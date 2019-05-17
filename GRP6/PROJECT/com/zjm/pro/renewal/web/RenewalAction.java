package com.zjm.pro.renewal.web;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.UrlParam;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.model.Client;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.applyDetail.service.ApplyDetailService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_applyDetail;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.db.model.Pro_projectfiles;
import com.zjm.pro.db.model.pro_manageRreviewModeExcel;
import com.zjm.pro.db.model.pro_meetingExportModeExcel;
import com.zjm.pro.db.model.pro_reviewCommitteeModeExcel;
import com.zjm.pro.delay.service.DelayService;
import com.zjm.pro.optGuaranty.service.OptGuarantyService;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.pro.projectfiles.service.ProjectfilesService;
import com.zjm.sys.db.model.Sys_docMould;
import com.zjm.sys.docMould.service.DocMouldService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.DateUtil;
import com.zjm.util.PriceUtil;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;
import com.zjm.util.excel.ExportExcel2;
import com.zjm.xdocreport.util.ContractUtil;

/**
 * 续保续贷流程 2Action
 * @author jchen
 *
 */
@Controller
@RequestMapping(value="/project/renewal")
public class RenewalAction {

	@Resource
	private ProjectApplyService projectApplyService;
	@Resource
	private DocMouldService docMouldService;
	@Resource
	private ClientService clientService;
	@Resource
	private ProjectService projectService;
	@Resource
	private ProjectfilesService  projectfilesService;
	@Resource
	private DelayService delayService;
	@Resource
	private ApplyDetailService applyDetailService;
	@Resource
	private OptGuarantyService  optGuarantyService;
	
	/**
	 * 跳转 生成委托担保书页面
	 */
	@RequestMapping(value="/showGuaranteePage")
	public ModelAndView showGuaranteePage(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_apply result = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+urlParam.getEntityID()+"\'");
		mv.getModelMap().put("apply", result);
		List<Pro_projectfiles> list = projectfilesService.selectListProFilesByWhereSql(" and entityID = \'"+urlParam.getEntityID()+"\'" + " and fileType = \'"+"001"+"\'");
		mv.getModelMap().put("fileList", list);
		mv.setViewName("/project/renewal/showGuaranteePage");
		return mv;
	}
	
	/**
	 * 显示文档模板类型选择页面
	 */
	@RequestMapping(value="/showMouldTypePage")
	public ModelAndView showMouldTypePage(String fileType, String applyID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gworkFlow/delay/selectMouldType");
		ModelMap modelMap = mv.getModelMap();
		// 查询担保意向函列表
		List<Sys_docMould> mouldList = docMouldService.selectDocMouldListByWheresql(" and mouldTypeID='a6e4fb06e8eb4ba6830ba284a8e3c83e'");	//ID值取自单级字典
		modelMap.put("mouldList", mouldList);
		modelMap.put("fileType", fileType);
		modelMap.put("applyID", applyID);
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
	public AjaxRes generateDocument(@RequestBody Pro_projectfiles projectfiles,String fileType,HttpServletRequest request){
		AjaxRes  ar =new AjaxRes();
		Boolean bool = createDocument(projectfiles,request);
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * @description	根据文档模板生成文档(生成《委托担保申请书》)
	 * @author wuhn
	 * @date 2017年8月9日 下午5:03:22
	 * tmps 模板文件路径
	 */
	@RequestMapping(value="/generateDocumentTwo")
	@ResponseBody
	public AjaxRes generateDocumentTwo(@RequestBody Pro_projectfiles projectfiles,String fileType,HttpServletRequest request){
		AjaxRes  ar =new AjaxRes();
		projectfiles.setFileType("001");
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
		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+projectfiles.getEntityID()+"' ");
		Pro_applyDetail applyDetail = applyDetailService.selectOneApplyDetailByWhereSql(" and apply_ID='"+projectfiles.getEntityID()+"' ");
		Client client = clientService.selectMainClientByClient_ID(apply.getClient_ID());
		//根据业务id获取业务表信息;
		String wheresql = " and apply_ID = \'"+apply.getApply_ID()+"\'";
	    Pro_project project = projectService.selectOneProjectInfoByWheresql(wheresql);
	    String guaranteeRemarks = optGuarantyService.getGuaranteeRemarkByWheresql(wheresql);
		Map map = getMapData(client,apply,project,guaranteeRemarks,applyDetail);
		try {
		ContractUtil.generateWord(templatePath, destPath, map);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		projectfiles.setProjectFiles_ID(Tool.createUUID32());
		projectfiles.setExtend("docx");
		projectfiles.setSourceFileName("《委托担保申请书》.docx");
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
	 * @date 2017年8月10日 上午10:31:29
	 */
	private Map getMapData(Client client,Pro_apply apply,Pro_project project,String guaranteeRemarks,Pro_applyDetail applyDetail) {
		Map<String,Object> map =new HashMap<>();
		map.put("apply", apply);
		map.put("client", client);
		map.put("applyDetail", applyDetail);
		map.put("guaranteeRemarks", guaranteeRemarks);
		double rSum = client.getRegisterSum() ==null ? 0 : client.getRegisterSum();
		map.put("bigRegisterSum", PriceUtil.getRMB((long) (rSum*100)));//注册金额大写
		map.put("createTime", DateUtil.dateStr(DateUtil.getNow(), DateUtil.DATE_PATTERN));
		return map;
	}
	
	/**
	 * 跳转 生成《**经理办公会评议项目情况简表（Ⅱ）》
	 */
	@RequestMapping(value="/showManageReviewExportPage")
	public ModelAndView showManageReviewExportPage(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_apply result = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+urlParam.getEntityID()+"\'");
		List<Pro_projectfiles> list = projectfilesService.selectListProFilesByWhereSql(" and entityID = \'"+urlParam.getEntityID()+"\'" + " and fileType = \'"+"003"+"\'");
		mv.getModelMap().put("fileList", list);
		mv.getModelMap().put("apply", result);
		mv.setViewName("/project/renewal/showManageReviewExportPage");
		return mv;
	}
	
	/**
	 **  生成经理办公会评议项目情况简表（Ⅰ/Ⅱ）
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageReviewExport")
	@ResponseBody
	public AjaxRes manageReviewExport(HttpServletRequest request,@RequestBody Pro_projectfiles projectfiles) throws Exception {
		String filename = "经理办公会评议项目情况简表（Ⅱ）.xls";
		AjaxRes  ar =new AjaxRes();
		String applyID = projectfiles.getEntityID();
		String flowID =  projectfiles.getFlowID();
		String ccolumnArr[]={"**经理办公会评议项目情况简表(Ⅰ)"};
		String ccolumnArr2[]={"**经理办公会评议项目情况简表（Ⅱ）"};
		String title = "经理办公会（Ⅰ）";
		String title2 = "经理办公会（Ⅱ）";
		ExportExcel2<pro_manageRreviewModeExcel> ex = new ExportExcel2<pro_manageRreviewModeExcel>();
		//OutputStream out = response.getOutputStream();
		OutputStream out = new  ByteArrayOutputStream();
		//对json对象进行转换
//		String entityID = "a34d63cc92ab11e7b87d000000143522";
//		if(null != paramMap){
 // 			entityID =  (String) paramMap.get("entityID");
//		}
		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+applyID+"' ");
		List<pro_manageRreviewModeExcel> list1 = delayService.packageManageReviewExport(SystemSession.getUserSession(),apply);
		
        String filePath = request.getSession().getServletContext().getRealPath("/");
        List<Map<String,Object>> listMap = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("title", title);
        map.put("ccolumnArr", ccolumnArr);
        map.put("list", list1);
        map.put("a", null);
        listMap.add(map);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("title", title2);
        map2.put("ccolumnArr", ccolumnArr2);
        map2.put("list", list1);
        map2.put("a", null);
        listMap.add(map2);
        Pro_projectfiles pro_projectfiles = ex.exportExcel(listMap, out, filePath, applyID,"",list1.size());
        pro_projectfiles.setSourceFileName(filename);
        pro_projectfiles.setExtend("xls");
        pro_projectfiles.setFileType("003");
        boolean a = projectfilesService.insertOneProFilesInfo(SystemSession.getUserSession(), pro_projectfiles);
        ar.setSucceed(a);
		return ar;
	}
	
	/**
	 * 跳转 生成《拟推荐上会项目清单（Ⅰ/Ⅱ）》
	 */
	@RequestMapping(value="/showMeetingExportPage")
	public ModelAndView showMeetingExportPage(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_apply result = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+urlParam.getEntityID()+"\'");
		mv.getModelMap().put("apply", result);
		List<Pro_projectfiles> list = projectfilesService.selectListProFilesByWhereSql(" and entityID = \'"+urlParam.getEntityID()+"\'" + " and fileType = \'"+"002"+"\'");
		mv.getModelMap().put("fileList", list);
		mv.setViewName("/project/renewal/showMeetingExportPage");
		return mv;
	}
	
	/**
	 ** 生成《拟推荐上会项目清单（Ⅰ/Ⅱ）》
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/meetingExport")
	@ResponseBody
	public AjaxRes meetingExport(HttpServletRequest request,@RequestBody Pro_projectfiles projectfiles) throws Exception {
		String filename = "生成《拟推荐上会项目清单（Ⅰ/Ⅱ）》.xls";
		String applyID = projectfiles.getEntityID();
		String flowID =  projectfiles.getFlowID();
		String ccolumnArr[]={"生成《拟推荐上会项目清单（Ⅱ）》"};
		String ccolumnArr2[]={"生成《拟推荐上会项目清单（Ⅰ）》"};
		String title = "经理办公会评议项目情况简表（Ⅱ）";
		String title2 = "经理办公会评议项目情况简表（Ⅰ）";
		ExportExcel2<pro_meetingExportModeExcel> ex = new ExportExcel2<pro_meetingExportModeExcel>();
		OutputStream out =  new  ByteArrayOutputStream();
		//对json对象进行转换
//		String entityID = "a34d63cc92ab11e7b87d000000143522";
//		if(null != paramMap){
// 			entityID =  (String) paramMap.get("entityID");
//		}
		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+applyID+"' ");
		List<pro_meetingExportModeExcel> list1 = delayService.packageMeetingExport(apply);
		
        String filePath = request.getSession().getServletContext().getRealPath("/");
//		ex.exportExcel(title, ccolumnArr, list1, out, null,filePath,entityID);
		List<Map<String,Object>> listMap = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("title", title);
        map.put("ccolumnArr", ccolumnArr);
        map.put("list", list1);
        map.put("a", null);
        listMap.add(map);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("title", title2);
        map2.put("ccolumnArr", ccolumnArr2);
        map2.put("list", list1);
        map2.put("a", null);
        listMap.add(map2);
        Pro_projectfiles projectfiles1 = ex.exportExcel(listMap, out, filePath, applyID,"",list1.size());
        projectfiles1.setFileType("002");
        projectfiles1.setSourceFileName(filename);
        projectfiles1.setExtend("xls");
        boolean a = projectfilesService.insertOneProFilesInfo(SystemSession.getUserSession(), projectfiles1);
        AjaxRes ar =new AjaxRes();
        ar.setSucceed(a);
		return ar;
	}

	/**
	 ** 生成项目评议委员会评审通过项目情况简表(Ⅰ)
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/reviewCommitteeExport")
	@ResponseBody
	public AjaxRes reviewCommitteeExport(HttpServletRequest request,@RequestBody Pro_projectfiles projectfiles) throws Exception {
		String filename = "项目评议委员会评审通过项目情况简表(Ⅰ).xls";
		AjaxRes ar =new AjaxRes();
		String applyID = projectfiles.getEntityID();
		String flowID =  projectfiles.getFlowID();
		String ccolumnArr[]={"项目评议委员会评审通过项目情况简表(Ⅰ)"};
		String ccolumnArr2[]={"项目评议委员会评审通过项目情况简表(Ⅰ)"};
		String title = "集团3000以下";
		String title2 = "中瑞3000以下";
		ExportExcel2<pro_reviewCommitteeModeExcel> ex = new ExportExcel2<pro_reviewCommitteeModeExcel>();
		OutputStream out = new  ByteArrayOutputStream();
		//对json对象进行转换
//		String entityID = "a34d63cc92ab11e7b87d000000143522";
//		if(null != paramMap){
// 			entityID =  (String) paramMap.get("entityID");
//		}
		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+applyID+"' ");
		
		List<pro_reviewCommitteeModeExcel> list1 = delayService.packageCommitteeExport(apply);
		List<Map<String,Object>> listMap = new ArrayList<>();
		Map<String,Object> map = new HashMap<>();
        map.put("title", title);
        map.put("ccolumnArr", ccolumnArr);
        map.put("list", list1);
        map.put("a", null);
        listMap.add(map);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("title", title2);
        map2.put("ccolumnArr", ccolumnArr2);
        map2.put("list", list1);
        map2.put("a", null);
        listMap.add(map2);
        String filePath = request.getSession().getServletContext().getRealPath("/");
        Pro_projectfiles projectfiles1 = ex.exportExcel(listMap, out, filePath, applyID,flowID,list1.size());
        projectfiles1.setSourceFileName(filename);
        projectfiles1.setExtend("xls");
        projectfiles1.setFileType("020");
        boolean a = projectfilesService.insertOneProFilesInfo(SystemSession.getUserSession(), projectfiles1);
	    ar.setSucceed(a);
		return ar;
	}
	
	/**
	 * 跳转 上传《党政联席会会议材料》/
	 */
	@RequestMapping(value="/showUploadFilePage")
	public ModelAndView showUploadFilePage(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_apply result = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+urlParam.getEntityID()+"\'");
		String fileswhereSql = "and entityID='" + urlParam.getEntityID() + "' and fileType = 004 ";
		List<Pro_projectfiles> projectfiles = projectfilesService.selectListProFilesByWhereSql(fileswhereSql);
		mv.getModelMap().put("projectfiles", projectfiles);
		mv.getModelMap().put("apply", result);
		mv.getModelMap().put("fileTwoType", "004");
		mv.setViewName("/project/renewal/showUploadFilePage");
		return mv;
	}
	
	/**
	 * 跳转 上传《管理类档案目录》或者《管理类档案目录,不移交说明》
	 */
	@RequestMapping(value="/showPMDirectoryPage")
	public ModelAndView showPMDirectoryPage(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_apply result = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+urlParam.getEntityID()+"\'");
		String fileswhereSql = "and entityID='" + urlParam.getEntityID() + "' and fileType = 005 ";
		List<Pro_projectfiles> projectfiles = projectfilesService.selectListProFilesByWhereSql(fileswhereSql);
		mv.getModelMap().put("projectfiles", projectfiles);
		mv.getModelMap().put("apply", result);
		mv.getModelMap().put("fileTwoType", "005");
		mv.getModelMap().put("apply", result);
		mv.setViewName("/project/renewal/showPMDirectoryPage");
		return mv;
	}
	
	/**
	 * 跳转 子公司风险部确认接收《管理类档案目录》或者《管理类档案-不移交说明》
	 */
	@RequestMapping(value="/showAffirmPMDirectoryPage")
	public ModelAndView showAffirmPMDirectoryPage(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_apply result = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+urlParam.getEntityID()+"\'");
		String fileswhereSql = "and entityID='" + urlParam.getEntityID() + "' and fileType = 005 ";
		List<Pro_projectfiles> projectfiles = projectfilesService.selectListProFilesByWhereSql(fileswhereSql);
		mv.getModelMap().put("apply", result);
		mv.getModelMap().put("projectfiles", projectfiles);
		mv.setViewName("/project/renewal/showAffirmPMDirectoryPage");
		return mv;
	}
	
	/**
	 *  子公司风险部上传《项目评议委员会评审通过项目情况简表（Ⅱ）》、《党政联席会会议材料》
	 * @param businessId
	 * @return
	 */
	@RequestMapping(value="/riskUpload")
	public ModelAndView riskUpload(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
			//查询业务/授信申请信息表
		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+urlParam.getEntityID()+"' ");
		String fileswhereSql = "and entityID='" + apply.getApply_ID() + "' and fileType = '020' ";// + " or fileType = '003'"
		List<Pro_projectfiles> projectfiles = projectfilesService.selectListProFilesByWhereSql(fileswhereSql);
		mv.getModelMap().put("fileType", "020");
		mv.getModelMap().put("apply", apply);
		mv.getModelMap().put("files", projectfiles);
		mv.getModelMap().put("type", urlParam.getType()==null?"view":urlParam.getType());//默认为查看页面
		mv.setViewName("/project/renewal/riskUpload");
		return mv;
	}
	
	/**
	 *  上传放款通知和放款凭证 
	 * @param businessId
	 * @return
	 */
	@RequestMapping(value="/loanFilesUpload")
	public ModelAndView loanFilesUpload(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		//查询业务/授信申请信息表
		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+urlParam.getEntityID()+"' ");
		String fileswhereSql = "and entityID='" + apply.getApply_ID() + "' and fileType = '007' " ;
		List<Pro_projectfiles> projectfiles = projectfilesService.selectListProFilesByWhereSql(fileswhereSql);
		mv.getModelMap().put("fileType", "007");
		mv.getModelMap().put("apply", apply);
		mv.getModelMap().put("files", projectfiles);
		mv.getModelMap().put("type", urlParam.getType()==null?"view":urlParam.getType());//默认为查看页面
		
		mv.setViewName("/project/renewal/loanFilesUpload");
		return mv;
	}
	
	/**
	 *  子公司审核放款通知和放款凭证 
	 * @param businessId
	 * @return
	 */
	@RequestMapping(value="/loanCheck")
	public ModelAndView loanCheck(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		//查询业务/授信申请信息表
		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+urlParam.getEntityID()+"' ");
		String fileswhereSql = "and entityID='" + apply.getApply_ID() + "' and fileType = '007' " ;
		List<Pro_projectfiles> projectfiles = projectfilesService.selectListProFilesByWhereSql(fileswhereSql);
		
		mv.getModelMap().put("apply", apply);
		mv.getModelMap().put("files", projectfiles);
		mv.getModelMap().put("type", urlParam.getType()==null?"view":urlParam.getType());//默认为查看页面
		
		mv.setViewName("/project/renewal/loanCheck");
		return mv;
	}
	
}
