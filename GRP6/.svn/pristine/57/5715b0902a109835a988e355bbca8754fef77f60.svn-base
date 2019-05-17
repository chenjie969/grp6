package com.zjm.pro.meetingArrange.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.map.Pro_meetingMapper;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_meeting;
import com.zjm.pro.meeting.service.MeetingService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.sys.util.RolesDataAccreditUtil;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/project/meetingArrange")
public class MeetingArrangeAction {
	
	@Resource
	private ProjectApplyService projectApplyService;
	@Resource
	private MeetingService projectMeetingService;
	@Resource
	private DicTypeService dicTypeService;
	@Resource
	private Pro_meetingMapper pro_meetingMapper;
	/**
	 * 显示待安排上会申请页面 
	 */
	@RequestMapping(value="/showMeetingArrangePage")
	public ModelAndView showMeetingArrangePage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meeting/meetingArrange/meetingArrange");
		return mv;
	}
	
	/**
	 * 显示已安排上会申请记录页面 
	 */
	@RequestMapping(value="/showMeetingArrangeRecordPage")
	public ModelAndView showMeetingArrangeRecordPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meeting/meetingArrange/meetingArrangeRecord");
		return mv;
	}
	
	/**
	 * 查询待安排上会的项目申请
	 */
	@RequestMapping(value="/selectWaitingArrangeApplyPageTables")
	@ResponseBody
	public AjaxRes selectWaitingArrangeApplyPageTables(@RequestBody PageTable<Pro_apply> pageTable){
		AjaxRes ar = new AjaxRes();
		User user = SystemSession.getUserSession();
		pageTable.getQueryCondition().setUser_uid(user.getUser_uid());//设置用户id通过匹配用户权限来查询
		StringBuffer sb = new StringBuffer();
		sb.append(" and unit_uid='"+user.getUnit_uid()+"'");
		sb.append(" and isMeeting = 1");
		sb.append(" and meetingStatus = '待安排'");
		pageTable.setWheresql(queryConditionSql(pageTable)+sb.toString());
		pageTable = projectApplyService.selectApplyPageTables(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}

	/**
	 * 申请的分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Pro_apply> pageTable){
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		if(pageTable==null){
			return "";
		}
		//根据a角权限及其数据权限查看
		if(null != pageTable.getQueryCondition().getUser_uid() && !"".equals(pageTable.getQueryCondition().getUser_uid())){
			String sql = RolesDataAccreditUtil.appendProSqlByRole(pageTable.getQueryCondition().getUser_uid(), RolesDataAccreditUtil.PRO_AMAN_SQL_STR, "");
			if( null != sql){
				wheresql.append(sql);
			}
		}
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and projectName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		return wheresql.toString();		
	}
	
	/**
	 * 显示安排上会页面
	 */
	@RequestMapping(value="/showMeetingApplyAddPage")
	public ModelAndView showMeetingApplyAddPage(String applyIDList){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meeting/meetingApply/meetingApplyAdd");
		mv.getModelMap().put("applyIDList", applyIDList);
		return mv;
	}
	
	/**
	 * 新增一条评审会信息
	 */
	@RequestMapping(value="/insertOneMeeting")
	@ResponseBody
	public AjaxRes insertOneMeeting(@RequestBody Pro_meeting proMeeting){
		AjaxRes ar = new AjaxRes();
		Boolean result = projectMeetingService.insertOneMeeting(SystemSession.getUserSession(), proMeeting);
		ar.setSucceed(result);
		return ar;
	}
	
	/**
	 * 分页查询已安排的评审会列表(包括已上会和未上会)
	 */
	@RequestMapping(value="/selectProMeetingPageTables")
	@ResponseBody
	public AjaxRes selectProMeetingPageTables(@RequestBody PageTable<Pro_meeting> pageTable){
		AjaxRes ar = new AjaxRes();
		//根据a角添加sql
		String wheresql = RolesDataAccreditUtil.appendProSqlByRole(SystemSession.getUserSession().getUser_uid(), RolesDataAccreditUtil.PRO_AMAN_SQL_STR, "a_role_data.");
		pageTable.setWheresql(wheresql );
		pageTable = projectMeetingService.selectProMeetingPageTables(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 显示评审会详情查看页面
	 */
	@RequestMapping(value="/showMeetingViewPage")
	public ModelAndView showMeetingViewPage(String meeting_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_meeting pro_meeting = projectMeetingService.selectOneProjectMeeting(" and pm.meeting_ID = '"+meeting_ID+"'");
		mv.setViewName("/project/meeting/meetingArrange/meetingArrangeView");
		mv.getModelMap().put("meeting", pro_meeting);
		return mv;
	}
	
	/**
	 * 显示评审会信息修改页面
	 */
	@RequestMapping(value="/showMeetingEditPage")
	public ModelAndView showMeetingEditPage(String meeting_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meeting/meetingArrange/meetingArrangeEdit");
		Pro_meeting pro_meeting = projectMeetingService.selectOneProjectMeeting(" and pm.meeting_ID = '"+meeting_ID+"'");
		mv.getModelMap().put("meeting", pro_meeting);
		List<C_dictype> meetingTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='5d23720a7a1543f0b2c3e82688465dc8'");//获取评审会类型下拉框;
		mv.getModelMap().put("meetingTypeList",meetingTypeList);		
		return mv;
	}
	
	/**
	 * 修改一条评审会信息
	 */
	@RequestMapping(value="/updateOneMeeting")
	@ResponseBody
	public AjaxRes updateOneMeeting(@RequestBody Pro_meeting proMeeting){
		AjaxRes ar = new AjaxRes();
		Boolean result = projectMeetingService.updateOneMeeting(SystemSession.getUserSession(), proMeeting);
		ar.setSucceed(result);
		return ar;
	}
	
	/**
	 * 显示评审会记录-分块页面
	 */
	@RequestMapping(value="/showMeetingDIVPage")
	public ModelAndView showMeetingDIVPage(PageTable<Pro_meeting> pageTable){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meeting/meetingArrange/meetingRecordDiv");
		pageTable.setSortName("meetingDateTime");
		pageTable.setSortOrder("desc");
		String wheresql = RolesDataAccreditUtil.appendProSqlByRole(SystemSession.getUserSession().getUser_uid(), RolesDataAccreditUtil.PRO_AMAN_SQL_STR, "a_role_data.");
		pageTable.setWheresql(wheresql );
		pageTable = projectMeetingService.selectProMeetingPageTables(pageTable);
		mv.getModelMap().put("pageTable",pageTable);
		return mv;
	}
	
}
