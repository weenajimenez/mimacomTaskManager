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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.mimacom.manager.tasklist.exception.NoSuchTaskException;
import com.mimacom.manager.tasklist.model.Task;
import com.mimacom.manager.tasklist.service.base.TaskServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the task remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.mimacom.manager.tasklist.service.TaskService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=tlm",
		"json.web.service.context.path=Task"
	},
	service = AopService.class
)
public class TaskServiceImpl extends TaskServiceBaseImpl {

	public Task addTask (long groupId, String title, String description, ServiceContext serviceContext) throws PortalException {
		return taskLocalService.addTask(groupId,title,description, serviceContext);
	}
	
	public Task updateTask (long taskId, String title, String description, ServiceContext serviceContext) throws PortalException{
		return taskLocalService.updateTask(taskId, title, description, serviceContext);
	}
	
	public List<Task> findByUserId(long userId){
		return taskLocalService.findByUserId(userId);
	}
	
	public List<Task> findByUserId(long userId, int start, int end){
		return taskLocalService.findByUserId(userId, start, end);
	}
	
	public int countbyUserId(long userId){
		return taskLocalService.countbyUserId(userId);
	}
	
	public List<Task> findByUserIdAndGroupId(long userId, long groupId){
		return taskLocalService.findByUserIdAndGroupId(userId, groupId);
	}
	
	public List<Task> findByUserIdAndGroupId(long userId, long groupId, int start, int end){
		return taskLocalService.findByUserIdAndGroupId(userId, groupId,start,end);
	}
	
	public int countbyUserIdAndGroupid(long userId, long groupId){
		return taskLocalService.countbyUserIdAndGroupid(userId, groupId);
	}
	
	public Task findByTaskId(long taskId) throws NoSuchTaskException{
		return taskLocalService.findByTaskId(taskId);
	}
	
	public Task fetchTask(long taskId){
		return taskLocalService.fetchTask(taskId);
	}
	
	public List<Task> findByKeywords(long groupId,String keywords, int start, int end, OrderByComparator<Task> orderByComparator){
		return taskLocalService.findByKeywords(groupId, keywords, start, end, orderByComparator);
	}
	
	public Task deleteTask(long taskId) throws PortalException {
		return taskLocalService.deleteTask(taskId);
	}
}