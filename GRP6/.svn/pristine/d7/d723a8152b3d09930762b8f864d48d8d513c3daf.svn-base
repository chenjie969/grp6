package com.zjm.oa.meeting.web;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.oa.common.service.OaFileService;
import com.zjm.oa.db.model.Oa_files;
import com.zjm.oa.db.model.Oa_meetingRoom;
import com.zjm.oa.meeting.service.MeetingRoomService;
import com.zjm.oa.meeting.service.MeetingService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * Created by lancepro on 7/14/17.
 */
@Controller
@RequestMapping(value = "/oa/meetingRoom")
public class MeetingRoomAction {
    @Resource
    private MeetingService meetingService;
    @Resource
    private MeetingRoomService service;
    @Resource
    private OaFileService fileService;

    /**
     * 访问会议室添加页面
     *
     * @return
     */
    @RequestMapping(value = "/add")
    public ModelAndView add() {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        mv.getModelMap().put("meetingRoom_ID", Tool.createUUID32());
        mv.setViewName("/oa/meeting/meetingRoom/add");
        return mv;
    }

    /**
     * 获取一条会议室记录
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/get")
    public AjaxRes get(String id) {
        AjaxRes ar = new AjaxRes();
        Oa_meetingRoom room = service.get(id);
        Oa_files file = new Oa_files();
        file.setFileType("02");
        file.setEntityID(room.getMeetingRoom_ID());
        List<Oa_files> fils = fileService.selectByRef(file);
        if (CollectionUtils.isNotEmpty(fils)) {
            room.setPicturePath(fils.get(0).getPathFile());
        }
        ar.setSucceed(room);
        return ar;
    }

    /**
     * 访问会议室列表页面
     *
     * @return
     */
    @RequestMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        List<Oa_meetingRoom> rooms = service.list(new PageTable<Oa_meetingRoom>());
        for (Oa_meetingRoom room : rooms) {
            Oa_files file = new Oa_files();
            file.setFileType("02");
            file.setEntityID(room.getMeetingRoom_ID());
            List<Oa_files> fils = fileService.selectByRef(file);
            if (CollectionUtils.isNotEmpty(fils)) {
                room.setPicturePath(fils.get(0).getPathFile());
            } else {
                room.setPicturePath("/oa/meeting/picture/room.png");
            }
        }
        mv.getModelMap().put("rooms", rooms);

        mv.setViewName("/oa/meeting/meetingRoom/list");
        return mv;
    }

    /**
     * 访问会议室编辑页面
     *
     * @param roomID
     * @return
     */
    @RequestMapping(value = "/edit")
    public ModelAndView edit(String roomID) {
        Oa_meetingRoom room = service.get(roomID);
        ModelAndView mv = CustomDispatchServlet.getModeAndView();
        Oa_files file = new Oa_files();
        file.setFileType("02");
        file.setEntityID(room.getMeetingRoom_ID());
        List<Oa_files> fils = fileService.selectByRef(file);
        if (CollectionUtils.isNotEmpty(fils)) {
            room.setPicturePath(fils.get(0).getPathFile());
        } else {
            room.setPicturePath("/oa/meeting/picture/room.png");
        }
        mv.getModelMap().put("room", room);
        mv.setViewName("/oa/meeting/meetingRoom/edit");
        return mv;
    }

    /**
     * 添加一条会议室记录
     *
     * @param meetingRoom
     * @return
     */
    @RequestMapping(value = "/save")
    @ResponseBody
    public AjaxRes save(@RequestBody Oa_meetingRoom meetingRoom) {
        AjaxRes ar = new AjaxRes();
        meetingRoom.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
        meetingRoom.setUnit_uidName(SystemSession.getUserSession().getUnit_uidName());
        meetingRoom.setUpdateDateTime(new Date());
        meetingRoom.setUpdateUserName(SystemSession.getUserSession().getUser_name());
        try {
			Integer num = service.save(meetingRoom);
			ar.setSucceed(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return ar;
    }

    /**
     * 更新会议室的配置
     *
     * @param meetingRoom
     * @return
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public AjaxRes update(@RequestBody Oa_meetingRoom meetingRoom) {
        AjaxRes ar = new AjaxRes();
        meetingRoom.setUpdateUserName(SystemSession.getUserSession().getUser_name());
        meetingRoom.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
        meetingRoom.setUnit_uidName(SystemSession.getUserSession().getUnit_uidName());
        Integer num = service.update(meetingRoom);
        try {
			ar.setSucceed(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return ar;
    }

    /**
     * 获取会议室记录列表
     *
     * @param pageTable
     * @return
     */
    @RequestMapping(value = "/listRoom")
    @ResponseBody
    public AjaxRes listRoom(@RequestBody PageTable<Oa_meetingRoom> pageTable) {
        AjaxRes ar = new AjaxRes();
        ar.setSucceed(service.list(pageTable));
        return ar;
    }

    /**
     * 根据会议室ID删除相应的会议室记录
     *
     * @param meetingRoom
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public AjaxRes delete(@RequestBody Oa_meetingRoom meetingRoom) {
        AjaxRes ar = new AjaxRes();
        ar.setSucceed(service.delete(meetingRoom.getMeetingRoom_ID()));
        return ar;
    }

    /**
     * 根据entityid和文件来源类型（即fileType字段）查询匹配的文件记录
     *
     * @param files
     * @return
     */
    @RequestMapping(value = "/getPicUrl")
    @ResponseBody
    public AjaxRes getPicUrl(Oa_files files) {
        AjaxRes ar = new AjaxRes();
        files.setFileType("02");
        List<Oa_files> fileList = fileService.selectByRef(files);
        if (CollectionUtils.isNotEmpty(fileList)) {
            ar.setSucceed(fileList.get(0));
        }
        return ar;
    }

    /**
     * 查询当前操作的会议室在数据库中有没有与其会议室名相同的记录。
     *
     * @param meetingRoom
     * @return
     */
    @RequestMapping(value = "/meetingRoomNameExists")
    @ResponseBody
    public AjaxRes meetingRoomNameExists(@RequestBody Oa_meetingRoom meetingRoom) {
        AjaxRes ar = new AjaxRes();
        Boolean b = service.meetingNameExists(meetingRoom);
        ar.setSucceed(!b);
        return ar;
    }


}
