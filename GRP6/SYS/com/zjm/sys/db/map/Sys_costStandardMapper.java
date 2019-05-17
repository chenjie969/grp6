package com.zjm.sys.db.map;

import java.util.List;
import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.model.Sys_costStandard;


public interface Sys_costStandardMapper {
	/**
	 * 增加一个收费标准类型
	 * @param costStandard
	 * @return
	 */
	public Integer insertOneCostStandard(Sys_costStandard costStandard);
	/**
	 * 查询收费标准类型表
	 * @param pageTable
	 * @return
	 */

	public List<Sys_costStandard> selectCostStandardTable(PageTable pageTable);
	/**
	 * 查询一条收费标准类型
	 * @param costStandard_ID
	 * @return
	 */
	public Sys_costStandard selectOneCostStandard(String costStandard_ID);
	/**
	 * 删除一条收费标准类型
	 * @param costStandard
	 * @return
	 */
	public Integer deleteOneCostStandard(String costStandard_ID);
	/**
	 * 
	 * 查询收费列表总记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectCostStandardPageTables_Count(PageTable<Sys_costStandard> pageTable);
}
