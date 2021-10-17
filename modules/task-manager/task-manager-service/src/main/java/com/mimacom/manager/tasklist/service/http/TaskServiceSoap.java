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

package com.mimacom.manager.tasklist.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.mimacom.manager.tasklist.service.TaskServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>TaskServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.mimacom.manager.tasklist.model.TaskSoap</code>. If the method in the
 * service utility returns a
 * <code>com.mimacom.manager.tasklist.model.Task</code>, that is translated to a
 * <code>com.mimacom.manager.tasklist.model.TaskSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskServiceHttp
 * @generated
 */
public class TaskServiceSoap {

	public static com.mimacom.manager.tasklist.model.TaskSoap addTask(
			long groupId, String title, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.mimacom.manager.tasklist.model.Task returnValue =
				TaskServiceUtil.addTask(
					groupId, title, description, serviceContext);

			return com.mimacom.manager.tasklist.model.TaskSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.mimacom.manager.tasklist.model.TaskSoap updateTask(
			long taskId, String title, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.mimacom.manager.tasklist.model.Task returnValue =
				TaskServiceUtil.updateTask(
					taskId, title, description, serviceContext);

			return com.mimacom.manager.tasklist.model.TaskSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.mimacom.manager.tasklist.model.TaskSoap[] findByUserId(
			long userId)
		throws RemoteException {

		try {
			java.util.List<com.mimacom.manager.tasklist.model.Task>
				returnValue = TaskServiceUtil.findByUserId(userId);

			return com.mimacom.manager.tasklist.model.TaskSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.mimacom.manager.tasklist.model.TaskSoap[] findByUserId(
			long userId, int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.mimacom.manager.tasklist.model.Task>
				returnValue = TaskServiceUtil.findByUserId(userId, start, end);

			return com.mimacom.manager.tasklist.model.TaskSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int countbyUserId(long userId) throws RemoteException {
		try {
			int returnValue = TaskServiceUtil.countbyUserId(userId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.mimacom.manager.tasklist.model.TaskSoap[]
			findByUserIdAndGroupId(long userId, long groupId)
		throws RemoteException {

		try {
			java.util.List<com.mimacom.manager.tasklist.model.Task>
				returnValue = TaskServiceUtil.findByUserIdAndGroupId(
					userId, groupId);

			return com.mimacom.manager.tasklist.model.TaskSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.mimacom.manager.tasklist.model.TaskSoap[]
			findByUserIdAndGroupId(
				long userId, long groupId, int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.mimacom.manager.tasklist.model.Task>
				returnValue = TaskServiceUtil.findByUserIdAndGroupId(
					userId, groupId, start, end);

			return com.mimacom.manager.tasklist.model.TaskSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int countbyUserIdAndGroupid(long userId, long groupId)
		throws RemoteException {

		try {
			int returnValue = TaskServiceUtil.countbyUserIdAndGroupid(
				userId, groupId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.mimacom.manager.tasklist.model.TaskSoap findByTaskId(
			long taskId)
		throws RemoteException {

		try {
			com.mimacom.manager.tasklist.model.Task returnValue =
				TaskServiceUtil.findByTaskId(taskId);

			return com.mimacom.manager.tasklist.model.TaskSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.mimacom.manager.tasklist.model.TaskSoap fetchTask(
			long taskId)
		throws RemoteException {

		try {
			com.mimacom.manager.tasklist.model.Task returnValue =
				TaskServiceUtil.fetchTask(taskId);

			return com.mimacom.manager.tasklist.model.TaskSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.mimacom.manager.tasklist.model.TaskSoap[] findByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.mimacom.manager.tasklist.model.Task> orderByComparator)
		throws RemoteException {

		try {
			java.util.List<com.mimacom.manager.tasklist.model.Task>
				returnValue = TaskServiceUtil.findByKeywords(
					groupId, keywords, start, end, orderByComparator);

			return com.mimacom.manager.tasklist.model.TaskSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.mimacom.manager.tasklist.model.TaskSoap deleteTask(
			long taskId)
		throws RemoteException {

		try {
			com.mimacom.manager.tasklist.model.Task returnValue =
				TaskServiceUtil.deleteTask(taskId);

			return com.mimacom.manager.tasklist.model.TaskSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TaskServiceSoap.class);

}