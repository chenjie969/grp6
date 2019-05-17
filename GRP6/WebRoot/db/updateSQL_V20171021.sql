/*============添加：业务性质（字典）==*/
ALTER TABLE pro_apply ADD busiNatureID VARCHAR(32);
/*============添加：业务性质名称==*/
ALTER TABLE pro_apply ADD busiNatureName VARCHAR(20);
/*============添加：是否完结==*/
ALTER TABLE pro_apply ADD isEnd BOOL DEFAULT 0;
/*============添加：完结日期==*/
ALTER TABLE pro_apply ADD endDate DATE;
/*============添加：备注==*/ 
ALTER TABLE pro_lawsuitprogress ADD remark TEXT NULL ;
