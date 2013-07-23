/*************************************************************************
 *
 * ADOBE CONFIDENTIAL
 * __________________
 *
 *  Copyright 2011 Adobe Systems Incorporated
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Adobe Systems Incorporated and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Adobe Systems Incorporated and its
 * suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Adobe Systems Incorporated.
 **************************************************************************/
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
