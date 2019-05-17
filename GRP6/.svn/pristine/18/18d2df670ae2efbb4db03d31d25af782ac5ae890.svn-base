package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.crm.db.model.Crm_selfHouse;

public interface Crm_selfHouseMapper {

	
	/**
	 * 查询自有住房   分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Crm_selfHouse> selectSelfHouseInfoPageTables(Crm_selfHouse selfHouse);
	

	/**
	 * 新增自有住房
	 * @author chenyang
	 * @return
	 */
	public Boolean insertOneSelfHouseInfo(Crm_selfHouse selfHouse);

	/**
	 *	删除一个自有住房
	 */
	public boolean deleteOneSelfHouseInfo(Crm_selfHouse selfHouse);

	/**
	 *查询一个自有住房
	 * @author chenyang
	 * @return
	 */
	public Crm_selfHouse selectOneSelfHouseInfo(Crm_selfHouse selfHouse);

	/**
	 * 
	 * @description 修改 更新自有住房信息
	 * @date 2017年5月5日 
	 */
	public Boolean updateOneSelfHouseInfo(Crm_selfHouse selfHouse);

	/**
	 * @description  根据　client_ID获取
	 * @author wuhn
	 * @date 2017年10月11日 下午4:52:55
	 */
	List<Crm_selfHouse>  selectSelfHouseListByClient_ID(String  client_ID);
	
	/**
	 * @description 根据　client_ID 　删除
	 * @author wuhn
	 * @date 2017年10月11日 下午4:53:09
	 */
	int  deleteSelfHouseByClient_ID(String client_ID);
	
}
