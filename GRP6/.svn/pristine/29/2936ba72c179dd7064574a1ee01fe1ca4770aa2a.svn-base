package com.zjm.sys.loglogin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.sys.db.map.Sys_logloginMapper;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.sys.db.model.Sys_loglogin;
import com.zjm.sys.loglogin.service.LogloginService;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

/**
*  @description  登录日志service
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年5月9日 下午6:44:11
*/
@Service(value="logloginService")
@Transactional
public class LogloginServiceImpl implements LogloginService {
	
	@Resource
	private Sys_logloginMapper  sys_logloginMapper;
	
	@Resource
	private LogService  logService ;// 日志接口
	
	/**
	 * 
	 * @description 查询分页列表
	 * @author wuhn
	 * @date 2017年5月9日 下午5:27:50
	 */
	public PageTable<Sys_loglogin> selectLogLoginPageTables(PageTable<Sys_loglogin> pageTable){
		List<Sys_loglogin> list = sys_logloginMapper.selectLogLoginPageTables(pageTable);//分页条数
		Long total = sys_logloginMapper.selectLogLoginPageTables_Count(pageTable); //总记录数
		pageTable.setRows(list);
		pageTable.setTotal(total);
		return pageTable;
		
	}
	
	/**
	 * @description  查询总记录数
	 * @author wuhn
	 * @date 2017年5月9日 下午5:29:33
	 */
	public Long selectLogLoginPageTables_Count(PageTable<Sys_loglogin> pageTable){
		return	sys_logloginMapper.selectLogLoginPageTables_Count(pageTable);
	}
	
	/**
     * 
     * @description 根据日志id 获取一条日志信息
     * @author wuhn
     * @date 2017年5月9日 下午5:25:38
     */
    public Sys_loglogin selectOneLogLoginInfo(Sys_loglogin sys_loglogin){
    	return	sys_logloginMapper.selectOneLogLoginInfo(sys_loglogin);
    }
	
	
	/**
	 * 
	 * @description 根据日志id  删除一条日志信息
	 * @author wuhn
	 * @date 2017年5月9日 下午5:24:05
	 */
    public Boolean deleteOneLogLoginInfo(Sys_loglogin sys_loglogin,User user){
    	try {
			int info = sys_logloginMapper.deleteOneLogLoginInfo(sys_loglogin);
			if( info > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    		return false;
    }
    
    /**
     * @description  删除全部日志信息 
     * @author wuhn
     * @date 2017年5月9日 下午5:31:28
     */
    public Boolean deleteAllLogLogin(Sys_loglogin Sys_loglogin,User user){
    	 try {
			int deleteAllLogLogin = sys_logloginMapper.deleteAllLogLogin(Sys_loglogin);
			 if(deleteAllLogLogin > 0){
				 return true;
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
    	 	return false;
    }
    
    /**
     * @description  插入 添加 一条日志信息
     * @author wuhn
     * @date 2017年5月9日 下午5:25:16
     */
    public Boolean insertOneLogLoginInfo(Sys_loglogin sys_loglogin) {
    	sys_loglogin.setUnitUid(SystemSession.getUserSession().getUnit_uid());
    	// 获取之前数据库中已经存贮的日志条数
    	Integer allRows = sys_logloginMapper.selectCountLogLogins(sys_loglogin);
    	if(allRows > 100000 ){ //若存贮的日志条数大于10w条 则清除之前保存的数据
    		sys_logloginMapper.deleteAllLogLogin(sys_loglogin);
    	}
    	sys_loglogin.setLogloginid(Tool.createUUID32());//上机id
    	sys_loglogin.setUnitUid(SystemSession.getUserSession().getUnit_uid()); //担保机构id
    	sys_loglogin.setUsername(SystemSession.getUserSession().getUnit_uidName());//担保机构名称
    	sys_loglogin.setUsername(SystemSession.getUserSession().getUser_name()); //上机人姓名
    	sys_loglogin.setDepartname("");//用户部门
    	sys_loglogin.setLogdescr("");// 操作描述
    	sys_loglogin.setLogtype("");//操作类型
    	sys_loglogin.setLoginaccount(SystemSession.getUserSession().getUser_uid()); //登录帐号

    	sys_loglogin.setIpaddress(""); //登录ip地址
		return sys_logloginMapper.insertOneLogLoginInfo(sys_loglogin)>0;
	}
    
    /**
     * @description 计算已经存在的日志条数, 条件为 机构id
     * @author wuhn
     * @date 2017年5月19日 15:24:04
     */
	@Override
	public Integer selectCountLogLogins(Sys_loglogin Sys_loglogin) {
		return sys_logloginMapper.selectCountLogLogins(Sys_loglogin);
	}

}
