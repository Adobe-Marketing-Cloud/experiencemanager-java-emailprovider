This module contains server side code to integrate with any third party email provider. It contains three classes:

#####1.	com.day.cq.xemailservice.impl.XEmailServiceImpl
- It implements com.day.cq.mcm.cq-mcm-emailprovider.EmailService interface. 
- CQ has a listener which will register all the classes implementing this interface. 
- This class implements methods inherited from com.day.cq.mcm.emailprovider.EmailService.

######getName() 
This method should return the name corresponding to the third party Email Service Provider's name. Please make sure that this value is same as the one configured during service configuration for property "value" inside node "providerName", [configure it here](http://localhost:4502/crx/de/index.jsp#/apps/mcm/sampleemailservice/components/sampleemailservicepage/dialog/items/general/items/providerName) (replace localhost:4502 with appropriate values, if required).

######execute() 
This method gets invoked for any action being performed for the configured Email Service.
-	Call to the specific client APIs can be invoked on the basis of operation name, which will be available through EmailServiceActions parameter.
-	These Email Service Provider's operations can be called from server call through actions, which can be configured at http://localhost:4502/crx/de/index.jsp#/apps/mcm/sampleemailservice/components/actionConfigurations (@refer parent README).
-	Client APIs will be invoked through the method. Object types used here should be replaced with the client specific object types. These object types are just the placeholders.
-	Email Provider's specific object construction can be done  using the method parameter "requestParams”.These parameters can be configured with the action dialogs at http://localhost:4502/crx/de/index.jsp#/apps/mcm/sampleemailservice/components/actionConfigurations.

#####2.	com.day.cq.xemailserviceXEmailServiceClient 
It is a sample interface provided for the reference. It contains the necessary client APIs.

#####3.	com.day.cq.xemailservice.impl.XEmailServiceClientImpl 
- Implements com.day.cq.xemailservice.XEmailServiceClient interface and should have the concrete implementation to invoke client APIs.
- Contains the sample code, which can be leveraged to make correct API call to the service and populate response.
- Most of APIs has return type as java.util.List and should have objects of type java.util.Map. This List is later converted to a JSON object, which eventually is being interpreted at the author UI corresponding to operations defined at http://localhost:4502/crx/de/index.jsp#/apps/mcm/sampleemailservice/components/actionConfigurations.

#####Workflow of sample calls
We have given sample implementations for some of the Email Provider Actions which CQ provides in com.day.cq.mcm.emailprovider.types.EmailServiceActions class. 
#####1.	getLists
- This operation is invoked when author adds CQ "Form" component on the authoring page and configures one of the following actions "E-Mail Service: Create Subscriber and add to list", "E-Mail Service: Send auto-responder email" or "E-Mail Service: Unsubscribe user from list". The actions correspond to the action configuration available at http://localhost:4502/crx/de/index.jsp#/apps/mcm/sampleemailservice/components/actionConfigurations. This API call is intended to populate subscription list on CQ instance by pulling data from Email Service Provider.  
       ![image](https://raw.github.com/Adobe-Marketing-Cloud/experiencemanager-java-emailprovider/diagrams/images/getListAPIcall.png)

#####2.	getFormsField 
- This operation is invoked to show data on author configuration dialog box. This API call is intended to populate "attributes" which are mandatory or optional for corresponding operation.  
        ![image](https://raw.github.com/Adobe-Marketing-Cloud/experiencemanager-java-emailprovider/diagrams/images/getFormsFieldAPIcall.png)

#####3.	getEmailTools 
- This operation configures personalization data through "Text & Personalization" component. The API call is intended to pull personalization data from Email Service and make it available in CQ author instance.  
        ![image](https://raw.github.com/Adobe-Marketing-Cloud/experiencemanager-java-emailprovider/diagrams/images/getEmailToolsAPIcall.png)

#####4.	addToList 
- This operation is invoked when subscriber submits the form which was previously configured on author instance. The API is invoked through configuration present at http://localhost:4502/crx/de/index.jsp#/libs/mcm/components/emailserviceactions/actions/addSubscriber/forward.jsp. This can be taken as reference to define other operations.

For more details refer sample code provided.

Note: Sample data will be visible on author instance on successful integration with Sample package. Integration errors and exceptions will be visible in CQ error.log and console logs. In case of error, data on author UI will be empty.
