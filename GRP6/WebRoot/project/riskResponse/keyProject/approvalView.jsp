<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%-- <%@ include file="/common_head.jsp" %> --%>
<link rel="stylesheet" href="<%=path %>/plugins/viewer/viewer.min.css?v=<%=vardate%>" /> 
<link rel="stylesheet" href="<%=path %>/plugins/webuploader/css/webuploader.css?v=<%=vardate%>" />
<style type="text/css">
	.fixed-table-footer table{
		font-size:13px;
		font-weight:bold;
	}
	.fixed-table-footer table td{
		border:1px solid #ccc;
	}
</style>
<div class="page-content">   
      <div class="page-header">
			<h4>查看审批信息</h4>
		</div>
      <div class="row">
		<div class="col-xs-12">
		<form class="form-horizontal" role="form" id="approvalEdit_from">
			<input type="hidden" id="riskScheme_ID"  name="riskScheme_ID" value="${riskScheme.riskScheme_ID}">
			<div class="space-4"></div>
			<div class="form-group">
          		<label class="col-sm-2 control-label no-padding-right" for="form-field-1"> 标题： </label>
				<div class="col-md-8">
	            	<input type="text" id="title" name="title" value="${riskScheme.title}" readonly="readonly" class="col-md-5 col-sm-6" />
				</div>
          	</div>
			<div class="form-group">
				<label class="col-md-2 control-label no-padding-right" for="form-field-1">审批类型： </label>
				<div class="col-sm-8">
					<input type="text" id="reviewType" name="reviewType" readonly="readonly" value="${riskScheme.reviewType}" class="col-md-5 col-sm-6" />
				</div>
			</div>
			
			<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="form-field-1">${riskScheme.reviewType}：</label>
					<label class="col-sm-9" id="riskSchemeFile">
		                		
		                		 <c:forEach items="${riskScheme.schemeFileList}" var="filesInfo" varStatus="status">
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
						          	<c:if test="${fn:length(riskScheme.schemeFileList)==0}">（空）</c:if>
		                
					</label>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="form-field-1">附件：</label>
					<label class="col-sm-9" id="riskSchemeFile">
		                		
		                		 <c:forEach items="${riskScheme.filesList}" var="filesInfo" varStatus="status">
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
						          	<c:if test="${fn:length(riskScheme.filesList)==0}">（空）</c:if>
		                
					</label>
				</div>
			
				<div class="form-group" id="workProgress" <c:if test="${riskScheme.reviewType eq '方案'}"> style="display:none"</c:if>>                                                   
				   <label class="col-md-2 control-label no-padding-right" for="form-field-1">工作进展： </label>
		           <div class="col-sm-8">
	               		<textarea class="col-sm-10 limited validate[maxSize[2000]]" rows="5"  name="workProgress" >${riskScheme.workProgress}</textarea>
		           		<div class="col-sm-10 no-padding-right">
		                 	<span class="light-grey" style="float:right;">最多允许输入字符2000个</span>
		           	 	</div>
		           	</div>
				</div> 
				<div class="form-group" id="needCoordination" <c:if test="${(riskScheme.reviewType eq '方案') or (riskScheme.reviewType eq '打击逃废债工作进度')}"> style="display:none"</c:if> >
				   <label class="col-md-2 control-label no-padding-right" for="form-field-1">需协调事项： </label>
		           <div class="col-sm-8">
	               		<textarea class="col-sm-10 limited validate[maxSize[2000]]" rows="5"  name="needCoordination" >${riskScheme.needCoordination}</textarea>
		           		<div class="col-sm-10 no-padding-right">
		                 	<span class="light-grey" style="float:right;">最多允许输入字符2000个</span>
		           	 	</div>
		           	</div>
				</div> 
				<div class="form-group" id="nextPlan" <c:if test="${(riskScheme.reviewType eq '方案') or (riskScheme.reviewType eq '工作进度')}"> style="display:none"</c:if>>
				   <label class="col-md-2 control-label no-padding-right" for="form-field-1">下一步计划： </label>
		           <div class="col-sm-8">
	               		<textarea class="col-sm-10 limited validate[maxSize[2000]]" rows="5"  name="nextPlan" >${riskScheme.nextPlan}</textarea>
		           		<div class="col-sm-10 no-padding-right"> 
		                 	<span class="light-grey" style="float:right;">最多允许输入字符2000个</span>
		           	 	</div>
		           	</div>
				</div> 
				<div class="form-group" id="lawsuitInfo" <c:if test="${(riskScheme.reviewType eq '方案') or (riskScheme.reviewType eq '工作进度')}"> style="display:none"</c:if>>
				   <label class="col-md-2 control-label no-padding-right" for="form-field-1">涉诉情况： </label>
		           <div class="col-sm-8">
	               		<textarea class="col-sm-10 limited validate[maxSize[2000]]" rows="5"  name="lawsuitInfo" >${riskScheme.lawsuitInfo}</textarea>
		           		<div class="col-sm-10 no-padding-right">
		                 	<span class="light-grey" style="float:right;">最多允许输入字符2000个</span>
		           	 	</div>
		           	</div>
				</div> 
				<div class="form-group" id="lawsuitProgress" <c:if test="${(riskScheme.reviewType eq '方案') or (riskScheme.reviewType eq '工作进度')}"> style="display:none"</c:if>>
				   <label class="col-md-2 control-label no-padding-right" for="form-field-1">涉案进展： </label>
		           <div class="col-sm-8">
	               		<textarea class="col-sm-10 limited validate[maxSize[2000]]" rows="5"  name="lawsuitProgress" >${riskScheme.lawsuitProgress}</textarea>
		           		<div class="col-sm-10 no-padding-right">
		                 	<span class="light-grey" style="float:right;">最多允许输入字符2000个</span>
		           	 	</div>
		           	</div>
				</div> 
				<div class="form-group ">
				   <label class="col-md-2 control-label no-padding-right" for="form-field-1">备注： </label>
		           <div class="col-sm-8">
	               		<textarea class="col-sm-10 limited validate[maxSize[2000]]" rows="5" readonly="readonly" name="remark" >${riskScheme.remark}</textarea>
		           		<div class="col-sm-10 no-padding-right">
		                 	<span class="light-grey" style="float:right;">最多允许输入字符2000个</span>
		           	 	</div>
		           	</div>
				</div> 
				
				<div class="form-group">
					<label class="col-md-2 control-label no-padding-right" for="form-field-1">创建人： </label>
					<div class="col-sm-8">
						<input type="text" id="createUserName" name="createUserName" value="${riskScheme.createUserName}"  readonly="readonly"  class="col-md-5 col-sm-6" />
					</div>
				</div>
					
		        <div class="form-group">
					<label class="col-md-2 control-label no-padding-right" for="form-input">创建日期：
					</label>
					<div class="col-sm-8">
						<input  type="text"  name="createDate" value="<fmt:formatDate type="date"  value="${riskScheme.createDate}"  />"  readonly="readonly"  class="col-md-5 col-sm-6" /> 
					</div>
				</div>
       </form>
				<!-- <div class="form-group">
					   <h4 class="header smaller lighter green">
	                     		      附件
                       </h4>
						<table id="fileList" style="font-size:13px !important;"></table>
				</div>  -->

       
        
     </div>
    </div>
</div>
<div id="filesUpload_page"></div>
<%-- <%@ include file="/common_foot.jsp" %> --%>
<%@ include file="/common_del.jsp" %>
<script src="<%=path %>/plugins/webuploader/js/webuploader.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/crm/filesUpload/fileupv3.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>
<script type="text/javascript">
$(function () {
	var entityID = tool.getUrlParam("entityID");
	var defParam = {
			"uploadFileList" : "thelist",//待上传的附件列表div ID
			//"uploadConsoleList" : "uploadConsoleList",//错误信息提示div ID
			"btn_PickID" : "picker",//选择附件按钮ID
			"btn_UploadID" : "ctlBtn",//上传按钮ID
			"uploadURL" : "/crm/filesUpload/insertOneFilesUpload",//上传的地址 
			"uploadParam" : {
				"fileOneType":"projFiles",//附件表分类
				"fileTwoType":"08",//附件上传入口分类
				"clientID":"",//客户id
				"projectID":"",//项目id
				"fileFlag":"08",
				"entityID":entityID,
				"uuid":""//文件uuid
			},//上传附加参数
			"fileList" : "fileList",//已上传的附件列表Table ID
			"fileListURL" : "/crm/filesUpload/selectAllProjectFileList",//加载附件列表数据地址
			"mimeTypes":[
				{title : "图片", extensions : "*"},
				/* {title : "文档", extensions : "doc,docx,xls,xlsx,ppt,pptx,pdf,swf"},
				{title : "音频,视频", extensions : "f4v,wnv,wmv,mp3,rmvb,avi,mp4"},
				{title : "文本", extensions : "txt,xml"},
				{title : "压缩包", extensions : "rar,zip,7z"} */
				]//限定上传附件类型
	};
	//刷新附件列表
	$.zjm_upload.initTable(defParam);
	$.zjm_upload.initUpload(defParam);
});
</script>

	