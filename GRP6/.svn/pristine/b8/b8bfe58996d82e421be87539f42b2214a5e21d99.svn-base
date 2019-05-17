package com.zjm.oa.meeting.service.impl;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.log.service.LogService;
import com.zjm.oa.db.map.Oa_filesMapper;
import com.zjm.oa.db.map.Oa_meetingMapper;
import com.zjm.oa.db.model.Oa_files;
import com.zjm.oa.db.model.Oa_meeting;
import com.zjm.oa.meeting.service.MeetingService;
import com.zjm.util.SystemSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lancepro on 7/14/17.
 */
@Service("meetingService")
@Transactional
public class MeetingServiceImpl implements MeetingService {
    @Resource
    private Oa_meetingMapper mapper;

    @Resource
    private Oa_filesMapper filesMapper;
    @Resource
    private LogService logService;

    @Override
    public Integer save(Oa_meeting entity) {
        entity.setStatus("0");
        logService.insertOneOperatorLogInfo(SystemSession.getUserSession(), "会议管理", "添加", "添加一条会议申请");
        return mapper.insert(entity);
    }

    @Override
    public Integer delete(String meetingID) {
        logService.insertOneOperatorLogInfo(SystemSession.getUserSession(), "会议管理", "删除", "删除一条会议记录");
        return mapper.delete(meetingID);
    }

    @Override
    public Integer update(Oa_meeting entity) {
        logService.insertOneOperatorLogInfo(SystemSession.getUserSession(), "会议管理", "修改", "修改一条会议记录");
        return mapper.updateByID(entity);
    }

    @Override
    public List<Oa_meeting> list(PageTable<Oa_meeting> param) {
        return mapper.list(param);
    }

    @Override
    public List<Oa_meeting> listByDuration(PageTable<Oa_meeting> param) {
        return mapper.listByDuration(param);
    }

    @Override
    public List<Oa_meeting> listByApprovalStatus(PageTable<Oa_meeting> param) {
        List<Oa_meeting> list = mapper.listByApprovalStatus(param);
        for (Oa_meeting meeting : list) {
            meeting.getCurrentStatus();
        }
        return list;
    }

    @Override
    public List<Oa_files> getAttachments(Oa_files files) {
        return filesMapper.selectByRef(files);
    }

    @Override
    public Oa_meeting getByPrimaryKey(String meeting_ID) {
        return mapper.getByPrimaryKey(meeting_ID);
    }

    @Override
    public Boolean approve(Oa_meeting meeting) {
        logService.insertOneOperatorLogInfo(SystemSession.getUserSession(), "会议管理", "修改", "通过一个会议申请");
        meeting.setStatus("1");
        return mapper.updateByID(meeting) == 1;
    }

    @Override
    public Boolean reject(Oa_meeting meeting) {
        logService.insertOneOperatorLogInfo(SystemSession.getUserSession(), "会议管理", "修改", "拒绝一个会议申请");
        meeting.setStatus("3");
        return mapper.updateByID(meeting) == 1;
    }

    @Override
    public Boolean cancel(Oa_meeting meeting) {
        logService.insertOneOperatorLogInfo(SystemSession.getUserSession(), "会议管理", "修改", "撤销一个会议申请");
        meeting.setStatus("2");
        return mapper.updateByID(meeting) == 1;
    }

	@Override
	public Boolean delApproval(Oa_meeting meeting) {
		logService.insertOneOperatorLogInfo(SystemSession.getUserSession(), "会议管理", "删除", "删除一个会议申请");
        try {
			return mapper.delete(meeting.getMeeting_ID()) == 1;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//根据会议室ID删除会议信息 
	@Override
	public Integer delOaMeetingByMeetingRoomID(String meetingRoomID) {
		Integer num = 0;
		try {
			num = mapper.delOaMeetingByMeetingRoomID(meetingRoomID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

}
