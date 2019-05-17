package com.zjm.crm.bankAccount.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.bankAccount.service.BankAccountService;
import com.zjm.crm.db.map.Crm_bankAccountMapper;
import com.zjm.crm.db.model.Crm_bankAccount;
import com.zjm.util.Tool;

/**
*  @description 银行开户信息 serviceImpl
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年5月5日 下午12:55:28
*/
@Service(value="bankAccountService")
@Transactional
public class BankAccountServiceImpl implements BankAccountService{
	
	@Resource
	private Crm_bankAccountMapper 	crm_bankAccountMapper;
	@Resource
	private LogService 	logService;
	
	/**
	 * 查询银行开户信息分页列表  wuhn
	 * @param pageTable
	 * @author wuhn
	 * @return
	 */
	public PageTable<Crm_bankAccount> selectCompanysCrm_bankAccountPageTables(PageTable<Crm_bankAccount> pageTable){
		List<Crm_bankAccount> list = crm_bankAccountMapper.selectCompanysCrm_bankAccountPageTables(pageTable);//分页 列表
		Long count = crm_bankAccountMapper.selectCompanyCrm_bankAccountPageTables_Count(pageTable); //银行开户表总记录数
		pageTable.setRows(list);
		pageTable.setTotal(count);
		return pageTable;
	}
	
	/**
	 * 
	 * @description   查询所有的银行开户信息 分页列表 总记录数
	 * @author wuhn
	 * @date 2017年5月4日 下午1:24:51
	 */
	public Long selectCompanyCrm_bankAccountPageTables_Count(PageTable<Crm_bankAccount> pageTable){
		return crm_bankAccountMapper.selectCompanyCrm_bankAccountPageTables_Count(pageTable);
	}
	/**
	 * @description  添加/插入一个银行开户信息信息
	 * @author wuhn
	 * @date 2017年5月4日 上午10:09:08
	 */
	public Boolean  insertOneCompanyCrm_bankAccountInfo(Crm_bankAccount crm_bankAccount,User user){
		crm_bankAccount.setBankaccountId(Tool.createUUID32());//设置流水号    bankAccount_ID
		return  crm_bankAccountMapper.insertOneCompanyCrm_bankAccountInfo(crm_bankAccount)>0;
	}
	
	/**
	 * 更新 修改一个银行开户信息信息
	 * @description
	 * @author wuhn
	 * @date 2017年5月4日 上午10:13:46
	 */
	public Boolean updateOneCompanyCrm_bankAccountInfo(Crm_bankAccount Crm_bankAccount,User user){
		Integer returnInt = 0;
		try {
			returnInt = crm_bankAccountMapper.updateOneCompanyCrm_bankAccountInfo(Crm_bankAccount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(returnInt>0){
			return 	true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * 删除 移除一个银行开户信息信息 根据银行开户id删除
	 * @description
	 * @author wuhn
	 * @date 2017年5月4日 上午10:14:02
	 */
	public Boolean deleteOneCompanyCrm_bankAccountInfo(Crm_bankAccount Crm_bankAccount,User user){
		return crm_bankAccountMapper.deleteOneCompanyCrm_bankAccountInfo(Crm_bankAccount)>0;
	}

	/**
	 * 删除 移除一个银行开户信息信息  根据客户id删除全部银行信息
	 * @description
	 * @author wuhn
	 * @date 2017年5月4日 上午10:14:02
	 */
	public Boolean deleteOneCompanyCrm_bankAccountByClient_ID(String Client_ID,User user){
		if(crm_bankAccountMapper.deleteOneCompanyCrm_bankAccountByClient_ID(Client_ID)>0){
			logService.insertOneOperatorLogInfo(user,"银行开户信息", "删除", "删除银行开户信息");
			return  true;
		}else{
			
			return false;
		}
	}
	
	/**
	 * 根据银行id查询一个银行开户信息 
	 * @description
	 * @author wuhn
	 * @date 2017年5月4日 上午10:14:02
	 */
	public Crm_bankAccount selectOneCompanyCrm_bankAccountInfo(Crm_bankAccount Crm_bankAccount){
		Crm_bankAccount bankAccount = crm_bankAccountMapper.selectOneCompanyCrm_bankAccountInfo(Crm_bankAccount);
		return bankAccount;
	}
	
	/**
	 * 根据客户id 查询一个银行开户信息 
	 * @description
	 * @author wuhn
	 * @date 2017年5月4日 上午10:14:02
	 */
	public List<Crm_bankAccount> selectCompanyCrm_bankAccountByClient_ID(Crm_bankAccount Crm_bankAccount){
		return crm_bankAccountMapper.selectCompanyCrm_bankAccountByClient_ID(Crm_bankAccount);
	}
	
}
