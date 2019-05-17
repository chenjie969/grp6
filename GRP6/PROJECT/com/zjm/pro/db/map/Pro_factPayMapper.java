package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_factPay;

/**
 * 业务还款信息表pro_factPay   mapper
 */
public interface Pro_factPayMapper {
	/**
	 * 
	 * @description 新增一条业务还款信息表pro_factPay
	 */
	public Integer insertOneFactPayInfo(Pro_factPay factPay);
	/**
	 * 返回还款信息表分页列表
	 * @param pageTable
	 * @author ZKY
	 * @return
	 */
	public List<Pro_factPay> selectFactPayTables(PageTable pageTable);
	/**
	 * 返回还款信息表分页列表   总记录数
	 * @param pageTable
	 * @author ZKY
	 * @return
	 */
	/**
	 * 根据输入条件查询单个还款信息
	 * @param whereSql
	 * @author ZKY
	 * @return
	 */
	public Pro_factPay selectOneFactPayByWhereSql(String whereSql);
	/**
	 * 修改还款登记信息
	 * @param pro_factPay
	 * @return
	 */
	public Integer updateOneFactPay(Pro_factPay pro_factPay);
	/**
	 * 删除单个还款表信息
	 * @param whereSql
	 * @return
	 */
	public Integer deleteOneFactPay(String whereSql);
	/**
	 * 根据project_ID 获取所有还款信息
	 * @param wheresql2
	 * @return
	 */
	public List<Pro_factPay> selectFactPayListByWheresql(String wheresql2);
	public Long selectFactPayTables_Count(PageTable pageTable);

	/**
	 * 返回项目对应还款信息表分页列表
	 */
	public List<Pro_factPay> selectPayTables(PageTable pageTable);
	/**
	 * 返回项目对应还款信息表分页列表   总记录数
	 */
	public Long selectPayTables_Count(PageTable pageTable);
	
	/**
	 * @param value
	 * @return pro_factPayMapper
	 */
	public Pro_factPay selectOneFactPayByID(String value);
	public Integer cancelOneFactPayDel(Pro_factPay factPay);
	//查询正常解除申请信息
	public List<Pro_factPay> selectFactPayList(String condition);
	
	/**
	 * 删除项目时，删除与项目有关的还款数据
	 * @param project_ID
	 */
	public Integer deletefactPayByProject_ID(String project_ID);
	/**
	 * 查询逾期后的还款
	 */
	public List<Pro_factPay> selectOverdueFactPayListByWheresql(String whereSql);

}
