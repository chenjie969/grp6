package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_billForProVO;
import com.zjm.pro.db.model.Pro_costBill;

/**
 * 票据管理 
 */
public interface Pro_billMapper {

	/**
	 * 查询所有收费项目的票据分页列表
	 */
	public List<Pro_billForProVO> selectMultiProsBillPageTable(PageTable<Pro_billForProVO> pageTable);
	
	/**
	 * 查询票据分页列表--查询总记录数
	 */
	public Long selectMultiProsBillPageTable_Count(PageTable<Pro_billForProVO> pageTable);
	
	/**
	 * 查询票据分页列表--查询总记录数
	 */
	public Integer selectBillCount(String wheresql);
	
	/**
	 * 查询某一项目下的票据分页列表
	 */
	public List<Pro_costBill> selectSglProBillPageTable(PageTable<Pro_costBill> pageTable);
	
	/**
	 * 新增一条票据记录
	 */
	public Integer insertOneBill(Pro_costBill bill);
	
	/**
	 * 修改一条票据记录
	 */
	public Integer updateOneBill(Pro_costBill bill);
	
	/**
	 * 查看一条票据记录
	 */
	public Pro_costBill selectOneBill(Pro_costBill bill);
	
	/**
	 * 删除一条票据记录
	 */
	public Integer deleteOneBill(Pro_costBill bill);
}
