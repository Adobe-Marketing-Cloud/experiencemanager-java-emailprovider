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


import com.day.cq.mcm.emailprovider.EmailService;
import com.day.cq.mcm.emailprovider.EmailServiceException;
import com.day.cq.mcm.emailprovider.types.EmailServiceActions;
import com.day.cq.wcm.webservicesupport.Configuration;
import com.day.cq.xemailservice.XEmailServiceClient;
import org.apache.felix.scr.annotations.*;

import java.util.Map;


@Component(metatype = false, label = "%cq.mcm.xemailservice.service.name", description = "%cq.mcm.xemailservice.service.description")
@Service
@Properties({
        @Property(name = "service.description", value = "XEmailService Service Implementation") ,
        @Property(name = "service.name", value = XEmailServiceImpl.EMAIL_SERVICE_NAME)
})
public class XEmailServiceImpl implements EmailService {

    @Reference
    private XEmailServiceClient emailServiceClient;

    private Configuration cloudServiceConfig;

    public static final String EMAIL_SERVICE_NAME = "xemailservice";

    @Override
    public String getName() {
        return EMAIL_SERVICE_NAME;
    }

    public Configuration getCloudServiceConfig() {
        return cloudServiceConfig;
    }

    @Override
    public Object execute(EmailServiceActions emailServiceActions, Map<String, Object> requestParams,
                          Configuration configuration) throws EmailServiceException {

        this.cloudServiceConfig = configuration;

        // For connect and getAccounts operation, the cloudservice configuration will be null
        switch(emailServiceActions){
            case CONNECT:
                this.emailServiceClient.checkCredentials(requestParams);
                return null;

            case GET_ACCOUNTS:
                return this.emailServiceClient.handleGetAccounts(requestParams);

            default:
                break;
        }

        // For all other actions the cloudservice configuration cannot be undefined
        if (configuration == null) {
            throw new EmailServiceException("No ET Configuration specified while invoking "
                    + emailServiceActions.name());
        }
        switch(emailServiceActions)
        {
            case ADD_SUBSCRIBER:
                this.emailServiceClient.addSubscriber(requestParams, configuration);
                break;

            case DELETE_SUBSCRIBER:
                this.emailServiceClient.deleteSubscriber(requestParams, configuration);
                break;

            case PUBLISH_EMAIL:
                this.emailServiceClient.publishEmail(requestParams, configuration);
                break;

            case UPDATE_EMAIL:
                this.emailServiceClient.updateEmail(requestParams, configuration);
                break;

            case SEND_AUTO_RESPONDER:
                this.emailServiceClient.sendAutoResponder(requestParams, configuration);
                break;

            case SEND_EMAIL_TO_SUBSCRIBER:
                this.emailServiceClient.sendMailToSubscriber(requestParams, configuration);
                break;

            case SEND_EMAIL_TO_SUBSCRIBER_LIST:
                this.emailServiceClient.sendMailToSubscriberList(requestParams, configuration);
                break;

            case GET_LISTS:
                return this.emailServiceClient.getLists(requestParams, configuration);

            case GET_PERSONALIZATION_INFO:
                return this.emailServiceClient.getPersonalizationInfo(requestParams, configuration);

            case GET_EMAILS:
                return this.emailServiceClient.getEmails(requestParams, configuration);

            case GET_EMAIL_CLASSIFICATIONS:
                return this.emailServiceClient.getEmailClassifications(requestParams, configuration);

            case CREATE_SUBSCRIPTION_LIST:
                return this.emailServiceClient.createSubscriptionList(requestParams, configuration);

            case DELETE_SUBSCRIPTION_LIST:
                this.emailServiceClient.deleteSubscriptionList(requestParams, configuration);

            case GET_SUBSCRIBERS:
                return this.emailServiceClient.getSubscribers(requestParams, configuration);

            case GET_FORM_FIELDS:
                return this.emailServiceClient.getFormFields(requestParams, configuration);

            default:
                throw new EmailServiceException("Unsupported Operation: " + emailServiceActions.name());
        }

        // Control shall never reach here.
        return null;
    }



}
