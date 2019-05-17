package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.pro.db.model.Pro_costFact;

public interface Pro_costFactMapper {
	 /**
     * 根据输入条件查询多个实收费用列表
     * @param string
     * @return
     */
	public List<Pro_costFact> selectCostFactListByWhereSql(String wheresql);
	
	
	public Integer insertOneCostFact(Pro_costFact costFact);

   /**
    * 根据输入条件查询单个实收表信息
    * @param string
    * @return
    */
	public Pro_costFact selectOneCostFactByWhereSql(String string);


    public Integer deleteOneCostFact(Pro_costFact costFact);
    
    
    /**
     * 根据预收id删除实收表信息
     * @param costPre_ID
     * @return
     */
    public Integer deleteOneCostFactByWhereSql(String  costPre_ID);

    /**
     * 根据id修改实收表信息
     * @param pro_costFact
     * @return costPre_ID
     */
	public Integer updateOneCostFact(Pro_costFact pro_costFact);


	/**
	 * @param condition
	 * @return 分组查询
	 */
	public List<Pro_costFact> selectCostFactListByWhereSqlGroup(String condition);
    
    
    
   
	
}
