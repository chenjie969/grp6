package com.zjm.gbpm.processDefinition.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;

public interface ProcessDefinitionService {
	/**
	 * 流程设计 模型分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectProcessDefinitionPageTable(PageTable pageTable);
	/**
	 *新建模型 
	 * @return
	 */
	public Boolean createProcessDefinitionModel(String requestParamsObj, User userSession);
	/**
	 * 流程设计 部署
	 * @return
	 */
	public Boolean createProcessDefinitionDeploy(String requestParamsObj, User userSession);
	/**
	 * 流程设计 导入
	 * @return
	 */
	public Boolean selectProcessDefinitionImportAdd(String modelName, String description,String actSortID,User userSession, MultipartFile zipMFile,
			HttpServletRequest request, HttpServletResponse response);
	/**
	 * 获取导出文件名
	 * @param modelId
	 * @return
	 */
	public String exportbpmnZipName(String modelId);
	/**
	 * 导出zip
	 * @param modelId
	 * @param request
	 * @param response
	 * @return
	 */
	public String exportbpmnZip(String modelId, HttpServletRequest request, HttpServletResponse response);
	/**
	 * 流程设计 删除model、部署的流程定义、已发起的流程
	 * @return
	 */
	public Boolean delectProcessDefinitionModel(String requestParamsObj,User userSession);
	/**
	 * 流程设计 流程已发布分页列表
	 * @return
	 */
	public PageTable selectProcessDefinitionDeployPageTable(PageTable pageTable);
	/**
	 * 流程设计 流程已发布List列表
	 * @return
	 */
	public List<Map<String, Object>> selectProcessDefinitionDeployList();
	/**
	 * 流程设计 启动流程
	 * @param entityType 
	 * @param entityName 
	 * @param entityID 
	 * @return
	 */
	public Boolean createProcessDefinitionStart(String modelKey,String entityID, String entityName, String entityType, User userSession);

}
