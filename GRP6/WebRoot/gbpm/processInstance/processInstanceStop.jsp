<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<div class="modal fade" id="processInstanceStop" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">流程实例中止</h4>
      </div>
      <div class="modal-body">
      <form class="form-horizontal" role="form" id="stop_form">
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>中止类型： </label>
				<div class="col-sm-9">
				<input type="hidden" id="stopTypeName" class="stopTypeName"/>
					<select class="col-xs-8 col-sm-9 btn_ztb_select validate[required]" class_name="stopTypeName" id="stopTypeID">
						<option value="">请选择</option>
						<c:forEach items="${stopMap}" var="stopInfo">
						<option value="${stopInfo.key}">${stopInfo.value}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>中止日期： </label>
				<div class="col-sm-7">
					<div class="input-group">
						<input class="form-control date-picker validate[required,custom[date]]" type="text" id="stopDate" data-date-format="yyyy-mm-dd" />
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>中止原因： </label>
				<div class="col-sm-9">
					<textarea id="stopReason" class="col-xs-10 col-sm-9 validate[required,maxSize[500]]"></textarea>
					<div class="col-sm-9 no-padding-right">
						<span class="light-grey" style="float:right">限制500个字符</span>
					</div>
				</div>
			</div>
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" ><i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>取消</button>
      </div>
    </div>
  </div>
</div>
				