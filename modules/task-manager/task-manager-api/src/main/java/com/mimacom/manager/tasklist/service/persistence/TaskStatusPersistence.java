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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mimacom.manager.tasklist.exception.NoSuchTaskStatusException;
import com.mimacom.manager.tasklist.model.TaskStatus;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the task status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskStatusUtil
 * @generated
 */
@ProviderType
public interface TaskStatusPersistence extends BasePersistence<TaskStatus> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaskStatusUtil} to access the task status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the task statuses where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching task statuses
	 */
	public java.util.List<TaskStatus> findByTaskId(long taskId);

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
	public java.util.List<TaskStatus> findByTaskId(
		long taskId, int start, int end);

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
	public java.util.List<TaskStatus> findByTaskId(
		long taskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
			orderByComparator);

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
	public java.util.List<TaskStatus> findByTaskId(
		long taskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first task status in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	public TaskStatus findByTaskId_First(
			long taskId,
			com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
				orderByComparator)
		throws NoSuchTaskStatusException;

	/**
	 * Returns the first task status in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status, or <code>null</code> if a matching task status could not be found
	 */
	public TaskStatus fetchByTaskId_First(
		long taskId,
		com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
			orderByComparator);

	/**
	 * Returns the last task status in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	public TaskStatus findByTaskId_Last(
			long taskId,
			com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
				orderByComparator)
		throws NoSuchTaskStatusException;

	/**
	 * Returns the last task status in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status, or <code>null</code> if a matching task status could not be found
	 */
	public TaskStatus fetchByTaskId_Last(
		long taskId,
		com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
			orderByComparator);

	/**
	 * Returns the task statuses before and after the current task status in the ordered set where taskId = &#63;.
	 *
	 * @param taskStatusId the primary key of the current task status
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task status
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	public TaskStatus[] findByTaskId_PrevAndNext(
			long taskStatusId, long taskId,
			com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
				orderByComparator)
		throws NoSuchTaskStatusException;

	/**
	 * Removes all the task statuses where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	public void removeByTaskId(long taskId);

	/**
	 * Returns the number of task statuses where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching task statuses
	 */
	public int countByTaskId(long taskId);

	/**
	 * Returns all the task statuses where userId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @return the matching task statuses
	 */
	public java.util.List<TaskStatus> findByType(long userId, int type);

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
	public java.util.List<TaskStatus> findByType(
		long userId, int type, int start, int end);

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
	public java.util.List<TaskStatus> findByType(
		long userId, int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
			orderByComparator);

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
	public java.util.List<TaskStatus> findByType(
		long userId, int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first task status in the ordered set where userId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	public TaskStatus findByType_First(
			long userId, int type,
			com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
				orderByComparator)
		throws NoSuchTaskStatusException;

	/**
	 * Returns the first task status in the ordered set where userId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status, or <code>null</code> if a matching task status could not be found
	 */
	public TaskStatus fetchByType_First(
		long userId, int type,
		com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
			orderByComparator);

	/**
	 * Returns the last task status in the ordered set where userId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	public TaskStatus findByType_Last(
			long userId, int type,
			com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
				orderByComparator)
		throws NoSuchTaskStatusException;

	/**
	 * Returns the last task status in the ordered set where userId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status, or <code>null</code> if a matching task status could not be found
	 */
	public TaskStatus fetchByType_Last(
		long userId, int type,
		com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
			orderByComparator);

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
	public TaskStatus[] findByType_PrevAndNext(
			long taskStatusId, long userId, int type,
			com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
				orderByComparator)
		throws NoSuchTaskStatusException;

	/**
	 * Removes all the task statuses where userId = &#63; and type = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param type the type
	 */
	public void removeByType(long userId, int type);

	/**
	 * Returns the number of task statuses where userId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @return the number of matching task statuses
	 */
	public int countByType(long userId, int type);

	/**
	 * Returns all the task statuses where userId = &#63; and progress = &#63;.
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 * @return the matching task statuses
	 */
	public java.util.List<TaskStatus> findByProgress(long userId, int progress);

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
	public java.util.List<TaskStatus> findByProgress(
		long userId, int progress, int start, int end);

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
	public java.util.List<TaskStatus> findByProgress(
		long userId, int progress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
			orderByComparator);

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
	public java.util.List<TaskStatus> findByProgress(
		long userId, int progress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first task status in the ordered set where userId = &#63; and progress = &#63;.
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	public TaskStatus findByProgress_First(
			long userId, int progress,
			com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
				orderByComparator)
		throws NoSuchTaskStatusException;

	/**
	 * Returns the first task status in the ordered set where userId = &#63; and progress = &#63;.
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status, or <code>null</code> if a matching task status could not be found
	 */
	public TaskStatus fetchByProgress_First(
		long userId, int progress,
		com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
			orderByComparator);

	/**
	 * Returns the last task status in the ordered set where userId = &#63; and progress = &#63;.
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	public TaskStatus findByProgress_Last(
			long userId, int progress,
			com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
				orderByComparator)
		throws NoSuchTaskStatusException;

	/**
	 * Returns the last task status in the ordered set where userId = &#63; and progress = &#63;.
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status, or <code>null</code> if a matching task status could not be found
	 */
	public TaskStatus fetchByProgress_Last(
		long userId, int progress,
		com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
			orderByComparator);

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
	public TaskStatus[] findByProgress_PrevAndNext(
			long taskStatusId, long userId, int progress,
			com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
				orderByComparator)
		throws NoSuchTaskStatusException;

	/**
	 * Removes all the task statuses where userId = &#63; and progress = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 */
	public void removeByProgress(long userId, int progress);

	/**
	 * Returns the number of task statuses where userId = &#63; and progress = &#63;.
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 * @return the number of matching task statuses
	 */
	public int countByProgress(long userId, int progress);

	/**
	 * Caches the task status in the entity cache if it is enabled.
	 *
	 * @param taskStatus the task status
	 */
	public void cacheResult(TaskStatus taskStatus);

	/**
	 * Caches the task statuses in the entity cache if it is enabled.
	 *
	 * @param taskStatuses the task statuses
	 */
	public void cacheResult(java.util.List<TaskStatus> taskStatuses);

	/**
	 * Creates a new task status with the primary key. Does not add the task status to the database.
	 *
	 * @param taskStatusId the primary key for the new task status
	 * @return the new task status
	 */
	public TaskStatus create(long taskStatusId);

	/**
	 * Removes the task status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskStatusId the primary key of the task status
	 * @return the task status that was removed
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	public TaskStatus remove(long taskStatusId)
		throws NoSuchTaskStatusException;

	public TaskStatus updateImpl(TaskStatus taskStatus);

	/**
	 * Returns the task status with the primary key or throws a <code>NoSuchTaskStatusException</code> if it could not be found.
	 *
	 * @param taskStatusId the primary key of the task status
	 * @return the task status
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	public TaskStatus findByPrimaryKey(long taskStatusId)
		throws NoSuchTaskStatusException;

	/**
	 * Returns the task status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskStatusId the primary key of the task status
	 * @return the task status, or <code>null</code> if a task status with the primary key could not be found
	 */
	public TaskStatus fetchByPrimaryKey(long taskStatusId);

	/**
	 * Returns all the task statuses.
	 *
	 * @return the task statuses
	 */
	public java.util.List<TaskStatus> findAll();

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
	public java.util.List<TaskStatus> findAll(int start, int end);

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
	public java.util.List<TaskStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
			orderByComparator);

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
	public java.util.List<TaskStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the task statuses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of task statuses.
	 *
	 * @return the number of task statuses
	 */
	public int countAll();

}