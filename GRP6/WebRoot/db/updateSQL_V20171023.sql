/*============添加：附件名称==*/
ALTER TABLE pro_contractDoc ADD fileName VARCHAR(200);
/*============添加：应收状态==*/
ALTER TABLE pro_costmust ADD costMustState VARCHAR(10);
/*============添加：预收状态==*/
ALTER TABLE pro_costpre ADD costPreState VARCHAR(10);
/*============添加：放款计划ID==*/
ALTER TABLE pro_costpre ADD loanPlan_ID VARCHAR(32);
/*============添加：应该费用ID==*/
ALTER TABLE pro_costpre ADD costMust_ID VARCHAR(32);
/*============添加：实收状态==*/
ALTER TABLE pro_costFact ADD costFactState VARCHAR(10);
/*============添加：放款计划ID==*/
ALTER TABLE pro_costFact ADD loanPlan_ID VARCHAR(32);
/*============添加：预收ID==*/
ALTER TABLE pro_costFact ADD costPre_ID VARCHAR(32);
/*============添加：计划实收日期==*/
ALTER TABLE pro_costFact ADD planFactCostDate DATETIME;
/*============添加：放款计划ID==*/
ALTER TABLE `pro_planpay` ADD COLUMN `loanPlan_ID` VARCHAR(32) NULL AFTER `applyDetail_ID`; 
/*============把applyDetail_ID必填去掉==*/
ALTER TABLE `pro_planpay` CHANGE `applyDetail_ID` `applyDetail_ID` VARCHAR(32) CHARSET utf8 COLLATE utf8_bin NULL; 
/*============添加：计划还款月==*/
ALTER TABLE `pro_planpay` ADD COLUMN `planPayMonth` SMALLINT(6) NULL AFTER `planPayDate`; 
/*============把applyDetail_ID必填去掉==*/
ALTER TABLE `pro_costmust` CHANGE `applyDetail_ID` `applyDetail_ID` VARCHAR(32) CHARSET utf8 COLLATE utf8_bin NULL; 
/*============添加：放款计划ID==*/
ALTER TABLE `pro_costmust` ADD COLUMN `loanPlan_ID` VARCHAR(32) NULL AFTER `applyDetail_ID`; 
/*============添加：利息、本金应收费用、利息应收费用==*/
ALTER TABLE `pro_costmust` ADD COLUMN `interestSum` DECIMAL(18,6) NULL AFTER `costUnit`, 
ADD COLUMN `capitalMustCostSum` DECIMAL(18,6) NULL AFTER `interestSum`, 
ADD COLUMN `interestMustCostSum` DECIMAL(18,6) NULL AFTER `capitalMustCostSum`; 


/*============添加：项目ID==*/
ALTER TABLE pro_checkPlan ADD project_ID VARCHAR(32);
ALTER TABLE pro_checkPlan CHANGE applyID apply_ID VARCHAR(32) NOT NULL;
/*============添加：项目ID==*/
ALTER TABLE pro_checkReport ADD project_ID VARCHAR(32);
ALTER TABLE pro_checkReport CHANGE applyID apply_ID VARCHAR(32) NOT NULL;

/*======初始化合同类型字典========*/
DELETE FROM `c_dictype` WHERE dicTypeID IN ('74c5e294e4284a0cb0385212d4b706ce','f997cedb6c684488853f2f6bf07debd0','36d80db0407447629ba347ffec4545ef');
DELETE FROM `c_dictype` WHERE dicTypeID IN ('db8b273584b94af5b4518412c960dd7e');
insert into `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) values('db8b273584b94af5b4518412c960dd7e','cbeb758e3d824626a31aabb2a9587b0a','109db432755c4f7ba0610be16df3bea7','合同类型','56','0','0',NULL,'','2017-10-17 10:17:39','郑诚','2017-10-17 10:17:39','郑诚');
insert into `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) values('74c5e294e4284a0cb0385212d4b706ce','cbeb758e3d824626a31aabb2a9587b0a','db8b273584b94af5b4518412c960dd7e','委保合同','0','0','0',NULL,'','2017-10-17 11:23:25','郑诚','2017-10-17 11:23:25','郑诚');
insert into `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) values('f997cedb6c684488853f2f6bf07debd0','cbeb758e3d824626a31aabb2a9587b0a','db8b273584b94af5b4518412c960dd7e','抵押合同','2','0','0',NULL,'','2017-10-17 11:23:44','郑诚','2017-10-17 11:23:44','郑诚');
insert into `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) values('36d80db0407447629ba347ffec4545ef','cbeb758e3d824626a31aabb2a9587b0a','db8b273584b94af5b4518412c960dd7e','担保合同','1','0','0',NULL,'','2017-10-17 11:23:36','郑诚','2017-10-17 11:23:36','郑诚');

/*============添加：预收费用ID==*/
ALTER TABLE pro_costReturn ADD costPre_ID VARCHAR(32);
/*============添加：原费用金额==*/
ALTER TABLE pro_costReturn ADD oldCostSum DECIMAL(18,6);
/*============添加：变更后费用金额==*/
ALTER TABLE pro_costReturn ADD newCostSum DECIMAL(18,6);
/*============添加：退费类型ID==*/
ALTER TABLE pro_costReturn ADD returnCostTypeID VARCHAR(32);
/*============添加：退费类型名称==*/
ALTER TABLE pro_costReturn ADD returnCostTypeName VARCHAR(32);
/*============添加：退费原因==*/
ALTER TABLE pro_costReturn ADD returnDesc TEXT;
/*============添加：放款计划ID==*/
ALTER TABLE pro_costReturn ADD loanPlan_ID VARCHAR(32);
/*============添加：费用状态==*/
ALTER TABLE pro_costReturn ADD costReturnState VARCHAR(32);  

/*======初始化"担保责任解除类型"、“担保责任解除方式”字典========*/
DELETE FROM `c_dictype` WHERE dicTypeID IN ('3b41441b90f945d0bdca2a298d22ff12','3d08a203ab804ddf80e8d3c827bd98ae','5d95aa0326c74dea9eeccae6853a2822','f97e9072b4814c839004153f8a3a4e88');
DELETE FROM `c_dictype` WHERE dicTypeID IN ('96190ce8289940319e0ffc699b9eb44a','9df927d50f8a48b9b6bcf313f5551530');
insert into `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) 
values('96190ce8289940319e0ffc699b9eb44a','cbeb758e3d824626a31aabb2a9587b0a','109db432755c4f7ba0610be16df3bea7','担保责任解除方式','51','0','0',NULL,'','2017-10-13 09:33:38','管理员','2017-10-13 09:33:38','管理员');
insert into `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) 
values('9df927d50f8a48b9b6bcf313f5551530','cbeb758e3d824626a31aabb2a9587b0a','109db432755c4f7ba0610be16df3bea7','担保责任解除类型','52','0','0',NULL,'','2017-10-13 09:34:39','管理员','2017-10-13 09:34:39','管理员');
insert into `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) 
values('3b41441b90f945d0bdca2a298d22ff12','cbeb758e3d824626a31aabb2a9587b0a','9df927d50f8a48b9b6bcf313f5551530','正常解除','1','0','0',NULL,'','2017-10-13 09:35:33','管理员','2017-10-13 09:35:33','管理员');
insert into `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) 
values('3d08a203ab804ddf80e8d3c827bd98ae','cbeb758e3d824626a31aabb2a9587b0a','96190ce8289940319e0ffc699b9eb44a','无代偿解除','0','0','0',NULL,'','2017-10-13 09:34:07','管理员','2017-10-13 09:34:07','管理员');
insert into `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) 
values('5d95aa0326c74dea9eeccae6853a2822','cbeb758e3d824626a31aabb2a9587b0a','9df927d50f8a48b9b6bcf313f5551530','提前解除','0','0','0',NULL,'','2017-10-13 09:35:17','管理员','2017-10-13 09:35:17','管理员');
insert into `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) 
values('f97e9072b4814c839004153f8a3a4e88','cbeb758e3d824626a31aabb2a9587b0a','96190ce8289940319e0ffc699b9eb44a','代偿解除','1','0','0',NULL,'','2017-10-13 09:34:21','管理员','2017-10-13 09:34:21','管理员');


/*============把applyDetail_ID必填去掉==*/
ALTER TABLE `pro_project` CHANGE `applyDetail_ID` `applyDetail_ID` VARCHAR(32) CHARSET utf8 COLLATE utf8_bin NULL; 
ALTER TABLE  `pro_costpre` CHANGE `applyDetail_ID` `applyDetail_ID` VARCHAR(32) CHARSET utf8 COLLATE utf8_bin NULL; 
ALTER TABLE `pro_costfact` CHANGE `applyDetail_ID` `applyDetail_ID` VARCHAR(32) CHARSET utf8 COLLATE utf8_bin NULL; 
ALTER TABLE  `pro_costreturn` CHANGE `applyDetail_ID` `applyDetail_ID` VARCHAR(32) CHARSET utf8 COLLATE utf8_bin NULL; 

UPDATE gbpm_dic_taskmanager SET `taskUrl`='/project/cost/showCostRecordPage',`viewTaskUrl`='/project/cost/showCostRecordPage' WHERE `taskName` = '财务收费确认'





