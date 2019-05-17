package com.zjm.pro.returnDetail.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.db.map.Pro_returnDetailMapper;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.db.model.Pro_returnDetail;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.pro.returnDetail.service.ReturnDetailService;
import com.zjm.util.Tool;

@Service("returnDetailService")
@Transactional
public class ReturnDetailServiceImpl implements ReturnDetailService {

	@Resource
	private Pro_returnDetailMapper returnDetailMapper;
	
	@Resource
	private LogService logService;
	@Resource
	private ProjectService projectService;

	/**
	 * 查询追偿分页列表
	 */
	@Override
	public PageTable<Pro_returnDetail> selectReturnDetailPageTable(PageTable<Pro_returnDetail> pageTable) {
		pageTable.setRows(returnDetailMapper.selectReturnDetailPageTable(pageTable));
		pageTable.setTotal(returnDetailMapper.selectReturnDetailPageTable_Count(pageTable));
		return pageTable;
	}

	/**
	 * 新增追偿情况
	 */
	@Override
	public Boolean insertOneReturnDetailInfo(User userSession, Pro_returnDetail pro_returnDetail) {
		Boolean b = false;
		//根据业务id获取业务表信息;
		String wheresql = " and project_ID = \'"+pro_returnDetail.getProjectID()+"\'";
	    Pro_project project = projectService.selectOneProjectInfoByWheresql(wheresql);
	    //新增一笔代偿表信息;
	    pro_returnDetail.setReturnDetail_ID(Tool.createUUID32());
	    pro_returnDetail.setUnit_uid(userSession.getUnit_uid());
	    pro_returnDetail.setUpdateUserName(userSession.getUser_name());
	    Integer returnInt = returnDetailMapper.insertOneReturnDetailInfo(pro_returnDetail);
	    
	    //更新 业务主表
  		if(project != null){
  			//更新追偿总金额
  			Double rReturnSum=0d;
  			rReturnSum=project.getReturnSum()==null ?0d :project.getReturnSum(); //拿到之前追偿金额
  			project.setReturnSum(rReturnSum+(pro_returnDetail.getReturnSum()==null?0d:pro_returnDetail.getReturnSum()));
  			
  			//更新追偿本金
  			Double rReturnCapitalSum=0d;
  			rReturnCapitalSum=project.getReturnCapitalSum()==null ?0d :project.getReturnCapitalSum();// 拿到之前的追偿本金
  			project.setReturnCapitalSum(rReturnCapitalSum+(pro_returnDetail.getReturnCapitalSum()==null ?0d :pro_returnDetail.getReturnCapitalSum()));
  			
  			
  			//更新追偿利息
  			Double rReturnInterestSum=0d;
  			rReturnInterestSum=project.getReturnInterestSum()==null ?0d :project.getReturnInterestSum();
  			project.setReturnInterestSum(rReturnInterestSum + (pro_returnDetail.getReturnInterestSum()==null ? 0d : pro_returnDetail.getReturnInterestSum() ) );
  			
  			//更新追偿其它
  			Double rReturnOtherSum=0d;
  			rReturnOtherSum=project.getReturnOtherSum()==null ?0d:project.getReturnOtherSum();//拿到之前的代偿解除其它
  			project.setReturnOtherSum(rReturnOtherSum+(pro_returnDetail.getReturnOtherSum()==null ?0d :pro_returnDetail.getReturnOtherSum()));
  		}
  		projectService.updateOneProjectInfo(userSession, project);
  		if(1==returnInt){
			logService.insertOneOperatorLogInfo(userSession,"追偿登记", "更新", "更新一条项目追偿信息project_ID=" + pro_returnDetail.getProjectID());
			logService.insertOneOperatorLogInfo(userSession,"追偿登记", "新增", "新增一条追偿表信息returnDetail_ID=" + pro_returnDetail.getReturnDetail_ID());
			b= true;
		}
		return b;
	}
	/**
	 * 修改追偿情况
	 */
	@Override
	public Boolean updateOneReturnDetailInfo(User userSession, Pro_returnDetail pro_returnDetail) {
		Boolean b = false;
		//根据业务id获取业务表信息;
		String wheresql = " and project_ID = \'"+pro_returnDetail.getProjectID()+"\'";
		Pro_project project = projectService.selectOneProjectInfoByWheresql(wheresql);
		
		//查询原来的代偿信息;
		wheresql = " and returnDetail_ID = \'"+pro_returnDetail.getReturnDetail_ID()+"\'";
		Pro_returnDetail old_returnDetail = returnDetailMapper.selectOneReturnDetailInfo(wheresql);
		//修改一笔代偿表信息;
		pro_returnDetail.setUpdateUserName(userSession.getUser_name());
		Integer returnInt = returnDetailMapper.updateOneReturnDetailInfo(pro_returnDetail);
		
		//更新 业务主表
		if(project != null){
			//更新追偿总金额
			Double rReturnSum=0d;
			rReturnSum=project.getReturnSum()==null ?0d :project.getReturnSum(); //拿到之前追偿金额
			project.setReturnSum(rReturnSum+(pro_returnDetail.getReturnSum()==null?0d:pro_returnDetail.getReturnSum())-(old_returnDetail.getReturnSum()==null?0d:old_returnDetail.getReturnSum()));
			
			//更新追偿本金
			Double rReturnCapitalSum=0d;
			rReturnCapitalSum=project.getReturnCapitalSum()==null ?0d :project.getReturnCapitalSum();// 拿到之前的追偿本金
			project.setReturnCapitalSum(rReturnCapitalSum+(pro_returnDetail.getReturnCapitalSum()==null ?0d :pro_returnDetail.getReturnCapitalSum())-(old_returnDetail.getReturnCapitalSum()==null ?0d :old_returnDetail.getReturnCapitalSum()));
			
			
			//更新追偿利息
			Double rReturnInterestSum=0d;
			rReturnInterestSum=project.getReturnInterestSum()==null ?0d :project.getReturnInterestSum();
			project.setReturnInterestSum(rReturnInterestSum + (pro_returnDetail.getReturnInterestSum()==null ? 0d : pro_returnDetail.getReturnInterestSum())-(old_returnDetail.getReturnInterestSum()==null ? 0d : old_returnDetail.getReturnInterestSum()));
			
			//更新追偿其它
			Double rReturnOtherSum=0d;
			rReturnOtherSum=project.getReturnOtherSum()==null ?0d:project.getReturnOtherSum();//拿到之前的代偿解除其它
			project.setReturnOtherSum(rReturnOtherSum+(pro_returnDetail.getReturnOtherSum()==null ?0d :pro_returnDetail.getReturnOtherSum())-(old_returnDetail.getReturnOtherSum()==null ?0d :old_returnDetail.getReturnOtherSum()));
		}
		projectService.updateOneProjectInfo(userSession, project);
		if(1==returnInt){
			logService.insertOneOperatorLogInfo(userSession,"追偿登记", "更新", "更新一条项目追偿信息project_ID=" + pro_returnDetail.getProjectID());
			logService.insertOneOperatorLogInfo(userSession,"追偿登记", "更新", "更新一条追偿表信息returnDetail_ID=" + pro_returnDetail.getReturnDetail_ID());
			b= true;
		}
		return b;
	}

	/**
	 * 查询一条追偿信息
	 */
	@Override
	public Pro_returnDetail selectOneReturnDetailInfo(String wheresql) {
		return returnDetailMapper.selectOneReturnDetailInfo(wheresql);
	}
}
