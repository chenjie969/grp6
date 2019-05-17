<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
 <link rel="stylesheet" href="<%=path %>/plugins/viewer/viewer.min.css?v=<%=vardate%>" /> 
<link rel="stylesheet" href="<%=path %>/plugins/webuploader/css/style.css?v=<%=vardate%>" />
<link rel="stylesheet" href="<%=path %>/plugins/webuploader/css/webuploader.css?v=<%=vardate%>" />
<link rel="stylesheet" href="<%=path %>/plugins/webuploader/css/demo.css?v=<%=vardate%>" />
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<h4 class="header smaller lighter blue">
				附件
			</h4>
			<!--用来存放文件信息-->
			<div id="uploader" class="wu-example">
			    <div class="queueList">
			        <div id="dndArea" class="placeholder">
			            <div id="filePicker" class="webuploader-container"><div class="webuploader-pick">点击选择图片</div><div id="rt_rt_1bn09g1o8qa21g33v2j2c41ttf1" style="position: absolute; top: 0px; left: 448px; width: 168px; height: 44px; overflow: hidden; bottom: auto; right: auto;"><input name="file" class="webuploader-element-invisible" multiple="multiple" accept="image/*" type="file"><label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255) none repeat scroll 0% 0%;"></label></div></div>
			            <p>或将照片拖到这里，单次最多可选300张</p>
			        </div>
			    <ul class="filelist"></ul></div>
			    <div class="statusBar" style="display:none;">
			        <div class="progress" style="display: none;">
			            <span class="text">0%</span>
			            <span class="percentage" style="width: 0%;"></span>
			        </div><div class="info">共0张（0B），已上传0张</div>
			        <div class="btns">
			            <div id="filePicker2" class="webuploader-container"><div class="webuploader-pick">继续添加</div><div id="rt_rt_1bn09g1oj66n10dj9qpi1n1o6" style="position: absolute; top: 0px; left: 0px; width: 1px; height: 1px; overflow: hidden;"><input name="file" class="webuploader-element-invisible" multiple="multiple" accept="image/*" type="file"><label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255) none repeat scroll 0% 0%;"></label></div></div><div class="uploadBtn state-pedding">开始上传</div>
			        </div>
			    </div>
			</div>
		</div>
	</div>
</div>
<div id="filesUpload_page" ></div>
<%@ include file="/common_foot.jsp" %>
<script src="<%=path %>/plugins/webuploader/js/webuploader.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/crm/filesUpload/fileupv2_3.js?v=<%=vardate%>"></script>
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