INSERT INTO `os_gworkflow_components` VALUES ('24', '301', '企业续保申请', 0x2F70726F6A6563742F64656C61792F72656E6577616C4E6F745265717569726564, null, null, null, null, null, '0');
INSERT INTO `os_gworkflow_components` VALUES ('25', '302', '地市立项尽调', 0x2F70726F6A6563742F64656C61792F696E7370656374417070726F76616C, null, null, null, null, null, '0');
INSERT INTO `os_gworkflow_components` VALUES ('26', '303', '档案移交登记', 0x2F70726F6A6563742F64656C61792F66696C655472616E73666572, null, null, null, null, null, '0');
INSERT INTO `os_gworkflow_components` VALUES ('27', '304', '档案接收确认', 0x2F70726F6A6563742F64656C61792F66696C655472616E73666572436F6E6669726D6174696F6E, null, null, null, null, null, '0');
INSERT INTO `os_gworkflow_components` VALUES ('28', '305', '子公司风险管理部审核', 0x2F70726F6A6563742F64656C61792F7269736B4578616D696E6174696F6E, null, null, null, null, null, '0');
INSERT INTO `os_gworkflow_components` VALUES ('29', '306', '集团风险管理部审核', 0x2F70726F6A6563742F64656C61792F626C6F635269736B4578616D696E6174696F6E, null, null, null, null, null, '0');
INSERT INTO `os_gworkflow_components` VALUES ('30', '307', '集团总办会纪要', 0x2F70726F6A6563742F64656C61792F626C6F6353756D6D617279, null, null, null, null, null, '0');

INSERT INTO `os_gworkflow_flowtemplate` VALUES ('2', 'G101', '所有业务品种', '保前流程', '展期子流程', 'delay', 'delay.xml', null, null, null, '1', '1', 'cbeb758e3d824626a31aabb2a9587b0a');

CREATE TABLE `pro_creditor` (
  `creditor_id` varchar(32) NOT NULL,
  `apply_id` varchar(32) DEFAULT NULL,
  `old_client_id` varchar(32) DEFAULT NULL,
  `old_client_name` varchar(32) NOT NULL,
  `new_client_id` varchar(32) DEFAULT NULL,
  `new_client_name` varchar(32) DEFAULT NULL,
  `creditor_date` datetime DEFAULT NULL,
  `creditor_sum` decimal(18,6) DEFAULT NULL,
  PRIMARY KEY (`creditor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


