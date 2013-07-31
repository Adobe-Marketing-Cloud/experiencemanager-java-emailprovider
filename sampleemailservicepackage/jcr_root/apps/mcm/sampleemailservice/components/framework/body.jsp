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

--%>

<%@page session="false"%>
<%@page contentType="text/html"
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
