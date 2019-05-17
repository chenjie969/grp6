package com.zjm.pro.loan.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.gworkFlow.db.model.OsGworkflowFlowtemplate;
import com.zjm.gworkFlow.startWorkFlow.service.GworkFlowService;
import com.zjm.pro.applyDetail.service.ApplyDetailService;
import com.zjm.pro.db.map.Pro_applyDetailMapper;
import com.zjm.pro.db.map.Pro_applyMapper;
import com.zjm.pro.db.map.Pro_checkPlanMapper;
import com.zjm.pro.db.map.Pro_loanPlanMapper;
import com.zjm.pro.db.map.Pro_meetingDetailMapper;
import com.zjm.pro.db.map.Pro_meetingResolutionMapper;
import com.zjm.pro.db.map.Pro_projectMapper;
import com.zjm.pro.db.map.Pro_projectfilesMapper;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_applyDetail;
import com.zjm.pro.db.model.Pro_checkPlan;
import com.zjm.pro.db.model.Pro_loanPlan;
import com.zjm.pro.db.model.Pro_meetingDetail;
import com.zjm.pro.db.model.Pro_meetingResolution;
import com.zjm.pro.db.model.Pro_planPay;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.db.model.Pro_projectfiles;
import com.zjm.pro.loan.service.LoanService;
import com.zjm.pro.meetDetail.service.MeetingDetailService;
import com.zjm.pro.planPay.service.PlanPayService;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

@Service("loanService")
@Transactional
public class LoanServiceImpl implements LoanService{

	@Resource
	private Pro_loanPlanMapper pro_loanPlanMapper;
	@Resource
	private ApplyDetailService applyDetailService;
	@Resource
	private Pro_projectfilesMapper projectfilesMapper;
	@Resource
	private MeetingDetailService meetingDetailService;
	@Resource
	private Pro_projectMapper projectMapper;
	@Resource
	private Pro_applyMapper applyMapper;
	@Resource
	private Pro_applyDetailMapper applyDetailMapper;
	@Resource
	private LogService logService;
	@Resource
	private PlanPayService planPayService;
	@Resource
	private Pro_meetingResolutionMapper meetingResolutionMapper;
	@Resource
	private Pro_meetingDetailMapper meetingDetailMapper;
	@Resource
	private Pro_checkPlanMapper checkPlanMapper;
	@Resource
	private GworkFlowService gworkFlowService;
	
	@Override
	public Boolean insertOnePlanLoan(User user,Pro_loanPlan loanPlan){
		try {
/*			Pro_applyDetail applyDetail = applyDetailService.selectApplyDetailList(" and applyDetail_ID='"+loanPlan.getApplyDetailID()+"'").get(0);
			loanPlan.setBankID(applyDetail.getBankID());
			loanPlan.setBankName(applyDetail.getBankName());
			loanPlan.setSubBankName(applyDetail.getSubBankName());
			loanPlan.setBankTypeID(applyDetail.getBankTypeID());
			loanPlan.setBankTypeName(applyDetail.getBankTypeName());
			loanPlan.setBusiTypeID(applyDetail.getBusiTypeID());
			loanPlan.setBusiTypeName(applyDetail.getBusiTypeName());*/
			loanPlan.setLoanPlan_ID(Tool.createUUID32());
			loanPlan.setPeriodMonthDay(concatMonthDay(loanPlan));
			loanPlan.setLoanState("未放款");
			loanPlan.setUnit_uid(user.getUnit_uid());
			loanPlan.setUnit_uidName(user.getUnit_uidName());
			loanPlan.setUpdateUserName(user.getUser_name());
			if(1==pro_loanPlanMapper.insertOnePlanLoan(loanPlan)){
				logService.insertOneOperatorLogInfo(user, "放款计划", "新增", "新增一条放款计划, ID="+loanPlan.getLoanPlan_ID());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 拼接申请期限字符串
	 */
	private String concatMonthDay(Pro_loanPlan loanPlan){
		Integer month = loanPlan.getPeriodMonth();
		Integer day = loanPlan.getPeriodDay();
		StringBuffer periodMonthDay = new StringBuffer();
		if( month!=null && !month.equals(0)){
			periodMonthDay.append(month+"个月");
			if(day!=null && day!=0){
				periodMonthDay.append(day+"天");
			}
		}else if(day!=null && day!=0){
			periodMonthDay.append(day+"天");
		}/*else{	//申请期限改为非必填项后注释此段代码
			periodMonthDay.append("0天");
		}*/
		return periodMonthDay.toString();
	}
	
	@Override
	public PageTable<Pro_loanPlan> selectPlanLoanPageTable(PageTable<Pro_loanPlan> pageTable) {
		try {
			List<Pro_loanPlan> loanPlanList = pro_loanPlanMapper.selectPlanLoanListByWhereSql(" and applyID='"+pageTable.getQueryCondition().getApply_ID()+"'");
			pageTable.setRows(loanPlanList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}

	@Override
	public Pro_loanPlan selectOneLoanPlan(String wheresql) {
		try {
			Pro_loanPlan loanPlan = pro_loanPlanMapper.selectOneLoanPlan(wheresql);
			return loanPlan;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 修改放款计划, 要删除其下的还款计划和应收费用
	 */
	@Override
	public Boolean updateOnePlanLoan(User user, Pro_loanPlan loanPlan) {
		try {
			planPayService.deletePlanPayByWheresql(" and loanPlan_ID='"+loanPlan.getLoanPlan_ID()+"'");
			loanPlan.setUpdateUserName(user.getUser_name());
			loanPlan.setPeriodMonthDay(concatMonthDay(loanPlan));
			if( 1==pro_loanPlanMapper.updateOnePlanLoan(loanPlan)){
				logService.insertOneOperatorLogInfo(user, "放款计划", "修改", "修改一条放款计划, ID="+loanPlan.getLoanPlan_ID());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 删除放款计划, 同时删除其下的还款计划和应收费用
	 */
	@Override
	public Boolean deleteOnePlanLoan(User user, String loanPlan_ID) {
		try {
			planPayService.deletePlanPayByWheresql(" and loanPlan_ID='"+loanPlan_ID+"'");
			if( 1==pro_loanPlanMapper.deleteOnePlanLoan(" and loanPlan_ID='"+loanPlan_ID+"'")){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 判断计划放款总金额是否超过了评审会同意金额 
	 */
	/*	原来是根据 applyDetailID 查, 现在根据 meetingDetail_ID查*/
	@Override
	public Boolean isMoreThanAgreeSum(Pro_loanPlan loanPlan) {
		try {
			String wheresql = "";
			if("insert".equals(loanPlan.getAccessType())){
//				wheresql = " and applyDetailID='"+loanPlan.getApplyDetailID()+"'";
				wheresql = " and meetingDetail_ID='"+loanPlan.getMeetingDetail_ID()+"'";
			}else if("update".equals(loanPlan.getAccessType())){
//				wheresql = " and applyDetailID='"+loanPlan.getApplyDetailID()+"' and loanPlan_ID != '"+loanPlan.getLoanPlan_ID()+"'";
				wheresql = " and meetingDetail_ID='"+loanPlan.getMeetingDetail_ID()+"' and loanPlan_ID != '"+loanPlan.getLoanPlan_ID()+"'";
			}
			Double totalLoanSum = pro_loanPlanMapper.totalLoanSumByWhereSql(wheresql);
			if(totalLoanSum==null){	//如果没有查到数据, 说明是第一次添加放款计划, 已计划放款金额为0
				totalLoanSum = (double) 0;
			}
			totalLoanSum += loanPlan.getLoanSum();	//已有计划放款金额 + 本次计划放款金额
//			Pro_applyDetail applyDetail = applyDetailService.selectApplyDetailList(" and applyDetail_ID='"+loanPlan.getApplyDetailID()+"'").get(0);
			Pro_meetingDetail meetingDetail = meetingDetailService.selectOneMeetingDetailByWhereSql(" and meetingDetail_ID='"+loanPlan.getMeetingDetail_ID()+"'");
			if(totalLoanSum <= meetingDetail.getAgreeSum()){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 判断计划还款总金额是否超过了该笔计划放款的金额 
	 */
	@Override
	public Boolean isMoreThanPlanLoanSum(Pro_planPay planPay) {
		try {
			String wheresql = "";
			if("insert".equals(planPay.getAccessType())){
				wheresql = " and loanPlan_ID='"+planPay.getLoanPlan_ID()+"'";
			}else if("update".equals(planPay.getAccessType())){
				wheresql = " and loanPlan_ID='"+planPay.getLoanPlan_ID()+"' and planPay_ID != '"+planPay.getPlanPay_ID()+"'";
			}
			Double totalPlanPaySum = planPayService.totalPlanPaySumByWheresql(wheresql);
			if(totalPlanPaySum==null){	//如果没有查到数据, 说明是第一次添加还款计划, 已计划还款金额为0
				totalPlanPaySum = (double) 0;
			}
			totalPlanPaySum += planPay.getPlanPaySum();	//已有计划还款金额 + 本次计划还款金额
			Pro_loanPlan loanPlan = selectOneLoanPlan(" and loanPlan_ID='"+planPay.getLoanPlan_ID()+"'");
			if(totalPlanPaySum <= loanPlan.getLoanSum()){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 自动新增还款计划时校验
	 */
	@Override
	public Map<String, Object> autoAddValidata(User user, Pro_planPay planPay) {
		Map<String, Object> map = new HashMap<>();
		try {
			Integer startMonth = planPay.getStartMonth();	//从放款后第几个月开始还款
			Integer monthNum = planPay.getMonthNum();		//每隔几个月还一次款
			Pro_loanPlan loanPlan = selectOneLoanPlan(" and loanPlan_ID='"+planPay.getLoanPlan_ID()+"'");
			
			if(planPay.getPlanPaySum() > loanPlan.getLoanSum()){
				map.put("validata", false);
				map.put("fieldID", "autoAddPlanPaySum");
				map.put("errorInfo", "每次计划还款金额不能超过计划放款金额！");
				return map;
			}
			if(startMonth > loanPlan.getPeriodMonth()){
				map.put("validata", false);
				map.put("fieldID", "startMonth");
				map.put("errorInfo", "不能超过计划放款期限！");
				return map;
			}
			if(monthNum > loanPlan.getPeriodMonth()){
				map.put("validata", false);
				map.put("fieldID", "monthNum");
				map.put("errorInfo", "不能超过计划放款期限！");
				return map;
			}
			Double totalPaySum = 0.0;
			Integer month = startMonth;
			while(month <= loanPlan.getPeriodMonth()){
				totalPaySum += planPay.getPlanPaySum();
				month += monthNum;  
			}
			if(totalPaySum > loanPlan.getLoanSum() ){
				map.put("validata", false);
				map.put("fieldID", "autoAddPlanPaySum");
				map.put("errorInfo", "计划还款总金额不能超过计划放款金额！");
				return map;
			}
			// 前面没有返回map, 则校验通过
			map.put("validata", true);
			
			//执行还款计划保存操作, 还先要删除之前的还款计划
			map.put("save", autoAddPlanPay(user, planPay));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 自动生成还款计划
	 */
	private Boolean autoAddPlanPay(User user, Pro_planPay planPay){
		try {
			//先删除原有的还款计划
			Boolean boolean1 = planPayService.deletePlanPayByWheresql(" and loanPlan_ID='"+planPay.getLoanPlan_ID()+"'");
			//插入多条还款计划
			Pro_loanPlan loanPlan = selectOneLoanPlan(" and loanPlan_ID='"+planPay.getLoanPlan_ID()+"'");
			Integer month = planPay.getStartMonth();
			Integer monthNum = planPay.getMonthNum();
			Integer periodMonth = loanPlan.getPeriodMonth();
			Date loanDate = loanPlan.getLoanDate();
			for( ;month <= periodMonth; month+=monthNum){
				Calendar cal = Calendar.getInstance();
				cal.setTime(loanDate);
				cal.add(Calendar.MONTH, month);
				planPay.setPlanPayDate(cal.getTime());
				planPay.setPlanPayMonth(month);
				planPayService.insertOnePlanPay(user, planPay);
			}
			return boolean1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 判断计划还款的月份不能超过计划放款期限
	 */
	@Override
	public Boolean isMoreThanPlanLoanPeriodMonth(Pro_planPay planPay) {
		try {
			Pro_loanPlan loanPlan = selectOneLoanPlan(" and loanPlan_ID='"+planPay.getLoanPlan_ID()+"'");
			if(loanPlan.getPeriodMonth() >= planPay.getPlanPayMonth()){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Boolean updatePlanLoanState(Pro_loanPlan loanPlan) {
		try {
			if(1 == pro_loanPlanMapper.updatePlanLoanState(loanPlan)){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//查询附件
	@Override
	public List<Pro_projectfiles> getAttachments(String entityID ) {
		List<Pro_projectfiles> listFiles = null;
		 try {
			 listFiles = projectfilesMapper.selectProFilesListByEntityID(entityID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listFiles;
	}
	
	//查询附件2
	@Override
	public List<Pro_projectfiles> getAttachmentsByType(String entityID, String type) {
		List<Pro_projectfiles> listFiles = null;
		String wheresql = " ";
		if(type != null && !"".equals(type)){
			wheresql = " and fileType = "+type+" ";
		}
		 try {
			 listFiles = projectfilesMapper.selectProFilesListByEntityIDType(entityID ,wheresql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listFiles;
	}

	@Override
	public Boolean deleteAttachment(String projectFiles_ID) {
		int count = 0;
		Boolean isTrue = false;
		try {
			count = projectfilesMapper.deleteOneInfoByProFiles_ID(projectFiles_ID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(count>0){
			isTrue = true;
		}
		return isTrue;
	}
	//根据评审会ID获取放款信息
	@Override
	public List<Pro_loanPlan> selectLoanReviewList(String wheresql) {
		List<Pro_loanPlan> loanPlanList = new ArrayList<Pro_loanPlan>();
		try {
			loanPlanList = pro_loanPlanMapper.selectPlanLoanListByWhereSql(wheresql);
			return loanPlanList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 修改已确认放款
	 */
	@Override
	public Boolean updateLoanConfirm(User user,Pro_loanPlan loanPlan) {
		Integer count = 0;
		Boolean isTrue = false;
		try {
			loanPlan.setLoanState("已放款");
			//修改放款计划表
			pro_loanPlanMapper.updateLoanConfirm(loanPlan);
			
			Pro_loanPlan loanPlan1 = new Pro_loanPlan();
			loanPlan1.setLoanPlan_ID(loanPlan.getLoanPlan_ID());
			//根据ID查询放款计划表信息
			loanPlan1 = pro_loanPlanMapper.selectOneLoanPlan(" and loanPlan_ID=\'"+loanPlan1.getLoanPlan_ID()+"\'");
			loanPlan1.setLoadCode(loanPlan.getLoadCode());
			
			//根据ID查询一条  评审会产品明细  信息
			String meetingDetail_ID = loanPlan1.getMeetingDetail_ID();
			Pro_meetingDetail meetingDetail = meetingDetailMapper.selectOneMeetingDetailByWhereSql(" and meetingDetail_ID=\'"+meetingDetail_ID+"\'");
			//根据ID查询一条  评审会决议表  信息
			String meetingResolution_ID = meetingDetail.getMeetingResolution_ID();
			Pro_meetingResolution meetingResolution = meetingResolutionMapper.selectOneResolutionByWhereSql(" and meetingResolution_ID=\'"+meetingResolution_ID+"\'");
			
			//向pro_project表放数据
			Pro_project project = setPro_Project(user,loanPlan1,meetingDetail);
			//向pro_project插入一条数据
			count = projectMapper.insertOneProjectInfo(project);
			
			//向 保后检查计划表pro_checkPlan 插入一条数据
			
			//向pro_checkPlan表中插入一条记录
			Pro_checkPlan checkPlan = new Pro_checkPlan();
			
			checkPlan.setApply_ID(loanPlan1.getApplyID());
			checkPlan.setProject_ID(project.getProject_ID());
			checkPlan.setCreate_user(user.getCreate_user());
			checkPlan.setUnit_uid(user.getUnit_uid());
			checkPlan.setIsFinish("0");
			
			Date billBeginDate = loanPlan1.getBillBeginDate();
	        Calendar calendar = Calendar.getInstance();  
	        calendar.setTime(billBeginDate);  
	        calendar.add(Calendar.DAY_OF_MONTH, -1);  
	        billBeginDate = calendar.getTime();  //获取当前时间的前一天
	        
			Date billEndDate = loanPlan1.getBillEndDate();
			String controlTypeName = meetingResolution.getControlTypeName();//保后监控周期名称
			int num = 0;
			if(null!=controlTypeName && "月".equals(controlTypeName)){
				num=1;
				//向pro_checkPlan表中插入一条记录
				insertOneCheckPlan(billBeginDate, num,billEndDate,checkPlan);
			}else if(null!=controlTypeName && "季度".equals(controlTypeName)){
				num=3;
				//向pro_checkPlan表中插入一条记录
				insertOneCheckPlan(billBeginDate, num,billEndDate,checkPlan);
			}else if(null!=controlTypeName && "半年".equals(controlTypeName)){
				num=6;
				//向pro_checkPlan表中插入一条记录
				insertOneCheckPlan(billBeginDate, num,billEndDate,checkPlan);
			}else if(null!=controlTypeName && "年".equals(controlTypeName)){//年
				num=12;
				//向pro_checkPlan表中插入一条记录
				insertOneCheckPlan(billBeginDate, num,billEndDate,checkPlan);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(count>0){
			isTrue = true;
			logService.insertOneOperatorLogInfo(user,"已放款确认", "更新", "更新一条已放款确认信息信息pro_loanPlan");
		}
		
		return isTrue;
	}
	
	/**
	 * 向pro_checkPlan表中插入一条记录
	 * @param beginDate
	 * @param num
	 * @param endDate
	 * @param checkPlan
	 * @throws ParseException
	 */
	private void insertOneCheckPlan(Date beginDate, int num, Date endDate,Pro_checkPlan checkPlan) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(beginDate);
		cal.add(cal.MONTH, num);
		//cal.add(cal.DAY_OF_MONTH, 0);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		String syncTime=df.format(cal.getTime()).toString();
		beginDate = df.parse(syncTime);
		
		int i = beginDate.compareTo(endDate);
		
		if (i <= 0) {
			checkPlan.setCheckPlan_ID(Tool.createUUID32());//主键
			checkPlan.setPlanCheckDate(beginDate);
			//向pro_checkPlan表中插入数据
			checkPlanMapper.insertOneCheckPlan(checkPlan);//计划检查日期planCheckDate
			insertOneCheckPlan(beginDate, num, endDate,checkPlan);
		}

	}
	//向pro_project表中存放数据
	public Pro_project setPro_Project(User user,Pro_loanPlan loanPlan1,Pro_meetingDetail meetingDetail){
		String applyDetail_ID = loanPlan1.getApplyDetailID();
		Pro_applyDetail applyDetail = null;
		if(null != applyDetail_ID){
			applyDetail = applyDetailMapper.selectOneApplyDetailWhereSql(" and applyDetail_ID='"+applyDetail_ID+"' ");
		}
		
		//根据ID查询一条Pro_apply记录
		Pro_apply apply = applyMapper.selectOneApplyWhereSql(" and apply_ID=\'"+loanPlan1.getApplyID()+"\'");
		
		Pro_project project = new Pro_project();
		
		project.setProject_ID(Tool.createUUID32());//项目ID
		project.setApply_ID(loanPlan1.getApplyID());//对应业务申请ID
		project.setLoanPlan_ID(loanPlan1.getLoanPlan_ID());//放款计划ID
		project.setApplyDetail_ID(loanPlan1.getApplyDetailID());//对应产品ID
		//项目编号
		project.setProjectName(apply.getProjectName());		//项目名称
		project.setProjectCode(apply.getBusiCode()); //项目编号
		project.setLoadCode(loanPlan1.getLoadCode()); //放款单编号编号
		
		project.setBusiTypeID(loanPlan1.getBusiTypeID());//业务品种ID
		project.setBusiTypeName(loanPlan1.getBusiTypeName());//业务品种名称
		project.setBankID(loanPlan1.getBankID());//合作机构ID
		project.setBankName(loanPlan1.getBankName());//合作机构名称
		project.setSubBankName(loanPlan1.getSubBankName());//合作子机构（或个人）（手工录入）
		
		Double loanSum = loanPlan1.getLoanSum()==null ? 0D:loanPlan1.getLoanSum();//放款金额
		Double guarantyScale= meetingDetail.getGuarantyScale()==null ? 0D:meetingDetail.getGuarantyScale();//担保责任比例
		Double guarantyDutySum = 0D;//担保责任金额
				
		if(loanSum!=0 ){
			guarantyDutySum = (loanSum*guarantyScale)/100;
		}
		
		project.setLoadSum(loanSum);//在保余额,初始化为放款金额
		project.setGuarantySum(loanSum);//在保余额,初始化为放款金额
		project.setGuarantyDutySum(guarantyDutySum);	//担保责任金额
		project.setGuarantyDutyResSum(guarantyDutySum);//担保责任余额
		
		project.setGuarantyScale(guarantyScale);	//担保责任比例
		project.setGuarantyScope(meetingDetail.getGuarantyScope());	//担保责任范围
		
		project.setBzScale(meetingDetail.getBzScale());//保证金比例
		
		project.setPeriodDay(loanPlan1.getPeriodDay());//期限.天
		project.setPeriodMonth(loanPlan1.getPeriodMonth());//期限.月
		project.setPeriodMonthDay(loanPlan1.getPeriodMonthDay());//期限.月天
		project.setBillBeginDate(loanPlan1.getBillBeginDate());//借据起始日期
		project.setBillEndDate(loanPlan1.getBillEndDate());//借据到期日期
		project.setDelayBeginDate(loanPlan1.getBillBeginDate());//展期起始日期（初始为借据起始日期）
		project.setDelayEndDate(loanPlan1.getBillEndDate());//展期到期日期（初始为借据到期日期）
		//project.setLoadBeginDate(apply.getContractBeginDate());//担保起始日期
		//project.setLoadEndDate(apply.getContractEndDate());//担保到期日期
		project.setLoadBeginDate(loanPlan1.getBillBeginDate());//担保起始日期
		project.setLoadEndDate(loanPlan1.getBillEndDate());//担保到期日期
		
		project.setUnit_uid(user.getUnit_uid());
		project.setUnit_uidName(user.getUnit_uidName());
		project.setUpdateUserName(user.getUser_name());//最后修改人姓名
		
		project.setIsDelay(0);//是否展期
		project.setIsFree(0);//担保责任是否完全解除
		project.setIsOver(0);//正式确认是否逾期
		project.setIsBeforeEnd(0);//是否提前到期
		project.setIsCreditor(0);//是否涉及敏感债权人
		project.setIsGuaranty(0);//是否担保集团担保
		
		
		if(null != applyDetail){
			project.setProjectCode(applyDetail.getProjectCode());//项目编号
			project.setBusiClass(applyDetail.getBusiClass());//业务大类(01：担保02：委贷)
			project.setAmanID(applyDetail.getAmanID());		//项目经理A角ID
			project.setAmanName(applyDetail.getAmanName());	//项目经理A角名称
			project.setBmanID(applyDetail.getBmanID());		//项目经理B角ID
			project.setBmanName(applyDetail.getBmanName());	//项目经理B角名称
			project.setReviewManID(applyDetail.getReviewManID());	//风控评审人ID
			project.setReviewManName(applyDetail.getReviewManName());	//风控评审人名称
		}
		
		return project;
	}
	

	/**
	 * 放款复核--取消
	 */
	@Override
	public Boolean loanConfirmCancel(User user, Pro_loanPlan loanPlan) {
		Integer count = 0;
		Boolean isTrue = false;
		//根据放款ID删除pro_project信息
		
		String loanPlan_ID = loanPlan.getLoanPlan_ID();
		loanPlan = pro_loanPlanMapper.selectOneLoanPlan(" and loanPlan_ID=\'"+loanPlan_ID+"\'");
		try {
			
			//删除附件表pro_projectfiles对应的信息
			projectfilesMapper.deleteOneProFilesByEntityID(" and entityID='"+loanPlan_ID+"'");
			List<Pro_project> projectList = projectMapper.selectProjectListByWheresql(" and loanPlan_ID='"+loanPlan.getLoanPlan_ID()+"' ");
			Pro_project project = null;
			if(projectList.size()>0){
				project = projectList.get(0);
			}
			//根据条件删除保后检查计划表pro_checkPlan
			//checkPlanMapper.deleteCheckPlansByApplyID(loanPlan.getApplyID());
			String project_ID="";
			if(project != null){
				project_ID=project.getProject_ID();
			}
			String whereSql = " and apply_ID='"+loanPlan.getApplyID()+"' and project_ID='"+project.getProject_ID()+"' and unit_uid = '"+SystemSession.getUserSession().getUnit_uid()+"' ";
			checkPlanMapper.deleteCheckPlansByWhereSql(whereSql);
			//删除pro_project对应的信息
			projectMapper.deleteOneProjectAfterBySql(" and loanPlan_ID='"+loanPlan_ID+"'");
			//修改放款计划表的状态loanState
			loanPlan.setLoanState("未放款");
			count = pro_loanPlanMapper.updatePlanLoanState(loanPlan);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(count>0){
			isTrue = true;
			logService.insertOneOperatorLogInfo(user,"已放款确认撤销", "删除", "更新一条已放款确认信息信息pro_loanPlan");
		}
		return isTrue;
	}
	//新增一条放款计划 WHDB
	@Override
	public Boolean insertOneLoanPlan(User user, Pro_loanPlan loanPlan) {
		String meetingDetail_ID = loanPlan.getMeetingDetail_ID();
		String condition = " and meetingDetail_ID='"+meetingDetail_ID+"' ";
		try {
			//查询评审会产品明细
			Pro_meetingDetail meetingDetail = meetingDetailService.selectOneMeetingDetailByWhereSql(condition);
			
			if(meetingDetail != null){
				loanPlan.setApplyID(meetingDetail.getApply_ID());
				loanPlan.setApplyDetailID(meetingDetail.getApplyDetail_ID());
				loanPlan.setBusiTypeID(meetingDetail.getBusiTypeID());
				loanPlan.setBusiTypeName(meetingDetail.getBusiTypeName());
				loanPlan.setBankID(meetingDetail.getBankID());
				loanPlan.setBankName(meetingDetail.getBankName());
				loanPlan.setBankTypeID(meetingDetail.getBankTypeID());
				loanPlan.setBankTypeName(meetingDetail.getBantTypeName());
				loanPlan.setSubBankName(meetingDetail.getSubBankName());
				String periodMonthDay = concatMonthDay(loanPlan);
				loanPlan.setPeriodMonthDay(periodMonthDay);
				loanPlan.setLoanState("未放款");
				loanPlan.setApprovalState("审批中");
				loanPlan.setUnit_uid(user.getUnit_uid());
				loanPlan.setUnit_uidName(user.getUnit_uidName());
				loanPlan.setUpdateUserName(user.getUser_name());
			}
		
			if(1==pro_loanPlanMapper.insertOnePlanLoan(loanPlan)){
				OsGworkflowFlowtemplate flow = new OsGworkflowFlowtemplate();
				flow.setUnit_uid(user.getUnit_uid());
				flow.setUser_uid(user.getUser_uid());
				flow.setProjectID(loanPlan.getApplyID());
				flow.setEntityName("放款申请：" + loanPlan.getLoanSum() + "万元");
				
				flow.setBusinessId(loanPlan.getLoanPlan_ID());
				flow.setBusinessType(loanPlan.getClass().getName());
				
				flow.setFlowTemplateName("放款子流程");
				flow.setFlowTemplateID("G201");
				flow.setFlowType("02");
				Long startResult = gworkFlowService.createworkflowInstance(flow);
				if(startResult == 0){
					throw new RuntimeException("流程模板配置有误");
				}
				
				logService.insertOneOperatorLogInfo(user, "放款计划", "新增", "新增一条放款计划, ID="+loanPlan.getLoanPlan_ID());
				return true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 删除一条放款计划
	 */ 
	@Override
	public Boolean delOneLoanPlan(User user, Pro_loanPlan loanPlan) {
		try {
			//删除附件表pro_projectfiles对应的信息
			projectfilesMapper.deleteOneProFilesByEntityID(" and entityID='"+loanPlan.getLoanPlan_ID()+"'");
			if( 1==pro_loanPlanMapper.deleteOnePlanLoan(" and loanPlan_ID='"+loanPlan.getLoanPlan_ID()+"'")){
				logService.insertOneOperatorLogInfo(user, "放款计划", "删除", "删除一条放款计划, ID="+loanPlan.getLoanPlan_ID());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//放款复核
	@Override
	public Boolean updateLoanCheck(User user, Pro_project project) {
		Integer count = 0;
		Boolean isTrue = false;
		try {
			Pro_loanPlan loanPlan = new Pro_loanPlan();
			//根据ID查询放款计划表信息
			loanPlan = pro_loanPlanMapper.selectOneLoanPlan(" and loanPlan_ID=\'"+project.getLoanPlan_ID()+"\'");
			//根据ID查询一条  评审会产品明细  信息
			String meetingDetail_ID = loanPlan.getMeetingDetail_ID();
			Pro_meetingDetail meetingDetail = meetingDetailMapper.selectOneMeetingDetailByWhereSql(" and meetingDetail_ID=\'"+meetingDetail_ID+"\'");
			
			//向pro_project表放数据
			project = setProject(user,loanPlan,project,meetingDetail);
			//向pro_project插入一条数据
			count = projectMapper.insertOneProjectInfo(project);
			
			//向 保后检查计划表pro_checkPlan 插入一条数据
			
			//向pro_checkPlan表中插入一条记录
			Pro_checkPlan checkPlan = new Pro_checkPlan();
			
			checkPlan.setApply_ID(project.getApply_ID());
			checkPlan.setProject_ID(project.getProject_ID());
			checkPlan.setCreate_user(user.getCreate_user());
			checkPlan.setUnit_uid(user.getUnit_uid());
			checkPlan.setIsFinish("0");
			
			Date billBeginDate = project.getBillBeginDate();
	        Calendar calendar = Calendar.getInstance();  
	        calendar.setTime(billBeginDate);  
	        calendar.add(Calendar.DAY_OF_MONTH, -1);  
	        billBeginDate = calendar.getTime();  //获取当前时间的前一天
	        
			Date billEndDate = project.getBillEndDate();
			
			//根据ID查询一条  评审会决议表  信息
			String meetingResolution_ID = meetingDetail.getMeetingResolution_ID();
			Pro_meetingResolution meetingResolution = meetingResolutionMapper.selectOneResolutionByWhereSql(" and meetingResolution_ID=\'"+meetingResolution_ID+"\'");
			
			String controlTypeName = meetingResolution.getControlTypeName();//保后监控周期名称
			int num = 0;
			if(null!=controlTypeName && "月".equals(controlTypeName)){
				num=1;
				//向pro_checkPlan表中插入一条记录
				insertOneCheckPlan(billBeginDate, num,billEndDate,checkPlan);
			}else if(null!=controlTypeName && "季度".equals(controlTypeName)){
				num=3;
				//向pro_checkPlan表中插入一条记录
				insertOneCheckPlan(billBeginDate, num,billEndDate,checkPlan);
			}else if(null!=controlTypeName && "半年".equals(controlTypeName)){
				num=6;
				//向pro_checkPlan表中插入一条记录
				insertOneCheckPlan(billBeginDate, num,billEndDate,checkPlan);
			}else if(null!=controlTypeName && "年".equals(controlTypeName)){//年
				num=12;
				//向pro_checkPlan表中插入一条记录
				insertOneCheckPlan(billBeginDate, num,billEndDate,checkPlan);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(count>0){
			isTrue = true;
			logService.insertOneOperatorLogInfo(user,"已放款确认", "更新", "更新一条已放款确认信息信息pro_loanPlan");
		}
		
		return isTrue;
	}
	
	//向pro_project表中存放数据
	public Pro_project setProject(User user, Pro_loanPlan loanPlan, Pro_project project,
			Pro_meetingDetail meetingDetail) {
		String applyDetail_ID = loanPlan.getApplyDetailID();
		Pro_applyDetail applyDetail = null;
		if (null != applyDetail_ID) {
			applyDetail = applyDetailMapper
					.selectOneApplyDetailWhereSql(" and applyDetail_ID='" + applyDetail_ID + "' ");
		}

		// 根据ID查询一条Pro_apply记录
		Pro_apply apply = applyMapper.selectOneApplyWhereSql(" and apply_ID=\'" + loanPlan.getApplyID() + "\'");

		project.setApply_ID(loanPlan.getApplyID());// 对应业务申请ID
		project.setApplyDetail_ID(loanPlan.getApplyDetailID());// 对应产品ID
		// 项目编号
		project.setProjectName(apply.getProjectName()); // 项目名称
		String projectCode = apply.getBusiCode();
		String loadCode = "WHDB".concat(projectCode);
		
		project.setProjectCode(projectCode);
		project.setLoadCode(loadCode); //项目编号

		project.setBusiTypeID(loanPlan.getBusiTypeID());// 业务品种ID
		project.setBusiTypeName(loanPlan.getBusiTypeName());// 业务品种名称
		project.setBankID(loanPlan.getBankID());// 合作机构ID
		project.setBankName(loanPlan.getBankName());// 合作机构名称
		project.setSubBankName(loanPlan.getSubBankName());// 合作子机构（或个人）（手工录入）

		Double loanSum = project.getLoadSum() == null ? 0D : project.getLoadSum();// 放款金额
		Double guarantyScale = meetingDetail.getGuarantyScale() == null ? 0D : meetingDetail.getGuarantyScale();// 担保责任比例
		Double guarantyDutySum = 0D;// 担保责任金额

		if (loanSum != 0) {
			guarantyDutySum = (loanSum * guarantyScale) / 100;
		}

		project.setLoadSum(loanSum);// 在保余额,初始化为放款金额
		project.setGuarantySum(loanSum);// 在保余额,初始化为放款金额
		project.setGuarantyDutySum(guarantyDutySum); // 担保责任金额
		project.setGuarantyDutyResSum(guarantyDutySum);// 担保责任余额

		project.setGuarantyScale(guarantyScale); // 担保责任比例
		project.setGuarantyScope(meetingDetail.getGuarantyScope()); // 担保责任范围

		project.setBzScale(meetingDetail.getBzScale());// 保证金比例

		// project.setPeriodDay(loanPlan.getPeriodDay());//期限.天
		// project.setPeriodMonth(loanPlan.getPeriodMonth());//期限.月
		project.setPeriodMonthDay(concatMonthDay(project.getPeriodMonth(), project.getPeriodDay()));// 期限.月天
		// project.setBillBeginDate(loanPlan.getBillBeginDate());//借据起始日期
		// project.setBillEndDate(loanPlan.getBillEndDate());//借据到期日期
		project.setDelayBeginDate(project.getBillBeginDate());// 展期起始日期（初始为借据起始日期）
		project.setDelayEndDate(project.getBillEndDate());// 展期到期日期（初始为借据到期日期）
		// project.setLoadBeginDate(apply.getContractBeginDate());//担保起始日期
		// project.setLoadEndDate(apply.getContractEndDate());//担保到期日期
		project.setLoadBeginDate(project.getBillBeginDate());// 担保起始日期
		project.setLoadEndDate(project.getBillEndDate());// 担保到期日期

		project.setUnit_uid(user.getUnit_uid());
		project.setUnit_uidName(user.getUnit_uidName());
		project.setUpdateUserName(user.getUser_name());// 最后修改人姓名

		project.setIsDelay(0);// 是否展期
		project.setIsFree(0);// 担保责任是否完全解除
		project.setIsOver(0);// 正式确认是否逾期
		project.setIsBeforeEnd(0);// 是否提前到期
		project.setIsCreditor(0);// 是否涉及敏感债权人
		project.setIsGuaranty(0);// 是否担保集团担保

		if (null != applyDetail) {
			project.setProjectCode(applyDetail.getProjectCode());// 项目编号
			project.setBusiClass(applyDetail.getBusiClass());// 业务大类(01：担保02：委贷)
			project.setAmanID(applyDetail.getAmanID()); // 项目经理A角ID
			project.setAmanName(applyDetail.getAmanName()); // 项目经理A角名称
			project.setBmanID(applyDetail.getBmanID()); // 项目经理B角ID
			project.setBmanName(applyDetail.getBmanName()); // 项目经理B角名称
			project.setReviewManID(applyDetail.getReviewManID()); // 风控评审人ID
			project.setReviewManName(applyDetail.getReviewManName()); // 风控评审人名称
		}

		return project;
	}
		/**
		 * 拼接申请期限字符串
		 */
		private String concatMonthDay(Integer month,Integer day){
			StringBuffer periodMonthDay = new StringBuffer();
			if( month!=null && !month.equals(0)){
				periodMonthDay.append(month+"个月");
				if(day!=null && day!=0){
					periodMonthDay.append(day+"天");
				}
			}else if(day!=null && day!=0){
				periodMonthDay.append(day+"天");
			}
			return periodMonthDay.toString();
		}
		
	
}
