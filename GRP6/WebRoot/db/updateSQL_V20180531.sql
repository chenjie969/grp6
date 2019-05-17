CREATE TABLE `pro_projectoverdue` (
  `overdue_ID` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '主键',
  `project_ID` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '放款明细表id',
  `capital` decimal(18,6) DEFAULT NULL COMMENT '未还本金',
  `interest` decimal(18,6) DEFAULT NULL COMMENT '未还利息',
  `defautInterest` decimal(18,6) DEFAULT NULL COMMENT '利息额',
  `compoundInterest` decimal(18,6) DEFAULT NULL COMMENT '复利额',
  `interestSum` decimal(18,6) DEFAULT NULL COMMENT '累计欠息额',
  `startTime` datetime DEFAULT NULL COMMENT '开始时间',
  `endTime` datetime DEFAULT NULL COMMENT '结束时间',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`overdue_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='逾期费用明细表';