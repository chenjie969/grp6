package com.zjm.sys.costStandard.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.sys.costStandard.service.CostStandardService;
import com.zjm.sys.db.map.Sys_costStandardMapper;
import com.zjm.sys.db.model.Sys_costStandard;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;
@Service("costStandardService")
@Transactional
public class CostStandardServiceImpl implements CostStandardService {
        @Resource   
	private Sys_costStandardMapper costStandardMapper;
        @Resource
        private LogService logService;
        
     /**
      * 查看收费标准表
      *    
      */
	@Override
	public PageTable<Sys_costStandard> selectCostStandardTable(PageTable<Sys_costStandard> pageTable) {
		pageTable.setRows(costStandardMapper.selectCostStandardTable(pageTable));
		pageTable.setTotal(costStandardMapper.selectCostStandardPageTables_Count(pageTable));
		return pageTable;
	}
    /**
     * 详细查看一条收费标准
     * 
     */
	@Override
	public Sys_costStandard selectOneCostStandard(String costStandard_ID) {
		
		return costStandardMapper.selectOneCostStandard(costStandard_ID);
	}
   /**
    * 增加一条收费标准
    * 
    */
	@Override
	public Boolean insertOneCostStandard(Sys_costStandard costStandard) {
		costStandard.setCostStandard_ID(Tool.createUUID32());
		costStandard.setIsDelete(0);
		costStandard.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		costStandard.setUpdateUserName(SystemSession.getUserSession().getUser_name());
		Float costRate = costStandard.getCostRate();
		String costUnit = costStandard.getCostUnit();
		String calculateRate="";
		Float calculateR =0f;
		if("‰".equals(costUnit)){
			calculateR = costRate/1000;
		}else{
			calculateR = costRate/100;
		}
		calculateRate = String.valueOf(calculateR);
		costStandard.setCalculateRate(calculateRate);
		if( costStandardMapper.insertOneCostStandard(costStandard)==1){
			logService.insertOneOperatorLogInfo(SystemSession.getUserSession(), "收费标准", "添加", "添加收费标准"+costStandard.getCostStandard_ID());
			return true;
		 }else {
			return false;
		 }
	 
    
		
	}
	/**
	 * 删除一条收费标准类型
	 * 
	 */
@Override
public Boolean deleteOneCostStandard(User user, String costStandard_ID) {
	
	if( costStandardMapper.deleteOneCostStandard(costStandard_ID)==1){
		
		logService.insertOneOperatorLogInfo(user, "收费标准", "删除", "删除收费标准"+costStandard_ID);
		return true;
	 }else {
		return false;
	  }
}

}
