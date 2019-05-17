package com.zjm.pro.applyDetail.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_applyDetail;
import com.zjm.pro.db.model.Pro_project;

public interface ApplyDetailService {
	/***
	 *  返回业务申请产品信息表分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectApplyDetailPageTables(PageTable pageTable);
	
	/**
	 * 插入一个业务申请产品信息表信息
	 * @param 
	 * @return
	 */
	public Boolean insertProjectApply(User user,Pro_applyDetail applyDetail);
	/**
	 * 根据wheresql查询一个业务申请产品信息表信息
	 * @param wheresql:
	 * @return
	 */
	public Pro_applyDetail selectOneApplyDetailByWhereSql(String wheresql);
	/**
	 * 更新一个业务申请产品信息表信息
	 * @param Pro_applyDetail
	 * @return
	 */
	public Boolean updateOneApplyDetailInfo(User user,Pro_applyDetail applyDetail);
	/**
	 * 根据wheresql删除一个业务申请产品信息表信息
	 * @param wheresql :reportSy_ID,unit_uid
	 * @return
	 */
	public Boolean deleteApplyDetailByWhereSql(User user,String wheresql);
	/**
	 * 根据wheresql查询申请明细
	 * @param wheresql:
	 * @return
	 */
	public List<Pro_applyDetail> selectApplyDetailList(String wheresql);
	
	/**
	 * 更新产品评审会决议
	 * xuyz
	 */
	public Boolean updateOneApproveGuarantee(Pro_applyDetail applyDetail);
    
	/**
	 * 根据pro_project 修改pro_apply信息
	 * @param userSession
	 * @param pro_project
	 * @return
	 */
	public Boolean updateOneApplyDetailByApplyDetail_ID(User userSession, Pro_project pro_project);
	
	/**
	 * 根据pro_project 修改pro_apply信息
	 * @param userSession
	 * @param pro_project
	 * @return
	 */
	public Boolean updateOneApplyDetail(User userSession, Pro_applyDetail applyDetail);
}
