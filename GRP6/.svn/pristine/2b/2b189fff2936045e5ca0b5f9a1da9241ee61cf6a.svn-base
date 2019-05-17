package com.zjm.crm.db.model;

import java.io.Serializable;
import java.util.Date;

public class Client implements Serializable{
	
	/**
	 * 客户主表
	 */
	private static final long serialVersionUID = 1L;
	
	private String   client_ID;//客户ID
	private String   clientGUID;//客户唯一标识
	private String   clientBH;//客户编号
	private String 	 clientName;//客户名称
	private String   clientTypeID;// 客户类型ID    '01企业02个人经营类03个人消费类（不做字典，直接写在程序中）'
	private String   clientTypeName;//客户类型名称
	private String   fullAreaCode;//所属区域完整代码
	private String   fullAreaName;//所属区域名称
	private String   fullTradeCode;//行业类别完整代码
	private String   fullTradeName;//行业类别名称
	private String   enterpriseTypeID;//企业类型ID    comment '参考普通字典表',
	private String   enterpriseTypeName;//企业类型名称
	private String   certificateCode;//统一社会信用代码
	private String   fullRegisteCode;//注册地完整代码
	private String   fullRegisteName;//注册地名称
	private String   registeAddress;//注册详细地址
	private String   workAddress;//经营实体所在地
	private String   zipCode;//邮编
	private String   legalPerson;//法定代表人
	private String   legalCertificate;//法定代表人证件类型中文名称
	private String   legalPersonNum;//法定代表人证件号码
	private String   controlPerson;//实际控制人
	private String   controlPersonPhone;//实际控制人
	private String   controlCertificate;//实际控制人证件类型中文名称
	private String   controlPersonNum;//实际控制人证件号码
	private Double   registerSum;//注册资本.万
	private String   currencyID;//币种代码
	private String   currencyName;//币种名称
	private String  natureID;//企业性质ID
	private String  natureName;//企业性质名称
	private Date   createDate;//成立日期
	private String  busiTerm;//营业期限
	private String   industryCommerceOrg;//工商登记机关
	private String   loanCode;//贷款卡（证）号码
	private String   busiScope;//经营范围
	private String   leadBusi;//主营业务
	private String  nationalTaxOrg;//国税登记机关
	private String   landTaxOrg;//地税登记机关
	private String   businessLicence;//营业执照号码
	private String   organizationCode;//组织机构代码证号
	private String   taxCode;//税务登记证号
	private Integer   employeeSum;//员工人数
	private Double   factSum;//实收资本
	private Double   capitalSum;//总资产
	private Integer   lastYear;//上年
	private Double   lastYearSale;//上年销售收入
	private Double   lastYearSaleProfit;//上年销售利润
	private Double   lastYearProfit;//上年净利润
	private Float   selfArea;//有证土地.亩
	private Float   rentalArea;//租赁土地.亩
	private Float   selfWorkShop;//有证厂房.平方米
	private Float   rentalWorkShop;//租赁厂房.平方米
	private Integer   isHighTechnology;//是否高新技术企业
	private String   highTechnologyCode;//高新技术企业证号
	private Date   highTechnologyDate;//高新技术认定日期
	private String  contactOne;//联系人1
	private String   positionOneName;//职位1
	private String   phoneOne;//联系方式1
	private String   contactTwo;//联系人2
	private String   positionTwoName;//职位名称2
	private String   phoneTwo;//联系方式2
	private String   remark;//备注
	private String   clientSourceID;//客户来源ID
	private String   clientSourceName;//客户来源名称
	private String   clientSourceDesc;//来源说明
	private String   personName;//申请人名称
	private String   personNum;//身份证号
	private String   sex;//性别
	private Integer   age;//年龄
	private String   maritalStatus;//婚姻状况
	private String   domicile;//户口所在地
	private Integer   familyNum;//家庭人数
	private Integer   workNum;//就业人数
	private String   incomeSource;//家庭收入主要来源
	private String   education;//教育程度
	private String   workUnit;//工作单位
	private String   position;//职务
	private String   unitAddress;//单位地址
	private Float   monthIncome;//税后月收入.元
	private String   unitPost;//单位邮编
	private String   unitPhone;//单位电话
	private String   houseNature;//现住房性质
	private Float  houseArea;//住房面积
	private String   houseAddress;//现住址
	private String   housePost;//住址邮编
	private String   phone;//联系方式
	private String   houseTel;//住宅电话
	private String	 otherAssets;//其它家庭财产
	private Boolean   isClient;//是否担保（委贷）客户
	private Boolean   isRelation;//是否关联客户
	private Integer   isOptGaranty;//是否反担保客户
	private Boolean   isBadClient;//是否黑名单
	private String   creditLevelID;//资信等级ID
	private String   creditLevel;//资信等级名称
	private String   unit_uid;//担保机构ID
	private String   unit_uidName;//担保机构名称
	private String   fullDepartCode;//创建部门完整代码
	private String   createUserID;//创建人ID
	private Date createDateTime;//创建时间
	private Boolean   isMainVersion;//是否是主版本
	private String   updateUserName;//最后修改人姓名
	private Date  updateDateTime;//最后修改时间
	private String fullDepartName;//创建部门名称
	private String createUserName;//创建人名称
	private String relationMainName;//企业所属的关联主体名称--2017/9/12 xuyz
	
	private String relationQueryDesc;//关联查询结果说明
	
	private String  fax; // 传真 
	private String riskLevelID;//风险等级ID
	private String riskLevelName;//风险等级名称
	private String riskLevelDesc;//风险等级说明
	private String gzwRiskLevel ; //国资委风险等级
	
	private Double timePointSum ; //最高时点金额(担保)
	private Double liabilitySum;   //负债总额
	
	
	
	private Double creditorGuarSum;   //敏感债权人在保金额
	private Double timePointEntrustSum;   //最高时点金额(委贷)
	private String oldDivisionID;   //2015年分类处置划分ID（字典）
	private String oldDivisionName;   //2015年分类处置划分名称
	private String divisionID;   //分类处置划分ID
	private String divisionName;   //分类处置划分名称
	
	private String oldClientName; //冗余字段 客户曾用名
	
	public String getControlPersonPhone() {
		return controlPersonPhone;
	}
	public void setControlPersonPhone(String controlPersonPhone) {
		this.controlPersonPhone = controlPersonPhone;
	}
	public String getClientGUID() {
		return clientGUID;
	}
	public void setClientGUID(String clientGUID) {
		this.clientGUID = clientGUID;
	}
	public String getClientBH() {
		return clientBH;
	}
	public void setClientBH(String clientBH) {
		this.clientBH = clientBH;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientTypeID() {
		return clientTypeID;
	}
	public void setClientTypeID(String clientTypeID) {
		this.clientTypeID = clientTypeID;
	}
	public String getClientTypeName() {
		return clientTypeName;
	}
	public void setClientTypeName(String clientTypeName) {
		this.clientTypeName = clientTypeName;
	}
	public String getFullAreaCode() {
		return fullAreaCode;
	}
	public void setFullAreaCode(String fullAreaCode) {
		this.fullAreaCode = fullAreaCode;
	}
	public String getFullAreaName() {
		return fullAreaName;
	}
	public void setFullAreaName(String fullAreaName) {
		this.fullAreaName = fullAreaName;
	}
	public String getFullTradeCode() {
		return fullTradeCode;
	}
	public void setFullTradeCode(String fullTradeCode) {
		this.fullTradeCode = fullTradeCode;
	}
	public String getFullTradeName() {
		return fullTradeName;
	}
	public void setFullTradeName(String fullTradeName) {
		this.fullTradeName = fullTradeName;
	}
	public String getEnterpriseTypeID() {
		return enterpriseTypeID;
	}
	public void setEnterpriseTypeID(String enterpriseTypeID) {
		this.enterpriseTypeID = enterpriseTypeID;
	}
	public String getEnterpriseTypeName() {
		return enterpriseTypeName;
	}
	public void setEnterpriseTypeName(String enterpriseTypeName) {
		this.enterpriseTypeName = enterpriseTypeName;
	}
	public String getCertificateCode() {
		return certificateCode;
	}
	public void setCertificateCode(String certificateCode) {
		this.certificateCode = certificateCode;
	}
	public String getFullRegisteCode() {
		return fullRegisteCode;
	}
	public void setFullRegisteCode(String fullRegisteCode) {
		this.fullRegisteCode = fullRegisteCode;
	}
	public String getFullRegisteName() {
		return fullRegisteName;
	}
	public void setFullRegisteName(String fullRegisteName) {
		this.fullRegisteName = fullRegisteName;
	}
	public String getRegisteAddress() {
		return registeAddress;
	}
	public void setRegisteAddress(String registeAddress) {
		this.registeAddress = registeAddress;
	}
	public String getWorkAddress() {
		return workAddress;
	}
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getLegalPerson() {
		return legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	public String getLegalCertificate() {
		return legalCertificate;
	}
	public void setLegalCertificate(String legalCertificate) {
		this.legalCertificate = legalCertificate;
	}
	public String getLegalPersonNum() {
		return legalPersonNum;
	}
	public void setLegalPersonNum(String legalPersonNum) {
		this.legalPersonNum = legalPersonNum;
	}
	public String getControlPerson() {
		return controlPerson;
	}
	public void setControlPerson(String controlPerson) {
		this.controlPerson = controlPerson;
	}
	public String getControlCertificate() {
		return controlCertificate;
	}
	public void setControlCertificate(String controlCertificate) {
		this.controlCertificate = controlCertificate;
	}
	public String getControlPersonNum() {
		return controlPersonNum;
	}
	public void setControlPersonNum(String controlPersonNum) {
		this.controlPersonNum = controlPersonNum;
	}
	public Double getRegisterSum() {
		return registerSum;
	}
	public void setRegisterSum(Double registerSum) {
		this.registerSum = registerSum;
	}
	public String getCurrencyID() {
		return currencyID;
	}
	public void setCurrencyID(String currencyID) {
		this.currencyID = currencyID;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public String getNatureID() {
		return natureID;
	}
	public void setNatureID(String natureID) {
		this.natureID = natureID;
	}
	public String getNatureName() {
		return natureName;
	}
	public void setNatureName(String natureName) {
		this.natureName = natureName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getBusiTerm() {
		return busiTerm;
	}
	public void setBusiTerm(String busiTerm) {
		this.busiTerm = busiTerm;
	}
	public String getIndustryCommerceOrg() {
		return industryCommerceOrg;
	}
	public String getCreateUserID() {
		return createUserID;
	}
	public void setCreateUserID(String createUserID) {
		this.createUserID = createUserID;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	public void setIndustryCommerceOrg(String industryCommerceOrg) {
		this.industryCommerceOrg = industryCommerceOrg;
	}
	public String getLoanCode() {
		return loanCode;
	}
	public void setLoanCode(String loanCode) {
		this.loanCode = loanCode;
	}
	public String getBusiScope() {
		return busiScope;
	}
	public void setBusiScope(String busiScope) {
		this.busiScope = busiScope;
	}
	public String getLeadBusi() {
		return leadBusi;
	}
	public void setLeadBusi(String leadBusi) {
		this.leadBusi = leadBusi;
	}
	public String getNationalTaxOrg() {
		return nationalTaxOrg;
	}
	public void setNationalTaxOrg(String nationalTaxOrg) {
		this.nationalTaxOrg = nationalTaxOrg;
	}
	public String getLandTaxOrg() {
		return landTaxOrg;
	}
	public void setLandTaxOrg(String landTaxOrg) {
		this.landTaxOrg = landTaxOrg;
	}
	public String getBusinessLicence() {
		return businessLicence;
	}
	public void setBusinessLicence(String businessLicence) {
		this.businessLicence = businessLicence;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public String getTaxCode() {
		return taxCode;
	}
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	public Integer getEmployeeSum() {
		return employeeSum;
	}
	public void setEmployeeSum(Integer employeeSum) {
		this.employeeSum = employeeSum;
	}
	public Double getFactSum() {
		return factSum;
	}
	public void setFactSum(Double factSum) {
		this.factSum = factSum;
	}
	public Double getCapitalSum() {
		return capitalSum;
	}
	public void setCapitalSum(Double capitalSum) {
		this.capitalSum = capitalSum;
	}
	public Integer getLastYear() {
		return lastYear;
	}
	public void setLastYear(Integer lastYear) {
		this.lastYear = lastYear;
	}
	public Double getLastYearSale() {
		return lastYearSale;
	}
	public void setLastYearSale(Double lastYearSale) {
		this.lastYearSale = lastYearSale;
	}
	public Double getLastYearSaleProfit() {
		return lastYearSaleProfit;
	}
	public void setLastYearSaleProfit(Double lastYearSaleProfit) {
		this.lastYearSaleProfit = lastYearSaleProfit;
	}
	public Double getLastYearProfit() {
		return lastYearProfit;
	}
	public void setLastYearProfit(Double lastYearProfit) {
		this.lastYearProfit = lastYearProfit;
	}
	public Float getSelfArea() {
		return selfArea;
	}
	public void setSelfArea(Float selfArea) {
		this.selfArea = selfArea;
	}
	public Float getRentalArea() {
		return rentalArea;
	}
	public void setRentalArea(Float rentalArea) {
		this.rentalArea = rentalArea;
	}
	public Float getSelfWorkShop() {
		return selfWorkShop;
	}
	public void setSelfWorkShop(Float selfWorkShop) {
		this.selfWorkShop = selfWorkShop;
	}
	public Float getRentalWorkShop() {
		return rentalWorkShop;
	}
	public void setRentalWorkShop(Float rentalWorkShop) {
		
		this.rentalWorkShop = rentalWorkShop;
	}
	
	public Integer getIsHighTechnology() {
		return isHighTechnology;
	}
	public void setIsHighTechnology(Integer isHighTechnology) {
		this.isHighTechnology = isHighTechnology;
	}
	public String getHighTechnologyCode() {
		return highTechnologyCode;
	}
	public void setHighTechnologyCode(String highTechnologyCode) {
		
		this.highTechnologyCode = highTechnologyCode;
	}
	public Date getHighTechnologyDate() {
		return highTechnologyDate;
	}
	public void setHighTechnologyDate(Date highTechnologyDate) {
		this.highTechnologyDate = highTechnologyDate;
	}
	public String getContactOne() {
		return contactOne;
	}
	public void setContactOne(String contactOne) {
		this.contactOne = contactOne;
	}
	public String getPositionOneName() {
		return positionOneName;
	}
	public void setPositionOneName(String positionOneName) {
		this.positionOneName = positionOneName;
	}
	public String getPhoneOne() {
		return phoneOne;
	}
	public void setPhoneOne(String phoneOne) {
		this.phoneOne = phoneOne;
	}
	public String getContactTwo() {
		return contactTwo;
	}
	public void setContactTwo(String contactTwo) {
		this.contactTwo = contactTwo;
	}
	public String getPositionTwoName() {
		return positionTwoName;
	}
	public void setPositionTwoName(String positionTwoName) {
		this.positionTwoName = positionTwoName;
	}
	public String getPhoneTwo() {
		return phoneTwo;
	}
	public void setPhoneTwo(String phoneTwo) {
		this.phoneTwo = phoneTwo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getClientSourceID() {
		return clientSourceID;
	}
	public void setClientSourceID(String clientSourceID) {
		this.clientSourceID = clientSourceID;
	}
	public String getClientSourceName() {
		return clientSourceName;
	}
	public void setClientSourceName(String clientSourceName) {
		this.clientSourceName = clientSourceName;
	}
	public String getClientSourceDesc() {
		return clientSourceDesc;
	}
	public void setClientSourceDesc(String clientSourceDesc) {
		this.clientSourceDesc = clientSourceDesc;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getDomicile() {
		return domicile;
	}
	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}
	public Integer getFamilyNum() {
		return familyNum;
	}
	public void setFamilyNum(Integer familyNum) {
		this.familyNum = familyNum;
	}
	public Integer getWorkNum() {
		return workNum;
	}
	public void setWorkNum(Integer workNum) {
		this.workNum = workNum;
	}
	public String getIncomeSource() {
		return incomeSource;
	}
	public void setIncomeSource(String incomeSource) {
		this.incomeSource = incomeSource;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getWorkUnit() {
		return workUnit;
	}
	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getUnitAddress() {
		return unitAddress;
	}
	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}
	public Float getMonthIncome() {
		return monthIncome;
	}
	public void setMonthIncome(Float monthIncome) {
		this.monthIncome = monthIncome;
	}
	public String getUnitPost() {
		return unitPost;
	}
	public void setUnitPost(String unitPost) {
		this.unitPost = unitPost;
	}
	public String getUnitPhone() {
		return unitPhone;
	}
	public void setUnitPhone(String unitPhone) {
		this.unitPhone = unitPhone;
	}
	public String getHouseNature() {
		return houseNature;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public void setHouseNature(String houseNature) {
		this.houseNature = houseNature;
	}
	public Float getHouseArea() {
		return houseArea;
	}
	public void setHouseArea(Float houseArea) {
		this.houseArea = houseArea;
	}
	public String getHouseAddress() {
		return houseAddress;
	}
	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}
	public String getHousePost() {
		return housePost;
	}
	public void setHousePost(String housePost) {
		this.housePost = housePost;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHouseTel() {
		return houseTel;
	}
	public void setHouseTel(String houseTel) {
		this.houseTel = houseTel;
	}
	public String getOtherAssets() {
		return otherAssets;
	}
	public void setOtherAssets(String otherAssets) {
		this.otherAssets = otherAssets;
	}
	public Boolean getIsClient() {
		return isClient;
	}
	public void setIsClient(Boolean isClient) {
		this.isClient = isClient;
	}
	public Boolean getIsRelation() {
		return isRelation;
	}
	public void setIsRelation(Boolean isRelation) {
		this.isRelation = isRelation;
	}
	public Integer getIsOptGaranty() {
		return isOptGaranty;
	}
	public void setIsOptGaranty(Integer isOptGaranty) {
		this.isOptGaranty = isOptGaranty;
	}
	public Boolean getIsBadClient() {
		return isBadClient;
	}
	public void setIsBadClient(Boolean isBadClient) {
		this.isBadClient = isBadClient;
	}
	public String getCreditLevelID() {
		return creditLevelID;
	}
	public void setCreditLevelID(String creditLevelID) {
		this.creditLevelID = creditLevelID;
	}
	public String getCreditLevel() {
		return creditLevel;
	}
	public void setCreditLevel(String creditLevel) {
		this.creditLevel = creditLevel;
	}
	public String getFullDepartCode() {
		return fullDepartCode;
	}
	public void setFullDepartCode(String fullDepartCode) {
		this.fullDepartCode = fullDepartCode;
	}
	public Boolean getIsMainVersion() {
		return isMainVersion;
	}
	public void setIsMainVersion(Boolean isMainVersion) {
		this.isMainVersion = isMainVersion;
	}
	public String getUpdateUserName() {
		return updateUserName;
	}
	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
	public Date getUpdateDateTime() {
		return updateDateTime;
	}
	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	public String getFullDepartName() {
		return fullDepartName;
	}
	public void setFullDepartName(String fullDepartName) {
		this.fullDepartName = fullDepartName;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public String getPersonNum() {
		return personNum;
	}
	public void setPersonNum(String personNum) {
		this.personNum = personNum;
	}
	public String getClient_ID() {
		return client_ID;
	}
	public void setClient_ID(String client_ID) {
		this.client_ID = client_ID;
	}
	public String getUnit_uid() {
		return unit_uid;
	}
	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}
	public String getUnit_uidName() {
		return unit_uidName;
	}
	public void setUnit_uidName(String unit_uidName) {
		this.unit_uidName = unit_uidName;
	}
	public String getRelationQueryDesc() {
		return relationQueryDesc;
	}
	public void setRelationQueryDesc(String relationQueryDesc) {
		this.relationQueryDesc = relationQueryDesc;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getRiskLevelID() {
		return riskLevelID;
	}
	public void setRiskLevelID(String riskLevelID) {
		this.riskLevelID = riskLevelID;
	}
	public String getRiskLevelName() {
		return riskLevelName;
	}
	public void setRiskLevelName(String riskLevelName) {
		this.riskLevelName = riskLevelName;
	}

	public String getRiskLevelDesc() {
		return riskLevelDesc;
	}
	public void setRiskLevelDesc(String riskLevelDesc) {
		this.riskLevelDesc = riskLevelDesc;
	}
	public String getRelationMainName() {
		return relationMainName;
	}
	public void setRelationMainName(String relationMainName) {
		this.relationMainName = relationMainName;
	}
	public String getGzwRiskLevel() {
		return gzwRiskLevel;
	}
	public void setGzwRiskLevel(String gzwRiskLevel) {
		this.gzwRiskLevel = gzwRiskLevel;
	}
	
	public Double getTimePointSum() {
		return timePointSum;
	}
	public void setTimePointSum(Double timePointSum) {
		this.timePointSum = timePointSum;
	}
	public Double getLiabilitySum() {
		return liabilitySum;
	}
	public void setLiabilitySum(Double liabilitySum) {
		this.liabilitySum = liabilitySum;
	}
	public Double getCreditorGuarSum() {
		return creditorGuarSum;
	}
	public void setCreditorGuarSum(Double creditorGuarSum) {
		this.creditorGuarSum = creditorGuarSum;
	}
	public Double getTimePointEntrustSum() {
		return timePointEntrustSum;
	}
	public void setTimePointEntrustSum(Double timePointEntrustSum) {
		this.timePointEntrustSum = timePointEntrustSum;
	}
	public String getOldDivisionID() {
		return oldDivisionID;
	}
	public void setOldDivisionID(String oldDivisionID) {
		this.oldDivisionID = oldDivisionID;
	}
	public String getDivisionID() {
		return divisionID;
	}
	public void setDivisionID(String divisionID) {
		this.divisionID = divisionID;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public String getOldDivisionName() {
		return oldDivisionName;
	}
	public String getOldClientName() {
		return oldClientName;
	}
	public void setOldClientName(String oldClientName) {
		this.oldClientName = oldClientName;
	}
	public void setOldDivisionName(String oldDivisionName) {
		this.oldDivisionName = oldDivisionName;
	}
	
	
}
