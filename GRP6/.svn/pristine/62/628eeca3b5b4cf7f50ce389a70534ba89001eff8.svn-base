<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="jurySuggestView" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" style="overflow: auto">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">评委表决</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="form_jurySuggest_edit">
			<input type="hidden" name="jurySuggest_ID" value="${jurySuggest.jurySuggest_ID }">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="meetingRoomID">项目编号：</label>
				<label class="col-sm-8" id="edit_projectCode"></label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">项目名称：</label>
				<label class="col-sm-8" id="edit_projectName"></label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="meetingRoomID">评委结论：</label>
				<label class="col-sm-8">${jurySuggest.suggestResultName }</label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">评委意见：</label>
				<label class="col-sm-8">${empty jurySuggest.suggestContent?"（空）":jurySuggest.suggestContent }</label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">附件：</label>
				<label class="col-sm-9">
                    <div id="attachmentsDIV">
	                    <c:if test="${empty projectfilesList }">
							（空）
						</c:if>
                  		<c:forEach items="${projectfilesList }" var="file">
                  			<a href="${file.pathFile }" target="_blank">${file.sourceFileName }</a><br/>
                  		</c:forEach>
                    </div>
				</label>
			</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
