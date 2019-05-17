package com.zjm.sys.loglogin.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.sys.db.model.Sys_loglogin;
import com.zjm.sys.loglogin.service.LogloginService;
import com.zjm.util.SystemSession;

/**
*  @description 登录日志action
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年5月9日 下午6:52:43
*/
@Controller
public class LogloginAction {
	
	@Resource
	private LogloginService  logloginService;
	
	/**
	 * @description 登录日志的分页列表
	 * @author wuhn
	 * @date 2017年5月9日 下午7:13:20
	 */
	@RequestMapping(value="/selectLogLoginPageTables",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectLogLoginPageTables(@RequestBody PageTable<Sys_loglogin> pageTable){
		String queryCondition = queryCondition(pageTable);//查询条件
		pageTable.setWheresql(queryCondition);
		pageTable=	logloginService.selectLogLoginPageTables(pageTable);
		pageTable.setWheresql("");
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(pageTable);
		
		return ar;
	}
	
	/**
	 * @description	分页列表的查询条件
	 * @author wuhn
	 * @date 2017年5月9日 下午7:20:41
	 */
	private String queryCondition(PageTable<Sys_loglogin> pageTable) {
		String wheresql="";
		if(pageTable==null){
			return "";
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql=wheresql+" and username like \'%"+pageTable.getSearchText().trim()+"%\'";
		}
		if(pageTable.getQueryCondition()!=null){ //查询条件不为空
			if(null != pageTable.getQueryCondition().getLogindatetime()){
				String logindatetime = pageTable.getQueryCondition().getLogindatetime();// 上机时间段查询
				String startTime = logindatetime.substring(0, 11).trim();
				String endTime = logindatetime.substring(13).trim();
				if(startTime.equals(endTime)){ //若开始时间和结束时间相等,则查询当天时间
					wheresql=wheresql+" and DATE_FORMAT(logindatetime,'%Y-%m-%d') = '"+endTime+"'";
				}else{
					wheresql=wheresql+" and logindatetime >='"+startTime+"' and logindatetime <= '"+endTime+"'";
				}
			}
		}
		User userSession = SystemSession.getUserSession();
		if(null != userSession){ 
			wheresql+=" and unit_uid= '"+ userSession.getUnit_uid()+"'"; //按照机构显示上机日志
		}
		String sortName = pageTable.getSortName();//排序字段名
		String sortOrder = pageTable.getSortOrder(); // 排序方式
		if(sortName!=null && !sortName.equals("") && sortOrder!=null && !sortOrder.equals("")){
				wheresql=wheresql+" order by "+sortName.trim()+"  " +sortOrder+"";
		}else{
			wheresql=wheresql+" ORDER BY logindatetime desc"; //默认按照最近的上机时间排序
		}
		return wheresql;
	}
	
	/**
	 * 
	 * @description	查看一条登录日志信息
	 * @author wuhn
	 * @date 2017年5月10日 下午1:52:57
	 */
	@RequestMapping(value="/selectOneLogLoginInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneLogLoginInfo(@RequestBody Sys_loglogin sys_loglogin){
		sys_loglogin.setUnitUid(SystemSession.getUserSession().getUnit_uid());
		Sys_loglogin logLoginInfo = logloginService.selectOneLogLoginInfo(sys_loglogin);
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(logLoginInfo);
		return ar;
	}
	
	/**
	 * 
	 * @description   删除一条日志信息
	 * @author wuhn
	 * @date 2017年5月10日 下午1:55:11
	 */
	@RequestMapping(value="/deleteOneLogLoginInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteOneLogLoginInfo(@RequestBody Sys_loglogin sys_loglogin){
		sys_loglogin.setUnitUid(SystemSession.getUserSession().getUnit_uid());
		Boolean bool = logloginService.deleteOneLogLoginInfo(sys_loglogin,SystemSession.getUserSession());
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * @description	删除全部日志信息  清空日志信息
	 * @author wuhn
	 * @date 2017年5月10日 下午1:57:47
	 */
	@RequestMapping(value="/deleteAllLogLogin",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteAllLogLogin(){
		Sys_loglogin logLogin=new Sys_loglogin();
		logLogin.setUnitUid(SystemSession.getUserSession().getUnit_uid());
		Boolean bool = logloginService.deleteAllLogLogin(logLogin,SystemSession.getUserSession());
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}

	
	/**
	 * @description	插入 添加 新增 一条 日志信息
	 * @author wuhn
	 * @date 2017年5月10日 下午1:59:19
	 */
	@RequestMapping(value="/insertOneLogLoginInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneLogLoginInfo(@RequestBody Sys_loglogin sys_loglogin){
		Boolean bool = logloginService.insertOneLogLoginInfo(sys_loglogin);
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
}
