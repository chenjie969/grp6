<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
 <link rel="stylesheet" href="<%=path %>/plugins/viewer/viewer.min.css?v=<%=vardate%>" /> 
<link rel="stylesheet" href="<%=path %>/plugins/webuploader/css/webuploader.css?v=<%=vardate%>" />
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<h4 class="header smaller lighter blue">
				附件
			</h4>
			<!--用来存放文件信息-->
			<div id="uploader" class="wu-example">
				<div id="thelist" class="uploader-list"></div>
				<div class="btns">
					<div id="picker" class="col-xs-2">选择文件</div>
					<button id="ctlBtn" class="btn btn-default">开始上传</button>
				</div>
			</div>
			<table id="fileList" style="font-size:13px !important;"></table>
		</div>
	</div>
</div>
<div id="filesUpload_page" ></div>
<%@ include file="/common_foot.jsp" %>
<script src="<%=path %>/plugins/webuploader/js/webuploader.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/crm/filesUpload/fileupv2_2.js?v=<%=vardate%>"></script>
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
				"fileOneType":"clientFiles",//附件表分类
				"fileTwoType":"01",//附件上传入口分类
				"clientID":"1c6847436cd7418e88fb11b465cbfce4",//客户id
				"projectID":"",//项目id
				"uuid":""//文件uuid
			},//上传附加参数
			"fileList" : "fileList",//已上传的附件列表Table ID
			"fileListURL" : "/crm/filesUpload/selectAllFilesList"//加载附件列表数据地址
	};
	$.zjm_upload.initUpload(defParam);
});
</script>