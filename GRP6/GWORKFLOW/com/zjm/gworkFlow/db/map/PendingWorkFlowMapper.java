package com.zjm.gworkFlow.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.gworkFlow.db.model.PendingWorkFlow;

public interface PendingWorkFlowMapper {
	
	/**
	 * 流程监控  分页列表 待处理
	 * @return
	 */
	public List<PendingWorkFlow> returnMonitoringWorkFlowPageTableWait(PageTable pageTable);
	/**
	 * 流程监控  分页列表  已终止
	 * @return
	 */
	public List<PendingWorkFlow> returnMonitoringWorkFlowPageTableStop(PageTable pageTable);
	/**
	 * 流程监控  分页列表 待处理 记录数
	 * @return
	 */
	public Long returnMonitoringWorkFlowPageTableCountWait(PageTable pageTable);
	/**
	 * 流程监控  分页列表 已终止 记录数
	 * @return
	 */
	public Long returnMonitoringWorkFlowPageTableCountStop(PageTable pageTable);
	/**
	 * 跟踪流程 列表 待处理 ls add 
	 * @param pendingWorkFlow
	 * @return
	 */
	public List<PendingWorkFlow> returnTrackingFlowWait(PendingWorkFlow monitoringWorkFlow);
	/**
	 * 跟踪流程 列表   已终止  ls add
	 * @param pendingWorkFlow
	 * @return
	 */
	public List<PendingWorkFlow> returnTrackingFlowStop(PendingWorkFlow monitoringWorkFlow);
	/**
	 * 待处理业务流程  分页列表
	 * @return
	 */
	public List<PendingWorkFlow> returnPendingWorkFlowPageTable(PageTable pageTable);
	/**
	 * 待处理业务流程  分页列表 记录数
	 * @return
	 */
	public Long returnPendingWorkFlowPageTableCount(PageTable pageTable);
	/**
	 * //根据projectid查询该项目的所有待办
	 * @param projectid
	 * @return
	 */
	public List<PendingWorkFlow> returnAllWaitStepsByProjectID(PendingWorkFlow pendingWorkFlow);
	/**
	 * 获取流程步骤信息
	 * @param pendingWorkFlow
	 * @return
	 */
	public List<PendingWorkFlow> returnWorkFlowStepInfo(PendingWorkFlow pendingWorkFlow);

}
