package com.zjm.crm.materialModel.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_materialModel;
/**
 * 客户资料模板表crm_materialModel service
 *
 */
public interface MaterialModelService {
	
	
	/**
	 * 查询多个客户资料类型
	 * 
	 */
   public Crm_materialModel  selectOneMaterialModelByWheresql(String  whereSql);
    /**
     * 新增客户资料清单模板
     * @param userSession
     * @param crm_materialModel
     * @return
     */
	public Boolean insertOneMaterialModel(User userSession, Crm_materialModel crm_materialModel);
	
	/**
	 * 判断客户资料清单模板是否存在
	 * @param materialModelService
	 * @return
	 */
	public Boolean isExistMaterialModelName(Crm_materialModel crm_materialModel);
	/**
	 * 
	 * @param pageTable
	 * @return
	 */
	public PageTable<Crm_materialModel> selectMaterialModelPageTable(PageTable<Crm_materialModel> pageTable);
	/**
	 * 修改客户资料清单模板
	 * @param userSession
	 * @param crm_materialModel
	 * @return
	 */
	public Boolean updateOneMaterialModel(User userSession, Crm_materialModel crm_materialModel);
	
	public Boolean copyMaterialModel(User userSession, Crm_materialModel crm_materialModel);
   
   
}
