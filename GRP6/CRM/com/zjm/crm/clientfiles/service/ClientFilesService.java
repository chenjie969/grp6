package com.zjm.crm.clientfiles.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_clientfiles;

public interface ClientFilesService {
	/**
	 * 插入一个客户附件
	 * @param files
	 * @return
	 */
	public boolean insertOneClientFiles(Crm_clientfiles files);
	/**
	 * 客户附件List
	 */
	public PageTable selectAllClientFilesPageTables(PageTable pageTable);
	/**
	 * 删除一个客户附件信息
	 * @param files
	 * @return
	 */
	public Boolean delectOneClientFilesInfo(Crm_clientfiles files);
	
	/**
	 * 查看文件列表
	 * 
	 */
   public List<Crm_clientfiles>  selectPictureFileList(String  whereSql);
   
   	/**
   	 * @description  根据客户id删除客户附件信息
   	 * @author wuhn
   	 * @date 2017年9月29日 下午5:32:22
   	 */
   	Boolean	deleteClientFilesByClient_ID (String client_ID,User user);
   
}
