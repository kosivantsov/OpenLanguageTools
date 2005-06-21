
/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */

package org.jvnet.olt.parsers.XResFileParser;

public class TokenCountingVisitor implements XResFileParserVisitor
{
  private int m_iNumTokens = 0;
  private int m_iTransTokens = 0;

  public Object visit(SimpleNode node, Object data)
  {
    m_iNumTokens++;
    return null;
  }

  public int getNumTokens()
  {
    return m_iNumTokens;
  }

  public int getTransNumTokens()
  {
    return m_iTransTokens;
  }

}
