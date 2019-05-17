package com.zjm.common.db.model;

import java.io.Serializable;
import java.util.Date;

public class QueryCondition implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String mod_uid;//菜单id
	private String pmod_id;//菜单父id
	//duanhuawei add 20170426 查询机构列表用

	private String dicTypeID;//单级字典ID，用于没有子节点的列表查询
	private String dicTypePID;//单级字典父ID，用于有子节点的列表查询

	private String unit_uid;//机构id
	private String punit_uid;//机构id-- 父idØ
	//duanhuawei add 20170427 查询部门的用户列表用
	private String depart_uid;//部门Id

	
	private String pbusisortid; //业务品种父 id
	private String busisortid; //业务品种父 id
	
	private String pbanksortid; // 银行字典父id
	private String banksortid; // 银行字典id
	
	private String pmultilevelsortid; //多级字典 父id
	private String multilevelsortid; //多级字典 父id
	
	private String clientTypeID; // 客户类型id '01企业02个人经营类03个人消费类（不做字典，直接写在程序中）'
	
	private String client_ID;// 客户id
	private String relationMain_ID;// 关联主体ID
	
	
	private String post_ID;//岗位id;
	private String parentPostID;//岗位 父id;
	
	private  String logindatetime;// 上机时间
	
	private  String operatordatetime; //操作时间
	
	private String 	 clientName;//客户名称（申请人姓名）
	//企业客户高级条件查询字段冗余----start----
	private String fullAreaName;//所属区域
	private String fullTradeName;//所属行业;
	private String natureID;//企业性质ID
	private String currencyID;//币别
	private Double   registerSumStart;//注册资本.万
	private Double   registerSumEnd;//注册资本.万
	private Date createDateStart;//成立时间1
	private Date createDateEnd;//成立时间2
	private String 	 clientSourceID;//客户来源ID
	private String controlPerson;//实际控制人;  
	
	private Date createDateTimeStart;//创建时间1
	private Date createDateTimeEnd;//创建时间2
	private String createUserName;//创建人姓名;
	
    
    private String fullDepartName;//创建部门
   
    private String legalPerson;//法定代表人;
	
	
    private String  unit_uidName;//创建机构名称;
	//企业客户高级条件查询字段冗余----end----
    
    //个人客户高级条件查询字段----start----
    private String personName;//申请人姓名
    private String personNum;//申请人身份证号码
    private String phone;//申请人联系方式
    //个人客户高级条件查询字段----end----

//	商机管理高级查询字段----start----
    private String apply_clientType;	//商机管理-客户类型，01企业  02个人
    private String apply_approvalStatu;	//商机管理-受理状态，01受理中  02同意受理  03不同意受理
    //private String clientName;客户名称，与已有字段共用
    //private String clientSourceID;客户来源，与已有字段共用
    private String busiTypeID;		//业务品种ID
    private String cooperationID;	//合作机构ID
    private Double applySumLow;		//申请金额 下限
    private Double applySumHigh;	//申请金额 上限
    private Integer periodMonthLow;	//申请期限 下限
    private Integer periodMonthHigh;//申请期限 上限
    private String receiveDeapartID;//接待部门ID
    private String receiveUserID;	//接待人ID
    private Date receiveDateLow;	//接待日期 下限
    private Date receiveDateHigh;	//接待日期 上限
    //企业
    private String contact;			//联系人
    //个人
    private String certificateCode;	//身份证号码
//	商机管理高级查询字段----end----
    
    private String upDownFlag;	//上下游标识：01上游供应商02下游销售商
    
    // 关联查询条件
    private String queryType;	//查询类型		//河北融投-风险处置-首页-查看工作进度提醒 也用到了此字段
    private String queryContent;	//查询内容
    
    //申请登记:高级条件查询:
    private String projectName;
    //private String	clientTypeID	;//	客户类型ID	varchar(32)
   
    private String busiTypeName; //业务品种名称;(前后台传递参数使用,真正查询时使用busiTypeNameList)
    private String	busiTypeNameList	;//	业务品种名称集合	text
    private String bankName; //合作机构名称;(前后台传递参数使用,真正查询时使用bankNameList)
   
	private String	bankNameList	;//	合作机构名称集合	text
	//private Double	applySum	;//	（授信）申请金额	decimal(18,6)
	private String	departName	;//	部门名称	varchar(50)
	private String	createManName	;//	创建人名称	varchar(20)
	private Date	createDate	;//	登记日期	date
	//信息中心
	private String	messageTypeId	;//	类型	varchar(20)
	private String	messageTypePID	;//	大类型	varchar(20)
	private String	status	;//	当前状态	varchar(20)
	private String  titleName;   // 标题名称

	//授信申请高级查询
	private String 	busiCode;	//授信编号
	private String 	creditTypeID;	//授信类型
	private Date	creditBeginDateLow;	//授信起始日期 下限
	private Date	creditBeginDateHigh;	//授信起始日期 上限
	private Date	creditEndDateLow;	//授信起始日期 下限
	private Date	creditEndDateHigh;	//授信起始日期 上限
	private Double	usedSumLow;			//已用金额 下限
	private Double	usedSumHigh;		//已用金额 上限
	private Double	usableSumLow;		//可用金额 下限
	private Double	usableSumHigh;		//可用金额 上限
	private Double	agreeSumLow;		//授信同意金额 下限
	private Double	agreeSumHigh;		//授信同意金额 上限
	//授信申请高级查询 结束

	//票据管理用
	private String apply_ID;		//项目申请ID
	private String applyDetail_ID;	//项目申请明细ID
	//票据管理用
	
	//授信各列表区分查询条件
	private String creditStatus;	//授信状态
	private String projectStageID;	//业务阶段
	//授信各列表区分查询条件---end
	private String parentApply_ID;	//授信额度ID pro_apply表
	//mashuo add 20170714 begin 
	private String actSortID;//流程分类ID
	private String pactSortID;//流程分类pID
	private String actSortName;//流程分类名称
	//mashuo add 20170714 begin 
	
	/**project表--保后跟踪--高级查询条件 begin*/
	private String loadSumStart;
	private String loadSumEnd;
	private Date delayBeginDateStart;//展期起始日期
	private Date delayBeginDateEnd;//展期起始日期
	private	Date delayEndDateStart;//展期结束日期
	private	Date delayEndDateEnd;//展期结束日期
	/**project表--保后跟踪--高级查询条件 end*/
	
	/** 担保措施管理-- 高级查询条件  begin */
	private String guarantyTypeID;//保证方式ID
	private String optTypeID;//反担保物类型
	private String updateUserName;//担保信息创建人
	private Integer isWorkable;//是否已落实
	private String ownerName;//权属人名称
	private Integer isFree ; //是否解除
	private Integer isDispose ; //是否处置
	private String  disposeBeginDate; //处置日期 开始
	private String  disposeEndDate; //处置日期 结束
	private String  freeBeginDate; //解除日期 开始
	private String  freeEndDate; //解除日期 结束
	private String  freeUserID; //已解除经办人id
	private String  disposeUserId; //已处置经办人id
	private String  optGuaranty_ID; //保证措施ID
	private String  relationMainName; //关联关系  重点项目查询
	
	/** end */
	
	
	private String entityID;//业务实体id
	private String entityType;//业务实体类型
	
	private String productNodeID;//产品节点ID
	private String productID;//产品节点ID
	
	private String  choose;
	private String staffcase_Id;//员工ID
	
	
	//人力资源的高级查询
	private String staffDocuments;//身份证号

	private String user_name;//员工姓名
	
	
	private String borndate;//出生日期
	private String contractEndDate;//合同到期日
	 
	//节点任务列表冗余字段----start
	private String productInstance_ID;//实例id
	private String taskType_ID;//任务事项类型id
	private Long  nodeSort;//节点顺序；
	private Boolean IsUsed;//流程状态：true：启用 false:禁用
	//节点任务列表冗余字段----end
	
	private String documentCode; //文档编号
	private String taskID;//任务id
	
	private String project_ID;
	private String flowID; // 流程id
	private String stepID; // 步骤id
	
	private String user_uid;	//用户ID
	private String loanPlan_ID;//计划放款表id
	private	String	busiClass	;//	业务大类(01：担保02：委贷)	Variable characters (50)
	
	private String materialTree_ID	;//	客户资料类型树ID	varchar(32)
	private String materialModel_ID	;//	资料模板ID	varchar(32)
	
	//同步：
	private String	clientGUID;//	主体客户唯一标识	varchar(32)s
	
	private String contractIDstr;	//文担 WHDB 合同审批多个合同ID
	private String arcMoveRec_ID;	//档案记录id
	
	private Date finishBeginDate;		//起始日期 河北融投-风险处置-工作进度提醒
	private Date finishEndDate;		//截止日期 河北融投-风险处置-工作进度提醒
	
	private Integer isMove	;//	是否已移交	Boolean	
	private String reviewType;	//审批类型
	
	/** 在保(贷后)跟踪高级查询补充参数 **/
	private String guarantyOrgName; //承保机构
	private String attributionName; //承办地区
	private String oprationCompanyName; //报送机构
	private String hostAreaName; //属地划分
	private String projectCode; //项目编号
	private Double loadSum;  //项目金额
	private String amanName; //a角名字
	private String bmanName; //b角名字
	private String fundID; //资金方id
	private String fundChinese;//资金方名称

	private String mark;
	
	/** 大报表高级查询补充参数 **/
	private String subBankName; //合作子机构
	private String delaySumStart; //展期金额
	private String delaySumEnd; //展期金额
	private String returnSumStart; //追偿总金额
	private String returnSumEnd; //追偿总金额
	private String replaceFreeSumStart; //代偿总金额
	private String replaceFreeSumEnd; //代偿总金额
	private String isCreditor; //是否涉及敏感债权人
	private String creditorCountStart;//债权人数量
	private String creditorCountEnd;//债权人数量
	private String fundSource; //资金来源
	private String periodMonthStart; //期限.月
	private String periodMonthEnd; //期限.月
	private String periodDayStart; //期限.天
	private String periodDayEnd; //期限.天
	private String guarantySumStart; //在保余额
	private String guarantySumEnd; //在保余额
	private Date payDateStart; //还款日期
	private Date payDateEnd; //还款日期
	private Date returnDateStart; //追偿日期
	private Date returnDateEnd; //追偿日期
	private String creditorSumStart; //转让金额
	private String creditorSumEnd; //转让金额
	private String normalFreeSumStart; //还款总金额
	private String normalFreeSumEnd; //还款总金额
	private String riskLevelID; //国资委五级分类ID
	private Date creditorDateStart; //转让日期
	private Date creditorDateEnd; //转让日期
	private String isCreditorMark; //是否债权转让
	private String guarantyOrgID; //承保机构ID
	private String attributionsID; //属地划分ID
	private String hostAreasID; //报送机构ID
	private String oprationCompanysID; //经办公司ID
	private String creditor; //债权人
	private String fundTypesName; //资金方类型
	private String fundName; //资金方名称子机构
	private Date loanDateStart; //放款日期
	private Date loanDateEnd; //放款日期
	private Date selectlDateStart; //查询日期
	private Date selectlDateEnd; //查询日期
	private Date replaceDateStart; //代偿日期
	private Date replaceDateEnd; //代偿日期
	
	/** 关联企业高级查询补充参数 **/
	private String relationClient;//关联企业
	
	private String lawSuitType; //诉讼类型 主诉01 被诉02
	private String assetSealUpType; //查封类型 01 作为申请人 02作为被执行人
	private String obligorType; //破产登记类型 01作为破产债权人 02作为破产连带债务人
	private String executecaseType; //执行案件类型 01作为申请执行人 02作为被执行人
	
	
	
	public Date getReplaceDateStart() {
		return replaceDateStart;
	}
	public void setReplaceDateStart(Date replaceDateStart) {
		this.replaceDateStart = replaceDateStart;
	}
	public Date getReplaceDateEnd() {
		return replaceDateEnd;
	}
	public void setReplaceDateEnd(Date replaceDateEnd) {
		this.replaceDateEnd = replaceDateEnd;
	}
	public Date getSelectlDateStart() {
		return selectlDateStart;
	}
	public void setSelectlDateStart(Date selectlDateStart) {
		this.selectlDateStart = selectlDateStart;
	}
	public Date getSelectlDateEnd() {
		return selectlDateEnd;
	}
	public void setSelectlDateEnd(Date selectlDateEnd) {
		this.selectlDateEnd = selectlDateEnd;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	/** 重点项目高级查询追加字段**/
	private String projectTypeName;//项目类型

	public String getFundID() {
		return fundID;
	}
	public void setFundID(String fundID) {
		this.fundID = fundID;
	}
	public String getFundChinese() {
		return fundChinese;
	}
	public void setFundChinese(String fundChinese) {
		this.fundChinese = fundChinese;
	}
	public String getRelationMainName() {
		return relationMainName;
	}
	public void setRelationMainName(String relationMainName) {
		this.relationMainName = relationMainName;
	}

	public String getProjectTypeName() {
		return projectTypeName;
	}
	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
	}
	public String getGuarantyOrgName() {
		return guarantyOrgName;
	}
	public void setGuarantyOrgName(String guarantyOrgName) {
		this.guarantyOrgName = guarantyOrgName;
	}
	public String getAttributionName() {
		return attributionName;
	}
	public void setAttributionName(String attributionName) {
		this.attributionName = attributionName;
	}
	public String getOprationCompanyName() {
		return oprationCompanyName;
	}
	public void setOprationCompanyName(String oprationCompanyName) {
		this.oprationCompanyName = oprationCompanyName;
	}
	public String getHostAreaName() {
		return hostAreaName;
	}
	public void setHostAreaName(String hostAreaName) {
		this.hostAreaName = hostAreaName;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public Double getLoadSum() {
		return loadSum;
	}
	public void setLoadSum(Double loadSum) {
		this.loadSum = loadSum;
	}
	public String getAmanName() {
		return amanName;
	}
	public void setAmanName(String amanName) {
		this.amanName = amanName;
	}
	public String getBmanName() {
		return bmanName;
	}
	public void setBmanName(String bmanName) {
		this.bmanName = bmanName;
	}
	public String getStaffcase_Id() {
		return staffcase_Id;
	}
	public String getStaffDocuments() {
		return staffDocuments;
	}
	public void setStaffDocuments(String staffDocuments) {
		this.staffDocuments = staffDocuments;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void setStaffcase_Id(String staffcase_Id) {
		this.staffcase_Id = staffcase_Id;
	}
	public String getUpDownFlag() {
		return upDownFlag;
	}
	public String getCreditStatus() {
		return creditStatus;
	}
	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}
	public String getProjectStageID() {
		return projectStageID;
	}
	public void setProjectStageID(String projectStageID) {
		this.projectStageID = projectStageID;
	}
	public void setUpDownFlag(String upDownFlag) {
		this.upDownFlag = upDownFlag;
	}

	public String getApply_clientType() {
		return apply_clientType;
	}

	public void setApply_clientType(String apply_clientType) {
		this.apply_clientType = apply_clientType;
	}

	public String getApply_approvalStatu() {
		return apply_approvalStatu;
	}

	public void setApply_approvalStatu(String apply_approvalStatu) {
		this.apply_approvalStatu = apply_approvalStatu;
	}

	public String getMod_uid() {
		return mod_uid;
	}

	public void setMod_uid(String mod_uid) {
		this.mod_uid = mod_uid;
	}

	public String getDicTypeID() {
		return dicTypeID;
	}

	public void setDicTypeID(String dicTypeID) {
		this.dicTypeID = dicTypeID;
	}

	public String getDicTypePID() {
		return dicTypePID;
	}
	public void setDicTypePID(String dicTypePID) {
		this.dicTypePID = dicTypePID;
	}
	public String getUnit_uid() {
		return unit_uid;
	}

	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}

	public String getDepart_uid() {
		return depart_uid;
	}

	public void setDepart_uid(String depart_uid) {
		this.depart_uid = depart_uid;
	}

	public String getPbusisortid() {
		return pbusisortid;
	}

	public void setPbusisortid(String pbusisortid) {
		this.pbusisortid = pbusisortid;
	}

	public String getPbanksortid() {
		return pbanksortid;
	}

	public void setPbanksortid(String pbanksortid) {
		this.pbanksortid = pbanksortid;
	}

	public String getPmultilevelsortid() {
		return pmultilevelsortid;
	}

	public void setPmultilevelsortid(String pmultilevelsortid) {
		this.pmultilevelsortid = pmultilevelsortid;
	}

	public String getClientTypeID() {
		return clientTypeID;
	}

	public void setClientTypeID(String clientTypeID) {
		this.clientTypeID = clientTypeID;
	}

	public String getClient_ID() {
		return client_ID;
	}

	public void setClient_ID(String client_ID) {
		this.client_ID = client_ID;
	}

	public String getPost_ID() {
		return post_ID;
	}

	public void setPost_ID(String post_ID) {
		this.post_ID = post_ID;
	}

	public String getLogindatetime() {
		return logindatetime;
	}

	public void setLogindatetime(String logindatetime) {
		this.logindatetime = logindatetime;
	}

	public String getOperatordatetime() {
		return operatordatetime;
	}

	public void setOperatordatetime(String operatordatetime) {
		this.operatordatetime = operatordatetime;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getFullAreaName() {
		return fullAreaName;
	}

	public void setFullAreaName(String fullAreaName) {
		this.fullAreaName = fullAreaName;
	}

	public String getFullTradeName() {
		return fullTradeName;
	}

	public void setFullTradeName(String fullTradeName) {
		this.fullTradeName = fullTradeName;
	}

	public String getNatureID() {
		return natureID;
	}

	public void setNatureID(String natureID) {
		this.natureID = natureID;
	}

	public String getCurrencyID() {
		return currencyID;
	}

	public void setCurrencyID(String currencyID) {
		this.currencyID = currencyID;
	}


	public String getClientSourceID() {
		return clientSourceID;
	}

	public void setClientSourceID(String clientSourceID) {
		this.clientSourceID = clientSourceID;
	}

	public String getControlPerson() {
		return controlPerson;
	}

	public void setControlPerson(String controlPerson) {
		this.controlPerson = controlPerson;
	}


	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getFullDepartName() {
		return fullDepartName;
	}

	public void setFullDepartName(String fullDepartName) {
		this.fullDepartName = fullDepartName;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getUnit_uidName() {
		return unit_uidName;
	}

	public void setUnit_uidName(String unit_uidName) {
		this.unit_uidName = unit_uidName;
	}

	public Double getRegisterSumStart() {
		return registerSumStart;
	}

	public void setRegisterSumStart(Double registerSumStart) {
		this.registerSumStart = registerSumStart;
	}

	public Double getRegisterSumEnd() {
		return registerSumEnd;
	}

	public void setRegisterSumEnd(Double registerSumEnd) {
		this.registerSumEnd = registerSumEnd;
	}

	public Date getCreateDateStart() {
		return createDateStart;
	}

	public void setCreateDateStart(Date createDateStart) {
		this.createDateStart = createDateStart;
	}

	public Date getCreateDateEnd() {
		return createDateEnd;
	}

	public void setCreateDateEnd(Date createDateEnd) {
		this.createDateEnd = createDateEnd;
	}

	public Date getCreateDateTimeStart() {
		return createDateTimeStart;
	}

	public void setCreateDateTimeStart(Date createDateTimeStart) {
		this.createDateTimeStart = createDateTimeStart;
	}

	public Date getCreateDateTimeEnd() {
		return createDateTimeEnd;
	}

	public void setCreateDateTimeEnd(Date createDateTimeEnd) {
		this.createDateTimeEnd = createDateTimeEnd;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonNum() {
		return personNum;
	}

	public void setPersonNum(String personNum) {
		this.personNum = personNum;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBusiTypeID() {
		return busiTypeID;
	}

	public void setBusiTypeID(String busiTypeID) {
		this.busiTypeID = busiTypeID;
	}

	public String getCooperationID() {
		return cooperationID;
	}

	public void setCooperationID(String cooperationID) {
		this.cooperationID = cooperationID;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Double getApplySumLow() {
		return applySumLow;
	}

	public void setApplySumLow(Double applySumLow) {
		this.applySumLow = applySumLow;
	}

	public Double getApplySumHigh() {
		return applySumHigh;
	}

	public void setApplySumHigh(Double applySumHigh) {
		this.applySumHigh = applySumHigh;
	}
	public Integer getPeriodMonthLow() {
		return periodMonthLow;
	}
	public void setPeriodMonthLow(Integer periodMonthLow) {
		this.periodMonthLow = periodMonthLow;
	}
	public Integer getPeriodMonthHigh() {
		return periodMonthHigh;
	}
	public void setPeriodMonthHigh(Integer periodMonthHigh) {
		this.periodMonthHigh = periodMonthHigh;
	}
	public String getReceiveDeapartID() {
		return receiveDeapartID;
	}

	public void setReceiveDeapartID(String receiveDeapartID) {
		this.receiveDeapartID = receiveDeapartID;
	}

	public String getReceiveUserID() {
		return receiveUserID;
	}

	public void setReceiveUserID(String receiveUserID) {
		this.receiveUserID = receiveUserID;
	}

	public Date getReceiveDateLow() {
		return receiveDateLow;
	}

	public void setReceiveDateLow(Date receiveDateLow) {
		this.receiveDateLow = receiveDateLow;
	}

	public Date getReceiveDateHigh() {
		return receiveDateHigh;
	}

	public void setReceiveDateHigh(Date receiveDateHigh) {
		this.receiveDateHigh = receiveDateHigh;
	}

	public String getCertificateCode() {
		return certificateCode;
	}

	public void setCertificateCode(String certificateCode) {
		this.certificateCode = certificateCode;
	}

	public String getQueryType() {
		return queryType;
	}
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	public String getQueryContent() {
		return queryContent;
	}
	public void setQueryContent(String queryContent) {
		this.queryContent = queryContent;
	}

	public String getBanksortid() {
		return banksortid;
	}
	public void setBanksortid(String banksortid) {
		this.banksortid = banksortid;
	}

	public String getBusisortid() {
		return busisortid;
	}
	public void setBusisortid(String busisortid) {
		this.busisortid = busisortid;
	}
	public String getMultilevelsortid() {
		return multilevelsortid;
	}
	public void setMultilevelsortid(String multilevelsortid) {
		this.multilevelsortid = multilevelsortid;
	}
	public String getPunit_uid() {
		return punit_uid;
	}
	public void setPunit_uid(String punit_uid) {
		this.punit_uid = punit_uid;
	}
	public String getParentPostID() {
		return parentPostID;
	}
	public void setParentPostID(String parentPostID) {
		this.parentPostID = parentPostID;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getBusiTypeNameList() {
		return busiTypeNameList;
	}
	public void setBusiTypeNameList(String busiTypeNameList) {
		this.busiTypeNameList = busiTypeNameList;
	}
	public String getBankNameList() {
		return bankNameList;
	}
	public void setBankNameList(String bankNameList) {
		this.bankNameList = bankNameList;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public String getCreateManName() {
		return createManName;
	}
	public void setCreateManName(String createManName) {
		this.createManName = createManName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getBusiTypeName() {
		return busiTypeName;
	}
	public void setBusiTypeName(String busiTypeName) {
		this.busiTypeName = busiTypeName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getMessageTypeId() {
		return messageTypeId;
	}
	public void setMessageTypeId(String messageTypeId) {
		this.messageTypeId = messageTypeId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getParentApply_ID() {
		return parentApply_ID;
	}
	public void setParentApply_ID(String parentApply_ID) {
		this.parentApply_ID = parentApply_ID;
	}
	public String getPactSortID() {
		return pactSortID;
	}
	public void setPactSortID(String pactSortID) {
		this.pactSortID = pactSortID;
	}
	public String getActSortName() {
		return actSortName;
	}
	public void setActSortName(String actSortName) {
		this.actSortName = actSortName;
	}
	public String getActSortID() {
		return actSortID;
	}
	public void setActSortID(String actSortID) {
		this.actSortID = actSortID;
	}
	public String getBusiCode() {
		return busiCode;
	}
	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}
	public String getCreditTypeID() {
		return creditTypeID;
	}
	public void setCreditTypeID(String creditTypeID) {
		this.creditTypeID = creditTypeID;
	}
	public Date getCreditBeginDateLow() {
		return creditBeginDateLow;
	}
	public void setCreditBeginDateLow(Date creditBeginDateLow) {
		this.creditBeginDateLow = creditBeginDateLow;
	}
	public Date getCreditBeginDateHigh() {
		return creditBeginDateHigh;
	}
	public void setCreditBeginDateHigh(Date creditBeginDateHigh) {
		this.creditBeginDateHigh = creditBeginDateHigh;
	}
	public Date getCreditEndDateLow() {
		return creditEndDateLow;
	}
	public void setCreditEndDateLow(Date creditEndDateLow) {
		this.creditEndDateLow = creditEndDateLow;
	}
	public Date getCreditEndDateHigh() {
		return creditEndDateHigh;
	}
	public void setCreditEndDateHigh(Date creditEndDateHigh) {
		this.creditEndDateHigh = creditEndDateHigh;
	}
	public Double getUsedSumLow() {
		return usedSumLow;
	}
	public void setUsedSumLow(Double usedSumLow) {
		this.usedSumLow = usedSumLow;
	}
	public Double getUsedSumHigh() {
		return usedSumHigh;
	}
	public void setUsedSumHigh(Double usedSumHigh) {
		this.usedSumHigh = usedSumHigh;
	}
	public Double getUsableSumLow() {
		return usableSumLow;
	}
	public void setUsableSumLow(Double usableSumLow) {
		this.usableSumLow = usableSumLow;
	}
	public Double getUsableSumHigh() {
		return usableSumHigh;
	}
	public void setUsableSumHigh(Double usableSumHigh) {
		this.usableSumHigh = usableSumHigh;
	}
	public Double getAgreeSumLow() {
		return agreeSumLow;
	}
	public void setAgreeSumLow(Double agreeSumLow) {
		this.agreeSumLow = agreeSumLow;
	}
	public Double getAgreeSumHigh() {
		return agreeSumHigh;
	}
	public void setAgreeSumHigh(Double agreeSumHigh) {
		this.agreeSumHigh = agreeSumHigh;
	}
	public String getGuarantyTypeID() {
		return guarantyTypeID;
	}
	public void setGuarantyTypeID(String guarantyTypeID) {
		this.guarantyTypeID = guarantyTypeID;
	}
	public String getUpdateUserName() {
		return updateUserName;
	}
	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
	public Integer getIsWorkable() {
		return isWorkable;
	}
	public void setIsWorkable(Integer isWorkable) {
		this.isWorkable = isWorkable;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOptTypeID() {
		return optTypeID;
	}
	public void setOptTypeID(String optTypeID) {
		this.optTypeID = optTypeID;
	}
	public Integer getIsFree() {
		return isFree;
	}
	public void setIsFree(Integer isFree) {
		this.isFree = isFree;
	}
	public Integer getIsDispose() {
		return isDispose;
	}
	public void setIsDispose(Integer isDispose) {
		this.isDispose = isDispose;
	}
	public String getDisposeBeginDate() {
		return disposeBeginDate;
	}
	public void setDisposeBeginDate(String disposeBeginDate) {
		this.disposeBeginDate = disposeBeginDate;
	}
	public String getDisposeEndDate() {
		return disposeEndDate;
	}
	public void setDisposeEndDate(String disposeEndDate) {
		this.disposeEndDate = disposeEndDate;
	}
	public String getFreeBeginDate() {
		return freeBeginDate;
	}
	public void setFreeBeginDate(String freeBeginDate) {
		this.freeBeginDate = freeBeginDate;
	}
	public String getFreeEndDate() {
		return freeEndDate;
	}
	public void setFreeEndDate(String freeEndDate) {
		this.freeEndDate = freeEndDate;
	}
	public String getFreeUserID() {
		return freeUserID;
	}
	public void setFreeUserID(String freeUserID) {
		this.freeUserID = freeUserID;
	}
	public String getDisposeUserId() {
		return disposeUserId;
	}
	public void setDisposeUserId(String disposeUserId) {
		this.disposeUserId = disposeUserId;
	}

	public String getPmod_id() {
		return pmod_id;
	}
	public void setPmod_id(String pmod_id) {
		this.pmod_id = pmod_id;
	}

	public String getEntityID() {
		return entityID;
	}
	public void setEntityID(String entityID) {
		this.entityID = entityID;
	}
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public String getApply_ID() {
		return apply_ID;
	}
	public void setApply_ID(String apply_ID) {
		this.apply_ID = apply_ID;
	}
	public String getApplyDetail_ID() {
		return applyDetail_ID;
	}
	public void setApplyDetail_ID(String applyDetail_ID) {
		this.applyDetail_ID = applyDetail_ID;
	}
	public String getProductNodeID() {
		return productNodeID;
	}
	public void setProductNodeID(String productNodeID) {
		this.productNodeID = productNodeID;
	}

	public String getChoose() {
		return choose;
	}
	public void setChoose(String choose) {
		this.choose = choose;
	}

	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getBorndate() {
		return borndate;
	}
	public void setBorndate(String borndate) {
		this.borndate = borndate;
	}
	public String getContractEndDate() {
		return contractEndDate;
	}
	public void setContractEndDate(String contractEndDate) {
		this.contractEndDate = contractEndDate;
	}
	public String getProductInstance_ID() {
		return productInstance_ID;
	}
	public void setProductInstance_ID(String productInstance_ID) {
		this.productInstance_ID = productInstance_ID;
	}
	public Long getNodeSort() {
		return nodeSort;
	}
	public void setNodeSort(Long nodeSort) {
		this.nodeSort = nodeSort;
	}
	public String getTaskType_ID() {
		return taskType_ID;
	}
	public void setTaskType_ID(String taskType_ID) {
		this.taskType_ID = taskType_ID;
	}
	public String getDocumentCode() {
		return documentCode;
	}
	public void setDocumentCode(String documentCode) {
		this.documentCode = documentCode;
	}

	public String getMessageTypePID() {
		return messageTypePID;
	}
	public void setMessageTypePID(String messageTypePID) {
		this.messageTypePID = messageTypePID;
	}
	public String getTaskID() {
		return taskID;
	}
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}

	public Boolean getIsUsed() {
		return IsUsed;
	}
	public void setIsUsed(Boolean isUsed) {
		IsUsed = isUsed;
	}
	public String getProject_ID() {
		return project_ID;
	}
	public void setProject_ID(String project_ID) {
		this.project_ID = project_ID;
	}
	public String getOptGuaranty_ID() {
		return optGuaranty_ID;
	}
	public void setOptGuaranty_ID(String optGuaranty_ID) {
		this.optGuaranty_ID = optGuaranty_ID;
	}
	public String getFlowID() {
		return flowID;
	}
	public void setFlowID(String flowID) {
		this.flowID = flowID;
	}
	public String getStepID() {
		return stepID;
	}
	public void setStepID(String stepID) {
		this.stepID = stepID;
	}
	public String getClientGUID() {
		return clientGUID;
	}
	public void setClientGUID(String clientGUID) {
		this.clientGUID = clientGUID;
	}
	public String getLoadSumStart() {
		return loadSumStart;
	}
	public void setLoadSumStart(String loadSumStart) {
		this.loadSumStart = loadSumStart;
	}
	public String getLoadSumEnd() {
		return loadSumEnd;
	}
	public void setLoadSumEnd(String loadSumEnd) {
		this.loadSumEnd = loadSumEnd;
	}
	public Date getDelayBeginDateStart() {
		return delayBeginDateStart;
	}
	public void setDelayBeginDateStart(Date delayBeginDateStart) {
		this.delayBeginDateStart = delayBeginDateStart;
	}
	public Date getDelayBeginDateEnd() {
		return delayBeginDateEnd;
	}
	public void setDelayBeginDateEnd(Date delayBeginDateEnd) {
		this.delayBeginDateEnd = delayBeginDateEnd;
	}
	public Date getDelayEndDateStart() {
		return delayEndDateStart;
	}
	public void setDelayEndDateStart(Date delayEndDateStart) {
		this.delayEndDateStart = delayEndDateStart;
	}
	public Date getDelayEndDateEnd() {
		return delayEndDateEnd;
	}
	public void setDelayEndDateEnd(Date delayEndDateEnd) {
		this.delayEndDateEnd = delayEndDateEnd;
	}
	public String getLoanPlan_ID() {
		return loanPlan_ID;
	}
	public void setLoanPlan_ID(String loanPlan_ID) {
		this.loanPlan_ID = loanPlan_ID;
	}
	public String getMaterialTree_ID() {
		return materialTree_ID;
	}
	public void setMaterialTree_ID(String materialTree_ID) {
		this.materialTree_ID = materialTree_ID;
	}
	public String getMaterialModel_ID() {
		return materialModel_ID;
	}
	public void setMaterialModel_ID(String materialModel_ID) {
		this.materialModel_ID = materialModel_ID;
	}
	public String getUser_uid() {
		return user_uid;
	}
	public void setUser_uid(String user_uid) {
		this.user_uid = user_uid;
	}
	public String getBusiClass() {
		return busiClass;
	}
	public void setBusiClass(String busiClass) {
		this.busiClass = busiClass;
	}
	public String getContractIDstr() {
		return contractIDstr;
	}
	public void setContractIDstr(String contractIDstr) {
		this.contractIDstr = contractIDstr;
	}
	public Integer getIsMove() {
		return isMove;
	}
	public void setIsMove(Integer isMove) {
		this.isMove = isMove;
	}
	public String getArcMoveRec_ID() {
		return arcMoveRec_ID;
	}
	public void setArcMoveRec_ID(String arcMoveRec_ID) {
		this.arcMoveRec_ID = arcMoveRec_ID;
	}
	public String getRelationMain_ID() {
		return relationMain_ID;
	}
	public void setRelationMain_ID(String relationMain_ID) {
		this.relationMain_ID = relationMain_ID;
	}
	public Date getFinishBeginDate() {
		return finishBeginDate;
	}
	public void setFinishBeginDate(Date finishBeginDate) {
		this.finishBeginDate = finishBeginDate;
	}
	public Date getFinishEndDate() {
		return finishEndDate;
	}
	public void setFinishEndDate(Date finishEndDate) {
		this.finishEndDate = finishEndDate;
	}
	public String getReviewType() {
		return reviewType;
	}
	public void setReviewType(String reviewType) {
		this.reviewType = reviewType;
	}
	public String getSubBankName() {
		return subBankName;
	}
	public void setSubBankName(String subBankName) {
		this.subBankName = subBankName;
	}
	public String getDelaySumStart() {
		return delaySumStart;
	}
	public void setDelaySumStart(String delaySumStart) {
		this.delaySumStart = delaySumStart;
	}
	public String getDelaySumEnd() {
		return delaySumEnd;
	}
	public void setDelaySumEnd(String delaySumEnd) {
		this.delaySumEnd = delaySumEnd;
	}
	public String getReturnSumStart() {
		return returnSumStart;
	}
	public void setReturnSumStart(String returnSumStart) {
		this.returnSumStart = returnSumStart;
	}
	public String getReturnSumEnd() {
		return returnSumEnd;
	}
	public void setReturnSumEnd(String returnSumEnd) {
		this.returnSumEnd = returnSumEnd;
	}
	public String getReplaceFreeSumStart() {
		return replaceFreeSumStart;
	}
	public void setReplaceFreeSumStart(String replaceFreeSumStart) {
		this.replaceFreeSumStart = replaceFreeSumStart;
	}
	public String getReplaceFreeSumEnd() {
		return replaceFreeSumEnd;
	}
	public void setReplaceFreeSumEnd(String replaceFreeSumEnd) {
		this.replaceFreeSumEnd = replaceFreeSumEnd;
	}
	public String getIsCreditor() {
		return isCreditor;
	}
	public void setIsCreditor(String isCreditor) {
		this.isCreditor = isCreditor;
	}
	public String getCreditorCountStart() {
		return creditorCountStart;
	}
	public void setCreditorCountStart(String creditorCountStart) {
		this.creditorCountStart = creditorCountStart;
	}
	public String getCreditorCountEnd() {
		return creditorCountEnd;
	}
	public void setCreditorCountEnd(String creditorCountEnd) {
		this.creditorCountEnd = creditorCountEnd;
	}
	public String getFundSource() {
		return fundSource;
	}
	public void setFundSource(String fundSource) {
		this.fundSource = fundSource;
	}
	public String getGuarantySumStart() {
		return guarantySumStart;
	}
	public void setGuarantySumStart(String guarantySumStart) {
		this.guarantySumStart = guarantySumStart;
	}
	public String getGuarantySumEnd() {
		return guarantySumEnd;
	}
	public void setGuarantySumEnd(String guarantySumEnd) {
		this.guarantySumEnd = guarantySumEnd;
	}
	public String getPeriodMonthStart() {
		return periodMonthStart;
	}
	public void setPeriodMonthStart(String periodMonthStart) {
		this.periodMonthStart = periodMonthStart;
	}
	public String getPeriodMonthEnd() {
		return periodMonthEnd;
	}
	public void setPeriodMonthEnd(String periodMonthEnd) {
		this.periodMonthEnd = periodMonthEnd;
	}
	public String getPeriodDayStart() {
		return periodDayStart;
	}
	public void setPeriodDayStart(String periodDayStart) {
		this.periodDayStart = periodDayStart;
	}
	public String getPeriodDayEnd() {
		return periodDayEnd;
	}
	public void setPeriodDayEnd(String periodDayEnd) {
		this.periodDayEnd = periodDayEnd;
	}
	public String getCreditorSumStart() {
		return creditorSumStart;
	}
	public void setCreditorSumStart(String creditorSumStart) {
		this.creditorSumStart = creditorSumStart;
	}
	public String getCreditorSumEnd() {
		return creditorSumEnd;
	}
	public void setCreditorSumEnd(String creditorSumEnd) {
		this.creditorSumEnd = creditorSumEnd;
	}
	public String getNormalFreeSumStart() {
		return normalFreeSumStart;
	}
	public void setNormalFreeSumStart(String normalFreeSumStart) {
		this.normalFreeSumStart = normalFreeSumStart;
	}
	public String getNormalFreeSumEnd() {
		return normalFreeSumEnd;
	}
	public void setNormalFreeSumEnd(String normalFreeSumEnd) {
		this.normalFreeSumEnd = normalFreeSumEnd;
	}
	public Date getPayDateStart() {
		return payDateStart;
	}
	public void setPayDateStart(Date payDateStart) {
		this.payDateStart = payDateStart;
	}
	public Date getPayDateEnd() {
		return payDateEnd;
	}
	public void setPayDateEnd(Date payDateEnd) {
		this.payDateEnd = payDateEnd;
	}
	public Date getReturnDateStart() {
		return returnDateStart;
	}
	public void setReturnDateStart(Date returnDateStart) {
		this.returnDateStart = returnDateStart;
	}
	public Date getReturnDateEnd() {
		return returnDateEnd;
	}
	public void setReturnDateEnd(Date returnDateEnd) {
		this.returnDateEnd = returnDateEnd;
	}
	public Date getCreditorDateStart() {
		return creditorDateStart;
	}
	public void setCreditorDateStart(Date creditorDateStart) {
		this.creditorDateStart = creditorDateStart;
	}
	public Date getCreditorDateEnd() {
		return creditorDateEnd;
	}
	public void setCreditorDateEnd(Date creditorDateEnd) {
		this.creditorDateEnd = creditorDateEnd;
	}
	public String getIsCreditorMark() {
		return isCreditorMark;
	}
	public void setIsCreditorMark(String isCreditorMark) {
		this.isCreditorMark = isCreditorMark;
	}
	public String getGuarantyOrgID() {
		return guarantyOrgID;
	}
	public void setGuarantyOrgID(String guarantyOrgID) {
		this.guarantyOrgID = guarantyOrgID;
	}
	public String getAttributionsID() {
		return attributionsID;
	}
	public void setAttributionsID(String attributionsID) {
		this.attributionsID = attributionsID;
	}
	public String getHostAreasID() {
		return hostAreasID;
	}
	public void setHostAreasID(String hostAreasID) {
		this.hostAreasID = hostAreasID;
	}
	public String getRiskLevelID() {
		return riskLevelID;
	}
	public void setRiskLevelID(String riskLevelID) {
		this.riskLevelID = riskLevelID;
	}
	public String getOprationCompanysID() {
		return oprationCompanysID;
	}
	public void setOprationCompanysID(String oprationCompanysID) {
		this.oprationCompanysID = oprationCompanysID;
	}
	public String getCreditor() {
		return creditor;
	}
	public void setCreditor(String creditor) {
		this.creditor = creditor;
	}
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public String getFundTypesName() {
		return fundTypesName;
	}
	public void setFundTypesName(String fundTypesName) {
		this.fundTypesName = fundTypesName;
	}
	public Date getLoanDateStart() {
		return loanDateStart;
	}
	public void setLoanDateStart(Date loanDateStart) {
		this.loanDateStart = loanDateStart;
	}
	public Date getLoanDateEnd() {
		return loanDateEnd;
	}
	public void setLoanDateEnd(Date loanDateEnd) {
		this.loanDateEnd = loanDateEnd;
	}
	public String getRelationClient() {
		return relationClient;
	}
	public void setRelationClient(String relationClient) {
		this.relationClient = relationClient;
	}
	public String getLawSuitType() {
		return lawSuitType;
	}
	public void setLawSuitType(String lawSuitType) {
		this.lawSuitType = lawSuitType;
	}
	public String getAssetSealUpType() {
		return assetSealUpType;
	}
	public void setAssetSealUpType(String assetSealUpType) {
		this.assetSealUpType = assetSealUpType;
	}
	public String getObligorType() {
		return obligorType;
	}
	public void setObligorType(String obligorType) {
		this.obligorType = obligorType;
	}
	public String getExecutecaseType() {
		return executecaseType;
	}
	public void setExecutecaseType(String executecaseType) {
		this.executecaseType = executecaseType;
	}


	
	//=====================get/set=========================
}