package com.zjm.sys.db.map;


import com.zjm.sys.db.model.Sys_role_usergroup;
import com.zjm.sys.db.model.Sys_roles;

public interface Sys_role_usergroupMapper {
	/**
	 * 插入一个项目组与角色关联表信息
	 * @param sys_role_user
	 * @return
	 */
	public Integer insertOneUserGroupAndRolesInfo(Sys_role_usergroup sys_role_usergroup);
	/**
	 * 删除一个项目组与角色关联表信息
	 * @param sys_roles
	 * @return
	 */
	public Integer delectUserGroupAndRolesInfo(Sys_roles sys_roles);

}
