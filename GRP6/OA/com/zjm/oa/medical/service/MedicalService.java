package com.zjm.oa.medical.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.oa.db.model.Hr_medical;

public interface MedicalService {
	/**
	 * 插入一条体检记录
	 * @param user
	 * @param medical
	 * @return
	 */
    public Boolean insertOneMedical(User user,Hr_medical medical);
    /**
     * 更新一条体检记录
     * @param user
     * @param medical
     * @return
     */
    public Boolean updateOneMedical(User user,Hr_medical medical);
    /**
     * 查询一条体检记录
     * @param medicalID
     * @return
     */
    public Hr_medical selectOneMedical(String medicalID);
    /**
     * 查询体检记录表
     * @param pageTable
     * @return
     */
    public  PageTable<Hr_medical> selectMedicalTable(PageTable<Hr_medical> pageTable);
}
