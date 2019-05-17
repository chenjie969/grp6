package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_arcDirectory;
import com.zjm.pro.db.model.Pro_arcTransfer;

/**
 * @author wzk
 * 档案资料
 */
public interface Pro_arcDirectoryMapper {
	/**
	 * 分页查询档案资料列表
	 */
	List<Pro_arcDirectory> selectFilesDataTable(PageTable<Pro_arcDirectory> pageTable);
	/**
	 * 分页查询档案资料列表————总数
	 */
	Long selectFilesDataTable_Count(PageTable<Pro_arcDirectory> pageTable);


}
