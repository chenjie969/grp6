package com.zjm.gbpm.runNode.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.gbpm.db.map.Gbpm_runNodeMapper;
import com.zjm.gbpm.db.model.Gbpm_runNode;
import com.zjm.gbpm.runNode.service.RunNodeService;
import com.zjm.util.Tool;
@Service("runNodeService")
@Transactional
public class RunNodeServiceImpl implements RunNodeService {

	@Resource
	private Gbpm_runNodeMapper runNodeMapper;
	@Resource
	private LogService logService;
 
	/**
	 *  根据输入条件查询运行中节点；
	 * @param WhereSql
	 * 实例ID，节点顺序
	 * @return Gbpm_runNode
	 */
	public Gbpm_runNode selectOneRunNodeByWhereSql(String whereSql) {
		Gbpm_runNode oneRunNode = runNodeMapper.selectOneRunNodeByWhereSql(whereSql);
		return oneRunNode;
	}
	
	/**
	 * 新增一个运行中节点
	 * @param runNode
	 * @return
	 */
	public Boolean insertOneRunNodeInfo(User userSession,Gbpm_runNode runNode) {
		runNode.setUnit_uid(userSession.getUnit_uid());
		runNode.setUnit_uidName(userSession.getUnit_uidName());
		runNode.setUpdateUserName(userSession.getUser_name());
		if (runNodeMapper.insertOneRunNodeInfo(runNode)==1) {
			logService.insertOneOperatorLogInfo(userSession,"运行中节点", "新增", "新增运行中节点"+runNode.getRunNode_ID());
			return true;
		}
		return false;
	}

	/**
	 * 删除一个运行中节点
	 * @param wheresql
	 */
	@Override
	public void deleteRunNodeByWheresql(User user,String wheresql) {
		runNodeMapper.deleteRunNodeByWheresql(wheresql);
		logService.insertOneOperatorLogInfo(user,"运行中节点", "删除", "删除运行中节点");		
	}

	/**
	 * 更新一个运行中节点
	 * @param wheresql
	 */
	@Override
	public Boolean updateOneRunNodeInfo(User userSession, Gbpm_runNode runNode) {
		runNode.setUpdateUserName(userSession.getUser_name());
		if (runNodeMapper.updateOneRunNodeInfo(runNode) > 0 ) {
			logService.insertOneOperatorLogInfo(userSession,"运行中节点", "更新", "更新运行中节点");		
			return true;
		}
		return false;
	}
	


}
