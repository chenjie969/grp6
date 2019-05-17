package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_reportXjl;
/**
 * 财务报表-现金流量表 映射mapper
 * @author zky
 * @time 2017-5-27;
 */
public interface Crm_reportXjlMapper {
	/***
	 *  返回现金流量表分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Crm_reportXjl> selectReportXjlPageTables(PageTable pageTable);
	/**
	 *  返回现金流量表分页列表记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectReportXjlPageTables_Count(PageTable pageTable);
	/**
	 * 插入一个现金流量表信息
	 * @param ReportXjl
	 * @return
	 */
	public Integer insertOneReportXjlInfo(Crm_reportXjl crm_reportXjl);
	/**
	 * 根据wheresql查询一个现金流量表信息
	 * @param wheresql:reportXjl_ID,unit_uid
	 * @return
	 */
	public Crm_reportXjl selectOneReportXjlWhereSql(String wheresql);
	/**
	 * 更新一个现金流量表信息
	 * @param crm_reportXjl
	 * @return
	 */
	public Integer updateOneReportXjlInfo(Crm_reportXjl crm_reportXjl);
	/**
	 * 根据wheresql删除一个现金流量表信息
	 * @param wheresql :reportXjl_ID,unit_uid
	 * @return
	 */
	public Integer delectReportXjlByWhereSql(String wheresql);
	
	/**
	 * @description	 根据wheresql获取list
	 * @author wuhn
	 * @date 2017年8月24日 下午5:25:08
	 */
	List<Crm_reportXjl>  selectCrm_ReportXjlList(String wheresql);
}
