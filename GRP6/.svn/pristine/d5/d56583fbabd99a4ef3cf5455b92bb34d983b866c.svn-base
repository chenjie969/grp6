package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.pro.db.model.Pro_costPre;

public interface Pro_costPreMapper {
	public Integer insertOneCostPre(Pro_costPre costPre);
	public List<Pro_costPre> selectCostPreListByWheresql(String string);
	
	public Integer deleteOneCostPre(Pro_costPre pro_costPre);
	public Pro_costPre selectOneCostPreByWhereSql(String whereSql);
	
	public Integer updateOneCostPre(Pro_costPre costPre);
	/**
	 * @param condition
	 * @return 分组查询
	 */
	public List<Pro_costPre> selectCostPreListByWheresqlGroup(String condition);
	/**
	 * @param costPre
	 * @return 预收转实收
	 */
	public Integer costPreToFact(Pro_costPre costPre);
}
