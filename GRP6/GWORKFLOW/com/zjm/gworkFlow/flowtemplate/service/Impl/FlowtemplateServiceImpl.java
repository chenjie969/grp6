package com.zjm.gworkFlow.flowtemplate.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.gworkFlow.db.map.OsGworkflowFlowtemplateMapper;
import com.zjm.gworkFlow.db.model.OsGworkflowFlowtemplate;
import com.zjm.gworkFlow.flowtemplate.service.FlowtemplateService;

/** 
 * @author 作者 E-mail: java_lishuai@163.com
 * @version 创建时间：2014-11-19 下午2:03:16 
 * 类说明： 
 */
@Service("flowtemplateService")
@Transactional
public class FlowtemplateServiceImpl implements FlowtemplateService{
	
	//@Resource(name="flowtemplateDao")
	//private FlowtemplateDao flowtemplateDao;
	
	@Resource
	private OsGworkflowFlowtemplateMapper osGworkflowFlowtemplateMapper;
	
	/**
	 * 获取所有的流程模板
	 * @param osGworkflowFlowtemplate
	 * @return
	 */
	public List<OsGworkflowFlowtemplate> returnAllFlowtemplateList(OsGworkflowFlowtemplate osGworkflowFlowtemplate){
		return osGworkflowFlowtemplateMapper.returnAllFlowtemplateList(osGworkflowFlowtemplate);
	}
	
	//取得一个流程模板的对象
	public OsGworkflowFlowtemplate getOneGworkflowTemplate(OsGworkflowFlowtemplate osGworkflowFlowtemplate){
			return osGworkflowFlowtemplateMapper.getOneGworkflowTemplate(osGworkflowFlowtemplate);
	}
	/**
	 * 判断是否已有流程实例 并且尚未结束
	 */
	public Boolean stateWorkFlowInstance(OsGworkflowFlowtemplate osGworkflowFlowtemplate) {
		if(osGworkflowFlowtemplateMapper.stateWorkFlowInstance(osGworkflowFlowtemplate)>0){
			return false;
		}else{
			return	true;
		}
	}
	/**
	 * 判断是否已有流程实例 
	 * @param os_step
	 * @return
	 */
	public Boolean stateWorkFlowStartInstance(
			OsGworkflowFlowtemplate osGworkflowFlowtemplate) {
		if(osGworkflowFlowtemplateMapper.stateWorkFlowStartInstance(osGworkflowFlowtemplate)>0){
			return true;
		}else{
			return	false;
		}
	}
	/**
	 * 获取所有的公文管理流程模板
	 * @return
	 */
	public List<OsGworkflowFlowtemplate> returnAllFlowtemplateListByFlowTypeID(
			OsGworkflowFlowtemplate osGworkflowFlowtemplate) {
		return osGworkflowFlowtemplateMapper.returnAllFlowtemplateListByFlowTypeID(osGworkflowFlowtemplate);
	}

}

