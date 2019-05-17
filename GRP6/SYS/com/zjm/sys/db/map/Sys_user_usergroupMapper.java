package com.zjm.sys.db.map;

import java.util.List;

import com.zjm.sys.db.model.Sys_user_usergroup;
import com.zjm.sys.db.model.Sys_usergroup;
import com.zjm.sys.db.model.Sys_users;

public interface Sys_user_usergroupMapper {
	/**
	 * 查询一个项目组下的用户List
	 * @param usergroup
	 * @return
	 */
	public List<Sys_users> selectOneUserGroupDownUserList(Sys_usergroup usergroup);
	/**
	 * 插入一个用户与项目组关联表信息
	 * @param sys_user_usergroup
	 * @return
	 */
	public Integer insertOneUserAndUserGroupInfo(Sys_user_usergroup sys_user_usergroup);
	/**
	 * 删除一个用户与项目组关联表信息
	 * @param sys_usergroup
	 * @return
	 */
	public Integer delectUserAndUserGroupInfo(Sys_usergroup sys_usergroup);
	/**
	 * 根据用户user_uid删除用户组和用户的关系
	 * @param user_uid
	 */
	public Integer delectUserAndUserGroupInfoByUserUid(String user_uid);

}
