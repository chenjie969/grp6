package com.zjm.gbpm.processDefinition.web;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.gbpm.processDefinition.service.ProcessDefinitionService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@RestController
public class ProcessDefinitionAction {
	@Resource
	private ProcessDefinitionService processDefinitionService;
	/**
	 * 流程设计 列表页面
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processDefinition/selectProcessDefinitionPage")
	@ResponseBody
	public ModelAndView selectProcessDefinitionPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/processDefinition/processDefinitionList");
		return mv;
	}
	/**
	 * 流程设计 模型分页列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processDefinition/selectProcessDefinitionPageTable")
	@ResponseBody
	public AjaxRes selectProcessDefinitionPageTable(@RequestBody PageTable pageTable) throws Exception{
		if(pageTable==null){
			pageTable=new PageTable<>();
		}
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable=processDefinitionService.selectProcessDefinitionPageTable(pageTable);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 模型列表查询条件
	 * @param pageTable
	 * @return
	 */
	private String queryConditionSql(PageTable pageTable){
		String wheresql="";
		wheresql=wheresql+" and c.unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ";
		if(pageTable==null){
			return "";
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql=wheresql+" and a.NAME_ like \'%"+pageTable.getSearchText().trim()+"%\'";
		}
		if( null != pageTable.getQueryCondition().getActSortID() && !pageTable.getQueryCondition().getActSortID().equals("")){
			wheresql=wheresql+" and c.actSortID = \'"+pageTable.getQueryCondition().getActSortID().trim()+"\'";
		}
		wheresql=wheresql+" ORDER BY c.order_id ";
		return wheresql;
	}
	
	
	
	/**
	 * 流程设计 新建模型页面
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processDefinition/selectProcessDefinitionModelAddPage")
	@ResponseBody
	public ModelAndView selectProcessDefinitionModelAddPage(@RequestParam("actSortID") String actSortID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/processDefinition/processDefinitionModelAdd");
		mv.getModel().put("actSortID", actSortID);
		return mv;
	}

	/**
	 *新建模型 
	 * @return
	 */
	@RequestMapping(value="/gbpm/processDefinition/createProcessDefinitionModel")
	public AjaxRes createProcessDefinitionModel(@RequestBody String requestParamsObj) {
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(processDefinitionService.createProcessDefinitionModel(requestParamsObj,SystemSession.getUserSession()));
		return ar;
	}


	/**
	 * 流程设计 发布确认页面
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processDefinition/selectProcessDefinitionDeployAddPage")
	@ResponseBody
	public ModelAndView selectProcessDefinitionDeployAddPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/processDefinition/processDefinitionDeployAdd");
		return mv;
	}

	/**
	 * 流程设计 部署
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processDefinition/createProcessDefinitionDeploy", method=RequestMethod.POST)
	public AjaxRes createProcessDefinitionDeploy(@RequestBody String requestParamsObj){
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(processDefinitionService.createProcessDefinitionDeploy(requestParamsObj,SystemSession.getUserSession()));
		return ar;
	}

	/**
	 * 流程设计 导入页面
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processDefinition/selectProcessDefinitionImportAddPage")
	@ResponseBody
	public ModelAndView selectProcessDefinitionImportAddPage(@RequestParam("actSortID") String actSortID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/processDefinition/processDefinitionImportAdd");
		mv.getModel().put("actSortID", actSortID);
		return mv;
	}

	/**
	 * 流程设计 导入
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processDefinition/selectProcessDefinitionImportAdd")
	public AjaxRes selectProcessDefinitionImportAdd(@RequestParam("modelName") String modelName,@RequestParam("description") String description,@RequestParam("actSortID") String actSortID,@RequestParam("zipMFile")MultipartFile zipMFile, HttpServletRequest request, HttpServletResponse response){
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(processDefinitionService.selectProcessDefinitionImportAdd(modelName,description,actSortID,SystemSession.getUserSession(),zipMFile,request,response));
		return ar;
	}

	/**
	 * 流程设计 导出
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processDefinition/selectProcessDefinitionExport")
	public void selectProcessDefinitionExport(String modelId,HttpServletRequest request, HttpServletResponse response){
		try {
			String filename=processDefinitionService.exportbpmnZipName(modelId);
			filesDownload(filename,processDefinitionService.exportbpmnZip(modelId,request,response),request,response);
		} catch (Exception e) {
			//logger.error("导出model的xml文件失败：modelId={}", modelId, e);
		}
	}
	/**
	 * 文件下载
	 * @param fileName
	 * @param filePath
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void filesDownload(String fileName, String filePath,
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		//设置响应头和客户端保存文件名
		response.setCharacterEncoding("GBK");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName=" + new String(fileName.getBytes("utf-8"),"iso-8859-1"));
		try {
			//打开本地文件流
			InputStream inputStream = new FileInputStream(filePath);
			//激活下载操作
			OutputStream os = response.getOutputStream();
			//循环写入输出流
			byte[] b = new byte[2048];
			int length;
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
			}
			// 这里主要关闭。
			os.close();
			inputStream.close();
		} catch (Exception e){
			throw e;
		}
	}
	/**
	 * 流程设计 model 删除确认
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processDefinition/selectProcessDefinitionModelDelPage")
	@ResponseBody
	public ModelAndView selectProcessDefinitionModelDelPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/processDefinition/processDefinitionModelDel");
		return mv;
	}
	/**
	 * 流程设计 删除model、部署的流程定义、已发起的流程
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processDefinition/delectProcessDefinitionModel", method=RequestMethod.POST)
	public AjaxRes delectProcessDefinitionModel(@RequestBody String requestParamsObj){
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(processDefinitionService.delectProcessDefinitionModel(requestParamsObj,SystemSession.getUserSession()));
		return ar;
	}

	/**
	 * 流程设计 流程已发布列表页面
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processDefinition/selectProcessDefinitionDeployListPage")
	@ResponseBody
	public ModelAndView selectProcessDefinitionDeployListPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/processDefinition/processDefinitionDeployList");
		return mv;
	}

	/**
	 * 流程设计 流程已发布分页列表
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processDefinition/selectProcessDefinitionDeployPageTable")
	public AjaxRes selectProcessDefinitionDeployPageTable(@RequestBody PageTable pageTable){
		AjaxRes ar=new AjaxRes();
		pageTable=processDefinitionService.selectProcessDefinitionDeployPageTable(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 流程设计 流程已发布List列表
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processDefinition/selectProcessDefinitionDeployList")
	public AjaxRes selectProcessDefinitionDeployList(@RequestBody PageTable pageTable){
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(processDefinitionService.selectProcessDefinitionDeployList());
		return ar;
	}

	/**
	 * 流程设计 启动流程
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processDefinition/createProcessDefinitionStart", method=RequestMethod.POST)
	public AjaxRes createProcessDefinitionStart(@RequestBody String requestParamsObj){
		AjaxRes ar=new AjaxRes();
		JSONObject requestParams=JSON.parseObject(requestParamsObj);
		String modelKey = (String)requestParams.get("modelKey");
		String entityID = (String)requestParams.get("entityID");
		String entityName = (String)requestParams.get("entityName");
		String entityType = (String)requestParams.get("entityType");
		ar.setSucceed(processDefinitionService.createProcessDefinitionStart(modelKey,entityID,entityName,entityType,SystemSession.getUserSession()));
		return ar;
	}
}
