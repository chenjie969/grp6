<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<%@ include file="/common_head.jsp" %>
<link rel="stylesheet"
	href="<%=path%>/plugins/viewer/viewer.min.css?v=<%=vardate%>" />
<link rel="stylesheet"
	href="<%=path%>/plugins/webuploader/css/webuploader.css?v=<%=vardate%>" />
<link rel="stylesheet"
	href="<%=path%>/assets/css/iconfont.css?v=<%=vardate%>" />
<link rel="stylesheet"
	href="<%=path%>/plugins/viewer/viewer.min.css?v=<%=vardate%>" />
<script src="<%=path%>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>
<style>
	table .table_busiLimit{
		font-size:13px;
		border:1px solid #ddd;
		table-layout:fixed
	}
	table .table_busiLimit tr,th,td{
		border:1px solid #ddd;
		text-align: center;
		vertical-align:middle
	}
	
</style>
	<div id="divTwo">	<!-- divTwo 开始-->
			<div class="page-header">
				<h5>催告函</h5>
			</div>
				<form class="form-horizontal" role="form" id="projectUrgeLetterPage_form">
	                          <div class="form-group col-sm-12">
	                               <input type="hidden"  id="apply_ID" name="apply_ID" value="${apply.apply_ID }">
	                               <input type="hidden"  id="project_ID" name="project_ID" value="${project.project_ID }">
	                           </div>
	                           <div class="form-group col-sm-12" >
	                             	<div class="col-sm-6" >
	                               		<label style="margin-top:-20px;"><i class="icon-asterisk orange"></i>是否有催告函： </label>
	                                </div>
	                                  <div class="radio col-sm-6">
	                                       <label style="margin-top:-55px;">
	                                           <input type="radio" name="isUrgeLetter" value="1" class="ace" checked="checked">
	                                           <span class="lbl">是</span>
	                                       </label>
	                                       <label style="margin-top:-55px;">
	                                           <input type="radio" name="isUrgeLetter" value="0" class="ace">
	                                           <span class="lbl">否</span>
	                                       </label>
	                                   </div>
	                           </div>
	              </form>
	              <h5 style="line-height: 26px;"class="col-sm-6">催告函</<h5>
	              <div id="attachmentsDIV" class=""></div>
						<!-- <td colspan="3" class="twoLocation"> -->
							<c:forEach items="${projectfiles }" var="projectfiles" varStatus="status">
								${status.index+1 }、
								<c:choose>
									<c:when test="${projectfiles.extend eq 'docx' || projectfiles.extend eq 'doc' || projectfiles.extend eq 'pdf' || projectfiles.extend eq 'xlsx' || projectfiles.extend eq 'xls' || projectfiles.extend eq 'ppt' || projectfiles.extend eq 'pptx' }">
										<a href="javascript:void(0)" onclick="window.parent.open('/sys/documentPreview/selectDocumentViewPage?domhref=${projectfiles.pathFile}&domextend=${projectfiles.extend }')">${projectfiles.sourceFileName }</a>
										&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)">下载</a> 
														
									</c:when>
									<c:when test="${projectfiles.extend == 'jpeg' || projectfiles.extend == 'png' || projectfiles.extend == 'gif' || projectfiles.extend == 'jpg' }">
										<a onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)">${projectfiles.sourceFileName }</a> 
										
									</c:when>
									<c:otherwise>
										<a onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)">${projectfiles.sourceFileName }</a> 
										
									</c:otherwise>
								</c:choose>
								<br>
							</c:forEach>
					</div>
	              <button class="btn btn-sm btn-info" type="button" name="button" id="${apply.apply_ID }" onclick="$.zjm_projectUrgeLetter.filesUpdate(this.id)">上传</button>
	        <div class="clearfix form-actions">
	         
			<div class="col-md-offset-3 col-md-9">
		       <button class="btn btn-primary btn_projectUrgeLetterAdd" type="button" value="1" ><i class="icon-ok bigger-110"></i>保存</button>
		        &nbsp; &nbsp; &nbsp;
		      <!--  <button class="btn btn-primary btn_agreeAdd" type="button" value="1" ><i class="icon-ok bigger-110"></i>同意立项</button>
		        &nbsp; &nbsp; &nbsp; -->
		       <button class="btn btn_closeprojectUrgeLetterAdd" type="button"><i class="icon-remove bigger-110 "></i>关闭</button>
      		</div>
      </div>
		</div>
		
<div id="loanApproval_page"></div>
<!-- <div class="modal fade" id="uploadfiles" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
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
</div> -->
<%@ include file="/common_foot.jsp" %>
<script
	src="<%=path%>/plugins/plupload/plupload.full.min.js?v=<%=vardate%>"></script>
<script src="<%=path%>/plugins/plupload/i18n/zh_CN.js?v=<%=vardate%>"></script>
<script src="<%=path%>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>
<%@ include file="/project/renewal/renewalFiles.jsp"%>
<script src="/project/apply/projectUrgeLetterPage.js"></script> 
	
	