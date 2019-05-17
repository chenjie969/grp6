ALTER TABLE pro_meeting CHANGE `meetiongRoomID` `meetingRoomID` VARCHAR(32) CHARSET utf8 COLLATE utf8_bin NULL, CHANGE `meetiongRoomName` `meetingRoomName` VARCHAR(20) CHARSET utf8 COLLATE utf8_bin NULL; 


/*=============删除=====客户资料相关表=============================*/
DROP TABLE IF EXISTS crm_materialDetail;
DROP TABLE IF EXISTS crm_materialTree;
DROP TABLE IF EXISTS crm_materialModel;
/*=============添加=================================================*/
/* Table: crm_materialModel    客户资料模板表                                                        */
/*==============================================================*/
CREATE TABLE crm_materialModel
(
   materialModel_ID     VARCHAR(32) NOT NULL,
   materialModelName    VARCHAR(100),
   busiTypeIDList       TEXT,
   busiTypeNameList     TEXT,
   clientTypeID         VARCHAR(32),
   clientTypeName       VARCHAR(20),
   versionNumber        CHAR(10),
   STATUS               BOOL DEFAULT 1,
   remark               TEXT,
   unit_uid             VARCHAR(32) NOT NULL,
   unit_uidName         VARCHAR(50),
   updateUserName       VARCHAR(20),
   updateDateTime       DATETIME,
   PRIMARY KEY (materialModel_ID)
);

/*==============================================================*/
/* Table: crm_materialTree     客户资料类型树表                                                    */
/*==============================================================*/
CREATE TABLE crm_materialTree
(
   materialTree_ID      VARCHAR(32) NOT NULL,
   materialModel_ID     VARCHAR(32) NOT NULL,
   pmaterialTree_ID     VARCHAR(32),
   materialTreeName     VARCHAR(200),
   materialTreeFullCode TEXT,
   order_id             BIGINT,
   unit_uid             VARCHAR(32) NOT NULL,
   unit_uidName         VARCHAR(50),
   updateUserName       VARCHAR(20),
   updateDateTime       DATETIME,
   PRIMARY KEY (materialTree_ID)
);

/*==============================================================*/
/* Table: crm_materialDetail      客户资料明细表                                                */
/*==============================================================*/
CREATE TABLE crm_materialDetail
(
   materialDetail_ID    VARCHAR(32) NOT NULL,
   materialTree_ID      VARCHAR(32) NOT NULL,
   materialModel_ID      VARCHAR(32),
   materialTreeName     VARCHAR(200),
   materialName         VARCHAR(100),
   materialType         VARCHAR(20),
   unit_uid             VARCHAR(32) NOT NULL,
   unit_uidName         VARCHAR(50),
   updateUserName       VARCHAR(20),
   updateDateTime       DATETIME,
   PRIMARY KEY (materialDetail_ID)
);

/*====================合同表================================*/
drop table if exists pro_contractDoc;
create table pro_contractDoc
(
   contractDoc_ID       varchar(32) not null,
   apply_ID             varchar(32) not null,
   applyDetail_ID       varchar(32) not null,
   contractCode         varchar(100),
   contractTypeID       varchar(32) comment '参考字典表',
   contractTypeName     varchar(100),
   contractName         varchar(100),
   contractBeginDate    date,
   contractEndDate      date,
   remark               text,
   contractPath         varchar(500),
   unit_uid             varchar(32) not null,
   unit_uidName         varchar(50),
   updateUserName       varchar(20),
   updateDateTime       datetime,
   primary key (contractDoc_ID),
   key AK_index_apply_ID (apply_ID),
   key AK_index_applyDetail_ID (applyDetail_ID),
   key AK_index_contractCode (contractCode)
);

/*=======字典：操作者类型==========初始化数据=============================*/
DELETE FROM c_dictype WHERE dictypepid='c692ccec1a7440fcaecebe1686cb7123';
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('00260013731c4f00983b476f0cc8074d','cbeb758e3d824626a31aabb2a9587b0a','c692ccec1a7440fcaecebe1686cb7123','角色','0','0','1',NULL,'','2017-08-08 10:14:55','管理员','2017-08-08 10:14:55','管理员');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('58ff15c6871c4656998a4f2d411f41e8','cbeb758e3d824626a31aabb2a9587b0a','c692ccec1a7440fcaecebe1686cb7123','部门负责人','4','0','1',NULL,'','2017-08-08 10:15:41','管理员','2017-08-08 10:15:41','管理员');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('6c8d9e8d44fc46538370c1b14c8ebe52','cbeb758e3d824626a31aabb2a9587b0a','c692ccec1a7440fcaecebe1686cb7123','流程发起人','1','0','1',NULL,'','2017-08-08 10:15:05','管理员','2017-08-08 10:15:05','管理员');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('a26b33d97a004a23a105ba7ab9f49bb6','cbeb758e3d824626a31aabb2a9587b0a','c692ccec1a7440fcaecebe1686cb7123','B角','5','0','0',NULL,'','2017-10-11 16:40:40','管理员','2017-10-11 16:40:40','管理员');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('b9600516a9f841b8936b12e92509439d','cbeb758e3d824626a31aabb2a9587b0a','c692ccec1a7440fcaecebe1686cb7123','风控评审人','6','0','0',NULL,'','2017-10-11 16:41:02','管理员','2017-10-11 16:41:02','管理员');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('c68cd5e36d244d469dd607f6d8a200cc','cbeb758e3d824626a31aabb2a9587b0a','c692ccec1a7440fcaecebe1686cb7123','当前办理人','3','0','1',NULL,'','2017-08-08 10:15:31','管理员','2017-08-08 10:15:31','管理员');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('c890276d9fc34c7ab614b7b7238a6669','cbeb758e3d824626a31aabb2a9587b0a','c692ccec1a7440fcaecebe1686cb7123','A角','4','0','0',NULL,'','2017-10-11 16:40:29','管理员','2017-10-11 16:40:29','管理员');

/*======ZHANGKEYAO  201701016==字典表—add —意见常用语===start=======*/
DELETE FROM c_dictype WHERE dictypeid IN ('9bda92c191a841a283f2a7facd084dd3','badccde901ce4bb5b3656fb345497272');
DELETE FROM c_dictype WHERE dictypeid IN ('52b9eab7bbe343f2955ef878b83dd20e');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('52b9eab7bbe343f2955ef878b83dd20e','cbeb758e3d824626a31aabb2a9587b0a','109db432755c4f7ba0610be16df3bea7','意见常用语','54','0','0',NULL,'','2017-10-16 19:55:00','管理员','2017-10-16 19:55:00','管理员');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('9bda92c191a841a283f2a7facd084dd3','cbeb758e3d824626a31aabb2a9587b0a','52b9eab7bbe343f2955ef878b83dd20e','不同意','1','0','0',NULL,'','2017-10-16 19:55:00','管理员','2017-10-16 19:55:00','管理员');
INSERT INTO `c_dictype` (`dicTypeID`, `unit_uid`, `dicTypePID`, `dicTypeName`, `order_id`, `isEable`, `isDefault`, `unificationID`, `remark`, `createdatetime`, `create_user`, `updatedatetime`, `update_user`) VALUES('badccde901ce4bb5b3656fb345497272', 'cbeb758e3d824626a31aabb2a9587b0a','52b9eab7bbe343f2955ef878b83dd20e','同意','0','0','0',NULL,'','2017-10-16 19:55:00','管理员','2017-10-16 19:55:00','管理员');

/*======ZHANGKEYAO  201701016==字典表—add —意见常用语===end=======*/

/*============添加：客户资料明细ID==*/
ALTER TABLE crm_clientFiles ADD materialDetail_ID VARCHAR(32);

