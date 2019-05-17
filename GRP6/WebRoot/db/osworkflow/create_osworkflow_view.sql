

/* 项目流程对应表  */
ALTER TABLE os_gworkflow_projidflowid ADD departid varchar(32);
ALTER TABLE os_gworkflow_projidflowid ADD useruid varchar(32);
ALTER TABLE os_gworkflow_projidflowid ADD createdatetime DATETIME;
/*项目与流程对应表增加一个流程类型字段    mashuo add 20150505*/
ALTER TABLE os_gworkflow_projidflowid ADD flowType VARCHAR(10);
ALTER TABLE os_gworkflow_projidflowid ADD entityName VARCHAR(100);
