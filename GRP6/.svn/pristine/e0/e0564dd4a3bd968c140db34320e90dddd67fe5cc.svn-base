package com.zjm.gbpm.actSort.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.gbpm.actSort.service.ActSortService;
import com.zjm.gbpm.db.map.Act_re_actSortMapper;
import com.zjm.gbpm.db.map.Act_re_model_actSortMapper;
import com.zjm.gbpm.db.map.Act_re_model_deploymentMapper;
import com.zjm.gbpm.db.model.Act_re_actSort;
import com.zjm.gbpm.db.model.Act_re_model_actSort;
import com.zjm.gbpm.processDefinition.service.ProcessDefinitionService;
import com.zjm.sys.db.model.Sys_modules;
@Service("actSortService")
@Transactional
public class ActSortServiceImpl implements ActSortService {
	@Resource
	private Act_re_actSortMapper actSortMapper;
	@Resource//activiti模型与流程分类关系表
	private Act_re_model_actSortMapper modelActSortMapper;
	@Resource//activiti模型与部署关系表
	private Act_re_model_deploymentMapper modelDeploymentMapper;
	@Resource//流程设计
	private ProcessDefinitionService processDefinitionService;

	/**
	 * 返回流程分类分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectActSortPageTables(PageTable pageTable) {
		List<Act_re_actSort> list=actSortMapper.selectActSortPageTables(pageTable);
		Long total=actSortMapper.selectActSortPageTables_Count(pageTable);
		pageTable.setRows(list);
		pageTable.setTotal(total);
		return pageTable;
	}

	/**
	 * 插入一个流程分类信息
	 * @param actSort
	 * @return
	 */
	public Boolean insertOneActSortInfo(Act_re_actSort actSort) {
		//查询流程分类记录数
		Long total=actSortMapper.selectActSortPageTables_Count(new PageTable());
		actSort.setOrder_id(total.intValue());
		if(actSortMapper.insertOneActSortInfo(actSort)==1){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 判断流程分类名称是否重复
	 * @param wheresql
	 * @return
	 */
	public Boolean selectActSortNameIsExist(String wheresql) {
		if(actSortMapper.selectActSortNameIsExist(wheresql)==0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 查询一个流程分类信息
	 * @param actSort
	 * @return
	 */
	public Act_re_actSort selectOneActSortInfo(Act_re_actSort actSort) {
		actSort= actSortMapper.selectOneActSortInfo(actSort);
		return actSort;
	}

	/**
	 * 更新一个流程分类信息
	 * @param actSort
	 * @return
	 */
	public Boolean updateOneActSortInfo(Act_re_actSort actSort) {
		if(actSortMapper.updateOneActSortInfo(actSort)==1){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 删除一个流程分类信息
	 * @param actSort
	 * @return
	 */
	public Boolean delectOneActSortInfo(Act_re_actSort actSort,User userSession) {
		deleteOneActSortDownInfo(actSort,userSession);
		if(actSortMapper.delectOneActSortInfo(actSort)==1){
			List<Act_re_model_actSort> list=modelActSortMapper.selectModelActSortList("  and unit_uid=\'"+userSession.getUnit_uid()+"\' and actSortID=\'"+actSort.getActSortID()+"\' ");
			for (Act_re_model_actSort act_re_model_actSort : list) {
				JSONObject requestParams=new JSONObject();
				requestParams.put("modelId", act_re_model_actSort.getModelID());
				processDefinitionService.delectProcessDefinitionModel(requestParams.toJSONString(), userSession);
			}
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 删除下级流程分类
	 * @param actSort
	 */
	private void deleteOneActSortDownInfo(Act_re_actSort actSort,User userSession) {
		//判断是否有下级菜单
		List<Act_re_actSort> list=actSortMapper.selectActSortList(" and pactSortID = \'"+ actSort.getActSortID()+"\'");
		for (Act_re_actSort actSort2 : list) {
			deleteOneActSortDownInfo(actSort2,userSession);
			List<Act_re_model_actSort> list2=modelActSortMapper.selectModelActSortList("  and unit_uid=\'"+userSession.getUnit_uid()+"\' and actSortID=\'"+actSort2.getActSortID()+"\' ");
			for (Act_re_model_actSort act_re_model_actSort : list2) {
				JSONObject requestParams=new JSONObject();
				requestParams.put("modelId", act_re_model_actSort.getModelID());
				processDefinitionService.delectProcessDefinitionModel(requestParams.toJSONString(), userSession);
			}
			actSortMapper.delectOneActSortInfo(actSort2);
		}
	}

	/**
	 * 查询流程分类列表List
	 * @param wheresql
	 * @return
	 */
	public List<Act_re_actSort> selectActSortList(String wheresql) {
		return actSortMapper.selectActSortList(wheresql);
	}

}
