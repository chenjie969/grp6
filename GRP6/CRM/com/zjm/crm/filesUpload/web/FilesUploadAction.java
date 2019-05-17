package com.zjm.crm.filesUpload.web;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.model.Client;
import com.zjm.crm.db.model.Crm_clientfiles;
import com.zjm.crm.db.model.UploadParam;
import com.zjm.crm.filesUpload.service.FilesUploadService;
import com.zjm.pro.contractdoc.service.ContractdocService;
import com.zjm.pro.db.model.Pro_contractdoc;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;


@Controller
@RequestMapping(value="/crm/filesUpload")
public class FilesUploadAction {
	//上传
	@Resource
	private FilesUploadService filesUploadService;
	
	
	//字典service
	@Resource
	private DicTypeService dicTypeService;
	
	//客户service
	@Resource
	private ClientService clientService;
	
	/**
	 * 附件信息页面PageTable
	 * @param sys_usergroup
	 * @return
	 */
	@RequestMapping(value="/selectFilesListPage")
	public ModelAndView selectFilesListPage(UploadParam uploadParam){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/filesUpload/fileup");
		mv.getModel().put("uploadParam", uploadParam);
		return mv;
	}
	/**
	 * 文档模板信息页面PageTable
	 * @return
	 */
	@RequestMapping(value="/selectDocMouldListPage")
	public ModelAndView selectDocMouldListPage(UploadParam uploadParam){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		String name = uploadParam.getName();
		if(null != name && "02".equals(name)){
			mv.setViewName("/sys/dataBaseVindicate/docMould/templateUpload");
		}else{
			mv.setViewName("/sys/dataBaseVindicate/docMould/docMould");
		}
		mv.getModel().put("uploadParam", uploadParam);
		return mv;
	}
	/**
	 * 文件上传
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertOneFilesUpload", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public AjaxRes insertOneFilesUpload(HttpServletRequest request,HttpSession session,UploadParam uploadParam) throws Exception {
		try {
			uploadParam.setRequest(request);//手动传入Plupload对象HttpServletRequest属性
			//获取root路径 设置上传文件目录 
			String rootPath=request.getSession().getServletContext().getRealPath("/");
			Boolean result = filesUploadService.saveFile(SystemSession.getUserSession(),uploadParam,rootPath);
			AjaxRes ar=new AjaxRes();
			ar.setSucceed(result);
			return ar;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 附件List
	 */
	@RequestMapping(value="/selectAllFilesList", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public AjaxRes selectAllFilesList(@RequestBody PageTable pageTable){
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable = filesUploadService.selectAllFilesList(pageTable);
		pageTable.setWheresql("");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 合同模板List
	 */
	@RequestMapping(value="/selectAllDocMouldList", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public AjaxRes selectAllDocMouldList(@RequestBody PageTable pageTable){
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable = filesUploadService.selectAllDocMouldList(pageTable);
		pageTable.setWheresql("");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 项目附件-意见附件-List
	 */
	@RequestMapping(value="/selectAllProjectFileList", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public AjaxRes selectAllProjectSuggestFileList(@RequestBody PageTable pageTable){
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable = filesUploadService.selectAllProjectSuggestList(pageTable);
		pageTable.setWheresql("");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 项目附件-项目完结评价附件-List
	 */
	@RequestMapping(value="/selectAllProjectEndFileList", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public AjaxRes selectAllProjectEndFileList(@RequestBody PageTable pageTable){
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable = filesUploadService.selectAllProjectSuggestList(pageTable);
		pageTable.setWheresql("");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 菜单分页列表查询条件
	 * @param pageTable
	 * @return
	 */
	private String queryConditionSql(PageTable pageTable){
		String wheresql= pageTable.getWheresql();
		wheresql=wheresql+" and unit_uid =\'"+SystemSession.getUserSession().getUnit_uid()+"\' ";
		if(pageTable==null){
			return wheresql;
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
		//	wheresql=wheresql+" and sourceFileName like \'%"+pageTable.getSearchText().trim()+"%\'";
			wheresql=wheresql+" and oldMouldName like \'%"+pageTable.getSearchText().trim()+"%\'";
		}

		if(pageTable.getUploadParam()!=null ){
			//附件上传入口分类
			if( pageTable.getUploadParam().getFileTwoType()!=null && !pageTable.getUploadParam().getFileTwoType().equals("") ){
				wheresql=wheresql+" and fileType =\'"+pageTable.getUploadParam().getFileTwoType().trim()+"\' ";
			}
			//客户id
			if( pageTable.getUploadParam().getClientID()!=null && !pageTable.getUploadParam().getClientID().equals("") ){
				wheresql=wheresql+" and client_ID =\'"+pageTable.getUploadParam().getClientID()+"\' ";
			}
			//项目id
			if( pageTable.getUploadParam().getProjectID()!=null && !pageTable.getUploadParam().getProjectID().equals("") ){
				wheresql=wheresql+" and projectID =\'"+pageTable.getUploadParam().getProjectID()+"\' ";
			}
			//业务id(entityID)
			if( pageTable.getUploadParam().getEntityID()!=null && !pageTable.getUploadParam().getEntityID().equals("") ){
				wheresql=wheresql+" and entityID =\'"+pageTable.getUploadParam().getEntityID()+"\' ";
			}
			//任务事项id(taskID)
			if( pageTable.getUploadParam().getTaskID()!=null && !pageTable.getUploadParam().getTaskID().equals("") ){
				wheresql=wheresql+" and taskID =\'"+pageTable.getUploadParam().getTaskID()+"\' ";
			}
			//osworkflow 流程id
			if( pageTable.getUploadParam().getOsFlowID()!=null && !pageTable.getUploadParam().getOsFlowID().equals("") ){
				wheresql=wheresql+" and flowID =\'"+pageTable.getUploadParam().getOsFlowID()+"\' ";
			}
			//osworkflow 步骤id
			if( pageTable.getUploadParam().getOsStepID()!=null && !pageTable.getUploadParam().getOsStepID().equals("") ){
				wheresql=wheresql+" and stepID =\'"+pageTable.getUploadParam().getOsStepID()+"\' ";
			}
			//osworkflow 历史步骤id
			if( pageTable.getUploadParam().getOsHistoryID()!=null && !pageTable.getUploadParam().getOsHistoryID().equals("") ){
				wheresql=wheresql+" and historyID =\'"+pageTable.getUploadParam().getOsHistoryID()+"\' ";
			}
		}
		
		String documentCode = pageTable.getQueryCondition().getDocumentCode();//文档编号
		if(documentCode !=null && !"".equals(documentCode) && !"shencha".equals(documentCode)){
			wheresql+=" and mouldName in ('"+documentCode+"')";
		}
		
		//排序功能
		if(pageTable.getSortName()!=null && !pageTable.getSortName().equals("") && pageTable.getSortOrder()!=null && !pageTable.getSortOrder().equals("")){
			wheresql=wheresql+" order by "+pageTable.getSortName().trim()+"  " +pageTable.getSortOrder()+"";
		}else{
			wheresql=wheresql+" order by updateDateTime desc";
		}
		return wheresql;
	}
	/**
	 * 文件下载
	 * @param fileName
	 * @param filePath
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/selectOneFilesDownload")
	public static void selectOneFilesDownload(String fileName, String filePath,
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		//获取root路径 设置上传文件目录 
		String rootPath=request.getSession().getServletContext().getRealPath("/");
		//声明本次下载状态的记录对象
		//DownloadRecord downloadRecord = new DownloadRecord(fileName, filePath, request);
		//设置响应头和客户端保存文件名
		response.setCharacterEncoding("GBK");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName=" + new String(fileName.getBytes("utf-8"),"iso-8859-1"));
		//用于记录以完成的下载的数据量，单位是byte
		//long downloadedLength = 0l;
		try {
			
			
			//打开本地文件流
			InputStream inputStream = new FileInputStream(rootPath+filePath);
			BufferedInputStream  bi =new BufferedInputStream(inputStream);
			
			//激活下载操作
			OutputStream os = response.getOutputStream();
			BufferedOutputStream  bo =new BufferedOutputStream(os);
			
			//循环写入输出流
			byte[] b = new byte[2048];
			int length;
			/*while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
				//downloadedLength += b.length;
			}*/
			
			while((length = bi.read(b) )!= -1){
				bo.write(b, 0, length);
			}
			
			if(bo != null){
				bo.close();
			}
			if(bi != null){
				bi.close();
			}
			
			// 这里主要关闭。
			os.close();
			inputStream.close();
		} catch (Exception e){
			//downloadRecord.setStatus(DownloadRecord.STATUS_ERROR);
			throw e;
		}
		//downloadRecord.setStatus(DownloadRecord.STATUS_SUCCESS);
		//downloadRecord.setEndTime(new Timestamp(System.currentTimeMillis()));
		//downloadRecord.setLength(downloadedLength);
		//存储记录
	}
	
	
	
	/**
	 * 删除附件信息页面
	 * @param sys_usergroup
	 * @return
	 */
	@RequestMapping(value="/selectFilesDelPage")
	public ModelAndView selectFilesDelPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/filesUpload/del");
		return mv;
	}
	/**
	 * 删除一个附件信息
	 * @param uploadParam
	 * @return
	 */
	@RequestMapping(value="/delectOneFilesInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes delectOneFilesInfo(HttpServletRequest request,@RequestBody UploadParam uploadParam){
		//获取root路径 设置上传文件目录 
		String rootPath=request.getSession().getServletContext().getRealPath("/");
		Boolean b = true;
		try {
			b = filesUploadService.delectOneFilesInfo(SystemSession.getUserSession(),uploadParam, rootPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 附件信息页面PageTable crm客户详情用
	 * @return
	 */
	@RequestMapping(value="/selectCrmFilesListPage")
	public ModelAndView selectCrmFilesListPage(UploadParam uploadParam){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/personClient/fileup.jsp");
		mv.getModel().put("uploadParam", uploadParam);
		return mv;
	}
	
	
	
	
	
	
	
	/**
     * 图片文件上传;
     * @param request
     * @param response
     * @param file
     */
  /*  @RequestMapping(value="/insertOnePictureFilesUpload", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public AjaxRes uploadFileHandler(HttpServletRequest request,HttpSession session,@RequestParam("uploadParam") String uploadParam){
        try {
			JSONObject jsonobject = JSONObject.parseObject(uploadParam);
			UploadParam uploadP = (UploadParam) JSONObject.toJavaObject(jsonobject, UploadParam.class);
			uploadP.setRequest(request);//手动传入Plupload对象HttpServletRequest属性
			//获取root路径 设置上传文件目录 
			String rootPath = request.getSession().getServletContext().getRealPath("/");
			Boolean b = filesUploadService.saveFile(uploadP, rootPath);
			AjaxRes ar = new AjaxRes();
			ar.setSucceed(b);
			return ar;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }*/
    /**
	 * 查询图片附件列表集合
	 * @param uploadParam
	 * @return
	 */	
	@RequestMapping(value="/selectPictureFileList")
	public ModelAndView selectPictureFileList(UploadParam uploadParam){	
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		Client client = this.selectCompanyClientInfo(uploadParam.getClientID());
		if("01".equals(client.getClientTypeID()) ){
			uploadParam.setClientFileType("dd8413aadf0945abb1ce600aa8fe45c8");//企业客户;
		}else{
			uploadParam.setClientFileType("dac960048cac4e44ac58ac574c07d125");//个人客户;
			
		}
		//获取图片附件类型:
		List<C_dictype> fileTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID = \'"+uploadParam.getClientFileType()+"\'");//获取企业客户证件资料下拉框;
					
		StringBuffer whereSql = new StringBuffer();
		whereSql.append(" and client_ID = \'"+uploadParam.getClientID()+"\'");
		whereSql.append(" and fileType = \'"+uploadParam.getFileTwoType()+"\'");
		whereSql.append(" and isFile = false ");
		//whereSql.append(" and ( extend= 'png' or   extend= 'jpg' )");
	
		List<Crm_clientfiles> pictureFilesList = filesUploadService.selectPictureFilesList(whereSql.toString());
		mv.setViewName("/crm/client/pictureFiles/pictureFile");
		mv.getModelMap().put("pictureFilesList",pictureFilesList);
			
		mv.getModelMap().put("fileTypeList",fileTypeList);		
		
		mv.getModel().put("client",client);
		return mv;
	}
	@RequestMapping(value="/selectPictureFileListApp")
	@ResponseBody
	public AjaxRes selectPictureFileListApp(@RequestBody UploadParam uploadParam){	
		Client client = this.selectCompanyClientInfo(uploadParam.getClientID());
		if("01".equals(client.getClientTypeID()) ){
			uploadParam.setClientFileType("dd8413aadf0945abb1ce600aa8fe45c8");//企业客户;
		}else{
			uploadParam.setClientFileType("dac960048cac4e44ac58ac574c07d125");//个人客户;
			
		}
		//获取图片附件类型:
		List<C_dictype> fileTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID = \'"+uploadParam.getClientFileType()+"\'");//获取企业客户证件资料下拉框;
					
		StringBuffer whereSql = new StringBuffer();
		whereSql.append(" and client_ID = \'"+uploadParam.getClientID()+"\'");
		whereSql.append(" and fileType = \'"+uploadParam.getFileTwoType()+"\'");
		whereSql.append(" and isFile = false ");
	
		List<Crm_clientfiles> pictureFilesList = filesUploadService.selectPictureFilesList(whereSql.toString());
					
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(fileTypeList);
		ar.setSucceed(pictureFilesList);
		
		
		return ar;
	}
	//根据客户id和机构id 客户对象中的客户名称和编码;
	public Client selectCompanyClientInfo(String  client_ID){
		Client client = new Client ();
		client.setClient_ID(client_ID);
		client.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		Client oneClient = clientService.selectOneClientInfo(client);
		return oneClient;
	}
	
	
	/**
	 * osworkflow意见附件分页列表
	 */
	@RequestMapping(value="/selectAllOsGworkflowFilesPageTables", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public AjaxRes selectAllOsGworkflowFilesPageTables(@RequestBody PageTable pageTable){
		System.out.println(">>>>>>>selectAllOsGworkflowFilesPageTables>>>>>>>>>>>>>>>>>>");
		pageTable.setWheresql(queryConditionSql(pageTable));
		System.out.println(JSON.toJSONString(pageTable));
		pageTable = filesUploadService.selectAllOsGworkflowFilesPageTables(pageTable);
		System.out.println(JSON.toJSONString(pageTable));
		pageTable.setWheresql("");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		System.out.println(">>>>>>>selectAllOsGworkflowFilesPageTables<<<<<<<<<<<<<<<<<");
		return ar;
	}
	@Resource
	private ContractdocService contractdocService;
	@RequestMapping(value="/selectOneFilesUpload", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public AjaxRes selectOneFilesUpload(HttpServletRequest request,HttpSession session,UploadParam uploadParam) throws Exception {
		try {
			uploadParam.setRequest(request);//手动传入Plupload对象HttpServletRequest属性
			//获取root路径 设置上传文件目录 
			String rootPath=request.getSession().getServletContext().getRealPath("/");
			Pro_contractdoc pp=new Pro_contractdoc();
			pp.setContractDoc_ID(uploadParam.getContractDoc_ID());
			pp.setApply_ID(uploadParam.getApply_ID());
			Pro_contractdoc result =contractdocService.selectOneContractdocInfo(pp);
		if(result!=null){
			filesUploadService.updateOneFilesInfo(SystemSession.getUserSession(), uploadParam, rootPath);
		}
			AjaxRes ar=new AjaxRes();
			ar.setSucceed(result);
			return ar;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
