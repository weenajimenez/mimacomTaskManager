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
 * Provides a wrapper for {@link TaskService}.
 *
 * @author Brian Wing Shun Chan
 * @see TaskService
 * @generated
 */
public class TaskServiceWrapper
	implements ServiceWrapper<TaskService>, TaskService {

	public TaskServiceWrapper(TaskService taskService) {
		_taskService = taskService;
	}

	@Override
	public com.mimacom.manager.tasklist.model.Task addTask(
			long groupId, String title, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskService.addTask(
			groupId, title, description, serviceContext);
	}

	@Override
	public int countbyUserId(long userId) {
		return _taskService.countbyUserId(userId);
	}

	@Override
	public int countbyUserIdAndGroupid(long userId, long groupId) {
		return _taskService.countbyUserIdAndGroupid(userId, groupId);
	}

	@Override
	public com.mimacom.manager.tasklist.model.Task deleteTask(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskService.deleteTask(taskId);
	}

	@Override
	public com.mimacom.manager.tasklist.model.Task fetchTask(long taskId) {
		return _taskService.fetchTask(taskId);
	}

	@Override
	public java.util.List<com.mimacom.manager.tasklist.model.Task>
		findByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.mimacom.manager.tasklist.model.Task> orderByComparator) {

		return _taskService.findByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	@Override
	public com.mimacom.manager.tasklist.model.Task findByTaskId(long taskId)
		throws com.mimacom.manager.tasklist.exception.NoSuchTaskException {

		return _taskService.findByTaskId(taskId);
	}

	@Override
	public java.util.List<com.mimacom.manager.tasklist.model.Task> findByUserId(
		long userId) {

		return _taskService.findByUserId(userId);
	}

	@Override
	public java.util.List<com.mimacom.manager.tasklist.model.Task> findByUserId(
		long userId, int start, int end) {

		return _taskService.findByUserId(userId, start, end);
	}

	@Override
	public java.util.List<com.mimacom.manager.tasklist.model.Task>
		findByUserIdAndGroupId(long userId, long groupId) {

		return _taskService.findByUserIdAndGroupId(userId, groupId);
	}

	@Override
	public java.util.List<com.mimacom.manager.tasklist.model.Task>
		findByUserIdAndGroupId(long userId, long groupId, int start, int end) {

		return _taskService.findByUserIdAndGroupId(userId, groupId, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _taskService.getOSGiServiceIdentifier();
	}

	@Override
	public com.mimacom.manager.tasklist.model.Task updateTask(
			long taskId, String title, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskService.updateTask(
			taskId, title, description, serviceContext);
	}

	@Override
	public TaskService getWrappedService() {
		return _taskService;
	}

	@Override
	public void setWrappedService(TaskService taskService) {
		_taskService = taskService;
	}

	private TaskService _taskService;

}