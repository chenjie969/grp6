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
		defParam.uploadParam.flowID=$("#fileTwoType").val();
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
				"fileTwoType":"005",//附件上传入口分类
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
	<h4>上传《管理类档案目录》或者《管理类档案目录,不移交说明》</h4>
</div>
<div class="page-content">
 <h4 class="header smaller lighter blue">
						项目信息
				</h4>
					<h5 style="line-height: 26px;"class="col-sm-6">
						项目编号：<span class="grey">${apply.busiCode}</span>
					</h5>
					<h5  style="line-height: 26px;"class="col-sm-6">
						项目名称：<span class="grey">${apply.projectName}</span>
					</h5>
					<h5 style="line-height: 26px;"class="col-sm-6">
						客户名称：<span class="grey">${apply.clientName}</span>
					</h5>
					<h5 style="line-height: 26px;"class="col-sm-6">
						业务品种：<span class="grey">${apply.busiTypeNameList}</span>
					</h5>
					<h5  style="line-height: 26px;"class="col-sm-12">
						申请金额：<span class="grey">
						<fmt:formatNumber value="${apply.applySum}" pattern="###,###.######"> </fmt:formatNumber>
						 &nbsp;万元</span>
					</h5>
					<!-- <h5 style="line-height: 26px;"class="col-sm-6">
					    期限：<span class="grey"></span>
					</h5> -->
					<h5 style="line-height: 26px;"class="col-sm-6">
						合作机构：<span class="grey">${apply.bankNameList}</span>
					</h5>
					<h5  style="line-height: 26px;"class="col-sm-6">
						项目来源：<span class="grey">${apply.projectSourceName}</span>
					</h5>
					<h5  style="line-height: 26px;"class="col-sm-6">
						A角：<span class="grey">${apply.amanName}</span>
					</h5>
					<h5  style="line-height: 26px;"class="col-sm-6">
						B角：<span class="grey">${apply.bmanName}</span>
					</h5>
					<h5  style="line-height: 26px;"class="col-sm-6">
						风控评审人：<span class="grey">${apply.reviewManName}</span>
					</h5>
					<h5  style="line-height: 26px;"class="col-sm-6">
						经办部门：<span class="grey">${apply.departName}</span>
					</h5>
			<%-- <c:if test="${suggest.entityType eq '03'}"><!-- 风险处置项目信息 -->
					<h5 style="line-height: 26px;"class="col-sm-6">
						标题：<span class="grey">${riskScheme.title}</span>
					</h5>
			</c:if> --%>
	<div class="row">
		<div class="col-xs-12">
				<div class="form-group" >
						<div class="widget-header widget-header-flat">
							<a href="javascript:void(0)" style="margin-right:10px;line-height:37px;display:block;text-decoration:none;" id="btn_uploadfiles">
								<i class="icon-edit bigger-110 orange" ></i>
								<span class="bigger-110 no-text-shadow">选择上传文件</span>
							</a>
							<input type="hidden" id="applyID" value="${apply.apply_ID }">
							<input type="hidden" id="fileTwoType" value="${fileTwoType}">
						</div>
						
						<h5 style="line-height: 26px;"class="col-sm-6">附件</<h5>
						<!-- <td colspan="3" class="twoLocation"> -->
							<c:forEach items="${projectfiles }" var="projectfiles" varStatus="status">
								${status.index+1 }、
								<c:choose>
									<c:when test="${projectfiles.extend eq 'docx' || projectfiles.extend eq 'doc' || projectfiles.extend eq 'pdf' || projectfiles.extend eq 'xlsx' || projectfiles.extend eq 'xls' || projectfiles.extend eq 'ppt' || projectfiles.extend eq 'pptx' }">
										<a href="javascript:void(0)" onclick="window.parent.open('/sys/documentPreview/selectDocumentViewPage?domhref=${projectfiles.pathFile}&domextend=${projectfiles.extend }')">${projectfiles.sourceFileName }</a>
										&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)">下载</a> 
														
									</c:when>
									<c:when test="${projectfiles.extend == 'jpeg' || projectfiles.extend == 'png' || projectfiles.extend == 'gif' || projectfiles.extend == 'jpg' }">
										<a onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)">${projectfiles.sourceFileName }</a> 
										
									</c:when>
									<c:otherwise>
										<a onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)">${projectfiles.sourceFileName }</a> 
										
									</c:otherwise>
								</c:choose>
								<br>
							</c:forEach>
					</div>
			<div class="space-16 col-sm-12"></div>
			<div class="space-16"></div>
			<div class="col-sm-10 col-sm-offset-1">
			<div class="col-sm-12 space-16"></div>
			<!-- <div class="col-sm-12 clearfix form-actions">
				<div class="col-md-offset-5 col-md-7">
					<button class="btn btn_factPaySave" type="button"><i class="icon-save bigger-110 "></i>保存</button>
			        <button class="btn btn_factViewColse" type="button"><i class="icon-remove bigger-110 "></i>关闭</button>
	      		</div>
	      	</div> -->
			
		</div>
	</div>
</div>
<div id="page_intentionLetter"></div>
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
<script src="/project/renewal/uploadFile.js"></script>
