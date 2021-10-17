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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the TaskStatus service. Represents a row in the &quot;tlm_TaskStatus&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.mimacom.manager.tasklist.model.impl.TaskStatusModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.mimacom.manager.tasklist.model.impl.TaskStatusImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskStatus
 * @generated
 */
@ProviderType
public interface TaskStatusModel
	extends BaseModel<TaskStatus>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a task status model instance should use the {@link TaskStatus} interface instead.
	 */

	/**
	 * Returns the primary key of this task status.
	 *
	 * @return the primary key of this task status
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this task status.
	 *
	 * @param primaryKey the primary key of this task status
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the task status ID of this task status.
	 *
	 * @return the task status ID of this task status
	 */
	public long getTaskStatusId();

	/**
	 * Sets the task status ID of this task status.
	 *
	 * @param taskStatusId the task status ID of this task status
	 */
	public void setTaskStatusId(long taskStatusId);

	/**
	 * Returns the group ID of this task status.
	 *
	 * @return the group ID of this task status
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this task status.
	 *
	 * @param groupId the group ID of this task status
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this task status.
	 *
	 * @return the company ID of this task status
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this task status.
	 *
	 * @param companyId the company ID of this task status
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this task status.
	 *
	 * @return the user ID of this task status
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this task status.
	 *
	 * @param userId the user ID of this task status
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this task status.
	 *
	 * @return the user uuid of this task status
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this task status.
	 *
	 * @param userUuid the user uuid of this task status
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this task status.
	 *
	 * @return the user name of this task status
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this task status.
	 *
	 * @param userName the user name of this task status
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this task status.
	 *
	 * @return the create date of this task status
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this task status.
	 *
	 * @param createDate the create date of this task status
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this task status.
	 *
	 * @return the modified date of this task status
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this task status.
	 *
	 * @param modifiedDate the modified date of this task status
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the type of this task status.
	 *
	 * @return the type of this task status
	 */
	public int getType();

	/**
	 * Sets the type of this task status.
	 *
	 * @param type the type of this task status
	 */
	public void setType(int type);

	/**
	 * Returns the progress of this task status.
	 *
	 * @return the progress of this task status
	 */
	public int getProgress();

	/**
	 * Sets the progress of this task status.
	 *
	 * @param progress the progress of this task status
	 */
	public void setProgress(int progress);

	/**
	 * Returns the task ID of this task status.
	 *
	 * @return the task ID of this task status
	 */
	public long getTaskId();

	/**
	 * Sets the task ID of this task status.
	 *
	 * @param taskId the task ID of this task status
	 */
	public void setTaskId(long taskId);

}