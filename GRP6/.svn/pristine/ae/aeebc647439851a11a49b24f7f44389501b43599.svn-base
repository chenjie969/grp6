package com.zjm.pro.finish.web;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.model.Client;
import com.zjm.gworkFlow.db.map.OsGworkflowInstanceMapper;
import com.zjm.gworkFlow.db.model.OsGworkflowInstance;
import com.zjm.gworkFlow.db.model.OsGworkflowProjsuggest;
import com.zjm.gworkFlow.flowBuild.service.OsGworkflowProjsuggestService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.applyDetail.service.ApplyDetailService;
import com.zjm.pro.contractdoc.service.ContractdocService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_applyDetail;
import com.zjm.pro.db.model.Pro_contractdoc;
import com.zjm.pro.db.model.Pro_finish;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.db.model.Pro_projectfiles;
import com.zjm.pro.finish.service.Pro_finishService;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.pro.projectfiles.service.ProjectfilesService;
import com.zjm.sys.db.model.Sys_docMould;
import com.zjm.sys.docMould.service.DocMouldService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.PriceUtil;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;
import com.zjm.xdocreport.util.ContractUtil;

/**
 * User:    bailf
 * DateTime:2018-03-23 14:51:41
 * details: 完结解保,Action请求层
 */
@RequestMapping("/pro/finish")
@Controller
public class ProFinishAction {


	private Logger log = LoggerFactory.getLogger(ProFinishAction.class);
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ProjectApplyService applyService;
	@Autowired
	private Pro_finishService finishService;
	@Autowired
	private OsGworkflowProjsuggestService osGworkflowProjsuggestService;
	@Autowired
	private OsGworkflowInstanceMapper osGworkflowInstanceMapper;
	@Resource
	private DocMouldService docMouldService;
	@Resource
	private ProjectfilesService  projectfilesService;
	@Resource
	private ClientService clientService;
	@Resource
	private ApplyDetailService applyDetailService;
	@Resource
	private ContractdocService contractdocService;
	
	


	// TODO 数据操作部分
	

	/**
	 * finish页面数据保存
	 * @param finish
	 * @return
	 */
    @ResponseBody
    @RequestMapping(value = "/updateFinish")
    public AjaxRes updateFinish(@RequestBody Pro_finish finish) {
        AjaxRes ar = new AjaxRes();
        try {
			Pro_finish new_finish = new Pro_finish();
			new_finish.setFinishId(finish.getFinishId());
			new_finish.setMargin(finish.getMargin());
			new_finish.setRemark(finish.getRemark());
			Long res = finishService.update(new_finish);
			ar.setSucceed(res);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ar.setFailMsg("保存失败");
		}
        return ar;
    }
	
	// TODO 页面跳转部分
	/**
	 * 701 - 解保资料 
	 * 
	 * 上传《解除保证责任通知书》、还款凭证复印件、《业务解除通知单》; 提供保证金回显  可手动调整
	 * @param urlParam
	 * @return
	 */
	@RequestMapping("/relieveUpload")
    public ModelAndView relieveUpload(String businessId){
    	ModelAndView mv = CustomDispatchServlet.getModeAndView();
    	try {
    		preData(businessId, mv);
			mv.setViewName("/project/finish/finish_relieveUpload");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
    	return mv;
    }
	/**
	 * 702 - 审核有无保证金
	 * 
	 * 审核《解除保证责任通知书》、还款凭证复印件、《业务解除通知单》、保证金
	 * @param urlParam
	 * @return
	 */
	@RequestMapping("/margin")
    public ModelAndView margin(String businessId){
    	ModelAndView mv = CustomDispatchServlet.getModeAndView();
    	try {
    		preData(businessId, mv);
			mv.setViewName("/project/finish/finish_margin");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
    	return mv;
    }
	
	/**
	 * 703 - 业务解除通知单自动生成
	 * 
	 * 项目组ab角   生成业务解除通知单
	 * @param urlParam
	 * @return
	 */
	@RequestMapping("/generate")
    public ModelAndView generate(String businessId){
    	ModelAndView mv = CustomDispatchServlet.getModeAndView();
    	try {
    		preData(businessId, mv);
			mv.setViewName("/project/finish/finish_generate");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
    	return mv;
    }
	/**
	 * 704 - 财务确认
	 * 
	 * 子公司或母公司 财务确认  仅审批功能
	 * @param urlParam
	 * @return
	 */
	@RequestMapping("/financeTrail")
    public ModelAndView financeTrail(String businessId){
    	ModelAndView mv = CustomDispatchServlet.getModeAndView();
    	try {
    		preData(businessId, mv);
			mv.setViewName("/project/finish/finish_financeTrail");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
    	return mv;
    }
	
	/**
	 * 705 - 风险部门初审
	 * 
	 * 子公司风险管理部审核人员   风险部门初审   仅审批功能
	 * @param urlParam
	 * @return
	 */
	@RequestMapping("/riskfirstTrail")
    public ModelAndView riskfirstTrail(String businessId){
    	ModelAndView mv = CustomDispatchServlet.getModeAndView();
    	try {
    		preData(businessId, mv);
			mv.setViewName("/project/finish/finish_riskfirstTrail");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
    	return mv;
    }
	
	/**
	 * 706 - 风险管理部审核
	 * 
	 * 子公司风险管理部部长 风险管理部审核  仅审批功能
	 * @param urlParam
	 * @return
	 */
	@RequestMapping("/riskManagerTrail")
    public ModelAndView riskManagerTrail(String businessId){
    	ModelAndView mv = CustomDispatchServlet.getModeAndView();
    	try {
    		preData(businessId, mv);
			mv.setViewName("/project/finish/finish_riskManagerTrail");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
    	return mv;
    }
	/**
	 * 707 - 解除
	 * 
	 * 子公司风险管理部部长 风险管理部审核  仅审批功能
	 * @param urlParam
	 * @return
	 */
	@RequestMapping("/relieve")
    public ModelAndView relieve(String businessId){
    	ModelAndView mv = CustomDispatchServlet.getModeAndView();
    	try {
    		preData(businessId, mv);
			mv.setViewName("/project/finish/finish_relieve");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
    	return mv;
    }

	/**
	 * 页面数据准备
	 * @param businessId
	 * @param mv
	 * @throws Exception
	 */
	private void preData(String businessId, ModelAndView mv) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("finishId", businessId);
		map.put("unitUid", SystemSession.getUserSession().getUnit_uid());
		Pro_finish finish = finishService.getOne(map);
		Pro_project project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+finish.getProjectId()
												+"\' and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		Pro_apply apply = applyService.selectOneApplyByWhereSql(" and pa.apply_ID = \'"+finish.getApplyId()
				+"\' and pa.unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		
		List<Pro_projectfiles> listFiles = new ArrayList<Pro_projectfiles>();
		listFiles = finishService.getAttachments(businessId, " and fileType = '09'");//完结解保文件类型09
		OsGworkflowInstance instance = new OsGworkflowInstance();
		instance.setBusinessId(finish.getFinishId());
		instance.setBusinessType(finish.getClass().getName());
		instance = osGworkflowInstanceMapper.getOneByBusiness(instance);
		
		OsGworkflowProjsuggest osGworkflowProjsuggest = new OsGworkflowProjsuggest();
		osGworkflowProjsuggest.setFlowID(instance.getEntryId());
		List<OsGworkflowProjsuggest> osSuggestList=osGworkflowProjsuggestService.selectAllOsGworkflowProjsuggest(osGworkflowProjsuggest,SystemSession.getUserSession());
		
		mv.getModelMap().put("osSuggestList", osSuggestList);
		mv.getModelMap().put("finish", finish);
		mv.getModelMap().put("project", project);
		mv.getModelMap().put("apply", apply);
		mv.getModelMap().put("files",listFiles);
		mv.getModelMap().put("flowID", instance.getEntryId());//流程实例id
	}
	
	
	
	// TODO 文档生成部分
	/**
	 * 显示文档模板类型选择页面
	 */
	@RequestMapping(value="/mouldType")
	public ModelAndView mouldType(String flowID, String applyID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		ModelMap modelMap = mv.getModelMap();
		List<Sys_docMould> mouldList = docMouldService.selectDocMouldListByWheresql(" and mouldTypeID='db8ba98240c2421bb6f7d281b352f777'");	//ID值取自单级字典
		modelMap.put("mouldList", mouldList);
		modelMap.put("flowID", flowID);
		modelMap.put("applyID", applyID);
		mv.setViewName("/project/finish/mouldType");
		return mv;
	}
	/**
	 * @description	根据文档模板生成文档
	 * @author wuhn
	 * @date 2017年8月9日 下午5:03:22
	 * tmps 模板文件路径
	 */
	@RequestMapping(value="/generateDocument")
	@ResponseBody
	public AjaxRes generateDocument(@RequestBody Pro_projectfiles projectfiles,HttpServletRequest request){
		AjaxRes  ar =new AjaxRes();
		Boolean bool = createDocument(projectfiles,request);
		ar.setSucceed(bool);
		return ar;
	}

	
	/**
	 * @description	  根据模板生成文档
	 * @author wuhn
	 * @date 2017年8月9日 下午6:24:10
	 */
	private Boolean createDocument(Pro_projectfiles projectfiles,HttpServletRequest request) {
		String realPath = request.getServletContext().getRealPath("/");
		String templatePath=realPath+ projectfiles.getMouldPath(); //模板路径
		String tempPath=projectfiles.getMouldPath();
		tempPath=tempPath.substring(0,tempPath.lastIndexOf("/")).replace("docMould", "projFiles");
		String destPath=realPath+tempPath; //目标存储路径 //目标存储路径
		File file = new File(destPath);
		if(!file.exists()){
			file.mkdirs();
		}
		String newDocName="/"+Tool.createUUID32()+".docx";
		projectfiles.setPathFile(tempPath+newDocName);
		destPath=destPath+newDocName;
		//查询业务/授信申请信息表
		Pro_apply apply = applyService.selectOneApplyByWhereSql(" and apply_ID='"+projectfiles.getEntityID()+"' ");
		//新增贷后项目 目前pro_apply、pro_project、pro_apoplyDetail为一一对应
		Pro_applyDetail detail = applyDetailService.selectOneApplyDetailByWhereSql(" and apply_ID = \'"+projectfiles.getEntityID()+"\'");
		Client client = clientService.selectMainClientByClient_ID(apply.getClient_ID());
		Pro_contractdoc doc = new Pro_contractdoc();
		doc.setContractCode(apply.getdContractCode());
		doc = contractdocService.selectOneContractdocInfo(doc);
		//根据业务id获取业务表信息;
		String wheresql = " and apply_ID = \'"+apply.getApply_ID()+"\'";
	    Pro_project project = projectService.selectOneProjectInfoByWheresql(wheresql);
		Map<String, Object> map = getMapData(client,apply,project,detail,doc);
		try {
		ContractUtil.generateWord(templatePath, destPath, map);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		projectfiles.setProjectFiles_ID(Tool.createUUID32());
		projectfiles.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		projectfiles.setUpdateUserName(SystemSession.getUserSession().getUser_name());
		projectfiles.setUploadManID(SystemSession.getUserSession().getUser_id());
		projectfiles.setUploadManName(SystemSession.getUserSession().getUser_name());
		projectfiles.setFileSize(new File(destPath).length()+"");
		Boolean bool = projectfilesService.insertOneProFilesInfo(SystemSession.getUserSession(), projectfiles);
		return bool;
	}
	/**
	 * 处理路径中的分隔符, 路径保存到数据库时调用
	 */
	public String getPath(String sysPath){
		return sysPath.replace("\\", "/");
	}
	
	/**
	 * @description	  获取生成文档数据
	 * @author wuhn
	 * @param detail 
	 * @param doc 
	 * @date 2017年8月10日 上午10:31:29
	 */
	private Map<String, Object> getMapData(Client client,Pro_apply apply,Pro_project project, Pro_applyDetail detail, Pro_contractdoc doc) {
		Map<String,Object> map =new HashMap<>();
		map.put("client", client);
		map.put("apply", apply);
		map.put("project", project);
		map.put("detail", detail);
		map.put("doc", doc);
//		BigDecimal bd = new BigDecimal(project.getGuarantySum()==null?0:project.getGuarantySum());
//		bd.setScale(0);
//		map.put("rmb", PriceUtil.getRMB(Long.valueOf((bd.toString()))));
		map.put("bigRegisterSum", PriceUtil.getRMB((long) (client.getRegisterSum()*100)));//注册金额大写
//		map.put("age", 18);
//		map.put("address", "北京市朝阳区建华南路17号现代柏联大厦");
		return map;
	}
	// TODO 附件部分
	/**
     * 根据ID获取该会议关联的附件
     * @param entityID
     * @return 查询附件
     */
    @ResponseBody
    @RequestMapping(value = "/getAttachments")
    public AjaxRes getAttachments(String entityID, String fileType) {
        List<Pro_projectfiles> listFiles = new ArrayList<Pro_projectfiles>();
        //fileType: 09为完结解保附件  此处在续保任务事项调用  故不做查询参数穿进去
        listFiles = finishService.getAttachments(entityID, " and fileType = '"+fileType+"'");
        AjaxRes ar = new AjaxRes();
        ar.setSucceed(listFiles);
        return ar;
    }
    /**
     * 根据文件ID删除该文件
     *
     * @param files_ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAttachment")
    public AjaxRes deleteAttachment(String projectFiles_ID) {
        AjaxRes ar = new AjaxRes();
        ar.setSucceed(finishService.deleteAttachment(projectFiles_ID));
        return ar;
    }
}
