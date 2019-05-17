package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @description	项目附件表Pro_projectfiles
 * @author wuhn
 * @date 2017年8月1日 10:53:41
 */
public class Pro_projectfiles implements Serializable{
	private static final long serialVersionUID = 1L;
	private String projectFiles_ID;    //附件ID   projectFiles_ID
    private String flowID;    //流程实例ID   flowID   产品 id productInstanceID
    private String stepID;    //流程步骤ID   stepID   流程节点id   nodeID
    private String taskID;    //任务事项id   taskID
    /**
     * 附件类型   fileType 文档类型    <br>
     *  01:评委表决附件; <br>
     * 	02:合同制作附件;<br>
     *  04:意见任务附件; <br>
     *  03:项目附件  支持图片 文档 等; <br>
     *  07:自动生成的担保意向函;<br>
     *  08:展期文件;<br>
     *  09:完结解保附件 支持图片 文档等;<br>
     *  11:续保续贷附件类型 支持图片 文档等;
     *  
     *  续保续贷流程
     *  002:拟推荐上会项目清单
     *  003:经理办公会评议项目情况简表
     *  004:党政联席会
     *  005:管理类档案目录
     *  006:总办会议纪要
     *  007:会议纪要
     *  020:项目评议委员会评审通过项目情况简表
     *  
     *  101：催告函  
     */
    private String fileType;    
    private String entityID;    //实体ID   entityID   apply_ID  checkPlan_ID
    private String sourceFileName;    //附件原文件名称   sourceFileName
    private String pathFile;    //存储路径与文件名   pathFile
    private String extend;    //文件扩展名   extend
    private String uploadManID;    //上传人ID   uploadManID
    private String uploadManName;    //上传人名称   uploadManName
    private Date uploadDateTime;    //上传时间   uploadDateTime   生成时间
    private String fileSize;    //附件大小   fileSize
    private String unit_uid;    //担保机构ID   unit_uid
    private String updateUserName;    //最后修改人姓名   updateUserName   经办人
    private Date updateDateTime;    //最后修改时间   updateDateTime
    
    private String mouldPath;//冗余字段
  
    
    
    public String getMouldPath() {
		return mouldPath;
	}

	public void setMouldPath(String mouldPath) {
		this.mouldPath = mouldPath;
	}

	public String getProjectFiles_ID() {
        return projectFiles_ID;
    }

    public void setProjectFiles_ID(String projectFiles_ID) {
        this.projectFiles_ID = projectFiles_ID;
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

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getEntityID() {
        return entityID;
    }

    public void setEntityID(String entityID) {
        this.entityID = entityID;
    }

    public String getSourceFileName() {
        return sourceFileName;
    }

    public void setSourceFileName(String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getUploadManID() {
        return uploadManID;
    }

    public void setUploadManID(String uploadManID) {
        this.uploadManID = uploadManID;
    }

    public String getUploadManName() {
        return uploadManName;
    }

    public void setUploadManName(String uploadManName) {
        this.uploadManName = uploadManName;
    }

    public Date getUploadDateTime() {
        return uploadDateTime;
    }

    public void setUploadDateTime(Date uploadDateTime) {
        this.uploadDateTime = uploadDateTime;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getUnit_uid() {
        return unit_uid;
    }

    public void setUnit_uid(String unit_uid) {
        this.unit_uid = unit_uid;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

	public String getTaskID() {
		return taskID;
	}

	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}


    
    
}