<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/common_timestamp.jsp" %>

<div class="modal fade bs-example-modal-lg" id="awaitedMeetingView" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" style="overflow: auto">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h3 class="modal-title " id="myModalLabel">会议详情</h3>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="awaitedMeetingView_form">
			<input type="hidden" name="riskMeetingRec_ID" value="${riskMeetingRec.riskMeetingRec_ID}">
					
			 <div class="form-group">
			<label class="col-sm-2 control-label no-padding-right" for="form-field-1"
							for="form-input">议程：</label>
			<div class="col-sm-9">
			<div class="space-6"></div>
			<table class="table table-striped table-bordered table-hover" data-toggle="table" data-striped="true" >
	             <thead>
					<tr>
						<th width="5%" style="text-align: center;">序号</th>
						<th width="25%" style="text-align: center;">标题</th>
						<th width="25%" style="text-align: center;">相关文件</th>
					</tr>
				 </thead>
				 <tbody>
				 <c:forEach items="${riskSchemeList}" var="riskScheme" varStatus="count">
				 	<tr>  
						 <td style="text-align: center;">${count.count}</td>  
						 <td style="text-align: center;">${riskScheme.title}</td>  
						 <c:if test="${fn:length(riskScheme.filesList)<1 }">
						 	<td style="text-align: center;">无</td>
						 </c:if>
						 <c:if test="${fn:length(riskScheme.filesList)>0 }">
						 	<td style="text-align: center;">
						 	<c:forEach items="${riskScheme.filesList}" var="filesInfo">
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
						 	</td>
						 </c:if>
					</tr>
				 </c:forEach>
				 <c:if test="${fn:length(riskSchemeList)<1}">
				 	<tr>  
						 <td style="text-align: center;" colspan="3">暂无数据</td> 
					</tr>
				 </c:if>
			    </tbody>
		    </table>
		</div>
		</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="meetingRoomID">会议名称：</label>
				<label class="col-sm-8 grey" id="meetingName">${riskMeetingRec.meetingName}</label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">会议类型：</label>
				<label class="col-sm-8 grey" id="meetingTypeName">${riskMeetingRec.meetingTypeName}</label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" >会议时间：</label>
				<label class="col-sm-8 grey" id="meetingDateTime"> <fmt:formatDate value="${riskMeetingRec.meetingDateTime }" pattern="yyyy-MM-dd HH:mm" type="both"/></label>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">会议室：</label>
				<label class="col-sm-8 grey" ID="meetingRoomName">${riskMeetingRec.meetingRoomName}</label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">参会人员：</label>
				<label class="col-sm-8 grey" id="userNameList">${riskMeetingRec.userNameList}</label>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">备注：</label>
				<label class="col-sm-8 grey" id="">${riskMeetingRec.remark}</label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">创建人：</label>
				<label class="col-sm-8 grey" id="createUserName">${riskMeetingRec.createUserName}</label>
			</div>	
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">创建日期：</label>
				<label class="col-sm-8 grey" id="createDate"><fmt:formatDate value="${riskMeetingRec.createDate}" pattern="yyyy-MM-dd"/></label>
			</div>
			
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
