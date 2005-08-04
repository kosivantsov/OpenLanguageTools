
/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */

/*
 * XliffParserTest.java
 *
 * Created on August 8, 2002, 1:49 PM
 */
package org.jvnet.olt.xliff_back_converter;

import org.xml.sax.InputSource;
import java.util.logging.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileReader;


/**
 * This is a Test suite class with a main method for running and testing the
 * <code>XliffParser</code>.
 *
 * @author Brian Kidney
 * @version August 8, 2002
 */
public class XliffParserTest {

    /* The Logger to be used */
    private static Logger logger =
        Logger.getLogger("org.jvnet.olt.xliff_back_converter");


    /**
     * Creates a new instance of XliffParserTest
     */
    public XliffParserTest() { }


    /**
     * @param argv The command line arguments
     */
    public static void main(String[] argv) {

        /* The XLIFF (.xlf) file to be back converted is the first argument.
         * The location of the confing properties is the second argument.
         */
        if (argv.length != 2) {
            System.out.println(
                "Usage: <file.xlz> <.properties>");
            logger.warning("Incorrect parameters entered");
            System.exit(1);
        }

        /* Properties required by the Back Converter */
        Properties properties = new Properties();

        /* Stores the properties required by the Back Converter */
        BackConverterProperties props = new BackConverterProperties();

        /* Try and load the properties from the .properties file */
        try {
            properties.load(new FileInputStream(argv[1]));

            FileReader xliffDTD = new FileReader(properties.getProperty(
                BackConverterProperties.XLIFF_DTD, ""));
            FileReader skeletonDTD = new FileReader(properties.getProperty(
                BackConverterProperties.XLIFF_SKELETON_DTD, ""));

        } catch (java.io.IOException e) {
            logger.log(Level.SEVERE, "Unable to load properties", e);
        }

        /* Create the XliffHandler and XliffParser and send the XLIFF file
         * to the parser.
         */
        try {
            properties.load(new FileInputStream(argv[1]));

            FileReader xliffDTD = new FileReader(properties.getProperty(
                BackConverterProperties.XLIFF_DTD, ""));
            FileReader skeletonDTD = new FileReader(properties.getProperty(
                BackConverterProperties.XLIFF_SKELETON_DTD, ""));

            XliffBackConverter backConverter =
                new XliffBackConverter(xliffDTD, skeletonDTD, logger);

            File file = new File(argv[0]);
            String outputDir = properties.getProperty(
                BackConverterProperties.OUTPUT_DIR, "");
            boolean getSource = false;
            String charset = "ISO8859_1";
            //String charset = null;
            System.out.println("num trans-unit = " +
                backConverter.getNumOfTransUnits());
            System.out.println("num of target = " +
                backConverter.getNumOfTargetUnits());
            System.out.println("isFinished() = " +
                backConverter.isFinished());
            backConverter.backConvert(file, outputDir, getSource, charset);
            System.out.println("num trans-unit = " +
                backConverter.getNumOfTransUnits());
            System.out.println("num of target = " +
                backConverter.getNumOfTargetUnits());
            System.out.println("isFinished() = " +
                backConverter.isFinished());

        } catch (java.io.IOException ex) {
            logger.log(Level.SEVERE, "IOException", ex);
        } catch (org.jvnet.olt.xliff_back_converter.XliffBackConverterException ex) {
            logger.log(Level.SEVERE, "XliffBackConverterException", ex);
        }
    }

}
