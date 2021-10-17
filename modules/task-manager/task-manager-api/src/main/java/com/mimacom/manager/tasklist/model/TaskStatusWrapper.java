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

package com.mimacom.manager.tasklist.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TaskStatus}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskStatus
 * @generated
 */
public class TaskStatusWrapper
	extends BaseModelWrapper<TaskStatus>
	implements ModelWrapper<TaskStatus>, TaskStatus {

	public TaskStatusWrapper(TaskStatus taskStatus) {
		super(taskStatus);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taskStatusId", getTaskStatusId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("type", getType());
		attributes.put("progress", getProgress());
		attributes.put("taskId", getTaskId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taskStatusId = (Long)attributes.get("taskStatusId");

		if (taskStatusId != null) {
			setTaskStatusId(taskStatusId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Integer progress = (Integer)attributes.get("progress");

		if (progress != null) {
			setProgress(progress);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}
	}

	/**
	 * Returns the company ID of this task status.
	 *
	 * @return the company ID of this task status
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this task status.
	 *
	 * @return the create date of this task status
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this task status.
	 *
	 * @return the group ID of this task status
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this task status.
	 *
	 * @return the modified date of this task status
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this task status.
	 *
	 * @return the primary key of this task status
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the progress of this task status.
	 *
	 * @return the progress of this task status
	 */
	@Override
	public int getProgress() {
		return model.getProgress();
	}

	/**
	 * Returns the task ID of this task status.
	 *
	 * @return the task ID of this task status
	 */
	@Override
	public long getTaskId() {
		return model.getTaskId();
	}

	/**
	 * Returns the task status ID of this task status.
	 *
	 * @return the task status ID of this task status
	 */
	@Override
	public long getTaskStatusId() {
		return model.getTaskStatusId();
	}

	/**
	 * Returns the type of this task status.
	 *
	 * @return the type of this task status
	 */
	@Override
	public int getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this task status.
	 *
	 * @return the user ID of this task status
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this task status.
	 *
	 * @return the user name of this task status
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this task status.
	 *
	 * @return the user uuid of this task status
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this task status.
	 *
	 * @param companyId the company ID of this task status
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this task status.
	 *
	 * @param createDate the create date of this task status
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this task status.
	 *
	 * @param groupId the group ID of this task status
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this task status.
	 *
	 * @param modifiedDate the modified date of this task status
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this task status.
	 *
	 * @param primaryKey the primary key of this task status
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the progress of this task status.
	 *
	 * @param progress the progress of this task status
	 */
	@Override
	public void setProgress(int progress) {
		model.setProgress(progress);
	}

	/**
	 * Sets the task ID of this task status.
	 *
	 * @param taskId the task ID of this task status
	 */
	@Override
	public void setTaskId(long taskId) {
		model.setTaskId(taskId);
	}

	/**
	 * Sets the task status ID of this task status.
	 *
	 * @param taskStatusId the task status ID of this task status
	 */
	@Override
	public void setTaskStatusId(long taskStatusId) {
		model.setTaskStatusId(taskStatusId);
	}

	/**
	 * Sets the type of this task status.
	 *
	 * @param type the type of this task status
	 */
	@Override
	public void setType(int type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this task status.
	 *
	 * @param userId the user ID of this task status
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this task status.
	 *
	 * @param userName the user name of this task status
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this task status.
	 *
	 * @param userUuid the user uuid of this task status
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected TaskStatusWrapper wrap(TaskStatus taskStatus) {
		return new TaskStatusWrapper(taskStatus);
	}

}