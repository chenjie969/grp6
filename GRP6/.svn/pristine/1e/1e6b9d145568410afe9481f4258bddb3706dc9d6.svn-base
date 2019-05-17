package com.zjm.pro.db.map;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_optGuaranty;

public interface Pro_optGuarantyMapper {
	
	/**
	 * @description	添加一条保证措施信息
	 * @author wuhn
	 * @date 2017年7月3日 下午7:29:41
	 */
	int insertOneOptGuarantyInfo(Pro_optGuaranty optGuaranty);
	
	
	/**
	 * @description   保证措施ID   optGuaranty_ID 删除保证措施信息
	 * @author wuhn
	 * @date 2017年7月3日 下午7:26:41
	 */
    int deleteOneOptGuarantyInfo(String optGuaranty_ID);
    
    /**
     * @description	 保证措施ID   optGuaranty_ID 动态修改 保证措施信息
     * @author wuhn
     * @date 2017年7月3日 下午7:27:44
     */
    int updateOneOptGuarantyInfo(Pro_optGuaranty optGuaranty);

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
    List<Pro_optGuaranty>  selectOptGuarantyPageTables(PageTable<Pro_optGuaranty>  pageTable);
    
    /**
     * @description   计算保证措施 分页列表 总记录数
     * @author wuhn
     * @date 2017年7月3日 下午7:38:57
     */
    int selectOptGuarantyPageTables_Count(PageTable<Pro_optGuaranty>  pageTable);
    
    Double selectGuarantySumByWheresql(@Param("wheresql")String wheresql);


	Integer deleteOptGuarantyByApply_Id(String apply_ID);


	List<Pro_optGuaranty> selectOptGuarantyByWheresql(String whereSql);


	String getGuaranteeRemarkByWheresql(String wheresql);
    
}