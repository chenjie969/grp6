package com.zjm.common.db.model;

import java.io.Serializable;

public class AjaxRes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String code;
	private String msg;
	private Object obj;
	//========================get/set============================
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	/**
	 * 设置成功值
	 * @param obj  设置对象  
	 * @param msg  设置码值解析
	 */
	public void setSucceed(Object obj,String msg){
		this.setMsg(msg);
		this.setSucceed(obj);
		this.setCode(Const.SUCCEED);
	}
	/**
	 * 设置成功值
	 * @param obj 设置对象    
	 */
	public void setSucceed(Object obj){
		this.obj = obj;
		this.setCode(Const.SUCCEED);
	}
	/**
	 * 设置成功值
	 * @param msg 返回码值解析
	 */
	public void setSucceedMsg(String msg){
		this.setCode(Const.SUCCEED);
		this.setMsg(msg);
	}
	/**
	 * 设置失败值
	 * @param msg 返回码值解析
	 */
	public void setFailMsg(String msg){
		this.obj = null;
		this.setCode(Const.FAIL);
		this.setMsg(msg);
	}
	/**
	 * 设置失败值
	 * @param obj 设置对象 
	 * @param msg 返回码值解析
	 */
	public void setFailMsg(Object obj,String msg){
		this.obj = obj;
		this.setCode(Const.FAIL);
		this.setMsg(msg);
	}
	
	

}
