
/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */

/* Generated By:JJTree: Do not edit this line. SimpleNode.java */

package org.jvnet.olt.laxparsers.sgml;

public class SimpleNode implements Node, LaxSgmlDocFragmentParserTreeConstants{
    protected Node parent;
    protected Node[] children;
    protected int id;
    protected LaxSgmlDocFragmentParser parser;
    
    /** Holds value of property nodeData. */
    private String nodeData = "";
    
    /** Holds value of property tagName. */
    private String tagName = "";
    
    /** Holds value of property markedSectionFlag. */
    private String markedSectionFlag = "";
    
    public SimpleNode(int i) {
        id = i;
    }
    
    public SimpleNode(LaxSgmlDocFragmentParser p, int i) {
        this(i);
        parser = p;
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
    public Object jjtAccept(LaxSgmlDocFragmentParserVisitor visitor, Object data) {
        visitor.visit(this, data);
        childrenAccept(visitor, data);
        
        return data;
    }
    
    /** Accept the visitor. **/
    public Object childrenAccept(LaxSgmlDocFragmentParserVisitor visitor, Object data) {
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                children[i].jjtAccept(visitor, data);
            }
        }
        return data;
    }
    
  /* You can override these two methods in subclasses of SimpleNode to
     customize the way the node appears when the tree is dumped.  If
     your output uses more than one line you should override
     toString(String), otherwise overriding toString() is probably all
     you need to do. */
    
    public String toString() { return LaxSgmlDocFragmentParserTreeConstants.jjtNodeName[id]; }
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
    
    /** Getter for property nodeData.
     * @return Value of property nodeData.
     *
     */
    public String getNodeData() {
        return this.nodeData;
    }
    
    /** Setter for property nodeData.
     * @param nodeData New value of property nodeData.
     *
     */
    public void setNodeData(String nodeData) {
        this.nodeData = nodeData;
    }
    
    public int getType() {
        return id;
    }
    
    
    /** Getter for property tagName.
     * @return Value of property tagName.
     *
     */
    public String getTagName() {
        return this.tagName;
    }
    
    /** Setter for property tagName.
     * @param tagName New value of property tagName.
     *
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
    
    /** Getter for property markedSectionFlag.
     * @return Value of property markedSectionFlag.
     *
     */
    public String getMarkedSectionFlag() {
        return this.markedSectionFlag;
    }
    
    /** Setter for property markedSectionFlag.
     * @param markedSectionFlag New value of property markedSectionFlag.
     *
     */
    public void setMarkedSectionFlag(String markedSectionFlag) {
        this.markedSectionFlag = markedSectionFlag;
    }
    
    public boolean isDisplayingNode() {
        int foo = id;
        switch(id) {
            case JJTENTITY:
            case JJTOPEN_TAG:
            case JJTEND_TAG:
            case JJTCOMMENT:
            case JJTCDATA_SECT:
            case JJTPROCESSING_INST:
            case JJTJSP_TAG:
            case JJTJSP_INLINE:
            case JJTMARKED_SECT_START:
            case JJTMARKED_SECT_END:
            case JJTPCDATA:
            case JJTEOF:
                return true;
            default:
                return false;
        }
    }
    
    
}

