package com.zjm.gbpm.db.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.zjm.oa.db.model.Oa_message;

/**
 * 首页统计用
 * @author chenyang add 20170726
 *
 */
public class Index implements Serializable {
	
	private String loadSum;//新增金额
	private Integer loadNum;//新增笔数
	private String returnSum;//解除金额
	private Integer returnNum;//解除笔数
	private String guarantySum;//在保余额
	private Integer guarantyNum;//笔数
	
	private Integer meetingPro;//上会项目
	private Integer noExpirePro;//未到期项目
	private Integer expirePro;//即将到期项目
	private Integer extendPro;//展期项目
	private Integer overPro;//逾期不代偿项目
	private Integer replacePro;//代偿项目
	private Integer endPro;//完结项目
	private Integer checkPro;//保后检查项目
	private Integer riskPro;//风险项目
	
	
	private Map<String, List<Oa_message>> messageMap;
	
	//==================get/set========================
	
	public String getLoadSum() {
		return loadSum;
	}
	public void setLoadSum(String loadSum) {
		this.loadSum = loadSum;
	}
	public String getReturnSum() {
		return returnSum;
	}
	public void setReturnSum(String returnSum) {
		this.returnSum = returnSum;
	}
	public String getGuarantySum() {
		return guarantySum;
	}
	public void setGuarantySum(String guarantySum) {
		this.guarantySum = guarantySum;
	}
	public Map<String, List<Oa_message>> getMessageMap() {
		return messageMap;
	}
	public void setMessageMap(Map<String, List<Oa_message>> messageMap) {
		this.messageMap = messageMap;
	}
	public Integer getMeetingPro() {
		return meetingPro;
	}
	public void setMeetingPro(Integer meetingPro) {
		this.meetingPro = meetingPro;
	}
	public Integer getOverPro() {
		return overPro;
	}
	public void setOverPro(Integer overPro) {
		this.overPro = overPro;
	}
	public Integer getExpirePro() {
		return expirePro;
	}
	public void setExpirePro(Integer expirePro) {
		this.expirePro = expirePro;
	}
	public Integer getReplacePro() {
		return replacePro;
	}
	public void setReplacePro(Integer replacePro) {
		this.replacePro = replacePro;
	}
	public Integer getRiskPro() {
		return riskPro;
	}
	public void setRiskPro(Integer riskPro) {
		this.riskPro = riskPro;
	}
	public Integer getCheckPro() {
		return checkPro;
	}
	public void setCheckPro(Integer checkPro) {
		this.checkPro = checkPro;
	}
	public Integer getLoadNum() {
		return loadNum;
	}
	public void setLoadNum(Integer loadNum) {
		this.loadNum = loadNum;
	}
	public Integer getReturnNum() {
		return returnNum;
	}
	public void setReturnNum(Integer returnNum) {
		this.returnNum = returnNum;
	}
	public Integer getGuarantyNum() {
		return guarantyNum;
	}
	public void setGuarantyNum(Integer guarantyNum) {
		this.guarantyNum = guarantyNum;
	}
	public Integer getNoExpirePro() {
		return noExpirePro;
	}
	public void setNoExpirePro(Integer noExpirePro) {
		this.noExpirePro = noExpirePro;
	}
	public Integer getExtendPro() {
		return extendPro;
	}
	public void setExtendPro(Integer extendPro) {
		this.extendPro = extendPro;
	}
	public Integer getEndPro() {
		return endPro;
	}
	public void setEndPro(Integer endPro) {
		this.endPro = endPro;
	}
}
