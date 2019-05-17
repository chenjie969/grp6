package com.zjm.crm.clientfiles.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.crm.clientfiles.service.ClientFilesService;
import com.zjm.crm.db.map.Crm_clientfilesMapper;
import com.zjm.crm.db.model.Crm_clientfiles;
import com.zjm.crm.db.model.UploadParam;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
@Service("clientFilesService")
@Transactional
public class ClientFilesServiceImpl implements ClientFilesService {
	@Resource
	private Crm_clientfilesMapper crm_clientfilesMapper;
	
	@Resource
	private LogService logService;
	
	/**
	 * 插入一个客户附件
	 * @param files
	 * @return
	 */
	public boolean insertOneClientFiles(Crm_clientfiles files) {
		if(crm_clientfilesMapper.insertOneClientFiles(files)==1){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 客户附件List
	 */
	public PageTable selectAllClientFilesPageTables(PageTable pageTable) {
		List<Crm_clientfiles> list=crm_clientfilesMapper.selectAllClientFilesPageTables(pageTable);
		Long total=crm_clientfilesMapper.selectAllClientFilesPageTables_Count(pageTable);
		pageTable.setRows(list);
		pageTable.setTotal(total);
		return pageTable;
	}
	/**
	 * 删除一个客户附件信息
	 * @param files
	 * @return
	 */
	public Boolean delectOneClientFilesInfo(Crm_clientfiles files) {
		if(crm_clientfilesMapper.delectOneClientFilesInfo(files)==1){
			return true;
		}else{
			return false;
		}
	}
	public List<Crm_clientfiles> selectPictureFileList(String  whereSql) {
		
		List<Crm_clientfiles> list;
		try {
			list = crm_clientfilesMapper.selectPictureFileList(whereSql);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public Boolean deleteClientFilesByClient_ID(String client_ID, User user) {
		try {
			int info = crm_clientfilesMapper.deleteClientFilesByClient_ID(client_ID);
			if(info > 0){
				logService.insertOneOperatorLogInfo(user, "客户附件", "添加", "添加一条客户附件");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
