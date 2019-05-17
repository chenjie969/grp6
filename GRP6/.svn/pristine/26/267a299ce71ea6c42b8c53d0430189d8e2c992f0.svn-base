package com.zjm.pro.contractdoc.service;
import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_contractdoc;
import com.zjm.pro.db.model.Pro_projectfiles;
public interface ContractdocService {
	/**
	 * 查询列表   
	 */	
	public List<Pro_contractdoc> selectContractTable(String applyID);	
	/**
	 * 根据id查出该记录
	 */	
	public Pro_contractdoc selectOneContractdocInfo(Pro_contractdoc Pro_contractdoc);	
	/**
	 * 更新	
	 */
	public Boolean updateOneContractInfo(Pro_contractdoc Pro_contractdoc);
	/**
	 * 插入
	 */
	public Boolean insertOneContractInfo(Pro_contractdoc Pro_contractdoc,User userSession);
	/**
	 * 删除
	 */
	public Boolean contractDel(Pro_contractdoc Pro_contractdoc);
	
	/**
	 * @param con
	 * @return 更新合同附件信息
	 */
	public Boolean updateOneContractFilesInfo(Pro_contractdoc con);
	
	/**
	 * @param contractdoc
	 * @param userSession
	 * @return 根据ID修改一条合同信息
	 */
	public Boolean updateOneContractByID(Pro_contractdoc contractdoc, User userSession);
	//新增/修改合同时判断合同编号是否存在
	public Boolean isExistContractCode(Pro_contractdoc contractdoc);
	
	//查询附件
	public List<Pro_projectfiles> getAttachments(String entityID);
}
