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

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

import com.synapse.scada.core.Server;
import com.synapse.scada.core.SynapseException;
import com.synapse.scada.core.SynapseServer;

/**
 * The Class Service.
 *
 * @author Tomek Kozlowski (rysiekblah)
 * @version 1.00 (Nov 9, 2012)
 */
public class Service extends Thread {

    /** The LOG. */
    static Logger LOG = Logger.getLogger(Service.class.getName());
    
    /** The server body. */
    Server synapseCore;

    /**
     * Instantiates a new server.
     *
     * @param server the body
     */
    public Service(Server server) {
        synapseCore = server;
    }
    
    /**
     * Inits the.
     *
     * @throws ServerException the server exception
     */
    public void init() throws ServerException {
        
        LOG.debug("Server initialization");
        
        try {
            synapseCore.create();
        } catch (SynapseException e) {
            LOG.error("Server initialization FAILED");
            throw new ServerException(e.getMessage());
        }
    }

    /**
     * Run.
     */
    public void run() {

        LOG.info("Start synapse server");
        
        try {
            
            synapseCore.start();

        } catch (SynapseException e) {
            LOG.error("Server startup FAILED", e);
        }
    }
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        PropertyConfigurator.configure("log.properties");
        Server server = new SynapseServer();
        Service service = new Service(server);
        try {
            service.init();
            Runtime rt = Runtime.getRuntime();
            rt.addShutdownHook(new ServerShutDown(server));
            service.start();
        } catch (ServerException e) {
            LOG.error("Server FAILED", e);
        }
    }
}
