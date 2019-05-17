package com.zjm.crm.report.model;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.zjm.util.SystemSession;

public class ReportParam implements Serializable {
	private String file;// 报表模板路径
	private String begindate;// 默认起始日期
	private String enddate;// 默认结束日期
	private Boolean isshowstats;// 是否显示统计条件
	private String busitype;//业务品种类型
	private String datename;//当前查询时间名称 
	private String endyearmonthsql;  // 统计年月
	private String createManName;
	private String begindatesql;
	private String enddatesql;
	
	private  String  endyearsql;//统计年
	
	private String pageType;
	private String groupTypeName;//分组类型名称
	

	/*
	 *  all : 包含所有条件,不进行过滤(默认是显示所有条件)
	 *  统计条件包含 : "统计期间" , "合作银行" , "业务品种" , "业务部门" , "A角" , "B角" , "C角" , "期限长短" , "担保金额大小"
	 */
	private String statscondition;// 统计条件
	
	private String unituid;//担保机构ID
	
	private String busiTypeView;//业务品种类型 用于控制提交统计条件 提交的form   mashuo add 20150706

	public ReportParam(){
		this.isshowstats = true;
		this.statscondition = "all";
		this.unituid = SystemSession.getUserSession().getUnit_uid();
	}
	
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}


	public String getStatscondition() {
		return statscondition;
	}

	public void setStatscondition(String statscondition) {
		String decode = "";
		try {
			decode = URLDecoder.decode(statscondition, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		this.statscondition = decode;
	}

	

	

	public String getDatename() {
		return datename;
	}

	public void setDatename(String datename) {
		String decode = "";
		try {
			decode = URLDecoder.decode(datename, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		this.datename = decode;
	}


	public String getBegindate() {
		return begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public Boolean getIsshowstats() {
		return isshowstats;
	}

	public void setIsshowstats(Boolean isshowstats) {
		this.isshowstats = isshowstats;
	}

	public String getBusitype() {
		return busitype;
	}

	public void setBusitype(String busitype) {
		this.busitype = busitype;
	}

	public String getBeginDate() {
		return this.getBegindate();
	}

	public String getEndDate() {
		return this.getEnddate();
	}

	public String getBusiTypeView() {
		return busiTypeView;
	}

	public void setBusiTypeView(String busiTypeView) {
		this.busiTypeView = busiTypeView;
	}

	

	public String getUnituid() {
		return unituid;
	}

	public void setUnituid(String unituid) {
		this.unituid = unituid;
	}

	public String getCreateManName() {
		return createManName;
	}

	public void setCreateManName(String createManName) {
		this.createManName = createManName;
	}

	public String getBegindatesql() {
		return begindatesql;
	}

	public void setBegindatesql(String begindatesql) {
		this.begindatesql = begindatesql;
	}

	public String getEnddatesql() {
		return enddatesql;
	}

	public void setEnddatesql(String enddatesql) {
		this.enddatesql = enddatesql;
	}

	public String getEndyearmonthsql() {
		return endyearmonthsql;
	}

	public void setEndyearmonthsql(String endyearmonthsql) {
		this.endyearmonthsql = endyearmonthsql;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public String getGroupTypeName() {
		return groupTypeName;
	}

	public void setGroupTypeName(String groupTypeName) {
		this.groupTypeName = groupTypeName;
	}

	public String getEndyearsql() {
		return endyearsql;
	}

	public void setEndyearsql(String endyearsql) {
		this.endyearsql = endyearsql;
	}
    
}
