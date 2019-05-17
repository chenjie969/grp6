/*============意见是否已提交==*/
ALTER TABLE pro_jurysuggest ADD suggestStatus BOOL DEFAULT 0;
/*============更新gbpm_nodeTask操作者类型数据==*/
UPDATE gbpm_nodetask set operaterTypeName = '角色中某一人' WHERE operaterTypeName = '角色';
/*==========添加==资金来源==*/
DELETE FROM c_dictype WHERE dicTypeID = '9c153f83aca84d299a2e6733efcc4e82' OR dicTypePID = '9c153f83aca84d299a2e6733efcc4e82';
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) 
VALUES('9c153f83aca84d299a2e6733efcc4e82','cbeb758e3d824626a31aabb2a9587b0a','109db432755c4f7ba0610be16df3bea7','资金来源','62','0','0',NULL,'','2017-10-12 19:55:00','管理员','2017-10-12 19:55:00','管理员');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) 
VALUES('3d1d5a18a63249faa7166272643d7b7b','cbeb758e3d824626a31aabb2a9587b0a','9c153f83aca84d299a2e6733efcc4e82','省外','1','0','0',NULL,'','2017-10-12 19:55:00','管理员','2017-10-12 19:55:00','管理员');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) 
VALUES('77c27050fd5347109c14035fee7723d2','cbeb758e3d824626a31aabb2a9587b0a','9c153f83aca84d299a2e6733efcc4e82','省内','0','0','0',NULL,'','2017-10-12 19:55:00','管理员','2017-10-12 19:55:00','管理员');

UPDATE sys_modules SET url = '/report/detail_report_guaranty.jsp?file=reportXML/detail_financing_clientOut.xml&dateType=beginAndEnd' WHERE mod_uid='7b8407be870042c0a219cacdea283466';
UPDATE sys_modules SET url = '/report/detail_report_guaranty.jsp?file=reportXML/detail_entrust_clientOut.xml&dateType=beginAndEnd' WHERE mod_uid='8e9447ea3ca24232a13f1daf72080609';


