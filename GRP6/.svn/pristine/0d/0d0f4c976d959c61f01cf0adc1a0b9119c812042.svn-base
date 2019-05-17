package com.zjm.oa.laborContract.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.oa.db.model.Hr_laborContract;


public interface LaborContractService {
    /**
      * 查询合同表
      * 
     */
	public PageTable<Hr_laborContract> selectContractTable(PageTable<Hr_laborContract> pageTable);
	/**
	 * 查询一条合同
	 * 
	 */
	public Hr_laborContract selectOneContract(String laborContractID);
	/**
	 * 插入一条合同
	 * 
	 */
	public Boolean insertOneLaborContract(User user,Hr_laborContract contract );
	/**
	 * 更新一条合同
	 * 
	 */
	public Boolean updateOneContract(User user,Hr_laborContract contract);
}
