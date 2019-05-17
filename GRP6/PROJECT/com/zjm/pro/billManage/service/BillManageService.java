package com.zjm.pro.billManage.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_costBill;
import com.zjm.pro.db.model.Pro_billForProVO;

public interface BillManageService {

	/**
	 * 查询所有收费项目的票据分页列表
	 */
	public PageTable<Pro_billForProVO> selectMultiProsBillPageTable(PageTable<Pro_billForProVO> pageTable);
	
	/**
	 * 查询某一项目下的票据分页列表
	 */
	public PageTable<Pro_costBill> selectSglProBillPageTable(PageTable<Pro_costBill> pageTable);
	
	/**
	 * 新增一条票据记录
	 */
	public Boolean insertOneBill(User user,Pro_costBill bill);
	
	/**
	 * 修改一条票据记录
	 */
	public Boolean updateOneBill(User user,Pro_costBill bill);
	
	/**
	 * 查看一条票据记录
	 */
	public Pro_costBill selectOneBill(Pro_costBill bill);
	
	/**
	 * 删除一条票据记录
	 */
	public Boolean deleteOneBill(User user,Pro_costBill bill);
	
}
