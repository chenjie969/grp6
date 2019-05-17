package com.zjm.crm.db.model;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传对象
 * @author mashuo 1144689809@qq.com 2017-04-28
 */
public class UploadParam implements Serializable {

	public String getTaskID() {
		return taskID;
	}
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}
	private String name; // 文件名称
	private String uuid;//文件uuid
	
	private int chunk=-1; // 当前第几块(从0开始计数)
	private int chunks=-1; // 上传附件总块数
    private HttpServletRequest request;//HttpServletRequest对象，不会自动赋值，需要手动传入
    private MultipartFile multipartFile;//保存文件上传信息，不会自动赋值，需要手动传入

	private String fileOneType;//附件一级分类
	private String fileTwoType;//附件二级分类
	private String clientID;//客户ID
	private String checkPlan_ID;//检查ID
	private String pageFilesID;//资料清单ID
	private String projectID;//项目编号projectID
	private String flowID;// 流程id
	private String stepID;// 步骤id
	private Long historyStepID;//历史步骤表自增id
	
	private String wheresql;
	
	private String fileID;//附件id
	private String filePath;//附件路径
	
	private Boolean isFile;//是否文档附件;
	private String clientFileType;//客户附件类型;
	
	/******************文档模版  chenyang  add  start***********************************/
	private String docMouldID;   //文档模板ID
	private String mouldTypeID;//文档模板类型
	private String mouldTypeName;//文档模板类型名称
	private String mouldName;//文档名称
	private String oldMouldName;  //模板原文件名称
	private String mouldPath;  //文档物理路径与文件名
	/******************文档模版  chenyang  add  end***********************************/

	/******************文档模版  zhudahai  add  start***********************************/
	private String entityID;

	/******************文档模版  zhudahai  add  end***********************************/
	
	private String fileFlag; //附件来源标记
	private String taskID; //附件来源标记
	
	//mashuo add 20171011 osworkflow工作流流程参数  begin
	private Long osFlowID; // 流程实例编号flowid
	private Integer osStepID;//步骤ID
	private Long osHistoryID;//历史步骤表自增id
	//mashuo add 20171011 osworkflow工作流流程参数  end
	private String applyDetail_ID;
	private String contractCode;
	private String contractTypeID;
	private String contractTypeName;
	private String contractName;
	private String contractBeginDate;
	private String contractEndDate;
	private String remark;
	private String contractPath;
	private String apply_ID;
	private String contractDoc_ID;
	//==================get/set================================
	private  String materialDetail_ID;//客户资料清单明细id
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getChunk() {
		return chunk;
	}
	public void setChunk(int chunk) {
		this.chunk = chunk;
	}
	public int getChunks() {
		return chunks;
	}
	public void setChunks(int chunks) {
		this.chunks = chunks;
	}
	public String getFileOneType() {
		return fileOneType;
	}
	public void setFileOneType(String fileOneType) {
		this.fileOneType = fileOneType;
	}
	public String getFileTwoType() {
		return fileTwoType;
	}
	public void setFileTwoType(String fileTwoType) {
		this.fileTwoType = fileTwoType;
	}
	
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public String getPageFilesID() {
		return pageFilesID;
	}
	public void setPageFilesID(String pageFilesID) {
		this.pageFilesID = pageFilesID;
	}
	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public String getFlowID() {
		return flowID;
	}
	public void setFlowID(String flowID) {
		this.flowID = flowID;
	}
	public String getStepID() {
		return stepID;
	}
	public void setStepID(String stepID) {
		this.stepID = stepID;
	}
	public Long getHistoryStepID() {
		return historyStepID;
	}
	public void setHistoryStepID(Long historyStepID) {
		this.historyStepID = historyStepID;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	public String getWheresql() {
		return wheresql;
	}
	public void setWheresql(String wheresql) {
		this.wheresql = wheresql;
	}
	public String getFileID() {
		return fileID;
	}
	public void setFileID(String fileID) {
		this.fileID = fileID;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Boolean getIsFile() {
		return isFile;
	}
	public void setIsFile(Boolean isFile) {
		this.isFile = isFile;
	}
	public String getClientFileType() {
		return clientFileType;
	}
	public void setClientFileType(String clientFileType) {
		this.clientFileType = clientFileType;
	}
	public String getDocMouldID() {
		return docMouldID;
	}
	public void setDocMouldID(String docMouldID) {
		this.docMouldID = docMouldID;
	}
	public String getMouldTypeID() {
		return mouldTypeID;
	}
	public void setMouldTypeID(String mouldTypeID) {
		this.mouldTypeID = mouldTypeID;
	}
	public String getMouldTypeName() {
		return mouldTypeName;
	}
	public void setMouldTypeName(String mouldTypeName) {
		this.mouldTypeName = mouldTypeName;
	}
	public String getMouldName() {
		return mouldName;
	}
	public void setMouldName(String mouldName) {
		this.mouldName = mouldName;
	}
	public String getOldMouldName() {
		return oldMouldName;
	}
	public void setOldMouldName(String oldMouldName) {
		this.oldMouldName = oldMouldName;
	}
	public String getMouldPath() {
		return mouldPath;
	}
	public void setMouldPath(String mouldPath) {
		this.mouldPath = mouldPath;
	}

	public String getEntityID() {
		return entityID;
	}

	public void setEntityID(String entityID) {
		this.entityID = entityID;
	}
	public String getFileFlag() {
		return fileFlag;
	}
	public void setFileFlag(String fileFlag) {
		this.fileFlag = fileFlag;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getCheckPlan_ID() {
		return checkPlan_ID;
	}
	public void setCheckPlan_ID(String checkPlan_ID) {
		this.checkPlan_ID = checkPlan_ID;
	}
	public Long getOsFlowID() {
		return osFlowID;
	}
	public void setOsFlowID(Long osFlowID) {
		this.osFlowID = osFlowID;
	}
	public Integer getOsStepID() {
		return osStepID;
	}
	public void setOsStepID(Integer osStepID) {
		this.osStepID = osStepID;
	}
	public Long getOsHistoryID() {
		return osHistoryID;
	}
	public void setOsHistoryID(Long osHistoryID) {
		this.osHistoryID = osHistoryID;
	}
	public String getMaterialDetail_ID() {
		return materialDetail_ID;
	}
	public void setMaterialDetail_ID(String materialDetail_ID) {
		this.materialDetail_ID = materialDetail_ID;
	}
	public String getApplyDetail_ID() {
		return applyDetail_ID;
	}
	public void setApplyDetail_ID(String applyDetail_ID) {
		this.applyDetail_ID = applyDetail_ID;
	}
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public String getContractTypeID() {
		return contractTypeID;
	}
	public void setContractTypeID(String contractTypeID) {
		this.contractTypeID = contractTypeID;
	}
	public String getContractTypeName() {
		return contractTypeName;
	}
	public void setContractTypeName(String contractTypeName) {
		this.contractTypeName = contractTypeName;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getContractBeginDate() {
		return contractBeginDate;
	}
	public void setContractBeginDate(String contractBeginDate) {
		this.contractBeginDate = contractBeginDate;
	}
	public String getContractEndDate() {
		return contractEndDate;
	}
	public void setContractEndDate(String contractEndDate) {
		this.contractEndDate = contractEndDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getContractPath() {
		return contractPath;
	}
	public void setContractPath(String contractPath) {
		this.contractPath = contractPath;
	}
	public String getApply_ID() {
		return apply_ID;
	}
	public void setApply_ID(String apply_ID) {
		this.apply_ID = apply_ID;
	}
	public String getContractDoc_ID() {
		return contractDoc_ID;
	}
	public void setContractDoc_ID(String contractDoc_ID) {
		this.contractDoc_ID = contractDoc_ID;
	}

	
	
}
