package com.zjm.crm.order.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.db.map.Crm_orderMapper;
import com.zjm.crm.db.model.Crm_order;
import com.zjm.crm.order.service.OrderService;
import com.zjm.util.Tool;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

	@Resource
	private Crm_orderMapper orderMapper;
	@Resource
	private LogService logService;
	
	/**
	 * 分页查询订单列表
	 */
	@Override
	public PageTable<Crm_order> selectOrderPageTable(PageTable<Crm_order> pageTable) {
		List<Crm_order> orderList = orderMapper.selectOrderPageTable(pageTable);
		pageTable.setRows(orderList);
		Long orderTotal = orderMapper.selectOrderPageTable_Count(pageTable);
		pageTable.setTotal(orderTotal);
		return pageTable;
	}
	
	/**
	 * 查询订单列表
	 */
	public List<Crm_order> selectOrderList(String wheresql){
		try {
			return orderMapper.selectOrderList(wheresql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *  查询一条订单信息
	 */
	@Override
	public Crm_order selectOneOrder(Crm_order order) {
		return orderMapper.selectOneOrder(order);
	}
	
	/**
	 *  插入一条订单信息
	 */
	@Override
	public Boolean insertOneOrder(User user,Crm_order order) {
		order.setOrder_ID(Tool.createUUID32());
		order.setUnit_uid(user.getUnit_uid());
		order.setUnit_uidName(user.getUnit_uidName());
		order.setUpdateUserName(user.getUser_name());
		if(orderMapper.insertOneOrder(order)==1){
			logService.insertOneOperatorLogInfo(user, "企业经营情况", "添加", "添加订单-"+order.getCustomerName());
			return true;
		}
		else
			return false;
	}
	
	/**
	 *  修改一条订单信息
	 */
	@Override
	public Boolean updateOneOrder(User user,Crm_order order) {
		order.setUpdateUserName(user.getUser_name());
		if(orderMapper.updateOneOrder(order)==1){
			logService.insertOneOperatorLogInfo(user, "企业经营情况", "修改","修改订单-"+order.getCustomerName());
			return true;
		}else
			return false;
	}
	
	/**
	 *  删除一条订单信息
	 */
	@Override
	public Boolean deleteOneOrder(User user,Crm_order order) {
		order = selectOneOrder(order);
		if(orderMapper.deleteOneOrder(order)==1){
			logService.insertOneOperatorLogInfo(user, "企业经营情况", "删除", "删除订单-"+order.getCustomerName());
			return true;
		}else
			return false;
	}

	@Override
	public Boolean deleteOrderByWheresql(String wheresql) {
		try {
			int info = orderMapper.deleteOrderByWheresql(wheresql);
			if(info > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
