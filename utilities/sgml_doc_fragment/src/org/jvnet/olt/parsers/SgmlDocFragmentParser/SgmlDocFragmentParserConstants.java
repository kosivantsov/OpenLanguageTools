
/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */

/* Generated By:JJTree&JavaCC: Do not edit this line. SgmlDocFragmentParserConstants.java */
package org.jvnet.olt.parsers.SgmlDocFragmentParser;

public interface SgmlDocFragmentParserConstants {

  int EOF = 0;
  int SUBSET_COMMENT = 2;
  int COMMENT = 4;
  int PI = 6;
  int DOCTYPE = 7;
  int INTERNAL_SUBSET_START = 8;
  int INTERNAL_SUBSET_WS = 9;
  int INTERNAL_SUBSET_END = 10;
  int WEIRD_ENT = 13;
  int ENT_STRING_LIT = 14;
  int ENTITY_DECL = 15;
  int NOT_STRING_LIT = 17;
  int NOTATION_DECL = 18;
  int DOCTYPE_CLOSE = 20;
  int DOCTYPE_TEXT = 21;
  int CDATA = 23;
  int ENTITY = 25;
  int SMARKSECT = 26;
  int EMARKSECT = 27;
  int STAGO = 28;
  int ETAGO = 29;
  int OSQRB = 30;
  int CSQRB = 31;
  int GT = 32;
  int PCDATA = 33;
  int WHITESPACE = 34;
  int AMP = 35;
  int PCT = 36;
  int ALPHA = 37;
  int NUM = 38;
  int ALPHANUM = 39;
  int TAGNAME = 40;
  int TAGC = 41;
  int WS = 42;
  int STRING_LIT = 43;
  int ATTRIBS = 44;

  int IN_INTERNAL_SUBSET = 0;
  int IN_SUBSET_COMMENT = 1;
  int DEFAULT = 2;
  int IN_COMMENT = 3;
  int IN_PI = 4;
  int DOCTYPEDECL = 5;
  int IN_ENTITY_DECL = 6;
  int IN_NOTATION_DECL = 7;
  int IN_CDATA = 8;
  int TAG = 9;
  int ATTLIST = 10;

  String[] tokenImage = {
    "<EOF>",
    "\"<!--\"",
    "\"-->\"",
    "\"<!--\"",
    "<COMMENT>",
    "\"<?\"",
    "\">\"",
    "<DOCTYPE>",
    "\"[\"",
    "<INTERNAL_SUBSET_WS>",
    "\"]\"",
    "\"<!NOTATION\"",
    "\"<!ENTITY\"",
    "<WEIRD_ENT>",
    "<ENT_STRING_LIT>",
    "\">\"",
    "<token of kind 16>",
    "<NOT_STRING_LIT>",
    "\">\"",
    "<token of kind 19>",
    "\">\"",
    "<DOCTYPE_TEXT>",
    "\"<![CDATA[\"",
    "\"]]>\"",
    "<token of kind 24>",
    "<ENTITY>",
    "\"<![\"",
    "\"]]>\"",
    "\"<\"",
    "\"</\"",
    "\"[\"",
    "\"]\"",
    "\">\"",
    "<PCDATA>",
    "<WHITESPACE>",
    "\"&\"",
    "\"%\"",
    "<ALPHA>",
    "<NUM>",
    "<ALPHANUM>",
    "<TAGNAME>",
    "\">\"",
    "<WS>",
    "<STRING_LIT>",
    "<ATTRIBS>",
  };

}
