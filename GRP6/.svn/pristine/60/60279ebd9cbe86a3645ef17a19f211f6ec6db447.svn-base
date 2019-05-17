<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="jurySuggestEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" style="overflow: auto">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">评委表决</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="form_jurySuggest_edit">
			<input type="hidden" name="jurySuggest_ID" value="${jurySuggest.jurySuggest_ID }" id="jurySuggest_ID">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="meetingRoomID">项目编号：</label>
				<label class="col-sm-3" id="edit_projectCode"></label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">项目名称：</label>
				<label class="col-sm-3" id="edit_projectName"></label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="meetingRoomID"><i class="icon-asterisk orange"></i>评委结论：</label>
				<div class="col-sm-9">
					<select class="col-sm-6 validate[required] select" id="select_suggestResultID" name="suggestResultID">
						<option value="">请选择</option>
						<c:forEach items="${resolutionResultList }" var="resolutionResult">
							<option value="${resolutionResult.dicTypeID }" <c:if test="${resolutionResult.dicTypeID==jurySuggest.suggestResultID }">selected="selected"</c:if>>${resolutionResult.dicTypeName }</option>	
						</c:forEach>
						<%-- <option value="01" <c:if test="${'01'==jurySuggest.suggestResultID }">selected="selected"</c:if>>同意</option>	
						<option value="02" <c:if test="${'02'==jurySuggest.suggestResultID }">selected="selected"</c:if>>复议</option>
						<option value="03" <c:if test="${'03'==jurySuggest.suggestResultID }">selected="selected"</c:if>>不同意</option>
						<option value="04" <c:if test="${'04'==jurySuggest.suggestResultID }">selected="selected"</c:if>>补充落实</option> --%>
					</select>
					<input type="hidden" name="suggestResultName" id="select_suggestResultName" value="${jurySuggest.suggestResultName }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">评委意见：</label>
				<div class="col-sm-9">
					<textarea rows="5" class="col-sm-9 validate[maxSize[100]]" name="suggestContent">${jurySuggest.suggestContent }</textarea>
					<div class="col-sm-9 no-padding-right">
						<span class="light-grey" style="float:right">限制100个字符</span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">附件：</label>
				<label class="col-sm-9"><button class="btn btn-xs btn-info" type="button" name="button" onclick="$.zjm_jurySuggestFiles.filesUpdate('${jurySuggest.jurySuggest_ID }')">上传</button></label>
				<div class="col-sm-offset-3 col-sm-9"  id="attachmentsDIV">
					<c:forEach items="${projectfilesList }" var="file">
						<div id="${file.projectFiles_ID }DIV">
							<a href="${file.pathFile }" target="_blank">${file.sourceFileName }</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="button" title="删除" class="btn btn-xs btn-danger" href="javascript:void(0)" onclick="$.zjm_jurySuggestFiles.deleteOnePictureFile(this.id,this.name)" name="${file.pathFile }" id="${file.projectFiles_ID }"><i class="icon-trash bigger-120"></i></button>
							<br/>
						</div>
					</c:forEach>
				</div>
			</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="btn_save" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
<script src="/plugins/plupload/plupload.full.min.js"></script>
<script src="/plugins/plupload/i18n/zh_CN.js"></script>
<script src="/project/meeting/jurySuggest/jurySuggestFiles.js"></script>
<%@ include file="/project/meeting/jurySuggest/jurySuggestFiles.jsp" %>  
<script type="text/javascript">
	/*绑定下拉框选项改变事件 */
	$("#select_suggestResultID").change(function(){
		var opText = $(this).children("option:selected").text();
		$("#select_suggestResultName").val(opText);
	});
</script>				