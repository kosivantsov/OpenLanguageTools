/*
 * ASpellCustomizerPanel.java
 *
 * Created on December 13, 2006, 3:52 PM
 */

package org.jvnet.olt.editor.spellchecker;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import org.jvnet.olt.editor.util.Languages;

/**
 *
 * @author  boris
 */
public class ASpellCustomizerPanel extends javax.swing.JPanel {
    
    private ASpellChecker checker;
    
    private LanguageMappingTableModel languageTableModel;
    
    private Map<String,String> mappingTable = new HashMap<String,String>();
    
    /** Creates new form ASpellCustomizerPanel */
    public ASpellCustomizerPanel(ASpellChecker checker,final Map<String,String> mappingTable){
        this.checker= checker;
        this.mappingTable = mappingTable;
        
        
        languageTableModel = new LanguageMappingTableModel(mappingTable);
        
        initComponents();
        languageMappingTable.setModel(languageTableModel);
        commandTextField.setText(checker.getDefaultCommand());
        
        
        String colName = languageMappingTable.getColumnName(0);
        languageMappingTable.getColumn(colName).setCellEditor(
                new DefaultCellEditor(
                new JComboBox(
                Languages.getLanguages())));
        
        languageMappingTable.getColumn("Spellchecker language").setCellEditor(
                new DefaultCellEditor(new JTextField()));
        
        languageMappingTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                removeButton.setEnabled( languageMappingTable.getSelectedRowCount() > 0);
            }
        });
        
    }
    
    void setASpellChecker(ASpellChecker checker){
        this.checker = checker;
        
        
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        commandTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        scrollPane1 = new javax.swing.JScrollPane();
        languageMappingTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();

        jLabel1.setText("Aspell command");

        jLabel2.setText("Placeholders: ");

        jLabel3.setText("${EDITOR_HOME} editor installation directory");

        jLabel4.setText("${USER_HOME} user's home directory location ");

        scrollPane1.setViewportView(languageMappingTable);

        jLabel5.setText("Language Mapping table");

        jLabel6.setText("${PROJECT_LANG} the project target language (fr-FR,de-DE etc)");

        jLabel7.setText("${TRANS_PROJECT_LANG} translated project lang. \nfrom the lang. mapping table");

        resetButton.setText("Reset to defaults");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel2)
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(commandTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(resetButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel6)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel4)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel3)
                        .add(jLabel7))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel5)
                    .add(layout.createSequentialGroup()
                        .add(scrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(addButton)
                            .add(removeButton))))
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {addButton, removeButton}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(commandTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(resetButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel3)
                .add(4, 4, 4)
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel6)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel7)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel5)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(addButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(removeButton))
                    .add(scrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 157, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
// TODO add your handling code here:
        int[] rows = languageMappingTable.getSelectedRows();
        languageTableModel.removeRows(rows);
    }//GEN-LAST:event_removeButtonActionPerformed
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        languageTableModel.addRow(Languages.NO_LANGUAGE," -- ");
        languageMappingTable.clearSelection();
        languageMappingTable.editCellAt(languageTableModel.getRowCount()-1,0);
    }//GEN-LAST:event_addButtonActionPerformed
    
    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        commandTextField.setText(checker.makeDefaultCommand());
        // TODO add your handling code here:
    }//GEN-LAST:event_resetButtonActionPerformed
    
    JTextField getCommandTextField(){
        return commandTextField;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField commandTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable languageMappingTable;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JScrollPane scrollPane1;
    // End of variables declaration//GEN-END:variables
    
}
