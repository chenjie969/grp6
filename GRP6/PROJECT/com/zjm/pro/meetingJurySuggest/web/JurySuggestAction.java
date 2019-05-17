package com.zjm.pro.meetingJurySuggest.web;


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
import com.zjm.pro.meeting.service.MeetingService;
import com.zjm.pro.db.model.Pro_jurySuggest;
import com.zjm.pro.db.model.Pro_meeting;
import com.zjm.pro.db.model.Pro_meetingApply;
import com.zjm.pro.db.model.Pro_projectfiles;
import com.zjm.pro.meetingJury.service.MeetingJuryService;
import com.zjm.pro.meetingJurySuggest.service.JurySuggestService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/project/jurySuggest")
public class JurySuggestAction {
	
	@Resource
	private JurySuggestService jurySuggestService;
	@Resource
	private MeetingJuryService meetingJuryService;
	@Resource
	private MeetingService projectMeetingService;
	@Resource
	private DicTypeService dicTypeService;
	
	/**
	 * 显示评委表决模块 
	 */
	@RequestMapping(value="/showJurySuggestIndexPage")
	public ModelAndView showJurySuggestIndexPage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/project/meeting/jurySuggest/jurySuggest");
		return mv;
	}
	
	/**
	 * 显示未表决项目列表页面
	 */
	@RequestMapping(value="/showMeetingNotVotePage")
	public ModelAndView showMeetingNotVotePage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/project/meeting/jurySuggest/meetingNotVote");
		return mv;
	}
	
	/**
	 * 查询当前评委未完成表决的评审会列表
	 */
	@RequestMapping(value="/selectNotVoteMeetingPageTables")
	@ResponseBody
	public AjaxRes selectNotVoteMeetingPageTables(@RequestBody PageTable<Pro_meeting> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable = jurySuggestService.selectNotVoteMeetingPageTables(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 申请的分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Pro_meeting> pageTable){
		if(pageTable==null){
			return "";
		}
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and meetingCode like \'%"+pageTable.getSearchText().trim()+"%\'");	//搜索框查询评审会编号
		}
		return wheresql.toString();
	}
	
	/**
	 *  显示已表决项目列表页面
	 */
	@RequestMapping(value="/showMeetingHasVotedPage")
	public ModelAndView showMeetingHasVotedPage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/project/meeting/jurySuggest/meetingHasVoted");
		return mv;
	}
	
	/**
	 * 查询当前评委已完成表决的评审会列表
	 */
	@RequestMapping(value="/selectHasVotedMeetingPageTables")
	@ResponseBody
	public AjaxRes selectHasVotedMeetingPageTables(@RequestBody PageTable<Pro_meeting> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable = jurySuggestService.selectHasVotedMeetingPageTables(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 显示未表决评审会-分块页面
	 */
	@RequestMapping(value="/showNotVoteDIVPage")
	public ModelAndView showNotVoteDIVPage(PageTable<Pro_meeting> pageTable){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meeting/jurySuggest/meetingAllDiv");
		pageTable.setSortName("meetingDateTime");
		pageTable.setSortOrder("desc");
		pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable = jurySuggestService.selectNotVoteMeetingPageTables(pageTable);
		mv.getModelMap().put("pageTable",pageTable);
		mv.getModelMap().put("isVote", "false");
		return mv;
	}
	
	/**
	 * 显示已表决评审会-分块页面
	 */
	@RequestMapping(value="/showHasVotedDIVPage")
	public ModelAndView showHasVotedDIVPage(PageTable<Pro_meeting> pageTable){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meeting/jurySuggest/meetingAllDiv");
		pageTable.setSortName("meetingDateTime");
		pageTable.setSortOrder("desc");
		pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable = jurySuggestService.selectHasVotedMeetingPageTables(pageTable);
		mv.getModelMap().put("pageTable",pageTable);
		mv.getModelMap().put("isVote", "true");
		return mv;
	}
	
	/**
	 * 显示评审会信息-带评委表决结果
	 */
	@RequestMapping(value="/selectMeetingWithJurySuggest")
	public ModelAndView selectMeetingWithJurySuggest(String meeting_ID, String showBtn){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_meeting	pro_meeting = projectMeetingService.selectOneProjectMeeting(" and pm.meeting_ID = '"+meeting_ID+"'");
		List<Pro_jurySuggest> jurySuggestList = jurySuggestService.selectJurySuggestListByWheresql(" and meeting_ID = '"+meeting_ID+"' and userID = '"+SystemSession.getUserSession().getUser_uid()+"'");
		if(jurySuggestList!=null && jurySuggestList.size()>0){
			for (Pro_jurySuggest jurySuggest : jurySuggestList) {
				for (Pro_meetingApply meetingApply : pro_meeting.getMeetingApplyList()) {
					if(jurySuggest.getApply_ID().equals(meetingApply.getEntityID())){
						meetingApply.setJurySuggest(jurySuggest);
					}
				}
			}
		}
		mv.setViewName("/project/meeting/jurySuggest/meetingDetail");
		mv.getModelMap().put("meeting", pro_meeting);
		mv.getModelMap().put("showBtn", showBtn);
		mv.getModelMap().put("user", SystemSession.getUserSession());
		return mv;
	}
	
	/**
	 * 显示评委表决意见编辑页面
	 */
	@RequestMapping(value="/showJurySuggestEditPage")
	public ModelAndView showJurySuggestEditPage(Pro_jurySuggest jurySuggest){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meeting/jurySuggest/jurySuggestEdit");
		//判断评委意见ID是否存在
		String jurySuggest_ID = jurySuggest.getJurySuggest_ID();
		if(jurySuggest_ID==null || "".equals(jurySuggest_ID)){	
			jurySuggest = jurySuggestService.insertOneJurySuggest(SystemSession.getUserSession(), jurySuggest);	//不存在就新增一条评委意见记录
		}else{	
			jurySuggest = jurySuggestService.selectOneJurySuggestByWheresql(" and jurySuggest_ID='"+jurySuggest_ID+"'");	//存在就查出该评委意见
		}	
		mv.getModelMap().put("jurySuggest", jurySuggest);
		List<C_dictype> resolutionResultList = dicTypeService.selectAllDicTypeList(" and dicTypePID='0f85770c257f4a00acaccc419798731c'");//评审会决议结果下拉框
		mv.getModelMap().put("resolutionResultList",resolutionResultList);
		mv.getModelMap().put("projectfilesList",getAttachments(jurySuggest.getJurySuggest_ID()).getObj());
		return mv;
	}
	
	/**
	 * 显示评委表决意见查看页面
	 */
	@RequestMapping(value="/showJurySuggestViewPage")
	public ModelAndView showJurySuggestViewPage(String jurySuggest_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meeting/jurySuggest/jurySuggestView");
		Pro_jurySuggest jurySuggest = jurySuggestService.selectOneJurySuggestByWheresql(" and jurySuggest_ID='"+jurySuggest_ID+"'");	//存在就查出该评委意见
		mv.getModelMap().put("jurySuggest", jurySuggest);
		mv.getModelMap().put("projectfilesList",getAttachments(jurySuggest_ID).getObj());
		return mv;
	}
	
	/**
	 * 更新一条评委表决意见
	 */
	@RequestMapping(value="/updateOneJurySuggest")
	@ResponseBody
	public AjaxRes updateOneJurySuggest(@RequestBody Pro_jurySuggest jurySuggest){
		AjaxRes ar = new AjaxRes();
		Boolean b = jurySuggestService.updateOneJurySuggest(SystemSession.getUserSession(), jurySuggest);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 提交评委表决意见
	 */
	@RequestMapping(value="/submitJurySuggest")
	@ResponseBody
	public AjaxRes submitJurySuggest(@RequestBody Pro_jurySuggest jurySuggest){
		AjaxRes ar = new AjaxRes();
		Boolean b = jurySuggestService.submitJurySuggest(" and meeting_ID='"+jurySuggest.getMeeting_ID()+"' and userID='"+SystemSession.getUserSession().getUser_uid()+"'");
		ar.setSucceed(b);
		return ar;
	}
	
	/**
     * 根据评委表决ID获取关联的附件
     */
    @ResponseBody
    @RequestMapping(value = "/getAttachments")
    public AjaxRes getAttachments(String entityID) {
        List<Pro_projectfiles> listFiles = new ArrayList<Pro_projectfiles>();
        listFiles = jurySuggestService.getAttachments(entityID);
        AjaxRes ar = new AjaxRes();
        ar.setSucceed(listFiles);
        return ar;
    }
}
