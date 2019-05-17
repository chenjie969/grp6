<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="modal fade" id="addAnnounce" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增信息</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal" role="form" id="add_annouce_form">
      	 	<!-- 打开新增页面时,就从后台返回一个32位UUID值,隐藏在新增页面中,作为新增信息的主键ID.这样做主要是为了上传附件与信息主体的关系绑定 -->
      	 	<input type="hidden" name="messageId" value="${messageId }" id="hidden_messageId">	
      	 	<input type="hidden" name="messageTypePID" id="hidden_messageTypePID">	
      	 	<input type="hidden" name="messageTypePName" id="hidden_messageTypePName">	
      	 	
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>信息标题： </label>
				<div class="col-sm-10">
					<div class="row">
					    <div class="col-sm-12">
							<input type="text" name="title" class="col-sm-10 validate[required,maxSize[50]]" id="title"/>
						</div>
			        </div>
				</div>
			</div>
			
      	 	<div class="form-group col-sm-6">
      	 		<!-- 信息分类名称 -->
      	 		<label class="col-sm-4 control-label no-padding-right"><i class="icon-asterisk orange"></i>信息类型：</label>
				<div class="col-sm-8">
					<div class="col-sm-12 input-group select_messageType">
						<input  type="text"  class="form-control validate[required]" dataValue="" value="" autoField="messageTypeId" id="select_messageType"  name="messageTypeName" readonly="readonly"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span>
					</div>
				</div>
			</div>	
			
			
			<!-- <div class="form-group col-sm-6" >
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>要求签收： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-12">
							<div class="radio">
								<label>
									<input type="radio" name="isSign" checked="checked" class="ace form-field-radio" value="1">
									<span class="lbl">是</span>
								</label>
								<label>
									<input type="radio" name="isSign" class="ace form-field-radio" value="0">
									<span class="lbl">否</span>
								</label>
							</div>
						</div>
			        </div>
				</div>
			</div> -->
			
			<div class="form-group col-sm-6" >
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>发布范围： </label>
				<div class="col-sm-8">
					<div class="col-sm-12 input-group select_publicScope">
						<input type="hidden" id="receiveUserIdList"/>
						<input type="hidden" id="receiveUserNameList"/>
						<input  type="text"  class="form-control validate[required]"  autoField="receiveUserIdList" dataValue="" id="select_publicScope"  name="receiveUserNameList" readonly="readonly"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span>
					</div>
				</div>
			</div>
			<div class="form-group col-sm-12">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1">内容模板：</label>				
				<div class="col-sm-6">
					<select class="col-sm-8 select_templet  btn_ztb_select "  name="templetId" class_name="ztb_add_templetType" id="select_templet">
					</select>
				</div>
			</div>
			
			<div class="form-group col-sm-12">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1">信息内容：</label>
				<div class="col-sm-10">
					<div class="row">
						<div class="col-sm-12">
								<input type="hidden" id="content" name="content" class="ztb_add_content">
								<div id="ueditor" >
								    <script id="editor" type="text/plain" style="width:97%;height:300px;"></script>
									 
								</div >
						<!--   	<div class="tabbable">
									<ul class="nav nav-tabs" id="typeTab">
										<li class="active">
											<a data-toggle="tab" href="#ueditor" id="ueditorTab">
												编辑器
											</a>
										</li>
										<li>
											<a data-toggle="tab" href="#image" id="imageTab">
												图片
											</a>
										</li>
										<li>
											<a data-toggle="tab" href="#url" id="urlTab">
												链接
											</a>
										</li>
									</ul>
									<div class="tab-content">
									    <input type="hidden" id="contentType" name="contentType" value="01"/>
										<input type="hidden" id="content" name="content" class="ztb_add_content">
										<div id="ueditor" class="tab-pane in active">
										    <script id="editor" type="text/plain" style="width:97%;height:300px;"></script>
											 
										</div >
										<div id="image" class="tab-pane"> 
											 <label class="control-label" for="FileUpload1"></label>
							                 <div class="controls">
							                 	<input type="hidden" id="imageUrl" />
							                 	<input class="input-file uniform_on" id="FileUpload1" name="FileUpload1" type="file">
							                 </div>
										</div>
										<div id="url" class="tab-pane">
											<div class="row" >
												 <div class="col-sm-12">
													<input type="text" name="url" placeholder="请输入链接地址" class="col-sm-12 validate[required,maxSize[100]]" id="url"/>
												 </div>
											</div>
										</div>
								  </div>
							 </div> -->
						</div>
					</div>
				</div>
			</div>
		 
			<div class="form-group">	
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1">文件上传： </label>
				<button type="button" class="btn btn-sm btn-primary" id="btn_uploadfiles"> <i class='icon-search bigger-110'></i>选择文件</button>
			</div>
			<div id="div_fileList"  class="form-group">
				<div class="col-sm-12">
					<table id="fileList" style="font-size:13px !important;"></table>
				</div>
			</div>
		</form>
      </div>
      <div class="modal-footer ">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-cloud-download bigger-110'></i>暂存</button>
      	<button type="button" class="btn btn-primary btn_submit_audit" > <i class='icon-ok bigger-110'></i>提交审核</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>

<%@ include file="/oa/info/uploadFiles/filesUpModal.jsp" %>
<%@ include file="/oa/info/uploadFiles/filesDel.jsp" %>
<script type="text/javascript">
$(function () {
	var defParam = {
			"uploadFileList" : "uploadFileList",//待上传的附件列表div ID
			"uploadConsoleList" : "uploadConsoleList",//错误信息提示div ID
			"btn_PickID" : "pick",//选择附件按钮ID
			"btn_UploadID" : "upload",//上传按钮ID
			"uploadURL" : "/crm/filesUpload/insertOneFilesUpload",//上传的地址 
			"uploadParam" : {
				"fileOneType":"oaFiles",//附件表分类--> oa类附件
				"fileTwoType":"01",//附件上传入口分类 --> 01:信息附件;02：会议室附件;03：会议附件
				"entityID":$("#hidden_messageId").val()
			},//上传附加参数
			"fileList" : "fileList",//已上传的附件列表Table ID
			"fileListURL" : "/oa/announce/selectUploadedFilesPageTables",//加载附件列表数据地址
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
		var zindex = parseInt($("#addAnnounce").css("z-index"));
		$("#uploadfiles").css("z-index",zindex+50);
		$(".modal-backdrop:eq(1)").css("z-index",zindex+40);
		$.zjm_upload.initUpload(defParam);
		$("#uploadfiles").on("hidden.bs.modal", function (e) {//解除事件绑定
			$.zjm_upload.initTable(defParam);
			uploader.destroy();
		}); 
	});
	
});
</script>
<script type="text/javascript">
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
</script>
