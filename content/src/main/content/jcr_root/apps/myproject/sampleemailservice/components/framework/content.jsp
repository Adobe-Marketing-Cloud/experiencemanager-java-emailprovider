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
            import="java.util.Iterator,
                    org.apache.sling.api.resource.Resource,
                "%><%
%><%@include file="/libs/foundation/global.jsp"%><%
//  Framework file should be implemented
String path = resource.getPath();
String cfgPath = path.endsWith(JcrConstants.JCR_CONTENT) ? path.substring(0, path.lastIndexOf(JcrConstants.JCR_CONTENT)) : path ; 
String resourceType = resource.getResourceType();

%>
<div id='CQ'> <!-- Create CQ div first, so tabs render on top -->

</div>
