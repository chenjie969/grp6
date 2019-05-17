package com.zjm.sys.busisort.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.sys.db.model.C_busiSort;

/**
*  @description 
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年4月25日 下午3:31:19
*/
@Service(value="busiSortService")
public interface BusiSortService {
	
	/**
	 * 查询所有业务品种
	 * @param wheresql 
	 * @param searchText 
	 * @param pageNumber 
	 * @param pageSize 
	 * @return
	 */
	public List<C_busiSort> selectAllBusiSortList(String wheresql);
	/**
	 * 插入一个业务品种信息
	 * @param C_busiSort
	 * @return
	 */
	public Boolean insertOneBusiSortInfo(C_busiSort C_busiSort,User user);
	/**
	 * 查询一个业务品种信息
	 * @param C_busiSort
	 * @return
	 */
	public C_busiSort selectOneBusiSortInfo(C_busiSort C_busiSort);
	/**
	 * 更新一个业务品种信息
	 * @param C_busiSort
	 * @return
	 */
	public Boolean updateOneBusiSortInfo(C_busiSort C_busiSort,User user);
	/**
	 * 删除一个业务品种信息
	 * @param C_busiSort
	 * @return
	 */
	public Boolean deleteOneBusiSortInfo(C_busiSort C_busiSort,User user);
	/**
	 * 查询业务品种列表   
	 * @param pageTable
	 * @return
	 */
	public PageTable<C_busiSort> selectBusiSortPageTables(PageTable<C_busiSort> pageTable);
	/**
	 * 判断是否存在
	 * @param wheresql
	 * @return
	 */
	public Boolean selectBusiSortIsExist(String wheresql);
	
	/**
	 * 由父类id查询子类业务品种
	 * @description
	 * @param pBusiSortId 业务品种父id
	 */
	public List<C_busiSort> selectBusiSortListByPbusisortid(String pBusiSortId );
	
}
