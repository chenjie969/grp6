<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade bs-example-modal-sm" id="meetingResolutionEdit2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改参会委员</h4>
      </div>
      <div class="modal-body">
		
		
		<form class="form-horizontal" role="form" id="updateMeetingUserName_form">
			 <input type="hidden" name="meeting_ID" class="meeting_ID" value="${meeting.meeting_ID}">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">参会委员： </label>
                <label class="col-sm-9 grey">
                   	 <input type="text" class="col-md-5 col-sm-6" id="userNameList" 
                   	 name="userNameList" value="${meeting.userNameList}"/>
                </label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">外部专家： </label>
                <label class="col-sm-9 grey">
                   	 <input type="text" class="col-md-5 col-sm-6" id="otherUserNameList" 
                   	 name="otherUserNameList" value="${meeting.otherUserNameList}"/>
                </label>
			</div>
			<%-- 
	        <div class="form-group ">
				   <label class="col-sm-3 control-label no-padding-right" for="form-field-1">放款条件： </label>
		           <div class="col-sm-9">
		               <textarea class="col-sm-10 limited validate[maxSize[250]]" rows="5" id="loanConditions"  name="loanConditions" >${meetingResolution.loanConditions}</textarea>
		           	<div class="col-sm-10 no-padding-right">
		                 <span class="light-grey" style="float:right;">限制250个字符</span>
		            </div>
		           </div>
			</div> --%>
			
		
		
		</form>
      </div>
      <div class="modal-footer">                   
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
