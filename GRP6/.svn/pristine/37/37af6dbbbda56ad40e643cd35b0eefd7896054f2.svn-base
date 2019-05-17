/*========移交前A角ID（初始与A角字段值一样）====pro_project==*/
ALTER TABLE pro_project ADD COLUMN beforeAManID VARCHAR(32) AFTER legalManName;
/*========移交前A角名（初始与A角字段值一样）====pro_project==*/
ALTER TABLE pro_project ADD COLUMN beforeAManName VARCHAR(20) AFTER beforeAManID;
/*========移交前B角ID（初始与B角字段值一样）====pro_project==*/
ALTER TABLE pro_project ADD COLUMN beforeBManID VARCHAR(32) AFTER beforeAManName;
/*========移交前B角名称（初始与B角字段值一样）====pro_project==*/
ALTER TABLE pro_project ADD COLUMN beforeBManName VARCHAR(20) AFTER beforeAManID;
/*========移交时间====pro_project==*/
ALTER TABLE pro_project ADD COLUMN changeDate DATE AFTER beforeBManName;
/*========移交操作人ID====pro_project==*/
ALTER TABLE pro_project ADD COLUMN changeManID VARCHAR(32) AFTER changeDate;
/*========移交操作人名称====pro_project==*/
ALTER TABLE pro_project ADD COLUMN changeManName VARCHAR(20) AFTER changeManID;
/*========移交表添加项目id====pro_project==*/
ALTER TABLE pro_projchangerec ADD COLUMN project_ID VARCHAR(32) AFTER apply_ID;