package com.zjm.pro.db.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
/**
 * 
 * @description  保证措施表 pro_optGuaranty
 * @author wuhn
 * @date 2017年7月3日 下午7:18:45
 */
public class Pro_optGuaranty implements Serializable{
	private static final long serialVersionUID = 1L;
	private    String   optGuaranty_ID;   //   保证措施ID   optGuaranty_ID
	private    String   apply_ID;   //   客户申请记录ID   apply_ID
	private    String   applyDetail_ID;   //   申请产品明细ID   applyDetail_ID
	private    String   contractDoc_ID;   //   合同ID   contractDoc_ID
	private    String   guarantyTypeID;   //   保证方式optTypeID   guarantyTypeID
	private    String   guarantyTypeName;   //   保证方式名称   guarantyTypeName
	private    String   optTypeID;   //   反担保物类型ID   optTypeID
	private    String   optTypeName;   //   反担保物类型名称   optTypeName
	private    String   optName;   //   反担保物名称optName   optName
	private    String   ownerName;   //   权属人名称ownerName   ownerName
	private    BigDecimal   oldValue;   //   抵押物原值（万）oldValue   oldValue
	private    BigDecimal   buyValue;   //   购卖价值（万）buyValue   buyValue
	private    BigDecimal   optValue;   //   抵押（质押）价值（万）optValue   optValue  抵押价值 质押价值
	private    String   registeAuthority;   //   房产登记机关registeAuthority   registeAuthority
	private    String   certificateNum;   //   房产证编号certificateNum    建筑工程规划许可证号
	private    Float   houseArea;   //   房屋面积（平方）houseArea   建筑面积
	private    Float   useArea;   //   使用面积（平方）useArea   useArea
	private    Float   havingArea;   //   分摊土地（平方）havingArea  抵押房产面积  抵押面积
	private    Date   createDate;   //   建成时间createDate   createDate
	private    Float   useYear;   //   使用年限（年）useYear   useYear
	private    Float   otherYear;   //   剩余年限（年）otherYear   otherYear
	private    String   houseAddress;   //   房屋座落地址houseAddress   houseAddress
	private    String   preposePledgee;   //   前置抵押人   preposePledgee
	private    BigDecimal   preposeSum;   //   前置抵押价值   preposeSum
	private    String   preposePledgeeOne;   //   前置抵押人第一位   preposePledgeeOne
	private    BigDecimal   preposeOneSum;   //   前置抵押价值第一位   preposeOneSum
	private    String   preposePledgeeTwo;   //   前置抵押人第二位   preposePledgeeTwo
	private    BigDecimal   preposeTwoSum;   //   前置抵押价值第二位   preposeTwoSum
	private    String   preposePledgeeThree;   //   前置抵押人第三位   preposePledgeeThree
	private    BigDecimal   preposeThreeSum;   //   前置抵押价值第三位   preposeThreeSum
	private    String   landCode;   //   土地证号landCode   landCode
	private    String   landProperty;   //   土地使用性质   landProperty
	private    String   landArea;   //   土地面积（平）   landArea
	private    String   adderss;   //   详细地址adderss   adderss   机器设备-存放地
	private    Short   count;   //   设备数量（台、套）count   count
	private    String   stockRegisteNum;   //   股权登记证书号certificateNum   stockRegisteNum
	private    String   stockRegisteAuthority;   //   股权登记机关registeAuthority   stockRegisteAuthority
	private    String   clientID;   //   客户编号clientID   clientID
	private    String   guararelationship;   //   与担保申请人关系guararelationship   guararelationship
	private    String   otherDesc;   //   其它描述otherDesc   机器设备 状况（现有或将有）
	private    String   sortNum;   //   我公司抵押权顺位sortNum   sortNum
	private    Float   coverageRatio;   //   抵押率%coverageRatio   coverageRatio
	private    Float   optPeriod;   //   抵押金额optPeriod   optPeriod
	private    Date   optBeginDate;   //   抵押开始日期optBeginDate   optBeginDate 抵（质）押登记期限
	private    Date   optEndDate;   //   抵押结束日期optEndDate   optEndDate 抵（质）押登记期限
	private    String   optGuarDesc;   //   反担保物描述optGuarDesc   optGuarDesc
	private    Integer   isRegister;   //   是否办理登记isRegister   isRegister
	private    Date   finishDate;   //   反担保物落实日期finishDate   finishDate
	private    Integer   isDispose=0;   //   是否被处置   isDispose
	private    String   disposeTypeID;   //   处置方式ID   disposeTypeID
	private    String   disposeTypeName;   //   处置方式名称   disposeTypeName
	private    BigDecimal   disposeSum;   //   处置变现金额   disposeSum
	private    BigDecimal   chargeAgainstSum;   //   冲抵变现金额   chargeAgainstSum
	private    String   disposeUserId;   //   （处置）经办人ID   disposeUserId
	private    String   disposeUserName;   //   （处置）经办人名称   disposeUserName
	private    Date   disposeDate;   //   处置日期   disposeDate
	private    Date   freeDate;   //   反担保物释放日期freeDate   freeDate 解除日期
	private    String   unit_uid;   //   担保机构编号unit_uid   unit_uid
	private    String   unit_uidName;   //   担保机构名称   unit_uidName
	private    String   updateUserName;   //   最后修改人姓名   updateUserName
	private    Date   updateDateTime;   //   最后修改时间   updateDateTime
	private    String   landSource;   //   土地来源 landSource   landSource
	private    String   pledgeLandArea;   //  抵押土地面积   pledgeLandArea   
	private    BigDecimal   assessValue;   //   抵押评估价值   assessValue   assessValue 评估价值
	private    Integer   isOther;   //   是否存在第三方     isOther   isOther
	private    String   otherType;   //    第三方权属人类型ID  otherType   otherType
	private    Integer   isWorkable = 0;   //   是否已落实  isWorkable   isWorkable  默认false  未落实
	private    String   isWorkables ;   //   是否已落实  isWorkable   isWorkable  默认false  未落实
	
	private    String   legalDsputeDesc;   //   法律纠纷、产权是否明晰   legalDsputeDesc
	private    String   cashabilityDesc;   //   变现能力评价   cashabilityDesc
	private    String   disposeRemark;   //   备注   disposeRemark
	private    String   versions;  //版本号  主版本 v1     其他副版本 
	private    String 	versionsId;//关联主版本id
	private    Integer 	isGuarantyMaxSum;//是否最高保证额    1 最高保证额  ，其他 0'
	
	private    String   busiCode ; // 冗余字段--  项目编号
	private    String   projectName ; // 冗余字段 -- 项目名称
	private    String   clientName ; // 冗余字段 -- 客户名称
	private    String   clientTypeID ; // 冗余字段 -- 客户名称
	private    String   personName ; // 冗余字段 -- 个人用户姓名
	private   String otherOwner;  // 冗余字段-- 第三方权属人名称
	private   String otherCreditCode;   // 冗余字段-- 统一社会信用代码
	private   String otherLegalPerson;  //冗余字段-- 法定代表人
	private   String otherLegalPhone;  // 冗余字段-- 法人联系方式
	private   String otherLegalAddress;  // 冗余字段-- 法人住所
	private   String otherPersonNum;  //冗余字段-- 身份证号码
	private   String otherPersonPhone;  //冗余字段-- 手机号
	private   String otherPersonAddress;  // 冗余字段-- 现住地址
	private   String otherPostCode;  // 冗余字段-- 邮编
	private   String otherFax;  // 冗余字段-- 传真
	private   String pageFlag;  // 冗余字段-- 页面标记 添加/查看/修改
   
	/** 20170718 增加第三方权属人信息 冗余字段 */
	private String thirdOwnerName;  // 第三方 权属人 名称
	private String thirdrCreditCode;  // 第三方 统一社会信用代码
	private String thirdLegalPerson;  // 第三方 法人名称
	private String thirdLegalPhone; // 第三方 法人联系方式
	private String thirdLegalAddress;  //第三方 法人住所
	private String thirdPostCode;  // 第三方 邮编
	private String thirdFax;  // 第三方 传真
	private String thirdPersonNum;  // 第三方 身份证号码
	private String thirdPersonPhone;  // 第三方手机号
	private String thirdPersonAddress;  // 第三方 现住地址
	
	/**20170712增加第三方权属人信息  01*/
	private   String otherOwnerID;  // -- 第三方权属人ID ---》作为增加字段，【非冗余字段】，保存在担保表中，和客户表客户id进行关联
	
	/**20170712增加是否代理人信息  02 */
	private Integer isProxy;  // 是否代理人
	private String proxyName; // 代理人姓名
	private String proxyPhone; // 代理人联系方式
	private String proxyCode; //  身份证号码  
	private BigDecimal actualValue; //  我公司抵押顺位实际余值
	
	/**20170713 增加 房产 和 机动车部分字段 */
	private String pledgePart ; // 抵押房产部位
	private String carBrandAndType ; // 机动车品牌及型号 
	private Date carBuyDate  ; // 机动车购买日期
	private String carCode     ; // 牌照号码
	private String carEngineCode   ; // 发动机号
	private String carFrame    ; // 车架号
	private String keepType    ; // 保管方式
	private BigDecimal invoiceValue   ; // 发票价值
	private Integer isInsurance    ; // 是否已上保险
	private String insuranceCompany    ; // 保险公司
	private String insuranceCode       ; // 保单编号
	private Date insuranceBeginDate      ; // 保单开始日期/合同开始日期
	private Date insuranceEndDate      ; // 保单结束日期/合同结束日期 
	private Integer isLocal      ; // 车主是否本地籍
	private String trafficViolation      ; //交管局最新违章 
	
	/** 20170714  增加 机器设备 部分字段 */
	private Integer isUseOther         ; //是否存在第三方使用权人 
	private String otherUseName        ; //第三方使用权人姓名/名称 
	private String otherUseCode        ; //第三方使用权人证件号码 
	private String otherUsePhone        ; //第三方使用权人联系方式
	private String specifications         ; //规格型号/规格
	private String machinesNumber		;//设备编号 2018-4-24 add 
	private String unitName		         ; //单位 
	private BigDecimal guaranteeSum        ; //   可提供反担保金额 
	private String bankName         ; //开户银行 
	private String bankNumber	      ; //	银行帐号
	private Integer isMarried       ; // 是否已婚
	private String spouseName       ; //配偶姓名 
	private String spouseCode        ; //配偶身份证号 
	private String guaranteePattern         ; //	担保方式
	private String guaranteePatternID         ; //	担保方式ID
	private BigDecimal guaranteeScale         ; //保证比例  / 股权出质比例
	
	/** 20170714  增加 质押--股票  部分字段 */
	private String ipoSite        ; //上市地点
	private String ipoName        ; //上市公司名称
	private String stockCode       ; //	股票代码 
	private Long stockCount       ; //	持股数量
	
	/** 20170714  增加 土地承租权 部分字段 */
	private String landOwnerName       ; //土地承租权人
	private String leaseName        ; //租赁协议
	private Float leasePeriod       ; //租赁期限/偿付期限
	private BigDecimal yearRent       ; //年租金/应收账款
	private String payPattern       ; //付款方式  
	private Date payDate       ; //支付时间  
	private Float alreadyTime        ; //合同已履行时长
	private Float residueTime        ; //剩余承租权时长
	private BigDecimal residueRent           ; //剩余期限租金 
	
	/** 20170714  增加 质押 -- 应收账款   部分字段 */
	private String companyContractCode         ; //企业合同编号
	private String companyContractName         ; //企业合同名称 
	private String billNumber           ; //发票号码
	private String billCode             ; //发票代码 
	private String payPerson            ; //付款人 
	private String leaseCode            ; //租用编号  
	private String firstOwner           ; //甲方授权人
	private String firstOwnerCode           ; //甲方授权人身份证号码 
	private String secondOwner            ; //	乙方授权人
	private String secondOwnerCode            ; //乙方授权人身份证号码
	
	
	
	/** 20170714  增加 质押 -- 存单详情   部分字段 */
	private String depositType                 ; //存单类型  
	private String depositCode                     ; //存单号 
	private String depositName                    ; //户名  
	private String depositAccounts                    ; //	账号
	private Date depositDate                    ; //存入日期 
	private Float depositPeriod                   ; //存入期限
	private BigDecimal depositSum                    ; //存入金额
	private BigDecimal yearScale                    ; //年利率  

	
	/** 20170714  增加 质押 -- 专利权详情 部分字段 */
	private String patentName                      ; //专利名称 
	private String patentCode                        ; //专利号  
	private Date appalyDate                         ; //申请日期  
	private Date certificateDate                        ; //颁证日期 
	private String validPeriod                         ; //有效期  
	private String patentDuty                            ; //维持专利权义务
	private BigDecimal custodyCost                           ; //保管费   

	/** 20170714  增加 质押 -- 商标详情 部分字段 */
	private String brandCode                             ; //商标注册号
	private String useCommodity                             ; //核定使用商品
	
	/** 20170714  增加 质押 -- 库存详情部分字段 */
	private String totalAmount                             ; //库存余额总额
	private String repertoryBalance                             ; //库存余额 
	private String insuranceCost                               ; //保险费 
	private String superviseCost                             ; //监管费   
	private String leaseCost                              ; //库房租赁费
	private String otherCost                              ; //其他费用
	
	
	/** 20170720 增加 保证措施落实，解除，处置 部分字段 */
	private String pledgeDepart; // 抵（质）押登记部门
	private String pledgeFile; // 抵（质）押登记证明文件
	private Integer pledgeFileCount; // 抵（质）押登记证明文件份数
	private String receivePerson; // 保证措施落实 原件存档接收人
	private String realizeUserName; // 保证措施落实 经办人
	private String realizeUserID; // 保证措施落实 经办人ID 
	private Date  realizeDate; // 保证措施落实 经办日期 
	private String freeUserName; // 解除经办人
	private String freeUserID; // 解除经办人Id
	private String guaranteeRemark; // 反担保物处置备注
	
	/** 20170721 增加是否解除，是否处置字段 */
	private Integer isFree=0 ; //是否解除
	
	private String relieveFlag;// 解除/处置列表标记
	
	/** 20170804  增加  是否本公司股权  */
	private Integer isCompanyStock ; //是否本公司股权
	
	/** 20170829 增加 原件管理部分字段**/
	private String custodyStatus="待入库";//保管状态
	private String putStockUserName;//入库经办人
	private Date putStockDate;//入库经办人
	/***20180424添加企业信息曾用名**/
	private String companyOnceName;
	
	private String optGuarantyIds;//担保措施id合集
	
	/** 20180718  增加保证金 -- 退回相关字段 */
	private BigDecimal returnGuaranteeSum;                             ; //退回保证金金额
	private BigDecimal guaranteeBalance                        ; //剩余保证金金额
	
	public BigDecimal getReturnGuaranteeSum() {
		return returnGuaranteeSum;
	}
	public void setReturnGuaranteeSum(BigDecimal returnGuaranteeSum) {
		this.returnGuaranteeSum = returnGuaranteeSum;
	}
	public BigDecimal getGuaranteeBalance() {
		return guaranteeBalance;
	}
	public void setGuaranteeBalance(BigDecimal guaranteeBalance) {
		this.guaranteeBalance = guaranteeBalance;
	}
	public Integer getIsGuarantyMaxSum() {
		return isGuarantyMaxSum;
	}
	public void setIsGuarantyMaxSum(Integer isGuarantyMaxSum) {
		this.isGuarantyMaxSum = isGuarantyMaxSum;
	}
	public String getCompanyOnceName() {
		return companyOnceName;
	}
	public void setCompanyOnceName(String companyOnceName) {
		this.companyOnceName = companyOnceName;
	}
	public String getMachinesNumber() {
		return machinesNumber;
	}
	public void setMachinesNumber(String machinesNumber) {
		this.machinesNumber = machinesNumber;
	}
	public String getOptGuarantyIds() {
		return optGuarantyIds;
	}
	public void setOptGuarantyIds(String optGuarantyIds) {
		this.optGuarantyIds = optGuarantyIds;
	}
	public String getVersionsId() {
		return versionsId;
	}
	public void setVersionsId(String versionsId) {
		this.versionsId = versionsId;
	}
	private List<Pro_projectfiles>  filesList; //扫描件集合

	public String getVersions() {
		return versions;
	}
	public void setVersions(String versions) {
		this.versions = versions;
	}
	/**20180322 增加保证金种类 rd_xujy**/
	private String depositTypeId;//保证金种类id
	private String depositTypeName;//保证金种类名称
	
	/**20180330反担保物列表显示冗余字段 rd_xujy**/
	private Double guarantySum;//项目余额
	private String fundChinese;//资金方
	private String fundName;//资金方子机构
	private String hzbankName;//合作方名称
	private String subBankName;//合作方子机构
	private Date loadBeginDate;//放款起始时间
	private Date delayEndDate;//放款到期时间
	
	public String getOptGuaranty_ID() {
		return optGuaranty_ID;
	}
	public void setOptGuaranty_ID(String optGuaranty_ID) {
		this.optGuaranty_ID = optGuaranty_ID;
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
	public String getContractDoc_ID() {
		return contractDoc_ID;
	}
	public void setContractDoc_ID(String contractDoc_ID) {
		this.contractDoc_ID = contractDoc_ID;
	}
	public String getGuarantyTypeID() {
		return guarantyTypeID;
	}
	public void setGuarantyTypeID(String guarantyTypeID) {
		this.guarantyTypeID = guarantyTypeID;
	}
	public String getGuarantyTypeName() {
		return guarantyTypeName;
	}
	public void setGuarantyTypeName(String guarantyTypeName) {
		this.guarantyTypeName = guarantyTypeName;
	}
	public String getOptTypeID() {
		return optTypeID;
	}
	public void setOptTypeID(String optTypeID) {
		this.optTypeID = optTypeID;
	}
	public String getOptTypeName() {
		return optTypeName;
	}
	public void setOptTypeName(String optTypeName) {
		this.optTypeName = optTypeName;
	}
	public String getOptName() {
		return optName;
	}
	public void setOptName(String optName) {
		this.optName = optName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public BigDecimal getOldValue() {
		return oldValue;
	}
	public void setOldValue(BigDecimal oldValue) {
		this.oldValue = oldValue;
	}
	public BigDecimal getBuyValue() {
		return buyValue;
	}
	public void setBuyValue(BigDecimal buyValue) {
		this.buyValue = buyValue;
	}
	public BigDecimal getOptValue() {
		return optValue;
	}
	public void setOptValue(BigDecimal optValue) {
		this.optValue = optValue;
	}
	public String getRegisteAuthority() {
		return registeAuthority;
	}
	public void setRegisteAuthority(String registeAuthority) {
		this.registeAuthority = registeAuthority;
	}
	public String getCertificateNum() {
		return certificateNum;
	}
	public void setCertificateNum(String certificateNum) {
		this.certificateNum = certificateNum;
	}
	
	public Float getHavingArea() {
		return havingArea;
	}
	public void setHavingArea(Float havingArea) {
		this.havingArea = havingArea;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Float getUseYear() {
		return useYear;
	}
	public void setUseYear(Float useYear) {
		this.useYear = useYear;
	}
	public Float getOtherYear() {
		return otherYear;
	}
	public void setOtherYear(Float otherYear) {
		this.otherYear = otherYear;
	}
	public String getHouseAddress() {
		return houseAddress;
	}
	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}
	public String getPreposePledgee() {
		return preposePledgee;
	}
	public void setPreposePledgee(String preposePledgee) {
		this.preposePledgee = preposePledgee;
	}
	public BigDecimal getPreposeSum() {
		return preposeSum;
	}
	public void setPreposeSum(BigDecimal preposeSum) {
		this.preposeSum = preposeSum;
	}
	public String getPreposePledgeeOne() {
		return preposePledgeeOne;
	}
	public void setPreposePledgeeOne(String preposePledgeeOne) {
		this.preposePledgeeOne = preposePledgeeOne;
	}
	public BigDecimal getPreposeOneSum() {
		return preposeOneSum;
	}
	public void setPreposeOneSum(BigDecimal preposeOneSum) {
		this.preposeOneSum = preposeOneSum;
	}
	public String getPreposePledgeeTwo() {
		return preposePledgeeTwo;
	}
	public void setPreposePledgeeTwo(String preposePledgeeTwo) {
		this.preposePledgeeTwo = preposePledgeeTwo;
	}
	public BigDecimal getPreposeTwoSum() {
		return preposeTwoSum;
	}
	public void setPreposeTwoSum(BigDecimal preposeTwoSum) {
		this.preposeTwoSum = preposeTwoSum;
	}
	public String getPreposePledgeeThree() {
		return preposePledgeeThree;
	}
	public void setPreposePledgeeThree(String preposePledgeeThree) {
		this.preposePledgeeThree = preposePledgeeThree;
	}
	public BigDecimal getPreposeThreeSum() {
		return preposeThreeSum;
	}
	public void setPreposeThreeSum(BigDecimal preposeThreeSum) {
		this.preposeThreeSum = preposeThreeSum;
	}
	public String getLandCode() {
		return landCode;
	}
	public void setLandCode(String landCode) {
		this.landCode = landCode;
	}
	public String getLandProperty() {
		return landProperty;
	}
	public void setLandProperty(String landProperty) {
		this.landProperty = landProperty;
	}
	
	public String getAdderss() {
		return adderss;
	}
	public void setAdderss(String adderss) {
		this.adderss = adderss;
	}
	public Short getCount() {
		return count;
	}
	public void setCount(Short count) {
		this.count = count;
	}
	public String getStockRegisteNum() {
		return stockRegisteNum;
	}
	public void setStockRegisteNum(String stockRegisteNum) {
		this.stockRegisteNum = stockRegisteNum;
	}
	public String getStockRegisteAuthority() {
		return stockRegisteAuthority;
	}
	public void setStockRegisteAuthority(String stockRegisteAuthority) {
		this.stockRegisteAuthority = stockRegisteAuthority;
	}
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public String getGuararelationship() {
		return guararelationship;
	}
	public void setGuararelationship(String guararelationship) {
		this.guararelationship = guararelationship;
	}
	public String getOtherDesc() {
		return otherDesc;
	}
	public void setOtherDesc(String otherDesc) {
		this.otherDesc = otherDesc;
	}
	public String getSortNum() {
		return sortNum;
	}
	public void setSortNum(String sortNum) {
		this.sortNum = sortNum;
	}
	public Float getCoverageRatio() {
		return coverageRatio;
	}
	public void setCoverageRatio(Float coverageRatio) {
		this.coverageRatio = coverageRatio;
	}
	public Float getOptPeriod() {
		return optPeriod;
	}
	public void setOptPeriod(Float optPeriod) {
		this.optPeriod = optPeriod;
	}
	public Date getOptBeginDate() {
		return optBeginDate;
	}
	public void setOptBeginDate(Date optBeginDate) {
		this.optBeginDate = optBeginDate;
	}
	public Date getOptEndDate() {
		return optEndDate;
	}
	public void setOptEndDate(Date optEndDate) {
		this.optEndDate = optEndDate;
	}
	public String getOptGuarDesc() {
		return optGuarDesc;
	}
	public void setOptGuarDesc(String optGuarDesc) {
		this.optGuarDesc = optGuarDesc;
	}
	public Integer getIsRegister() {
		return isRegister;
	}
	public void setIsRegister(Integer isRegister) {
		this.isRegister = isRegister;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public Integer getIsDispose() {
		return isDispose;
	}
	public void setIsDispose(Integer isDispose) {
		this.isDispose = isDispose;
	}
	public String getDisposeTypeID() {
		return disposeTypeID;
	}
	public void setDisposeTypeID(String disposeTypeID) {
		this.disposeTypeID = disposeTypeID;
	}
	public String getDisposeTypeName() {
		return disposeTypeName;
	}
	public void setDisposeTypeName(String disposeTypeName) {
		this.disposeTypeName = disposeTypeName;
	}
	public BigDecimal getDisposeSum() {
		return disposeSum;
	}
	public void setDisposeSum(BigDecimal disposeSum) {
		this.disposeSum = disposeSum;
	}
	public BigDecimal getChargeAgainstSum() {
		return chargeAgainstSum;
	}
	public void setChargeAgainstSum(BigDecimal chargeAgainstSum) {
		this.chargeAgainstSum = chargeAgainstSum;
	}
	public String getDisposeUserId() {
		return disposeUserId;
	}
	public void setDisposeUserId(String disposeUserId) {
		this.disposeUserId = disposeUserId;
	}
	public String getDisposeUserName() {
		return disposeUserName;
	}
	public void setDisposeUserName(String disposeUserName) {
		this.disposeUserName = disposeUserName;
	}
	public Date getDisposeDate() {
		return disposeDate;
	}
	public void setDisposeDate(Date disposeDate) {
		this.disposeDate = disposeDate;
	}
	public Date getFreeDate() {
		return freeDate;
	}
	public void setFreeDate(Date freeDate) {
		this.freeDate = freeDate;
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
	public String getLandSource() {
		return landSource;
	}
	public void setLandSource(String landSource) {
		this.landSource = landSource;
	}
	public String getPledgeLandArea() {
		return pledgeLandArea;
	}
	public void setPledgeLandArea(String pledgeLandArea) {
		this.pledgeLandArea = pledgeLandArea;
	}
	public BigDecimal getAssessValue() {
		return assessValue;
	}
	public void setAssessValue(BigDecimal assessValue) {
		this.assessValue = assessValue;
	}
	public Integer getIsOther() {
		return isOther;
	}
	public void setIsOther(Integer isOther) {
		this.isOther = isOther;
	}
	public String getOtherType() {
		return otherType;
	}
	public void setOtherType(String otherType) {
		this.otherType = otherType;
	}
	public Integer getIsWorkable() {
		return isWorkable;
	}
	public void setIsWorkable(Integer isWorkable) {
		this.isWorkable = isWorkable;
	}
	public String getLegalDsputeDesc() {
		return legalDsputeDesc;
	}
	public void setLegalDsputeDesc(String legalDsputeDesc) {
		this.legalDsputeDesc = legalDsputeDesc;
	}
	public String getCashabilityDesc() {
		return cashabilityDesc;
	}
	public void setCashabilityDesc(String cashabilityDesc) {
		this.cashabilityDesc = cashabilityDesc;
	}
	public String getDisposeRemark() {
		return disposeRemark;
	}
	public void setDisposeRemark(String disposeRemark) {
		this.disposeRemark = disposeRemark;
	}
	public Float getHouseArea() {
		return houseArea;
	}
	public void setHouseArea(Float houseArea) {
		this.houseArea = houseArea;
	}
	public Float getUseArea() {
		return useArea;
	}
	public void setUseArea(Float useArea) {
		this.useArea = useArea;
	}
	public String getLandArea() {
		return landArea;
	}
	public void setLandArea(String landArea) {
		this.landArea = landArea;
	}
	public String getBusiCode() {
		return busiCode;
	}
	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getOtherOwner() {
		return otherOwner;
	}
	public void setOtherOwner(String otherOwner) {
		this.otherOwner = otherOwner;
	}
	public String getOtherCreditCode() {
		return otherCreditCode;
	}
	public void setOtherCreditCode(String otherCreditCode) {
		this.otherCreditCode = otherCreditCode;
	}
	public String getOtherLegalPerson() {
		return otherLegalPerson;
	}
	public void setOtherLegalPerson(String otherLegalPerson) {
		this.otherLegalPerson = otherLegalPerson;
	}
	public String getOtherLegalPhone() {
		return otherLegalPhone;
	}
	public void setOtherLegalPhone(String otherLegalPhone) {
		this.otherLegalPhone = otherLegalPhone;
	}
	public String getOtherLegalAddress() {
		return otherLegalAddress;
	}
	public void setOtherLegalAddress(String otherLegalAddress) {
		this.otherLegalAddress = otherLegalAddress;
	}
	public String getOtherPersonNum() {
		return otherPersonNum;
	}
	public void setOtherPersonNum(String otherPersonNum) {
		this.otherPersonNum = otherPersonNum;
	}
	public String getOtherPersonPhone() {
		return otherPersonPhone;
	}
	public void setOtherPersonPhone(String otherPersonPhone) {
		this.otherPersonPhone = otherPersonPhone;
	}
	public String getOtherPersonAddress() {
		return otherPersonAddress;
	}
	public void setOtherPersonAddress(String otherPersonAddress) {
		this.otherPersonAddress = otherPersonAddress;
	}
	public String getOtherPostCode() {
		return otherPostCode;
	}
	public void setOtherPostCode(String otherPostCode) {
		this.otherPostCode = otherPostCode;
	}
	public String getOtherFax() {
		return otherFax;
	}
	public void setOtherFax(String otherFax) {
		this.otherFax = otherFax;
	}
	public String getOtherOwnerID() {
		return otherOwnerID;
	}
	public void setOtherOwnerID(String otherOwnerID) {
		this.otherOwnerID = otherOwnerID;
	}
	public Integer getIsProxy() {
		return isProxy;
	}
	public void setIsProxy(Integer isProxy) {
		this.isProxy = isProxy;
	}
	
	public String getProxyName() {
		return proxyName;
	}
	public void setProxyName(String proxyName) {
		this.proxyName = proxyName;
	}
	public String getProxyPhone() {
		return proxyPhone;
	}
	public void setProxyPhone(String proxyPhone) {
		this.proxyPhone = proxyPhone;
	}
	public String getProxyCode() {
		return proxyCode;
	}
	public void setProxyCode(String proxyCode) {
		this.proxyCode = proxyCode;
	}
	public BigDecimal getActualValue() {
		return actualValue;
	}
	public void setActualValue(BigDecimal actualValue) {
		this.actualValue = actualValue;
	}
	public String getPledgePart() {
		return pledgePart;
	}
	public void setPledgePart(String pledgePart) {
		this.pledgePart = pledgePart;
	}
	public String getCarBrandAndType() {
		return carBrandAndType;
	}
	public void setCarBrandAndType(String carBrandAndType) {
		this.carBrandAndType = carBrandAndType;
	}
	public Date getCarBuyDate() {
		return carBuyDate;
	}
	public void setCarBuyDate(Date carBuyDate) {
		this.carBuyDate = carBuyDate;
	}
	public String getCarCode() {
		return carCode;
	}
	public void setCarCode(String carCode) {
		this.carCode = carCode;
	}
	public String getCarEngineCode() {
		return carEngineCode;
	}
	public void setCarEngineCode(String carEngineCode) {
		this.carEngineCode = carEngineCode;
	}
	public String getCarFrame() {
		return carFrame;
	}
	public void setCarFrame(String carFrame) {
		this.carFrame = carFrame;
	}
	public String getKeepType() {
		return keepType;
	}
	public void setKeepType(String keepType) {
		this.keepType = keepType;
	}
	public BigDecimal getInvoiceValue() {
		return invoiceValue;
	}
	public void setInvoiceValue(BigDecimal invoiceValue) {
		this.invoiceValue = invoiceValue;
	}
	public Integer getIsInsurance() {
		return isInsurance;
	}
	public void setIsInsurance(Integer isInsurance) {
		this.isInsurance = isInsurance;
	}
	public String getInsuranceCompany() {
		return insuranceCompany;
	}
	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}
	public String getInsuranceCode() {
		return insuranceCode;
	}
	public void setInsuranceCode(String insuranceCode) {
		this.insuranceCode = insuranceCode;
	}
	public Date getInsuranceBeginDate() {
		return insuranceBeginDate;
	}
	public void setInsuranceBeginDate(Date insuranceBeginDate) {
		this.insuranceBeginDate = insuranceBeginDate;
	}
	public Date getInsuranceEndDate() {
		return insuranceEndDate;
	}
	public void setInsuranceEndDate(Date insuranceEndDate) {
		this.insuranceEndDate = insuranceEndDate;
	}
	public Integer getIsLocal() {
		return isLocal;
	}
	public void setIsLocal(Integer isLocal) {
		this.isLocal = isLocal;
	}
	public String getTrafficViolation() {
		return trafficViolation;
	}
	public void setTrafficViolation(String trafficViolation) {
		this.trafficViolation = trafficViolation;
	}
	public Integer getIsUseOther() {
		return isUseOther;
	}
	public void setIsUseOther(Integer isUseOther) {
		this.isUseOther = isUseOther;
	}
	public String getOtherUseName() {
		return otherUseName;
	}
	public void setOtherUseName(String otherUseName) {
		this.otherUseName = otherUseName;
	}
	public String getOtherUseCode() {
		return otherUseCode;
	}
	public void setOtherUseCode(String otherUseCode) {
		this.otherUseCode = otherUseCode;
	}
	public String getOtherUsePhone() {
		return otherUsePhone;
	}
	public void setOtherUsePhone(String otherUsePhone) {
		this.otherUsePhone = otherUsePhone;
	}
	public String getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public BigDecimal getGuaranteeSum() {
		return guaranteeSum;
	}
	public void setGuaranteeSum(BigDecimal guaranteeSum) {
		this.guaranteeSum = guaranteeSum;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankNumber() {
		return bankNumber;
	}
	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}
	public Integer getIsMarried() {
		return isMarried;
	}
	public void setIsMarried(Integer isMarried) {
		this.isMarried = isMarried;
	}
	public String getSpouseName() {
		return spouseName;
	}
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}
	public String getSpouseCode() {
		return spouseCode;
	}
	public void setSpouseCode(String spouseCode) {
		this.spouseCode = spouseCode;
	}
	public String getGuaranteePattern() {
		return guaranteePattern;
	}
	public void setGuaranteePattern( String guaranteePattern) {
		this.guaranteePattern = guaranteePattern;
	}
	public BigDecimal getGuaranteeScale() {
		return guaranteeScale;
	}
	public void setGuaranteeScale(BigDecimal guaranteeScale) {
		this.guaranteeScale = guaranteeScale;
	}
	public String getIpoSite() {
		return ipoSite;
	}
	public void setIpoSite(String ipoSite) {
		this.ipoSite = ipoSite;
	}
	public String getIpoName() {
		return ipoName;
	}
	public void setIpoName(String ipoName) {
		this.ipoName = ipoName;
	}
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public Long getStockCount() {
		return stockCount;
	}
	public void setStockCount(Long stockCount) {
		this.stockCount = stockCount;
	}
	public String getLandOwnerName() {
		return landOwnerName;
	}
	public void setLandOwnerName(String landOwnerName) {
		this.landOwnerName = landOwnerName;
	}
	public String getLeaseName() {
		return leaseName;
	}
	public void setLeaseName(String leaseName) {
		this.leaseName = leaseName;
	}
	public Float getLeasePeriod() {
		return leasePeriod;
	}
	public void setLeasePeriod(Float leasePeriod) {
		this.leasePeriod = leasePeriod;
	}
	public BigDecimal getYearRent() {
		return yearRent;
	}
	public void setYearRent(BigDecimal yearRent) {
		this.yearRent = yearRent;
	}
	public String getPayPattern() {
		return payPattern;
	}
	public void setPayPattern(String payPattern) {
		this.payPattern = payPattern;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Float getAlreadyTime() {
		return alreadyTime;
	}
	public void setAlreadyTime(Float alreadyTime) {
		this.alreadyTime = alreadyTime;
	}
	public Float getResidueTime() {
		return residueTime;
	}
	public void setResidueTime(Float residueTime) {
		this.residueTime = residueTime;
	}
	public BigDecimal getResidueRent() {
		return residueRent;
	}
	public void setResidueRent(BigDecimal residueRent) {
		this.residueRent = residueRent;
	}
	public String getCompanyContractCode() {
		return companyContractCode;
	}
	public void setCompanyContractCode(String companyContractCode) {
		this.companyContractCode = companyContractCode;
	}
	public String getCompanyContractName() {
		return companyContractName;
	}
	public void setCompanyContractName(String companyContractName) {
		this.companyContractName = companyContractName;
	}
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public String getPayPerson() {
		return payPerson;
	}
	public void setPayPerson(String payPerson) {
		this.payPerson = payPerson;
	}
	public String getLeaseCode() {
		return leaseCode;
	}
	public void setLeaseCode(String leaseCode) {
		this.leaseCode = leaseCode;
	}
	public String getFirstOwner() {
		return firstOwner;
	}
	public void setFirstOwner(String firstOwner) {
		this.firstOwner = firstOwner;
	}
	public String getFirstOwnerCode() {
		return firstOwnerCode;
	}
	public void setFirstOwnerCode(String firstOwnerCode) {
		this.firstOwnerCode = firstOwnerCode;
	}
	public String getSecondOwner() {
		return secondOwner;
	}
	public void setSecondOwner(String secondOwner) {
		this.secondOwner = secondOwner;
	}
	public String getSecondOwnerCode() {
		return secondOwnerCode;
	}
	public void setSecondOwnerCode(String secondOwnerCode) {
		this.secondOwnerCode = secondOwnerCode;
	}
	public String getDepositType() {
		return depositType;
	}
	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}
	public String getDepositCode() {
		return depositCode;
	}
	public void setDepositCode(String depositCode) {
		this.depositCode = depositCode;
	}
	public String getDepositName() {
		return depositName;
	}
	public void setDepositName(String depositName) {
		this.depositName = depositName;
	}
	public String getDepositAccounts() {
		return depositAccounts;
	}
	public void setDepositAccounts(String depositAccounts) {
		this.depositAccounts = depositAccounts;
	}
	public Date getDepositDate() {
		return depositDate;
	}
	public void setDepositDate(Date depositDate) {
		this.depositDate = depositDate;
	}
	public Float getDepositPeriod() {
		return depositPeriod;
	}
	public void setDepositPeriod(Float depositPeriod) {
		this.depositPeriod = depositPeriod;
	}
	public BigDecimal getDepositSum() {
		return depositSum;
	}
	public void setDepositSum(BigDecimal depositSum) {
		this.depositSum = depositSum;
	}
	public BigDecimal getYearScale() {
		return yearScale;
	}
	public void setYearScale(BigDecimal yearScale) {
		this.yearScale = yearScale;
	}
	public String getPatentName() {
		return patentName;
	}
	public void setPatentName(String patentName) {
		this.patentName = patentName;
	}
	public String getPatentCode() {
		return patentCode;
	}
	public void setPatentCode(String patentCode) {
		this.patentCode = patentCode;
	}
	public Date getAppalyDate() {
		return appalyDate;
	}
	public void setAppalyDate(Date appalyDate) {
		this.appalyDate = appalyDate;
	}
	public Date getCertificateDate() {
		return certificateDate;
	}
	public void setCertificateDate(Date certificateDate) {
		this.certificateDate = certificateDate;
	}
	public String getValidPeriod() {
		return validPeriod;
	}
	public void setValidPeriod(String validPeriod) {
		this.validPeriod = validPeriod;
	}
	public String getPatentDuty() {
		return patentDuty;
	}
	public void setPatentDuty(String patentDuty) {
		this.patentDuty = patentDuty;
	}
	public BigDecimal getCustodyCost() {
		return custodyCost;
	}
	public void setCustodyCost(BigDecimal custodyCost) {
		this.custodyCost = custodyCost;
	}
	public String getBrandCode() {
		return brandCode;
	}
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}
	public String getUseCommodity() {
		return useCommodity;
	}
	public void setUseCommodity(String useCommodity) {
		this.useCommodity = useCommodity;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getRepertoryBalance() {
		return repertoryBalance;
	}
	public void setRepertoryBalance(String repertoryBalance) {
		this.repertoryBalance = repertoryBalance;
	}
	public String getInsuranceCost() {
		return insuranceCost;
	}
	public void setInsuranceCost(String insuranceCost) {
		this.insuranceCost = insuranceCost;
	}
	public String getSuperviseCost() {
		return superviseCost;
	}
	public void setSuperviseCost(String superviseCost) {
		this.superviseCost = superviseCost;
	}
	public String getLeaseCost() {
		return leaseCost;
	}
	public void setLeaseCost(String leaseCost) {
		this.leaseCost = leaseCost;
	}
	public String getOtherCost() {
		return otherCost;
	}
	public void setOtherCost(String otherCost) {
		this.otherCost = otherCost;
	}
	public String getPageFlag() {
		return pageFlag;
	}
	public void setPageFlag(String pageFlag) {
		this.pageFlag = pageFlag;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getClientTypeID() {
		return clientTypeID;
	}
	public void setClientTypeID(String clientTypeID) {
		this.clientTypeID = clientTypeID;
	}
	public String getGuaranteePatternID() {
		return guaranteePatternID;
	}
	public void setGuaranteePatternID(String guaranteePatternID) {
		this.guaranteePatternID = guaranteePatternID;
	}
	public String getThirdOwnerName() {
		return thirdOwnerName;
	}
	public void setThirdOwnerName(String thirdOwnerName) {
		this.thirdOwnerName = thirdOwnerName;
	}
	public String getThirdrCreditCode() {
		return thirdrCreditCode;
	}
	public void setThirdrCreditCode(String thirdrCreditCode) {
		this.thirdrCreditCode = thirdrCreditCode;
	}
	public String getThirdLegalPerson() {
		return thirdLegalPerson;
	}
	public void setThirdLegalPerson(String thirdLegalPerson) {
		this.thirdLegalPerson = thirdLegalPerson;
	}
	public String getThirdLegalPhone() {
		return thirdLegalPhone;
	}
	public void setThirdLegalPhone(String thirdLegalPhone) {
		this.thirdLegalPhone = thirdLegalPhone;
	}
	public String getThirdLegalAddress() {
		return thirdLegalAddress;
	}
	public void setThirdLegalAddress(String thirdLegalAddress) {
		this.thirdLegalAddress = thirdLegalAddress;
	}
	public String getThirdPostCode() {
		return thirdPostCode;
	}
	public void setThirdPostCode(String thirdPostCode) {
		this.thirdPostCode = thirdPostCode;
	}
	public String getThirdFax() {
		return thirdFax;
	}
	public void setThirdFax(String thirdFax) {
		this.thirdFax = thirdFax;
	}
	public String getThirdPersonNum() {
		return thirdPersonNum;
	}
	public void setThirdPersonNum(String thirdPersonNum) {
		this.thirdPersonNum = thirdPersonNum;
	}
	public String getThirdPersonPhone() {
		return thirdPersonPhone;
	}
	public void setThirdPersonPhone(String thirdPersonPhone) {
		this.thirdPersonPhone = thirdPersonPhone;
	}
	public String getThirdPersonAddress() {
		return thirdPersonAddress;
	}
	public void setThirdPersonAddress(String thirdPersonAddress) {
		this.thirdPersonAddress = thirdPersonAddress;
	}
	public String getPledgeDepart() {
		return pledgeDepart;
	}
	public void setPledgeDepart(String pledgeDepart) {
		this.pledgeDepart = pledgeDepart;
	}
	public String getPledgeFile() {
		return pledgeFile;
	}
	public void setPledgeFile(String pledgeFile) {
		this.pledgeFile = pledgeFile;
	}
	public Integer getPledgeFileCount() {
		return pledgeFileCount;
	}
	public void setPledgeFileCount(Integer pledgeFileCount) {
		this.pledgeFileCount = pledgeFileCount;
	}
	public String getReceivePerson() {
		return receivePerson;
	}
	public void setReceivePerson(String receivePerson) {
		this.receivePerson = receivePerson;
	}
	public String getRealizeUserName() {
		return realizeUserName;
	}
	public void setRealizeUserName(String realizeUserName) {
		this.realizeUserName = realizeUserName;
	}
	public String getRealizeUserID() {
		return realizeUserID;
	}
	public void setRealizeUserID(String realizeUserID) {
		this.realizeUserID = realizeUserID;
	}
	public Date getRealizeDate() {
		return realizeDate;
	}
	public void setRealizeDate(Date realizeDate) {
		this.realizeDate = realizeDate;
	}
	public String getFreeUserName() {
		return freeUserName;
	}
	public void setFreeUserName(String freeUserName) {
		this.freeUserName = freeUserName;
	}
	public String getFreeUserID() {
		return freeUserID;
	}
	public void setFreeUserID(String freeUserID) {
		this.freeUserID = freeUserID;
	}
	public String getGuaranteeRemark() {
		return guaranteeRemark;
	}
	public void setGuaranteeRemark(String guaranteeRemark) {
		this.guaranteeRemark = guaranteeRemark;
	}
	public Integer getIsFree() {
		return isFree;
	}
	public void setIsFree(Integer isFree) {
		this.isFree = isFree;
	}
	public String getRelieveFlag() {
		return relieveFlag;
	}
	public void setRelieveFlag(String relieveFlag) {
		this.relieveFlag = relieveFlag;
	}
	public Integer getIsCompanyStock() {
		return isCompanyStock;
	}
	public void setIsCompanyStock(Integer isCompanyStock) {
		this.isCompanyStock = isCompanyStock;
	}
	public String getCustodyStatus() {
		return custodyStatus;
	}
	public void setCustodyStatus(String custodyStatus) {
		this.custodyStatus = custodyStatus;
	}
	public String getPutStockUserName() {
		return putStockUserName;
	}
	public void setPutStockUserName(String putStockUserName) {
		this.putStockUserName = putStockUserName;
	}
	public Date getPutStockDate() {
		return putStockDate;
	}
	public void setPutStockDate(Date putStockDate) {
		this.putStockDate = putStockDate;
	}
	public List<Pro_projectfiles> getFilesList() {
		return filesList;
	}
	public void setFilesList(List<Pro_projectfiles> filesList) {
		this.filesList = filesList;
	}
	
	public String getIsWorkables() {
		return isWorkable==1?"是":"否";
	}
	public void setIsWorkables(String isWorkables) {
		this.isWorkables = isWorkable==1?"是":"否";
	}
	public String getDepositTypeId() {
		return depositTypeId;
	}
	public void setDepositTypeId(String depositTypeId) {
		this.depositTypeId = depositTypeId;
	}
	public String getDepositTypeName() {
		return depositTypeName;
	}
	public void setDepositTypeName(String depositTypeName) {
		this.depositTypeName = depositTypeName;
	}
	public Double getGuarantySum() {
		return guarantySum;
	}
	public void setGuarantySum(Double guarantySum) {
		this.guarantySum = guarantySum;
	}
	public String getFundChinese() {
		return fundChinese;
	}
	public void setFundChinese(String fundChinese) {
		this.fundChinese = fundChinese;
	}
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public String getHzbankName() {
		return hzbankName;
	}
	public void setHzbankName(String hzbankName) {
		this.hzbankName = hzbankName;
	}
	public String getSubBankName() {
		return subBankName;
	}
	public void setSubBankName(String subBankName) {
		this.subBankName = subBankName;
	}
	public Date getLoadBeginDate() {
		return loadBeginDate;
	}
	public void setLoadBeginDate(Date loadBeginDate) {
		this.loadBeginDate = loadBeginDate;
	}
	public Date getDelayEndDate() {
		return delayEndDate;
	}
	public void setDelayEndDate(Date delayEndDate) {
		this.delayEndDate = delayEndDate;
	}
	
}