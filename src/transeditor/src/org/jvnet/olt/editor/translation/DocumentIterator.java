/*
 * DocumentIterator.java
 *
 * Created on November 15, 2006, 12:28 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.jvnet.olt.editor.translation;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;
import org.jvnet.olt.editor.model.PivotBaseElement;
import org.jvnet.olt.editor.model.PivotTag;
import org.jvnet.olt.editor.model.PivotText;
import org.jvnet.olt.editor.model.TMData;

/**
 *
 * @author boris
 */
public class DocumentIterator {
    
    private int curSent = 0;
    private int curWord = 0;
    private TMData tmdata = null;
    
    boolean inSentence = false;
    
    boolean finished = false;
    
    List<WordHolder> words = new ArrayList<WordHolder>();
    
    class WordHolder {
        String word;
        int position;
        
        WordHolder(String word,int position){
            this.word = word;
            this.position = position;
        }
    }
    
    /** Creates a new instance of DocumentIterator */
    public DocumentIterator(TMData tmdata) {
        if(tmdata == null)
            throw new NullPointerException();
        this.tmdata = tmdata;
        
        this.curSent = 0;
        this.words = buildWordList(curSent);
        
    }
    
    public boolean hasNext(){
        if(tmdata.tmsentences == null || tmdata.tmsentences.length == 0){
            finished = true;
            return false;
        }
        
        int cw = curWord;
        int cs = curSent;
        
        List ws = words;
        
        if( cw  >= ws.size() ){
            do{
                if (++cs >= tmdata.tmsentences.length){
                    finished = true;
                    return false;                    
                }
                
                ws = buildWordList(cs);
            }
            while(ws.size() == 0);
            
        }
        
        return true;
    }
    public String next(){
        if(finished)
            throw new IllegalStateException("iteration already at the end");
        
        if(curWord >= words.size()){
            do{
                if(curSent >= tmdata.tmsentences.length)
                    throw new IllegalStateException("scrolled over data end");
                words = buildWordList(++curSent);
            }
            while(words.size() == 0);
            
            curWord = 0;
        }

        return words.get(curWord++ ).word;
    }
        
    private List buildWordList(int segmentNo){
        PivotText p = new PivotText((tmdata).tmsentences[segmentNo].getTranslation());
        
        List rv = new ArrayList();
        
        PivotBaseElement[] elements = p.elements();
        
        int xoffset = 0;
        for(PivotBaseElement e : elements){
            e.setPositionSite(xoffset);
            xoffset += e.getVisibleLength();
        }
        
        for (int j = 0; j < elements.length; j++) {
            PivotBaseElement element = elements[j];
            if (!element.getFlag()) {
                if ((j != 0) && (j != (elements.length - 1)) && PivotTag.betweenIntegratedTag(j, elements)) {
                    continue;
                }
                
                String source = element.getContent();
                
                for (int k = 0; k < source.length(); k++) {
                    char c = source.charAt(k);
                    
                    if (!Character.isLetter(c)) {
                        if (PivotTextPane.delim.indexOf(String.valueOf(c)) == -1) {
                            PivotTextPane.delim = PivotTextPane.delim + c;
                        }
                    }
                }
                
                String delim = PivotTextPane.delim;
                StringTokenizer tokens = new StringTokenizer(source, delim, true);
                int offset = element.getPositionSite();
                int curP = 0;
                
                while (tokens.hasMoreElements()) {
                    String word = (String)tokens.nextElement();
                    
                    //one letter and ingnorable
                    if ((word.length() == 1) && (delim.indexOf(word) != -1)) {
                        offset++;
                        continue;
                    }
                    
                    
                    //number => ignorable
                    try {
                        int ttt = Integer.parseInt(word);
                        offset += word.length();
                        
                        continue;
                    } catch (NumberFormatException ex) {
                    }
                    
                    //ignorable from ignore list
                    if (PivotTextPane.getWordFromIgnoreTable(word) != null) {
                        offset += word.length();
                        
                        continue;
                    }
                    
                    rv.add(new WordHolder(word,offset));
                    offset += word.length();
                }//end of if
            }
            
        }
        
        return rv;
    }
    

    public int currentSegment(){
        return curSent;
    }
    
    public int getOffsetInSegment(){
        if(finished)
            throw new IllegalStateException("iteration has finished");
        
        return words.get(curWord-1).position;        
    }
    
    public void replaceCurrentWord(String newWord){
        if(finished)
            throw new IllegalStateException("iteration has finished");

        if(curWord -1 < 0)            
            throw new IllegalStateException("call 'next()' first");
        
        WordHolder h = words.get(curWord-1);

        String tr = tmdata.tmsentences[curSent].getTranslation();
        StringBuilder sb = new StringBuilder(tr);
        sb.replace(h.position,h.position+h.word.length(),newWord);

        tmdata.tmsentences[curSent].setTranslation(sb.toString());
        
        
        int diff = newWord.length() - h.word.length();
        
        if(diff == 0 || curWord >= words.size())
            return;
            
        ListIterator<WordHolder> i = words.listIterator(curWord);
        while(i.hasNext()){
            WordHolder hh = i.next();
            hh.position += diff;
        }

    }
    
    public void seekToSegment(int segNo){
        if(segNo < 0 || segNo > tmdata.tmsentences.length)
            throw new IllegalArgumentException("segno out of range");
        
        curSent = segNo;
        curWord = 0;
        words = buildWordList(curSent);
        finished = false;
    }
}