package com.zjm.sys.clientCode.service;

import com.zjm.common.db.model.User;
import com.zjm.sys.db.model.Sys_clientCode;
/**
 * 客户编号
 * @author chenyang   add 20170524
 */
public interface ClientCodeService {
	
	/**
	 * 查询一个客户编号信息
	 * @param sys_clientCode
	 * @return
	 */
	public Sys_clientCode selectOneClientCodeInfo(Sys_clientCode clientCode);
	
	/**
	 * 更新客户编号信息
	 * @param sys_clientCode
	 * @return
	 */
	public Boolean updateOneClientCodeInfo(User user,Sys_clientCode clientCode);
	
	/**
	 * 新增客户时获取编号当前值
	 * @return
	 */
	public Sys_clientCode returnOneClientCode(User user,String clientTypeID);


}
