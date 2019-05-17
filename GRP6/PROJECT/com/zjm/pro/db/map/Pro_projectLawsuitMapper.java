package com.zjm.pro.db.map;

import java.util.List;
import java.util.Map;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_projectLawsuit;

public interface Pro_projectLawsuitMapper {	
	/**
	 * 新增一个项目诉讼
	 * @param projectLawsuit
	 * @return
	 */
	
	public Integer  insertOneProjectLawsuit(Pro_projectLawsuit projectLawsuit);
	/**
	 * 更改项目诉讼
	 * @param proLawSuit
	 * @return
	 */
	public Integer  updateOneProjectLawsuitInfo(Pro_projectLawsuit projectLawsuit);

	/**
	 * 查询一条项目诉讼
	 * @param proLawSuit
	 * @return
	 */
	public Pro_projectLawsuit selectOneProjectLawsuitInfo(String whereSql);
	
	/**
	 * 根据项目id删除诉讼
	 * @param project_ID
	 * @return
	 */
	public Integer deleteLawsuitMapperByProject_ID(String project_ID);
	
	/**
	 * 查询项目诉讼登记列表
	 * @param pageTable
	 * @return
	 */
	public List<Pro_projectLawsuit> selectProjectLawsuitTable(PageTable<Pro_projectLawsuit> pageTable);
	
	/**
	 * 查询项目诉讼登记数量
	 * @param pageTable
	 * @return
	 */
	public Long selectProjectLawsuitTable_count(PageTable<Pro_projectLawsuit> pageTable);
	
	
	/**
	 * 修改查封信息
	 * @param param
	 * @return
	 */
	public Integer updateConAsset(Map<String, Object> param);
	
	/**
	 * 拼接关联项目id
	 * @return
	 */
	public String concatProjectID();
	
	
}
