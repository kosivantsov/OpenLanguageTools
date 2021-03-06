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
/*
 * XLIFFModel.java
 *
 * Created on April 20, 2005, 4:43 PM
 *
 */
package org.jvnet.olt.xliff;

import java.util.Collection;
import java.util.Map;


/**
 *
 * @author boris
 */
public interface XLIFFModel {
    public int getSize();

    public Map getGroupZeroSource();

    public Map getGroupZeroTarget();

    public Map getGroupAltTrans();

    public String getSourceLanguage();

    public String getTargetLanguage();

    public void setTargetLanguage(String tgtLang);

    public String getProcessName();

    public String getPhaseName();

    public String getToolName();

    public String getOriginalDataType();

    public TrackingGroup getGroupTrack();

    public TrackingComments getCommentsTrack();

    public AttributesFactory getAttrFactory();

    public TrackingSourceContext getSourceContextTrack();

    //insertion ordered collection of Ids
    public Collection getIDArray();

    public void populate(org.jvnet.olt.format.GlobalVariableManager gvm);

    public Version getVersion();
}
