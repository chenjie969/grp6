/*评审会类型字典*/
DELETE FROM c_dictype WHERE dicTypeID IN ('44adce684a35463581b070e5f9011f49','42ea4386d6a847359dc2fe954a4e8cc2','5d23720a7a1543f0b2c3e82688465dc8');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('5d23720a7a1543f0b2c3e82688465dc8','cbeb758e3d824626a31aabb2a9587b0a','109db432755c4f7ba0610be16df3bea7','评审会类型','55','0','0',NULL,'','2017-10-17 10:17:06','郑诚','2017-10-17 10:17:06','郑诚');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('42ea4386d6a847359dc2fe954a4e8cc2','cbeb758e3d824626a31aabb2a9587b0a','5d23720a7a1543f0b2c3e82688465dc8','部门内部评审','0','0','0',NULL,'','2017-10-17 10:58:36','管理员','2017-10-17 10:58:36','管理员');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('44adce684a35463581b070e5f9011f49','cbeb758e3d824626a31aabb2a9587b0a','5d23720a7a1543f0b2c3e82688465dc8','董事会评审','1','0','0',NULL,'','2017-10-17 10:58:45','管理员','2017-10-17 10:58:45','管理员');


