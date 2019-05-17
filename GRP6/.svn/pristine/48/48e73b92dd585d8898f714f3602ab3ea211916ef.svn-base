package com.zjm.sys.db.map;

import com.zjm.sys.db.model.C_bankSort;
import com.zjm.common.db.model.PageTable;

import java.util.List;


public interface C_bankSortMapper {
   
	/**
	 * 查询所有银行字典
	 * @return
	 */
	public List<C_bankSort> selectAllbankSortList(String wheresql);
	/**
	 * 插入一个银行字典信息
	 * @return
	 */
	public Integer insertOnebankSortInfo(C_bankSort C_bankSort);
	/**
	 * 查询一个银行字典信息
	 * @return
	 */
	public C_bankSort selectOnebankSortInfo(C_bankSort C_bankSort);
	/**
	 * 更新一个银行字典信息
	 * @return
	 */
	public Integer updateOnebankSortInfo(C_bankSort C_bankSort);
	/**
	 * 删除一个银行字典信息
	 * @return
	 */
	public Integer deleteOnebankSortInfo(C_bankSort C_bankSort);
	
	/**
	 * 查询银行字典列表    分页列表
	 * @param pageTable
	 * @return
	 */
	public List<C_bankSort> selectbankSortPageTables(PageTable<C_bankSort> pageTable);
	/**
	 * 查询银行字典列表    总记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectbankSortPageTables_Count(PageTable<C_bankSort> pageTable);
	
	/**
	 * 公共排序方法
	 * @param wheresql
	 */
	public void updateSortOrder(String wheresql);
	/**
	 * 判断是否存在
	 * @param wheresql
	 * @return
	 */
	public Integer selectbankSortIsExist(String wheresql);
	
	/**
	 * 查询同级节点下共有多少银行字典
	 * @return
	 */
	public Integer selectbankSortOrderId(C_bankSort C_bankSort);
	/**
	 * 由父类id查询子类银行字典
	 * @description
	 * @author wuhn
	 * @date 2017年4月25日 下午7:40:35
	 */
	public List<C_bankSort> selectbankSortListByPbankSortid(C_bankSort C_bankSort );
	
}