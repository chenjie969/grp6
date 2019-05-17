package com.zjm.oa.db.map;


import com.zjm.common.db.model.PageTable;
import com.zjm.oa.db.model.Oa_meetingRoom;

import java.util.List;

/**
 * Created by lancepro on 7/14/17.
 */
public interface Oa_meetingRoomMapper {
    /**
     * 根据查询sql获取匹配记录
     *
     * @param param
     * @return
     */
    List<Oa_meetingRoom> list(PageTable<Oa_meetingRoom> param);

    /**
     * 插入一条记录
     *
     * @param entity
     * @return
     */
    Integer insert(Oa_meetingRoom entity);

    /**
     * 根据主键更新一条记录
     *
     * @param entity
     * @return
     */
    Integer updateByID(Oa_meetingRoom entity);

    /**
     * 根据主键删除一条记录
     *
     * @param id
     * @return
     */
    Integer delete(String id);

    /**
     * 根据主键获取一条记录
     *
     * @param id
     * @return
     */
    Oa_meetingRoom get(String id);

    /**
     * 查询一个会议室名是否在数据库表中已存在(除了当前正在操作的记录以外）
     * @param meetingRoom
     * @return
     */
    Integer checkIdentifyOfMeetingRoomName(Oa_meetingRoom meetingRoom);
}
