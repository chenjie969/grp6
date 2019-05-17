package com.zjm.pro.projectCode.service;

import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_projectCode;
/**
 * 客户编号
 * @author chenyang   add 20170524
 */
public interface ProjectCodeService {
	
	/**
	 * 查询一个项目编号信息
	 * @param Pro_projectCode
	 * @return
	 */
	public Pro_projectCode selectOneProjectCodeInfo(Pro_projectCode projectCode);
	
	/**
	 * 更新项目编号信息
	 * @param Pro_projectCode
	 * @return
	 */
	public Boolean updateOneProjectCodeInfo(User user,Pro_projectCode projectCode);
	
	/**
	 * 新增项目时获取编号当前值
	 * @return
	 */
	public Pro_projectCode returnOneProjectCode(User user,String projectType);



}
