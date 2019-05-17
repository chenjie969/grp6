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
	<h4>生成委托担保书</h4>
</div>
<div class="page-content">
 <h4 class="header smaller lighter blue">
						项目信息
				</h4>
					<h5 style="line-height: 26px;"class="col-sm-6">
						项目编号：<span class="grey">${apply.busiCode}</span>
					</h5>
					<h5  style="line-height: 26px;"class="col-sm-6">
						项目名称：<span class="grey">${apply.projectName}</span>
					</h5>
					<h5 style="line-height: 26px;"class="col-sm-6">
						客户名称：<span class="grey">${apply.clientName}</span>
					</h5>
					<h5 style="line-height: 26px;"class="col-sm-6">
						业务品种：<span class="grey">${apply.busiTypeNameList}</span>
					</h5>
					<h5  style="line-height: 26px;"class="col-sm-12">
						申请金额：<span class="grey">
						<fmt:formatNumber value="${apply.applySum}" pattern="###,###.######"> </fmt:formatNumber>
						 &nbsp;万元</span>
					</h5>
					<!-- <h5 style="line-height: 26px;"class="col-sm-6">
					    期限：<span class="grey"></span>
					</h5> -->
					<h5 style="line-height: 26px;"class="col-sm-6">
						合作机构：<span class="grey">${apply.bankNameList}</span>
					</h5>
					<h5  style="line-height: 26px;"class="col-sm-6">
						项目来源：<span class="grey">${apply.projectSourceName}</span>
					</h5>
					<h5  style="line-height: 26px;"class="col-sm-6">
						A角：<span class="grey">${apply.amanName}</span>
					</h5>
					<h5  style="line-height: 26px;"class="col-sm-6">
						B角：<span class="grey">${apply.bmanName}</span>
					</h5>
					<h5  style="line-height: 26px;"class="col-sm-6">
						风控评审人：<span class="grey">${apply.reviewManName}</span>
					</h5>
					<h5  style="line-height: 26px;"class="col-sm-6">
						经办部门：<span class="grey">${apply.departName}</span>
					</h5>
			<%-- <c:if test="${suggest.entityType eq '03'}"><!-- 风险处置项目信息 -->
					<h5 style="line-height: 26px;"class="col-sm-6">
						标题：<span class="grey">${riskScheme.title}</span>
					</h5>
			</c:if> --%>
	<div class="row">
		<div class="col-xs-12">
				<div class="widget-header widget-header-flat">
					<a href="javascript:void(0)" style="margin-right:10px;line-height:37px;display:block;text-decoration:none;"  class="pull-right btn_addIntentionLetter">
									<i class="icon-edit bigger-110 orange" ></i>
									<span class="bigger-110 no-text-shadow orange">生成委托担保申请书</span>
					</a>
					<input type="hidden" id="hidden_applyID" value="${apply.apply_ID }">
				</div>
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
												&nbsp;&nbsp;<a title='删除附件2' name="${projectfiles.projectFiles_ID }" onclick="$.zjm_singleLoanReview.delFiles(this.name);" href='javascript:void(0)'><i class="icon-trash bigger-120"></i></a>
											</c:if>
										</c:when>
										<c:otherwise>
											<a onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)">${projectfiles.sourceFileName }</a> 
											<c:if test="${urlParam.type eq 'edit' }">
												&nbsp;&nbsp;<a title='删除附件3' name="${projectfiles.projectFiles_ID }" onclick="$.zjm_singleLoanReview.delFiles(this.name);" href='javascript:void(0)'><i class="icon-trash bigger-120"></i></a>
											</c:if>
										</c:otherwise>
									</c:choose>
								<br>
							</c:forEach>
						</td>
			
		</div>
	</div>
</div>
<div id="loanApproval_page"></div>
<div id="page_intentionLetter"></div>
<script src="/plugins/plupload/plupload.full.min.js"></script>
<script src="/plugins/plupload/i18n/zh_CN.js"></script>
<script src="/project/renewal/uploadFile.js"></script>
