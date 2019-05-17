/*========版本号====设备编号==*/
ALTER TABLE pro_optguaranty ADD COLUMN `isGuarantyMaxSum` varchar(3) DEFAULT NULL COMMENT '最高保证额标记  1 最高保证额  ，其他 0'


ALTER TABLE pro_optguaranty MODIFY COLUMN `isGuarantyMaxSum` tinyint(1) DEFAULT '0';






