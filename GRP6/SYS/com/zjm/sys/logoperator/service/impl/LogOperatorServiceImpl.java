package com.zjm.sys.logoperator.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.sys.db.map.Sys_logoperatorMapper;
import com.zjm.sys.db.model.Sys_logoperator;
import com.zjm.sys.logoperator.service.LogOperatorService;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

/**
*  @description  操作日志service
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年5月10日 下午4:53:40
*/
@Service(value="logOperatorService")
@Transactional
public class LogOperatorServiceImpl implements LogOperatorService {
	
	
	@Resource
	private Sys_logoperatorMapper  sys_logoperatorMapper;
	
	@Resource
	private LogService  logService ;// 日志接口
	
	/**
	 * @description 查询分页列表
	 * @author wuhn
	 * @date 2017年5月9日 下午5:27:50
	 */
	public PageTable<Sys_logoperator> selectLogOperatorPageTables(PageTable<Sys_logoperator> pageTable){
		List<Sys_logoperator> list = sys_logoperatorMapper.selectLogOperatorPageTables(pageTable);//分页条数
		Long total = sys_logoperatorMapper.selectLogOperatorPageTables_Count(pageTable);//总记录数
		pageTable.setRows(list);
		pageTable.setTotal(total);
		return pageTable;
	}
	
	/**
	 * 
	 * @description  查询总记录数
	 * @author wuhn
	 * @date 2017年5月9日 下午5:29:33
	 */
	public Long selectLogOperatorPageTables_Count(PageTable<Sys_logoperator> pageTable){
		return sys_logoperatorMapper.selectLogOperatorPageTables_Count(pageTable);
	}
	
	/**
     * 
     * @description 根据操作日志id 获取一条操作日志信息
     * @author wuhn
     * @date 2017年5月9日 下午5:25:38
     */
    public Sys_logoperator selectOneLogOperatorInfo(Sys_logoperator sys_logoperator){
    	return sys_logoperatorMapper.selectOneLogOperatorInfo(sys_logoperator);
    }
	
	
	/**
	 * 
	 * @description 根据操作日志id  删除一条操作日志信息
	 * @author wuhn
	 * @date 2017年5月9日 下午5:24:05
	 */
    public Boolean deleteOneLogOperatorInfo(Sys_logoperator sys_logoperator ,User user) {
    	try {
			int info = sys_logoperatorMapper.deleteOneLogOperatorInfo(sys_logoperator);
			if( info > 0){
				return true ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    		return false;
	}
    
    /**
     * 
     * @description  删除全部操作日志信息 
     * @author wuhn
     * @date 2017年5月9日 下午5:31:28
     */
    public Boolean deleteAllLogOperator(Sys_logoperator sys_logoperator ,User user) {
		 try {
			int deleteAllLogOperator = sys_logoperatorMapper.deleteAllLogOperator(sys_logoperator);
			 if(deleteAllLogOperator > 0){
				 return true;
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
	}
    
    /**
     * 
     * @description  插入 添加 一条操作日志信息  ---> 暂未使用
     * @author wuhn
     * @date 2017年5月9日 下午5:25:16
     */
    public Boolean insertOneLogOperatorInfo(Sys_logoperator sys_logoperator){
    	sys_logoperator.setUnitUid(SystemSession.getUserSession().getUnit_uid());//担保机构id
    	sys_logoperator.setUsername(SystemSession.getUserSession().getUnit_uidName());//担保机构名称
    	sys_logoperator.setUsername(SystemSession.getUserSession().getUser_name());//上机人姓名
    	sys_logoperator.setUsername(SystemSession.getUserSession().getDepart_uid());//上机人部门名称 
    	sys_logoperator.setModname("");//操作功能模块
    	sys_logoperator.setLogdescr(""); //操作描述
    	sys_logoperator.setOpenratortype("");//操作类型
    	sys_logoperator.setLoginaccount("");//登录帐号
    	sys_logoperator.setIpaddress("");//ip地址
    	sys_logoperator.setLogoperatorid(Tool.createUUID32());
    	return sys_logoperatorMapper.insertOneLogOperatorInfo(sys_logoperator)>0;
    }
    
    /**
     * @description	 统计操作日志的条数   条件为机构id
     * @author wuhn
     * @date 2017年5月19日 下午7:15:42
     */
	@Override
	public Integer selectCountLogOperators(Sys_logoperator Sys_logoperator) {
		
		return sys_logoperatorMapper.selectCountLogOperators(Sys_logoperator);
	}
    
}
