This module contains the java source code and java docs, which will guide you through the integration steps:

- com.day.cq.xemailservice.impl.XEmailServiceImpl is the main class, which implements EmailService class of com.day.cq.mcm.cq-mcm-emailprovider.
- CQ has a listener which will register all the classes implementing EmailService.
- The interface class has two main methods getName and execute, inherited from EmailService interface.
  a) "getName" method should return the name corresponding to the third party Email Service Provider's name. Please make sure that this value is same as the one configured 
during service config http://localhost:4502/crx/de/index.jsp#/libs/mcm/sampleemailservice/components/sampleemailservicepage for property name "providerName".
	b) "execute" method is the method which gets invoked for any action being performed for the configured Email Service.
	c) Call to the specific client APIs can be invoked on the basis of operation name, which be available through EmailServiceActions parameter being passed to execute method.
    d) These Email Service Provider's operations can be called from server call through actions, which can be configured at http://localhost:4502/crx/de/index.jsp#/libs/mcm/sampleemailservice/components/actionConfigurations (@refer parent README).
	e) Client APIs will be invoked through "execute" method, we have provided a client interface com.day.cq.xemailservice.XEmailServiceClient for reference. Object types
	use here should be replaced with  the client specific object types. These object types are just the placeholders.
	f) Email Provider's specific object construction can be done in com.day.cq.xemailservice.impl.XEmailServiceImpl by using "params" object map which is provided through "execute" method.
	e) These parameters can be configured with the action dialogs at http://localhost:4502/crx/de/index.jsp#/libs/mcm/sampleemailservice/components/actionConfigurations.
	
- com.day.cq.xemailservice.impl.XEmailServiceClientImpl is the class which inherits com.day.cq.xemailservice.XEmailServiceClient and should have the concrete implementation
to invoke client APIs.
