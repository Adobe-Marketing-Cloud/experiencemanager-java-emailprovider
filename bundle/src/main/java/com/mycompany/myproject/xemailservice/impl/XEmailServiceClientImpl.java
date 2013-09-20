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

package com.mycompany.myproject.xemailservice.impl;

import com.day.cq.mcm.emailprovider.ESConstants;
import com.day.cq.mcm.emailprovider.EmailServiceException;
import com.day.cq.mcm.emailprovider.impl.types.ListAttributeImpl;
import com.day.cq.mcm.emailprovider.types.EmailServiceActions;
import com.day.cq.mcm.emailprovider.types.ListAttribute;
import com.day.cq.mcm.emailprovider.util.EmailHelper;
import com.day.cq.wcm.webservicesupport.Configuration;
import com.mycompany.myproject.xemailservice.XEmailServiceClient;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(metatype = false, label = "%cq.mcm.xemailservice.service.name", description = "%cq.mcm.xemailservice.service.description")
@Service
public class XEmailServiceClientImpl implements XEmailServiceClient {

    private static final Logger log = LoggerFactory.getLogger(XEmailServiceClientImpl.class);

    @Override
    public Object handleGetAccounts(Map<String, Object> requestParams) throws EmailServiceException {

        String userName = (String) requestParams.get("username");
        String password = (String) requestParams.get("password");

        try {
            if("admin".equals(userName) && "admin".equals(password)){
                JSONArray accounts = new JSONArray();
                JSONObject adminAccount = new JSONObject();
                adminAccount.put("id", "adminID");
                adminAccount.put("name", "accountName");
                accounts.put(adminAccount);
                log.info("Success: " + EmailServiceActions.GET_ACCOUNTS.toString());
                return accounts;
            }
            else{
                Map<String, String> error = new HashMap<String, String>();
                error.put("error", "Invalid Credentials");
                return error;
            }
        } catch (Exception e) {
            log.error("JSON Exception in getting accounts information ");
            throw new EmailServiceException("Error while establishing connection with XEmailService");
        }

    }

    @Override
    public void addSubscriber(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException{
        String emailId = (String) requestParams.get(ESConstants.FORM_EMAIL_FIELD);
        Object listIds = requestParams.get(EmailHelper.PN_LISTID);

        log.info("Success: " + EmailServiceActions.ADD_SUBSCRIBER.toString());
        //iterate over listIds and fetch all the subscriptionLists
        //call to client specific API


    }

    @Override
    public void deleteSubscriber(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException{
        String emailId = (String) requestParams.get(ESConstants.FORM_EMAIL_FIELD);
        Object listIds = requestParams.get(EmailHelper.PN_LISTID);

        log.info("Success: " + EmailServiceActions.DELETE_SUBSCRIBER.toString());
        //iterate over listIds and fetch all the subscriptionLists
        //call to client specific API
    }

    @Override
    public void publishEmail(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException{
        String emailSubject = (String)requestParams.get("subject");
        String content = (String)requestParams.get("content");
        if((Boolean)requestParams.get("isHtml")==true){
             // Set HTML content
        } else {
            //Set text content
        }
        String emailName = (String)requestParams.get("name");

        log.info("Success: " + EmailServiceActions.PUBLISH_EMAIL.toString());
        //pull other required parameters from requestParams
        //call to client specific API

    }

    @Override
    public void updateEmail(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException{
        String emailSubject = (String)requestParams.get("subject");
        String content = (String)requestParams.get("content");
        if((Boolean)requestParams.get("isHtml")==true){
            // Set HTML content
        } else {
            //Set text content
        }
        String emailName = (String)requestParams.get("name");

        log.info("Success: " + EmailServiceActions.UPDATE_EMAIL.toString());
        //pull other required parameters from requestParams
        //call to client specific API
    }

    @Override
    public void sendAutoResponder(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException{
        String newsLetterId = (String)requestParams.get(EmailHelper.PN_AUTORESPONDER_EMAIL);
        String emailClassification = (String)requestParams.get(EmailHelper.PN_EMAIL_CLASSIFICATION);
        String emailAddress = (String)requestParams.get(ESConstants.FORM_EMAIL_FIELD);

        log.info("Success: " + EmailServiceActions.SEND_AUTO_RESPONDER.toString());
        //pull other required parameters from requestParams
        //call to client specific API for this action

    }

    @Override
    public void sendMailToSubscriber(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException{
        String newsLetterId = (String)requestParams.get(EmailHelper.PN_AUTORESPONDER_EMAIL);
        String emailClassification = (String)requestParams.get(EmailHelper.PN_EMAIL_CLASSIFICATION);
        String emailAddress = (String)requestParams.get(ESConstants.FORM_EMAIL_FIELD);

        log.info("Success: " + EmailServiceActions.SEND_EMAIL_TO_SUBSCRIBER.toString());
        //pull other required parameters from requestParams
        //call to client specific API for this action
    }

    @Override
    public void sendMailToSubscriberList(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException{

        String newsLetterId = (String)requestParams.get(EmailHelper.PN_AUTORESPONDER_EMAIL);
        String emailClassification = (String)requestParams.get(EmailHelper.PN_EMAIL_CLASSIFICATION);
        String listID = (String)requestParams.get("listID");

        log.info("Success: " + EmailServiceActions.SEND_EMAIL_TO_SUBSCRIBER_LIST.toString());
        //pull all subscribers from listID and send email to the list
        //call to client specific API for this action
    }

    @Override
    public List<Map<String, Object>> getLists(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException{
        try{
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> listData = new HashMap<String, Object>();
            listData.put("id", "sampleid");
            listData.put("name", "samplelist");
            list.add(listData);

            //List<List> subscriberLists = new ArrayList<List>();
            //subscriberLists = client.getSubscriberlist, corresponding API call
            //iterate over subscriberLists to populate listData
            //listData.put("id", subscriberList.getID();
            //listData.put("name", subscriberList.getListName());

            log.info("Success: " + EmailServiceActions.GET_LISTS.toString());
            return list;
        }catch (Exception e){
            throw new EmailServiceException(e.getMessage());
        }
    }

    @Override
    public List<Map<String, Object>> getPersonalizationInfo(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException{
        try{
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> listData = new HashMap<String, Object>();
            listData.put("text", "sample");
            listData.put("value", "%%sample%%");
            list.add(listData);

            log.info("Success: " + EmailServiceActions.GET_PERSONALIZATION_INFO.toString());
            //List<List> personalizationList = new ArrayList<List>();
            //personalizationList = client.getPersonalizationList, corresponding API call
            //iterate over personalizationList to populate listData
            //listData.put("id", personalizationList.getText();
            //listData.put("name", personalizationList.getValue());

            return list;
        }catch (Exception e){
            throw new EmailServiceException(e.getMessage());
        }

    }

    @Override
    public List<Map<String, Object>> getEmails(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException{
        try{
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> listData = new HashMap<String, Object>();
            listData.put("id", "sampleid");
            listData.put("name", "sampleemail");
            list.add(listData);

            //List<List> emails = new ArrayList<List>();
            //emails = client.getemails , corresponding API call
            //iterate over emails to populate listData
            //listData.put("id", emails.getID();
            //listData.put("name", emails.getListName());

            log.info("Success: " + EmailServiceActions.GET_EMAILS.toString());
            return list;
        }catch (Exception e){
            throw new EmailServiceException(e.getMessage());
        }

    }

    @Override
    public List<Map<String, Object>> createSubscriptionList(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException{
        String listIds = (String)requestParams.get("listId");
        //call to client specific API

        try{
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> listData = new HashMap<String, Object>();

            listData.put("id", "sampleid");
            listData.put("name", "samplesubscriberList");
            list.add(listData);

            //List<List> subscriberLists = new ArrayList<List>();
            //subscriptionList can be populated through corresponding API call
            //iterate over subscriberLists to populate listData
            //listData.put("id", subscriberList.getID();
            //listData.put("name", subscriberList.getListName());

            log.info("Success: " + EmailServiceActions.CREATE_SUBSCRIPTION_LIST.toString());

            return list;
        }catch (Exception e){
            throw new EmailServiceException(e.getMessage());
        }

    }

    @Override
    public void deleteSubscriptionList(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException{
        Object listIds = requestParams.get(EmailHelper.PN_LISTID);

        log.info("Success: " + EmailServiceActions.DELETE_SUBSCRIPTION_LIST.toString());
        //call to client specific API
    }

    @Override
    public List<Map<String, Object>> getSubscribers(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException{
        String listIds = (String)requestParams.get("listId");
        //call to client specific API

        try{
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> listData = new HashMap<String, Object>();

            listData.put("id", "testid");
            listData.put("name", "subscriberList1");
            list.add(listData);

            //List<List> subscribers = new ArrayList<List>();
            //subscribers can be populated through corresponding API call
            //iterate over subscribers to populate listData
            //listData.put("id", subscribers.getID();
            //listData.put("name", subscribers.getListName());

            log.info("Success: " + EmailServiceActions.GET_SUBSCRIBERS.toString());
            return list;
        }catch (Exception e){
            throw new EmailServiceException(e.getMessage());
        }

    }

    @Override
    public List<Map<String, Object>> getFormFields(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException{
        String actionType = (String)requestParams.get("actionType");
        EmailServiceActions formAction = null;
        if(actionType.indexOf("addSubscriber")!=-1)
            formAction = EmailServiceActions.ADD_SUBSCRIBER;
        else if(actionType.indexOf("deleteSubscriber")!=-1)
            formAction = EmailServiceActions.DELETE_SUBSCRIBER;
        else if(actionType.indexOf("autoResponder")!=-1)
            formAction = EmailServiceActions.SEND_AUTO_RESPONDER;
        else
            throw new EmailServiceException("Form fields not associated with given form action: " + actionType);

        //ADD default email field
        List<ListAttribute> attributes = new ArrayList<ListAttribute>();
        ListAttribute attribute = new ListAttributeImpl(ESConstants.FORM_EMAIL_FIELD,ESConstants.FORM_EMAIL_FIELD,true);
        attributes.add(attribute);
        //add other attributes to the list through API call
        List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
        for(ListAttribute attr: attributes)
        {
            if(formAction == EmailServiceActions.DELETE_SUBSCRIBER && !attr.isRequired())
                continue;
            mapList.add(attr.getPropertiesMap());
        }
        log.info("Success: " + EmailServiceActions.GET_FORM_FIELDS.toString());
        return mapList;

    }
}
