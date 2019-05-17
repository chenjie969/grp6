package com.zjm.gworkFlow.flowBuild.service.Impl;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.gworkFlow.db.map.Os_gworkflow_filesMapper;
import com.zjm.gworkFlow.db.model.Os_gworkflow_files;
import com.zjm.gworkFlow.flowBuild.service.OsGworkflowFilesService;

/** 
 * osworkflow意见附件表
 * @author mashuo add 20171011
 */
@Service("osGworkflowFilesService")
@Transactional
public class OsGworkflowFilesServiceImpl implements OsGworkflowFilesService{

	@Resource
	private Os_gworkflow_filesMapper os_gworkflow_filesMapper;
	/**
	 * 插入一个流程意见附件
	 * @param files
	 * @return
	 */
	public boolean insertOneOsGworkflowFiles(Os_gworkflow_files files) {
		try {
			
		
		if(os_gworkflow_filesMapper.insertOneOsGworkflowFiles(files)==1){
			return true;
		}else{
			return false;
		}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * osworkflow意见附件分页列表
	 */
	public PageTable selectAllOsGworkflowFilesPageTables(PageTable pageTable) {
		List<Os_gworkflow_files> list=os_gworkflow_filesMapper.selectAllOsGworkflowFilesPageTables(pageTable);
		Long counts=os_gworkflow_filesMapper.selectAllOsGworkflowFilesPageTables_Count(pageTable);
		pageTable.setRows(list);
		pageTable.setTotal(counts);
		return pageTable;
	}
	/**
	 * 删除一个osworkflow意见附件信息
	 */
	public boolean delectOneOsGworkflowFilesInfo(Os_gworkflow_files files) {
		if(os_gworkflow_filesMapper.delectOneOsGworkflowFilesInfo(files)==1){
			return true;
		}else{
			return false;
		}
	}
	
}

