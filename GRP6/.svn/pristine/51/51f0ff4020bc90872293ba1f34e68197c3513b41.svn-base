/*============业务还款信息表备注改为Text==*/
ALTER TABLE `pro_factPay` CHANGE `remark` `remark` Text; 
/*===========修改保证措施表“土地面积”字段的类型==========*/
ALTER TABLE pro_optguaranty CHANGE landArea landArea VARCHAR (50) NULL;

/*======应收费用明细表======添加：最迟应收日期=====添加应收费用时用的（王振坤 20171116）======*/
ALTER TABLE pro_costMust ADD COLUMN mustCostDate date ;

/*=====融投项目特有=======添加：保外债权人融资金额==*/
ALTER TABLE crm_relationMain ADD COLUMN creditorSum DECIMAL(18,6) NULL AFTER entrustSum;

