package com.zjm.pro.meetingApply.web;

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
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.sys.util.RolesDataAccreditUtil;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/project/meetingApply")
public class MeetingApplyAction {
	
	@Resource
	private ProjectApplyService projectApplyService;
	
	/**
	 * 显示上会申请页面 
	 */
	@RequestMapping(value="/showMeetingApplyPage")
	public ModelAndView showMeetingApplyPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meeting/meetingApply/meetingApply");
		return mv;
	}
	
	/**
	 * 显示上会申请记录页面 
	 */
	@RequestMapping(value="/showMeetingApplyRecordPage")
	public ModelAndView showMeetingApplyRecordPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meeting/meetingApply/meetingApplyRecord");
		return mv;
	}
	
	/**
	 * 查询可以申请上会的项目申请
	 */
	@RequestMapping(value="/selectSelectableApplyPageTables")
	@ResponseBody
	public AjaxRes selectSelectableApplyPageTables(@RequestBody PageTable<Pro_apply> pageTable){
		AjaxRes ar = new AjaxRes();
		User user = SystemSession.getUserSession();
		pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());//设置用户id通过匹配用户权限来查询
		StringBuffer sb = new StringBuffer();
		sb.append(" and unit_uid='"+user.getUnit_uid()+"'");
//		sb.append(" and amanID='"+user.getUser_uid()+"'");		//项目A角必须是当前登录本人
		sb.append(" and isStop = 0");	//不是否决项目
		sb.append(" and isMeeting = 1");	//是上会项目
		sb.append(" and meetingStatus IS NULL");	//上会状态为空, 没有申请过上会
		pageTable.setWheresql(queryConditionSql(pageTable)+sb.toString());
		pageTable = projectApplyService.selectApplyPageTables(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 查询已提交申请上会的项目申请记录
	 */
	@RequestMapping(value="/selectSubmitedApplyRecordPageTables")
	@ResponseBody
	public AjaxRes selectSubmitedApplyRecordPageTables(@RequestBody PageTable<Pro_apply> pageTable){
		AjaxRes ar = new AjaxRes();
		User user = SystemSession.getUserSession();
		pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());//设置用户id通过匹配用户权限来查询
		StringBuffer sb = new StringBuffer();
		sb.append(" and unit_uid='"+user.getUnit_uid()+"'");
		sb.append(" and isMeeting = 1");
//		sb.append(" and (applyMeetingUserName='"+user.getUser_name()+"' OR amanID='"+user.getUser_uid()+"')");		//项目A角或上会申请人是当前登录本人
		sb.append(" and meetingStatus IS NOT NULL");
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
		//根据权限查看用户可查看到的数据sql
		if(null != pageTable.getQueryCondition().getUser_uid() && !"".equals(pageTable.getQueryCondition().getUser_uid())){
			String sql = RolesDataAccreditUtil.appendProSqlByRole(pageTable.getQueryCondition().getUser_uid(),RolesDataAccreditUtil.PRO_AMAN_SQL_STR,"");
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
	 * 显示上会申请新增页面
	 */
	@RequestMapping(value="/showMeetingApplyAddPage")
	public ModelAndView showMeetingApplyAddPage(String projectNameList, String applyIDList){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meeting/meetingApply/meetingApplyAdd");
		mv.getModelMap().put("projectNameList", projectNameList);
		mv.getModelMap().put("applyIDList", applyIDList);
		return mv;
	}
	
	/**
	 * 申请上会处理: 将pro_apply的上会状态设置为"待安排"
	 */
	@RequestMapping(value="/setMeetingStatusArranging")
	@ResponseBody
	public AjaxRes setMeetingStatusArranging(@RequestBody Pro_apply proApply){
		AjaxRes ar = new AjaxRes();
		Boolean result = projectApplyService.setMeetingStatusArranging(proApply,"待安排");
		ar.setSucceed(result);
		return ar;
	}
}
