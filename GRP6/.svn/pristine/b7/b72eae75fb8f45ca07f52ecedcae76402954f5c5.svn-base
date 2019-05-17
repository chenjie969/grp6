package com.zjm.crm.reportXjl.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_reportXjl;

public interface ReportXjlService {
	/***
	 *  返回现金流表分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectReportXjlPageTables(PageTable pageTable);
	
	/**
	 * 插入一个现金流表信息
	 * @param crm_reportXjl
	 * @return
	 */
	public Boolean insertOneReportXjlInfo(User user,Crm_reportXjl crm_reportXjl);
	/**
	 * 根据wheresql查询一个现金流表信息
	 * @param wheresql:reportXjl_ID,unit_uid
	 * @return
	 */
	public Crm_reportXjl selectOneReportXjlWhereSql(String wheresql);
	/**
	 * 更新一个现金流表信息
	 * @param crm_reportXjl
	 * @return
	 */
	public Boolean updateOneReportXjlInfo(User user,Crm_reportXjl crm_reportXjl);
	/**
	 * 根据wheresql删除一个现金流表信息
	 * @param wheresql :reportXjl_ID,unit_uid
	 * @return
	 */
	public Boolean delectReportXjlByWhereSql(User user,String wheresql);
	
	/**
	 * @description	 根据wheresql获取list
	 * @author wuhn
	 * @date 2017年8月24日 下午5:25:08
	 */
	List<Crm_reportXjl>  selectCrm_ReportXjlList(String wheresql);
	
}
