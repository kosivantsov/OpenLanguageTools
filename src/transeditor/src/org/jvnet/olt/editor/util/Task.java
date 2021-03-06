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
 * Task.java
 *
 * Created on July 18, 2005, 4:42 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package org.jvnet.olt.editor.util;

import javax.swing.SwingUtilities;

/**
 *
 * @author boris
 */
abstract public class Task {
    
    /** Creates a new instance of Task */
    public Task() {
    }
    
    abstract protected void execute();
    
    public void start(){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                execute();
            }
        });
    }
}
