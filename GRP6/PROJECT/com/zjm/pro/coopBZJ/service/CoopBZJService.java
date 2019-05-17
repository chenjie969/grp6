package com.zjm.pro.coopBZJ.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.sys.db.model.C_bankSort;

public interface CoopBZJService {

	/**
	 * 查询银行类合作机构 
	 */
	public PageTable<C_bankSort> selectbankSortPageTables(PageTable<C_bankSort> pageTable);
	
	/**
	 * 查询一个合作机构的信息
	 */
	public C_bankSort selectOneBankSort(C_bankSort bankSort);
	
	/**
	 * 更新一个合作机构的信息
	 */
	public Boolean updateOneBankSort(User user,C_bankSort bankSort);
}
