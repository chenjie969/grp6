package com.zjm.pro.riskAppraise.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.db.map.Pro_riskAppraiseMapper;
import com.zjm.pro.db.model.Pro_riskAppraise;
import com.zjm.pro.riskAppraise.service.RiskAppraiseService;
import com.zjm.util.Tool;

@Service("RiskAppraiseService")
@Transactional
public class RiskAppraiseServiceImpl implements RiskAppraiseService {
	@Resource
	private RiskAppraiseService riskAppraiseService;
	@Resource
	private Pro_riskAppraiseMapper riskAppraiseMapper;
	@Resource
	private LogService logService;
	
   /**
    * 
    * 新增一个风险管理委员会评议
    */
	@Override
	public Boolean insertOneRiskAppraise(User userSession, Pro_riskAppraise riskAppraise) {
		
		riskAppraise.setUnit_uid(userSession.getUnit_uid());
		riskAppraise.setUpdateUserName(userSession.getUser_name());
		
		try {
			if(riskAppraiseMapper.insertOneRiskAppraise(riskAppraise)==1){
				logService.insertOneOperatorLogInfo(userSession,"新增风险管理委员会评议", "新增", "新增风险管理委员会评议"+riskAppraise.getRiskAppraise_ID());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
    /**
     * 
     * 更新风险管理委员会评议
     * 
     */
	@Override
	public Boolean updateOneRiskAppraise(User userSession, Pro_riskAppraise riskAppraise) {
		riskAppraise.setUnit_uid(userSession.getUnit_uid());
		riskAppraise.setUpdateUserName(userSession.getUser_name());
		
		try {
			
		if(riskAppraiseMapper.updateOneRiskAppraise(riskAppraise)==1){
			logService.insertOneOperatorLogInfo(userSession,"修改风险管理委员会评议", "修改", "修改风险管理委员会评议" +riskAppraise.getRiskAppraise_ID());
			return true;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
     /**
      * 
      * 查询风险管理委员会评议
      */
	@Override
	public Pro_riskAppraise selectOneRiskAppraise(String whereSql) {

		Pro_riskAppraise riskAppraise = riskAppraiseMapper.selectOneRiskAppraise(whereSql);
		
		return riskAppraise;
	}
}
