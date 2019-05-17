package com.zjm.sys.modules.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.model.Sys_modules;
/**
 * 菜单设置
 * @author mashuo add 20170411
 */
public interface ModulesService {
	/**
	 * 查询所有菜单
	 * @param wheresql 
	 * @param searchText 
	 * @param pageNumber 
	 * @param pageSize 
	 * @return
	 */
	public List<Sys_modules> selectAllModulesList(String wheresql);
	/**
	 * 插入一个菜单信息
	 * @param sys_modules
	 * @return
	 */
	public Boolean insertOneModulesInfo(Sys_modules sys_modules);
	/**
	 * 查询一个菜单信息
	 * @param sys_modules
	 * @return
	 */
	public Sys_modules selectOneModulesInfo(Sys_modules sys_modules);
	/**
	 * 更新一个菜单信息
	 * @param sys_modules
	 * @return
	 */
	public Boolean updateOneModulesInfo(Sys_modules sys_modules);
	/**
	 * 删除一个菜单信息
	 * @param sys_modules
	 * @return
	 */
	public Boolean deleteOneModulesInfo(Sys_modules sys_modules);
	/**
	 * 查询菜单列表   
	 * @param pageTable
	 * @return
	 */
	public PageTable<Sys_modules> selectModulesPageTables(PageTable<Sys_modules> pageTable);
	/**
	 * 判断是否存在
	 * @param wheresql
	 * @return
	 */
	public Boolean selectModulesIsExist(String wheresql);
	

}
