package com.zjm.pro.costPre.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.costDelay.service.CostDelayService;
import com.zjm.pro.costMust.service.CostMustService;
import com.zjm.pro.costPre.service.CostPreService;
import com.zjm.pro.db.map.Pro_costFactMapper;
import com.zjm.pro.db.map.Pro_costMustMapper;
import com.zjm.pro.db.map.Pro_costPreMapper;
import com.zjm.pro.db.model.Pro_costFact;
import com.zjm.pro.db.model.Pro_costMust;
import com.zjm.pro.db.model.Pro_costPre;
import com.zjm.util.Tool;

@Transactional
@Service("costPreService")
public class CostPreServiceImpl implements CostPreService {

	@Resource
	private Pro_costPreMapper pro_costPreMapper;
	@Resource
	private Pro_costFactMapper costFactMapper;
	@Resource
	private CostMustService costMustService;
	@Resource
	private CostDelayService costDelayService;
	@Resource
	private LogService logService;
	@Resource
	private Pro_costMustMapper pro_costMustMapper;
	
	
   /**
    * 新增预收
    */
	public Boolean insertOneCostPre(User user, Pro_costPre costPre) {
		Boolean b = false;
		Integer returnInt  = 0; 
		
		costPre.setCostPre_ID(Tool.createUUID32());
		costPre.setOperationDepartID(user.getDepart_uid());
		costPre.setOperationDepartName(user.getDepart_name());
		costPre.setOperationUserID(user.getUser_id());
		costPre.setOperationUserName(user.getUser_name());
		costPre.setUnit_uid(user.getUnit_uid());
		costPre.setUpdateUserName(user.getUser_name());
		costPre.setCostPreState("未确认到账");
		try {
			returnInt = pro_costPreMapper.insertOneCostPre(costPre);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(returnInt >0){
			b  = true;
			logService.insertOneOperatorLogInfo(user, "新增一条预收信息", "新增", "costPre_ID=="+costPre.getCostPre_ID());
		}
		
		return b;
	}



     /**
      * 根据条件查询多个预收费用信息
      */
	public List<Pro_costPre> selectCostPreListByWheresql(String string) {
		List<Pro_costPre> costPreList =  pro_costPreMapper.selectCostPreListByWheresql(string);
		return costPreList;
	}


   /**
    * 预收费用--撤销---预收转应收
    */
	public Boolean costPreToCostMust(User user, Pro_costPre pro_costPre) {
		Boolean b = false;
		Boolean returnBool2= false;
		Boolean returnBool3 = false;
		 Pro_costMust costMust = new Pro_costMust(); 
		 //根据costPre_ID 获取单个costPre 信息
		Pro_costPre costPre = selectOneCostPreByWhereSql(" and  costPre_ID = \'"+pro_costPre.getCostPre_ID()+"\'");
		if(null != costPre){//根据costMust_ID 获取单个costMust信息
			costMust = costMustService.selectOneCostMustByWhereSql(" and costMust_ID = \'"+costPre.getCostMust_ID()+"\'");
			if(null != costMust){
				costMust.setCostMustState("未收到");
				returnBool2 = costMustService.updateOneCostMust(user, costMust);
				if(returnBool2){
					//根据预收id,删除此预收费用;
					returnBool3  = deleteOneCostPre(user,pro_costPre);
					if(returnBool3){
						b = true;
					}
				}
			}
		}
		return b;
	}


	 /**
	  * 删除一条预收费用记录
	  */
	public Boolean deleteOneCostPre(User user, Pro_costPre pro_costPre) {
		Boolean b = false;
		try {
			pro_costPre = pro_costPreMapper.selectOneCostPreByWhereSql(" and costPre_ID='"+pro_costPre.getCostPre_ID()+"' ");
			String costMust_ID = pro_costPre.getCostMust_ID();
			if(costMust_ID != null){
				Pro_costMust costMust = new Pro_costMust();
				costMust.setCostMust_ID(costMust_ID);
				costMust.setCostMustState("未收到");
				pro_costMustMapper.updateCostMustState(costMust);
			}
			Integer resultNum = pro_costPreMapper.deleteOneCostPre(pro_costPre);
			if(resultNum == 1){
				logService.insertOneOperatorLogInfo(user, "预收费用", "删除", "删除一条预收费用,costPre_ID="+pro_costPre.getCostPre_ID());
				b =  true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
		
	}


    /**
     * 查询单个预收表信息
     */
	public Pro_costPre selectOneCostPreByWhereSql(String whereSql) {
		Pro_costPre costPre = pro_costPreMapper.selectOneCostPreByWhereSql(whereSql);
		return costPre;
	}



	public Boolean updateOneCostPre(User user, Pro_costPre costPre) {
		try {
			Integer resultNum = pro_costPreMapper.updateOneCostPre(costPre);
			if(resultNum == 1){
				logService.insertOneOperatorLogInfo(user, "预收费用", "修改", "修改一条预收费用,ID="+costPre.getCostPre_ID());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	//分组查询
	@Override
	public List<Pro_costPre> selectCostPreListByWheresqlGroup(String condition) {
		List<Pro_costPre> costPreList =  pro_costPreMapper.selectCostPreListByWheresqlGroup(condition);
		return costPreList;
	}



	@Override
	public Boolean costPreToFact(User user, Pro_costPre costPre) {
		Boolean returnBool  = false;
		try {
			costPre = pro_costPreMapper.selectOneCostPreByWhereSql(" and costPre_ID='"+costPre.getCostPre_ID()+"'");
			costPre.setCostPreState("已确认到账");
			//更新应收状态  : 未->已确认到账
			Integer returnInt= pro_costPreMapper.costPreToFact(costPre);
			
			Pro_costFact costFact = new Pro_costFact();
			costFact.setCostFact_ID(Tool.createUUID32());
			costFact.setApply_ID(costPre.getApply_ID());
			costFact.setApplyDetail_ID(costPre.getApplyDetail_ID());
			costFact.setMeetingDetail_ID(costPre.getMeetingDetail_ID());
			costFact.setCostTypeID(costPre.getCostTypeID());
			costFact.setCostTypeName(costPre.getCostTypeName());
			costFact.setLoanPlan_ID(costPre.getLoanPlan_ID());
			costFact.setPlanFactCostDate(new Date());
			costFact.setCostRate(costPre.getCostRate());
			costFact.setCostUnit(costPre.getCostUnit());
			costFact.setFactCostSum(costPre.getPreCostSum());
			costFact.setFactCostDate(new Date());
			costFact.setCostPre_ID(costPre.getCostPre_ID());
			costFact.setRemark(costPre.getRemark());
			costFact.setOperationDepartID(user.getDepart_uid());
			costFact.setOperationDepartName(user.getDepart_name());
			costFact.setOperationUserID(user.getUser_uid());
			costFact.setOperationUserName(user.getUser_name());
			costFact.setUpdateUserName(user.getUser_name());
			costFact.setUnit_uid(user.getUnit_uid());	
			costFact.setCostFactState("未确认");
			Integer count = costFactMapper.insertOneCostFact(costFact);
			
			
			if(count>0 && returnInt>0){
				returnBool = true;
				logService.insertOneOperatorLogInfo(user, "实收费用", "添加", "添加一条实收费用,costFact_ID="+costFact.getCostFact_ID());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnBool;
	}

}
