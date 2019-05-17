package com.zjm.pro.costMust.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_costMust;

public interface CostMustService {

	public PageTable<Pro_costMust> selectCostMustPageTable(PageTable<Pro_costMust> pageTable);
	
	public Boolean updateOneCostMust(User user, Pro_costMust costMust);
	public Boolean insertOneCostMust(User user, Pro_costMust costMust);
	public Boolean deleteOneCostMust(User user, Pro_costMust costMust);
	public Integer deleteCostMustByWheresql(String wheresql);
	
	public Pro_costMust selectOneCostMust(Pro_costMust costMust);
     /**
      * 到账确认--应收转预收
      * @param userSession
      * @param pro_costMust
      * @return
      */
	public Boolean costMustToPre(User userSession, Pro_costMust pro_costMust);
    /**
     * 查询多个应收费用list
     * @param string
     * @return
     */
	public List<Pro_costMust> selectCostMustListByWheresql(String whereSql);
    /**
     * 查询单个应收费用信息
     * @param string
     * @return
     */
	public Pro_costMust selectOneCostMustByWhereSql(String string);

	/**
	 * @param condition
	 * @return 分组查询
	 */
	public List<Pro_costMust> selectCostMustListByWheresqlGroup(String condition);
}
