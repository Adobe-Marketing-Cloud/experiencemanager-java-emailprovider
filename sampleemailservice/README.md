This module contains the java source code and java docs, which will guide you through the integration steps:

- com.day.cq.xemailservice.impl.XEmailServiceImpl is the main class, which implements EmailService class of com.day.cq.mcm.cq-mcm-emailprovider.
- CQ has a listener which will register all the classes implementing EmailService.
- The interface class has two main methods getName and execute, inherited from EmailService interface.

  1. "getName" method should return the name corresponding to the third party Email Service Provider's name. Please make sure that this value is same as the one configured during service config for property name "providerName". [Configure it here](http://localhost:4502/crx/de/index.jsp#/apps/mcm/sampleemailservice/components/sampleemailservicepage/dialog/items/general/items/providerName) (replace "localhost:4502" with appropriate values, if required).
  2. "execute" method is the method which gets invoked for any action being performed for the configured Email Service.
  3. Call to the specific client APIs can be invoked on the basis of operation name, which be available through EmailServiceActions parameter being passed to execute method.
  4. These Email Service Provider's operations can be called from server call through actions, which can be configured at http://localhost:4502/crx/de/index.jsp#/apps/mcm/sampleemailservice/components/actionConfigurations (@refer parent README).
  5. Client APIs will be invoked through "execute" method, we have provided a client interface com.day.cq.xemailservice.XEmailServiceClient for reference. Object types use here should be replaced with  the client specific object types. These object types are just the placeholders.
  6. Email Provider's specific object construction can be done in com.day.cq.xemailservice.impl.XEmailServiceImpl by using "params" object map which is provided through "execute" method.
  7. These parameters can be configured with the action dialogs at http://localhost:4502/crx/de/index.jsp#/apps/mcm/sampleemailservice/components/actionConfigurations.
	
- com.day.cq.xemailservice.impl.XEmailServiceClientImpl is the class which inherits com.day.cq.xemailservice.XEmailServiceClient and should have the concrete implementation
to invoke client APIs.
- com.day.cq.xemailservice.impl.XEmailServiceClientImpl contains the sample code, which can be leveraged to make correct API call to the service and populate response.
- Most of APIs has return type as java.util.List and should have objects of type java.util.Map. This List is later converted to a JSON object, which eventually is being interpreted at the author UI corresponding to operations defined at http://localhost:4502/crx/de/index.jsp#/apps/mcm/sampleemailservice/components/actionConfigurations.
- Sample data will be visible on author instance on successful integration with Sample package.
- Integration errors and exceptions will be visible in CQ error.log and console logs. In case of error, data on author UI will be empty.
- Sample integration uses following operations:
    1. getLists - This operation is invoked when author adds CQ "form" component on the authoring page and configures one of the following actions "E-Mail Service: Create Subscriber and add to list", "E-Mail Service: Send auto-responder email" or "E-Mail Service: Unsubscribe user from list".
       There actions corresponds to the action configuration available at http://localhost:4502/crx/de/index.jsp#/apps/mcm/sampleemailservice/components/actionConfigurations. This API call is intended to populate subscription list on CQ instance by pulling data from Email Service Provider.
       ![image](https://raw.github.com/Adobe-Marketing-Cloud/experiencemanager-java-emailprovider/diagrams/images/getListAPIcall.png)
    2. getFormsField - This operation is invoked to show data on author configuration dialog box. This API call is intended to populate "attributes" which are mandatory or optional for corresponding operation.
        ![image](https://raw.github.com/Adobe-Marketing-Cloud/experiencemanager-java-emailprovider/diagrams/images/getFormsFieldAPIcall.png)
    3. getEmailTools - This operation corresponds configure personalization data through "Text & Personalization" component. This API call is intended to pull personalization data from Email Service and make it available in CQ author instance.
        ![image](https://raw.github.com/Adobe-Marketing-Cloud/experiencemanager-java-emailprovider/diagrams/images/getEmailToolsAPIcall.png)
    4. addToList - This operation is invoked when when subscriber actually submits the form which was previous configured on author instance. This API is invoked through configuration present at /libs/mcm/components/emailserviceactions/actions/addSubscriber/forward.jsp. This can be taken as reference to define other operations.
- For more details refer sample code provided.

