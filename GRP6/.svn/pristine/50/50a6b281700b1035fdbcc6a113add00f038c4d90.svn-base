package com.zjm.pro.meetResolution.web;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.UrlParam;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.applyDetail.service.ApplyDetailService;
import com.zjm.pro.db.map.Pro_meetingApplyMapper;
import com.zjm.pro.db.map.Pro_meetingMapper;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_applyDetail;
import com.zjm.pro.db.model.Pro_countOfVotes;
import com.zjm.pro.db.model.Pro_jurySuggest;
import com.zjm.pro.db.model.Pro_meeting;
import com.zjm.pro.db.model.Pro_meetingApply;
import com.zjm.pro.db.model.Pro_meetingCost;
import com.zjm.pro.db.model.Pro_meetingDetail;
import com.zjm.pro.db.model.Pro_meetingJury;
import com.zjm.pro.db.model.Pro_meetingResolution;
import com.zjm.pro.db.model.Pro_suggest;
import com.zjm.pro.meetDetail.service.MeetingDetailService;
import com.zjm.pro.meetResolution.service.MeetingResolutionService;
import com.zjm.pro.meeting.service.MeetingService;
import com.zjm.pro.meetingApply.service.MeetingApplyService;
import com.zjm.pro.meetingCost.service.MeetingCostService;
import com.zjm.pro.meetingJury.service.MeetingJuryService;
import com.zjm.pro.meetingJurySuggest.service.JurySuggestService;
import com.zjm.pro.suggest.service.ProjectSuggestService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.sys.util.RolesDataAccreditUtil;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

@Controller
@RequestMapping(value="/pro/meetResolution/meetingResolution")
public class MeetingResolutionAction {

	@Resource
	private MeetingResolutionService meetingResolutionService;
	@Resource
	private MeetingDetailService meetingDetailService;
	@Resource
	private Pro_meetingMapper pro_meetingMapper;
	@Resource
	private Pro_meetingApplyMapper pro_meetingApplyMapper;
	
	@Resource
	private ProjectApplyService projectApplyService;
	
	@Resource
	private ApplyDetailService applyDetailService;
	
	@Resource
	private ProjectSuggestService projectSuggestService;
	
	@Resource
	private MeetingCostService meetingCostService;
	@Resource
	private DicTypeService dicTypeService;
	
	@Resource
	private MeetingApplyService meetingApplyService;
	@Resource
	private MeetingService projectMeetingService;
	@Resource
	private MeetingJuryService meetingJuryService;
	@Resource
	private JurySuggestService jurySuggestService;
	
	
	
	//初始化下拉框数据
	public void  initSelect(ModelAndView mv){
		
		List<C_dictype> resolutionResultList = dicTypeService.selectAllDicTypeList(" and dicTypePID='0f85770c257f4a00acaccc419798731c'");//评审会决议结果下拉框
		mv.getModelMap().put("resolutionResultList",resolutionResultList);		
		List<C_dictype> controlTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='e5265aaf696e4de2961ded8b358ed8b1'");//保后监管周期下拉框
		mv.getModelMap().put("controlTypeList",controlTypeList);
//		List<Pro_meetingJury> meetingJuryList = meetingJuryService.selectMeetingJuryListByWheresql(" and juryStatus = '01'");//获取评委列表
//		mv.getModelMap().put("meetingJuryList",meetingJuryList);	
	}
	
	//初始化下拉框数据
	@RequestMapping(value="/selectMeetingJuryList")
	@ResponseBody
	public AjaxRes  selectMeetingJuryList(){
		AjaxRes ar = new AjaxRes();
		try {
			List<Map<String, Object>> mapList  = new ArrayList<Map<String,Object>>();
			Map<String,Object> map =new HashMap<String,Object>();
			List<Pro_meetingJury> list=meetingJuryService.selectMeetingJuryListByWheresql(" and juryStatus = '01'");
			
			for (Pro_meetingJury meetingJury : list) {
				map =new HashMap<String,Object>();
				map.put("id", meetingJury.getUserUid());
				map.put("name", meetingJury.getUserName());
				mapList.add(map);
			}
			ar.setSucceed(mapList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	/**
	 * 添加评审会决议
	 * 
	 * 
	 */
		@RequestMapping(value="/insertOneMeetingResolution")
		@ResponseBody
		public AjaxRes insertOneMeetingResolution(@RequestBody Pro_meetingResolution meetResolution){
			AjaxRes ar = new AjaxRes();
			try {
				meetResolution.setMeetingResolution_ID(Tool.createUUID32());
				ar.setSucceed(meetingResolutionService.insertOneMeetingResolution(SystemSession.getUserSession(), meetResolution));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ar;
		}
		/**
		 * 查看评审会决议--任务事项
		 */
		@RequestMapping(value="/selectOneResolution")
		public ModelAndView selectOneResolution(UrlParam urlParam){
			String apply_ID = null;
			if (urlParam != null && "01".equals(urlParam.getEntityType())){
				apply_ID = urlParam.getEntityID();
			}
			ModelAndView mv = insertIfNotExist(apply_ID);
			mv.getModelMap().put("urlParam", urlParam);
			mv.setViewName("/project/meetResolution/meetingResolution/meetingResolution");
			return mv;
		}
		
		/**
		 * 查看评审会决议时的操作
		 */
		private ModelAndView insertIfNotExist(String apply_ID){
			ModelAndView mv = CustomDispatchServlet.getModeAndView();
			try{
				String whereSql = "and apply_ID = '"+apply_ID+"'";
				// 考虑到有些项目不需要上会, 评审会决议表信息会在项目刚申请的时候就插入一条, 所以此处meetingResolution一定能查出一条
				Pro_meetingResolution meetingResolution = meetingResolutionService.selectOneResolutionByWhereSql(whereSql);
				Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(whereSql);
				if(meetingResolution.getUserIDList()==null){
					Pro_meetingApply meetingApply = meetingApplyService.selectOneMeetingApplyByWhereSql(" and entityType = '01' and entityID ='"+apply_ID+"'");
					if (meetingApply != null) {
						meetingResolution.setUserIDList(meetingApply.getUserIDList());
						meetingResolution.setUserNameList(meetingApply.getUserNameList());
						Pro_meeting meeting = pro_meetingMapper.selectOneMeetingByWhereSql(" and meeting_ID ='"+meetingApply.getMeeting_ID()+"'");
						if(meeting != null){
							meetingResolution.setMeeting_ID(meeting.getMeeting_ID());
							meetingResolution.setMeetingCode(meeting.getMeetingCode());
							meetingResolution.setMeetingDate(meeting.getMeetingDateTime());
							meetingResolution.setOtherUserNameList(meeting.getOtherUserNameList());
						}
						meetingResolutionService.updateMeetingResolution(SystemSession.getUserSession(), meetingResolution);
					}
				}

				List<Pro_meetingDetail> meetingDetailList = meetingDetailService.selectMeetingDetailListByWhereSql(" and meetingResolution_ID='"+meetingResolution.getMeetingResolution_ID()+"'");
				mv.getModelMap().put("meetingDetailList",meetingDetailList);
				mv.getModelMap().put("apply",apply);
				mv.getModelMap().put("meetingResolution",meetingResolution);
			}catch (Exception e) {
				e.printStackTrace();
			}
			return mv;
		}
		
		/**
		 * 手机---查看评审会决议
		 */
		@RequestMapping(value="/selectOneResolutionAPP")
		@ResponseBody
		public AjaxRes selectOneResolutionAPP(@RequestBody  UrlParam urlParam){
			AjaxRes ar = new AjaxRes();
			List<Object> resolutionList = new ArrayList<>();
			try {
				ModelAndView mv = insertIfNotExist(urlParam.getEntityID());
				Pro_apply apply = (Pro_apply) mv.getModelMap().get("apply");
				Pro_meetingResolution meetingResolution = (Pro_meetingResolution) mv.getModelMap().get("meetingResolution");
				List<Pro_meetingDetail> meetingDetailList = (List<Pro_meetingDetail>) mv.getModelMap().get("meetingDetailList");
				meetingResolution.setMeetingDetailList(meetingDetailList);
				resolutionList.add(apply);
				resolutionList.add(meetingResolution);
				resolutionList.add(urlParam);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ar.setSucceed(resolutionList);
			return ar;
		}
		

	/**
	 * 跳转到修改决议内容页面
	 * @param业务ID meetingResolution_ID
	 * @return
	 */
	@RequestMapping(value="/returnMeetingResolutionPage")
	public ModelAndView returnMeetingResolutionPage(String meetingResolution_ID,String flag){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try{
			String whereSql = " and meetingResolution_ID = \'"+meetingResolution_ID+"\'";
			Pro_meetingResolution  meetingResolution = meetingResolutionService.selectOneResolutionByWhereSql(whereSql);
			mv.getModelMap().put("meetingResolution",meetingResolution);
			initSelect(mv);
			// flag=1修改评审基本信息
			if ("1".equals(flag)) {
				mv.setViewName("/project/meetResolution/meetingResolution/reviewInfo/reviewInfoEdit");
			} else {
				// flag=2修改评审信息
				mv.setViewName("/project/meetResolution/meetingResolution/resolutionContent/resolutionContentEdit");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return mv;		
	}

	/**
	 * updateMeetingResolution
	 * 更新决议内容
	 * 
	 */
	@RequestMapping(value="/updateMeetingResolution", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateMeetingResolution(@RequestBody Pro_meetingResolution meetingResolution){
		Boolean b = true;	
		if(meetingResolution  != null){
           try{	
        	   if (meetingResolution.getMeetingResolution_ID() != null && !"".equals(meetingResolution.getMeetingResolution_ID())){
        		   b = meetingResolutionService.updateMeetingResolution(SystemSession.getUserSession(), meetingResolution);
        	   } else {
        		   b = meetingResolutionService.insertOneMeetingResolution(SystemSession.getUserSession(), meetingResolution);
        	   }
			
		}catch (Exception e) {
			e.printStackTrace();
		}
           }		
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	
	/**进入评审会决议  页面
	 * @return
	 * entityID,apply_ID 为pro_apply的主键apply_ID
	 * entityType为gbpm_productNode的nodeID（节点ID）；productInstanceID的主键
	 * gbpm_dic_taskmanager的taskName   taskID
	 * gbpm_runNode的runNode_ID（nodeID）  
	 * client_ID,clientTypeID   crm_client
	 */
	@RequestMapping(value="/showMeetingResolutionPage")
	public ModelAndView showMeetingResolutionPage(String entityID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		
		try {
			Pro_apply pro_apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+entityID+"'");
			List<Pro_suggest> suggestList = projectSuggestService.selectSuggestListByWhereSql(" and entityID='"+entityID+"'");
			Pro_meetingResolution meetingResolution = meetingResolutionService.selectOneResolutionByWhereSql(" and apply_ID='"+entityID+"'");
			Pro_meetingApply oneMeetingApply = meetingApplyService.selectOneMeetingApplyByWhereSql(" and entityID ='"+entityID+"'");
			if(null != oneMeetingApply){
				Pro_meeting oneMeeting = projectMeetingService.selectOneMeetingByWhereSql(" and meeting_ID =\'"+oneMeetingApply.getMeeting_ID()+"\'");
				mv.getModelMap().put("meeting",oneMeeting);		
			}
			if(null ==meetingResolution){
				Pro_meetingResolution newMeetingResolution  = new Pro_meetingResolution();
				newMeetingResolution.setMeetingResolution_ID(Tool.createUUID32());
				newMeetingResolution.setApply_ID(entityID);
				meetingResolutionService.insertOneMeetingResolution(SystemSession.getUserSession(), newMeetingResolution);
				mv.getModelMap().put("meetingResolution",newMeetingResolution);
			}else{
				mv.getModelMap().put("meetingResolution",meetingResolution);
			}
			
			mv.getModelMap().put("pro_apply", pro_apply);
			mv.getModelMap().put("suggestList", suggestList);
			mv.setViewName("/project/meetResolution/meetingResolution");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	/**进入评委在线表决  页面
	 * @return
	 */
	@RequestMapping(value="/showJuryOnlineVotePage")
	public ModelAndView showJuryOnlineVotePage(String applyID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meetResolution/juryOnlineVote");
		return mv;
	}
	
	
	
	/**
	 * 分页查询节点列表
	 */
	@RequestMapping(value="/selectMeetingResolutionByApplyIDPageTable")
	@ResponseBody
	public AjaxRes selectMeetingResolutionByApplyIDPageTable(@RequestBody PageTable<Pro_meetingResolution> pageTable,@RequestParam String applyID){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryConditionSql(pageTable,applyID));
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		try {
			pageTable = meetingResolutionService.selectMeetingResolutionByApplyIDPageTable(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 分页查询节点列表
	 */
	@RequestMapping(value="/selectMeetResoByApplyIDPageTable")
	@ResponseBody
	public AjaxRes selectMeetResoByApplyIDPageTable(){
		AjaxRes ar = new AjaxRes();
		PageTable<Pro_meetingResolution> pageTable = new PageTable<Pro_meetingResolution>();
		List<Pro_meetingResolution> meetList = new ArrayList<Pro_meetingResolution>();
		Pro_meetingResolution meets = new Pro_meetingResolution();
		
		meetList.add(meets);
		pageTable.setRows(meetList);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Pro_meetingResolution> pageTable,String apply_ID){
		if(pageTable==null){
			return "";
		}
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		if (apply_ID!=null && !"".equals(apply_ID)) {
			wheresql.append(" and apply_ID like \'%"+apply_ID+"%\'");
		}
		if(pageTable.getSortName()!=null && !pageTable.getSortName().equals("") && pageTable.getSortOrder()!=null && !pageTable.getSortOrder().equals("")){
				wheresql.append(" order by "+pageTable.getSortName().trim()+"  " +pageTable.getSortOrder()+"");
		}else{
			wheresql.append(" ORDER BY updateDateTime DESC ");
		}
		return wheresql.toString();
	}
	
	/**显示添加页面
	 * @return
	 */
	@RequestMapping(value="/showMeetResolutionAddPage")
	public ModelAndView showMeetResolutionAddPage(String apply_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		
		List<Pro_meeting> meetingList= new ArrayList<Pro_meeting>();
        
        List<Pro_meetingApply> meetApplyList = pro_meetingApplyMapper.selectMeetingIDByApplyID(apply_ID);
        
        for (Pro_meetingApply meetApply : meetApplyList) {
			String meeting_ID = meetApply.getMeeting_ID();
			Pro_meeting meeting = pro_meetingMapper.showOneEvaluItemsViewPage(meeting_ID);
			meetingList.add(meeting);
		}
        mv.getModelMap().put("applyID", apply_ID);
		mv.getModelMap().put("meetingList", meetingList);
		mv.setViewName("/project/meetResolution/meetResolutionAddModal");
		return mv;
	}
	/**显示添加页面11111111111
	 * @return
	 */
	@RequestMapping(value="/showMeetingResoAddPage")
	public ModelAndView showMeetingResoAddPage(String applyID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meetResolution/addMeetResoModal");
		return mv;
	}
	/**显示--查看页面
	 * @return
	 */
	@RequestMapping(value="/showMeetingResolutionViewPage")
	public ModelAndView showMeetingResolutionViewPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meetResolution/meetingResolutionView");
		return mv;
	}
	
	
	/*@RequestMapping(value="/isExistNodeNames")
	@ResponseBody
	public AjaxRes isExistNodeNames(@RequestBody Gbpm_dicNode dicNode){
		AjaxRes ar = new AjaxRes();
		dicNode.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		try {
			ar.setSucceed(dicNodeService.isExistDicNodeNames(dicNode));
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		return ar;
	}*/
	
	
	//评委在线表决
	@RequestMapping(value="/selectJuryOnlineVotePageTable")
	@ResponseBody
	public AjaxRes selectJuryOnlineVotePageTable(){
		AjaxRes ar = new AjaxRes();
		PageTable<Pro_meetingResolution> pageTable = new PageTable<Pro_meetingResolution>();
		List<Pro_meetingResolution> meetList = new ArrayList<Pro_meetingResolution>();
		Pro_meetingResolution meets = new Pro_meetingResolution();
		
		meetList.add(meets);
		pageTable.setRows(meetList);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	
	
	/**显示添加评委在线表决页面
	 * @return
	 */
	@RequestMapping(value="/showJuryOnlineVoteAddPage")
	public ModelAndView showJuryOnlineVoteAddPage(String applyID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meetResolution/juryVoteAddModal");
		return mv;
	}
	/**显示--查看页面
	 * @return
	 */
	@RequestMapping(value="/showJuryOnlineVoteViewPage")
	public ModelAndView showJuryOnlineVoteViewPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meetResolution/juryOnlineVoteView");
		return mv;
	}
	

	/**
	 * 显示页面 :编辑批准担保情况
	 */
	@RequestMapping(value="/showApproveGuaranteeEditPage")
	public ModelAndView showApproveGuaranteeEditPage(Pro_applyDetail applyDetail){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		applyDetail = applyDetailService.selectApplyDetailList(" and applyDetail_ID='"+applyDetail.getApplyDetail_ID()+"'").get(0);
		mv.getModelMap().put("applyDetail", applyDetail);
		mv.setViewName("/project/meetResolution/approveGuaranteeEdit");
		return mv;
	}
	
	/**
	 * 执行操作 :修改批准担保情况
	 */
	@RequestMapping(value="/updateOneProApplyDetail")
	@ResponseBody
	public AjaxRes updateOneApproveGuarantee(@RequestBody Pro_applyDetail applyDetail){
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(applyDetailService.updateOneApproveGuarantee(applyDetail));
		return ar;
	}
	
	/**
	 * 查询评审会批准收费标准列表 
	 */
	@RequestMapping(value="/selectMeetingCostPageTable")
	@ResponseBody
	public AjaxRes selectMeetingCostPageTable(@RequestBody PageTable<Pro_meetingCost> pageTable){
		AjaxRes ar = new AjaxRes();
		List<Pro_meetingCost> meetingCostList = meetingCostService.selectMeetingCostList(" and applyID = '"+pageTable.getQueryCondition().getApply_ID()+"'");
		pageTable.setRows(meetingCostList);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 执行操作:新增评审会批准收费标准
	 */
	@RequestMapping(value="/insertMeetingCostList")
	@ResponseBody
	public AjaxRes insertMeetingCostList(@RequestBody Pro_meetingCost meetingCost){
		AjaxRes ar = new AjaxRes();
		Boolean b = meetingCostService.insertMeetingCostList(SystemSession.getUserSession(), meetingCost);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 显示页面:评审会批准收费标准修改页面
	 */
	@RequestMapping(value="/showMeetingCostEditPage")
	public ModelAndView showMeetingCostEditPage(Pro_meetingCost meetingCost){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meetResolution/meetingCostEdit");
		mv.getModelMap().put("meetingCost", meetingCostService.selectOneMeetingCost(meetingCost));
		return mv;
	}
	
	/**
	 * 执行操作:修改评审会批准收费标准备注
	 */
	@RequestMapping(value="/updateOneMeetingCostRemark")
	@ResponseBody
	public AjaxRes updateOneMeetingCostRemark(@RequestBody Pro_meetingCost meetingCost){
		AjaxRes ar = new AjaxRes();
		Boolean b = meetingCostService.updateOneMeetingCostRemark(SystemSession.getUserSession(), meetingCost);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 显示页面:评审会批准收费标准删除页面
	 */
	@RequestMapping(value="/showMeetingCostDelPage")
	public ModelAndView showMeetingCostDelPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meetResolution/meetingCostDel");
		return mv;
	}
	
	/**
	 * 执行操作:删除评审会批准收费标准
	 */
	@RequestMapping(value="/deleteOneMeetingCost")
	@ResponseBody
	public AjaxRes deleteOneMeetingCost(@RequestBody Pro_meetingCost meetingCost){
		AjaxRes ar = new AjaxRes();
		Boolean b = meetingCostService.deleteOneMeetingCost(SystemSession.getUserSession(), meetingCost.getMeetingCost_ID());
		ar.setSucceed(b);
		return ar;
	}
	
	
	/**
	 * 跳转到修改参会委员页面
	 * @param业务ID meeting_ID
	 * @return
	 */
	@RequestMapping(value="/returnMeetingUserName")
	public ModelAndView returnMeetingUserName(String meeting_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_meeting  meeting = new Pro_meeting();
		if(null != meeting_ID && !"".equals(meeting_ID)){			
			String whereSql = " and meeting_ID = \'"+meeting_ID+"\'";
			meeting = projectMeetingService.selectOneMeetingByWhereSql(whereSql);
		}
		mv.getModelMap().put("meeting",meeting);
		mv.setViewName("/project/meetResolution/meetingResolutionEdit2");
		return mv;		
	}
	/**
	 * updateMeetingResolution
	 * 更新决议内容
	 * 
	 */
	@RequestMapping(value="/updateMeetingUserName", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateMeetingUserName(@RequestBody Pro_meeting meeting){
		Boolean b = true;	
		if(meeting  != null){		
			b = projectMeetingService.updateMeetingUserName(SystemSession.getUserSession(), meeting);
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	
	/*************************xuyz 评审会表决菜单模块  重做  2017/10***********************************************************/
	/**
	 * 显示评审会决议模块 
	 */
	@RequestMapping(value="/showMeetingResultIndexPage")
	public ModelAndView showMeetingResultIndexPage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/project/meeting/meetingResult/meetingResult");
		return mv;
	}
	
	/**
	 * 显示未录入决议评审会列表页面
	 */
	@RequestMapping(value="/showMeetingNotInputPage")
	public ModelAndView showMeetingNotInputPage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/project/meeting/meetingResult/meetingNotInput");
		return mv;
	}
	
	/**
	 * 查询未录入决议的评审会列表(未上会)
	 */
	@RequestMapping(value="/selectNotInputMeetingPageTables")
	@ResponseBody
	public AjaxRes selectNotInputMeetingPageTables(@RequestBody PageTable<Pro_meeting> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(" and unit_uid='"+SystemSession.getUserSession().getUnit_uid()+"' and meetingStatus='01'");
		//根据a角所拥有的数据权限查询
		String wheresql = RolesDataAccreditUtil.appendProSqlByRole(SystemSession.getUserSession().getUser_uid(), RolesDataAccreditUtil.PRO_AMAN_SQL_STR, "a_role_data.");
		if( null != wheresql){
			pageTable.setWheresql(pageTable.getWheresql()+" "+wheresql);
		}
		pageTable = projectMeetingService.selectProMeetingPageTables(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 *  显示已录入决议评审会列表页面
	 */
	@RequestMapping(value="/showMeetingHasInputedPage")
	public ModelAndView showMeetingHasInputedPage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/project/meeting/meetingResult/meetingHasInputed");
		return mv;
	}
	
	/**
	 * 查询已录入决议的评审会列表(已上会)
	 */
	@RequestMapping(value="/selectHasInputedMeetingPageTables")
	@ResponseBody
	public AjaxRes selectHasInputedMeetingPageTables(@RequestBody PageTable<Pro_meeting> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(" and unit_uid='"+SystemSession.getUserSession().getUnit_uid()+"' and meetingStatus='02'");
		//根据a角所拥有的数据权限查询
		String wheresql = RolesDataAccreditUtil.appendProSqlByRole(SystemSession.getUserSession().getUser_uid(), RolesDataAccreditUtil.PRO_AMAN_SQL_STR, "a_role_data.");
		if( null != wheresql){
			pageTable.setWheresql(pageTable.getWheresql()+" "+wheresql);
		}
		pageTable = projectMeetingService.selectProMeetingPageTables(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 显示未录入决议评审会-分块页面
	 */
	@RequestMapping(value="/showNotInputDIVPage")
	public ModelAndView showMeetingDIVPage(PageTable<Pro_meeting> pageTable){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meeting/meetingResult/meetingAllDiv");
		pageTable.setSortName("meetingDateTime");
		pageTable.setSortOrder("desc");
		pageTable.setWheresql(" and unit_uid='"+SystemSession.getUserSession().getUnit_uid()+"' and meetingStatus='01'");
		//根据a角所拥有的数据权限查询
		String wheresql = RolesDataAccreditUtil.appendProSqlByRole(SystemSession.getUserSession().getUser_uid(), RolesDataAccreditUtil.PRO_AMAN_SQL_STR, "a_role_data.");
		if( null != wheresql){
			pageTable.setWheresql(pageTable.getWheresql()+" "+wheresql);
		}
		pageTable = projectMeetingService.selectProMeetingPageTables(pageTable);
		mv.getModelMap().put("pageTable",pageTable);
		mv.getModelMap().put("isInput", "false");
		return mv;
	}
	
	/**
	 * 显示已录入决议评审会-分块页面
	 */
	@RequestMapping(value="/showHasInputedDIVPage")
	public ModelAndView showHasInputedDIVPage(PageTable<Pro_meeting> pageTable){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meeting/meetingResult/meetingAllDiv");
		pageTable.setSortName("meetingDateTime");
		pageTable.setSortOrder("desc");
		pageTable.setWheresql(" and unit_uid='"+SystemSession.getUserSession().getUnit_uid()+"' and meetingStatus='02'");
		//根据a角所拥有的数据权限查询
		String wheresql = RolesDataAccreditUtil.appendProSqlByRole(SystemSession.getUserSession().getUser_uid(), RolesDataAccreditUtil.PRO_AMAN_SQL_STR, "a_role_data.");
		if( null != wheresql){
			pageTable.setWheresql(pageTable.getWheresql()+" "+wheresql);
		}
		pageTable = projectMeetingService.selectProMeetingPageTables(pageTable);
		mv.getModelMap().put("pageTable",pageTable);
		mv.getModelMap().put("isInput", "true");
		return mv;
	}
	
	/**
	 * 显示评审会信息-带评委表决汇总结果
	 */
	@RequestMapping(value="/selectMeetingWithVoteResult")
	public ModelAndView selectMeetingWithVoteResult(String meeting_ID, String showBtn){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meeting/meetingResult/meetingDetail");
		Pro_meeting	pro_meeting = projectMeetingService.selectOneProjectMeeting(" and pm.meeting_ID = '"+meeting_ID+"'");
		List<Pro_countOfVotes> voteList = jurySuggestService.countOfJuryVotes(" and meeting_ID = '"+meeting_ID+"'");
		List<C_dictype> resolutionResultList = dicTypeService.selectAllDicTypeList(" and dicTypePID='0f85770c257f4a00acaccc419798731c'");
		
		// 统计各个项目的评委表决结果
		for (Pro_meetingApply meetingApply : pro_meeting.getMeetingApplyList()) {
			Map<String,Object> map = new HashMap<>();
			for (Pro_countOfVotes countOfVotes : voteList) {
				if(meetingApply.getEntityID().equals(countOfVotes.getApply_ID())){
					map.put(countOfVotes.getSuggestResultID(), countOfVotes.getVotesNum());
				}
			}
			String str = "";
			for (C_dictype dictype : resolutionResultList) {
				Object tmp = map.get(dictype.getDicTypeID());
				if(tmp == null){
					str += dictype.getDicTypeName()+"0"+"；";
				}else{
					str += dictype.getDicTypeName()+map.get(dictype.getDicTypeID())+"；";
				}
			}
			meetingApply.setVoteResult(str);
		}
		
		mv.getModelMap().put("meeting", pro_meeting);
		mv.getModelMap().put("showBtn", showBtn);
		return mv;
	}
	
	/**
	 * 显示各个评委表决结果
	 */
	@RequestMapping(value="/showJurySuggestsViewPage")
	public ModelAndView showJurySuggestsViewPage(String apply_ID, String meeting_ID){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/project/meeting/meetingResult/jurySuggestsView");
		List<Pro_jurySuggest> jurySuggestList = jurySuggestService.selectJurySuggestListByWheresql(" and apply_ID='"+apply_ID+"' and meeting_ID='"+meeting_ID+"'");
		mv.getModelMap().put("jurySuggestList", jurySuggestList);
		Pro_meetingApply meetingApply = meetingApplyService.selectOneMeetingApplyByWhereSql(" and entityID='"+apply_ID+"' and meeting_ID='"+meeting_ID+"'");
		mv.getModelMap().put("userNameList",meetingApply.getUserNameList().split(","));
		return mv;
	}
	
	/**
	 * 查看评审会决议--菜单模块
	 */
	@RequestMapping(value="/openMeeingResolution")
	public ModelAndView openMeeingResolution(String apply_ID, String type ,String comming){
		ModelAndView mv = insertIfNotExist(apply_ID);
		mv.getModelMap().put("type", type);
		if( null != comming && !"".equals(comming)){
			mv.setViewName("/project/meeting/meetingResult/meetingResolution2");
		} else {
			mv.setViewName("/project/meeting/meetingResult/meetingResolution");
		}
		return mv;
	}
	
	/**
	 * 提交评审会决议, 把评审会及相关项目的状态修改为已上会
	 */
	@RequestMapping(value="/changeMeeingStatus")
	@ResponseBody
	public AjaxRes changeMeeingStatus(@RequestBody String meeting_ID){
		// 修改评审会的上会状态
		Pro_meeting meeting = new Pro_meeting();
		meeting.setMeeting_ID(meeting_ID);
		meeting.setMeetingStatus("02");
		Boolean b1 = projectMeetingService.updateMeetingStatus(meeting);
		// 修改评审会项目的上会状态
		meeting = projectMeetingService.selectOneProjectMeeting(" and pm.meeting_ID='"+meeting_ID+"'");
		List<Pro_meetingApply> meetingApplyList = meeting.getMeetingApplyList();
		String tmp = "";
		for (Pro_meetingApply pro_meetingApply : meetingApplyList) {
			tmp += pro_meetingApply.getEntityID()+",";
		}
		tmp = tmp.substring(0, tmp.length()-1);
		Pro_apply apply = new Pro_apply();
		apply.setMeetingApplyIDs(tmp);
		Boolean b2 = projectApplyService.setMeetingStatusArranging(apply,"已上会");
		
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(b1&b2);
		return ar;
	}
	
	
	/*************************xuyz 评审会表决菜单模块  重做  2017/10***********************************************************/
	
}
