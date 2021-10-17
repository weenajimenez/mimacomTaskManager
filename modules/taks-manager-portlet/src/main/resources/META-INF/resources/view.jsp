<%@ include file="init.jsp" %>

<% 
	List<Task> taskList = (List<Task>)renderRequest.getAttribute(TaskListManagerPortletKeys.LIST_TASK);
	int totalTask = (Integer) renderRequest.getAttribute(TaskListManagerPortletKeys.TOTAL_TASKS);
	int totalFinishedTask = (Integer) renderRequest.getAttribute(TaskListManagerPortletKeys.TOTAL_FINISHED_TASKS);

	
	PieChartConfig _pieChartConfig = new PieChartConfig();

	_pieChartConfig.addColumns(
			new SingleValueColumn("Tareas por finalizar", (totalTask-totalFinishedTask)),
		    new SingleValueColumn("Tareas finalizadas", totalFinishedTask)
	);
%>

<liferay-portlet:renderURL var="newUrl" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
	<liferay-portlet:param name="mvcRenderCommandName" value="<%=TaskListManagerPortletKeys.NEW_TASK%>"/>
	<liferay-portlet:param name="backURL" value="<%= currentURL %>"/>
</liferay-portlet:renderURL>

<% if(totalTask > 2){ %>
	<div class="data_home">
		<div class="module_home total">
			<span class="title">
				<liferay-ui:message key="task.home.total" ></liferay-ui:message>
			</span>
			<i class="icon-qrcode"></i>
			<span  class="number"><%= totalTask %></span>
		</div>
		<div class="module_home finished">
			<span class="title">
				<liferay-ui:message key="task.home.finished" ></liferay-ui:message>
			</span>
			<i class="icon-check-sign"></i>
			<span  class="number"><%= totalFinishedTask %></span>
		</div>
		<div class="module_home toFinished">
			<span class="title">
				<liferay-ui:message key="task.home.to.finished" ></liferay-ui:message>
			</span>
			<i class="icon-refresh"></i>
			<span  class="number"><%= (totalTask-totalFinishedTask)%></span>
		</div>
		<chart:pie config="<%= _pieChartConfig %>" id="pieTask"/>
	</div>
<% } %>
<aui:button type="new" value="new" href="${newUrl}" icon="icon-plus"></aui:button>

<table id="taskListTable" class="table table-striped table-bordered">
	<thead>
		<tr>
			<th>id</th>
			<th>Título</th>
			<th>Descripción</th>
			<th>-</th>
		</tr>
	</thead>
	<tbody>
		<% for(Task task:taskList ){%>
		<liferay-portlet:renderURL var="editUrl" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
			<liferay-portlet:param name="mvcRenderCommandName" value="<%=TaskListManagerPortletKeys.EDIT_TASK%>"/>
			<liferay-portlet:param name="backURL" value="<%= currentURL %>"/>
			<liferay-portlet:param name="<%=TaskListManagerPortletKeys.ID_TASK%>" 
			value="<%= String.valueOf(task.getTaskId()) %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-portlet:actionURL var="deleteUrl" name="<%= TaskListManagerPortletKeys.DELETE_TASK %>">
			<liferay-portlet:param name="backURL" value="<%= currentURL %>"/>
			<liferay-portlet:param name="<%=TaskListManagerPortletKeys.ID_TASK%>" 
			value="<%= String.valueOf(task.getTaskId()) %>"/>
		</liferay-portlet:actionURL>
		
		<liferay-portlet:actionURL var="finishUrl" name="<%= TaskListManagerPortletKeys.FINISH_TASK %>">
			<liferay-portlet:param name="backURL" value="<%= currentURL %>"/>
			<liferay-portlet:param name="<%=TaskListManagerPortletKeys.ID_TASK%>" 
			value="<%= String.valueOf(task.getTaskId()) %>"/>
		</liferay-portlet:actionURL>
		
			<tr>
				<td><%= task.getTaskId() %></td>
				<td><%= task.getTitle() %></td>
				<td><%= task.getDescription() %></td>
				<td>
					<aui:button href="${finishUrl}" icon="icon-check-sign" value="task.status.finalizada"></aui:button>
				
					<aui:button href="${editUrl}" icon="icon-edit"></aui:button>
					
					<aui:button href="${deleteUrl}" icon="icon-trash"></aui:button>
				</td>
			</tr>
		<% }%>
	</tbody>
</table>
<script>
$(document).ready(function() {
$('#taskListTable').DataTable({
	"aLengthMenu": [5, 10, 25],
	"pageLength": 5,
	"columnDefs": [
        {
            "targets": [0],
            "visible": false,
            "searchable": true
        }
    ],
    order:[0,'desc'],
	rowReorder: true,
	"language": {
        "lengthMenu": "Mostrar _MENU_ tareas por página",
        "zeroRecords": "No hay tareas para listar",
        "info": "Página _PAGE_ de _PAGES_",
        "infoEmpty": "No hay registros",
        "infoFiltered": "(filtered from _MAX_ total)",
        "search": "Buscar:",
        "paginate": {
            "first": "Primero",
            "last": "Último",
            "next": "Siguiente",
            "previous": "Anterior"
        },
    }
});
} );
</script>