package com.zjm.pro.apply.service;

import java.util.List;
import java.util.Map;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_project;

public interface ProjectApplyService {
	/***
	 *  业务申请信息表 分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectApplyPageTables(PageTable pageTable);
	
	/**
	 * 插入一个业务申请信息表信息
	 * @param 
	 * @return
	 */
	public Boolean insertOneApplyInfo(User user,Pro_apply apply);
	/**
	 * 根据wheresql查询一个业务申请信息表信息
	 * @param wheresql:
	 * @return
	 */
	public Pro_apply selectOneApplyByWhereSql(String wheresql);
	/**
	 *根据打包ID查询applyList
	 * @param wheresql:
	 * @return
	 */
	public List<Pro_apply> selectApplyListByPackageID(String wheresql);
	/**
	 * 更新一个业务申请信息表信息
	 * @param Pro_apply
	 * @return
	 */
	public Boolean updateOneApplyInfo(User user,Pro_apply apply);
	/**
	 * 更新项目结案评价
	 * 
	 */
	public Boolean updateApplySetProjectJudge(User user,Map<String,Object>  param);
	/**
	 * 根据wheresql删除一个业务申请信息表信息
	 * @param wheresql :apply_ID
	 * @return
	 */
	public Boolean delectApplyByWhereSql(User user,Pro_apply apply);
	/**
	 *	指定项目AB角 
	 */
	public Boolean updateApplySetABMan(Pro_apply  apply);
	/**
	 *	指定项目风控复核人
	 */
	public Boolean updateApplySetReviewMan(Pro_apply  apply);
	/**
	 *	指定项目法务评审人 
	 */
	public Boolean updateApplySetLegalMan(Pro_apply  apply);
	
	//上会审批--根据ID修改isArrangeMeeting
	public int updateIsArrangeMeetingById(PageTable<Pro_apply> pageTable);
	//申请记录-撤销
	public int updateIsArrangeMeetingByIds(PageTable<Pro_apply> pageTable);

	public int updateIsArrangeMeetById(Pro_apply apply);
	
	/**
	 * 申请上会处理: 设置pro_apply的上会状态
	 * @author xuyz
	 */
	public Boolean setMeetingStatusArranging(Pro_apply proApply, String meetingStatus);
	
	Boolean updateApplyYesPackage(String  str);
   /**
    * 根据project 信息修改apply
    * @param userSession
    * @param pro_project
    * @return
    */
	public Boolean updateOneApplyByApply_ID(User userSession, Pro_project pro_project);

	/**
	 * 首页获取项目进度列表
	 * @return
	 */
	public List<Pro_apply> selectProjectStageList();

	/**
	 * 查询风险项目分页列表
	 * @param PageTable<Pro_apply> pageTable
	 */
	public PageTable<Pro_apply> selectRiskApplyPageTables(PageTable<Pro_apply> pageTable);
   

}
