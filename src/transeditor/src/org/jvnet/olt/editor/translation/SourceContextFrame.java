
/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */

/*
 * SourceContextFrame.java
 *
 * Created on October 5, 2004, 3:41 PM
 */

package org.jvnet.olt.editor.translation;
import org.jvnet.olt.editor.util.Bundle;
import org.jvnet.olt.xliff.TrackingSourceContext;

import java.util.Map;
import java.util.Iterator;


/**
 *
 * @author  timf
 */
public class SourceContextFrame extends javax.swing.JFrame {
    private Bundle bundle = Bundle.getBundle(SourceContextFrame.class.getName());

    /** Creates new form SourceContextFrame */
    public SourceContextFrame() {
        initComponents();
        setTitle(Constants.TOOL_NAME);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), bundle.getString("Source_Text_Context_Information")));
        jPanel1.setToolTipText(bundle.getString("Context_information_describing_the_source_language_string_currently_selected."));
        jPanel1.setAutoscrolls(true);
        jPanel1.setName("");
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 180));
        jTextPane1.setEditable(false);
        jTextPane1.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(jTextPane1);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SourceContextFrame().setVisible(true);
                //System.out.println("foo");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables


    /**
     * This sets the content of the text pane to show the context
     * information for this segment. There's no formatting applied
     * to this at the moment, perhaps a future enhancement would be
     * to have a nicely styled document to be displayed
     *
     */
    public void setContextInformation(Map contextInformation){

        StringBuffer buf = new StringBuffer();
        Iterator it = contextInformation.entrySet().iterator();

        while (it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            TrackingSourceContext.SourceContextKey key
                = (TrackingSourceContext.SourceContextKey )entry.getKey();

            buf.append(key.contextType+" = "+entry.getValue()+"\n");
        }
        this.jTextPane1.setText(buf.toString());
    }

}
