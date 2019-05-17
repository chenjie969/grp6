package com.zjm.pro.arcTransfer.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_arcTransfer;

public interface ArcTransferService {
	/**
	 * 分页查询档案移交列表
	 */
	PageTable<Pro_arcTransfer> selectTransferRecordsPageTable(PageTable<Pro_arcTransfer> pageTable);
	
}
