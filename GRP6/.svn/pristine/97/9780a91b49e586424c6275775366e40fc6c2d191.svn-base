package com.zjm.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;


import com.zjm.common.db.model.Const;
import com.zjm.common.db.model.User;

public class SystemSession {
	/**
	 * 获取当前对象的拷贝
	 * @return
	 */
	public static User getUserSession() {
		User sys_user=null;
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		if (null != session) {
			Object obj = session.getAttribute(Const.SESSION_USER);
			if(obj!=null && obj instanceof User){
				try {
					sys_user=(User)BeanUtils.cloneBean((User) obj);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
		return sys_user;
	}
	/**
	 * 获取当前真实的对象，可以进行操作实体
	 * @return
	 */
	public static User getRealUserSession() {
		User sys_user=null;
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		if (null != session) {
			Object obj = session.getAttribute(Const.SESSION_USER);
			if(obj!=null && obj instanceof User){
				try {
					sys_user=(User) obj;
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
		return sys_user;
	}

	
	
	
	
	
}
