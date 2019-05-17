package com.zjm.gbpm.nodeTask.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.gbpm.db.model.Gbpm_nodeTask;

public interface NodeTaskService{
	/**
	 * 分页查询产品节点任务事项列表
	 */
	public PageTable<Gbpm_nodeTask> selectNodeTaskPageTable(PageTable<Gbpm_nodeTask> pageTable);

	/**
	 * 新增/修改时判断产品节点任务事项名称是否存在
	 */
	public Boolean isExistNodeTaskName(Gbpm_nodeTask nodeTask);

	/**
	 *  插入一条产品节点任务事项
	 */
	public Boolean insertOneNodeTask(User userSession, Gbpm_nodeTask nodeTask);

	/**
	 *  查询一条产品节点任务事项信息
	 */
	public Gbpm_nodeTask selectOneNodeTaskInfo(Gbpm_nodeTask nodeTask);

	/**
	 *  查询一条产品节点任务事项信息
	 */
	public Boolean updateOneNodeTaskInfo(User userSession, Gbpm_nodeTask nodeTask);

	/**
	 *  执行操作-删除一条产品节点任务事项
	 */
	public Boolean deleteOneNodeTask(User userSession, Gbpm_nodeTask nodeTask);

	/**
	 * 根据wheresql获取节点任务事项List
	 * @param wheresql
	 * @return
	 */
	List<Gbpm_nodeTask> selectNodeTaskListByWheresql(String wheresql);

	/**
	 *  根据wheresql删除产品节点任务事项
	 */
	public void deleteNodeTaskByWheresql(User user, String wheresql);

	/**
	 *  执行操作-修改节点顺序
	 */
	public Boolean updateSortNodeTask(User userSession, Gbpm_nodeTask nodeTask);

	public Boolean insertMuchNodeTask(User userSession, Gbpm_nodeTask nodeTask);

}