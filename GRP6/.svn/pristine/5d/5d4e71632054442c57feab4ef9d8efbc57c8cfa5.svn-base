package com.zjm.common.login.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.User;
import com.zjm.common.login.service.LoginService;
import com.zjm.util.SystemSession;
import com.zjm.common.db.map.SysDicDataMapper;
import com.zjm.common.db.map.UserMapper;
/**
 * 登录
 * @author mashuo add 20170522
 */
@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {
	@Resource 
	private UserMapper  userMapper;
	@Resource 
	private SysDicDataMapper sysDicDataMapper;//公用字典
	/**
	 * 根据登录名获取用户信息
	 * @param user
	 * @return
	 */
	public User selectOneUserByLoginName(User user) {
		return userMapper.selectOneUserByLoginName(user);
	}
	/**
     * 更新个人设置
     * @return
     */
	public Boolean updateUserSetInfo(User user) {
		user.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		user.setUpdate_user(SystemSession.getUserSession().getUser_name());
		if(userMapper.updateUserSetInfo(user)==1){
			return true;
		}else{
			return false;
		}
	}
	
	

}
