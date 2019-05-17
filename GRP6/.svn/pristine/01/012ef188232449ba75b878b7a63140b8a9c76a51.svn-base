<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="modal fade" id="meetingCostEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" style="z-index:9999">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">修改收费标准</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="form_meetingCostEdit">
			<input type="hidden" name="meetingCost_ID" value="${meetingCost.meetingCost_ID }">
 			
 			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">费用类型： </label>
				<label class="col-sm-9" for="form-field-1">${meetingCost.costTypeName }</label>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">费率： </label>
				<label class="col-sm-9" for="form-field-1">${meetingCost.costRate }&nbsp;${meetingCost.costUnit }</label>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">计算规则： </label>
				<label class="col-sm-9" for="form-field-1">${meetingCost.culate }</label>
			</div>
			
 			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">备注： </label>
				<div class="col-sm-9">
					<textarea name="remark" class="col-sm-10" rows="5">${meetingCost.remark }</textarea>
				</div>
			</div>
 			
		</form>
      </div>
      <div class="modal-footer">
			<button type="button" class="btn btn-primary btn_submit"><i class='icon-ok bigger-110'></i>保存</button>
			<button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>取消</button>
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
				