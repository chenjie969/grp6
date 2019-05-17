package com.zjm.oa.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.oa.db.model.Hr_laborContract;


public interface Hr_laborContractMapper {
	 
	/**
	 * 插入一条合同
	 * @param laborContract
	 * @return
	 */

	public Integer insertOneLaborContract(Hr_laborContract laborContract);
	/**
	 * 
	 * 更新合同
	 * @param laborContract
	 * @return
	 */
	public Integer updateOneContract(Hr_laborContract laborContract);
	/**
	 * 
	 * 详细查询一条合同
	 * @param contract
	 * @return
	 */
	public Hr_laborContract selectOneContract(String laborContractID);
	/**
	  * 
	  * 查询劳务合同表
	  * @param pageTable
	  * @return
	  */
	public List<Hr_laborContract> selectContractTable(PageTable pageTable);
	
}

