package com.zjm.sys.docMould.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.sys.db.model.Sys_docMould;

public interface DocMouldService {
	/**
	 * 插入一个文档模板
	 * @param files
	 * @return
	 */
	public boolean insertOneDocMould(User user,Sys_docMould files);
	/**
	 * 文档模板PageTable
	 */
	public PageTable selectAllDocMouldList(PageTable pageTable);
	/**
	 * 文档模板List
	 */
	public List<Sys_docMould> selectDocMouldListByWheresql(String wheresql);
	/**
	 * 删除一个文档模板信息
	 * @param files
	 * @return
	 */
	public Boolean delectOneDocMouldInfo(User user,Sys_docMould files);
	/**
	 * 查看一个文档信息
	 * @param filename
	 * @param filePath
	 * @return
	 */
	public Sys_docMould selectOnefile(String filename, String filePath);
	
}
