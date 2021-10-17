/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.mimacom.manager.tasklist.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TaskStatusService}.
 *
 * @author Brian Wing Shun Chan
 * @see TaskStatusService
 * @generated
 */
public class TaskStatusServiceWrapper
	implements ServiceWrapper<TaskStatusService>, TaskStatusService {

	public TaskStatusServiceWrapper(TaskStatusService taskStatusService) {
		_taskStatusService = taskStatusService;
	}

	@Override
	public com.mimacom.manager.tasklist.model.TaskStatus addTaskStatus(
			long groupId, long taskId, int type, int progress,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskStatusService.addTaskStatus(
			groupId, taskId, type, progress, serviceContext);
	}

	@Override
	public int countByType(long userId, int type) {
		return _taskStatusService.countByType(userId, type);
	}

	@Override
	public int countTaskId(long taskId) {
		return _taskStatusService.countTaskId(taskId);
	}

	@Override
	public com.mimacom.manager.tasklist.model.TaskStatus deleteTaskStatus(
			long taskStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskStatusService.deleteTaskStatus(taskStatusId);
	}

	@Override
	public java.util.List<com.mimacom.manager.tasklist.model.TaskStatus>
		findByTaskId(long taskId) {

		return _taskStatusService.findByTaskId(taskId);
	}

	@Override
	public java.util.List<com.mimacom.manager.tasklist.model.TaskStatus>
		findByTaskId(long taskId, int start, int end) {

		return _taskStatusService.findByTaskId(taskId, start, end);
	}

	@Override
	public java.util.List<com.mimacom.manager.tasklist.model.TaskStatus>
		findByType(long userId, int type) {

		return _taskStatusService.findByType(userId, type);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _taskStatusService.getOSGiServiceIdentifier();
	}

	@Override
	public TaskStatusService getWrappedService() {
		return _taskStatusService;
	}

	@Override
	public void setWrappedService(TaskStatusService taskStatusService) {
		_taskStatusService = taskStatusService;
	}

	private TaskStatusService _taskStatusService;

}