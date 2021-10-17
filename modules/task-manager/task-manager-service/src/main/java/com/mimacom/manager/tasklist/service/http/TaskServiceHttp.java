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

import com.mimacom.manager.tasklist.service.TaskServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>TaskServiceUtil</code> service
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
 * @see TaskServiceSoap
 * @generated
 */
public class TaskServiceHttp {

	public static com.mimacom.manager.tasklist.model.Task addTask(
			HttpPrincipal httpPrincipal, long groupId, String title,
			String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TaskServiceUtil.class, "addTask", _addTaskParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, title, description, serviceContext);

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

			return (com.mimacom.manager.tasklist.model.Task)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.mimacom.manager.tasklist.model.Task updateTask(
			HttpPrincipal httpPrincipal, long taskId, String title,
			String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TaskServiceUtil.class, "updateTask",
				_updateTaskParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, taskId, title, description, serviceContext);

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

			return (com.mimacom.manager.tasklist.model.Task)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.mimacom.manager.tasklist.model.Task>
		findByUserId(HttpPrincipal httpPrincipal, long userId) {

		try {
			MethodKey methodKey = new MethodKey(
				TaskServiceUtil.class, "findByUserId",
				_findByUserIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.mimacom.manager.tasklist.model.Task>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.mimacom.manager.tasklist.model.Task>
		findByUserId(
			HttpPrincipal httpPrincipal, long userId, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				TaskServiceUtil.class, "findByUserId",
				_findByUserIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.mimacom.manager.tasklist.model.Task>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int countbyUserId(HttpPrincipal httpPrincipal, long userId) {
		try {
			MethodKey methodKey = new MethodKey(
				TaskServiceUtil.class, "countbyUserId",
				_countbyUserIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId);

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

	public static java.util.List<com.mimacom.manager.tasklist.model.Task>
		findByUserIdAndGroupId(
			HttpPrincipal httpPrincipal, long userId, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				TaskServiceUtil.class, "findByUserIdAndGroupId",
				_findByUserIdAndGroupIdParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.mimacom.manager.tasklist.model.Task>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.mimacom.manager.tasklist.model.Task>
		findByUserIdAndGroupId(
			HttpPrincipal httpPrincipal, long userId, long groupId, int start,
			int end) {

		try {
			MethodKey methodKey = new MethodKey(
				TaskServiceUtil.class, "findByUserIdAndGroupId",
				_findByUserIdAndGroupIdParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, groupId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.mimacom.manager.tasklist.model.Task>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int countbyUserIdAndGroupid(
		HttpPrincipal httpPrincipal, long userId, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				TaskServiceUtil.class, "countbyUserIdAndGroupid",
				_countbyUserIdAndGroupidParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, groupId);

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

	public static com.mimacom.manager.tasklist.model.Task findByTaskId(
			HttpPrincipal httpPrincipal, long taskId)
		throws com.mimacom.manager.tasklist.exception.NoSuchTaskException {

		try {
			MethodKey methodKey = new MethodKey(
				TaskServiceUtil.class, "findByTaskId",
				_findByTaskIdParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(methodKey, taskId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.mimacom.manager.tasklist.exception.
							NoSuchTaskException) {

					throw (com.mimacom.manager.tasklist.exception.
						NoSuchTaskException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.mimacom.manager.tasklist.model.Task)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.mimacom.manager.tasklist.model.Task fetchTask(
		HttpPrincipal httpPrincipal, long taskId) {

		try {
			MethodKey methodKey = new MethodKey(
				TaskServiceUtil.class, "fetchTask", _fetchTaskParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(methodKey, taskId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.mimacom.manager.tasklist.model.Task)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.mimacom.manager.tasklist.model.Task>
		findByKeywords(
			HttpPrincipal httpPrincipal, long groupId, String keywords,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.mimacom.manager.tasklist.model.Task> orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				TaskServiceUtil.class, "findByKeywords",
				_findByKeywordsParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, keywords, start, end, orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.mimacom.manager.tasklist.model.Task>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.mimacom.manager.tasklist.model.Task deleteTask(
			HttpPrincipal httpPrincipal, long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TaskServiceUtil.class, "deleteTask",
				_deleteTaskParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(methodKey, taskId);

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

			return (com.mimacom.manager.tasklist.model.Task)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TaskServiceHttp.class);

	private static final Class<?>[] _addTaskParameterTypes0 = new Class[] {
		long.class, String.class, String.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _updateTaskParameterTypes1 = new Class[] {
		long.class, String.class, String.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _findByUserIdParameterTypes2 = new Class[] {
		long.class
	};
	private static final Class<?>[] _findByUserIdParameterTypes3 = new Class[] {
		long.class, int.class, int.class
	};
	private static final Class<?>[] _countbyUserIdParameterTypes4 =
		new Class[] {long.class};
	private static final Class<?>[] _findByUserIdAndGroupIdParameterTypes5 =
		new Class[] {long.class, long.class};
	private static final Class<?>[] _findByUserIdAndGroupIdParameterTypes6 =
		new Class[] {long.class, long.class, int.class, int.class};
	private static final Class<?>[] _countbyUserIdAndGroupidParameterTypes7 =
		new Class[] {long.class, long.class};
	private static final Class<?>[] _findByTaskIdParameterTypes8 = new Class[] {
		long.class
	};
	private static final Class<?>[] _fetchTaskParameterTypes9 = new Class[] {
		long.class
	};
	private static final Class<?>[] _findByKeywordsParameterTypes10 =
		new Class[] {
			long.class, String.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _deleteTaskParameterTypes11 = new Class[] {
		long.class
	};

}