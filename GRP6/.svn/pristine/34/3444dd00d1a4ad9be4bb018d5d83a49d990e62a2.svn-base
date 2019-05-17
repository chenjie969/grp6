package com.zjm.pro.projectLawsuit.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_projectLawsuit;

public interface ProjectLawsuitService {
	/**
     * 新增一个项目诉讼
     * @param userSession
     * @param proLawSuit
     * @return
     */
	public Boolean  insertOneProjectLawsuit(User userSession,Pro_projectLawsuit projectLawsuit);		
	/**
	 * 修改项目诉讼
	 * @param userSession
	 * @param proLawSuit
	 * @return
	 */
	public Boolean updateOneProjectLawsuitInfo(User userSession,Pro_projectLawsuit projectLawsuit);
	/**
	 * 查询一个项目诉讼
	 * @param proLawSuit
	 * @return
	 */
	public Pro_projectLawsuit selectOneProjectLawsuitInfo(String wheresql);
	
	/**
	 * 查询诉讼登记列表
	 * @param pageTable
	 * @return
	 */
	public PageTable<Pro_projectLawsuit> selectProjectLawPageTables(PageTable<Pro_projectLawsuit> pageTable);
	
	/**
	 * 拼接关联项目id
	 */
	public String concatProjectID();
}
