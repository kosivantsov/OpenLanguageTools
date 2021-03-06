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
/*
 * Copyright  2005 Sun Microsystems, Inc.
 * All rights reserved Use is subject to license terms.
 *
 */
package org.jvnet.olt.editor.util;

import java.awt.*;

import java.util.*;

import javax.swing.*;


public class JTextLabel extends JLabel {
    //public static final String strToken = "\"|. \n";
    public static final String strToken = " \t\n";

    //font
    private static Font font = new Font("Dialog", Font.PLAIN, 12);
    private static FontMetrics mx = Toolkit.getDefaultToolkit().getFontMetrics(font);
    private static int[] ascWidth = mx.getWidths();
    private static int iChHeight = mx.getHeight();

    //private static int hzWidth = mx.stringWidth ("\uFFFD") ;
    private static int hzWidth = mx.stringWidth("\u4e00");
    private static Color selColor;
    private static Color defColor;
    private static String TEST_STR = "Hello World! How do you think about my table? " + "I think it would be an excellent tool";

    /* magic number to adjust with JTextPane line wrapping */
    //private static final int XOFF = 2;

    private int iWidth;
    private int iHeight;
    private String strInput;
    private Vector vLines;
    private int iLines;
    private boolean isSelect;

    public JTextLabel(String strInput, int iWidth, boolean isSelectInput, Color selColorInput, Color defColorInput) {
        this.iWidth = iWidth;
        this.isSelect = isSelectInput;

        if (selColorInput != null) {
            this.selColor = selColorInput;
        }

        if (defColorInput != null) {
            this.defColor = defColorInput;
        }

        setContent(strInput);
    }

    public JTextLabel(int iWidth) {
        this(TEST_STR, iWidth, false, null, null);
    }

    public void setContent(String strInput) {
        this.strInput = strInput;
        calculateBasicInfo();
    }

    public java.awt.Insets getInsets() {
        return new java.awt.Insets(0, 0, 0, 0);
    }

    private int getStringWidth(String strInput) {
        char[] chText = strInput.toCharArray();
        int l = 0;

        for (int j = 0; j < chText.length; j++) {
            //if ( chText [j] < 0x80 )//ascii char
            if (chText[j] < 0xff) { // iso8859-1 chars
                l += ascWidth[chText[j]];
            } else { // asia char
                l += hzWidth;
            }
        }

        return l;
    }

    private void preparePaint() {
        String str = "";
        vLines = new Vector();
        StringTokenizer m_tokenizer = new StringTokenizer(strInput, strToken, true);

        int w = 20;
        int l;
        StringBuffer m_strBuffer = new StringBuffer();

        for (int i = 0; m_tokenizer.hasMoreTokens(); i++) {
            str = m_tokenizer.nextToken();

            if (str.equals(" ")) {
                l = ascWidth[str.charAt(0)];
                m_strBuffer.append(str);
            } else if (str.equals("\n")) {
                vLines.addElement(m_strBuffer.toString());
                m_strBuffer.delete(0, m_strBuffer.length());
                w = 20;

                continue;
            } else {
                l = getStringWidth(str);
            }

            if ((w + l) > iWidth) {
                vLines.addElement(m_strBuffer.toString());
                m_strBuffer.delete(0, m_strBuffer.length());
                m_strBuffer.append(str);
                w = 20 + l;
            } else {
                w += l;
                m_strBuffer.append(str);
            }
        }

        if (m_strBuffer.length() != 0) {
            vLines.addElement(m_strBuffer.toString());
        }
    }

    private boolean judgePureISOchars(String strInput) {
        for (int i = 0; i < strInput.length(); i++) {
            if (strInput.charAt(i) > 0xff) {
                return false;
            }
        }

        return true;
    }

    private void preparePaintLikeLabel() {
        String str = "";
        vLines = new Vector();
        StringTokenizer m_tokenizer = new StringTokenizer(strInput, strToken, true);

        int w = 2;
        int l;
        StringBuffer m_strBuffer = new StringBuffer();

        for (int i = 0; m_tokenizer.hasMoreTokens(); i++) {
            str = m_tokenizer.nextToken();

            if (str.equals(" ")) {
                //l = ascWidth[str.charAt(0)];
                //w += l;
                if (w >= iWidth) { // add the space then exceed the width.
                    vLines.addElement(m_strBuffer.toString());
                    m_strBuffer.delete(0, m_strBuffer.length());

                    w = 2 + ascWidth[str.charAt(0)];
                } else {
                    w += ascWidth[str.charAt(0)];
                    m_strBuffer.append(str);
                }

                continue;
            } else if (str.equals("\n")) {
                vLines.addElement(m_strBuffer.toString());
                m_strBuffer.delete(0, m_strBuffer.length());
                w = 2;

                continue;
            } else {
                boolean bFlag = judgePureISOchars(str);

                if (bFlag) {
                    l = getStringWidth(str);
/*
                    if (l >= iWidth) {
                        //  Do stuff in here.
                    }
*/
                    if ((w + l) >= iWidth) {
                        vLines.addElement(m_strBuffer.toString());
                        m_strBuffer.delete(0, m_strBuffer.length());
                        m_strBuffer.append(str);
                        w = 2 + l;

                        continue;
                    } else {
                        w += l;
                        m_strBuffer.append(str);

                        continue;
                    }
                } else {
                    for (int j = 0; j < str.length(); j++) {
                        boolean boolIso1 = (str.charAt(j) < 0xff);

                        if (boolIso1) { // iso8859-1 chars
                            w += ascWidth[str.charAt(j)];
                        } else { // asia char
                            w += hzWidth;
                        }

                        if (w >= iWidth) {
                            vLines.addElement(m_strBuffer.toString());
                            m_strBuffer.delete(0, m_strBuffer.length());
                            m_strBuffer.append(str.charAt(j));
                            w = boolIso1 ? (2 + ascWidth[str.charAt(j)]) : (2 + hzWidth);
                        } else {
                            m_strBuffer.append(str.charAt(j));
                        }
                    }
                }
            }
        }

        if (m_strBuffer.length() != 0) {
            vLines.addElement(m_strBuffer.toString());
        }
    }

    private void calculateBasicInfo() {
        preparePaintLikeLabel();
        iLines = vLines.size();
        iHeight = (iLines * iChHeight) + getYOffset();
    }

    public void paint(Graphics g) {
        g.setFont(font);

        if (isSelect) {
            g.setColor(selColor);
            g.fillRect(0, 0, iWidth, iHeight);
        } else {
            g.setColor(defColor);
            g.fillRect(0, 0, iWidth, iHeight);
        }

        g.setColor(java.awt.Color.black);

        for (int i = 0; i < iLines; i++) {
            g.drawString((String)vLines.get(i), 0, (iChHeight * i) + getYOffset());
        }
    }

    public void setSelectStatus(boolean bFlag) {
        isSelect = bFlag;
    }

    public Dimension getPreferredSize() {
        return new Dimension(iWidth, iHeight);
    }

    public void setHeight(int iHeight) {
        this.iHeight = iHeight;
    }

    public int getHeight() {
        return iHeight;
    }

    public void setWidth(int iWidth) {
        this.iWidth = iWidth;
        calculateBasicInfo();
    }

    public String getText() {
        return strInput;
    }

    public void setNewFont(java.awt.Font font) {
        super.setFont(font);
        this.font = font;
        mx = Toolkit.getDefaultToolkit().getFontMetrics(font);
        ascWidth = mx.getWidths();
        iChHeight = mx.getHeight();
        hzWidth = mx.stringWidth("\u4e00");

        calculateBasicInfo();
    }

    protected int getYOffset() {
        return (mx.getMaxAscent() + mx.getLeading());
    }
}
