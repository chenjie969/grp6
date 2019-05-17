 /*======pro_apply表======添加：法务评审人ID及名字==*/
ALTER TABLE `pro_apply` ADD COLUMN `legalManID` VARCHAR(32) NULL AFTER `reviewManName`, ADD COLUMN `legalManName` VARCHAR(20) NULL AFTER `legalManID`; 
 /*======pro_applydetail表======添加：法务评审人ID及名字==*/
ALTER TABLE `pro_applydetail` ADD COLUMN `legalManID` VARCHAR(32) NULL AFTER `reviewManName`, ADD COLUMN `legalManName` VARCHAR(20) NULL AFTER `legalManID`; 
 /*======pro_project表======添加：法务评审人ID及名字==*/
ALTER TABLE `pro_project` ADD COLUMN `legalManID` VARCHAR(32) NULL AFTER `reviewManName`, ADD COLUMN `legalManName` VARCHAR(20) NULL AFTER `legalManID`;

/*======保后（贷后）产品放款明细表======添加：备注==*/
ALTER TABLE pro_project ADD COLUMN remark text ;
/*======计划还款明细表======添加：项目ID==*/
ALTER TABLE pro_planPay ADD COLUMN project_ID varchar(32) ;