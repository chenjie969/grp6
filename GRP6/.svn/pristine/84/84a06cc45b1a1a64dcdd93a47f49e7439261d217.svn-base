package com.zjm.gworkFlow.db.map;

import java.util.List;
import java.util.Map;

import com.zjm.gworkFlow.db.model.PendingWorkFlow;
import com.zjm.gworkFlow.db.model.OsHistorystep;

/** 
 * @author 作者mashuo
 * @version 创建时间：20170914
 * 类说明： 
 */
public interface OsHistorystepMapper {
	
	/**
	 * 取得某一个流程实例的所有历史步骤
	 * @param osHistorystep
	 * @return
	 */
	public List<OsHistorystep> getAllHistoryStep(OsHistorystep osHistorystep);
	
	/**
	 * 取得历史步骤ID的上一个步骤记录ID，有可能是多个
	 * @param osHistorystep
	 * @return
	 */
	public List<OsHistorystep> getHistoryPREVIOUS_ID(Long ID);
	
	/**
	 * 根据id取得步骤的名称
	 * @param ID
	 * @return
	 */
	public List<OsHistorystep> getHistoryPREVIOUS_stepName(Long ID);

	/**
	 * 取得某一个流程实例的所有当前步骤
	 * @param entry_ID
	 * @return
	 */
	public List<OsHistorystep> getAllCurSteps(Long entry_ID);
	
	/**
	 * 取得当前步骤ID的上一个步骤记录ID，有可能是多个
	 * @param ID
	 * @return
	 */
	public List<OsHistorystep> getAllCurPreviousSteps(Long ID);
	/**
	 * 删除一个项目的流程信息
	 * @param wheresql
	 * @return
	 */
	public Integer delOneProjectFlow(String wheresql);
	
	/**
	 * 插入一条历史记录
	 * @param osHistorystep
	 * @return
	 */
	public Integer insertOneHistoryStep(OsHistorystep osHistorystep);
	
	/**
	 * 获取项目的所有待办流程
	 * @param pendingWorkFlow
	 * @return
	 */
	public List<OsHistorystep> returnProjPendingList(PendingWorkFlow pendingWorkFlow);
	
	/**
	 * 删除 代办记录 步骤对应表记录
	 * @param osHistorystep
	 * @return
	 */
	public Integer deletePendingOfBeforeStep(OsHistorystep osHistorystep);
	/**
	 * 删除一条代办记录
	 * @param osHistorystep
	 * @return
	 */
	public Integer deletePending(OsHistorystep osHistorystep);
	
	/**
	 * 改变流程状态
	 * @param status
	 * @param flowID
	 * @return
	 */
	public Integer updateWfentryStatus(Map<String, Object> map);
	/**
	 * 更新指定的待办人员
	 * @return
	 */
	public Integer updateWaitUserInfo(PendingWorkFlow pendingWorkFlow);
	/**
	 * 查询流程项目实例对应表，返回流程ENTRY_ID
	 * @param wheresql
	 * @return
	 */
	public Long returnOneWorkFlowENTRYID(String wheresql);
	/**
	 * 修改步骤的限办时间
	 * @param wheresql2
	 * @return
	 */
	public Integer updateOneWorkFlowStepLimitDate(String wheresql2);
}

