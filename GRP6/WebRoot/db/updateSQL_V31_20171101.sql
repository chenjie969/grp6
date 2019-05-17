/*==========客户资料名称表排序字段================*/
ALTER TABLE `crm_materialdetail` ADD `order_id` VARCHAR(32);
/*======应收费用明细表======添加：评审会产品明细==*/
ALTER TABLE pro_costMust ADD COLUMN meetingDetail_ID VARCHAR(32) COMMENT '评审会产品明细';
/*======预收费用明细表======添加：评审会产品明细==*/
ALTER TABLE pro_costPre ADD COLUMN meetingDetail_ID VARCHAR(32) COMMENT '评审会产品明细';
/*======业务退费表======添加：评审会产品明细==*/
ALTER TABLE pro_costReturn ADD COLUMN meetingDetail_ID VARCHAR(32) COMMENT '评审会产品明细';
/*======实收费用明细表======添加：评审会产品明细==*/
ALTER TABLE pro_costFact ADD COLUMN meetingDetail_ID VARCHAR(32) COMMENT '评审会产品明细';
/*======保后（贷后）产品放款明细表======添加：评审会产品明细==*/
ALTER TABLE pro_project ADD COLUMN meetingDetail_ID VARCHAR(32) COMMENT '评审会产品明细';




