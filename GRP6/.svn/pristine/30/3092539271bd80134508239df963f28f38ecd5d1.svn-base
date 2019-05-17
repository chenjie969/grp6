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
<script type="text/javascript">

/**
 * 更新审批信息;
 */
function riskSchemeUpdate(){
	if($("#approvalEdit_from").validationEngine("validate")){
		var queryContainer_form = $("#approvalEdit_from");
		console.log(queryContainer_form.serializeJson());
				$.ajax({type:'POST',url:'/project/riskScheme/updateOneRiskSchemeInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
			        	if(data.obj){
							$("#addNewApproval").modal("hide");
						}else{
							alert("保存失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
	}
 };
</script>
<div class="page-content">   
      <div class="page-header">
			<h4>修改审批信息</h4>
		</div>
      <div class="row">
		<div class="col-xs-12">
		<form class="form-horizontal" role="form" id="approvalEdit_from">
			<input type="hidden" id="riskScheme_ID"  name="riskScheme_ID" value="${riskScheme.riskScheme_ID}">
			<div class="space-4"></div>
			<div class="form-group">
          		<label class="col-sm-2 control-label no-padding-right" for="form-field-1"> 标题： </label>
				<div class="col-md-8">
	            	<input type="text" id="title" name="title" value="${riskScheme.title}" class="col-md-5 col-sm-6" />
				</div>
          	</div>
          	
          	<div class="form-group">
				<label class="col-md-2 control-label no-padding-right" for="form-field-1">审批类型： </label>
				<div class="col-sm-8">
					<input type="text" id="reviewType" name="reviewType" readonly="readonly" value="${riskScheme.reviewType}" class="col-md-5 col-sm-6" />
				</div>
			</div>
          	
       		<div class="form-group" >
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1">方案：</label>
				<div class="col-sm-6"  >
	                <button class="btn btn-sm btn-info"  type="button" name="button" id="${riskScheme.riskScheme_ID.concat('_09')}" onclick="$.zjm_loanAttachment.filesUpdate(this.id)">
	                    	请选择  </button>
	                 <div id="attachmentsDIV_09" class=""  > ${riskScheme.riskScheme_ID.concat('_09')}</div>
				</div>
			</div>
			<div class="form-group" >
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1">附件：</label>
				<div class="col-sm-6"  >
	                <button class="btn btn-sm btn-info"  type="button" name="button" id="${riskScheme.riskScheme_ID.concat('_08')}" onclick="$.zjm_loanAttachment.filesUpdate(this.id)">
	                    	请选择</button>
	                <div id="attachmentsDIV_08" class=""  > ${riskScheme.riskScheme_ID.concat('_08')}</div>
				</div>
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
	               		<textarea class="col-sm-10 limited validate[maxSize[2000]]" rows="5"  name="remark" >${riskScheme.remark}</textarea>
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
				<div class="clearfix form-actions">
			<div class="col-md-offset-3 col-md-9">
		       <button class="btn btn-primary " value="0" type="button" onclick="riskSchemeUpdate()"><i class="icon-ok bigger-110"></i>保存</button>
            </div>
      </div>
       </form>
				<!-- <div class="form-group">
					   <h4 class="header smaller lighter green">
	                     		      附件
	                       </h4>
						<div id="thelist" class="uploader-list"></div>
						<div id="picker" class="col-xs-2">选择文件</div>
						<button id="ctlBtn" class="btn btn-default">开始上传</button>
						<table id="fileList" style="font-size:13px !important;"></table>
				</div> 
 -->
       
        
     </div>
    </div>
</div>
<div id="filesUpload_page"></div>
<%-- <%@ include file="/common_foot.jsp" %> --%>
<%@ include file="/common_del.jsp" %>
<script src="<%=path %>/plugins/webuploader/js/webuploader.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/crm/filesUpload/fileupv2.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>
<script src="/plugins/plupload/plupload.full.min.js"></script>
<script src="/plugins/plupload/i18n/zh_CN.js"></script>
<script src="<%=path %>/project/replacePro/replacePro.js?v=<%=vardate%>"></script>
<script src="/project/riskResponse/keyProject/fileUp.js"></script>
<%@ include file="/project/riskResponse/keyProject/fileUp.jsp" %>
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

<script type="text/javascript">
	 /* var types = new Array('08','09');
	 for( var i=0; i < types.length; i++){
		 var type = types[i];
		 $.get("/project/loan/getAttachments?entityID=" + $("#riskScheme_ID").val()+"&"+"type="+type, function (data) {
	        $("#attachmentsDIV_"+type).empty();
	        console.log("attachmentsDIV_"+type);
	         if (data.obj) {
	             $.each(data.obj, function (k, v) {
	                 var aHref = ["<div id='" + v.projectFiles_ID + "DIV'><a href='" + v.pathFile + "' target='_blank'>" + v.sourceFileName + "</a>",
	                     '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
	                     "<a href='javascript:void(0)' onclick='$.zjm_loanAttachment.deleteOnePictureFile(this.id,this.name)' name='" + v.pathFile + "' id='" + v.projectFiles_ID + "'>" + '删除' + "</a>",
	                     "<br/><div>"].join('');
	                 $("#attachmentsDIV_"+type).append(aHref);
	             })
	         }
	     })
	 } */
	 
	 
	 $.get("/project/loan/getAttachments?entityID=" + $("#riskScheme_ID").val()+"&"+"type=08", function (data) {
	        $("#attachmentsDIV_08").empty();
	         if (data.obj) {
	             $.each(data.obj, function (k, v) {
	                 var aHref = ["<div id='" + v.projectFiles_ID + "DIV'><a href='" + v.pathFile + "' target='_blank'>" + v.sourceFileName + "</a>",
	                     '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
	                     "<a href='javascript:void(0)' onclick='$.zjm_loanAttachment.deleteOnePictureFile(this.id,this.name)' name='" + v.pathFile + "' id='" + v.projectFiles_ID + "'>" + '删除' + "</a>",
	                     "<br/><div>"].join('');
	                 $("#attachmentsDIV_08").append(aHref);
	             })
	         }
	     })
	     $.get("/project/loan/getAttachments?entityID=" + $("#riskScheme_ID").val()+"&"+"type=09", function (data) {
	        $("#attachmentsDIV_09").empty();
	         if (data.obj) {
	             $.each(data.obj, function (k, v) {
	                 var aHref = ["<div id='" + v.projectFiles_ID + "DIV'><a href='" + v.pathFile + "' target='_blank'>" + v.sourceFileName + "</a>",
	                     '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
	                     "<a href='javascript:void(0)' onclick='$.zjm_loanAttachment.deleteOnePictureFile(this.id,this.name)' name='" + v.pathFile + "' id='" + v.projectFiles_ID + "'>" + '删除' + "</a>",
	                     "<br/><div>"].join('');
	                 $("#attachmentsDIV_09").append(aHref);
	             })
	         }
	     })
</script>
	