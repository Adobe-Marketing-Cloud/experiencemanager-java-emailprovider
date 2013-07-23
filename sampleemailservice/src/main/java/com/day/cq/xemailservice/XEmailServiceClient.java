package com.day.cq.xemailservice;

import com.day.cq.mcm.emailprovider.types.*;
import com.day.cq.wcm.webservicesupport.Configuration;

/**
 * XEmailService Webservice client that makes webservice calls to XEmailService WebService endpoint.
 */
public interface XEmailServiceClient {
    /**
     * This function returns all the accounts associated with the Email Service configuration. If Email Service Provider
     * supports multiple accounts for a connection then those accounts can be fetched by implementing this API.
     * @param connectionParams The connection parameters to connect to the Service Provider.
     * @param filter Pass null if no filtering needed.
     * @return A list of all Accounts associated with this connection.
     *
     * Note: @param Object and @return type of list can be replaced with the corresponding filter and Account object types of your own object type(s) or the Email Service.
     *
     * @throws XEmailServiceException in case of errors
     */
    public java.util.List<Account> getAccounts(ConnectionParams connectionParams, Object filter) throws XEmailServiceException;
    /**
     * This function is used to validate the connection parameters associated with Email Service
     * @param connectionParams The ConnectionParams for Email Service.
     * @throws XEmailServiceException in case of errors.
     */
    public void checkCredentials(ConnectionParams connectionParams) throws XEmailServiceException;
    /**
     * This function is used to add a subscriber to subscription lists.
     * @param subscriber The Subscriber object containing information about the subscriber and the subscription lists.
     *
     * Note: @param subscriber can be replaced with the corresponding object type of your own object type(s) or the Email Service.
     *
     * @throws XEmailServiceException in case of errors.
     */
    public void addSubscriberToList(Subscriber subscriber) throws XEmailServiceException;
    /**
     * This function is used to delete a subscriber to subscription lists.
     * @param subscriber The Subscriber object containing information about the subscriber and the subscription lists.
     *
     * Note: @param subscriber can be replaced with the corresponding object type of your own object type(s) or the Email Service.
     *
     * @throws XEmailServiceException in case of errors.
     */
    public void deleteSubscriberFromList(Subscriber subscriber) throws XEmailServiceException;
    /**
     * This function is used to publish an email to Email Service.
     * @param email The email to be published
     * @return the published email with new properties(<>Some ID</>: identifier of email on Email Service) saved on Email Service
     *
     * Note: @param and @return Email can be replaced with the corresponding object types of your own object type(s) or the Email Service.
     *
     * @throws XEmailServiceException in case of errors.
     */
    public Email publishEmail( Email email) throws XEmailServiceException;
    /**
     * This function is used to update a published email on an external email provider
     * @param email The email containing the updates with ID set to corresponding email entity on Email Service
     *
     * Note: @param email can be replaced with the corresponding object type of your own object type(s) or the Email Service.
     *
     * @throws XEmailServiceException
     */
    public void updateEmail(Email email) throws XEmailServiceException;
    /**
     * This function is used to send an email to a subscriber.
     * @param email Email object containing information about email like ID and customerKey
     * @param subscriber The subscriber to which the email will be sent.
     *
     * Note: @param email and subscriber be replaced with the corresponding object type of your own object type(s) or the Email Service.
     *
     * @throws XEmailServiceException in case of errors.
     */
    public void sendEmail(Email email, Subscriber subscriber) throws XEmailServiceException;
    /**
     * This function is used to send an email to a subscriberList.
     * @param email Email object containing information about email like ID and customerKey
     * @param subscriberList The list to which the email will be sent.
     *
     * Note: @param email and subscriberList can be replaced with the corresponding object type of your own object type(s) or the Email Service.
     *
     * @throws XEmailServiceException in case of errors.
     */
    public void sendEmail(Email email, SubscriptionList subscriberList) throws XEmailServiceException;
    /**
     * This function will get all the subscribers that are subscribed on the specified list.
     * @param listId identifier of the subscription list for which subscribers need to be fetched.
     * @return A list containing all the subscriber objects subscribed to the list.
     * @throws XEmailServiceException in case of errors.
     */
    public java.util.List<SubscriptionList> getSubscribers(String listId) throws XEmailServiceException;
    /**
     * This function will delete specified subscription list from Email Service.
     * @param listId The identifier of the subscription list to be deleted.
     * @throws XEmailServiceException in case of errors.
     */
    public void deleteList( String listId) throws XEmailServiceException;
    /**
     * This function will create a subscription list on Email Service.
     * @param list List containing information on the list to be created
     *
     * Note: @param and @return type list can be replaced with the corresponding object type of your own object type(s) or the Email Service.
     *
     * @throws XEmailServiceException in case of errors.
     */
    public Object createList(Object list) throws XEmailServiceException;
    /**
     * This function returns the Classification types for sending an email.
     * @param filter Filter containing send classification filters, pass null for no filtering.
     * @return A List containing all SendClassification objects for the available classifications.
     *
     * Note: @param filter and @return list type SendClassification can be replaced with the corresponding object type of your own object type(s) or the Email Service.
     *
     * @throws XEmailServiceException in case of errors.
     */
    public java.util.List<SendClassification> getSendClassifications(Object filter) throws XEmailServiceException;

    /**
     * This function will get a list of all mails that are available with Email Service for this account.
     * @param filter Filter containing Email filters. Pass null for no filter.
     * @return A list containing all Email objects.
     *
     * Note: @param filter can be replaced with the corresponding object type of your own object type(s) or the Email Service.
     *
     *  @throws XEmailServiceException in case of errors.
     */
    public java.util.List<Email> getEmails(Object filter) throws XEmailServiceException;

    /**
     * This function is used to return all subscription lists available with Email Service account.
     * @param filter Filter containing list filters. Pass null for no filter.
     * @return a List containing Email Subscriber objects for each subscription list available with Email Service account.
     *
     * Note: @param filter and @return list of objects can be replaced with the corresponding object type of your own object type(s) or the Email Service.
     *
     * @throws XEmailServiceException in case of errors.
     */
    public java.util.List<Object> getSubscriberList(Object filter) throws XEmailServiceException;

    /**
     * This function returns the CQ cloud service configuration
     * @return CQ Cloud Service configuration
     */
    public Configuration getConfiguration();


}
