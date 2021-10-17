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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mimacom.manager.tasklist.exception.NoSuchTaskException;
import com.mimacom.manager.tasklist.model.Task;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Task. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TaskServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TaskService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.mimacom.manager.tasklist.service.impl.TaskServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the task remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link TaskServiceUtil} if injection and service tracking are not available.
	 */
	public Task addTask(
			long groupId, String title, String description,
			ServiceContext serviceContext)
		throws PortalException;

	public int countbyUserId(long userId);

	public int countbyUserIdAndGroupid(long userId, long groupId);

	public Task deleteTask(long taskId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Task fetchTask(long taskId);

	public List<Task> findByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<Task> orderByComparator);

	public Task findByTaskId(long taskId) throws NoSuchTaskException;

	public List<Task> findByUserId(long userId);

	public List<Task> findByUserId(long userId, int start, int end);

	public List<Task> findByUserIdAndGroupId(long userId, long groupId);

	public List<Task> findByUserIdAndGroupId(
		long userId, long groupId, int start, int end);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public Task updateTask(
			long taskId, String title, String description,
			ServiceContext serviceContext)
		throws PortalException;

}