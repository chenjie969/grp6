package com.zjm.gbpm.taskType.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.gbpm.db.map.Gbpm_taskTypeMapper;
import com.zjm.gbpm.db.model.Gbpm_taskType;
import com.zjm.gbpm.taskType.service.TaskTypeService;
import com.zjm.util.Tool;


@Service("taskTypeService")
@Transactional
public class TaskTypeServiceImpl implements TaskTypeService{
	@Resource
	private Gbpm_taskTypeMapper gbpm_taskTypeMapper;
	@Resource
	private LogService logService;
	
	/**
	 * 插入一个任务事项类型
	 * @return
	 */
	@Override
	public Boolean insertOneTaskType(User user, Gbpm_taskType gbpm_taskType) {
		gbpm_taskType.setTaskType_ID(Tool.createUUID32());
		gbpm_taskType.setUnit_uid(user.getUnit_uid());
		gbpm_taskType.setUpdate_user(user.getUser_name());
		//查询同级节点下共有多少任务实现类型
		gbpm_taskType.setTaskTypeSort(gbpm_taskTypeMapper.selectTaskTypeOrderId(gbpm_taskType));
		String wheresql = " and taskType_ID = \'" + gbpm_taskType.getpTaskType_ID() +"\'";
		Gbpm_taskType pGbpm_taskType = gbpm_taskTypeMapper.selectOneTaskTypeByWheresql(wheresql);
		String taskTypeFullCode = null;
		if (pGbpm_taskType != null) {
			taskTypeFullCode = pGbpm_taskType.getTaskTypeFullCode()+gbpm_taskType.getTaskType_ID()+"/";
		} else {
			taskTypeFullCode = gbpm_taskType.getTaskType_ID()+"/";
		}
		gbpm_taskType.setTaskTypeFullCode(taskTypeFullCode);
		if(gbpm_taskTypeMapper.insertOneTaskTypeInfo(gbpm_taskType)==1){
			logService.insertOneOperatorLogInfo(user,"任务事项类型", "添加", gbpm_taskType.getTaskTypeName());
			return true;
		}
		return false;
	}
	
	/**
	 * 插入一个任务事项类型
	 * @return
	 */
	@Override
	public Boolean updateOneTaskType(User user, Gbpm_taskType gbpm_taskType) {
		gbpm_taskType.setUpdate_user(user.getUser_name());
		if(gbpm_taskTypeMapper.updateOneTaskTypeInfo(gbpm_taskType)==1){
			logService.insertOneOperatorLogInfo(user,"任务事项类型", "修改", gbpm_taskType.getTaskTypeName());
			return true;
		}
		return false;
	}
	
	/**
	 *查询所有任务事项类型
	 * @return
	 */
	@Override
	public List<Gbpm_taskType> selectAllTaskTypeList(String wheresql) {
		return gbpm_taskTypeMapper.selectTaskTypeList(wheresql);
	}

	/**
	 * 添加时判断任务事项类型名称是否重复
	 * @return
	 */
	@Override
	public Boolean selectTaskTypeIsExist(String wheresql) {
		if(gbpm_taskTypeMapper.selectTaskTypeIsExist(wheresql)==0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Boolean deleteOneTaskTypeInfo(User user, Gbpm_taskType gbpm_taskType) {
		//删除下级部门
		deleteOneTaskTypeDownInfo(user,gbpm_taskType);
//		Sys_dep_user dUser = new Sys_dep_user();
//		dUser.setDepart_uid(sys_departs.getDepart_uid());
//		sys_dep_userMapper.deleteOneDepUserInfo(dUser);
		
		String wheresql = " and taskType_ID =\'" +  gbpm_taskType.getTaskType_ID() +"\'";
		if(gbpm_taskTypeMapper.deleteOneTaskTypeInfo(wheresql)==1){
			logService.insertOneOperatorLogInfo(user,"任务事项类型", "删除", "删除任务事项类型");
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 删除子部门（子方法）
	 * @param sys_departs
	 */
	private void deleteOneTaskTypeDownInfo(User user,Gbpm_taskType gbpm_taskType) {
		try {
			//判断是否有下级部门
			List<Gbpm_taskType> list=gbpm_taskTypeMapper.selectTaskTypeList(" and pTaskType_ID = \'"+ gbpm_taskType.getTaskType_ID()+"\'");
			for (Gbpm_taskType gbpm_taskType2 : list) {
				deleteOneTaskTypeDownInfo(user,gbpm_taskType2);
				//删除下级任务事项类型
				String wheresql = " and taskType_ID = \'" + gbpm_taskType2.getTaskType_ID() +"\'";
				gbpm_taskTypeMapper.deleteOneTaskTypeInfo(wheresql);
				
				logService.insertOneOperatorLogInfo(user,"任务事项类型", "删除", "删除任务事项类型");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}