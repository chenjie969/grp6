<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<link rel="stylesheet" href="<%=path %>/plugins/viewer/viewer.min.css?v=<%=vardate%>" />
<input type="hidden" name="client_ID" id="client_ID" value="${client.client_ID}"  />
<div class="page-header"><!--begin页头部分 -->	
		    	<h5>   
		    		<c:if test="${client.clientTypeID eq  01}">
						  	 客户名称：
		    			<span class="">${client.clientName}</span>	
					</c:if>
		    		<c:if test="${client.clientTypeID ne  01}">
						  	 申请人：
		    			<span class="">${client.personName}</span>	
		    			&nbsp;
		    			<span class="">${client.clientName}</span>
					</c:if>		    						
					<span style="margin-left:2em;" class="grey">客户编号：
						<span class="ztb_view_clientBH">
						<c:if test="${client.clientBH eq null}">
						  	（空）
						 </c:if>
								${client.clientBH}
						</span>					
					</span>							
				</h5>
</div>
<div class="col-sm-12" style="margin-top:10px;" id="ulPictureFile">
		<c:forEach items="${fileTypeList}" var="fileType" varStatus="status">
		 	<div class="col-sm-12" style="margin-top:30px;" >
				<h5 align="right" class="col-sm-3" style="">${fileType.dicTypeName}：</h5>

					<ul class="col-sm-6" style="margin:0 !important;" >
						
						<c:forEach items="${pictureFilesList}" var="pictureFiles" varStatus="status">	
																			
							<c:if test="${pictureFiles.clientFileType == fileType.dicTypeID}">							 
							 	<li style="width:110px;float:left;">
								    <img class="ztb_image btn_opfile_viewer " data-original="${pictureFiles.pathFile}" src="${pictureFiles.pathFile}" alt="${pictureFiles.sourceFileName}" title="${pictureFiles.sourceFileName}">										
									<button align="right" class="delete_image" id="${pictureFiles.clientFiles_ID}" name="${pictureFiles.pathFile}" >	
										<i class="icon-trash bigger-110 red"></i>
									</button>
								</li>
							</c:if>
							
						</c:forEach>
					</ul>
				
				
				<div class="col-sm-3 activeUpload_Div" style=""><!--  onclick="activeUpload(this)"   -->
					<button class="btn  btn-sm activeUpload" type="button" name="activeUpload" id="${fileType.dicTypeID}">
						<i class="icon icon-upload-alt"></i>
						<span>上传图片</span>
					</button>
					<h6 class="grey line-height:16px;">格式要求：支持jpg，jpeg，bmp，gif，png格式照片，大小不超过1M。</h6>
				</div>
			</div>
		</c:forEach>
</div>
 
<script src="<%=path %>/plugins/plupload/plupload.full.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/plupload/i18n/zh_CN.js?v=<%=vardate%>"></script>
<script src="<%=path %>/crm/client/pictureFiles/pictureFile.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>
<script type="text/javascript">

$(function () {
	 /* var defParam = {
			"uploadFileList" : "uploadFileList",//待上传的附件列表div ID
			"uploadConsoleList" : "uploadConsoleList",//错误信息提示div ID
			"btn_PickID" : "pickfiles",//选择附件按钮ID
			"btn_UploadID" : "uploadfiles",//上传按钮ID
			"uploadURL" : "/crm/filesUpload/insertOneFilesUpload",//上传的地址 
			"uploadParam" : {
				"isFile":false,
				"clientFileType":"",
				"fileOneType":"clientFiles",//附件表分类
				"fileTwoType":"02",//附件上传入口分类
				"clientID":$("#client_ID").val(),//客户id
				"projectID":""//项目id
			},//上传附加参数
			"fileList" : "fileList",//已上传的附件列表Table ID
			"fileListURL" : "/crm/filesUpload/selectPictureFileList",//加载附件列表数据地址
			"mimeTypes":[{title : "图片", extensions : "image/jpg,image/gif,image/png,image/jpeg"}]//限定上传附件类型  
	}; 	 */
	//刷新图片列表
	//$.zjm_pictureFileIndex.initDate();		
	$("[name='activeUpload']").click(function(){
		var fileTypeID ="";//图片类型id;
		 fileTypeID = $(this).attr("id"); 
		var defParam = {
				"uploadFileList" : "uploadFileList",//待上传的附件列表div ID
				"uploadConsoleList" : "uploadConsoleList",//错误信息提示div ID
				"btn_PickID" : "pickfiles",//选择附件按钮ID
				"btn_UploadID" : "uploadfiles",//上传按钮ID
				"uploadURL" : "/crm/filesUpload/insertOneFilesUpload",//上传的地址 
				"uploadParam" : {
					"isFile":false,
					"clientFileType":fileTypeID,
					"fileOneType":"clientFiles",//附件表分类
					"fileTwoType":"02",//附件上传入口分类
					"clientID":$("#client_ID").val(),//客户id
					"projectID":""//项目id
				},//上传附加参数
				"fileList" : "fileList",//已上传的附件列表Table ID
				"fileListURL" : "/crm/filesUpload/selectPictureFileList",//加载附件列表数据地址
				"mimeTypes":[{title : "图片", extensions : "jpg,gif,png,jpeg"}]
					 /* //限定上传附件类型  */
		};
		$("#uploadfiles").modal({keyboard:true});		
		$.zjm_pictureFile.initUpload(defParam);
		$("#uploadfiles").on("hidden.bs.modal", function (e) {//解除事件绑定
			$.zjm_pictureFileIndex.initDate();
			uploader.destroy();  
			$("#pickfiles").unbind("click"); 
		}); 
	});
	//查看图片附件;
	$(".btn_opfile_viewer").click(function(){
		var viewer = new Viewer(document.getElementById("ulPictureFile"), {
		    url: 'data-original'
		});
		$(".viewer-close").click(function(){
			viewer.destroy();
		});
	});
	//删除图片附件;
	$(".delete_image").click(function(){
		var clientFiles_ID  = $(this).attr("id");
		var pathFile  = $(this).attr("name");	
		var  clientID = $("#client_ID").val();
		var  fileTwoType = "02";
		$.zjm_pictureFile.deleteOnePictureFile(clientFiles_ID,pathFile,clientID,fileTwoType);
		
	});
	
});

</script>