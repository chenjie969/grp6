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
	<h4><span>风险管理部初审核 </span></h4>
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
					<c:if test="${!empty finish.margin}">
						<tr>
							<td class="oneLocation">保证金</td>
							<td class="twoLocation">${empty finish.margin? 0: finish.margin}&nbsp;&nbsp;万元</td>
							
							<td class="oneLocation" >保证金用途</td>
							<td class="twoLocation">${empty finish.remark? '': finish.remark}
							</td>
						</tr>
					</c:if>
					<tr>
						<td class="oneLocation">解保资料附件</td>
						<td class="twoLocation" colspan="3" >
							<div class="col-sm-10 col-sm-offset-1 suggest_pare">
								<div id="attachmentsDIV" class="">
								<c:forEach items="${files }" var="projectfiles" varStatus="status">
									<div id="${projectfiles.projectFiles_ID }DIV">
									${status.index+1 }、
									<c:choose>
										<c:when test="${projectfiles.extend eq 'docx' || projectfiles.extend eq 'doc' || projectfiles.extend eq 'pdf' || projectfiles.extend eq 'xlsx' || projectfiles.extend eq 'xls' || projectfiles.extend eq 'ppt' || projectfiles.extend eq 'pptx' }">
											<a href="javascript:void(0)" onclick="window.parent.open('/sys/documentPreview/selectDocumentViewPage?domhref=${projectfiles.pathFile}&domextend=${projectfiles.extend }')">${projectfiles.sourceFileName }</a>
											&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)">下载</a> 
											&nbsp;&nbsp;&nbsp;&nbsp;<a title='删除附件' name="${projectfiles.projectFiles_ID }" onclick="$.zjm_finishFiles.deleteOnePictureFile(this.name);" href='javascript:void(0)'>删除</a>
																		
										</c:when>
										<c:when test="${projectfiles.extend == 'jpeg' || projectfiles.extend == 'png' || projectfiles.extend == 'gif' || projectfiles.extend == 'jpg' }">
											<a onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)">${projectfiles.sourceFileName }</a> 
											&nbsp;&nbsp;&nbsp;&nbsp;
											<c:if test="${projectfiles.extend=='jpeg' || projectfiles.extend=='png' || projectfiles.extend=='gif' || projectfiles.extend=='jpg'}">
												
												 <a href="#" class="btn_opfile_viewer_img" data-original="${projectfiles.pathFile}" src="${projectfiles.pathFile}"><i class="icon-zoom-in bigger-120 orange"></i></a>
												    <img class="hide" data-original="${projectfiles.pathFile}" src="${projectfiles.pathFile}" alt="${projectfiles.sourceFileName}" title="${projectfiles.sourceFileName}"/>
												&nbsp;&nbsp;
												<a href="#" onclick="javascript:window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile}')">
														<i class="icon-download-alt bigger-120 "></i>
												</a>
						          			</c:if>
											<a title='删除附件' name="${projectfiles.projectFiles_ID }" onclick="$.zjm_finishFiles.deleteOnePictureFile(this.name);" href='javascript:void(0)'>删除</a>
										</c:when>
										<c:otherwise>
											<a onclick="window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${projectfiles.sourceFileName}&filePath=${projectfiles.pathFile }')" href="javascript:void(0)">${projectfiles.sourceFileName }</a> 
											&nbsp;&nbsp;&nbsp;&nbsp;<a title='删除附件' name="${projectfiles.projectFiles_ID }" onclick="$.zjm_finishFiles.deleteOnePictureFile(this.name);" href='javascript:void(0)'>删除</a>
										</c:otherwise>
									</c:choose>
									<br>
									</div>
								</c:forEach>
			                	</div>
		                	</div>
							<%-- <button class="btn btn-sm btn-info" type="button"  
								name="button" id="${finish.finishId }" onclick="$.zjm_finishFiles.filesUpdate(this.id)">
		                    	上传</button> --%>
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
<script src="/plugins/plupload/plupload.full.min.js"></script>
<script src="/plugins/plupload/i18n/zh_CN.js"></script>
<script>     
 
	 $(function() {
		$(".btn_opfile_viewer").click(function() {
		 	var viewer = new Viewer(document.getElementById($(this).attr("data-id")), { 
			    url: 'data-original'
			});
			viewer.show();
			$(".viewer-close").click(function(){
				viewer.destroy();
			});
		});
		$(".suggest_pare").on("click",".btn_opfile_viewer_img",function() {
			console.log(3333);
			 var suggestParent = $(this).parents(".suggest_pare"); 
			 console.info(suggestParent)
		 	var viewer = new Viewer( suggestParent[0], { 
			    url: 'data-original'
			}); 
			viewer.show();
			$(".viewer-close").click(function(){
				
				viewer.destroy();
				 window.location.reload();  
			});
		});
		$(".btn_riskfile_viewer_img").click(function() {
		 	var viewer = new Viewer(document.getElementById("ulPictureFile2"), { 
			    url: 'data-original'
			});
			viewer.show();
			$(".viewer-close").click(function(){
				
				viewer.destroy();
				 window.location.reload();  
			});
		});
	}); 
</script>

