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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.mimacom.manager.tasklist.model.TaskStatus;
import com.mimacom.manager.tasklist.service.base.TaskStatusLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the task status local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.mimacom.manager.tasklist.service.TaskStatusLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskStatusLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.mimacom.manager.tasklist.model.TaskStatus",
	service = AopService.class
)
public class TaskStatusLocalServiceImpl extends TaskStatusLocalServiceBaseImpl {

	public TaskStatus addTaskStatus (long groupId, long taskId, int type, int progress, ServiceContext serviceContext) throws PortalException{
		long taskStatusId = counterLocalService.increment(TaskStatus.class.getName());
		User user = userLocalService.getUser(serviceContext.getUserId());
		
		TaskStatus newTaskStatus = super.createTaskStatus(taskStatusId);
		newTaskStatus.setGroupId(groupId);
		newTaskStatus.setCompanyId(serviceContext.getCompanyId());
		newTaskStatus.setUserId(user.getUserId());
		newTaskStatus.setUserName(user.getScreenName());
		newTaskStatus.setCreateDate(serviceContext.getCreateDate(new Date()));
		newTaskStatus.setTaskId(taskId);
		newTaskStatus.setType(type);
		newTaskStatus.setProgress(progress);
		
		return super.addTaskStatus(newTaskStatus);
	}
	
	public List<TaskStatus> findByTaskId(long taskId){
		return taskStatusPersistence.findByTaskId(taskId);
	}
	
	public List<TaskStatus> findByTaskId(long taskId, int start, int end){
		return taskStatusPersistence.findByTaskId(taskId, start, end);
	}
	
	public int countTaskId(long taskId){
		return taskStatusPersistence.countByTaskId(taskId);
	}
	
	public List<TaskStatus> findByType(long userId, int type){
		return taskStatusPersistence.findByType(userId, type);
	}
	
	public int countByType(long userId, int type){
		return taskStatusPersistence.countByType(userId, type);
	}
}