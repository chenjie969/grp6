/*完结解保子流程数据表*/

CREATE TABLE pro_finish (
	finish_ID VARCHAR (32) NOT NULL COMMENT '完结解保ID',
	finish_ID_old BIGINT (20) DEFAULT NULL COMMENT '',
	project_ID_old BIGINT (20) DEFAULT NULL COMMENT '项目原id',
	project_ID VARCHAR (32) NOT NULL COMMENT '关联项目id',
	apply_ID VARCHAR (32) DEFAULT NULL COMMENT '项目申请id',
	margin DECIMAL (18, 4) DEFAULT NULL COMMENT '保证金',
	remark text COMMENT '备注',
	operationManID VARCHAR (32) DEFAULT NULL COMMENT '创建人id',
	operationManName VARCHAR (20) DEFAULT NULL COMMENT '创建人名字',
	unit_uid VARCHAR (32) NOT NULL COMMENT '',
	updateUserName VARCHAR (20) DEFAULT NULL COMMENT '更新人',
	updateDateTime datetime DEFAULT NULL COMMENT '更新时间',
	finishState VARCHAR (10) DEFAULT NULL COMMENT '审批状态（中文：待审批/审批中/通过/未通过）',
	PRIMARY KEY (finish_ID)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '完结解保';

/*初始化数据*/
INSERT INTO os_gworkflow_flowtemplate ( flowTemplateID, flowTypeID, flowTypeName, flowTemplateName, flowTempaleMapName, flowXmlFile, funDesrc, version, releaseDate, isActive, isDel, unit_uid) 
	VALUES ( 'G701', '所有业务品种', '在保(贷后)流程', '完结解保子流程', 'finish', 'finish.xml', NULL, NULL, NULL, '1', '1', 'cbeb758e3d824626a31aabb2a9587b0a');

INSERT INTO os_gworkflow_components ( componentID, componentName, editAction, viewAction, roleDescr, funDescr, releaseDate, author, unit_uid) 
	VALUES ( '701', '解保资料', '/pro/finish/relieveUpload', NULL, NULL, '项目组上传资料，填写保证金', NULL, NULL, '0');
INSERT INTO os_gworkflow_components ( componentID, componentName, editAction, viewAction, roleDescr, funDescr, releaseDate, author, unit_uid) 
	VALUES ( '702', '审核有无保证金', '/pro/finish/margin', NULL, NULL, '财务部风险部审核资料、保证金', NULL, NULL, '0');
INSERT INTO os_gworkflow_components ( componentID, componentName, editAction, viewAction, roleDescr, funDescr, releaseDate, author, unit_uid) 
	VALUES ( '703', '业务解除通知单生成', '/pro/finish/generate', NULL, NULL, '项目组生成《业务解除通知单》', NULL, NULL, '0');
INSERT INTO os_gworkflow_components ( componentID, componentName, editAction, viewAction, roleDescr, funDescr, releaseDate, author, unit_uid) 
	VALUES ( '704', '业务解除通知单审核', '/pro/finish/financeTrail', '', '', '财务部审核', NULL, '', '0');
INSERT INTO os_gworkflow_components ( componentID, componentName, editAction, viewAction, roleDescr, funDescr, releaseDate, author, unit_uid) 
	VALUES ( '705', '风控初审', '/pro/finish/riskfirstTrail', '', '', '子公司风险部门初审', NULL, '', '0');
INSERT INTO os_gworkflow_components ( componentID, componentName, editAction, viewAction, roleDescr, funDescr, releaseDate, author, unit_uid)
	VALUES ( '706', '风控复审', '/pro/finish/riskManagerTrail', '', '', '子公司风险部审核', NULL, '', '0');
INSERT INTO os_gworkflow_components ( componentID, componentName, editAction, viewAction, roleDescr, funDescr, releaseDate, author, unit_uid) 
	VALUES ( '707', '解除', '/pro/finish/relieve', '', '', '解除', NULL, '', '0');

	
/*模板相关初始化数据*/
INSERT INTO c_dictype (dicTypeID, unit_uid, dicTypePID, dicTypeName, order_id, isEable, isDefault, unificationID, remark, createdatetime, create_user, updatedatetime, update_user) 
	VALUES ('db8ba98240c2421bb6f7d281b352f777', 'cbeb758e3d824626a31aabb2a9587b0a', 'b9813a1bea1e4f9b8880a0111a670233', '业务解除通知单', '7', '0', '0', NULL, '', '2018-03-26 16:40:46', '管理员', '2018-03-26 16:41:05', '管理员');
INSERT INTO sys_docmould (docMouldID, mouldTypeID, mouldName, oldMouldName, mouldPath, uploadDateTime, fileSize, extend, uploadManID, uploadManName, unit_uid, unit_uidName, updatedatetime, updateUserName, mouldTypeName) 
	VALUES ('fcb93898e2c841d2ade07e7679996a50', 'db8ba98240c2421bb6f7d281b352f777', 'WDBH_FINISH_01', 'finish_relieve.doc', '/unitdata/unit_cbeb758e3d824626a31aabb2a9587b0a/docMould/5d285773-54d6-4b5b-897c-dba953fefed4.doc', '2018-03-26 16:43:16', '40960', 'doc', '32a3e2cbd422451ba333802e123a2391', '管理员', 'cbeb758e3d824626a31aabb2a9587b0a', NULL, '2018-03-26 16:43:16', '管理员', '业务接触通知单');
