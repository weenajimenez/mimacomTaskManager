package com.mimacom.manager.listTask.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.mimacom.manager.listTask.constants.TaskListManagerPortletKeys;
import com.mimacom.manager.tasklist.model.Task;
import com.mimacom.manager.tasklist.model.TaskStatus;
import com.mimacom.manager.tasklist.service.TaskService;
import com.mimacom.manager.tasklist.service.TaskStatusService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + TaskListManagerPortletKeys.TASKLISTMANAGER,
			"mvc.command.name="+TaskListManagerPortletKeys.ROOT_TASK
		},
		service = MVCRenderCommand.class
	)

public class TaskListRenderCommand implements MVCRenderCommand {

	@Reference
	private TaskService _taskService;
	
	@Reference
	private TaskStatusService _taskStatusService;
	
	private final Log _log = LogFactoryUtil.getLog(TaskSaveMVCActionCommand.class);
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		List<Task> taskList = new ArrayList<Task>();
		
		int taskTotal = 0;
		int finishedTaskTotal = 0;
		
		long userId=0;
		
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
			userId = serviceContext.getUserId();
			taskList = _taskService.findByUserId(userId);
			taskTotal = _taskService.countbyUserId(userId);
			finishedTaskTotal = _taskStatusService.countByType(userId, TaskListManagerPortletKeys.ID_FINISH_TASK);
		} catch (PortalException e) {
			_log.error(e);
		}
		
		renderRequest.setAttribute(TaskListManagerPortletKeys.LIST_TASK, taskList);
		renderRequest.setAttribute(TaskListManagerPortletKeys.TOTAL_TASKS, taskTotal);
		renderRequest.setAttribute(TaskListManagerPortletKeys.TOTAL_FINISHED_TASKS, finishedTaskTotal);
		
		return "/view.jsp";
	}
}
