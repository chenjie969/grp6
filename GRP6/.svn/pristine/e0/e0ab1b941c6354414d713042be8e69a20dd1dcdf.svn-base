package com.zjm.pro.costFact.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_costFact;
import com.zjm.pro.db.model.Pro_costPre;

public interface CostFactService {

	public PageTable<Pro_costFact> selectCostFactPageTable(PageTable<Pro_costFact> pageTable);
	
	
	public Boolean insertOneCostFact(User user, Pro_costFact costFact);
     /**
      * 查询多个实收费用信息
      * @param string
      * @return
      */
	public List<Pro_costFact> selectCostFactListByWhereSql(String string);

     /**
      * 实收转预收
      * @param userSession
      * @param pro_costFact
      * @return
      */
	public Boolean costFactToCostPre(User userSession, Pro_costFact pro_costFact);
	
	
	/**
	 * 删除一条实收费用记录
	 * @param user
	 * @param pro_costFact
	 * @return
	 */
	public Boolean deleteOneCostFact(User user, Pro_costFact pro_costFact);

    /**
     * 查询一条实收费用记录
     * @param string
     * @return
     */
	public Pro_costFact selectOneCostFactByWhereSql(String string);

    /**
     * 调整收入计划
     * @param userSession
     * @param pro_costFact
     * @return
     */
	public Boolean insertCostPlanToCostFact(User userSession, Pro_costFact pro_costFact);

    /**
     * 修改
     * @param userSession
     * @param pro_costFact
     * @return
     */
	public Boolean updateOneCostFact(User userSession, Pro_costFact pro_costFact);
	/**
	 * 修改
	 * @param userSession
	 * @param pro_costFact
	 * @return
	 */
	public Boolean updateOneCostFacts(User userSession, Pro_costFact pro_costFact);


	/**
	 * @param condition
	 * @return 分组查询
	 */
	public List<Pro_costFact> selectCostFactListByWhereSqlGroup(String condition);
	
	
	
}
