/********************************************************************************
 * 
 *  Copyright 2012 Synapse SCADA team
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  
 *******************************************************************************/
package com.synapse.scada.server;


import org.apache.log4j.Logger;

import com.synapse.scada.core.Server;
import com.synapse.scada.core.SynapseException;

/**
 * The Class ServerShutDown.
 *
 * @author Tomek Kozlowski (rysiekblah)
 * @version 1.00 (Nov 9, 2012)
 */
public class ServerShutDown extends Thread {

    /** The LOG. */
    static Logger LOG = Logger.getLogger(ServerShutDown.class);
    
    /** The body. */
    Server body;

    /**
     * Instantiates a new server shut down.
     *
     * @param body the body
     */
    ServerShutDown(Server body) {
        LOG.debug("Creation shodown hook");
        this.body = body;
    }

    /* (non-Javadoc)
     * @see java.lang.Thread#run()
     */
    public void run() {
        LOG.debug("Run shutdown hook");
         try {
            body.stop();
        } catch (SynapseException e) {
            LOG.error("Server deactivation FAILED", e);
        }
        LOG.info("Server has been stoped and cleaned");
    }
}
