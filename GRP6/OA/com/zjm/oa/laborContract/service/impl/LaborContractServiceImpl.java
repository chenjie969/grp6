package com.zjm.oa.laborContract.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.oa.db.map.Hr_laborContractMapper;
import com.zjm.oa.db.model.Hr_laborContract;
import com.zjm.oa.laborContract.service.LaborContractService;
import com.zjm.util.Tool;
@Service("laborContractService")
@Transactional
public class LaborContractServiceImpl implements LaborContractService {
	@Resource
	private Hr_laborContractMapper laborContractMapper;
	@Resource
	private LogService logService;
	
   /*
    * 
    * 查询合同列表
    * 
    */
	public PageTable<Hr_laborContract> selectContractTable(PageTable<Hr_laborContract> pageTable) {
		List<Hr_laborContract> list = laborContractMapper.selectContractTable(pageTable);		
		pageTable.setRows(list);
		return pageTable;
	}
    /*
     * 
     * 查询一条合同
     *
     */
	public Hr_laborContract selectOneContract(String laborContractID) {
	
		return laborContractMapper.selectOneContract(laborContractID);
	}
    /**
     * 插入一条合同
     * 
     */
	public Boolean insertOneLaborContract(User user, Hr_laborContract contract) {
		//设置主键ID
		contract.setLaborContractID(Tool.createUUID32());
		
		if(laborContractMapper.insertOneLaborContract(contract)==1){
			logService.insertOneOperatorLogInfo(user, "劳务合同", "添加","添加劳务合同"+contract.getLaborContractID() );
			return true;	
		  }
		else {
			return false;
			
		}
	}
     /**
      * 修改一条合同
      * 
      */
	public Boolean updateOneContract(User user, Hr_laborContract contract) {
		Integer returnInt = 0;
		try {
			returnInt = laborContractMapper.updateOneContract(contract);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(returnInt>0){
			logService.insertOneOperatorLogInfo(user, "劳务合同", "修改", "修改劳务合同"+contract.getLaborContractID());
			return 	true;
		}else{
			return false;
		}
	
	}

	

}