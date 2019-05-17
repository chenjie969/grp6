<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/common_timestamp.jsp" %>
<link rel="stylesheet" href="<%=path %>/plugins/viewer/viewer.min.css?v=<%=vardate%>" /> 
<link rel="stylesheet" href="<%=path %>/plugins/webuploader/css/webuploader.css?v=<%=vardate%>" />
<link rel="stylesheet" href="<%=path %>/assets/css/iconfont.css?v=<%=vardate%>" />
<div class="modal fade bs-example-modal-lg" id="awaitingMeetingView" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static"
	data-keyboard="false">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h3 class="modal-title" id="myModalLabel">查看详情</h3>
			</div>
			  <div class="modal-body">
		<form class="form-horizontal" role="form" >
			<input type="hidden" name="riskScheme_ID" value="${riskScheme.riskScheme_ID}">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="meetingRoomID">标题：</label>
				<label class="col-sm-8 grey" >${riskScheme.title}</label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">流程名称：</label>
				<label class="col-sm-8 grey" >${riskScheme.productName}</label>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">审批类型：</label>
				<label class="col-sm-8 grey" >${riskScheme.reviewType}</label>
			</div>
			<c:if test="${riskScheme.reviewType eq '工作进度'}">
				  	<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" >工作进展： </label>
						<label class="col-sm-8 grey">
							 ${riskScheme.workProgress}
	                     </label>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" >需协调事项： </label>
						<label class="col-sm-8 grey">
							 ${riskScheme.needCoordination}
	                     </label>
					</div>
			</c:if>
			<c:if test="${riskScheme.reviewType eq '打击逃废债工作进度'}">
					<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" >工作进展： </label>
							<label class="col-sm-8 grey">
								 ${riskScheme.workProgress}
		                     </label>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" >下一步计划： </label>
							<label class="col-sm-8 grey">
								 ${riskScheme.nextPlan}
		                     </label>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" >涉诉情况： </label>
							<label class="col-sm-8 grey">
								 ${riskScheme.lawsuitInfo}
		                     </label>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" >涉案进展： </label>
							<label class="col-sm-8 grey">
								 ${riskScheme.lawsuitProgress}
		                     </label>
						</div>
			</c:if>	
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">备注：</label>
				<label class="col-sm-8 grey" >${riskScheme.remark}</label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">创建人：</label>
				<label class="col-sm-8 grey" id="createUserName">${riskScheme.createUserName}</label>
			</div>	
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">创建日期：</label>
				<label class="col-sm-8 grey" id ="createDate"><fmt:formatDate value="${riskScheme.createDate}" pattern="yyyy-MM-dd"/></label>
			</div>
			<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1">附件：</label>
					<label class="col-sm-9" id="riskSchemeFile">
		                		
		                		 <c:forEach items="${riskScheme.filesList}" var="filesInfo" varStatus="status">
										<p>
										<c:if test="${filesInfo.extend eq 'jpg' ||(filesInfo.extend eq 'jpeg')||(filesInfo.extend eq 'png') ||(filesInfo.extend eq 'gif') }">
											 <a href="#" class="btn_opfile_viewer_img" data-original="${filesInfo.pathFile}" src="${filesInfo.pathFile}">
					                	</c:if>		
					                			${filesInfo.sourceFileName}
					                     <c:if test="${filesInfo.extend eq 'jpg'}">			
					                	       </a>
										 </c:if>
					                	<c:if test="${filesInfo.extend=='docx' || filesInfo.extend=='doc' || filesInfo.extend=='pdf' || filesInfo.extend=='xlsx' || filesInfo.extend=='xls' || filesInfo.extend=='ppt' || filesInfo.extend=='pptx' || filesInfo.extend=='txt'}">
					                           	&nbsp;&nbsp;
							          	<a class="" href="#" onclick="javascript:window.parent.open('/sys/documentPreview/selectDocumentViewPage?domhref=${filesInfo.pathFile}&domextend=${filesInfo.extend}')"><i class="icon-zoom-in bigger-120 orange"></i></a>
										&nbsp;&nbsp;
										<a class="" href="#" onclick="javascript:window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${filesInfo.sourceFileName}&filePath=${filesInfo.pathFile}')"><i class="icon-download-alt bigger-120 "></i></a>
								          	
							          	</c:if>
							          	<c:if test="${filesInfo.extend=='jpeg' || filesInfo.extend=='png' || filesInfo.extend=='gif' || filesInfo.extend=='jpg'}">
													&nbsp;&nbsp;
													 <a href="#" class="btn_opfile_viewer_img" data-original="${filesInfo.pathFile}" src="${filesInfo.pathFile}"><i class="icon-zoom-in bigger-120 orange"></i></a>
													    <img class="hide" data-original="${filesInfo.pathFile}" src="${filesInfo.pathFile}" alt="${filesInfo.sourceFileName}" title="${filesInfo.sourceFileName}">
													&nbsp;&nbsp;
													<a href="#" onclick="javascript:window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${filesInfo.sourceFileName}&filePath=${filesInfo.pathFile}')">
															<i class="icon-download-alt bigger-120 "></i>
													</a>
							          	</c:if>
							          	</p>
						          	</c:forEach>
						          	<c:if test="${fn:length(riskScheme.filesList)==0}">（空）</c:if>
		                
					</label>
				</div>

		</form>
      </div>
			<div class="modal-footer">
			
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<i class='icon-remove bigger-110'></i>关闭
				</button>
			</div>
		</div>
	</div>
</div>
<script src="<%=path %>/plugins/plupload/plupload.full.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/plupload/i18n/zh_CN.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>
<script>    
$(".btn_opfile_viewer_img").click(function() {
 	var viewer = new Viewer(document.getElementById("riskSchemeFile"), { 
	    url: 'data-original'
	});
	viewer.show();
	$(".viewer-close").click(function(){
		viewer.destroy();
	});
});
</script>