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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.mimacom.manager.tasklist.exception.NoSuchTaskException;
import com.mimacom.manager.tasklist.model.Task;
import com.mimacom.manager.tasklist.service.base.TaskLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the task local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.mimacom.manager.tasklist.service.TaskLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.mimacom.manager.tasklist.model.Task",
	service = AopService.class
)
public class TaskLocalServiceImpl extends TaskLocalServiceBaseImpl {

	public Task addTask (long groupId, String title, String description, ServiceContext serviceContext) throws PortalException {
		long taskId = counterLocalService.increment(Task.class.getName());
		Task newTask = super.createTask(taskId);
		newTask.setGroupId(groupId);
		newTask.setUserId(serviceContext.getUserId());
		User user = userLocalService.getUser(serviceContext.getUserId());
		newTask.setUserName(user.getScreenName());
		newTask.setCompanyId(serviceContext.getCompanyId());
		newTask.setCreateDate(serviceContext.getCreateDate(new Date()));
		newTask.setTitle(title);
		newTask.setDescription(description);
		return super.addTask(newTask);
	}
	
	public Task updateTask (long taskId, String title, String description, ServiceContext serviceContext) throws PortalException{
		Task updateTask = getTask(taskId);
		updateTask.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		updateTask.setTitle(title);
		updateTask.setDescription(description);
		return super.updateTask(updateTask);
	}
	
	public List<Task> findByUserId(long userId){
		return taskPersistence.findByUserId(userId);
	}
	
	public List<Task> findByUserId(long userId, int start, int end){
		return taskPersistence.findByUserId(userId, start, end);
	}
	
	public int countbyUserId(long userId){
		return taskPersistence.countByUserId(userId);
	}
	
	public List<Task> findByUserIdAndGroupId(long userId, long groupId){
		return taskPersistence.findByUserIdAndGroupId(userId, groupId);
	}
	
	public List<Task> findByUserIdAndGroupId(long userId, long groupId, int start, int end){
		return taskPersistence.findByUserIdAndGroupId(userId, groupId,start,end);
	}
	
	public int countbyUserIdAndGroupid(long userId, long groupId){
		return taskPersistence.countByUserIdAndGroupId(userId, groupId);
	}
	
	public Task findByTaskId(long taskId) throws NoSuchTaskException{
		return taskPersistence.findByTaskId(taskId);
	}
	
	public Task fetchTask(long taskId){
		return taskPersistence.fetchByPrimaryKey(taskId);
	}
	
	public List<Task> findByKeywords(long groupId,String keywords, int start, int end, OrderByComparator<Task> orderByComparator){
		DynamicQuery query = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
		if (Validator.isNotNull(keywords)) {
			 Junction disjunction = RestrictionsFactoryUtil.disjunction()
					.add(
							RestrictionsFactoryUtil.like("title",'%'+ keywords+'%')
					).add(
							RestrictionsFactoryUtil.like("description",'%'+ keywords+'%')
					);
			 query.add(disjunction);
		}
		return dynamicQuery(query, start, end, orderByComparator);
	}
}