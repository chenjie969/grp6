/*---------任务事项类型初始化数据----------*/
INSERT INTO gbpm_tasktype_task (taskManager_ID, taskType_ID) select taskManager_ID,'ff467932922a4ccdad57b15d665cac6f' from gbpm_dic_taskmanager;
/*---------修改任务事项类型根节点的父节点----------*/
UPDATE gbpm_tasktype SET pTaskType_ID = '-1' where taskType_ID = 'ff467932922a4ccdad57b15d665cac6f';

