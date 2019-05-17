/*============是否系统自动指派==*/
ALTER TABLE gbpm_productNode ADD COLUMN isAutoAssign  BOOLEAN NOT NULL DEFAULT TRUE;

/*============================河北融投特有==========================*/
/*============档案移交表==*/
DROP TABLE IF EXISTS pro_arcMove;
CREATE TABLE pro_arcMove
(
   arcMove_ID           VARCHAR(32) NOT NULL,
   arcMoveRec_ID        VARCHAR(32) NOT NULL,
   apply_ID             VARCHAR(32) NOT NULL,
   arcTypeID            VARCHAR(32),
   arcTypeName          VARCHAR(20),
   fileTitleID          VARCHAR(32),
   fileTitleName        VARCHAR(100),
   pageCount            SMALLINT,
   pageNumber           SMALLINT,
   isOriginal           BOOL DEFAULT 0,
   isAll                BOOL DEFAULT 1,
   remark               TEXT,
   isMove               BOOL DEFAULT 0,
   unit_uid             VARCHAR(32),
   updateUserName       VARCHAR(20),
   updateDateTime       DATETIME,
   PRIMARY KEY (arcMove_ID)
);
/*============档案移交记录表==*/
DROP TABLE IF EXISTS pro_arcMoveRec;
CREATE TABLE pro_arcMoveRec
(
   arcMoveRec_ID        VARCHAR(32) NOT NULL,
   apply_ID             VARCHAR(32) NOT NULL,
   moveDate             DATE,
   moveUserName         VARCHAR(20),
   acceptDate           DATE,
   acceptUserName       VARCHAR(20),
   STATUS               VARCHAR(10),
   unit_uid             VARCHAR(32),
   updateUserName       VARCHAR(20),
   updateDateTime       DATETIME,
   PRIMARY KEY (arcMoveRec_ID),
   KEY AK_index_apply_ID (apply_ID)
);

/*============总办会纪要表==*/
DROP TABLE IF EXISTS pro_meetingSummary;
CREATE TABLE pro_meetingSummary
(
   meetingSummary_ID    VARCHAR(32) NOT NULL,
   apply_ID             VARCHAR(32) NOT NULL,
   meetingCode          VARCHAR(50),
   signUserName         VARCHAR(20),
   meetingDateTime      DATETIME,
   compereUserName      VARCHAR(20),
   userNameList         VARCHAR(500),
   absenceUserNameList  VARCHAR(500),
   attendUserNameList   VARCHAR(500),
   recordUserName       VARCHAR(20),
   mainContent          TEXT,
   unit_uid             VARCHAR(32),
   updateUserName       VARCHAR(20),
   updateDateTime       DATETIME,
   PRIMARY KEY (meetingSummary_ID)
);

/*============总办会纪要表==*/
DROP TABLE IF EXISTS pro_riskScheme;
CREATE TABLE pro_riskScheme
(
   riskScheme_ID        VARCHAR(32) NOT NULL,
   relationMain_ID      VARCHAR(32),
   relationMainName     VARCHAR(100),
   product_ID           VARCHAR(32),
   productName          VARCHAR(20),
   productInstance_ID   VARCHAR(32),
   title                VARCHAR(200),
   workProgress         TEXT,
   needCoordination     TEXT,
   nextPlan             TEXT,
   lawsuitInfo          TEXT,
   lawsuitProgress      TEXT,
   remark               TEXT,
   createUserID         VARCHAR(32),
   createUserName       VARCHAR(20),
   createDate           DATE,
   STATUS               VARCHAR(20),
   isMeeting            BOOL DEFAULT 0,
   unit_uid             VARCHAR(32),
   updateUserName       VARCHAR(20),
   updateDateTime       DATETIME,
   PRIMARY KEY (riskScheme_ID)
);

/*============会议记录表==*/
DROP TABLE IF EXISTS pro_riskMeetingRec;
CREATE TABLE pro_riskMeetingRec
(
   riskMeetingRec_ID    VARCHAR(32) NOT NULL,
   meetingName          VARCHAR(200),
   meetingTypeID        VARCHAR(32),
   meetingTypeName      VARCHAR(20),
   meetingDateTime      DATETIME,
   meetingRoom_ID       VARCHAR(32),
   meetingRoomName      VARCHAR(50),
   userIDList           TEXT,
   userNameList         TEXT,
   remark               TEXT,
   createUserID         VARCHAR(32),
   createUserName       VARCHAR(20),
   createDate           DATE,
   STATUS               VARCHAR(20),
   unit_uid             VARCHAR(32),
   updateUserName       VARCHAR(20),
   updateDateTime       DATETIME,
   PRIMARY KEY (riskMeetingRec_ID)
);

/*============风险管理委员会评议表==*/
DROP TABLE IF EXISTS pro_riskAppraise;
CREATE TABLE pro_riskAppraise
(
   riskAppraise_ID      VARCHAR(32) NOT NULL,
   riskScheme_ID        VARCHAR(32) NOT NULL,
   reportUnit           VARCHAR(100),
   reportUserIDList     TEXT,
   reportUserNameList   TEXT,
   reportDate           DATE,
   appraiseResult       VARCHAR(20),
   appraiseDesc         TEXT,
   unit_uid             VARCHAR(32),
   updateUserName       VARCHAR(20),
   updateDateTime       DATETIME,
   PRIMARY KEY (riskAppraise_ID)
);


/*============风险管理委员会评议表化解方案（工作进度）与会议关联表==*/
DROP TABLE IF EXISTS pro_riskScheme_riskMeetingRec;
CREATE TABLE pro_riskScheme_riskMeetingRec
(
   riskScheme_ID        VARCHAR(32) NOT NULL,
   riskMeetingRec_ID    VARCHAR(32) NOT NULL,
   PRIMARY KEY (riskScheme_ID, riskMeetingRec_ID)
);