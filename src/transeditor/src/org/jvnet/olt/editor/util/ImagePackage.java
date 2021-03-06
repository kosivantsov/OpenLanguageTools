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

import java.awt.Image;

import javax.swing.ImageIcon;


public class ImagePackage {
    private static ImagePackage instance = null;

    /**
     * GUI gifs
     */
    public static ImageIcon imageOpen;
    public static ImageIcon imageSave;
    public static ImageIcon imageUpdate;
    public static ImageIcon imageHelp;
    public static ImageIcon imageNext;
    public static ImageIcon imagePrev;

    //public static ImageIcon imageClose;
    public static ImageIcon imageUndo;
    public static ImageIcon imageRedo;
    public static ImageIcon imageCopy;
    public static ImageIcon imagePaste;
    public static ImageIcon imageCut;
    public static ImageIcon imageSearch;
    public static ImageIcon imageMTAGNU;
    public static ImageIcon imageMVAGNT;
    public static ImageIcon imageSpellCheck;
    public static ImageIcon imageTagVerify;
    public static ImageIcon imageFind;
    public static ImageIcon imageUnTrans;
    public static ImageIcon imageComment;
    public static ImageIcon imageUpload;
    public static ImageIcon imageApproveFile;
    public static ImageIcon imageRejectFile;
    public static ImageIcon imageApproveSegment;
    public static ImageIcon imageRejectSegment;

    //translation status and type gifs
    public static ImageIcon[] statusIcon = new ImageIcon[4];
    public static ImageIcon[] typeIcon = new ImageIcon[6];

    private ImagePackage() {
        //init gifs in gui
        imageOpen = new ImageIcon(getClass().getResource("/gifs/Open.gif"));
        imageSave = new ImageIcon(getClass().getResource("/gifs/Save.gif"));
        imageUpdate = new ImageIcon(getClass().getResource("/gifs/MiniTM.gif"));
        imageHelp = new ImageIcon(getClass().getResource("/gifs/Help.gif"));
        imageNext = new ImageIcon(getClass().getResource("/gifs/Next.gif"));
        imagePrev = new ImageIcon(getClass().getResource("/gifs/Previous.gif"));

        imageUndo = new ImageIcon(getClass().getResource("/gifs/Undo.gif"));
        imageRedo = new ImageIcon(getClass().getResource("/gifs/Redo.gif"));
        imageCopy = new ImageIcon(getClass().getResource("/gifs/Copy.gif"));
        imagePaste = new ImageIcon(getClass().getResource("/gifs/Paste.gif"));
        imageCut = new ImageIcon(getClass().getResource("/gifs/Cut.gif"));
        imageSearch = new ImageIcon(getClass().getResource("/gifs/Search.gif"));
        imageMTAGNU = new ImageIcon(getClass().getResource("/gifs/Translated.gif"));
        imageMVAGNT = new ImageIcon(getClass().getResource("/gifs/Review.gif"));
        imageSpellCheck = new ImageIcon(getClass().getResource("/gifs/SpellCheck.gif"));
        imageTagVerify = new ImageIcon(getClass().getResource("/gifs/TagVerify.gif"));
        imageFind = new ImageIcon(getClass().getResource("/gifs/Find.gif"));

        imageComment = new ImageIcon(getClass().getResource("/gifs/Comment.gif"));
        imageUpload = new ImageIcon(getClass().getResource("/gifs/Upload.gif"));
        imageApproveFile = new ImageIcon(getClass().getResource("/gifs/AcceptFile.gif"));
        imageRejectFile = new ImageIcon(getClass().getResource("/gifs/RejectFile.gif"));
        imageApproveSegment = new ImageIcon(getClass().getResource("/gifs/AcceptSegment.gif"));
        imageRejectSegment = new ImageIcon(getClass().getResource("/gifs/RejectSegment.gif"));

        //Init translation type and status gifs;
        statusIcon[0] = new ImageIcon(new ImageIcon(getClass().getResource("/gifs/untrans.gif")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        statusIcon[1] = new ImageIcon(new ImageIcon(getClass().getResource("/gifs/trans.gif")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        statusIcon[2] = new ImageIcon(new ImageIcon(getClass().getResource("/gifs/verified.gif")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        statusIcon[3] = new ImageIcon(new ImageIcon(getClass().getResource("/gifs/rejected.gif")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));

        typeIcon[0] = new ImageIcon(new ImageIcon(getClass().getResource("/gifs/untrans.gif")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        typeIcon[1] = new ImageIcon(new ImageIcon(getClass().getResource("/gifs/exact.gif")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        typeIcon[2] = new ImageIcon(new ImageIcon(getClass().getResource("/gifs/auto.gif")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        typeIcon[3] = new ImageIcon(new ImageIcon(getClass().getResource("/gifs/fuzzy.gif")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        typeIcon[4] = new ImageIcon(new ImageIcon(getClass().getResource("/gifs/user.gif")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        typeIcon[5] = new ImageIcon(new ImageIcon(getClass().getResource("/gifs/user.gif")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
    }

    public static synchronized ImagePackage instance() {
        if (instance == null) {
            instance = new ImagePackage();
        }

        return instance;
    }
}
