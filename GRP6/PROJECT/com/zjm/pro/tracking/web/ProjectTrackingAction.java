package com.zjm.pro.tracking.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.model.Client;
import com.zjm.gbpm.db.model.Gbpm_finishNode;
import com.zjm.gbpm.db.model.Gbpm_nodeTask;
import com.zjm.gbpm.db.model.Gbpm_productInstance;
import com.zjm.gbpm.db.model.Gbpm_productNode;
import com.zjm.gbpm.db.model.Gbpm_runNode;
import com.zjm.gbpm.db.model.Gbpm_runTask;
import com.zjm.gbpm.productInstance.service.ProductInstanceService;
import com.zjm.gbpm.runNode.service.RunNodeService;
import com.zjm.gbpm.runTask.service.RunTaskService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.model.EChart;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_dynamic;
import com.zjm.pro.db.model.Pro_riskScheme;
import com.zjm.pro.dynamic.service.DynamicService;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.pro.riskScheme.serivce.RiskSchemeService;
import com.zjm.pro.tracking.service.ProductTrackingService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.sys.util.RolesDataAccreditUtil;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

@Controller
@RequestMapping(value = "/project/projectTracking")
public class ProjectTrackingAction {

	@Resource
	private ProjectApplyService projectApplyService;
	@Resource
	private ProductInstanceService productInstanceService;
	@Resource
	private ProductTrackingService productTrackingService;

	@Resource
	private RunNodeService runNodeService;
	@Resource
	private DicTypeService dicTypeService;
	@Resource
	private RunTaskService runTaskService;
	@Resource
	private ClientService clientService;

	@Resource
	private DynamicService dynamicService;
	@Resource
	private ProjectService projectService;
	@Resource
	private RiskSchemeService riskShemeService;

	public void initSelect(ModelAndView mv) {
		List<C_dictype> projectSourceList = dicTypeService
				.selectAllDicTypeList(" and dicTypePID='3fafef23e87a4b9c99807207f618883d'");// 获取项目(客户)来源下拉框;
		mv.getModelMap().put("projectSourceList", projectSourceList);

		List<C_dictype> busiNatureList = dicTypeService
				.selectAllDicTypeList(" and dicTypePID='53b3870104de46f99940750515404048'");// 获取业务性质下拉框;
		mv.getModelMap().put("busiNatureList", busiNatureList);

		List<C_dictype> projectTypeList = dicTypeService
				.selectAllDicTypeList(" and dicTypePID='d80f39f02f4a4578aa15bd337062a6fd'");// 获取项目类型下拉框;
		mv.getModelMap().put("projectTypeList", projectTypeList);

		List<C_dictype> clientTypeList = dicTypeService
				.selectAllDicTypeList(" and dicTypePID='2624e18b06c34fdabd0df26d51eca41c'");// 获取客户类型下拉框;
		mv.getModelMap().put("clientTypeList", clientTypeList);

		List<C_dictype> greenChannelList = dicTypeService
				.selectAllDicTypeList(" and dicTypePID='70c0e21474174350856987e442c7cd37'");// 获取绿色通道下拉框;
		mv.getModelMap().put("greenChannelList", greenChannelList);
	}

	/**
	 * 申请的分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Pro_apply> pageTable) {
		StringBuffer wheresql = new StringBuffer();
		// 搜索框功能
		if (pageTable == null) {
			return "";
		}
		if (pageTable.getWheresql() != null && !"null".equals(pageTable.getWheresql())) {
			wheresql.append(pageTable.getWheresql());
		}
		
		// wheresql.append(" and taskmanager.unit_uid =
		// \'"+SystemSession.getUserSession().getUnit_uid()+"\' ");
		// wheresql.append(" and isStop = 0 ");//是否终止

		// wheresql.append(" and projectStageID =
		// \'4abbe76851e44d0ea4524d93de2da5be\' ");
		/*
		 * wheresql.append(" and isPutPackage = false" + "and isStop = true" +
		 * "and isCredit=false" + "and projectStageName != '\'受理'\'");
		 */
		// 当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if (null != pageTable.getSearchText()) {
			wheresql.append(" and projectName like \'%" + pageTable.getSearchText().trim() + "%\'");
		}

		// 申请id
		String apply_ID = pageTable.getQueryCondition().getApply_ID();
		if (apply_ID != null && !"".equals(apply_ID)) {
			wheresql.append(" and apply_ID ='" + apply_ID + "'");
		}

		// 根据实例id查询
		if (pageTable.getQueryCondition().getProductInstance_ID() != null
				&& !"".equals(pageTable.getQueryCondition().getProductInstance_ID())) {
			wheresql.append(
					" and productInstanceID = \'" + pageTable.getQueryCondition().getProductInstance_ID() + "\'");
		}
		// 根据节点顺序查询
		if (pageTable.getQueryCondition().getNodeSort() != null
				&& !"".equals(pageTable.getQueryCondition().getNodeSort())) {
			wheresql.append(" and nodeSort = " + pageTable.getQueryCondition().getNodeSort());
		}
		// 根据节点id查询
		if (pageTable.getQueryCondition().getProductID() != null
				&& !"".equals(pageTable.getQueryCondition().getProductID())) {
			wheresql.append(" and productID = \'" + pageTable.getQueryCondition().getProductID() + "\'");
		}
		// 根据项目名称(projectName)
		if (pageTable.getQueryCondition().getProjectName() != null
				&& !"".equals(pageTable.getQueryCondition().getProjectName())) {
			wheresql.append(" and projectName like \'%" + pageTable.getQueryCondition().getProjectName() + "%\'");
		}
		// 根据客户类型ID(clientTypeID)
		if (pageTable.getQueryCondition().getClientTypeID() != null
				&& !"".equals(pageTable.getQueryCondition().getClientTypeID())) {
			wheresql.append(" and clientTypeID = \'" + pageTable.getQueryCondition().getClientTypeID() + "\'");
		}
		// 根据客户名称(clientName)
		if (pageTable.getQueryCondition().getClientName() != null
				&& !"".equals(pageTable.getQueryCondition().getClientName())) {
			wheresql.append(" and clientName like \'%" + pageTable.getQueryCondition().getClientName() + "%\'");
		}
		// 根据业务品种ID(busiTypeName)
		if (pageTable.getQueryCondition().getBusiTypeName() != null
				&& !"".equals(pageTable.getQueryCondition().getBusiTypeName())) {
			wheresql.append(" and busiTypeNameList like \'%" + pageTable.getQueryCondition().getBusiTypeName() + "%\'");
		}
		// 根据申请金额(registerSumStart-registerSumEnd)
		if (pageTable.getQueryCondition().getRegisterSumStart() != null
				&& !"".equals(pageTable.getQueryCondition().getRegisterSumStart())) {
			if (pageTable.getQueryCondition().getRegisterSumEnd() != null
					&& !"".equals(pageTable.getQueryCondition().getRegisterSumEnd())) {

				wheresql.append(" and applySum >= " + pageTable.getQueryCondition().getRegisterSumStart()
						+ " and applySum <=" + pageTable.getQueryCondition().getRegisterSumEnd());
			} else {
				wheresql.append(" and applySum >=" + pageTable.getQueryCondition().getRegisterSumStart());
			}
		} else {
			if (pageTable.getQueryCondition().getRegisterSumEnd() != null
					&& !"".equals(pageTable.getQueryCondition().getRegisterSumEnd())) {
				wheresql.append(" and applySum <=" + pageTable.getQueryCondition().getRegisterSumEnd());
			}
		}
		// 根据合作机构ID(bankName)

		if (pageTable.getQueryCondition().getBankName() != null
				&& !"".equals(pageTable.getQueryCondition().getBankName())) {
			wheresql.append(" and bankNameList like \'%" + pageTable.getQueryCondition().getBankName() + "%\'");
		}
		// 根据经办部门名称(departName)
		if (pageTable.getQueryCondition().getDepartName() != null
				&& !"".equals(pageTable.getQueryCondition().getDepartName())) {
			wheresql.append(" and departName = \'" + pageTable.getQueryCondition().getDepartName() + "\'");
		}
		// 根据经办人名(createManName)
		if (pageTable.getQueryCondition().getCreateManName() != null
				&& !"".equals(pageTable.getQueryCondition().getCreateManName())) {
			wheresql.append(" and createManName like \'%" + pageTable.getQueryCondition().getCreateManName() + "%\'");
		}
		// 根据受理日期(createDateStart-createDateEnd)
		if (pageTable.getQueryCondition().getCreateDateStart() != null
				&& !"".equals(pageTable.getQueryCondition().getCreateDateStart())) {
			// 输入日期 转换格式
			String Time1 = new SimpleDateFormat("yyyy-MM-dd")
					.format(pageTable.getQueryCondition().getCreateDateStart());
			if (pageTable.getQueryCondition().getCreateDateEnd() != null
					&& !"".equals(pageTable.getQueryCondition().getCreateDateEnd())) {
				// 把输入框日期2转换格式
				String Time2 = new SimpleDateFormat("yyyy-MM-dd")
						.format(pageTable.getQueryCondition().getCreateDateEnd());
				wheresql.append(" and createDate >= \'" + Time1 + "\' and createDate <=\'" + Time2 + "\'");
			} else {
				wheresql.append(" and createDate >=\'" + Time1 + "\'");
			}
		} else {
			if (pageTable.getQueryCondition().getCreateDateEnd() != null
					&& !"".equals(pageTable.getQueryCondition().getCreateDateEnd())) {

				String Time2 = new SimpleDateFormat("yyyy-MM-dd")
						.format(pageTable.getQueryCondition().getCreateDateEnd());
				wheresql.append(" and createDate <=\'" + Time2 + "\'");
			}
		}
		return wheresql.toString();
	}

	/**
	 * 查询保（贷）前跟踪页面分页列表
	 * 
	 * @param PageTable<Pro_apply>
	 *            pageTable
	 * @author chenyang
	 * @time :2017-7-5
	 */
	@RequestMapping(value = "/selectProjectTrackingPageTable")
	@ResponseBody
	public AjaxRes selectProjectTrackingPageTable(@RequestBody PageTable<Pro_apply> pageTable) {
		try {
			AjaxRes ar = new AjaxRes();
			pageTable.setWheresql(queryConditionSql(pageTable) + " and isStop = 0  and projectStageName != \'流程未启动\' "
					+ " and unit_uid = \'" + SystemSession.getUserSession().getUnit_uid() + "\' ");
			//设置用户数据权限
			String sql = RolesDataAccreditUtil.appendProSqlByRole(SystemSession.getUserSession().getUser_uid(), RolesDataAccreditUtil.PRO_CREATE_SQL_STR, "");
			if( null != sql ){
				pageTable.setWheresql(pageTable.getWheresql()+sql);
			}
			pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			pageTable = projectApplyService.selectApplyPageTables(pageTable);
			ar.setSucceed(pageTable);
			return ar;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	/**
//	 * 添加保证措施 -- 选择可添加保证措施的项目列表
//	 * @param pageTable
//	 * @return
//	 */
//	@RequestMapping(value = "/selectProjectAddOptGuarantyPageTable")
//	@ResponseBody
//	public AjaxRes selectProjectAddOptGuarantyPageTable(@RequestBody PageTable<Pro_apply> pageTable) {
//		try {
//			AjaxRes ar = new AjaxRes();
//			pageTable.setWheresql(queryConditionSql(pageTable) + " and unit_uid = \'" + SystemSession.getUserSession().getUnit_uid() + "\' ");
//			//设置用户数据权限
//			String sql = RolesDataAccreditUtil.appendProSqlByRole(SystemSession.getUserSession().getUser_uid(), RolesDataAccreditUtil.PRO_CREATE_SQL_STR, "");
//			if( null != sql ){
//				pageTable.setWheresql(pageTable.getWheresql()+sql);
//			}
//			pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
//			pageTable = projectApplyService.selectApplyPageTables(pageTable);
//			ar.setSucceed(pageTable);
//			return ar;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

	/**
	 * 保前 项目处理
	 * 
	 * @param业务ID apply_ID
	 * @return
	 */
	@RequestMapping(value = "/projectBeforeDeal")
	public ModelAndView projectDeal(String apply_ID) {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Gbpm_runNode runNode = new Gbpm_runNode();
		Gbpm_productInstance productInstance = new Gbpm_productInstance();
		List<Gbpm_productNode> productNodeList = new ArrayList<>();
		Client client = new Client();
		Pro_apply apply = new Pro_apply();
		if (null != apply_ID && !"".equals(apply_ID)) {
			String whereSql = "and apply_ID = \'" + apply_ID + "\'";
			// 根据业务id获取申请明细表信息
			apply = projectApplyService.selectOneApplyByWhereSql(whereSql);
			// 根据客户id获取客户信息；
			client = getClientByApply(apply);
			// 根据申请业务id获取产品实例
			productInstance = productInstanceService
					.selectOneProductInstanceByWhereSql("and entityID = \'" + apply_ID + "\'");
			// 根据产品实例id获取正在运行中节点；
			try {
				runNode = productTrackingService.selectRunningNodeByProductInstanceID(SystemSession.getUserSession(),
						productInstance.getProductInstance_ID());
			} catch (Exception e) {
				e.printStackTrace();
			}

			productNodeList = productTrackingService.selectProductNodeListByID(SystemSession.getUserSession(),
					productInstance.getProductID());
		}
		StringBuffer whereSqlnum = new StringBuffer();
		if (null != apply_ID && !"".equals(apply_ID)) {
			whereSqlnum.append(" and apply_ID = \'" + apply_ID + "\'");
			whereSqlnum.append(
					" and readerUserIDList not  like  \'%" + SystemSession.getUserSession().getUser_uid() + "%\'");
			List<Pro_dynamic> list = dynamicService.selectProDynamicList(whereSqlnum.toString());
			int number = list.size();
			mv.getModel().put("number", number);// 未读条数
		}
		mv.getModel().put("apply", apply);// 项目信息；
		mv.getModel().put("client", client);//客户信息；
		mv.getModel().put("productNodeList", productNodeList);// 产品 节点
		mv.getModel().put("productInstance", productInstance);// 产品实例
		mv.getModel().put("runNode", runNode);// 正在运行节点
		mv.setViewName("/project/apply/projectBeforeTracking/projectBeforeDeal");
		return mv;
	}

	/**
	 * 风险方案项目处理
	 * 
	 * @param业务ID 
	 * @return
	 */
	@RequestMapping(value = "/riskProjectDeal")
	public ModelAndView riskProjectDeal(String riskScheme_ID) {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Gbpm_runNode runNode = new Gbpm_runNode();
		Gbpm_productInstance productInstance = new Gbpm_productInstance();
		List<Gbpm_productNode> productNodeList = new ArrayList<>();
		Pro_riskScheme riskScheme = new Pro_riskScheme();
		if (null != riskScheme_ID && !"".equals(riskScheme_ID)) {
			try {
				String whereSql = "and riskScheme_ID = \'" + riskScheme_ID + "\'";
				riskScheme = riskShemeService.selectOneRiskShemeInfo(whereSql);
				// 根据化解方案id获取产品实例
				productInstance = productInstanceService
						.selectOneProductInstanceByWhereSql("and entityID = \'" + riskScheme_ID + "\'");
				// 根据产品实例id获取正在运行中节点；
				runNode = productTrackingService.selectRunningNodeByProductInstanceID(SystemSession.getUserSession(),
						productInstance.getProductInstance_ID());
			} catch (Exception e) {
				e.printStackTrace();
			}

			productNodeList = productTrackingService.selectProductNodeListByID(SystemSession.getUserSession(),
					productInstance.getProductID());
		}
		StringBuffer whereSqlnum = new StringBuffer();
//		if (null != apply_ID && !"".equals(apply_ID)) {
//			whereSqlnum.append(" and apply_ID = \'" + apply_ID + "\'");
//			whereSqlnum.append(
//					" and readerUserIDList not  like  \'%" + SystemSession.getUserSession().getUser_uid() + "%\'");
//			List<Pro_dynamic> list = dynamicService.selectProDynamicList(whereSqlnum.toString());
//			int number = list.size();
//			mv.getModel().put("number", number);// 未读条数
//		}
		mv.getModel().put("riskScheme", riskScheme);// 项目信息；
		mv.getModel().put("productNodeList", productNodeList);// 产品 节点
		mv.getModel().put("productInstance", productInstance);// 产品实例
		mv.getModel().put("runNode", runNode);// 正在运行节点
		mv.setViewName("/project/riskResponse/keyProject/riskProjectDeal");
		return mv;
	}
	
	/**
	 * 保前 项目处理手机端接口
	 * 
	 * @param业务ID apply_ID
	 * @return
	 */
	@RequestMapping(value = "/projectBeforeDealAPP")
	@ResponseBody
	public AjaxRes projectBeforeDealAPP(@RequestBody String apply_ID) {
		AjaxRes ar = new AjaxRes();
		Gbpm_runNode runNode = new Gbpm_runNode();
		Gbpm_productNode productNode = new Gbpm_productNode();
		Gbpm_productInstance productInstance = new Gbpm_productInstance();
		List<Gbpm_productNode> productNodeList = new ArrayList<>();
		List<Object> objectList = new ArrayList<>();
		Pro_apply apply = new Pro_apply();
		if (null != apply_ID && !"".equals(apply_ID)) {
			try {
				String whereSql = "and apply_ID = " + apply_ID;
				// 根据业务id获取申请明细表信息
				apply = projectApplyService.selectOneApplyByWhereSql(whereSql);
				// 根据申请业务id获取产品实例
				productInstance = productInstanceService
						.selectOneProductInstanceByWhereSql("and entityID = " + apply_ID);
				// 根据产品实例id获取正在运行中节点；
				runNode = productTrackingService.selectRunningNodeByProductInstanceID(SystemSession.getUserSession(),
						productInstance.getProductInstance_ID());
				productNodeList = productTrackingService.selectProductNodeListByID(SystemSession.getUserSession(),
						productInstance.getProductID());

				productNode.setProductNodeList(productNodeList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		objectList.add(apply);// 项目信息；
		objectList.add(productInstance);// 产品实例
		objectList.add(runNode);// 正在运行节点
		objectList.add(productNode);//// 产品 节点
		ar.setSucceed(objectList);
		return ar;
	}

	/**
	 * 根据apply对象中的客户id获取客户信息
	 * 
	 * @param apply
	 * @return
	 */
	public Client getClientByApply(Pro_apply apply) {
		Client client = new Client();
		// 如果是关联客户传入关联id
		client.setClient_ID(null == apply.getClient_ID() ? apply.getRelationID() : apply.getClient_ID());
		client = clientService.selectOneClientInfo(client);
		return client;
	}

	/**
	 * 查询正在执行的节点任务
	 * 
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/selectRunningNodeTaskTable")
	@ResponseBody
	public AjaxRes selectRunningNodeTaskTable(@RequestBody PageTable pageTable) {
		AjaxRes ar = new AjaxRes();
		if (pageTable == null) {
			pageTable = new PageTable<Gbpm_runTask>();
		}
		pageTable.setWheresql(queryConditionSql(pageTable) + " and unit_uid = \'"
				+ SystemSession.getUserSession().getUnit_uid() + "\' ");
		pageTable = productTrackingService.selectRunningNodeTaskTable(pageTable);
		pageTable.setWheresql("");
		ar.setSucceed(pageTable);
		return ar;
	}

	/**
	 * 查询已经完成的节点任务
	 * 
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/selectFinishNodeTaskTable")
	@ResponseBody
	public AjaxRes selectFinishNodeTaskTable(@RequestBody PageTable pageTable) {
		AjaxRes ar = new AjaxRes();
		if (pageTable == null) {
			pageTable = new PageTable<Gbpm_runTask>();
		}
		pageTable.setWheresql(queryConditionSql(pageTable) + " and unit_uid = \'"
				+ SystemSession.getUserSession().getUnit_uid() + "\' ");
		pageTable = productTrackingService.selectFinishNodeTaskTable(pageTable);
		pageTable.setWheresql("");
		ar.setSucceed(pageTable);
		return ar;
	}

	/**
	 * 查询未执行的节点任务
	 * 
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/selectNotRunNodeTaskTable")
	@ResponseBody
	public AjaxRes selectNotRunNodeTaskTable(@RequestBody PageTable pageTable) {
		AjaxRes ar = new AjaxRes();
		if (pageTable == null) {
			pageTable = new PageTable<Gbpm_nodeTask>();
		}
		pageTable.setWheresql(queryConditionSql(pageTable) + " and unit_uid = \'"
				+ SystemSession.getUserSession().getUnit_uid() + "\' ");
		try {
			pageTable = productTrackingService.selectNotRunNodeTaskTable(pageTable);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageTable.setWheresql("");
		ar.setSucceed(pageTable);
		return ar;
	}

	/**
	 * 跳转到终止项目页面
	 * 
	 * @param业务ID apply_ID
	 * @return
	 */
	@RequestMapping(value = "/stopProcessPage")
	public ModelAndView stopProcessPage(String apply_ID) {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		List<C_dictype> stopTypeList = new ArrayList<>();// 否决类型list
		Pro_apply apply = new Pro_apply();
		if (null != apply_ID && !"".equals(apply_ID)) {
			String whereSql = "and apply_ID = \'" + apply_ID + "\'";
			// 根据业务id获取申请明细表信息
			apply = projectApplyService.selectOneApplyByWhereSql(whereSql);
			// 获取否决类型list
			stopTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='f7fd34633c704e23a5934582f9c2ac81'");// 获取否决类型下拉框;
		}

		mv.getModel().put("apply", apply);// 项目信息；
		mv.getModelMap().put("stopTypeList", stopTypeList);
		mv.setViewName("/project/apply/projectBeforeTracking/stopProcessPage");
		return mv;
	}


	
	
	/**
	 * 
	 * 否决项目 stopProcess
	 */
	@RequestMapping(value = "/stopProcess", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes stopProcess(@RequestBody Pro_apply apply) {
		Boolean b = true;
		if (apply != null) {
			b = projectApplyService.updateOneApplyInfo(SystemSession.getUserSession(), apply);
		}
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}

	/**
	 * 跳转到变更执行人页面
	 * 
	 * @param业务ID apply_ID
	 * @return
	 */
	@RequestMapping(value = "/changeHandleUserPage")
	public ModelAndView changeHandleUserPage(Gbpm_runTask runTask) {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_apply apply = new Pro_apply();
		if (null != runTask.getEntityID() && !"".equals(runTask.getEntityID())) {
			String whereSql = "and apply_ID = \'" +runTask.getEntityID() + "\'";
			apply = projectApplyService.selectOneApplyByWhereSql(whereSql);
		}
		if (null != runTask.getRunTask_ID() && !"".equals(runTask.getRunTask_ID())) {
			String whereSql = "and runTask_ID = \'" + runTask.getRunTask_ID() + "\'";
			runTask = runTaskService.selectOneRunTaskByWhereSql(whereSql);
		}
		mv.getModel().put("runTask", runTask);// 运行中任务；
		mv.getModel().put("apply", apply);//；
		mv.setViewName("/project/apply/projectBeforeTracking/changeHandleUserPage");
		return mv;
	}
	
	/**
	 * 
	 * 变更执行人
	 */
	@RequestMapping(value = "/changeHandleUser", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes changeHandleUser(@RequestBody Gbpm_runTask runTask) {
		Boolean b = true;
		if (runTask != null) {
			runTask.setHandleDateTime(new Date());
			b = runTaskService.changeHandleUser(SystemSession.getUserSession(),runTask);
		}
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 
	 * 确认完成此事项 stopProcess
	 */
	@RequestMapping(value = "/confirmFinish", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes confirmFinish(@RequestBody Gbpm_runTask runTask) {
		Boolean b = true;
		if (runTask != null) {
			runTask.setHandleDateTime(new Date());
			runTask.setHandleUserID(SystemSession.getUserSession().getUser_uid());
			runTask.setHandleUserName(SystemSession.getUserSession().getUser_name());
			b = runTaskService.updateOneRunTaskInfo(SystemSession.getUserSession(), runTask);
		}
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}

	/**
	 * 
	 * 查询此正在运行节点的任务是否全部处理完成 selectRunTaskListByWhereSql
	 */
	@RequestMapping(value = "/isAllFinish", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes isAllFinish(@RequestBody Gbpm_runTask runTask) {
		Boolean b = true;
		if (runTask != null) {
			List<Gbpm_runTask> runTaskList = runTaskService
					.selectRunTaskListByWhereSql(" and  runNodeID = \'" + runTask.getRunNodeID() + "\'");
			for (Gbpm_runTask runTasks : runTaskList) {
				if (!"已完成".equals(runTasks.getTaskStatus()) && !"选做类型".equals(runTasks.getOperationType())) {
					b = false;
					break;
				}
			}
		}
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}

	/**
	 * 项目管理-保前跟踪-高级条件查询页面;
	 */
	@RequestMapping(value = "/openProBeforeApplySelectPage")
	public ModelAndView openProBeforeApplySelectPage() {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		initSelect(mv);// 获取下拉框
		mv.setViewName("/project/apply/projectApplySelect");
		return mv;
	}

	/**
	 * 
	 * 获取未执行节点限办天数 selectRunTaskListByWhereSql
	 */
	@RequestMapping(value = "/selectNotActiveNodeLimitDay", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectNotActiveNodeLimitDay(@RequestBody Gbpm_productNode gbpm_productNode) {
		AjaxRes ar = new AjaxRes();
		Gbpm_productNode productNode = productTrackingService
				.selectNotActiveNodeLimitDay(" and productNode_ID = \'" + gbpm_productNode.getProductNode_ID() + "\'");
		ar.setSucceed(productNode);
		return ar;
	}

	/**
	 * 
	 * 获取正在执行节点限办天数 selectRunNodeLimitDay
	 */
	@RequestMapping(value = "/selectRunNodeLimitDay", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectRunNodeLimitDay(@RequestBody Gbpm_runNode Gbpm_runNode) {
		AjaxRes ar = new AjaxRes();
		try {
			Gbpm_runNode runNode = productTrackingService
					.selectRunNodeLimitDay(" and runNode_ID = \'" + Gbpm_runNode.getRunNode_ID() + "\'");
			ar.setSucceed(runNode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}

	/**
	 * 
	 * 获取已完成节点限办天数 selectFinishNodeLimitDay
	 */
	@RequestMapping(value = "/selectFinishNodeLimitDay", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectFinishNodeLimitDay(@RequestBody Gbpm_finishNode Gbpm_finishNode) {
		AjaxRes ar = new AjaxRes();
		String whereSql = " and productInstanceID = \'" + Gbpm_finishNode.getProductInstanceID() + "\' ";
		whereSql += " and nodeSort = " + Gbpm_finishNode.getNodeSort();
		Gbpm_finishNode finishNode = productTrackingService.selectFinishNodeLimitDay(whereSql);

		ar.setSucceed(finishNode);
		return ar;
	}

	// ----------------------项目动态-------------------

	/**
	 * 查看信息页面
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/selectDynamicViewPage")
	public ModelAndView selectDynamicViewPage(Pro_dynamic dynamic) {
		if (dynamic == null) {
			dynamic = new Pro_dynamic();
		}
		dynamic.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		dynamic = dynamicService.selectOneProDynamic(dynamic.getDynamic_ID());
		Date d1 = new Date();
		int minutes = ((int) d1.getTime() / 1000 - (int) dynamic.getCreateDateTime().getTime() / 1000) / 60;

		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/apply/projectBeforeTracking/viewDynamic");
		mv.getModel().put("dynamic", dynamic);
		mv.getModel().put("minutes", minutes);
		return mv;
	}

	/**
	 * 查询信息 页面
	 */
	@RequestMapping(value = "/selectDynamicListPage")
	public ModelAndView selectDynamicListPage(String apply_ID) {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try {
			Pro_apply apply = new Pro_apply();
			// 根据业务id获取申请明细表信息
			apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'" + apply_ID + "\'");
			StringBuffer whereSql = new StringBuffer();
			whereSql.append(" set d.`readerUserIDList`= (CONCAT(d.`readerUserIDList`,CONCAT(',','"
					+ SystemSession.getUserSession().getUser_uid() + "'))) ");
			whereSql.append(" where d.apply_id='" + apply_ID + "' AND d.`readerUserIDList` NOT LIKE '%"
					+ SystemSession.getUserSession().getUser_uid() + "%'");
			dynamicService.updateProDynamicList(whereSql.toString());

			mv.setViewName("/project/apply/projectBeforeTracking/projectState");
			mv.getModel().put("apply", apply);// 项目信息；
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "/selectDynamicListPageTables")
	@ResponseBody
	public AjaxRes selectDynamicListPageTables(@RequestBody PageTable pageTable) {
		try {
			pageTable.setWheresql(queryConditionSql1(pageTable));
			pageTable = dynamicService.selectProDynamicTables(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}

	/**
	 * 查询信息 列表
	 */

	@RequestMapping(value = "/selectDynamicListPageTablesAPP")
	@ResponseBody
	public AjaxRes selectDynamicListPageTablesAPP(@RequestBody Pro_dynamic Pro_dynamic) {
		AjaxRes ar = new AjaxRes();
		try{List<Object> dynamicList = new ArrayList<>();
		Pro_apply apply = new Pro_apply();
		// 根据业务id获取申请明细表信息
		apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'" + Pro_dynamic.getApply_ID() + "\'");
		StringBuffer whereSql = new StringBuffer();
		StringBuffer whereSql1 = new StringBuffer();
		whereSql.append(" set d.`readerUserIDList`= (CONCAT(d.`readerUserIDList`,CONCAT(',','"
				+ SystemSession.getUserSession().getUser_uid() + "'))) ");
		whereSql.append(" where d.apply_id='" + Pro_dynamic.getApply_ID() + "' AND d.`readerUserIDList` NOT LIKE '%"
				+ SystemSession.getUserSession().getUser_uid() + "%'");
		dynamicService.updateProDynamicList(whereSql.toString());
		if (null != Pro_dynamic.getApply_ID() && !"".equals(Pro_dynamic.getApply_ID())) {
			whereSql1.append(" and apply_ID = \'" + Pro_dynamic.getApply_ID() + "\'");
		}	
		whereSql1.append("ORDER BY createDateTime desc ");
		List<Pro_dynamic> dynamicLists = dynamicService.selectProDynamicList(whereSql1.toString());
		
		Pro_dynamic.setDynamicList(dynamicLists);
		dynamicList.add(Pro_dynamic);
		dynamicList.add(apply);
		ar.setSucceed(dynamicList);	
		System.out.println(ar);}
		catch(Exception e){
			e.printStackTrace();
		}
		return ar;
	}

	// 分页用的
	@RequestMapping(value = "/selectDynamicListPages")
	public ModelAndView selectDynamicListPages(String apply_ID, String pageNumber) {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try {
			Pro_apply apply = new Pro_apply();
			// 根据业务id获取申请明细表信息
			apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'" + apply_ID + "\'");
			int total = 1;
			total = dynamicService.selectProDynamicCount(" and apply_ID = \'" + apply_ID + "\'");
			if (total % 10 == 0) {
				total = total / 10;
			} else {
				total = total / 10 + 1;
			}
			StringBuffer whereSql1 = new StringBuffer();
			if (null != apply_ID && !"".equals(apply_ID)) {
				whereSql1.append(" and apply_ID = \'" + apply_ID + "\'");
			}
			if (pageNumber == null || "".equals(pageNumber)) {
				pageNumber = "1";
			}
			whereSql1.append("ORDER BY createDateTime desc ");
			whereSql1.append(" limit " + (Integer.parseInt(pageNumber) - 1) * 10 + " ,10");
			List<Pro_dynamic> list = dynamicService.selectProDynamicList(whereSql1.toString());
			mv.setViewName("/project/apply/projectBeforeTracking/projectState");
			mv.getModel().put("total", total);
			mv.getModel().put("list", list);
			mv.getModel().put("apply", apply);// 项目信息；
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return mv;
	}

	

	/**
	 * 分页列表查询条件
	 */
	private String queryConditionSql1(PageTable pageTable) {
		String wheresql = "";
		wheresql = wheresql + " and unit_uid = \'" + SystemSession.getUserSession().getUnit_uid() + "\' ";
		if (pageTable == null) {
			return "";
		}
		if (null != pageTable.getSearchText()) {
			wheresql = wheresql + " and createUserName like \'%" + pageTable.getSearchText().trim() + "%\'";
		}
		wheresql = wheresql + "ORDER BY createDateTime desc ";
		return wheresql;

	}

	/**
	 * 添加项目动态
	 */
	@RequestMapping(value = "/selectDynamicAddPage")
	public ModelAndView selectDynamicAddPage(Pro_dynamic prodynamic) {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/apply/projectBeforeTracking/addDynamic");
		mv.getModel().put("prodynamic", prodynamic);
		return mv;
	}

	/**
	 * 新增一个项目动态
	 */
	@RequestMapping(value = "/insertOneDynamicInfo", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneDynamicInfo(@RequestBody Pro_dynamic prodynamic) {

		try {
			prodynamic.setDynamic_ID(Tool.createUUID32());
			prodynamic.setReaderUserIDList(SystemSession.getUserSession().getUser_id());
			prodynamic.setCreateUserID(SystemSession.getUserSession().getUser_id());
			prodynamic.setCreateUserName(SystemSession.getUserSession().getUser_name());
			prodynamic.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			prodynamic.setUpdateDateTime(new Date());
			prodynamic.setCreateDateTime(new Date());
			prodynamic.setApply_ID(prodynamic.getApply_ID());
			prodynamic.setUpdateUserName(SystemSession.getUserSession().getUser_name());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Boolean b = dynamicService.insertOneProDynamic(prodynamic);
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}

	/**
	 * 删除信息页面
	 */
	@RequestMapping(value = "/selectDynamicDelPage")
	public ModelAndView selectDynamicDelPage(Pro_dynamic prodynamic) {
		if (prodynamic == null) {
			prodynamic = new Pro_dynamic();
		}
		prodynamic = dynamicService.selectOneProDynamic(prodynamic.getDynamic_ID());

		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/apply/projectBeforeTracking/dynamicdel");
		mv.getModel().put("prodynamic", prodynamic);

		return mv;
	}

	/**
	 * 删除一个项目动态
	 */
	@RequestMapping(value = "/delectOneDynamicInfo", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes delectOneCaseInfo(@RequestBody Pro_dynamic prodynamic) {
		AjaxRes ar = new AjaxRes();
		try {
			prodynamic = dynamicService.selectOneProDynamic(prodynamic.getDynamic_ID());
			prodynamic.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			Date d1 = new Date();
			int minutes = ((int) d1.getTime() / 1000 - (int) prodynamic.getCreateDateTime().getTime() / 1000) / 60;

			if (minutes <= 2) {
				Boolean b = dynamicService.deleteProDynamicByDynamicID(prodynamic.getDynamic_ID());
				ar.setSucceed(b);
			} else {
				String result = "error";
				ar.setSucceed(result);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}
	

	// ------------------------授信项目跟踪---------------------------------------start------
	/**
	 * 查询授信跟踪页面分页列表
	 * 
	 * @param PageTable<Pro_apply>
	 *            pageTable
	 * @author
	 * @time :2017-9-4
	 */
	@RequestMapping(value = "/selectCreditTrackingPageTable")
	@ResponseBody
	public AjaxRes selectCreditTrackingPageTable(@RequestBody PageTable<Pro_apply> pageTable) {
		try {
			AjaxRes ar = new AjaxRes();
			pageTable.setWheresql(queryConditionSql(pageTable)
					+ " and isStop = 0 and   projectType = \'综合授信\'  and projectStageName != \'流程未启动\' "
					+ " and unit_uid = \'" + SystemSession.getUserSession().getUnit_uid() + "\' ");
			pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			//设置用户数据权限
			String sql = RolesDataAccreditUtil.appendProSqlByABCCreate(pageTable.getQueryCondition().getUser_uid(),"");
			if( null != sql ){
				pageTable.setWheresql(pageTable.getWheresql()+sql);
			}
			pageTable = projectApplyService.selectApplyPageTables(pageTable);
			ar.setSucceed(pageTable);
			return ar;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// ------------------------授信项目跟踪---------------------------------------end--------

	
	/**
	 * 统计
	 */
	/**
	 * 本年发生  按金额大小统计
	 */
	@RequestMapping(value = "/guarantySumYearBySum", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes guarantySumYearBySum() {
		AjaxRes ar = new AjaxRes();
		EChart eChart = new EChart();
		try {
			eChart = projectService.guarantySumYearBySum(SystemSession.getUserSession());
			ar.setSucceed(eChart);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ar;
	}
	
	/**
	 * 本年发生  按期限统计
	 */
	@RequestMapping(value = "/guarantySumYearByPeriod", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes guarantySumYearByPeriod() {
		AjaxRes ar = new AjaxRes();
		EChart eChart = new EChart();
		try {
			eChart = projectService.guarantySumYearByPeriod(SystemSession.getUserSession());
			ar.setSucceed(eChart);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ar;
	}
	
	/**
	 * 截止累计  按金额大小统计
	 */
	@RequestMapping(value = "/guarantySumBySum", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes guarantySumBySum() {
		AjaxRes ar = new AjaxRes();
		EChart eChart = new EChart();
		try {
			eChart = projectService.guarantySumBySum(SystemSession.getUserSession());
			ar.setSucceed(eChart);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ar;
	}
	
	/**
	 * 截止累计  按期限统计
	 */
	@RequestMapping(value = "/guarantySumByPeriod", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes guarantySumByPeriod() {
		AjaxRes ar = new AjaxRes();
		EChart eChart = new EChart();
		try {
			eChart = projectService.guarantySumByPeriod(SystemSession.getUserSession());
			ar.setSucceed(eChart);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ar;
	}
	
}
