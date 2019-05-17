package com.zjm.pro.db.model;

import java.io.Serializable;
/**
 * 以关联系维度查询所有的项目信息
 * Gua:担保业务 guarantee
 * Ent:委贷业务 entrust
 * ReSum:余额 remaining sum
 * 
 */
public class Pro_projectForProVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String relationMain_ID;		//关联主体流水号
	private String relationMainName;	//关联主体名称
	private String clientID;			//主体客户ID
	private String clientName;			//主体客户名称
	private String clientGUID;			//主体客户唯一标识
	private String relationTypeID;		//关系类型ID
	private String relationTypeName;	//关系类型名称
	private String projectTypeID;   	//项目类型ID（字典）----融投特有
	private String projectTypeName;  	//项目类型名称----融投特有
	private String fullAreaCode;		//所属区域完整代码
	private String fullAreaName;		//所属区域名称
	private Double capitalSum;			//总资产
	private Double liabilitySum;     	//负债总额
	private Double guarantySum;       	//2015年1月末担保余额-----融投特有
	private Double guarantyEntrustSum;  //2015年1月末担保集团委贷余额-----融投特有
	private Double entrustSum;    		//2015年1月末融投系委贷余额-----融投特有
	private Double creditorSum;   		//保外债权人融资金额
	private Double guaReSum_zaibao;		//在保余额
	private Double entReSum_guaGroup;	//担保集团委贷余额
	private Double entReSum_gua;		//委贷余额_有担保集团担保的
	private Double entReSum_noGua;		//委贷余额_没有担保集团担保的
//	private Double entReSum_gua;		//租赁余额_有担保集团担保的
//	private Double entReSum_noGua;		//租赁余额_没有担保集团担保的
//	private Double entReSum_gua;		//股权退出余额_有担保集团担保的
//	private Double entReSum_noGua;		//股权退出余额_没有担保集团担保的
//	private Double entReSum_gua;		//投资收回余额_有担保集团担保的
//	private Double entReSum_noGua;		//投资收回余额_没有担保集团担保的
	private Double totalSum_gua_rt;		//融投系业务合计_有担保集团担保的
	private Double totalSum_noGua_rt;	//融投系业务合计_没有担保集团担保的
	private Double replaceReSum;		//代偿余额
	private Double collectDebtsSum_rt;	//融投系清收清欠金额	= 委贷清收本金 + 委贷清收利息 + 担保的追偿金额 + 保费清收
	private Double totalSum_rt;			//融投系合计		= 在保余额 + 融投系业务合计_没有担保集团担保的 + 代偿余额
	private Double deRiskSum;			//项目总共化解金额	= 保外债权人融资金额 + 融投系合计
	
//	private List<Crm_client_relationMain> cmlist; 	//冗余字段，封装同一relationMain_ID的Crm_client_relationMain对象

	public String getRelationMain_ID() {
		return relationMain_ID;
	}

	public void setRelationMain_ID(String relationMain_ID) {
		this.relationMain_ID = relationMain_ID;
	}

	public String getRelationMainName() {
		return relationMainName;
	}

	public void setRelationMainName(String relationMainName) {
		this.relationMainName = relationMainName;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getProjectTypeID() {
		return projectTypeID;
	}

	public void setProjectTypeID(String projectTypeID) {
		this.projectTypeID = projectTypeID;
	}

	public String getProjectTypeName() {
		return projectTypeName;
	}

	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
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

	public Double getCapitalSum() {
		return capitalSum==null?0:capitalSum;
	}

	public void setCapitalSum(Double capitalSum) {
		this.capitalSum = capitalSum;
	}

	public Double getLiabilitySum() {
		return liabilitySum==null?0:liabilitySum;
	}

	public void setLiabilitySum(Double liabilitySum) {
		this.liabilitySum = liabilitySum;
	}

	public Double getGuarantySum() {
		return guarantySum==null?0:guarantySum ;
	}

	public void setGuarantySum(Double guarantySum) {
		this.guarantySum = guarantySum;
	}

	public Double getGuarantyEntrustSum() {
		return guarantyEntrustSum==null?0:guarantyEntrustSum ;
	}

	public void setGuarantyEntrustSum(Double guarantyEntrustSum) {
		this.guarantyEntrustSum = guarantyEntrustSum;
	}

	public Double getEntrustSum() {
		return entrustSum==null?0:entrustSum ;
	}

	public void setEntrustSum(Double entrustSum) {
		this.entrustSum = entrustSum;
	}

	public Double getCreditorSum() {
		return creditorSum==null?0:creditorSum ;
	}

	public void setCreditorSum(Double creditorSum) {
		this.creditorSum = creditorSum;
	}

	public Double getGuaReSum_zaibao() {
		return guaReSum_zaibao==null?0:guaReSum_zaibao ;
	}

	public void setGuaReSum_zaibao(Double guaReSum_zaibao) {
		this.guaReSum_zaibao = guaReSum_zaibao;
	}

	public Double getEntReSum_guaGroup() {
		return entReSum_guaGroup==null?0:entReSum_guaGroup ;
	}

	public void setEntReSum_guaGroup(Double entReSum_guaGroup) {
		this.entReSum_guaGroup = entReSum_guaGroup;
	}

	public Double getEntReSum_gua() {
		return entReSum_gua==null?0:entReSum_gua ;
	}

	public void setEntReSum_gua(Double entReSum_gua) {
		this.entReSum_gua = entReSum_gua;
	}

	public Double getEntReSum_noGua() {
		return entReSum_noGua==null?0:entReSum_noGua ;
	}

	public void setEntReSum_noGua(Double entReSum_noGua) {
		this.entReSum_noGua = entReSum_noGua;
	}

	public Double getReplaceReSum() {
		return replaceReSum==null?0:replaceReSum ;
	}

	public void setReplaceReSum(Double replaceReSum) {
		this.replaceReSum = replaceReSum;
	}

	public Double getCollectDebtsSum_rt() {
		return collectDebtsSum_rt==null?0:collectDebtsSum_rt ;
	}

	public void setCollectDebtsSum_rt(Double collectDebtsSum_rt) {
		this.collectDebtsSum_rt = collectDebtsSum_rt;
	}

	public Double getTotalSum_rt() {
		return totalSum_rt==null?0:totalSum_rt ;
	}

	public void setTotalSum_rt(Double totalSum_rt) {
		this.totalSum_rt = totalSum_rt;
	}

	public Double getDeRiskSum() {
		return deRiskSum==null?0:deRiskSum ;
	}

	public void setDeRiskSum(Double deRiskSum) {
		this.deRiskSum = deRiskSum;
	}

//	public List<Crm_client_relationMain> getCmlist() {
//		return cmlist;
//	}
//
//	public void setCmlist(List<Crm_client_relationMain> cmlist) {
//		this.cmlist = cmlist;
//	}

	public Double getTotalSum_gua_rt() {
		return totalSum_gua_rt==null?0:totalSum_gua_rt ;
	}

	public void setTotalSum_gua_rt(Double totalSum_gua_rt) {
		this.totalSum_gua_rt = totalSum_gua_rt;
	}

	public Double getTotalSum_noGua_rt() {
		return totalSum_noGua_rt==null?0:totalSum_noGua_rt ;
	}

	public void setTotalSum_noGua_rt(Double totalSum_noGua_rt) {
		this.totalSum_noGua_rt = totalSum_noGua_rt;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientGUID() {
		return clientGUID;
	}

	public void setClientGUID(String clientGUID) {
		this.clientGUID = clientGUID;
	}

	public String getRelationTypeID() {
		return relationTypeID;
	}

	public void setRelationTypeID(String relationTypeID) {
		this.relationTypeID = relationTypeID;
	}

	public String getRelationTypeName() {
		return relationTypeName;
	}

	public void setRelationTypeName(String relationTypeName) {
		this.relationTypeName = relationTypeName;
	}
	
}
