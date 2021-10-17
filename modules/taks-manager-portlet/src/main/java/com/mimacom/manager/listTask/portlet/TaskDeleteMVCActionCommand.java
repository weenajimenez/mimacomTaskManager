package com.mimacom.manager.listTask.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.mimacom.manager.listTask.constants.TaskListManagerPortletKeys;
import com.mimacom.manager.tasklist.model.TaskStatus;
import com.mimacom.manager.tasklist.service.TaskService;
import com.mimacom.manager.tasklist.service.TaskStatusService;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + TaskListManagerPortletKeys.TASKLISTMANAGER,
			"mvc.command.name="+TaskListManagerPortletKeys.DELETE_TASK
		},
		service = MVCActionCommand.class
	)

public class TaskDeleteMVCActionCommand implements MVCActionCommand {

	private final Log _log = LogFactoryUtil.getLog(TaskDeleteMVCActionCommand.class);
	@Reference
	private TaskService _taskService;
	@Reference
	private TaskStatusService _taskStatusService;
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		long taskId = ParamUtil.getLong(actionRequest, TaskListManagerPortletKeys.ID_TASK);
		try {
			_taskService.deleteTask(taskId);
			deleteTaskStatusByTask(taskId);
			return true;
		} catch (PortalException e) {
			_log.error(e);
		}
		return false;
	}

	private void deleteTaskStatusByTask(long taskId) throws PortalException {
		
		List<TaskStatus> taskStatusList =_taskStatusService.findByTaskId(taskId);
		
		for(TaskStatus taskStatus:taskStatusList) {
			_taskStatusService.deleteTaskStatus(taskStatus.getTaskStatusId());
		}
	}
}
