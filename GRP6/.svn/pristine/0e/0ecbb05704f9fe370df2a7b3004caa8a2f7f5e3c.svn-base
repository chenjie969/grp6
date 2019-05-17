package com.zjm.gbpm.index.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.SysDicData;
import com.zjm.common.sysDicData.service.SysDicDataService;
import com.zjm.gbpm.db.model.AppDesktopVO;
import com.zjm.gbpm.db.model.Gbpm_runTask;
import com.zjm.gbpm.db.model.Index;
import com.zjm.gbpm.index.service.IndexService;
import com.zjm.gbpm.runTask.service.RunTaskService;
import com.zjm.oa.db.model.Oa_message;
import com.zjm.oa.message.service.MessageService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_dynamic;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.dynamic.service.DynamicService;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.sys.db.model.Sys_syspara;
import com.zjm.sys.syspara.service.SysparaService;
import com.zjm.sys.util.RolesDataAccreditUtil;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@RestController
public class IndexAction {
	@Resource
	IndexService indexservice;
	@Resource
	SysDicDataService sysDicDataService;
	@Resource
	private MessageService messageService;
	@Resource
	private ProjectService projectService;
	@Resource
	private SysparaService sysparaService;
	@Resource
	private DynamicService dynamicService;
	@Resource
	private ProjectApplyService projectapplyService;
	@Resource
	private RunTaskService runtaskService;
	/**
	 * 首页--统计数据
	 * @return
	 */
	@RequestMapping(value = "/gbpm/index/indexPackage")
	@ResponseBody
	public ModelAndView indexPackge(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		String monthLoadSumSql = " and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ";//本月统计新增数据sql
		String monthReturnSumSql = " and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ";//本月统计解除数据sql
		String monthIncomeSql = " and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ";//本月统计数据sql
		String yearLoadSumSql = " and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ";//本年统计数据sql
		String yearReturnSumSql = " and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ";//本年统计数据sql
		String sql = " and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ";//本年统计数据sql
		String totalLoadSumSql = " and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ";//累计统计数据sql
		String totalReturnSumSql = " and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ";//累计统计数据sql
		String totalIncomeSumSql = " and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ";//累计统计数据sql
		monthLoadSumSql = monthLoadSumSql + " and YEAR(reportDate) = YEAR(NOW())  AND MONTH(reportDate) = MONTH(NOW())";
		monthReturnSumSql = monthReturnSumSql + " and YEAR(payDate) = YEAR(NOW())  AND MONTH(payDate) = MONTH(NOW())";
		monthIncomeSql = monthIncomeSql + " and YEAR(factCostDate) = YEAR(NOW())  AND MONTH(factCostDate) = MONTH(NOW())";
		yearLoadSumSql = yearLoadSumSql + " and YEAR(reportDate) = YEAR(NOW())";
		yearReturnSumSql = yearReturnSumSql + " and YEAR(payDate) = YEAR(NOW())";
		
		//获取公司通知sql
		String informSql = " AND m.messageTypeID = '52b6f7f2d3a44f9c95890acb53d83d43' AND m.noSignUserIDList like '%"+SystemSession.getUserSession().getUser_uid()+"%' AND m.isSign = '1' AND m.approvalStatus = '04' ORDER BY updateDateTime desc LIMIT 6";
		//获取公司公示sql
		String publicitySql = " AND m.messageTypeID = '742d5377805a42c7b7d34a900365476c' AND m.noSignUserIDList like '%"+SystemSession.getUserSession().getUser_uid()+"%' AND m.isSign = '1' AND m.approvalStatus = '04' ORDER BY updateDateTime desc LIMIT 6";
		try {
			//获取统计数据
			Index yearIndex = indexservice.selectStatisticalData(yearLoadSumSql,yearReturnSumSql);
			mv.getModel().put("yearIndex", yearIndex);
			Index monthIndex = indexservice.selectStatisticalData(monthLoadSumSql,monthReturnSumSql);
			mv.getModel().put("monthIndex", monthIndex);
			Index totalIndex = indexservice.selectStatisticalData(totalLoadSumSql, totalReturnSumSql);
			mv.getModel().put("totalIndex", totalIndex);
			//获取项目动态数据
			StringBuffer whereSql1 = new StringBuffer();			
//			whereSql.append(" set d.`readerUserIDList`= (CONCAT(d.`readerUserIDList`,CONCAT(',','"+SystemSession.getUserSession().getUser_uid()+"'))) "
//					);
			whereSql1.append(" and readerUserIDList NOT LIKE '%"+SystemSession.getUserSession().getUser_uid()+"%'");	
			whereSql1.append(" GROUP BY a.apply_ID ");
//			whereSql1.append(" ORDER BY createDateTime desc ");
			whereSql1.append(" limit "+ "6");			
			List<Pro_dynamic> proMessageList = dynamicService.selectIndexProDynamicList(whereSql1.toString());			
			mv.setViewName("/project/apply/projectBeforeTracking/projectState");
			mv.getModel().put("proMessageList", proMessageList);
			//获取项目进度跟踪List
			List<Pro_apply> applyList = projectapplyService.selectProjectStageList();
			mv.getModel().put("applyList", applyList);
			
			//获取公司通知和信息中心数据
			List<Oa_message> informList = messageService.selectMessageList(informSql);
			mv.getModel().put("informList", informList);
			List<Oa_message> publicityList = messageService.selectMessageList(publicitySql);
			mv.getModel().put("publicityList", publicityList);
			List<SysDicData> messageList=sysDicDataService.selectMultiLevelSortDicList("and pmultilevelsortid='e666b06b1e7c45f4a0e7b520e3da0624'","%");
			Map<String, List<Oa_message>> messageMap = new HashMap<>();
			//获取各个信息的sql
			String documentSql = "";
			for (SysDicData sysDicData : messageList) {
				documentSql = " AND m.messageTypeID = '"+sysDicData.getId()+"' AND m.noSignUserIDList like '%"+SystemSession.getUserSession().getUser_uid()+"%' AND m.isSign = '1' AND m.approvalStatus = '04' ORDER BY updateDateTime desc LIMIT 6";
				List<Oa_message> documentList = messageService.selectMessageList(documentSql);
				messageMap.put(sysDicData.getId(), documentList);
			}
			mv.getModel().put("messageList", messageList);
			Index indexData = new Index();
			indexData = indexservice.selectProData(SystemSession.getUserSession());
			indexData.setMessageMap(messageMap);
			mv.getModel().put("indexData", indexData);
		} catch (Exception e) {
			e.printStackTrace();
		}
//			mv.getModel().put("messageMap", messageMap);
		mv.setViewName("/gbpm/index");
		return mv;
	}
	
	
	/**
	 * @description	首页保后检查计划列表
	 * @author chenyang
	 */
	@RequestMapping(value="/project/index/selectCheckProjectPageTables")
	@ResponseBody
	public AjaxRes selectCheckProjectPageTables(@RequestBody PageTable<Pro_project>  pageTable){
		AjaxRes  ar =new AjaxRes();
		pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());//设置用户id通过匹配用户权限来查询
		try {
			String queryCondition = queryCondition(pageTable);
			pageTable.setWheresql(queryCondition);
			pageTable= projectService.selectCheckProjectPageTables(pageTable);
			pageTable.setWheresql("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(pageTable);
		return ar;
	}
	
	private String queryCondition(PageTable<Pro_project> pageTable) {
		StringBuffer sb=new StringBuffer();
		if (pageTable.getWheresql()!=null) {
			sb.append(pageTable.getWheresql());
		}
		//根据当前用户是否是abc三角及其对应的数据权限进行查询
		if(null != pageTable.getQueryCondition().getUser_uid() && !"".equals(pageTable.getQueryCondition().getUser_uid())){
			String sql = RolesDataAccreditUtil.appendProSqlByABC(pageTable.getQueryCondition().getUser_uid(), "project.");
			if( null != sql){
				sb.append(sql);
			}
		}
		
		String wheresql = " and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ";
		wheresql = wheresql + " and praraID = '02'";
		Sys_syspara para = sysparaService.selectOneSysparaInfo(wheresql);
		sb.append(" and project.unit_uid= '"+SystemSession.getUserSession().getUnit_uid()+"'");
		
		sb.append(" and planCheckDate < DATE_ADD(now(),INTERVAL " + para.getParaValue() + " DAY) " +  " and planCheckDate > NOW()");
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			sb.append(" and projectName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		
		return sb.toString();
	}
	
	/**
	 * @description	首页即将到期列表
	 * @author chenyang
	 */
	@RequestMapping(value="/project/index/selectExpireProjectPageTables")
	@ResponseBody
	public AjaxRes selectExpireProjectPageTables(@RequestBody PageTable<Pro_project>  pageTable){
		AjaxRes  ar =new AjaxRes();
		pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());//设置用户id通过匹配用户权限来查询
		try {
			//添加即将到期wheresql
			String queryCondition = expireQueryCondition(pageTable);
			pageTable.setWheresql(queryCondition);
			pageTable= projectService.selectProjectPageTables(pageTable);
			pageTable.setWheresql("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(pageTable);
		return ar;
	}
	
	private String expireQueryCondition(PageTable<Pro_project> pageTable) {
		StringBuffer sb=new StringBuffer();
		if (pageTable.getWheresql()!=null) {
			sb.append(pageTable.getWheresql());
		}
		
		//根据当前用户是否是abc三角及其对应的数据权限进行查询
		if(null != pageTable.getQueryCondition().getUser_uid() && !"".equals(pageTable.getQueryCondition().getUser_uid())){
			String sql = RolesDataAccreditUtil.appendProSqlByABC(pageTable.getQueryCondition().getUser_uid(), "pp.");
			if( null != sql){
				sb.append(sql);
			}
		}
		String wheresql = " and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ";
		wheresql = wheresql + " and praraID = '01'";
		Sys_syspara para = sysparaService.selectOneSysparaInfo(wheresql);
		sb.append(" and PP.unit_uid= '"+SystemSession.getUserSession().getUnit_uid()+"'");
		sb.append(" and delayEndDate < DATE_ADD(now(),INTERVAL " + para.getParaValue() + " DAY) " +  " and delayEndDate > NOW()");
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			sb.append(" and projectName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		
		return sb.toString();
	}
	
	/**
	 * APP首页
	 * @return
	 */
	@RequestMapping(value = "/app/index/getAppDesktop")
	@ResponseBody
	public AjaxRes getAppDesktop(){
		AjaxRes ar = new AjaxRes();
		try {
			List<AppDesktopVO> desktopList = new ArrayList<>();
			//通知公告类都需要签收, 信息文件类都不用签收
			Long announceNum = messageService.selectTable_Count(" AND m.messageTypePID='331022423f914bebbbf988a03f4227a8' AND m.noSignUserIDList like '%"+SystemSession.getUserSession().getUser_uid()+"%' AND m.isSign = '1' AND m.approvalStatus = '04' AND m.unit_uid = '"+SystemSession.getUserSession().getUnit_uid()+"'  ");
			desktopList.add(new AppDesktopVO("通知", "inform", "您有新的通知，请注意查收！", announceNum.intValue()/*,"331022423f914bebbbf988a03f4227a8"*/));
			Long documentNum = messageService.selectTable_Count(" AND m.messageTypePID='e666b06b1e7c45f4a0e7b520e3da0624' AND m.noSignUserIDList like '%"+SystemSession.getUserSession().getUser_uid()+"%' AND m.isSign = '1' AND m.approvalStatus = '04' AND m.unit_uid = '"+SystemSession.getUserSession().getUnit_uid()+"'  ");
			desktopList.add(new AppDesktopVO("文件", "file", "您有新的文件，请注意查收！", documentNum.intValue()/*,"e666b06b1e7c45f4a0e7b520e3da0624"*/));
			Index indexData = indexservice.selectProData(SystemSession.getUserSession());
			StringBuffer wheresql = new StringBuffer();
			wheresql.append(" and runTask.unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ");
			wheresql.append(" and runTask.handleUserID = \'"+SystemSession.getUserSession().getUser_uid()+"\' ");
			wheresql.append(" and taskStatus = \'"+ "未完成" +"\' ");
			PageTable<Gbpm_runTask> pageTable = new PageTable<>();
			pageTable.setWheresql(wheresql.toString());
			Long waitTaskNumber = runtaskService.selectRunTaskGroupTable_count(pageTable);
			desktopList.add(new AppDesktopVO("待办业务", "daibanyewu", "待办业务",waitTaskNumber.intValue()));
			desktopList.add(new AppDesktopVO("即将上会", "meeting", "即将上会", Integer.valueOf(indexData.getMeetingPro())));
			desktopList.add(new AppDesktopVO("逾期项目", "overdue", "逾期项目", Integer.valueOf(indexData.getOverPro())));
			desktopList.add(new AppDesktopVO("保后检查", "approve", "保后检查", Integer.valueOf(indexData.getCheckPro())));
			desktopList.add(new AppDesktopVO("风险项目", "warning", "风险项目", Integer.valueOf(indexData.getRiskPro())));
			desktopList.add(new AppDesktopVO("即将到期", "oval", "即将到期", Integer.valueOf(indexData.getExpirePro())));
			desktopList.add(new AppDesktopVO("代偿项目", "replace", "代偿项目", Integer.valueOf(indexData.getReplacePro())));
			ar.setSucceed(desktopList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * APP首页--点击"通知"
	 * @return
	 */
	@RequestMapping(value = "/app/index/getAnnounce")
	@ResponseBody
	public AjaxRes getAnnounce(@RequestBody PageTable<Oa_message> pageTable){
		AjaxRes ar = new AjaxRes();
		try {
			pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			pageTable.setWheresql(" AND messageTypePID='331022423f914bebbbf988a03f4227a8' AND isSign='1' AND approvalStatus = '04' AND noSignUserIDList like '%"+SystemSession.getUserSession().getUser_uid()+"%'");
			pageTable = messageService.selectAnnouncePageTable(pageTable);
			ar.setSucceed(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * APP首页--点击"文件"
	 * @return
	 */
	@RequestMapping(value = "/app/index/getDocument")
	@ResponseBody
	public AjaxRes getDocument(@RequestBody PageTable<Oa_message> pageTable){
		AjaxRes ar = new AjaxRes();
		try {
			pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			pageTable.setWheresql(" AND messageTypePID='e666b06b1e7c45f4a0e7b520e3da0624' AND isSign='1' AND approvalStatus = '04' AND noSignUserIDList like '%"+SystemSession.getUserSession().getUser_uid()+"%'");
			pageTable = messageService.selectAnnouncePageTable(pageTable);
			ar.setSucceed(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
}
