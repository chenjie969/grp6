/*---------任务事项根节点初始化----------*/

INSERT INTO gbpm_taskType  (taskType_ID, pTaskType_ID,taskTypeName,taskTypeSort,taskTypeFullCode,unit_uid,update_user,updatedatetime) VALUES 
('ff467932922a4ccdad57b15d665cac6f', 'ff467932922a4ccdad57b15d665cac6f','任务事项类型','0','ff467932922a4ccdad57b15d665cac6f/','cbeb758e3d824626a31aabb2a9587b0a','管理员',now());

/*--'在保（委贷）项目明细表','到期明细表','逾期明细表','咨询业务明细表','金额期限明细表'---功能菜单---*/
DELETE FROM sys_modules WHERE mod_uid IN ('2c057f0e133e458fa40bb4a47be36843','33dae7efc72f4db8901749fa41c47905','5e7210405c6644f2a62a1395f9af88ff','cdbd7f6d2ac940358f5b7861d480165a','f0fb4abca2c144f88d46dc621de985f8');
INSERT INTO `sys_modules` (`mod_uid`, `unit_uid`, `pmod_id`, `mod_name`, `url`, `title`, `iframe`, `icon`, `iconopen`, `isopen`, `isReload`, `order_id`, `mod_type`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('2c057f0e133e458fa40bb4a47be36843','cbeb758e3d824626a31aabb2a9587b0a','508f7a79c38b4d849873752f8ab48c10','金额期限明细表','/report/detail_report_guaranty.jsp?file=/reportXML/total_sum_deadline.xml&dateType=beginAndEnd','','','','',NULL,'1','0','1','2017-09-27 16:15:20','1','2017-09-27 16:15:20','1');
INSERT INTO `sys_modules` (`mod_uid`, `unit_uid`, `pmod_id`, `mod_name`, `url`, `title`, `iframe`, `icon`, `iconopen`, `isopen`, `isReload`, `order_id`, `mod_type`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('33dae7efc72f4db8901749fa41c47905','cbeb758e3d824626a31aabb2a9587b0a','44a07f62fedb471bbdc1b13b2cdc040c','到期明细表','/report/detail_report_guaranty.jsp?file=/reportXML/month_detail_expire_project .xml&dateType=beginAndEnd','','','','',NULL,'1','5','1','2017-09-27 16:11:16','1','2017-09-27 16:11:16','1');
INSERT INTO `sys_modules` (`mod_uid`, `unit_uid`, `pmod_id`, `mod_name`, `url`, `title`, `iframe`, `icon`, `iconopen`, `isopen`, `isReload`, `order_id`, `mod_type`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('5e7210405c6644f2a62a1395f9af88ff','cbeb758e3d824626a31aabb2a9587b0a','44a07f62fedb471bbdc1b13b2cdc040c','逾期明细表','/report/detail_report_guaranty.jsp?file=/reportXML/month_detail_overdue_project.xml&dateType=beginAndEnd','','','','',NULL,'1','6','1','2017-09-27 16:12:15','1','2017-09-27 16:12:15','1');
INSERT INTO `sys_modules` (`mod_uid`, `unit_uid`, `pmod_id`, `mod_name`, `url`, `title`, `iframe`, `icon`, `iconopen`, `isopen`, `isReload`, `order_id`, `mod_type`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('cdbd7f6d2ac940358f5b7861d480165a','cbeb758e3d824626a31aabb2a9587b0a','44a07f62fedb471bbdc1b13b2cdc040c','在保（委贷）项目明细表','/report/detail_report_guaranty.jsp?file=/reportXML/month_detail_insurance(entrust)_project.xml&dateType=endDate','','','','',NULL,'1','3','1','2017-09-27 16:09:44','1','2017-09-27 16:09:44','1');
INSERT INTO `sys_modules` (`mod_uid`, `unit_uid`, `pmod_id`, `mod_name`, `url`, `title`, `iframe`, `icon`, `iconopen`, `isopen`, `isReload`, `order_id`, `mod_type`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('f0fb4abca2c144f88d46dc621de985f8','cbeb758e3d824626a31aabb2a9587b0a','44a07f62fedb471bbdc1b13b2cdc040c','咨询业务明细表','/report/detail_report_guaranty.jsp?file=/reportXML/month_detail_consult_project .xml&dateType=beginAndEnd','','','','',NULL,'1','0','1','2017-09-27 16:13:14','1','2017-09-27 16:13:14','1');

/*--创建评委库表---*/
create table pro_meetingJury
(
   meetingJury_ID       varchar(32) not null,
   userUid              varchar(32) not null,
   userName             varchar(20),
   juryStatus           char(2),
   unit_uid             varchar(32),
   updateUserName       varchar(20),
   updateDateTime       datetime,
   primary key (meetingJury_ID)
);

/*--创建评委库表---*/
ALTER TABLE pro_apply ADD isApplyMeeting bool default 0;
/*--修改会议开始时间字段---*/
ALTER TABLE oa_meeting CHANGE meetingBeginTim meetingBeginTime TIME NULL;



