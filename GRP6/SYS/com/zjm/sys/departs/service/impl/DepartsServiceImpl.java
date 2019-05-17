package com.zjm.sys.departs.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.sys.db.map.Sys_dep_postMapper;
import com.zjm.sys.db.map.Sys_dep_userMapper;
import com.zjm.sys.db.map.Sys_departsMapper;
import com.zjm.sys.db.map.Sys_post_userMapper;
import com.zjm.sys.db.model.Sys_dep_post;
import com.zjm.sys.db.model.Sys_dep_user;
import com.zjm.sys.db.model.Sys_departs;
import com.zjm.sys.db.model.Sys_post_user;
import com.zjm.sys.departs.service.DepartsService;
import com.zjm.sys.util.RolesDataAccreditUtil;
import com.zjm.util.Tool;
/**
 * 部门设置
 * @author duanhuawei add 20170426
 */
@Service("departsService")
@Transactional
public class DepartsServiceImpl implements DepartsService{
	@Resource 
	private Sys_departsMapper  sys_departsMapper;
	@Resource 
	private Sys_dep_userMapper  sys_dep_userMapper;
	@Resource
	private LogService logService;
	
	@Resource
	private Sys_dep_postMapper  sys_dep_postMapper;// 部门与岗位mapper
	
	@Resource
	private Sys_post_userMapper	sys_post_userMapper; //岗位与用户Mapper
	/**
	 * 查询所有部门
	 * @return
	 */
	public List<Sys_departs> selectAllDepartsList(String wheresql) {
		return sys_departsMapper.selectAllDepartsList(wheresql);
	}

	/**
	 * 插入一个部门信息
	 * @return
	 */
	public Boolean insertOneDepartsInfo(User user,Sys_departs sys_departs) {
		try {
			sys_departs.setDepart_uid(Tool.createUUID32());
		//	sys_departs.setUnit_uid(user.getUnit_uid());
			sys_departs.setCreate_user(user.getUser_name());
			sys_departs.setUpdate_user(user.getUser_name());
			//查询同级节点下共有多少部门
			sys_departs.setOrder_id(sys_departsMapper.selectDepartsOrderId(sys_departs));
			Sys_departs pSys_departs = sys_departsMapper.selectPDepartsByPdepartID(sys_departs.getPdepart_id());
			String depart_fullcode = null;
			if (pSys_departs != null) {
				depart_fullcode = pSys_departs.getDepart_fullcode()+sys_departs.getDepart_uid()+"/";
			} else {
				depart_fullcode = sys_departs.getDepart_uid()+"/";
			}
			sys_departs.setDepart_fullcode(depart_fullcode);
			if(sys_departsMapper.insertOneDepartsInfo(sys_departs)==1){
				logService.insertOneOperatorLogInfo(user,"组织机构设置", "添加", sys_departs.getDepart_name());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 查询一个部门信息
	 * @return
	 */
	public Sys_departs selectOneDepartsInfo(Sys_departs sys_departs) {
		return sys_departsMapper.selectOneDepartsInfo(sys_departs);
	}
	/**
	 * 更新一个部门信息
	 * @return
	 */
	public Boolean updateOneDepartsInfo(User user,Sys_departs sys_departs) {
		try {
			if(sys_departsMapper.updateOneDepartsInfo(sys_departs)==1){
				logService.insertOneOperatorLogInfo(user,"组织机构设置", "修改", sys_departs.getDepart_name());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 删除一个部门信息
	 * @return
	 */
	public Boolean deleteOneDepartsInfo(User user,Sys_departs sys_departs) {
		//删除下级部门
		deleteOneDepartsDownInfo(user,sys_departs);
		Sys_dep_user dUser = new Sys_dep_user();
		dUser.setDepart_uid(sys_departs.getDepart_uid());
		sys_dep_userMapper.deleteOneDepUserInfo(dUser);
		
		String wheresql=" and unit_uid ='"+user.getUnit_uid()+"' and depart_uid = '"+sys_departs.getDepart_uid()+"'";
		sys_dep_postMapper.deleteDepPostInfo(wheresql); // 先删掉关联关系
		
		if(sys_departsMapper.deleteOneDepartsInfo(sys_departs)==1){
			logService.insertOneOperatorLogInfo(user,"组织机构设置", "删除", sys_departs.getDepart_name());
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 删除子部门（子方法）
	 * @param sys_departs
	 */
	private void deleteOneDepartsDownInfo(User user,Sys_departs sys_departs) {
		try {
			//判断是否有下级部门
			List<Sys_departs> list=sys_departsMapper.selectAllDepartsList(" and pdepart_id = \'"+ sys_departs.getDepart_uid()+"\'");
			for (Sys_departs sys_departs2 : list) {
				deleteOneDepartsDownInfo(user,sys_departs2);
				//删除关联数据
				Sys_dep_user dUser = new Sys_dep_user();
				dUser.setDepart_uid(sys_departs2.getDepart_uid());
				sys_dep_userMapper.deleteOneDepUserInfo(dUser);
				
				String wheresql=" and unit_uid ='"+user.getUnit_uid()+"' and depart_uid = '"+sys_departs.getDepart_uid()+"'";
				sys_dep_postMapper.deleteDepPostInfo(wheresql); // 先删掉关联关系
				
				sys_departsMapper.deleteOneDepartsInfo(sys_departs2);
				logService.insertOneOperatorLogInfo(user,"组织机构设置", "删除", sys_departs2.getDepart_name());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询部门列表   
	 * @param pageTable
	 * @return
	 *//*
	public PageTable<Sys_departs> selectDepartsPageTables(PageTable<Sys_departs> pageTable) {
		List<Sys_departs> list=sys_departsMapper.selectDepartsPageTables(pageTable);
		Long total=sys_departsMapper.selectDepartsPageTables_Count(pageTable);
		pageTable.setRows(list);
		pageTable.setTotal(total);
		return pageTable;
	}*/

	/**
	 * 判断是否存在
	 * @param wheresql
	 * @return
	 */
	public Boolean selectDepartsIsExist(String wheresql) {
		if(sys_departsMapper.selectDepartsIsExist(wheresql)==0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 获取部门下的所有用户;
	 * 
	 */
	public List<Sys_departs> returnDepartOfUser(Sys_departs departs) {
		List<Sys_departs> departOfUser = sys_departsMapper.returnDepartOfUser(departs);
		return departOfUser;
	}
	
	/**
	 * 给部门设置岗位 信息
	 */
	@Override
	public Boolean updateSetDepartPostInfo(User user, Sys_departs sys_departs) {
		String wheresql=" and unit_uid ='"+sys_departs.getUnit_uid()+"' and depart_uid = '"+sys_departs.getDepart_uid()+"'";
		try {
			Sys_dep_post dep_post=new Sys_dep_post();
			dep_post.setDepart_uid(sys_departs.getDepart_uid());
			dep_post.setUnit_uid(sys_departs.getUnit_uid());
			List<Sys_dep_post> oldDepPostList = sys_dep_postMapper.selectDepPostList(dep_post); // 获取该部门下,原有的岗位信息
			sys_dep_postMapper.deleteDepPostInfo(wheresql); // 先删掉关联关系
			String postIds = sys_departs.getPostIds();
			String[] split = postIds.split(",");
			for (String str : split) {
				 Sys_dep_post dep=new Sys_dep_post();
				 dep.setDepart_uid(sys_departs.getDepart_uid());
				 dep.setUnit_uid(sys_departs.getUnit_uid());
				 dep.setPost_ID(str);
				 sys_dep_postMapper.insertOneDepPostInfo(dep);
			}
			// 删掉部门中已不存在的岗位 ---> 岗位与用户表 用的用户信息
		//	deletePostUserByPostId(split,oldDepPostList);
			
			logService.insertOneOperatorLogInfo(user,"设置岗位","修改",sys_departs.getDepart_name()+" 设置岗位");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 *  TODO: 若部门下的岗位被删除,则不需要处理 用户和岗位之间的关系,已和钟总确认!	2017年6月9日 10:47:42
	 * 
	 * @description	删掉部门中已不存在的岗位 ---》 岗位下的用户信息
	 * @author wuhn
	 * @date 2017年6月8日 下午7:38:15
	 */
	private void deletePostUserByPostId(String[] postIds,List<Sys_dep_post> oldDepPostList) {
		Iterator<Sys_dep_post> it = oldDepPostList.iterator();
		while(it.hasNext()){
			Sys_dep_post	depPost = it.next();
			for(String postId: postIds){
				if(postId.equals(depPost.getPost_ID())){ 
					it.remove(); //若存在则移除,剩下的则是被删掉的岗位信息
				}
			}
		}
		for(Sys_dep_post depPost: oldDepPostList){
			//获取该部门下,已经删掉的岗位信息---> 获取被删掉岗位的用户信息
			Sys_dep_user  sys_dep_user=new Sys_dep_user();
			sys_dep_user.setDepart_uid(depPost.getDepart_uid());
			List<Sys_dep_user> DepUserList = sys_dep_userMapper.selectOneDepUserListByDepart(sys_dep_user);
			// 删除该部门下,已经删掉的岗位信息 ---> 移除岗位和用户之间的关联关系
			Sys_post_user sys_post_user=new Sys_post_user();//岗位和用户
			for (Sys_dep_user depuser : DepUserList) {
				sys_post_user.setPost_ID(depPost.getPost_ID());
				sys_post_user.setUser_uid(depuser.getUser_uid());
				sys_post_userMapper.deleteOnePostUserInfo(sys_post_user);
			}
		}
	}
	
	/**
	 * 获取当前机构下的部门根节点 --- 根据机构id和 部门的父类id
	 */
	@Override
	public List<Sys_departs> selectRootDepartByUnits(Sys_departs sys_departs) {
		return sys_departsMapper.selectRootDepartByUnits(sys_departs);
	}
	
	/**
	 * @description	根据机构id,删除机构下的部门信息 
	 * @author wuhn
	 * @date 2017年6月9日 下午3:22:32
	 */
	@Override
	public Boolean deleteDepartByUnits(User user,String unit_uid) {
		try {
			int deleteDepartByUnits = sys_departsMapper.deleteDepartByUnits(unit_uid);

			if( deleteDepartByUnits > 0){
				logService.insertOneOperatorLogInfo(user,"由机构删除部门","删除",user.getUser_name()+"删除");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
	}

	@Override
	public List<String> selectUserListByCommonDepUser(String userId) {
		return sys_dep_userMapper.selectUserListByCommonDepUser(userId);
	}

	@Override
	public List<String> selectfollowDepUserByDepart(String departId) {
		return sys_dep_userMapper.selectfollowDepUserByDepart(departId);
	}

	@Override
	public boolean isHoldingGroupFlowDEpart(String userId) {
		boolean isHoldingGroupFlowDEpart = false;
		String holdingGroupId = "c48cdb2e54c840459f0b327e0fe06865";//河北融投控股集团
		String companyId =  RolesDataAccreditUtil.subsidiaryCode(userId);//获取用户的子公司id
		if(holdingGroupId.equals(companyId)){
			isHoldingGroupFlowDEpart = true;
		}
		return isHoldingGroupFlowDEpart;
	}

}
