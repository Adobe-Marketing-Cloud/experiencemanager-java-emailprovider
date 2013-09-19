Experience Manager SDK for Email Service Providers
==================================================

Java SDK for Adobe Experience Manager (Adobe CQ) to integrate an external Email Service Provider. The SDK covers email authoring, publishing and subscriber/list management.

Valid for
-------------
* Adobe Experience Manager 5.6.1


The SDK contains
-------------

* A Java source code project and a recommended Content Package structure
* Source code project "sampleemailservice" contains a sample implementation using the email service API calls and java docs.
* The POM lists the dependencies to CQ, apache and javax artifacts. Learn more about how to build AEM projects with Maven http://dev.day.com/docs/en/cq/aem-how-tos/development/how-to-build-aem-projects-using-apache-maven.html
* Content Package "sampleemailservicepackage" is the package which can be installed through Package Manager. Per default, this package will install the "sampleemailservice" bundle and node content at "/apps/mcm/sampleemailservice"
* In addition a sample Cloud Service configuration will be installed at /etc/cloudservices/sampleemailservice, which can be used to configure connectivity, API keys or server-end points to the 3rd party service
* Package will install service configuration nodes - components, templates and widgets at http://localhost:4502/crx/de/index.jsp#/apps/mcm/sampleemailservice.
    
1. *components/actionConfigurations* node has the dialogs to the actions or operations corresponding to the service. Required parameters can be provided to the servlet through these configuration nodes.  For sample example few configuration nodes are available.
2. *components/framework* corresponds to additional client side email service configuration, if any (Note: for more information you can refer already existing email service integration for ExactTarget and Silverpop available at http://localhost:4502/crx/de/index.jsp#/libs/mcm/). ExactTarget and Silverpop has additional configuration for personalization.
3. *components/newsletter* corresponds to publishing the newsletter to your email service provider.
4. *components/sampleemailservice* corresponds to the service page, when email service is added to the CQ page.
5. *components/sampleemailservicepage* corresponds to the cloud configuration page available while configuring the email service with CQ. For this sample there is property "componentReference" inside "/apps/mcm/sampleemailservice".
6. templates corresponds to the couldservice configuration of email service.
7. widgets corresponds to the client specific libraries i.e. you can write your own scripts. Please note the "categories="[mcm.xemailservice]", this is in sync with the http://localhost:4502/crx/de/index.jsp#/apps/mcm/sampleemailservice/components/sampleemailservice/sampleemailservice.jsp.
8. More details can be found inside the respective folders. [JAVA sample code](sampleemailservice/README.md) and [Cloudconfig and UI action configuration] ( sampleemailservicepackage/README.md)

####Build steps

1. Build sampleemailservice using maven command "mvn clean install". This command will create osgi bundle inside "target" folder. 
2. Build sampleemailservicepackage using maven command "mvn clean install". This command will create CQ package inside "target" folder. This package has sampleemailservice bundle packaged together with js and jsp files, which are required for sample integration.

####Deploy Steps

1. Download and start the latest AEM quickstart. Refer [link](http://dev.day.com/docs/en/cq/current/exploring.html)
2. Upload and install "sampleemailservicepackage" package created in build steps through http://localhost:4502/crx/packmgr/index.jsp. More info can be found [here](http://dev.day.com/docs/en/cq/current/administering/package_manager.html#Uploading Packages from Your File System).

####Sample workflow

1. After deploying "sampleemailservicepackage", configure the cloud configuration service through http://localhost:4502/etc/cloudservices.html.
2. Select "Sample Email Service" and configure it using dummy data. username - admin and password - admin.
3. Sample email provider integration steps are available [here](http://dev.day.com/docs/en/cq/current/wcm/campaigns.html#Integrating Email Service Provider with an email).



