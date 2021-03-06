package com.zjm.pro.delay.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.gworkFlow.db.model.OsGworkflowFlowtemplate;
import com.zjm.gworkFlow.startWorkFlow.service.GworkFlowService;
import com.zjm.pro.db.map.Pro_delayMapper;
import com.zjm.pro.db.map.Pro_projectMapper;
import com.zjm.pro.db.map.Pro_projectfilesMapper;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_delay;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.db.model.pro_manageRreviewModeExcel;
import com.zjm.pro.db.model.pro_meetingExportModeExcel;
import com.zjm.pro.db.model.pro_reviewCommitteeModeExcel;
import com.zjm.pro.delay.service.DelayService;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.util.DateUtil;
import com.zjm.util.SystemSession;

@Service("delayService")
@Transactional
public class DelayServiceImpl implements DelayService {
    
	@Resource
	private ProjectService  projectService;
	@Resource
	private Pro_delayMapper pro_delayMapper;
	@Resource
	private Pro_projectMapper pro_projectMapper;
	
	@Resource
	private LogService logService;
	@Resource
	private Pro_projectfilesMapper projectfilesMapper;
	@Resource
	private GworkFlowService gworkFlowService;
	/***
	 *  展期情况信息表 分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectDelayTables(PageTable pageTable) {
		List<Pro_delay> applyList = null;
		try {
			applyList = pro_delayMapper.selectDelayTables(pageTable);
			Long total = pro_delayMapper.selectDelayTables_Count(pageTable);
			pageTable.setRows(applyList);
			pageTable.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}
	/**
	 * 插入一个 展期情况信息
	 * @param 
	 * @return
	 */
	public Boolean insertOneDelayInfo(User user, Pro_delay delay) {
		Integer returnInt2=1;
		Boolean b = false;
		//根据业务id获取业务表信息;
		String wheresql = " and project_ID = \'"+delay.getProject_ID()+"\'";
	    Pro_project project = projectService.selectOneProjectInfoByWheresql(wheresql);
		
	    //新增一笔放款表信息;
	    //delay.setDelay_ID(Tool.createUUID32());
	    delay.setUnit_uid(user.getUnit_uid());
	    delay.setUpdateUserName(user.getUser_name());
	    delay.setDelayState("待审批");
	    delay.setDelayMonthDay(getMonthDay(delay.getDelayMonth(),delay.getDelayDay()));
	    Integer returnInt = pro_delayMapper.insertOneDelayInfo(delay);
	    if(project != null){
			//展期金额相加更新实际放款表
			Double dDelaySum=0d;
			dDelaySum=delay.getDelaySum()==null ? 0d :delay.getDelaySum(); //拿到最新的展期金额
			project.setDelaySum(dDelaySum);
//			project.setDelayMonth(delay.getDelayMonth());//更新展期日期 月
//			project.setDelayDay(delay.getDelayDay());//更新展期日期 天
//			project.setDelayMonthDay(getMonthDay(delay.getDelayMonth(),delay.getDelayDay()));//更新展期日期 月天
//			project.setDelayEndDate(delay.getDelayEndDate());//更新展期 到期日期
//			if(null != delay.getDelayBeginDate()){
//				project.setDelayBeginDate(delay.getDelayBeginDate());// 更新展期 起始日期
//			}
//			project.setDelayRate(delay.getDelayRate());//更新 展期后担保费率%
//			project.setDelayServiceRate(delay.getDelayServiceRate());//更新展期后融资服务费率%
			//更新放款表信息  (子流程处理完修改)
			project.setDelayEndDate(delay.getDelayEndDate());
			int[] monthDay = getMonthAndDay(project.getLoadBeginDate(), project.getDelayEndDate());
			project.setPeriodDay(monthDay[1]);
			project.setPeriodMonth(monthDay[0]);
			project.setPeriodMonthDay(getMonthDayByMonthAndDay(monthDay[0],monthDay[1]));
			project.setIsDelay(1);
			returnInt2=pro_projectMapper.updateOneProjectInfo(project);
			
			//新增展期流程:
			OsGworkflowFlowtemplate flow = new OsGworkflowFlowtemplate();
			flow.setUnit_uid(user.getUnit_uid());
			flow.setUser_uid(user.getUser_uid());
			flow.setProjectID(delay.getApplyID());
			flow.setEntityName("展期");
			
			flow.setBusinessId(delay.getDelay_ID());
			flow.setBusinessType(delay.getClass().getName());
			
			flow.setFlowTemplateName("展期子流程");
			flow.setFlowTemplateID("G101");
			flow.setFlowType("02");
			Long startResult = gworkFlowService.createworkflowInstance(flow);
			if(startResult == 0){
				throw new RuntimeException("流程模板配置有误");
			}
		}
		if(1==returnInt&&1==returnInt2){
			logService.insertOneOperatorLogInfo(user,"展期登记", "更新", "更新一条项目展期信息project_ID="+delay.getProject_ID());
			logService.insertOneOperatorLogInfo(user,"展期登记", "新增", "新增一条展期表信息delay_ID="+delay.getDelay_ID());
			b= true;
		}
		return b;
	}
	
	/**
	 * 根据展期期限月,天 拼接月天;
	 * @param delayMonth
	 * @param delayDay
	 * @return
	 */
	public String getMonthDay(Integer delayMonth,Integer delayDay){
		String monthDay = "";
		if (delayMonth != null && delayMonth != 0) {
			monthDay = delayMonth+"个月";
		}
		if (delayDay != null && delayDay != 0) {
			monthDay+=delayDay+"天";
		}
		return  monthDay;
		
	}
	
	/**
	 * 根据输入条件查询单个展期信息
	 */
	public Pro_delay selectOneDelayByWhereSql(String whereSql) {
		return	pro_delayMapper.selectOneDelayByWhereSql(whereSql);
		
	}
	/**
	 * 展期列表修改
	 */
	public Boolean updateOneDelay(User user, Pro_delay pro_delay) {
		Boolean b = false;
		
		//根据业务id获取业务表信息;
		String wheresql = " and project_ID = \'"+pro_delay.getProject_ID()+"\'";
	    Pro_project oldProject = projectService.selectOneProjectInfoByWheresql(wheresql);
	    String wheresql1 = " and delay_ID = \'"+pro_delay.getDelay_ID()+"\'";
	    Pro_delay oldDelay = pro_delayMapper.selectOneDelayByWhereSql(wheresql1);
	    //更新展期金额---start
	    Double newDelaySum=0d;
		newDelaySum=pro_delay.getDelaySum()==null ? 0d :pro_delay.getDelaySum(); //拿到最新的展期金额
		Double pDelaySum=oldProject.getDelaySum()==null ?0d :oldProject.getDelaySum();//拿到之前放款表展期金额总金额
		Double oldDDelaySum=oldDelay.getDelaySum()==null ?0d :oldDelay.getDelaySum();//拿到之前的展期表展期金额
		oldProject.setDelaySum(pDelaySum+(newDelaySum-oldDDelaySum));
		//更新展期金额---end
		
		oldProject.setDelayBeginDate(pro_delay.getDelayBeginDate());//更新展期起始日期
		oldProject.setDelayEndDate(pro_delay.getDelayEndDate());//更新展期 到期日期
		//更新放款期限
		int[] monthDay = getMonthAndDay(oldProject.getLoadBeginDate(), oldProject.getDelayEndDate());
		oldProject.setPeriodDay(monthDay[1]);
		oldProject.setPeriodMonth(monthDay[0]);
		oldProject.setPeriodMonthDay(getMonthDayByMonthAndDay(monthDay[0],monthDay[1]));
		//更新放款表信息
		Integer returnInt2=pro_projectMapper.updateOneProjectInfo(oldProject);
		
	    pro_delay.setDelayMonthDay(getMonthDay(pro_delay.getDelayMonth(),pro_delay.getDelayDay()));
		Integer returnInt = pro_delayMapper.updateOneDelay(pro_delay);
		if(returnInt>0&&returnInt2>0){
			logService.insertOneOperatorLogInfo(user,"保后跟踪展期登记", "更新", "更新一条项目展期信息project_ID="+pro_delay.getProject_ID());
			logService.insertOneOperatorLogInfo(user,"保后跟踪展期登记", "更新", "更新一条展期表信息delay_ID="+pro_delay.getDelay_ID());
			b= true;
		}
		return b;
	}
	/**
	 * 根据输入的条件删除一条展期表信息
	 * @param userSession
	 * @param whereSql delay_ID
	 * @return
	 */
	public Boolean deleteDelayByWhereSql(User userSession, String whereSql) {
		try {
			Integer returnResult  = pro_delayMapper.deleteDelayByWhereSql(whereSql);
			if(returnResult>0){
				logService.insertOneOperatorLogInfo(userSession,"申请登记", "删除", "删除业务申请产品信息表信息");		
			    return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 根据输入的条件删除一条展期表信息
	 * @param userSession
	 * @param whereSql delay_ID
	 * @return
	 */
	public Boolean deleteOneDelay(User userSession, Pro_delay pro_delay) {
		Boolean b = false;
		try {
			String whereSql=" and delay_ID = '"+pro_delay.getDelay_ID()+"'".trim();
			String whereSql2=" and project_ID = '"+pro_delay.getProject_ID()+"'".trim();
			Integer returnResult = 0;
			Integer returnResult2 = 0;
			//根据delay_ID 获取单个 展期表信息
			Pro_delay oldDelay = pro_delayMapper.selectOneDelayByWhereSql(whereSql);
		    //根据业务id获取单个业务表信息;
		    Pro_project oldProject = projectService.selectOneProjectInfoByWheresql(whereSql2);
			
		    List<Pro_delay> delayList = pro_delayMapper.selectDelayListByWhereSql(whereSql2);
		    
		    if(null != oldProject && null != oldDelay){
				 //更新展期金额---start
				Double pDelaySum=oldProject.getDelaySum()==null ?0d :oldProject.getDelaySum();//拿到之前放款表展期金额总金额
				Double oldDDelaySum=oldDelay.getDelaySum()==null ?0d :oldDelay.getDelaySum();//拿到之前的展期表展期金额
				oldProject.setDelaySum(pDelaySum-oldDDelaySum);
				//更新展期金额---end
				Integer delayListLength = delayList.size();//获取list 长度
				if(2 == delayListLength){
					if(pro_delay.getDelay_ID().equals(delayList.get(0).getDelay_ID())){
						oldProject.setDelayBeginDate(delayList.get(1).getDelayBeginDate());
						oldProject.setDelayEndDate(delayList.get(1).getDelayEndDate());
					}else{
						oldProject.setDelayBeginDate(delayList.get(0).getDelayBeginDate());
						oldProject.setDelayEndDate(delayList.get(0).getDelayEndDate());
					}
				}else{
					if(2 < delayListLength){
						 if(pro_delay.getDelay_ID().equals(delayList.get(delayListLength-1).getDelay_ID())){
							 oldProject.setDelayBeginDate(delayList.get(delayListLength-2).getDelayBeginDate());
							 oldProject.setDelayEndDate(delayList.get(delayListLength-2).getDelayEndDate());
						 }else{
							 oldProject.setDelayBeginDate(delayList.get(delayListLength-1).getDelayBeginDate());
							 oldProject.setDelayEndDate(delayList.get(delayListLength-1).getDelayEndDate());
						 }
					}else{
						 oldProject.setDelayBeginDate(oldProject.getLoadBeginDate());//更新展期起始日期
						 oldProject.setDelayEndDate(oldProject.getLoadEndDate());//更新展期 到期日期
					}			
				}
				returnResult  = pro_delayMapper.deleteDelayByWhereSql(whereSql);
				//更新放款期限
				int[] monthDay = getMonthAndDay(oldProject.getLoadBeginDate(), oldProject.getDelayEndDate());
				oldProject.setPeriodDay(monthDay[1]);
				oldProject.setPeriodMonth(monthDay[0]);
				oldProject.setPeriodMonthDay(getMonthDayByMonthAndDay(monthDay[0],monthDay[1]));
			    //更新放款表信息
			    returnResult2 = pro_projectMapper.updateOneProjectInfo(oldProject);
			}
			if(returnResult>0 && returnResult2 > 0){
				logService.insertOneOperatorLogInfo(userSession,"申请登记", "删除", "删除业务申请产品信息表信息");		
			    b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	/**
	 * @param whereSql
	 * @return 查询一条展期信息
	 */
	@Override
	public Pro_delay selectOneDelayInfo(String whereSql) {
		Pro_delay delay = new Pro_delay();
		try {
			delay = pro_delayMapper.selectOneDelayInfoByID(whereSql);
			return delay;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @return 展期修改
	 */
	@Override
	public Object updateProDelay(User user, Pro_delay delay) {
		Integer returnInt2 = 0;
		Boolean b = false;
		// 根据业务id获取业务表信息;
		Pro_project project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'" + delay.getProject_ID() + "\'");

		// 新增一笔放款表信息;
		delay.setDelayMonthDay(getMonthDay(delay.getDelayMonth(), delay.getDelayDay()));
		Integer returnInt = pro_delayMapper.updateProDelay(delay);
		if (project != null) {
			// 展期金额相加更新实际放款表
			Double dDelaySum = 0d;
			dDelaySum = delay.getDelaySum() == null ? 0d : delay.getDelaySum(); // 拿到最新的展期金额
			project.setDelaySum(dDelaySum);
			project.setDelayEndDate(delay.getDelayEndDate());// 更新展期 到期日期
			if(null != delay.getDelayBeginDate()){
				project.setDelayBeginDate(delay.getDelayBeginDate()); // 更新展期 起始日期
			}
			project.setIsDelay(1);
			// 更新放款表信息
			returnInt2 = pro_projectMapper.updateOneProjectInfo(project);
		}
		if (1 == returnInt && 1 == returnInt2) {
			logService.insertOneOperatorLogInfo(user, "展期修改", "更新", "更新一条项目展期信息project_ID=" + delay.getProject_ID());
			logService.insertOneOperatorLogInfo(user, "展期修改", "修改", "新增一条展期表信息delay_ID=" + delay.getDelay_ID());
			b = true;
		}
		return b;
	}
	//展期删除
	@Override
	public Boolean delProDelay(User user, Pro_delay delay) {
		// 根据业务id获取展期表信息;
		delay = pro_delayMapper.selectOneDelayInfoByID(" and delay.delay_ID =\'"+delay.getDelay_ID()+"\'");
		// 根据业务id获取业务表信息;
		Pro_project project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'" + delay.getProject_ID() + "\'");
		Integer returnInt2 = 0;
		Boolean isTrue = false;
		if (project != null) {
			// 展期金额相加更新实际放款表
			Double dDelaySum = 0d;
			//dDelaySum = delay.getDelaySum() == null ? 0d : delay.getDelaySum(); // 拿到最新的展期金额
			project.setDelaySum(dDelaySum);
			project.setDelayEndDate(null);// 更新展期 到期日期
			if(null != delay.getDelayBeginDate()){
				project.setDelayBeginDate(null);// 更新展期 起始日期
			}
			project.setIsDelay(0);
			// 更新放款表信息
			returnInt2 = pro_projectMapper.updateOneProjectInfo(project);
		}
		//删除附件表pro_projectfiles对应的信息
		projectfilesMapper.deleteOneProFilesByEntityID(" and entityID='"+delay.getDelay_ID()+"'");
		//删除展期信息
		int returnInt = pro_delayMapper.deleteDelayByWhereSql(" and delay_ID = \'"+delay.getDelay_ID()+"\'");
		
		if (1 == returnInt && 1 == returnInt2) {
			logService.insertOneOperatorLogInfo(user, "展期删除", "更新", "更新一条项目展期信息project_ID=" + delay.getProject_ID());
			logService.insertOneOperatorLogInfo(user, "展期删除", "删除", "删除一条展期表信息delay_ID=" + delay.getDelay_ID());
			isTrue = true;
		}
		
		return isTrue;
	}
	
	//根据输入条件查询多个展期信息
	public List<Pro_delay> selectDelayListByWhereSql(String string) {
		 List<Pro_delay> delayList = pro_delayMapper.selectDelayListByWhereSql(string);
		return delayList;
	}
	
	@Override
	public List<pro_manageRreviewModeExcel> packageManageReviewExport(User user,Pro_apply apply) {
		List<pro_manageRreviewModeExcel> list1=new ArrayList<pro_manageRreviewModeExcel>();
		pro_manageRreviewModeExcel pro2=new pro_manageRreviewModeExcel();
		pro2.setId("评议会日期：");
		pro2.setLoadSum("[2014]年第（"+1+"）次经理办公会");
		pro2.setGuaranteeMeasures("金额单位："+100+"万元");
		list1.add(pro2);
		pro_manageRreviewModeExcel pro=new pro_manageRreviewModeExcel();
		pro.setId("序号");
		pro.setIsPass("是否通过");
		pro.setCompanyType("中泽");
		pro.setBusiClass("业务类型");
		pro.setProjectName("项目名称");
		pro.setLoadSum("金额");
		pro.setFundChinese("资金来源");
		pro.setBankName("合作放款机构");
		pro.setGuarantyRate("担保费率/委贷利率");
		pro.setConsultCost("咨询费");
		pro.setReviewRate("评审费率");
		pro.setPeriodMonthDay("期限");
		pro.setGuaranteeMeasures("反担保措施（详）");
		pro.setAmanName("A角");
		pro.setBmanName("B角");
		list1.add(pro);
        List<pro_manageRreviewModeExcel> list = pro_delayMapper.manageReviewExport(" and pa.apply_ID='"+apply.getApply_ID()+"' ");
        list1.addAll(list);
        pro_manageRreviewModeExcel pro3=new pro_manageRreviewModeExcel();
        pro3.setId("制表人："+user.getUser_name()+"                      复核人：                                                               "+"分管副经理：                                   ");
//        pro3.setLoadSum("复核人：");
//        pro3.setGuaranteeMeasures("分管副经理：");
        list1.add(pro3);
        pro_manageRreviewModeExcel pro4=new pro_manageRreviewModeExcel();
        pro4.setId("经理："+"                                    制表日期："+DateUtil.dateStr(DateUtil.getNow(), DateUtil.DATE_PATTERN));
//        pro4.setGuaranteeMeasures("制表日期："+DateUtil.getNow());
        list1.add(pro4);
        pro_manageRreviewModeExcel pro5=new pro_manageRreviewModeExcel();
        pro5.setId("附：《项目调查报告》（原件）");
        list1.add(pro5);
		return list1;
	}
	
	
	@Override
	public List<pro_meetingExportModeExcel> packageMeetingExport(Pro_apply apply) {
		List<pro_meetingExportModeExcel> list1=new ArrayList<pro_meetingExportModeExcel>();
		pro_meetingExportModeExcel pro2=new pro_meetingExportModeExcel();
		pro2.setId("");
		pro2.setLoadSum("[2014]年第（"+1+"）次经理办公会");
		pro2.setGuaranteeMeasures("金额单位：万元    ");
		list1.add(pro2);
		pro_meetingExportModeExcel pro=new pro_meetingExportModeExcel();
		pro.setId("序号");
		pro.setFullAreaName("地区");
		pro.setOprationCompanyName("报送机构");
		pro.setGuarantyOrgName("承保机构");
		pro.setBusiClass("业务类型");
		pro.setProjectName("项目名称");
		pro.setLoadSum("金额");
		pro.setFundChinese("资金来源");
		pro.setBankName("合作放款机构");
		pro.setGuarantyRate("担保费率/委贷利率");
		pro.setConsultCost("咨询费");
		pro.setReviewRate("评审费率");
		pro.setPeriodMonthDay("期限");
		pro.setGuaranteeMeasures("反担保措施（详）");
		pro.setAmanName("A角");
		pro.setBmanName("B角");
		list1.add(pro);
        List<pro_meetingExportModeExcel> list = pro_delayMapper.meetingExport(" and pa.apply_ID='"+apply.getApply_ID()+"' ");
        list1.addAll(list);
        pro_meetingExportModeExcel pro3=new pro_meetingExportModeExcel();
        pro3.setId("本次推荐项目，综合业务部已尽职审核《项目调查报告》我部认为以上项目具备上会资格，提请项目专家评议会（大）审议。");
        list1.add(pro3);
        pro_meetingExportModeExcel pro4=new pro_meetingExportModeExcel();
        pro4.setId("说明：本表填列额度5000万元以上项目信息");
        list1.add(pro4);
        pro_meetingExportModeExcel pro5=new pro_meetingExportModeExcel();
        pro5.setId("综合业务部制表人："+SystemSession.getUserSession().getUser_name()+"                              综合业务部负责人："+"                                分管领导：");
        list1.add(pro5);
		return list1;
	}
	@Override
	public List<pro_reviewCommitteeModeExcel> packageCommitteeExport(Pro_apply apply) {
		List<pro_reviewCommitteeModeExcel> list1=new ArrayList<pro_reviewCommitteeModeExcel>();
		pro_reviewCommitteeModeExcel pro2=new pro_reviewCommitteeModeExcel();
		pro2.setId("");
		pro2.setLoadSum("[2014]年第（"+1+"）次经理办公会");
		pro2.setGuaranteeMeasures("金额单位：万元    ");
		list1.add(pro2);
		pro_reviewCommitteeModeExcel pro=new pro_reviewCommitteeModeExcel();
		pro.setId("序号");
		pro.setNatureName("中小微/集团");
		pro.setFullAreaName("地区");
		pro.setBusiClass("业务类型");
		pro.setProjectName("项目名称");
		pro.setLoadSum("金额");
		pro.setFundChinese("资金来源");
		pro.setBankName("合作放款机构");
		pro.setGuarantyRate("担保费率/委贷利率");
		pro.setReviewRate("评审费率");
		pro.setPeriodMonthDay("期限");
		pro.setGuaranteeMeasures("反担保措施（详）");
		pro.setAmanName("A角");
		pro.setBmanName("B角");
		pro.setReviewe("审核人员");
		pro.setGuaranteesLimit("在保担保额度");
		pro.setGuaranteesCommitteeLimit("在保委贷额度");
		pro.setNewLimit("该户新增后的额度");
		pro.setCapitalUSES("资金用途");
		list1.add(pro);
        List<pro_reviewCommitteeModeExcel> list = pro_delayMapper.committeeExport(" and pa.apply_ID='"+apply.getApply_ID()+"' ");
        list1.addAll(list);
        pro_reviewCommitteeModeExcel pro3=new pro_reviewCommitteeModeExcel();
        pro3.setId("风险管理部制表人：");
        pro3.setPeriodMonthDay("风险管理部核表人："+SystemSession.getUserSession().getUser_name());
        pro3.setCapitalUSES("风险管理部部长： ");
        list1.add(pro3);
        pro_reviewCommitteeModeExcel pro4=new pro_reviewCommitteeModeExcel();
        pro4.setId("说明：1、业务类型：担保/委贷；2、反担保措施：详细填列反担保措施；3、地区：填列地市名称；4、本表由风险管理部编制，填列3000万元（含）以下过会项目");
        list1.add(pro4);
        pro_reviewCommitteeModeExcel pro5=new pro_reviewCommitteeModeExcel();
        pro5.setId("风险总监签字：                                                                                                 "+"董事长签字：");
        list1.add(pro5);
		return list1;
	}
	
	private int[]  getMonthAndDay(Date fromDate,Date toDate) {
		Calendar  from  =  Calendar.getInstance();
	    from.setTime(fromDate);
	    Calendar  to  =  Calendar.getInstance();
	    to.setTime(toDate);
	    int fromYear = from.get(Calendar.YEAR);
	    int fromMonth = from.get(Calendar.MONTH);
	    int fromDay = from.get(Calendar.DAY_OF_MONTH);
	    int toYear = to.get(Calendar.YEAR);
	    int toMonth = to.get(Calendar.MONTH);
	    int toDay = to.get(Calendar.DAY_OF_MONTH);
	    int year = toYear  -  fromYear;
	    int day = toDay  - fromDay;
	    int month = year*12 + toMonth  - fromMonth;
	    if( day< 0){
	    	switch (toMonth) {
			case 0://一月
				day = 31 +day; //12月的天数加上负的天数
				break;

			default:
				Calendar cal = Calendar.getInstance(); 
		    	cal.set(Calendar.YEAR,toYear); 
		    	cal.set(Calendar.MONTH, toMonth-1);
		    	int dateOfMonth = cal.getActualMaximum(Calendar.DATE);
		    	day =dateOfMonth+day;
				break;
			}
	    	month = year*12 + toMonth  - fromMonth -1 ;
	    }
	   
	    int[] monthDay = new int[]{month,day};
	    return monthDay;
	}
	
	//通过期限年和月获取年月
	public String getMonthDayByMonthAndDay(Integer periodMonth,Integer periodDay){
			String periodMonthDay = "";
			if(periodMonth!=null && periodMonth != 0){
				periodMonthDay +=periodMonth+"个月";
			}
			if(periodDay!=null){	
				periodMonthDay +=periodDay+"天";					
			}
			return periodMonthDay.toString();
	}
	
}
