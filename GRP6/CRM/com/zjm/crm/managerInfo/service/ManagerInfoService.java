package com.zjm.crm.managerInfo.service;


import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_managerInfo;
public interface ManagerInfoService {
	
	/**
	 * 
	 * @description    删除 股东 主要管理人员情况  wheresql
	 * @author wuhn
	 * @date 2017年5月14日17:40:35
	 */
    Boolean deleteOneManagerInfo(String whereql ,User user);
    
    /**
	 * @description   添加 股东  主要管理人员情况
	 * @author wuhn
	 * @date 2017年5月14日17:40:38
	 */
    Boolean insertOneManagerInfo(Crm_managerInfo crm_managerInfo ,User user);

    /**
   	 * @description  根据客户id  获取主要股东管理人员情况
   	 * @author wuhn
   	 * @date 2017年5月14日17:40:41
   	 */
    Crm_managerInfo selectOneManagerInfo(String wheresql);
    
    /**
   	 * @description  修改股东 主要管理人员情况
   	 * @author wuhn
   	 * @date 2017年5月14日17:40:44
   	 */
    Boolean updateOneManagerInfo(Crm_managerInfo crm_managerInfo,User user);
    
    /**
     * @description  根据客户id 删除股东管理人员情况
     * @author wuhn
     * @date 2017年10月11日 上午10:33:12
     */
    Boolean deleteManagerInfoByClient_ID(String client_ID);
    
}
