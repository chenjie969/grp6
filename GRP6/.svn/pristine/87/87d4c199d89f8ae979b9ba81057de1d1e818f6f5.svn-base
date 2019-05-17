/*==========业务代偿信息表====添加：代偿原因================*/
ALTER TABLE `pro_replace` ADD `replaceReason` TEXT;
/*======业务还款信息表======添加：审批状态==*/
ALTER TABLE pro_factPay ADD COLUMN payState VARCHAR(10) COMMENT '审批状态（中文：待审批/审批中/通过/未通过）';
/*======业务还款信息表======添加：是否注销保证措施==*/
ALTER TABLE pro_factPay ADD COLUMN isStopOptGuaranty BOOL;

/*======放款计划表======添加：是否有延期或豁免事项申请==*/
ALTER TABLE pro_loanPlan ADD COLUMN isDelayApply BOOL COMMENT '是否有延期或豁免事项申请';
/*======放款计划表======添加：延期或豁免事项申请详情==*/
ALTER TABLE pro_loanPlan ADD COLUMN delayApplyDesc TEXT COMMENT '延期或豁免事项申请详情';
/*======放款计划表======添加：保证措施落实情况==*/
ALTER TABLE pro_loanPlan ADD COLUMN receiveDesc TEXT COMMENT '保证措施落实情况';