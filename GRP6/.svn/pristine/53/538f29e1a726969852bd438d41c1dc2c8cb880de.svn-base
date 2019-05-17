package com.zjm.oa.meeting.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.oa.common.service.OaFileService;
import com.zjm.oa.db.model.Oa_files;
import com.zjm.oa.db.model.Oa_meeting;
import com.zjm.oa.db.model.Oa_meetingRoom;
import com.zjm.oa.meeting.service.MeetingRoomService;
import com.zjm.oa.meeting.service.MeetingService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by lancepro on 7/14/17.
 */
@Controller
@RequestMapping(value = "/oa/meeting")
public class MeetingAction {
    @Resource
    private MeetingService service;
    @Resource
    private MeetingRoomService meetingRoomService;
    @Resource
    private OaFileService fileService;

    /**
     * 访问会议申请首页
     *
     * @return
     */
    @RequestMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        List<Oa_meetingRoom> rooms = meetingRoomService.list(new PageTable<>());
        mv.getModelMap().put("rooms", rooms);
        mv.setViewName("/oa/meeting/index");
        return mv;
    }

    /**
     * 载入会议申请模态框
     *
     * @return
     */
    @RequestMapping(value = "/applyModal")
    public ModelAndView applyModal() {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        List<Oa_meetingRoom> rooms = meetingRoomService.list(new PageTable<>());
        mv.getModelMap().put("entityID", Tool.createUUID32());
        mv.getModelMap().put("rooms", rooms);
        mv.setViewName("/oa/meeting/meetingApplyModal");
        return mv;
    }

    /**
     * 访问我的会议页面
     *
     * @return
     */
    @RequestMapping(value = "/myMeeting")
    public ModelAndView myMeeting() {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        mv.setViewName("/oa/meeting/myMeeting");
        return mv;
    }

    /**
     * 访问会议申请记录页
     *
     * @return
     */
    @RequestMapping(value = "/meetingRecord")
    public ModelAndView meetingRecord() {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        mv.setViewName("/oa/meeting/applyRecord");
        return mv;
    }
    
    /**
     * 显示删除模态框
     *
     * @return
     */
    @RequestMapping(value = "/showDelModalPage")
    public ModelAndView showDelModalPage() {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        mv.setViewName("/oa/meeting/warnModal/deleteModal");
        return mv;
    }

    /**
     * 访问会议审核页面
     *
     * @return
     */
    @RequestMapping(value = "/approval")
    public ModelAndView approval() {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        mv.setViewName("/oa/meeting/approval");
        return mv;
    }
    /**
     * 进入是否通过审核模态框
     *
     * @return
     */
    @RequestMapping(value = "/showRefuseModalPage")
    public ModelAndView showRefuseModalPage() {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        mv.setViewName("/oa/meeting/warnModal/refuseModal");
        return mv;
    }
    /**
     * 进入是否撤销申请模态框
     *
     * @return
     */
    @RequestMapping(value = "/showApprovalModalPage")
    public ModelAndView showApprovalModalPage() {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        mv.setViewName("/oa/meeting/warnModal/passModal");
        return mv;
    }
    /**
     * 根据会议状态和关键字（可选）查询相应的会议记录并裁入到审核页面
     *
     * @param approvalStatus
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/approvalList")
    public ModelAndView approvalList(String approvalStatus, String keyword) {
        String condition = "status = '" + approvalStatus + "' and unit_uid =\'"+SystemSession.getUserSession().getUnit_uid()+"\' ";
        if (StringUtils.isNotEmpty(keyword)) {
            condition += " and meetingName like '%" + keyword + "%'";
        }
        PageTable pageTable = new PageTable<Oa_meeting>();
        pageTable.setWheresql(condition);
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        List<Oa_meeting> list = service.listByApprovalStatus(pageTable);
        mv.getModelMap().put("approvalStatus", approvalStatus);
        mv.getModelMap().put("meetings", list);
        mv.setViewName("/oa/meeting/approvalFragment");
        return mv;
    }

    /**
     * 根据会议状态和关键字（可选）查询相应的会议记录并裁入到申请记录页面
     *
     * @param approvalStatus
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/applyRecordList")
    public ModelAndView applyRecordList(String approvalStatus, String keyword) {
        User user = SystemSession.getUserSession();
        String condition = "status = '" + approvalStatus + "' and unit_uid =\'"+SystemSession.getUserSession().getUnit_uid()+"\' ";
        if (StringUtils.isNotEmpty(keyword)) {
            condition += " and meetingName like '%" + keyword + "%'";
        }
        condition += " and createUserID = '" + user.getUser_uid() + "'";
        PageTable pageTable = new PageTable<Oa_meeting>();
        pageTable.setWheresql(condition);
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        List<Oa_meeting> list = service.listByApprovalStatus(pageTable);
        mv.getModelMap().put("approvalStatus", approvalStatus);
        mv.getModelMap().put("meetings", list);
        mv.setViewName("/oa/meeting/applyRecordFragment");
        return mv;
    }

    /**
     * 根据会议状态和关键字（可选）查询相应的会议记录并裁入到我的会议页面
     *
     * @param currentStatus
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/myMeetingList")
    public ModelAndView myMeetingList(String currentStatus, String keyword) {
    	ModelAndView mv = CustomDispatchServlet.getModeAndView();
    	try{
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        User user = SystemSession.getUserSession();
	        String now = dateFormat.format(new Date());
	        String condition = "status = '1' and unit_uid =\'"+SystemSession.getUserSession().getUnit_uid()+"\' ";
	        if ("waiting".equals(currentStatus)) {
	            condition += " and meetingBeginDateTime > '" + now + "'";
	        } else if ("running".equals(currentStatus)) {
	            condition += " and meetingBeginDateTime <= '" + now + "' and meetingEndDateTime >= '" + now + "'";
	        } else if ("over".equals(currentStatus)) {
	            condition += " and meetingEndDateTime < '" + now + "'";
	        }
	        condition += " and membersIDList like '%" + user.getUser_uid() + "%'";
	        if (StringUtils.isNotEmpty(keyword)) {
	            condition += " and meetingName like '%" + keyword + "%'";
	        }
	        PageTable pageTable = new PageTable<Oa_meeting>();
	        pageTable.setWheresql(condition);
	        
	        List<Oa_meeting> list = service.listByApprovalStatus(pageTable);
	        mv.getModelMap().put("currentStatus", currentStatus);
	        mv.getModelMap().put("meetings", list);
	        mv.setViewName("/oa/meeting/myMeetingFragment");
    	}catch (Exception e) {
			e.printStackTrace();
		}
        return mv;
    }

    /**
     * 根据会议ID查看会议详情
     *
     * @param meeting_ID
     * @return
     */
    @RequestMapping(value = "/view")
    public ModelAndView view(String meeting_ID) {
        Oa_meeting meeting = service.getByPrimaryKey(meeting_ID);
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        mv.getModelMap().put("meeting", meeting);
        Oa_meetingRoom room = meetingRoomService.get(meeting.getMeetingRoomID());
        Oa_files file = new Oa_files();
        file.setFileType("02");
        file.setEntityID(room.getMeetingRoom_ID());
        List<Oa_files> pictureFiles = fileService.selectByRef(file);
        if (CollectionUtils.isNotEmpty(pictureFiles)) {
            room.setPicturePath(pictureFiles.get(0).getPathFile());
        } else {
            room.setPicturePath("/oa/meeting/picture/room.png");
        }

        file.setFileType("03");
        file.setEntityID(meeting_ID);
        List<Oa_files> attachments = fileService.selectByRef(file);
        mv.getModelMap().put("attachments", attachments);
        mv.getModelMap().put("room", room);
        mv.setViewName("/oa/meeting/meetingViewModal");
        return mv;
    }

    /**
     * 根据会议ID批准该会议申请
     *
     * @param meeting
     * @return
     */
    @RequestMapping(value = "/approve")
    @ResponseBody
    public AjaxRes approve(@RequestBody Oa_meeting meeting) {
        AjaxRes ar = new AjaxRes();
        ar.setSucceed(service.approve(meeting));
        return ar;
    }

    /**
     * 根据会议ID拒绝该会议申请
     *
     * @param meeting
     * @return
     */
    @RequestMapping(value = "/reject")
    @ResponseBody
    public AjaxRes reject(@RequestBody Oa_meeting meeting) {
        AjaxRes ar = new AjaxRes();
        ar.setSucceed(service.reject(meeting));
        return ar;
    }
    /**
     * 根据会议ID删除该会议申请
     *
     * @param meeting
     * @return
     */
    @RequestMapping(value = "/delApproval")
    @ResponseBody
    public AjaxRes delApproval(@RequestBody Oa_meeting meeting) {
        AjaxRes ar = new AjaxRes();
        ar.setSucceed(service.delApproval(meeting));
        return ar;
    }
    /**
     * 根据时间段查询会议记录并包装成fullcalendar所需要的eventarray格式，详情请参考fullcalendar的文档。
     *
     * @param start
     * @param end
     * @param meetingRoomID
     * @return
     */
    @RequestMapping(value = "/meetingEventArray", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String meetingEventArray(String start, String end, String meetingRoomID) {
        String condition = "meetingRoomID = '" + meetingRoomID + "' and meetingBeginDateTime >= '" + start + " 00:00:00' and meetingEndDateTime <= '" + end + " 23:59:59' and unit_uid =\'"+SystemSession.getUserSession().getUnit_uid()+"\' ";
        PageTable pageTable = new PageTable<Oa_meeting>();
        pageTable.setWheresql(condition);
        List<Oa_meeting> meetingList = service.listByDuration(pageTable);
        JSONArray meetingEvents = new JSONArray();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        //通过meetingRoomID查询会议室管理员
        Oa_meetingRoom meetingRoom = meetingRoomService.get(meetingRoomID);
        
        for (Oa_meeting meeting : meetingList) {
        	//根据meeting_ID获得附件名称
        	String meeting_ID = meeting.getMeeting_ID();
        	List<Oa_files> fileList= fileService.selectOaFileByEntityID(meeting_ID);
        	String fileNme="";
        	for (Oa_files oa_files : fileList) {
				String sourceFileName = oa_files.getSourceFileName();
				fileNme =fileNme+sourceFileName+",";
			}
        	if(fileNme!=null && !"".equals(fileNme)){
        		fileNme = fileNme.substring(0,fileNme.length() - 1);
        	}
            JSONObject meetingEvent = new JSONObject();
            meetingEvent.put("id",meeting_ID);
            meetingEvent.put("title", meeting.getMeetingName());
            meetingEvent.put("start", dateFormat.format(meeting.getMeetingBeginDateTime()));
            meetingEvent.put("end", dateFormat.format(meeting.getMeetingEndDateTime()));
            meetingEvent.put("meetingRoom", meeting.getMeetingRoomName());
            meetingEvent.put("subject", meeting.getSubject());
            meetingEvent.put("createUserName", meeting.getCreateUserName());//审核人
            meetingEvent.put("createTime", dateFormat.format(meeting.getCreateDateTime()));//审核时间
            meetingEvent.put("statuss", meeting.getStatus());//审核状态
            
            meetingEvent.put("compereName", meeting.getCompereName());//主持人
            meetingEvent.put("membersNameList", meeting.getMembersNameList());//出席人员
            meetingEvent.put("outMembers", meeting.getOutMembers());//外部出席人员
            meetingEvent.put("remark", meeting.getRemark());//备注
            meetingEvent.put("managerNameList", meetingRoom.getManagerNameList());//会议室管理员
            meetingEvent.put("fileNme", fileNme);//附件
          
            meetingEvents.add(meetingEvent);
        }
        return meetingEvents.toJSONString();
    }

    /**
     * 添加一条会议申请
     *
     * @param meeting
     * @return
     */
    @RequestMapping(value = "/save")
    @ResponseBody
    public AjaxRes save(@RequestBody Oa_meeting meeting) {
        AjaxRes ar = new AjaxRes();
        meeting.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
        meeting.setUnit_uidName(SystemSession.getUserSession().getUnit_uidName());
        meeting.setUpdateDateTime(new Date());
        meeting.setUpdateUserName(SystemSession.getUserSession().getUser_name());
        meeting.setCreateUserID(SystemSession.getUserSession().getUser_uid());
        meeting.setCreateUserName(SystemSession.getUserSession().getUser_name());
        meeting.setCreateDateTime(new Date());
        ar.setSucceed(service.save(meeting));
        return ar;
    }

    /**
     * 撤销一条会议申请
     *
     * @param meeting
     * @return
     */
    @RequestMapping(value = "/cancel")
    @ResponseBody
    public AjaxRes cancel(@RequestBody Oa_meeting meeting) {
        AjaxRes ar = new AjaxRes();
        ar.setSucceed(service.cancel(meeting));
        return ar;
    }

    /**
     * 根据会议ID获取该会议关联的附件
     *
     * @param entityID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAttachments")
    public AjaxRes getAttachments(String entityID) {
        Oa_files files = new Oa_files();
        AjaxRes ar = new AjaxRes();
        files.setEntityID(entityID);
        files.setFileType("03");
        ar.setSucceed(service.getAttachments(files));
        return ar;
    }

    /**
     * 根据文件ID删除该文件
     *
     * @param files_ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAttachment")
    public AjaxRes deleteAttachment(String files_ID) {
        AjaxRes ar = new AjaxRes();
        ar.setSucceed(fileService.delete(files_ID));
        return ar;
    }
}
