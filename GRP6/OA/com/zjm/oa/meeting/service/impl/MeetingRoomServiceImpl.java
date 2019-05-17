package com.zjm.oa.meeting.service.impl;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.log.service.LogService;
import com.zjm.oa.db.map.Oa_meetingRoomMapper;
import com.zjm.oa.db.model.Oa_meetingRoom;
import com.zjm.oa.meeting.service.MeetingRoomService;
import com.zjm.oa.meeting.service.MeetingService;
import com.zjm.pro.db.model.Pro_meeting;
import com.zjm.pro.db.model.Pro_meetingApply;
import com.zjm.pro.onManagement.service.ProMeetingService;
import com.zjm.util.SystemSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lancepro on 7/14/17.
 */
@Service("meetingRoomService")
@Transactional
public class MeetingRoomServiceImpl implements MeetingRoomService {
    @Resource
    private Oa_meetingRoomMapper mapper;
    @Resource
    private LogService logService;
    @Resource
    private MeetingService meetingservice;
    @Resource
    private ProMeetingService proMeetingservice;

    @Override
    public Integer update(Oa_meetingRoom entity) {
        logService.insertOneOperatorLogInfo(SystemSession.getUserSession(), "会议管理", "修改", "修改会议室配置");
        return mapper.updateByID(entity);
    }

    @Override
    public Integer save(Oa_meetingRoom entity) {
        logService.insertOneOperatorLogInfo(SystemSession.getUserSession(), "会议管理", "新增", "新增会议室");
        return mapper.insert(entity);
    }

    @Override
	public Integer delete(String meetingRoomID) {
		Integer num= 0;
		try {
			logService.insertOneOperatorLogInfo(SystemSession.getUserSession(),"会议管理", "删除", "删除会议室");
			// 删除会议室下的所有会议
			meetingservice.delOaMeetingByMeetingRoomID(meetingRoomID);
			// 删除会议室下的所有上会
			proMeetingservice.delApplyRecordByMeetingRoomID(meetingRoomID);
			// 根据会议室ID删除会议信息
			num = mapper.delete(meetingRoomID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

    @Override
    public List<Oa_meetingRoom> list(PageTable<Oa_meetingRoom> param) {
        return mapper.list(param);
    }

    @Override
    public Oa_meetingRoom get(String meetingRoomID) {
        return mapper.get(meetingRoomID);
    }

    @Override
    public Boolean meetingNameExists(Oa_meetingRoom meetingRoom) {
        return mapper.checkIdentifyOfMeetingRoomName(meetingRoom) > 0;
    }
}
