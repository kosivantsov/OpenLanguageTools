
/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */

/*
 * SegmenterInterface.java
 *
 * Created on March 14, 2003, 10:31 AM
 */


package org.jvnet.olt.filters.segmenter_facade;

/** It's assumend this interface will be implemented using a constructor
 *  that provides some means of specifying which language the input text
 *  is in (so we can choose the right abbreviations, etc.)
 */
public interface SegmenterInterface {
    
    
    /**
     * This method parses the input reader based on the language specified. It
     * also runs that parser's SegmentCollectionFactoryVisitor, and populates
     * the local segmentList and formattingMap.
     */
    public void parse() throws java.lang.Exception;         
     
    
    /**
     * This method parses the input reader based on the language specified. It
     * also runs that parser's SegmentCollectionFactoryVisitor, and populates
     * the local segmentList and formattingMap.
     */
    public void parseForStats() throws java.lang.Exception;
    
    /**
     * Gets a list of segments produced by this segmenter
     */
    public java.util.List getSegments();
    
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
    public java.util.Map getFormatting();
    
    /**
     * This returns a list of numbers that were found in this segment
     * which can be used by our alignment program
     *
     * @returns a list of the numbers found in this segment
     */
    public java.util.List getNumberList();
    
    /**
     * This returns a list of all the individual words found in this
     * segment (may include repetitions) - this list can be used by
     * the alignment program, and the number of elements in the List
     * is the wordcount.
     */
    public java.util.List getWordList();    
    
}
