package com.zjm.sys.userGroup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.sys.db.map.Sys_user_usergroupMapper;
import com.zjm.sys.db.map.Sys_usergroupMapper;
import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.model.Sys_user_usergroup;
import com.zjm.sys.db.model.Sys_usergroup;
import com.zjm.sys.db.model.Sys_users;
import com.zjm.sys.userGroup.service.UserGroupService;
import com.zjm.util.SystemSession;

/**
 * 项目组设置
 * @author mashuo  add 20170512
 *
 */
@Service("userGroupService")
@Transactional
public class UserGroupServiceImpl implements UserGroupService {
	@Resource
	private Sys_usergroupMapper sys_usergroupMapper;
	@Resource
	private Sys_user_usergroupMapper sys_user_usergroupMapper;

	/**
	 * 返回项目组分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectUserGroupPageTables(PageTable pageTable) {
		List<Sys_usergroup> list=sys_usergroupMapper.selectUserGroupPageTables(pageTable);
		Long total=sys_usergroupMapper.selectUserGroupPageTables_Count(pageTable);
		pageTable.setRows(list);
		pageTable.setTotal(total);
		return pageTable;
	}

	/**
	 * 插入一个项目组信息
	 * @param sys_usergroup
	 * @return
	 */
	public Boolean insertOneUserGroupInfo(Sys_usergroup sys_usergroup) {
		//查询项目组记录数
		Long total=sys_usergroupMapper.selectUserGroupPageTables_Count(new PageTable());
		sys_usergroup.setOrder_id(total.intValue());
		if(sys_usergroupMapper.insertOneUserGroupInfo(sys_usergroup)==1){
			if(sys_usergroup.getUser_uids()!=null && !sys_usergroup.getUser_uids().equals("")){
				String[] user_uids=sys_usergroup.getUser_uids().replaceAll("", "").split(",");
				Sys_user_usergroup Sys_user_usergroup=new Sys_user_usergroup();
				for(int i=0;i<user_uids.length;i++){
					if(user_uids[i]!=null && !user_uids[i].equals("")){
						Sys_user_usergroup=new Sys_user_usergroup();
						Sys_user_usergroup.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
						Sys_user_usergroup.setUser_uid(user_uids[i]);
						Sys_user_usergroup.setUserGroup_uuid(sys_usergroup.getUserGroup_uuid());
						Integer b=sys_user_usergroupMapper.insertOneUserAndUserGroupInfo(Sys_user_usergroup);
					}
				}
			}
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 判断项目组名称是否重复
	 * @param wheresql
	 * @return
	 */
	public Boolean selectUserGroupNameIsExist(String wheresql) {
		if(sys_usergroupMapper.selectUserGroupNameIsExist(wheresql)==0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 查询一个项目组信息
	 * @param usergroup
	 * @return
	 */
	public Sys_usergroup selectOneUserGroupInfo(Sys_usergroup usergroup) {
		usergroup= sys_usergroupMapper.selectOneUserGroupInfo(usergroup);
		List<Sys_users> userList=sys_user_usergroupMapper.selectOneUserGroupDownUserList(usergroup);
		String user_uids="";
		String user_names="";
		for (Sys_users sys_users : userList) {
			user_uids=user_uids+sys_users.getUser_uid()+",";
			user_names=user_names+sys_users.getUser_name()+",";
		}
		usergroup.setUser_uids(user_uids);
		usergroup.setUser_names(user_names);
		return usergroup;
	}

	/**
	 * 更新一个项目组信息
	 * @param sys_usergroup
	 * @return
	 */
	public Boolean updateOneUserGroupInfo(Sys_usergroup sys_usergroup) {
		if(sys_usergroupMapper.updateOneUserGroupInfo(sys_usergroup)==1){
			Integer a=sys_user_usergroupMapper.delectUserAndUserGroupInfo(sys_usergroup);
			if(sys_usergroup.getUser_uids()!=null && !sys_usergroup.getUser_uids().equals("")){
				String[] user_uids=sys_usergroup.getUser_uids().replaceAll("", "").split(",");
				Sys_user_usergroup Sys_user_usergroup=new Sys_user_usergroup();
				for(int i=0;i<user_uids.length;i++){
					if(user_uids[i]!=null && !user_uids[i].equals("")){
						Sys_user_usergroup=new Sys_user_usergroup();
						Sys_user_usergroup.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
						Sys_user_usergroup.setUser_uid(user_uids[i]);
						Sys_user_usergroup.setUserGroup_uuid(sys_usergroup.getUserGroup_uuid());
						Integer b=sys_user_usergroupMapper.insertOneUserAndUserGroupInfo(Sys_user_usergroup);
					}
				}
			}
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 删除一个项目组信息
	 * @param sys_usergroup
	 * @return
	 */
	public Boolean delectOneUserGroupInfo(Sys_usergroup sys_usergroup) {
		Integer a=sys_user_usergroupMapper.delectUserAndUserGroupInfo(sys_usergroup);
		if(sys_usergroupMapper.delectOneUserGroupInfo(sys_usergroup)==1){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 查询项目组列表List
	 * @param wheresql
	 * @return
	 */
	public List<Sys_usergroup> selectUserGroupList(String wheresql) {
		return sys_usergroupMapper.selectUserGroupList(wheresql);
	}

}
