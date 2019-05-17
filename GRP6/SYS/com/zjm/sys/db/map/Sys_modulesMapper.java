package com.zjm.sys.db.map;


import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.model.Sys_modules;
public interface Sys_modulesMapper {
	/**
	 * 查询所有菜单
	 * @return
	 */
	public List<Sys_modules> selectAllModulesList(String wheresql);
	/**
	 * 插入一个菜单信息
	 * @return
	 */
	public Integer insertOneModulesInfo(Sys_modules sys_modules);
	/**
	 * 查询一个菜单信息
	 * @return
	 */
	public Sys_modules selectOneModulesInfo(Sys_modules sys_modules);
	/**
	 * 更新一个菜单信息
	 * @return
	 */
	public Integer updateOneModulesInfo(Sys_modules sys_modules);
	/**
	 * 删除一个菜单信息
	 * @return
	 */
	public Integer deleteOneModulesInfo(Sys_modules sys_modules);
	
	/**
	 * 查询菜单列表    分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Sys_modules> selectModulesPageTables(PageTable<Sys_modules> pageTable);
	/**
	 * 查询菜单列表    总记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectModulesPageTables_Count(PageTable<Sys_modules> pageTable);
	
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
	public Integer selectModulesIsExist(String wheresql);
	
	/**
	 * 查询同级节点下共有多少菜单
	 * @return
	 */
	public Integer selectModulesOrderId(Sys_modules sys_modules);
	/**
	 * 删除该菜单的角色授权信息
	 * @param sys_modules2
	 */
	public Integer deleteOneModulesInfoRelevanceRoles(Sys_modules sys_modules2);
}
