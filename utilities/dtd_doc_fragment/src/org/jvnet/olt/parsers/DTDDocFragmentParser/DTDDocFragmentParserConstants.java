
/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */

/* Generated By:JJTree&JavaCC: Do not edit this line. DTDDocFragmentParserConstants.java */
package org.jvnet.olt.parsers.DTDDocFragmentParser;

public interface DTDDocFragmentParserConstants {

  int EOF = 0;
  int COMMENT = 2;
  int WS = 3;
  int ENTITY_DECL = 4;
  int WEIRD_ENT = 8;
  int ENTITY_DECL_NAME = 9;
  int ENT_WS = 10;
  int ENT_STRING_LIT = 11;
  int CLOSE_ENTITY_DECL = 12;
  int NOT_STRING_LIT = 13;
  int NOTATION_DECL = 14;
  int ELEMENT_STRING_LIT = 16;
  int ELEMENT_DECL = 17;
  int ATTLIST_STRING_LIT = 19;
  int ATTLIST_DECL = 20;
  int CDATA = 23;
  int ENTITYREF = 25;
  int PARAMETERENTITYREF = 26;
  int SMARKSECT = 27;
  int EMARKSECT = 28;
  int OSQRB = 29;
  int CSQRB = 30;
  int GT = 31;
  int PCDATA = 32;
  int WHITESPACE = 33;
  int AMP = 34;
  int PCT = 35;
  int ALPHA = 36;
  int NUM = 37;
  int ALPHANUM = 38;
  int TAGNAME = 39;
  int STRING_LIT = 40;
  int ATTRIBS = 41;

  int DEFAULT = 0;
  int IN_COMMENT = 1;
  int IN_ENTITY_DECL = 2;
  int IN_NOTATION_DECL = 3;
  int IN_ELEMENT_DECL = 4;
  int IN_ATTLIST_DECL = 5;
  int IN_CDATA = 6;
  int TAG = 7;
  int ATTLIST = 8;

  String[] tokenImage = {
    "<EOF>",
    "\"<!--\"",
    "\"-->\"",
    "<WS>",
    "\"<!ENTITY\"",
    "\"<!NOTATION\"",
    "\"<!ELEMENT\"",
    "\"<!ATTLIST\"",
    "<WEIRD_ENT>",
    "<ENTITY_DECL_NAME>",
    "<ENT_WS>",
    "<ENT_STRING_LIT>",
    "\">\"",
    "<NOT_STRING_LIT>",
    "\">\"",
    "<token of kind 15>",
    "<ELEMENT_STRING_LIT>",
    "\">\"",
    "<token of kind 18>",
    "<ATTLIST_STRING_LIT>",
    "\">\"",
    "<token of kind 21>",
    "\"<![CDATA[\"",
    "\"]]>\"",
    "<token of kind 24>",
    "<ENTITYREF>",
    "<PARAMETERENTITYREF>",
    "\"<![\"",
    "\"]]>\"",
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
    "<STRING_LIT>",
    "<ATTRIBS>",
  };

}
