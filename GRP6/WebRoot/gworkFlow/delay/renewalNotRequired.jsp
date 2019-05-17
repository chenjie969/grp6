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
	.table th, .table td {
		vertical-align: middle!important;
		}
</style>

<div class="page-header">
	<h4>企业续保申请</h4>
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
						<td class="twoLocation">${apply.busiCode }</td>
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
						<td class="twoLocation">${delay.delayState }</td>
					</tr>
					<jsp:include page="/gworkFlow/components/component_sugget_view_import.jsp"></jsp:include>
				</table>
				<div class="widget-header widget-header-flat">
					<a href="javascript:void(0)" style="margin-right:10px;line-height:37px;display:block;text-decoration:none;"  class="pull-right btn_addIntentionLetter">
									<i class="icon-edit bigger-110 orange" ></i>
									<span class="bigger-110 no-text-shadow orange">生成委托担保申请书</span>
					</a>
					<input type="hidden" value="${flowID }">
					<input type="hidden" id="hidden_applyID" value="${apply_ID }">
				</div>
			<div class="space-16 col-sm-12"></div>
			<div class="space-16"></div>
			<div class="col-sm-10 col-sm-offset-1">
			<div class="col-sm-12 space-16"></div>
			
<div id="optGuaranty_page"></div>
<div id="clientList_page"></div>
<input type="hidden" value="${apply.apply_ID }" name="apply_ID" id="apply_ID">
			
			<!-- <div class="col-sm-12 clearfix form-actions">
				<div class="col-md-offset-5 col-md-7">
					<button class="btn btn_factPaySave" type="button"><i class="icon-save bigger-110 "></i>保存</button>
			        <button class="btn btn_factViewColse" type="button"><i class="icon-remove bigger-110 "></i>关闭</button>
	      		</div>
	      	</div> -->
			<td>附件</td>
						<td colspan="3" class="twoLocation">
							<c:forEach items="${fileList }" var="projectfiles" varStatus="status11">
								<c:choose>
										<c:when test="${projectfiles.extend eq 'docx' || projectfiles.extend eq 'doc' || projectfiles.extend eq 'pdf' || projectfiles.extend eq 'xlsx' || projectfiles.extend eq 'xls' || projectfiles.extend eq 'ppt' || projectfiles.extend eq 'pptx' }">
											<a href="javascript:void(0)" onclick="window.parent.open('/sys/documentPreview/selectDocumentViewPage?domhref=${projectfiles.pathFile}&domextend=${projectfiles.extend }')">${projectfiles.sourceFileName }</a>
											&nbsp;&nbsp;<a title="下载" onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)"><i class="icon-download-alt bigger-120 "></i></a> 
											<c:if test="${urlParam.type eq 'edit' }">
												&nbsp;&nbsp;<a title='删除附件' name="${projectfiles.projectFiles_ID }" onclick="$.zjm_planLoanAndPay.delFiles(this.name);" href='javascript:void(0)'><i class="icon-trash bigger-120"></i></a>
											</c:if>							
										</c:when>
										<c:when test="${projectfiles.extend == 'jpeg' || projectfiles.extend == 'png' || projectfiles.extend == 'gif' || projectfiles.extend == 'jpg' }">
										
											<a href="#" class="btn_opfile_viewer_img" data-original="${projectfiles.pathFile}" src="${projectfiles.pathFile}">${projectfiles.sourceFileName }</a>
											 <img class="hide" data-original="${projectfiles.pathFile}" src="${projectfiles.pathFile}" alt="${projectfiles.sourceFileName}" title="${projectfiles.sourceFileName}">
											 &nbsp;&nbsp;
											<a title="下载" onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)">
												<i class="icon-download-alt bigger-120 "></i>
											</a> 
											<c:if test="${urlParam.type eq 'edit' }">
												&nbsp;&nbsp;<a title='删除附件' name="${projectfiles.projectFiles_ID }" onclick="$.zjm_planLoanAndPay.delFiles(this.name);" href='javascript:void(0)'><i class="icon-trash bigger-120"></i></a>
											</c:if>
										</c:when>
										<c:otherwise>
											<a onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)">${projectfiles.sourceFileName }</a> 
											<c:if test="${urlParam.type eq 'edit' }">
												&nbsp;&nbsp;<a title='删除附件' name="${projectfiles.projectFiles_ID }" onclick="$.zjm_planLoanAndPay.delFiles(this.name);" href='javascript:void(0)'><i class="icon-trash bigger-120"></i></a>
											</c:if>
										</c:otherwise>
									</c:choose>
								<br>
							</c:forEach>
						</td>
		</div>
		<div class="page-content">
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
							<div class="page-header">
								<h5 style="display: inline;">项目编号：<span class="grey">${apply.busiCode }</span></h5>
								<h5 style="display: inline;margin-left:2em;">项目名称：<span class="grey">${apply.projectName }</span></h5>
							</div>
						<c:if test="${luoshi != 'luoshi' }">
							<button type="button" id="btn_addOptGuaranty" class="btn btn-sm btn-info" data-toggle="modal" data-target="#edit">新增</button>
							<!-- <button class="btn btn-sm btn-info"  id="btn_deleteOptGuaranty" data-toggle="modal" data-target="#delete">删除所选</button> -->
						</c:if>	
						<c:if test="${luoshi eq 'luoshi'}">
	                         <button class="btn btn-sm btn-info" id="btn_realizeOptGuaranty" data-toggle="modal" data-target="#agree">落实</button>
						</c:if>
							<div class="page-header">
								<table id="optManager_table123" style="font-size:13px !important;" border="1" width="800">
									<tr>
										<td>保证方式</td>
										<td>反担保物类型</td>
										<td>权属人</td>
										<td>评估价值</td>
										<td>抵（质）押率</td>
										<td>抵（质）押价值</td>
									</tr>
								<c:forEach items="${guaranties }" var="guaranties" varStatus="status1">
									<tr>
										<td>${guaranties.guarantyTypeName}</td>
										<td>${guaranties.optTypeName}</td>
										<td>${guaranties.ownerName}</td>
										<td>${guaranties.assessValue}</td>
										<td>${guaranties.coverageRatio}</td>
										<td>${guaranties.optValue}</td>
									</tr>
								</c:forEach>
								</table>  
	                        </div>
					<!-- PAGE CONTENT ENDS -->
				</div><!-- /.col -->
			</div><!-- /.row -->
		</div><!-- /.page-content -->
	</div>
</div>
<!-- <div id="loanApproval_page"></div> -->
<div id="page_intentionLetter"></div>
<%@ include file="/common_message.jsp" %>
<%@ include file="/project/opt/optManager/failDel.jsp" %>

<script src="<%=path %>/project/opt/optManager/optManager.js?v=<%=vardate%>"></script>
<script src="/plugins/plupload/plupload.full.min.js"></script>
<script src="/plugins/plupload/i18n/zh_CN.js"></script>
<script src="/gworkFlow/delay/uploadFile.js"></script>
