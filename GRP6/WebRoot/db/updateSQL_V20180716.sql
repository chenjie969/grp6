INSERT INTO `os_gworkflow_flowtemplate` VALUES ('4', 'G401', '所有业务品种', '保前流程', '委贷还款流程', 'factpay', 'factpay.xml', null, null, null, '1', '1', 'cbeb758e3d824626a31aabb2a9587b0a');

INSERT INTO `os_gworkflow_components` VALUES ('38', '401', '项目组上传文件', '/project/factPay/gworkFlowUploadFile', null, null, null, null, null, '0');
INSERT INTO `os_gworkflow_components` VALUES ('39', '402', '部门审核', '/project/factPay/gworkFlowSelectFile', null, null, null, null, null, '0');


ALTER TABLE pro_factpay ADD COLUMN `isCheck` tinyint(1) DEFAULT '0' COMMENT '是否通过流程';
