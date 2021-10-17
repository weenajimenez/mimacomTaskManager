package com.mimacom.manager.listTask.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.mimacom.manager.listTask.constants.TaskListManagerPortletKeys;
import com.mimacom.manager.tasklist.service.TaskService;
import com.mimacom.manager.tasklist.service.TaskStatusService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + TaskListManagerPortletKeys.TASKLISTMANAGER,
			"mvc.command.name="+TaskListManagerPortletKeys.SAVE_TASK
		},
		service = MVCActionCommand.class
	)

public class TaskSaveMVCActionCommand implements MVCActionCommand {

	private final Log _log = LogFactoryUtil.getLog(TaskSaveMVCActionCommand.class);
	@Reference
	private TaskService _taskService;
	
	@Reference
	private TaskStatusService _taskStatusService;
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		String taskTitle = ParamUtil.getString(actionRequest, "title");
		String taskDescription = ParamUtil.getString(actionRequest, "description");
		
		int type = ParamUtil.getInteger(actionRequest, "type");
		int progress = ParamUtil.getInteger(actionRequest, "progress");
		
		long taskId = ParamUtil.getLong(actionRequest, TaskListManagerPortletKeys.ID_TASK);
		
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long groupId = themeDisplay.getScopeGroupId();
			if(taskId==0){
				taskId = _taskService.addTask(groupId, taskTitle, taskDescription, serviceContext).getTaskId();
			}else {
				taskId = _taskService.updateTask(taskId, taskTitle, taskDescription, serviceContext).getTaskId();
			}
			addStatusToTask(groupId,taskId, type, progress, serviceContext);
			return true;
		} catch (PortalException e) {
			_log.error(e);
		}
		return false;
	}
	
	
	private void addStatusToTask(long groupId,long taskId, int type, 
			int progress, ServiceContext serviceContext)
	{
			try {
				_taskStatusService.addTaskStatus(groupId, taskId, type, progress, serviceContext);
			} catch (PortalException e) {
				_log.error(e);
			}
	}
}
