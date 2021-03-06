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
 * BackconversionStatusCallback.java
 *
 * Created on February 4, 2005, 1:50 PM
 */
package org.jvnet.olt.editor.translation;

import java.io.File;


/**
 *
 * @author boris
 */
public interface BackconversionStatusCallback {
    public static final int ERROR_UNKNOWN  = -1;
    public static final int ERROR_TMX = 0;
    public static final int ERROR_BACKCONV = 1;
    public static final int ERROR_FRAMEFILE = 2;
    public static final int ERROR_NO_FILES = 3;

    public void conversionStart(int numFiles);

    public void fileStarted(File f);

    public void fileSuccess();

    public void fileError(int errorCode,Throwable t);

    public void conversionEnd();

    public void unlock();
}
