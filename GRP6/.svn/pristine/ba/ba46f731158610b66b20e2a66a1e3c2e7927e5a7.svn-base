package com.zjm.oa.meeting.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.oa.db.model.Oa_files;
import com.zjm.oa.db.model.Oa_meeting;
import com.zjm.oa.db.model.Oa_meetingRoom;

import java.util.List;

/**
 * Created by lancepro on 7/14/17.
 */
public interface MeetingService {
    /**
     * 保存一条会议记录
     *
     * @param entity
     * @return
     */
    Integer save(Oa_meeting entity);

    /**
     * 根据主键删除一条记录
     *
     * @param meetingID
     * @return
     */
    Integer delete(String meetingID);

    /**
     * 根据主键更新一条记录
     *
     * @param entity
     * @return
     */
    Integer update(Oa_meeting entity);

    /**
     * 根据参数中的Sql获取匹配的记录
     *
     * @param param
     * @return
     */
    List<Oa_meeting> list(PageTable<Oa_meeting> param);

    /**
     * 获取某时间段内的会议记录
     *
     * @param param
     * @return
     */
    List<Oa_meeting> listByDuration(PageTable<Oa_meeting> param);

    /**
     * 根据会议状态获取匹配的会议记录
     *
     * @param param
     * @return
     */
    List<Oa_meeting> listByApprovalStatus(PageTable<Oa_meeting> param);

    /**
     * 根据文件entityId和文件类型来源（即filetype字段）获取相应会议的附件列表
     *
     * @param files
     * @return
     */
    List<Oa_files> getAttachments(Oa_files files);

    /**
     * 通过主键获取一条记录
     *
     * @param meetingID
     * @return
     */
    Oa_meeting getByPrimaryKey(String meetingID);

    /**
     * 通过一条会议申请
     *
     * @param meeting
     * @return
     */
    Boolean approve(Oa_meeting meeting);

    /**
     * 拒绝一条会议申请
     *
     * @param meeting
     * @return
     */
    Boolean reject(Oa_meeting meeting);

    /**
     * 撤销一条会议申请
     *
     * @param meeting
     * @return
     */
    Boolean cancel(Oa_meeting meeting);

	Boolean delApproval(Oa_meeting meeting);
	//根据会议室ID删除会议信息 
	Integer delOaMeetingByMeetingRoomID(String meetingRoomID);
}
