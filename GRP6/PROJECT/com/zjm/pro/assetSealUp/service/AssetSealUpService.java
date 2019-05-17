package com.zjm.pro.assetSealUp.service;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_assetSealUp;
public interface AssetSealUpService {
	/**
	 * 新增一个资产清查信息
	 * @param userSession
	 * @param proSeaulUp
	 * @return
	 */
	public Boolean  insertOneSeaulUp(User userSession,Pro_assetSealUp proSeaulUp);		
	
	public PageTable<Pro_assetSealUp> selectProSeaulUpPageTables(PageTable<Pro_assetSealUp> pageTable);
	/**
	 * 根据ID删除一个资产清查信息
	 * @param assetSealUp_ID
	 * @return
	 */
	public Boolean deleteSeaulUpsBySealUpID(String assetSealUp_ID);
   /**
    * 更新一个资产清查信息
    * @param userSession
    * @param proSeaulUp
    * @return
    */
	public Boolean updateOneSealUpInfo(User userSession,Pro_assetSealUp proSeaulUp);
   /**
    * 查询一个资产清查信息
    * @param whereSql
    * @return
    */
	public Pro_assetSealUp selectOneSealUpInfo(String whereSql);
	
	
	
}
