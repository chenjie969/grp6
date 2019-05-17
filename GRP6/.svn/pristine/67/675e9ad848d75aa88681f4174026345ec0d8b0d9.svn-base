package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.crm.db.model.Crm_machine;

public interface Crm_machineMapper {

	
	/**
	 * 查询机械    分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Crm_machine> selectMachinePageTables(Crm_machine machine);
	
	/**
	 * 新增机械
	 * @author chenyang
	 * @return
	 */
	public Boolean insertOneMachineInfo(Crm_machine machine);

	/**
	 *	删除一个机械
	 * @return
	 */
	public boolean deleteOneMachineInfo(String machine_id);

	/**
	 *查询一个机械
	 * @author chenyang
	 * @return
	 */
	public Crm_machine selectOneMachineInfo(Crm_machine machine);

	/**
	 * 
	 * @description 修改 更新机械信息  
	 * @author chenyang
	 */
	public Boolean updateOneMachineInfo(Crm_machine machine);
	
	
	/**
	 * @description   根据客户id 删除
	 * @author wuhn
	 * @date 2017年10月11日 下午3:34:07
	 */
	int deleteMachineByClient_ID(String client_ID);
	
}
