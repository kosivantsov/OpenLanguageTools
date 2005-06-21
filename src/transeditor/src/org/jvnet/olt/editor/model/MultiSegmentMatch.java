/*
 * Copyright  2005 Sun Microsystems, Inc.
 * All rights reserved Use is subject to license terms.
 *
 */
package org.jvnet.olt.editor.model;

import java.util.*;
import java.util.logging.Logger;

import org.jvnet.olt.editor.translation.AlignmentMain;

/**
 * <p>Title: Multi Segments Match</p>
 */
import org.jvnet.olt.editor.translation.Backend;
import org.jvnet.olt.editor.translation.DocumentUndoableEdit;
import org.jvnet.olt.editor.translation.MainFrame;
import org.jvnet.olt.xliff.*;

import org.omg.CosNaming.IstringHelper;


public class MultiSegmentMatch extends Match {
    private static final Logger logger = Logger.getLogger(MultiSegmentMatch.class.getName());
    protected int sourceQuantity;
    protected int targetQuantity;

    public MultiSegmentMatch(XLIFFBasicSentence xlfSrcInput, XLIFFBasicSentence xlfTgtInput, String aMatchQualityInput, String aFormatDiffInput, String aMatchType) {
        super(xlfSrcInput, xlfTgtInput, aFormatDiffInput, aMatchQualityInput);

        int colonLoc = aMatchType.indexOf(":");

        //logger.finer("aMatchType="+aMatchType+" "+aMatchType.substring(0,colonLoc)+"|"+aMatchType.substring(colonLoc+1));
        sourceQuantity = Integer.parseInt(aMatchType.substring(0, colonLoc));
        targetQuantity = Integer.parseInt(aMatchType.substring(colonLoc + 1));
    }

    public String getMatchStyle() {
        return sourceQuantity + ":" + targetQuantity;
    }

    public int getSrcSegmentNumber() {
        return sourceQuantity;
    }

    public void handleWhenSelected() {
        //logger.finer("it is multi segment match ...");
        int currentSelectRow = AlignmentMain.testMain1.curRow;
        AlignmentMain.testMain1.getTableView().setRowSelectionInterval(currentSelectRow, (currentSelectRow + sourceQuantity) - 1);
        AlignmentMain.testMain2.getTableView().setRowSelectionInterval(currentSelectRow, (currentSelectRow + sourceQuantity) - 1);
    }

    /**
     * @param iSentenceID  the row number of the table
     * @param iTransType   the translation type ("EXACT_TRANSLATION","AUTO_TRANSLATION","FUZZY_TRANSLATION")
     * @param iApplyType   the apply type ("EXACTAUTOMATCH","AUTOPROPAGATE","TRANSFER")
     */
    public void handleAsAppliedMatch(int iSentenceID, int iTransType, int iApplyType) {
        //logger.finer("handleAsAppliedMatch() ...");
        Backend backend = Backend.instance();
        TMData tmpdata = backend.getTMData();

        TMData.TMSentence x = tmpdata.tmsentences[iSentenceID];

        handleAsAppliedMatch(x, iTransType, iApplyType);
    }

    public void handleAsAppliedMatch(TMData.TMSentence sntnc, int iTransType, int iApplyType) {
        Backend backend = Backend.instance();
        TMData tmpdata = backend.getTMData();

        TMData.TMSentence tms = null;
        TMData.TMSentence firsttms = sntnc;

        String theID = null;
        String firstID = firsttms.getTransUintID();
        String oldString = null;
        String newString = null;
        Vector undoObject = null;
        int oldType = 0;
        int newType = 0;

        StringBuffer theSource = new StringBuffer();

        /**
         * Adding new group into tracking object
         */
        int iSentenceID = sntnc.getSentenceID();
        ArrayList theGroup = new ArrayList();

        for (int i = 0; i < sourceQuantity; i++) {
            tms = tmpdata.tmsentences[iSentenceID + i];
            theID = tms.getTransUintID();
            theGroup.add(theID);
            tmpdata.groupTracking.addSentence(theID, (iSentenceID + i), tms.getTranslation(), tms.getTranslationStatus(), tms.getTranslationType());
            theSource.append(tms.getSource() + " ");
        }

        tmpdata.groupTracking.addGroup(firstID, theGroup, true);
        tmpdata.getGroupTrack().setShownAsGrouped(true);

        if (iApplyType == TRANSFER) {
            undoObject = new Vector();
        }

        for (int i = 0; i < sourceQuantity; i++) {
            tms = tmpdata.tmsentences[iSentenceID + i];

            /**
             * For undo if using "TRANSFER"
             */
            if (iApplyType == TRANSFER) {
                oldString = tms.getTranslation();
                oldType = (tms.getTranslationStatus() * 10) + tms.getTranslationType();
            }

            /**
             * Apply match
             */
            if (i == 0) {
                if (iMatchQuality >= 100) {
                    tms.setTranslation(getMatchTranslation());
                    tms.setAutoTranslated(true);
                } else {
                    SimpleSentence s = new SimpleSentence(theSource.toString(), this.getLRDS(), this.getLRDT());
                    tms.setTranslation(s.getValue());
                    tms.setAutoTranslated(false);
                }
            } else {
                tms.setTranslation(new String(" "));

                if (iMatchQuality >= 100) {
                    tms.setAutoTranslated(true);
                } else {
                    tms.setAutoTranslated(false);
                }
            }

            /**
             * for undo if using "TRANSFER"
             */
            if (iApplyType == TRANSFER) {
                newString = tms.getTranslation();
                newType = (TMData.TMSentence.TRANSLATED * 10) + iTransType;
                undoObject.add(new Object[] {
                        new Integer(iSentenceID + i), new Integer(0), new String(oldString),
                        new String(newString), new Integer(oldType), new Integer(newType)
                    });
            }
        }

        /**
         * update the status and type
         */
        for (int i = 0; i < sourceQuantity; i++) {
            tms = tmpdata.tmsentences[iSentenceID + i];
            tms.setTranslationStatus(TMData.TMSentence.TRANSLATED);
            tms.setTranslationType(iTransType);
        }

        /**
         * Push into undo object
         */
        if (iApplyType == TRANSFER) {
            DocumentUndoableEdit edit = new DocumentUndoableEdit(false, "Transfer " + getMatchStyle(), iSentenceID, 0, undoObject, theGroup);
            MainFrame.undo.addDocumentEdit(edit);
        }
    }
}
