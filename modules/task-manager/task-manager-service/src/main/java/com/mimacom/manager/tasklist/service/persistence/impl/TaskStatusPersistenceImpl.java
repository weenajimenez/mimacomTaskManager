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

package com.mimacom.manager.tasklist.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import com.mimacom.manager.tasklist.exception.NoSuchTaskStatusException;
import com.mimacom.manager.tasklist.model.TaskStatus;
import com.mimacom.manager.tasklist.model.impl.TaskStatusImpl;
import com.mimacom.manager.tasklist.model.impl.TaskStatusModelImpl;
import com.mimacom.manager.tasklist.service.persistence.TaskStatusPersistence;
import com.mimacom.manager.tasklist.service.persistence.impl.constants.tlmPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the task status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TaskStatusPersistence.class)
public class TaskStatusPersistenceImpl
	extends BasePersistenceImpl<TaskStatus> implements TaskStatusPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TaskStatusUtil</code> to access the task status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TaskStatusImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByTaskId;
	private FinderPath _finderPathWithoutPaginationFindByTaskId;
	private FinderPath _finderPathCountByTaskId;

	/**
	 * Returns all the task statuses where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching task statuses
	 */
	@Override
	public List<TaskStatus> findByTaskId(long taskId) {
		return findByTaskId(taskId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TaskStatus> findByTaskId(long taskId, int start, int end) {
		return findByTaskId(taskId, start, end, null);
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
	@Override
	public List<TaskStatus> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator) {

		return findByTaskId(taskId, start, end, orderByComparator, true);
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
	@Override
	public List<TaskStatus> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTaskId;
				finderArgs = new Object[] {taskId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTaskId;
			finderArgs = new Object[] {taskId, start, end, orderByComparator};
		}

		List<TaskStatus> list = null;

		if (useFinderCache) {
			list = (List<TaskStatus>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TaskStatus taskStatus : list) {
					if (taskId != taskStatus.getTaskId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_TASKSTATUS_WHERE);

			sb.append(_FINDER_COLUMN_TASKID_TASKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TaskStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(taskId);

				list = (List<TaskStatus>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first task status in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	@Override
	public TaskStatus findByTaskId_First(
			long taskId, OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException {

		TaskStatus taskStatus = fetchByTaskId_First(taskId, orderByComparator);

		if (taskStatus != null) {
			return taskStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskId=");
		sb.append(taskId);

		sb.append("}");

		throw new NoSuchTaskStatusException(sb.toString());
	}

	/**
	 * Returns the first task status in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status, or <code>null</code> if a matching task status could not be found
	 */
	@Override
	public TaskStatus fetchByTaskId_First(
		long taskId, OrderByComparator<TaskStatus> orderByComparator) {

		List<TaskStatus> list = findByTaskId(taskId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last task status in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status
	 * @throws NoSuchTaskStatusException if a matching task status could not be found
	 */
	@Override
	public TaskStatus findByTaskId_Last(
			long taskId, OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException {

		TaskStatus taskStatus = fetchByTaskId_Last(taskId, orderByComparator);

		if (taskStatus != null) {
			return taskStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskId=");
		sb.append(taskId);

		sb.append("}");

		throw new NoSuchTaskStatusException(sb.toString());
	}

	/**
	 * Returns the last task status in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status, or <code>null</code> if a matching task status could not be found
	 */
	@Override
	public TaskStatus fetchByTaskId_Last(
		long taskId, OrderByComparator<TaskStatus> orderByComparator) {

		int count = countByTaskId(taskId);

		if (count == 0) {
			return null;
		}

		List<TaskStatus> list = findByTaskId(
			taskId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TaskStatus[] findByTaskId_PrevAndNext(
			long taskStatusId, long taskId,
			OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException {

		TaskStatus taskStatus = findByPrimaryKey(taskStatusId);

		Session session = null;

		try {
			session = openSession();

			TaskStatus[] array = new TaskStatusImpl[3];

			array[0] = getByTaskId_PrevAndNext(
				session, taskStatus, taskId, orderByComparator, true);

			array[1] = taskStatus;

			array[2] = getByTaskId_PrevAndNext(
				session, taskStatus, taskId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TaskStatus getByTaskId_PrevAndNext(
		Session session, TaskStatus taskStatus, long taskId,
		OrderByComparator<TaskStatus> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TASKSTATUS_WHERE);

		sb.append(_FINDER_COLUMN_TASKID_TASKID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TaskStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(taskId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(taskStatus)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TaskStatus> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the task statuses where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	@Override
	public void removeByTaskId(long taskId) {
		for (TaskStatus taskStatus :
				findByTaskId(
					taskId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(taskStatus);
		}
	}

	/**
	 * Returns the number of task statuses where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching task statuses
	 */
	@Override
	public int countByTaskId(long taskId) {
		FinderPath finderPath = _finderPathCountByTaskId;

		Object[] finderArgs = new Object[] {taskId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TASKSTATUS_WHERE);

			sb.append(_FINDER_COLUMN_TASKID_TASKID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(taskId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TASKID_TASKID_2 =
		"taskStatus.taskId = ?";

	private FinderPath _finderPathWithPaginationFindByType;
	private FinderPath _finderPathWithoutPaginationFindByType;
	private FinderPath _finderPathCountByType;

	/**
	 * Returns all the task statuses where userId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @return the matching task statuses
	 */
	@Override
	public List<TaskStatus> findByType(long userId, int type) {
		return findByType(
			userId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TaskStatus> findByType(
		long userId, int type, int start, int end) {

		return findByType(userId, type, start, end, null);
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
	@Override
	public List<TaskStatus> findByType(
		long userId, int type, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator) {

		return findByType(userId, type, start, end, orderByComparator, true);
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
	@Override
	public List<TaskStatus> findByType(
		long userId, int type, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByType;
				finderArgs = new Object[] {userId, type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByType;
			finderArgs = new Object[] {
				userId, type, start, end, orderByComparator
			};
		}

		List<TaskStatus> list = null;

		if (useFinderCache) {
			list = (List<TaskStatus>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TaskStatus taskStatus : list) {
					if ((userId != taskStatus.getUserId()) ||
						(type != taskStatus.getType())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_TASKSTATUS_WHERE);

			sb.append(_FINDER_COLUMN_TYPE_USERID_2);

			sb.append(_FINDER_COLUMN_TYPE_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TaskStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(type);

				list = (List<TaskStatus>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public TaskStatus findByType_First(
			long userId, int type,
			OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException {

		TaskStatus taskStatus = fetchByType_First(
			userId, type, orderByComparator);

		if (taskStatus != null) {
			return taskStatus;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchTaskStatusException(sb.toString());
	}

	/**
	 * Returns the first task status in the ordered set where userId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status, or <code>null</code> if a matching task status could not be found
	 */
	@Override
	public TaskStatus fetchByType_First(
		long userId, int type,
		OrderByComparator<TaskStatus> orderByComparator) {

		List<TaskStatus> list = findByType(
			userId, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TaskStatus findByType_Last(
			long userId, int type,
			OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException {

		TaskStatus taskStatus = fetchByType_Last(
			userId, type, orderByComparator);

		if (taskStatus != null) {
			return taskStatus;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchTaskStatusException(sb.toString());
	}

	/**
	 * Returns the last task status in the ordered set where userId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status, or <code>null</code> if a matching task status could not be found
	 */
	@Override
	public TaskStatus fetchByType_Last(
		long userId, int type,
		OrderByComparator<TaskStatus> orderByComparator) {

		int count = countByType(userId, type);

		if (count == 0) {
			return null;
		}

		List<TaskStatus> list = findByType(
			userId, type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TaskStatus[] findByType_PrevAndNext(
			long taskStatusId, long userId, int type,
			OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException {

		TaskStatus taskStatus = findByPrimaryKey(taskStatusId);

		Session session = null;

		try {
			session = openSession();

			TaskStatus[] array = new TaskStatusImpl[3];

			array[0] = getByType_PrevAndNext(
				session, taskStatus, userId, type, orderByComparator, true);

			array[1] = taskStatus;

			array[2] = getByType_PrevAndNext(
				session, taskStatus, userId, type, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TaskStatus getByType_PrevAndNext(
		Session session, TaskStatus taskStatus, long userId, int type,
		OrderByComparator<TaskStatus> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TASKSTATUS_WHERE);

		sb.append(_FINDER_COLUMN_TYPE_USERID_2);

		sb.append(_FINDER_COLUMN_TYPE_TYPE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TaskStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		queryPos.add(type);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(taskStatus)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TaskStatus> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the task statuses where userId = &#63; and type = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param type the type
	 */
	@Override
	public void removeByType(long userId, int type) {
		for (TaskStatus taskStatus :
				findByType(
					userId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(taskStatus);
		}
	}

	/**
	 * Returns the number of task statuses where userId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @return the number of matching task statuses
	 */
	@Override
	public int countByType(long userId, int type) {
		FinderPath finderPath = _finderPathCountByType;

		Object[] finderArgs = new Object[] {userId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TASKSTATUS_WHERE);

			sb.append(_FINDER_COLUMN_TYPE_USERID_2);

			sb.append(_FINDER_COLUMN_TYPE_TYPE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(type);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TYPE_USERID_2 =
		"taskStatus.userId = ? AND ";

	private static final String _FINDER_COLUMN_TYPE_TYPE_2 =
		"taskStatus.type = ?";

	private FinderPath _finderPathWithPaginationFindByProgress;
	private FinderPath _finderPathWithoutPaginationFindByProgress;
	private FinderPath _finderPathCountByProgress;

	/**
	 * Returns all the task statuses where userId = &#63; and progress = &#63;.
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 * @return the matching task statuses
	 */
	@Override
	public List<TaskStatus> findByProgress(long userId, int progress) {
		return findByProgress(
			userId, progress, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TaskStatus> findByProgress(
		long userId, int progress, int start, int end) {

		return findByProgress(userId, progress, start, end, null);
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
	@Override
	public List<TaskStatus> findByProgress(
		long userId, int progress, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator) {

		return findByProgress(
			userId, progress, start, end, orderByComparator, true);
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
	@Override
	public List<TaskStatus> findByProgress(
		long userId, int progress, int start, int end,
		OrderByComparator<TaskStatus> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByProgress;
				finderArgs = new Object[] {userId, progress};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProgress;
			finderArgs = new Object[] {
				userId, progress, start, end, orderByComparator
			};
		}

		List<TaskStatus> list = null;

		if (useFinderCache) {
			list = (List<TaskStatus>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TaskStatus taskStatus : list) {
					if ((userId != taskStatus.getUserId()) ||
						(progress != taskStatus.getProgress())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_TASKSTATUS_WHERE);

			sb.append(_FINDER_COLUMN_PROGRESS_USERID_2);

			sb.append(_FINDER_COLUMN_PROGRESS_PROGRESS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TaskStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(progress);

				list = (List<TaskStatus>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public TaskStatus findByProgress_First(
			long userId, int progress,
			OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException {

		TaskStatus taskStatus = fetchByProgress_First(
			userId, progress, orderByComparator);

		if (taskStatus != null) {
			return taskStatus;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", progress=");
		sb.append(progress);

		sb.append("}");

		throw new NoSuchTaskStatusException(sb.toString());
	}

	/**
	 * Returns the first task status in the ordered set where userId = &#63; and progress = &#63;.
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task status, or <code>null</code> if a matching task status could not be found
	 */
	@Override
	public TaskStatus fetchByProgress_First(
		long userId, int progress,
		OrderByComparator<TaskStatus> orderByComparator) {

		List<TaskStatus> list = findByProgress(
			userId, progress, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TaskStatus findByProgress_Last(
			long userId, int progress,
			OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException {

		TaskStatus taskStatus = fetchByProgress_Last(
			userId, progress, orderByComparator);

		if (taskStatus != null) {
			return taskStatus;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", progress=");
		sb.append(progress);

		sb.append("}");

		throw new NoSuchTaskStatusException(sb.toString());
	}

	/**
	 * Returns the last task status in the ordered set where userId = &#63; and progress = &#63;.
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task status, or <code>null</code> if a matching task status could not be found
	 */
	@Override
	public TaskStatus fetchByProgress_Last(
		long userId, int progress,
		OrderByComparator<TaskStatus> orderByComparator) {

		int count = countByProgress(userId, progress);

		if (count == 0) {
			return null;
		}

		List<TaskStatus> list = findByProgress(
			userId, progress, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TaskStatus[] findByProgress_PrevAndNext(
			long taskStatusId, long userId, int progress,
			OrderByComparator<TaskStatus> orderByComparator)
		throws NoSuchTaskStatusException {

		TaskStatus taskStatus = findByPrimaryKey(taskStatusId);

		Session session = null;

		try {
			session = openSession();

			TaskStatus[] array = new TaskStatusImpl[3];

			array[0] = getByProgress_PrevAndNext(
				session, taskStatus, userId, progress, orderByComparator, true);

			array[1] = taskStatus;

			array[2] = getByProgress_PrevAndNext(
				session, taskStatus, userId, progress, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TaskStatus getByProgress_PrevAndNext(
		Session session, TaskStatus taskStatus, long userId, int progress,
		OrderByComparator<TaskStatus> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TASKSTATUS_WHERE);

		sb.append(_FINDER_COLUMN_PROGRESS_USERID_2);

		sb.append(_FINDER_COLUMN_PROGRESS_PROGRESS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TaskStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		queryPos.add(progress);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(taskStatus)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TaskStatus> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the task statuses where userId = &#63; and progress = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 */
	@Override
	public void removeByProgress(long userId, int progress) {
		for (TaskStatus taskStatus :
				findByProgress(
					userId, progress, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(taskStatus);
		}
	}

	/**
	 * Returns the number of task statuses where userId = &#63; and progress = &#63;.
	 *
	 * @param userId the user ID
	 * @param progress the progress
	 * @return the number of matching task statuses
	 */
	@Override
	public int countByProgress(long userId, int progress) {
		FinderPath finderPath = _finderPathCountByProgress;

		Object[] finderArgs = new Object[] {userId, progress};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TASKSTATUS_WHERE);

			sb.append(_FINDER_COLUMN_PROGRESS_USERID_2);

			sb.append(_FINDER_COLUMN_PROGRESS_PROGRESS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(progress);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PROGRESS_USERID_2 =
		"taskStatus.userId = ? AND ";

	private static final String _FINDER_COLUMN_PROGRESS_PROGRESS_2 =
		"taskStatus.progress = ?";

	public TaskStatusPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TaskStatus.class);

		setModelImplClass(TaskStatusImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the task status in the entity cache if it is enabled.
	 *
	 * @param taskStatus the task status
	 */
	@Override
	public void cacheResult(TaskStatus taskStatus) {
		entityCache.putResult(
			entityCacheEnabled, TaskStatusImpl.class,
			taskStatus.getPrimaryKey(), taskStatus);

		taskStatus.resetOriginalValues();
	}

	/**
	 * Caches the task statuses in the entity cache if it is enabled.
	 *
	 * @param taskStatuses the task statuses
	 */
	@Override
	public void cacheResult(List<TaskStatus> taskStatuses) {
		for (TaskStatus taskStatus : taskStatuses) {
			if (entityCache.getResult(
					entityCacheEnabled, TaskStatusImpl.class,
					taskStatus.getPrimaryKey()) == null) {

				cacheResult(taskStatus);
			}
			else {
				taskStatus.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all task statuses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TaskStatusImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the task status.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaskStatus taskStatus) {
		entityCache.removeResult(
			entityCacheEnabled, TaskStatusImpl.class,
			taskStatus.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TaskStatus> taskStatuses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaskStatus taskStatus : taskStatuses) {
			entityCache.removeResult(
				entityCacheEnabled, TaskStatusImpl.class,
				taskStatus.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, TaskStatusImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new task status with the primary key. Does not add the task status to the database.
	 *
	 * @param taskStatusId the primary key for the new task status
	 * @return the new task status
	 */
	@Override
	public TaskStatus create(long taskStatusId) {
		TaskStatus taskStatus = new TaskStatusImpl();

		taskStatus.setNew(true);
		taskStatus.setPrimaryKey(taskStatusId);

		taskStatus.setCompanyId(CompanyThreadLocal.getCompanyId());

		return taskStatus;
	}

	/**
	 * Removes the task status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskStatusId the primary key of the task status
	 * @return the task status that was removed
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	@Override
	public TaskStatus remove(long taskStatusId)
		throws NoSuchTaskStatusException {

		return remove((Serializable)taskStatusId);
	}

	/**
	 * Removes the task status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the task status
	 * @return the task status that was removed
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	@Override
	public TaskStatus remove(Serializable primaryKey)
		throws NoSuchTaskStatusException {

		Session session = null;

		try {
			session = openSession();

			TaskStatus taskStatus = (TaskStatus)session.get(
				TaskStatusImpl.class, primaryKey);

			if (taskStatus == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaskStatusException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(taskStatus);
		}
		catch (NoSuchTaskStatusException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TaskStatus removeImpl(TaskStatus taskStatus) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taskStatus)) {
				taskStatus = (TaskStatus)session.get(
					TaskStatusImpl.class, taskStatus.getPrimaryKeyObj());
			}

			if (taskStatus != null) {
				session.delete(taskStatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (taskStatus != null) {
			clearCache(taskStatus);
		}

		return taskStatus;
	}

	@Override
	public TaskStatus updateImpl(TaskStatus taskStatus) {
		boolean isNew = taskStatus.isNew();

		if (!(taskStatus instanceof TaskStatusModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(taskStatus.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(taskStatus);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in taskStatus proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TaskStatus implementation " +
					taskStatus.getClass());
		}

		TaskStatusModelImpl taskStatusModelImpl =
			(TaskStatusModelImpl)taskStatus;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (taskStatus.getCreateDate() == null)) {
			if (serviceContext == null) {
				taskStatus.setCreateDate(now);
			}
			else {
				taskStatus.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!taskStatusModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				taskStatus.setModifiedDate(now);
			}
			else {
				taskStatus.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (taskStatus.isNew()) {
				session.save(taskStatus);

				taskStatus.setNew(false);
			}
			else {
				taskStatus = (TaskStatus)session.merge(taskStatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {taskStatusModelImpl.getTaskId()};

			finderCache.removeResult(_finderPathCountByTaskId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTaskId, args);

			args = new Object[] {
				taskStatusModelImpl.getUserId(), taskStatusModelImpl.getType()
			};

			finderCache.removeResult(_finderPathCountByType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByType, args);

			args = new Object[] {
				taskStatusModelImpl.getUserId(),
				taskStatusModelImpl.getProgress()
			};

			finderCache.removeResult(_finderPathCountByProgress, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByProgress, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((taskStatusModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTaskId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					taskStatusModelImpl.getOriginalTaskId()
				};

				finderCache.removeResult(_finderPathCountByTaskId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTaskId, args);

				args = new Object[] {taskStatusModelImpl.getTaskId()};

				finderCache.removeResult(_finderPathCountByTaskId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTaskId, args);
			}

			if ((taskStatusModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByType.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					taskStatusModelImpl.getOriginalUserId(),
					taskStatusModelImpl.getOriginalType()
				};

				finderCache.removeResult(_finderPathCountByType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByType, args);

				args = new Object[] {
					taskStatusModelImpl.getUserId(),
					taskStatusModelImpl.getType()
				};

				finderCache.removeResult(_finderPathCountByType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByType, args);
			}

			if ((taskStatusModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByProgress.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					taskStatusModelImpl.getOriginalUserId(),
					taskStatusModelImpl.getOriginalProgress()
				};

				finderCache.removeResult(_finderPathCountByProgress, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProgress, args);

				args = new Object[] {
					taskStatusModelImpl.getUserId(),
					taskStatusModelImpl.getProgress()
				};

				finderCache.removeResult(_finderPathCountByProgress, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProgress, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, TaskStatusImpl.class,
			taskStatus.getPrimaryKey(), taskStatus, false);

		taskStatus.resetOriginalValues();

		return taskStatus;
	}

	/**
	 * Returns the task status with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the task status
	 * @return the task status
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	@Override
	public TaskStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaskStatusException {

		TaskStatus taskStatus = fetchByPrimaryKey(primaryKey);

		if (taskStatus == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaskStatusException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return taskStatus;
	}

	/**
	 * Returns the task status with the primary key or throws a <code>NoSuchTaskStatusException</code> if it could not be found.
	 *
	 * @param taskStatusId the primary key of the task status
	 * @return the task status
	 * @throws NoSuchTaskStatusException if a task status with the primary key could not be found
	 */
	@Override
	public TaskStatus findByPrimaryKey(long taskStatusId)
		throws NoSuchTaskStatusException {

		return findByPrimaryKey((Serializable)taskStatusId);
	}

	/**
	 * Returns the task status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskStatusId the primary key of the task status
	 * @return the task status, or <code>null</code> if a task status with the primary key could not be found
	 */
	@Override
	public TaskStatus fetchByPrimaryKey(long taskStatusId) {
		return fetchByPrimaryKey((Serializable)taskStatusId);
	}

	/**
	 * Returns all the task statuses.
	 *
	 * @return the task statuses
	 */
	@Override
	public List<TaskStatus> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TaskStatus> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<TaskStatus> findAll(
		int start, int end, OrderByComparator<TaskStatus> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<TaskStatus> findAll(
		int start, int end, OrderByComparator<TaskStatus> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<TaskStatus> list = null;

		if (useFinderCache) {
			list = (List<TaskStatus>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TASKSTATUS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TASKSTATUS;

				sql = sql.concat(TaskStatusModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TaskStatus>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the task statuses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TaskStatus taskStatus : findAll()) {
			remove(taskStatus);
		}
	}

	/**
	 * Returns the number of task statuses.
	 *
	 * @return the number of task statuses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TASKSTATUS);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "taskStatusId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TASKSTATUS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TaskStatusModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the task status persistence.
	 */
	@Activate
	public void activate() {
		TaskStatusModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TaskStatusModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TaskStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TaskStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByTaskId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TaskStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTaskId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTaskId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TaskStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTaskId",
			new String[] {Long.class.getName()},
			TaskStatusModelImpl.TASKID_COLUMN_BITMASK);

		_finderPathCountByTaskId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTaskId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TaskStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TaskStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] {Long.class.getName(), Integer.class.getName()},
			TaskStatusModelImpl.USERID_COLUMN_BITMASK |
			TaskStatusModelImpl.TYPE_COLUMN_BITMASK);

		_finderPathCountByType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByProgress = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TaskStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProgress",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByProgress = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TaskStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProgress",
			new String[] {Long.class.getName(), Integer.class.getName()},
			TaskStatusModelImpl.USERID_COLUMN_BITMASK |
			TaskStatusModelImpl.PROGRESS_COLUMN_BITMASK);

		_finderPathCountByProgress = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProgress",
			new String[] {Long.class.getName(), Integer.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TaskStatusImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = tlmPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.mimacom.manager.tasklist.model.TaskStatus"),
			true);
	}

	@Override
	@Reference(
		target = tlmPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = tlmPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_TASKSTATUS =
		"SELECT taskStatus FROM TaskStatus taskStatus";

	private static final String _SQL_SELECT_TASKSTATUS_WHERE =
		"SELECT taskStatus FROM TaskStatus taskStatus WHERE ";

	private static final String _SQL_COUNT_TASKSTATUS =
		"SELECT COUNT(taskStatus) FROM TaskStatus taskStatus";

	private static final String _SQL_COUNT_TASKSTATUS_WHERE =
		"SELECT COUNT(taskStatus) FROM TaskStatus taskStatus WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "taskStatus.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TaskStatus exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TaskStatus exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TaskStatusPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"type"});

	static {
		try {
			Class.forName(tlmPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}