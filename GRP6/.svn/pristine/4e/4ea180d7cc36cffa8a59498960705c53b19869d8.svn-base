package com.zjm.pro.factPay.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_factPay;

public interface FactPayService {
	/***
	 *  还款情况信息表 分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectFactPayTables(PageTable pageTable);
	
	/**
	 * 插入一个 还款情况信息
	 * @param 
	 * @return
	 */
	public Boolean insertOneFactPayInfo(User user,Pro_factPay factPay);
	 /**
	    * 根据条件查询单个还款信息
	    * @param string
	    * @return
	    */
		public Pro_factPay selectOneFactPayByWhereSql(String string);
		/**
		 * 根据条件查询多个还款信息
		 * @param string
		 * @return
		 */
		public List<Pro_factPay> selectFactPayListByWhereSql(String string);
	    /**
	     * 修改还款登记信息
	     * @param userSession
	     * @param pro_factPay
	     * @return
	     */
	    public Boolean updateOneFactPay(User userSession, Pro_factPay pro_factPay);
	    /**
	     * 删除一个还款表信息
	     * @param userSession
	     * @param factPay
	     * @return
	     */
		public Boolean deleteOneFactPay(User userSession, Pro_factPay factPay);

	
	/**项目对应的还款列表
	 * @param pageTable
	 * @return
	 */
	public PageTable<Pro_factPay> selectPayTables(PageTable<Pro_factPay> pageTable);
	/**查询还款信息
	 * @param string
	 * @return
	 */
	public Pro_factPay selectOneFactPayByID(String value);
	//删除一条还款信息
	public Boolean cancelOneFactPayDel(Pro_factPay factPay);
	//部分还款——添加
	public Boolean addOneFactPay(Pro_factPay factPay);
	//查询正常解除申请信息
	public List<Pro_factPay> selectFactPayList(String condition);
	//正常解除申请
	public Object insertOneFactPayWHDB(User user,Pro_factPay factPay);
	//删除还款信息
	public Object deleteOneFactPay(Pro_factPay factPay);
	
}
