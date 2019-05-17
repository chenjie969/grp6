/*============最高时点金额(委贷)==*/
ALTER TABLE crm_client ADD COLUMN timePointEntrustSum DECIMAL(18,6) NULL;
/*============敏感债权人在保金额==*/
ALTER TABLE crm_client ADD COLUMN creditorGuarSum DECIMAL(18,6) NULL;
/*============2015年分类处置划分ID（字典）==*/
ALTER TABLE crm_client ADD COLUMN oldDivisionID varchar(32) ;
/*============2015年分类处置划分名称==*/
ALTER TABLE crm_client ADD COLUMN oldDivisionName varchar(20) ;
/*============分类处置划分ID==*/
ALTER TABLE crm_client ADD COLUMN divisionID varchar(32) ;
/*============分类处置划分名称==*/
ALTER TABLE crm_client ADD COLUMN divisionName varchar(20) ;

/*============字典表中新增分类处置划分字典==*/
DELETE FROM `c_dictype` WHERE `dicTypeID`='cb2b7adef9c740daa4c43fda3d4d4d11' OR  `dicTypePID` = 'cb2b7adef9c740daa4c43fda3d4d4d11';

INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) 
VALUES('cb2b7adef9c740daa4c43fda3d4d4d11','cbeb758e3d824626a31aabb2a9587b0a','109db432755c4f7ba0610be16df3bea7','项目分类处置划分','65','0','0',NULL,'','2017-11-22 15:11:41','管理员','2017-11-22 15:11:41','管理员');


INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) 
VALUES('2e172a72d091496585d9fc9f2a439d3e','cbeb758e3d824626a31aabb2a9587b0a','cb2b7adef9c740daa4c43fda3d4d4d11','帮助扶持类','0','0','0',NULL,'','2017-11-22 15:11:41','管理员','2017-11-22 15:11:41','管理员');

INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) 
VALUES('1cc1e6b03d1d427c87cf1a636953d817','cbeb758e3d824626a31aabb2a9587b0a','cb2b7adef9c740daa4c43fda3d4d4d11','快速提升类','1','0','0',NULL,'','2017-11-22 15:11:41','管理员','2017-11-22 15:11:41','管理员');

INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) 
VALUES('c8b0e981e1f74f60b50a0293d827329c','cbeb758e3d824626a31aabb2a9587b0a','cb2b7adef9c740daa4c43fda3d4d4d11','依法处置类','2','0','0',NULL,'','2017-11-22 15:11:41','管理员','2017-11-22 15:11:41','管理员');

INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) 
VALUES('ffcb6b6a9ccb44ea8bb7582af5feabc1','cbeb758e3d824626a31aabb2a9587b0a','cb2b7adef9c740daa4c43fda3d4d4d11','支持发展类','3','0','0',NULL,'','2017-11-22 15:11:41','管理员','2017-11-22 15:11:41','管理员');

INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) 
VALUES('f8c5709585454b66b4e1091a65a81abd','cbeb758e3d824626a31aabb2a9587b0a','cb2b7adef9c740daa4c43fda3d4d4d11','重组盘活类','4','0','0',NULL,'','2017-11-22 15:11:41','管理员','2017-11-22 15:11:41','管理员');

INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) 
VALUES('36b1f8d9be264549b98d179665647c43','cbeb758e3d824626a31aabb2a9587b0a','cb2b7adef9c740daa4c43fda3d4d4d11','未划分','5','0','0',NULL,'','2017-11-22 15:11:41','管理员','2017-11-22 15:11:41','管理员');

