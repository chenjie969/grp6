package com.zjm.common.db.map;

import com.zjm.common.db.model.User;

public interface UserMapper {
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
	public Integer updateUserSetInfo(User user);
	
	/**
	 * 根据用户id获取用户信息
	 * @param user_uid
	 * @return
	 */
	User selectUserByUserUid(String user_uid);

}
