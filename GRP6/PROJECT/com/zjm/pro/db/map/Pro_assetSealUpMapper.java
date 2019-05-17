package com.zjm.pro.db.map;

import java.util.List;
import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_assetSealUp;


public interface Pro_assetSealUpMapper {	
	/**
	 * 新增资产查封信息
	 * @param proSeaulUp
	 * @return
	 */
	public Integer  insertOneSeaulUp(Pro_assetSealUp proSeaulUp);		
	/**
	 * 查询资产查封信息表
	 * @param pageTable
	 * @return
	 */
	public List<Pro_assetSealUp> selectProSeaulUpPageTables(PageTable pageTable);
    /**
     * 根据ID删除资产查封信息
     * @param assetSealUp_ID
     * @return
     */
	public Integer deleteSeaulUpsBySealUpID(String assetSealUp_ID);
   /**
    * 更新资产查封信息
    * @param proSeaulUp
    * @return
    */
	public Integer updateOneSealUpInfo(Pro_assetSealUp proSeaulUp);
    /**
     * 查询一个资产查封信息
     * @param proSeaulUp
     * @return
     */
	public Pro_assetSealUp selectOneSealUpInfo(String whereSql);
	/**
	 * 统计资产查封信息数
	 * @param pageTable
	 * @return
	 */
	public Long selectSealUpPageTables_Count(PageTable pageTable);
	
	/**根据项目id 删除查封信息
	 * @param projectId
	 */
	public Integer deleteSeaulUpsByProject_ID(String project_ID);
	
}
