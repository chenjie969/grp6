package com.zjm.crm.billRec.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.db.map.Crm_billRecMapper;
import com.zjm.crm.db.model.Crm_billRec;
import com.zjm.crm.billRec.service.BillRecService;
import com.zjm.util.Tool;

@Service("billRecService")
@Transactional
public class BillRecServiceImpl implements BillRecService {

	@Resource
	private Crm_billRecMapper billRecMapper;
	@Resource
	private LogService logService;
	
	/**
	 * 查询开票银行列表
	 */
	@Override
	public PageTable<Crm_billRec> selectBillRecPageTable(PageTable<Crm_billRec> pageTable) {
		/*	带分页
		 * Long billRecTotal = billRecMapper.selectBillRecPageTable_Count(pageTable);
		pageTable.setTotal(billRecTotal);
		List<Crm_billRec> billRecList = billRecMapper.selectBillRecPageTable(pageTable);*/
		
		List<Crm_billRec> billRecList = billRecMapper.selectBillRecList(pageTable);		//不分页
		pageTable.setRows(billRecList);
		return pageTable;
	}
	
	/**
	 * 查询开票银行
	 */
	public List<Crm_billRec> selectBillRecList(String wheresql){
		try {
			return billRecMapper.selectBillRecListByWheresql(wheresql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *  查询一条开票银行
	 */
	@Override
	public Crm_billRec selectOneBillRec(Crm_billRec billRec) {
		return billRecMapper.selectOneBillRec(billRec);
	}
	
	/**
	 *  插入一条开票银行
	 */
	@Override
	public Boolean insertOneBillRec(User user,Crm_billRec billRec) {
		billRec.setBillRec_ID(Tool.createUUID32());
		billRec.setUnit_uid(user.getUnit_uid());
		billRec.setUnit_uidName(user.getUnit_uidName());
		billRec.setUpdateUserName(user.getUser_name());
		if(billRecMapper.insertOneBillRec(billRec)==1){
			logService.insertOneOperatorLogInfo(user, "企业主要负债情况", "添加", "添加开票银行-"+billRec.getBillBank());
			return true;
		}
		else
			return false;
	}
	
	/**
	 *  修改一条开票银行
	 */
	@Override
	public Boolean updateOneBillRec(User user,Crm_billRec billRec) {
		billRec.setUpdateUserName(user.getUser_name());
		if(billRecMapper.updateOneBillRec(billRec)==1){
			logService.insertOneOperatorLogInfo(user, "企业主要负债情况", "修改","修改开票银行-"+billRec.getBillBank());
			return true;
		}else
			return false;
	}
	
	/**
	 *  删除一条开票银行
	 */
	@Override
	public Boolean deleteOneBillRec(User user,Crm_billRec billRec) {
		billRec = selectOneBillRec(billRec);
		if(billRecMapper.deleteOneBillRec(billRec)==1){
			logService.insertOneOperatorLogInfo(user, "企业主要负债情况", "删除", "删除开票银行-"+billRec.getBillBank());
			return true;
		}else
			return false;
	}

	@Override
	public Boolean deleteBillRecByClient_ID(String client_ID) {
		try {
			int deleteBillRecByClient_ID = billRecMapper.deleteBillRecByClient_ID(client_ID);
			if(deleteBillRecByClient_ID > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
