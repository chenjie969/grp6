package com.zjm.crm.machine.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.map.Crm_machineMapper;
import com.zjm.crm.db.model.Crm_machine;
import com.zjm.crm.machine.service.MachineService;
import com.zjm.util.Tool;

/**
 * 机械
 * @author chenYang
 *  
 */
@Service("machineService")
@Transactional
public class MachineServiceImpl implements MachineService {
	@Resource
	private Crm_machineMapper crm_machineMapper;
	@Resource
	private LogService logService;
	@Resource
	private ClientService clientService;
	
	/**
	 * 查询机械分页列表
	 * @param pageTable
	 * @author chenyang
	 * @return
	 */
	public PageTable<Crm_machine> selectMachinePageTables(Crm_machine machine) {
		List<Crm_machine> list = crm_machineMapper.selectMachinePageTables(machine);
		PageTable<Crm_machine> pageTable = new PageTable<>();
		pageTable.setRows(list);
		pageTable.setTotal((long) list.size());
		return pageTable;
	}
	
	/**
	 * 查询应收账户列表  不分页
	 * @author xuyz
	 * @return
	 */
	public List<Crm_machine> selectMachineList(Crm_machine machine){
		return crm_machineMapper.selectMachinePageTables(machine);
	}
	
	/**
	 * 新增机械
	 * @param Crm_machine
	 * @author chenyang
	 * @return
	 */
	@Override
	public Boolean insertOneMachineInfo(User user,Crm_machine machine) {
		machine.setUpdateUserName(user.getUser_name());
		machine.setUnit_uid(user.getUnit_uid());
		machine.setUnit_uidName(user.getUnit_uidName());
		machine.setMachine_ID(Tool.createUUID32());
		if(crm_machineMapper.insertOneMachineInfo(machine)){
			logService.insertOneOperatorLogInfo(user,"机械", "新增", "新增机械");
			return true;			
		}else{
			return false;
		}
	}

	/**
	 *	删除一个机械
	 * @param Crm_machine
	 * @return
	 */
	@Override
	public boolean deleteOneMachineInfo(User user,String machine_id) {
		if(crm_machineMapper.deleteOneMachineInfo(machine_id)){
			logService.insertOneOperatorLogInfo(user,"机械", "删除", "删除机械");
			return true;			
		}else{
			return false;
		}
	}

	/**
	 *查询机械
	 * @param Crm_machine
	 * @author chenyang
	 * @return
	 */
	@Override
	public Crm_machine selectOneMachineInfo(Crm_machine machine) {
		return crm_machineMapper.selectOneMachineInfo(machine);
	}

	/**
	 * 
	 * @description 修改 更新机械信息  
	 * @author chenyang
	 */
	@Override
	public Boolean updateOneMachineInfo(User user,Crm_machine machine) {
		machine.setUpdateUserName(user.getUser_name());
		if(crm_machineMapper.updateOneMachineInfo(machine)){
			logService.insertOneOperatorLogInfo(user,"机械", "修改", "修改机械");
			return true;			
		}else{
			return false;
		}
	}

	
	@Override
	public Boolean deleteMachineByClient_ID(String client_ID) {
		try {
			int info = crm_machineMapper.deleteMachineByClient_ID(client_ID);
			if( info > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
