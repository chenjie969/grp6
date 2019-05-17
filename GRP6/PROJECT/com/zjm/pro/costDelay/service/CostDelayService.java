package com.zjm.pro.costDelay.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_costDelay;

public interface CostDelayService {

	public PageTable<Pro_costDelay> selectCostDelayPageTable(PageTable<Pro_costDelay> pageTable);
	
//	public Boolean updateOneCostDelay(User user, Pro_costDelay costDelay);
	
	public Boolean deleteOneCostDelay(User user, Pro_costDelay costDelay);
	
	public Boolean insertOneCostDelay(User user, Pro_costDelay costDelay);
	
	public Pro_costDelay selectOneCostDelay(Pro_costDelay costDelay);
}
