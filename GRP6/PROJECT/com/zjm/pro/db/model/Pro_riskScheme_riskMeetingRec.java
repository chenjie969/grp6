package com.zjm.pro.db.model;

import java.io.Serializable;

public class Pro_riskScheme_riskMeetingRec implements Serializable {

	/**
	 * 会议记录与化解方案关联表
	 */
	private static final long serialVersionUID = 1L;
	private String riskScheme_ID;           //化解方案ID
	private String riskMeetingRec_ID;	    //会议记录ID
	
	public String getRiskScheme_ID() {
		return riskScheme_ID;
	}
	public void setRiskScheme_ID(String riskScheme_ID) {
		this.riskScheme_ID = riskScheme_ID;
	}
	public String getRiskMeetingRec_ID() {
		return riskMeetingRec_ID;
	}
	public void setRiskMeetingRec_ID(String riskMeetingRec_ID) {
		this.riskMeetingRec_ID = riskMeetingRec_ID;
	}

}
