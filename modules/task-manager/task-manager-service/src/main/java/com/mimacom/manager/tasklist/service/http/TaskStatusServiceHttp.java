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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.mimacom.manager.tasklist.service.TaskStatusServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>TaskStatusServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskStatusServiceSoap
 * @generated
 */
public class TaskStatusServiceHttp {

	public static com.mimacom.manager.tasklist.model.TaskStatus addTaskStatus(
			HttpPrincipal httpPrincipal, long groupId, long taskId, int type,
			int progress,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TaskStatusServiceUtil.class, "addTaskStatus",
				_addTaskStatusParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, taskId, type, progress, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.mimacom.manager.tasklist.model.TaskStatus)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.mimacom.manager.tasklist.model.TaskStatus>
		findByTaskId(HttpPrincipal httpPrincipal, long taskId) {

		try {
			MethodKey methodKey = new MethodKey(
				TaskStatusServiceUtil.class, "findByTaskId",
				_findByTaskIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, taskId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.mimacom.manager.tasklist.model.TaskStatus>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.mimacom.manager.tasklist.model.TaskStatus>
		findByTaskId(
			HttpPrincipal httpPrincipal, long taskId, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				TaskStatusServiceUtil.class, "findByTaskId",
				_findByTaskIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, taskId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.mimacom.manager.tasklist.model.TaskStatus>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int countTaskId(HttpPrincipal httpPrincipal, long taskId) {
		try {
			MethodKey methodKey = new MethodKey(
				TaskStatusServiceUtil.class, "countTaskId",
				_countTaskIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, taskId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.mimacom.manager.tasklist.model.TaskStatus>
		findByType(HttpPrincipal httpPrincipal, long userId, int type) {

		try {
			MethodKey methodKey = new MethodKey(
				TaskStatusServiceUtil.class, "findByType",
				_findByTypeParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, type);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.mimacom.manager.tasklist.model.TaskStatus>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int countByType(
		HttpPrincipal httpPrincipal, long userId, int type) {

		try {
			MethodKey methodKey = new MethodKey(
				TaskStatusServiceUtil.class, "countByType",
				_countByTypeParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, type);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.mimacom.manager.tasklist.model.TaskStatus
			deleteTaskStatus(HttpPrincipal httpPrincipal, long taskStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TaskStatusServiceUtil.class, "deleteTaskStatus",
				_deleteTaskStatusParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, taskStatusId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.mimacom.manager.tasklist.model.TaskStatus)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		TaskStatusServiceHttp.class);

	private static final Class<?>[] _addTaskStatusParameterTypes0 =
		new Class[] {
			long.class, long.class, int.class, int.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _findByTaskIdParameterTypes1 = new Class[] {
		long.class
	};
	private static final Class<?>[] _findByTaskIdParameterTypes2 = new Class[] {
		long.class, int.class, int.class
	};
	private static final Class<?>[] _countTaskIdParameterTypes3 = new Class[] {
		long.class
	};
	private static final Class<?>[] _findByTypeParameterTypes4 = new Class[] {
		long.class, int.class
	};
	private static final Class<?>[] _countByTypeParameterTypes5 = new Class[] {
		long.class, int.class
	};
	private static final Class<?>[] _deleteTaskStatusParameterTypes6 =
		new Class[] {long.class};

}