package com.zjm.gworkFlow.pendingWorkFlow.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.gworkFlow.db.map.PendingWorkFlowMapper;
import com.zjm.gworkFlow.db.model.PendingWorkFlow;
import com.zjm.gworkFlow.pendingWorkFlow.service.PendingWorkFlowService;
@Service("pendingWorkFlowService")
@Transactional
public class PendingWorkFlowServiceImpl implements PendingWorkFlowService {

	@Resource
	private PendingWorkFlowMapper pendingWorkFlowMapper;
	
	
	/**
	 * 流程监控 列表  PageTable
	 * @return
	 */
	public PageTable returnMonitoringWorkFlowPageTable(PageTable pageTable ) {
		try {
			//取得一页的数据，并存入pageTable对象list属性中
			List<PendingWorkFlow> list = null;
			if(pageTable.getWheresql3()!=null && pageTable.getWheresql3().equals("1")){
				list=  pendingWorkFlowMapper.returnMonitoringWorkFlowPageTableWait(pageTable); //#####需修改#####################
			}else
			if(pageTable.getWheresql3()!=null && pageTable.getWheresql3().equals("4")){
				list=  pendingWorkFlowMapper.returnMonitoringWorkFlowPageTableStop(pageTable);
			}
			pageTable.setRows(list);
			//所有记录数	
			Long rowCount=0L;
			if(pageTable.getWheresql3()!=null && pageTable.getWheresql3().equals("1")){
				rowCount = pendingWorkFlowMapper.returnMonitoringWorkFlowPageTableCountWait( pageTable);	
			}else
			if(pageTable.getWheresql3()!=null && pageTable.getWheresql3().equals("4")){
				rowCount = pendingWorkFlowMapper.returnMonitoringWorkFlowPageTableCountStop( pageTable);
			}
			pageTable.setTotal(rowCount);
			return pageTable;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 待处理业务流程  pageTable
	 * @return
	 */
	public PageTable returnPendingWorkFlowPageTable(PageTable pageTable) {
		try {
			//取得一页的数据，并存入pageTable对象list属性中
			List<PendingWorkFlow> list = null;              
			list=  pendingWorkFlowMapper.returnPendingWorkFlowPageTable(pageTable); //#####需修改#####################
			pageTable.setRows(list);
			List<PendingWorkFlow> listStop = null;                                    
			Long rowCount = pendingWorkFlowMapper.returnPendingWorkFlowPageTableCount( pageTable);	
			pageTable.setTotal(rowCount);
			return pageTable;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 获取流程步骤信息
	 * @param pendingWorkFlow
	 * @return
	 */
	public List<PendingWorkFlow> returnWorkFlowStepInfo(PendingWorkFlow pendingWorkFlow){
		return pendingWorkFlowMapper.returnWorkFlowStepInfo(pendingWorkFlow);
	}
}
