/*****************mashuo add 2017-07-10 begin activiti 用户信息视图********************/
/***身份信息-组信息***/
CREATE  VIEW `act_id_group` AS
(SELECT 
role_uid AS ID_,/** 用户组id **/
1 AS REV_,/**版本号**/
role_name AS NAME_,/**用户组名称**/
'' AS TYPE_/**用户组类型**/
 FROM sys_roles);

/***身份信息-组信息***/
CREATE  VIEW `act_id_info` AS
(SELECT 
user_uid AS ID_,/**主键**/
1 AS REV_,/**版本号**/
user_uid AS USER_ID_,/**用户id**/
'' AS TYPE_,/**类型**/
'' AS KEY_,/**formInPut名称\属性名**/
'' AS VALUE_,/**formInPut值\属性值**/
'' AS PASSWORD_,/**密码**/
'' AS PARENT_ID_/**父节点\上级关联**/
 FROM sys_users);

/***身份信息-用户和组关系的中间表***/
CREATE  VIEW `act_id_membership` AS
(SELECT 
user_uid AS USER_ID_,/**用户id**/
role_uid AS GROUP_ID_/**用户组id**/
 FROM sys_roles_user);

/***身份信息-用户信息***/
CREATE  VIEW `act_id_user` AS
(SELECT 
user_uid AS ID_,/**id**/
1 AS REV_,/**版本号**/
user_name AS FIRST_,/**用户名称**/
'' AS LAST_,/**用户姓氏**/
'' AS EMAIL_,/**邮箱**/
'' AS PWD_,/**密码**/
'' AS PICTURE_ID_/**头像id\ACT_GE_BYTEARRAY**/
 FROM sys_users);
/*****************mashuo add 2017-07-10 end activiti 用户信息视图********************/
 
 
 /*****************mashuo add 2017-07-13 begin activiti 部署与模型关系表********************/
 CREATE TABLE act_re_model_deployment (
 modelID varchar(64) NOT NULL,
 deploymentID varchar(64) NOT NULL,
 unit_uid varchar(64) NOT NULL
 );
 /*****************mashuo add 2017-07-13 end activiti 部署与模型关系表********************/
  /*****************mashuo add 2017-07-13 begin 流程分类表********************/
 CREATE TABLE act_re_actsort (
 actSortID varchar(32) NOT NULL,
 pactSortID varchar(32) NOT NULL,
 unit_uid varchar(32) NOT NULL,
 actSortName varchar(50) NOT NULL,
 actSortFullCode varchar(200) NOT NULL,
 order_id int(11),
 remark text,
 isOpen tinyint(1),
 createdatetime datetime,
 create_user varchar(30),
 updatedatetime datetime,
 update_user varchar(30)
 );
 /*****************mashuo add 2017-07-13 end 流程分类表********************/
  /*****************mashuo add 2017-07-13 begin activiti 模型与流程分类关系表********************/
 CREATE TABLE act_re_model_actsort (
 modelID varchar(64) NOT NULL,
 actSortID varchar(32) NOT NULL,
 unit_uid varchar(64) NOT NULL
 );
 /*****************mashuo add 2017-07-13 end activiti 模型与流程分类关系表********************/
 
 
 insert into `act_re_actsort` (`actSortID`, `pactSortID`, `unit_uid`, `actSortName`, `actSortFullCode`, `order_id`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`, `isOpen`) values('4f36d0e58b63440eb9bf3324f0984f84','-1','cbeb758e3d824626a31aabb2a9587b0a','流程分类','4f36d0e58b63440eb9bf3324f0984f84/','0','','2017-07-14 15:35:14','管理员','2017-07-14 16:15:19','管理员','1');
insert into `act_re_actsort` (`actSortID`, `pactSortID`, `unit_uid`, `actSortName`, `actSortFullCode`, `order_id`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`, `isOpen`) values('40ad8657d27e46ef9b4da71fa2d6b9c2','4f36d0e58b63440eb9bf3324f0984f84','cbeb758e3d824626a31aabb2a9587b0a','业务流程','4f36d0e58b63440eb9bf3324f0984f84/40ad8657d27e46ef9b4da71fa2d6b9c2/','1','','2017-07-14 21:24:03','管理员','2017-07-14 21:24:03','管理员','0');
insert into `act_re_actsort` (`actSortID`, `pactSortID`, `unit_uid`, `actSortName`, `actSortFullCode`, `order_id`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`, `isOpen`) values('a3226c25607c4692a46e68727e653302','4f36d0e58b63440eb9bf3324f0984f84','cbeb758e3d824626a31aabb2a9587b0a','OA流程','4f36d0e58b63440eb9bf3324f0984f84/a3226c25607c4692a46e68727e653302/','2','','2017-07-14 21:24:13','管理员','2017-07-14 21:24:13','管理员','0');
