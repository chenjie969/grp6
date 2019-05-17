package com.zjm.crm.stock.service;

import java.util.List;

import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_stock;

/**
*  @description 
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年5月15日 下午5:39:46
*/
public interface StockService {
	
	/**
	 * 
	 * @description  根据 股权id 删除一条股权信息
	 * @author wuhn
	 * @date 2017年5月15日 下午5:26:07
	 */
    Boolean deleteOneStockInfo(String stockId ,User user);
    /**
     * 
     * @description 根据客户id 删除对应股权信息
     * @author wuhn
     * @date 2017年5月15日 下午5:27:42
     */
    Boolean deleteStockInfoByClient_ID(String Client_ID ,User user);
    
    /**
     * @description  添加一条股权信息
     * @author wuhn
     * @date 2017年5月15日 下午5:28:23
     */
    Boolean insertOneStockInfo(Crm_stock record ,User user);

    /**
     * @description  根据股权id  查询一条股权信息
     * @author wuhn
     * @date 2017年5月15日 下午5:28:38
     */
    Crm_stock selectOneStockInfo(String stockId);
    
    /**
     * @description	根据客户id 获取对应股权信息
     * @author wuhn
     * @date 2017年5月15日 下午5:30:23
     */
    List<Crm_stock> selectStockListByClient_ID(String client_ID);
    
    /**
     * 
     * @description 更新 修改一条股权信息
     * @author wuhn
     * @date 2017年5月15日 下午5:29:26
     */
    Boolean updateOneStockInfo(Crm_stock record ,User user);
    

}
