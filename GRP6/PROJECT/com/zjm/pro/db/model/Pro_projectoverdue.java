package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shsong
 *	逾期费用明细表
 */
public class Pro_projectoverdue implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String overdue_ID; 		//主键
	private String project_ID; 		//放款明细表id
	private Double capital; 		//未还本金
	private Double interest; 		//未还利息
	private Double defautInterest;	//利息额
	private Double compoundInterest;//复利额
	private Double interestSum;		//累计欠息额
	private Date startTime;			//开始时间
	private Date endTime;			//结束时间
	private Date createTime;		//创建时间
	
	public String getOverdue_ID() {
		return overdue_ID;
	}
	public void setOverdue_ID(String overdue_ID) {
		this.overdue_ID = overdue_ID;
	}
	public String getProject_ID() {
		return project_ID;
	}
	public void setProject_ID(String project_ID) {
		this.project_ID = project_ID;
	}
	public Double getCapital() {
		return capital;
	}
	public void setCapital(Double capital) {
		this.capital = capital;
	}
	public Double getInterest() {
		return interest;
	}
	public void setInterest(Double interest) {
		this.interest = interest;
	}
	public Double getDefautInterest() {
		return defautInterest;
	}
	public void setDefautInterest(Double defautInterest) {
		this.defautInterest = defautInterest;
	}
	public Double getCompoundInterest() {
		return compoundInterest;
	}
	public void setCompoundInterest(Double compoundInterest) {
		this.compoundInterest = compoundInterest;
	}
	public Double getInterestSum() {
		return interestSum;
	}
	public void setInterestSum(Double interestSum) {
		this.interestSum = interestSum;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
		
	
}
