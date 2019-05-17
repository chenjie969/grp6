package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_lawsuitProgress;

/**
 * pro_lawsuitProgress  mapper
 */
public interface Pro_lawsuitProgressMapper {
	/**
	 * 增加一条案件诉讼
	 * @param pro_lawsuitProgress
	 * @return
	 */
	public Integer insertOneLawsuitProgressInfo(Pro_lawsuitProgress pro_lawsuitProgress);
    /**
     * 删除一条案件诉讼
     * @param wheresql
     * @return
     */
	public Integer delOneLawsuitProgressInfo(String wheresql);
	/**
	 * 更新一条案件诉讼
	 * @param pro_lawsuitProgress
	 * @return
	 */
	public Integer updateOneLawsuitProgressInfo(Pro_lawsuitProgress pro_lawsuitProgress);
	/**
	 * 查询一条案件诉讼
	 * @param wheresql
	 * @return
	 */
	public Pro_lawsuitProgress selectOneLawsuitProgressInfo(String wheresql);
	/**
	 * 
	 * 分页列表查询
	 * @param pageTable
	 * @return
	 */
	public List<Pro_lawsuitProgress> selectLawsuitProgressPageTable(PageTable<Pro_lawsuitProgress> pageTable);
    /**
     * 
     * 查询总记录数
     * @param pageTable
     * @return
     */
	public Long selectLawsuitProgressPageTable_Count(PageTable<Pro_lawsuitProgress> pageTable);

	

	

	

	
	
}
