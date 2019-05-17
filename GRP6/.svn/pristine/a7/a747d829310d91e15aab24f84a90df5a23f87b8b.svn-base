package com.zjm.crm.machine.service;

import com.zjm.crm.db.model.Crm_machine;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;

/**
 * 机械
 * @author chenyang
 */
public interface MachineService {
	
	/**
	 * 查询应收账户分页列表
	 * @author chenyang
	 * @return
	 */
	public PageTable<Crm_machine> selectMachinePageTables(Crm_machine machine);
	
	/**
	 * 查询应收账户列表  不分页
	 * @author xuyz
	 * @return
	 */
	public List<Crm_machine> selectMachineList(Crm_machine machine);
	
	/**
	 *	删除一个机械
	 * @return
	 */
	public boolean deleteOneMachineInfo(User user,String machine_id);

	/**
	 *	新增一个机械
	 * @return
	 */
	public Boolean insertOneMachineInfo(User user,Crm_machine machine);

	/**
	 * 查询一个机械
	 * @return
	 */
	public Crm_machine selectOneMachineInfo(Crm_machine machine);

	/**
	 * 
	 * @description 修改 更新机械信息  
	 * @author chenyang
	 */
	public Boolean updateOneMachineInfo(User user,Crm_machine machine);
	
	
	/**
	 * @description   根据客户id 删除
	 * @author wuhn
	 * @date 2017年10月11日 下午3:34:07
	 */
	Boolean deleteMachineByClient_ID(String client_ID);
	
}
