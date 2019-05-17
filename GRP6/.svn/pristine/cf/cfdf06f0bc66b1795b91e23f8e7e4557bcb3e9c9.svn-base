package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_creditor;

public interface Pro_creditorMapper {

	/**
	 *	新增债权转让，返回新增的主键ID 
	 */
	public boolean insertOneCreditorInfo(Pro_creditor pro_creditor);
	
    
	/**
	 *更新债权转让
	 * @param string
	 */
	public Integer updateCreditor(Pro_creditor pro_creditor);
	
    /**
     *  删除债权转让
     * @param whereSql
     * @return
     */
	public Integer deleteCreditorByWhereSql(String whereSql);
	
	public Pro_creditor selectOneCreditorByWhereSql(String wheresql);

	public List<Pro_creditor> selectProjectCreditorPageTables(PageTable<Pro_creditor> pageTable);


	public Long selectProjectCreditorPageTables_Count(PageTable<Pro_creditor> pageTable);
}
