/*=====融投项目特有=======添加：负债总额==*/
ALTER TABLE crm_client ADD COLUMN liabilitySum DECIMAL(18,6) NULL AFTER capitalSum;
/*=====融投项目特有=======添加：2015年1月末担保余额、2015年1月末担保集团委贷余额、2015年1月末融投系委贷余额==*/
ALTER TABLE crm_relationMain ADD COLUMN guarantySum DECIMAL(18,6) NULL AFTER remark;
ALTER TABLE crm_relationMain ADD COLUMN guarantyEntrustSum DECIMAL(18,6) NULL AFTER guarantySum; 
ALTER TABLE crm_relationMain ADD COLUMN entrustSum DECIMAL(18,6) NULL AFTER guarantyEntrustSum; 


