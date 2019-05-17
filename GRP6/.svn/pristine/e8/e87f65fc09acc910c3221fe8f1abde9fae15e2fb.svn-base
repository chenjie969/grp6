package com.zjm.common.log.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.map.LogMapper;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.util.Tool;

/**
 * 日志接口
 * @author mashuo add 20170522
 *
 */
@Service("logService")
@Transactional
public class LogServiceImpl implements LogService {
	@Resource 
	private LogMapper  logMapper;

	/**
	 * 插入登录或登出日志
	 * @param logtype 操作类型  登录、退出
	 * @param logdescr 操作描述
	 */
	public void insertOneLoginLogInfo(User user, String logtype, String logdescr) {

		String sql="insert into sys_loglogin ("+
				"logLoginID,"+
				"unit_uid,"+
				"loginDateTime,"+
				"userName,"+
				"departName,"+
				"logType,"+
				"logDescr,"+
				"loginAccount,"+
				"ipAddress,"+
				"unit_uidName"+
				")"+
				"values ("+
				"\'"+Tool.createUUID32()+"\',"+
				"\'"+user.getUnit_uid()+"\',"+
				"NOW(),"+
				"\'"+user.getUser_name()+"\',"+
				"\'"+user.getDepart_name()+"\',"+
				"\'"+logtype+"\',"+
				"\'"+logdescr+"\',"+
				"\'"+user.getUser_id()+"\',"+
				"\'"+user.getIpaddress()+"\',"+
				"\'"+user.getUnit_uidName()+"\'"+
				")";
		logMapper.insertOneLogInfo(sql);
	}

	/**
	 * 插入操作日志
	 * @param modname 操作功能模块 
	 * @param openratortype  操作类型 添加、修改、删除
	 * @param logdescr  操作描述
	 */
	public void insertOneOperatorLogInfo(User user, String modname, String openratortype, String logdescr) {
		String sql=" insert into "+
				" sys_logoperator ("+
				"logOperatorID,"+
				"unit_uid,"+
				"operatorDateTime,"+
				"userName,"+
				"departName,"+
				"modName,"+
				"logDescr,"+
				"openratorType,"+
				"loginAccount,"+
				"ipAddress,"+
				"unit_uidName"+
				")"+
				"values ("+
				"\'"+Tool.createUUID32()+"\', "+
				"\'"+user.getUnit_uid()+"\',"+
				"NOW(),"+
				"\'"+user.getUser_name()+"\',"+
				"\'"+user.getDepart_name()+"\',"+
				"\'"+modname+"\',"+
				"\'"+logdescr+"\',"+
				"\'"+openratortype+"\',"+
				"\'"+user.getUser_id()+"\',"+
				"\'"+user.getIpaddress()+"\',"+
				"\'"+user.getUnit_uidName()+"\'"+
				")";
		logMapper.insertOneLogInfo(sql);
	}
}
