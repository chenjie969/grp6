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
		/* text-align: center; */
	}
	.oneLocation{
		text-align: center;
	}
	.twoLocation{
		text-align: left;
	}
</style>

<div class="page-header">
	<h4><span>生成业务解除通知单</span></h4>
</div>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<h4 class="lighter blue" style="text-align:center;">
				<span>项目信息</span>
			</h4>
			<div class="space-16"></div>
			<div class="col-sm-10 col-sm-offset-1">
			<form class="form-horizontal row" role="form" id="inspectSave_form">
				<input type="hidden" id="apply_ID" name="applyId" value="${finish.applyId }">
				<input type="hidden" id="finish_ID" name="finishId" value="${finish.finishId }">
				<input type="hidden" id="flowID" value="${flowID }">
				<table class="table table-bordered table-strip">
					<col style="background:#f9f9f9;"></col>
					<colgroup>
						<col width="25%">
						<col width="25%">
						<col width="25%">
						<col width="25%">
					</colgroup>
					<tr>
						<td class="oneLocation" bgcolor="#f9f9f9">项目名称</td>
						<td class="twoLocation">${project.projectName}</td>
						<td class="oneLocation">项目编号</td>
						<td class="twoLocation">${project.projectCode}</td>
					</tr>
					<tr>
						<td class="oneLocation">客户名称</td>
						<td class="twoLocation">${apply.clientName }</td>
						<td class="oneLocation" bgcolor="#f9f9f9">业务品种</td>
						<td class="twoLocation">${project.busiTypeName}</td>
					</tr>
					<tr>
						<td class="oneLocation">项目金额</td>
						<td class="twoLocation">${project.loadSum}&nbsp;万元</td>
						<td class="oneLocation" bgcolor="#f9f9f9">期限</td>
						<td class="twoLocation">
						 ${project.periodMonth}&nbsp;个月&nbsp;${project.periodDay}&nbsp;天
						</td>
					</tr>
					<tr>
						<td class="oneLocation">资金方名称</td>
						<td class="twoLocation">${apply.fundName}</td>
						<td class="oneLocation" bgcolor="#f9f9f9">完结解保状态</td>
						<td class="twoLocation">
						 ${finish.finishstate}
						</td>
					</tr>
					<tr>
						<td class="oneLocation">保证金</td>
						<td class="twoLocation">${empty finish.margin? 0: finish.margin}&nbsp;&nbsp;万元</td>
						
						<td class="oneLocation" >保证金用途</td>
						<td class="twoLocation">${empty finish.remark? '': finish.remark}
						</td>
					</tr>
					<tr>
						<td class="oneLocation">解保资料附件</td>
						<td class="twoLocation" colspan="3" >
							<div id="attachmentsDIV" class="">
							<c:forEach items="${files }" var="projectfiles" varStatus="status">
								<div id="${projectfiles.projectFiles_ID }DIV">
								${status.index+1 }、
								<c:choose>
									<c:when test="${projectfiles.extend eq 'docx' || projectfiles.extend eq 'doc' || projectfiles.extend eq 'pdf' || projectfiles.extend eq 'xlsx' || projectfiles.extend eq 'xls' || projectfiles.extend eq 'ppt' || projectfiles.extend eq 'pptx' }">
										<a href="javascript:void(0)" onclick="window.parent.open('/sys/documentPreview/selectDocumentViewPage?domhref=${projectfiles.pathFile}&domextend=${projectfiles.extend }')">${projectfiles.sourceFileName }</a>
										&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)">下载</a> 
										<%-- &nbsp;&nbsp;&nbsp;&nbsp;<a title='删除附件' name="${projectfiles.projectFiles_ID }" onclick="$.zjm_finishFiles.deleteOnePictureFile(this.name);" href='javascript:void(0)'>删除</a> --%>
																	
									</c:when>
									<c:when test="${projectfiles.extend == 'jpeg' || projectfiles.extend == 'png' || projectfiles.extend == 'gif' || projectfiles.extend == 'jpg' }">
										<a onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)">${projectfiles.sourceFileName }</a> 
										<%-- &nbsp;&nbsp;&nbsp;&nbsp;<a title='删除附件' name="${projectfiles.projectFiles_ID }" onclick="$.zjm_finishFiles.deleteOnePictureFile(this.name);" href='javascript:void(0)'>删除</a> --%>
									</c:when>
									<c:otherwise>
										<a onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)">${projectfiles.sourceFileName }</a> 
										<%-- &nbsp;&nbsp;&nbsp;&nbsp;<a title='删除附件' name="${projectfiles.projectFiles_ID }" onclick="$.zjm_finishFiles.deleteOnePictureFile(this.name);" href='javascript:void(0)'>删除</a> --%>
									</c:otherwise>
								</c:choose>
								<br>
								</div>
							</c:forEach>
		                	</div>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<a href="javascript:void(0)" style="margin-right:10px;line-height:37px;display:block;text-decoration:none;"  class="pull-right btn_generateRelieve">
									<i class="icon-edit bigger-110 orange" ></i>
									<span class="bigger-110 no-text-shadow orange">生成《业务解除通知单》</span>
							</a>
						</td>
					</tr>
					<jsp:include page="/gworkFlow/components/component_sugget_view_import.jsp"></jsp:include>
				</table>
				</form>
			</div>
			
		</div>
	</div>
</div>
<div id="finish_page"></div>
<%-- 
<%@ include file="/common_message.jsp" %>
<%@ include file="/common_foot.jsp"%> --%>
<%@ include file="/project/finish/finishFiles.jsp"%>

<script src="<%=path%>/project/finish/finish.js"></script>
<script src="<%=path%>/project/finish/finishFiles.js"></script>


