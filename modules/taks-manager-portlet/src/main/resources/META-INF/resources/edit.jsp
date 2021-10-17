<%@ include file="init.jsp" %>

<liferay-ui:header title="task.edit" backURL="<%= backURL %>"></liferay-ui:header> 

<liferay-portlet:actionURL var="saveUrl" name="<%= TaskListManagerPortletKeys.SAVE_TASK %>">
	<liferay-portlet:param name="backURL" value="<%= currentURL %>"/>
</liferay-portlet:actionURL>

<%  
	Task task = (Task)renderRequest.getAttribute(TaskListManagerPortletKeys.TASK);
	
	List<TaskStatus> taskStatusList = (List<TaskStatus>)renderRequest.getAttribute(TaskListManagerPortletKeys.LIST_TASK_STATUS);
	TaskStatus currentStatus = (TaskStatus) renderRequest.getAttribute(TaskListManagerPortletKeys.CURRENT_STATUS_TASK);
	int progress = 0;
	int type =0;
	if(currentStatus!=null){
		progress = currentStatus.getProgress();
		type = currentStatus.getType();
	}
	Map<Integer, String> types = new HashMap<>();
	types.put(0, "task.status.inicial");
    types.put(1, "task.status.inicial");
    types.put(2, "task.status.progreso");
    types.put(3, "task.status.bloqueada");
    types.put(4, "task.status.finalizada");
%>

<aui:form action="${saveUrl}">
	 <aui:model-context bean="<%= task %>" model="<%= Task.class %>"></aui:model-context>
	
	<aui:input name="taskId" type="hidden"></aui:input>
	<aui:input name="title" label="task.title" 
		disabled="<%= type==4?true:false %>" required="true"></aui:input>
	<aui:input name="description" required="true" type="textarea" label="task.description" 
		disabled="<%= type==4?true:false %>"></aui:input>
		
		
	
	<% if(task!=null && currentStatus!=null){ %>
	
	<aui:select name="type" model="<%= TaskStatus.class %>" disabled="<%= type==4?true:false %>">
		<aui:option selected="<%= currentStatus.getType()==1?true:false %>" value="1" label="task.status.inicial"></aui:option>
		<aui:option selected="<%= currentStatus.getType()==2?true:false %>" value="2" label="task.status.progreso"></aui:option>
		<aui:option selected="<%= currentStatus.getType()==3?true:false %>" value="3" label="task.status.bloqueada"></aui:option>
		<aui:option selected="<%= currentStatus.getType()==4?true:false %>" value="4" label="task.status.finalizada"></aui:option>
	</aui:select>
	
	<aui:input name="progress" type="range" min="0" max="100" 
		value="<%= progress %>" model="<%= TaskStatus.class %>" disabled="<%= type==4?true:false %>"></aui:input>
	<label id="taskProgress"><%= progress %>%</label>
	
	<% }else{ %>
		<aui:input name="type" model="<%= TaskStatus.class %>" value="1" type="hidden"></aui:input>
		<aui:input name="progress" model="<%= TaskStatus.class %>" value="0" type="hidden"></aui:input>
	<% } %>
	
	<aui:button-row> 
		<aui:button type="submit" value="save" disabled="<%= type==4?true:false %>"></aui:button>
		<aui:button type="cancel" value="cancel" href="<%= backURL %>"></aui:button>
	</aui:button-row>
</aui:form>

<% if(taskStatusList.size()>0){ %>
	<h3><liferay-ui:message key="task.status.title"></liferay-ui:message></h3>
	<ul>
	<% for(TaskStatus taskStatusItem:taskStatusList){%>
		<li> <%= taskStatusItem.getCreateDate() %>: 
	         <liferay-ui:message key="<%= types.get(taskStatusItem.getType()) %>"/>
	         [Progress: <%= taskStatusItem.getProgress() %>%]</li>
	<% 	} %>
	</ul>
<% 	} %>

<script type="text/javascript">
   $(document).ready(function() {
      $("#<portlet:namespace />type").change(function(){
         var intType = $(this).val();
         if(intType==4){
        	 $("#<portlet:namespace />progress").val(100);
        	 $("#taskProgress").hide();
        	 $("label[for='<portlet:namespace />progress']").hide();
        	 $("#<portlet:namespace />progress").hide();
        }
      });
   });
</script>
