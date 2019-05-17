package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_order;

public interface Crm_orderMapper {

	/**
	 * 分页查询订单情况列表
	 */
	public List<Crm_order> selectOrderPageTable(PageTable<Crm_order> pageTable);
	
	/**
	 * 分页查询订单情况列表-查询总记录数
	 */
	public Long selectOrderPageTable_Count(PageTable<Crm_order> pageTable);
	
	/**
	 * 查询订单情况列表
	 */
	public List<Crm_order> selectOrderList(String wheresql);
	
	/**
	 *  查询一条订单情况
	 */
	public Crm_order selectOneOrder(Crm_order order);
	
	/**
	 *  插入一条订单情况
	 */
	public Integer insertOneOrder(Crm_order order);
	
	/**
	 *  修改一条订单情况
	 */
	public Integer updateOneOrder(Crm_order order);
	
	/**
	 *  删除一条订单情况
	 */
	public Integer deleteOneOrder(Crm_order order);
	
	/**
	 * @description  根据wheresql  删除
	 * @author wuhn
	 * @date 2017年10月11日 下午2:14:40
	 */
	int deleteOrderByWheresql(String wheresql);
	
	
}
