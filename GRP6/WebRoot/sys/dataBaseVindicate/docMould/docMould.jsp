<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<link rel="stylesheet" href="<%=path %>/plugins/viewer/viewer.min.css?v=<%=vardate%>" />
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<h4 class="page-header">
				文档模板
			</h4>
			<table id="fileList" style="font-size:13px !important;"></table>
			<div class="space-4"></div>
			<h4 class="header smaller lighter blue">
				添加文档模板
				<!-- <button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_uploadfiles">
					<i class="icon-edit bigger-110"></i>
					<span class="bigger-110 no-text-shadow">添加</span>
				</button> -->
			</h4>
      		<div class="space-4"></div>
   			<div class="col-sm-4">
      			<label class="col-sm-3 control-label no-padding-right" for="form-input">文档编号： </label>
				<div class="col-sm-8">
					<input type="text" name="mouldName" id="mouldName"  class="col-sm-12 col-md-12  validate[maxSize[50]]" />
				</div>
				<div class = "col-sm-12">&nbsp;</div>
				<label class="col-sm-3 control-label no-padding-right" for="form-input">文档模版类型：</label>
				<div class="col-sm-8">
					<input type="hidden" name="mouldTypeName" id="mouldTypeName"  class="ztb_add_mouldTypeName">
					<select class="col-sm-12 col-md-12 select_mouldType  btn_ztb_select"  name="mouldTypeID" class_name="ztb_add_mouldTypeName" id="select_mouldType" readonly="readonly">
					</select>
				</div>
			</div>
			<div class="col-sm-8" style="margin-top:5px">
      			<button type="button" name="button" class="btn btn-app btn-purple btn-xs" id="btn_uploadfiles">
					<i class="icon-cloud-upload "></i>
					<span class="bigger-110 no-text-shadow">添加</span>
				</button>
			</div>
			
			
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
			
			
		</div>
	</div>
</div>
<div id="filesUpload_page" ></div>
<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_message.jsp" %>
<%@ include file="/sys/dataBaseVindicate/docMould/del.jsp" %>
<script src="<%=path %>/plugins/plupload/plupload.full.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/plupload/i18n/zh_CN.js?v=<%=vardate%>"></script>
<script src="<%=path %>/sys/dataBaseVindicate/docMould/docMould.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>
<script type="text/javascript">
$(function () {
	zjm.init();
	var defParam = {
			"uploadFileList" : "uploadFileList",//待上传的附件列表div ID
			"uploadConsoleList" : "uploadConsoleList",//错误信息提示div ID
			"btn_PickID" : "pickfiles",//选择附件按钮ID
			"btn_UploadID" : "uploadfiles",//上传按钮ID
			"uploadURL" : "/crm/filesUpload/insertOneFilesUpload",//上传的地址 
			"uploadParam" : {
				"fileOneType":"docMould",//文档模版
				"fileTwoType":"",//附件上传入口分类
				"clientID":"",//客户id
				"projectID":""//项目id
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
	zjm.dataViewValSelect("select_house", "/selectDicTypeSelectJSON", {"dicTypePID" : '1fe88348f96c4cbfb33480860fa1b617'});//获取住房性质下拉框
	zjm.dataViewValSelect("select_mouldType", "/selectDicTypeListJSON", {"dicTypePID" : 'b9813a1bea1e4f9b8880a0111a670233'});//获取模板类型下拉框
	$("#btn_uploadfiles").click(function(){
		var mouldName = $("#mouldName").val();
		var mouldTypeName = $("#mouldTypeName").val();
		if(mouldName == ""){
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("文档名称不能为空");
			return;
		}
		console.log(mouldTypeName);
		if(mouldTypeName == "" || mouldTypeName == " 请选择"){
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("请选择文档模版类型");
			return;
		}
		$("#uploadfiles").modal({keyboard:true});
		$.zjm_upload.initUpload(defParam);
		$("#uploadfiles").on("hidden.bs.modal", function (e) {//解除事件绑定
			$.zjm_upload.initTable(defParam);
			uploader.destroy();
		}); 
	});
	
});
</script>