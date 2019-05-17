package com.zjm.sys.units.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.sys.db.map.Sys_dep_userMapper;
import com.zjm.sys.db.map.Sys_unitsMapper;
import com.zjm.sys.db.model.Sys_departs;
import com.zjm.sys.db.model.Sys_post;
import com.zjm.sys.db.model.Sys_units;
import com.zjm.sys.db.model.Sys_users;
import com.zjm.sys.departs.service.DepartsService;
import com.zjm.sys.post.service.PostService;
import com.zjm.sys.units.service.UnitsService;
import com.zjm.sys.users.service.UsersService;
import com.zjm.util.Tool;
/**
 * 担保机构设置
 * @author duanhuawei  add 20170425
 */
@Service("unitsService")
@Transactional
public class UnitsServiceImpl implements UnitsService{
	@Resource 
	private Sys_unitsMapper  sys_unitsMapper;
	@Resource 
	private LogService  logService;
	@Resource
	private DepartsService   departsService; //部门service
	@Resource
	private UsersService usersService;//用户 mashuo add 20170922
	@Resource
	private PostService postService;//岗位  mashuo add 20170925
	
	
	
	/**
	 * 插入一个机构信息
	 * @return
	 */
	public Boolean insertOneUnitsInfo(User user,Sys_units sys_units) {
		try {
			sys_units.setUnit_uid(Tool.createUUID32());
			//查询同级节点下共有多少机构
			sys_units.setOrder_id(sys_unitsMapper.selectUnitsOrderId(sys_units));
			sys_units.setCreate_user(user.getUser_name());
			Sys_units pSys_units = sys_unitsMapper.selectPUnitsInfo(sys_units);
			String unit_uidFullCode = null;
			if (pSys_units != null) {
				unit_uidFullCode = pSys_units.getUnit_uidFullCode()+sys_units.getUnit_uid()+"/";
			} else {
				unit_uidFullCode = sys_units.getUnit_uid()+"/";
			}
			sys_units.setUnit_uidFullCode(unit_uidFullCode);
			logService.insertOneOperatorLogInfo(user,"机构设置", "添加", sys_units.getpUnitsName());
			
			
			if(sys_unitsMapper.insertOneUnitsInfo(sys_units)==1){
				Sys_departs departs=new Sys_departs();
				departs.setUnit_uid(sys_units.getUnit_uid());//担保机构编号  -->当前用户所在的担保机构
				//获取部门父节点代码  ---》河北融投集团节点代码
				// 机构为当前机构, 父类节点为1
				
				
				
				//mashuo edit 20170922 
				/*Sys_departs rootDepart=new Sys_departs();
				if("cbeb758e3d824626a31aabb2a9587b0a".equals(sys_units.getPunit_uid())){// 根机构的 下级子机构  -->默认机构根节点: cbeb758e3d824626a31aabb2a9587b0a
					rootDepart.setPdepart_id("1");
					rootDepart.setUnit_uid(user.getUnit_uid());
				}else{ // 子机构的子节点
					rootDepart.setUnit_uid(sys_units.getPunit_uid());
				}
				
				List<Sys_departs> list=	departsService.selectRootDepartByUnits(rootDepart); //当前机构的 根节点部门
				rootDepart=list.get(0);
				departs.setPdepart_id(rootDepart.getDepart_uid());*/
				departs.setPdepart_id("1");
				departs.setDepart_name("组织结构"); // 部门节点名称
				departs.setUrl("-");//部门节点url
				//mashuo edit 20170922  begin
				if(departsService.insertOneDepartsInfo(user, departs)){
					Sys_departs rootDepart=new Sys_departs();
					rootDepart.setUnit_uid(departs.getUnit_uid());
					rootDepart.setPdepart_id("1");
					List<Sys_departs> list=	departsService.selectRootDepartByUnits(rootDepart); //当前机构的 根节点部门
					rootDepart=list.get(0);
					Sys_departs adminDepart=new Sys_departs();
					adminDepart.setDepart_uid(Tool.createUUID32());
					adminDepart.setUnit_uid(sys_units.getUnit_uid());
					adminDepart.setPdepart_id(rootDepart.getDepart_uid());
					adminDepart.setDepart_name("超级管理员");
					adminDepart.setUrl("-");
					if(departsService.insertOneDepartsInfo(user, adminDepart)){
						Sys_users sys_users=new Sys_users();
						sys_users.setUser_name("管理员");
						sys_users.setUser_id(sys_units.getUser_id());
						sys_users.setUserpassword(sys_units.getUserpassword());
						sys_users.setUser_type("1");
						sys_users.setIsEable(0);
						sys_users.setIsactive(1);
						sys_users.setIsAdmin(1);
						sys_users.setIs_otherdep(0);
						sys_users.setUnit_uid(sys_units.getUnit_uid());
						sys_users.setUnit_uidName(sys_units.getUnit_uidName());
						sys_users.setDepart_uid(adminDepart.getDepart_uid());
						if(usersService.insertOneUsersInfo(user, sys_users)){
							Sys_post sys_post=new Sys_post();
							sys_post.setPost_ID(Tool.createUUID32());
							sys_post.setParentPostID("1");
							sys_post.setUnit_uid(sys_units.getUnit_uid());
							sys_post.setPostFullCode(sys_post.getPost_ID()+"/");
							sys_post.setPostName("岗位设置");
							sys_post.setCreateUserName(user.getUser_name());
							sys_post.setUpdateUserName(user.getUser_name());
							postService.insertOnePostInfo(sys_post, user);
							return true;
						}else{
							return false;
						}
					}else{
						return false;
					}
				}else{
					return false;
				}
				//mashuo edit 20170922  end
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 查询所有担保机构
	 * @return
	 */
	public List<Sys_units> selectAllUnitsList(String wheresql) {
		return sys_unitsMapper.selectAllUnitsList(wheresql);
	}
	/**
	 * 查询机构分页列表
	 * @return
	 */
	public PageTable selectUnitsPageTables(PageTable pageTable) {
		List<Sys_units> list=sys_unitsMapper.selectUnitsPageTables(pageTable);
		Long total=sys_unitsMapper.selectUnitsPageTables_Count(pageTable);
		pageTable.setRows(list);
		pageTable.setTotal(total);
		return pageTable;
	}
	/**
	 * 查询一个机构
	 * @return
	 */
	public Sys_units selectOneUnitsInfo(Sys_units sys_units) {
		Sys_units retSys_units = null;
		try {
			retSys_units = sys_unitsMapper.selectOneUnitsInfo(sys_units);
			Sys_units pSys_units = sys_unitsMapper.selectPUnitsInfo(retSys_units);
			if (pSys_units != null) {
				retSys_units.setpUnitsName(pSys_units.getUnit_uidName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retSys_units;
	}
	
	/**
	 * 查询一个父机构
	 * @return
	 */
	public Sys_units selectPUnitsInfo(Sys_units sys_units) {
		return sys_unitsMapper.selectPUnitsInfo(sys_units);
	}
	/**
	 * 更新一个机构
	 * @return
	 */
	public Boolean updateOneUnitsInfo(User user,Sys_units sys_units) {
		try {
			if(sys_unitsMapper.updateOneUnitsInfo(sys_units)==1){
				logService.insertOneOperatorLogInfo(user,"机构设置", "更新", sys_units.getpUnitsName());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 删除一个机构
	 */
	public Boolean deleteOneUnitsInfo(User user,Sys_units sys_units) {
		try {
			//删除该机构下的部门
			departsService.deleteDepartByUnits(user,sys_units.getUnit_uid());
			//删除下级菜单
			deleteOneUnitsDownInfo(user,sys_units);
			logService.insertOneOperatorLogInfo(user,"机构设置", "删除", sys_units.getpUnitsName());
			if(sys_unitsMapper.deleteOneUnitsInfo(sys_units)==1){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 子方法删除子机构
	 * @param sys_units
	 */
	private void deleteOneUnitsDownInfo(User user,Sys_units sys_units) {
		
		try {
			//判断是否有下级菜单
			List<Sys_units> list=sys_unitsMapper.selectAllUnitsList(" and punit_uid = \'"+ sys_units.getUnit_uid()+"\'");
			for (Sys_units sys_units2 : list) {
				deleteOneUnitsDownInfo(user,sys_units2);
				//删除该机构下的部门
				departsService.deleteDepartByUnits(user,sys_units2.getUnit_uid());
				sys_unitsMapper.deleteOneUnitsInfo(sys_units2);
				logService.insertOneOperatorLogInfo(user,"机构设置", "删除", sys_units2.getpUnitsName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 判断是否存在
	 * @param wheresql
	 * @return
	 */
	public Boolean selectUnitsIsExist(String wheresql) {
		if(sys_unitsMapper.selectUnitsIsExist(wheresql)==0){
			//不存在
			return true;
		}else{
			//存在
			return false;
		}
	}

}
