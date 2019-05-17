package com.zjm.crm.riskLevel.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.map.Crm_riskLevelRecMapper;
import com.zjm.crm.db.model.Crm_riskLevelRec;
import com.zjm.crm.riskLevel.service.RiskLevelService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.util.Tool;
@Service("riskLevelService")
@Transactional
public class RiskLevelServiceImpl implements RiskLevelService {
      @Resource
	 private Crm_riskLevelRecMapper riskLevelMapper;
      @Resource
  	private ClientService clientService;
      @Resource
  	private ProjectApplyService projectApplyService;
      @Resource
      private LogService logService;
      /**
       * 增加一条风险评定记录
       */
	@Override
	public Boolean insertOneRiskLevelRec(User user, Crm_riskLevelRec riskLevelRec) {
		riskLevelRec.setRiskLevelRec_ID(Tool.createUUID32());
		riskLevelRec.setChangeUserID(user.getUser_uid());
		riskLevelRec.setChangeUserName(user.getUser_name());
		riskLevelRec.setUnit_uid(user.getUnit_uid());
		riskLevelRec.setUnit_uidName(user.getUnit_uidName());
		riskLevelRec.setUpdateUserName(user.getUser_name());
		// 更新客户表中的风险等级
		clientService.updateRiskLevelByClient_ID(user, riskLevelRec);
		// 添加一条风险等级记录
		if (riskLevelMapper.insertOneRiskLevelRec (riskLevelRec)== 1){
			logService.insertOneOperatorLogInfo(user, "风险等级评定", "添加", "添加等级风险"+riskLevelRec.getRiskLevelID());
			return true;
		     }
		else{
		  return false;
		}
		
	}

	
	@Override
	public PageTable<Crm_riskLevelRec> selectRiskLevelPageTable(PageTable<Crm_riskLevelRec> pageTable) {
		String wheresql = " and apply_ID = '"+pageTable.getQueryCondition().getApply_ID()+"'";
		Pro_apply pro_apply = projectApplyService.selectOneApplyByWhereSql(wheresql);
		pageTable.getQueryCondition().setClient_ID(pro_apply.getClient_ID());
        List <Crm_riskLevelRec> list =riskLevelMapper.selectRiskLevelPageTable(pageTable);
		pageTable.setRows(list);
		return pageTable;
	}


	@Override
	public Crm_riskLevelRec selectOneRiskLevelInfo(String wheresql) {
		return riskLevelMapper.selectOneRiskLevelInfo(wheresql);
	}
	@Override
	public List<Crm_riskLevelRec> selectRiskLevelList(String wheresql) {
		return riskLevelMapper.selectRiskLevelList(wheresql);
	}


	@Override
	public Boolean updateOneRiskLevelInfo(Crm_riskLevelRec riskLevelRec) {
	
			if(riskLevelMapper.updateOneRiskLevelInfo(riskLevelRec)==1){
				return true;
			};
			return false;
	}


	@Override
	public Boolean deleteRiskLevelByClient_ID(String client_ID) {
		try {
			int deleteRiskLevelByClient_ID = riskLevelMapper.deleteRiskLevelByClient_ID(client_ID);
			if(deleteRiskLevelByClient_ID > 0){
				
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

    /**
     * 删除风险等级记录
     */
	@Override
	public Boolean deleteOneRiskLevelByID(User user, String riskLevelRec_ID) {
		if (riskLevelMapper.deleteOneRiskLevelByID(riskLevelRec_ID)==1){
			logService.insertOneOperatorLogInfo(user, "风险等级评定", "删除", "删除等级风险");
			return true;
	      }
	  else {
		return false;
	  }

	}
}
