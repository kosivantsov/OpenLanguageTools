
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

public class BodyImpl implements org.jvnet.olt.filters.xliffsubsegment.xliff.Body, com.sun.xml.bind.RIElement, com.sun.xml.bind.JAXBObject, org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.UnmarshallableObject, org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.XMLSerializable, org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.ValidatableObject
{

    protected com.sun.xml.bind.util.ListImpl _Content;
    public final static java.lang.Class version = (org.jvnet.olt.filters.xliffsubsegment.xliff.impl.JAXBVersion.class);
    private static com.sun.msv.grammar.Grammar schemaFragment;

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return (org.jvnet.olt.filters.xliffsubsegment.xliff.Body.class);
    }

    public java.lang.String ____jaxb_ri____getNamespaceURI() {
        return "";
    }

    public java.lang.String ____jaxb_ri____getLocalName() {
        return "body";
    }

    protected com.sun.xml.bind.util.ListImpl _getContent() {
        if (_Content == null) {
            _Content = new com.sun.xml.bind.util.ListImpl(new java.util.ArrayList());
        }
        return _Content;
    }

    public java.util.List getContent() {
        return _getContent();
    }

    public org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.UnmarshallingEventHandler createUnmarshaller(org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.UnmarshallingContext context) {
        return new org.jvnet.olt.filters.xliffsubsegment.xliff.impl.BodyImpl.Unmarshaller(context);
    }

    public void serializeBody(org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        int idx1 = 0;
        final int len1 = ((_Content == null)? 0 :_Content.size());
        context.startElement("", "body");
        int idx_0 = idx1;
        while (idx_0 != len1) {
            context.childAsURIs(((com.sun.xml.bind.JAXBObject) _Content.get(idx_0 ++)), "Content");
        }
        context.endNamespaceDecls();
        int idx_1 = idx1;
        while (idx_1 != len1) {
            context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _Content.get(idx_1 ++)), "Content");
        }
        context.endAttributes();
        while (idx1 != len1) {
            context.childAsBody(((com.sun.xml.bind.JAXBObject) _Content.get(idx1 ++)), "Content");
        }
        context.endElement();
    }

    public void serializeAttributes(org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        int idx1 = 0;
        final int len1 = ((_Content == null)? 0 :_Content.size());
    }

    public void serializeURIs(org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        int idx1 = 0;
        final int len1 = ((_Content == null)? 0 :_Content.size());
    }

    public java.lang.Class getPrimaryInterface() {
        return (org.jvnet.olt.filters.xliffsubsegment.xliff.Body.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        if (schemaFragment == null) {
            schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize((
 "\u00ac\u00ed\u0000\u0005sr\u0000\'com.sun.msv.grammar.trex.ElementPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000"
+"\tnameClasst\u0000\u001fLcom/sun/msv/grammar/NameClass;xr\u0000\u001ecom.sun.msv."
+"grammar.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aignoreUndeclaredAttributesL\u0000"
+"\fcontentModelt\u0000 Lcom/sun/msv/grammar/Expression;xr\u0000\u001ecom.sun."
+"msv.grammar.Expression\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0002L\u0000\u0013epsilonReducibilityt\u0000\u0013Lj"
+"ava/lang/Boolean;L\u0000\u000bexpandedExpq\u0000~\u0000\u0003xppp\u0000sr\u0000\u001dcom.sun.msv.gra"
+"mmar.ChoiceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun.msv.grammar.BinaryExp\u0000\u0000"
+"\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1q\u0000~\u0000\u0003L\u0000\u0004exp2q\u0000~\u0000\u0003xq\u0000~\u0000\u0004ppsr\u0000 com.sun.msv.gra"
+"mmar.OneOrMoreExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001ccom.sun.msv.grammar.UnaryExp"
+"\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\u0003expq\u0000~\u0000\u0003xq\u0000~\u0000\u0004sr\u0000\u0011java.lang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001"
+"Z\u0000\u0005valuexp\u0000psq\u0000~\u0000\u0007q\u0000~\u0000\u000epsq\u0000~\u0000\u0007q\u0000~\u0000\u000epsq\u0000~\u0000\u0000q\u0000~\u0000\u000ep\u0000sq\u0000~\u0000\u0007ppsq\u0000"
+"~\u0000\nq\u0000~\u0000\u000epsr\u0000 com.sun.msv.grammar.AttributeExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003e"
+"xpq\u0000~\u0000\u0003L\u0000\tnameClassq\u0000~\u0000\u0001xq\u0000~\u0000\u0004q\u0000~\u0000\u000epsr\u00002com.sun.msv.grammar."
+"Expression$AnyStringExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0004sq\u0000~\u0000\r\u0001q\u0000~\u0000\u0017s"
+"r\u0000 com.sun.msv.grammar.AnyNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun.ms"
+"v.grammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpsr\u00000com.sun.msv.grammar.Expr"
+"ession$EpsilonExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0004q\u0000~\u0000\u0018q\u0000~\u0000\u001dsr\u0000#com.s"
+"un.msv.grammar.SimpleNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNamet\u0000\u0012Ljav"
+"a/lang/String;L\u0000\fnamespaceURIq\u0000~\u0000\u001fxq\u0000~\u0000\u001at\u0000.com.sun.tt.filter"
+"s.xliffsubsegment.xliff.Groupt\u0000+http://java.sun.com/jaxb/xjc"
+"/dummy-elementssq\u0000~\u0000\u0000q\u0000~\u0000\u000ep\u0000sq\u0000~\u0000\u0007ppsq\u0000~\u0000\nq\u0000~\u0000\u000epsq\u0000~\u0000\u0014q\u0000~\u0000\u000ep"
+"q\u0000~\u0000\u0017q\u0000~\u0000\u001bq\u0000~\u0000\u001dsq\u0000~\u0000\u001et\u00002org.jvnet.olt.filters.xliffsubsegment.x"
+"liff.TransUnitq\u0000~\u0000\"sq\u0000~\u0000\u0000q\u0000~\u0000\u000ep\u0000sq\u0000~\u0000\u0007ppsq\u0000~\u0000\nq\u0000~\u0000\u000epsq\u0000~\u0000\u0014q\u0000"
+"~\u0000\u000epq\u0000~\u0000\u0017q\u0000~\u0000\u001bq\u0000~\u0000\u001dsq\u0000~\u0000\u001et\u00000com.sun.tt.filters.xliffsubsegme"
+"nt.xliff.BinUnitq\u0000~\u0000\"q\u0000~\u0000\u001dsq\u0000~\u0000\u001et\u0000\u0004bodyt\u0000\u0000sr\u0000\"com.sun.msv.gr"
+"ammar.ExpressionPool\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet\u0000/Lcom/sun/msv/gr"
+"ammar/ExpressionPool$ClosedHash;xpsr\u0000-com.sun.msv.grammar.Ex"
+"pressionPool$ClosedHash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0003\u0000\u0003I\u0000\u0005countB\u0000\rstreamVersionL\u0000"
+"\u0006parentt\u0000$Lcom/sun/msv/grammar/ExpressionPool;xp\u0000\u0000\u0000\n\u0001pq\u0000~\u0000\tq"
+"\u0000~\u0000\u0012q\u0000~\u0000$q\u0000~\u0000*q\u0000~\u0000\u000fq\u0000~\u0000\u0010q\u0000~\u0000\u0013q\u0000~\u0000%q\u0000~\u0000+q\u0000~\u0000\fx"));
        }
        return new com.sun.msv.verifier.regexp.REDocumentDeclaration(schemaFragment);
    }

    public class Unmarshaller
        extends org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.AbstractUnmarshallingEventHandlerImpl
    {


        public Unmarshaller(org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.UnmarshallingContext context) {
            super(context, "----");
        }

        protected Unmarshaller(org.jvnet.olt.filters.xliffsubsegment.xliff.impl.runtime.UnmarshallingContext context, int startState) {
            this(context);
            state = startState;
        }

        public java.lang.Object owner() {
            return org.jvnet.olt.filters.xliffsubsegment.xliff.impl.BodyImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname, org.xml.sax.Attributes __atts)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  3 :
                        revertToParentFromEnterElement(___uri, ___local, ___qname, __atts);
                        return ;
                    case  2 :
                        if (("group" == ___local)&&("" == ___uri)) {
                            _getContent().add(((org.jvnet.olt.filters.xliffsubsegment.xliff.impl.GroupImpl) spawnChildFromEnterElement((org.jvnet.olt.filters.xliffsubsegment.xliff.impl.GroupImpl.class), 2, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("trans-unit" == ___local)&&("" == ___uri)) {
                            _getContent().add(((org.jvnet.olt.filters.xliffsubsegment.xliff.impl.TransUnitImpl) spawnChildFromEnterElement((org.jvnet.olt.filters.xliffsubsegment.xliff.impl.TransUnitImpl.class), 2, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("bin-unit" == ___local)&&("" == ___uri)) {
                            _getContent().add(((org.jvnet.olt.filters.xliffsubsegment.xliff.impl.BinUnitImpl) spawnChildFromEnterElement((org.jvnet.olt.filters.xliffsubsegment.xliff.impl.BinUnitImpl.class), 2, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        break;
                    case  0 :
                        if (("body" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 1;
                            return ;
                        }
                        break;
                    case  1 :
                        if (("group" == ___local)&&("" == ___uri)) {
                            _getContent().add(((org.jvnet.olt.filters.xliffsubsegment.xliff.impl.GroupImpl) spawnChildFromEnterElement((org.jvnet.olt.filters.xliffsubsegment.xliff.impl.GroupImpl.class), 2, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("trans-unit" == ___local)&&("" == ___uri)) {
                            _getContent().add(((org.jvnet.olt.filters.xliffsubsegment.xliff.impl.TransUnitImpl) spawnChildFromEnterElement((org.jvnet.olt.filters.xliffsubsegment.xliff.impl.TransUnitImpl.class), 2, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("bin-unit" == ___local)&&("" == ___uri)) {
                            _getContent().add(((org.jvnet.olt.filters.xliffsubsegment.xliff.impl.BinUnitImpl) spawnChildFromEnterElement((org.jvnet.olt.filters.xliffsubsegment.xliff.impl.BinUnitImpl.class), 2, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        state = 2;
                        continue outer;
                }
                super.enterElement(___uri, ___local, ___qname, __atts);
                break;
            }
        }

        public void leaveElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  3 :
                        revertToParentFromLeaveElement(___uri, ___local, ___qname);
                        return ;
                    case  2 :
                        if (("body" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 3;
                            return ;
                        }
                        break;
                    case  1 :
                        state = 2;
                        continue outer;
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
                    case  3 :
                        revertToParentFromEnterAttribute(___uri, ___local, ___qname);
                        return ;
                    case  1 :
                        state = 2;
                        continue outer;
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
                    case  3 :
                        revertToParentFromLeaveAttribute(___uri, ___local, ___qname);
                        return ;
                    case  1 :
                        state = 2;
                        continue outer;
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
                        case  3 :
                            revertToParentFromText(value);
                            return ;
                        case  1 :
                            state = 2;
                            continue outer;
                    }
                } catch (java.lang.RuntimeException e) {
                    handleUnexpectedTextException(value, e);
                }
                break;
            }
        }

    }

}
