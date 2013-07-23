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