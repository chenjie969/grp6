package com.zjm.pro.credit.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_applyDetail;

public interface CreditApplyService {

	/**
	 *	新增授信申请记录，返回新增的主键ID 
	 */
	public String insertOneCreditApply(User user,Pro_apply creditApply);
	
	/**
	 *	新增授信项下项目申请记录
	 */
	public Boolean insertOneCreditProjectApply(User user,Pro_applyDetail applyDetail);
	
	/**
	 * 查询授信申请分页列表
	 */
	public PageTable<Pro_apply> selectCreditApplyPageTables(PageTable<Pro_apply> pageTable);
	
	/**
	 * 查询一条授信申请信息
	 */
	public Pro_apply selectOneCreditApply(Pro_apply creditApply,String selectType);
	
	/**
	 * 删除一条授信申请信息
	 */
	public Boolean deleteOneCreditApply(User user,Pro_apply creditApply);
	
	/**
	 * 查询某授信项的用款明细
	 */
	public PageTable<Pro_apply> selectFundsDetailPageTables(PageTable<Pro_apply> pageTable);
	
	/**
	 * 根据 apply_ID 修改 pro_apply表 的内容
	 */
	public Boolean updateApply(Pro_apply apply);
}
