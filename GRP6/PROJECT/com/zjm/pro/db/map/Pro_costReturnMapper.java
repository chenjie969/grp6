package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.pro.db.model.Pro_costReturn;

public interface Pro_costReturnMapper {

	public List<Pro_costReturn> selectCostReturnListByWhereSql(String wheresql);
	/**
	 * 执行退费新增操作
	 */
	public Integer insertOneCostReturn(Pro_costReturn costReturn);
   /**
    * 查询单个退费表信息
    * @param whereSql
    * @return
    */
	public Pro_costReturn selectOneCostReturnByWhereSql(String whereSql);

    /**
     * 修改退费表信息
     * @param pro_costReturn
     * @return
     */
	public Integer updateOneCostReturn(Pro_costReturn pro_costReturn);
	
	/**
	 * @param pro_costReturn
	 * @return 修改退费表信息
	 */
	public Integer delOneCostReturn(Pro_costReturn pro_costReturn);
	/**
	 * @param condition
	 * @return 分组查询
	 */
	public List<Pro_costReturn> selectCostReturnListByWhereSqlGroup(String condition);
	
}
