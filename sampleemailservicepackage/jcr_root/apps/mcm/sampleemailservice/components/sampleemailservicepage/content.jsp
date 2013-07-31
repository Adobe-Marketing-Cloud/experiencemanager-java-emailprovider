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

<%@page session="false" contentType="text/html"
            pageEncoding="utf-8"%>
<%@include file="/libs/foundation/global.jsp"%>
<%@include file="/libs/cq/cloudserviceconfigs/components/configpage/init.jsp"%>
<%@include file="/libs/cq/cloudserviceconfigs/components/configpage/hideeditok.jsp"%>
<%@page session="false" import="com.day.cq.i18n.I18n,
						java.util.ResourceBundle" %>
<cq:includeClientLib categories="cq.personalization" />
<% String resPath = resource.getPath().replace("/jcr:content", ""); 
final ResourceBundle resourceBundle = slingRequest.getResourceBundle(null);
    I18n i18n = new I18n(resourceBundle);
    String[] successfulConfiguration  = {i18n.get("XEmailService configuration is successful. You can now add XEmailService to your site."),i18n.get("To use personalization from data extensions in your emails, please create framework"),i18n.get("Please apply the configuration to your websites")};
%>
<div>
    <h3>XEmail Service Settings</h3>
    <img src="<%=thumbnailPath%>" alt="<%=serviceName%>" style="float: left;" />
    <ul style="float: left; margin: 0px;">
        <li><div class="li-bullet"><strong><%=i18n.get("Username: ")%></strong><%= xssAPI.encodeForHTML(properties.get("username", "")) %></div></li>
        <li><div class="li-bullet"><strong><%=i18n.get("Password: ")%></strong><%= properties.get("password", "").replaceAll(".", "*") %></div></li>
        <li><div class="li-bullet"><strong><%=i18n.get("API End Point: ")%></strong><%= properties.get("apiendpoint", "") %></div></li>
        <li><div class="li-bullet"><strong><%=i18n.get("Account ID: ") %></strong><%= properties.get("accountId", "") %></div></li>
        <li class="config-successful-message when-config-successful" style="display: none"><%=successfulConfiguration[0] %><br><%=successfulConfiguration[2] %><a href="/siteadmin"> #.</a>
        <%=successfulConfiguration[1]%> <a href="javascript: CQ.cloudservices.editNewConfiguration('<%=resPath%>','<%=resPath%>', false, '<%=i18n.get("Create Framework") %>')" 
            style="color: #336600;" title="<%=i18n.get("Add new XEmailService framework")%>"><b>+</b></a>.
        </li>
    </ul>
    <div class="when-config-successful" style="display: none">
        <h2 style="border: none; margin-top: 10px; padding-left:0px;"><%=i18n.get("Available Frameworks")%>
        [<a href="javascript: CQ.cloudservices.editNewConfiguration('<%=resPath%>','<%=resPath%>', false, '<%=i18n.get("Create Framework") %>')" 
            style="color: #336600;" title="<%=i18n.get("Add new XEmailService framework")%>"><b>+</b></a>]
        </h2>
        <%@include file="/libs/cq/cloudserviceconfigs/components/childlist/childlist.jsp"%><%-- cq:include accepts no params --%>
        <%=printChildren(currentPage, request)%>
    </div>       
</div>
