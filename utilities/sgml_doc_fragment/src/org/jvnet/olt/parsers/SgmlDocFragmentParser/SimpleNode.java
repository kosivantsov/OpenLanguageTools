
/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */

/* Generated By:JJTree: Do not edit this line. SimpleNode.java */

package org.jvnet.olt.parsers.SgmlDocFragmentParser;
import org.jvnet.olt.parsers.tagged.TaggedMarkupNode;
import org.jvnet.olt.parsers.tagged.TaggedMarkupVisitor;
public class SimpleNode 
implements Node, TaggedMarkupNode
{
  protected static final TreeConst consts = new TreeConst();

  protected Node parent;
  protected Node[] children;
  protected int id;

  protected String m_nodeData = "";   //  A string to hold data about the node,
                                      //  normally token values.

  protected String m_tagName = "";
  protected String m_markedSectFlag = "";
  protected boolean hasAttribute = false;

  protected int m_beginLine   = -1;
  protected int m_beginColumn = -1;
  protected int m_endLine     = -1;
  protected int m_endColumn   = -1;

  public SimpleNode(int i) {
    id = i;
  }

  public void jjtOpen() {
  }

  public void jjtClose() {
  }
  
  public void jjtSetParent(Node n) { parent = n; }
  public Node jjtGetParent() { return parent; }

  public void jjtAddChild(Node n, int i) {
    if (children == null) {
      children = new Node[i + 1];
    } else if (i >= children.length) {
      Node c[] = new Node[i + 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = n;
  }

  public Node jjtGetChild(int i) {
    return children[i];
  }

  public int jjtGetNumChildren() {
    return (children == null) ? 0 : children.length;
  }

  /** Accept the visitor. **/
  public Object jjtAccept(SgmlDocFragmentParserVisitor visitor, Object data)  {
     data = visitor.visit(this, data);
     data = childrenAccept(visitor,data);
    return data;
  }
  
  /* added this method so we could accept a generic tagged markup visitor */
  public Object jjtAccept(TaggedMarkupVisitor visitor, Object data)  {
     data = visitor.visit(this, data);
     data = childrenAccept(visitor,data);
    return data;
  }

/** Accept the visitor. **/



  public Object childrenAccept(SgmlDocFragmentParserVisitor visitor, Object data) {
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        data = children[i].jjtAccept(visitor, data);
      }
    }
    return data;
  }
  
  /* added this method so we could accept a generic tagged markup visitor */
  public Object childrenAccept(TaggedMarkupVisitor visitor, Object data) {
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
          TaggedMarkupNode node = (TaggedMarkupNode)children[i];
          node.jjtAccept(visitor, data);
      }
    }
    return data;
  }

  /* You can override these two methods in subclasses of SimpleNode to
     customize the way the node appears when the tree is dumped.  If
     your output uses more than one line you should override
     toString(String), otherwise overriding toString() is probably all
     you need to do. */

  public String toString() { return SgmlDocFragmentParserTreeConstants.jjtNodeName[id]; }
  public String toString(String prefix) { return prefix + toString(); }

  /* Override this method if you want to customize how the node dumps
     out its children. */

  public void dump(String prefix) {
    System.out.println(toString(prefix));
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
	SimpleNode n = (SimpleNode)children[i];
	if (n != null) {
	  n.dump(prefix + " ");
	}
      }
    }
  }
  public void setMarkedSectFlag(String strData)
  {
    m_markedSectFlag = strData.trim();
  }

  public String getMarkedSectFlag()
  {
    return m_markedSectFlag;
  }

  public void setNodeData(String strData)
  {
    m_nodeData = strData;
  }

  public String getNodeData()
  {
    return m_nodeData;
  }

  public void setTagName(String strData)
  {
    m_tagName = strData;
  }

  public String getTagName()
  {
    return m_tagName;
  }

  public void setBeginPos(int beginLine, int beginColumn, boolean update)
  {
    if(((m_beginLine == -1) && (m_beginColumn == -1)) || update)
    {
      m_beginLine   = beginLine;
      m_beginColumn = beginColumn;
    }
  }

  public void setEndPos(int endLine, int endColumn, boolean update)
  {
    if(((m_endLine == -1) && (m_endColumn == -1)) || update)
    {
      m_endLine   = endLine;
      m_endColumn = endColumn;
    }
  }

  public int getBeginLine()
  {
    return m_beginLine;
  }

  public int getEndLine()
  {
    return m_endLine;
  }

  public int getBeginColumn()
  {
    return m_beginColumn;
  }

  public int getEndColumn()
  {
    return m_endColumn;
  }

  public boolean isDisplayingNode()
  {
    return consts.isDisplayingNode(id);
  }

  public int getType()
  {
    return id;
  }

  public boolean isEmptyTag(){
      return false;
  }

  protected void setHasAttribute(boolean hasAttribute){
	this.hasAttribute = hasAttribute;
  }

  public boolean hasAttribute(){
	return hasAttribute;
  }
 
  /* setting prefix and schema are no-ops for the sgml parser, but since
   * we're implementing TaggedMarkupNode here as well, we have to implement
   * these methods
   */
  public void setPrefix(String thePrefix){;}
  
  public String getPrefix(){
      return "";
  }
  
  public String getNamespaceID() { 
      return "";
  }
  public void setNamespaceID(String schema){;}
  
  /**
   * This is a no-op for the sgml parser
   */
  public java.util.Map getNamespaceMap() {
      return null;
  }  

}






