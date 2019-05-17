--创建流程对应实体表
CREATE TABLE os_gworkflow_instance (
  id INT(11) NOT NULL AUTO_INCREMENT,
  applyId VARCHAR(64) NOT NULL,	
  businessId VARCHAR(64) NOT NULL,	
  businessType VARCHAR(128) NOT NULL,	
  entryId INT(11) NOT NULL,	
  flowTemplateId VARCHAR(64) NOT NULL,
  createTime DATETIME NOT NULL,		
  user_uid VARCHAR(64) NOT NULL,	
  unit_uid VARCHAR(64) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8



--流程模板



--事项
DELETE FROM os_gworkflow_components WHERE id > 20;
INSERT INTO os_gworkflow_components(componentID, componentName, editAction, unit_uid)
VALUES('201', '放款申请查看', '/project/loan/showLoanApplyViewPage_onFlow', 0 );

