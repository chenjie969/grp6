/*==============================================================*/
/* Table: gbpm_taskType任务类型表                                                                                   */
/*==============================================================*/
create table gbpm_taskType
(
   taskType_ID          varchar(32) not null,
   pTaskType_ID         varchar(32),
   taskTypeName         varchar(100),
   taskTypeSort         smallint,
   taskTypeFullCode     text,
   remark               varchar(500),
   unit_uid             varchar(32) not null,
   unit_uidName         varchar(50),
   updatedatetime       datetime,
   update_user          varchar(20),
   primary key (taskType_ID)
);

/*==============================================================*/
/* Table: gbpm_taskType_taskManager   任务类型与任务事项关联表                    */
/*==============================================================*/
create table gbpm_taskType_task
(
   taskType_ID          varchar(32) not null,
   taskManager_ID       varchar(32) not null,
   primary key (taskType_ID, taskManager_ID)
);

alter table gbpm_taskType_task add constraint FK_gbpm_taskType_task foreign key (taskType_ID)
      references gbpm_taskType (taskType_ID) on delete restrict on update restrict;

alter table gbpm_taskType_task add constraint FK_gbpm_taskType_task2 foreign key (taskManager_ID)
      references gbpm_dic_taskManager (taskManager_ID) on delete restrict on update restrict;

/*============删除原来任务表中的任务类型=====================*/
ALTER TABLE gbpm_dic_taskmanager DROP COLUMN taskTypeID;
















