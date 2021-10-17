package com.mimacom.manager.listTask.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.mimacom.manager.listTask.constants.TaskListManagerPortletKeys;
import com.mimacom.manager.tasklist.model.Task;
import com.mimacom.manager.tasklist.model.TaskStatus;
import com.mimacom.manager.tasklist.service.TaskService;
import com.mimacom.manager.tasklist.service.TaskStatusService;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + TaskListManagerPortletKeys.TASKLISTMANAGER,
			"mvc.command.name="+TaskListManagerPortletKeys.NEW_TASK,
			"mvc.command.name="+TaskListManagerPortletKeys.EDIT_TASK
		},
		service = MVCRenderCommand.class
	)

public class TaskEditRenderCommand implements MVCRenderCommand {

	private final Log _log = LogFactoryUtil.getLog(TaskEditRenderCommand.class);
	
	@Reference
	private TaskService _taskService;
	
	@Reference
	private TaskStatusService _taskStatusService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long taskId = ParamUtil.getLong(renderRequest, TaskListManagerPortletKeys.ID_TASK);
		
		Task task = null;
		List<TaskStatus> taskStatusList = new ArrayList<TaskStatus>();
		
		if(taskId > 0) {
			task = _taskService.fetchTask(taskId);
			taskStatusList = _taskStatusService.findByTaskId(taskId);
		}
		
		renderRequest.setAttribute(TaskListManagerPortletKeys.TASK, task);
		renderRequest.setAttribute(TaskListManagerPortletKeys.LIST_TASK_STATUS, taskStatusList);
		renderRequest.setAttribute(TaskListManagerPortletKeys.CURRENT_STATUS_TASK, getCurrentStatus(taskStatusList));
		
		return "/edit.jsp";
	}

	private TaskStatus getCurrentStatus(List<TaskStatus> taskStatusList) {
		if(taskStatusList.size()>0) {
			return taskStatusList.get(taskStatusList.size()-1);
		}
		return null;
	}

}
