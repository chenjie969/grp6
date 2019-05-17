package com.zjm.pro.apply.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.model.Client;
import com.zjm.gbpm.db.model.Gbpm_productInstance;
import com.zjm.gbpm.productInstance.service.ProductInstanceService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.applyDetail.service.ApplyDetailService;
import com.zjm.pro.db.map.Pro_applyDetailMapper;
import com.zjm.pro.db.map.Pro_applyMapper;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_applyDetail;
import com.zjm.pro.db.model.Pro_meetingDetail;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.db.model.Pro_projectCode;
import com.zjm.pro.db.model.Pro_suggest;
import com.zjm.pro.meetDetail.service.MeetingDetailService;
import com.zjm.pro.meetResolution.service.MeetingResolutionService;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.pro.projectCode.service.ProjectCodeService;
import com.zjm.pro.suggest.service.ProjectSuggestService;
import com.zjm.util.SystemSession;

@Service("projectApplyService")
@Transactional
public class ProjectApplyServiceImpl implements ProjectApplyService {
    
	//申请表mapper
	@Resource
	private Pro_applyMapper pro_applyMapper;
	
	
	//产品实例service	
	@Resource
	private ProductInstanceService productInstanceService;
	//客户service	
	@Resource
	private ClientService clientService;
	
	@Resource
	private Pro_applyDetailMapper pro_applyDetailMapper;
	
	//申请明细service;
	@Resource
	private ApplyDetailService applyDetailService;
	
	@Resource
	private ProjectCodeService projectCodeService;
	
	@Resource
	private LogService logService;
	@Resource
	private ProjectService projectService;
	@Resource
	private ProjectSuggestService projectSuggestService;

	@Resource
	private MeetingResolutionService meetingResolutionService;
	@Resource
	private MeetingDetailService meetingDetailService;
	
	@Override
	public PageTable selectApplyPageTables(PageTable pageTable) {
		List<Pro_apply> applyList = null;
		try {
			applyList = pro_applyMapper.selectApplyPageTables(pageTable);
			Long total = pro_applyMapper.selectApplyPageTables_Count(pageTable);
			pageTable.setRows(applyList);
			pageTable.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}

	public Boolean insertOneApplyInfo(User user, Pro_apply apply) {
		try {
			//设置编号
			Pro_projectCode projectCode = new Pro_projectCode();
			projectCode=projectCodeService.returnOneProjectCode(user, "apply");
			//格式化客户编号之后再设置
			String projectBH = projectCode.getYears() + projectCodeFormat(projectCode.getApplyCode());
			apply.setBusiCode(projectBH);
			apply.setIsMeeting(1);		//设置默认为上会项目   2017/10/26 xuyz
			apply.setUpdateUserName(user.getUser_name());//设置更新人名称;
			apply.setUnit_uid(user.getUnit_uid());//设置担保机构id
			apply.setUnit_uidName(user.getUnit_uidName());//设置担保机构名称;			
			if(pro_applyMapper.insertOneApplyInfo(apply) == 1){
			  logService.insertOneOperatorLogInfo(user,"申请登记", "新增", "业务申请信息表信息");
			  return true;
		    }
		}catch (Exception e) {
			 e.printStackTrace();
		}
		return false;
		
	}

	public Pro_apply selectOneApplyByWhereSql(String wheresql) {
		Pro_apply apply = new Pro_apply();
		try {
			apply = pro_applyMapper.selectOneApplyWhereSql(wheresql);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return apply;
	}
	
	public List<Pro_apply> selectApplyListByPackageID(String wheresql) {
		List<Pro_apply> applyList = new ArrayList<>();
		try {
			 applyList = pro_applyMapper.selectApplyListByWhereSql(wheresql);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return applyList;
	}
	/**
	 * 修改
	 */
	public Boolean updateOneApplyInfo(User user, Pro_apply apply) {
		try{
			if(null != apply){
				String wheresql = " and apply_ID =\'"+apply.getApply_ID()+"\'";			
				 Pro_apply oldApply = pro_applyMapper.selectOneApplyWhereSql(wheresql);
				 if(apply.getDepartID() != null ){
					 oldApply.setDepartID(apply.getDepartID());//更新部门ID
				 }
				 if(apply.getDepartName() != null){
					 oldApply.setDepartName(apply.getDepartName());//更新部门名称 
				 }
				 if(user.getUser_name() != null ){
					 oldApply.setUpdateUserName(user.getUser_name());//更新最后修改人;
				 }
				 if (apply.getCreateManID() != null) {
					 oldApply.setCreateManID(apply.getCreateManID());//更新创建人ID
					
				 }
				 if(apply.getAmanID() != null){
					 oldApply.setAmanID(apply.getAmanID());//更新A角ID
				 }
				 if(apply.getAmanName() != null){
					 oldApply.setAmanName(apply.getAmanName());//更新A角name
				 }
				 if(apply.getBmanID() != null){
					 oldApply.setBmanID(apply.getBmanID());//更新B角ID
				 }
				 if(apply.getBmanName() != null){
					 oldApply.setBmanName(apply.getBmanName());//更新B角name
				 }
				 if (apply.getCreateManName() != null) {
					 oldApply.setCreateManName(apply.getCreateManName());//更新创建人
					
				 }
				 if (apply.getBankNameList() != null) {
					 oldApply.setBankNameList(apply.getBankNameList());//更新合作机构名称集合
				 }
				 if (apply.getBusiTypeNameList() != null) {
					 oldApply.setBusiTypeNameList(apply.getBusiTypeNameList());//更新业务品种名称集合
				 }
				 if (apply.getApplySum() != null) {
					 oldApply.setApplySum(apply.getApplySum());//更新申请总金额
				 }
				 if (apply.getIsPutPackage() != null) {
					oldApply.setIsPutPackage(apply.getIsPutPackage());
				 }
				 if(apply.getProjectStageID() != null ){//业务阶段ID	
					 oldApply.setProjectStageID(apply.getProjectStageID());
				 }
				 if(apply.getProjectStageName() != null ){//业务阶段名称
					 oldApply.setProjectStageName(apply.getProjectStageName());
				 }
				 if(apply.getProjectSourceID() != null ){//项目来源id
					 oldApply.setProjectSourceID(apply.getProjectSourceID());
				 }
				 if(apply.getProjectSourceName() != null ){//项目来源name
					 oldApply.setProjectSourceName(apply.getProjectSourceName());
				 }
				 if(apply.getSourceDesc() != null ){//来源说明
					 oldApply.setSourceDesc(apply.getSourceDesc());
				 }
				 if(apply.getProductInstance_ID() != null ){//流程实例ID
					 oldApply.setProductInstance_ID(apply.getProductInstance_ID());
				 }
				 if(apply.getProjectName() != null ){//项目名称
					 oldApply.setProjectName(apply.getProjectName());
				 }
				 if(apply.getClient_ID() != null ){//客户id
					 oldApply.setClient_ID(apply.getClient_ID());
				 }
				 if(apply.getClientName() != null ){//客户名称
					 oldApply.setClientName(apply.getClientName());
				 }
				 if(apply.getRelationName() != null ){//主体名称
					 oldApply.setRelationName(apply.getRelationName());
				 }
				 if(apply.getCreateDate() != null){//更新登记时间
					 oldApply.setCreateDate(apply.getCreateDate());
				 }
				 if(apply.getProjectJudge() != null ){//项目评价
					 oldApply.setProjectJudge(apply.getProjectJudge());
					 Date date=new Date();
					 DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					 String time=format.format(date);
					 oldApply.setJudgeDateTime(time);
					 oldApply.setJudgeManID(SystemSession.getUserSession().getUser_uid());
					 oldApply.setJudgeManName(SystemSession.getUserSession().getUser_name());
					 
				 }
				 
				 if(apply.getStopTypeID() != null ){//否决类型,否决类型名称
					 oldApply.setStopTypeID(apply.getStopTypeID()); 
					 oldApply.setStopTypeName(apply.getStopTypeName()); 
					 oldApply.setStopDesc(apply.getStopDesc());
					 oldApply.setStopDate(apply.getStopDate());
					 oldApply.setIsStop(1);
				 }
				 if(null !=apply.getBusiNatureID()){
					 oldApply.setBusiNatureID(apply.getBusiNatureID());//业务性质id
				 }
				 if(null != apply.getBusiNatureName()){//业务性质name
					 oldApply.setBusiNatureName(apply.getBusiNatureName());
				 }
				 Integer returnResult = pro_applyMapper.updateOneApplyInfo(oldApply);
				 if(1==returnResult){
					  logService.insertOneOperatorLogInfo(user,"申请登记", "修改", "业务申请信息表信息");
					  return true;
				 }
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 更新项目结案评价
	 * 
	 */
	
	public Boolean updateApplySetProjectJudge(User user,Map<String,Object>  param){
		
		String apply_ID =(String) param.get("apply_ID");
		String projectJudge = (String) param.get("projectJudge");
		Pro_apply apply = new Pro_apply();
		apply.setProjectJudge(projectJudge);
		apply.setApply_ID(apply_ID);
		Integer returnInt = 0;
		try {
	       returnInt  = pro_applyMapper.updateApplySetProjectJudge(apply);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(returnInt>0){
			logService.insertOneOperatorLogInfo(user, "申请登记", "修改", "业务申请信息");
			return true;
		} else{
		return false;
		}
		
	}
	/**
	 * 根据wheresql删除一个业务申请信息表信息
	 * @param wheresql :apply_ID
	 * @return
	 */
	public Boolean delectApplyByWhereSql(User user, Pro_apply apply) {	
		String wheresql = "";
		try{
			wheresql=" and apply_ID = '"+apply.getApply_ID()+"'".trim();
			try {
				deleteProjectRelationInfo(user,apply);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//根据apply_ID 删除多条申请明细表信息;
			Boolean returnResult1 =  applyDetailService.deleteApplyDetailByWhereSql(user, wheresql);//删除
			
			//根据apply_ID删除一条申请表信息;
			Integer returnResult = pro_applyMapper.delectApplyByWhereSql(wheresql);
			
			
			
			if(returnResult== 1 && returnResult1){
				logService.insertOneOperatorLogInfo(user,"申请登记", "删除", "删除一条申请表信息");
				return true;
			}			
		}catch(Exception e){
			e.printStackTrace();			
		}
		return  false;	
		
	}
	/**
	 * 删除与项目申请相关信息
	 * @param user
	 * @param apply
	 */
	public  void deleteProjectRelationInfo(User user,Pro_apply apply){
		
		String applyIDSql=" and apply_ID = '"+apply.getApply_ID()+"'";
		String entityIDSql=" and entityID = '"+apply.getApply_ID()+"'";
		//根据申请id 获取流程示例对象---start;
		
		Gbpm_productInstance productInstance = productInstanceService.selectOneProductInstanceByWhereSql(entityIDSql);
		if(null != productInstance){
			Boolean returnBool1= productInstanceService.delProductInstanceInfo(user, productInstance);
		}
		//根据申请id 获取流程示例对象---end;
		//根据申请id删除客户信息--start;
		Pro_apply pro_apply = pro_applyMapper.selectOneApplyWhereSql(applyIDSql);
		if(null != pro_apply){
			Client client = new Client();
			client.setClient_ID(pro_apply.getClient_ID());
			Boolean returnBool2 = clientService.deleteOneCompanyClientInfo(user, client);
		}
		//根据申请id删除保后产品信息表信息--end;
		List<Pro_project> projectList = projectService.selectProjectListByWheresql(applyIDSql);
		if(null != projectList){
			for (Pro_project pro_project : projectList) {
				Boolean returnBool3 = projectService.deleteOneProjectAfter(user, pro_project);
			}
		}
		//根据申请id删除保后产品信息表信息--end;
		
		//根据申请id删除项目意见表信息--start;
		List<Pro_suggest> suggestList = projectSuggestService.selectSuggestListByWhereSql(entityIDSql);
		if(null != suggestList){
			for (Pro_suggest pro_suggest : suggestList) {
				Boolean returnBool4 = projectSuggestService.deleteOneSuggestInfo(user, pro_suggest);
			}
		}
		//根据申请id删除项目意见表信息--end;
		//根据申请id删除评审会产品明细表信息--start;
		List<Pro_meetingDetail> meetingDetailList = meetingDetailService.selectMeetingDetailListByWhereSql(applyIDSql);
	    for (Pro_meetingDetail pro_meetingDetail : meetingDetailList) {
	    	meetingDetailService.deleteOnemeetingDetail(user, pro_meetingDetail.getMeetingDetail_ID());
		}
	    //根据申请id删除评审会产品明细表信息---end;
	    //根据申请id删除评审会决议表信息---start;
	      meetingResolutionService.delMeetingResolutionBySql(user, applyIDSql);
	    //根据申请id删除评审会决议表信息---end;
	     
	 
	}
	
	
	
	
	
	//编号位数生成
	private String projectCodeFormat(Integer number) {
		String projectcodes="" + number;
		for(int i=0;projectcodes.length()<4;i++){
			projectcodes="0"+projectcodes;
		}
		return projectcodes;
	}
	//上会审批--根据ID修改isArrangeMeeting
	@Override
	public int updateIsArrangeMeetingById(PageTable<Pro_apply> pageTable) {
		return pro_applyMapper.updateIsArrangeMeetingById(pageTable);
	}
	@Override
	public int updateIsArrangeMeetById(Pro_apply apply) {
		return pro_applyMapper.updateIsArrangeMeetById(apply);
	}
	// 上会审批--根据ID修改isArrangeMeeting
	@Override
	public int updateIsArrangeMeetingByIds(PageTable<Pro_apply> pageTable) {
		return pro_applyMapper.updateIsArrangeMeetingByIds(pageTable);
	}
	
	
	/**
	 * 申请上会处理: 设置pro_apply的上会状态, 批量操作
	 * @author xuyz
	 */
	@Override
	public Boolean setMeetingStatusArranging(Pro_apply proApply, String meetingStatus){
		try {
			String[] meetingApplyIDArr = proApply.getMeetingApplyIDs().split(",");
			proApply.setMeetingApplyIDArr(meetingApplyIDArr);
			proApply.setMeetingStatus(meetingStatus);
			Integer resultNum = pro_applyMapper.updateApplyMeetingStatus(proApply);
			if(meetingApplyIDArr.length==resultNum){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
 
	/**
	 *	指定项目AB角 
	 */
	@Override
	public Boolean updateApplySetABMan(Pro_apply  apply){
		try {
			apply.setBeforeAManID(apply.getAmanID());
			apply.setBeforeBManID(apply.getBmanID());
			Integer applyFlag = pro_applyMapper.updateApplySetABMan(apply);
			Pro_applyDetail applyDetail = new Pro_applyDetail();
			applyDetail.setApply_ID(apply.getApply_ID());
			applyDetail.setAmanID(apply.getAmanID());
			applyDetail.setAmanName(apply.getAmanName());
			applyDetail.setBmanID(apply.getBmanID());
			applyDetail.setBmanName(apply.getBmanName());
			applyDetail.setBeforeAManID(apply.getAmanID());
			applyDetail.setBeforeBManID(apply.getBmanID());
			Integer applyDetailFlag = pro_applyDetailMapper.updateApplySetABMan(applyDetail);
			if(applyFlag==1 && applyDetailFlag > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 *	指定项目风控复核人
	 */
	@Override
	public Boolean updateApplySetReviewMan(Pro_apply  apply){
		try {
			apply.setBeforeReviewManID(apply.getReviewManID());
			Integer applyFlag = pro_applyMapper.updateApplySetReviewMan(apply);
			Pro_applyDetail applyDetail = new Pro_applyDetail();
			applyDetail.setApply_ID(apply.getApply_ID());
			applyDetail.setReviewManID(apply.getReviewManID());
			applyDetail.setReviewManName(apply.getReviewManName());
			applyDetail.setBeforeReviewManID(apply.getBeforeReviewManID());
			Integer applyDetailFlag = pro_applyDetailMapper.updateApplySetReviewMan(applyDetail);
			if(applyFlag==1 && applyDetailFlag > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean updateApplyYesPackage(String str) {
		return pro_applyMapper.updateApplyYesPackage(str)>0;
	}


	public Boolean updateOneApplyByApply_ID(User userSession, Pro_project pro_project) {
		Pro_apply	 apply = new Pro_apply();
		Boolean b = false;
		Integer returnInt = 0;
		if(null != pro_project){
			     apply= pro_applyMapper.selectOneApplyWhereSql(" and apply_ID = \'"+pro_project.getApply_ID()+"\'");
				 apply.setHostAreaID(pro_project.getHostAreaID());
				 apply.setHostAreaName(pro_project.getHostAreaName());//承办地
				 apply.setGuarantyOrgID(pro_project.getGuarantyOrgID());
				 apply.setGuarantyOrgName(pro_project.getGuarantyOrgName());//承办机构
				 apply.setAttributionID(pro_project.getAttributionID());
				 apply.setAttributionName(pro_project.getAttributionName());//属地划分
				 apply.setOprationCompanyID(pro_project.getOprationCompanyID());
				 apply.setOprationCompanyName(pro_project.getOprationCompanyName());//经办公司
				 apply.setAmanID(pro_project.getAmanID());//A角
				 apply.setAmanName(pro_project.getAmanName());
				 apply.setBmanID(pro_project.getBmanID());
				 apply.setBmanName(pro_project.getBmanName());//B角
				 apply.setBusiTypeNameList(pro_project.getBusiTypeName());//业务品种
				 apply.setBankNameList(pro_project.getBankName());//合作机构
				 apply.setBeforeAManID(pro_project.getAmanID());
				 apply.setBeforeBManID(pro_project.getBmanID());
				 apply.setFundName(pro_project.getFundName());//资金方名称
				 apply.setFundType(pro_project.getFundType());
				 apply.setFundTypeID(pro_project.getFundTypeID());
				 apply.setFundID(pro_project.getFundID());//资金方id
				 apply.setFundChinese(pro_project.getFundChinese());//资金方
				 apply.setApplySum(pro_project.getLoadSum());
				 apply.setAgreeSum(pro_project.getLoadSum());//设置同意金额;
				 apply.setProjectName(pro_project.getProjectName());
				  returnInt = pro_applyMapper.updateOneApplyInfo(apply);
			}
			if(returnInt>0){
			    logService.insertOneOperatorLogInfo(userSession,"保后(贷)跟踪", "修改", "修改业务申请信息apply_ID="+pro_project.getApply_ID());
				b = true;
			}
			return b;
	}

	/**
	 * 首页获取项目进度列表
	 * @return
	 */
	@Override
	public List<Pro_apply> selectProjectStageList() {
		return pro_applyMapper.selectProjectStageList();
	}

	@Override
	public PageTable<Pro_apply> selectRiskApplyPageTables(PageTable<Pro_apply> pageTable) {
		List<Pro_apply> applyList = null;
		try {
			applyList = pro_applyMapper.selectRiskApplyPageTables(pageTable);
			Long total = pro_applyMapper.selectRiskApplyPageTables_Count(pageTable);
			pageTable.setRows(applyList);
			pageTable.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}

	@Override
	public Boolean updateApplySetLegalMan(Pro_apply apply) {
//		try {
//			apply.setBeforeLegalManID(apply.getLegalManID());
//			Integer applyFlag = pro_applyMapper.updateApplySetLegalMan(apply);
//			Pro_applyDetail applyDetail = new Pro_applyDetail();
//			applyDetail.setApply_ID(apply.getApply_ID());
//			applyDetail.setLegalManID(apply.getLegalManID());
//			applyDetail.setLegalManName(apply.getLegalManName());
//			applyDetail.setBeforeLegalManID(apply.getBeforeLegalManID());
//			Integer applyDetailFlag = pro_applyDetailMapper.updateApplySetLegalMan(applyDetail);
//			if(applyFlag==1 && applyDetailFlag > 0){
//				return true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return false;
	}

}
