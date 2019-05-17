package com.zjm.crm.financeDesc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.db.map.Crm_financeDescMapper;
import com.zjm.crm.db.model.Crm_financeDesc;
import com.zjm.crm.financeDesc.service.FinanceDescService;
import com.zjm.util.Tool;

@Service("financeDescService")
@Transactional
public class FinanceDescServiceImpl implements FinanceDescService {

	@Resource
	private Crm_financeDescMapper financeDescMapper;
	@Resource
	private LogService logService;
	
	/**
	 *  查询一条财务状况说明
	 */
	@Override
	public Crm_financeDesc selectOneFinanceDesc(Crm_financeDesc financeDesc) {
		return financeDescMapper.selectOneFinanceDesc(financeDesc);
	}
	
	/**
	 *  插入一条财务状况说明
	 */
	@Override
	public Boolean insertOneFinanceDesc(User user,Crm_financeDesc financeDesc) {
		financeDesc.setFinanceDesc_ID(Tool.createUUID32());
		financeDesc.setUnit_uid(user.getUnit_uid());
		financeDesc.setUnit_uidName(user.getUnit_uidName());
		financeDesc.setUpdateUserName(user.getUser_name());
		if(financeDescMapper.insertOneFinanceDesc(financeDesc)==1){
//			logService.insertOneOperatorLogInfo(user, "企业财务状况说明", "添加", "添加财务状况说明-"+financeDesc.get());
			return true;
		}
		else
			return false;
	}
	
	/**
	 *  修改一条财务状况说明
	 */
	@Override
	public Boolean updateOneFinanceDesc(User user,Crm_financeDesc financeDesc) {
		financeDesc.setUpdateUserName(user.getUser_name());
		if(financeDescMapper.updateOneFinanceDesc(financeDesc)==1){
//			logService.insertOneOperatorLogInfo(user, "企业财务状况说明", "修改","修改财务状况说明-"+financeDesc.getBillBank());
			return true;
		}else
			return false;
	}

	@Override
	public Integer updateOneFinanceDesc(Crm_financeDesc financeDesc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Crm_financeDesc> selectFinanceDescListByWhereSql(String wheresql) {
		return financeDescMapper.selectFinanceDescListByWhereSql(wheresql);
	}

	@Override
	public Boolean deleteFinanceDescByWhereSql(String wheresql) {
		try {
			int info = financeDescMapper.deleteFinanceDescByWhereSql(wheresql);
			if(info > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
