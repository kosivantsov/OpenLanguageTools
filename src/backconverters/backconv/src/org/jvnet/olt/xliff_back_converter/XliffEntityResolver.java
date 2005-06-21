
/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */

/*
 * XliffEntityResolver.java
 *
 * Created on August 14, 2002, 10:57 AM
 */
package org.jvnet.olt.xliff_back_converter;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.Reader;
import java.util.logging.*;

/**
 * Resolves the XLIFF DTD for entities.
 *
 * <p>This XliffEntityResolver ignores the public and url locations for 
 * the DTD as indicated in XLIFF files and instead gets and resolves the DTD
 * from a local directory.</p>
 *
 * @author    Brian Kidney
 * @version   August 14, 2002
 */
public class XliffEntityResolver implements EntityResolver {

    /* The Xliff DTD */
    private Reader xliffDTD = null;

    /* Logging object */
    private Logger logger = null;


    /**
     * Constructor for the XliffEntityResolver object
     *
     * @param theLogger  The logging object (For logging messages).
     * @param theXliffDTD   The Xliff DTD.
     */
    public XliffEntityResolver(Logger theLogger, Reader theXliffDTD) {

        this.logger = theLogger;
        this.xliffDTD = theXliffDTD;

    }


    /**
     * Allow the application to resolve external entities.
     *
     * The Parser will call this method before opening any external entity 
     * except the top-level document entity (including the external DTD 
     * subset, external entities referenced within the DTD, and external 
     * entities referenced within the document element).
     *
     * This method is used to open the entity from a local directory
     *
     * @param publicId          The public identifier of the external entity 
     *                          being referenced, or null if none was 
     *                          supplied.
     * @param systemId          The system identifier of the external entity 
     *                          being referenced.
     * @return                  An InputSource object describing the new 
     *                          input source, or null to request that the 
     *                          parser open a regular URI connection to the 
     *                          system identifier.
     * @exception SAXException  Any SAX exception, possibly wrapping another 
     *                          exception.Any SAX exception, possibly 
     *                          wrapping another exception.
     */
    public InputSource resolveEntity(String publicId, String systemId)
         throws SAXException {

        logger.log(Level.FINEST, "SystemId = " + systemId);

        File file = null;

        /* Open a file containing the DTD, so we can get its filename later     
         */
        try {
            file = new File(systemId);
        } catch (NullPointerException e) {
            logger.log(Level.WARNING,
                "Pathname of file to parse is null", e);
            throw new NullPointerException();
        }

        logger.log(Level.FINEST, "File.getName() is " + file.getName());
        if (file.getName().equals("xliff.dtd")) {
            logger.log(Level.FINEST, "Using XLIFFDTD");
            return new InputSource(xliffDTD);
        } else {
            logger.log(Level.FINEST, "Returning Null");
            return null;
        }

    }

}

