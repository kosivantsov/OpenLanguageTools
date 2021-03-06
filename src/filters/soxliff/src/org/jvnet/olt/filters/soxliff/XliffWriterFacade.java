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
 * XliffWriterFacade.java
 *
 * Created on April 24, 2006, 10:16 AM
 *
 */

package org.jvnet.olt.filters.soxliff;

import org.jvnet.olt.filters.segmenters.formatters.XliffContextValue;
import java.io.*;
import java.util.*;
import org.jvnet.olt.filters.sgml.SgmlFilterHelper;
import org.jvnet.olt.utilities.*;
import org.jvnet.olt.filters.segmenters.formatters.*;
import org.jvnet.olt.format.xml.*;
import org.jvnet.olt.format.*;
import org.jvnet.olt.filters.soxliff.util.*;

/**
 * Facade that creates OLT xliff and writes translation units. Standard XliffSegmenterFormatter
 * is used.
 *
 * @author michal
 */
public class XliffWriterFacade {
    
    private String                        sourceLanguage = null;
    private File                           xlzFile = null;
    private XliffZipFileIO              xlzIO   = null;
    private FormatWrapper         wrapper = null;
    private SegmenterFormatter  formatter = null;
    
    private static final String XLIFF_TYPE = "STAROFFICE";
    
    /**
     * Do not allow to create an empty constructor
     */
    private XliffWriterFacade(File soXliff,String sourceLanguage) throws IOException,SegmenterFormatterException {
        xlzFile = new File(soXliff.getAbsolutePath()+".xlz");
        this.sourceLanguage = sourceLanguage;
        xlzIO = new XliffZipFileIO(xlzFile);
        try {
            wrapper = new FormatWrapperFactory().createFormatWrapper("STAROFFICE", new EntityManager());
        } catch(UnsupportedFormatException e) {
            throw new SegmenterFormatterException("Cannot create formatWrapper: " + e.getMessage());
        }
        formatter = new XliffSegmenterFormatter(XLIFF_TYPE,  sourceLanguage, soXliff.getName(), xlzIO.getXliffWriter(), xlzIO.getSklWriter(), wrapper);
    }
    
    /**
     * Create new OLT xliff file
     *
     * @param soXliff file that should be created
     * @param sourceLanguage of the xliff file
     *
     * @throws IOException
     * @throws SegmenterFormatterException
     */
    public static XliffWriterFacade createWriter(File soXliff,String sourceLanguage) throws IOException,SegmenterFormatterException {
        return new XliffWriterFacade(soXliff,sourceLanguage);
    }
    
    /**
     * Writes single segment to the xliff file
     *
     * @param segment that should be written
     *
     * @throws SegmenterFormatterException
     */
    public void writeSegment(SOSegment segment) throws SegmenterFormatterException {
        
        String source = segment.getSource();
        int wordCount = 0;
        try {
            wordCount = SgmlFilterHelper.wordCount(source,sourceLanguage);
        } catch(Throwable t) {
            System.err.println("Cannot get correct wordcount: " + t.getMessage());
        }
        String target  = segment.getTarget();
        
        // write context informations
        List contexts = segment.getContext();
        if(contexts.size()>0) {
            Iterator it = contexts.iterator();
            List contextToAdd = Collections.synchronizedList(new ArrayList());
            while(it.hasNext()) {
                String[] context = (String[])it.next();
                String type = context[0];
                String value = context[1];
                if(value==null) {
                    value = "";
                }
                
                XliffContextValue ctx = new XliffContextValue(type,value);
                contextToAdd.add(ctx);
            }
            ((XliffSegmenterFormatter)formatter).writeContext(contextToAdd);
        }
        
        if(target!=null && !"".equals(target)) {
            formatter.writeSegment(source,target,wordCount);
        } else {
            formatter.writeSegment(source,wordCount);
        }
        
    }
    
    /**
     * Flush content of the writer and close all resources
     *
     * @throws IOException
     * @throws SegmenterFormatterException
     */
    public void close() throws IOException,SegmenterFormatterException {
        formatter.flush();
        xlzIO.writeZipFile();
    }
    
}
