<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<%@ include file="/common_foot.jsp" %>

	<input type="hidden" name="relationMain_ID" id="relationMain_ID" value="${relationMain.relationMain_ID}"/>
	<input type="hidden" name="relationMainName" id="relationMainName" value="${relationMain.relationMainName}"/>
	
	<h4 class="header smaller lighter blue">
		基本信息
	</h4>
    <div class="row" style="margin:0;">
        <h5 class="col-sm-3">系名：<span class="grey ">${relationMain.relationMainName}</span></h5>
        <h5 class="col-sm-9">主体企业名称：<span class="grey ">${relationMain.clientName}</span></h5>
        <h5 class="col-sm-3">项目类型：<span class="grey ">${relationMain.projectTypeName}</span></h5>
        <h5 class="col-sm-9">项目合计：<span class="grey ">${loadSum}</span></h5>
        <h5 class="col-sm-12">关联企业名称<span class="grey "></span></h5>
        <div class="col-sm-10">
             <div class="widget-main padding-8">
     			<table id="companyName-table" style="font-size: 13px !important;">
				</table>
			</div>
		</div>
    </div>
    
    <h4 class="header smaller lighter blue">
		项目进展
	</h4>
	<div class="row" style="margin:0;">
		<div class="col-sm-10">
             <div class="widget-main padding-8">
     			<table id="projectProgress-table" style="font-size: 13px !important;">
				</table>
			</div>
		</div>
	</div>
	
	<h4 class="header smaller lighter blue">
		项目档案
	</h4>
	<div class="row" style="margin:0;">
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="form-field-1">方案：</label>
			<label class="col-sm-9" id="riskSchemeFile">
                		
                		 <c:forEach items="${riskScheme.schemeFileList}" var="filesInfo" varStatus="status">
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
				          	<c:if test="${fn:length(riskScheme.schemeFileList)==0}"></c:if>
                
			</label>
                		 
            <c:if test="${fn:length(projectSuggestList)==0}">
			（空）
	  		</c:if>
	 		<c:forEach items="${projectSuggestList}" var="suggestList" varStatus="listCount">	
		    
			<label class="col-sm-3 control-label no-padding-right" for="form-field-1">${suggestList.taskName}：</label>
			<label class="col-sm-9" id="suggestList">
						<c:forEach items="${suggestList.filesList}" var="filesInfo" varStatus="status">
							<p>
							<c:if test="${filesInfo.extend eq 'jpg' ||(filesInfo.extend eq 'jpeg')||(filesInfo.extend eq 'png') ||(filesInfo.extend eq 'gif') }">
								 <a href="#" class="btn_suggestFile_viewer_img" data-original="${filesInfo.pathFile}" src="${filesInfo.pathFile}">
		                	</c:if>		
		                			${filesInfo.sourceFileName}
		                   	<c:if test="${filesInfo.extend eq 'jpg'}">			
		                	       </a>
							</c:if>
				    	
		                	<c:if test="${filesInfo.extend=='docx' || filesInfo.extend=='doc' || filesInfo.extend=='pdf' || filesInfo.extend=='xlsx' || filesInfo.extend=='xls' || filesInfo.extend=='ppt' || filesInfo.extend=='pptx' || filesInfo.extend=='txt'}">
		                           	&nbsp;&nbsp;
				          	<a class="" href="#" onclick="javascript:window.parent.open('/sys/documentPreview/selectDocumentViewPage?domhref=${filesInfo.pathFile}&domextend=${filesInfo.extend}')"><i class="icon-zoom-in bigger-120 orange"></i></a>
							<%-- <button class="btn btn-xs btn-info" onclick="javascript:window.parent.open('/sys/documentPreview/selectDocumentEditPage?domhref=${filesInfo.pathFile}&domextend=${filesInfo.extend}')"><i class="icon-pencil bigger-120"></i></button> --%>
							&nbsp;&nbsp;
							<a class="" href="#" onclick="javascript:window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${filesInfo.sourceFileName}&filePath=${filesInfo.pathFile}')"><i class="icon-download-alt bigger-120 "></i></a>
					          	
				          	</c:if>
				          	<c:if test="${filesInfo.extend=='jpeg' || filesInfo.extend=='png' || filesInfo.extend=='gif' || filesInfo.extend=='jpg'}">
				          				<%-- <button class="btn btn-xs btn-warning btn_opfile_viewer" data-id="jpgFileList" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i>
											<img class="hide" data-original="${filesInfo.pathFile}" src="${filesInfo.pathFile}" alt="${filesInfo.sourceFileName}">
										</button> --%>
				          				<%-- <button class="btn btn-xs btn-warning btn_opfile_viewer_img" data-id="jpgFileList" href="javascript:void(0)">
				          							<!-- <i class="icon-zoom-in bigger-120"></i> -->
											<img class="hide" data-original="${filesInfo.pathFile}" src="${filesInfo.pathFile}" alt="${filesInfo.sourceFileName}">
										    <img class="hide" data-original="${filesInfo.pathFile}" src="${filesInfo.pathFile}" alt="${filesInfo.sourceFileName}" title="${filesInfo.sourceFileName}">
										</button> --%>
										&nbsp;&nbsp;
										 <a href="#" class="btn_suggestFile_viewer_img" data-original="${filesInfo.pathFile}" src="${filesInfo.pathFile}"><i class="icon-zoom-in bigger-120 orange"></i></a>
										    <img class="hide" data-original="${filesInfo.pathFile}" src="${filesInfo.pathFile}" alt="${filesInfo.sourceFileName}" title="${filesInfo.sourceFileName}">
										&nbsp;&nbsp;
										<a href="#" onclick="javascript:window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${filesInfo.sourceFileName}&filePath=${filesInfo.pathFile}')">
												<i class="icon-download-alt bigger-120 "></i>
										</a>
				          	</c:if>
				          	<%-- <c:if test="${filesInfo.extend=='docx' && filesInfo.extend=='doc' && filesInfo.extend=='pdf' && filesInfo.extend=='xlsx' && filesInfo.extend=='xls' && filesInfo.extend=='ppt' && filesInfo.extend=='pptx' && filesInfo.extend=='jpeg' && filesInfo.extend=='png' && filesInfo.extend=='gif' && filesInfo.extend=='jpg' }">
				          		<button class="btn btn-xs btn-warning" onclick="javascript:window.parent.open('/crm/filesUpload/selectOneFilesDownload?fileName=${filesInfo.sourceFileName}&filePath=${filesInfo.pathFile}')"><i class="icon-download-alt bigger-120"></i></button>
				          	</c:if> --%>
				          	</p>
				          	</c:forEach>
				          	<c:if test="${fn:length(suggestList.filesList)==0}"></c:if>
			</label>
			
		 	</c:forEach>
		</div>
	</div>
<script src="<%=path %>/project/riskResponse/keyProject/riskSchemeInfo.js?v=<%=vardate%>"></script>
