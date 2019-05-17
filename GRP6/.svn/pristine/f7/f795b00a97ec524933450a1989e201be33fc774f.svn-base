package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_materialModel;

public interface Crm_materialModelMapper {
    /**
     * 查询单个Crm_materialModel
     * @param whereSql
     * @return
     */
	public Crm_materialModel selectOneMaterialModel(String whereSql);
  
	/**
	 * 判断客户资料清单模板是否存在
	 * @param crm_materialModel
	 * @return
	 */
	public Integer isExistMaterialModelName(Crm_materialModel crm_materialModel);
    /**
     * 新增客户资料清单模板
     * @param crm_materialModel
     * @return
     */
	public Integer insertOneMaterialModel(Crm_materialModel crm_materialModel);
    /**
     * 查詢客戶資料客户资料清单模板列表
     * @param pageTable
     * @return
     */
	public List<Crm_materialModel> selectMaterialModelPageTable(PageTable<Crm_materialModel> pageTable);
     /**
      * 查詢客戶資料客户资料清单模板列表 条数
      * @param pageTable
      * @return
      */
	public Long selectMaterialModelPageTable_Count(PageTable<Crm_materialModel> pageTable);
     /**
      * 修改客戶資料客户资料清单模板
      * @param crm_materialModel
      * @return
      */
	public Integer updateOneMaterialModel(Crm_materialModel crm_materialModel);

	
	
}
