<!-- 续保续贷任务事项 - 上传放款凭证、放款通知-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>

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
table {
	font-size: 13px;
	border: 1px solid #ddd;
}

table tr th {
	border: 1px solid #ddd;
	text-align: center;
}
;
</style>

<div class="page-content" style="padding-bottom: 100px;">
	<div class="page-header">
		<h4 style="text-align: center;">上传放款凭证、放款通知</h4>
	</div>
	<div class="page-content">
		<input type="hidden" value="${apply.apply_ID }" id="apply_ID"name="apply_ID">
		<input type="hidden" value="${type }" name="type" id="type">
		<input type="hidden" value="${fileType}" name = "fileType" id="fileType">
		<div class="col-xs-12">

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
				经办部门：<span class="grey">${apply.departName}</span>
			</h5>
		</div>
		<div class="col-xs-12">
			<h4 class="header smaller lighter blue">相关附件</h4>
			<div class="col-sm-12" id="ulPictureFile">
				<table class="table table-bordered table-strip">
					<col style="background: #f9f9f9;"></col>
					<colgroup>
						<col width="25%">
						<col width="25%">
						<col width="25%">
						<col width="25%">
					</colgroup>
					<tr title="请上传放款凭证、放款通知">
						<td class="twoLocation" colspan="4">
							<div id="attachmentsDIV" class="">
								<c:forEach items="${files }" var="projectfiles"
									varStatus="status">
									<div id="${projectfiles.projectFiles_ID }DIV">
										${status.index+1 }、
										<c:choose>
											<c:when
												test="${projectfiles.extend eq 'docx' || projectfiles.extend eq 'doc' || projectfiles.extend eq 'pdf' || projectfiles.extend eq 'xlsx' || projectfiles.extend eq 'xls' || projectfiles.extend eq 'ppt' || projectfiles.extend eq 'pptx' }">
												<a href="javascript:void(0)"
													onclick="window.parent.open('/sys/documentPreview/selectDocumentViewPage?domhref=${projectfiles.pathFile}&domextend=${projectfiles.extend }')">${projectfiles.sourceFileName }</a>
										&nbsp;&nbsp;&nbsp;&nbsp;<a
													onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')"
													href="javascript:void(0)">下载</a>
												<c:if test="${type eq 'edit'}">&nbsp;&nbsp;&nbsp;&nbsp;<a
														title='删除附件' name="${projectfiles.projectFiles_ID }"
														onclick="$.zjm_planLoanAndPay.delFiles(this.name);"
														href='javascript:void(0)'>删除</a>
												</c:if>

											</c:when>
											<c:when
												test="${projectfiles.extend == 'jpeg' || projectfiles.extend == 'png' || projectfiles.extend == 'gif' || projectfiles.extend == 'jpg' }">
												<a
													onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')"
													href="javascript:void(0)">${projectfiles.sourceFileName }</a>
												<c:if test="${type eq 'edit'}">&nbsp;&nbsp;&nbsp;&nbsp;<a
														title='删除附件' name="${projectfiles.projectFiles_ID }"
														onclick="$.zjm_finishFiles.deleteOnePictureFile(this.name);"
														href='javascript:void(0)'>删除</a>
												</c:if>
											</c:when>
											<c:otherwise>
												<a
													onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')"
													href="javascript:void(0)">${projectfiles.sourceFileName }</a>
												<c:if test="${type eq 'edit'}">&nbsp;&nbsp;&nbsp;&nbsp;
										
											<a title='删除附件' name="${projectfiles.projectFiles_ID }"
														onclick="$.zjm_finishFiles.deleteOnePictureFile(this.name);"
														href='javascript:void(0)'>删除</a>
												</c:if>
											</c:otherwise>
										</c:choose>
										<br>
									</div>
								</c:forEach>
							</div> <c:if test="${type eq 'edit'}">
								<button class="btn btn-sm btn-info" type="button" name="button"
									id="${apply.apply_ID }"
									onclick="$.zjm_renewalFiles.filesUpdate(this.id)">上传</button>
							</c:if>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<!-- <div class="col-sm-12 space-16"></div>
		<div class="col-sm-12 clearfix form-actions">
			<div class="col-md-offset-5 col-md-7">
				<button class="btn btn_close" type="button">
					<i class="icon-remove bigger-110 "></i>关闭当前页
				</button>
			</div>
		</div>
		<div class="col-sm-12 space-16"></div> -->
	</div>

</div>
<!-- /.page-content -->
<!--end页面内容  -->

<div id="renewal_page"></div>
<script
	src="<%=path%>/plugins/plupload/plupload.full.min.js?v=<%=vardate%>"></script>
<script src="<%=path%>/plugins/plupload/i18n/zh_CN.js?v=<%=vardate%>"></script>
<script src="<%=path%>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>

<script src="<%=path%>/project/renewal/renewal.js"></script>
<script src="<%=path%>/project/renewal/renewalFiles.js"></script>
<%@ include file="/project/renewal/renewalFiles.jsp"%>