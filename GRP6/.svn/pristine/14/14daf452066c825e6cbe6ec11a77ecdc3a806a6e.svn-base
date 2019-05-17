package com.zjm.sys.multilevelsort.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.sys.db.model.C_multiLevelSort;

/**
*  @description 多级字典
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年4月26日 22:09:58
*/
public interface MultiLevelSortService {
		

	/**
	 * 查询所有多级字典
	 * @param wheresql 
	 * @param searchText 
	 * @param pageNumber 
	 * @param pageSize 
	 * @return
	 */
	public List<C_multiLevelSort> selectAllmultilevelsortList(String wheresql);
	
	/**
	 * 插入一个多级字典信息
	 * @param C_multiLevelSort
	 * @return
	 */
	public Boolean insertOnemultilevelsortInfo(C_multiLevelSort C_multiLevelSort,User user );
	/**
	 * 查询一个多级字典信息
	 * @param C_multiLevelSort
	 * @return
	 */
	public C_multiLevelSort selectOnemultilevelsortInfo(C_multiLevelSort C_multiLevelSort);
	/**
	 * 更新一个多级字典信息
	 * @param C_multiLevelSort
	 * @return
	 */
	public Boolean updateOnemultilevelsortInfo(C_multiLevelSort C_multiLevelSort,User user );
	/**
	 * 删除一个多级字典信息
	 * @param C_multiLevelSort
	 * @return
	 */
	public Boolean deleteOnemultilevelsortInfo(C_multiLevelSort C_multiLevelSort,User user );
	/**
	 * 查询多级字典列表   
	 * @param pageTable
	 * @return
	 */
	public PageTable<C_multiLevelSort> selectmultilevelsortPageTables(PageTable<C_multiLevelSort> pageTable);
	/**
	 * 判断是否存在
	 * @param wheresql
	 * @return
	 */
	public Boolean selectmultilevelsortIsExist(String wheresql);
	
	/**
	 * 由父类id查询子类多级字典
	 * @description
	 * @param pmultilevelsortId 多级字典父id
	 */
	public List<C_multiLevelSort> selectmultilevelsortListByPmultilevelsortid(C_multiLevelSort C_multiLevelSort );
	
	public C_multiLevelSort selectOnemultiLevelSortInfoByWheresql(String wheresql);
	
	
}
