package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_replace;

/**
 * 代偿情况pro_replace  mapper
 */
public interface Pro_replaceMapper {
    
	
	
	/***
	 * 新增代偿表信息
	 * @param pro_replace
	 * @return
	 */
	public Integer insertOneReplaceInfo(Pro_replace pro_replace);

	/**
	 * 查询代偿分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Pro_replace> selectReplacePageTable(PageTable<Pro_replace> pageTable);
	/**
	 * 查询一个代偿信息
	 * @param pageTable
	 * @return
	 */
	public Pro_replace selectOneReplaceInfo(String wheresql);


	/***
	 * 修改代偿表信息
	 * @param pro_replace
	 * @return
	 */
	public Integer updateOneReplaceInfo(Pro_replace pro_replace);
	/**
	 * 查询代偿分页列表总数
	 * @param pageTable
	 * @return
	 */
	public Long selectReplacePageTable_Count(PageTable<Pro_replace> pageTable);



	/**
	 * 分页查询代偿列表 —— 项目对应
	 */
	public List<Pro_replace> selectReplaceTable(PageTable<Pro_replace> pageTable);
	/**
	 * 分页查询代偿列表--总数 —— 项目对应
	 */
	public Long selectReplaceTable_Count(PageTable<Pro_replace> pageTable);
	/**
	 * 查询一条代偿信息
	 * @param sqlWhere
	 * @return
	 */
	public Pro_replace showRepalceViewPage(String sqlWhere);

	public Integer cancelReplaceDel(Pro_replace replace);

	/**
	 * @param condition
	 * @return 查询正常解除申请信息
	 */
	public List<Pro_replace> selectReplaceList(String condition);

	/**
	 * 删除项目时删除对应项目的代偿信息
	 * @param project_ID
	 */
	public Integer deleteReplaceByProject_ID(String project_ID);

	
}
