/*========版本号====设备编号==*/
ALTER TABLE pro_project ADD COLUMN replaceOverDate date DEFAULT NULL COMMENT '代偿到期日期';
ALTER TABLE pro_project ADD COLUMN isUrgeLetter tinyint(1) DEFAULT '0' COMMENT '是否有催告函';







