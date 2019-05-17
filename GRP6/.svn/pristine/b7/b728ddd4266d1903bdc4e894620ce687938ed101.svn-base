<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<div class="page-content" style="padding-bottom:100px;">
	<div class="page-header" >
		<h4 style="text-align: center;">档案移交</h4>
	</div>
      <div class="row">
		<div class="col-xs-12">
			<!-- 业务ID-->
			<input type="hidden" id="apply_ID" class="" name=""
				value="${urlParam.entityID}"> <input type="hidden" id="type"
				class="" name="" value="${urlParam.type}"> <input
				type="hidden" id="operationType0" class="" name=""
				value="${operationType}">

			<h4 class="header smaller lighter blue">项目信息</h4>
			<h5 style="line-height: 26px;" class="col-sm-6">
				项目编号：<span class="grey">${apply.busiCode}</span>
			</h5>
			<h5 style="line-height: 26px;" class="col-sm-6">
				项目名称：<span class="grey">${apply.projectName}</span>
			</h5>
			<h5 style="line-height: 26px;" class="col-sm-6">
				客户名称：<span class="grey">${apply.clientName}</span>
			</h5>
			<h5 style="line-height: 26px;" class="col-sm-6">
				业务品种：<span class="grey">${apply.busiTypeNameList}</span>
			</h5>
			<h5 style="line-height: 26px;" class="col-sm-12">
				申请金额：<span class="grey"> <fmt:formatNumber
						value="${apply.applySum}" pattern="###,###.######">
					</fmt:formatNumber> &nbsp;万元
				</span>
			</h5>
			<h5 style="line-height: 26px;" class="col-sm-6">
				合作机构：<span class="grey">${apply.bankNameList}</span>
			</h5>
			<h5 style="line-height: 26px;" class="col-sm-6">
				项目来源：<span class="grey">${apply.projectSourceName}</span>
			</h5>
			<h5 style="line-height: 26px;" class="col-sm-6">
				A角：<span class="grey">${apply.amanName}</span>
			</h5>
			<h5 style="line-height: 26px;" class="col-sm-6">
				B角：<span class="grey">${apply.bmanName}</span>
			</h5>
			<h5 style="line-height: 26px;" class="col-sm-6">
				风控评审人：<span class="grey">${apply.reviewManName}</span>
			</h5>
			<h5 style="line-height: 26px;" class="col-sm-6">
				经办部门：<span class="grey">${apply.departName}</span>
			</h5>
			<div class="space-16 col-sm-12"></div>
			<h4 class="header smaller lighter blue">所有附件</h4>
			<!-- <div class="row">
                     <div class="col-sm-12">
						<div class="page-header">
							<button type="button" class="btn btn-sm btn-info" id="btn_returnArcMoveRecAdd">新增移交记录</button>
						</div>
                     </div>
                     <div class="col-sm-12">
						<div class="table-responsive">
							<table id="arcMoveRec_table" style="font-size:13px !important;"></table>  
                        </div>
                     </div>
				</div> -->
			<div class="row">
				<div id="attachmentsDIV" class="">
					<c:forEach items="${files }" var="projectfiles" varStatus="status">
						<div id="${projectfiles.projectFiles_ID }DIV">
							${status.index+1 }、
							<c:choose>
								<c:when
									test="${projectfiles.extend eq 'docx' || projectfiles.extend eq 'doc' || projectfiles.extend eq 'pdf' || projectfiles.extend eq 'xlsx' || projectfiles.extend eq 'xls' || projectfiles.extend eq 'ppt' || projectfiles.extend eq 'pptx' }">
									<a href="javascript:void(0)"
										onclick="window.parent.open('/sys/documentPreview/selectDocumentViewPage?domhref=${projectfiles.pathFile}&domextend=${projectfiles.extend }')">${projectfiles.sourceFileName }</a>
										&nbsp;&nbsp;&nbsp;&nbsp;<a
										onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')"
										href="javascript:void(0)">下载

								</c:when>
								<c:when
									test="${projectfiles.extend == 'jpeg' || projectfiles.extend == 'png' || projectfiles.extend == 'gif' || projectfiles.extend == 'jpg' }">
									<a
										onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')"
										href="javascript:void(0)">${projectfiles.sourceFileName }</a> 
										&nbsp;&nbsp;&nbsp;&nbsp;
								</c:when>
								<c:otherwise>
									<a
										onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')"
										href="javascript:void(0)">${projectfiles.sourceFileName }</a> 
										&nbsp;&nbsp;&nbsp;&nbsp;
								</c:otherwise>
							</c:choose>
							<br>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div><!-- /.page-content --><!--end页面内容  -->
		
<div id="arMoveRec_page" ></div>
<div id="arcMoveDetail_page"></div>
<%@ include file="/common_del.jsp" %>
<script src="<%=path %>/project/arcMove/arcMoveRec.js?v=<%=vardate%>"></script>
