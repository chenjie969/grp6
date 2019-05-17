package com.zjm.pro.replace.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.db.map.Pro_projectMapper;
import com.zjm.pro.db.map.Pro_projectfilesMapper;
import com.zjm.pro.db.map.Pro_replaceMapper;
import com.zjm.pro.db.model.Pro_factPay;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.db.model.Pro_replace;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.pro.replace.service.ReplaceService;
import com.zjm.util.BigDecimalUtil;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

@Service("replaceService")
@Transactional
public class ReplaceServiceImpl implements ReplaceService {

	@Resource
	private Pro_replaceMapper pro_replaceMapper;
	@Resource
	private Pro_projectMapper pro_projectMapper;
	
	@Resource
	private LogService logService;
	@Resource
	private ProjectService projectService;
	@Resource
	private Pro_projectfilesMapper projectfilesMapper;
	BigDecimalUtil bigDecimal = new BigDecimalUtil();
	
	
	public Boolean insertOneReplaceInfo(User user, Pro_replace pro_replace) {
			Integer returnInt2=0;
			Boolean b = false;
			//根据业务id获取业务表信息;
			String wheresql = " and project_ID = \'"+pro_replace.getProject_ID()+"\'";
		    Pro_project project = projectService.selectOneProjectInfoByWheresql(wheresql);
		    //新增一笔代偿表信息;
		    pro_replace.setReplace_ID(Tool.createUUID32());
		    pro_replace.setUnit_uid(user.getUnit_uid());
		    pro_replace.setUpdateUserName(user.getUser_name());
		    Integer returnInt = pro_replaceMapper.insertOneReplaceInfo(pro_replace);
		    
		    //更新 业务主表
	  		if(project != null){
	  			//更新在保余额   
	  			Double gGuarantySum=0d;
	  			gGuarantySum=project.getGuarantySum() ==null ? 0d :project.getGuarantySum();   //拿到之前的在保余额
	  			Double fGuarantySum = gGuarantySum-(pro_replace.getReplaceCapitalSum()==null ?0d:pro_replace.getReplaceCapitalSum()) <0 ? 0d:gGuarantySum-(pro_replace.getReplaceCapitalSum()==null ?0d:pro_replace.getReplaceCapitalSum());
	  			project.setGuarantySum(fGuarantySum);//设置新的在保余额
	  			
	  			// 更新逾期余额
	  			/*Double gOverplusSum = 0d;
	  			gOverplusSum = project.getOverplusSum() == null? 0d :project.getOverplusSum();
	  			project.setOverplusSum(gOverplusSum-(pro_replace.getReplaceCapitalSum()==null?0d:pro_replace.getReplaceCapitalSum()));
	  			*/
	  			//更新代偿总金额
	  			Double rReplaceFreeSum=0d;
	  			rReplaceFreeSum=project.getReplaceFreeSum()==null ?0d :project.getReplaceFreeSum(); //拿到之前代偿金额
	  			project.setReplaceFreeSum(rReplaceFreeSum+(pro_replace.getReplaceSum()==null?0d:pro_replace.getReplaceSum()));
	  			
	  			//更新代偿本金
	  			Double rReplaceCapitalSum=0d;
	  			rReplaceCapitalSum=project.getReplaceCapitalSum()==null ?0d :project.getReplaceCapitalSum();// 拿到之前的代偿本金
	  			project.setReplaceCapitalSum(rReplaceCapitalSum+(pro_replace.getReplaceCapitalSum()==null ?0d :pro_replace.getReplaceCapitalSum()));
	  			
	  			
	  			//更新代偿利息
	  			Double rReplaceInterestSum=0d;
	  			rReplaceInterestSum=project.getReplaceInterestSum()==null ?0d :project.getReplaceInterestSum();
	  			project.setReplaceInterestSum(rReplaceInterestSum + (pro_replace.getReplaceInterestSum()==null ? 0d : pro_replace.getReplaceInterestSum() ) );
	  			
	  			//更新代偿解除其它
	  			Double rReplaceOtherSum=0d;
	  			rReplaceOtherSum=project.getReplaceOtherSum()==null ?0d:project.getReplaceOtherSum();//拿到之前的代偿解除其它
	  			project.setReplaceOtherSum(rReplaceOtherSum+(pro_replace.getReplaceOtherSum()==null ?0d :pro_replace.getReplaceOtherSum()));
	  			
	  			//更新自有资金代偿
	  			Double rSelfReplaceSum=0d;
	  			rSelfReplaceSum=project.getSelfReplaceSum()==null ?0d:project.getSelfReplaceSum(); //拿到之前的自有资金代偿
	  			project.setSelfReplaceSum(rSelfReplaceSum+(pro_replace.getSelfReplaceSum()==null ?0d : pro_replace.getSelfReplaceSum()));
	  			
	  			//更新准备金冲抵
	  			Double dDangerReplaceSum=0d;
	  			dDangerReplaceSum=project.getDangerReplaceSum()==null ?0d:project.getDangerReplaceSum(); //拿到之前的准备金冲抵
	  			project.setDangerReplaceSum(dDangerReplaceSum+(pro_replace.getDangerReplaceSum()==null?0d:pro_replace.getDangerReplaceSum()));
	  			
	  			//更新代偿解除日期
	  			project.setReplaceDate(pro_replace.getReplaceDate());
	  			project.setUpdateUserName(user.getUser_name());
	  			 returnInt2=pro_projectMapper.updateOneProjectInfo(project);
	  		}
	  		if(1==returnInt&&1==returnInt2){
				logService.insertOneOperatorLogInfo(user,"代偿登记", "更新", "更新一条项目代偿信息project_ID="+pro_replace.getProject_ID());
				logService.insertOneOperatorLogInfo(user,"代偿登记", "新增", "新增一条代偿表信息replace_ID="+pro_replace.getReplace_ID());
				b= true;
			}
			return b;
	}
	/**
	 * 修改一个代偿信息,并修改project表项目信息
	 */
	public Boolean updateOneReplaceInfo(User user, Pro_replace pro_replace) {
		Integer returnInt2=0;
		Boolean b = false;
		//根据业务id获取业务表信息;
		String wheresql = " and project_ID = \'"+pro_replace.getProject_ID()+"\'";
		Pro_project project = projectService.selectOneProjectInfoByWheresql(wheresql);
		//查询原来的代偿信息
		wheresql = " and replace_ID = \'"+pro_replace.getReplace_ID()+"\'";
		Pro_replace old_replace = pro_replaceMapper.selectOneReplaceInfo(wheresql);
		
		//修改一笔代偿表信息;
		pro_replace.setUpdateUserName(user.getUser_name());
		Integer returnInt = pro_replaceMapper.updateOneReplaceInfo(pro_replace);
		
		//更新 业务主表
		if(project != null){
			//更新在保余额   
			Double gGuarantySum=0d;
			gGuarantySum=project.getGuarantySum() ==null ? 0d :project.getGuarantySum();   //拿到之前的在保余额
//			Double fGuarantySum = gGuarantySum-(pro_replace.getReplaceCapitalSum()==null ?0d:pro_replace.getReplaceCapitalSum()) <0 ? 0d:gGuarantySum-(pro_replace.getReplaceCapitalSum()==null ?0d:pro_replace.getReplaceCapitalSum());
			Double fGuarantySum = gGuarantySum-(pro_replace.getReplaceCapitalSum()==null ?0d:pro_replace.getReplaceCapitalSum())+(old_replace.getReplaceCapitalSum()==null ?0d:old_replace.getReplaceCapitalSum());
			project.setGuarantySum(fGuarantySum);//设置新的在保余额
			
			// 更新逾期余额
			/*Double gOverplusSum = 0d;
	  			gOverplusSum = project.getOverplusSum() == null? 0d :project.getOverplusSum();
	  			project.setOverplusSum(gOverplusSum-(pro_replace.getReplaceCapitalSum()==null?0d:pro_replace.getReplaceCapitalSum()));
			 */
			//更新代偿总金额
			Double rReplaceFreeSum=0d;
			rReplaceFreeSum=project.getReplaceFreeSum()==null ?0d :project.getReplaceFreeSum(); //拿到之前代偿金额
			project.setReplaceFreeSum(rReplaceFreeSum+(pro_replace.getReplaceSum()==null?0d:pro_replace.getReplaceSum())-(old_replace.getReplaceSum()==null?0d:old_replace.getReplaceSum()));
			
			//更新代偿本金
			Double rReplaceCapitalSum=0d;
			rReplaceCapitalSum=project.getReplaceCapitalSum()==null ?0d :project.getReplaceCapitalSum();// 拿到之前的代偿本金
			project.setReplaceCapitalSum(rReplaceCapitalSum+(pro_replace.getReplaceCapitalSum()==null ?0d :pro_replace.getReplaceCapitalSum())-(old_replace.getReplaceCapitalSum()==null ?0d :old_replace.getReplaceCapitalSum()));
			
			
			//更新代偿利息
			Double rReplaceInterestSum=0d;
			rReplaceInterestSum=project.getReplaceInterestSum()==null ?0d :project.getReplaceInterestSum();
			project.setReplaceInterestSum(rReplaceInterestSum + (pro_replace.getReplaceInterestSum()==null ? 0d : pro_replace.getReplaceInterestSum())-(old_replace.getReplaceInterestSum()==null ? 0d : old_replace.getReplaceInterestSum()) );
			
			//更新代偿解除其它
			Double rReplaceOtherSum=0d;
			rReplaceOtherSum=project.getReplaceOtherSum()==null ?0d:project.getReplaceOtherSum();//拿到之前的代偿解除其它
			project.setReplaceOtherSum(rReplaceOtherSum+(pro_replace.getReplaceOtherSum()==null ?0d :pro_replace.getReplaceOtherSum())-(old_replace.getReplaceOtherSum()==null ?0d :old_replace.getReplaceOtherSum()));
			
			//更新自有资金代偿
			Double rSelfReplaceSum=0d;
			rSelfReplaceSum=project.getSelfReplaceSum()==null ?0d:project.getSelfReplaceSum(); //拿到之前的自有资金代偿
			project.setSelfReplaceSum(rSelfReplaceSum+(pro_replace.getSelfReplaceSum()==null ?0d : pro_replace.getSelfReplaceSum())-(old_replace.getSelfReplaceSum()==null ?0d : old_replace.getSelfReplaceSum()));
			
			//更新准备金冲抵
			Double dDangerReplaceSum=0d;
			dDangerReplaceSum=project.getDangerReplaceSum()==null ?0d:project.getDangerReplaceSum(); //拿到之前的准备金冲抵
			project.setDangerReplaceSum(dDangerReplaceSum+(pro_replace.getDangerReplaceSum()==null?0d:pro_replace.getDangerReplaceSum())-(old_replace.getDangerReplaceSum()==null?0d:old_replace.getDangerReplaceSum()));
			
			//更新代偿解除日期
			project.setReplaceDate(pro_replace.getReplaceDate());
			project.setUpdateUserName(user.getUser_name());
			returnInt2=pro_projectMapper.updateOneProjectInfo(project);
		}
		if(1==returnInt&&1==returnInt2){
			logService.insertOneOperatorLogInfo(user,"代偿登记", "更新", "更新一条项目代偿信息project_ID="+pro_replace.getProject_ID());
			logService.insertOneOperatorLogInfo(user,"代偿登记", "更新", "更新一条代偿表信息replace_ID="+pro_replace.getReplace_ID());
			b= true;
		}
		return b;
	}
	

	@Override
	public PageTable<Pro_replace> selectReplacePageTable(PageTable<Pro_replace> pageTable) {
		pageTable.setRows(pro_replaceMapper.selectReplacePageTable(pageTable));
		pageTable.setTotal(pro_replaceMapper.selectReplacePageTable_Count(pageTable));
		return pageTable;
	}


	/**
	 * 查询一个代偿信息
	 **/
	@Override
	public Pro_replace selectOneReplaceInfo(String wheresql) {
		Pro_replace replace = pro_replaceMapper.selectOneReplaceInfo(wheresql);
		return replace;
	}
	
	/**
	 * 分页查询代偿列表 —— 项目对应
	 */
	@Override
	public PageTable<Pro_replace> selectReplaceTable(PageTable<Pro_replace> pageTable) {
		
		List<Pro_replace> replaceList = null;
		try {
			replaceList = pro_replaceMapper.selectReplaceTable(pageTable);
			Long total = pro_replaceMapper.selectReplaceTable_Count(pageTable);
			pageTable.setRows(replaceList);
			pageTable.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pageTable;
	}



	@Override
	public Pro_replace showRepalceViewPage(String sqlWhere) {
		return pro_replaceMapper.showRepalceViewPage(sqlWhere);
	}



	/**
	 * 撤销一条代偿信息
	 */
	@Override
	public Boolean cancelReplaceDel(Pro_replace replace) {
		replace = showRepalceViewPage(" and replace_ID='"+replace.getReplace_ID()+"'");
		Pro_project  project= new Pro_project();
		project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+replace.getProject_ID()+"\'");
		
		updateProJect(replace, project);
		
		Integer count = 0;
		Boolean isTrue = false;
		try {
			count = pro_replaceMapper.cancelReplaceDel(replace);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(count>0){
			logService.insertOneOperatorLogInfo(SystemSession.getUserSession(),"撤销代偿", "撤销", "撤销一条代偿信息");
			isTrue = true;
		}
		
		return isTrue;
	}
	
	//修改pro_project表
	private void updateProJect(Pro_replace replace, Pro_project project) {

		Pro_project project1 = new Pro_project();

		Double guarantySum = project.getGuarantySum();// 在保余额
		Double guarantyDutyResSum = project.getGuarantyDutyResSum();// 担保责任余金额
		Double guarantyScale = project.getGuarantyScale();//担保责任比例

		Double	replaceFreeSum = project.getReplaceFreeSum();        //	代偿总金额   
		Double	replaceCapitalSum = project.getReplaceCapitalSum();  //分类1其中：代偿本金  
		Double	replaceInterestSum = project.getReplaceInterestSum();//分类1其中：代偿利息  
		Double	replaceOtherSum = project.getReplaceOtherSum();      //分类1其中：代偿其它  
		Double	selfReplaceSum = project.getSelfReplaceSum();        //分类2其中：自有资金代偿
		Double	dangerReplaceSum = project.getDangerReplaceSum();    //分类2其中：准备金冲抵 
		
		Double	replaceFreeSum1 = replace.getReplaceSum();        //	代偿总金额   
		Double	replaceCapitalSum1 = replace.getReplaceCapitalSum();  //分类1其中：代偿本金  
		Double	replaceInterestSum1 = replace.getReplaceInterestSum();//分类1其中：代偿利息  
		Double	replaceOtherSum1 = replace.getReplaceOtherSum();      //分类1其中：代偿其它  
		Double	selfReplaceSum1 = replace.getSelfReplaceSum();        //分类2其中：自有资金代偿
		Double	dangerReplaceSum1 = replace.getDangerReplaceSum();    //分类2其中：准备金冲抵 
		project1.setProject_ID(replace.getProject_ID());
		try {
			project1.setReplaceFreeSum(bigDecimal.sub(replaceFreeSum, replaceFreeSum1));
			project1.setReplaceCapitalSum(bigDecimal.sub(replaceCapitalSum, replaceCapitalSum1));
			project1.setReplaceInterestSum(bigDecimal.sub(replaceInterestSum, replaceInterestSum1));
			project1.setReplaceOtherSum(bigDecimal.sub(replaceOtherSum, replaceOtherSum1));
			project1.setSelfReplaceSum(bigDecimal.sub(selfReplaceSum, selfReplaceSum1));
			project1.setDangerReplaceSum(bigDecimal.sub(dangerReplaceSum, dangerReplaceSum1));

			//project1.setGuarantySum(bigDecimal.add(guarantySum, replaceCapitalSum1));
			project1.setGuarantyDutyResSum(bigDecimal.add(guarantyDutyResSum, replaceCapitalSum1));
			
			Double replaceCapitalSum2 = 0D;
			if(guarantyScale != null && guarantyScale != 0){
				replaceCapitalSum2 = bigDecimal.mul(replaceCapitalSum1, 100D)/guarantyScale;
			}
			project1.setGuarantySum(bigDecimal.add(guarantySum, replaceCapitalSum2));
			
			// 更新项目表
			pro_projectMapper.updateDutyRemove(project1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//部分代偿
	@Override
	public Boolean addOneReplace(Pro_replace replace) {
		replace.setReplace_ID(Tool.createUUID32());
		Pro_project project = new Pro_project();
		project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'" + replace.getProject_ID() + "\'");

		updateProJectAdd(replace, project);

		Integer count = 0;
		Boolean isTrue = false;
		User user = SystemSession.getUserSession();
		replace.setUnit_uid(user.getUnit_uid());
		replace.setUpdateUserName(user.getUser_name());
		replace.setRepalceState("通过");
		try {
			count = pro_replaceMapper.insertOneReplaceInfo(replace);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count > 0) {
			logService.insertOneOperatorLogInfo(SystemSession.getUserSession(), "部分代偿", "添加", "添加一条代偿信息");
			isTrue = true;
		}

		return isTrue;
	}
	
	//修改pro_project表
	private void updateProJectAdd(Pro_replace replace, Pro_project project) {

		Pro_project project1 = new Pro_project();

		Double guarantySum = project.getGuarantySum();// 在保余额
		Double guarantyDutyResSum = project.getGuarantyDutyResSum();// 担保责任余金额
		Double guarantyScale = project.getGuarantyScale();//担保责任比例

		Double	replaceFreeSum = project.getReplaceFreeSum();        //	代偿总金额   
		Double	replaceCapitalSum = project.getReplaceCapitalSum();  //分类1其中：代偿本金  
		Double	replaceInterestSum = project.getReplaceInterestSum();//分类1其中：代偿利息  
		Double	replaceOtherSum = project.getReplaceOtherSum();      //分类1其中：代偿其它  
		Double	selfReplaceSum = project.getSelfReplaceSum();        //分类2其中：自有资金代偿
		Double	dangerReplaceSum = project.getDangerReplaceSum();    //分类2其中：准备金冲抵

		Double	replaceFreeSum1 = replace.getReplaceSum();        //	代偿总金额   
		Double	replaceCapitalSum1 = replace.getReplaceCapitalSum();  //分类1其中：代偿本金  
		Double	replaceInterestSum1 = replace.getReplaceInterestSum();//分类1其中：代偿利息  
		Double	replaceOtherSum1 = replace.getReplaceOtherSum();      //分类1其中：代偿其它  
		Double	selfReplaceSum1 = replace.getSelfReplaceSum();        //分类2其中：自有资金代偿
		Double	dangerReplaceSum1 = replace.getDangerReplaceSum();    //分类2其中：准备金冲抵
		project1.setProject_ID(replace.getProject_ID());
		try {
			project1.setReplaceFreeSum(bigDecimal.add(replaceFreeSum, replaceFreeSum1));
			project1.setReplaceCapitalSum(bigDecimal.add(replaceCapitalSum, replaceCapitalSum1));
			project1.setReplaceInterestSum(bigDecimal.add(replaceInterestSum, replaceInterestSum1));
			project1.setReplaceOtherSum(bigDecimal.add(replaceOtherSum, replaceOtherSum1));
			project1.setSelfReplaceSum(bigDecimal.add(selfReplaceSum, selfReplaceSum1));
			project1.setDangerReplaceSum(bigDecimal.add(dangerReplaceSum, dangerReplaceSum1));

			//project1.setGuarantySum(bigDecimal.sub(guarantySum, replaceCapitalSum1));
			project1.setGuarantyDutyResSum(bigDecimal.sub(guarantyDutyResSum, replaceCapitalSum1));
			
			Double replaceCapitalSum2 = 0D;
			if(guarantyScale != null && guarantyScale != 0){
				replaceCapitalSum2 = bigDecimal.mul(replaceCapitalSum1, 100D)/guarantyScale;
			}
			project1.setGuarantySum(bigDecimal.sub(guarantySum, replaceCapitalSum2));
			// 更新项目表
			pro_projectMapper.updateDutyRemove(project1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询一个代偿信息
	 
	@Override
	public Pro_replace selectOneReplaceInfo(String wheresql) {
		Pro_replace replace = pro_replaceMapper.selectOneReplaceInfo(wheresql);
		return replace;
	}*/


	//查询正常解除申请信息
	@Override
	public List<Pro_replace> selectReplaceList(String condition) {
		List<Pro_replace> replaceList = null;
		try {
			replaceList = pro_replaceMapper.selectReplaceList(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return replaceList;
	}
	//代偿解除申请
	public Boolean insertOneReplaceWHDB(User user, Pro_replace pro_replace) {
		Integer returnInt2=0;
		Boolean b = false;
		//根据业务id获取业务表信息;
		String wheresql = " and project_ID = \'"+pro_replace.getProject_ID()+"\'";
	    Pro_project project = projectService.selectOneProjectInfoByWheresql(wheresql);
	    //新增一笔代偿表信息;
	    pro_replace.setRepalceState("审批中");
	    pro_replace.setApply_ID(project.getApply_ID());
	    pro_replace.setUnit_uid(user.getUnit_uid());
	    pro_replace.setUpdateUserName(user.getUser_name());
	    Integer returnInt = pro_replaceMapper.insertOneReplaceInfo(pro_replace);
	    
	    //更新 业务主表
  		if(project != null){
  			//更新在保余额   
  			Double gGuarantySum=0d;
  			gGuarantySum=project.getGuarantySum() ==null ? 0d :project.getGuarantySum();   //拿到之前的在保余额
  			Double fGuarantySum = gGuarantySum-(pro_replace.getReplaceSum()==null ?0d:pro_replace.getReplaceSum()) <0 ? 0d:gGuarantySum-(pro_replace.getReplaceSum()==null ?0d:pro_replace.getReplaceSum());
  			project.setGuarantySum(fGuarantySum);//设置新的在保余额
  			
  			//更新代偿利息
  			Double rReplaceInterestSum=0d;
  			rReplaceInterestSum=project.getReplaceInterestSum()==null ?0d :project.getReplaceInterestSum();
  			project.setReplaceInterestSum(rReplaceInterestSum + (pro_replace.getReplaceInterestSum()==null ? 0d : pro_replace.getReplaceInterestSum() ) );
  			
  			//担保责任比例
  			Double guarantyScale = project.getGuarantyScale()==null ?0d : project.getGuarantyScale();
  			Double guarantyDutyResSum = (fGuarantySum*guarantyScale)/100;
  			project.setGuarantyDutyResSum(guarantyDutyResSum);
  			
  			//更新代偿解除日期
  			project.setReplaceDate(pro_replace.getReplaceDate());
  			project.setUpdateUserName(user.getUser_name());
  			returnInt2=pro_projectMapper.updateOneProjectInfo(project);
  		}
  		if(1==returnInt&&1==returnInt2){
			logService.insertOneOperatorLogInfo(user,"代偿登记", "更新", "更新一条项目代偿信息project_ID="+pro_replace.getProject_ID());
			logService.insertOneOperatorLogInfo(user,"代偿登记", "新增", "新增一条代偿表信息replace_ID="+pro_replace.getReplace_ID());
			b= true;
		}
		return b;
}



	@Override
	public Object deleteOneReplace(User user, Pro_replace replace) {
		
		replace = pro_replaceMapper.showRepalceViewPage(" and pro_replace.replace_ID='"+replace.getReplace_ID()+"' ");
		Integer returnInt2=0;
		Boolean b = false;
		//根据业务id获取业务表信息;
		String wheresql = " and project_ID = \'"+replace.getProject_ID()+"\'";
	    Pro_project project = projectService.selectOneProjectInfoByWheresql(wheresql);
	    //新增一笔代偿表信息;
	    Integer returnInt = 0;
	    
	    //更新 业务主表
  		if(project != null){
  			//删除附件表pro_projectfiles对应的信息
			projectfilesMapper.deleteOneProFilesByEntityID(" and entityID='"+replace.getReplace_ID()+"'");
  			//更新在保余额   
  			Double gGuarantySum=0d;
  			gGuarantySum=project.getGuarantySum() ==null ? 0d :project.getGuarantySum();   //拿到之前的在保余额
  			Double fGuarantySum = gGuarantySum+(replace.getReplaceSum()==null ?0d:replace.getReplaceSum()) <0 ? 0d : gGuarantySum+(replace.getReplaceSum()==null ?0d : replace.getReplaceSum());
  			project.setGuarantySum(fGuarantySum);//设置新的在保余额
  			
  			//更新代偿利息
  			Double rReplaceInterestSum=0d;
  			rReplaceInterestSum=project.getReplaceInterestSum()==null ?0d :project.getReplaceInterestSum();
  			project.setReplaceInterestSum(rReplaceInterestSum - (replace.getReplaceInterestSum()==null ? 0d : replace.getReplaceInterestSum() ) );
  			
  			//担保责任比例
  			Double guarantyScale = project.getGuarantyScale()==null ?0d : project.getGuarantyScale();
  			Double guarantyDutyResSum = (fGuarantySum*guarantyScale)/100;
  			project.setGuarantyDutyResSum(guarantyDutyResSum);
  			
  			//更新代偿解除日期
  			project.setReplaceDate(replace.getReplaceDate());
  			project.setUpdateUserName(user.getUser_name());
  			returnInt2=pro_projectMapper.updateOneProjectInfo(project);
  			
  			returnInt = pro_replaceMapper.cancelReplaceDel(replace);
  		}
  		if(1==returnInt&&1==returnInt2){
			logService.insertOneOperatorLogInfo(user,"代偿登记", "撤销", "撤销一条项目代偿信息project_ID="+replace.getProject_ID());
			logService.insertOneOperatorLogInfo(user,"代偿登记", "新增", "新增一条代偿表信息replace_ID="+replace.getReplace_ID());
			b= true;
		}
		return b;
	}
}
