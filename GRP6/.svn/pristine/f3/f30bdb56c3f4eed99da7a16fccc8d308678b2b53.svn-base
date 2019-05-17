package com.zjm.crm.filesUpload.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_clientfiles;
import com.zjm.crm.db.model.UploadParam;
import com.zjm.sys.db.model.Sys_docMould;

public interface FilesUploadService {
	/**
	 * 保存附件
	 * @param rootPath 
	 * 
	 * @param uploadType
	 *            上传类型
	 * @param clientID
	 *            客户id
	 * @param src
	 *            上传文件
	 * @param fileType
	 *            文件类型
	 * @param newName
	 *            系统生成的name
	 * @param oldName
	 *            文件本身name
	 * @return
	 */
	public Boolean saveFile(User user,UploadParam uploadParam, String rootPath);
	/**
	 * 附件List
	 */
	public PageTable selectAllFilesList(PageTable pageTable);
	
	/**
	 * 合同模板List
	 */
	public PageTable selectAllDocMouldList(PageTable pageTable);
	/**
	 * 删除一个附件信息
	 * @param uploadParam
	 * @param rootPath 
	 * @return
	 */
	public Boolean delectOneFilesInfo(User user,UploadParam uploadParam, String rootPath);
	
	
	/**
	 * 图片附件list
	 * 
	 */
	public List<Crm_clientfiles> selectPictureFilesList(String whereSql);
	public PageTable selectAllProjectSuggestList(PageTable pageTable);
	/**
	 * osworkflow意见附件分页列表
	 */
	public PageTable selectAllOsGworkflowFilesPageTables(PageTable pageTable);
	
	public Boolean updateOneFilesInfo(User user,UploadParam uploadParam, String rootPath);
	
	
	/**
	 * @param user
	 * @param uploadParam
	 * @param rootPath
	 * @return  合同制作
	 */
	public Boolean saveNewDocMould(User user, UploadParam uploadParam, String rootPath) ;
}
