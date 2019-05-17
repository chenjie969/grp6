package com.zjm.sys.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.model.Sys_docMould;

public interface Sys_docMouldMapper {
	/**
	 * 插入一个文档模板
	 * @param docMould
	 * @return
	 */
	public Integer insertOneDocMould(Sys_docMould docMould);
	/**
	 * 文档模板pageTable
	 */
	public List<Sys_docMould> selectAllDocMouldPageTables(PageTable pageTable);
	/**
	 * 文档模板List
	 */
	public List<Sys_docMould> selectDocMouldListByWheresql(String wheresql);
	/**
	 * 文档模板 
	 */
	public Long selectAllDocMouldPageTables_Count(PageTable pageTable);
	/**
	 * 删除一个文档模板信息
	 * @param docMould
	 * @return
	 */
	public Integer delectOneDocMouldInfo(Sys_docMould docMould);
	public Sys_docMould  selectOnefile(String filename, String filePath);
	
}
