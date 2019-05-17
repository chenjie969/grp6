/*========版本号====借款用途及还款来源==*/
ALTER TABLE pro_applydetail ADD COLUMN `applySumUse` varchar(100) DEFAULT NULL COMMENT '借款用途及还款来源'
ALTER TABLE pro_apply ADD COLUMN `applySumUse` varchar(100) DEFAULT NULL COMMENT '借款用途及还款来源'



