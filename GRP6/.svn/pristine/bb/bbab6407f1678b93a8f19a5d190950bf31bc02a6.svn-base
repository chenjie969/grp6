package com.zjm.crm.payTaxInfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.db.map.Crm_payTaxInfoMapper;
import com.zjm.crm.db.model.Crm_payTaxInfo;
import com.zjm.crm.payTaxInfo.service.PayTaxInfoService;
import com.zjm.util.Tool;

@Service("payTaxInfoService")
@Transactional
public class PayTaxInfoServiceImpl implements PayTaxInfoService {

	@Resource
	private Crm_payTaxInfoMapper payTaxInfoMapper;
	@Resource
	private LogService logService;
	
	/**
	 * 分页查询企业纳税情况列表
	 */
	@Override
	public PageTable<Crm_payTaxInfo> selectPayTaxInfoPageTable(PageTable<Crm_payTaxInfo> pageTable) {
		List<Crm_payTaxInfo> payTaxInfoList = payTaxInfoMapper.selectPayTaxInfoPageTable(pageTable);
		pageTable.setRows(payTaxInfoList);
		Long payTaxInfoTotal = payTaxInfoMapper.selectPayTaxInfoPageTable_Count(pageTable);
		pageTable.setTotal(payTaxInfoTotal);
		return pageTable;
	}
	
	/**
	 * 查询企业纳税情况列表
	 */
	public List<Crm_payTaxInfo> selectPayTaxInfoList(String wheresql){
		try {
			return payTaxInfoMapper.selectPayTaxInfoList(wheresql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *  查询一条企业纳税情况
	 */
	@Override
	public Crm_payTaxInfo selectOnePayTaxInfo(Crm_payTaxInfo payTaxInfo) {
		return payTaxInfoMapper.selectOnePayTaxInfo(payTaxInfo);
	}
	
	/**
	 *  插入一条企业纳税情况
	 */
	@Override
	public Boolean insertOnePayTaxInfo(User user,Crm_payTaxInfo payTaxInfo) {
		payTaxInfo.setPayTaxInfo_ID(Tool.createUUID32());
		payTaxInfo.setUnit_uid(user.getUnit_uid());
		payTaxInfo.setUnit_uidName(user.getUnit_uidName());
		payTaxInfo.setUpdateUserName(user.getUser_name());
		if(payTaxInfoMapper.insertOnePayTaxInfo(payTaxInfo)==1){
			logService.insertOneOperatorLogInfo(user, "企业经营情况", "添加", "添加企业纳税情况-"+payTaxInfo.getPeriod());
			return true;
		}
		else
			return false;
	}
	
	/**
	 *  修改一条企业纳税情况
	 */
	@Override
	public Boolean updateOnePayTaxInfo(User user,Crm_payTaxInfo payTaxInfo) {
		payTaxInfo.setUpdateUserName(user.getUser_name());
		if(payTaxInfoMapper.updateOnePayTaxInfo(payTaxInfo)==1){
			logService.insertOneOperatorLogInfo(user, "企业经营情况", "修改","修改企业纳税情况-"+payTaxInfo.getPeriod());
			return true;
		}else
			return false;
	}
	
	/**
	 *  删除一条企业纳税情况
	 */
	@Override
	public Boolean deleteOnePayTaxInfo(User user,Crm_payTaxInfo payTaxInfo) {
		payTaxInfo = selectOnePayTaxInfo(payTaxInfo);
		if(payTaxInfoMapper.deleteOnePayTaxInfo(payTaxInfo)==1){
			logService.insertOneOperatorLogInfo(user, "企业经营情况", "删除", "删除企业纳税情况-"+payTaxInfo.getPeriod());
			return true;
		}else
			return false;
	}

	@Override
	public Boolean deletePayTaxByClient_ID(String client_ID) {
		try {
			int deletePayTaxByClient_ID = payTaxInfoMapper.deletePayTaxByClient_ID(client_ID);
			if(deletePayTaxByClient_ID > 0 ){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
