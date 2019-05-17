package com.zjm.pro.projectCode.service.impl;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.db.map.Pro_projectCodeMapper;
import com.zjm.pro.db.model.Pro_projectCode;
import com.zjm.pro.projectCode.service.ProjectCodeService;
import com.zjm.util.Tool;
/**
 * 项目编号
 * @author chenyang   add 20170719
 */
@Service("projectCodeService")
@Transactional
public class ProjectCodeServiceImpl implements ProjectCodeService{
	@Resource(name="pro_projectCodeMapper")
	private	Pro_projectCodeMapper pro_projectCodeMapper;
	@Resource
	private	LogService logService;
	
	/**
	 * 查询一个项目编号信息
	 * @param Pro_projectCode
	 * @return
	 */
	@Override
	public Pro_projectCode selectOneProjectCodeInfo(Pro_projectCode projectCode) {
		Calendar a=Calendar.getInstance();
		projectCode.setYears(a.get(Calendar.YEAR));
		Pro_projectCode projectCode2 = pro_projectCodeMapper.selectOneProjectCodeInfo(projectCode);
		if (projectCode2 == null) {
			projectCode.setProjectCode_ID(Tool.createUUID32());
			projectCode.setApplyCode(1);
			projectCode.setProjectCode(1);
			projectCode.setCreditCode(1);
			Boolean boolean1 = pro_projectCodeMapper.insertOneProjectCodeInfo(projectCode);
			return projectCode;
		}
		return projectCode2;
	}

	/**
	 * 更新项目编号信息
	 * @param Pro_projectCode
	 * @return
	 */
	@Override
	public Boolean updateOneProjectCodeInfo(User user,Pro_projectCode projectCode) {
		if(pro_projectCodeMapper.updateOneProjectCodeInfo(projectCode)){
			logService.insertOneOperatorLogInfo(user,"项目编号", "修改", "修改项目编号");
			return true;	
		}else{
			return false;
		}
	}

	/**
	 * 新增项目时获取编号当前值
	 * @return
	 */
	@Override
	public Pro_projectCode returnOneProjectCode(User user,String projectType) {
		Pro_projectCode projectCode=new Pro_projectCode();
		projectCode.setUnit_uid(user.getUnit_uid());
		projectCode=this.selectOneProjectCodeInfo(projectCode);//查询编号当前值
		if(projectType.equals("apply")){
			projectCode.setApplyCode(projectCode.getApplyCode()+1);
			this.updateOneProjectCodeInfo(user,projectCode);//回写受理登记项目编号当前值+1
			projectCode.setApplyCode(projectCode.getApplyCode()-1);
		}
		if(projectType.equals("applyDetail")){
			projectCode.setProjectCode(projectCode.getProjectCode()+1);
			this.updateOneProjectCodeInfo(user,projectCode);//回写受理登记项目编号当前值+1
			projectCode.setProjectCode(projectCode.getProjectCode()-1);
		}
		if (projectType.equals("credit")) {
			projectCode.setCreditCode(projectCode.getCreditCode()+1);
			this.updateOneProjectCodeInfo(user,projectCode);//回写授信项目编号当前值+1
			projectCode.setCreditCode(projectCode.getCreditCode()-1);
		}
		return projectCode;
	}
	
	
}
