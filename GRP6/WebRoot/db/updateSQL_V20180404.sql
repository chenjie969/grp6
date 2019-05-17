/*========版本号====债券表修改字段==*/
ALTER TABLE pro_creditor ADD COLUMN fund_source VARCHAR(12) DEFAULT '' COMMENT '资金来源：省内／省外';
ALTER TABLE pro_creditor ADD COLUMN fund_type VARCHAR(32) DEFAULT '' COMMENT '资金方类型（中文：银行/非银行/个人）';
ALTER TABLE pro_creditor ADD COLUMN fund_type_id VARCHAR(32) NOT NULL COMMENT '资金方类型（中文：银行/非银行/个人）ID';
ALTER TABLE pro_creditor ADD COLUMN fund_name VARCHAR(32) DEFAULT '' COMMENT '资金方名称 ';
ALTER TABLE pro_creditor ADD COLUMN create_date datetime DEFAULT NULL COMMENT '创建时间';
ALTER TABLE pro_creditor ADD COLUMN project_id VARCHAR(32) NOT NULL COMMENT '项目id';
alter table pro_creditor drop column old_client_id;
alter table pro_creditor drop column old_client_name;
alter table pro_creditor drop column new_client_id;
alter table pro_creditor drop column new_client_name;



