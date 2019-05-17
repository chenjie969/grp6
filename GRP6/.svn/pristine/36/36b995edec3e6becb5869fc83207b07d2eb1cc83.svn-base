/*============添加：评审会产品明细==*/
ALTER TABLE pro_loanPlan ADD meetingDetail_ID VARCHAR(32);
/*============添加：申请期限.天==*/
ALTER TABLE pro_loanPlan ADD periodDay SMALLINT;
/*============添加：申请期限.月==*/
ALTER TABLE pro_loanPlan ADD periodMonth SMALLINT;
/*============添加：申请期限.月天==*/
ALTER TABLE pro_loanPlan ADD periodMonthDay VARCHAR(20);
/*============添加：利率==*/
ALTER TABLE pro_loanPlan ADD interestRate FLOAT;
/*============添加：借据起始日期==*/
ALTER TABLE pro_loanPlan ADD billBeginDate DATE;
/*============添加：借据结束日期==*/
ALTER TABLE pro_loanPlan ADD billEndDate DATE;
/*============添加：放款计划ID==*/
ALTER TABLE pro_project ADD loanPlan_ID VARCHAR(32);


/*=============修改=====评审会决议表=============================*/
ALTER TABLE `pro_meetingresolution` CHANGE `applyID` `apply_ID` VARCHAR(32) CHARSET utf8 COLLATE utf8_bin NULL;
ALTER TABLE `pro_meetingresolution` CHANGE `meetingID` `meeting_ID` VARCHAR(32) CHARSET utf8 COLLATE utf8_bin NULL;
/*=============添加=====评审会决议表=============================*/
ALTER TABLE `pro_meetingresolution` ADD COLUMN `userIDList` TEXT NULL AFTER `otherUserNameList`, ADD COLUMN `userNameList` TEXT NULL AFTER `userIDList`; 
