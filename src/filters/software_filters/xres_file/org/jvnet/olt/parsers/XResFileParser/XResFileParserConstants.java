
/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */

/* Generated By:JJTree&JavaCC: Do not edit this line. XResFileParserConstants.java */
package org.jvnet.olt.parsers.XResFileParser;

public interface XResFileParserConstants {

  int EOF = 0;
  int PING = 1;
  int HASH = 2;
  int NEWLINE = 3;
  int EQUALS = 4;
  int SLASHNEWLINE = 5;
  int SLASH = 6;
  int WS = 7;
  int WORD = 8;

  int DEFAULT = 0;

  String[] tokenImage = {
    "<EOF>",
    "\"!\"",
    "\"#include\"",
    "<NEWLINE>",
    "\":\"",
    "\"\\\\\\n\"",
    "\"\\\\\"",
    "<WS>",
    "<WORD>",
  };

}
