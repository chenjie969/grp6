<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<style>
	table{
		font-size:14px !important;
	}
	table tr td{
		border:1px solid #ddd;
		text-align: center;
	}
	.twoLocation{
		text-align: left;
	}
</style>

<div class="page-header">
	<h4>集团风险管理部审核</h4>
</div>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<h4 class="lighter blue" style="text-align:center;">展期详情</h4>
			<div class="space-16"></div>
			<div class="col-sm-10 col-sm-offset-1">
					<table class="table table-bordered table-strip">
					<col style="background:#f9f9f9;"></col>
					<colgroup>
						<col width="25%">
						<col width="25%">
						<col width="25%">
						<col width="25%">
					</colgroup>
					<tr>
						<td>项目名称</td>
						<td class="twoLocation">${apply.projectName }</td>
						<td bgcolor="#f9f9f9">业务编号</td>
						<td class="twoLocation">${pply.busiCode }</td>
					</tr>
					<tr>
						<td>客户名称</td>
						<td class="twoLocation">${apply.clientName }</td>
						<td bgcolor="#f9f9f9">业务金额</td>
						<td class="twoLocation"><fmt:formatNumber value="${apply.applySum }"></fmt:formatNumber>&nbsp;万元</td>
					</tr>
					<tr>
						<td>展期金额</td>
						<td class="twoLocation"><fmt:formatNumber value="${delay.delaySum }"></fmt:formatNumber>&nbsp;万元</td>
						<td bgcolor="#f9f9f9">展期审批状态</td>
						<td class="twoLocation">${delay.delayState }"></td>
					</tr>
					<tr>
						<td>附件</td>
						<td colspan="3" class="twoLocation">
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
						</td>
					</tr>
					<jsp:include page="/gworkFlow/components/component_sugget_view_import.jsp"></jsp:include>
				</table>
				<div class="space-16 col-sm-12"></div>
			<div class="space-16"></div>
			<div class="col-sm-10 col-sm-offset-1">
			<div class="col-sm-12 space-16"></div>
			<!-- <div class="col-sm-12 clearfix form-actions">
				<div class="col-md-offset-5 col-md-7">
					<button class="btn btn_factPaySave" type="button"><i class="icon-save bigger-110 "></i>保存</button>
			        <button class="btn btn_factViewColse" type="button"><i class="icon-remove bigger-110 "></i>关闭</button>
	      		</div>
	      	</div> -->
			
		</div>
	</div>
</div>
<div id="loanApproval_page"></div>
<script src="/plugins/plupload/plupload.full.min.js"></script>
<script src="/plugins/plupload/i18n/zh_CN.js"></script>
