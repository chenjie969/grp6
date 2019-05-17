/*=====融投项目特有=======添加：项目类型ID（字典）、项目类型名称==*/
/*=====字典：重点项目、直管项目、打击逃废债项目==*/
ALTER TABLE crm_relationMain ADD COLUMN projectTypeID varchar(32) AFTER remark;
ALTER TABLE crm_relationMain ADD COLUMN projectTypeName varchar(20) AFTER projectTypeID;

 /*======pro_apply表======添加：移交前法务评审人ID==*/
ALTER TABLE `pro_apply` ADD COLUMN `beforeLegalManID` VARCHAR(32) NULL AFTER `beforeReviewManID`; 
 /*======pro_applydetail表======添加：移交前法务评审人ID==*/
ALTER TABLE `pro_applydetail` ADD COLUMN `beforeLegalManID` VARCHAR(32) NULL AFTER `beforeReviewManID`; 
