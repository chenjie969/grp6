/*============业务主表信息表新增字段完结人id，完结人姓名==*/
ALTER TABLE pro_project ADD COLUMN finishUserID varchar(32) ;
ALTER TABLE pro_project ADD COLUMN finishUserName varchar(20) ;
/**项目完结类型*/
ALTER TABLE pro_project ADD COLUMN finishTypeID varchar(32) ;
ALTER TABLE pro_project ADD COLUMN finishTypeName varchar(50) ;
/**项目完结评价***/
ALTER TABLE pro_project ADD COLUMN projAppraisal TEXT ;
/**项目完日期***/

ALTER TABLE pro_project ADD COLUMN finishDate DATE ;

/**字典表中添加项目完结类型***/
DELETE FROM c_dictype WHERE dicTypeID IN ('10090c83ee964159a456b6510ab8faf5','c56b9927b8484bc597a06dad1f940dce','675f989ce0e24745b9bc86f2c9b37d64','29e2b2acc8d84a86af9e9f4102b5f033','37e6ae22b6bb47e084e3e7332b9703cd');

INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) 
VALUES('10090c83ee964159a456b6510ab8faf5','cbeb758e3d824626a31aabb2a9587b0a','109db432755c4f7ba0610be16df3bea7','项目完结类型','63','0','0',NULL,'','2017-10-12 19:55:00','管理员','2017-10-12 19:55:00','管理员');

INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) 
VALUES('c56b9927b8484bc597a06dad1f940dce','cbeb758e3d824626a31aabb2a9587b0a','10090c83ee964159a456b6510ab8faf5','按期解保完结项目','0','0','0',NULL,'','2017-10-12 19:55:00','管理员','2017-10-12 19:55:00','管理员');


INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) 
VALUES('675f989ce0e24745b9bc86f2c9b37d64','cbeb758e3d824626a31aabb2a9587b0a','10090c83ee964159a456b6510ab8faf5','逾期无代偿解除项目','1','0','0',NULL,'','2017-10-12 19:55:00','管理员','2017-10-12 19:55:00','管理员');


INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) 
VALUES('29e2b2acc8d84a86af9e9f4102b5f033','cbeb758e3d824626a31aabb2a9587b0a','10090c83ee964159a456b6510ab8faf5','逾期代偿解保无损失完结项目','2','0','0',NULL,'','2017-10-12 19:55:00','管理员','2017-10-12 19:55:00','管理员');

INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) 
VALUES('37e6ae22b6bb47e084e3e7332b9703cd','cbeb758e3d824626a31aabb2a9587b0a','10090c83ee964159a456b6510ab8faf5','逾期代偿解保有损失完结项目','3','0','0',NULL,'','2017-10-12 19:55:00','管理员','2017-10-12 19:55:00','管理员');

/**pro_apply表中添加是否续作项目字段：默认为否***/
ALTER TABLE pro_apply ADD isContinue BOOL DEFAULT 0;

