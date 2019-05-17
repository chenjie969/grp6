package com.zjm.pro.costReturn.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.gworkFlow.db.model.OsGworkflowFlowtemplate;
import com.zjm.gworkFlow.startWorkFlow.service.GworkFlowService;
import com.zjm.pro.costReturn.service.CostReturnService;
import com.zjm.pro.costPre.service.CostPreService;
import com.zjm.pro.db.map.Pro_costReturnMapper;
import com.zjm.pro.db.model.Pro_costReturn;
import com.zjm.pro.db.model.Pro_costPre;
import com.zjm.util.Tool;

@Transactional
@Service("costReturnService")
public class CostReturnServiceImpl implements CostReturnService {

	@Resource
	private Pro_costReturnMapper pro_costReturnMapper;
	@Resource
	private LogService logService;
	@Resource
	private CostPreService costPreService;
	@Resource
	private GworkFlowService gworkFlowService;
	
	@Override
	public PageTable<Pro_costReturn> selectCostReturnPageTable(PageTable<Pro_costReturn> pageTable) {
		try {
			List<Pro_costReturn> costReturnList = pro_costReturnMapper.selectCostReturnListByWhereSql(" and apply_ID = '"+pageTable.getQueryCondition().getApply_ID()+"'");
			pageTable.setRows(costReturnList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}
	/**
	 * 执行退费新增操作
	 */
	@Override
	public Boolean insertOneCostReturn(User user, Pro_costReturn costReturn) {
		try {
			costReturn.setCostReturn_ID(Tool.createUUID32());
			costReturn.setOperationDepartID(user.getDepart_uid());
			costReturn.setOperationDepartName(user.getDepart_name());
			costReturn.setOperationUserID(user.getUser_uid());
			costReturn.setOperationUserName(user.getUser_name());
			costReturn.setUpdateUserName(user.getUser_name());
			costReturn.setUnit_uid(user.getUnit_uid());		
			//新增退担保费用流程:
			if(costReturn.getCostTypeID().equals("f0bd2361808d4da9980f18629c236d5c")){
				OsGworkflowFlowtemplate flow = new OsGworkflowFlowtemplate();
				flow.setUnit_uid(user.getUnit_uid());
				flow.setUser_uid(user.getUser_uid());
				flow.setProjectID(costReturn.getApply_ID());
				flow.setEntityName("退费");
				flow.setBusinessId(costReturn.getCostReturn_ID());
				flow.setBusinessType(costReturn.getClass().getName());
				flow.setFlowTemplateName("退回保费流程");
				flow.setFlowTemplateID("G601");
				flow.setFlowType("02");
				Long startResult = gworkFlowService.createworkflowInstance(flow);
				if(startResult == 0){
					throw new RuntimeException("流程模板配置有误");
				}
			}else if(costReturn.getCostTypeID().equals("4bcadc946ff64ced88d0fe7f865685f9")){//新增退保证金流程
				OsGworkflowFlowtemplate flow = new OsGworkflowFlowtemplate();
				flow.setUnit_uid(user.getUnit_uid());
				flow.setUser_uid(user.getUser_uid());
				flow.setProjectID(costReturn.getApply_ID());
				flow.setEntityName("退费");
				flow.setBusinessId(costReturn.getCostReturn_ID());
				flow.setBusinessType(costReturn.getClass().getName());
				flow.setFlowTemplateName("退回保证金流程");
				flow.setFlowTemplateID("G501");
				flow.setFlowType("02");
				Long startResult = gworkFlowService.createworkflowInstance(flow);
				if(startResult == 0){
					throw new RuntimeException("流程模板配置有误");
				}
			}
			costReturn.setCostReturnState("未确认到账");
			if( 1==pro_costReturnMapper.insertOneCostReturn(costReturn)){
				logService.insertOneOperatorLogInfo(user, "实收费用", "添加", "添加一条实收费用,costReturn="+costReturn.getCostReturn_ID());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
    
	/**|
	 * 根据输入的条件查询多个退费表信息
	 */
	public List<Pro_costReturn> selectCostReturnListByWhereSql(String whereSql) {
		List<Pro_costReturn> costReturnList = pro_costReturnMapper.selectCostReturnListByWhereSql(whereSql);
		return costReturnList;
	}
     /**
      * 退费列表----确认退费
      */
	public Boolean costReturnToCostPre(User userSession, Pro_costReturn pro_costReturn) {
		Boolean b = false;  
		Pro_costReturn costReturn = new Pro_costReturn();
		if(null != pro_costReturn.getCostReturn_ID()){
			//根据id获取退费信息(退费金额)
			String  whereSql   = " and costReturn_ID = \'"+pro_costReturn.getCostReturn_ID()+"\'";
			costReturn = pro_costReturnMapper.selectOneCostReturnByWhereSql(whereSql);
			
			//根据预收表id获取预收表信息---修改预收表数据(预收金额)
			if(null != costReturn){
				Double returnCostSum = costReturn.getReturnCostSum();
				String costPre_ID = " and costPre_ID = \'"+costReturn.getCostPre_ID()+"\'";
				Pro_costPre costPre = costPreService.selectOneCostPreByWhereSql(costPre_ID);
				if(null != costPre){
					Double preCostSum = costPre.getPreCostSum();
					costPre.setPreCostSum(preCostSum-returnCostSum);
					Boolean returnBool = costPreService.updateOneCostPre(userSession, costPre);
					if(returnBool){//更新退费表信息returnCostDate
						costReturn.setCostReturnState("已确认");
						costReturn.setReturnCostDate(new Date());
						Integer resultNum  = pro_costReturnMapper.updateOneCostReturn(costReturn);
						if(resultNum > 0){
							b = true;
						}
						
					}
				}
			}
		}
		return b;
	}
     /**
      * 修改退费表信息
      */
	public Boolean updateOneCostReturn(User user, Pro_costReturn pro_costReturn) {
		Boolean b = false;
		try {
			Integer resultNum = pro_costReturnMapper.updateOneCostReturn(pro_costReturn);
			if(resultNum == 1){
				logService.insertOneOperatorLogInfo(user, "退费", "修改", "修改一条退费信息,ID="+pro_costReturn.getCostReturn_ID());
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b ;
	}
	/**
	 * 修改退费表信息
	 */
	public Boolean delOneCostReturn(User user, Pro_costReturn pro_costReturn) {
		Boolean b = false;
		try {
			Integer resultNum = pro_costReturnMapper.delOneCostReturn(pro_costReturn);
			if(resultNum == 1){
				logService.insertOneOperatorLogInfo(user, "退费", "删除", "删除一条退费信息,ID="+pro_costReturn.getCostReturn_ID());
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b ;
	}
	//分组查询
	@Override
	public List<Pro_costReturn> selectCostReturnListByWhereSqlGroup(String condition) {
		List<Pro_costReturn> costReturnList = pro_costReturnMapper.selectCostReturnListByWhereSqlGroup(condition);
		return costReturnList;
	}
	//查询一条退费信息
	@Override
	public Pro_costReturn selectOneCostReturnByWhereSql(String whereSql) {
		Pro_costReturn costReturn = new Pro_costReturn();
		try {
			costReturn = pro_costReturnMapper.selectOneCostReturnByWhereSql(whereSql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return costReturn;
	}

	

}
