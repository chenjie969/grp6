package com.zjm.pro.optGuaranty.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_optGuaranty;

/**
*  @description  保证措施 Service
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年7月3日 下午7:49:48
*/
@Service(value="optGuarantyService")
public interface OptGuarantyService {

	/**
	 * @description	添加一条保证措施信息
	 * @author wuhn
	 * @date 2017年7月3日 下午7:29:41
	 */
	Boolean insertOneOptGuarantyInfo(User user,Pro_optGuaranty optGuaranty);
	
	
	/**
	 * @description   保证措施ID   optGuaranty_ID 删除保证措施信息
	 * @author wuhn
	 * @date 2017年7月3日 下午7:26:41
	 */
    Boolean deleteOneOptGuarantyInfo(User user,String optGuaranty_ID);
    
    /**
     * @description	 保证措施ID   optGuaranty_ID 动态修改 保证措施信息
     * @author wuhn
     * @date 2017年7月3日 下午7:27:44
     */
    Boolean updateOneOptGuarantyInfo(User user,Pro_optGuaranty optGuaranty);

    /**
     * @description 保证措施ID   optGuaranty_ID 获取保证措施信息
     * @author wuhn
     * @date 2017年7月3日 下午7:27:25
     */
    Pro_optGuaranty selectOneOptGuarantyInfo(String optGuaranty_ID);
    
    /**
     * @description  查询保证措施分页列表
     * @author wuhn
     * @date 2017年7月3日 下午7:38:24
     */
    PageTable<Pro_optGuaranty>  selectOptGuarantyPageTables(PageTable<Pro_optGuaranty>  pageTable);
    
    /**
     * @description   计算保证措施 分页列表 总记录数
     * @author wuhn
     * @date 2017年7月3日 下午7:38:57
     */
    int selectOptGuarantyPageTables_Count(PageTable<Pro_optGuaranty>  pageTable);


	List<Pro_optGuaranty> selectOptGuarantyByWheresql(String string);


	int insertOptGuarantyInfo(User userSession, Pro_optGuaranty optGuaranty);


	String getGuaranteeRemarkByWheresql(String wheresql);
    
}
