
/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */

package org.jvnet.olt.parsers.MsgFileParser;

import junit.framework.*;
import java.io.StringReader;
import java.io.StringWriter;
import org.jvnet.olt.tmci.TokenCell;
import org.jvnet.olt.tmci.MessageTokenCell;
import java.util.Vector;
import java.util.Enumeration;

public class DisplayingNodeTest 
extends TestCase
implements MsgFileParserTreeConstants
{ 
  StringReader reader;
  String string;

  public DisplayingNodeTest(String name)
  {
    super(name);
  }

  public void setUp()
  {
    //  Put a sample .msg file in a string
    string = 
      /* START TEST FILE */
      "$quote \"\n" +
      "$set 1\n" +
      "5 \"<unknown>\"\n" +
      "6 \"...\"\n" +
      "$set 11\n" +
      "1 \"SKIP Kij algorithms (version 1):\\n\"\n" +
      "2 \"SKIP Kij algorithms:\\n\"\n" +
      "3 \"SKIP Crypt algorithms (version 1):\\n\"\n" +
      "4 \"SKIP Crypt algorithms:\\n\"\n" +
      "5 \"SKIP MAC algorithms:\\n\"\n" +
      "6 \"SKIP NSID list:\\n\"\n" +
      "7 \"Get IP Mask failed!\\n\"\n" +
      "8 \"\\t*** Error in key id\\n\"\n" +
      "9 \"*** : Invalid NSID/node id\\n\"\n" +
      "10 \"\\t*** Error in key id\\n\"\n" +
      "11 \"\\t*** Error in key id\\n\"\n" +
      "12 \"\\t*** Error in key id\\n\"\n" +
      "13 \"%1$s:\\t\\tbad version %2$d\\n\"\n" +
      "14 \"Get IP Mask failed!\\n\"\n" +
      "15 \"skiphost ifname=%1$s action=%2$s address=%3$s\"\n" +
      "16 \"exclude\"\n" +
      "17 \"�ɲ�\"\n" +
      "$quote \n" +
      "$set 12\n" +
      "18 \" mask=%s\"\n" +
      "19 \" tunnel=%s\"\n" +
      "20 \" version=1 kij_alg=%1$s kp_alg=%2$s \"\n" +
      "21 \"\\t*** Error in key id\\n\"\n" +
      "22 \"*** : Invalid NSID/node id\\n\"\n" +
      "23 \"\\t*** Error in key id\\n\"\n" +
      "24 \" version=%d \"\n" +
      "25 \"\\t*** Error in key id\\n\"\n" +
      "26 \"\\t*** Error in key id\\n\"\n" +
      "27 \"\\t*** Mulitline message to\\n\\\n" +
      "test the quoting code and the\\\n" +
      "multiline handling of the parser in general.\"\n";
    /* END TEST FILE */
    reader = new StringReader(string);
  }

  public void tearDown()
  {
    reader = null;
    string = "";
  }

  public void testDisplayRoundTrip()
  {
    MsgFileParser parser = new MsgFileParser(reader);
    StringWriter writer = new StringWriter();
    try
    {
      parser.parse();
      QuoteReplacingVisitor restoringVisitor = 
	new QuoteReplacingVisitor();
      parser.walkParseTree(restoringVisitor, "");
     
      DisplayingNodePrintingVisitor printingVisitor = 
	new DisplayingNodePrintingVisitor(writer);
      parser.walkParseTree(printingVisitor, "");
    }
    catch(Exception ex)
    {
      fail("Parse of the test file failed!" + ex);
    }

    assertEquals("Round trip handling of the message file failed!",
		 string, writer.getBuffer().toString() );
  }


  public void testTokenCellRoundTrip()
  {
    MsgFileParser parser = new MsgFileParser(reader);
    StringWriter writer = new StringWriter();
    try
    {
      //  Parse the test file
      parser.parse();
    
      //  Build TokenCell array
      DisplayingTokenArrayFactoryVisitor displayingVisitor 
	= new DisplayingTokenArrayFactoryVisitor();
      parser.walkParseTree(displayingVisitor, "");
      
      //  Print TokenCell array to test string
      TokenCell[] cellArray = displayingVisitor.getDisplayingTokens();
      for(int i = 0; i < cellArray.length; i++ )
      {
	if(cellArray[i].getType() != TokenCell.MARKER)
	{
	  writer.write(cellArray[i].getText());
	}
      }
    }
    catch(Exception ex)
    {
      fail("Parse of the test file failed!" + ex);
    }

    if(!string.equals(writer.getBuffer().toString()))
    {
      System.out.print("\nExpected:\n" + string );
      System.out.print("\nActual:\n" + writer.getBuffer().toString() );
    }


    assertEquals("Round trip handling of the message file, using the TokenCell array, failed!",
		 string, writer.getBuffer().toString() );
    
  }
}