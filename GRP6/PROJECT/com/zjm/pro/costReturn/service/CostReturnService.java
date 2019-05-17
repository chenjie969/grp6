package com.zjm.pro.costReturn.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_costPre;
import com.zjm.pro.db.model.Pro_costReturn;

public interface CostReturnService {

	public PageTable<Pro_costReturn> selectCostReturnPageTable(PageTable<Pro_costReturn> pageTable);
	/**
	 * 执行退费新增操作
	 */
	public Boolean insertOneCostReturn(User user, Pro_costReturn costReturn);
    
	/**
	 * 根据输入条件查询多个退费表信息
	 * @param whereSql
	 * @return
	 */
	public List<Pro_costReturn> selectCostReturnListByWhereSql(String whereSql);
    /**
     * 退费列表----确认退费
     * @param userSession
     * @param pro_costReturn
     * @return
     */
	public Boolean costReturnToCostPre(User userSession, Pro_costReturn pro_costReturn);
	
	/**
	 * 修改退费表信息
	 * @param user
	 * @param pro_costReturn
	 * @return
	 */
	public Boolean updateOneCostReturn(User user, Pro_costReturn pro_costReturn);
	
	/**
	 * @param user
	 * @param costReturn
	 * @return 执行退费删除操作
	 */
	public Boolean delOneCostReturn(User user, Pro_costReturn costReturn);
	/**
	 * @param condition
	 * @return 分组查询
	 */
	public List<Pro_costReturn> selectCostReturnListByWhereSqlGroup(String condition);
	/**
	 * @param whereSql
	 * @return 查询一条退费信息
	 */
	public Pro_costReturn selectOneCostReturnByWhereSql(String whereSql);
	
	
}
