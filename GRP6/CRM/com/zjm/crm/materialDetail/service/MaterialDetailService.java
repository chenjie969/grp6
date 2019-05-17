package com.zjm.crm.materialDetail.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_materialDetail;
/**
 *客户资料明细表crm_materialDetail service
 *
 */
public interface MaterialDetailService {
	
	
	/**
	 * 查询多个客户资料明细
	 * 
	 */
   public List<Crm_materialDetail>  selectMaterialDetailListByWheresql(String  whereSql);
    /**
     * 新增一条客户资料
     * @param userSession
     * @param crm_materialDetail
     * @return
     */
	public Boolean insertOneMaterialDetail(User userSession, Crm_materialDetail crm_materialDetail);
	/**
	 * 查询客户资料列表
	 * @param pageTable
	 * @return
	 */
	public PageTable<Crm_materialDetail> selectMaterialDetailPageTable(PageTable<Crm_materialDetail> pageTable);
	/**
	 * 查询一个客户资料
	 * @param materialDetail_ID
	 * @return
	 */
	public Crm_materialDetail selectOneMaterialDetailByWheresql(String materialDetail_ID);
	/**
	 * 删除一个客户资料
	 * @param userSession
	 * @param crm_materialDetail
	 * @return
	 */
	public Boolean deleteOneMaterialDetail(User userSession, Crm_materialDetail crm_materialDetail);
	/**
	 *更新一个客户资料
	 * @param userSession
	 * @param crm_materialDetail
	 * @return
	 */
	public Boolean updateOneMaterialDetail(User userSession, Crm_materialDetail crm_materialDetail);
   
   
}
