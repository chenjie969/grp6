/*============添加担保意向涵表==*/
DROP TABLE IF EXISTS pro_intentionLetter;
CREATE TABLE pro_intentionLetter
(
   intentionLetter_ID   VARCHAR(32) NOT NULL,
   apply_ID             VARCHAR(32) NOT NULL,
   meetingDetail_ID     VARCHAR(32),
   intentionLetterCode  VARCHAR(20),
   bankID               VARCHAR(32),
   bankName             VARCHAR(50),
   busiTypeID           VARCHAR(32),
   busiTypeName         VARCHAR(50),
   agreeSum             DECIMAL(18,6),
   periodMonth          SMALLINT,
   periodDay            SMALLINT,
   periodMonthDay       VARCHAR(20),
   createDate           DATE,
   batchNumber          SMALLINT,
   STATUS               VARCHAR(20),
   fileName             VARCHAR(200),
   filePath             VARCHAR(500),
   unit_uid             VARCHAR(32) NOT NULL,
   unit_uidName         VARCHAR(50),
   updateUserName       VARCHAR(20),
   updateDateTime       DATETIME,
   PRIMARY KEY (intentionLetter_ID),
   KEY AK_index_apply_ID (apply_ID)
);