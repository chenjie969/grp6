package com.zjm.sys.db.map;

import com.zjm.sys.db.model.C_multiLevelSort;
import com.zjm.common.db.model.PageTable;

import java.util.List;


public interface C_multiLevelSortMapper {
    
	/**
	 * 查询所有多级字典
	 * @return
	 */
	public List<C_multiLevelSort> selectAllmultiLevelSortList(String wheresql);
	/**
	 * 插入一个多级字典信息
	 * @return
	 */
	public Integer insertOnemultiLevelSortInfo(C_multiLevelSort C_multiLevelSort);
	/**
	 * 查询一个多级字典信息
	 * @return
	 */
	public C_multiLevelSort selectOnemultiLevelSortInfo(C_multiLevelSort C_multiLevelSort);
	/**
	 * 更新一个多级字典信息
	 * @return
	 */
	public Integer updateOnemultiLevelSortInfo(C_multiLevelSort C_multiLevelSort);
	/**
	 * 删除一个多级字典信息
	 * @return
	 */
	public Integer deleteOnemultiLevelSortInfo(C_multiLevelSort C_multiLevelSort);
	
	/**
	 * 查询多级字典列表    分页列表
	 * @param pageTable
	 * @return
	 */
	public List<C_multiLevelSort> selectmultiLevelSortPageTables(PageTable<C_multiLevelSort> pageTable);
	/**
	 * 查询多级字典列表    总记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectmultiLevelSortPageTables_Count(PageTable<C_multiLevelSort> pageTable);
	
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
	public Integer selectmultiLevelSortIsExist(String wheresql);
	
	/**
	 * 查询同级节点下共有多少多级字典
	 * @return
	 */
	public Integer selectmultiLevelSortOrderId(C_multiLevelSort C_multiLevelSort);
	/**
	 * 由父类id查询子类多级字典
	 * @description
	 * @author wuhn
	 */
	public List<C_multiLevelSort> selectmultiLevelSortListByPmultiLevelSortid(C_multiLevelSort C_multiLevelSort);
	
	public C_multiLevelSort selectOnemultiLevelSortInfoByWheresql(String wheresql);
	
	
}