<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="<%=path %>/plugins/plupload/plupload.full.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/plupload/i18n/zh_CN.js?v=<%=vardate%>"></script>
<script src="<%=path %>/sys/dataBaseVindicate/docMould/docMould.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>

<script>
$(function () {
	$("#btn_uploadfiles").click(function(){
		defParam.uploadParam.flowID=$("#hidden_flowID").val();
		defParam.uploadParam.entityID=$("#applyID").val();
		$("#uploadfiles").modal({keyboard:true});
		$.zjm_upload.initUpload(defParam);
		$("#uploadfiles").on("hidden.bs.modal", function (e) {//解除事件绑定
			$.zjm_upload.initTable(defParam);
			uploader.destroy();
			window.location.reload();
		}); 
	});

	zjm.init();
	var defParam = {
			"uploadFileList" : "uploadFileList",//待上传的附件列表div ID
			"uploadConsoleList" : "uploadConsoleList",//错误信息提示div ID
			"btn_PickID" : "pickfiles",//选择附件按钮ID
			"btn_UploadID" : "uploadfiles",//上传按钮ID
			"uploadURL" : "/crm/filesUpload/insertOneFilesUpload",//上传的地址 
			"uploadParam" : {
				"fileOneType":"projFiles",//项目附件
				"fileTwoType":"03",//附件上传入口分类
				"clientID":"",//客户id
				"flowID":"",
				"fileFlag":"projFiles",
				"entityID":""//
			},//上传附加参数
			"fileList" : "fileList",//已上传的附件列表Table ID
			"fileListURL" : "/crm/filesUpload/selectAllDocMouldList",//加载附件列表数据地址
			"mimeTypes":""
				/* [
				{title : "图片", extensions : "image/jpg,image/gif,image/png,image/jpeg"},
				{title : "文档", extensions : "doc,docx,xls,xlsx,ppt,pptx,pdf,swf"},
				{title : "音频,视频", extensions : "f4v,wnv,wmv,mp3,rmvb,avi,mp4"},
				{title : "文本", extensions : "txt,xml"},
				{title : "压缩包", extensions : "rar,zip,7z"}
				] *///限定上传附件类型
	};
	//刷新附件列表
	$.zjm_upload.initTable(defParam);
})

</script>
<style>
	table{
		font-size:14px !important;
	}
	table tr td{
		border:1px solid #ddd;
		text-align: center;
	}
	.twoLocation{
		text-align: left;
	}
</style>

<div class="page-header">
	<h4>部门审核</h4>
</div>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<h4 class="lighter blue" style="text-align:center;">还款详情</h4>
			<div class="space-16"></div>
			<div class="col-sm-10 col-sm-offset-1">
					<table class="table table-bordered table-strip">
					<col style="background:#f9f9f9;"></col>
					<colgroup>
						<col width="25%">
						<col width="25%">
						<col width="25%">
						<col width="25%">
					</colgroup>
							<tr>
						<td>项目名称</td>
						<td class="twoLocation">${apply.projectName }</td>
						<td bgcolor="#f9f9f9">客户名称</td>
						<td class="twoLocation">${apply.clientName }</td>
					</tr>
					<tr>
						<td>合同编号</td>
						<td class="twoLocation">${apply.dContractCode }</td>
						<td bgcolor="#f9f9f9">合同期间</td>
						<td class="twoLocation"><fmt:formatDate value="${apply.contractBeginDate }"></fmt:formatDate>~<fmt:formatDate value="${apply.contractEndDate }"></fmt:formatDate></td>
					</tr>
					<tr>
						<td>委贷金额</td>
						<td class="twoLocation"><fmt:formatNumber value="${project.loadSum }"></fmt:formatNumber>&nbsp;万元</td>
						<td bgcolor="#f9f9f9">退费金额</td>
						<td class="twoLocation">${costReturn.returnCostSum }</td>
					</tr>
					<tr>
						<td>保证金金额</td>
						<td class="twoLocation"><fmt:formatNumber value="${optGuaranty.guaranteeSum }"></fmt:formatNumber>&nbsp;万元</td>
					</tr>
					<%-- <div class="form-group" >
						<div class="widget-header widget-header-flat">
							<a href="javascript:void(0)" style="margin-right:10px;line-height:37px;display:block;text-decoration:none;" id="btn_uploadfiles">
								<i class="icon-edit bigger-110 orange" ></i>
								<span class="bigger-110 no-text-shadow">选择上传文件</span>
							</a>
							<input type="hidden" id="hidden_flowID" value="${flowID }">
							<input type="hidden" id="applyID" value="${apply_ID }">
						</div>
					</div> --%>
					<jsp:include page="/gworkFlow/components/component_sugget_view_import.jsp"></jsp:include>
				</table>
				<div class="space-16 col-sm-12"></div>
			<div class="space-16"></div>
			<div class="col-sm-10 col-sm-offset-1  suggest_pare">
			<div class="col-sm-12 space-16"></div>
			
			<td>附件</td>
						<td colspan="3" class="twoLocation">
							<c:forEach items="${projectfiles }" var="projectfiles" varStatus="status11">
								<c:choose>
										<c:when test="${projectfiles.extend eq 'docx' || projectfiles.extend eq 'doc' || projectfiles.extend eq 'pdf' || projectfiles.extend eq 'xlsx' || projectfiles.extend eq 'xls' || projectfiles.extend eq 'ppt' || projectfiles.extend eq 'pptx' }">
											<a href="javascript:void(0)" onclick="window.parent.open('/sys/documentPreview/selectDocumentViewPage?domhref=${projectfiles.pathFile}&domextend=${projectfiles.extend }')">${projectfiles.sourceFileName }</a>
											&nbsp;&nbsp;<a title="下载" onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)"><i class="icon-download-alt bigger-120 "></i></a> 
											<c:if test="${urlParam.type eq 'edit' }">
												&nbsp;&nbsp;<a title='删除附件' name="${projectfiles.projectFiles_ID }" onclick="$.zjm_planLoanAndPay.delFiles(this.name);" href='javascript:void(0)'><i class="icon-trash bigger-120"></i></a>
											</c:if>							
										</c:when>
										<c:when test="${projectfiles.extend == 'jpeg' || projectfiles.extend == 'png' || projectfiles.extend == 'gif' || projectfiles.extend == 'jpg' }">
											<c:if test="${projectfiles.extend eq 'jpg' ||(projectfiles.extend eq 'jpeg')||(projectfiles.extend eq 'png') ||(projectfiles.extend eq 'gif') }">
										 		<a href="#" class="btn_opfile_viewer_img" data-original="${projectfiles.pathFile}" src="${projectfiles.pathFile}">
				                			</c:if>		
				                				${projectfiles.sourceFileName}
				                   			<c:if test="${projectfiles.extend eq 'jpg'}">			
				                	       		</a>
									 		</c:if>
									 		<c:if test="${projectfiles.extend=='jpeg' || projectfiles.extend=='png' || projectfiles.extend=='gif' || projectfiles.extend=='jpg'}">
												&nbsp;&nbsp;
												
												 <a href="#" class="btn_opfile_viewer_img" data-original="${projectfiles.pathFile}" src="${projectfiles.pathFile}"><i class="icon-zoom-in bigger-120 orange"></i></a>
												    <img class="hide" data-original="${projectfiles.pathFile}" src="${projectfiles.pathFile}" alt="${projectfiles.sourceFileName}" title="${projectfiles.sourceFileName}"/>
												&nbsp;&nbsp;
												<a href="#" onclick="javascript:window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile}')">
														<i class="icon-download-alt bigger-120 "></i>
												</a>
						          			</c:if>
											<%-- <a href="#" class="btn_opfile_viewer_img" data-original="${projectfiles.pathFile}" src="${projectfiles.pathFile}">${projectfiles.sourceFileName }</a>
											 <img class="hide" data-original="${projectfiles.pathFile}" src="${projectfiles.pathFile}" alt="${projectfiles.sourceFileName}" title="${projectfiles.sourceFileName}">
											 &nbsp;&nbsp;
											<a title="下载" onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)">
												<i class="icon-download-alt bigger-120 "></i>
											</a> 
											<c:if test="${urlParam.type eq 'edit' }">
												&nbsp;&nbsp;<a title='删除附件' name="${projectfiles.projectFiles_ID }" onclick="$.zjm_planLoanAndPay.delFiles(this.name);" href='javascript:void(0)'><i class="icon-trash bigger-120"></i></a>
											</c:if> --%>
										</c:when>
										<c:otherwise>
											<a onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)">${projectfiles.sourceFileName }</a> 
											<c:if test="${urlParam.type eq 'edit' }">
												&nbsp;&nbsp;<a title='删除附件' name="${projectfiles.projectFiles_ID }" onclick="$.zjm_planLoanAndPay.delFiles(this.name);" href='javascript:void(0)'><i class="icon-trash bigger-120"></i></a>
											</c:if>
										</c:otherwise>
									</c:choose>
								<br>
							</c:forEach>
						</td>
			
		</div>
	</div>
</div>
<div id="page_intentionLetter"></div>
<!-- <div id="loanApproval_page"></div> -->
<div class="modal fade" id="uploadfiles" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
  <div class="modal-dialog" >
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">文档上传</h4>
      </div>
      <div class="modal-body">
     		<form class="form-horizontal" role="form" id="add_form">
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 待上传文档列表 </label>
				<div class="col-sm-9" id="uploadFileList">您的浏览器未安装 Flash, Silverlight 或者支持 HTML5 .</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group" id="uploadConsoleListDiv">
				
			</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="pickfiles"> <i class='icon-search bigger-110'></i>选择文件</button>
        <button type="button" class="btn btn-primary" id="uploadfiles"> <i class='icon-upload-alt bigger-110'></i>上传</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
<script src="/plugins/plupload/plupload.full.min.js"></script>
<script src="/plugins/plupload/i18n/zh_CN.js"></script>
<script src="/gworkFlow/optreturn/uploadFile.js"></script>
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
			 var suggestParent = $(this).parents(".suggest_pare"); 
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
