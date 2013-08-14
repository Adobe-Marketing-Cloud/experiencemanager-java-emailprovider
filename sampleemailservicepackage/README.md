This package specify concreate steps and reference documentation to integrate any third party Email Service provider with Day CQ 5.6.1.
- This package contains source code and a CQ package. Source code "sampleemailservice" has the sample email service calls and java docs, with the help of which full implementation should be done.
- CQ package "sampleemailservicepackage" is the final package which should be installed through package share. This package will install the "sampleemailservice" bundle and node content at "/apps/mcm/sampleemailservice".
- This package can be build using maven command "mvn clean install". Created zip package will be available inside "target" folder.
- Upload the package through package manager. http://localhost:4502/crx/packmgr/index.jsp and install it.
- This package will install
 1. Cloud service configuration inside "/etc/cloudservices/" with node name "sampleemailservice".

 2. Service configuration files like action configurations and java scrip library folders will be available inside /apps/mcm/sampleemailservice

Cloud configuration
- Cloud service configuration present at /etc/cloudservices/sampleemailservice
- Basic properties like - service name, service url, thumbnail path can be configured at /etc/cloudservices/sampleemailservice/jcr:content. e.g. - jcr:title will be used to show title, serviceAdminUrl property can be added to point to service url, thumbnailPath property can be added to point to path to thumbnail used for corresponding Email Service.
- /apps/mcm/sampleemailservice/components/sampleemailservicepage is used for cloud configuration dialog, which is done through http://localhost:4502/etc/cloudservices.html.
- Make sure value of /apps/mcm/sampleemailservice/components/sampleemailservicepage/dialog/items/general/items/providerName is same as the one returned from EmailService.getName(). Refer XEmailServiceImpl.getName().


Action Configuration
- Sample actions and javascipt files have been provided through /apps/mcm/sampleemailservice/components/actionConfigurations and /apps/mcm/sampleemailservice/widgets/xemailservice-clientlib.
- /apps/mcm/sampleemailservice/components/actionConfigurations  contains basic actions - addSubscriber, autoResponder and deleteSubscriber. These actions refers email service libraries /libs/mcm/emailservice-clientlib and custom libraris /apps/mcm/sampleemailservice/widgets/xemailservice-clientlib.
- Please note "category" property present inside /apps/mcm/sampleemailservice/widgets/xemailservice-clientlib. Its value is mcm.xemailservice. This category is being used to include js libraries through jsp, refer /apps/mcm/sampleemailservice/components/sampleemailservice/sampleemailservice.jsp.
- Sample code and it working has been described in README.md of sampleemailservice package, which contains all java code with documentation and code snippet.
