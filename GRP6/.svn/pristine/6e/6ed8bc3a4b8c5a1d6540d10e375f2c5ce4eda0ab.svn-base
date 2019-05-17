package com.zjm.pro.dynamic.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_dynamic;

public interface DynamicService {
	/**
	 *	新增一条项目动态
	 */
	public Boolean  insertOneProDynamic(Pro_dynamic prodynamic);	
	/**
	 * 查询所有项目动态
	 */
	public List<Pro_dynamic> selectProDynamicList(String whereSql);
	/**
	 * 查询所有项目动态总条数
	 */
	public Integer selectProDynamicCount(String whereSql);
	/**
	 * 删除项目动态
	 * 
	 */
	public Boolean deleteProDynamicByDynamicID(String dynamic_ID);
	/**
	 * 根据项目动态ID查询项目动态
	 * @param dynamic_ID
	 * @return
	 */
	public Pro_dynamic selectOneProDynamic(String dynamic_ID);
	/**
	 * 更新所有项目动态
	 */
	public Boolean updateProDynamicList(String whereSql);
	
	/**
	 * 首页获取项目动态列表
	 * @param whereSql
	 * @return
	 */
	List<Pro_dynamic> selectIndexProDynamicList(String whereSql);
	/**
	 * 获取项目动态表格列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectProDynamicTables(PageTable pageTable);
}
