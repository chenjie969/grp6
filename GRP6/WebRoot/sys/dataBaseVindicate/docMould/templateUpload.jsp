<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
 <link rel="stylesheet" href="<%=path %>/plugins/viewer/viewer.min.css?v=<%=vardate%>" /> 
<link rel="stylesheet" href="<%=path %>/plugins/webuploader/css/webuploader.css?v=<%=vardate%>" />
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<h4 class="header smaller lighter blue">
				文档模板
			</h4>
			
			<%-- 初始化加载显示列表信息 --%>
			<table id="fileList" style="font-size:13px !important;"></table>
			
			<div class="space-20"></div>
			
		
			<div class="col-sm-12">
      			<label class="col-sm-2" style="text-align:right;">文档编号： </label>
				<div class="col-sm-4">
					<input type="text" name="mouldName" id="mouldName"  class="col-sm-12 col-md-12  validate[maxSize[50]]" />
				</div>
				<div class = "col-sm-12">&nbsp;</div>
				<label class="col-sm-2" style="text-align:right;">文档模版类型：</label>
				<div class="col-sm-4">
					<input type="hidden" name="mouldTypeName" id="mouldTypeName"  class="ztb_add_mouldTypeName">
					<select class="col-sm-12 col-md-12 select_mouldType  btn_ztb_select"  name="mouldTypeID" class_name="ztb_add_mouldTypeName" id="select_mouldType" readonly="readonly">
					</select>
				</div>
		</div>
		<div class="space-20 col-sm-12"></div>

		<div class="col-sm-10 col-sm-offset-2">
			<!--用来存放文件信息-->
			<div id="thelist" class="uploader-list"></div>
			<div class="space-20 col-sm-12"></div>
			<div id="picker" class="col-xs-2">选择文件</div>
			<button id="ctlBtn" class="btn btn-default">开始上传</button>
		</div>
					
		
			
		</div>
	</div>
</div>
<div id="filesUpload_page" ></div>
<%@ include file="/common_foot.jsp" %>
<script src="<%=path %>/plugins/webuploader/js/webuploader.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/sys/dataBaseVindicate/docMould/templateUpload.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>
<%@ include file="/common_message.jsp" %>

<script type="text/javascript">
$(function () {
	zjm.dataViewValSelect("select_mouldType", "/selectDicTypeListJSON", {"dicTypePID" : 'b9813a1bea1e4f9b8880a0111a670233'});//获取模板类型下拉框

	var defParam = {
			"uploadFileList" : "thelist",//待上传的附件列表div ID
			//"uploadConsoleList" : "uploadConsoleList",//错误信息提示div ID
			"btn_PickID" : "picker",//选择附件按钮ID
			"btn_UploadID" : "ctlBtn",//上传按钮ID
			"uploadURL" : "/crm/filesUpload/insertOneFilesUpload",//上传的地址 
			"uploadParam" : {
				"fileOneType":"docMould",//附件表分类
				"fileTwoType":"",//附件上传入口分类
				"clientID":"",//客户id
				"projectID":"",//项目id
				"uuid":""//文件uuid
			},//上传附加参数
			"fileList" : "fileList",//已上传的附件列表Table ID
			"fileListURL" : "/crm/filesUpload/selectAllDocMouldList",//加载附件列表数据地址
			"mimeTypes":[
				/* {title : "图片", extensions : "gif,jpg,jpeg,bmp,png",mimeTypes: 'image/jpg,image/gif,image/png,image/jpeg'}, */
				{title : "文档", extensions : "doc,docx", mimeTypes:'doc/docx'}
			/* 	{title : "音频,视频", extensions : "f4v,wnv,wmv,mp3,rmvb,avi,mp4"},
				{title : "文本", extensions : "txt,xml"},
				{title : "压缩包", extensions : "rar,zip,7z"} */
				]//限定上传附件类型
	};
	//刷新附件列表
	$.templateUpload.initTable(defParam);
	$.templateUpload.initUpload(defParam);
});
</script>