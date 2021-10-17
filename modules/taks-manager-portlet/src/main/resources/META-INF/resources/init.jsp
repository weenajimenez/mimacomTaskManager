<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.frontend.taglib.chart.model.percentage.pie.PieChartConfig" %>
<%@page import="com.liferay.frontend.taglib.chart.model.SingleValueColumn" %>
<%@page import="com.mimacom.manager.listTask.constants.TaskListManagerPortletKeys"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.mimacom.manager.tasklist.model.Task"%>
<%@page import="com.mimacom.manager.tasklist.model.TaskStatus"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>
<%@ taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet"  %>
<%@ taglib prefix="liferay-theme" uri="http://liferay.com/tld/theme"  %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui"  %>

<%@ taglib prefix="chart" uri="http://liferay.com/tld/chart" %>


<script type = "text/javascript" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<link href ="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css"/>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
 String currentURL = PortalUtil.getCurrentURL(renderRequest);
 String backURL = ParamUtil.getString(renderRequest, "backURL");
%>