package com.day.cq.xemailservice.servlets;


import com.day.cq.xemailservice.XEmailServiceClient;
import com.day.cq.xemailservice.XEmailServiceException;
import com.day.cq.xemailservice.impl.XEmailServiceClientImpl;
import com.day.cq.mcm.emailprovider.service.EmailServiceProvider;
import com.day.cq.wcm.webservicesupport.Configuration;
import com.day.cq.wcm.webservicesupport.ConfigurationManager;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceUtil;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * Servlet class that listens for specific email provider requests. Update the "sling.servlet.selectors" property with your service
 * provider name. Listed the sample call for specific action  "viewPublishedEmail"
 */
@Component
@Service 
@Properties(value = { @Property(name = "sling.servlet.extensions", value = "json", propertyPrivate = true),
    @Property(name = "sling.servlet.selectors", value = "xemailservice", propertyPrivate = true),
    @Property(name = "sling.servlet.resourceTypes", value = "sling/servlet/default"),
    @Property(name = "sling.servlet.methods", value = { "POST", "GET" }, propertyPrivate = true) })
@SuppressWarnings("serial")
public class XEmailServiceSpecificActionsServlet extends SlingAllMethodsServlet {

	private static final String CONFIGURATION_PATH = "cfgpath";
	
    private static final String PARAM_ERROR = "error";

    private static final String ENCODING_UTF_8 = "utf-8";

    private static final String CONTENT_TYPE_JSON = "application/json";
    
    private static final String PARAM_NEWSLETTER = "newsletter";

    /** operation to check credentials with a API call */

    private static final String PARAM_OPERATION = "operation";

    private static final String OPERATION_VIEW_PUBLISHED_EMAIL = "viewPublishedEmail";

    @Reference
    private EmailServiceProvider emailServiceProvider;
    
    @Reference
    private ConfigurationManager cfgMgr;
    
    
    /**
	 * 
	 */
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
	 * 
	 */
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE_JSON);
        response.setCharacterEncoding(ENCODING_UTF_8);
        
        String errorMsg = "";
        try {
            handleRequest(request, response);
        } catch (Exception e) {

            if (e.getCause() instanceof UnknownHostException) {
                errorMsg = "Could not connect to " + e.getCause().getMessage();
            } else {
                errorMsg = "An exception occured.<br>" + e.getMessage();
            }
            PrintWriter out = response.getWriter();
            writeResponse(out, PARAM_ERROR, errorMsg);
        }
    }

    private void handleRequest(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws XEmailServiceException, IOException {
        
        String operation = request.getParameter(PARAM_OPERATION);
        if(OPERATION_VIEW_PUBLISHED_EMAIL.equals(operation)) {
        	handleViewPublishedEmail(request, response);
        } else {
            throw new XEmailServiceException("requested operation " + operation + " is not supported");
        }
    }

   
	private void handleViewPublishedEmail(SlingHttpServletRequest request,
			SlingHttpServletResponse response) throws IOException, XEmailServiceException {
    	String newsletter = request.getParameter(PARAM_NEWSLETTER);
    	if(newsletter==null)
    	{
    		writeResponse(response.getWriter(),PARAM_ERROR,"Missing request parameters");
    		return;
    	}
        Configuration config = getConfiguration(request, response,false);
        if(config != null) { 
            XEmailServiceClient client = new XEmailServiceClientImpl(config);
            //call to specific action or API can be done here.
        }
        else
        	writeResponse(response.getWriter(),PARAM_ERROR,"Email Service Configuration Missing or not provided");
	}


    private Configuration getConfiguration(SlingHttpServletRequest request, SlingHttpServletResponse response,boolean formSubmission) throws IOException {
        Configuration config = null;
        String path;
        if(!formSubmission)
        	 path = request.getParameter(CONFIGURATION_PATH);
        else
        {
            final ValueMap values = ResourceUtil.getValueMap(request.getResource());
            path = values.get(CONFIGURATION_PATH,String.class);
        }
        if (path != null) {
            config = cfgMgr.getConfiguration(path);
        }
        if (config == null && !formSubmission) {
        	writeResponse(response.getWriter(), PARAM_ERROR, "Configuration '" + path + "' not found");
        }
        return config;
    }    

    private void writeResponse(PrintWriter out, Map<String, String> keyValuePair)
    {
    	JSONObject json = new JSONObject();
        try 
        {
            for(Map.Entry<String, String> entry : keyValuePair.entrySet())
            {
            	json.put(entry.getKey(), entry.getValue());
            }
            out.write(json.toString());
        } catch (JSONException e) {
            //logging
        } finally {
            out.flush();
        }    	
	}

	/**
     * Writes a {@link JSONObject} response to the {@link SlingHttpServletResponse}. The parameter <code>msg</code> is written to the
     * property <code>propertyname</code> in the JSON object.
     * 
     * @param out
     * @param propertyname
     * @param msg
     */
    private void writeResponse(PrintWriter out, String propertyname, String msg) {
        JSONObject returnValue = new JSONObject();
        try {
            returnValue.put(propertyname, msg);
            out.write(returnValue.toString());
        } catch (JSONException e) {
            //logging
        } finally {
            out.flush();
        }
    }

    
}
