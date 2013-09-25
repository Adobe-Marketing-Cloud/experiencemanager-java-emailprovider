/*************************************************************************
 * Copyright 2013 Adobe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **************************************************************************/
package com.mycompany.myproject.xemailservice.tests;

import com.adobe.cq.testing.client.MCMClient;
import com.adobe.cq.testing.util.CQIntegrationTestBase;
import com.adobe.granite.testing.ClientException;
import java.util.Date;
import static org.apache.http.HttpStatus.SC_OK;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import com.adobe.granite.testing.util.FormEntityBuilder;
import java.util.regex.Pattern;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.apache.sling.testing.tools.http.RequestExecutor;

public class XEmailIntegrationIT extends CQIntegrationTestBase{
	


	public static MCMClient authorAdmin = null;
	
	final static String username = "admin";
	final static String password = "admin";
	final static String parentPathForXEmail = "/etc/cloudservices/sampleemailservice";
	final static String pageTitleForXConfig = "TestXEMailConfig";
    static String pageNameForXConfig = "TestXEmail";
    static String XConfigPath=null;
    final static String XEmailtemplatePath = "/apps/myproject/sampleemailservice/templates/sampleemailservice"  ;
    final static String endpointURI = "https://webservice.s4.XEmailService.com/Service.asmx";

	

	@BeforeClass
	public static void configureXEmail() throws ClientException {
		
        
		authorAdmin =adminAuthor.getClient(MCMClient.class);
		/*
		 * Create sampleemailservice configuration
		 * 
		 */
		
		try{
			XConfigPath = authorAdmin.createPage(pageNameForXConfig + new Date().getTime() , pageTitleForXConfig, parentPathForXEmail, XEmailtemplatePath,SC_OK).getPath();
		}catch(Exception e){
			Assert.fail("Could not Create XMail Config"+e.getMessage());
		}
		
		FormEntityBuilder FB = new FormEntityBuilder();
		FB.addParameter("username", username)
		   .addParameter("password", password)
		   .addParameter("endpoint", "https://webservice.XEmailService.com/Service.asmx");
		
		/*
		 * Check if we can connect to sampleemailservice with given credentials.
		 * By default, username="admin" , password = "admin"
		 */
		
		try{
		authorAdmin.http.doPost(XConfigPath + "/_jcr_content.emailservice.json", FB.getEntity(), SC_OK);
		}
		catch (Exception e){
			Assert.fail("Cannot connect to Xemail-Service with given credentials"+e.getMessage());
		}
		
		/*
		 * save the configuration
		 */
		
		FB = new FormEntityBuilder();
		FB.addParameter("./sling:resourceType", "myproject/sampleemailservice/components/sampleemailservicepage")
		    .addParameter("_charset_", "utf-8")
		    .addParameter("./username", username)
		    .addParameter("./password", password)
		    .addParameter("./apiendpoint", endpointURI)		   
		    .addParameter("./providerName", "xemailservice")
			.addParameter("./cq:cloudservicename", "xemailservice")
			.addParameter("./cq:template", XEmailtemplatePath);
		
		try{
			authorAdmin.http.doPost(XConfigPath + "/_jcr_content", FB.getEntity(), SC_OK);
		} catch (Exception e){
			Assert.fail("Could not save configuration" + e.getMessage());
		}
		   		
	}
	
	/*
	 * Check for list returned by sampleemailservice
	 */
	
	@Test
	public void testgetLists(){
		RequestExecutor exec = null;
		try{
			
			String path = "/_jcr_content.emailservice.json?operation=getlist&cfgpath="+ XConfigPath ;
			exec = authorAdmin.http.doGet( path, SC_OK);
			String content = exec.getContent();
			assertNotNull(content);
		
			final Pattern p = Pattern.compile("\"name\":\"samplelist\"", Pattern.CASE_INSENSITIVE);
			if (!p.matcher(content).find())
				fail("Couldnot retreive sample mail list");
			
		}catch (Exception e) {
			Assert.fail("Could not retreive default attribute email from XMailService" + e.getMessage());
		}
	
	
	}
	/*
	 * Test for attributes of list for sampleemailservice
	 */
	@Test
	public void testGetFormFields(){
		RequestExecutor exec = null;
		try{
			String action = "mcm/components/emailserviceactions/actions/addSubscriber";
			String path = "/_jcr_content.emailservice.json?operation=getFormFields&cfgpath="+ XConfigPath + "&actionType=" + action;
			exec = authorAdmin.http.doGet( path, SC_OK);
			String content = exec.getContent();
			assertNotNull(content);
			
			final Pattern p = Pattern.compile("\"type\":\"email\"", Pattern.CASE_INSENSITIVE);
			if (!p.matcher(content).find())
				fail("Couldnot retreive Attribute--Email");
			
			
		}catch (Exception e) {
			Assert.fail("Could not retreive default attribute email from XMailService" + e.getMessage());
		}
	}

	/*
	 * delete the created sampleemailservice configuration
	 */
	
	@AfterClass
	public static void  deleteXConfiguration(){
		try{
			authorAdmin.deletePage(new String[] {XConfigPath}, true, false, SC_OK);
			}catch (Exception e){
				Assert.fail("Could not delete the XEmailConfiguration" + e.getMessage());
			}
	}
	
}
