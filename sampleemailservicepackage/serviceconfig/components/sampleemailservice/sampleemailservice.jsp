<%--
  Copyright 1997-2009 Day Management AG
  Barfuesserplatz 6, 4001 Basel, Switzerland
  All Rights Reserved.

  This software is the confidential and proprietary information of
  Day Management AG, ("Confidential Information"). You shall not
  disclose such Confidential Information and shall use it only in
  accordance with the terms of the license agreement you entered into
  with Day.

  ==============================================================================

  Default body script.

  Draws the HTML body with the page content.

  ==============================================================================

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
	    configuration = cfgMgr.getConfiguration("xemailservice", services);
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