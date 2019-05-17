package com.zjm.crm.stock.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.db.map.Crm_stockMapper;
import com.zjm.crm.db.model.Crm_stock;
import com.zjm.crm.stock.service.StockService;

/**
*  @description 股权结构 service
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年5月15日 下午5:40:13
*/
@Service(value="stockService")
@Transactional
public class StockServiceImpl implements StockService{
	
	@Resource
	private Crm_stockMapper  crm_stockMapper;
	
	@Resource
	private LogService  logService;
	
	
	/**
	 * 
	 * @description  根据 股权id 删除一条股权信息
	 * @author wuhn
	 * @date 2017年5月15日 下午5:26:07
	 */
	@Override
	public Boolean deleteOneStockInfo(String stockId,User user) {
		try {
			int deleteOneStockInfo = crm_stockMapper.deleteOneStockInfo(stockId);
			if( deleteOneStockInfo > 0){
				logService.insertOneOperatorLogInfo(user,"股权信息", "删除", "删除股权信息");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
	}
	
	/**
     * @description 根据客户id 删除对应股权信息
     * @author wuhn
     * @date 2017年5月15日 下午5:27:42
     */
	@Override
	public Boolean deleteStockInfoByClient_ID(String Client_ID,User user) {
		try {
			int delete = crm_stockMapper.deleteStockInfoByClient_ID(Client_ID);
			if( delete > 0){
				logService.insertOneOperatorLogInfo(user,"股权信息", "删除", "根据客户id删除");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
	}
	
	 /**
     * @description  添加一条股权信息
     * @author wuhn
     * @date 2017年5月15日 下午5:28:23
     */
	@Override
	public Boolean insertOneStockInfo(Crm_stock record,User user) {
		try {
			int insertOneStockInfo = crm_stockMapper.insertOneStockInfo(record);
			if( insertOneStockInfo > 0){
				logService.insertOneOperatorLogInfo(user,"股权信息", "添加", "添加"+record.getStockname());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
	}
	
	/**
     * @description  根据股权id  查询一条股权信息
     * @author wuhn
     * @date 2017年5月15日 下午5:28:38
     */
	@Override
	public Crm_stock selectOneStockInfo(String stockId) {
		return crm_stockMapper.selectOneStockInfo(stockId);
	}
	
	 /**
     * @description	根据客户id 获取对应股权信息
     * @author wuhn
     * @date 2017年5月15日 下午5:30:23
     */
	@Override
	public List<Crm_stock> selectStockListByClient_ID(String client_ID) {
		return crm_stockMapper.selectStockListByClient_ID(client_ID);
	}
	
	/**
     * 
     * @description 更新 修改一条股权信息
     * @author wuhn
     * @date 2017年5月15日 下午5:29:26
     */
	@Override
	public Boolean updateOneStockInfo(Crm_stock record ,User user) {
		try {
			int updateOneStockInfo = crm_stockMapper.updateOneStockInfo(record);
			if( updateOneStockInfo > 0){
				logService.insertOneOperatorLogInfo(user,"股权信息", "修改", "修改"+record.getStockname());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
	}

}
