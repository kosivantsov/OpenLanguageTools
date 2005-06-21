
/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.3-b18-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2004.10.08 at 01:50:51 BST 
//


package org.jvnet.olt.filters.xliffsubsegment.xliff.impl;

public class ExImpl implements org.jvnet.olt.filters.xliffsubsegment.xliff.Ex, com.sun.xml.bind.RIElement, com.sun.xml.bind.JAXBObject, org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.UnmarshallableObject, org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.XMLSerializable, org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.ValidatableObject
{

    protected java.lang.String _Ts;
    protected java.lang.String _Id;
    protected java.lang.String _Rid;
    public final static java.lang.Class version = (org.jvnet.olt.filters.xliffsubsegment.xliff.impl.JAXBVersion.class);
    private static com.sun.msv.grammar.Grammar schemaFragment;

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return (org.jvnet.olt.filters.xliffsubsegment.xliff.Ex.class);
    }

    public java.lang.String ____jaxb_ri____getNamespaceURI() {
        return "";
    }

    public java.lang.String ____jaxb_ri____getLocalName() {
        return "ex";
    }

    public java.lang.String getTs() {
        return _Ts;
    }

    public void setTs(java.lang.String value) {
        _Ts = value;
    }

    public java.lang.String getId() {
        return _Id;
    }

    public void setId(java.lang.String value) {
        _Id = value;
    }

    public java.lang.String getRid() {
        return _Rid;
    }

    public void setRid(java.lang.String value) {
        _Rid = value;
    }

    public org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.UnmarshallingEventHandler createUnmarshaller(org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.UnmarshallingContext context) {
        return new org.jvnet.olt.filters.xliffsubsegment.xliff.impl.ExImpl.Unmarshaller(context);
    }

    public void serializeBody(org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        context.startElement("", "ex");
        context.endNamespaceDecls();
        if (_Ts!= null) {
            context.startAttribute("", "ts");
            try {
                context.text(((java.lang.String) _Ts), "Ts");
            } catch (java.lang.Exception e) {
                org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.Util.handlePrintConversionException(this, e, context);
            }
            context.endAttribute();
        }
        if (_Rid!= null) {
            context.startAttribute("", "rid");
            try {
                context.text(((java.lang.String) _Rid), "Rid");
            } catch (java.lang.Exception e) {
                org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.Util.handlePrintConversionException(this, e, context);
            }
            context.endAttribute();
        }
        context.startAttribute("", "id");
        try {
            context.text(((java.lang.String) _Id), "Id");
        } catch (java.lang.Exception e) {
            org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.Util.handlePrintConversionException(this, e, context);
        }
        context.endAttribute();
        context.endAttributes();
        context.endElement();
    }

    public void serializeAttributes(org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
    }

    public void serializeURIs(org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
    }

    public java.lang.Class getPrimaryInterface() {
        return (org.jvnet.olt.filters.xliffsubsegment.xliff.Ex.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        if (schemaFragment == null) {
            schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize((
 "\u00ac\u00ed\u0000\u0005sr\u0000\'com.sun.msv.grammar.trex.ElementPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000"
+"\tnameClasst\u0000\u001fLcom/sun/msv/grammar/NameClass;xr\u0000\u001ecom.sun.msv."
+"grammar.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aignoreUndeclaredAttributesL\u0000"
+"\fcontentModelt\u0000 Lcom/sun/msv/grammar/Expression;xr\u0000\u001ecom.sun."
+"msv.grammar.Expression\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0002L\u0000\u0013epsilonReducibilityt\u0000\u0013Lj"
+"ava/lang/Boolean;L\u0000\u000bexpandedExpq\u0000~\u0000\u0003xppp\u0000sr\u0000\u001fcom.sun.msv.gra"
+"mmar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun.msv.grammar.BinaryExp"
+"\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1q\u0000~\u0000\u0003L\u0000\u0004exp2q\u0000~\u0000\u0003xq\u0000~\u0000\u0004ppsq\u0000~\u0000\u0007ppsr\u0000\u001dcom.s"
+"un.msv.grammar.ChoiceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\bppsr\u0000 com.sun.msv.g"
+"rammar.AttributeExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~\u0000\u0003L\u0000\tnameClassq\u0000~\u0000\u0001xq"
+"\u0000~\u0000\u0004sr\u0000\u0011java.lang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z\u0000\u0005valuexp\u0000psr\u0000\u001bcom.sun."
+"msv.grammar.DataExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\u0002dtt\u0000\u001fLorg/relaxng/datatype/"
+"Datatype;L\u0000\u0006exceptq\u0000~\u0000\u0003L\u0000\u0004namet\u0000\u001dLcom/sun/msv/util/StringPai"
+"r;xq\u0000~\u0000\u0004ppsr\u0000-com.sun.msv.datatype.xsd.NormalizedStringType\u0000"
+"\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000#com.sun.msv.datatype.xsd.StringType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001"
+"Z\u0000\risAlwaysValidxr\u0000*com.sun.msv.datatype.xsd.BuiltinAtomicTy"
+"pe\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000%com.sun.msv.datatype.xsd.ConcreteType\u0000\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0001\u0002\u0000\u0000xr\u0000\'com.sun.msv.datatype.xsd.XSDatatypeImpl\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L"
+"\u0000\fnamespaceUrit\u0000\u0012Ljava/lang/String;L\u0000\btypeNameq\u0000~\u0000\u001aL\u0000\nwhiteS"
+"pacet\u0000.Lcom/sun/msv/datatype/xsd/WhiteSpaceProcessor;xpt\u0000 ht"
+"tp://www.w3.org/2001/XMLSchemat\u0000\u0010normalizedStringsr\u00004com.sun"
+".msv.datatype.xsd.WhiteSpaceProcessor$Replace\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000,"
+"com.sun.msv.datatype.xsd.WhiteSpaceProcessor\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xp\u0001sr"
+"\u00000com.sun.msv.grammar.Expression$NullSetExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000"
+"\u0000xq\u0000~\u0000\u0004ppsr\u0000\u001bcom.sun.msv.util.StringPair\u00d0t\u001ejB\u008f\u008d\u00a0\u0002\u0000\u0002L\u0000\tlocalN"
+"ameq\u0000~\u0000\u001aL\u0000\fnamespaceURIq\u0000~\u0000\u001axpt\u0000\u0005CDATAt\u0000\u0000sr\u0000#com.sun.msv.gra"
+"mmar.SimpleNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000\u001aL\u0000\fnamespace"
+"URIq\u0000~\u0000\u001axr\u0000\u001dcom.sun.msv.grammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpt\u0000\u0002tsq"
+"\u0000~\u0000\'sr\u00000com.sun.msv.grammar.Expression$EpsilonExpression\u0000\u0000\u0000\u0000"
+"\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0004sq\u0000~\u0000\u000f\u0001q\u0000~\u0000-sq\u0000~\u0000\u000bppsq\u0000~\u0000\rq\u0000~\u0000\u0010psq\u0000~\u0000\u0011ppsr\u0000$com"
+".sun.msv.datatype.xsd.NmtokenType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\"com.sun.msv."
+"datatype.xsd.TokenType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0016q\u0000~\u0000\u001dt\u0000\u0007NMTOKENsr\u00005co"
+"m.sun.msv.datatype.xsd.WhiteSpaceProcessor$Collapse\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002"
+"\u0000\u0000xq\u0000~\u0000 \u0000q\u0000~\u0000#sq\u0000~\u0000$q\u0000~\u00005q\u0000~\u0000\'sq\u0000~\u0000(t\u0000\u0003ridq\u0000~\u0000\'q\u0000~\u0000-sq\u0000~\u0000\rpp"
+"q\u0000~\u0000\u0014sq\u0000~\u0000(t\u0000\u0002idq\u0000~\u0000\'sq\u0000~\u0000(t\u0000\u0002exq\u0000~\u0000\'sr\u0000\"com.sun.msv.grammar"
+".ExpressionPool\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet\u0000/Lcom/sun/msv/grammar"
+"/ExpressionPool$ClosedHash;xpsr\u0000-com.sun.msv.grammar.Express"
+"ionPool$ClosedHash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0003\u0000\u0003I\u0000\u0005countB\u0000\rstreamVersionL\u0000\u0006pare"
+"ntt\u0000$Lcom/sun/msv/grammar/ExpressionPool;xp\u0000\u0000\u0000\u0004\u0001pq\u0000~\u0000\fq\u0000~\u0000/q"
+"\u0000~\u0000\tq\u0000~\u0000\nx"));
        }
        return new com.sun.msv.verifier.regexp.REDocumentDeclaration(schemaFragment);
    }

    public class Unmarshaller
        extends org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.AbstractUnmarshallingEventHandlerImpl
    {


        public Unmarshaller(org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.UnmarshallingContext context) {
            super(context, "------------");
        }

        protected Unmarshaller(org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.UnmarshallingContext context, int startState) {
            this(context);
            state = startState;
        }

        public java.lang.Object owner() {
            return org.jvnet.olt.filters.xliffsubsegment.xliff.impl.ExImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname, org.xml.sax.Attributes __atts)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  4 :
                        attIdx = context.getAttribute("", "rid");
                        if (attIdx >= 0) {
                            final java.lang.String v = context.eatAttribute(attIdx);
                            eatText1(v);
                            state = 7;
                            continue outer;
                        }
                        state = 7;
                        continue outer;
                    case  7 :
                        attIdx = context.getAttribute("", "id");
                        if (attIdx >= 0) {
                            final java.lang.String v = context.eatAttribute(attIdx);
                            eatText2(v);
                            state = 10;
                            continue outer;
                        }
                        break;
                    case  0 :
                        if (("ex" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 1;
                            return ;
                        }
                        break;
                    case  1 :
                        attIdx = context.getAttribute("", "ts");
                        if (attIdx >= 0) {
                            final java.lang.String v = context.eatAttribute(attIdx);
                            eatText3(v);
                            state = 4;
                            continue outer;
                        }
                        state = 4;
                        continue outer;
                    case  11 :
                        revertToParentFromEnterElement(___uri, ___local, ___qname, __atts);
                        return ;
                }
                super.enterElement(___uri, ___local, ___qname, __atts);
                break;
            }
        }

        private void eatText1(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _Rid = com.sun.xml.bind.WhiteSpaceProcessor.collapse(value);
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText2(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _Id = com.sun.xml.bind.WhiteSpaceProcessor.replace(value);
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText3(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _Ts = com.sun.xml.bind.WhiteSpaceProcessor.replace(value);
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        public void leaveElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  4 :
                        attIdx = context.getAttribute("", "rid");
                        if (attIdx >= 0) {
                            final java.lang.String v = context.eatAttribute(attIdx);
                            eatText1(v);
                            state = 7;
                            continue outer;
                        }
                        state = 7;
                        continue outer;
                    case  7 :
                        attIdx = context.getAttribute("", "id");
                        if (attIdx >= 0) {
                            final java.lang.String v = context.eatAttribute(attIdx);
                            eatText2(v);
                            state = 10;
                            continue outer;
                        }
                        break;
                    case  10 :
                        if (("ex" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 11;
                            return ;
                        }
                        break;
                    case  1 :
                        attIdx = context.getAttribute("", "ts");
                        if (attIdx >= 0) {
                            final java.lang.String v = context.eatAttribute(attIdx);
                            eatText3(v);
                            state = 4;
                            continue outer;
                        }
                        state = 4;
                        continue outer;
                    case  11 :
                        revertToParentFromLeaveElement(___uri, ___local, ___qname);
                        return ;
                }
                super.leaveElement(___uri, ___local, ___qname);
                break;
            }
        }

        public void enterAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  4 :
                        if (("rid" == ___local)&&("" == ___uri)) {
                            state = 5;
                            return ;
                        }
                        state = 7;
                        continue outer;
                    case  7 :
                        if (("id" == ___local)&&("" == ___uri)) {
                            state = 8;
                            return ;
                        }
                        break;
                    case  1 :
                        if (("ts" == ___local)&&("" == ___uri)) {
                            state = 2;
                            return ;
                        }
                        state = 4;
                        continue outer;
                    case  11 :
                        revertToParentFromEnterAttribute(___uri, ___local, ___qname);
                        return ;
                }
                super.enterAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void leaveAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  4 :
                        attIdx = context.getAttribute("", "rid");
                        if (attIdx >= 0) {
                            final java.lang.String v = context.eatAttribute(attIdx);
                            eatText1(v);
                            state = 7;
                            continue outer;
                        }
                        state = 7;
                        continue outer;
                    case  9 :
                        if (("id" == ___local)&&("" == ___uri)) {
                            state = 10;
                            return ;
                        }
                        break;
                    case  7 :
                        attIdx = context.getAttribute("", "id");
                        if (attIdx >= 0) {
                            final java.lang.String v = context.eatAttribute(attIdx);
                            eatText2(v);
                            state = 10;
                            continue outer;
                        }
                        break;
                    case  3 :
                        if (("ts" == ___local)&&("" == ___uri)) {
                            state = 4;
                            return ;
                        }
                        break;
                    case  1 :
                        attIdx = context.getAttribute("", "ts");
                        if (attIdx >= 0) {
                            final java.lang.String v = context.eatAttribute(attIdx);
                            eatText3(v);
                            state = 4;
                            continue outer;
                        }
                        state = 4;
                        continue outer;
                    case  6 :
                        if (("rid" == ___local)&&("" == ___uri)) {
                            state = 7;
                            return ;
                        }
                        break;
                    case  11 :
                        revertToParentFromLeaveAttribute(___uri, ___local, ___qname);
                        return ;
                }
                super.leaveAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void handleText(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                try {
                    switch (state) {
                        case  8 :
                            eatText2(value);
                            state = 9;
                            return ;
                        case  4 :
                            attIdx = context.getAttribute("", "rid");
                            if (attIdx >= 0) {
                                final java.lang.String v = context.eatAttribute(attIdx);
                                eatText1(v);
                                state = 7;
                                continue outer;
                            }
                            state = 7;
                            continue outer;
                        case  2 :
                            eatText3(value);
                            state = 3;
                            return ;
                        case  7 :
                            attIdx = context.getAttribute("", "id");
                            if (attIdx >= 0) {
                                final java.lang.String v = context.eatAttribute(attIdx);
                                eatText2(v);
                                state = 10;
                                continue outer;
                            }
                            break;
                        case  5 :
                            eatText1(value);
                            state = 6;
                            return ;
                        case  1 :
                            attIdx = context.getAttribute("", "ts");
                            if (attIdx >= 0) {
                                final java.lang.String v = context.eatAttribute(attIdx);
                                eatText3(v);
                                state = 4;
                                continue outer;
                            }
                            state = 4;
                            continue outer;
                        case  11 :
                            revertToParentFromText(value);
                            return ;
                    }
                } catch (java.lang.RuntimeException e) {
                    handleUnexpectedTextException(value, e);
                }
                break;
            }
        }

    }

}
