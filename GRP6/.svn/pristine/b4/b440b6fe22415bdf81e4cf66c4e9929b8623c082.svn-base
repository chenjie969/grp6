<style>
	table{
	font-size:13px;
	border:1px solid #ddd;
	}
	table tr th{
	border:1px solid #ddd;
	text-align: center;
	};

</style>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>

<link rel="stylesheet" href="<%=path %>/plugins/viewer/viewer.min.css?v=<%=vardate%>" /> 
<link rel="stylesheet" href="<%=path %>/plugins/webuploader/css/webuploader.css?v=<%=vardate%>" />
<link rel="stylesheet" href="<%=path %>/assets/css/iconfont.css?v=<%=vardate%>" />



 
<link rel="stylesheet" href="<%=path %>/plugins/viewer/viewer.min.css?v=<%=vardate%>" />
<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>

<div class="page-content" style="padding-bottom:100px;">
	<div class="page-header" >
		<h4 style="text-align: center;">${suggest.taskName}</h4>
	</div>
      <div class="row">
		<div class="col-xs-12">
			     <!-- 产品实例id -->
                 <input type="hidden" id="productInstanceID" name="productInstanceID" class="" value="${suggest.productInstanceID}">
                  <!-- 正在运行节点id -->
                  <input type="hidden" id="nodeID" class="" name="" value="${suggest.nodeID}">
                  <!--   产品实例任务ID -->
                 <input type="hidden" id="taskID" class="" name="" value="${suggest.taskID}">
                  <!--产品实例任务名称 -->
                 <input type="hidden" id="taskName" class="" name="" value="${suggest.taskName}">
                   <!-- 业务类型-->
                 <input type="hidden" id="entityType" class="" name=""  value="${suggest.entityType}">
                   <!-- 业务ID-->
                 <input type="hidden" id="entityID" class="" name="" value="${suggest.entityID}">
                 
                 <input type="hidden" id="suggest_ID" class="" name="" value="${suggest.suggest_ID}">
                
                 <input type="hidden" id="type" class="" name="" value="${suggest.type}">
                 <input type="hidden" id="nodeNames" class="" name="" value="${suggest.nodeNames}">
                 <input type="hidden" id="suggestType" value="${suggest.suggestType}"/>
			
				  <div class="col-sm-12"  id="ulPictureFile2">
						<h5 style="line-height: 26px;"class="">
							<b>标题：</b><span class="grey">${riskScheme.title}</span>
						</h5>
						<h5>
							<b>${riskScheme.reviewType}：</b>
						</h5>
							<c:forEach items="${riskScheme.schemeFileList}" var="filesInfo" varStatus="status">
							<p>
							<c:if test="${filesInfo.extend eq 'jpg' ||(filesInfo.extend eq 'jpeg')||(filesInfo.extend eq 'png') ||(filesInfo.extend eq 'gif') }">
								 <a href="#" class="btn_riskfile_viewer_img" data-original="${filesInfo.pathFile}" src="${filesInfo.pathFile}">
		                	</c:if>		
		                			${filesInfo.sourceFileName}
		                   <c:if test="${filesInfo.extend eq 'jpg'}">			
		                	       </a>
							 </c:if>
		                	<c:if test="${filesInfo.extend=='docx' || filesInfo.extend=='doc' || filesInfo.extend=='pdf' || filesInfo.extend=='xlsx' || filesInfo.extend=='xls' || filesInfo.extend=='ppt' || filesInfo.extend=='pptx' || filesInfo.extend=='txt'}">
		                           	&nbsp;&nbsp;
				          	<a class="" href="#" onclick="javascript:window.parent.open('/sys/documentPreview/selectDocumentViewPage?domhref=${filesInfo.pathFile}&domextend=${filesInfo.extend}')"><i class="icon-zoom-in bigger-120 orange"></i></a>
							<%-- <button class="btn btn-xs btn-info" onclick="javascript:window.parent.open('/sys/documentPreview/selectDocumentEditPage?domhref=${filesInfo.pathFile}&domextend=${filesInfo.extend}')"><i class="icon-pencil bigger-120"></i></button> --%>
							&nbsp;&nbsp;
							<a class="" href="#" onclick="javascript:window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${filesInfo.sourceFileName}&filePath=${filesInfo.pathFile}')"><i class="icon-download-alt bigger-120 "></i></a>
					          	
				          	</c:if>
					          	<c:if test="${filesInfo.extend=='jpeg' || filesInfo.extend=='png' || filesInfo.extend=='gif' || filesInfo.extend=='jpg'}">
											&nbsp;&nbsp;
											 <a href="#" class="btn_riskfile_viewer_img" data-original="${filesInfo.pathFile}" src="${filesInfo.pathFile}"><i class="icon-zoom-in bigger-120 orange"></i></a>
											    <img class="hide" data-original="${filesInfo.pathFile}" src="${filesInfo.pathFile}" alt="${filesInfo.sourceFileName}" title="${filesInfo.sourceFileName}">
											&nbsp;&nbsp;
											<a href="#" onclick="javascript:window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${filesInfo.sourceFileName}&filePath=${filesInfo.pathFile}')">
													<i class="icon-download-alt bigger-120 "></i>
											</a>
					          	</c:if>
				          	</p>
				          	</c:forEach>
						<c:if test="${fn:length(riskScheme.schemeFileList)==0}">（空）</c:if>
						
						<hr/>
						<h5>
							<b>附件：</b>
						</h5>
							<c:forEach items="${riskScheme.attachFileList}" var="filesInfo" varStatus="status">
							<p>
							<c:if test="${filesInfo.extend eq 'jpg' ||(filesInfo.extend eq 'jpeg')||(filesInfo.extend eq 'png') ||(filesInfo.extend eq 'gif') }">
								 <a href="#" class="btn_riskfile_viewer_img" data-original="${filesInfo.pathFile}" src="${filesInfo.pathFile}">
		                	</c:if>		
		                			${filesInfo.sourceFileName}
		                   <c:if test="${filesInfo.extend eq 'jpg'}">			
		                	       </a>
							 </c:if>
		                	<c:if test="${filesInfo.extend=='docx' || filesInfo.extend=='doc' || filesInfo.extend=='pdf' || filesInfo.extend=='xlsx' || filesInfo.extend=='xls' || filesInfo.extend=='ppt' || filesInfo.extend=='pptx' || filesInfo.extend=='txt'}">
		                           	&nbsp;&nbsp;
				          	<a class="" href="#" onclick="javascript:window.parent.open('/sys/documentPreview/selectDocumentViewPage?domhref=${filesInfo.pathFile}&domextend=${filesInfo.extend}')"><i class="icon-zoom-in bigger-120 orange"></i></a>
							<%-- <button class="btn btn-xs btn-info" onclick="javascript:window.parent.open('/sys/documentPreview/selectDocumentEditPage?domhref=${filesInfo.pathFile}&domextend=${filesInfo.extend}')"><i class="icon-pencil bigger-120"></i></button> --%>
							&nbsp;&nbsp;
							<a class="" href="#" onclick="javascript:window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${filesInfo.sourceFileName}&filePath=${filesInfo.pathFile}')"><i class="icon-download-alt bigger-120 "></i></a>
					          	
				          	</c:if>
				          	<c:if test="${filesInfo.extend=='jpeg' || filesInfo.extend=='png' || filesInfo.extend=='gif' || filesInfo.extend=='jpg'}">
										&nbsp;&nbsp;
										 <a href="#" class="btn_riskfile_viewer_img" data-original="${filesInfo.pathFile}" src="${filesInfo.pathFile}"><i class="icon-zoom-in bigger-120 orange"></i></a>
										    <img class="hide" data-original="${filesInfo.pathFile}" src="${filesInfo.pathFile}" alt="${filesInfo.sourceFileName}" title="${filesInfo.sourceFileName}">
										&nbsp;&nbsp;
										<a href="#" onclick="javascript:window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${filesInfo.sourceFileName}&filePath=${filesInfo.pathFile}')">
												<i class="icon-download-alt bigger-120 "></i>
										</a>
				          	</c:if>
				          	</p>
				          	</c:forEach>
				          	<c:if test="${fn:length(riskScheme.attachFileList)==0}">（空）</c:if>
				 </div>
				<div class="space-16 col-sm-12"></div>
				<h4 class="header smaller lighter blue">
					意见汇总
			    </h4>
			    
				<div class="col-sm-12"  id="ulPictureFile">
				 <c:forEach items="${projectSuggestList}" var="suggestList" varStatus="listCount">	
				 <div class="space-8 "></div>
				     <div class="widget-box suggest_parent">  <!-- suggest_parent 为了防止不同意见节点下面的图片同时显示所添加的class-->
						<div class="widget-header">
							<h4 class="smaller">
								[${suggestList.nodeNames}]&nbsp;&nbsp;${suggestList.taskName}
								 <c:if test="${suggestList.suggestUserName ne null}">
									（${suggestList.suggestUserName}）
							     </c:if>
								<small style="text-align:right">
								      <fmt:formatDate value="${suggestList.suggestDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>  
								</small>
							</h4>
						</div>
	
						<div class="widget-body"  >
							<div class="widget-main" >
								<h5>
									意见内容：
									<span class="grey">
									<c:if test="${suggestList.suggestContent eq null}">
											  		（空）
									 </c:if>
											${suggestList.suggestContent}
									</span>
							 
								</h5> 
								<hr/>
								<h5>
									<b>附件：</b>
								</h5>
								
									<c:forEach items="${suggestList.filesList}" var="filesInfo" varStatus="status">
									<p>
									<c:if test="${filesInfo.extend eq 'jpg' ||(filesInfo.extend eq 'jpeg')||(filesInfo.extend eq 'png') ||(filesInfo.extend eq 'gif') }">
										 <a href="#" class="btn_opfile_viewer_img" data-original="${filesInfo.pathFile}" src="${filesInfo.pathFile}">
				                	</c:if>		
				                			${filesInfo.sourceFileName}
				                   <c:if test="${filesInfo.extend eq 'jpg'}">			
				                	       </a>
									 </c:if>
											
				                	
				                	
				                	<c:if test="${filesInfo.extend=='docx' || filesInfo.extend=='doc' || filesInfo.extend=='pdf' || filesInfo.extend=='xlsx' || filesInfo.extend=='xls' || filesInfo.extend=='ppt' || filesInfo.extend=='pptx' || filesInfo.extend=='txt'}">
				                           	&nbsp;&nbsp;
						          	<a class="" href="#" onclick="javascript:window.parent.open('/sys/documentPreview/selectDocumentViewPage?domhref=${filesInfo.pathFile}&domextend=${filesInfo.extend}')"><i class="icon-zoom-in bigger-120 orange"></i></a>
									<%-- <button class="btn btn-xs btn-info" onclick="javascript:window.parent.open('/sys/documentPreview/selectDocumentEditPage?domhref=${filesInfo.pathFile}&domextend=${filesInfo.extend}')"><i class="icon-pencil bigger-120"></i></button> --%>
									&nbsp;&nbsp;
									<a class="" href="#" onclick="javascript:window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${filesInfo.sourceFileName}&filePath=${filesInfo.pathFile}')"><i class="icon-download-alt bigger-120 "></i></a>
							          	
						          	</c:if>
						          	<c:if test="${filesInfo.extend=='jpeg' || filesInfo.extend=='png' || filesInfo.extend=='gif' || filesInfo.extend=='jpg'}">
												&nbsp;&nbsp;
												 <a href="#" class="btn_opfile_viewer_img" data-original="${filesInfo.pathFile}" src="${filesInfo.pathFile}"><i class="icon-zoom-in bigger-120 orange"></i></a>
												    <img class="hide" data-original="${filesInfo.pathFile}" src="${filesInfo.pathFile}" alt="${filesInfo.sourceFileName}" title="${filesInfo.sourceFileName}">
												&nbsp;&nbsp;
												<a href="#" onclick="javascript:window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${filesInfo.sourceFileName}&filePath=${filesInfo.pathFile}')">
														<i class="icon-download-alt bigger-120 "></i>
												</a>
						          	</c:if>
						          	</p>
						          	</c:forEach>
						          	<c:if test="${fn:length(suggestList.filesList)==0}">（空）</c:if>
								
							</div>
						</div>
					</div>
							
					</c:forEach>
				</div>
					
   		 </div>			
	</div>
	<div id="btn_projectSuggestEdit" class="btn_projectSuggestEdit" value="${suggest.suggest_ID}"  style="width:65px;height:71px;border-radius:50%;z-index:100;position:fixed;bottom:100px;right:150px;box-shadow:0 0 10px 5px rgba(255,173,42,0.4)">
		<i class="iconfont icon-yijian orange" style="font-size:500%;" title="录入意见"></i>
	</div>		    
</div><!-- /.page-content --><!--end页面内容  -->
		
<div id="projectSuggest_page" ></div>
<script src="<%=path %>/plugins/plupload/plupload.full.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/plupload/i18n/zh_CN.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/project/suggest/riskScheme/projectSuggest.js?v=<%=vardate%>"></script>

<script>     
 
	 $(function() {
		$(".btn_opfile_viewer").click(function() {
		 	var viewer = new Viewer(document.getElementById($(this).attr("data-id")), { 
			    url: 'data-original'
			});
			viewer.show();
			$(".viewer-close").click(function(){
				viewer.destroy();
			});
		});
		$(".btn_opfile_viewer_img").click(function() {
			var suggestParent = $(this).parents(".suggest_parent");
		 	var viewer = new Viewer( suggestParent[0], { 
			    url: 'data-original'
			});
			viewer.show();
			$(".viewer-close").click(function(){
				
				viewer.destroy();
				 window.location.reload();  
			});
		});
		$(".btn_riskfile_viewer_img").click(function() {
		 	var viewer = new Viewer(document.getElementById("ulPictureFile2"), { 
			    url: 'data-original'
			});
			viewer.show();
			$(".viewer-close").click(function(){
				
				viewer.destroy();
				 window.location.reload();  
			});
		});
	}); 
</script>
<%-- <script src="<%=path %>/plugins/webuploader/js/webuploader.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/crm/filesUpload/fileupv2.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>
 --%>

<%-- <%@ include file="/project/suggest/projectSuggest/projectSuggestEdit.jsp" %> --%>
<%-- <script src="<%=path %>/plugins/webuploader/js/webuploader.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/crm/filesUpload/fileupv2.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>


<script type="text/javascript">
$(function () {
	var defParam = {
			"uploadFileList" : "thelist",//待上传的附件列表div ID
			//"uploadConsoleList" : "uploadConsoleList",//错误信息提示div ID
			"btn_PickID" : "picker",//选择附件按钮ID
			"btn_UploadID" : "ctlBtn",//上传按钮ID
			"uploadURL" : "/crm/filesUpload/insertOneFilesUpload",//上传的地址 
			"uploadParam" : {
				"fileOneType":"projFiles",//附件表分类
				"fileTwoType":"04",//附件上传入口分类
				"clientID":"",//客户id
				"projectID":"",//项目id
				"fileFlag":"04",
				"entityID":$("#taskID").val(),
				"uuid":""//文件uuid
			},//上传附加参数
			"fileList" : "fileList",//已上传的附件列表Table ID
			"fileListURL" : "/crm/filesUpload/selectAllProjectFileList",//加载附件列表数据地址
			"mimeTypes":[
				{title : "文件", extensions : "*",mimeTypes: '*'}
				]//限定上传附件类型
	};
	//刷新附件列表
	$.zjm_upload.initTable(defParam);
	$.zjm_upload.initUpload(defParam);
});
</script> --%>