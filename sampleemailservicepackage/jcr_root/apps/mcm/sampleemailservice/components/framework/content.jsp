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
