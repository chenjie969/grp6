package com.zjm.sys.logoperator.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.sys.db.model.Sys_logoperator;
import com.zjm.sys.logoperator.service.LogOperatorService;
import com.zjm.util.SystemSession;

/**
*  @description 操作日志action
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年5月10日 下午5:02:33
*/
@Controller
public class LogOperatorAction {
	
	@Resource
	private LogOperatorService  logOperatorService;
	
	/**
	 * 
	 * @description 查询操作日志的分页列表
	 * @author wuhn
	 * @date 2017年5月10日 下午5:11:25
	 */
	@RequestMapping(value="/selectLogOperatorPageTables",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectLogOperatorPageTables(@RequestBody PageTable<Sys_logoperator> pageTable ){
		String queryCondition = queryCondition(pageTable);
		pageTable.setWheresql(queryCondition);
		pageTable=logOperatorService.selectLogOperatorPageTables(pageTable);
		pageTable.setWheresql("");
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	
	
	
	private String queryCondition(PageTable<Sys_logoperator> pageTable) {
		String wheresql=" and unit_uid='"+ SystemSession.getUserSession().getUnit_uid()+"'";
		if(pageTable==null){
			return "";
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql=wheresql+" and username like \'%"+pageTable.getSearchText().trim()+"%\'";
		}
		if(pageTable.getQueryCondition()!=null){ //查询条件不为空
			if(null != pageTable.getQueryCondition().getOperatordatetime()){
				String operatordatetime = pageTable.getQueryCondition().getOperatordatetime();//操作时间查询
				String startTime = operatordatetime.substring(0, 11).trim();
				String endTime = operatordatetime.substring(13).trim();
				if(startTime.equals(endTime)){//若开始时间和结束时间相等，则查询当天的时间
					wheresql+=" and DATE_FORMAT(operatordatetime,'%Y-%m-%d') = '"+ startTime +"'" ;
				}else{
					wheresql=wheresql+" and operatordatetime >='"+startTime+"' and operatordatetime <= '"+endTime+"'";
				}
			}
		}

		String sortName = pageTable.getSortName();//排序字段名
		String sortOrder = pageTable.getSortOrder(); // 排序方式
		if(sortName!=null && !sortName.equals("") && sortOrder!=null && !sortOrder.equals("")){
				wheresql=wheresql+" order by "+sortName.trim()+"  " +sortOrder+"";
		}else{
			wheresql=wheresql+" ORDER BY operatordatetime desc"; //默认按照最近的上机时间排序
		}
		return wheresql;
	}


	/**
	 * 
	 * @description 查询一条操作日志信息
	 * @author wuhn
	 * @date 2017年5月10日 下午5:28:58
	 */
	@RequestMapping(value="/selectOneLogOperatorInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneLogOperatorInfo(@RequestBody Sys_logoperator sys_logoperator){
		sys_logoperator.setUnitUid(SystemSession.getUserSession().getUnit_uid());
		Sys_logoperator logOperatorInfo = logOperatorService.selectOneLogOperatorInfo(sys_logoperator);
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(logOperatorInfo);
		return ar;
	}
	
	/**
	 * 
	 * @description  删除一条操作日志信息
	 * @author wuhn
	 * @date 2017年5月10日 下午5:32:06
	 */
	@RequestMapping(value="/deleteOneLogOperatorInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteOneLogOperatorInfo(@RequestBody Sys_logoperator sys_logoperator){
		sys_logoperator.setUnitUid(SystemSession.getUserSession().getUnit_uid());
		Boolean bool = logOperatorService.deleteOneLogOperatorInfo(sys_logoperator,SystemSession.getUserSession());
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 
	 * @description  删除全部日志，清空日志信息
	 * @author wuhn
	 * @date 2017年5月10日 下午5:33:15
	 */
	@RequestMapping(value="/deleteAllLogOperator",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteAllLogOperator(@RequestBody Sys_logoperator sys_logoperator ){
		sys_logoperator.setUnitUid(SystemSession.getUserSession().getUnit_uid());
		Boolean bool = logOperatorService.deleteAllLogOperator(sys_logoperator,SystemSession.getUserSession());
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 
	 * @description	添加一条日志信息
	 * @author wuhn
	 * @date 2017年5月10日 下午5:34:37
	 */
	@RequestMapping(value="/insertOneLogOperatorInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneLogOperatorInfo(@RequestBody Sys_logoperator sys_logoperator){
		Boolean bool = logOperatorService.insertOneLogOperatorInfo(sys_logoperator);
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	
}
