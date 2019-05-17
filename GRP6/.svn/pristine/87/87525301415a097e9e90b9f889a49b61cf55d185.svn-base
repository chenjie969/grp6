<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" href="<%=path %>/plugins/viewer/viewer.min.css?v=<%=vardate%>" /> 
<link rel="stylesheet" href="<%=path %>/plugins/webuploader/css/webuploader.css?v=<%=vardate%>" />
<link rel="stylesheet" href="<%=path %>/assets/css/iconfont.css?v=<%=vardate%>" />
<link rel="stylesheet" href="<%=path %>/plugins/viewer/viewer.min.css?v=<%=vardate%>" />
<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>

<div class="modal modal_wapper fade bs-example-modal-lg" id="addMeeting" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h3 class="modal-title">新增会议</h3>
			</div>
			
			<div class="modal-body">
				<form class="form-horizontal" role="form" id="meetingAdd_form">
					<input type="hidden" name="riskScheme_IDs" value="${riskScheme_ID}">
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
						 	<td style="text-align:right;">
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
				<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>会议名称： </label>
				<div class="col-sm-6">
					<input type="text" name="meetingName"  class="col-sm-8 validate[required,maxSize[50]]"/>
				</div>
			</div>
		
			<div class="form-group ">
				<label class="col-md-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>会议类型： </label>
		        <div class="col-md-8">
		        <input type="hidden" id="meetingTypeName" class="meetingTypeName" name="meetingTypeName" value="${riskScheme.meetingTypeName}">
					  <select id="meetingTypeNameList" class="col-sm-6 col-md-6 validate[required]" onchange='setMeetingTypeName()' name="meetingTypeID"  >		
								<option value="">&nbsp;请选择</option>
								<c:forEach items="${meetingTypeNameList}" var="meetingType">
									<option value="${meetingType.dicTypeID}" <c:if test="${meetingType.dicTypeID eq riskScheme.meetingTypeID}">selected="selected"</c:if>>${meetingType.dicTypeName}</option>
								</c:forEach>
					  </select>
				</div>
			</div>
			<div class="form-group">
		   	    <label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>会议时间： </label>
		        <div class="col-sm-6">
					<div class="row">
						<div class="col-sm-6 no-padding-right">
							<div class="input-group">
								<input class="form-control validate[required]" type="text" data-date-format="yyyy-mm-dd hh:ii" name="meetingDateTimeStr" id="datetime-picker"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
 			</div>
			<div class="form-group">
					<input type="hidden" name="meetingRoomName" id="meetingRoomName">
                     <label class="col-sm-3 control-label no-padding-right"  for="meetingRoom_ID"><i
                             class="icon-asterisk orange"></i>会议室：</label>
                     <div class="col-sm-3 no-padding-right">
                         <select class="col-xs-10 validate[required]" id="meetingRoom_ID"
                                 name=meetingRoom_ID>
                             <!-- <option value="">--请选择--</option> -->
                             <c:forEach var="riskScheme" items="${rooms}" varStatus="status">
                                 <option value="${riskScheme.meetingRoom_ID}">${riskScheme.meetingRoomName}</option>
                             </c:forEach>
                         </select>
                     </div>
                 </div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>参会人员：</label>
				<div class="col-sm-6">
					<div class="row">
						<div class=" col-sm-8">
							<div class="input-group userNameList">
								<input  type="text"  class="form-control validate[required]" id="userNameList" name="userNameList" autoField="userIDList" readonly="readonly" />
								<span class="input-group-addon midden">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group ">
				   <label class="col-sm-3 control-label no-padding-right" for="form-field-1">备注： </label>
		           <div class="col-sm-8">
		               <textarea class="col-sm-10 limited validate[maxSize[2000]]" rows="5" id="remark"  name="remark" ></textarea>
		           	<div class="col-sm-10 no-padding-right">
		                 <span class="light-grey" style="float:right;">最多允许输入字符2000个</span>
		            </div>
		           </div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>创建人：</label>
				<div class="col-sm-6">
					<div class="row">
						<div class=" col-sm-6">
							<div class="input-group createUserID">
								<input  type="text"  class="form-control validate[required]" id="createUserID" name="createUserName" value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}"autoField="juryUserUids2" readonly="readonly" />
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
				
			</div>
			
			<div class="form-group">
		   	    <label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>创建日期： </label>
	         	<div class="col-sm-6">
					<div class="input-group col-sm-6">
						<input class="form-control date-picker validate[required,custom[date]]" id="date-picker-1" name="createDate" type="text" data-date-format="yyyy-mm-dd" />
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
	        </div>
			</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary btn_submit">
					<i class='icon-ok bigger-110'></i>保存
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<i class='icon-remove bigger-110'></i>关闭
				</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
/*注册日期控件点击事件*/
$('#datetime-picker').datetimepicker({language:"zh",autoclose:true,minuteStep:10}).next().on(ace.click_event, function(){
	$(this).prev().focus();
});
/*注册日期控件点击事件*/
$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
	$(this).prev().focus();
});
/*设置日期初始值，默认为当天*/
$("#date-picker-1").attr("value",tool.parseDate(new Date().getTime()));


/*会议类型 */
 
 function setMeetingTypeName(){
	var type = document.getElementById('meetingTypeNameList');     	
	 var pindex  = type.selectedIndex;
	 // 获取选中的下拉框的值(value)
　	 var pValue  =  type.options[pindex].value;　
　	 // 获取选中的下拉框的值(key)
　	 var pText = type.options[pindex].text;
　    document.getElementById('meetingTypeName').value=pText;
}   
 
</script>