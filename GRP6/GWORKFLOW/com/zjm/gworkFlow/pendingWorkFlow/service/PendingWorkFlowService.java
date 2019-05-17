package com.zjm.gworkFlow.pendingWorkFlow.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.gworkFlow.db.model.PendingWorkFlow;

public interface PendingWorkFlowService {
	/**
	 * 流程监控 列表  PageTable
	 * @return
	 */
	public PageTable returnMonitoringWorkFlowPageTable(PageTable pageTable ) ;
	/**
	 * 待处理业务流程  pageTable
	 * @return
	 */
	public PageTable returnPendingWorkFlowPageTable(PageTable pageTable) ;
	
	/**
	 * 获取流程步骤信息
	 * @param pendingWorkFlow
	 * @return
	 */
	public List<PendingWorkFlow> returnWorkFlowStepInfo(PendingWorkFlow pendingWorkFlow);
	
	/**
	 * 获取个人代办任务
	 * @param pageTable
	 * @return
	 */
//	public PageTable gworkWaitTaskPageTable(PageTable pageTable) ;
}
