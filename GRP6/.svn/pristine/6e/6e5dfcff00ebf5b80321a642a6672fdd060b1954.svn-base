package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_clientfiles;

public interface Crm_clientfilesMapper {
	/**
	 * 插入一个客户附件
	 * @param files
	 * @return
	 */
	public Integer insertOneClientFiles(Crm_clientfiles files);
	/**
	 * 客户附件List
	 */
	public List<Crm_clientfiles> selectAllClientFilesPageTables(PageTable pageTable);
	/**
	 * 客户附件 
	 */
	public Long selectAllClientFilesPageTables_Count(PageTable pageTable);
	/**
	 * 删除一个客户附件信息
	 * @param files
	 * @return
	 */
	public Integer delectOneClientFilesInfo(Crm_clientfiles files);
	
	
	
	
	/**
	 * 图片附件
	 * @param whereSql
	 * @return
	 */
	public List<Crm_clientfiles> selectPictureFileList(String whereSql);
	
	/**
	 * @description  根据客户id删除客户附件
	 * @author wuhn
	 * @date 2017年9月29日 下午5:30:04
	 */
	int deleteClientFilesByClient_ID(String client_ID);
	
	
	
	
}
