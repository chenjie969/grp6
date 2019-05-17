 /*======放款计划表======添加：审批状态==*/
ALTER TABLE pro_loanPlan ADD COLUMN approvalState VARCHAR(10) COMMENT '放款审批状态（中文：待审批/审批中/通过/未通过）';
/*======放款计划表======添加：备注==*/
ALTER TABLE pro_loanPlan ADD COLUMN remark text ;

