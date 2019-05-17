/*====申请表===删除：是否已申请上会=====================*/
ALTER TABLE pro_apply DROP COLUMN isApplyMeeting;
/*============添加：上会状态（中文：待安排/未上会/已上会）==*/
ALTER TABLE pro_apply ADD meetingStatus VARCHAR(20);
/*============添加：申请上会日期==*/
ALTER TABLE pro_apply ADD applyMeetingDate DATE;
/*============添加：经办部门ID==*/
ALTER TABLE pro_apply ADD operationDepartID VARCHAR(50);
/*============添加：经办部门名称==*/
ALTER TABLE pro_apply ADD operationDepartName VARCHAR(20);
/*============添加：上会申请人名称==*/
ALTER TABLE pro_apply ADD applyMeetingUserName VARCHAR(20);
/*============添加：申请上会提交日期==*/
ALTER TABLE pro_apply ADD meetingSubmitDate DATE;

/*====产品明细表===添加：申请上会日期==*/
ALTER TABLE pro_applyDetail ADD applyMeetingDate DATE;
/*============添加：经办部门ID==*/
ALTER TABLE pro_applyDetail ADD operationDepartID VARCHAR(50);
/*============添加：经办部门名称==*/
ALTER TABLE pro_applyDetail ADD operationDepartName VARCHAR(20);
/*============添加：上会申请人名称==*/
ALTER TABLE pro_applyDetail ADD applyMeetingUserName VARCHAR(20);
/*============添加：申请上会提交日期==*/
ALTER TABLE pro_applyDetail ADD meetingSubmitDate DATE;
/*============添加：上会状态（中文：待安排/未上会/已上会）==*/
ALTER TABLE pro_applyDetail ADD meetingStatus VARCHAR(20);
/*============添加：是否已出具评审会决议==*/
ALTER TABLE pro_applyDetail ADD isResolution BOOL DEFAULT 0;
/*============添加：评审会编号==*/
ALTER TABLE pro_applyDetail ADD meetingCode VARCHAR(50);
/*============添加：决议编号==*/
ALTER TABLE pro_applyDetail ADD resolutionCode VARCHAR(50);
/*============添加：在保监控要求==*/
ALTER TABLE pro_applyDetail ADD monitoredAsking TEXT;
/*============添加：上会结果ID(字典，与决议结果字典相同)==*/
ALTER TABLE pro_applyDetail ADD meetingResult VARCHAR(10);
