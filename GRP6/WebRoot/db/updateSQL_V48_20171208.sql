/*============实际控制人电话==*/
ALTER TABLE crm_client ADD COLUMN controlPhone VARCHAR(20) AFTER controlPerson;
/*============档案类型字典==*/
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`)
 VALUES('8369e90fea71447083326eba9fceb5a7','cbeb758e3d824626a31aabb2a9587b0a','109db432755c4f7ba0610be16df3bea7',' 档案类别','66','0','0',NULL,'','2017-11-24 11:41:59','管理员','2017-11-24 11:41:59','管理员');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`)
 VALUES('2ece6f868a9d423882862d1ad88ab572','cbeb758e3d824626a31aabb2a9587b0a','8369e90fea71447083326eba9fceb5a7',' 权证类','1','0','0',NULL,'','2017-11-24 11:41:59','管理员','2017-11-24 11:41:59','管理员');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`)
 VALUES('368a0a1edf1d47d5873271e3b004fee8','cbeb758e3d824626a31aabb2a9587b0a','8369e90fea71447083326eba9fceb5a7',' 管理类','2','0','0',NULL,'','2017-11-24 11:41:59','管理员','2017-11-24 11:41:59','管理员');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`)
 VALUES('858bdf30c80745b09bccf537bc031e44','cbeb758e3d824626a31aabb2a9587b0a','8369e90fea71447083326eba9fceb5a7',' 其他','3','0','0',NULL,'','2017-11-24 11:41:59','管理员','2017-11-24 11:41:59','管理员');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`)
 VALUES('f0ae1331d3fb49a58a371334b7a99bf9','cbeb758e3d824626a31aabb2a9587b0a','8369e90fea71447083326eba9fceb5a7',' 要件类','0','0','0',NULL,'','2017-11-24 11:41:59','管理员','2017-11-24 11:41:59','管理员');
 
 