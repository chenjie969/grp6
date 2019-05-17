package com.zjm.pro.replace.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_replace;

public interface ReplaceService {
	/**
	 * 新增代偿登记 
	 * @param userSession
	 * @param pro_replace
	 * @return
	 */
	public Boolean insertOneReplaceInfo(User userSession, Pro_replace pro_replace);
	/**
	 * 查询一个代偿信息
	 * @param string
	 * @return
	 */
	public Pro_replace selectOneReplaceInfo(String wheresql);

	/**
	 * 修改代偿登记 
	 * @param userSession
	 * @param pro_replace
	 * @return
	 */
	public Boolean updateOneReplaceInfo(User userSession, Pro_replace pro_replace);
	/**
	 * 分页查询代偿列表
	 */
	public PageTable<Pro_replace> selectReplacePageTable(PageTable<Pro_replace> pageTable);
	
	/**
	 * 分页查询代偿列表 —— 项目对应
	 */
	public PageTable<Pro_replace> selectReplaceTable(PageTable<Pro_replace> pageTable);

	/**
	 * @param sqlWhere
	 * @return 查询代偿详情
	 */
	public Pro_replace showRepalceViewPage(String sqlWhere);

	/**
	 * @param replace
	 * @return 撤销代偿
	 */
	public Boolean cancelReplaceDel(Pro_replace replace);

	/**
	 * @param replace
	 * @return  部分代偿
	 */
	public Boolean addOneReplace(Pro_replace replace);
	//查询正常解除申请信息
	public List<Pro_replace> selectReplaceList(String condition);

	/**
	 * @param user
	 * @param pro_replace
	 * @return 代偿解除申请
	 */
	public Boolean insertOneReplaceWHDB(User user, Pro_replace pro_replace);

	/**
	 * @param user
	 * @param replace
	 * @return 撤销代偿解除申请
	 */
	public Object deleteOneReplace(User user, Pro_replace replace);
}
