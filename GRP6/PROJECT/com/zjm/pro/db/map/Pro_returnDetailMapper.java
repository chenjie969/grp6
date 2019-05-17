package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_returnDetail;

/**
 * 追偿情况pro_returnDetail  mapper
 */
public interface Pro_returnDetailMapper {
	/**
	 * 查询追偿分页列表
	 */
	public List<Pro_returnDetail> selectReturnDetailPageTable(PageTable<Pro_returnDetail> pageTable);

	/**
	 * 查询追偿分页列表总数
	 */
	public Long selectReturnDetailPageTable_Count(PageTable<Pro_returnDetail> pageTable);

	/**
	 * 新增追偿信息
	 * @param pro_returnDetail
	 * @return
	 */
	public Integer insertOneReturnDetailInfo(Pro_returnDetail pro_returnDetail);
	/**
	 * 查询一条追偿信息
	 * @return
	 */
	public Pro_returnDetail selectOneReturnDetailInfo(String wheresql);

	/**
	 * 修改追偿信息
	 * @param pro_returnDetail
	 * @return
	 */
	public Integer updateOneReturnDetailInfo(Pro_returnDetail pro_returnDetail);

	/**
	 * 删除项目时同步删除项目的追偿信息
	 * @param project_ID
	 * @return
	 */
	public Integer deleteReturnDetailByProject_ID(String project_ID);
}
