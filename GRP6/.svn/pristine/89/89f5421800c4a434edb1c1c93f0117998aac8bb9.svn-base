<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<%=path %>/plugins/viewer/viewer.min.css?v=<%=vardate%>" />
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<h5>申请人：
	    		<span class="ztb_view_personName "></span>
	    		&nbsp;&nbsp;
	    		<span class="ztb_view_clientName "></span>
				<span style="margin-left:2em;" class="grey">客户编号：
					<span class="ztb_view_clientBH"></span>
				</span>
			</h5>
			<h4 class="header smaller lighter blue">
				附件
				<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_uploadfiles">
					<i class="icon-edit bigger-110"></i>
					<span class="bigger-110 no-text-shadow">添加</span>
				</button>
			</h4>
			<table id="fileList" style="font-size:13px !important;"></table>
		</div>
	</div>
</div>
<div id="filesUpload_page" ></div>

<script src="<%=path %>/plugins/plupload/plupload.full.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/plupload/i18n/zh_CN.js?v=<%=vardate%>"></script>
<script src="<%=path %>/crm/client/companyClient/fileup.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>
<script type="text/javascript">
$(function () {
	var defParam = {
			"uploadFileList" : "uploadFileList",//待上传的附件列表div ID
			"uploadConsoleList" : "uploadConsoleList",//错误信息提示div ID
			"btn_PickID" : "pickfiles",//选择附件按钮ID
			"btn_UploadID" : "uploadfiles",//上传按钮ID
			"uploadURL" : "/crm/filesUpload/insertOneFilesUpload",//上传的地址 
			"uploadParam" : {
				"fileOneType":"clientFiles",//附件表分类
				"fileTwoType":"01",//附件上传入口分类
				"clientID":$("#client_ID").val(),//客户id
				"projectID":""//项目id
			},//上传附加参数
			"fileList" : "fileList",//已上传的附件列表Table ID
			"fileListURL" : "/crm/filesUpload/selectAllFilesList",//加载附件列表数据地址
			"mimeTypes":""
				/* [
				{title : "图片", extensions : "image/jpg,image/gif,image/png,image/jpeg"},
				{title : "文档", extensions : "doc,docx,xls,xlsx,ppt,pptx,pdf,swf"},
				{title : "音频,视频", extensions : "f4v,wnv,wmv,mp3,rmvb,avi,mp4"},
				{title : "文本", extensions : "txt,xml"},
				{title : "压缩包", extensions : "rar,zip,7z"}
				]//限定上传附件类型 */
	};
	//刷新附件列表
	$.zjm_upload.initTable(defParam);
	$("#btn_uploadfiles").click(function(){
		$("#uploadfiles").modal({keyboard:true});
		$.zjm_upload.initUpload(defParam);
		$("#uploadfiles").on("hidden.bs.modal", function (e) {//解除事件绑定
			$.zjm_upload.initTable(defParam);
			uploader.destroy();
		}); 
	});
	
});
</script>