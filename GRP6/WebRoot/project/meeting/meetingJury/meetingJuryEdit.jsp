<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<div class="modal fade" id="editMeetingJury" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改评委</h4>
      </div>
      <div class="modal-body">
			<form class="form-horizontal" role="form" id="form_editMeetingJury">
				<input type="hidden" name="meetingJury_ID" value="${meetingJury.meetingJury_ID }">
				<input type="hidden" name="userUid" value="${meetingJury.userUid }">
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>评委姓名： </label>
					<label class="col-sm-9">${meetingJury.userName }</label>
				</div>
				<div class="space-4"></div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>是否可用： </label>
					<div class="col-sm-9">
						<div class="radio">
							<label class="no-padding-left">
								<input type="radio" name="juryStatus" class="ace form-field-radio" value="01" 
									<c:if test="${meetingJury.juryStatus=='01' }">checked="checked"</c:if>/>
								<span class="lbl">启用</span>
							</label>
							<label>
								<input type="radio" name="juryStatus" class="ace form-field-radio"  value="02" 
									<c:if test="${meetingJury.juryStatus=='02' }">checked="checked"</c:if>/>
								<span class="lbl">禁用</span>
							</label>
						</div>
					</div>
				</div>
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit"><i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
				