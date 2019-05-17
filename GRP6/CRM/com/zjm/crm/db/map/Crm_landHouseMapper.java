package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.crm.db.model.Crm_landHouse;

public interface Crm_landHouseMapper {

	
	/**
	 * 查询住宅    分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Crm_landHouse> selectLandHousePageTables(Crm_landHouse landHouse);
	
	/**
	 * 新增住宅
	 * @author chenyang
	 * @return
	 */
	public Boolean insertOneLandHouseInfo(Crm_landHouse landHouse);

	/**
	 *	删除一个住宅
	 * @return
	 */
	public boolean deleteOneLandHouseInfo(String landHouse_id);

	/**
	 *查询一个住宅
	 * @author chenyang
	 * @return
	 */
	public Crm_landHouse selectOneLandHouseInfo(Crm_landHouse landHouse);

	/**
	 * 
	 * @description 修改 更新住宅信息  
	 * @author chenyang
	 */
	public Boolean updateOneLandHouseInfo(Crm_landHouse landHouse);
	
	/**
	 * @description  根据 client_ID 删除
	 * @author wuhn 
	 * @date 2017年10月11日 下午3:27:15
	 */
	int deleteLandHouseByClient_ID(String client_ID);

	
	
}
