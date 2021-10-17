create index IX_CB46579B on tlm_Task (userId, groupId);

create index IX_6A905D1C on tlm_TaskStatus (taskId, progress);
create index IX_1D21D47A on tlm_TaskStatus (taskId, type_);
create index IX_8E473200 on tlm_TaskStatus (taskId, userId, type_);
create index IX_FA19A0E2 on tlm_TaskStatus (userId, progress);
create index IX_83469674 on tlm_TaskStatus (userId, type_);