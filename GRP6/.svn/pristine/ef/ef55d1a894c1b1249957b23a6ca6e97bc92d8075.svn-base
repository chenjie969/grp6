package com.zjm.sys.db.map;


import com.zjm.sys.db.model.Sys_role_user;
import com.zjm.sys.db.model.Sys_roles;

public interface Sys_role_userMapper {
	/**
	 * 插入一个用户与角色关联表信息
	 * @param sys_role_user
	 * @return
	 */
	public Integer insertOneUserAndRolesInfo(Sys_role_user sys_role_user);
	/**
	 * 删除一个用户与角色关联表信息
	 * @param sys_roles
	 * @return
	 */
	public Integer delectUserAndRolesInfo(Sys_roles sys_roles);
	/**
	 * 根据用户user_uid删除角色和用户的关系
	 * @param user_uid
	 */
	public Integer delectUserAndRolesInfoByUserUid(String user_uid);

}
