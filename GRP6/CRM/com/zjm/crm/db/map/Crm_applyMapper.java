package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_apply;

public interface Crm_applyMapper {

	/**
	 * 查询申请分页列表
	 */
	public List<Crm_apply> selectApplyPageTable(PageTable<Crm_apply> pageTable);
	
	/**
	 * 查询申请分页列表--查询总记录数
	 */
	public Long selectApplyPageTable_Count(PageTable<Crm_apply> pageTable);
	
	/**
	 * 新增一条申请记录
	 */
	public Integer insertOneApply(Crm_apply apply);
	
	/**
	 * 插入前查询当前年份已有编号
	 */
	public String selectMaxApplyNum(Crm_apply apply);
	
	/**
	 * 修改一条申请记录
	 */
	public Integer updateOneApply(Crm_apply apply);
	
	/**
	 * 查看一条申请记录
	 */
	public Crm_apply selectOneApply(Crm_apply apply);
	
	/**
	 * 删除一条申请记录
	 */
	public Integer deleteOneApply(Crm_apply apply);
	
	/**
	 * 同意受理，设置审批状态approvalStatu = 02
	 */
	public Integer agreeToAccept(Crm_apply apply);
	
	/**
	 * 不同意受理，设置审批状态approvalStatu = 03
	 */
	public Integer disagreeToAccept(Crm_apply apply);
	
	/**
	 * 判断客户名称是否重复
	 */
	public Integer isExistClientName(Crm_apply apply);
	
//-------------------------------------------------记录添加
	/**
	 * 查询申请分页列表
	 */
	public List<Crm_apply> selectRegisterPageTable(PageTable<Crm_apply> pageTable);
	
	/**
	 * 查询申请分页列表--查询总记录数
	 */
	public Long selectRegisterPageTable_Count(PageTable<Crm_apply> pageTable);
}
