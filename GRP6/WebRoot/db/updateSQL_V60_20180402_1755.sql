--存项目的 录入期限
ALTER TABLE pro_project ADD COLUMN oldPeriodMonth smallint(6) DEFAULT NULL COMMENT '录入的期限月';
ALTER TABLE pro_project ADD COLUMN oldPeriodDay smallint(6) DEFAULT NULL COMMENT '录入的期限日';
ALTER TABLE pro_project ADD COLUMN oldPeriodMonthDay varchar(20) DEFAULT NULL COMMENT '录入的期限日月';