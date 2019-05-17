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

	<input type="hidden" id="entityID" value="${entityID}" />
	<div class="page-content">
		<div class="page-header">
			<h4>核销损失情况</h4>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="table-responsive">
					<table id="losePro_table" style="font-size:13px !important;"></table>  
			   </div>
			</div>
		</div><!-- /.row -->
	</div><!-- /.page-content -->

<div id="replace_page"></div>
<div id="filesUpload_page"></div>
<%-- <%@ include file="/common_foot.jsp" %> --%>
<%@ include file="/common_del.jsp" %>
<script src="<%=path %>/plugins/webuploader/js/webuploader.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/crm/filesUpload/fileupv2.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/project/replacePro/replacePro.js?v=<%=vardate%>"></script>
<script type="text/javascript">
$(function () {
	/* var entityID = tool.getUrlParam("entityID"); */
	var entityID = $("#entityID").val();
	var defParam = {
			"uploadFileList" : "thelist",//待上传的附件列表div ID
			//"uploadConsoleList" : "uploadConsoleList",//错误信息提示div ID
			"btn_PickID" : "picker",//选择附件按钮ID
			"btn_UploadID" : "ctlBtn",//上传按钮ID
			"uploadURL" : "/crm/filesUpload/insertOneFilesUpload",//上传的地址 
			"uploadParam" : {
				"fileOneType":"projFiles",//附件表分类
				"fileTwoType":"05",//附件上传入口分类
				"clientID":"",//客户id
				"projectID":"",//项目id
				"fileFlag":"05",
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

	