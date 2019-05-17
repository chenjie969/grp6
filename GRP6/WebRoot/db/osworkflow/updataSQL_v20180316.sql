insert  into `os_gworkflow_components`(`ID`,`componentID`,`componentName`,`editAction`,`viewAction`,`roleDescr`,`funDescr`,`releaseDate`,`author`,`unit_uid`) values 
(24,'301','企业续保申请','/gworkFlow/delay/renewalNotRequired.jsp',NULL,NULL,NULL,NULL,NULL,0),
(25,'302','地市立项尽调','/gworkFlow/delay/inspectApproval.jsp',NULL,NULL,NULL,NULL,NULL,0),
(26,'303','档案移交登记','/gworkFlow/delay/fileTransfer.jsp',NULL,NULL,NULL,NULL,NULL,0),
(27,'304','档案接收确认','/gworkFlow/delay/fileTransferConfirmation.jsp',NULL,NULL,NULL,NULL,NULL,0),
(28,'305','子公司风险管理部审核','/gworkFlow/delay/riskExamination.jsp',NULL,NULL,NULL,NULL,NULL,0),
(29,'601','集团风险管理部审核','/gworkFlow/delay/blocRiskExamination.jsp',NULL,NULL,NULL,NULL,NULL,0),
(30,'601','集团总办会纪要','/gworkFlow/delay/blocSummary.jsp',NULL,NULL,NULL,NULL,NULL,0),

INSERT INTO grp6_wendan.os_gworkflow_flowtemplate (
	flowTemplateID,
	flowTypeID,
	flowTypeName,
	flowTemplateName,
	flowTempaleMapName,
	flowXmlFile,
	isActive,
	isDel,
	unit_uid
)
VALUES (
		'G301',
		'所有业务品种',
		'展期流程',
		'展期子流程',
		'delay',
		'delay.xml',
		'1',
		'1',
		'cbeb758e3d824626a31aabb2a9587b0a'
);
