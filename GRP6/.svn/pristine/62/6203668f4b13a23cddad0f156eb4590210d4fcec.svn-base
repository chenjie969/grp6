package com.zjm.pro.onManagement.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.oa.db.model.Oa_meeting;
import com.zjm.oa.db.model.Oa_meetingRoom;
import com.zjm.oa.meeting.service.MeetingRoomService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.map.Pro_meetingApplyMapper;
import com.zjm.pro.db.map.Pro_meetingMapper;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_meeting;
import com.zjm.pro.db.model.Pro_meetingApply;
import com.zjm.pro.db.model.Pro_package;
import com.zjm.pro.onManagement.service.ProMeetingService;
import com.zjm.pro.projectPackage.service.PackageService;
import com.zjm.sys.util.RolesDataAccreditUtil;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

/**上会管理申请
 * 
 */
@Controller
@RequestMapping(value = "/pro/meeting")
public class ProMeetingAction {
    @Resource
    private ProMeetingService proMeetingService;
    @Resource
    private MeetingRoomService meetingRoomService;
    @Resource
	private PackageService packageService;
	@Resource
	private ProjectApplyService projectApplyService;
	@Resource
	private Pro_meetingApplyMapper pro_meetingApplyMapper;
	@Resource
	private Pro_meetingMapper pro_meetingMapper;
    
    //首页--点击上会申请，进入上会申请页面
    @RequestMapping(value = "/meeting")
    public ModelAndView index() {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        //List<Pro_meeting> rooms = proMeetingService.selectAllMeetingRooms(new PageTable<>());
        List<Oa_meetingRoom> rooms = meetingRoomService.list(new PageTable<>());
        mv.getModelMap().put("rooms", rooms);
        mv.setViewName("/project/onManagement/meeting");
        return mv;
    }
    //点击申请记录，进入申请记录页面
    @RequestMapping(value = "/meetingRecord")
    public ModelAndView meetingRecord() {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        mv.setViewName("/project/onManagement/applyRecord");
        return mv;
    }
    
    //点击上会审批，进入上会审批页面
    @RequestMapping(value = "/meetingApproval")
    public ModelAndView meetingApproval() {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        mv.setViewName("/project/onManagement/meetingApproval");
        return mv;
    }
    
    //进入所有评审会页面
    @RequestMapping(value = "/allEvaluItems")
    public ModelAndView allEvaluItems() {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        mv.setViewName("/project/onManagement/allEvaluItems");
        return mv;
    }
    //进入我的评审会页面
    @RequestMapping(value = "/myEvaluItems")
    public ModelAndView myEvaluItems() {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        mv.setViewName("/project/onManagement/myEvaluItems");
        return mv;
    }
    //点击同意，进入考核通过提示框
    @RequestMapping(value = "/showDelModalPage")
    public ModelAndView showDelModalPage() {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        mv.setViewName("/project/onManagement/warnModal/deleteModal");
        return mv;
    }
    
    //点击同意，进入考核通过提示框
    @RequestMapping(value = "/showApprovalModalPage")
    public ModelAndView showApprovalModalPage() {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        mv.setViewName("/project/onManagement/warnModal/passModal");
        return mv;
    }
    
    //点击申请会议按钮--进入申请会议弹出模态框页面
    @RequestMapping(value = "/meetingApplyAdd")
    public ModelAndView meetingApplyAdd() {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        List<Oa_meetingRoom> rooms = meetingRoomService.list(new PageTable<>());
        mv.getModelMap().put("entityID", Tool.createUUID32());
        mv.getModelMap().put("rooms", rooms);
        mv.setViewName("/project/onManagement/meetingApplyAdd");
        return mv;
    }
    //点击保存--添加一条上会申请记录
    @RequestMapping(value="/insertOneMeetingApply")
	@ResponseBody
	public AjaxRes insertOneMeetingApply(@RequestBody Pro_meeting meeting) {
		AjaxRes ar = new AjaxRes();

		/*String meetingDateTimeStr = meeting.getMeetingDateTimeStr();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date meetingDateTime;
		try {
			meetingDateTime = sdf.parse(meetingDateTimeStr);
			meeting.setMeetingDateTime(meetingDateTime);

			String id = Tool.createUUID32();

			// 获取会议室信息
			Oa_meetingRoom meetingRoom = meetingRoomService.get(meeting.getmeetingRoomID());

			User user = SystemSession.getUserSession();
			meeting.setmeetingRoomName(meetingRoom.getMeetingRoomName());
			meeting.setMeeting_ID(id);
			meeting.setUpdateUserName(user.getUser_name());
			meeting.setUnit_uid(SystemSession.getUserSession().getUnit_uid());;
			meeting.setMeetingStatus("01");
			meeting.setMeetingPlace(meetingRoom.getPosition());
			// 向 评审会信息表pro_meeting 中插入数据
			ar.setSucceed(proMeetingService.insertOneMeetingApply(meeting));
			// 向 评审会与申请对应表pro_meetingApply 中插入数据
			// 申请项目ID
			String proEntityID = meeting.getProEntityID();

			String[] proEntityIDArr = null;
			if (proEntityID != null && !"".equals(proEntityID)) {
				proEntityIDArr = proEntityID.trim().split(",");
				for (int i = 0; i < proEntityIDArr.length; i++) {
					if (proEntityIDArr[i] != null && !"".equals(proEntityIDArr[i])) {
						Pro_meetingApply meetingApply = new Pro_meetingApply();
						meetingApply.setMeetingApply_ID(Tool.createUUID32());
						meetingApply.setEntityID(proEntityIDArr[i]);
						meetingApply.setMeeting_ID(id);
						meetingApply.setEntityType("01");
						meetingApply.setUpdateUserName(user.getUser_name());
						proMeetingService.insertOneMeetingApplyApply(meetingApply);

						
						//PageTable<Pro_apply> pageTable = new PageTable<Pro_apply>();
						// 修改 业务申请信息表pro_apply 中的isArrangeMeeting的值 为1即为true
						String whereSql = " apply_ID = \'" + proEntityIDArr[i] + "\' limit 1 ";
						//pageTable.setWheresql(whereSql);
						Pro_apply apply = new Pro_apply();
						apply.setMeetingDate(meetingDateTime);
						apply.setMeetingResult("已安排上会");
						apply.setApply_ID(proEntityIDArr[i]);
						
						projectApplyService.updateIsArrangeMeetById(apply);
					}
				}
			}
			// 打包
			String[] packEagentityIDArr = null;
			// 打包项目ID
			String packEagentityID = meeting.getPackEagentityID();
			if (packEagentityID != null && !"".equals(packEagentityID)) {
				packEagentityIDArr = packEagentityID.trim().split(",");
				for (int j = 0; j < packEagentityIDArr.length; j++) {
					if (packEagentityIDArr[j] != null && !"".equals(packEagentityIDArr[j])) {
						Pro_meetingApply meetingApply = new Pro_meetingApply();
						meetingApply.setMeetingApply_ID(Tool.createUUID32());
						meetingApply.setEntityID(packEagentityIDArr[j]);
						meetingApply.setMeeting_ID(id);
						meetingApply.setEntityType("02");
						meetingApply.setUpdateUserName(user.getUser_name());
						proMeetingService.insertOneMeetingApplyApply(meetingApply);

						// 修改 打包表pro_package 中的isArrangeMeeting的值 为1即为true
						PageTable<Pro_package> pageTable = new PageTable<Pro_package>();
						String whereSql = " package_ID = \'" + packEagentityIDArr[j] + "\' limit 1 ";
						pageTable.setWheresql(whereSql);
						packageService.updateIsArrangeMeetingById(pageTable);

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
*/
		return ar;
	}
    //点击左侧会议室名称会在右侧日期上显示大致信息
    @RequestMapping(value = "/meetingEventArray", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String meetingEventArray(String meetingRoom_ID) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String condition = " and meetingRoomID = '" + meetingRoom_ID+"' and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\' " ;
        PageTable<Pro_meeting> pageTable = new PageTable<Pro_meeting>();
        pageTable.setWheresql(condition);
        JSONArray meetingEvents = new JSONArray();
        List<Pro_meeting> meetingList=null;
		try {
			//通过会议室名或得评审信息
			meetingList = proMeetingService.listByDuration(pageTable);
			
			for (Pro_meeting meeting : meetingList) {
				
				String meeting_ID=meeting.getMeeting_ID();
				List<Map<String, Object>> projectNameList = getProjectNameList(meeting_ID);
				String projectName = "";
				for(int i=0;i<projectNameList.size();i++){
					Map<String, Object> map = projectNameList.get(i);
					if(i<projectNameList.size()-1){
						projectName += (String) map.get("projectName")+"，";
					}else{
						projectName += (String) map.get("projectName");
					}
				}
				
	            JSONObject meetingEvent = new JSONObject();
	            meetingEvent.put("id", meeting.getMeeting_ID());
	            meetingEvent.put("title", "评审会20170001");
	            meetingEvent.put("meetCode", meeting.getMeetingCode());//评审编号
	            meetingEvent.put("projectName", projectName);//项目名称
	            meetingEvent.put("start", dateFormat.format(meeting.getMeetingDateTime()));//上会时间
	            meetingEvent.put("upUserName", meeting.getUpdateUserName());//申请人
	            meetingEvent.put("meetStatus", meeting.getMeetingStatus());//审核状态
//	            meetingEvent.put("userName", meeting.getUserName());//主持人姓名
	            meetingEvent.put("userNameList", meeting.getUserNameList());//参与评委
	            meetingEvent.put("otherUsers", meeting.getOtherUserNameList());//外部专家
	            meetingEvent.put("upDatime", dateFormat.format(meeting.getUpdateDateTime()));//申请时间
//	            meetingEvent.put("meetingRoom", meeting.getmeetingRoomName());//会议室名称
//	            meetingEvent.put("position", meeting.getMeetingPlace());//会议室位置
	            meetingEvents.add(meetingEvent);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        String meetingEventstr = meetingEvents.toJSONString();
        return meetingEventstr;
    }
    
    /**
	 * 分页查询所有的评审会
	 */
    @RequestMapping(value = "/allMeetingList")
    public ModelAndView allMeetingList(String currentStatus, String keyword) {
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String now = dateFormat.format(new Date());
        PageTable pageTable = new PageTable<Pro_meeting>();
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        
        User user = SystemSession.getUserSession();
		pageTable.setWheresql(queryConditionSql(user,"all",pageTable,currentStatus));
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		try {
			pageTable = proMeetingService.selectMyProMeetingPageTable(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Pro_meeting> List = pageTable.getRows();
        mv.getModelMap().put("currentStatus", currentStatus);
        mv.getModelMap().put("meetings", List);
        mv.setViewName("/project/onManagement/allMeetingFragment");
        return mv;
    }
    
    /**
	 * 分页查询我的评审会
	 */
	@RequestMapping(value = "/myMeetingList")
    public ModelAndView myMeetingList(String currentStatus, String keyword) {
        PageTable pageTable = new PageTable<Pro_meeting>();
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        
        User user = SystemSession.getUserSession();
		pageTable.setWheresql(queryConditionSql(user,"my",pageTable,currentStatus));
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		try {
			pageTable = proMeetingService.selectMyProMeetingPageTable(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
        mv.getModelMap().put("currentStatus", currentStatus);
        mv.getModelMap().put("meetings", pageTable);
        mv.setViewName("/project/onManagement/myMeetingFragment");
        return mv;
    }
	
	/**
	 * 分页列表查询条件
	 * @param pageTable 
	 */
	private String queryConditionSql(User user,String str, PageTable<Pro_meeting> pageTable,String currentStatus){
		if(user==null){
			return "";
		}
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if("my".equals(str)){
//			wheresql.append(" and userIDList like \'%"+user.getUser_uid().trim()+"%\'");
			String sql = RolesDataAccreditUtil.appendMeetingSql(user.getUser_uid().trim());
			if( null != sql){
				wheresql.append(sql);
			}
		}
		
		if (currentStatus !=null && "waiting".equals(currentStatus)) {
			wheresql.append(" and meetingDateTime > now()");
		}
		/*if (currentStatus !=null && "waiting".equals(currentStatus)) {//未进行
        	wheresql.append(" and meetingDateTime > now()");
        }else if(currentStatus !=null && "running".equals(currentStatus)) {//进行中
        	wheresql.append(" and meetingDateTime < now()");
        }else if(currentStatus !=null && "over".equals(currentStatus)) {//已结束
        	wheresql.append(" and meetingDateTime < SUBDATE(NOW(),INTERVAL 3 HOUR) ");
        }*/
		wheresql.append(" and meetingStatus='02' and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and meetingRoomName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		
		wheresql.append(" ORDER BY updateDateTime DESC ");
		return wheresql.toString();
	}
	
	//显示页面--点击进入删除页面
    @RequestMapping(value = "/showEvaluItemsDelPage")
    public ModelAndView showEvaluItemsDelPage() {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        mv.setViewName("/project/onManagement/evaluItemsDel");
        return mv;
    }
    /**
	 *  执行操作-删除一条节点
	 */
	@RequestMapping(value="/deleteOneEvaluItems")
	@ResponseBody
	public AjaxRes deleteOneEvaluItems(@RequestBody Pro_meeting meeting){
		AjaxRes ar = new AjaxRes();
		try {
			ar.setSucceed(proMeetingService.deleteOneEvaluItems(meeting));
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		return ar;
	}
	//查看一条评审会信息
	@RequestMapping(value="/showOneEvaluItemsViewPage")
	public ModelAndView showOneEvaluItemsViewPage(Pro_meeting meeting){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try {
			meeting = proMeetingService.showOneEvaluItemsViewPage(meeting);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.getModelMap().put("promeeting",meeting);
		mv.setViewName("/project/onManagement/evaluItemsView");
		return mv;
	}
	/**
	 * 新增时判断评审会编号是否存在
	 */
	@RequestMapping(value="/isExistMeetingCode")
	@ResponseBody
	public AjaxRes isExistMeetingCode(@RequestBody Pro_meeting meeting){
		AjaxRes ar = new AjaxRes();
		try {
			ar.setSucceed(proMeetingService.isExistMeetingCode(meeting));
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		return ar;
	}
	
	//点击申请记录，进入申请记录页面
    @RequestMapping(value = "/clientListModalAdd")
    public ModelAndView clientListModalAdd() {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        mv.setViewName("/project/onManagement/clientList");
        return mv;
    }
    
    /**
     * 上会审批，查询所有的  待审核、同意、被拒绝的审批信息
     */
    @RequestMapping(value = "/meetingApprovalList")
    public ModelAndView approvalList(String approvalStatus, String keyword) {
        List<Pro_meeting> list = proMeetingService.selectMeetingApprovalList(approvalStatus,keyword);
        
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        mv.getModelMap().put("approvalStatus", approvalStatus);
        mv.getModelMap().put("meetings", list);
        mv.setViewName("/project/onManagement/approvalFragment");
        return mv;
    }
    //上会审批--查看
    @RequestMapping(value = "/approvalView")
    public ModelAndView approvalView(String meeting_ID) {
    	Pro_meeting meeting = proMeetingService.selectOneApprovalInfoById(meeting_ID);
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        mv.getModelMap().put("meeting", meeting);
        mv.setViewName("/project/onManagement/meetingApprovalViewModal");
        return mv;
    }
    
    
    //项目详细信息--查看
    @RequestMapping(value = "/showProViewPage")
    public ModelAndView showProViewPage(String meeting_ID) {
    	Pro_meeting meeting = proMeetingService.selectOneApprovalInfoById(meeting_ID);
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        mv.getModelMap().put("meeting", meeting);
        mv.setViewName("/project/onManagement/proNameViewModal");
        return mv;
    }
    
    
    //查看 详细项目名称
    @RequestMapping(value = "/proNameView")
    public ModelAndView proNameView(String proName) {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        mv.getModelMap().put("proName", proName);
        mv.setViewName("/project/onManagement/proNameViewModal");
        return mv;
    }
    /**
     * 根据会议ID批准该上会申请--同意
     * @param meeting
     * @return
     */
    @RequestMapping(value = "/approveMeeting")
    @ResponseBody
    public AjaxRes approve(@RequestBody Pro_meeting meeting) {
        AjaxRes ar = new AjaxRes();
        ar.setSucceed(proMeetingService.approveMeeting(meeting));
        return ar;
    }
    /**
     * 根据会议ID拒绝该上会申请
     * @param meeting
     * @return
     */
    @RequestMapping(value = "/rejectApproval")
    @ResponseBody
    public AjaxRes reject(@RequestBody Pro_meeting meeting) {
        AjaxRes ar = new AjaxRes();
        ar.setSucceed(proMeetingService.rejectApproval(meeting));
        return ar;
    }
    
    /**
     * 根据会议ID删除该上会申请
     * @param meeting
     * @return
     */
    @RequestMapping(value = "/delApproval")
    @ResponseBody
    public AjaxRes delApproval(@RequestBody Pro_meeting meeting) {
        AjaxRes ar = new AjaxRes();
        ar.setSucceed(proMeetingService.deleteOneEvaluItems(meeting));
        return ar;
    }
    
    /*以下是申请记录*/
    /**
     * 根据会议状态和关键字（可选）查询相应的会议记录并裁入到申请记录页面
     * @param approvalStatus
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/applyRecordList")
    public ModelAndView applyRecordList(String approvalStatus, String keyword) {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        List<Pro_meeting> recordList = proMeetingService.selectApplyRecordList(approvalStatus,keyword);
        mv.getModelMap().put("approvalStatus", approvalStatus);
        mv.getModelMap().put("meetings", recordList);
        mv.setViewName("/project/onManagement/applyRecordFragment");
        return mv;
    }
    /**
     * 进入撤销页面--撤销一条会议申请
     * @param meeting
     * @return
     */
    @RequestMapping(value = "/showMeetApprovalRejectPage")
    public ModelAndView showMeetApprovalRejectPage() {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        mv.setViewName("/project/onManagement/meetApprovalReject");
        return mv;
    }
    
    /**
     * 撤销一条会议申请
     * @param meeting
     * @return
     */
    @RequestMapping(value = "/revokeApplyRecord")
    @ResponseBody
    public AjaxRes revokeApplyRecord(@RequestBody Pro_meeting meeting) {
        AjaxRes ar = new AjaxRes();
        ar.setSucceed(proMeetingService.revokeApplyRecord(meeting));
        return ar;
    }
    
   
    /**根据applyID查询评论会信息
     * @param meetingRoom_ID
     * @return
     */
    //通过ID获取项目名称
  	public List<Map<String, Object>> getProjectNameList(String meeting_ID){
  		List<Map<String, Object>> projectNameList = new ArrayList<Map<String, Object>>();
  		List<Pro_meetingApply> meetingApplyList = new ArrayList<Pro_meetingApply>();
  		try {
  			meetingApplyList = pro_meetingApplyMapper.selectOneMeetingApplyById(meeting_ID);

  			for (Pro_meetingApply pro_meetingApply : meetingApplyList) {
  				String entityID = pro_meetingApply.getEntityID();
  				String entityType = pro_meetingApply.getEntityType();
  				if ("01".equals(entityType)) {
  					Map<String, Object> proNameMap = new HashMap<String, Object>();
  					String whereSql = " and apply_ID = \'" + entityID + "\'";
  					Pro_apply apply;
  					String projectName;

  					apply = projectApplyService.selectOneApplyByWhereSql(whereSql);
  					if (apply != null) {
  						projectName = apply.getProjectName();
  						proNameMap.put("projectName", projectName);
  						projectNameList.add(proNameMap);
  					}

  				} else if ("02".equals(entityType)) {
  					Map<String, Object> proNameMap = new HashMap<String, Object>();
  					String whereSql = " and package_ID = \'" + entityID + "\'";
  					Pro_package pro_package;
  					String projectName;

  					pro_package = packageService.selectOnePackageByWhereSql(whereSql);
  					if (pro_package != null) {
  						projectName = pro_package.getPackageName();
  						proNameMap.put("projectName", projectName);
  						projectNameList.add(proNameMap);
  					}

  				}
  			}
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		return projectNameList;
  	}
}
