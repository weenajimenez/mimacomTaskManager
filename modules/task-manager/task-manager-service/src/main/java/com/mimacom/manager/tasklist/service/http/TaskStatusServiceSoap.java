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

import com.mimacom.manager.tasklist.service.TaskStatusServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>TaskStatusServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.mimacom.manager.tasklist.model.TaskStatusSoap</code>. If the method in the
 * service utility returns a
 * <code>com.mimacom.manager.tasklist.model.TaskStatus</code>, that is translated to a
 * <code>com.mimacom.manager.tasklist.model.TaskStatusSoap</code>. Methods that SOAP
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
 * @see TaskStatusServiceHttp
 * @generated
 */
public class TaskStatusServiceSoap {

	public static com.mimacom.manager.tasklist.model.TaskStatusSoap
			addTaskStatus(
				long groupId, long taskId, int type, int progress,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.mimacom.manager.tasklist.model.TaskStatus returnValue =
				TaskStatusServiceUtil.addTaskStatus(
					groupId, taskId, type, progress, serviceContext);

			return com.mimacom.manager.tasklist.model.TaskStatusSoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.mimacom.manager.tasklist.model.TaskStatusSoap[]
			findByTaskId(long taskId)
		throws RemoteException {

		try {
			java.util.List<com.mimacom.manager.tasklist.model.TaskStatus>
				returnValue = TaskStatusServiceUtil.findByTaskId(taskId);

			return com.mimacom.manager.tasklist.model.TaskStatusSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.mimacom.manager.tasklist.model.TaskStatusSoap[]
			findByTaskId(long taskId, int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.mimacom.manager.tasklist.model.TaskStatus>
				returnValue = TaskStatusServiceUtil.findByTaskId(
					taskId, start, end);

			return com.mimacom.manager.tasklist.model.TaskStatusSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int countTaskId(long taskId) throws RemoteException {
		try {
			int returnValue = TaskStatusServiceUtil.countTaskId(taskId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.mimacom.manager.tasklist.model.TaskStatusSoap[]
			findByType(long userId, int type)
		throws RemoteException {

		try {
			java.util.List<com.mimacom.manager.tasklist.model.TaskStatus>
				returnValue = TaskStatusServiceUtil.findByType(userId, type);

			return com.mimacom.manager.tasklist.model.TaskStatusSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int countByType(long userId, int type)
		throws RemoteException {

		try {
			int returnValue = TaskStatusServiceUtil.countByType(userId, type);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.mimacom.manager.tasklist.model.TaskStatusSoap
			deleteTaskStatus(long taskStatusId)
		throws RemoteException {

		try {
			com.mimacom.manager.tasklist.model.TaskStatus returnValue =
				TaskStatusServiceUtil.deleteTaskStatus(taskStatusId);

			return com.mimacom.manager.tasklist.model.TaskStatusSoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		TaskStatusServiceSoap.class);

}