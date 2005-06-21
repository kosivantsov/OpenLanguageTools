
/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */

/*
 * SegmenterFacade.java
 *
 * Created on June 25, 2002, 1:36 PM
 */

package org.jvnet.olt.filters.segmenter_facade;

import java.util.*;
import org.jvnet.olt.filters.en_segmenter.*;
import org.jvnet.olt.filters.de_segmenter.*;
import org.jvnet.olt.filters.es_segmenter.*;
import org.jvnet.olt.filters.fr_segmenter.*;
import org.jvnet.olt.filters.it_segmenter.*;
import org.jvnet.olt.filters.sv_segmenter.*;

/**
 * SegmenterFacade is designed to take the pain away from dealing with different
 * segmenters. Provide it a language name, and an input and it will parse the
 * inputstream and you can use it to get the SegmentCollection from the underlying
 * parser.<br><br>
 *
 * @author  timf
 */
public class SegmenterFacade implements SegmenterInterface {
    
    private List segments;
    private List numbers;
    private List words;
    
    private Map formattingMap;
    private Map languageMap;
    
    
    private String language="";
    private java.io.Reader reader;
    private static final int EN = 0;
    private static final int DE = 1;
    private static final int ES = 2;
    private static final int FR = 3;
    private static final int IT = 4;
    private static final int SV = 5;
    
    /** Creates a new instance of SegmenterFacade */
    public SegmenterFacade(java.io.Reader reader, java.lang.String language) {
        
        segments = new ArrayList();
        formattingMap = new HashMap();
        
        numbers = new ArrayList();
        words = new ArrayList();
        
        // only adding the languages we support
        languageMap = new HashMap();
        languageMap.put("en",new Integer(EN));
        languageMap.put("en-AU",new Integer(EN));
        languageMap.put("en-CA",new Integer(EN));
        languageMap.put("en-GB",new Integer(EN));
        languageMap.put("en-HK",new Integer(EN));
        languageMap.put("en-IE",new Integer(EN));
        languageMap.put("en-IN",new Integer(EN));
        languageMap.put("en-LR",new Integer(EN));
        languageMap.put("en-NZ",new Integer(EN));
        languageMap.put("en-PH",new Integer(EN));
        languageMap.put("en-SG",new Integer(EN));
        languageMap.put("en-US",new Integer(EN));
        languageMap.put("en-ZA",new Integer(EN));
        languageMap.put("de",new Integer(DE));
        languageMap.put("de-AT",new Integer(DE));
        languageMap.put("de-BE",new Integer(DE));
        languageMap.put("de-CH",new Integer(DE));
        languageMap.put("de-DE",new Integer(DE));
        languageMap.put("es",new Integer(ES));
        languageMap.put("es-AR",new Integer(ES));
        languageMap.put("es-CL",new Integer(ES));
        languageMap.put("es-CO",new Integer(ES));
        languageMap.put("es-ES",new Integer(ES));
        languageMap.put("es-MX",new Integer(ES));
        languageMap.put("es-PE",new Integer(ES));
        languageMap.put("es-VE",new Integer(ES));
        languageMap.put("fr",new Integer(FR));
        languageMap.put("fr",new Integer(FR));
        languageMap.put("fr-BE",new Integer(FR));
        languageMap.put("fr-CA",new Integer(FR));
        languageMap.put("fr-CH",new Integer(FR));
        languageMap.put("fr-FR",new Integer(FR));
        languageMap.put("it",new Integer(IT));
        languageMap.put("it-IT",new Integer(IT));        
        languageMap.put("sv",new Integer(SV));
        languageMap.put("sv-FI",new Integer(SV));
        languageMap.put("sv-SE",new Integer(SV));
        
        this.reader=reader;
        this.language=language;
    }
    
    /**
     * This method parses the input reader based on the language specified. It
     * also runs that parser's SegmentCollectionFactoryVisitor, and populates
     * the local segmentList and formattingMap.
     */
    public void parse() throws java.lang.Exception {
        Integer availableLanguage = (Integer)languageMap.get(this.language.toLowerCase());
        if (availableLanguage == null){
            availableLanguage = new Integer(EN);
        }
        
        
        switch (availableLanguage.intValue()){
            case DE:
                Segmenter_de parser_de = new  Segmenter_de(reader);
                parser_de.parse();
                org.jvnet.olt.filters.de_segmenter.SegmentCollectionFactoryVisitor segmentVisit_de =
                new org.jvnet.olt.filters.de_segmenter.SegmentCollectionFactoryVisitor();
                parser_de.walkParseTree(segmentVisit_de, null);
                segments = segmentVisit_de.getCollection();
                formattingMap = segmentVisit_de.getFormatting();
                break;
            case ES:
                Segmenter_es parser_es = new  Segmenter_es(reader);
                parser_es.parse();
                org.jvnet.olt.filters.es_segmenter.SegmentCollectionFactoryVisitor segmentVisit_es =
                new org.jvnet.olt.filters.es_segmenter.SegmentCollectionFactoryVisitor();
                parser_es.walkParseTree(segmentVisit_es, null);
                segments = segmentVisit_es.getCollection();
                formattingMap = segmentVisit_es.getFormatting();
                break;
            case FR:
                Segmenter_fr parser_fr = new  Segmenter_fr(reader);
                parser_fr.parse();
                org.jvnet.olt.filters.fr_segmenter.SegmentCollectionFactoryVisitor segmentVisit_fr =
                new org.jvnet.olt.filters.fr_segmenter.SegmentCollectionFactoryVisitor();
                parser_fr.walkParseTree(segmentVisit_fr, null);
                segments = segmentVisit_fr.getCollection();
                formattingMap = segmentVisit_fr.getFormatting();
                break;
            case IT:
                Segmenter_it parser_it = new  Segmenter_it(reader);
                parser_it.parse();
                org.jvnet.olt.filters.it_segmenter.SegmentCollectionFactoryVisitor segmentVisit_it =
                new org.jvnet.olt.filters.it_segmenter.SegmentCollectionFactoryVisitor();
                parser_it.walkParseTree(segmentVisit_it, null);
                segments = segmentVisit_it.getCollection();
                formattingMap = segmentVisit_it.getFormatting();
                break;
            case SV:
                Segmenter_sv parser_sv = new Segmenter_sv(reader);
                parser_sv.parse();
                org.jvnet.olt.filters.sv_segmenter.SegmentCollectionFactoryVisitor segmentVisit_sv =
                new org.jvnet.olt.filters.sv_segmenter.SegmentCollectionFactoryVisitor();
                parser_sv.walkParseTree(segmentVisit_sv, null);
                segments = segmentVisit_sv.getCollection();
                formattingMap = segmentVisit_sv.getFormatting();
                break;
            case EN:
            default:
                Segmenter_en parser_en = new  Segmenter_en(reader);
                parser_en.parse();
                org.jvnet.olt.filters.en_segmenter.SegmentCollectionFactoryVisitor segmentVisit_en =
                new org.jvnet.olt.filters.en_segmenter.SegmentCollectionFactoryVisitor();
                parser_en.walkParseTree(segmentVisit_en, null);
                segments = segmentVisit_en.getCollection();
                formattingMap = segmentVisit_en.getFormatting();
        }
        
        
        
        
        
    }
    
    /**
     * This method parses the input reader based on the language specified. It
     * also runs that parser's SegmentCollectionFactoryVisitor, and populates
     * the local segmentList and formattingMap.
     */
    public void parseForStats() throws java.lang.Exception {
        Integer availableLanguage = (Integer)languageMap.get(this.language.toLowerCase());
        if (availableLanguage == null){
            availableLanguage = new Integer(EN);
        }
        
        
        switch (availableLanguage.intValue()){
            case DE:
                Segmenter_de parser_de = new  Segmenter_de(reader);
                parser_de.parse();
                org.jvnet.olt.filters.de_segmenter.SegmentStatsVisitor segmentVisit_de =
                new org.jvnet.olt.filters.de_segmenter.SegmentStatsVisitor();
                parser_de.walkParseTree(segmentVisit_de, null);
                words = segmentVisit_de.getWordList();
                numbers = segmentVisit_de.getNumberList();
                break;
            case ES:
                Segmenter_es parser_es = new  Segmenter_es(reader);
                parser_es.parse();
                org.jvnet.olt.filters.es_segmenter.SegmentStatsVisitor segmentVisit_es =
                new org.jvnet.olt.filters.es_segmenter.SegmentStatsVisitor();
                parser_es.walkParseTree(segmentVisit_es, null);
                words = segmentVisit_es.getWordList();
                numbers = segmentVisit_es.getNumberList();
                break;
            case FR:
                Segmenter_fr parser_fr = new  Segmenter_fr(reader);
                parser_fr.parse();
                org.jvnet.olt.filters.fr_segmenter.SegmentStatsVisitor segmentVisit_fr =
                new org.jvnet.olt.filters.fr_segmenter.SegmentStatsVisitor();
                parser_fr.walkParseTree(segmentVisit_fr, null);
                words = segmentVisit_fr.getWordList();
                numbers = segmentVisit_fr.getNumberList();
                break;
            case IT:
                Segmenter_it parser_it = new  Segmenter_it(reader);
                parser_it.parse();
                org.jvnet.olt.filters.it_segmenter.SegmentStatsVisitor segmentVisit_it =
                new org.jvnet.olt.filters.it_segmenter.SegmentStatsVisitor();
                parser_it.walkParseTree(segmentVisit_it, null);
                words = segmentVisit_it.getWordList();
                numbers = segmentVisit_it.getNumberList();
                break;
            case SV:
                Segmenter_sv parser_sv = new Segmenter_sv(reader);
                parser_sv.parse();
                org.jvnet.olt.filters.sv_segmenter.SegmentStatsVisitor segmentVisit_sv =
                new org.jvnet.olt.filters.sv_segmenter.SegmentStatsVisitor();
                parser_sv.walkParseTree(segmentVisit_sv, null);
                words = segmentVisit_sv.getWordList();
                numbers = segmentVisit_sv.getNumberList();
                break;
            case EN:
            default:
                Segmenter_en parser_en = new  Segmenter_en(reader);
                parser_en.parse();
                org.jvnet.olt.filters.en_segmenter.SegmentStatsVisitor segmentVisit_en =
                new org.jvnet.olt.filters.en_segmenter.SegmentStatsVisitor();
                parser_en.walkParseTree(segmentVisit_en, null);
                words = segmentVisit_en.getWordList();
                numbers = segmentVisit_en.getNumberList();
        }
        
        
        
        
        
    }
    
    /**
     * Gets a list of segments produced by this segmenter
     */
    public java.util.List getSegments() {
        return this.segments;
    }
    
    /**
     * This gives us a Map of the formatting found by this segmenter :
     * that is, usually spaces after segments, \n after segments - that
     * sort of thing. These are formatting elements that are not part
     * of the segment itself.
     *
     * For example, for the text:
     *
     * "This is a sentence. So is this."
     *
     * We would have two segments and one formatting element. The map
     * uses the segment number preceeding each piece of formatting as
     * it's key.
     *
     * For the above example, our Map would have one entry :
     *  key  value
     *  1 =  " "
     * 
     */     
    public java.util.Map getFormatting() {
        return this.formattingMap;
    }
    
    /**
     * This returns a list of numbers that were found in this segment
     * which can be used by our alignment program
     *
     * @returns a list of the numbers found in this segment
     */
    public java.util.List getNumberList(){
        return this.numbers;
    }
    
    /**
     * This returns a list of all the individual words found in this
     * segment (may include repetitions) - this list can be used by
     * the alignment program, and the number of elements in the List
     * is the wordcount.
     */
    public java.util.List getWordList(){
        return this.words;
    }
    
    
}
