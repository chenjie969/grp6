package com.zjm.oa.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.oa.db.model.Hr_medical;

public interface Hr_medicalMapper {
	/**
	 * 增加一条体检记录
	 * @param medical
	 * @return
	 */
	public Integer insertOneMedical(Hr_medical medical);
	/**
	 * 更新一条体检记录
	 * @param medical
	 * @return
	 */
	public Integer updateOneMedical(Hr_medical medical);
	/**
     * 查询体检记录表
     * @param pageTable
     * @return
     */
	public List<Hr_medical> selectMedicalTable(PageTable pageTable);
	/**
	 * 查询一条体检记录表
	 * @param medicalID
	 * @return
	 */
	public Hr_medical selectOneMedical(String medicalID);
	
}
