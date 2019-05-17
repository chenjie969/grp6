package com.zjm.pro.costMust.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.costMust.service.CostMustService;
import com.zjm.pro.costPre.service.CostPreService;
import com.zjm.pro.db.map.Pro_costMustMapper;
import com.zjm.pro.db.map.Pro_costPreMapper;
import com.zjm.pro.db.model.Pro_costMust;
import com.zjm.pro.db.model.Pro_costPre;
import com.zjm.pro.meetingCost.service.MeetingCostService;
import com.zjm.util.Tool;

@Service("costMustService")
@Transactional
public class CostMustServiceImpl implements CostMustService {

	@Resource
	private Pro_costMustMapper pro_costMustMapper;
	@Resource
	private MeetingCostService meetingCostService;
	@Resource
	private LogService logService;
	@Resource
	private CostPreService costPreService;
	@Resource
	private Pro_costPreMapper pro_costPreMapper;
	
	@Override
	public PageTable<Pro_costMust> selectCostMustPageTable(PageTable<Pro_costMust> pageTable) {
		List<Pro_costMust> costMustList = null;
		try {
			costMustList = pro_costMustMapper.selectApplyPageTables(pageTable);
			Long total = pro_costMustMapper.selectApplyPageTables_Count(pageTable);
			pageTable.setRows(costMustList);
			pageTable.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}

	@Override
	public Boolean insertOneCostMust(User user, Pro_costMust costMust) {
		try {
			costMust.setCostMust_ID(Tool.createUUID32());
			costMust.setOperationDepartID(user.getDepart_uid());
			costMust.setOperationDepartName(user.getDepart_name());
			costMust.setOperationUserID(user.getUser_uid());
			costMust.setOperationUserName(user.getUser_name());
			costMust.setUpdateUserName(user.getUser_name());
			costMust.setUnit_uid(user.getUnit_uid());
			costMust.setCostMustState("未收到");
			if( 1==pro_costMustMapper.insertOneCostMust(costMust)){
				logService.insertOneOperatorLogInfo(user, "应收费用", "添加", "添加一条应收费用,ID="+costMust.getCostMust_ID());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	

	@Override
	public Pro_costMust selectOneCostMust(Pro_costMust costMust) {
		try {
			costMust = pro_costMustMapper.selectOneCostMust(costMust);
			return costMust;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean updateOneCostMust(User user, Pro_costMust costMust) {
		try {
			costMust.setUpdateUserName(user.getUser_name());
			Integer resultNum = pro_costMustMapper.updateOneCostMust(costMust);
			if(resultNum == 1){
				logService.insertOneOperatorLogInfo(user, "应收费用", "修改", "修改一条应收费用,ID="+costMust.getCostMust_ID());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


     /**
      * 到账确认--应收转预收
      */
	public Boolean costMustToPre(User user, Pro_costMust pro_costMust) {
		Boolean b = false;
		Boolean returnBool  = false;
		   //更新应收状态  : 未收->已收
		Pro_costMust costMust = new Pro_costMust (); 
		Pro_costPre costPre= new Pro_costPre();
		Integer returnInt  = 0;
		String whereSql = " and costMust_ID = \'"+pro_costMust.getCostMust_ID()+"\'";
		costMust =  pro_costMustMapper.selectOneCostMustByWhereSql(whereSql);
		if(null != costMust){
			costMust.setCostMustState("已收到");
			returnInt= pro_costMustMapper.updateOneCostMust(costMust);
		}
		if(returnInt> 0){
			//在预收费用中插入一条数据---start
			costPre.setCostPre_ID(Tool.createUUID32());
			costPre.setApplyDetail_ID(costMust.getApplyDetail_ID());
			costPre.setApply_ID(costMust.getApply_ID());
			costPre.setMeetingDetail_ID(costMust.getMeetingDetail_ID());
			costPre.setCostTypeID(costMust.getCostTypeID());
			costPre.setCostTypeName(costMust.getCostName());
			costPre.setCostRate(costMust.getCostRate());
			costPre.setCostUnit(costMust.getCostUnit());
			costPre.setPreCostSum(costMust.getMustCostSum());
			costPre.setPreCostDate(new Date());
			costPre.setRemark(costMust.getRemark());
			costPre.setOperationDepartID(costMust.getOperationDepartID());
			costPre.setOperationDepartName(costMust.getOperationDepartName());
			costPre.setOperationUserID(costMust.getOperationUserID());
			costPre.setOperationUserName(costMust.getOperationUserName());
			costPre.setUnit_uid(costMust.getUnit_uid());
			costPre.setUpdateUserName(user.getUser_name());
			costPre.setUpdateDateTime(new Date());
			costPre.setCostPreState("未确认到账");
			costPre.setLoanPlan_ID(costMust.getLoanPlan_ID());
			costPre.setCostMust_ID(costMust.getCostMust_ID());
			Integer count = pro_costPreMapper.insertOneCostPre(costPre);
			if(count>0){
				returnBool = true;
			}
			//在预收费用中插入一条数据---end
			if(returnBool){
				b=true;
			}
			
		}
		return b;
	}

	public List<Pro_costMust> selectCostMustListByWheresql(String whereSql) {
		List<Pro_costMust> costMustList = new ArrayList<Pro_costMust>();
		try {
			costMustList = pro_costMustMapper.selectCostMustListByWheresql(whereSql);
			return costMustList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return costMustList;
	}

	public Pro_costMust selectOneCostMustByWhereSql(String string) {
		Pro_costMust pro_costMust = new Pro_costMust();
		try {
			pro_costMust  = pro_costMustMapper.selectOneCostMustByWhereSql(string);
			return pro_costMust;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pro_costMust;
	}

	/**
	 * 删除一条应收费用信息
	 */
	@Override
	public Boolean deleteOneCostMust(User user, Pro_costMust costMust) {
		try {
			if(1==deleteCostMustByWheresql(" and costMust_ID='"+costMust.getCostMust_ID()+"'")){
				logService.insertOneOperatorLogInfo(user, "担保收费", "删除", "删除一条应收费用信息,costMust_ID="+costMust.getCostMust_ID());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 根据条件删除应收费用信息(删除放款计划或还款计划时批量删除用)
	 */
	@Override
	public Integer deleteCostMustByWheresql(String wheresql) {
		try {
			Integer result = pro_costMustMapper.deleteCostMustByWheresql(wheresql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//分组查询
	@Override
	public List<Pro_costMust> selectCostMustListByWheresqlGroup(String condition) {
		List<Pro_costMust> costMustList = new ArrayList<Pro_costMust>();
		try {
			costMustList = pro_costMustMapper.selectCostMustListByWheresqlGroup(condition);
			return costMustList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return costMustList;
	}
	
}
