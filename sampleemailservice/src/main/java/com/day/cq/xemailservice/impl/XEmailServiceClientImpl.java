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

package com.day.cq.xemailservice.impl;


import com.day.cq.xemailservice.XEmailServiceClient;
import com.day.cq.xemailservice.XEmailServiceException;
import com.day.cq.mcm.emailprovider.types.Account;
import com.day.cq.mcm.emailprovider.types.ConnectionParams;
import com.day.cq.mcm.emailprovider.types.Email;
import com.day.cq.mcm.emailprovider.types.Subscriber;
import com.day.cq.mcm.emailprovider.types.SubscriptionList;
import com.day.cq.mcm.emailprovider.types.SendClassification;
import com.day.cq.wcm.webservicesupport.Configuration;

import java.util.List;


public class XEmailServiceClientImpl implements XEmailServiceClient {


   private Configuration configuration;

    private XEmailServiceClientImpl(){
    	
    }
    public XEmailServiceClientImpl(Configuration configuration){
    	this.configuration = configuration;
    }


    @Override
    public List<Account> getAccounts(ConnectionParams connectionParams, Object filter) throws XEmailServiceException {
        return null;  //Replace with your own implementation using client APIs and your custom objects
    }

    @Override
    public void checkCredentials(ConnectionParams connectionParams) throws XEmailServiceException {
        //Replace with your own implementation using client APIs and your custom objects
    }

    @Override
    public void addSubscriberToList(Subscriber subscriber) throws XEmailServiceException {
        //Replace with your own implementation using client APIs and your custom objects
    }

    @Override
    public void deleteSubscriberFromList(Subscriber subscriber) throws XEmailServiceException {
        //Replace with your own implementation using client APIs and your custom objects
    }

    @Override
    public Email publishEmail(Email email) throws XEmailServiceException {
        return null;  //Replace with your own implementation using client APIs and your custom objects
    }

    @Override
    public void updateEmail(Email email) throws XEmailServiceException {
        //Replace with your own implementation using client APIs and your custom objects
    }

    @Override
    public void sendEmail(Email email, Subscriber subscriber) throws XEmailServiceException {
        //Replace with your own implementation using client APIs and your custom objects
    }

    @Override
    public void sendEmail(Email email, SubscriptionList subscriberList) throws XEmailServiceException {
        //Replace with your own implementation using client APIs and your custom objects
    }

    @Override
    public List<SubscriptionList> getSubscribers(String listId) throws XEmailServiceException {
        return null;  //Replace with your own implementation using client APIs and your custom objects
    }

    @Override
    public void deleteList(String listId) throws XEmailServiceException {
        //Replace with your own implementation using client APIs and your custom objects
    }

    @Override
    public Object createList(Object list) throws XEmailServiceException {
        return null;  //Replace with your own implementation using client APIs and your custom objects
    }

    @Override
    public List<SendClassification> getSendClassifications(Object filter) throws XEmailServiceException {
        return null;  //Replace with your own implementation using client APIs and your custom objects
    }

    @Override
    public List<Email> getEmails(Object filter) throws XEmailServiceException {
        return null;  //Replace with your own implementation using client APIs and your custom objects
    }

    @Override
    public List<Object> getSubscriberList(Object filter) throws XEmailServiceException {
        return null;  //Replace with your own implementation using client APIs and your custom objects
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }
}
