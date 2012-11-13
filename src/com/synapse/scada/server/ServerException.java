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

/**
 * The Class ServerException.
 *
 * @author Tomek Kozlowski (rysiekblah)
 * @version 1.00 (Nov 9, 2012)
 */
public class ServerException extends Exception {
    
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5712296326508636407L;


	/**
	 * Instantiates a new server exception.
	 */
	public ServerException() {
        super();
    }

   
    /**
     * Instantiates a new server exception.
     *
     * @param message the message
     */
    public ServerException(String message) {
        super(message);
    }
}
