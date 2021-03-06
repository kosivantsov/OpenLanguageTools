/*
* CDDL HEADER START
*
* The contents of this file are subject to the terms of the
* Common Development and Distribution License (the "License").
* You may not use this file except in compliance with the License.
*
* You can obtain a copy of the license at LICENSE.txt
* or http://www.opensource.org/licenses/cddl1.php.
* See the License for the specific language governing permissions
* and limitations under the License.
*
* When distributing Covered Code, include this CDDL HEADER in each
* file and include the License file at LICENSE.txt.
* If applicable, add the following below this CDDL HEADER, with the
* fields enclosed by brackets "[]" replaced with your own identifying
* information: Portions Copyright [yyyy] [name of copyright owner]
*
* CDDL HEADER END
*/

/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */

package org.jvnet.olt.filters.sgml;


import org.jvnet.olt.filters.segmenter_facade.*;
import org.jvnet.olt.filters.NonConformantSgmlDocFragmentParser.*;
import java.io.*;
import java.util.*;
/** This class is designed report information about the html for alignment purposes.
 * @author timf
 */
public class StatsVisitor implements NonConformantSgmlDocFragmentParserVisitor,NonConformantSgmlDocFragmentParserTreeConstants {
    
    private List tags;
    private List words;
    private List nums;
    private String language;
    
    private static final int BUFFSIZE = 10;
    
    /** Creates a new instance of HtmlStatsVisitor
     * @param table The TagTable that this class uses.
     */
    public StatsVisitor(String language) {
        tags = new ArrayList();
        words = new ArrayList();
        nums = new ArrayList();
        this.language = language;
    }
    
    /** This method does the main work of getting stats on the html input.
     *
     * @param simpleNode The simpleNode that is being visited
     * @param obj An object
     * @return An object
     */
    public Object visit(SimpleNode simpleNode, Object obj) {
        try {
            switch (simpleNode.getType()){
                case JJTOPEN_TAG:
                case JJTCLOSE_TAG:
                    // add these to the tags
                    tags.add(simpleNode.getNodeData());
                    break;
                case JJTPCDATA:
                    // count words and numbers and things
                    StringReader reader = new StringReader(simpleNode.getNodeData());
                    SegmenterFacade segmenterFacade = new SegmenterFacade(reader, language);
                    
                    try {
                        segmenterFacade.parseForStats();
                    } catch (java.lang.Exception e){ // need to handle this better.
                        throw new Exception ("Caught an exception getting sentence statistics :" + e.getMessage());
                    }
                    words.addAll(segmenterFacade.getWordList());
                    nums.addAll(segmenterFacade.getNumberList());
            }
            
        }catch (java.lang.Exception e){
            e.printStackTrace();
            System.exit(1);// erk - fixme
        }
        return obj;
    }
    
    public List getTags(){
        return tags;
    }
    
    public List getNumbers(){
        return nums;
    }
    
    public List getWords(){
        return words;
    }
    
}

