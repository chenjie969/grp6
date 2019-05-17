package com.zjm.sys.departs.service;

import java.util.List;

import com.zjm.common.db.model.User;
import com.zjm.sys.db.model.Sys_departs;
/**
 * 部门设置
 * @author duanhuawei add 20170426
 */
public interface DepartsService {
	/**
	 * 查询所有部门
	 * @param wheresql 
	 * @param searchText 
	 * @param pageNumber 
	 * @param pageSize 
	 * @return
	 */
	public List<Sys_departs> selectAllDepartsList(String wheresql);
	/**
	 * 插入一个部门信息
	 * @param sys_departs
	 * @return
	 */
	public Boolean insertOneDepartsInfo(User user,Sys_departs sys_departs);
	/**
	 * 查询一个部门信息
	 * @param sys_departs
	 * @return
	 */
	public Sys_departs selectOneDepartsInfo(Sys_departs sys_departs);
	/**
	 * 更新一个部门信息
	 * @param sys_departs
	 * @return
	 */
	public Boolean updateOneDepartsInfo(User user,Sys_departs sys_departs);
	/**
	 * 删除一个部门信息
	 * @param sys_departs
	 * @return
	 */
	public Boolean deleteOneDepartsInfo(User user,Sys_departs sys_departs);
	/**
	 * 判断是否存在
	 * @param wheresql
	 * @return
	 */
	public Boolean selectDepartsIsExist(String wheresql);
	/**
	 * 查询部门列表   
	 * @param pageTable
	 * @return
	 */
	/*public PageTable<Sys_departs> selectDepartsPageTables(PageTable<Sys_departs> pageTable);*/
	
	
	
	/**
	 * 获取部门下的所有用户
	 * @param thisDeparts
	 */
	public List<Sys_departs> returnDepartOfUser(Sys_departs thisDeparts);
	
	/**
	 * 
	 * @description	设置部门下的岗位信息
	 * @author wuhn
	 * @date 2017年6月7日 下午7:32:10
	 */
	public Boolean updateSetDepartPostInfo(User user,Sys_departs sys_departs);
	
	/**
	 * 获取当前机构下的部门根节点  --- 根据机构id和 部门的父类id
	 * @description
	 * @author wuhn
	 * @date 2017年6月9日 下午2:53:36
	 */
	public List<Sys_departs> selectRootDepartByUnits(Sys_departs  sys_departs);
	
	/**
	 * @description	根据机构id,删除机构下的部门信息 
	 * @author wuhn
	 * @date 2017年6月9日 下午3:22:32
	 */
	public Boolean deleteDepartByUnits(User user,String unit_uid);
	
	/**
	 * 根据用户id查询同部门的用户id
	 * @param userId
	 * @return
	 */
	public List<String> selectUserListByCommonDepUser(String userId);
	
	/** 根据部门id查询包括自己部门以及下级部门的所有用户id
	 * @param departId
	 * @return
	 */
	public List<String> selectfollowDepUserByDepart(String departId);
	
	/**
	 * @param userId 根据用户id
	 * @return
	 */
	public boolean isHoldingGroupFlowDEpart(String userId);
	
}
