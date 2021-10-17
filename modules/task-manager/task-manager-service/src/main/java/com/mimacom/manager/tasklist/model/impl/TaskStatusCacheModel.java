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

package com.mimacom.manager.tasklist.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.mimacom.manager.tasklist.model.TaskStatus;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TaskStatus in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TaskStatusCacheModel
	implements CacheModel<TaskStatus>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TaskStatusCacheModel)) {
			return false;
		}

		TaskStatusCacheModel taskStatusCacheModel =
			(TaskStatusCacheModel)object;

		if (taskStatusId == taskStatusCacheModel.taskStatusId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, taskStatusId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{taskStatusId=");
		sb.append(taskStatusId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", type=");
		sb.append(type);
		sb.append(", progress=");
		sb.append(progress);
		sb.append(", taskId=");
		sb.append(taskId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TaskStatus toEntityModel() {
		TaskStatusImpl taskStatusImpl = new TaskStatusImpl();

		taskStatusImpl.setTaskStatusId(taskStatusId);
		taskStatusImpl.setGroupId(groupId);
		taskStatusImpl.setCompanyId(companyId);
		taskStatusImpl.setUserId(userId);

		if (userName == null) {
			taskStatusImpl.setUserName("");
		}
		else {
			taskStatusImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			taskStatusImpl.setCreateDate(null);
		}
		else {
			taskStatusImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			taskStatusImpl.setModifiedDate(null);
		}
		else {
			taskStatusImpl.setModifiedDate(new Date(modifiedDate));
		}

		taskStatusImpl.setType(type);
		taskStatusImpl.setProgress(progress);
		taskStatusImpl.setTaskId(taskId);

		taskStatusImpl.resetOriginalValues();

		return taskStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		taskStatusId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		type = objectInput.readInt();

		progress = objectInput.readInt();

		taskId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(taskStatusId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(type);

		objectOutput.writeInt(progress);

		objectOutput.writeLong(taskId);
	}

	public long taskStatusId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int type;
	public int progress;
	public long taskId;

}