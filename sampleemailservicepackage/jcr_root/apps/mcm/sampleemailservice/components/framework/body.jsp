<%@page session="false"%><%--
  Copyright 1997-2009 Day Management AG
  Barfuesserplatz 6, 4001 Basel, Switzerland
  All Rights Reserved.

  This software is the confidential and proprietary information of
  Day Management AG, ("Confidential Information"). You shall not
  disclose such Confidential Information and shall use it only in
  accordance with the terms of the license agreement you entered into
  with Day.

  ==============================================================================



--%><%@page contentType="text/html"
            pageEncoding="utf-8"
            import="javax.jcr.Node,
                    java.util.Iterator,
                    com.day.cq.wcm.webservicesupport.Configuration,
                    org.apache.sling.api.resource.Resource"%><%
%><%@include file="/libs/foundation/global.jsp"%><%

    String id = currentPage.getName();
    String title = xssAPI.encodeForHTML(properties.get("jcr:title", id)); 
    String description = xssAPI.encodeForHTML(properties.get("jcr:description", ""));
    String cfgPath = null;
    try{
     cfgPath = currentPage.getParent().getPath();
    }catch(Exception e){
    	 log.error("Error while retrieving parent configuration", e);
    }
          
%><body>
    <div><cq:include path="trail" resourceType="cq/cloudserviceconfigs/components/trail"/></div>
    <p class="cq-clear-for-ie7"></p>
    <h1><%= title %></h1>
    <p><%= description %></p>
    <cq:include script="content.jsp" />
    <p>&nbsp;</p>
<% if(cfgPath!= null ){%>
    <input type="hidden"  name="cfgpath"  id="cfgpath" value="<%=cfgPath%>"/>
<%}%>    
</body>
