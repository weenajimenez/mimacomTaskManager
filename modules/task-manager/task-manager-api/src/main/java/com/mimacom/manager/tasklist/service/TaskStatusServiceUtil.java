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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for TaskStatus. This utility wraps
 * <code>com.mimacom.manager.tasklist.service.impl.TaskStatusServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TaskStatusService
 * @generated
 */
public class TaskStatusServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mimacom.manager.tasklist.service.impl.TaskStatusServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.mimacom.manager.tasklist.model.TaskStatus addTaskStatus(
			long groupId, long taskId, int type, int progress,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addTaskStatus(
			groupId, taskId, type, progress, serviceContext);
	}

	public static int countByType(long userId, int type) {
		return getService().countByType(userId, type);
	}

	public static int countTaskId(long taskId) {
		return getService().countTaskId(taskId);
	}

	public static com.mimacom.manager.tasklist.model.TaskStatus
			deleteTaskStatus(long taskStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTaskStatus(taskStatusId);
	}

	public static java.util.List<com.mimacom.manager.tasklist.model.TaskStatus>
		findByTaskId(long taskId) {

		return getService().findByTaskId(taskId);
	}

	public static java.util.List<com.mimacom.manager.tasklist.model.TaskStatus>
		findByTaskId(long taskId, int start, int end) {

		return getService().findByTaskId(taskId, start, end);
	}

	public static java.util.List<com.mimacom.manager.tasklist.model.TaskStatus>
		findByType(long userId, int type) {

		return getService().findByType(userId, type);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static TaskStatusService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TaskStatusService, TaskStatusService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TaskStatusService.class);

		ServiceTracker<TaskStatusService, TaskStatusService> serviceTracker =
			new ServiceTracker<TaskStatusService, TaskStatusService>(
				bundle.getBundleContext(), TaskStatusService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}