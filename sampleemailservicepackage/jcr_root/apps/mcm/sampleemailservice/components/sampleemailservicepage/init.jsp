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

  Init script.

  Draws the WCM initialization code. This is usually called by the head.jsp
  of the page. If the WCM is disabled, no output is written.

  *******************************************************************************

--%>

<%@include file="/libs/foundation/global.jsp" %><%
%><%@page session="false" import="com.day.cq.wcm.api.WCMMode" %>
<cq:includeClientLib categories="cq.wcm.edit,cq.mcm"/>