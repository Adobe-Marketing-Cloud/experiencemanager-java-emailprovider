/*
 *   Copyright 2013 Adobe
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.day.cq.xemailservice.auth;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

/**
 * This class implements a WS-Security password handler for WebService.
 */
public class AuthenticationHandler implements CallbackHandler {

    private String password = null;

    /**
     * Default constructor
     */
    public AuthenticationHandler() {
    }

    /**
     * Constructor that takes the password as parameter.
     * 
     * @param password The password
     */
    public AuthenticationHandler(String password) {
        this.password = password;
    }

    /**
     * This function handles the callbacks and assigns the password if the callback is a WSPasswordCallback.
     */
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        //TODO: Provide your own implementation as per usecase
    }
}