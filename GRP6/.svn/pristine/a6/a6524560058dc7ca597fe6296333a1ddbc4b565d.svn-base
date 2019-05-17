package com.zjm.pro.delay.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_delay;
import com.zjm.pro.db.model.pro_manageRreviewModeExcel;
import com.zjm.pro.db.model.pro_meetingExportModeExcel;
import com.zjm.pro.db.model.pro_reviewCommitteeModeExcel;
import com.zjm.util.SystemSession;

public interface DelayService {
	/***
	 *  展期信息表 分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectDelayTables(PageTable pageTable);
	
	/**
	 * 插入一个 展期情况信息
	 * @param 
	 * @return
	 */
	public Boolean insertOneDelayInfo(User user,Pro_delay delay);
	
	
	 /**
     * 根据输入条件查询单个展期信息
     * @param string
     * @return
     */
	public Pro_delay selectOneDelayByWhereSql(String string);
	/**
	 * 根据输入条件查询多个展期信息
	 * @param string
	 * @return
	 */
	public List<Pro_delay> selectDelayListByWhereSql(String string);
    /**
     * 修改展期登记
     * @param userSession
     * @param pro_delay
     * @return
     */
	public Boolean updateOneDelay(User userSession, Pro_delay pro_delay);
	/**
	 * 根据输入的条件删除一条展期表信息
	 * @param userSession
	 * @param whereSql delay_ID
	 * @return
	 */
	public Boolean deleteDelayByWhereSql(User userSession, String whereSql);
	/**
	 * 根据输入的条件删除一条展期表信息
	 * @param userSession
	 * @param Pro_delay delay
	 * @return
	 */
	public Boolean deleteOneDelay(User userSession, Pro_delay delay);
	/**
	 * @param whereSql
	 * @return 查询一条展期信息
	 */
	public Pro_delay selectOneDelayInfo(String whereSql);
	/**
	 * 展期修改
	 */
	public Object updateProDelay(User user,Pro_delay delay);
	/**
	 * 展期删除
	 */
	public Boolean delProDelay(User userSession, Pro_delay delay);

	/**
	 * 封装 经理办公会评议项目情况简表Excel数据
	 * @param wheresql
	 * @return
	 */
	public List<pro_manageRreviewModeExcel> packageManageReviewExport(User user,Pro_apply apply);
	
	/**
	 * 封装《拟推荐上会项目清单（Ⅰ/Ⅱ）》Excel数据
	 * @param wheresql
	 * @return
	 */
	public List<pro_meetingExportModeExcel> packageMeetingExport(Pro_apply apply);

	/**
	 * 封装 项目评议委员会评审通过项目情况简表(Ⅰ)Excel数据
	 * @param apply
	 * @return
	 */
	public List<pro_reviewCommitteeModeExcel> packageCommitteeExport(Pro_apply apply);
	
}
