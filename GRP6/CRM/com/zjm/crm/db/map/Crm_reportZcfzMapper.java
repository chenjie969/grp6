package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_reportZcfz;
/**
 * 财务报表-资产负债 映射mapper
 * @author zky
 * @time 2017-5-27;
 */
public interface Crm_reportZcfzMapper {
	/***
	 *  返回资产负债表分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Crm_reportZcfz> selectReportZcfzPageTables(PageTable pageTable);
	/**
	 *  返回资产负债表分页列表记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectReportZcfzPageTables_Count(PageTable pageTable);
	/**
	 * 插入一个资产负债表信息
	 * @param crm_reportSy
	 * @return
	 */
	public Integer insertOneReportZcfzInfo(Crm_reportZcfz crm_reportZcfz);
	/**
	 * 根据wheresql查询一个资产负债表信息
	 * @param wheresql:reportZcfz_ID,unit_uid
	 * @return
	 */
	public Crm_reportZcfz selectOneReportZcfzWhereSql(String wheresql);
	/**
	 * 更新一个资产负债表信息
	 * @param crm_reportZcfz
	 * @return
	 */
	public Integer updateOneReportZcfzInfo(Crm_reportZcfz crm_reportZcfz);
	/**
	 * 根据wheresql删除一个资产负债表信息
	 * @param wheresql :reportZcfz_ID,unit_uid
	 * @return
	 */
	public Integer delectReportZcfzByWhereSql(String wheresql);
	
	/**
	 * @description	 根据wheresql  获取一个list
	 * @author wuhn
	 * @date 2017年8月24日 下午4:47:01
	 */
	List<Crm_reportZcfz>  selectReportZcfzByList(String wheresql);

}
