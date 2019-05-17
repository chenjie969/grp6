package com.zjm.sys.db.map;

import com.zjm.sys.db.model.Sys_clientCode;

public interface Sys_clientCodeMapper {
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
	public Boolean updateOneClientCodeInfo(Sys_clientCode clientCode);
}
