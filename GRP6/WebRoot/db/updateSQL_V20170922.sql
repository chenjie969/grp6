UPDATE sys_modules SET mod_name = '资金来源为非银机构前30大客户名录' WHERE mod_uid='2994e582251a4c0ab49ab92745e0e89c';
/*======ZHANGKEYAO  20170922==pro_apply--add --fundTypeID(资金方类型id)字段===start=======*/

ALTER TABLE pro_apply ADD fundTypeID VARCHAR(32);
/*======ZHANGKEYAO  20170922==pro_apply--add --fundTypeID(资金方类型id)字段===end=======*/

/*----------20170925-------LiKM------Begin--------------------*/
ALTER TABLE pro_applydetail MODIFY  dcontractCode TEXT;/*委托担保合同号（委托贷款合同号）*/
ALTER TABLE pro_applydetail MODIFY  jcontractCode TEXT;/*借款合同号*/
ALTER TABLE pro_applydetail MODIFY  bcontractCode TEXT;/*保证合同号*/
/*-----贷款利率（委贷利率）-------*/
ALTER TABLE pro_project ADD bankRate FLOAT;
/*-----担保费率-------*/
ALTER TABLE pro_project ADD guarantyRate FLOAT;
/*-----评审费率-------*/
ALTER TABLE pro_project ADD reviewRate FLOAT;
/*-----金融服务费率-------*/
ALTER TABLE pro_project ADD serviceRate FLOAT;
/*-----罚息利率（针对委贷）-------*/
ALTER TABLE pro_project ADD punishRate FLOAT;
ALTER TABLE gbpm_product ADD productSort INT;
ALTER TABLE gbpm_dic_node ADD nodeSort INT;
ALTER TABLE gbpm_dic_taskmanager ADD taskmanagerSort INT;
ALTER TABLE gbpm_dic_taskmanager ADD isPersonTask BOOL DEFAULT 1;
ALTER TABLE sys_userGroup ADD order_id INT;
ALTER TABLE Sys_docMould CHANGE update_user updateUserName VARCHAR(20);

/*----------20170925-------LiKM------End--------------------*/

/*======ZHANGKEYAO  20170922==sys_dep_user--update --is_otherdep字段===start=======*/
UPDATE  `sys_dep_user`  SET `is_otherdep`=0
/*======ZHANGKEYAO  20170922==sys_dep_user--update --is_otherdep字段===end=======*/

/*----------20170925-------LiKM------Begin--------------------*/
/*------业务大类------*/
ALTER TABLE c_busiSort ADD busiClass VARCHAR(50);
/*----------20170925-------LiKM------End--------------------*/


=======

/*----------20170925-------LiKM------Begin--------------------*/
ALTER TABLE pro_applydetail MODIFY  dcontractCode TEXT;/*委托担保合同号（委托贷款合同号）*/
ALTER TABLE pro_applydetail MODIFY  jcontractCode TEXT;/*借款合同号*/
ALTER TABLE pro_applydetail MODIFY  bcontractCode TEXT;/*保证合同号*/
/*-----贷款利率（委贷利率）-------*/
ALTER TABLE pro_project ADD bankRate FLOAT;
/*-----担保费率-------*/
ALTER TABLE pro_project ADD guarantyRate FLOAT;
/*-----评审费率-------*/
ALTER TABLE pro_project ADD reviewRate FLOAT;
/*-----金融服务费率-------*/
ALTER TABLE pro_project ADD serviceRate FLOAT;
/*-----罚息利率（针对委贷）-------*/
ALTER TABLE pro_project ADD punishRate FLOAT;
ALTER TABLE gbpm_product ADD productSort INT;
ALTER TABLE gbpm_dic_node ADD nodeSort INT;
ALTER TABLE gbpm_dic_taskmanager ADD taskmanagerSort INT;
ALTER TABLE gbpm_dic_taskmanager ADD isPersonTask BOOL DEFAULT 1;
ALTER TABLE sys_userGroup ADD order_id INT;
ALTER TABLE Sys_docMould CHANGE update_user updateUserName VARCHAR(20);

/*----------20170925-------LiKM------End--------------------*/

