package com.zjm.pro.lawsuitProgress.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_lawsuitProgress;

public interface LawsuitProgressService {
	/**
	 * 新增诉讼情况登记 
	 * @param userSession
	 * @param pro_lawsuitProgress
	 * @return
	 */
	public Boolean insertOneLawsuitProgressInfo(User userSession, Pro_lawsuitProgress pro_lawsuitProgress);
	/**
	 * 删除一个诉讼情况
	 * @param userSession
	 * @param wheresql
	 * @return
	 */
	public Boolean delOneLawsuitProgressInfo(User userSession, String wheresql);
	/**
	 * 更改一个案件诉讼情况
	 * @param userSession
	 * @param pro_lawsuitProgress
	 * @return
	 */
	public Boolean updateOneLawsuitProgressInfo(User userSession, Pro_lawsuitProgress pro_lawsuitProgress);
	
	/**
	 *查询案件诉讼表 
	 * @param pageTable
	 * @return
	 */

	public PageTable<Pro_lawsuitProgress> selectLawsuitProgressPageTable(PageTable<Pro_lawsuitProgress> pageTable);
	/**
	 * 
	 * 查询一条案件诉讼
	 * @param wheresql
	 * @return
	 */

	public Pro_lawsuitProgress selectOneLawsuitProgressInfo(String wheresql);

	

	

}
