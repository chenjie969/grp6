package com.zjm.sys.roles.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.map.Sys_role_dataMapper;
import com.zjm.sys.db.map.Sys_role_functionMapper;
import com.zjm.sys.db.map.Sys_role_moduleMapper;
import com.zjm.sys.db.map.Sys_role_postMapper;
import com.zjm.sys.db.map.Sys_role_userMapper;
import com.zjm.sys.db.map.Sys_role_usergroupMapper;
import com.zjm.sys.db.map.Sys_rolesMapper;
import com.zjm.sys.db.model.Sys_role_data;
import com.zjm.sys.db.model.Sys_role_function;
import com.zjm.sys.db.model.Sys_role_module;
import com.zjm.sys.db.model.Sys_role_post;
import com.zjm.sys.db.model.Sys_role_user;
import com.zjm.sys.db.model.Sys_role_usergroup;
import com.zjm.sys.db.model.Sys_roles;
import com.zjm.sys.roles.service.RolesService;
import com.zjm.util.SystemSession;

/**
 * 角色设置
 * @author mashuo  add 20170524
 *
 */
@Service("rolesService")
@Transactional
public class RolesServiceImpl implements RolesService {
	@Resource
	private Sys_rolesMapper sys_rolesMapper;
	@Resource
	private Sys_role_userMapper sys_role_userMapper;
	@Resource
	private Sys_role_postMapper sys_role_postMapper;
	@Resource
	private Sys_role_usergroupMapper sys_role_usergroupMapper;
	@Resource
	private Sys_role_moduleMapper sys_role_moduleMapper;
	@Resource
	private Sys_role_functionMapper sys_role_functionMapper;
	@Resource
	private Sys_role_dataMapper sys_role_dataMapper;
	
	/**
	 * 返回角色分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectRolesPageTables(PageTable pageTable) {
		List<Sys_roles> list=sys_rolesMapper.selectRolesPageTables(pageTable);
		Long total=sys_rolesMapper.selectRolesPageTables_Count(pageTable);
		pageTable.setRows(list);
		pageTable.setTotal(total);
		return pageTable;
	}

	/**
	 * 插入一个角色信息
	 * @param sys_roles
	 * @return
	 */
	public Boolean insertOneRolesInfo(Sys_roles sys_roles) {
		//查询角色记录数
		Long total=sys_rolesMapper.selectRolesPageTables_Count(new PageTable());
		sys_roles.setOrder_id(total.intValue());
		if(sys_rolesMapper.insertOneRolesInfo(sys_roles)==1){
			//插入角色与用户的关系表
			if(sys_roles.getUser_uids()!=null && !sys_roles.getUser_uids().equals("")){
				String[] user_uids=sys_roles.getUser_uids().replaceAll("", "").split(",");
				Sys_role_user sys_role_user=new Sys_role_user();
				for(int i=0;i<user_uids.length;i++){
					if(user_uids[i]!=null && !user_uids[i].equals("")){
						sys_role_user=new Sys_role_user();
						sys_role_user.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
						sys_role_user.setUser_uid(user_uids[i]);
						sys_role_user.setRole_uid(sys_roles.getRole_uid());
						Integer b=sys_role_userMapper.insertOneUserAndRolesInfo(sys_role_user);
					}
				}
			}
			//插入角色与岗位的关系表
			if(sys_roles.getPost_IDs()!=null && !sys_roles.getPost_IDs().equals("")){
				String[] post_IDs=sys_roles.getPost_IDs().replaceAll("", "").split(",");
				Sys_role_post sys_role_post=new Sys_role_post();
				for(int i=0;i<post_IDs.length;i++){
					if(post_IDs[i]!=null && !post_IDs[i].equals("")){
						sys_role_post=new Sys_role_post();
						sys_role_post.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
						sys_role_post.setPost_ID(post_IDs[i]);
						sys_role_post.setRole_uid(sys_roles.getRole_uid());
						Integer b=sys_role_postMapper.insertOnePostAndRolesInfo(sys_role_post);
					}
				}
			}
			//插入角色与项目组的关系表
			if(sys_roles.getUserGroup_uuids()!=null && !sys_roles.getUserGroup_uuids().equals("")){
				String[] userGroup_uuids=sys_roles.getUserGroup_uuids().replaceAll("", "").split(",");
				Sys_role_usergroup sys_role_usergroup=new Sys_role_usergroup();
				for(int i=0;i<userGroup_uuids.length;i++){
					if(userGroup_uuids[i]!=null && !userGroup_uuids[i].equals("")){
						sys_role_usergroup=new Sys_role_usergroup();
						sys_role_usergroup.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
						sys_role_usergroup.setUserGroup_uuid(userGroup_uuids[i]);
						sys_role_usergroup.setRole_uid(sys_roles.getRole_uid());
						Integer b=sys_role_usergroupMapper.insertOneUserGroupAndRolesInfo(sys_role_usergroup);
					}
				}
			}
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 判断角色名称是否重复
	 * @param wheresql
	 * @return
	 */
	public Boolean selectRolesNameIsExist(String wheresql) {
		if(sys_rolesMapper.selectRolesNameIsExist(wheresql)==0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 查询一个角色信息
	 * @param usergroup
	 * @return
	 */
	public Sys_roles selectOneRolesInfo(Sys_roles usergroup) {
		usergroup= sys_rolesMapper.selectOneRolesInfo(usergroup);
		return usergroup;
	}

	/**
	 * 更新一个角色信息
	 * @param sys_roles
	 * @return
	 */
	public Boolean updateOneRolesInfo(Sys_roles sys_roles) {
		if(sys_rolesMapper.updateOneRolesInfo(sys_roles)==1){
			//删除角色与用户的关系表
			Integer a=sys_role_userMapper.delectUserAndRolesInfo(sys_roles);
			//插入角色与用户的关系表
			if(sys_roles.getUser_uids()!=null && !sys_roles.getUser_uids().equals("")){
				String[] user_uids=sys_roles.getUser_uids().replaceAll("", "").split(",");
				Sys_role_user sys_role_user=new Sys_role_user();
				for(int i=0;i<user_uids.length;i++){
					if(user_uids[i]!=null && !user_uids[i].equals("")){
						sys_role_user=new Sys_role_user();
						sys_role_user.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
						sys_role_user.setUser_uid(user_uids[i]);
						sys_role_user.setRole_uid(sys_roles.getRole_uid());
						Integer b=sys_role_userMapper.insertOneUserAndRolesInfo(sys_role_user);
					}
				}
			}
			//删除角色与岗位的关系表
			Integer a1=sys_role_postMapper.delectPostAndRolesInfo(sys_roles);
			//插入角色与岗位的关系表
			if(sys_roles.getPost_IDs()!=null && !sys_roles.getPost_IDs().equals("")){
				String[] post_IDs=sys_roles.getPost_IDs().replaceAll("", "").split(",");
				Sys_role_post sys_role_post=new Sys_role_post();
				for(int i=0;i<post_IDs.length;i++){
					if(post_IDs[i]!=null && !post_IDs[i].equals("")){
						sys_role_post=new Sys_role_post();
						sys_role_post.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
						sys_role_post.setPost_ID(post_IDs[i]);
						sys_role_post.setRole_uid(sys_roles.getRole_uid());
						Integer b=sys_role_postMapper.insertOnePostAndRolesInfo(sys_role_post);
					}
				}
			}
			//删除角色与项目组的关系表
			Integer a2=sys_role_usergroupMapper.delectUserGroupAndRolesInfo(sys_roles);
			//插入角色与项目组的关系表
			if(sys_roles.getUserGroup_uuids()!=null && !sys_roles.getUserGroup_uuids().equals("")){
				String[] userGroup_uuids=sys_roles.getUserGroup_uuids().replaceAll("", "").split(",");
				Sys_role_usergroup sys_role_usergroup=new Sys_role_usergroup();
				for(int i=0;i<userGroup_uuids.length;i++){
					if(userGroup_uuids[i]!=null && !userGroup_uuids[i].equals("")){
						sys_role_usergroup=new Sys_role_usergroup();
						sys_role_usergroup.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
						sys_role_usergroup.setUserGroup_uuid(userGroup_uuids[i]);
						sys_role_usergroup.setRole_uid(sys_roles.getRole_uid());
						Integer b=sys_role_usergroupMapper.insertOneUserGroupAndRolesInfo(sys_role_usergroup);
					}
				}
			}
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 删除一个角色信息
	 * @param sys_roles
	 * @return
	 */
	public Boolean delectOneRolesInfo(Sys_roles sys_roles) {
		//删除角色与用户的关系表
		Integer a=sys_role_userMapper.delectUserAndRolesInfo(sys_roles);
		//删除角色与岗位的关系表
		Integer a1=sys_role_postMapper.delectPostAndRolesInfo(sys_roles);
		//删除角色与项目组的关系表
		Integer a2=sys_role_usergroupMapper.delectUserGroupAndRolesInfo(sys_roles);
		//删除角色与菜单的关系表
		Integer a3=sys_role_moduleMapper.delectModuleAndRolesInfo(sys_roles);
		if(sys_rolesMapper.delectOneRolesInfo(sys_roles)==1){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 查询角色列表List
	 * @param wheresql
	 * @return
	 */
	public List<Sys_roles> selectRolesList(String wheresql) {
		return sys_rolesMapper.selectRolesList(wheresql);
	}

	/**
	 * 对一个角色授权
	 * @param sys_roles
	 * @return
	 */
	public Boolean updateOneRolesAccreditInfo(Sys_roles sys_roles) {
		try {
			//删除角色与菜单的关系表
			Integer a1=sys_role_moduleMapper.delectModuleAndRolesInfo(sys_roles);
			//插入角色与菜单的关系表
			if(sys_roles.getMod_uids()!=null && !sys_roles.getMod_uids().equals("")){
				String[] mod_uids=sys_roles.getMod_uids().replaceAll("", "").split(",");
				Sys_role_module sys_role_module=new Sys_role_module();
				for(int i=0;i<mod_uids.length;i++){
					if(mod_uids[i]!=null && !mod_uids[i].equals("")){
						sys_role_module=new Sys_role_module();
						sys_role_module.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
						sys_role_module.setMod_uid(mod_uids[i]);
						sys_role_module.setRole_uid(sys_roles.getRole_uid());
						Integer b=sys_role_moduleMapper.insertOneModuleAndRolesInfo(sys_role_module);
					}
				}
			}
			//删除角色与功能的关系表
			Integer a2=sys_role_functionMapper.delectFunctionAndRolesInfo(sys_roles);
			//插入角色与功能的关系表
			if(sys_roles.getFun_ids()!=null && !sys_roles.getFun_ids().equals("")){
				String[] fun_ids=sys_roles.getFun_ids().replaceAll("", "").split(",");
				Sys_role_function sys_role_function=new Sys_role_function();
				for(int i=0;i<fun_ids.length;i++){
					if(fun_ids[i]!=null && !fun_ids[i].equals("")){
						sys_role_function=new Sys_role_function();
						sys_role_function.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
						sys_role_function.setFun_id(fun_ids[i]);
						sys_role_function.setRole_uid(sys_roles.getRole_uid());
						Integer b=sys_role_functionMapper.insertOneFunctionAndRolesInfo(sys_role_function);
					}
				}
			}
			//更新 权限与数据类型关联表
			if( null != sys_roles.getProDataType() && !"".equals(sys_roles.getProDataType() )){
				insertOrUpdateRoleData(sys_roles, 2,Integer.valueOf(sys_roles.getProDataType()));//更新或添加项目数据授权类型
			}
			if(null != sys_roles.getClientDataType() && !"".equals(sys_roles.getClientDataType())){
				insertOrUpdateRoleData(sys_roles, 1,Integer.valueOf(sys_roles.getClientDataType()));//更新或添加客户数据授权类型
			}
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * @param sys_roles
	 * @param operationType  1:客户数据授权类型    2:项目数据授权类型
	 * @return
	 */
	private int insertOrUpdateRoleData(Sys_roles sys_roles , int operationType ,int accreditType){
		int res = 0;
		
		Sys_role_data sysRoleData = new Sys_role_data();
		sysRoleData.setRole_uid(sys_roles.getRole_uid());
		sysRoleData.setOperation_type(operationType);
		//查询
		Sys_role_data data = sys_role_dataMapper.selectOneData(sysRoleData);
		if( null != data){
			data.setAccredit_type(Integer.valueOf(accreditType));
			data.setUnit_uid(sys_roles.getUnit_uid());
			res = sys_role_dataMapper.updateOneSysRolesData(data);
		}else{
			sysRoleData.setAccredit_type(accreditType);
			sysRoleData.setUnit_uid(sys_roles.getUnit_uid());
			res = sys_role_dataMapper.insertOneDataAndRolesInfo(sysRoleData);
		}
		return res;
		
	}

	@Override
	public void testSql() {
		sys_role_dataMapper.testSqlOne();
		sys_role_dataMapper.testSqlTwo();
		
	}

}
