package com.zjm.gworkFlow.util;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjm.gworkFlow.db.model.StepRecord;

/** 
 * @author 作者 E-mail: java_lishuai@163.com
 * @version 创建时间：2015-1-19 下午8:01:46 
 * 类说明： 
 */
public class FlowTools {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpServletResponse httpServletResponse;
	private HttpServletRequest httpServletRequest;
//	private Map<String,Object> session;
	
	/**
	 * 设置操作步骤
	 * @param type
	 * @param value
	 * @return
	 */
	public Boolean setRecordStep(Map<String,Object> session,String type,String value){
		StepRecord record = new StepRecord();
		record.setOptionalItem(formatCNText(value));
		session.remove("stepRecord");
		session.put("stepRecord",record);
		return false;
	}
	
	/**
	 * 获取操作步骤
	 * @return
	 */
	public StepRecord getRecordStep(){
		
		return null;
	}
	
	/**
	 * 转换中文编码
	 * @param text
	 * @return
	 */
	private String formatCNText(String text) {
		String actionNameCon = "";
		try {
			actionNameCon = java.net.URLDecoder.decode(text,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return actionNameCon;
	}

	public void setServletResponse(HttpServletResponse httpServletResponse) {
		this.httpServletResponse = httpServletResponse;
	}

	public void setServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}

	public void setSession(Map<String, Object> map) {
//		this.session = map;
	}

}

