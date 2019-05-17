INSERT INTO `os_gworkflow_flowtemplate` VALUES ('5', 'G201', '所有业务品种', '保前流程', '委贷解除流程', 'wdfinish', 'wdfinish.xml', null, null, null, '1', '1', 'cbeb758e3d824626a31aabb2a9587b0a');

INSERT INTO `os_gworkflow_components` VALUES ('40', '120', '解保资料', '/pro/finish/relieveUpload', null, null, null, null, null, '0');
INSERT INTO `os_gworkflow_components` VALUES ('41', '121', '审核有无保证金', '/pro/finish/margin', null, null, null, null, null, '0');
INSERT INTO `os_gworkflow_components` VALUES ('42', '122', '业务解除通知单生成', '/pro/finish/generate', null, null, null, null, null, '0');
INSERT INTO `os_gworkflow_components` VALUES ('43', '123', '业务解除通知单审核', '/pro/finish/financeTrail', null, null, null, null, null, '0');
INSERT INTO `os_gworkflow_components` VALUES ('44', '124', '风控初审', '/pro/finish/riskfirstTrail', null, null, null, null, null, '0');
INSERT INTO `os_gworkflow_components` VALUES ('45', '125', '风控复审', '/pro/finish/riskManagerTrail', null, null, null, null, null, '0');
INSERT INTO `os_gworkflow_components` VALUES ('46', '126', '解除', '/pro/finish/relieve', null, null, null, null, null, '0');

INSERT INTO `os_gworkflow_flowtemplate` VALUES ('6', 'G501', '所有业务品种', '保前流程', '退回保证金流程', 'returnoptsum', 'returnoptsum.xml', null, null, null, '1', '1', 'cbeb758e3d824626a31aabb2a9587b0a');
INSERT INTO `os_gworkflow_components` VALUES ('47', '510', '上传退保证金通知单', '/pro/finish/riskManagerTrail', null, null, null, null, null, '0');
INSERT INTO `os_gworkflow_components` VALUES ('48', '511', '财务确认', '/pro/finish/relieve', null, null, null, null, null, '0');

INSERT INTO `os_gworkflow_flowtemplate` VALUES ('7', 'G601', '所有业务品种', '保前流程', '退回保费流程', 'returnguarantysum', 'returnguarantysum.xml', null, null, null, '1', '1', 'cbeb758e3d824626a31aabb2a9587b0a');
INSERT INTO `os_gworkflow_components` VALUES ('49', '610', '上传退费审批单', '/pro/finish/riskManagerTrail', null, null, null, null, null, '0');
INSERT INTO `os_gworkflow_components` VALUES ('50', '611', '财务确认', '/pro/finish/relieve', null, null, null, null, null, '0');

