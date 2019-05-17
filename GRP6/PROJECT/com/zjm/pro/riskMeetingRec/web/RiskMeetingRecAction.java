package com.zjm.pro.riskMeetingRec.web;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.oa.db.model.Oa_meetingRoom;
import com.zjm.oa.meeting.service.MeetingRoomService;
import com.zjm.pro.db.map.Pro_projectfilesMapper;
import com.zjm.pro.db.model.Pro_riskMeetingRec;
import com.zjm.pro.db.model.Pro_riskScheme;
import com.zjm.pro.riskMeetingRec.serivce.RiskMeetingRecService;
import com.zjm.pro.suggest.service.ProjectSuggestService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/project/riskMeetingRec")
public class RiskMeetingRecAction {
	@Resource
	private RiskMeetingRecService riskMeetingRecService;
	@Resource
	private DicTypeService dicTypeService;
	@Resource
	private MeetingRoomService meetingRoomService;
	@Resource
	private Pro_projectfilesMapper pro_projectfilesMapper;
	@Resource
	private ProjectSuggestService projectSuggestService;
	 
	//初始化下拉框数据
		/*public void  initSelect(ModelAndView mv){
			//会议类型
			List<C_dictype> meetingTypeNameList = dicTypeService.selectAllDicTypeList(" and dicTypePID='fa6c711da2944bc4abc8f814adb4e0a6'");
			mv.getModelMap().put("meetingTypeNameList",meetingTypeNameList);		
			
		}*/
	/**
	 * @param 
	 * @return 安排会议
	 */
	@RequestMapping(value = "/riskMeeting")
	public ModelAndView selectCheckRegister() {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/riskResponse/meetingArrange/arrangeMeeting");
		return mv;
	}
	
	/**
	 * 查询待安排会议列表
	 */
	@RequestMapping(value="/selectAwaitingMeetingPageTables")
	@ResponseBody
	public AjaxRes selectAwaitingMeetingPageTables(@RequestBody PageTable<Pro_riskScheme> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		StringBuffer sb = new StringBuffer();
		sb.append(" and (isMeeting IS NULL OR isMeeting = 0)");
		sb.append(" and status = '审批中'");
		pageTable.setWheresql(queryConditionSql(pageTable)+sb.toString());
		pageTable = riskMeetingRecService.selectAwaitingMeetingPageTables(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}

	
	/**
	 * 待安排的分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Pro_riskScheme> pageTable){
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		if(pageTable==null){
			return "";
		}
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and (title like \'%"+pageTable.getSearchText().trim()+"%\'OR createUserName like \'%"+pageTable.getSearchText().trim()+"%\')");
		}
		return wheresql.toString();		
	}
	
	

    /**
     * 添加会议安排页面
     * @param riskMeetingRec_ID
     * @return
     */
	@RequestMapping(value = "/showRiskMeetingRecPage")
	public ModelAndView showRiskMeetingRecPage(String riskScheme_ID) {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try {
			 List<Oa_meetingRoom> rooms = meetingRoomService.list(new PageTable<>());
			List<Pro_riskScheme> riskSchemeList = riskMeetingRecService.selectRiskSchemeListByRiskScheme_ID(" and riskScheme_ID in ("+riskScheme_ID+")");
			
			List<C_dictype> meetingTypeNameList = dicTypeService.selectAllDicTypeList(" and dicTypePID='a139f3b270cd49ed9ca43de9a2a4ef04'");
			mv.getModelMap().put("meetingTypeNameList",meetingTypeNameList);	
			mv.getModelMap().put("rooms", rooms);
			mv.getModelMap().put("riskSchemeList", riskSchemeList);
			mv.getModelMap().put("riskScheme_ID", riskScheme_ID);
			mv.setViewName("/project/riskResponse/meetingArrange/meetingAdd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
  /**
   * 添加安排会议
   * @param riskMeetingRec
   * @return
   */
	@RequestMapping(value="/insertOneArrangeMeeting")
	@ResponseBody
	public AjaxRes insertOneArrangeMeeting(@RequestBody Pro_riskMeetingRec riskMeetingRec){
		AjaxRes ar = new AjaxRes();
		Boolean b =riskMeetingRecService.insertOneArrangeMeeting(SystemSession.getUserSession(), riskMeetingRec);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 查询已安排会议列表
	 */
	@RequestMapping(value="/selectAwaitedMeetingPageTables")
	@ResponseBody
	public AjaxRes selectAwaitedMeetingPageTables(@RequestBody PageTable<Pro_riskMeetingRec> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		/*StringBuffer sb = new StringBuffer();
		sb.append(" and isMeeting = 1");*/
		pageTable.setWheresql(queryConditionSql1(pageTable));
		pageTable = riskMeetingRecService.selectAwaitedMeetingPageTables(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}

	/**
	 * 已安排的分页列表查询条件
	 */
	private String queryConditionSql1(PageTable<Pro_riskMeetingRec> pageTable){
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		if(pageTable==null){
			return "";
		}
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and (meetingTypeName like \'%"+pageTable.getSearchText().trim()+"%\'OR meetingName like \'%"+pageTable.getSearchText().trim()+"%\')");
		}
		return wheresql.toString();		
	}

    /**
     * 
     * 查看已安排会议
     * @param riskMeetingRec_ID
     * @return
     */
	@RequestMapping(value = "/showAwaitedMeetingPage")
	public ModelAndView showAwaitedMeetingPage(String riskMeetingRec_ID) {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try {
			//根据条件查询一条已安排会议信息
			Pro_riskMeetingRec riskMeetingRec =riskMeetingRecService.selectOneAwaitedMeeting(" and riskMeetingRec_ID='"+riskMeetingRec_ID+"' ");
			mv.getModelMap().put("riskMeetingRec", riskMeetingRec);
			
			List<Pro_riskScheme> riskSchemeList = riskMeetingRecService.selectRiskSchemeList(" and prmr.`riskMeetingRec_ID` = '"+riskMeetingRec_ID+"'");
			
			List<Pro_riskScheme> newRiskSchemeList = new ArrayList<Pro_riskScheme>();
			if (riskSchemeList != null) {
				for (Pro_riskScheme riskScheme : riskSchemeList) {
					List fileList = new ArrayList<>();
					if(null !=riskScheme){
						PageTable pageTable=new PageTable<>();
						String sql= " and  fileType = '08' and entityID = '"+riskScheme.getRiskScheme_ID()+"'";
						pageTable.setWheresql(sql);
						fileList  = pro_projectfilesMapper.selectProjectFilesPageTables(pageTable);
					}
					riskScheme.setFilesList(fileList);
					newRiskSchemeList.add(riskScheme);
				}
			}
			mv.getModelMap().put("riskSchemeList", newRiskSchemeList);
			
			mv.setViewName("/project/riskResponse/meetingArrange/awaitedMeetingView");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mv;
	}
	
	
}
