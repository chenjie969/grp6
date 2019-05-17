<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%-- <%@ include file="/common_head.jsp" %> --%>
<link rel="stylesheet" href="<%=path %>/plugins/viewer/viewer.min.css?v=<%=vardate%>" /> 
<link rel="stylesheet" href="<%=path %>/plugins/webuploader/css/webuploader.css?v=<%=vardate%>" />

	<div class="page-content">
		<input type="hidden" name="apply_ID" id="apply_ID" value="${apply.apply_ID }"><%-- ${apply.apply_ID } --%>
		<div class="page-header">
			<h4>项目结案评价</h4>
		</div>
		<div class="row">
			<div class="col-xs-12">
					<div class="form-group">
						 <h4 class="header smaller lighter blue">
	                           <!-- 意见区 -->项目结案评价:
	                     </h4> 
	                      <c:if test="${'edit' eq urlParam.type}">
		                     <div class="col-sm-12" id="projectJudgetEditPage">
								<textarea class="col-sm-10 validate[maxSize[2000]]" rows="8" cols="80" name="projectJudge" id="projectJudge">${apply.projectJudge=="null"?"(空)":apply.projectJudge}</textarea>
								<div class="col-sm-10 no-padding-right" style="text-align:right;">
									<span class="light-grey">限制2000个字符</span>
								</div>
							   </div>
						  </c:if>
						    <c:if test="${'view' eq urlParam.type }">
							  <div class="col-sm-12" id="projectJudgetViewPage">
								 ${apply.projectJudge=="null"?"(空)":apply.projectJudge}
							  </div>
							</c:if>
					</div>
					<div class="col-sm-12 space-20"></div>
					<div class="form-group" >
						   <h4 class="header smaller lighter green">
	                      		      附件
	                        </h4>
							<div id="thelist" class="uploader-list"></div>
							 <c:if test="${'view' ne urlParam.type }">
							<div id="picker" class="col-xs-1">选择文件</div>
							<button id="ctlBtn" class="btn btn-default">上传</button>
							</c:if>
							<table id="fileList" style="font-size:13px !important;"></table>
					</div>  
					<div class="space-20"></div>
					 <div class="clearfix form-actions">
						<div class="col-md-offset-3 col-md-9">
						 <c:if test="${'view' ne urlParam.type }">
					     <button type="button" id="" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
                         <button type="button" class="btn btn-default" id="btn_close" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
                         </c:if>
			            </div>
					</div> 
			</div>
		</div>
	</div>
<div id="filesUpload_page"></div>
<script src="<%=path %>/plugins/webuploader/js/webuploader.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/project/endPro/fileupv.js?v=<%=vardate%>"></script>
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
				"fileOneType":"projFiles",//附件表分类
				"fileTwoType":"06",//附件上传入口分类
				"clientID":"",//客户id
				"projectID":"",//项目id
				"fileFlag":"06",
				"entityID":$("#apply_ID").val(),
				"uuid":""//文件uuid
			},//上传附加参数
			"fileList" : "fileList",//已上传的附件列表Table ID
			"fileListURL" : "/crm/filesUpload/selectAllProjectFileList",//加载附件列表数据地址
			"mimeTypes":[
				{title : "", extensions : "*"},
				]//限定上传附件类型
	};
	
	//刷新附件列表
	$.zjm_upload.initTable(defParam);
	$.zjm_upload.initUpload(defParam);
	$(".btn_submit").click(function(){
		$.ajax({
			type:'POST',
			url:'/project/apply/updateApplySetProjectJudge',
			data:{"apply_ID":$("#apply_ID").val(),"projectJudge":$("#projectJudge").val()},
			dataType:'json',
			success:function(data) {
			if(data){
				window.location.reload();
			}else{
				alert("保存失败！");
				tool.undisabled(".btn_submit");
			}
       	 }
		});
	});
	
	
	//关闭页面
	$("#btn_close").click(function(){
		window.parent.closeMenu('项目完结评价'+$("#apply_ID").val());
	});
	
});
</script>

	