/*============审批类型==*/
ALTER TABLE pro_riskScheme ADD COLUMN reviewType varchar(20);
/*============当前环节ID==*/
ALTER TABLE pro_riskScheme ADD COLUMN nodeID varchar(32);
/*============当前环节名称==*/
ALTER TABLE pro_riskScheme ADD COLUMN nodeNames varchar(100);
/*============否决日期==*/
ALTER TABLE pro_riskScheme ADD COLUMN stopDate DATE AFTER isMeeting;
/*============否决原因==*/
ALTER TABLE pro_riskScheme ADD COLUMN stopDesc VARCHAR(500) AFTER stopDate;
/*============审批完成日期==*/
ALTER TABLE pro_riskScheme ADD COLUMN finishDate DATE AFTER stopDesc;

/*========添加：字典  会议类型名称：讨论会、调度会、风委会、会议专题会================*/
DELETE FROM c_dictype WHERE dicTypeID = 'a139f3b270cd49ed9ca43de9a2a4ef04' OR dicTypePID = 'a139f3b270cd49ed9ca43de9a2a4ef04';
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('a139f3b270cd49ed9ca43de9a2a4ef04','cbeb758e3d824626a31aabb2a9587b0a','109db432755c4f7ba0610be16df3bea7','会议类型','66','0','0',NULL,'','2017-11-29 18:30:36','管理员','2017-11-29 18:30:36','管理员');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('f73a43a78b784d6cb309835117a47121','cbeb758e3d824626a31aabb2a9587b0a','a139f3b270cd49ed9ca43de9a2a4ef04','讨论会','0','0','0',NULL,'','2017-11-29 18:31:03','管理员','2017-11-29 18:31:03','管理员');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('1bc497df150b480b963ca0fa3c97b20a','cbeb758e3d824626a31aabb2a9587b0a','a139f3b270cd49ed9ca43de9a2a4ef04','调度会','1','0','0',NULL,'','2017-11-29 18:31:19','管理员','2017-11-29 18:31:19','管理员');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('e79a01575a99452595aa55f0c82e992f','cbeb758e3d824626a31aabb2a9587b0a','a139f3b270cd49ed9ca43de9a2a4ef04','风委会','2','0','0',NULL,'','2017-11-29 18:31:42','管理员','2017-11-29 18:31:42','管理员');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('f7e6634d72804228b71f562a6a8f0a0d','cbeb758e3d824626a31aabb2a9587b0a','a139f3b270cd49ed9ca43de9a2a4ef04','项目专题会','3','0','0',NULL,'','2017-11-29 18:32:00','管理员','2017-11-29 18:32:00','管理员');

/*============添加项目分类处置划分ID==*/
ALTER TABLE crm_risklevelrec ADD COLUMN divisionID  VARCHAR(32);
/*============添加项目分类处置划分名称==*/
ALTER TABLE crm_risklevelrec ADD COLUMN divisionName VARCHAR(30);