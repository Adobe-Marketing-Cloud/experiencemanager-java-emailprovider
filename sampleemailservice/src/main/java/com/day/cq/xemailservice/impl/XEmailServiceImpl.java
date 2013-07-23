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
package com.day.cq.xemailservice.impl;


import com.day.cq.xemailservice.XEmailServiceClient;
import com.day.cq.xemailservice.XEmailServiceException;
import com.day.cq.mcm.emailprovider.ESConstants;
import com.day.cq.mcm.emailprovider.EmailService;
import com.day.cq.mcm.emailprovider.impl.types.ListAttributeImpl;
import com.day.cq.mcm.emailprovider.types.*;
import com.day.cq.wcm.webservicesupport.Configuration;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 */
@Component(metatype = false, label = "%cq.mcm.xemailservice.service.name", description = "%cq.mcm.xemailservice.service.description")
@Service
@Properties({ @Property(name = "service.description", value = "XEmailService Service Implementation") })
public class XEmailServiceImpl implements EmailService {

    private XEmailServiceClient client;
    private Configuration config;
    private static final String SERVICE_NAME = "XEmailService"; //update the name with the corresponding email service provider name

    @Override
    public String getName() {
        return SERVICE_NAME;
    }

    /**
     * This method is an entry point for all the actions to email service but the specific API calls, for specific calls refer {@link com.day.cq.xemailservice.servlets.XEmailServiceSpecificActionsServlet}.
     * @param op     Operation which is initiated on the email service
     * @param params   map of
     * @param  config
     *
     */    
    public Object execute(EmailServiceActions op,Map<String,Object> params, Configuration config) throws XEmailServiceException
    {

        this.client = new XEmailServiceClientImpl(config);
        this.config = config;
    	switch(op){
    	//the below operations are needed for configuring the account and hence configuration is null
    		case CONNECT:
    			checkCredentials(getConnectionParams(params));
    			return null;
    		case GET_ACCOUNTS:
    			return handleGetAccounts(params);
    		default:
    			break;
    	}
        if (config == null) {
            throw new XEmailServiceException("No Configuration specified while invoking " + op.name());
        }
    	switch(op)
    	{
    		case ADD_SUBSCRIBER:
    			handleAddSubscriber(params);
    			return null;
    		case DELETE_SUBSCRIBER:
    			handleDeleteSubscriber(params);
    	        return null;
    		case PUBLISH_EMAIL:
    			handlePublishEmail(params);
    			return null;
    		case UPDATE_EMAIL:
    			handleUpdateEmail(params);
    			return null;
    		case SEND_AUTO_RESPONDER:
    			handleAutoResponder(params);
    			return null;
    		case SEND_EMAIL_TO_SUBSCRIBER:
    			handleSendMailToSubscriber(params);
    			return null;
    		case SEND_EMAIL_TO_SUBSCRIBER_LIST:
    			handleSendMailToSubscriberList(params);
    			return null;
    		case GET_LISTS:
    			return handleGetLists(params);
    		case GET_PERSONALIZATION_INFO:
    			return handleGetPersonalizationInfo(params);
    		case GET_EMAILS:
    			return handleGetEmails(params);
    		case GET_EMAIL_CLASSIFICATIONS:
    			return handleGetEmailClassifications(params);
    		case CREATE_SUBSCRIPTION_LIST:
    			return handleCreateSubscriptionList(params);
    		case DELETE_SUBSCRIPTION_LIST:
    			handleDeleteSubscriptionList(params);
    			return null;
    		case GET_SUBSCRIBERS:
    			return handleGetSubscribers(params);
            case GET_FORM_FIELDS:
                return handleGetFormFields(params,config);

    		default:
    			throw new XEmailServiceException("Unsupported Operation: " + op.name());
    	}
    }

    private void checkCredentials(ConnectionParams connectionParams) throws XEmailServiceException {
        this.client.checkCredentials(connectionParams);
    }

    private ConnectionParams getConnectionParams(Map<String, Object> params) {
        return null;//To change body of created methods use File | Settings | File Templates.
    }

    private Object handleGetAccounts(Map<String, Object> params) throws XEmailServiceException {
        Object filterObject = null;
        return this.client.getAccounts(this.getConnectionParams(params), filterObject);

    }

    private void handleAutoResponder(Map<String, Object> params) {
        //To change body of created methods use File | Settings | File Templates.
    }

    private void handleSendMailToSubscriber(Map<String, Object> params) throws XEmailServiceException {
        Email email = null;
        Subscriber subscriber = null;
        this.client.sendEmail(email, subscriber);

    }

    private void handleSendMailToSubscriberList(Map<String, Object> params) throws XEmailServiceException {
        //foreach subscriber list
        this.handleSendMailToSubscriber(params);
    }

    /**
     * This handler method is to fetch the lists. Output from this method should be a of type java.util.List<Map<String,Object> >.
     *
     * Later this object will be converted to JSON object.
     * @param params
     * @return
     * @throws XEmailServiceException
     */
    private Object handleGetLists(Map<String, Object> params) throws XEmailServiceException {
        Object filterObject = null; // construct filter object if any with the help of params map
        return this.client.getSubscriberList(filterObject);

    }

    /**
     * This handler method is to fetch personalized information. Output from this method should be a of type java.util.List<Map<String,Object> >.
     * Later this object will be converted to JSON object.
     * @param params
     * @return
     */
    private Object handleGetPersonalizationInfo(Map<String, Object> params) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private Object handleGetEmails(Map<String, Object> params) throws XEmailServiceException {

        return this.client.getEmails(new Object());
    }

    private Object handleGetEmailClassifications(Map<String, Object> params) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private Object handleCreateSubscriptionList(Map<String, Object> params) throws XEmailServiceException {
        return  this.client.createList(params);
    }

    private void handleDeleteSubscriptionList(Map<String, Object> params) throws XEmailServiceException {
        //fetch list  name from params
        String listName = (String) params.get("<List>");     //Replace <List> with the actual key
        this.client.deleteList(listName);
    }

    private Object handleGetSubscribers(Map<String, Object> params) throws XEmailServiceException {
        return this.client.getSubscribers(""); //pull the actual name from the params
    }

    private void handleUpdateEmail(Map<String, Object> params) {
        //this.client.updateEmail(email); //construct desired email object from params
    }

    private void handlePublishEmail(Map<String, Object> params) {
        //this.client.publishEmail(email); //construct desired email object from params
    }

    private void handleDeleteSubscriber(Map<String, Object> params) {
       // this.client.deleteSubscriberFromList(subscriber);//construct subscriber from the params object

    }

    private void handleAddSubscriber(Map<String, Object> params) {
        //this.client.addSubscriberToList(subscriber);  //construct subscriber from the params object
    }

    /**
     * Sample method to handle forms fields
     * @param params
     * @param config
     * @return
     * @throws XEmailServiceException
     */
    private Object handleGetFormFields(Map<String, Object> params,
                                       Configuration config) throws XEmailServiceException {

        java.util.List<ListAttribute> attributes = new ArrayList<ListAttribute>();
        String actionType = (String)params.get("actionType");
        EmailServiceActions formAction = null;
        if(actionType.indexOf("addSubscriber")!=-1)
            formAction = EmailServiceActions.ADD_SUBSCRIBER;
        else if(actionType.indexOf("deleteSubscriber")!=-1)
            formAction = EmailServiceActions.DELETE_SUBSCRIBER;
        else if(actionType.indexOf("autoResponder")!=-1)
            formAction = EmailServiceActions.SEND_AUTO_RESPONDER;
        else
            throw new XEmailServiceException("Form fields not associated with given form action: " + actionType);
        //ADD default email field
        ListAttribute attribute = new ListAttributeImpl(ESConstants.FORM_EMAIL_FIELD,ESConstants.FORM_EMAIL_FIELD,true);
        attributes.add(attribute);

        java.util.List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
        for(ListAttribute attr: attributes)
        {
            if(formAction == EmailServiceActions.DELETE_SUBSCRIBER && !attr.isRequired())
                continue;
            mapList.add(attr.getPropertiesMap());
        }
        return mapList;
    }


}
