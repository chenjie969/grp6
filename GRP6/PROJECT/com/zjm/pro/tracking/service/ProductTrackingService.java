package com.zjm.pro.tracking.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.gbpm.db.model.Gbpm_productNode;
import com.zjm.gbpm.db.model.Gbpm_runNode;

public interface ProductTrackingService {
     /**
      * 根据产品id 获取产品节点；
      * @param productID
      * @return
      */
	public List<Gbpm_productNode> selectProductNodeListByID(User user,String productID);
	
	/**
	 * 获取正在运行节点信息；
	 * @param 产品实例id
	 */
	public Gbpm_runNode   selectRunningNodeByProductInstanceID(User user,String productInstanceID);
   
	/**
     * 获取正在执行的节点的任务：
     * @param pageTable
     * @return
     */
	public PageTable selectRunningNodeTaskTable(PageTable pageTable);
	/**
	 * 获取已经完成的节点的任务：
	 * @param pageTable
	 * @return
	 */
	public PageTable selectFinishNodeTaskTable(PageTable pageTable);
	/**
	 * 获取未执行的节点的任务：
	 * @param pageTable
	 * @return
	 */
	public PageTable selectNotRunNodeTaskTable(PageTable pageTable);
     
	/**
	 * 根据ProjectNode_ID获取未执行节点限办天数
	 * @param string
	 * @return
	 */
	public Gbpm_productNode selectNotActiveNodeLimitDay(String string);
	/**
	 * 根据runtNode_ID获取正在执行节点限办天数
	 * @param string
	 * @return
	 */
	public Gbpm_runNode selectRunNodeLimitDay(String string);
	/**
	 * 根据productInstanceID,nodeSort 获取已完成节点限办天数
	 * @param whereSql
	 * @return
	 */
	public com.zjm.gbpm.db.model.Gbpm_finishNode selectFinishNodeLimitDay(String whereSql);
	
	
	
	
}
