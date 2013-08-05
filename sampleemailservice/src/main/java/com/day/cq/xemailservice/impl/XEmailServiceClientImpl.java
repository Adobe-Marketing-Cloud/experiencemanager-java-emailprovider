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

import com.day.cq.mcm.emailprovider.EmailServiceException;
import com.day.cq.wcm.webservicesupport.Configuration;
import com.day.cq.xemailservice.XEmailServiceClient;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

// TODO : add scr annotations - negative ranking or minimum ranking
@Component(metatype = false, label = "%cq.mcm.xemailservice.service.name", description = "%cq.mcm.xemailservice.service.description")
@Service
public class XEmailServiceClientImpl implements XEmailServiceClient {

    private static final Logger log = LoggerFactory.getLogger(XEmailServiceClientImpl.class);

    @Override
    public void checkCredentials(Map<String, Object> requestParams) throws EmailServiceException {

    }

    @Override
    public JSONArray handleGetAccounts(Map<String, Object> requestParams) throws EmailServiceException {

        String userName = (String) requestParams.get("username");
        String password = (String) requestParams.get("password");
        JSONArray accounts = null;

        if("admin".equals(userName) && "admin".equals(password)){

            accounts = new JSONArray();
            try {
                JSONObject adminAccount = new JSONObject();
                adminAccount.put("id", "adminID");
                adminAccount.put("name", "accountName");
                accounts.put(adminAccount);
            } catch (JSONException e) {
                log.error("JSON Exception in getting accounts information ");
            }
        }
        return accounts;
    }

    @Override
    public void addSubscriber(Map<String, Object> requestParams, Configuration configuration) {
    }

    @Override
    public void deleteSubscriber(Map<String, Object> requestParams, Configuration configuration) {
    }

    @Override
    public void publishEmail(Map<String, Object> requestParams, Configuration configuration) {
    }

    @Override
    public void updateEmail(Map<String, Object> requestParams, Configuration configuration) {
    }

    @Override
    public void sendAutoResponder(Map<String, Object> requestParams, Configuration configuration) {
    }

    @Override
    public void sendMailToSubscriber(Map<String, Object> requestParams, Configuration configuration) {
    }

    @Override
    public void sendMailToSubscriberList(Map<String, Object> requestParams, Configuration configuration) {
    }

    @Override
    public JSONObject getLists(Map<String, Object> requestParams, Configuration configuration) {
        return null;
    }

    @Override
    public JSONObject getPersonalizationInfo(Map<String, Object> requestParams, Configuration configuration) {
        return null;
    }

    @Override
    public JSONObject getEmails(Map<String, Object> requestParams, Configuration configuration) {
        return null;
    }

    @Override
    public JSONObject getEmailClassifications(Map<String, Object> requestParams, Configuration configuration) {
        return null;
    }

    @Override
    public JSONObject createSubscriptionList(Map<String, Object> requestParams, Configuration configuration) {
        return null;
    }

    @Override
    public JSONObject deleteSubscriptionList(Map<String, Object> requestParams, Configuration configuration) {
        return null;
    }

    @Override
    public JSONObject getSubscribers(Map<String, Object> requestParams, Configuration configuration) {
        return null;
    }

    @Override
    public JSONObject getFormFields(Map<String, Object> requestParams, Configuration configuration) {
        return null;
    }
}
