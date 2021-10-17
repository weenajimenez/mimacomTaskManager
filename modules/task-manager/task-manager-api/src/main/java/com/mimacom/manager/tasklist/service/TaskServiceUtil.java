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
 * Provides the remote service utility for Task. This utility wraps
 * <code>com.mimacom.manager.tasklist.service.impl.TaskServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TaskService
 * @generated
 */
public class TaskServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mimacom.manager.tasklist.service.impl.TaskServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.mimacom.manager.tasklist.model.Task addTask(
			long groupId, String title, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addTask(
			groupId, title, description, serviceContext);
	}

	public static int countbyUserId(long userId) {
		return getService().countbyUserId(userId);
	}

	public static int countbyUserIdAndGroupid(long userId, long groupId) {
		return getService().countbyUserIdAndGroupid(userId, groupId);
	}

	public static com.mimacom.manager.tasklist.model.Task deleteTask(
			long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTask(taskId);
	}

	public static com.mimacom.manager.tasklist.model.Task fetchTask(
		long taskId) {

		return getService().fetchTask(taskId);
	}

	public static java.util.List<com.mimacom.manager.tasklist.model.Task>
		findByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.mimacom.manager.tasklist.model.Task> orderByComparator) {

		return getService().findByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	public static com.mimacom.manager.tasklist.model.Task findByTaskId(
			long taskId)
		throws com.mimacom.manager.tasklist.exception.NoSuchTaskException {

		return getService().findByTaskId(taskId);
	}

	public static java.util.List<com.mimacom.manager.tasklist.model.Task>
		findByUserId(long userId) {

		return getService().findByUserId(userId);
	}

	public static java.util.List<com.mimacom.manager.tasklist.model.Task>
		findByUserId(long userId, int start, int end) {

		return getService().findByUserId(userId, start, end);
	}

	public static java.util.List<com.mimacom.manager.tasklist.model.Task>
		findByUserIdAndGroupId(long userId, long groupId) {

		return getService().findByUserIdAndGroupId(userId, groupId);
	}

	public static java.util.List<com.mimacom.manager.tasklist.model.Task>
		findByUserIdAndGroupId(long userId, long groupId, int start, int end) {

		return getService().findByUserIdAndGroupId(userId, groupId, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.mimacom.manager.tasklist.model.Task updateTask(
			long taskId, String title, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateTask(
			taskId, title, description, serviceContext);
	}

	public static TaskService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TaskService, TaskService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TaskService.class);

		ServiceTracker<TaskService, TaskService> serviceTracker =
			new ServiceTracker<TaskService, TaskService>(
				bundle.getBundleContext(), TaskService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}