package com.zjm.pro.creditor.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_creditor;
import com.zjm.pro.db.model.Pro_delay;

public interface CreditorService {

	/**
	 *	新增债权转让，返回新增的主键ID 
	 */
	public boolean insertOneCreditorInfo(User user,Pro_creditor creditApply);

	public Boolean insertOneCreditorInfoByApplyInfo(User userSession, Pro_creditor pro_creditor);

	public PageTable<Pro_creditor> selectProjectCreditorPageTables(PageTable<Pro_creditor> pageTable);

	public Pro_creditor selectOneCreditorByWhereSql(String whereSql);

	public Boolean deleteCreditorByWhereSql(String whereSql);
}
