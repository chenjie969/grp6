<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal modal_wapper fade bs-example-modal-lg" id="reviewInfoEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg " role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">修改评审基本信息</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="updateResolutionMeeting_form">
			<input type="hidden" name="meetingResolution_ID" value="${meetingResolution.meetingResolution_ID}"/>
      		<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right"
					for="form-input"><i class="icon-asterisk orange"></i>决议编号：</label>
				<div class="col-sm-8">
					<input type="text" name="resolutionCode" id="resolutionCode"  class="validate[required,maxSize[50]]" value="${meetingResolution.resolutionCode}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right"
					for="form-input"><i class="icon-asterisk orange"></i>评审会编号：</label>
					<div class="col-sm-8">
					<input type="text" name="meetingCode" id="meetingCode"  class="validate[required,maxSize[50]]" value="${meetingResolution.meetingCode}"/>
				</div>
			</div>
 			<div class="form-group">
 			<label class="col-sm-4 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>上会日期： </label>
				<div class="col-sm-7">
						<div class="row">
							<div class="col-sm-7">
								<div class="input-group">
									<input  type="text" class="form-control date-picker validate[required,custom[date]]" 
									name="meetingDate" id="id-date-picker-1"  data-date-format="yyyy-mm-dd"  value = "<fmt:formatDate pattern="yyyy-MM-dd" value="${meetingResolution.meetingDate}" />" />
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
					</div>
 			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>表决评委： </label>
				<div class="col-sm-7">
					<div class="row">
						<div class="col-sm-7">
							<div class="input-group userid">
								<input  type="text"  class="form-control validate[required] " autoField="userId"   id="userid"  value="${meetingResolution.userNameList}" dataValue="" name="userNameList" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">列席人员：</label>
					<div class="col-sm-7">
					<div class="col-sm-7">
					<textarea type="text" name="otherUserNameList" id="otherUserNameList"  class="col-sm-10 validate[maxSize[500]]" rows="6">${meetingResolution.otherUserNameList}</textarea>
				</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">评委投票结果：</label>
				<label class="col-sm-8"></label>
 			</div>
 			<div class="form-group">
 				<label class="col-sm-5 control-label no-padding-right"><i class="icon-asterisk orange"></i>参会应到人数：</label>
 				<input type="text" name="shouldJury" id="shouldJury"  class="col-sm-2 validate[required,custom[number],maxSize[50]]"value="${meetingResolution.shouldJury}" />
				<span class="col-sm-2" style="line-height:34px;">人</span>
 			</div>
 			<div class="form-group">
 				<label class="col-sm-5 control-label no-padding-right"><i class="icon-asterisk orange"></i>参会实到人数：</label>
 				<input type="text" name="senseJury" id="senseJury"  class="col-sm-2 validate[required,custom[number],maxSize[50]]"value="${meetingResolution.senseJury}" />
				<span class="col-sm-2" style="line-height:34px;">人</span>
 			</div>
 			<div class="form-group">
 				<label class="col-sm-5 control-label no-padding-right"><i class="icon-asterisk orange"></i>决议通过人数：</label>
 				<input type="text" name="passJury" id="passJury"  class="col-sm-2 validate[required,custom[number],maxSize[50]]"value="${meetingResolution.passJury}" />
				<span class="col-sm-2" style="line-height:34px;">人</span>
 			</div>
		</form>
      </div>
      <div class="modal-footer">                   
        <button type="button" class="btn btn-primary btn_submit"> <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
	/*注册日期控件点击事件*/
	$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
		$(this).prev().focus();
	});
</script>