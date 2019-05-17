package com.zjm.pro.returnDetail.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_returnDetail;

public interface ReturnDetailService {

	/**
	 * 分页查询追偿列表
	 */
	public PageTable<Pro_returnDetail> selectReturnDetailPageTable(PageTable<Pro_returnDetail> pageTable);

	/**
	 * 新增追偿情况
	 */
	public Boolean insertOneReturnDetailInfo(User userSession, Pro_returnDetail pro_returnDetail);
	/**
	 * 查询追偿情况
	 */
	public Pro_returnDetail selectOneReturnDetailInfo(String wheresql);

	/**
	 * 修改追偿情况
	 */
	public Boolean updateOneReturnDetailInfo(User userSession, Pro_returnDetail pro_returnDetail);
}
