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

package com.mimacom.manager.tasklist.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.mimacom.manager.tasklist.model.Task;
import com.mimacom.manager.tasklist.model.TaskStatus;
import com.mimacom.manager.tasklist.service.base.TaskStatusServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the task status remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.mimacom.manager.tasklist.service.TaskStatusService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskStatusServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=tlm",
		"json.web.service.context.path=TaskStatus"
	},
	service = AopService.class
)
public class TaskStatusServiceImpl extends TaskStatusServiceBaseImpl {

	public TaskStatus addTaskStatus (long groupId,long taskId, int type, int progress, ServiceContext serviceContext) throws PortalException{
		return taskStatusLocalService.addTaskStatus(groupId,taskId, type, progress, serviceContext);
	}
	
	public List<TaskStatus> findByTaskId(long taskId){
		return taskStatusLocalService.findByTaskId(taskId);
	}
	
	public List<TaskStatus> findByTaskId(long taskId, int start, int end){
		return taskStatusLocalService.findByTaskId(taskId, start, end);
	}
	
	public int countTaskId(long taskId){
		return taskStatusLocalService.countTaskId(taskId);
	}
	
	public List<TaskStatus> findByType(long userId, int type){
		return taskStatusLocalService.findByType(userId, type);
	}
	
	public int countByType(long userId, int type){
		return taskStatusLocalService.countByType(userId, type);
	}
	
	public TaskStatus deleteTaskStatus(long taskStatusId) throws PortalException {
		return taskStatusLocalService.deleteTaskStatus(taskStatusId);
	}
}