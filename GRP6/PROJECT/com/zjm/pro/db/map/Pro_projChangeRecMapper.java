package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_projChangeRec;

/**
 * @author rd_xujy
 * description : 项目移交映射表
 */
public interface Pro_projChangeRecMapper {
	
	/**
	 * 添加一条移交记录
	 * @param proChangeRec
	 * @return
	 */
	int insertOneprojChangeRec( Pro_projChangeRec proChangeRec);

	/**
	 * 查询移交记录
	 * @param pageTable
	 * @return
	 */
	List<Pro_projChangeRec> selectProjChangeRecPageTable(PageTable<Pro_projChangeRec> pageTable);

	/**
	 * 统计移交记录值
	 * @param pageTable
	 * @return
	 */
	Long selectProjChangeRecPageTableCount(PageTable<Pro_projChangeRec> pageTable);

	/**
	 * 根据项目移交记录id修改
	 * @param projChangeRec_ID
	 * @return
	 */
	Pro_projChangeRec selectOneProjChangeRecByID(String projChangeRec_ID);
	
	/**
	 * 更新一条记录
	 * @param projChangeRec
	 * @return
	 */
	int updateOneProjChangeRec(Pro_projChangeRec projChangeRec);

	/**
	 * 根据项目id删除项目移交记录
	 * @param project_ID
	 * @return
	 */
	Integer deleteProjChangeRecByProject_ID(String project_ID);
}
