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
 * Provides the local service utility for TaskStatus. This utility wraps
 * <code>com.mimacom.manager.tasklist.service.impl.TaskStatusLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TaskStatusLocalService
 * @generated
 */
public class TaskStatusLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mimacom.manager.tasklist.service.impl.TaskStatusLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.mimacom.manager.tasklist.model.TaskStatus addTaskStatus(
			long groupId, long taskId, int type, int progress,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addTaskStatus(
			groupId, taskId, type, progress, serviceContext);
	}

	/**
	 * Adds the task status to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TaskStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param taskStatus the task status
	 * @return the task status that was added
	 */
	public static com.mimacom.manager.tasklist.model.TaskStatus addTaskStatus(
		com.mimacom.manager.tasklist.model.TaskStatus taskStatus) {

		return getService().addTaskStatus(taskStatus);
	}

	public static int countByType(long userId, int type) {
		return getService().countByType(userId, type);
	}

	public static int countTaskId(long taskId) {
		return getService().countTaskId(taskId);
	}

	/**
	 * Creates a new task status with the primary key. Does not add the task status to the database.
	 *
	 * @param taskStatusId the primary key for the new task status
	 * @return the new task status
	 */
	public static com.mimacom.manager.tasklist.model.TaskStatus
		createTaskStatus(long taskStatusId) {

		return getService().createTaskStatus(taskStatusId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the task status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TaskStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param taskStatusId the primary key of the task status
	 * @return the task status that was removed
	 * @throws PortalException if a task status with the primary key could not be found
	 */
	public static com.mimacom.manager.tasklist.model.TaskStatus
			deleteTaskStatus(long taskStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTaskStatus(taskStatusId);
	}

	/**
	 * Deletes the task status from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TaskStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param taskStatus the task status
	 * @return the task status that was removed
	 */
	public static com.mimacom.manager.tasklist.model.TaskStatus
		deleteTaskStatus(
			com.mimacom.manager.tasklist.model.TaskStatus taskStatus) {

		return getService().deleteTaskStatus(taskStatus);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mimacom.manager.tasklist.model.impl.TaskStatusModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mimacom.manager.tasklist.model.impl.TaskStatusModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.mimacom.manager.tasklist.model.TaskStatus fetchTaskStatus(
		long taskStatusId) {

		return getService().fetchTaskStatus(taskStatusId);
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

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the task status with the primary key.
	 *
	 * @param taskStatusId the primary key of the task status
	 * @return the task status
	 * @throws PortalException if a task status with the primary key could not be found
	 */
	public static com.mimacom.manager.tasklist.model.TaskStatus getTaskStatus(
			long taskStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTaskStatus(taskStatusId);
	}

	/**
	 * Returns a range of all the task statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mimacom.manager.tasklist.model.impl.TaskStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @return the range of task statuses
	 */
	public static java.util.List<com.mimacom.manager.tasklist.model.TaskStatus>
		getTaskStatuses(int start, int end) {

		return getService().getTaskStatuses(start, end);
	}

	/**
	 * Returns the number of task statuses.
	 *
	 * @return the number of task statuses
	 */
	public static int getTaskStatusesCount() {
		return getService().getTaskStatusesCount();
	}

	/**
	 * Updates the task status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TaskStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param taskStatus the task status
	 * @return the task status that was updated
	 */
	public static com.mimacom.manager.tasklist.model.TaskStatus
		updateTaskStatus(
			com.mimacom.manager.tasklist.model.TaskStatus taskStatus) {

		return getService().updateTaskStatus(taskStatus);
	}

	public static TaskStatusLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TaskStatusLocalService, TaskStatusLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TaskStatusLocalService.class);

		ServiceTracker<TaskStatusLocalService, TaskStatusLocalService>
			serviceTracker =
				new ServiceTracker
					<TaskStatusLocalService, TaskStatusLocalService>(
						bundle.getBundleContext(), TaskStatusLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}