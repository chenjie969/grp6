package com.zjm.crm.reportSy.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_reportSy;

public interface ReportSyService {
	/***
	 *  返回损益变表分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectReportSyPageTables(PageTable pageTable);
	
	/**
	 * 查询损益表List
	 */
	public List<Crm_reportSy> selectReportSyList(String wheresql);
	
	/**
	 * 插入一个损益变表信息
	 * @param crm_reportSy
	 * @return
	 */
	public Boolean insertOneReportSyInfo(User user,Crm_reportSy crm_reportSy);
	/**
	 * 根据wheresql查询一个损益表信息
	 * @param wheresql:reportSy_ID,unit_uid
	 * @return
	 */
	public Crm_reportSy selectOneReportSyWhereSql(String wheresql);
	/**
	 * 更新一个损益变表信息
	 * @param crm_reportSy
	 * @return
	 */
	public Boolean updateOneReportSyInfo(User user,Crm_reportSy crm_reportSy);
	/**
	 * 根据wheresql删除一个损益变表信息
	 * @param wheresql :reportSy_ID,unit_uid
	 * @return
	 */
	public Boolean delectReportSyByWhereSql(User user,String wheresql);
	
	
}
