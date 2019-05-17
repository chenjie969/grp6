package com.zjm.sys.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.model.Sys_logoperator;

public interface Sys_logoperatorMapper {
	/**
	 * @description 查询分页列表
	 * @author wuhn
	 * @date 2017年5月9日 下午5:27:50
	 */
	List<Sys_logoperator> selectLogOperatorPageTables(PageTable<Sys_logoperator> pageTable);
	
	/**
	 * 
	 * @description  查询总记录数
	 * @author wuhn
	 * @date 2017年5月9日 下午5:29:33
	 */
	Long selectLogOperatorPageTables_Count(PageTable<Sys_logoperator> pageTable);
	
	/**
     * 
     * @description 根据操作日志id 获取一条操作日志信息
     * @author wuhn
     * @date 2017年5月9日 下午5:25:38
     */
    Sys_logoperator selectOneLogOperatorInfo(Sys_logoperator Sys_logoperator);
	
	
	/**
	 * 
	 * @description 根据操作日志id  删除一条操作日志信息
	 * @author wuhn
	 * @date 2017年5月9日 下午5:24:05
	 */
    int deleteOneLogOperatorInfo(Sys_logoperator Sys_logoperator);
    
    /**
     * 
     * @description  删除全部操作日志信息 
     * @author wuhn
     * @date 2017年5月9日 下午5:31:28
     */
    int deleteAllLogOperator(Sys_logoperator Sys_logoperator);
    
    /**
     * 
     * @description  插入 添加 一条操作日志信息
     * @author wuhn
     * @date 2017年5月9日 下午5:25:16
     */
    int insertOneLogOperatorInfo(Sys_logoperator Sys_logoperator);
    
    /**
     * @description	 统计操作日志的条数   条件为机构id
     * @author wuhn
     * @date 2017年5月19日 下午7:15:42
     */
    Integer selectCountLogOperators(Sys_logoperator Sys_logoperator);
}