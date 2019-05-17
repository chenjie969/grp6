package com.zjm.sys.db.map;

import java.util.List;

import com.zjm.sys.db.model.Sys_departs;
/**
 * 部门设置
 * @author duanhuawei add 20170426
 */
public interface Sys_departsMapper {

	/**
	 * 查询所有部门
	 * @param wheresql
	 * @return
	 */
	public List<Sys_departs> selectAllDepartsList(String wheresql);
	/**
	 * 查询部门排序ID
	 * @param sys_departs
	 * @return
	 */
	public Integer selectDepartsOrderId(Sys_departs sys_departs);
	/**
	 * 插入一个部门信息
	 * @param sys_departs
	 * @return
	 */
	public Integer insertOneDepartsInfo(Sys_departs sys_departs);
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
	public Integer updateOneDepartsInfo(Sys_departs sys_departs);
	/**
	 * 删除部门
	 * @param sys_departs
	 * @return
	 */
	public Integer deleteOneDepartsInfo(Sys_departs sys_departs);
	/**
	 * 查询部门是否存在
	 * @param wheresql
	 * @return
	 */
	public int selectDepartsIsExist(String wheresql);
	
	/**
	 * 查询部门下所有用户
	 * @param departs
	 */
	public List<Sys_departs> returnDepartOfUser(Sys_departs departs);
	
	//============================部门没有列表数据==========================
	/**
	 * 查询部门列表
	 * @param pageTable
	 * @return
	 *//*
	public List<Sys_departs> selectDepartsPageTables(PageTable<Sys_departs> pageTable);
	*//**
	 * 查询部门列表记录数
	 * @param pageTable
	 * @return
	 *//*
	public Long selectDepartsPageTables_Count(PageTable<Sys_departs> pageTable);*/
	
	public Sys_departs selectPDepartsByPdepartID(String pdepart_id);
	
	/**
	 * @description	  获取当前机构下的部门根节点  --- 根据机构id和 部门的父类id
	 * @author wuhn
	 * @date 2017年6月9日 下午2:49:45
	 */
	public List<Sys_departs> selectRootDepartByUnits(Sys_departs  sys_departs);
	
	/**
	 * @description	根据机构id,删除机构下的部门信息 
	 * @author wuhn
	 * @date 2017年6月9日 下午3:22:32
	 */
	public int deleteDepartByUnits(String unit_uid);
    
}