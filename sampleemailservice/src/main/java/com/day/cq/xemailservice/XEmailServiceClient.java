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
import com.day.cq.wcm.webservicesupport.Configuration;

import java.util.List;
import java.util.Map;

/**
 * XEmailService client that translates the request parameters into their own custom implementation objects if necessary
 * and calls the actual endpoint.
 */
public interface XEmailServiceClient {

    /**
     * This function is used to validate the connection parameters associated with Email Service
     *
     * @param requestParams The request parameters of the current request.
     * @throws EmailServiceException in case of errors.
     */
    public void checkCredentials(Map<String, Object> requestParams) throws EmailServiceException;


    /**
     * This function returns all the accounts associated with the Email Service configuration. If Email Service Provider
     * supports multiple accounts for a connection then those accounts can be fetched by implementing this API.
     *
     * @param requestParams The request parameters of the current request.
     * @return Object of type JSONArray of JSONObject in case of successful connection, otherwise a map.
     *
     * Note: The bare-bones request parameters needs to be translated into the implementation types as and when necessary
     *
     * @throws EmailServiceException in case of errors
     */
    public Object handleGetAccounts(Map<String, Object> requestParams) throws EmailServiceException;

    /**
     * This function is used to add a subscriber to subscription lists.
     * @param requestParams The request parameters of the current request.
     * @param configuration The cloud service configuration for this email service
     *
     * Note: The bare-bones request parameters needs to be translated into the implementation types as and when necessary
     *
     * @throws EmailServiceException in case of errors.
     */
    public void addSubscriber(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException;

    /**
     * This function is used to delete a subscriber to subscription lists.
     * @param requestParams The request parameters of the current request.
     * @param configuration The cloud service configuration for this email service.
     *
     * Note: The bare-bones request parameters needs to be translated into the implementation types as and when necessary
     *
     * @throws EmailServiceException in case of errors.
     */
    public void deleteSubscriber(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException;

    /**
     * This function is called to publish the email.
     * @param requestParams The request parameters of the current request.
     * @param configuration The cloud service configuration for this email service.
     *
     * Note: The bare-bones request parameters needs to be translated into the implementation types as and when necessary
     *
     * @throws EmailServiceException in case of errors.
     */
    public void publishEmail(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException;

    /**
     * This function is used to update an already published email.
     * @param requestParams The request parameters of the current request.
     * @param configuration The cloud service configuration for this email service.
     *
     * Note: The bare-bones request parameters needs to be translated into the implementation types as and when necessary
     *
     * @throws EmailServiceException in case of errors.
     */
    public void updateEmail(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException;

    /**
     * This function is used set the auto-responder settings of the email service.
     * @param requestParams The request parameters of the current request.
     * @param configuration The cloud service configuration for this email service.
     *
     * Note: The bare-bones request parameters needs to be translated into the implementation types as and when necessary
     *
     * @throws EmailServiceException in case of errors.
     */
    public void sendAutoResponder(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException;

    /**
     * This function is used to send email to a subscriber.
     * @param requestParams The request parameters of the current request.
     * @param configuration The cloud service configuration for this email service.
     *
     * Note: The bare-bones request parameters needs to be translated into the implementation types as and when necessary
     *
     * @throws EmailServiceException in case of errors.
     */
    public void sendMailToSubscriber(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException;

    /**
     * This function is used to send mail to a subscriber list.
     * @param requestParams The request parameters of the current request.
     * @param configuration The cloud service configuration for this email service.
     *
     * Note: The bare-bones request parameters needs to be translated into the implementation types as and when necessary
     *
     * @throws EmailServiceException in case of errors.
     */
    public void sendMailToSubscriberList(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException;

    /**
     * This function is used to get lists of subscribers.
     * @param requestParams The request parameters of the current request.
     * @param configuration The cloud service configuration for this email service.
     *
     * @return a List of Map. This list is later converted to json object. Refer implementation for example.
     * Note: The bare-bones request parameters needs to be translated into the implementation types as and when necessary
     *
     * @throws EmailServiceException in case of errors.
     */
    public List getLists(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException;


    /**
     * This function is used to get Personalization information for enabling personalization in AEM.
     * @param requestParams The request parameters of the current request.
     * @param configuration The cloud service configuration for this email service.
     * @return a List of Map. This list is later converted to json object. Refer implementation for example.
     *
     * Note: The bare-bones request parameters needs to be translated into the implementation types as and when necessary
     *
     * @throws EmailServiceException in case of errors.
     */
    public List getPersonalizationInfo(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException;

    /**
     * This function is used to fetch Emails.
     * @param requestParams The request parameters of the current request.
     * @param configuration The cloud service configuration for this email service.
     * @return a List of Map. This list is later converted to json object. Refer implementation for example.
     *
     * Note: The bare-bones request parameters needs to be translated into the implementation types as and when necessary
     *
     * @throws EmailServiceException in case of errors.
     */
    public List getEmails(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException;


    /**
     * This function is used to create a subscription list.
     * @param requestParams The request parameters of the current request.
     * @param configuration The cloud service configuration for this email service.
     * @return a List of Map. This list is later converted to json object. Refer implementation for example.
     *
     * Note: The bare-bones request parameters needs to be translated into the implementation types as and when necessary
     *
     * @throws EmailServiceException in case of errors.
     */
    public List createSubscriptionList(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException;

    /**
     * This function is used to delete a subscription list.
     * @param requestParams The request parameters of the current request.
     * @param configuration The cloud service configuration for this email service.
     *
     * Note: The bare-bones request parameters needs to be translated into the implementation types as and when necessary
     *
     * @throws EmailServiceException in case of errors.
     */
    public void deleteSubscriptionList(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException;

    /**
     * This function is used to fetch the subscribers.
     * @param requestParams The request parameters of the current request.
     * @param configuration The cloud service configuration for this email service.
     * @return a List of Map. This list is later converted to json object. Refer implementation for example.
     *
     * Note: The bare-bones request parameters needs to be translated into the implementation types as and when necessary
     *
     * @throws EmailServiceException in case of errors.
     */
    public List getSubscribers(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException;

    /**
     * This function is used to fetch form fields which are required to be a part of form.
     * @param requestParams The request parameters of the current request.
     * @param configuration The cloud service configuration for this email service.
     * @return a List of Map. This list is later converted to json object. Refer implementation for example.
     *
     * Note: The bare-bones request parameters needs to be translated into the implementation types as and when necessary
     *
     * @throws EmailServiceException in case of errors.
     */
    public List getFormFields(Map<String, Object> requestParams, Configuration configuration) throws EmailServiceException;

}
