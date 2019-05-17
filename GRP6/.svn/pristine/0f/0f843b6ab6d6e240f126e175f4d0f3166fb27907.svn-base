package com.zjm.sys.domPreview.web;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.util.CustomDispatchServlet;

@Controller
@RequestMapping(value="/sys/documentPreview")
public class DomPreviewAction {
	private static final long serialVersionUID = 1L;

	private static final int BUFFER_SIZE = 2 * 1024;
	
	/**
	 * 添加项目组信息页面
	 * @param sys_usergroup
	 * @return
	 */
	@RequestMapping(value="/selectDocumentViewPage")
	public ModelAndView selectDocumentViewPage(String  domhref,String  domextend){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/documentPreview/documentView");
		mv.getModel().put("domhref", domhref);
		mv.getModel().put("domextend", domextend);
		return mv;
	}
	/**
	 * 添加项目组信息页面
	 * @param sys_usergroup
	 * @return
	 */
	@RequestMapping(value="/selectDocumentEditPage")
	public ModelAndView selectDocumentEditPage(String  domhref,String  domextend){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/documentPreview/documentEdit");
		mv.getModel().put("domhref", domhref);
		mv.getModel().put("domextend", domextend);
		return mv;
	}


	/**
	 * 保存编辑文件
	 * @return
	 */
	@RequestMapping(value="/saveFile", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public void saveFile(HttpServletRequest request,HttpServletResponse rps, String domhref){
		String rootPath=request.getSession().getServletContext().getRealPath("/");
		String msg = "";
		//截取文件名称
		String fileName = splitFileName(domhref);
		//生成文件保存路径
		String savePath = createSavePath(rootPath,domhref);
		//创建文件上传文件夹
		File savePathFolder = new File(savePath,fileName);
		if(!savePathFolder.getParentFile().exists()){
			savePathFolder.getParentFile().mkdirs();
		}
		//保存修改的文件
		if(delFile(new File(savePath+fileName))){
			MultipartHttpServletRequest multipartHttpServletRequest  = (MultipartHttpServletRequest)request;
			//调试发现map中只有一个键值对
			MultiValueMap<String,MultipartFile> map = multipartHttpServletRequest.getMultiFileMap();
			if(map!=null){
				try{
					Iterator<String> iterator = map.keySet().iterator();
					while(iterator.hasNext()){
						String key = iterator.next();
						List<MultipartFile> multipartFileList = map.get(key);
						for(MultipartFile multipartFile:multipartFileList){//循环只进行一次
							multipartFile.transferTo(savePathFolder);
						}
					}
					msg = String.valueOf(true);
				}
				catch (IOException e){
					e.printStackTrace();
					msg = String.valueOf(false);
				}
			}else{
				System.out.println("map is null !!!!");
			}
		}else{
			msg = String.valueOf(false);
		}
		try {
			rps.getWriter().print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	/**
	 * 截取文件名称
	 * @param domhref
	 * @return
	 */
	private String splitFileName(String domhref){
		String fileName = "";
		if(!domhref.equalsIgnoreCase("")){
			String[] href = domhref.split("/");
			Integer splitCount = href.length;
			fileName = 
					(splitCount != 0) ? 
							(href[splitCount-1]) :  
								(String.valueOf(System.currentTimeMillis()))+(href[splitCount-1]).split(".")[1];
		}
		return fileName;
	}

	/**
	 * 生成文件保存路径
	 * @param domhref
	 * @return
	 */
	private String createSavePath(String rootPath,String domhref){
		String rootDirectory = "unitdata";//如果上传的根目录有所修改,只修改此处
		String savePath = "";
		String[] splitPath =  domhref.replace("/", "\\").split(rootDirectory);
		Integer splitCount = splitPath.length;
		savePath = (splitCount != 0) ? (splitPath[splitCount-1]) : "";
		savePath = (!savePath.equals("")) ? (savePath.replace(splitFileName(domhref), "")) : savePath;
		return rootPath +rootDirectory+ savePath;
	}


	/**
	 * 删除文件
	 * @param delFile
	 * @return
	 */
	private Boolean delFile(File delFile){
		if (delFile.isFile() && delFile.exists()) {  
			return delFile.delete();  
		}else{
			return false;
		}
	}

	/**
	 * 返回文件类型
	 * @param file
	 * @return
	 */
	private String getFileType(String fileName){
		String path = fileName;
		if ((path != null) && (path.length() > 0)) {   
			int dot = path.lastIndexOf('.');   
			if ((dot >-1) && (dot < (path.length() - 1))) { 
				return path.substring(dot + 1).toLowerCase();   
			}   
		}   
		return path.toLowerCase();   
	}

}
