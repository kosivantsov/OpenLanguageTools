/*
 * Copyright  2005 Sun Microsystems, Inc.
 * All rights reserved Use is subject to license terms.
 *
 */
/*
 * SAXWriter2.java
 *
 * Created on April 26, 2005, 2:07 PM
 *
 */
package org.jvnet.olt.xliff.writer.handlers;

import java.io.IOException;

import org.jvnet.olt.editor.translation.Constants;
import org.jvnet.olt.xliff.ReaderException;
import org.jvnet.olt.xliff.XMLDumper;
import org.jvnet.olt.xliff.handlers.Element;


/**
 *
 * @author boris
 */
public class XLIFFHandler extends BaseHandler {
    public XLIFFHandler(Context ctx) {
        super(ctx);
    }

    public void dispatch(org.jvnet.olt.xliff.handlers.Element element, boolean start) throws ReaderException {
        Element e1 = element;

        if (start && "xliff".equals(element.getQName()) && ctx.getVersion().isXLIFF11()) {
            e1.addNamespaceDeclaration(null, Constants.XLIFF_1_1_URI);
            e1.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        }

        writeElement(element, start);
    }

    public void dispatchIgnorableChars(org.jvnet.olt.xliff.handlers.Element element, char[] chars, int start, int length) throws ReaderException {
        writeChars(chars, start, length);
    }

    public void dispatchChars(org.jvnet.olt.xliff.handlers.Element element, char[] chars, int start, int length) throws ReaderException {
        writeChars(chars, start, length);
    }

    public boolean handleSubElements() {
        return true;
    }
}