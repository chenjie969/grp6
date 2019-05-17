package com.zjm.sys.db.map;

import java.util.List;

import com.zjm.sys.db.model.C_busiSort;
import com.zjm.common.db.model.PageTable;

public interface C_busiSortMapper {
	
	/**
	 * 查询所有业务品种
	 * @return
	 */
	public List<C_busiSort> selectAllBusiSortList(String wheresql);
	/**
	 * 插入一个业务品种信息
	 * @return
	 */
	public Integer insertOneBusiSortInfo(C_busiSort C_busiSort);
	/**
	 * 查询一个业务品种信息
	 * @return
	 */
	public C_busiSort selectOneBusiSortInfo(C_busiSort C_busiSort);
	/**
	 * 更新一个业务品种信息
	 * @return
	 */
	public Integer updateOneBusiSortInfo(C_busiSort C_busiSort);
	/**
	 * 删除一个业务品种信息
	 * @return
	 */
	public Integer deleteOneBusiSortInfo(C_busiSort C_busiSort);
	
	/**
	 * 查询业务品种列表    分页列表
	 * @param pageTable
	 * @return
	 */
	public List<C_busiSort> selectBusiSortPageTables(PageTable<C_busiSort> pageTable);
	/**
	 * 查询业务品种列表    总记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectBusiSortPageTables_Count(PageTable<C_busiSort> pageTable);
	
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
	public Integer selectBusiSortIsExist(String wheresql);
	
	/**
	 * 查询同级节点下共有多少业务品种
	 * @return
	 */
	public Integer selectBusiSortOrderId(C_busiSort C_busiSort);
	/**
	 * 由父类id查询子类业务品种
	 * @description
	 * @author wuhn
	 * @date 2017年4月25日 下午7:40:35
	 */
	public List<C_busiSort> selectBusiSortListByPbusisortid(String pBusiSortId );
	
	
}