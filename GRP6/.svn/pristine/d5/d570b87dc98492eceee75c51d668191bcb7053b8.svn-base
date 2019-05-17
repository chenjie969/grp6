package com.zjm.crm.reportZcfz.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_reportSy;
import com.zjm.crm.db.model.Crm_reportZcfz;
/**
 * 资产负债  service;
 * 
 * @author zky
 * @time   2017-5-27;
 * 
 *
 */
public interface ReportZcfzService {
	/***
	 *  返回资产负债表分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectReportZcfzPageTables(PageTable pageTable);
	
	/**
	 * 插入一个资产负债表信息
	 * @param crm_ReportZcfz
	 * @return
	 */
	public Boolean insertOneReportZcfzInfo(User user,Crm_reportZcfz reportZcfz);
	/**
	 * 根据wheresql查询一个资产负债表信息
	 * @param wheresql:reportZcfz_ID,unit_uid
	 * @return
	 */
	public Crm_reportZcfz selectOneReportZcfzWhereSql(String wheresql);
	/**
	 * 更新一个资产负债表信息
	 * @param reportZcfz
	 * @return
	 */
	public Boolean updateOneReportZcfzInfo(User user,Crm_reportZcfz reportZcfz);
	/**
	 * 根据wheresql删除一个资产负债表信息
	 * @param wheresql:reportZcfz_ID,unit_uid
	 * @return
	 */
	public Boolean delectReportZcfzByWhereSql(User user,String wheresql);
	
	
	/**
	 * @description	 根据wheresql  获取一个list
	 * @author wuhn
	 * @date 2017年8月24日 下午4:47:01
	 */
	List<Crm_reportZcfz>  selectReportZcfzByList(String wheresql);

	
}
