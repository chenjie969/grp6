<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<link rel="stylesheet" href="<%=path %>/plugins/viewer/viewer.min.css?v=<%=vardate%>" />
<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>
<h4 class="header smaller lighter orange">
	<i class="icon-tasks"></i>意见汇总
</h4>
<div class="page-content" >
	<div class="row">
	
	
		<%-- <c:forEach items="${osSuggestList}" var="osSuggestInfo" varStatus="status">
			<div class="panel panel-default">
			  <div class="panel-body">
			  	<div class="col-xs-4">
			  		${osSuggestInfo.stepName}<br />
			  		(${osSuggestInfo.user_name})<br />
			  		<fmt:formatDate value="${osSuggestInfo.suggestTime}" type="time" timeStyle="full" pattern="yyyy-MM-dd HH:mm:ss"/>
			  	</div>
			  	<div class="col-xs-8">
			  		审批意见 :${osSuggestInfo.suggestContent}
			  	</div>
			  </div>
			</div>
		</c:forEach>
		
		
		<c:forEach items="${osSuggestList}" var="osSuggestInfo" varStatus="status">
			<div class="media">
			  <div class="media-left">
			    ${osSuggestInfo.stepName}<br />
			  		(${osSuggestInfo.user_name})<br />
		  		<fmt:formatDate value="${osSuggestInfo.suggestTime}" type="time" timeStyle="full" pattern="yyyy-MM-dd HH:mm:ss"/>
			  </div>
			  <div class="media-body">
			  	<h4 class="media-heading">审批意见 :</h4>
			    ${osSuggestInfo.suggestContent}
			  </div>
			</div>
		</c:forEach> --%>
		    <div class="bs-example" data-example-id="simple-table">
			    <table class="table">
			      <tbody>
			      <c:if test="${fn:length(osSuggestList)==0}"><tr><th scope="row" style="text-align:center;vertical-align:middle;">（空）</th></tr></c:if>
					<c:forEach items="${osSuggestList}" var="osSuggestInfo" varStatus="status">
				        <tr>
				          <th scope="row" calss="col-xs-4" style="text-align:center;vertical-align:middle;">
				          		&nbsp;<br />
						          ${osSuggestInfo.stepName}<br />
						  		(${osSuggestInfo.user_name})<br />
					  		<fmt:formatDate value="${osSuggestInfo.suggestTime}" type="time" timeStyle="full" pattern="yyyy-MM-dd HH:mm:ss"/>
					  		<br />&nbsp;
			  		     </th>
				          <td class="col-xs-8" id="jpgFileList${osSuggestInfo.historyID}">
				          	意见内容：<br />
				          	${osSuggestInfo.suggestContent}<br /><hr>
				          	附件：<br />
				          	<c:forEach items="${osSuggestInfo.filesList}" var="filesInfo" varStatus="status">
				          	${filesInfo.sourceFileName}
				          	
				          	
				          	
				          	<c:if test="${filesInfo.extend=='docx' || filesInfo.extend=='doc' || filesInfo.extend=='pdf' || filesInfo.extend=='xlsx' || filesInfo.extend=='xls' || filesInfo.extend=='ppt' || filesInfo.extend=='pptx' }">
				          	
				          	<button class="btn btn-xs btn-warning" onclick="javascript:window.parent.open('/sys/documentPreview/selectDocumentViewPage?domhref=${filesInfo.pathFile}&domextend=${filesInfo.extend}')"><i class="icon-zoom-in bigger-120"></i></button>
										<button class="btn btn-xs btn-info" onclick="javascript:window.parent.open('/sys/documentPreview/selectDocumentEditPage?domhref=${filesInfo.pathFile}&domextend=${filesInfo.extend}')"><i class="icon-pencil bigger-120"></i></button>
										<button class="btn btn-xs btn-warning" onclick="javascript:window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${filesInfo.sourceFileName}&filePath=${filesInfo.pathFile}')"><i class="icon-download-alt bigger-120"></i></button>
				          	
				          	</c:if>
				          	<c:if test="${filesInfo.extend=='jpeg' || filesInfo.extend=='png' || filesInfo.extend=='gif' || filesInfo.extend=='jpg'}">
				          				<%-- <button class="btn btn-xs btn-warning btn_opfile_viewer" data-id="jpgFileList${osSuggestInfo.historyID}" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i>
											<img class="hide" data-original="${filesInfo.pathFile}" src="${filesInfo.pathFile}" alt="${filesInfo.sourceFileName}">
										</button> --%>
										<button class="btn btn-xs btn-warning" onclick="javascript:window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${filesInfo.sourceFileName}&filePath=${filesInfo.pathFile}')"><i class="icon-download-alt bigger-120"></i></button>
				          	</c:if>
				          	<c:if test="${filesInfo.extend=='docx' && filesInfo.extend=='doc' && filesInfo.extend=='pdf' && filesInfo.extend=='xlsx' && filesInfo.extend=='xls' && filesInfo.extend=='ppt' && filesInfo.extend=='pptx' && filesInfo.extend=='jpeg' && filesInfo.extend=='png' && filesInfo.extend=='gif' && filesInfo.extend=='jpg' }">
				          		<button class="btn btn-xs btn-warning" onclick="javascript:window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${filesInfo.sourceFileName}&filePath=${filesInfo.pathFile}')"><i class="icon-download-alt bigger-120"></i></button>
				          	</c:if>
				          	<br />
				          	</c:forEach>
				          	<c:if test="${fn:length(osSuggestInfo.filesList)==0}">（空）</c:if>
				          	
				          </td>
				        </tr>
			        </c:forEach>
			      </tbody>
			    </table>
				&nbsp;<br/>&nbsp;<br/>&nbsp;<br/>
			  </div>
			  <div id="jpgFileList">
  </div>
	</div>
</div>

<script>     
 
	$(function() {
		$(".btn_opfile_viewer").click(function() {
			alert($(this).attr("data-id"));
			var viewer = new Viewer(document.getElementById($(this).attr("data-id")), {
			    url: 'data-original'
			});
			viewer.show();
			$(".viewer-close").click(function(){
				viewer.destroy();
			});
		});
	});
</script>