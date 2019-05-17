package com.zjm.gbpm.processDefinition.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.gbpm.db.map.Act_re_model_actSortMapper;
import com.zjm.gbpm.db.map.Act_re_model_deploymentMapper;
import com.zjm.gbpm.db.map.Act_ProcessInstanceMapper;
import com.zjm.gbpm.db.model.Act_re_model_actSort;
import com.zjm.gbpm.db.model.Act_re_model_deployment;
import com.zjm.gbpm.processDefinition.service.ProcessDefinitionService;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;
import com.zjm.util.ZipCompressing;
import com.zjm.util.ZipDecompressing;
@Service("processDefinitionService")
@Transactional
public class ProcessDefinitionServiceImpl implements ProcessDefinitionService {
	/**
	 * 提供对暴露BPM和工作流操作的所有服务的访问
	 */
	private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	/**
	 * 提供访问流程定义和部署存储库的服务
	 */
	private RepositoryService repositoryService = processEngine.getRepositoryService();
	@Resource//activiti模型与流程分类关系表
	private Act_re_model_actSortMapper modelActSortMapper;
	@Resource//activiti模型与部署关系表
	private Act_re_model_deploymentMapper modelDeploymentMapper;
	@Resource//流程实例
	Act_ProcessInstanceMapper processInstanceMapper;
	/**
	 * 流程设计 模型分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectProcessDefinitionPageTable(PageTable pageTable) {
		List<Act_re_model_actSort> list=modelActSortMapper.selectProcessDefinitionPageTable(pageTable);
		Long total=modelActSortMapper.selectProcessDefinitionPageTable_Count(pageTable);
		pageTable.setRows(list);
		pageTable.setTotal(total);
		return pageTable;
	}
	/**
	 *新建模型 
	 * @return
	 */
	public Boolean createProcessDefinitionModel(String requestParamsObj, User userSession) {
		JSONObject requestParams=JSON.parseObject(requestParamsObj);
		try {
			ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
			RepositoryService repositoryService = processEngine.getRepositoryService();
			ObjectMapper objectMapper = new ObjectMapper();
			ObjectNode editorNode = objectMapper.createObjectNode();
			editorNode.put("id", "canvas");
			editorNode.put("resourceId", "canvas");
			ObjectNode stencilSetNode = objectMapper.createObjectNode();
			stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
			editorNode.put("stencilset", stencilSetNode);
			Model modelData = repositoryService.newModel();

			String modelName=(String)requestParams.get("modelName");
			String description = (String)requestParams.get("description");
			String actSortID = (String)requestParams.get("actSortID");
			ObjectNode modelObjectNode = objectMapper.createObjectNode();
			modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, modelName);
			modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
			modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
			modelData.setMetaInfo(modelObjectNode.toString());
			modelData.setName(modelName);
			//modelData.setCategory(category);
			modelData.setKey(Tool.createUUID32());

			//保存模型
			repositoryService.saveModel(modelData);
			repositoryService.addModelEditorSource(modelData.getId(), editorNode.toString().getBytes("utf-8"));
			Act_re_model_actSort modelActSort=new Act_re_model_actSort();
			modelActSort.setUnit_uid(userSession.getUnit_uid());
			modelActSort.setModelID(modelData.getId());
			modelActSort.setActSortID(actSortID);
			modelActSortMapper.insertOneModelActSortInfo(modelActSort);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 流程设计 部署
	 * @return
	 */
	public Boolean createProcessDefinitionDeploy(String requestParamsObj, User userSession) {
		JSONObject requestParams=JSON.parseObject(requestParamsObj);
		try {
			Model modelData = repositoryService.getModel((String)requestParams.get("modelId"));
			ObjectNode modelNode = (ObjectNode) new ObjectMapper().readTree(repositoryService.getModelEditorSource(modelData.getId()));
			byte[] bpmnBytes = null;
			BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);
			bpmnBytes = new BpmnXMLConverter().convertToXML(model);
			String processName = modelData.getName() + ".bpmn20.xml";
			Deployment deployment = repositoryService.createDeployment().name(modelData.getName()).addString(processName, new String(bpmnBytes,"utf-8")).deploy();
			modelData.setDeploymentId(deployment.getId());
			repositoryService.saveModel(modelData);
			Act_re_model_deployment modelDeployment=new Act_re_model_deployment();
			modelDeployment.setUnit_uid(userSession.getUnit_uid());
			modelDeployment.setModelID(modelData.getId());
			modelDeployment.setDeploymentID(deployment.getId());
			modelDeploymentMapper.insertOneModelDeploymentInfo(modelDeployment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 流程设计 导入
	 * @return
	 */
	public Boolean selectProcessDefinitionImportAdd(String modelName, String description,String actSortID,User userSession, MultipartFile zipMFile,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			//获取root路径 设置上传文件目录 
			String rootPath=request.getSession().getServletContext().getRealPath("/");
			String directory = rootPath+"\\unitdata\\unit_"+SystemSession.getUserSession().getUnit_uid()+"\\activiti\\import";
			File zipFile = new File(directory+"\\"+zipMFile.getOriginalFilename());
			//判断文件夹是否存在
			if(!zipFile.exists()) {zipFile.mkdirs();}
			zipMFile.transferTo(zipFile);

			List<String> fileList=ZipDecompressing.zip(zipFile.getPath().substring(0, zipFile.getPath().lastIndexOf('.')), zipFile);
			File xmlFile = null;
			File pngFile = null;
			for(int i=0;i<fileList.size();i++){
				if(fileList.get(i).substring(fileList.get(i).lastIndexOf('.')+1).toLowerCase().equals("xml")){
					xmlFile=new File(fileList.get(i));
				}else{
					pngFile=new File(fileList.get(i));
				}
			}


			InputStream resourceAsStream = new FileInputStream(xmlFile);
			XMLInputFactory xif = XMLInputFactory.newInstance();
			InputStreamReader in = new InputStreamReader(resourceAsStream, "UTF-8");
			XMLStreamReader xtr = xif.createXMLStreamReader(in);


			BpmnXMLConverter xmlConverter = new BpmnXMLConverter();
			BpmnModel bpmnModel=xmlConverter.convertToBpmnModel(xtr);

			BpmnJsonConverter converter = new BpmnJsonConverter();
			ObjectNode modelNode = converter.convertToJson(bpmnModel);

			ObjectMapper objectMapper = new ObjectMapper();
			ObjectNode editorNode = objectMapper.createObjectNode();
			editorNode.put("id", "canvas");
			editorNode.put("resourceId", "canvas");
			ObjectNode stencilSetNode = objectMapper.createObjectNode();
			stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
			editorNode.put("stencilset", stencilSetNode);
			Model modelData = repositoryService.newModel();
			ObjectNode modelObjectNode = objectMapper.createObjectNode();
			modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, modelName);
			modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
			modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
			modelData.setMetaInfo(modelObjectNode.toString());
			modelData.setName(modelName);
			modelData.setKey(Tool.createUUID32());

			//保存模型
			repositoryService.saveModel(modelData);
			repositoryService.addModelEditorSource(modelData.getId(), modelNode.toString().getBytes("utf-8"));
			InputStream pngIS=new FileInputStream(pngFile);
			ByteArrayOutputStream swapStream = new ByteArrayOutputStream();  
			byte[] buff = new byte[1024];  
			int rc = 0;  
			while ((rc = pngIS.read(buff)) > 0) {  
				swapStream.write(buff, 0, rc);  
			}  
			byte[] pngISbyte = swapStream.toByteArray();
			repositoryService.addModelEditorSourceExtra(modelData.getId(), pngISbyte);
			
			Act_re_model_actSort modelActSort=new Act_re_model_actSort();
			modelActSort.setUnit_uid(userSession.getUnit_uid());
			modelActSort.setModelID(modelData.getId());
			modelActSort.setActSortID(actSortID);
			modelActSortMapper.insertOneModelActSortInfo(modelActSort);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			//导导入zip文件失败!
			return false;
		}
	}
	/**
	 * 获取导出文件名
	 * @param modelId
	 * @return
	 */
	public String exportbpmnZipName(String modelId) {
		String filename="";
		try {
			Model modelData = repositoryService.getModel(modelId);
			BpmnJsonConverter jsonConverter = new BpmnJsonConverter();
			JsonNode editorNode = new ObjectMapper().readTree(repositoryService.getModelEditorSource(modelData.getId()));
			BpmnModel bpmnModel = jsonConverter.convertToBpmnModel(editorNode);
			filename= bpmnModel.getMainProcess().getId() + ".zip";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filename;
	}
	/**
	 * 导出zip
	 * @param modelId
	 * @param request
	 * @param response
	 * @return
	 */
	public String exportbpmnZip(String modelId, HttpServletRequest request, HttpServletResponse response) {
		//获取root路径 设置上传文件目录 
		String rootPath=request.getSession().getServletContext().getRealPath("/");
		String directory = rootPath+"\\unitdata\\unit_"+SystemSession.getUserSession().getUnit_uid()+"\\activiti\\export";
		try {
			Model modelData = repositoryService.getModel(modelId);
			BpmnJsonConverter jsonConverter = new BpmnJsonConverter();
			JsonNode editorNode = new ObjectMapper().readTree(repositoryService.getModelEditorSource(modelData.getId()));
			BpmnModel bpmnModel = jsonConverter.convertToBpmnModel(editorNode);
			BpmnXMLConverter xmlConverter = new BpmnXMLConverter();
			byte[] bpmnBytes = xmlConverter.convertToXML(bpmnModel);
			File fileDirectory = new File(directory+"\\"+bpmnModel.getMainProcess().getName());
			File file = new File(directory+"\\"+bpmnModel.getMainProcess().getName(),bpmnModel.getMainProcess().getId() + ".bpmn20.xml");//附件文件夹
			//判断文件夹是否存在
			if(!fileDirectory.getParentFile().exists()){fileDirectory.getParentFile().mkdirs();}
			if(!fileDirectory.exists()) {fileDirectory.mkdirs();}
			if(!file.exists()) {file.createNewFile();}
			try (FileOutputStream fop = new FileOutputStream(file)) {
				fop.write(bpmnBytes);
				fop.flush();
				fop.close();
			} catch (IOException e) {e.printStackTrace();}
			byte[] pngIS=repositoryService.getModelEditorSourceExtra(modelData.getId());
			try (FileOutputStream  fos = new FileOutputStream(directory+"\\"+bpmnModel.getMainProcess().getName()+"\\"+bpmnModel.getMainProcess().getId() + ".png")) {
				fos.write(pngIS);
				fos.flush();
				fos.close();
			} catch (IOException e) {e.printStackTrace();}
			Boolean b=ZipCompressing.zip(directory+"\\"+bpmnModel.getMainProcess().getName()+"\\"+bpmnModel.getMainProcess().getId() + ".zip",
					new File(directory+"\\"+bpmnModel.getMainProcess().getName()+"\\"+bpmnModel.getMainProcess().getId() + ".bpmn20.xml"),
					new File(directory+"\\"+bpmnModel.getMainProcess().getName()+"\\"+bpmnModel.getMainProcess().getId() + ".png")); //测试压缩目录
			if(b){
				return directory+"\\"+bpmnModel.getMainProcess().getName()+"\\"+bpmnModel.getMainProcess().getId() + ".zip";
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			//导出model的xml文件失败！
		}
		return null;
	}
	/**
	 * 流程设计 删除model、部署的流程定义、已发起的流程
	 * @return
	 */
	public Boolean delectProcessDefinitionModel(String requestParamsObj,User userSession) {
		try {
			JSONObject requestParams=JSON.parseObject(requestParamsObj);
			List<Act_re_model_deployment> modelDeploymentList=modelDeploymentMapper.selectModelDeploymentList("  and unit_uid=\'"+userSession.getUnit_uid()+"\' and modelID=\'"+(String)requestParams.get("modelId")+"\' ");
			for (Act_re_model_deployment model_deployment : modelDeploymentList) {
				if(model_deployment.getDeploymentID()!=null){
				/*
				 * 能级联的删除
				 * 能删除启动的流程，会删除和当前规则相关的所有信息，正在执行的信息，也包括历史信息
				 */
				processEngine.getRepositoryService().deleteDeployment(model_deployment.getDeploymentID(), true);
				Act_re_model_deployment modelDeployment=new Act_re_model_deployment();
				modelDeployment.setUnit_uid(userSession.getUnit_uid());
				modelDeployment.setModelID((String)requestParams.get("modelId"));
				modelDeployment.setDeploymentID(model_deployment.getDeploymentID());;
				modelDeploymentMapper.delectOneModelDeploymentInfo(modelDeployment);
				}
			}
			
			Act_re_model_actSort modelActSort=new Act_re_model_actSort();
			modelActSort.setUnit_uid(userSession.getUnit_uid());
			modelActSort.setModelID((String)requestParams.get("modelId"));
			modelActSortMapper.delectOneModelActSortInfo(modelActSort);
			repositoryService.deleteModel((String)requestParams.get("modelId"));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 流程设计 流程已发布分页列表
	 * @return
	 */
	public PageTable selectProcessDefinitionDeployPageTable(PageTable pageTable) {
		try {
			//流程定义、部署
			List<ProcessDefinition> list=null;
			if ( null != pageTable.getSearchText()) {
				list=repositoryService.createProcessDefinitionQuery().processDefinitionNameLike("%"+pageTable.getSearchText().trim()+"%").orderByProcessDefinitionName().desc().listPage(pageTable.getPageNumber().intValue(), pageTable.getPageSize().intValue());//分页查询
			}else{
				list=repositoryService.createProcessDefinitionQuery().orderByProcessDefinitionName().desc().listPage(pageTable.getPageNumber().intValue(), pageTable.getPageSize().intValue());//分页查询
			}
			Long count=repositoryService.createProcessDefinitionQuery().count();//分页查询
			pageTable.setTotal(count);
			List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
			Map<String, Object> map = new HashMap<String, Object>();
			// 遍历集合，查看内容
			for (ProcessDefinition pd : list) {
				map = new HashMap<String, Object>();
				map.put("id", pd.getId());
				map.put("category", pd.getCategory());
				map.put("name", pd.getName());
				map.put("key", pd.getKey());
				map.put("description", pd.getDescription());
				map.put("version", pd.getVersion());
				map.put("resourceName", pd.getResourceName());
				map.put("deploymentId", pd.getDeploymentId());
				map.put("diagramResourceName", pd.getDiagramResourceName());
				map.put("hasStartFormKey", pd.hasStartFormKey());
				map.put("hasGraphicalNotation", pd.hasGraphicalNotation());
				map.put("isSuspended", pd.isSuspended());
				map.put("tenantId", pd.getTenantId());
				mapList.add(map);
			}
			pageTable.setRows(mapList);
			return pageTable;
		} catch (Exception e) {
			e.printStackTrace();
			return pageTable;
		}
	}
	
	/**
	 * 流程设计 流程已发布List列表
	 * @return
	 */
	public List<Map<String, Object>> selectProcessDefinitionDeployList() {
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		try {
			//流程定义、部署
			List<ProcessDefinition> list=null;
				list=repositoryService.createProcessDefinitionQuery().orderByProcessDefinitionName().desc().list();
			Long count=repositoryService.createProcessDefinitionQuery().count();//分页查询
			
			Map<String, Object> map = new HashMap<String, Object>();
			// 遍历集合，查看内容
			for (ProcessDefinition pd : list) {
				map = new HashMap<String, Object>();
				map.put("id", pd.getId());
				map.put("category", pd.getCategory());
				map.put("name", pd.getName());
				map.put("key", pd.getKey());
				map.put("description", pd.getDescription());
				map.put("version", pd.getVersion());
				map.put("resourceName", pd.getResourceName());
				map.put("deploymentId", pd.getDeploymentId());
				map.put("diagramResourceName", pd.getDiagramResourceName());
				map.put("hasStartFormKey", pd.hasStartFormKey());
				map.put("hasGraphicalNotation", pd.hasGraphicalNotation());
				map.put("isSuspended", pd.isSuspended());
				map.put("tenantId", pd.getTenantId());
				mapList.add(map);
			}
			return mapList;
		} catch (Exception e) {
			e.printStackTrace();
			return mapList;
		}
	}
	/**
	 * 流程设计 启动流程
	 * @return
	 */
	public Boolean createProcessDefinitionStart(String modelKey,String entityID,String entityName,String entityType,User userSession) {
		
		try {
			//设置流程启动人员
			processEngine.getIdentityService().setAuthenticatedUserId(userSession.getUser_uid());
			//启动流程
			ProcessInstance processInstance = processEngine.getRuntimeService()  
					.startProcessInstanceByKey(modelKey);  
			//根据流程id获取当前任务list
			List<Task> tasks = processEngine.getTaskService().createTaskQuery().processInstanceId(processInstance.getProcessInstanceId()).list();
			for (Task task : tasks) {//设置流程第一步办理人为流程启动者
				processEngine.getTaskService().setAssignee(task.getId(), userSession.getUser_uid());
			}
			//插入流程与项目对应表
			com.zjm.gbpm.db.model.Act_ProcessInstance pi=new com.zjm.gbpm.db.model.Act_ProcessInstance();
			pi.setInstanceEntity_ID(Tool.createUUID32());
			pi.setEntityID(entityID);
			pi.setEntityName(entityName);
			pi.setEntityType(entityType);
			pi.setProcessInstanceID(processInstance.getId());
			pi.setUpdateUserName(userSession.getUser_name());
			pi.setUnit_uid(userSession.getUnit_uid());
			try {
				processInstanceMapper.insertOneProInstanceEntityInfo(pi);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
