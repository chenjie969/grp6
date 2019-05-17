package com.zjm.sys.banksort.service;

import java.util.List;

import com.zjm.sys.db.model.C_bankSort;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;

/**
*  @description 银行字典
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年4月26日 下午7:57:49
*/
public interface BankSortService {
	

	/**
	 * 查询所有银行字典
	 * @param wheresql 
	 * @param searchText 
	 * @param pageNumber 
	 * @param pageSize 
	 * @return
	 */
	public List<C_bankSort> selectAllbankSortList(String wheresql);
	/**
	 * 插入一个银行字典信息
	 * @param C_bankSort
	 * @return
	 */
	public Boolean insertOnebankSortInfo(C_bankSort C_bankSort,User user);
	/**
	 * 查询一个银行字典信息
	 * @param C_bankSort
	 * @return
	 */
	public C_bankSort selectOnebankSortInfo(C_bankSort C_bankSort);
	/**
	 * 更新一个银行字典信息
	 * @param C_bankSort
	 * @return
	 */
	public Boolean updateOnebankSortInfo(C_bankSort C_bankSort,User user);
	/**
	 * 删除一个银行字典信息
	 * @param C_bankSort
	 * @return
	 */
	public Boolean deleteOnebankSortInfo(C_bankSort C_bankSort,User user);
	/**
	 * 查询银行字典列表   
	 * @param pageTable
	 * @return
	 */
	public PageTable<C_bankSort> selectbankSortPageTables(PageTable<C_bankSort> pageTable);
	/**
	 * 判断是否存在
	 * @param wheresql
	 * @return
	 */
	public Boolean selectbankSortIsExist(String wheresql);
	
	/**
	 * 由父类id查询子类银行字典
	 * @description
	 * @param pbankSortId 银行字典父id
	 */
	public List<C_bankSort> selectbankSortListByPbankSortid(C_bankSort C_bankSort);
	
	/**
	 * @description	   查询额度使用情况分页列表
	 * @author wuhn
	 * @date 2017年5月26日 下午5:07:14
	 */
	PageTable<C_bankSort> selectCreditConditionsPageTables(PageTable<C_bankSort> pageTable);
	
}
