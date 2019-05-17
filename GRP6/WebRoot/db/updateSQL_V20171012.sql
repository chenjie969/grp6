ALTER TABLE pro_replace CHANGE applyID apply_ID VARCHAR(32) NOT NULL;
/*============添加：担保责任余金额==*/
ALTER TABLE pro_project ADD guarantyDutyResSum decimal(18,6) NULL;
/*============添加：担保责任解除方式ID(字典)==*/
ALTER TABLE pro_project ADD freeMethodID VARCHAR(32);
/*============添加：担保责任解除方式名称==*/
ALTER TABLE pro_project ADD freeMethodName VARCHAR(20);
/*============添加：资金来源(省内／省外)========融投特有==============*/
ALTER TABLE pro_project ADD fundSource VARCHAR(10);

/*========字典====评审会决议结果======================*/
DELETE FROM c_dictype WHERE dicTypeID IN ('0f85770c257f4a00acaccc419798731c','3c445c0a7a904b37bd1d75bbc8b2a89d','403250e542cb488286d1afd963db3eff','cd95740df7ed409b8c729df4d7851dff');
insert into `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) values('0f85770c257f4a00acaccc419798731c','cbeb758e3d824626a31aabb2a9587b0a','109db432755c4f7ba0610be16df3bea7','评审会决议结果','51','0','0',NULL,'','2017-10-12 19:54:13','管理员','2017-10-12 20:04:17','管理员');
insert into `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) values('3c445c0a7a904b37bd1d75bbc8b2a89d','cbeb758e3d824626a31aabb2a9587b0a','0f85770c257f4a00acaccc419798731c','同意','0','0','0',NULL,'','2017-10-12 19:54:37','管理员','2017-10-12 19:54:37','管理员');
insert into `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) values('403250e542cb488286d1afd963db3eff','cbeb758e3d824626a31aabb2a9587b0a','0f85770c257f4a00acaccc419798731c','复议','1','0','0',NULL,'','2017-10-12 19:54:49','管理员','2017-10-12 19:54:49','管理员');
insert into `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) values('cd95740df7ed409b8c729df4d7851dff','cbeb758e3d824626a31aabb2a9587b0a','0f85770c257f4a00acaccc419798731c','否决','2','0','0',NULL,'','2017-10-12 19:55:00','管理员','2017-10-12 19:55:00','管理员');





