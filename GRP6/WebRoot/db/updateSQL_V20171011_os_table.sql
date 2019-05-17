/*
SQLyog Ultimate v11.26 (32 bit)
MySQL - 5.6.19 : Database - grp_rt
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `os_currentstep` */

DROP TABLE IF EXISTS `os_currentstep`;

CREATE TABLE `os_currentstep` (
  `ID` bigint(20) NOT NULL,
  `ENTRY_ID` bigint(20) DEFAULT NULL,
  `STEP_ID` int(11) DEFAULT NULL,
  `ACTION_ID` int(11) DEFAULT NULL,
  `OWNER` varchar(35) COLLATE utf8_bin DEFAULT NULL,
  `START_DATE` datetime DEFAULT NULL,
  `FINISH_DATE` datetime DEFAULT NULL,
  `DUE_DATE` datetime DEFAULT NULL,
  `STATUS` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `CALLER` varchar(35) COLLATE utf8_bin DEFAULT NULL,
  `stepName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `limitDate` int(11) DEFAULT NULL,
  `limitDateUnit` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `AK_AK_ENTRY_ID` (`ENTRY_ID`),
  KEY `AK_AK_OWNER` (`OWNER`),
  KEY `AK_AK_CALLER` (`CALLER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `os_currentstep_prev` */

DROP TABLE IF EXISTS `os_currentstep_prev`;

CREATE TABLE `os_currentstep_prev` (
  `ID` bigint(20) NOT NULL,
  `PREVIOUS_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`,`PREVIOUS_ID`),
  KEY `AK_AK_ID` (`ID`),
  KEY `AK_AK_PREVIOUS_ID` (`PREVIOUS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `os_entryids` */

DROP TABLE IF EXISTS `os_entryids`;

CREATE TABLE `os_entryids` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `os_gwork_flowroleuser` */

DROP TABLE IF EXISTS `os_gwork_flowroleuser`;

CREATE TABLE `os_gwork_flowroleuser` (
  `flowroleuserid` int(11) NOT NULL AUTO_INCREMENT,
  `flowid` bigint(20) DEFAULT NULL,
  `roleid` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `userid` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `unit_uid` bigint(20) NOT NULL,
  PRIMARY KEY (`flowroleuserid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `os_gworkflow_components` */

DROP TABLE IF EXISTS `os_gworkflow_components`;

CREATE TABLE `os_gworkflow_components` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `componentID` varchar(3) COLLATE utf8_bin DEFAULT NULL,
  `componentName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `editAction` text COLLATE utf8_bin,
  `viewAction` text COLLATE utf8_bin,
  `roleDescr` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `funDescr` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `releaseDate` date DEFAULT NULL,
  `author` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `unit_uid` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `os_gworkflow_creditidflowid` */

DROP TABLE IF EXISTS `os_gworkflow_creditidflowid`;

CREATE TABLE `os_gworkflow_creditidflowid` (
  `ID` double DEFAULT NULL,
  `credit_ID` text COLLATE utf8_bin,
  `ENTRY_ID` double DEFAULT NULL,
  `flowTemplateID` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `flowCreateTime` datetime DEFAULT NULL,
  `flowCtreatorID` varchar(80) COLLATE utf8_bin DEFAULT NULL,
  `unit_uid` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `os_gworkflow_files` */

DROP TABLE IF EXISTS `os_gworkflow_files`;

CREATE TABLE `os_gworkflow_files` (
  `files_ID` varchar(32) COLLATE utf8_bin NOT NULL,
  `fileType` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `sourceFileName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `pathFile` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `extend` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `uploadManID` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `uploadManName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `uploadDateTime` datetime DEFAULT NULL,
  `fileSize` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `unit_uid` varchar(32) COLLATE utf8_bin NOT NULL,
  `unit_uidName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `updateUserName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `updateDateTime` datetime DEFAULT NULL,
  `flowID` bigint(20) DEFAULT NULL,
  `stepID` bigint(20) DEFAULT NULL,
  `historyID` bigint(20) DEFAULT NULL,
  `projectID` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`files_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `os_gworkflow_flowstatus` */

DROP TABLE IF EXISTS `os_gworkflow_flowstatus`;

CREATE TABLE `os_gworkflow_flowstatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flowStatus_id` int(11) DEFAULT NULL,
  `flowStatusName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `os_gworkflow_flowtemplate` */

DROP TABLE IF EXISTS `os_gworkflow_flowtemplate`;

CREATE TABLE `os_gworkflow_flowtemplate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flowTemplateID` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `flowTypeID` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `flowTypeName` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `flowTemplateName` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `flowTempaleMapName` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `flowXmlFile` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `funDesrc` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `version` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `releaseDate` date DEFAULT NULL,
  `isActive` tinyint(4) DEFAULT NULL,
  `isDel` tinyint(4) DEFAULT NULL,
  `unit_uid` varchar(32) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `os_gworkflow_oaflowid` */

DROP TABLE IF EXISTS `os_gworkflow_oaflowid`;

CREATE TABLE `os_gworkflow_oaflowid` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flowTypeID` char(2) COLLATE utf8_bin DEFAULT NULL,
  `flowType` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `oa_id` int(11) DEFAULT NULL,
  `ENTRY_ID` bigint(20) DEFAULT NULL,
  `flowTemplateID` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `flowCreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `flowCtreatorID` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `flowCreator` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `unit_uid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `os_gworkflow_projidflowid` */

DROP TABLE IF EXISTS `os_gworkflow_projidflowid`;

CREATE TABLE `os_gworkflow_projidflowid` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `projectID` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `ENTRY_ID` bigint(20) DEFAULT NULL,
  `flowTemplateID` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `flowCreateTime` datetime DEFAULT NULL,
  `flowCtreatorID` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `unit_uid` varchar(32) COLLATE utf8_bin NOT NULL,
  `flowTemplateName` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `departid` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `useruid` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `createdatetime` datetime DEFAULT NULL,
  `flowType` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `entityName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `AK_key_unit_id` (`projectID`,`unit_uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `os_gworkflow_projsuggest` */

DROP TABLE IF EXISTS `os_gworkflow_projsuggest`;

CREATE TABLE `os_gworkflow_projsuggest` (
  `opsuggest_ID` varchar(32) COLLATE utf8_bin NOT NULL,
  `unit_uid` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `projectID` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `user_uid` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `user_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `depart_uid` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `depart_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `suggestContent` text COLLATE utf8_bin,
  `suggestResult` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `suggestTime` datetime DEFAULT NULL,
  `flowID` bigint(20) DEFAULT NULL,
  `stepID` bigint(20) DEFAULT NULL,
  `stepName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `isCheckMan` tinyint(1) DEFAULT '0',
  `historyID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`opsuggest_ID`),
  KEY `AK_key_unit_id` (`unit_uid`),
  KEY `AK_key_projectid` (`projectID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `os_gworkflow_stepstauts` */

DROP TABLE IF EXISTS `os_gworkflow_stepstauts`;

CREATE TABLE `os_gworkflow_stepstauts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `statusName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `os_gworkflow_useraction` */

DROP TABLE IF EXISTS `os_gworkflow_useraction`;

CREATE TABLE `os_gworkflow_useraction` (
  `userAction_id` int(11) NOT NULL AUTO_INCREMENT,
  `UserGID` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `flowid` bigint(20) DEFAULT NULL,
  `actionid` int(11) DEFAULT NULL,
  `actionName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `unit_uid` bigint(20) NOT NULL,
  PRIMARY KEY (`userAction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `os_historystep` */

DROP TABLE IF EXISTS `os_historystep`;

CREATE TABLE `os_historystep` (
  `ID` bigint(20) NOT NULL,
  `ENTRY_ID` bigint(20) DEFAULT NULL,
  `STEP_ID` int(11) DEFAULT NULL,
  `ACTION_ID` int(11) DEFAULT NULL,
  `OWNER` varchar(35) COLLATE utf8_bin DEFAULT NULL,
  `START_DATE` datetime DEFAULT NULL,
  `FINISH_DATE` datetime DEFAULT NULL,
  `DUE_DATE` datetime DEFAULT NULL,
  `STATUS` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `CALLER` varchar(35) COLLATE utf8_bin DEFAULT NULL,
  `stepName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `limitDate` int(11) DEFAULT NULL,
  `limitDateUnit` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `AK_AK_ENTRY_ID` (`ENTRY_ID`),
  KEY `AK_AK_OWNER` (`OWNER`),
  KEY `AK_AK_CALLER` (`CALLER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `os_historystep_prev` */

DROP TABLE IF EXISTS `os_historystep_prev`;

CREATE TABLE `os_historystep_prev` (
  `ID` bigint(20) NOT NULL,
  `PREVIOUS_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`,`PREVIOUS_ID`),
  KEY `AK_AK_ID` (`ID`),
  KEY `AK_AK_PREVIOUS_ID` (`PREVIOUS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `os_propertyentry` */

DROP TABLE IF EXISTS `os_propertyentry`;

CREATE TABLE `os_propertyentry` (
  `GLOBAL_KEY` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `ITEM_KEY` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `ITEM_TYPE` tinyint(4) DEFAULT NULL,
  `STRING_VALUE` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DATE_VALUE` datetime DEFAULT NULL,
  `DATA_VALUE` longblob,
  `FLOAT_VALUE` float DEFAULT NULL,
  `NUMBER_VALUE` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `os_stepids` */

DROP TABLE IF EXISTS `os_stepids`;

CREATE TABLE `os_stepids` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `os_wfentry` */

DROP TABLE IF EXISTS `os_wfentry`;

CREATE TABLE `os_wfentry` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `STATE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `view_steps` */

DROP TABLE IF EXISTS `view_steps`;

/*!50001 DROP VIEW IF EXISTS `view_steps` */;
/*!50001 DROP TABLE IF EXISTS `view_steps` */;

/*!50001 CREATE TABLE  `view_steps`(
 `ID` bigint(20) ,
 `ENTRY_ID` bigint(20) ,
 `STEP_ID` int(11) ,
 `ACTION_ID` int(11) ,
 `OWNER` varchar(35) ,
 `START_DATE` datetime ,
 `FINISH_DATE` datetime ,
 `DUE_DATE` datetime ,
 `STATUS` varchar(40) ,
 `CALLER` varchar(35) ,
 `stepName` varchar(100) 
)*/;

/*View structure for view view_steps */

/*!50001 DROP TABLE IF EXISTS `view_steps` */;
/*!50001 DROP VIEW IF EXISTS `view_steps` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_steps` AS select `a`.`ID` AS `ID`,`a`.`ENTRY_ID` AS `ENTRY_ID`,`a`.`STEP_ID` AS `STEP_ID`,`a`.`ACTION_ID` AS `ACTION_ID`,`a`.`OWNER` AS `OWNER`,`a`.`START_DATE` AS `START_DATE`,`a`.`FINISH_DATE` AS `FINISH_DATE`,`a`.`DUE_DATE` AS `DUE_DATE`,`a`.`STATUS` AS `STATUS`,`a`.`CALLER` AS `CALLER`,`a`.`stepName` AS `stepName` from `os_currentstep` `a` union select `os_historystep`.`ID` AS `ID`,`os_historystep`.`ENTRY_ID` AS `ENTRY_ID`,`os_historystep`.`STEP_ID` AS `STEP_ID`,`os_historystep`.`ACTION_ID` AS `ACTION_ID`,`os_historystep`.`OWNER` AS `OWNER`,`os_historystep`.`START_DATE` AS `START_DATE`,`os_historystep`.`FINISH_DATE` AS `FINISH_DATE`,`os_historystep`.`DUE_DATE` AS `DUE_DATE`,`os_historystep`.`STATUS` AS `STATUS`,`os_historystep`.`CALLER` AS `CALLER`,`os_historystep`.`stepName` AS `stepName` from `os_historystep` */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
