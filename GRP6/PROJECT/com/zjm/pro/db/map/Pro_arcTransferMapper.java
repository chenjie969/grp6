package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_arcTransfer;

/**
 * @author wzk
 * 档案移交清单表
 */
public interface Pro_arcTransferMapper {
	/**
	 * 分页查询档案移交列表
	 */
	List<Pro_arcTransfer> selectTransferRecordsPageTable(PageTable<Pro_arcTransfer> pageTable);
	/**
	 * 分页查询档案移交列表---总数
	 */
	Long selectTransferRecordsPageTable_Count(PageTable<Pro_arcTransfer> pageTable);


}
