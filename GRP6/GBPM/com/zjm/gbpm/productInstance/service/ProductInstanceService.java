package com.zjm.gbpm.productInstance.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.gbpm.db.model.Gbpm_productInstance;

/**
 * 
 * 产品实例service
 */

public interface ProductInstanceService {
	/**
	 *  根据输入条件查询单个产品实例；
	 * @param WhereSql
	 * apply_ID
	 * @return
	 */
	public Gbpm_productInstance   selectOneProductInstanceByWhereSql(String whereSql);

	/**
	 * 新增一个产品流程实例
	 * @param userSession
	 * @param productInstance
	 * @return
	 */
	public Boolean insertOneProductInstanceInfo(User userSession, Gbpm_productInstance productInstance);

	/**
	 *判断流程是否被实例化
	 * @param wheresql
	 * @return
	 */
	public Boolean isExistProductInstance(String wheresql);
	
	/**
	 *节点设置办理人 提交下一步
	 * @param Gbpm_productInstance
	 * @return
	 */
	public void nextStep(User user,Gbpm_productInstance productInstance);

	/**
	 *节点 返回上一步
	 * @param Gbpm_productInstance
	 * @return
	 */
	public Boolean backStep(User user,Gbpm_productInstance productInstance);

	/**
	 * 分页查询我发起的产品流程实例列表
	 */
	public PageTable<Gbpm_productInstance> selectProductMyBuildInstancePageTable(PageTable<Gbpm_productInstance> pageTable);

	/**
	 * 分页查询我参与的产品流程实例列表
	 */
	public PageTable<Gbpm_productInstance> selectProductMyJoinInstancePageTable(PageTable<Gbpm_productInstance> pageTable);

	/**
	 *重新提交到退回环节
	 * @param Gbpm_productInstance
	 * @return
	 */
	public Boolean returnBackNode(User userSession, Gbpm_productInstance productInstance);

	/**
	 * 删除流程实例
	 * @param gbpm_productInstance
	 * @return
	 */
	public Boolean delProductInstanceInfo(User user,Gbpm_productInstance gbpm_productInstance);

}
