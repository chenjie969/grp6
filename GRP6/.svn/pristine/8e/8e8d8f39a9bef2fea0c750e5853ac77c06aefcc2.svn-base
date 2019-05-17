package com.zjm.gbpm.finishNode.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.gbpm.db.map.Gbpm_finishNodeMapper;
import com.zjm.gbpm.db.model.Gbpm_finishNode;
import com.zjm.gbpm.finishNode.service.FinishNodeService;
@Service("finishNodeService")
@Transactional
public class FinishNodeServiceImpl implements FinishNodeService {

	@Resource
	private Gbpm_finishNodeMapper finishNodeMapper;
	@Resource
	private LogService logService;

	/**
	 *  根据输入条件查询已经完成节点；
	 * @param WhereSql
	 * 实例ID，任务顺序
	 * @return Gbpm_finishNode
	 */
	public Gbpm_finishNode selectOneFinishNodeByWhereSql(String whereSql) {
		Gbpm_finishNode  finishNode=	finishNodeMapper.selectOneFinishNodeByWhereSql(whereSql);
		return finishNode;
	}

	/**
	 * 插入一条已完成节点
	 * @param finishNode
	 */
	@Override
	public void insertOneFinishNode(User user,Gbpm_finishNode finishNode) {
		if (finishNodeMapper.insertOneFinishNode(finishNode) > 0) {
			logService.insertOneOperatorLogInfo(user,"已完成节点", "新增", "新增已完成节点"+finishNode.getFinishNode_ID());
		}
	}

	/**
	 * 根据wheresql删除已完成节点
	 * @param finishNode
	 */
	@Override
	public Boolean deleteFinishNodeByWheresql(User user, String wheresql) {
		if (finishNodeMapper.deleteFinishNodeByWheresql(wheresql) > 0) {
			logService.insertOneOperatorLogInfo(user,"已完成节点", "删除", "删除已完成节点");
			return true;
		}
		return false;
	}

	/**
	 * 根据wheresql获取已完成节点List
	 * @param finishNode
	 */
	@Override
	public List<Gbpm_finishNode> selectFinishNodeListByWheresql(String wheresql) {
		List<Gbpm_finishNode> finishNodeList = finishNodeMapper.selectFinishNodeListByWheresql(wheresql);
		return finishNodeList;
	}

}
