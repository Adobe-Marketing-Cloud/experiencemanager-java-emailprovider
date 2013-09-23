This package specifies concrete steps and reference documentation to integrate any third party Email Service provider with Day CQ 5.6.1.

-	The final "myproject-content-1.0-SNAPSHOT" package contains an OSGI bundle and CQ content for sample integration.

#####OSGI bundle 
- "myproject-bundle-1.0-SNAPSHOT" contains server side java code, more information can be found [here](../sampleemailservice)

#####CQ content

######	Cloud configuration:
-	Cloud service configuration will be present at /etc/cloudservices/sampleemailservice
-	/apps/myproject/sampleemailservice/components/sampleemailservicepage is used for cloud configuration dialog, which is done through http://localhost:4502/etc/cloudservices.html.
-	Basic properties (service name, service url, thumbnail path, etc.) can be configured at /etc/cloudservices/sampleemailservice/jcr:content. e.g. - jcr:title will be used to show title, serviceAdminUrl property can be added to point to service url, thumbnailPath property can be added to point the thumbnail used for corresponding Email Service.
-	Make sure value of /apps/myproject/sampleemailservice/components/sampleemailservicepage/dialog/items/general/items/providerName is same as the one returned from EmailService.getName(). Refer XEmailServiceImpl.getName().

######	Action Configuration:
-	Service configuration files e.g. action configurations and java script library folders will be available inside /apps/myproject/sampleemailservice.
-	Sample actions and javascipt files have been provided through /apps/myproject/sampleemailservice/components/actionConfigurations and /apps/myproject/sampleemailservice/widgets/xemailservice-clientlib.
-	/apps/myproject/sampleemailservice/components/actionConfigurations contains basic actions - addSubscriber, autoResponder and deleteSubscriber. These actions refer email service libraries /libs/myproject/emailservice-clientlib and custom libraries /apps/myproject/sampleemailservice/widgets/xemailservice-clientlib.
-	Please note "category" property present inside /apps/myproject/sampleemailservice/widgets/xemailservice-clientlib. It's value is mcm.xemailservice. This category is being used to include js libraries through jsp, refer /apps/myproject/sampleemailservice/components/sampleemailservice/sampleemailservice.jsp.

####Build and install
-	Maven command "mvn -PautoInstallPackage clean install" will build and install "myproject-content-1.0-SNAPSHOT" package to the CQ server.
-	Package can be build and uploaded manually by using command "mvn clean install". Upload the package "myproject-content-1.0-SNAPSHOT" created inside "target" through package manager at http://localhost:4502/crx/packmgr/index.jsp and install it.
