<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<link rel="stylesheet" href="<%=path %>/plugins/viewer/viewer.min.css?v=<%=vardate%>" />
<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>
			      	<c:if test="${fn:length(osSuggestList)==0}">
			      		<!-- <tr><th scope="row" style="text-align:center;vertical-align:middle;">（空）</th></tr> -->
			      	</c:if>
					<c:forEach items="${osSuggestList}" var="osSuggestInfo" varStatus="status">
						<tr>
							<td rowspan="1" style="display:table-cell; vertical-align:middle;text-align:center;">
								${osSuggestInfo.stepName}<br>(${osSuggestInfo.user_name})
								<br>
								<fmt:formatDate value="${osSuggestInfo.suggestTime}" type="time" timeStyle="full" pattern="yyyy-MM-dd HH:mm:ss"/>
							</td>
							<td colspan="3" class="twoLocation" id="jpgFileList${osSuggestInfo.historyID}" style="line-height:30px;">
								<b>意见内容：</b><br>
								${osSuggestInfo.suggestContent}<br>
								<hr><b>附件：</b><br>
								<c:forEach items="${osSuggestInfo.filesList}" var="filesInfo" varStatus="status">
						          	${filesInfo.sourceFileName}
					          		<button class="btn btn-xs btn-warning" onclick="javascript:window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${filesInfo.sourceFileName}&filePath=${filesInfo.pathFile}')"><i class="icon-download-alt bigger-120"></i></button>
						          	<c:if test="${filesInfo.extend=='docx' || filesInfo.extend=='doc' || filesInfo.extend=='pdf' || filesInfo.extend=='xlsx' || filesInfo.extend=='xls' || filesInfo.extend=='ppt' || filesInfo.extend=='pptx' }">
						          		<button class="btn btn-xs btn-warning" onclick="javascript:window.parent.open('/sys/documentPreview/selectDocumentViewPage?domhref=${filesInfo.pathFile}&domextend=${filesInfo.extend}')"><i class="icon-zoom-in bigger-120"></i></button>
						          	</c:if>
						          	<c:if test="${filesInfo.extend=='jpeg' || filesInfo.extend=='png' || filesInfo.extend=='gif' || filesInfo.extend=='jpg'}">
						          	</c:if>
						          	<br />
					          	</c:forEach>
					          	<c:if test="${fn:length(osSuggestInfo.filesList)==0}">（空）</c:if>
							</td>
						</tr>
			        </c:forEach>
