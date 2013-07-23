if(CQ.mcm && CQ.mcm.utils.Newsletter){
	CQ.mcm.utils.Newsletter.XEmailService = CQ.mcm.utils.Newsletter.XEmailService || {};
	
	CQ.mcm.utils.Newsletter.XEmailService.PUBLISH_DIALOG_PATH = "/libs/mcm/sampleemailservice/components/newsletter/publish/dialog.infinity.json";
	 //publish dialog path, which can be customized as per requirement at the location above)
	CQ.mcm.utils.Newsletter.publishDialogPath= CQ.mcm.utils.Newsletter.XEmailService.PUBLISH_DIALOG_PATH;

	//@refer ExactTarget.js for more information http://localhost:4502/crx/de/index.jsp#/libs/mcm/exacttarget
	//successful publish callback , enables the view published newsletter button
	//to visit the published newsletter
	CQ.mcm.utils.Newsletter.onPublishSuccess = function(dialog){
		try
		{
			//@refer ExactTarget.js for more information http://localhost:4502/crx/de/index.jsp#/libs/mcm/exacttarget
		}
		catch(e)
		{
			CQ.Log.debug("Could not render button#ViewPublishedNewsletter: {0}", e.message);
		}
	}
	 

	
}

//Dialog paths to Email service specific actions. Dialogs can be modified as required. For more information refer http://localhost:4502/crx/de/index.jsp#/libs/mcm/exacttarget/components/actionConfigurations/
if(CQ.EmailServiceActionsConfig && CQ.EmailServiceActionsConfig.actionsDialogPath){
	CQ.EmailServiceActionsConfig.actionsDialogPath[CQ.EmailServiceActionsConfig.ADD_SUBSCRIBER] = "/libs/mcm/sampleemailservice/components/actionConfigurations/addSubscriber/dialog.infinity.json";
	CQ.EmailServiceActionsConfig.actionsDialogPath[CQ.EmailServiceActionsConfig.DELETE_SUBSCRIBER] = "/libs/mcm/sampleemailservice/components/actionConfigurations/deleteSubscriber/dialog.infinity.json";
	CQ.EmailServiceActionsConfig.actionsDialogPath[CQ.EmailServiceActionsConfig.AUTO_RESPONDER] = "/libs/mcm/sampleemailservice/components/actionConfigurations/autoResponder/dialog.infinity.json";
}

CQ.EmailServiceActionsConfig.XEmailService = CQ.EmailServiceActionsConfig.XEmailService ||{};

//This script will call server for desired forms field which should be shown to the client, specific implementation can be provided at the server side.
CQ.EmailServiceActionsConfig.XEmailService.showFormFields = function(component){
	//For more information refer http://localhost:4502/crx/de/index.jsp#/libs/mcm/exacttarget/widgets
};