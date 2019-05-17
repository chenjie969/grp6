<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/common_timestamp.jsp"%>

<div class="modal fade bs-example-modal-sm" id="projectSuggestEditPage" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
    <!-- 还款登记页面 -->
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel" ></h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal " role="form" id="projectSuggestEdit_form" >
		    <input type="hidden" id="productInstanceID2" name="productInstanceID" value="">
		    <input type="hidden"  id="taskName2"  name="taskName" value="">
		    <input type="hidden"  id="taskID2"  name="taskID" value="">
		    <input type="hidden"  id="nodeID2"  name="nodeID" value="">
		    <input type="hidden"  id="nodeNames2"  name="nodeNames" value="">
		    <input type="hidden"  id="entityID3"  name="entityID" value="">
		    <input type="hidden"  id=""  name="suggest_ID" value="${suggest.suggest_ID}">
		    <input type="hidden"  id="type2"  name="type" value="">
		    <input type="hidden"  id="entityType2"  name="entityType" value="">
		    <input type="hidden" id="suggestType" value="${type}">
		      <div class="form-group" id="">
				                              
		             <label class="col-sm-offset-1 no-padding" style="text-align:left;">
							<i class="icon-asterisk orange"></i>意见内容：
					</label>
					   <!-- <button type="button" id="btn_selectSuggest" class="btn btn-xs btn-info pull-right" style="margin-right:76px;">选择常用语</button> -->
					<div class="space-6"></div>	
					<%-- <input type="text"  class="col-sm-10 col-sm-offset-1 validate[required,maxSize[2000]]" rows="8" cols="80"  id="suggestContent" name="suggestContent" value="${suggest.suggestContent}"/>
					 --%>
					<textarea class="col-sm-10 col-sm-offset-1 validate[required,maxSize[2000]]"  rows="8" cols="80"  name="suggestContent" id="suggestContent">${suggest.suggestContent}</textarea>
					
					
					<div class="col-sm-10 col-sm-offset-1 no-padding-right" style="text-align:right;">
						<span class="light-grey">限制2000个字符</span>
					</div>
		      </div>
		     <!--  <div>
					   <h4 class="header smaller lighter orange">
                            <i class="icon-paper-clip"></i>
                      		      附件
                        </h4>
						<div id="thelist" class="uploader-list"></div>
						<div id="picker" class="col-xs-2">选择文件</div>
						<button id="ctlBtn" class="btn btn-default">开始上传</button>
						<table id="fileList" style="font-size:13px !important;"></table>
			 </div>   -->
			 
			 <button type="button" name="button" class="btn btn-xs btn-info" id="btn_uploadfiles">
					<i class="icon-upload-alt bigger-110"></i>
					<span class="bigger-110 no-text-shadow">上传附件</span>
			  </button>
			 <table id="fileList" style="font-size:13px !important;"></table>

		</form>
		
		
		
      </div>
      <div class="modal-footer">
        <button type="button" id="" class="btn btn-primary btn_submitUpdate" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="uploadfiles" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static">
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
<%@ include file="/project/suggest/projectSuggest/suggestContentSelect.jsp" %>
<%-- <div class="modal fade" id="selectSuggest" tabindex="0" role="dialog" aria-labelledby="myModalLabel"  data-backdrop="static">
			  <div class="modal-dialog" >
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">选择常用语</h4>
			      </div>
			      <div class="modal-body">
			      <form class="form-horizontal" role="form" id="">
			           <div class="col-md-offset-1">
	                   <table  id="table1" class="table table-hover table-striped" >
	                    <thead>
					 			 <tr >
						         	 <th>选择 </th>
						         	 <th>常用语</th>
					             </tr>
				             </thead>
				             
				             <c:forEach items="${suggestContentList}" var="suggestContent">
					              <tr id="tr11" align="center">
						              <td style="border:1px solid #ddd;">				              		
						              		 <div class="radio">
												<label>
													 <input type="radio"  name=""  id="btn_selectSuggestContent"   class="ace  form-field-radio btn_selectSuggestContent" value="${suggestContent.dicTypeName}" />
												     <span class="lbl"></span>
												</label>
								            </div>
						              </td>
						              <td style="border:1px solid #ddd;">				              		
						              		 ${suggestContent.dicTypeName}
						              </td>
					              </tr>		
				             </c:forEach>
				            
	                   	
			           </table>
			           </div>
			      </form>
			          
			      <form class="form-horizontal" role="form" id="">
						<div class="space-4"></div>
						<div class="form-group">
						     <label class="col-md-2 control-label no-padding-right" for="form-input">借款合同号： </label>
			                 <div class="col-sm-10">
									<textarea class="col-sm-10 limited   validate[maxSize[2000]]" rows="5"  name="jcontractCode" id="jcontractCode" >${applyDetail.jcontractCode}</textarea>							
								    <span class="col-sm-4 light-grey col-sm-push-8">限制输入字数2000个</span>
							 </div>
						</div>
						
					</form>
			      
			      </div>
			      
			    </div>
			  </div>
</div>			 --%>
			
<div id="filesUpload_page" ></div>

<script src="<%=path %>/plugins/plupload/plupload.full.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/plupload/i18n/zh_CN.js?v=<%=vardate%>"></script>
<script src="<%=path%>/project/suggest/projectSuggest/suggestEdit.js?v=<%=vardate%>"></script>


<script>   
$(function() {
		var defParam = {
				"uploadFileList" : "uploadFileList",//待上传的附件列表div ID
				"uploadConsoleList" : "uploadConsoleList",//错误信息提示div ID
				"btn_PickID" : "pickfiles",//选择附件按钮ID
				"btn_UploadID" : "uploadfiles",//上传按钮ID
				"uploadURL" : "/crm/filesUpload/insertOneFilesUpload",//上传的地址 
				"uploadParam" : {
					"fileOneType":"projFiles",//附件表分类
					"fileTwoType":$("#suggestType").val(),//附件上传入口分类
					"fileFlag":"projFiles",//
					"entityID":$("#entityID").val(),
					"taskID":$("#taskID").val(),
					"clientID":""//客户id
				},//上传附加参数
				"fileList" : "fileList",//已上传的附件列表Table ID
				"fileListURL" : "/crm/filesUpload/selectAllProjectFileList",//加载意见附件列表数据地址
				"mimeTypes":[]//限定上传附件类型
		};
		//刷新附件列表
		$.zjm_suggestEdit.initTable(defParam);
		$("#btn_uploadfiles").click(function(){
			$("#uploadfiles").modal({keyboard:true});
			$.zjm_suggestEdit.initUpload(defParam);
			$("#uploadfiles").on("hidden.bs.modal", function (e) {//解除事件绑定
				$.zjm_suggestEdit.initTable(defParam);
				uploader.destroy();
			}); 
		});
		$("#btn_selectSuggest").click(function(){			
				$("#selectSuggest").modal({keyboard:true});
				var zindex = parseInt($("#projectSuggestEditPage").css("z-index"));
				$("#selectSuggest").css("z-index",zindex+50);
				$(".modal-backdrop:eq(1)").css("z-index",zindex+40);
				
				zjm.init();
				$(".btn_selectSuggestContent").click(function(){
					var suggestContent = $(this).attr("value");
					alert(suggestContent);
					//$("#suggestContent").html(suggestContent);
					$("#suggestContent").attr("value","");
					$("#suggestContent").attr("value",suggestContent);
/* 					$("#suggestContent").text(suggestContent); */
					$("#selectSuggest").modal("hide");
				});
				$("#selectSuggest").on("hidden.bs.modal", function (e) {//解除事件绑定
					$(".btn_selectSuggestContent").unbind("click");
				});
			
		});

	});
</script>


<!-- <script type="text/javascript">
$(function () {
	var defParam = {
			"uploadFileList" : "thelist",//待上传的附件列表div ID
			//"uploadConsoleList" : "uploadConsoleList",//错误信息提示div ID
			"btn_PickID" : "picker",//选择附件按钮ID
			"btn_UploadID" : "ctlBtn",//上传按钮ID
			"uploadURL" : "/crm/filesUpload/insertOneFilesUpload",//上传的地址 
			"uploadParam" : {
				"fileOneType":"projFiles",//附件表分类
				"fileTwoType":"04",//附件上传入口分类
				"clientID":"",//客户id
				"projectID":"",//项目id
				"fileFlag":"04",
				"entityID":$("#taskID2").val(),
				"uuid":""//文件uuid
			},//上传附加参数
			"fileList" : "fileList",//已上传的附件列表Table ID
			"fileListURL" : "/crm/filesUpload/selectAllProjectFileList",//加载附件列表数据地址
			"mimeTypes":[
				{title : "文件", extensions : "*",mimeTypes: '*'}
				]//限定上传附件类型
	};
	//刷新附件列表
	$.zjm_upload.initTable(defParam);
	$.zjm_upload.initUpload(defParam);
	
});
</script> -->					