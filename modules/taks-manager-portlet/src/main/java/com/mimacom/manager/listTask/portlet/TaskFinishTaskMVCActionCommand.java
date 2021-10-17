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
			"mvc.command.name="+TaskListManagerPortletKeys.FINISH_TASK
		},
		service = MVCActionCommand.class
	)

public class TaskFinishTaskMVCActionCommand implements MVCActionCommand {

	private final Log _log = LogFactoryUtil.getLog(TaskFinishTaskMVCActionCommand.class);
	@Reference
	private TaskStatusService _taskStatusService;
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		long taskId = ParamUtil.getLong(actionRequest, TaskListManagerPortletKeys.ID_TASK);
		int type = TaskListManagerPortletKeys.ID_FINISH_TASK;
		int progress = TaskListManagerPortletKeys.COMPLETE_PROGRESS;
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long groupId = themeDisplay.getScopeGroupId();
			_taskStatusService.addTaskStatus(groupId, taskId, type, progress, serviceContext);
			return true;
		} catch (PortalException e) {
			_log.error(e);
		}
		return false;
	}
}
