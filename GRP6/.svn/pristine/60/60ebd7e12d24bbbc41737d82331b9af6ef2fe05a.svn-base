<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<div class="modal fade" id="ostaskSugget" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">填写意见</h4>
			</div>
			<div class="modal-body">
			
				<div class="row">
					<div class="col-xs-12">
						<form class="form-horizontal" role="form" id="projectSuggestAdd_form">
			                 <input type="hidden" id="opsuggest_ID" name="opsuggest_ID" class="" value="${osSuggest.opsuggest_ID}">
			                 <input type="hidden" id="flowID" class="" name="flowID" value="${osSuggest.flowID}">
			                 <input type="hidden" id="stepID" class="" name="stepID" value="${osSuggest.stepID}">
			                 <input type="hidden" id="projectID" class="" name="projectID"  value="${osSuggest.projectID}">
			                 <input type="hidden" id="historyID" class="" name="historyID" value="${osSuggest.historyID}">
							 <h4 class="header smaller lighter blue">
		                           <i class="icon-asterisk orange"></i>
		                           <!-- 意见区 -->${osSuggest.stepName}
		                     </h4> 
								<textarea class="col-sm-12 validate[required,maxSize[2000]]" rows="8" cols="80" placeholder="（空）" name="suggestContent">${osSuggest.suggestContent}</textarea>
								<div class="col-sm-12 no-padding-right" style="text-align:right;">
									<span class="light-grey">限制2000个字符</span>
								</div>
								<button type="button" name="button" class="btn btn-minier btn-warning pull-right" id="btn_uploadfiles">
									<i class="icon-edit bigger-110"></i>
									<span class="bigger-110 no-text-shadow">添加</span>
								</button>
								<table id="fileList" style="font-size:13px !important;"></table>
						</form> 
						<div class="space-20"></div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary btn_doTask_submit">
					<i class='icon-ok bigger-110'></i>确认
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<i class='icon-remove bigger-110'></i>取消
				</button>
			</div>
		</div>
	</div>
</div>


			<div class="modal fade" id="uploadfiles" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
			  <div class="modal-dialog" >
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">附件上传</h4>
			      </div>
			      <div class="modal-body">
			      		<form class="form-horizontal" role="form" id="add_form">
						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 待上传文件列表 </label>
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
			
			
			<div id="filesUpload_page" ></div>
			<!-- <div class="modal fade" id="delmodule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
			  <div class="modal-dialog modal-sm" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">删除附件</h4>
			      </div>
			      <div class="modal-body">
			      		<div class="alert bigger-110">
			      			<i class='icon-warning-sign red bigger-130'></i>
							是否删除此附件？
						</div>
			      </div>
			      <div class="modal-footer">
			        
			        <button type="button" class="btn btn-primary btn_submit" ><i class='icon-ok bigger-110'></i>确定</button>
			        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
			      </div>
			    </div>
			  </div>
			</div> -->
<script src="<%=path %>/plugins/plupload/plupload.full.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/plupload/i18n/zh_CN.js?v=<%=vardate%>"></script>
<script src="<%=path%>/gworkFlow/components/component_sugget_edit.js?v=<%=vardate%>"></script>
<script>     
 
	$(function() {
		$("#ostaskSugget").modal({
			keyboard : true
		});
		zjm.init();
		$(".btn_doTask_submit").click(function() {
			
			var queryContainer_form = $("#projectSuggestAdd_form");
			$.ajax({
				type : 'POST',
				url : '/gworkFlow/flowBuild/updateOneOsGworkflowProjsuggest',
				data : JSON.stringify(queryContainer_form.serializeJson()),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					if (data.obj == 1) {
						$("#ostaskSugget").modal("hide");
						window.parent.closeMenu("osworkflow"+$(".os_projectID").val());
					} else {
						alert("意见保存失败！");
						tool.undisabled(".btn_submit");
					}
				}
			});
		});
		
		
		
		
		
		
		
		
		var defParam = {
				"uploadFileList" : "uploadFileList",//待上传的附件列表div ID
				"uploadConsoleList" : "uploadConsoleList",//错误信息提示div ID
				"btn_PickID" : "pickfiles",//选择附件按钮ID
				"btn_UploadID" : "uploadfiles",//上传按钮ID
				"uploadURL" : "/crm/filesUpload/insertOneFilesUpload",//上传的地址 
				"uploadParam" : {
					"fileOneType":"osFiles",//附件表分类
					"fileTwoType":"01",//附件上传入口分类
					"clientID":"",//客户id
					"projectID":$("#projectID").val(),//项目id
					"osFlowID":$("#flowID").val(),//流程id
					"osStepID":$("#stepID").val(),//步骤id
					"osHistoryID":$("#historyID").val()//历史步骤id
				},//上传附加参数
				"fileList" : "fileList",//已上传的附件列表Table ID
				"fileListURL" : "/crm/filesUpload/selectAllOsGworkflowFilesPageTables",//加载附件列表数据地址
				"mimeTypes":[]//限定上传附件类型
		};
		//刷新附件列表
		$.zjm_upload_os.initTable(defParam);
		$("#btn_uploadfiles").click(function(){
			$("#uploadfiles").modal({keyboard:true});
			$.zjm_upload_os.initUpload(defParam);
			$("#uploadfiles").on("hidden.bs.modal", function (e) {//解除事件绑定
				$.zjm_upload_os.initTable(defParam);
				uploader.destroy();
			}); 
		});

	});
</script>