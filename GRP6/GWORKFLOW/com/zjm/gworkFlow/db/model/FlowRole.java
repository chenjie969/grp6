package com.zjm.gworkFlow.db.model;

import java.util.Map;

/**
 * @author 作者 E-mail: java_lishuai@163.com
 * @version 创建时间：2014-12-7 下午11:42:22 类说明：
 */
public class FlowRole {
	/* 1.nodynamicsplitrole: 非动态分支角色
	   2. dynamicsplitrole: 动态分支角色  
	   3.autodynamicsplitrole 自动动态分支角色  
	   4.prestepowner 前面某个步骤的操作人
	   5.rolenoexit 角色不存在    
	   6.rolenousers 角色没有人
	   7.autosyschooseuser 自动由系统取人，map中存的是用户的userid
	*/
	private String roleType;
	
	private Map<Long, String> roleMap; // 角色中文名称集合

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public Map<Long, String> getRoleMap() {
		return roleMap;
	}

	public void setRoleMap(Map<Long, String> roleMap) {
		this.roleMap = roleMap;
	}

}
