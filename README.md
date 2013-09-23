Experience Manager SDK for Email Service Providers
==================================================

Java SDK for Adobe Experience Manager (Adobe CQ) to integrate an external Email Service Provider. The SDK covers email authoring, publishing and subscriber/list management.

Valid for
-------------
* Adobe Experience Manager 5.6.1


The SDK contains
-------------

* A Java source code project and a recommended Content Package structure.
* Module "bundle" contains a sample implementation using the email service API calls and java docs.
* Module "content" contains CRX content node structure and required configuration.
* Build and upload package using build and deploy steps, mentioned below.
* Package will install the "myproject-bundle-1.0-SNAPSHOT.jar" bundle at "/apps/myproject/install".
* In addition a sample Cloud Service configuration will be installed at /etc/cloudservices/sampleemailservice, which can be used to configure connectivity, API keys or server-end points to the 3rd party service.
* Package will install service configuration nodes - components, templates and widgets at http://localhost:4502/crx/de/index.jsp#/apps/myproject/sampleemailservice.
    
1. *components/actionConfigurations* node has the dialogs to the actions or operations corresponding to the service. Required parameters can be provided to the servlet through these configuration nodes.  For sample example few configuration nodes are available.
2. *components/framework* corresponds to additional client side email service configuration, if any (Note: for more information you can refer already existing email service integration for ExactTarget and Silverpop available at http://localhost:4502/crx/de/index.jsp#/libs/mcm/). ExactTarget and Silverpop has additional configuration for personalization.
3. *components/newsletter* corresponds to publishing the newsletter to your email service provider.
4. *components/sampleemailservice* corresponds to the service page, when email service is added to the CQ page.
5. *components/sampleemailservicepage* corresponds to the cloud configuration page available while configuring the email service with CQ. For this sample there is property "componentReference" inside "/apps/myproject/sampleemailservice".
6. *templates* corresponds to the couldservice configuration of email service.
7. *widgets* corresponds to the client specific libraries i.e. you can write your own scripts. Please note the "categories="[mcm.xemailservice]", this is in sync with the http://localhost:4502/crx/de/index.jsp#/apps/myproject/sampleemailservice/components/sampleemailservice/sampleemailservice.jsp.
8. More details can be found inside the respective folders. [JAVA sample code](bundle/README.md) and [Cloudconfig and UI action configuration] ( content/README.md)

####Build and deploy steps

- Project can be build and installed through maven command "mvn -PautoInstallPackage clean install".

####Sample workflow

1. After deploying crx package, configure the cloud configuration service through http://localhost:4502/etc/cloudservices.html.
2. Select "Sample Email Service" and configure it using dummy data. username - admin and password - admin.
3. Sample email provider integration steps are available [here](http://dev.day.com/docs/en/cq/current/wcm/campaigns.html#Integrating Email Service Provider with an email).



