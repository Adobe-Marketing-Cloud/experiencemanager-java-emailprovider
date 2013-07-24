Experience Manager SDK for Email Service Providers
==================================================

Java SDK for Adobe Experience Manager (Adobe CQ) to integrate an external Email Service Provider. The SDK convers email authoring, publishing and subscriber/list management.

Valid for:
- Adobe Experience Manager 5.6.0
- Adobe Experience Manager 5.6.1
 

==================================================

1) This sample code specify concrete steps and reference documentation to integrate any third party Email Service provider with Day CQ 5.6.1.
2) This package contains source code and a CQ package. Source code "sampleemailservice" has the sample email service calls and java docs, with the help of which full implementation should be done.
3) There are dependencies on some CQ, apache and javax artifacts.
4) CQ package "sampleemailservicepackage" is the final package which should be installed through package share. This package will install the "sampleemailservice" bundle and node content at "/libs/mcm/sampleemailservice".
5) In addition sample cloud service configuration will be installed at /etc/cloudservices/sampleemailservice, which should modified with correct serviceurl, serviceAdminUrl etc.
6) Package will install service configuration nodes - components, templates and widgets at http://localhost:4502/crx/de/index.jsp#/libs/mcm/sampleemailservice.
    
        a) components/actionConfigurations node has the dialogs to the actions or operations corresponding to the service. Required parameters can be provided to the servlet through these configuration nodes.  For sample example few configuration nodes are available.
        b) components/framework corresponds to additional client side email service configuration, if any (Note: for more information you can refer already existing email service integration for ExtactTarget and SilverPop available at http://localhost:4502/crx/de/index.jsp#/libs/mcm/). ExactTarget and SilverPop has additional configuration for personalization.
        c) components/newsletter corresponds to publishing the newsletter to your email service provider.
        d) components/sampleemailservice and components/sampleemailservicepage corresponds to the could configuration page available while configuring the email service with CQ. For this sample there is property "componentReference" inside "/libs/mcm/sampleemailservice".
        e) templates corresponds to the couldservice configuration of email service.
        f) widgets corresponds to the client specific libraries i.e. you can write your own scripts. Please note the "categories="[mcm.xemailservice]", this is in sync with the http://localhost:4502/crx/de/index.jsp#/libs/mcm/sampleemailservice/components/sampleemailservice/sampleemailservice.jsp.
    


