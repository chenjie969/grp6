package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_contractdoc;


public interface Pro_contractDocMapper {
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
	public Integer updateOneContractInfo(Pro_contractdoc Pro_contractdoc);
	/**
	 * 更新	附件
	 */
	public Integer updateOneContractFilesInfo(Pro_contractdoc Pro_contractdoc);
	/**
	 * 根据ID修改一条记录
	 */
	public Integer updateOneContractByID(Pro_contractdoc Pro_contractdoc);
	/**
	 * 插入
	 */
	public Integer insertOneContractInfo(Pro_contractdoc Pro_contractdoc);
	/**
	 * 删除
	 */
	public Integer contractDel(Pro_contractdoc Pro_contractdoc);
	
	/**
	 * @param contractdoc
	 * @return 新增/修改合同时判断合同编号是否存在
	 */
	public int isExistContractCode(Pro_contractdoc contractdoc);
}
