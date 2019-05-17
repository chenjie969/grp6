package com.zjm.crm.filesUpload.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import com.zjm.oa.common.service.OaFileService;
import com.zjm.oa.db.model.Oa_files;
import com.zjm.pro.contractdoc.service.ContractdocService;
import com.zjm.pro.db.model.Pro_contractdoc;
import com.zjm.pro.db.model.Pro_projectfiles;
import com.zjm.pro.projectfiles.service.ProjectfilesService;

import org.apache.taglibs.standard.tag.common.fmt.ParseDateSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.druid.util.StringUtils;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.clientfiles.service.ClientFilesService;
import com.zjm.crm.db.model.Crm_clientfiles;
import com.zjm.crm.db.model.UploadParam;
import com.zjm.crm.filesUpload.service.FilesUploadService;
import com.zjm.gworkFlow.db.model.Os_gworkflow_files;
import com.zjm.gworkFlow.flowBuild.service.OsGworkflowFilesService;
import com.zjm.sys.db.model.Sys_docMould;
import com.zjm.sys.docMould.service.DocMouldService;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

@Service("filesUploadService")
@Transactional
public class FilesUploadServiceImpl implements FilesUploadService {
    private static final int BUFFER_SIZE = 2 * 1024;

    //根目录
    private final String rootDirectory = "unitdata";
    //机构目录前缀
    private final String unitDirectoryPrefix = "unit_";
    //附件目录
    private final String clientFilesDirectory = "clientFiles";
    //项目附件目录
    private final String projFilesDirectory = "projFiles";
    //报表附件目录
    private final String reportFilesDirectory = "reportFiles";
    //合同模板目录
    private final String docMouldDirectory = "docMould";
    //oa目录
    private final String oaFilesDirectory = "oaFiles";
    //os目录
    private final String osFilesDirectory = "osFiles";
    //上传文件类型
    private final String[] uploadingType = {"clientFiles", "projFiles", "reportFiles", "docMould", "oaFiles","osFiles"};
    //上传附件入口类型
	@Resource
	   private  ContractdocService  contractdocService;
    //客户附件保存
    @Resource
    private ClientFilesService clientFilesService;
    //合同模版保存
    @Resource
    private DocMouldService docMouldService;
    @Resource
    private OaFileService oaFileService;

    @Resource
    private ProjectfilesService  projectfilesService; //项目附件保存
    @Resource
	private OsGworkflowFilesService osGworkflowFilesService;//osworkflow意见附件表
    /**
     * 保存附件
     *
     * @param uploadType 上传类型
     * @param clientID   客户id
     * @param src        上传文件
     * @param fileType   文件类型
     * @param newName    系统生成的name
     * @param oldName    文件本身name
     * @return
     */
    public Boolean saveFile(User user, UploadParam uploadParam, String rootPath) {
        String uploadType = uploadParam.getFileOneType();
        if (uploadType != null && !uploadType.equals("")) {
            if (uploadType.equals(uploadingType[0])) {
                return saveFiles(user, uploadParam, rootPath);
            } else if (uploadType.equals(uploadingType[1])) { //projFiles  项目附件
                return saveFiles(user, uploadParam, rootPath);
            } else if (uploadType.equals(uploadingType[2])) {
                return saveFiles(user, uploadParam, rootPath);
            } else if (uploadType.equals(uploadingType[3])) {
                return saveDocMoulds(user, uploadParam, rootPath);
            } else if (uploadType.equals(uploadingType[4])) {
                return saveOaFiles(user, uploadParam, rootPath);
            } else if (uploadType.equals(uploadingType[5])) {
                return saveOsWorkFlowFiles(user, uploadParam, rootPath);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 保存附件
     *
     * @param uploadParam
     * @param rootPath
     * @return
     */
    private Boolean saveFiles(User user, UploadParam uploadParam, String rootPath) {
    	String newName="";
    	if(uploadParam.getUuid()!=null && !uploadParam.getUuid().equals("")){
            newName = uploadParam.getUuid();
    	}else {
    		newName = Tool.createUUID();
    	}
        File path = initUploadDirectory(user, uploadParam.getFileOneType(), newName + "." + getFileType(uploadParam.getName()), rootPath);
        if (path != null) {
            Boolean uploadResult = upload(uploadParam, path.getPath());//
            if (uploadResult) {
            	String fileFlag = uploadParam.getFileFlag();//附件来源标记
            	if(fileFlag != null && !"".equals(fileFlag) || "optFlag".equals(fileFlag) || "projFiles".equals(fileFlag)){ // 担保措施管理附件
            		Pro_projectfiles	files = setValue(uploadParam,user,path);
            		return  projectfilesService.insertOneProFilesInfo(user, files);
            	}else{
	                Crm_clientfiles files = new Crm_clientfiles();
	                files.setClientFiles_ID(Tool.createUUID32());
	                files.setFileType(uploadParam.getFileTwoType());
	                files.setUnit_uid(user.getUnit_uid());
	                files.setClient_ID(uploadParam.getClientID());
	                files.setSourceFileName(uploadParam.getName());
	                files.setPathFile(getRelativePath(path));
	                files.setExtend(getFileType(uploadParam.getName()));
	                files.setUploadManID(user.getUser_uid());
	                files.setUploadManName(user.getUser_name());
	                files.setFileSize(fileSize(new File(path.getPath())));
	                files.setUpdateUserName(user.getUser_name());
	                files.setIsFile(uploadParam.getIsFile());
	                files.setClientFileType(uploadParam.getClientFileType());
	                files.setMaterialDetail_ID(uploadParam.getMaterialDetail_ID());
	                if (clientFilesService.insertOneClientFiles(files)) {
	                    return true;
	                } else {
	                    return false;
	                }
            	}  
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    /**
     * @description	  给项目附件表赋值
     * @author wuhn
     * @date 2017年8月1日 上午11:28:47
     */
    private Pro_projectfiles setValue(UploadParam uploadParam,User user,File path ) {
    	 Pro_projectfiles files=new Pro_projectfiles ();
    	 files.setProjectFiles_ID(Tool.createUUID32());
         files.setFileType(uploadParam.getFileTwoType());
         files.setUnit_uid(user.getUnit_uid());
         files.setEntityID(uploadParam.getEntityID());
         files.setSourceFileName(uploadParam.getName());
         files.setPathFile(getRelativePath(path));
         files.setExtend(getFileType(uploadParam.getName()));
         files.setUploadManID(user.getUser_uid());
         files.setUploadManName(user.getUser_name());
         files.setFileSize(fileSize(new File(path.getPath())));
         files.setUpdateUserName(user.getUser_name());
         files.setFlowID(uploadParam.getFlowID());
         files.setStepID(uploadParam.getStepID());
         files.setTaskID(uploadParam.getTaskID());
         
         return files;
	}

	/**
     * 保存合同模板
     *
     * @param uploadParam
     * @param rootPath
     * @return
     */
    private Boolean saveDocMoulds(User user, UploadParam uploadParam, String rootPath) {
    	String newName="";
    	if(uploadParam.getUuid()!=null && !uploadParam.getUuid().equals("")){
            newName = uploadParam.getUuid();
    	}else {
    		newName = Tool.createUUID();
    	}
        File path = initUploadDirectory(user, uploadParam.getFileOneType(), newName + "." + getFileType(uploadParam.getName()), rootPath);
        if (path != null) {
            Boolean uploadResult = upload(uploadParam, path.getPath());//
            String fileFlag = uploadParam.getFileFlag();
            
            if(fileFlag != null && fileFlag.equals("contract")){
                Sys_docMould docMould = new Sys_docMould();
                docMould.setDocMouldID(Tool.createUUID32());
                docMould.setUnit_uid(user.getUnit_uid());
                docMould.setOldMouldName(uploadParam.getName());
                docMould.setMouldPath(getRelativePath(path));
                docMould.setFileSize(fileSize(new File(path.getPath())));
                docMould.setExtend(getFileType(uploadParam.getName()));
                docMould.setUploadManID(user.getUser_uid());
                docMould.setUploadManName(user.getUser_name());
                docMould.setUpdateUserName(user.getUser_name());
                docMouldService.insertOneDocMould(user, docMould);
            	Pro_contractdoc con= new Pro_contractdoc();
            	con.setContractDoc_ID(Tool.createUUID32());
            	con.setApply_ID(uploadParam.getApply_ID());
            	con.setApplyDetail_ID("2eceb1d4a01b44179109d40eac924490");
            	con.setContractCode(uploadParam.getContractCode());
            	con.setContractName(uploadParam.getContractName());
            	con.setContractTypeID(uploadParam.getContractTypeID());
            	con.setContractTypeName(uploadParam.getContractTypeName());            	
            	con.setContractEndDate(parseDate1(uploadParam.getContractEndDate()));
            	con.setContractBeginDate(parseDate(uploadParam.getContractBeginDate()));
            	/*con.setContractPath(uploadParam.getName());*/
               	con.setContractPath(getRelativePath(path));
            	con.setRemark(uploadParam.getRemark());
            	con.setFilename(uploadParam.getName());
            	/*con.setMouldPath(getRelativePath(path));*/
            	con.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
            	return contractdocService.insertOneContractInfo(con, user);
            }else  if(fileFlag != null && fileFlag.equals("contractupdate")){
            	Pro_contractdoc con=new Pro_contractdoc();
            	con.setApply_ID(uploadParam.getApply_ID());
            	con.setContractDoc_ID(uploadParam.getContractDoc_ID());
            	con.setApplyDetail_ID("2eceb1d4a01b44179109d40eac924490");
            	con.setContractCode(uploadParam.getContractCode());
            	con.setContractName(uploadParam.getContractName());
            	con.setContractTypeName(uploadParam.getContractTypeName());
            	con.setContractEndDate(parseDate1(uploadParam.getContractEndDate()));
            	con.setContractBeginDate(parseDate(uploadParam.getContractBeginDate()));
            	/*con.setContractPath(uploadParam.getName());*/
            	con.setContractPath(getRelativePath(path));
            	con.setContractTypeID(uploadParam.getContractTypeID());
            	con.setRemark(uploadParam.getRemark());
            	con.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
            	con.setFilename(uploadParam.getName());
          /*  	con.setMouldPath(getRelativePath(path));*/
/*            	con= contractdocService.selectOneContractdocInfo(con);
*/            	return contractdocService.updateOneContractInfo(con);            	
            }else{
            	if (uploadResult) {
                    Sys_docMould docMould = new Sys_docMould();
                    docMould.setDocMouldID(Tool.createUUID32());
                    docMould.setMouldTypeID(uploadParam.getMouldTypeID());
                    docMould.setUnit_uid(user.getUnit_uid());
                    docMould.setMouldName(uploadParam.getMouldName());
                    docMould.setMouldTypeID(uploadParam.getMouldTypeID());
                    docMould.setMouldTypeName(uploadParam.getMouldTypeName());
                    docMould.setOldMouldName(uploadParam.getName());
                    docMould.setMouldPath(getRelativePath(path));
                    docMould.setFileSize(fileSize(new File(path.getPath())));
                    docMould.setExtend(getFileType(uploadParam.getName()));
                    docMould.setUploadManID(user.getUser_uid());
                    docMould.setUploadManName(user.getUser_name());
                    docMould.setUpdateUserName(user.getUser_name());
                    if (docMouldService.insertOneDocMould(user, docMould)) {
                        return true;
                    } else {
                        return false;
                    }
	            } else {
	                return false;
	            }
            }
        } else {
            return false;
        }
    }
    
    private Date parseDate(String contractBeginDate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (contractBeginDate == null || contractBeginDate.equals("")) {
				Date date = new Date();
				return date;
			} else {
				Date date = simpleDateFormat.parse(contractBeginDate);
				return date;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
    private Date parseDate1(String contractEndDate) {
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	try {
    		if (contractEndDate == null || contractEndDate.equals("")) {
				Date date = new Date();
				return date;
			} else {
    		Date date=simpleDateFormat.parse(contractEndDate);
			return date;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return null;
	}

    
    private Boolean saveOaFiles(User user, UploadParam uploadParam, String rootPath) {
    	String newName="";
    	if(uploadParam.getUuid()!=null && !uploadParam.getUuid().equals("")){
            newName = uploadParam.getUuid();
    	}else {
    		newName = Tool.createUUID();
    	}
        File path = initUploadDirectory(user, uploadParam.getFileOneType(), newName + "." + getFileType(uploadParam.getName()), rootPath);
        if (path != null) {
            Boolean uploadResult = upload(uploadParam, path.getPath());//
            String fileFlag = uploadParam.getFileFlag();
            if(fileFlag != null && fileFlag.equals("contract")){
            	Pro_contractdoc con= new Pro_contractdoc();
            	
            	return contractdocService.insertOneContractInfo(con, user);
            }else{
            	if (uploadResult) {
                    Oa_files files = new Oa_files();
                    files.setFiles_ID(Tool.createUUID32());
                    files.setFileType(uploadParam.getFileTwoType());
                    files.setUnit_uid(user.getUnit_uid());
                    files.setUnit_uidName(user.getUnit_uidName());
                    files.setSourceFileName(uploadParam.getName());
                    files.setPathFile(getRelativePath(path));
                    files.setExtend(getFileType(uploadParam.getName()));
                    files.setUploadManID(user.getUser_uid());
                    files.setUploadManName(user.getUser_name());
                    files.setFileSize(fileSize(new File(path.getPath())));
                    files.setUpdateUserName(user.getUser_name());
                    files.setEntityID(uploadParam.getEntityID());
                    if (oaFileService.insert(files)) {
                        return true;
                    } else {
                        return false;
                    }
            	} else {
            		return false;
            	}
            }
        } else {
            return false;
        }
    }

    /**
     * osworkflow意见附件
     * @param user
     * @param uploadParam
     * @param rootPath
     * @return
     */
    private Boolean saveOsWorkFlowFiles(User user, UploadParam uploadParam, String rootPath) {
    	System.out.println(">>>>>os>>>>");
    	String newName="";
    	if(uploadParam.getUuid()!=null && !uploadParam.getUuid().equals("")){
            newName = uploadParam.getUuid();
    	}else {
    		newName = Tool.createUUID();
    	}
        File path = initUploadDirectory(user, uploadParam.getFileOneType(), newName + "." + getFileType(uploadParam.getName()), rootPath);
        if (path != null) {
            Boolean uploadResult = upload(uploadParam, path.getPath());//
            if (uploadResult) {
            	Os_gworkflow_files files = new Os_gworkflow_files();
                files.setFiles_ID(Tool.createUUID32());
                files.setFileType(uploadParam.getFileTwoType());
                files.setUnit_uid(user.getUnit_uid());
                files.setUnit_uidName(user.getUnit_uidName());
                files.setSourceFileName(uploadParam.getName());
                files.setPathFile(getRelativePath(path));
                files.setExtend(getFileType(uploadParam.getName()));
                files.setUploadManID(user.getUser_uid());
                files.setUploadManName(user.getUser_name());
                files.setFileSize(fileSize(new File(path.getPath())));
                files.setUpdateUserName(user.getUser_name());
                files.setProjectID(uploadParam.getProjectID());
                files.setFlowID(uploadParam.getOsFlowID());
                files.setStepID(uploadParam.getOsStepID());
                files.setHistoryID(uploadParam.getOsHistoryID());
                if (osGworkflowFilesService.insertOneOsGworkflowFiles(files)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    /**
     * 初始化根目录
     *
     * @param rootPath2
     * @return
     */
    private String initRootDirectory(String rootPath) {

        //		String rootPath = ServletActionContext.getServletContext().getRealPath("/"+rootDirectory);
        rootPath = rootPath + File.separator + rootDirectory;
        //创建根目录
        File rootPathFolder = new File(rootPath);
        // 如果根目录没有就创建一个根目录
        if (!rootPathFolder.exists()) {
            rootPathFolder.mkdirs();
        }
        return rootPath;
    }

    /**
     * 初始化 上传 目录
     *
     * @param fileOneType
     * @param rootPath
     * @return
     */
    private File initUploadDirectory(User user, String fileOneType, String newName, String rootPath) {
        String clientFiles = uploadingType[0];//图片
        String projFiles = uploadingType[1];//客户附件
        String reportFiles = uploadingType[2];//项目附件
        String docMoulds = uploadingType[3];//合同模板
        String oaFiles = uploadingType[4];//oa
        String osFiles = uploadingType[5];//oa
        //担保机构附件目录的名字
        String unitDirectory = unitDirectoryPrefix + user.getUnit_uid();//userSession.getUnit_uid();
        //如果上传类型是 客户附件
        if (fileOneType.equals(clientFiles)) {
            String fileAccessory = initRootDirectory(rootPath) + File.separator + unitDirectory + File.separator + clientFilesDirectory;
            File fileAccessoryFolder = new File(fileAccessory, newName);//附件文件夹
            if (!fileAccessoryFolder.getParentFile().exists()) {//判断 此担保机构的附件目录是否存在此项目的附件目录,如果不存在 创建目录
                fileAccessoryFolder.getParentFile().mkdirs();
            }
            return fileAccessoryFolder;
        }
        //如果上传类型是 项目附件
        if (fileOneType.equals(projFiles)) {
            String fileAccessory = initRootDirectory(rootPath) + File.separator + unitDirectory + File.separator + projFilesDirectory;
            File fileAccessoryFolder = new File(fileAccessory, newName);//附件文件夹
            if (!fileAccessoryFolder.getParentFile().exists()) {//判断 此担保机构的附件目录是否存在此项目的附件目录,如果不存在 创建目录
                fileAccessoryFolder.getParentFile().mkdirs();
            }
            return fileAccessoryFolder;
        }
        //如果上传类型是 报表附件
        if (fileOneType.equals(reportFiles)) {
            String fileAccessory = initRootDirectory(rootPath) + File.separator + unitDirectory + File.separator + reportFilesDirectory;
            File fileAccessoryFolder = new File(fileAccessory, newName);//附件文件夹
            if (!fileAccessoryFolder.getParentFile().exists()) {//判断 此担保机构的附件目录是否存在此项目的附件目录,如果不存在 创建目录
                fileAccessoryFolder.getParentFile().mkdirs();
            }
            return fileAccessoryFolder;
        }
        //如果上传类型是 合同模板
        if (fileOneType.equals(docMoulds)) {
            String fileAccessory = initRootDirectory(rootPath) + File.separator + unitDirectory + File.separator + docMouldDirectory;
            File fileAccessoryFolder = new File(fileAccessory, newName);//附件文件夹
            if (!fileAccessoryFolder.getParentFile().exists()) {//判断 此担保机构的附件目录是否存在此项目的附件目录,如果不存在 创建目录
                fileAccessoryFolder.getParentFile().mkdirs();
            }
            return fileAccessoryFolder;
        }
        if (fileOneType.equals(oaFiles)) {
            String fileAccessory = initRootDirectory(rootPath) + File.separator + unitDirectory + File.separator + oaFilesDirectory;
            File fileAccessoryFolder = new File(fileAccessory, newName);//附件文件夹
            if (!fileAccessoryFolder.getParentFile().exists()) {//判断 此担保机构的附件目录是否存在此项目的附件目录,如果不存在 创建目录
                fileAccessoryFolder.getParentFile().mkdirs();
            }
            return fileAccessoryFolder;
        }
        if (fileOneType.equals(osFiles)) {
            String fileAccessory = initRootDirectory(rootPath) + File.separator + unitDirectory + File.separator + osFilesDirectory;
            File fileAccessoryFolder = new File(fileAccessory, newName);//附件文件夹
            if (!fileAccessoryFolder.getParentFile().exists()) {//判断 此担保机构的附件目录是否存在此项目的附件目录,如果不存在 创建目录
                fileAccessoryFolder.getParentFile().mkdirs();
            }
            return fileAccessoryFolder;
        }
        return null;
    }

    /**
     * 获取上传文件
     *
     * @param uploadParam
     * @param pluploadDir
     * @return
     */
    private Boolean upload(UploadParam uploadParam, String pluploadDir) {
        int chunks = uploadParam.getChunks();//用户上传文件被分隔的总块数
        int nowChunk = uploadParam.getChunk();//当前块，从0开始
        //这里Request请求类型的强制转换可能出错，配置文件中向SpringIOC容器引入multipartResolver对象即可。
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) uploadParam.getRequest();
        //调试发现map中只有一个键值对
        MultiValueMap<String, MultipartFile> map = multipartHttpServletRequest.getMultiFileMap();
        if (map != null) {
            try {
                Iterator<String> iterator = map.keySet().iterator();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    List<MultipartFile> multipartFileList = map.get(key);
                    for (MultipartFile multipartFile : multipartFileList) {//循环只进行一次
                        uploadParam.setMultipartFile(multipartFile);//手动向Plupload对象传入MultipartFile属性值
                        File targetFile = new File(pluploadDir);//新建目标文件，只有被流写入时才会真正存在
                        if (chunks > 1) {//用户上传资料总块数大于1，要进行合并
                            File tempFile = new File(pluploadDir);
                            //第一块直接从头写入，不用从末端写入
                            savePluploadFile(multipartFile.getInputStream(), tempFile, nowChunk == 0 ? false : true);
                            if (chunks - nowChunk == 1) {//全部块已经上传完毕，此时targetFile因为有被流写入而存在，要改文件名字
                                tempFile.renameTo(targetFile);
                                return true;
                            }
                        } else {
                            //只有一块，就直接拷贝文件内容
                            multipartFile.transferTo(targetFile);
                            return true;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 保存文件
     *
     * @param inputStream
     * @param tempFile
     * @param flag
     */
    private void savePluploadFile(InputStream inputStream, File tempFile, boolean flag) {
        OutputStream outputStream = null;
        try {
            if (flag == false) {
                //从头写入
                outputStream = new BufferedOutputStream(new FileOutputStream(tempFile));
            } else {
                //从末端写入
                outputStream = new BufferedOutputStream(new FileOutputStream(tempFile, true));
            }
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = (inputStream.read(bytes))) > 0) {
                outputStream.write(bytes, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 计算文件大小
     *
     * @param file
     * @return
     */
    private String fileSize(File file) {
        Long fileSize = file.length();
        return "" + fileSize;
    }

    /**
     * 获取相对路径
     *
     * @param path
     * @return
     */
    private String getRelativePath(File path) {
        String split = "/unitdata";
        String b = split + path.getPath().replace("\\", "/");
        String[] c = b.split(split);
        return split + c[2];
    }

    /**
     * 返回文件类型
     *
     * @param file
     * @return
     */
    private String getFileType(String fileName) {
        String path = fileName;
        if ((path != null) && (path.length() > 0)) {
            int dot = path.lastIndexOf('.');
            if ((dot > -1) && (dot < (path.length() - 1))) {
                return path.substring(dot + 1).toLowerCase();
            }
        }
        return path.toLowerCase();
    }

    /**
     * 附件List
     */
    public PageTable selectAllFilesList(PageTable pageTable) {
        return clientFilesService.selectAllClientFilesPageTables(pageTable);
    }

    /**
     * 合同List
     */
    public PageTable selectAllDocMouldList(PageTable pageTable) {
        return docMouldService.selectAllDocMouldList(pageTable);
    }

    /**
     * 删除一个附件信息
     *
     * @param uploadParam
     * @param rootPath
     * @return
     */
    public Boolean delectOneFilesInfo(User user, UploadParam uploadParam, String rootPath) {
        String uploadType = uploadParam.getFileOneType();
        if (uploadType != null && !uploadType.equals("")) {
            if (uploadType.equals(uploadingType[0])) {
                return delectOneClientFilesInfo(user, uploadParam, rootPath);
            } else if (uploadType.equals(uploadingType[3])) {
                return delectOneDocMouldInfo(user, uploadParam, rootPath);
            } else if(uploadType.equals(uploadingType[4])){		
                return delectOneOaFileInfo(user,uploadParam,rootPath);
			}else if(uploadType.equals(uploadingType[5])){
				return delectOneOsGworkflowFilesInfo(user,uploadParam,rootPath);
			}else if(uploadType.equals(uploadingType[1])){
				return delectOneProjectFileInfo(user,uploadParam,rootPath);
			}else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 删除一个客户附件信息
     *
     * @param uploadParam
     * @param rootPath
     * @return
     */
    private Boolean delectOneClientFilesInfo(User user, UploadParam uploadParam, String rootPath) {
        Crm_clientfiles files = new Crm_clientfiles();
        files.setClientFiles_ID(uploadParam.getFileID());
        files.setUnit_uid(user.getUnit_uid());
        files.setClient_ID(uploadParam.getClientID());
        if (clientFilesService.delectOneClientFilesInfo(files)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除一个合同模板信息
     *
     * @param uploadParam
     * @param rootPath
     * @return
     */
    private Boolean delectOneDocMouldInfo(User user, UploadParam uploadParam, String rootPath) {
        Sys_docMould docMould = new Sys_docMould();
        docMould.setDocMouldID(uploadParam.getFileID());
        docMould.setUnit_uid(user.getUnit_uid());
        if (docMouldService.delectOneDocMouldInfo(user, docMould)) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 删除一个oa文件信息
     */
    private Boolean delectOneOaFileInfo(User user, UploadParam uploadParam, String rootPath) {
       Boolean dbDel = oaFileService.delete(uploadParam.getFileID());
       Boolean phyDel = delFile(uploadParam,rootPath);
       return dbDel&&phyDel;
    }
    /**
     * 删除一个project项目文件信息
     */
    private Boolean delectOneProjectFileInfo(User user, UploadParam uploadParam, String rootPath) {
       Boolean dbDel = projectfilesService.deleteOneInfoByProFiles_ID(user, uploadParam.getFileID());
       Boolean phyDel = delFile(uploadParam,rootPath);
       return dbDel&&phyDel;
    }

    /**
     * 删除物理文件
     */
    private Boolean delFile(UploadParam uploadParam, String rootPath) {
        Boolean delResult = false;
        File file = new File(rootPath + uploadParam.getFilePath());
        if (file.isFile() && file.exists()) {//路径为文件且不为空则进行删除
            delResult = file.delete();
        }
        return delResult;
    }

    @Override
    public List<Crm_clientfiles> selectPictureFilesList(String whereSql) {
        List<Crm_clientfiles> pictureFileList = clientFilesService.selectPictureFileList(whereSql);
        return pictureFileList;
    }

	@Override
	public PageTable selectAllProjectSuggestList(PageTable pageTable) {
		return projectfilesService.selectProjectFilesPageTables(pageTable);
	}

	/**
	 * osworkflow意见附件分页列表
	 */
	public PageTable selectAllOsGworkflowFilesPageTables(PageTable pageTable) {
		return osGworkflowFilesService.selectAllOsGworkflowFilesPageTables(pageTable);
	}

	
	 /**
     * 删除一个osworkflow意见附件信息
     *
     * @param uploadParam
     * @param rootPath
     * @return
     */
    private Boolean delectOneOsGworkflowFilesInfo(User user, UploadParam uploadParam, String rootPath) {
    	Os_gworkflow_files files = new Os_gworkflow_files();
        files.setFiles_ID(uploadParam.getFileID());
        files.setUnit_uid(user.getUnit_uid());
        files.setProjectID(uploadParam.getProjectID());
        /*files.setFlowID(uploadParam.getOsFlowID());
        files.setStepID(uploadParam.getOsStepID());
        files.setHistoryID(uploadParam.getOsHistoryID());*/
        if (osGworkflowFilesService.delectOneOsGworkflowFilesInfo(files)) {
            return true;
        } else {
            return false;
        }
    }

	@Override
	public Boolean updateOneFilesInfo(User user, UploadParam uploadParam, String rootPath) {
		String newName = "";
		if (uploadParam.getUuid() != null && !uploadParam.getUuid().equals("")) {
			newName = uploadParam.getUuid();
		} else {
			newName = Tool.createUUID();
		}
		File path = initUploadDirectory(user, uploadParam.getFileOneType(),
				newName + "." + getFileType(uploadParam.getName()), rootPath);
		if (path != null) {
			Boolean uploadResult = upload(uploadParam, path.getPath());//
			String fileFlag = uploadParam.getFileFlag();

			if (fileFlag != null && fileFlag.equals("contractupdate")) {
				Pro_contractdoc con = new Pro_contractdoc();
				con.setApply_ID(uploadParam.getApply_ID());
				con.setContractDoc_ID(uploadParam.getContractDoc_ID());
				con.setApplyDetail_ID("2eceb1d4a01b44179109d40eac924490");
				con.setContractCode(uploadParam.getContractCode());
				con.setContractName(uploadParam.getContractName());
				con.setContractTypeName(uploadParam.getContractTypeName());
				con.setContractEndDate(parseDate1(uploadParam.getContractEndDate()));
				con.setContractBeginDate(parseDate(uploadParam.getContractBeginDate()));
				/* con.setContractPath(uploadParam.getName()); */
				con.setContractPath(getRelativePath(path));
				con.setContractTypeID(uploadParam.getContractTypeID());
				con.setRemark(uploadParam.getRemark());
				con.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
				con.setFilename(uploadParam.getName());
				/* con.setMouldPath(getRelativePath(path)); */
				/*
				 * con= contractdocService.selectOneContractdocInfo(con);
				 */ return contractdocService.updateOneContractInfo(con);
			} else {
				return false;
			}

		}
		return null;
	}
	/**
     * 保存合同模板
     *
     * @param uploadParam
     * @param rootPath
     * @return
     */
	@Override
	public Boolean saveNewDocMould(User user, UploadParam uploadParam, String rootPath) {
		String newName="";
    	if(uploadParam.getUuid()!=null && !uploadParam.getUuid().equals("")){
            newName = uploadParam.getUuid();
    	}else {
    		newName = Tool.createUUID();
    	}
        File path = initUploadDirectory(user, uploadParam.getFileOneType(), newName + "." + getFileType(uploadParam.getName()), rootPath);
        
        if (path != null) {
            Boolean uploadResult = upload(uploadParam, path.getPath());//
            if (uploadResult) {
            	try {
					String fileFlag = uploadParam.getFileFlag();//附件来源标记
					Pro_projectfiles	files = setValue(uploadParam,user,path);
					
					projectfilesService.insertOneProFilesInfo(user, files);
					Pro_contractdoc con= new Pro_contractdoc();
					
					String contractDoc_ID = uploadParam.getEntityID();
					String apply_ID = uploadParam.getApply_ID();
					
					con.setContractDoc_ID(contractDoc_ID);
					con.setApply_ID(apply_ID);
					con = contractdocService.selectOneContractdocInfo(con);
					
					con.setContractPath(files.getPathFile());
					con.setFilename(files.getSourceFileName());
					//更新合同附件信息
					return contractdocService.updateOneContractFilesInfo(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
            	return false;
            	
            } else {
                return false;
            }
        } else {
            return false;
        }
	}
	
	
}
