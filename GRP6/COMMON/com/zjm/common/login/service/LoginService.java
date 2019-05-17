package com.zjm.common.login.service;

import java.util.List;

import com.zjm.common.db.model.SysDicData;
import com.zjm.common.db.model.User;

/**
 * 登录
 * @author mashuo add 20170522
 */
public interface LoginService {
	/**
	 * 根据登录名获取用户信息
	 * @param user
	 * @return
	 */
	public User selectOneUserByLoginName(User user);
	/**
     * 更新个人设置
     * @return
     */
	public Boolean updateUserSetInfo(User user);
	

}
