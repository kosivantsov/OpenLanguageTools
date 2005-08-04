
/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */

package org.jvnet.olt.filters.it_segmenter;

public class StringViewingVisitor implements Segmenter_itVisitor
{

  public Object visit(SimpleNode node, Object data)
  {
      //  if (!node.toString().equals("whitespace") && !node.toString().equals("word"))
    System.out.println(node.toString() + " : " + node.getNodeData());
    return data;
  }
}