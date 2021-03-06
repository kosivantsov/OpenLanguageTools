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

/*
 * MessageFormatWrappingVisitor.java
 *
 * Created on October 23, 2003, 8:54 pm
 */

package org.jvnet.olt.format.messageformat;

import java.io.StringWriter;
import java.io.IOException;
import java.io.StringReader;
import org.jvnet.olt.io.*;
import org.jvnet.olt.format.GlobalVariableManager;
import org.jvnet.olt.format.GlobalVariableManagerException;

import org.jvnet.olt.parsers.MessageFormatParser.*;

/**
 * This class is a visitor that's used by MessageFormatWrapper - see that class for
 * more information. This format wrapper writes either XLIFF or TMX formatting
 * - it really only uses one tag, the <it> tag to do this, but XLIFF
 * and TMX are very slightly different in the way they handle these, so
 * it makes sense to use the same code.
 *
 * @see MessageFormatWrapper
 * @author  timf
 */
public class MessageFormatWrappingVisitor implements MessageFormatParserVisitor, MessageFormatParserTreeConstants {
    private StringBuffer buffer;
    private int     m_itCount;
    private boolean isTMX = false;

    /** Creates a new instance of MessageFormatWrappingVisitor */
    public MessageFormatWrappingVisitor() {
        
        buffer = new StringBuffer();
        m_itCount = 1;
    }
    
    public void setUseTMXBehaviour(boolean isTMX){
        this.isTMX = isTMX;
    }
    
    public String getWrappedString() {
        return buffer.toString();
    }
    
    public Object visit(SimpleNode node, Object data) {
        processFormatting(node);
        return data;
    }
    
    protected void processFormatting(SimpleNode node) {
        int type = node.getType();
        String nodeText = node.getNodeData();
        switch(type) {
            case JJTCONV:
                writeIndividualFormat(nodeText);
                break;
            default:
                buffer.append(escapeSgmlTokens(nodeText));
                break;
        }
    }
    
    protected void writeIndividualFormat(String format) {
        if (isTMX){
            buffer.append("<it pos=\"begin\">");
        } else {
            buffer.append("<it id=\"" + (m_itCount++) + "\" pos=\"open\">");
        }
        buffer.append(escapeSgmlTokens(format));
        buffer.append("</it>");
    }
    
    protected String escapeSgmlTokens(String string) {
        String returnVal="";
        try {
            StringReader stringReader = new StringReader(string);
            EntityConversionFilterReader reader = new EntityConversionFilterReader(stringReader);
            reader.setEntityMap(ASCIIControlCodeMapFactory.getAsciiControlCodesMap());
            StringWriter writer = new StringWriter();
            
            int ch;
            while((ch=reader.read()) != -1) {
                writer.write(ch);
            }
            returnVal = writer.toString();
        }
        catch(IOException exIO) {
            return returnVal;
        }
        return returnVal;
    }
}
