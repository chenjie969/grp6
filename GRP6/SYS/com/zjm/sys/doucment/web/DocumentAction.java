package com.zjm.sys.doucment.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Client;
import com.zjm.pro.db.model.Pro_projectfiles;
import com.zjm.pro.optGuaranty.service.OptGuarantyService;
import com.zjm.pro.projectfiles.service.ProjectfilesService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;
import com.zjm.xdocreport.util.ContractUtil;

/**
 * @description   合同模板管理 /文档管理action
 * @company http://www.igit.com.cn/  
 * @author wuhn	
 * @date 2017年8月7日 下午2:33:50
*/
@Controller
@RequestMapping(value="/documentAction")
public class DocumentAction {
	
	@Resource
	private OptGuarantyService  optGuarantyService;
	
	@Resource
	private ProjectfilesService  projectfilesService;
	
	@RequestMapping(value="/initTable")
	public ModelAndView  initTable(){
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
		modeAndView.setViewName("/sys/dataBaseVindicate/documentList/optManagerList");
		return modeAndView;
	}
	
	
	/**
	 * @throws IOException 
	 * @description  合同模板列表
	 */
	@RequestMapping(value="/selectOptGuarantyPageTables",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes  selectOptGuarantyPageTables(@RequestBody PageTable<Map<String, Object>> pageTable,HttpServletRequest request) throws IOException{
		List<Map<String,Object>> list=new ArrayList<>();
		Map<String,Object> map= new HashMap<>();
		String choose = pageTable.getQueryCondition().getChoose();
	
		String realPath = request.getServletContext().getRealPath("/");
		File file =new File(realPath+"sys/dataBaseVindicate/documentList/doc.properties"); 

		if(!file.isFile()){
			System.out.println("路径下：文件不存在");
		}
		
		BufferedReader br=new BufferedReader(new FileReader(file));
		java.util.Properties  pro =new java.util.Properties();
		pro.load(br);
		if(br != null ){
			br.close();
		}
		System.out.println(pro);
		map.put("01", "项目调查报告A角");
		list.add(map);
		map= new HashMap<>();
		map.put("02", "项目风险评估报告书");
		list.add(map);
		map= new HashMap<>();
		map.put("03", "出具同意担保通书");
		list.add(map);
		map= new HashMap<>();

		AjaxRes ar =new AjaxRes();
		List<Map<String,Object>> disposeList = disposeList(list,choose);
		
		pageTable.setRows(disposeList);
		pageTable.setTotal(10L);
		ar.setSucceed(pageTable);
		return ar;
	}

	private List<Map<String,Object>> disposeList(List<Map<String, Object>> list, String ch) {
		List<Map<String, Object>> newList=new ArrayList<>();
		if(ch != null && ch.length() > 0){
			String[] choose = ch.split(",");
			Map<String,Map<String, Object>> mmap=new HashMap<>();
			for(int x =0;x<list.size();x++){
				Map<String, Object> map = list.get(x);
				for (String string : map.keySet()) {
					mmap.put(string, map);
				}
			}
			
			for (String str : choose) {
				Map<String, Object> map = mmap.get(str);
				if(!map.isEmpty()){
					newList.add(map);
				}
			}
		}else{
			return list;
		}	
		
		return newList;
	}


	/**
	 * @description	分页列表查询条件
	 * @author wuhn
	 * @date 2017年7月4日 上午10:26:27
	 */
	private String queryCondition(PageTable<Pro_projectfiles> pageTable) {
		StringBuffer sb= new StringBuffer();
		sb.append(" and unit_uid ='"+ SystemSession.getUserSession().getUnit_uid() +"'");// 添加机构id
		if(pageTable == null){
			return sb.toString();
		}
		
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			sb.append(" and sourceFileName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		
		// 实体id 、 项目申请id
		String entityID = pageTable.getQueryCondition().getEntityID();
		if(entityID != null && !"".equals(entityID)){
			sb.append(" and entityID = '"+entityID+"'");
		}
		
		String documentCode = pageTable.getQueryCondition().getDocumentCode();
		if(documentCode !=null && "shencha".equals(documentCode)){
			
		}else{
			
			
			// 流程实例id
			String flowID = pageTable.getQueryCondition().getFlowID();
			if(null != flowID && !"".equals(flowID)){
				sb.append(" and flowID='"+flowID+"'");
			}
			
			// 流程节点id
			String stepID = pageTable.getQueryCondition().getStepID();
			if(null != stepID && !"".equals(stepID)){
				sb.append(" and  stepID ='"+stepID+"'");
			}
			
			// 事项节点id
			String taskID = pageTable.getQueryCondition().getTaskID();
			if(null != taskID && !"".equals(taskID)){
				sb.append(" and  taskID ='"+taskID+"'");
			}
		}
		
		if(pageTable.getSortName()!=null && !pageTable.getSortName().equals("") && pageTable.getSortOrder()!=null && !pageTable.getSortOrder().equals("")){
			sb.append(" ORDER BY "+pageTable.getSortName().trim()+"  " +pageTable.getSortOrder()+"");
		}else{
			sb.append(" ORDER BY updateDateTime desc");
		}
		
		return sb.toString();
	}
	
	
	
	/**
	 * @description	 可选文档模板 -- 分页列表
	 * @author wuhn
	 * @throws UnsupportedEncodingException 
	 * @date 2017年8月8日 下午2:06:01
	 */
	@RequestMapping(value="/documentList")
	public ModelAndView  documentList(DocVo docVo) throws UnsupportedEncodingException{
		docVo.setTaskName(java.net.URLDecoder.decode(docVo.getTaskName(),"UTF-8"));
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
		modeAndView.getModel().put("docVo", docVo);
		modeAndView.setViewName("/sys/dataBaseVindicate/documentList/documentList2");
		return modeAndView;
	}
	
	
	/**
	 * @description	已生成文档 -- 分页列表
	 * @author wuhn
	 * @date 2017年8月8日 下午2:06:01
	 */
	@RequestMapping(value="/selectProjectFilesPageTables")
	@ResponseBody
	public AjaxRes documentTable(@RequestBody PageTable<Pro_projectfiles> pageTable){
		AjaxRes ar =new AjaxRes();
		String queryCondition = queryCondition(pageTable);
		pageTable.setWheresql(queryCondition);
		pageTable =	projectfilesService.selectProjectFilesPageTables(pageTable);
		pageTable.setWheresql("");
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * @description	根据文档模板生成文档
	 * @author wuhn
	 * @date 2017年8月9日 下午5:03:22
	 */
	@RequestMapping(value="/generateDocument")
	@ResponseBody
	public AjaxRes generateDocument(@RequestBody Pro_projectfiles  projectfiles,HttpServletRequest request){
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
	private Boolean createDocument(Pro_projectfiles projectfiles, HttpServletRequest request) {
		String realPath = request.getServletContext().getRealPath("/");
		String templatePath=realPath+ projectfiles.getPathFile(); //模板路径
		String tempPath=projectfiles.getPathFile();
		tempPath=tempPath.substring(0,tempPath.lastIndexOf("/")).replace("docMould", "projFiles");
		String destPath=realPath+tempPath; //目标存储路径
		File file = new File(destPath);
		if(!file.exists()){
			file.mkdirs();
		}
		String newDocName="/"+Tool.createUUID32()+".docx";
		projectfiles.setPathFile(tempPath+newDocName);
		destPath=destPath+newDocName;
	
		Map map = getMapData();
	
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
	 * @description	  获取生成文档数据
	 * @author wuhn
	 * @date 2017年8月10日 上午10:31:29
	 */
	private Map getMapData() {
		Map<String,Object> map =new HashMap<>();
		map.put("name", "中投保");
		map.put("age", 18);
		map.put("address", "北京市朝阳区建华南路17号现代柏联大厦");
		return map;
	}
	
	
	/**
	 * @description	  删除已生成的文档
	 * @author wuhn
	 * @date 2017年8月10日 上午10:32:36
	 */
	@RequestMapping(value="/deleteDocument")
	@ResponseBody
	public AjaxRes deleteDocument(@RequestBody Pro_projectfiles  projectfiles,HttpServletRequest request){
		AjaxRes  ar= new AjaxRes();
		deletePhysicalFile(projectfiles,request);
		
		Boolean info = projectfilesService.deleteOneInfoByProFiles_ID(
				SystemSession.getUserSession(), projectfiles.getProjectFiles_ID());
		ar.setSucceed(info);
		return ar;
	}

	/**
	 * @description	删除物理文件
	 * @author wuhn
	 * @date 2017年8月10日 上午10:35:36
	 */
	private void deletePhysicalFile(Pro_projectfiles projectfiles, HttpServletRequest request) {
		String realPath = request.getServletContext().getRealPath("/");
		String absolutePath=realPath+projectfiles.getPathFile() ;
		File file = new File(absolutePath);
		if(file.isFile()){
			file.delete();
		}else{
			System.out.println("路径："+ absolutePath +"文件不存在。");
		}
	}
	
	
	
}
