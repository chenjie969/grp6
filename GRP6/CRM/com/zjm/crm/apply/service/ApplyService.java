package com.zjm.crm.apply.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_apply;

public interface ApplyService {

	/**
	 * 查询申请分页列表
	 */
	public PageTable<Crm_apply> selectApplyPageTable(PageTable<Crm_apply> pageTable);
	
	/**
	 * 查询一条申请记录
	 */
	public Crm_apply selectOneApply(Crm_apply apply);
	
	/**
	 * 插入一条申请记录
	 */
	public Boolean insertOneApply(User user,Crm_apply apply);
	
	/**
	 * 更新一条申请记录
	 */
	public Boolean updateOneApply(User user,Crm_apply apply);
	
	/**
	 * 删除一条申请记录
	 */
	public Boolean deleteOneApply(User user,Crm_apply apply);
	
	/**
	 * 同意受理，将一条申请记录转入受理申请
	 */
	public Boolean agreeToAccept(User user,Crm_apply apply);
	
	/**
	 * 不同意受理，将一条申请记录转入客户储备库
	 */
	public Boolean disagreeToAccept(User user,Crm_apply apply);
	
	/**
	 * 判断客户名称是否重复
	 */
	public Boolean isExistClientName(Crm_apply apply);
	
	/**
	 * 根据企业名称判断是否是黑名单企业
	 */
	public Boolean isExistBadClient(Crm_apply apply);
	
	/**
	 * 根据身份证号码判断是否是黑名单个人
	 */
	public Boolean isExistBadPerson(Crm_apply apply);
	
	//-------------------------------记录添加--------------------
	/**
	 * 查询记录分页列表
	 */
	public PageTable<Crm_apply> selectRegisterPageTable(PageTable<Crm_apply> pageTable);
}
