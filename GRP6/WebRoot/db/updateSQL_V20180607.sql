ALTER TABLE pro_project ADD COLUMN `isSensitiveCreditor` tinyint(1) DEFAULT '0' COMMENT '是否敏感债权人';

ALTER TABLE pro_project ADD COLUMN `sensitiveCreditorNumber` bigint(20) DEFAULT '0' COMMENT '敏感债权人數';