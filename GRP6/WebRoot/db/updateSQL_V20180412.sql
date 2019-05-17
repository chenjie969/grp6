/*========版本号====债券表修改字段==*/
ALTER TABLE pro_creditor ADD COLUMN sub_fund_name VARCHAR(32) DEFAULT '' COMMENT '子机构名称';

ALTER TABLE pro_creditor ADD COLUMN fund_id VARCHAR(32) DEFAULT '' COMMENT '资金方id';


