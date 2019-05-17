package com.zjm.sys.db.map;

import java.util.List;

import com.zjm.sys.db.model.C_dictype;
import com.zjm.common.db.model.PageTable;

public interface C_dictypeMapper {

	/**
	 * 查询所有字典
	 * @return
	 */
	public List<C_dictype> selectAllDicTypeList(String wheresql) ;
	/**
	 * 查询字典列表    总记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectDicTypePageTables_Count(PageTable<C_dictype> pageTable);
	/**
	 * 查询字典列表    分页列表
	 * @param pageTable
	 * @return
	 */
	public List<C_dictype> selectDicTypePageTables(PageTable<C_dictype> pageTable);
	/**
	 * 插入一个字典
	 * @return Integer
	 */
	public Integer insertOneDicTypeInfo(C_dictype c_dictype);
	/**
	 * 查询同级节点下共有多少字典
	 */
	public Integer selectDicTypeOrderId(C_dictype c_dictype);
	/**
	 * 查询一个字典信息
	 * @return
	 */
	public C_dictype selectOneDicTypeInfo(C_dictype c_dictype);
	/**
	 * 更新一个字典信息
	 * @return
	 */
	public Integer updateOneDicTypeInfo(C_dictype c_dictype); 
	/**
	 * 删除一个字典信息
	 * @return
	 */
	public Integer deleteOneDicTypeInfo(C_dictype c_dictype);
	/**
	 * 公共排序方法
	 * @param wheresql
	 */
	public void updateSortOrder(String wheresql);
	/**
	 * 判断字典名称是否存在（全部单级字典）
	 */
	public Integer isExistDictypeNameForALL(C_dictype c_dictype);
	/**
	 * 判断字典名称是否存在（同级目录字典）
	 */
	public Integer isExistDictypeNameForParent(C_dictype c_dictype);
	
	
	/**
	 * @param  指定要获取的字典类别
	 * @param c_dictype
	 * @return
	 */
	public List<C_dictype> sysDicType(C_dictype c_dictype);
}
