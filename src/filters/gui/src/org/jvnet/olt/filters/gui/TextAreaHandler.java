
/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */

package org.jvnet.olt.filters.gui;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/** Log handler that logs into a textarea.
 *
 * @author boris
 */
public class TextAreaHandler extends Handler{
    /**
     * target text area
     */
    private JTextArea area;
    /**
     * default formatter
     */
    private SimpleFormatter formatter = new SimpleFormatter();
    
    class SimpleFormatter extends Formatter{
        StringBuffer sb = new StringBuffer(200);
        
        public String format(java.util.logging.LogRecord record) {
            return fmt(record).toString();
        }
        
        /**
         * internal format implementation
         */
        private StringBuffer fmt(LogRecord rec){
            sb.delete(0,sb.length());
            sb.append(rec.getLevel().getName());
            sb.append(": ");
            sb.append(rec.getMessage());
            
            return sb;
        }
        
    }
    
    /**
     * Creates a new instance of TextAreaLogger
     * @param area Text are to receive messages
     */
    public TextAreaHandler(JTextArea area) {
        this.area = area;
    }
    
    /**
     * publish the logrecrod
     * @param record log record to publish
     */
    public void publish(final java.util.logging.LogRecord record) {
        if(record == null)
            return;
        
        if(area != null ){
            final String msg = formatter.format(record)+"\n";
            
            
            SwingUtilities.invokeLater(new Runnable(){
                public void run() {                    
                    area.append(msg);                    
                    area.setCaretPosition(area.getText().length());
                }
                
                
            });
        }
    }
    
    /**
     * create default formatter
     * @return returns TextAreaHandler.SimpleFormatter instance
     */
    public java.util.logging.Formatter getFormatter() {
        return formatter;
    }
    
    /**
     * method from parent.
     *
     * Does nothing
     * @throws java.lang.SecurityException never thrown.
     */
    public void close() throws SecurityException {
    }
    
    /**
     * method from parent.
     *
     * Does nothing.
     */
    public void flush() {
    }
    
    
    
}
