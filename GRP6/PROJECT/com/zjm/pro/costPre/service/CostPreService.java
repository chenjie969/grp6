package com.zjm.pro.costPre.service;

import java.util.List;

import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_costPre;

public interface CostPreService {
	/**
	 * 新增
	 * @param user
	 * @param costPre
	 * @return
	 */
	public Boolean insertOneCostPre(User user, Pro_costPre costPre);
     /**
      * 根据条件查询多个应收费用信息
      * @param string
      * @return
      */
	public List<Pro_costPre> selectCostPreListByWheresql(String string);
	
	/**
	 * 预收费用--撤销---预收转应收
	 * @param userSession
	 * @param pro_costPre
	 * @return
	 */
	public Boolean costPreToCostMust(User userSession, Pro_costPre pro_costPre);
	/**
	 * 删除一条预收费用记录
	 * @param user
	 * @param costMust
	 * @return
	 */
	public Boolean deleteOneCostPre(User user, Pro_costPre pro_costPre);
	
	
	public  Pro_costPre selectOneCostPreByWhereSql(String whereSql);
	/**
	 * 修改预收表信息
	 * @param user
	 * @param costPre
	 * @return
	 */
	public Boolean updateOneCostPre(User user, Pro_costPre costPre);
	/**
	 * @param condition
	 * @return 分组查询
	 */
	public List<Pro_costPre> selectCostPreListByWheresqlGroup(String condition);
	/**
	 * @param user
	 * @param costPre
	 * @return 预收费用-预收转实收
	 */
	public Boolean costPreToFact(User user, Pro_costPre costPre);
	
}
