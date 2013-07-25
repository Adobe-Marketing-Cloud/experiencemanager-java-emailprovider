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

package com.day.cq.xemailservice;

import com.day.cq.mcm.emailprovider.EmailServiceException;

/**
 * Exception that will be throws if there is any error from XEmailService
 */
public class XEmailServiceException extends EmailServiceException {

    /**
     * Default constructor
     */
    public XEmailServiceException() {

    }

    /**
     * Constructor that takes an error message.
     * 
     * @param message error message.
     */
    public XEmailServiceException(String message) {
        super(message);
    }

    /**
     * Constructor that takes a Throwable root cause.
     * 
     * @param throwable root cause exception.
     */
    public XEmailServiceException(Throwable throwable) {
        super(throwable);
    }

    /**
     * Constructor that takes an error message and a Throwable root cause.
     * 
     * @param message An error message.
     * @param throwable Root cause exception.
     */
    public XEmailServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
