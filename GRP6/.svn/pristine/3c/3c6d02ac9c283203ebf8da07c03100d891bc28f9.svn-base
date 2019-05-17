package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_materialDetail;

public interface Crm_materialDetailMapper {
	
	public List<Crm_materialDetail> selectMaterialDetailList(String whereSql);

	public Integer insertOneMaterialDetail(Crm_materialDetail crm_materialDetail);
  
	public List<Crm_materialDetail> selectMaterialDetailPageTable(PageTable<Crm_materialDetail> pageTable);

	public Long selectMaterialDetailPageTable_Count(PageTable<Crm_materialDetail> pageTable);

	public Crm_materialDetail selectOneMaterialDetailByWheresql(String materialDetail_ID);

	public Integer deleteOneMaterialDetailBySql(String wheresql);

	public Integer updateOneMaterialDetail(Crm_materialDetail crm_materialDetail);
	
}
