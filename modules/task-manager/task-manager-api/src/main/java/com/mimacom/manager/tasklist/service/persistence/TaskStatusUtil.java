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

package com.mimacom.manager.tasklist.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mimacom.manager.tasklist.model.TaskStatus;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the task status service. This utility wraps <code>com.mimacom.manager.tasklist.service.persistence.impl.TaskStatusPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskStatusPersistence
 * @generated
 */
public class TaskStatusUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TaskStatus taskStatus) {
		getPersistence().clearCache(taskStatus);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, TaskStatus> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TaskStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaskStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaskStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TaskStatus update(TaskStatus taskStatus) {
		return getPersistence().update(taskStatus);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TaskStatus update(
		TaskStatus taskStatus, ServiceContext serviceContext) {

		return getPersistence().update(taskStatus, serviceContext);
	}

	/**
	 * Returns all the task statuses where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching task statuses
	 */
	public static List<TaskStatus> findByTaskId(long taskId) {
		return getPersistence().findByTaskId(taskId);
	}

	/**
	 * Returns a range of all the task statuses where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @return the range of matching task statuses
	 */
	public static List<TaskStatus> findByTaskId(
		long taskId, int start, int end) {

		return getPersistence().findByTaskId(taskId, start, end);
	}

	/**
	 * Returns an ordered range of all the task statuses where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching task statuses
	 */
	public static List<TaskStatus> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator) {

		return getPersistence().findByTaskId(
			taskId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the task statuses where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching task statuses
	 */
	public static List<TaskStatus> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTaskId(
			taskId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first task status in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	public static TaskStatus findByTaskId_First(
			long taskId, OrderByComparator<TaskStatus> orderByComparator)
		throws com.mimacom.manager.tasklist.exception.
			NoSuchTaskStatusException {

		return getPersistence().findByTaskId_First(taskId, orderByComparator);
	}

	/**
	 * Returns the first task status in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status, or <code>null</code> if a matching task status could not be found
	 */
	public static TaskStatus fetchByTaskId_First(
		long taskId, OrderByComparator<TaskStatus> orderByComparator) {

		return getPersistence().fetchByTaskId_First(taskId, orderByComparator);
	}

	/**
	 * Returns the last task status in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	public static TaskStatus findByTaskId_Last(
			long taskId, OrderByComparator<TaskStatus> orderByComparator)
		throws com.mimacom.manager.tasklist.exception.
			NoSuchTaskStatusException {

		return getPersistence().findByTaskId_Last(taskId, orderByComparator);
	}

	/**
	 * Returns the last task status in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status, or <code>null</code> if a matching task status could not be found
	 */
	public static TaskStatus fetchByTaskId_Last(
		long taskId, OrderByComparator<TaskStatus> orderByComparator) {

		return getPersistence().fetchByTaskId_Last(taskId, orderByComparator);
	}

	/**
	 * Returns the task statuses before and after the current task status in the ordered set where taskId = &#63;.
	 *
	 * @param taskStatusId the primary key of the current task status
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task status
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	public static TaskStatus[] findByTaskId_PrevAndNext(
			long taskStatusId, long taskId,
			OrderByComparator<TaskStatus> orderByComparator)
		throws com.mimacom.manager.tasklist.exception.
			NoSuchTaskStatusException {

		return getPersistence().findByTaskId_PrevAndNext(
			taskStatusId, taskId, orderByComparator);
	}

	/**
	 * Removes all the task statuses where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	public static void removeByTaskId(long taskId) {
		getPersistence().removeByTaskId(taskId);
	}

	/**
	 * Returns the number of task statuses where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching task statuses
	 */
	public static int countByTaskId(long taskId) {
		return getPersistence().countByTaskId(taskId);
	}

	/**
	 * Returns all the task statuses where userId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @return the matching task statuses
	 */
	public static List<TaskStatus> findByType(long userId, int type) {
		return getPersistence().findByType(userId, type);
	}

	/**
	 * Returns a range of all the task statuses where userId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @return the range of matching task statuses
	 */
	public static List<TaskStatus> findByType(
		long userId, int type, int start, int end) {

		return getPersistence().findByType(userId, type, start, end);
	}

	/**
	 * Returns an ordered range of all the task statuses where userId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching task statuses
	 */
	public static List<TaskStatus> findByType(
		long userId, int type, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator) {

		return getPersistence().findByType(
			userId, type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the task statuses where userId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching task statuses
	 */
	public static List<TaskStatus> findByType(
		long userId, int type, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByType(
			userId, type, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first task status in the ordered set where userId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	public static TaskStatus findByType_First(
			long userId, int type,
			OrderByComparator<TaskStatus> orderByComparator)
		throws com.mimacom.manager.tasklist.exception.
			NoSuchTaskStatusException {

		return getPersistence().findByType_First(
			userId, type, orderByComparator);
	}

	/**
	 * Returns the first task status in the ordered set where userId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status, or <code>null</code> if a matching task status could not be found
	 */
	public static TaskStatus fetchByType_First(
		long userId, int type,
		OrderByComparator<TaskStatus> orderByComparator) {

		return getPersistence().fetchByType_First(
			userId, type, orderByComparator);
	}

	/**
	 * Returns the last task status in the ordered set where userId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	public static TaskStatus findByType_Last(
			long userId, int type,
			OrderByComparator<TaskStatus> orderByComparator)
		throws com.mimacom.manager.tasklist.exception.
			NoSuchTaskStatusException {

		return getPersistence().findByType_Last(
			userId, type, orderByComparator);
	}

	/**
	 * Returns the last task status in the ordered set where userId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status, or <code>null</code> if a matching task status could not be found
	 */
	public static TaskStatus fetchByType_Last(
		long userId, int type,
		OrderByComparator<TaskStatus> orderByComparator) {

		return getPersistence().fetchByType_Last(
			userId, type, orderByComparator);
	}

	/**
	 * Returns the task statuses before and after the current task status in the ordered set where userId = &#63; and type = &#63;.
	 *
	 * @param taskStatusId the primary key of the current task status
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task status
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	public static TaskStatus[] findByType_PrevAndNext(
			long taskStatusId, long userId, int type,
			OrderByComparator<TaskStatus> orderByComparator)
		throws com.mimacom.manager.tasklist.exception.
			NoSuchTaskStatusException {

		return getPersistence().findByType_PrevAndNext(
			taskStatusId, userId, type, orderByComparator);
	}

	/**
	 * Removes all the task statuses where userId = &#63; and type = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param type the type
	 */
	public static void removeByType(long userId, int type) {
		getPersistence().removeByType(userId, type);
	}

	/**
	 * Returns the number of task statuses where userId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @return the number of matching task statuses
	 */
	public static int countByType(long userId, int type) {
		return getPersistence().countByType(userId, type);
	}

	/**
	 * Returns all the task statuses where userId = &#63; and progress = &#63;.
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 * @return the matching task statuses
	 */
	public static List<TaskStatus> findByProgress(long userId, int progress) {
		return getPersistence().findByProgress(userId, progress);
	}

	/**
	 * Returns a range of all the task statuses where userId = &#63; and progress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @return the range of matching task statuses
	 */
	public static List<TaskStatus> findByProgress(
		long userId, int progress, int start, int end) {

		return getPersistence().findByProgress(userId, progress, start, end);
	}

	/**
	 * Returns an ordered range of all the task statuses where userId = &#63; and progress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching task statuses
	 */
	public static List<TaskStatus> findByProgress(
		long userId, int progress, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator) {

		return getPersistence().findByProgress(
			userId, progress, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the task statuses where userId = &#63; and progress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching task statuses
	 */
	public static List<TaskStatus> findByProgress(
		long userId, int progress, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProgress(
			userId, progress, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first task status in the ordered set where userId = &#63; and progress = &#63;.
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	public static TaskStatus findByProgress_First(
			long userId, int progress,
			OrderByComparator<TaskStatus> orderByComparator)
		throws com.mimacom.manager.tasklist.exception.
			NoSuchTaskStatusException {

		return getPersistence().findByProgress_First(
			userId, progress, orderByComparator);
	}

	/**
	 * Returns the first task status in the ordered set where userId = &#63; and progress = &#63;.
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status, or <code>null</code> if a matching task status could not be found
	 */
	public static TaskStatus fetchByProgress_First(
		long userId, int progress,
		OrderByComparator<TaskStatus> orderByComparator) {

		return getPersistence().fetchByProgress_First(
			userId, progress, orderByComparator);
	}

	/**
	 * Returns the last task status in the ordered set where userId = &#63; and progress = &#63;.
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	public static TaskStatus findByProgress_Last(
			long userId, int progress,
			OrderByComparator<TaskStatus> orderByComparator)
		throws com.mimacom.manager.tasklist.exception.
			NoSuchTaskStatusException {

		return getPersistence().findByProgress_Last(
			userId, progress, orderByComparator);
	}

	/**
	 * Returns the last task status in the ordered set where userId = &#63; and progress = &#63;.
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status, or <code>null</code> if a matching task status could not be found
	 */
	public static TaskStatus fetchByProgress_Last(
		long userId, int progress,
		OrderByComparator<TaskStatus> orderByComparator) {

		return getPersistence().fetchByProgress_Last(
			userId, progress, orderByComparator);
	}

	/**
	 * Returns the task statuses before and after the current task status in the ordered set where userId = &#63; and progress = &#63;.
	 *
	 * @param taskStatusId the primary key of the current task status
	 * @param userId the user ID
	 * @param progress the progress
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task status
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	public static TaskStatus[] findByProgress_PrevAndNext(
			long taskStatusId, long userId, int progress,
			OrderByComparator<TaskStatus> orderByComparator)
		throws com.mimacom.manager.tasklist.exception.
			NoSuchTaskStatusException {

		return getPersistence().findByProgress_PrevAndNext(
			taskStatusId, userId, progress, orderByComparator);
	}

	/**
	 * Removes all the task statuses where userId = &#63; and progress = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 */
	public static void removeByProgress(long userId, int progress) {
		getPersistence().removeByProgress(userId, progress);
	}

	/**
	 * Returns the number of task statuses where userId = &#63; and progress = &#63;.
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 * @return the number of matching task statuses
	 */
	public static int countByProgress(long userId, int progress) {
		return getPersistence().countByProgress(userId, progress);
	}

	/**
	 * Caches the task status in the entity cache if it is enabled.
	 *
	 * @param taskStatus the task status
	 */
	public static void cacheResult(TaskStatus taskStatus) {
		getPersistence().cacheResult(taskStatus);
	}

	/**
	 * Caches the task statuses in the entity cache if it is enabled.
	 *
	 * @param taskStatuses the task statuses
	 */
	public static void cacheResult(List<TaskStatus> taskStatuses) {
		getPersistence().cacheResult(taskStatuses);
	}

	/**
	 * Creates a new task status with the primary key. Does not add the task status to the database.
	 *
	 * @param taskStatusId the primary key for the new task status
	 * @return the new task status
	 */
	public static TaskStatus create(long taskStatusId) {
		return getPersistence().create(taskStatusId);
	}

	/**
	 * Removes the task status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskStatusId the primary key of the task status
	 * @return the task status that was removed
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	public static TaskStatus remove(long taskStatusId)
		throws com.mimacom.manager.tasklist.exception.
			NoSuchTaskStatusException {

		return getPersistence().remove(taskStatusId);
	}

	public static TaskStatus updateImpl(TaskStatus taskStatus) {
		return getPersistence().updateImpl(taskStatus);
	}

	/**
	 * Returns the task status with the primary key or throws a <code>NoSuchTaskStatusException</code> if it could not be found.
	 *
	 * @param taskStatusId the primary key of the task status
	 * @return the task status
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	public static TaskStatus findByPrimaryKey(long taskStatusId)
		throws com.mimacom.manager.tasklist.exception.
			NoSuchTaskStatusException {

		return getPersistence().findByPrimaryKey(taskStatusId);
	}

	/**
	 * Returns the task status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskStatusId the primary key of the task status
	 * @return the task status, or <code>null</code> if a task status with the primary key could not be found
	 */
	public static TaskStatus fetchByPrimaryKey(long taskStatusId) {
		return getPersistence().fetchByPrimaryKey(taskStatusId);
	}

	/**
	 * Returns all the task statuses.
	 *
	 * @return the task statuses
	 */
	public static List<TaskStatus> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the task statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @return the range of task statuses
	 */
	public static List<TaskStatus> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the task statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of task statuses
	 */
	public static List<TaskStatus> findAll(
		int start, int end, OrderByComparator<TaskStatus> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the task statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of task statuses
	 * @param end the upper bound of the range of task statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of task statuses
	 */
	public static List<TaskStatus> findAll(
		int start, int end, OrderByComparator<TaskStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the task statuses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of task statuses.
	 *
	 * @return the number of task statuses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TaskStatusPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TaskStatusPersistence, TaskStatusPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TaskStatusPersistence.class);

		ServiceTracker<TaskStatusPersistence, TaskStatusPersistence>
			serviceTracker =
				new ServiceTracker
					<TaskStatusPersistence, TaskStatusPersistence>(
						bundle.getBundleContext(), TaskStatusPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}