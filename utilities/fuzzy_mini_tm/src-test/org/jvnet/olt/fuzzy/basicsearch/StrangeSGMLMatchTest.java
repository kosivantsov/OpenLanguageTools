
/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */


/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */

package org.jvnet.olt.fuzzy.basicsearch;

import junit.framework.*;
import java.io.*;
import java.util.Arrays;
import org.jvnet.olt.minitm.*;
import org.jvnet.olt.fuzzy.*;

public class StrangeSGMLMatchTest 
extends TestCase
{
  private BasicSGMLFuzzySearchMiniTM minitm;

  public StrangeSGMLMatchTest(String name)
  {
    super(name);
  }

  public static Test suite()
  {
    TestSuite suite = new TestSuite();

    suite.addTest( new StrangeSGMLMatchTest("testMatchQuality") );
    suite.addTest( new StrangeSGMLMatchTest("testMatchQualityB") );
    suite.addTest( new StrangeSGMLMatchTest("testMatchQualityC") );
    suite.addTest( new StrangeSGMLMatchTest("testUpdateMatchQualityA") );
    suite.addTest( new StrangeSGMLMatchTest("testUpdateMatchQualityB") );
    suite.addTest( new MoreSGMLMatchTests("testMatchQuality") );
    suite.addTest( new MoreSGMLMatchTests("testMatchQualityB") );
    suite.addTest( new MoreSGMLMatchTests("testMatchQualityC") );

    return suite;
  }

  
  public void setUp()
  {
    try
    {
      minitm = new BasicSGMLFuzzySearchMiniTM("weird-sgml.mtm",
					      true,
					      "SGML MiniTM",
					      "en",
					      "de");
      
    }
    catch(Exception ex) { fail(ex.getMessage());}
  }

  public void tearDown()
  {
    minitm = null;
    File file = new File("weird-sgml.mtm");
    if(file.exists()) { file.delete(); }
    
  }

  public void testMatchQuality()
  {
    try
    {
      AlignedSegment as = new AlignedSegment("What's Changed in the Solaris 9 Operating Environment highlights and describes the new features of the <trademark>Solaris</trademark> 8 operating environment.","The Translation", "johnc");

      minitm.addNewSegment(as);

      TMMatch[] matches = minitm.getMatchFor("The Solaris operating environment runs on three types of hardware, or platforms - SPARC, IA and <trademark>MAC</trademark>.", 60, 5);
      if(matches.length > 0)
      {
	for(int t = 0; t < matches.length; t++)
	{
	  System.out.println("Result " + t + " { " + 
			     matches[t].getDataSourceKey() + ", " +
			     matches[t].getRatioOfMatch() + " }");
	}
      }
      assertEquals(0, matches.length);
      
    }
    catch(Exception ex) { fail(ex.getMessage());}
  }

  public void testMatchQualityB()
  {
    try
    {
      AlignedSegment as = new AlignedSegment("Contact the IHV directly to get support for these controllers, which have been certified using a third-party driver.","The Translation", "johnc");

      minitm.addNewSegment(as);

      TMMatch[] matches = minitm.getMatchFor("PXE network boot is available only for devices that implement the Intel Preboot Execution Environment specification.", 70, 5);
      if(matches.length > 0)
      {
	for(int t = 0; t < matches.length; t++)
	{
	  System.out.println("Result " + t + " { " + 
			     matches[t].getDataSourceKey() + ", " +
			     matches[t].getRatioOfMatch() + " }");
	}
      }
      assertEquals(0, matches.length);
      
    }
    catch(Exception ex) { fail(ex.getMessage());}
  }

  public void testMatchQualityC()
  {
    try
    {
      AlignedSegment as = new AlignedSegment("IA based systems that use the Intel Pentium Pro and subsequently released Intel CPUs can address up to 32 Gbytes of memory. ","The Translation", "johnc");

      minitm.addNewSegment(as);

      TMMatch[] matches = minitm.getMatchFor("PXE network boot is available only for devices that implement the Intel Preboot Execution Environment specification. ", 70, 5);
      if(matches.length > 0)
      {
	for(int t = 0; t < matches.length; t++)
	{
	  System.out.println("Result " + t + " { " + 
			     matches[t].getDataSourceKey() + ", " +
			     matches[t].getRatioOfMatch() + " }");
	}
      }
      assertEquals(0, matches.length);
      
    }
    catch(Exception ex) { fail(ex.getMessage());}
  }

  public void testUpdateMatchQualityA()
  {
    try
    {
      AlignedSegment as = new AlignedSegment("The Solaris operating environment runs on three types of hardware, or platforms - SPARC, IA and <trademark>MAC</trademark>.","The Translation", "johnc");

      minitm.addNewSegment(as);

      TMMatch[] prematch = minitm.getMatchFor("The Solaris operating environment runs on three types of hardware, or platforms - SPARC, IA and <trademark>MAC</trademark>.", 60, 5);

      AlignedSegment as1 = new AlignedSegment("What's Changed in the Solaris 9 Operating Environment highlights and describes the new features of the <trademark>Solaris</trademark> 8 operating environment.","The Translation", "johnc");

      minitm.updateSegment(as1, prematch[0].getDataSourceKey());

      TMMatch[] matches = minitm.getMatchFor("The Solaris operating environment runs on three types of hardware, or platforms - SPARC, IA and <trademark>MAC</trademark>.", 60, 5);
      if(matches.length > 0)
      {
	for(int t = 0; t < matches.length; t++)
	{
	  System.out.println("Result " + t + " { " + 
			     matches[t].getDataSourceKey() + ", " +
			     matches[t].getRatioOfMatch() + " }");
	}
      }
      assertEquals(1, matches.length);
      
    }
    catch(Exception ex) { fail(ex.getMessage());}
  }

  public void testUpdateMatchQualityB()
  {
    try
    {
      AlignedSegment as = new AlignedSegment("What's Changed in the Solaris 9 Operating Environment highlights and describes the new features of the <trademark>Solaris</trademark> 8 operating environment.","The Translation", "johnc");

      minitm.addNewSegment(as);

      TMMatch[] prematch = minitm.getMatchFor("What's Changed in the Solaris 9 Operating Environment highlights and describes the new features of the <trademark>Solaris</trademark> 8 operating environment.", 60, 5);

      AlignedSegment as1 = new AlignedSegment("The Solaris operating environment runs on three types of hardware, or platforms - SPARC, IA and <trademark>MAC</trademark>.","The Translation", "johnc");

      minitm.updateSegment(as1, prematch[0].getDataSourceKey());

      TMMatch[] matches = minitm.getMatchFor("The Solaris operating environment runs on three types of hardware, or platforms - SPARC, IA and <trademark>MAC</trademark>.", 60, 5);
      if(matches.length > 0)
      {
	for(int t = 0; t < matches.length; t++)
	{
	  System.out.println("Result " + t + " { " + 
			     matches[t].getDataSourceKey() + ", " +
			     matches[t].getRatioOfMatch() + " }");
	}
      }
      assertEquals(0, matches.length);
      
    }
    catch(Exception ex) { fail(ex.getMessage());}
  }

}
