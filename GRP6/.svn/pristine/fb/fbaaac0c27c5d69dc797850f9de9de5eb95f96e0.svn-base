package com.zjm.crm.order.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_order;

public interface OrderService {

	/**
	 * 分页查询订单列表
	 */
	public PageTable<Crm_order> selectOrderPageTable(PageTable<Crm_order> pageTable);
	
	/**
	 * 查询订单列表
	 */
	public List<Crm_order> selectOrderList(String wheresql);
	
	/**
	 *  查询一条订单信息
	 */
	public Crm_order selectOneOrder(Crm_order order);
	
	/**
	 *  插入一条订单信息
	 */
	public Boolean insertOneOrder(User user,Crm_order order);
	
	/**
	 *  修改一条订单信息
	 */
	public Boolean updateOneOrder(User user,Crm_order order);
	
	/**
	 *  删除一条订单信息
	 */
	public Boolean deleteOneOrder(User user,Crm_order order);
	
	/**
	 * @description  根据wheresql  删除
	 * @author wuhn
	 * @date 2017年10月11日 下午2:14:40
	 */
	Boolean deleteOrderByWheresql(String wheresql);
}
