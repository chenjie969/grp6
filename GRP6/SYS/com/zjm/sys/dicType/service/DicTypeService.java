package com.zjm.sys.dicType.service;

import java.util.List;

import com.zjm.sys.db.model.C_dictype;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;

public interface DicTypeService {

	/**
	 * 查询所有字典
	 * @return
	 */
	public List<C_dictype> selectAllDicTypeList(String wheresql) ;
	
	/**
	 * 查询字典列表   
	 * @param pageTable
	 * @return
	 */
	public PageTable<C_dictype> selectDicTypePageTables(PageTable<C_dictype> pageTable);
	/**
	 * 插入一个字典
	 * @return
	 */
	public Boolean insertOneDicTypeInfo(User user,C_dictype c_dictype);
	/**
	 * 查询一个字典信息
	 * @param c_dictype
	 * @return
	 */
	public C_dictype selectOneDicTypeInfo(C_dictype c_dictype);
	/**
	 * 更新一个字典信息
	 * @param sys_modules
	 * @return
	 */
	public Boolean updateOneDicTypeInfo(User user,C_dictype c_dictype);
	/**
	 * 删除一个字典信息
	 * @param sys_modules
	 * @return
	 */
	public Boolean deleteOneDicTypeInfo(User user,C_dictype c_dictype);
	/**
	 * 判断字典名称是否存在（全部单级字典）
	 */
	public Boolean isExistDictypeNameForALL(C_dictype c_dictype);
	/**
	 * 判断字典名称是否存在（同级目录字典）
	 */
	public Boolean isExistDictypeNameForParent(C_dictype c_dictype);
}
