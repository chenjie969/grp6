package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.crm.db.model.Crm_spouseInfo;

public interface Crm_spouseInfoMapper {

	
	/**
	 * 查询配偶信息   分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Crm_spouseInfo> selectSpouseInfoPageTables(Crm_spouseInfo spouseInfo);
	
	/**
	 * 新增配偶信息
	 * @param client
	 * @author chenyang
	 * @return
	 */
	public Boolean insertOneSpouseInfo(Crm_spouseInfo spouseInfo);

	/**
	 *	删除一个配偶信息
	 * @param clientRelation
	 * @return
	 */
	public boolean deleteOneSpouseInfo(Crm_spouseInfo spouseInfo);

	/**
	 *查询一个配偶信息
	 * @param Crm_spouseInfo
	 * @author chenyang
	 * @return
	 */
	public Crm_spouseInfo selectOneSpouseInfo(Crm_spouseInfo spouseInfo);

	/**
	 * 
	 * @description 修改 更新配偶信息信息
	 * @author chenyang
	 * @date 2017年5月5日 
	 */
	public Boolean updateOneSpouseInfo(Crm_spouseInfo spouseInfo);
	
	/**
	 * @description  根据客户id获取　
	 * @author wuhn
	 * @date 2017年10月11日 下午4:38:22
	 */
	List<Crm_spouseInfo>   selectSpouseListByClient_ID(String client_ID);
	
	/**
	 * @description  根据客户
	 * @author wuhn
	 * @date 2017年10月11日 下午4:38:39
	 */
	int deleteSpouseByClient_ID(String  client_ID);
	
}
