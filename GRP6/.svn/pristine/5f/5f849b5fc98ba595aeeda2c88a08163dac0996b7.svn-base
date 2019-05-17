package com.zjm.common.log.service;

import com.zjm.common.db.model.User;

public interface LogService {
	/**
	 * 插入登录或登出日志
	 * @param logtype 操作类型  登录、退出
	 * @param logdescr 操作描述
	 */
	public void insertOneLoginLogInfo(User user, String logtype, String logdescr);
	/**
	 * 插入操作日志
	 * @param modname 操作功能模块 
	 * @param openratortype  操作类型 添加、修改、删除
	 * @param logdescr  操作描述
	 */
	public void insertOneOperatorLogInfo(User user, String modname, String openratortype, String logdescr);

}
