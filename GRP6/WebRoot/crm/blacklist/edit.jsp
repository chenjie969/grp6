<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="editblacklist" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改黑名单</h4>
      </div>
      <div class="modal-body">
			<form class="form-horizontal" role="form" id="editBadClientform">
				<input type="hidden" name="badClient_ID" class="ztb_edit_badClient_ID">
				<input type="hidden" name="client_ID" class="ztb_edit_client_ID">
				<input type="hidden" name="operationDepartFullCode" class="ztb_edit_operationDepartFullCode">
				<input type="hidden" name="operationDepartName" class="ztb_edit_operationDepartName">
				<input type="hidden" name="operatorID" class="ztb_edit_operatorID">
				<input type="hidden" name="operatorName" class="ztb_edit_operatorName">
				<input type="hidden" name="operatorDate" class="ztb_edit_operatorDate">
				<input type="hidden" name="cancelDepartFullCode" class="ztb_edit_cancelDepartFullCode">
				<input type="hidden" name="cancelDepartName" class="ztb_edit_cancelDepartName">
				<input type="hidden" name="cancelOperatorID" class="ztb_edit_cancelOperatorID">
				<input type="hidden" name="cancelOperatorName" class="ztb_edit_cancelOperatorName">
				<input type="hidden" name="cancelDate" class="ztb_edit_cancelDate">
				<input type="hidden" name="cancelDescription" class="ztb_edit_cancelDescription">
				<input type="hidden" name="clientName" class="ztb_edit_clientName"/>
				<div class="form-group company" style="display:none">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 企业名称： </label>
					<div class="col-sm-9">
						<span class="col-sm-10 ztb_edit_clientName control-label" style="text-align:left"></span>
					</div>
				</div>
				<div class="form-group person" style="display:none">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 申请人姓名： </label>
					<div class="col-sm-9">
						<span class="col-sm-10 ztb_edit_personName control-label" style="text-align:left"></span>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="form-group company person">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> <i class="icon-asterisk orange"></i>拉黑原因： </label>
					<div class="col-sm-9">
						<textarea class="col-sm-10 ztb_edit_operationDescription validate[required,maxSize[50]]" rows="8" name="operationDescription"></textarea>
						<div class="col-sm-10 no-padding-right">
							<span class="light-grey" style="float:right">限制50个字符</span>
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
				