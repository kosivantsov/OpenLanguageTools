
/*
 * Copyright  2005 Sun Microsystems, Inc. 
 * All rights reserved Use is subject to license terms.
 *
 */

/*
 * File:           XliffHandler.java
 * Date:           July 24, 2004  3:24 PM
 *
 * @author  timf
 * @version generated by NetBeans XML module
 */
package org.jvnet.olt.filters.intstaroffice.xliff;

import org.xml.sax.*;

public interface XliffHandler {
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_mrk(final Attributes meta) throws SAXException;
    
    /**
     *
     * A data element event handling method.
     * @param data value or null
     * @param meta attributes
     */
    public void handle_mrk(final java.lang.String data, final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_mrk() throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_bin_unit(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_bin_unit() throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_sub(final Attributes meta) throws SAXException;
    
    /**
     *
     * A data element event handling method.
     * @param data value or null
     * @param meta attributes
     */
    public void handle_sub(final java.lang.String data, final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_sub() throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_file(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_file() throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_target(final Attributes meta) throws SAXException;
    
    /**
     *
     * A data element event handling method.
     * @param data value or null
     * @param meta attributes
     */
    public void handle_target(final java.lang.String data, final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_target() throws SAXException;
    
    /**
     *
     * A data element event handling method.
     * @param data value or null
     * @param meta attributes
     */
    public void handle_internal_file(final java.lang.String data, final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_xliff(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_xliff() throws SAXException;
    
    /**
     *
     * An empty element event handling method.
     * @param data value or null
     */
    public void handle_bx(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_prop_group(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_prop_group() throws SAXException;
    
    /**
     *
     * A data element event handling method.
     * @param data value or null
     * @param meta attributes
     */
    public void handle_context(final java.lang.String data, final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_skl(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_skl() throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_trans_unit(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_trans_unit() throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_phase(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_phase() throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_body(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_body() throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_group(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_group() throws SAXException;
    
    /**
     *
     * A data element event handling method.
     * @param data value or null
     * @param meta attributes
     */
    public void handle_prop(final java.lang.String data, final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_ept(final Attributes meta) throws SAXException;
    
    /**
     *
     * A data element event handling method.
     * @param data value or null
     * @param meta attributes
     */
    public void handle_ept(final java.lang.String data, final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_ept() throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_header(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_header() throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_ph(final Attributes meta) throws SAXException;
    
    /**
     *
     * A data element event handling method.
     * @param data value or null
     * @param meta attributes
     */
    public void handle_ph(final java.lang.String data, final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_ph() throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_g(final Attributes meta) throws SAXException;
    
    /**
     *
     * A data element event handling method.
     * @param data value or null
     * @param meta attributes
     */
    public void handle_g(final java.lang.String data, final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_g() throws SAXException;
    
    /**
     *
     * A data element event handling method.
     * @param data value or null
     * @param meta attributes
     */
    public void handle_note(final java.lang.String data, final Attributes meta) throws SAXException;
    
    /**
     *
     * An empty element event handling method.
     * @param data value or null
     */
    public void handle_ex(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_phase_group(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_phase_group() throws SAXException;
    
    /**
     *
     * An empty element event handling method.
     * @param data value or null
     */
    public void handle_external_file(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_alt_trans(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_alt_trans() throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_context_group(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_context_group() throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_bpt(final Attributes meta) throws SAXException;
    
    /**
     *
     * A data element event handling method.
     * @param data value or null
     * @param meta attributes
     */
    public void handle_bpt(final java.lang.String data, final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_bpt() throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_it(final Attributes meta) throws SAXException;
    
    /**
     *
     * A data element event handling method.
     * @param data value or null
     * @param meta attributes
     */
    public void handle_it(final java.lang.String data, final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_it() throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_count_group(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_count_group() throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_bin_source(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_bin_source() throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_glossary(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_glossary() throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_source(final Attributes meta) throws SAXException;
    
    /**
     *
     * A data element event handling method.
     * @param data value or null
     * @param meta attributes
     */
    public void handle_source(final java.lang.String data, final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_source() throws SAXException;
    
    /**
     *
     * A data element event handling method.
     * @param data value or null
     * @param meta attributes
     */
    public void handle_count(final java.lang.String data, final Attributes meta) throws SAXException;
    
    /**
     *
     * An empty element event handling method.
     * @param data value or null
     */
    public void handle_x(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_bin_target(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_bin_target() throws SAXException;
    
    /**
     *
     * A container element start event handling method.
     * @param meta attributes
     */
    public void start_reference(final Attributes meta) throws SAXException;
    
    /**
     *
     * A container element end event handling method.
     */
    public void end_reference() throws SAXException;
    
    /**
     * Determines if the parsed XLIFF file is one produced
     * directly from the StarOffice database
     * @return true if the parsed file was produced from the internal SO DB
     */
    public boolean isInternalStarOfficeXLIFF();
}

