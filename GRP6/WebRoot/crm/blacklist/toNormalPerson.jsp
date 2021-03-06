<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="changeToNormalPerson" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">转为正常个人</h4>
      </div>
      <div class="modal-body">

			<form class="form-horizontal" role="form" id="changePersonform">
				<input type="hidden" name="badClient_ID" class="ztb_change_badClient_ID">
				<input type="hidden" name="client_ID" class="ztb_change_client_ID">
				<input type="hidden" name="operationDepartFullCode" class="ztb_change_operationDepartFullCode">
				<input type="hidden" name="operationDepartName" class="ztb_change_operationDepartName">
				<input type="hidden" name="operatorID" class="ztb_change_operatorID">
				<input type="hidden" name="operatorName" class="ztb_change_operatorName">
				<input type="hidden" name="operatorDate" class="ztb_change_operatorDate">
				<input type="hidden" name="operationDescription" class="ztb_change_operationDescription">
				<input type="hidden" name="cancelDepartFullCode" class="ztb_change_cancelDepartFullCode">
				<input type="hidden" name="cancelDepartName" class="ztb_change_cancelDepartName">
				<input type="hidden" name="cancelOperatorID" class="ztb_change_cancelOperatorID">
				<input type="hidden" name="cancelOperatorName" class="ztb_change_cancelOperatorName">
				<input type="hidden" name="cancelDate" class="ztb_change_cancelDate">
				<input type="hidden" name="cancelDescription" class="ztb_change_cancelDescription">
				<div class="form-group">
					<h5 class="col-sm-4 no-padding-right" align="right">申请人姓名：</h5>
					<h5 class="grey col-sm-8 ztb_change_personName"></h5>
				</div>
				<div class="space-4"></div>
				<!-- <div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 性别： </label>
					<div class="col-sm-9">
						<span class="grey ztb_change_sex"></span>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 年龄： </label>
					<div class="col-sm-9">
						<span class="grey ztb_change_age"></span>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 职位： </label>
					<div class="col-sm-9">
						<span class="grey ztb_change_position"></span>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 联系方式： </label>
					<div class="col-sm-9">
						<span class="grey ztb_change_phone"></span>
					</div>
				</div> -->
				<div class="form-group">
					<h5 class="col-sm-4 no-padding-right" align="right">经办部门：</h5>
					<h5 class="grey col-sm-8 ztb_change_operationDepartName"></h5>
				</div>
				<div class="space-4"></div>
				<div class="form-group">
					<h5 class="col-sm-4 no-padding-right" align="right">经办人：</h5>
					<h5 class="grey col-sm-8 ztb_change_operatorName"></h5>
				</div>
				<div class="space-4"></div>
				<div class="form-group">
					<h5 class="col-sm-4 no-padding-right" align="right">拉黑日期：</h5>
					<h5 class="grey col-sm-8 ztb_change_operatorDate"></h5>
				</div>
				<div class="space-4"></div>
				<div class="form-group">
					<h5 class="col-sm-4 no-padding-right" align="right">拉黑原因：</h5>
					<h5 class="grey col-sm-7 ztb_change_operationDescription" style="line-height:26px;"></h5>
				</div>
				<div class="space-4"></div>
				<div class="form-group">
					<h5 class="col-sm-4 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i> 移出黑名单原因： </h5>
					<div class="col-sm-8">
						<textarea class="col-xs-10 col-sm-10 ztb_change_url validate[required,maxSize[200]]"  name="cancelDescription" rows="8"></textarea>
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
				