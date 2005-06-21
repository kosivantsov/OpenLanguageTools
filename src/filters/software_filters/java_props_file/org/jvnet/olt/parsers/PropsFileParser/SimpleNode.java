
/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */

/* Generated By:JJTree: Do not edit this line. SimpleNode.java */

package org.jvnet.olt.parsers.PropsFileParser;

public class SimpleNode implements Node
{
  protected Node parent;
  protected Node[] children;
  protected int id;
  protected PropsFileParser parser;

  //  A string to hold data about the node, normally token values.
  protected String m_nodeData = "";
  //  This variable indicates whether has message string for current message id
  protected boolean m_hasMessage = false;

  public SimpleNode(int i)
  {
    id = i;
  }

  public SimpleNode(PropsFileParser p, int i)
  {
    this(i);
    parser = p;
  }

  public void jjtOpen()
  {
  }

  public void jjtClose()
  {
  }

  public void jjtSetParent(Node n)
  {
    parent = n;
  }

  public Node jjtGetParent()
  {
    return parent;
  }

  public void jjtAddChild(Node n, int i)
  {
    if (children == null)
    {
      children = new Node[i + 1];
    }
    else if (i >= children.length)
    {
      Node c[] = new Node[i + 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = n;
  }

  public Node jjtGetChild(int i)
  {
    return children[i];
  }

  public int jjtGetNumChildren()
  {
    return (children == null) ? 0 : children.length;
  }

  /** Accept the visitor. **/
  public Object jjtAccept(PropsFileParserVisitor visitor, Object data)
  {
    data = visitor.visit(this, data);
    data = childrenAccept(visitor, data);
    return data;
  }

  /** Accept the visitor. **/

  public Object childrenAccept(PropsFileParserVisitor visitor, Object data)
  {
    if (children != null)
    {
      for (int i = 0; i < children.length; ++i)
      {
        data = children[i].jjtAccept(visitor, data);
      }
    }
    return data;
  }

  /* You can override these two methods in subclasses of SimpleNode to
     customize the way the node appears when the tree is dumped.  If
     your output uses more than one line you should override
     toString(String), otherwise overriding toString() is probably all
     you need to do. */

  public String toString()
  {
    return PropsFileParserTreeConstants.jjtNodeName[id];
  }

  public String toString(String prefix)
  {
    return prefix + toString();
  }

  /* Override this method if you want to customize how the node dumps
     out its children. */

  public void dump(String prefix)
  {
    System.out.println(toString(prefix));
    if (children != null)
    {
      for (int i = 0; i < children.length; ++i)
      {
        SimpleNode n = (SimpleNode) children[i];
        if (n != null)
        {
          n.dump(prefix + " ");
        }
      }
    }
  }

  public void setNodeData(String strData)
  {
    m_nodeData = strData;
  }

  public String getNodeData()
  {
    return m_nodeData;
  }

  public void setHasMessage(boolean bHasMessage)
  {
    m_hasMessage = bHasMessage;
  }

  public boolean isHasMessage()
  {
    return m_hasMessage;
  }

  public int getType()
  {
    return id;
  }

}