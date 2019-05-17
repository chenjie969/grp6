package com.zjm.pro.costDelay.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.costDelay.service.CostDelayService;
import com.zjm.pro.costMust.service.CostMustService;
import com.zjm.pro.db.map.Pro_costDelayMapper;
import com.zjm.pro.db.model.Pro_costDelay;
import com.zjm.pro.db.model.Pro_costMust;
import com.zjm.util.Tool;

@Transactional
@Service("costDelayService")
public class CostDelayServiceImpl implements CostDelayService {

	@Resource
	private Pro_costDelayMapper pro_costDelayMapper;
	@Resource
	private CostMustService costMustService;
	@Resource
	private LogService logService;
	
	@Override
	public PageTable<Pro_costDelay> selectCostDelayPageTable(PageTable<Pro_costDelay> pageTable) {
		try {
			List<Pro_costDelay> costDelayList = pro_costDelayMapper.selectCostDelayListByWhereSql(" and costdelay.apply_ID = '"+pageTable.getQueryCondition().getApply_ID()+"'");
			pageTable.setRows(costDelayList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}

	/*@Override
	public Boolean updateOneCostDelay(User user, Pro_costDelay costDelay) {
		try {
			pro_costDelayMapper.updateOneCostDelay(costDelay);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}*/

	@Override
	public Boolean deleteOneCostDelay(User user, Pro_costDelay costDelay) {
		try {
			if(pro_costDelayMapper.deleteOneCostDelay(costDelay)==1){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	@Override
	public Pro_costDelay selectOneCostDelay(Pro_costDelay costDelay) {
		try {
			costDelay = pro_costDelayMapper.selectOneCostDelay(costDelay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return costDelay;
	}

	@Override
	public Boolean insertOneCostDelay(User user, Pro_costDelay costDelay) {
		// TODO Auto-generated method stub
		return null;
	}
}
