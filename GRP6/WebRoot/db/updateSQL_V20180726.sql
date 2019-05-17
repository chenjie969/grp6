-- 利息计算记录表
CREATE TABLE `pro_calculationFactPay` (
  `calculation_ID` varchar(32) NOT NULL COMMENT '利息记录id',
  `apply_ID` varchar(32) NOT NULL COMMENT '业务id',
  `project_ID` varchar(32) NOT NULL COMMENT '项目id',
  `interest` decimal(18,6) DEFAULT NULL COMMENT '本次产生的利息',
  `fxinterest` decimal(18,6) DEFAULT NULL COMMENT ' 本次当月产生的罚息',
  `flinterest` decimal(18,6) DEFAULT NULL COMMENT '本次产生的复利',
  `surplusInterest` decimal(18,6) DEFAULT NULL COMMENT ' 本次还款后剩余的利息',
  `surplusFxinterest` decimal(18,6) DEFAULT NULL COMMENT '本次还款后剩余的罚息',
  `surplusFlinterest` decimal(18,6) DEFAULT NULL COMMENT '本次还款后剩余的复利',
  `surplusSum` decimal(18,6) DEFAULT NULL COMMENT '本次还款后剩余的还款利息(还的利息比产生的利息多)',
  `interestDate` date DEFAULT NULL COMMENT '利息产生时间',
   PRIMARY KEY (`calculation_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='利息计算表（按月，按季）';