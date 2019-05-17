package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_guarantyRec;

public interface Crm_guarantyRecMapper {

	/**
	 * 分页查询对外担保列表
	 */
	public List<Crm_guarantyRec> selectGuarantyRecPageTable(PageTable<Crm_guarantyRec> pageTable);
	
	/**
	 * 分页查询对外担保列表-查询总记录数
	 */
	public Long selectGuarantyRecPageTable_Count(PageTable<Crm_guarantyRec> pageTable);
	
	/**
	 * 查询对外担保列表 不分页
	 */
	public List<Crm_guarantyRec> selectGuarantyRecList(PageTable<Crm_guarantyRec> pageTable);
	
	/**
	 * 查询对外担保列表 不分页
	 */
	public List<Crm_guarantyRec> selectGuarantyRecListByWheresql(String wheresql);
	
	/**
	 *  查询一条对外担保
	 */
	public Crm_guarantyRec selectOneGuarantyRec(Crm_guarantyRec guarantyRec);
	
	/**
	 *  插入一条对外担保
	 */
	public Integer insertOneGuarantyRec(Crm_guarantyRec guarantyRec);
	
	/**
	 *  修改一条对外担保
	 */
	public Integer updateOneGuarantyRec(Crm_guarantyRec guarantyRec);
	
	/**
	 *  删除一条对外担保
	 */
	public Integer deleteOneGuarantyRec(Crm_guarantyRec guarantyRec);
	
	/**
	 * @description 根据 client_ID  删除
	 * @author wuhn
	 * @date 2017年10月11日 下午5:11:49
	 */
	int  deleteGuarantyRecByClient_ID(String client_ID);
}
