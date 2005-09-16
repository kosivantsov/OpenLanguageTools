
/*
 * Copyright  2005 Sun Microsystems, Inc.
 * All rights reserved Use is subject to license terms.
 *
 */

/*
 * XliffFilterGUI.java
 *
 * Created on May 17, 2005, 10:35 AM
 */
package org.jvnet.olt.filters.gui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetListener;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.dnd.DnDConstants;
import java.io.FileInputStream;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;

/**
 * Simple GUI code to do drag & drop XLIFF Conversion. Tested and works on
 * GNOME, Mac OSX and Win32 (XP professional, I think, but can't remember) Other
 * platforms may not work - the way of doing native app to java drag and drop
 * doesn't seem to be terribly coherent, so this may need work. Also need to look
 * at configuration and user preferences : right now, there are none !
 * @author  timf
 */
public class XliffFilterGUI extends javax.swing.JFrame implements DropTargetListener {
    
    private DropFileExtractor extr =  new DropFileExtractor();
    private boolean firstShowConfig = true;
    private boolean firstShowLog = true;
    private Map attributes = null;
    // underlying preferences store for the attributes
    // currently, these need to be synchronised manually
    // by the programmer when changing attribute values - see setAttribute(Object key, Object value)
    private Preferences prefs = null;
    
    // for testing
    // private Map attributes = new HashMap();
    // {
    //   attributes.put("xxx", "yyyy");
    //   attributes.put("Hello", "Dolly");
    // }
    private String resourcesDir = null;
    
    //height of log when first 'Show Log'/'Show Config' button hit first time
    private int PREFFERED_HEIGHT = 200;
    
    /** Creates new form XliffFilterGUI */
    public XliffFilterGUI(String resourcesDir) {
        // for convenience, we just use the default logger.
        logger = Logger.getLogger("Conversion");
        
        this.resourcesDir = resourcesDir;
        this.attributes = getUserPreferences();
        initComponents();
        //add textarea log handler
        logger.addHandler(new TextAreaHandler(logTextArea));
        
        // make a drop target that uses this as it's lister
        DropTarget d = new DropTarget((Component)jLabel1, (DropTargetListener)this);
        d.setActive(true);
        
        
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setVisible(false);
        setShowLogBtnText();
        logTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        showConfigBtn = new javax.swing.JButton();
        showLogBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane2.setVisible(false);
        setShowConfigBtnText();

        jTable1 = new javax.swing.JTable();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Open Language Tools XLIFF Filters");
        jScrollPane1.setDoubleBuffered(true);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(200, 100));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(150, 200));
        logTextArea.setEditable(false);
        logTextArea.setLineWrap(true);
        logTextArea.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(logTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(xliffFilterGUIMessages.getString("Drop_files_here"));
        jLabel1.setBorder(new javax.swing.border.TitledBorder("Open Language Tools XLIFF Filters"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 15, 5);
        getContentPane().add(jLabel1, gridBagConstraints);

        showConfigBtn.setText(java.util.ResourceBundle.getBundle("org/jvnet/olt/filters/gui/XliffFilterGUIMessages").getString("Show_Config_>>>"));
        showConfigBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showConfigBtnActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(showConfigBtn, gridBagConstraints);

        showLogBtn.setText(xliffFilterGUIMessages.getString("Show_log_>>>"));
        setShowConfigBtnText();
        showLogBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showLogBtnActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(showLogBtn, gridBagConstraints);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(150, 200));
        jTable1.setModel(getTableModel());
        jTable1.setPreferredSize(new java.awt.Dimension(200, 150));
        jScrollPane2.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        getContentPane().add(jScrollPane2, gridBagConstraints);

        pack();
    }
    // </editor-fold>//GEN-END:initComponents
    
    private void showConfigBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showConfigBtnActionPerformed
// TODO add your handling code here:
        //Show / hide config button action
        boolean newState = !jScrollPane2.isVisible();
        jScrollPane2.setVisible(! jScrollPane2.isVisible());
        int height = (int)jScrollPane2.getSize().getHeight();
        if(firstShowConfig){
            height = PREFFERED_HEIGHT;
            firstShowConfig = false;
        }
        
        Dimension d = getSize();
        d.setSize(d.getWidth(),d.getHeight() + (newState ? 1 : -1) * height);
        setSize(d);
        setShowConfigBtnText();
        updateLableLayout();
        repaint();
        pack();
    }//GEN-LAST:event_showConfigBtnActionPerformed
    
    private void showLogBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showLogBtnActionPerformed
        
        //Show / hide log button action
        
        boolean newState = !jScrollPane1.isVisible();
        jScrollPane1.setVisible(! jScrollPane1.isVisible());
        int height = (int)jScrollPane1.getSize().getHeight();
        if(firstShowLog){
            height = PREFFERED_HEIGHT;
            firstShowLog = false;
        }
        
        Dimension d = getSize();
        d.setSize(d.getWidth(),d.getHeight() + (newState ? 1 : -1) * height);
        setSize(d);
        setShowLogBtnText();
        updateLableLayout();
        repaint();
        pack();
        
    }//GEN-LAST:event_showLogBtnActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        final String resourcesDir = args[0];
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                XliffFilterGUI gui = new XliffFilterGUI(resourcesDir);
                gui.setVisible(true);
            }
        });
        
    }
    
    public void dragEnter(DropTargetDragEvent dtde) {
        // System.out.println("Drag Enter event");
    }
    
    public void dragExit(DropTargetEvent dte) {
        // System.out.println("Drag Exit event");
    }
    
    public void dragOver(DropTargetDragEvent dtde) {
        /// System.out.println("Drag over event");
    }
    
    /**
     * This is the event that gets called when a user drops a file on
     * top of the label saying "drop files here" - it's action is to
     * extract the filename the user has dropped on the label, and
     * kick off a XliffFilterRunner to convert the file to xliff which
     * then makes a callback to this class to display a dialog box.
     */
    public void drop(java.awt.dnd.DropTargetDropEvent dtde) {
        if (this.attributes == null){
            this.logger.log(Level.SEVERE,xliffFilterGUIMessages.getString("WARNING_:_Filter_attributes_not_configured_!"));
        }
        
        dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
        
        List files = extr.extractFiles(dtde);
        if (files.isEmpty()){
            this.logger.log(Level.SEVERE, xliffFilterGUIMessages.getString("ERROR_:_No_files_found_from_drop_target_!"));
            showCompletionDialog(false);
        } else {
            convertFiles(files);
        }
    }
    
    /**
     * Do the actual task of kicking off a converter for each file in the fileList
     * @param fileList the list of Files to be converted to XLIFF
     */
    private void convertFiles(List fileList){
        
        XliffFilterStarter starter = new XliffFilterStarter(fileList, attributes, this.logger, new UICallback(){
            
            public void start(){
                SwingUtilities.invokeLater(new Runnable(){
                    public void run(){
                        XliffFilterGUI.this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    }
                });
            }
            
            public void startFile(File f) {
                logger.info(MessageFormat.format(
                        xliffFilterGUIMessages.getString("Processing_file_o"),
                        new Object[] {f.getAbsolutePath()}));
            }
            
            public void doneFile() {
            }
            
            public void doneAll(final int failed) {
                SwingUtilities.invokeLater(new Runnable(){
                    public void run(){
                        XliffFilterGUI.this.setCursor(Cursor.getDefaultCursor());
                        
                        showCompletionDialog(failed == 0 );
                    }
                });
            }
        });
        
        starter.runFilters();
        
    }
    
    
    /**
     * Show a dialog that says we've completed processing of a given file with
     * a (hopefully) meaningful error message.
     * @param file the file we've just converted (or tried to)
     * @param success true if the conversion was successful
     */
    protected void showCompletionDialog(boolean success){
        if (success){
            JOptionPane.showMessageDialog((Component)this,
                    xliffFilterGUIMessages.getString("All_files_were_converted_successfuly"),
                    "Open Language Tools XLIFF Filters",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog((Component)this,
                    xliffFilterGUIMessages.getString("Conversion_of_some_of_the_files_failed_-_see_log_file_for_more_information."),
                    "Open Language Tools XLIFF Filters",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
    public void dropActionChanged(DropTargetDragEvent dtde) {
        // System.out.println("Drop action changed");
    }
    
    private void setShowLogBtnText(){
        if(showLogBtn != null && jScrollPane1 != null)
            showLogBtn.setText(jScrollPane1.isVisible() ? xliffFilterGUIMessages.getString("_Hide_log_<<<") : xliffFilterGUIMessages.getString("Show_log_>>>"));
    }
    
    private void setShowConfigBtnText(){
        if(showConfigBtn != null && jScrollPane2 != null)
            showConfigBtn.setText(jScrollPane2.isVisible() ? xliffFilterGUIMessages.getString("Hide_Config_<<<") : xliffFilterGUIMessages.getString("Show_Config_>>>"));
    }
    
    private void updateLableLayout(){
        boolean visible = jScrollPane1.isVisible();
        
        GridBagLayout layout = (GridBagLayout)getContentPane().getLayout();
        GridBagConstraints c = layout.getConstraints(jLabel1);
        c.weighty = visible ? 0.0 : 1.0;
        
        layout.setConstraints(jLabel1,c);
    }
    
    
    private TableModel getTableModel(){
        if (this.attributes != null){
            UserPrefsTableModel model = new UserPrefsTableModel(this.attributes, this);
            return model;
        } else {
            this.logger.log(Level.SEVERE, "WARNING, trying to set table model when attributes are empty!");
            return null;
        }
    }
    
    /**
     * Here's where we need to set/configure user preferences : we return a map
     * of key/value pairs that we can use to configure the filters.
     * @return a Map containing key/value pairs
     */
    private Map getUserPreferences(){
        
        Map attribs = new HashMap();
        this.prefs = Preferences.userNodeForPackage(XliffFilterGUI.class);
        attribs.put("source.language",
                prefs.get("source.language", "en-US"));
        attribs.put("file.encoding",
                prefs.get("file.encoding",  System.getProperty("file.encoding")));
        attribs.put("xml.config.dtd",
                prefs.get("xml.config.dtd",
                resourcesDir+File.separator+"xml-config.dtd"));
        attribs.put("xml.config.dir",
                prefs.get("xml.config.dir",
                resourcesDir+File.separator+".xml-config-store"));
        
        // now save our preferences back to the underlying store if needed
        prefs.put("source.language", (String)attribs.get("source.language"));
        prefs.put("file.encoding", (String)attribs.get("file.encoding"));
        prefs.put("xml.config.dtd", (String)attribs.get("xml.config.dtd"));
        prefs.put("xml.config.dir",  (String)attribs.get("xml.config.dir"));
        
        //boolean configuredXmlStore = prefs.getBoolean("configured.xml.config", false);
        
        //if (!configuredXmlStore){
/*
        try {
            XliffFilterFacade.updateXmlConfigRepository(resourcesDir+File.separator+"xml-config",
                    resourcesDir+File.separator+".xml-config-store",
                    resourcesDir+File.separator+"xml-config.dtd");
 
            prefs.putBoolean("configured.xml.config", true);
        } catch (XliffFilterFacadeException e){
            this.logger.log(Level.SEVERE,xliffFilterGUIMessages.getString("Problem_configuring_XML_filter!"),e);
        }
 */
        //}
        return attribs;
    }
    
    public String getResourcesDir(){
        if (this.resourcesDir == null){
            this.logger.log(Level.SEVERE,xliffFilterGUIMessages.getString("WARNING_!_No_resources_file_defined_!"));
        }
        return this.resourcesDir;
    }
    
    public void setResourcesDir(String resourcesDir){
        this.resourcesDir = resourcesDir;
        this.attributes = getUserPreferences();
    }
    
    /**
     * used to set key/value pairs that are passed into the filters
     * conversion proper
     */
    protected void setAttribute(Object key, Object value){
        this.attributes.put(key, value);
        this.prefs.put((String)key, (String)value);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea logTextArea;
    private javax.swing.JButton showConfigBtn;
    private javax.swing.JButton showLogBtn;
    // End of variables declaration//GEN-END:variables
    /** A logger we can use to capture logging output with
     */
    private Logger logger = null;
    
    private static final java.util.ResourceBundle xliffFilterGUIMessages = java.util.ResourceBundle.getBundle("org/jvnet/olt/filters/gui/XliffFilterGUIMessages");
}
