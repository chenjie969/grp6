package com.zjm.sys.units.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.sys.db.model.Sys_modules;
import com.zjm.sys.db.model.Sys_units;
/**
 * 担保机构设置
 * @author duanhuawei add 20170425
 */
public interface UnitsService {
	
	/**
	 * 插入一个担保机构
	 * @param sys_units
	 * @return
	 */
	public Boolean insertOneUnitsInfo(User user,Sys_units sys_units);
	/**
	 * 查询机构分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectUnitsPageTables(PageTable pageTable);
	/**
	 * 查询所有担保机构
	 * @param wheresql 
	 * @param searchText 
	 * @param pageNumber 
	 * @param pageSize 
	 * @return
	 */
	public List<Sys_units> selectAllUnitsList(String wheresql);
	/**
	 * 查询一个担保机构
	 * @param sys_units
	 * @return
	 */
	public Sys_units selectOneUnitsInfo(Sys_units sys_units);
	/**
	 * 更新一个机构
	 * @param sys_units
	 * @return
	 */
	public Boolean updateOneUnitsInfo(User user,Sys_units sys_units);
	/**
	 * 删除一个机构
	 * @param sys_units
	 * @return
	 */
	public Boolean deleteOneUnitsInfo(User user,Sys_units sys_units);
	/**
	 * 查看机构名字是否存在
	 * @param wheresql
	 * @return
	 */
	public Boolean selectUnitsIsExist(String wheresql);

}
