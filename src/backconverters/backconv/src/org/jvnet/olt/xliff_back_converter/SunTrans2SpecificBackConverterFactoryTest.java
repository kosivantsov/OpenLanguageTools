/*
* CDDL HEADER START
*
* The contents of this file are subject to the terms of the
* Common Development and Distribution License (the "License").
* You may not use this file except in compliance with the License.
*
* You can obtain a copy of the license at LICENSE.txt
* or http://www.opensource.org/licenses/cddl1.php.
* See the License for the specific language governing permissions
* and limitations under the License.
*
* When distributing Covered Code, include this CDDL HEADER in each
* file and include the License file at LICENSE.txt.
* If applicable, add the following below this CDDL HEADER, with the
* fields enclosed by brackets "[]" replaced with your own identifying
* information: Portions Copyright [yyyy] [name of copyright owner]
*
* CDDL HEADER END
*/
///*
// * SunTrans2SpecificBackConverterFactoryTest.java
// *
// * Created on April 24, 2006, 2:37 PM
// *
// * To change this template, choose Tools | Template Manager
// * and open the template in the editor.
// */
//TODO: remove or move to test
//package org.jvnet.olt.xliff_back_converter;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import junit.framework.TestCase;
//import org.jvnet.olt.xliff_back_converter.format.html.HtmlSpecificBackConverter;
//import org.jvnet.olt.xliff_back_converter.format.sgml.SgmlSpecificBackConverter;
//import org.jvnet.olt.xliff_back_converter.format.software.SoftwareSpecificBackConverter;
//import org.jvnet.olt.xliff_back_converter.format.xml.ooo.OpenOfficeSpecificBackConverter;
//
///**
// *
// * @author boris
// */
//public class SunTrans2SpecificBackConverterFactoryTest extends TestCase{
//    Map expectClasses;
//
//    /** Creates a new instance of SunTrans2SpecificBackConverterFactoryTest */
//    public SunTrans2SpecificBackConverterFactoryTest() {
//    }
//
//
//
//    protected void setUp() throws Exception {
//        super.setUp();
//
//
//        expectClasses = new LinkedHashMap();
//
//        Map x = expectClasses;
//        /*
//        x.put("html", HtmlSpecificBackConverter.class);
//        x.put("htm", HtmlSpecificBackConverter.class);
//        x.put("sgml", SgmlSpecificBackConverter.class);
//        x.put("sgm", SgmlSpecificBackConverter.class);
//        x.put("plaintext", NullSpecificBackConverter.class);
//        x.put("po", SoftwareSpecificBackConverter.class);
//        x.put("properties", SoftwareSpecificBackConverter.class);
//        x.put("msg" , SoftwareSpecificBackConverter.class);
//        x.put("tmsg", SoftwareSpecificBackConverter.class);
//        x.put("java", SoftwareSpecificBackConverter.class); */
//        x.put("OpenOffice.org Writer", OpenOfficeSpecificBackConverter.class);
//        x.put("OpenOffice.org Impress", OpenOfficeSpecificBackConverter.class);
//        x.put("OpenOffice.org Calc", OpenOfficeSpecificBackConverter.class);
//        x.put("Open Document Format Text", OpenOfficeSpecificBackConverter.class);
//        x.put("Open Document Format Spreadsheet", OpenOfficeSpecificBackConverter.class);
//        x.put("Open Document Format Graphics", OpenOfficeSpecificBackConverter.class);
//        x.put("Open Document Format Presentation", OpenOfficeSpecificBackConverter.class);
//
//    }
//
//
//
//    public void testBackConverter() throws Exception{
//        SunTrans2SpecificBackConverterFactory fac = new SunTrans2SpecificBackConverterFactory();
//
//        for (Iterator i = expectClasses.entrySet().iterator(); i.hasNext();) {
//            Map.Entry entry = (Map.Entry) i.next();
//
//            String conv = (String)entry.getKey();
//
//            Object o = fac.getSpecificBackConverter(conv);
//            assertNotNull(o);
//
//            System.out.println("conv:"+conv+" -> "+entry.getValue().getClass());
//
//            assertEquals(entry.getValue(),o.getClass());
//        }
//
//    }
//
//
//}
