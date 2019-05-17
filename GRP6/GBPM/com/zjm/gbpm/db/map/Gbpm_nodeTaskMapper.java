package com.zjm.gbpm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.gbpm.db.model.Gbpm_nodeTask;

public interface Gbpm_nodeTaskMapper {

	/**
	 * 分页查询产品节点任务事项列表
	 */
	public List<Gbpm_nodeTask> selectNodeTaskPageTable(PageTable<Gbpm_nodeTask> pageTable);
	
	/**
	 * 分页查询产品节点任务事项列表-查询总记录数
	 */
	public Long selectNodeTaskPageTable_Count(PageTable<Gbpm_nodeTask> pageTable);
	
	/**
	 *  查询一条产品节点任务事项
	 */
	public Gbpm_nodeTask selectOneNodeTask(Gbpm_nodeTask nodeTask);
	
	/**
	 *  插入一条产品节点任务事项
	 */
	public Integer insertOneNodeTask(Gbpm_nodeTask nodeTask);
	
	/**
	 *  修改一条产品节点任务事项
	 */
	public Integer updateOneNodeTask(Gbpm_nodeTask nodeTask);
	
	/**
	 *  删除一条产品节点任务事项
	 */
	public Integer deleteOneNodeTask(Gbpm_nodeTask nodeTask);
	
	/**
	 *  判断产品节点任务事项名称是否已存在
	 */
	public Integer isExistNodeTaskName(Gbpm_nodeTask nodeTask);

	/**
	 * 根据wheresql获取节点任务事项List
	 * @param wheresql
	 * @return
	 */
	public List<Gbpm_nodeTask> selectNodeTaskListByWheresql(String wheresql);

	/**
	 *  根据wheresql删除产品节点任务事项
	 */
	public void deleteNodeTaskByWheresql(String wheresql);

	/**
	 *  修改一条产品流程信息
	 */
	public int updateSortNodeTask(Gbpm_nodeTask nodeTask);

	
}
