package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_reportSy;
/**
 * 损益表映射mapper
 * @author zky
 * @time 2017-5-25;
 */
public interface Crm_reportSyMapper {
	/***
	 *  返回损益表分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Crm_reportSy> selectReportSyPageTables(PageTable pageTable);
	/**
	 *  返回损益表分页列表记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectReportSyPageTables_Count(PageTable pageTable);
	/**
	 * 插入一个损益表信息
	 * @param crm_reportSy
	 * @return
	 */
	public Integer insertOneReportSyInfo(Crm_reportSy crm_reportSy);
	/**
	 * 根据wheresql查询一个损益表信息
	 * @param wheresql:reportSy_ID,unit_uid
	 * @return
	 */
	public Crm_reportSy selectOneReportSyWhereSql(String wheresql);
	/**
	 * 更新一个损益表信息
	 * @param crm_reportSy
	 * @return
	 */
	public Integer updateOneReportSyInfo(Crm_reportSy crm_reportSy);
	/**
	 * 根据wheresql删除一个损益表信息
	 * @param wheresql :reportSy_ID,unit_uid
	 * @return
	 */
	public Integer delectReportSyByWhereSql(String wheresql);
	/**
	 * 查询损益表List
	 * @param wheresql
	 * @return
	 */
	public List<Crm_reportSy> selectReportSyList(String wheresql);

}
