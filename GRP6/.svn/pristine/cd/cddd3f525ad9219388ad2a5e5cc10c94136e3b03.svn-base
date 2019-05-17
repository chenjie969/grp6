package com.zjm.pro.costFact.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.costFact.service.CostFactService;
import com.zjm.pro.costPre.service.CostPreService;
import com.zjm.pro.db.map.Pro_costFactMapper;
import com.zjm.pro.db.map.Pro_costPreMapper;
import com.zjm.pro.db.model.Pro_costFact;
import com.zjm.pro.db.model.Pro_costMust;
import com.zjm.pro.db.model.Pro_costPre;
import com.zjm.pro.db.model.Pro_projectCode;
import com.zjm.sys.db.model.C_busiSort;
import com.zjm.util.Tool;

@Transactional
@Service("costFactService")
public class CostFactServiceImpl implements CostFactService {

	@Resource
	private Pro_costFactMapper pro_costFactMapper;
	@Resource
	private Pro_costPreMapper costPreMapper;
	@Resource
	private LogService logService;
	@Resource
	private CostPreService costPreService;
	
	@Override
	public PageTable<Pro_costFact> selectCostFactPageTable(PageTable<Pro_costFact> pageTable) {
		try {
			List<Pro_costFact> costFactList = pro_costFactMapper.selectCostFactListByWhereSql(" and costfact.apply_ID = '"+pageTable.getQueryCondition().getApply_ID()+"'");
			pageTable.setRows(costFactList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}


	@Override
	public Boolean insertOneCostFact(User user, Pro_costFact costFact) {
		try {
			costFact.setCostFact_ID(Tool.createUUID32());
			costFact.setOperationDepartID(user.getDepart_uid());
			costFact.setOperationDepartName(user.getDepart_name());
			costFact.setOperationUserID(user.getUser_uid());
			costFact.setOperationUserName(user.getUser_name());
			costFact.setUpdateUserName(user.getUser_name());
			costFact.setUnit_uid(user.getUnit_uid());	
			costFact.setCostFactState("未确认");
			if( 1==pro_costFactMapper.insertOneCostFact(costFact)){
				logService.insertOneOperatorLogInfo(user, "实收费用", "添加", "添加一条实收费用,costFact_ID="+costFact.getCostFact_ID());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Pro_costFact> selectCostFactListByWhereSql(String string) {
		List<Pro_costFact> costFactList = pro_costFactMapper.selectCostFactListByWhereSql(string);
		return costFactList;
	}

  /**
   * 实收转预收
   */
	public Boolean costFactToCostPre(User user, Pro_costFact pro_costFact) {
		Boolean b = false;
		Boolean returnBool2= false;
		 Pro_costPre costPre = new Pro_costPre(); 
		 //根据costFact_ID 获取单个pro_costFact 信息
		Pro_costFact costFact = selectOneCostFactByWhereSql(" and  costFact_ID = \'"+pro_costFact.getCostFact_ID()+"\'");
		if(null != costFact){
			costFact.setCostFactState("未确认");
			Integer returnInt = pro_costFactMapper.updateOneCostFact(costFact);
			if(returnInt >0){
				//根据costPre_ID 获取单个costPre信息
				costPre = costPreService.selectOneCostPreByWhereSql(" and costPre_ID = \'"+costFact.getCostPre_ID()+"\'");
				if(null != costPre){
					costPre.setCostPreState("未确认到账");
					returnBool2 = costPreService.updateOneCostPre(user, costPre);
					if(returnBool2){
						b = true;
					}
				}
			}
		}
		
		return b;
	}

		
	public Boolean deleteOneCostFact(User user, Pro_costFact costFact) {
			Boolean b = false;
			try {
				costFact = pro_costFactMapper.selectOneCostFactByWhereSql(" and costFact_ID='"+costFact.getCostFact_ID()+"' ");
				String costPre_ID = costFact.getCostPre_ID();
				if(costPre_ID !=null){
					Pro_costPre costPre = new Pro_costPre();
					costPre.setCostPre_ID(costPre_ID);
					costPre.setCostPreState("未确认到账");
					costPreMapper.costPreToFact(costPre);
				}
				
				Integer resultNum = pro_costFactMapper.deleteOneCostFact(costFact);
				
				
				if(resultNum > 0){
					logService.insertOneOperatorLogInfo(user, "实收费用", "删除", "删除一条实收费用,costFact_ID="+costFact.getCostFact_ID());
					b =  true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return b;
		}


	public Pro_costFact selectOneCostFactByWhereSql(String string) {
			Pro_costFact costFact =  pro_costFactMapper.selectOneCostFactByWhereSql(string);
			return costFact;
		}

    
	/**
	 * 收入计划调整
	 */
 	public Boolean insertCostPlanToCostFact(User user, Pro_costFact pro_costFact) {
 		Boolean b = false; 
 		try {
			Pro_costFact costFact =  pro_costFactMapper.selectOneCostFactByWhereSql(" and costPre_ID = \'"+pro_costFact.getCostPre_ID()+"\'");
			
			
			String[] strArr = pro_costFact.getPlanFactTableData().split(";");//获取前台拼接字符串;			
			List<String[]> stringList = new  ArrayList<>();			
			for (int i = 0; i < strArr.length; i++) {
				stringList.add(strArr[i].split(",",-1)) ;//拆分业务明细.存放在list中;	
			}			
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 if(null != costFact){//不为空
				 //将其删除,在将拆分的数据进行插入
				 //删除此记录-----start
			  Integer returnInt = pro_costFactMapper.deleteOneCostFactByWhereSql(" and costPre_ID = \'"+costFact.getCostPre_ID()+"\'");
				 //删除此记录-----end
				 if(returnInt>0){//删除成功
					 for (String[] strings : stringList) {//遍历list,取值后放入相应属性中,存入数据库
							int	j=0;
							costFact.setCostFact_ID(Tool.createUUID32());
							costFact.setFactCostSum(Double.valueOf(strings[j++]).doubleValue());
							try {
								  Date planFactCostDate = sdf.parse((strings[j++]).toString());
								costFact.setPlanFactCostDate(planFactCostDate);
							} catch (ParseException e) {
								e.printStackTrace();
							}
							if( 1==pro_costFactMapper.insertOneCostFact(costFact)){
								logService.insertOneOperatorLogInfo(user, "实收费用", "添加", "添加一条实收费用,costFact_ID="+costFact.getCostFact_ID());
								b = true;
							}	
						}
				 }
				
				 
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

 	@Override
	public Boolean updateOneCostFact(User userSession, Pro_costFact pro_costFact) {
		Boolean b  = true;
		
		try {
			Integer returnInt = pro_costFactMapper.updateOneCostFact(pro_costFact);
			if(returnInt >0){
				//根据id获取实收表信息----
				Pro_costFact costFact = pro_costFactMapper.selectOneCostFactByWhereSql(" and costFact_ID = \'"+pro_costFact.getCostFact_ID()+"\'");
				if(null != costFact && null != costFact.getCostPre_ID()){//根据预收id查询实收表信息,如果全部为已确认,则更新预收表状态,否则不更新
					String whereSql = " and costPre_ID = \'"+costFact.getCostPre_ID()+"\'";
					whereSql +=" and costFactState = '未确认' ";
					List<Pro_costFact> costFactList = pro_costFactMapper.selectCostFactListByWhereSql(whereSql);
					if(null == costFactList || costFactList.size() ==0){//如果为空,则全部确认到账---更新预收表信息
						 Pro_costPre pro_costPre = new Pro_costPre();
						 pro_costPre.setCostPre_ID(costFact.getCostPre_ID());
						 pro_costPre.setCostPreState("已确认到账");
						Boolean bool = costPreService.updateOneCostPre(userSession, pro_costPre);
						if(!bool){
							b  = false;
						}
					}
					
				}
			}
		} catch (Exception e) {
			b  = false;
			e.printStackTrace();
		}
		return b;
	}
 	@Override
	public Boolean updateOneCostFacts(User userSession, Pro_costFact costFact) {
		Boolean b  = false;
		
		try {
			Integer returnInt = pro_costFactMapper.updateOneCostFact(costFact);
			if(returnInt >0){
				b  = true;
				logService.insertOneOperatorLogInfo(userSession, "实收费用", "修改", "修改一条实收费用,costFact_ID="+costFact.getCostFact_ID());
			}
		} catch (Exception e) {
			b  = false;
			e.printStackTrace();
		}
		return b;
	}

 	//分组查询
	@Override
	public List<Pro_costFact> selectCostFactListByWhereSqlGroup(String condition) {
		List<Pro_costFact> costFactList = pro_costFactMapper.selectCostFactListByWhereSqlGroup(condition);
		return costFactList;
	}

	
}
