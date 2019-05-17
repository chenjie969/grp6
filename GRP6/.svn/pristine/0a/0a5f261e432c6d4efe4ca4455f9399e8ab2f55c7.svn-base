package com.zjm.oa.db.map;

import com.zjm.common.db.model.PageTable;
import com.zjm.oa.db.model.Oa_meeting;

import java.util.List;

/**
 * Created by lancepro on 7/14/17.
 */
public interface Oa_meetingMapper {
    /**
     * 根据参数中的Sql获取匹配的记录
     *
     * @param param
     * @return
     */
    List<Oa_meeting> list(PageTable<Oa_meeting> param);

    /**
     * 插入一条记录
     *
     * @param entity
     * @return
     */
    Integer insert(Oa_meeting entity);

    /**
     * 根据主键更新一条记录
     *
     * @param entity
     * @return
     */
    Integer updateByID(Oa_meeting entity);

    /**
     * 根据主键删除一条记录
     *
     * @param id
     * @return
     */
    Integer delete(String id);

    /**
     * 通过主键获取一条记录
     *
     * @param meeting_ID
     * @return
     */
    Oa_meeting getByPrimaryKey(String meeting_ID);

    /**
     * 获取某时间段内的会议记录
     *
     * @param param
     * @return
     */
    List<Oa_meeting> listByDuration(PageTable<Oa_meeting> param);

    /**
     * 根据会议状态获得匹配的记录
     *
     * @param param
     * @return
     */
    List<Oa_meeting> listByApprovalStatus(PageTable<Oa_meeting> param);

	Integer delOaMeetingByMeetingRoomID(String meetingRoomID);

}	
