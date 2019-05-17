package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_costMust;

/**
 * 应收费用表
 */
public interface Pro_costMustMapper {
	
	public List<Pro_costMust> selectCostMustListByWhereSql(String wheresql);
	
	public Integer insertOneCostMust(Pro_costMust costMust);
	
	public Pro_costMust selectOneCostMust(Pro_costMust costMust);
	
	public Integer updateOneCostMust(Pro_costMust costMust);
	
	public Integer updateCostMustState(Pro_costMust costMust);
	
	/**
	 * 根据条件删除应收费用
	 */ 
	public Integer deleteCostMustByWheresql(String wheresql);
  
	/**
     * 获取应收费用列表
     * @param pageTable
     * @return
     */
	public List<Pro_costMust> selectApplyPageTables(PageTable<Pro_costMust> pageTable);
    /**
     * 获取应收费用列表总条数
     * @param pageTable
     * @return
     */
	public Long selectApplyPageTables_Count(PageTable<Pro_costMust> pageTable);
    /**
     * 根据条件进行查询
     * @param whereSql
     * @return
     */
	public Pro_costMust selectOneCostMustByWhereSql(String whereSql);
    /**
     * 查询多个应收费用
     * @param whereSql
     * @return
     */
	public List<Pro_costMust> selectCostMustListByWheresql(String whereSql);
	
	/**
	 * @param condition
	 * @return 分组查询
	 */
	public List<Pro_costMust> selectCostMustListByWheresqlGroup(String condition);
}
