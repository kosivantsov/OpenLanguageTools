/* Generated By:JJTree&JavaCC: Do not edit this line. POFileParserConstants.java */
package org.jvnet.olt.parsers.POFileParser;

public interface POFileParserConstants {

  int EOF = 0;
  int LC_COMMENT = 2;
  int TMC_COMMENT = 5;
  int SINGLE_LINE_COMMENT = 8;
  int STRING_LITERAL = 10;
  int DOMAIN = 11;
  int MSGID = 12;
  int MSGSTR = 13;
  int MSGID_PLURAL = 14;
  int MSGSTRS = 15;
  int WS = 16;
  int NEWLINE = 17;

  int DEFAULT = 0;
  int IN_LC_COMMENT = 1;
  int IN_TMC_COMMENT = 2;
  int IN_SINGLE_LINE_COMMENT = 3;

  String[] tokenImage = {
    "<EOF>",
    "\"#@LC@\"",
    "<LC_COMMENT>",
    "<token of kind 3>",
    "\"#@TMC@\"",
    "<TMC_COMMENT>",
    "<token of kind 6>",
    "\"#\"",
    "<SINGLE_LINE_COMMENT>",
    "<token of kind 9>",
    "<STRING_LITERAL>",
    "\"domain\"",
    "\"msgid\"",
    "\"msgstr\"",
    "\"msgid_plural\"",
    "<MSGSTRS>",
    "<WS>",
    "<NEWLINE>",
  };

}
