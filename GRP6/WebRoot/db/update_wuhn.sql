/**
 * 作用： 修改表结构提供的sql
 * author：wuhn
 */

/*begin  上机日志和操作日志添加字段 担保机构名称 */
ALTER TABLE `sys_loglogin`  ADD COLUMN `unit_uidName`  varchar(50) NOT NULL AFTER `ipAddress`;

ALTER TABLE `sys_logoperator`   ADD COLUMN `unit_uidName`  varchar(50) NOT NULL AFTER `ipAddress`;
/*end  2017年5月9日 16:51:14 */ 

/*begin 上机日志和操作日志 字段大小 修改到 varchar(100) */
ALTER TABLE `sys_loglogin` MODIFY COLUMN `unit_uidName`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL AFTER `ipAddress`;

ALTER TABLE `sys_logoperator` MODIFY COLUMN `unit_uidName`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL AFTER `ipAddress`;
/*end 2017年5月10日 16:24:16 */