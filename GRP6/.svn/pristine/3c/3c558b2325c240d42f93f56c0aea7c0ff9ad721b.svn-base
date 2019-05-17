package com.zjm.sys.costStandard.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.sys.db.model.Sys_costStandard;



public interface CostStandardService {
	/**
	 * 查询收费标准
	 * @param pageTable
	 * @return
	 */
	public PageTable<Sys_costStandard> selectCostStandardTable(PageTable<Sys_costStandard> pageTable);
	/**
	 * 详细查询一条收费标准
	 * @param costStandard_ID
	 * @return
	 */
	public Sys_costStandard selectOneCostStandard(String costStandard_ID);
	/**
	 * 增加一条收费标准
	 * @param user
	 * @param costStandard
	 * @return
	 */
	public Boolean insertOneCostStandard(Sys_costStandard costStandard );
	/**
	 * 删除一条收费标准
	 * @param user
	 * @param costStandard
	 * @return
	 */
	public Boolean deleteOneCostStandard(User user, String costStandard_ID);
	
	
}
