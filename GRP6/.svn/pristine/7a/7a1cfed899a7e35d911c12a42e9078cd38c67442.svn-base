package com.zjm.sys.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.model.Sys_departs;
import com.zjm.sys.db.model.Sys_users;
import com.zjm.sys.db.model.Sys_users;

public interface Sys_usersMapper {
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<Sys_users> selectAllUsersList(String wheresql);
	/**
	 * 插入一个用户信息
	 * @return
	 */
	public Integer insertOneUsersInfo(Sys_users sys_users);
	/**
	 * 查询一个用户信息
	 * @return
	 */
	public Sys_users selectOneUsersInfo(Sys_users sys_users);
	/**
	 * 更新一个用户信息
	 * @return
	 */
	public Integer updateOneUsersInfo(Sys_users sys_users);
	/**
	 * 删除一个用户信息
	 * @return
	 */
	public Integer deleteOneUsersInfo(Sys_users sys_users);
	
	/**
	 * 查询用户列表    分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Sys_users> selectUsersPageTables(PageTable<Sys_users> pageTable);
	/**
	 * 查询用户列表    总记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectUsersPageTables_Count(PageTable<Sys_users> pageTable);
	
	/**
	 * 公共排序方法
	 * @param wheresql
	 */
	public void updateSortOrder(String wheresql);
	/**
	 * 判断是否存在
	 * @param wheresql
	 * @return
	 */
	public Integer selectUsersIdIsExist(String wheresql);
	
	/**
	 * 查询同部门下共有多少用户
	 * @return
	 */
	public Integer selectUsersOrderId(Sys_users sys_users);
	/**
	 * 查看某用户的密码是否存在
	 * @param sys_user
	 * @return
	 */
	public int selectUsersIsUpdatePwd(Sys_users sys_user);

	public List<Sys_users> selectPostUsersPageTables(PageTable<Sys_users> pageTable);

	public Long selectPostUsersPageTables_Count(PageTable<Sys_users> pageTable);
	/**
	 * 取得最大的用户编号
	 * @return
	 */
	public String selectMaxUserBh();
	
	/**
	 * 获取部门下的人员
	 * @param wheresql
	 */
	public List<Sys_users> selectUsersListByDepartUid(String wheresql);
	
	/**
	 * 根据用户id获取用户所在部门
	 * @param userId
	 * @return 
	 */
	public Sys_departs getDepartByUserId(String userId);
	
}
