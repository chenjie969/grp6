package com.zjm.sys.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.model.Sys_loglogin;

public interface Sys_logloginMapper {
	
	/**
	 * 
	 * @description 查询分页列表
	 * @author wuhn
	 * @date 2017年5月9日 下午5:27:50
	 */
	List<Sys_loglogin> selectLogLoginPageTables(PageTable<Sys_loglogin> pageTable);
	
	/**
	 * 
	 * @description  查询总记录数
	 * @author wuhn
	 * @date 2017年5月9日 下午5:29:33
	 */
	Long selectLogLoginPageTables_Count(PageTable<Sys_loglogin> pageTable);
	
	/**
     * 
     * @description 根据日志id 获取一条日志信息
     * @author wuhn
     * @date 2017年5月9日 下午5:25:38
     */
    Sys_loglogin selectOneLogLoginInfo(Sys_loglogin Sys_loglogin);
	
	
	/**
	 * 
	 * @description 根据日志id  删除一条日志信息
	 * @author wuhn
	 * @date 2017年5月9日 下午5:24:05
	 */
    int deleteOneLogLoginInfo(Sys_loglogin Sys_loglogin);
    
    /**
     * 
     * @description  删除全部日志信息 
     * @author wuhn
     * @date 2017年5月9日 下午5:31:28
     */
    int deleteAllLogLogin(Sys_loglogin Sys_loglogin);
    
    /**
     * 
     * @description  插入 添加 一条日志信息
     * @author wuhn
     * @date 2017年5月9日 下午5:25:16
     */
    int insertOneLogLoginInfo(Sys_loglogin Sys_loglogin);
    
    /**
     * @description 计算已经存在的日志条数, 条件为 机构id
     * @author wuhn
     * @date 2017年5月19日 下午3:15:21
     */
    Integer selectCountLogLogins(Sys_loglogin Sys_loglogin);


    
}