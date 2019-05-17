/*=======项目诉讼登记表==*/
ALTER TABLE pro_projectlawsuit ADD COLUMN  `caseType` varchar(20) DEFAULT NULL COMMENT '案件类型';
ALTER TABLE pro_projectlawsuit ADD COLUMN  `dicTypeID` varchar(50) DEFAULT NULL OMMENT '单位id';
ALTER TABLE pro_projectlawsuit ADD COLUMN  `dicTypeName` varchar(50) DEFAULT NULL OMMENT '单位名称';
ALTER TABLE pro_projectlawsuit ADD COLUMN  `effectiveLegalDocuments` varchar(100) DEFAULT NULL COMMENT '生效法律文书';
ALTER TABLE pro_projectlawsuit ADD COLUMN  `firstSeal` text COMMENT '财产查控情况(首封)';
ALTER TABLE pro_projectlawsuit ADD COLUMN  `waiting` text COMMENT '财产查控情况(轮候)';
ALTER TABLE pro_projectlawsuit ADD COLUMN  `undertakeJudge` varchar(32) DEFAULT NULL COMMENT '承办法官';
ALTER TABLE pro_projectlawsuit ADD COLUMN  `plaintiffApplyExecute` tinyint(1) DEFAULT '0' COMMENT '原告是否申请执行 1是  0否';
ALTER TABLE pro_projectlawsuit ADD COLUMN  `province` varchar(11) DEFAULT NULL COMMENT '省内/外 省内  省外';
ALTER TABLE pro_projectlawsuit ADD COLUMN  `ifSentenceIdentical` tinyint(1) DEFAULT '0' COMMENT '是否与判决一致 1是  0否';
ALTER TABLE pro_projectlawsuit ADD COLUMN `ifReview` tinyint(1) DEFAULT '0' COMMENT '是否审结 1已审结 0未审结 ';
ALTER TABLE pro_projectlawsuit ADD COLUMN  `otherPartyType` varchar(50) DEFAULT NULL COMMENT '对方类型   :非银机构   个人  平台  银行';
ALTER TABLE pro_projectlawsuit ADD COLUMN  `ifWorkingGroup` tinyint(1) DEFAULT '0' COMMENT '是否工作组 1是  0否';
ALTER TABLE pro_projectlawsuit ADD COLUMN  `remark` text COMMENT '备注'

/*=======资产查封信息表==*/

ALTER TABLE pro_assetsealup ADD COLUMN  `effectiveLegalDocuments` varchar(100) DEFAULT NULL COMMENT '生效法律文书';
ALTER TABLE pro_assetsealup ADD COLUMN  `lawsuitDate` date DEFAULT NULL COMMENT '立案日期';
ALTER TABLE pro_assetsealup ADD COLUMN  `plaintiff` varchar(100) DEFAULT NULL COMMENT '申请执行人';
ALTER TABLE pro_assetsealup ADD COLUMN  `defendant` varchar(100) DEFAULT NULL COMMENT '被执行人 ';
ALTER TABLE pro_assetsealup ADD COLUMN  `firstSeal` text COMMENT '财产查控情况(首封)';
ALTER TABLE pro_assetsealup ADD COLUMN  `waiting` text COMMENT '财产查控情况(轮候)';
ALTER TABLE pro_assetsealup ADD COLUMN  `firstSealAssetValue` decimal(18,6) DEFAULT NULL COMMENT '首封资产价值';
ALTER TABLE pro_assetsealup ADD COLUMN  `ifWorkingGroup` tinyint(1) DEFAULT '0' COMMENT '是否工作组  1是  0否	'

ALTER TABLE pro_projectlawsuit ADD COLUMN  `executionBasisNum` varchar(30) DEFAULT NULL COMMENT '执行依据编号';
ALTER TABLE pro_projectlawsuit ADD COLUMN  `executionBasisType` varchar(11) DEFAULT NULL COMMENT '执行依据种类   裁决书 公证书 判决书';
