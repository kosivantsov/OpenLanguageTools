
/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */

/* Generated By:JJTree&JavaCC: Do not edit this line. PrintfParserConstants.java */
package org.jvnet.olt.parsers.PrintfParser;

public interface PrintfParserConstants {

  int EOF = 0;
  int NOCONV = 1;
  int NULLCONV = 2;
  int MSGCONV = 3;
  int REGEXPCONV = 4;
  int CONV = 5;
  int VARCONV = 6;
  int SPACE = 7;
  int EMPTY = 8;
  int SLASH = 9;
  int APOS = 10;
  int BACKTICK = 11;
  int BACKSLASH = 12;
  int TWOBACKSLASH = 13;
  int ALERT = 14;
  int BACKSPACE = 15;
  int FORMFEED = 16;
  int NEWLINE = 17;
  int OCTAL = 18;
  int CARRIAGERETURN = 19;
  int TAB = 20;
  int VERTTAB = 21;
  int NORMAL = 22;
  int WORDS = 23;

  int DEFAULT = 0;
  int SLASHMODE = 1;

  String[] tokenImage = {
    "<EOF>",
    "\"% \"",
    "\"%%\"",
    "<MSGCONV>",
    "<REGEXPCONV>",
    "<CONV>",
    "<VARCONV>",
    "\"/\\\\\"",
    "<EMPTY>",
    "\"/\"",
    "\"\\\'\"",
    "\"`\"",
    "\"\\\\\"",
    "\"\\\\\"",
    "\"a\"",
    "\"b\"",
    "\"f\"",
    "\"n\"",
    "<OCTAL>",
    "\"r\"",
    "\"t\"",
    "\"v\"",
    "<NORMAL>",
    "<WORDS>",
  };

}