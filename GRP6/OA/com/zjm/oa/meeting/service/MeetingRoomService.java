package com.zjm.oa.meeting.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.oa.db.model.Oa_meetingRoom;

import java.util.List;

/**
 * Created by lancepro on 7/14/17.
 */
public interface MeetingRoomService {
    /**
     * 更新会议室
     * @param entity
     * @return
     */
    Integer update(Oa_meetingRoom entity);

    /**
     * 新增会议室
     * @param entity
     * @return
     */
    Integer save(Oa_meetingRoom entity);

    /**
     * 删除会议室
     * @param meetingRoomID
     * @return
     */
    Integer delete(String meetingRoomID);

    /**
     *  根据参数的sql查询满足条件的记录
     * @param param
     * @return
     */
    List<Oa_meetingRoom> list(PageTable<Oa_meetingRoom> param);

    /**
     * 通过主键ID获取记录
     * @param meetingRoomID
     * @return
     */
    Oa_meetingRoom get(String meetingRoomID);

    /**
     * 查询一个会议室名是否在数据库表中已存在(除了当前正在操作的记录以外）
     * @param meetingRoom
     * @return
     */
    Boolean meetingNameExists(Oa_meetingRoom meetingRoom);
}
