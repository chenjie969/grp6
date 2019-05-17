package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.crm.db.model.Crm_bankAccount;
import com.zjm.common.db.model.PageTable;

public interface Crm_bankAccountMapper {

	/**
	 * 查询银行开户信息分页列表  wuhn
	 * @param pageTable
	 * @author wuhn
	 * @return
	 */
	public List<Crm_bankAccount> selectCompanysCrm_bankAccountPageTables(PageTable<Crm_bankAccount> pageTable);
	
	/**
	 * 
	 * @description   查询所有的银行开户信息 分页列表 总记录数
	 * @author wuhn
	 * @date 2017年5月4日 下午1:24:51
	 */
	public Long selectCompanyCrm_bankAccountPageTables_Count(PageTable<Crm_bankAccount> pageTable);
	/**
	 * @description  添加/插入一个银行开户信息信息
	 * @author wuhn
	 * @date 2017年5月4日 上午10:09:08
	 */
	public Integer insertOneCompanyCrm_bankAccountInfo(Crm_bankAccount Crm_bankAccount);
	
	/**
	 * 更新 修改一个银行开户信息信息
	 * @description
	 * @author wuhn
	 * @date 2017年5月4日 上午10:13:46
	 */
	public Integer updateOneCompanyCrm_bankAccountInfo(Crm_bankAccount Crm_bankAccount);
	
	/**
	 * 删除 移除一个银行开户信息信息 根据银行开户id删除
	 * @description
	 * @author wuhn
	 * @date 2017年5月4日 上午10:14:02
	 */
	public Integer deleteOneCompanyCrm_bankAccountInfo(Crm_bankAccount Crm_bankAccount);

	/**
	 * 删除 移除一个银行开户信息信息  根据客户id删除全部银行信息
	 * @description
	 * @author wuhn
	 * @date 2017年5月4日 上午10:14:02
	 */
	public Integer deleteOneCompanyCrm_bankAccountByClient_ID(String client_ID);
	
	/**
	 * 根据银行id查询一个银行开户信息 
	 * @description
	 * @author wuhn
	 * @date 2017年5月4日 上午10:14:02
	 */
	public Crm_bankAccount selectOneCompanyCrm_bankAccountInfo(Crm_bankAccount Crm_bankAccount);
	
	/**
	 * 根据客户id 查询一个银行开户信息 
	 * @description
	 * @author wuhn
	 * @date 2017年5月4日 上午10:14:02
	 */
	public List<Crm_bankAccount> selectCompanyCrm_bankAccountByClient_ID(Crm_bankAccount Crm_bankAccount);
	
}