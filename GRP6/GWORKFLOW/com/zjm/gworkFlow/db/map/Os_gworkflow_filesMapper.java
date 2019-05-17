package com.zjm.gworkFlow.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.gworkFlow.db.model.Os_gworkflow_files;

/** 
 * osworkflow意见附件表
 * @author mashuo add 20171011
 */
public interface Os_gworkflow_filesMapper {
	/**
	 * 插入一个流程意见附件
	 * @param files
	 * @return
	 */
	public Integer insertOneOsGworkflowFiles(Os_gworkflow_files files);
	/**
	 * osworkflow意见附件list
	 */
	public List<Os_gworkflow_files> selectAllOsGworkflowFilesPageTables(PageTable pageTable);
	/**
	 * osworkflow意见附件记录数
	 */
	public Long selectAllOsGworkflowFilesPageTables_Count(PageTable pageTable);
	/**
	 * 删除一个osworkflow意见附件信息
	 */
	public Integer delectOneOsGworkflowFilesInfo(Os_gworkflow_files files);

}
