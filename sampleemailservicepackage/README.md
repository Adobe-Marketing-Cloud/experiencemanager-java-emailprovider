This package specifies concrete steps and reference documentation to integrate any third party Email Service provider with Day CQ 5.6.1.

-	The final "sampleemailservicepackage" package contains an OSGI bundle and CQ content for sample integration.

#####OSGI bundle 
- "sampleemailservice" contains server side java code, more information can be found [here](../sampleemailservice)

#####CQ content

######	Cloud configuration:
-	Cloud service configuration will be present at /etc/cloudservices/sampleemailservice
-	/apps/mcm/sampleemailservice/components/sampleemailservicepage is used for cloud configuration dialog, which is done through http://localhost:4502/etc/cloudservices.html.
-	Basic properties (service name, service url, thumbnail path, etc.) can be configured at /etc/cloudservices/sampleemailservice/jcr:content. e.g. - jcr:title will be used to show title, serviceAdminUrl property can be added to point to service url, thumbnailPath property can be added to point the thumbnail used for corresponding Email Service.
-	Make sure value of /apps/mcm/sampleemailservice/components/sampleemailservicepage/dialog/items/general/items/providerName is same as the one returned from EmailService.getName(). Refer XEmailServiceImpl.getName().

######	Action Configuration:
-	Service configuration files e.g. action configurations and java script library folders will be available inside /apps/mcm/sampleemailservice.
-	Sample actions and javascipt files have been provided through /apps/mcm/sampleemailservice/components/actionConfigurations and /apps/mcm/sampleemailservice/widgets/xemailservice-clientlib.
-	/apps/mcm/sampleemailservice/components/actionConfigurations contains basic actions - addSubscriber, autoResponder and deleteSubscriber. These actions refer email service libraries /libs/mcm/emailservice-clientlib and custom libraries /apps/mcm/sampleemailservice/widgets/xemailservice-clientlib.
-	Please note "category" property present inside /apps/mcm/sampleemailservice/widgets/xemailservice-clientlib. It's value is mcm.xemailservice. This category is being used to include js libraries through jsp, refer /apps/mcm/sampleemailservice/components/sampleemailservice/sampleemailservice.jsp.

####Build and install
-	CQ "sampleemailservicepackage" package can be build using maven command "mvn clean install". Created zip will be available in “target” folder which should be installed through package share.
-	Upload the package through package manager at http://localhost:4502/crx/packmgr/index.jsp and install it.
