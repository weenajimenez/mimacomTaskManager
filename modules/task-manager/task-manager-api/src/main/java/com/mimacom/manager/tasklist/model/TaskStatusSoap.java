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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mimacom.manager.tasklist.service.http.TaskStatusServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TaskStatusSoap implements Serializable {

	public static TaskStatusSoap toSoapModel(TaskStatus model) {
		TaskStatusSoap soapModel = new TaskStatusSoap();

		soapModel.setTaskStatusId(model.getTaskStatusId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setType(model.getType());
		soapModel.setProgress(model.getProgress());
		soapModel.setTaskId(model.getTaskId());

		return soapModel;
	}

	public static TaskStatusSoap[] toSoapModels(TaskStatus[] models) {
		TaskStatusSoap[] soapModels = new TaskStatusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaskStatusSoap[][] toSoapModels(TaskStatus[][] models) {
		TaskStatusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TaskStatusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaskStatusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaskStatusSoap[] toSoapModels(List<TaskStatus> models) {
		List<TaskStatusSoap> soapModels = new ArrayList<TaskStatusSoap>(
			models.size());

		for (TaskStatus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaskStatusSoap[soapModels.size()]);
	}

	public TaskStatusSoap() {
	}

	public long getPrimaryKey() {
		return _taskStatusId;
	}

	public void setPrimaryKey(long pk) {
		setTaskStatusId(pk);
	}

	public long getTaskStatusId() {
		return _taskStatusId;
	}

	public void setTaskStatusId(long taskStatusId) {
		_taskStatusId = taskStatusId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	public int getProgress() {
		return _progress;
	}

	public void setProgress(int progress) {
		_progress = progress;
	}

	public long getTaskId() {
		return _taskId;
	}

	public void setTaskId(long taskId) {
		_taskId = taskId;
	}

	private long _taskStatusId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _type;
	private int _progress;
	private long _taskId;

}