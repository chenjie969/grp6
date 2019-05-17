package com.zjm.crm.landHouse.service;

import com.zjm.crm.db.model.Crm_landHouse;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;

/**
 * 住宅
 * @author chenyang
 */
public interface LandHouseService {
	
	/**
	 * 查询应收账户分页列表
	 * @author chenyang
	 * @return
	 */
	public PageTable<Crm_landHouse> selectLandHousePageTables(Crm_landHouse landHouse);
	
	/**
	 * 查询应收账户列表  不分页
	 * @author xuyz
	 * @return
	 */
	public List<Crm_landHouse> selectLandHouseList(Crm_landHouse landHouse);
	
	/**
	 *	删除一个住宅
	 * @return
	 */
	public boolean deleteOneLandHouseInfo(User user,String landHouse_id);

	/**
	 *	新增一个住宅
	 * @return
	 */
	public Boolean insertOneLandHouseInfo(User user,Crm_landHouse landHouse);

	/**
	 * 查询一个住宅
	 * @return
	 */
	public Crm_landHouse selectOneLandHouseInfo(Crm_landHouse landHouse);

	/**
	 * 
	 * @description 修改 更新住宅信息  
	 * @author chenyang
	 */
	public Boolean updateOneLandHouseInfo(User user,Crm_landHouse landHouse);
	
	
	/**
	 * @description  根据 client_ID 删除
	 * @author wuhn 
	 * @date 2017年10月11日 下午3:27:15
	 */
	Boolean deleteLandHouseByClient_ID(String client_ID);
	
}
