<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" id="disagreeToAccept" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">转入客户储备库</h4>
      </div>
      <div class="modal-body">
   		<form class="form-horizontal" role="form" id="form_disagreeToAccept">
   			<input type="hidden" name="capply_ID" value="${apply.capply_ID }">
   			<input type="hidden" name="clientType" value="${apply.clientType }">
			<div class="form-group company">
				<c:if test="${apply.clientType =='01' }">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 企业名称： </label>
				</c:if>
				<c:if test="${apply.clientType =='02' }">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 申请人姓名： </label>
				</c:if>
				<label class="col-sm-9">${apply.clientName }</label>
			</div>
			<div class="form-group company person">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2">不同意受理原因： </label>
				<div class="col-sm-9">
					<textarea class="col-sm-10 ztb_edit_operationDescription validate[maxSize[250]]" rows="8" name="noAgreeDesc"></textarea>
					<div class="col-sm-10 no-padding-right">
						<span class="light-grey" style="float:right">限制250个字符</span>
					</div>
				</div>
			</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" ><i class='icon-ok bigger-110'></i>确认</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>取消</button>
      </div>
    </div>
  </div>
</div>
				