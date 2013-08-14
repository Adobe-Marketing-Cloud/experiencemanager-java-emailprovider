<%--

  *******************************************************************************

  Copyright 2013 Adobe

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

  *******************************************************************************

  Default body script.

  Draws the HTML body with the page content.

  *******************************************************************************

--%>
<%@page session="false" import="com.day.cq.wcm.webservicesupport.ConfigurationManager,
                com.day.cq.wcm.webservicesupport.Configuration,
                org.apache.sling.api.resource.Resource,
                org.apache.sling.api.resource.ValueMap,
                javax.jcr.Property,
                javax.jcr.Node,
                javax.jcr.Value,
                java.util.Iterator,
                com.day.cq.wcm.api.WCMMode"%><%
%><%@include file="/libs/foundation/global.jsp" %><%
%>
<%
if(WCMMode.fromRequest(request)==WCMMode.EDIT || WCMMode.fromRequest(request)==WCMMode.PREVIEW){
	%><cq:includeClientLib categories="mcm.xemailservice" /><%
	ConfigurationManager cfgMgr = (ConfigurationManager)sling.getService(ConfigurationManager.class);
	
	Configuration configuration = null;
	String[] services = pageProperties.getInherited("cq:cloudserviceconfigs", new String[]{});
	if(cfgMgr != null) {
        //here sampleemailservice corresponds to the node name of your service inside /etc/cloudservices/
	    configuration = cfgMgr.getConfiguration("sampleemailservice", services);
	}
	if(configuration != null ){%>
	    <input type="hidden"  name="cfgpath"  id="cfgpath" value="<%=configuration.getPath()%>"/>
	<%}
	String entityId = pageProperties.get("entityID",String.class);
	if(entityId!=null){%>
	<input type="hidden" id="published_html_attr" value="true" name="published_html_attr">
	<%}
}
%>