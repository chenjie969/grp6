package com.zjm.crm.loanRec.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.db.map.Crm_loanRecMapper;
import com.zjm.crm.db.model.Crm_loanRec;
import com.zjm.crm.loanRec.service.LoanRecService;
import com.zjm.util.Tool;

@Service("loanRecService")
@Transactional
public class LoanRecServiceImpl implements LoanRecService {

	@Resource
	private Crm_loanRecMapper loanRecMapper;
	@Resource
	private LogService logService;
	
	/**
	 * 查询贷款银行列表
	 */
	@Override
	public PageTable<Crm_loanRec> selectLoanRecPageTable(PageTable<Crm_loanRec> pageTable) {
		/* 带分页
		 * Long loanRecTotal = loanRecMapper.selectLoanRecPageTable_Count(pageTable);
		pageTable.setTotal(loanRecTotal);
		List<Crm_loanRec> loanRecList = loanRecMapper.selectLoanRecPageTable(pageTable);*/
		
		List<Crm_loanRec> loanRecList = loanRecMapper.selectLoanRecList(pageTable);	//不分页
		pageTable.setRows(loanRecList);
		return pageTable;
	}
	
	/**
	 * 查询贷款银行
	 */
	public List<Crm_loanRec> selectLoanRecList(String wheresql){
		return loanRecMapper.selectLoanRecListByWheresql(wheresql);
	}
	
	/**
	 *  查询一条贷款银行
	 */
	@Override
	public Crm_loanRec selectOneLoanRec(Crm_loanRec loanRec) {
		return loanRecMapper.selectOneLoanRec(loanRec);
	}
	
	/**
	 *  插入一条贷款银行
	 */
	@Override
	public Boolean insertOneLoanRec(User user,Crm_loanRec loanRec) {
		loanRec.setLoanRec_ID(Tool.createUUID32());
		loanRec.setUnit_uid(user.getUnit_uid());
		loanRec.setUnit_uidName(user.getUnit_uidName());
		loanRec.setUpdateUserName(user.getUser_name());
		if(loanRecMapper.insertOneLoanRec(loanRec)==1){
			logService.insertOneOperatorLogInfo(user, "企业主要负债情况", "添加", "添加贷款银行-"+loanRec.getLoanBank());
			return true;
		}
		else
			return false;
	}
	
	/**
	 *  修改一条贷款银行
	 */
	@Override
	public Boolean updateOneLoanRec(User user,Crm_loanRec loanRec) {
		loanRec.setUpdateUserName(user.getUser_name());
		if(loanRecMapper.updateOneLoanRec(loanRec)==1){
			logService.insertOneOperatorLogInfo(user, "企业主要负债情况", "修改","修改贷款银行-"+loanRec.getLoanBank());
			return true;
		}else
			return false;
	}
	
	/**
	 *  删除一条贷款银行
	 */
	@Override
	public Boolean deleteOneLoanRec(User user,Crm_loanRec loanRec) {
		loanRec = selectOneLoanRec(loanRec);
		if(loanRecMapper.deleteOneLoanRec(loanRec)==1){
			logService.insertOneOperatorLogInfo(user, "企业主要负债情况", "删除", "删除贷款银行-"+loanRec.getLoanBank());
			return true;
		}else
			return false;
	}

	@Override
	public Boolean deleteLoanRecByClient_ID(String client_ID) {
		try {
			int deleteLoanRecByClient_ID = loanRecMapper.deleteLoanRecByClient_ID(client_ID);
			if(deleteLoanRecByClient_ID > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
