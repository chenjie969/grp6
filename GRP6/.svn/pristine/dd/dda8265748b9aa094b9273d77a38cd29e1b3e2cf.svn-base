<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="editCompanyBankAccountInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改开户信息</h4>
      </div>
      <div class="modal-body">

			<form class="form-horizontal" role="form" id="edit_CompanyBankAccountInfo">
				<input type="hidden" name="client_ID" class="ztb_edit_client_ID" id="bankAccount_client_ID">
				<input type="hidden" name="clientTypeID" class="ztb_edit_clientTypeID" id="bankAccount_clientTypeID">
				<input type="hidden" name="bankaccountId" class="ztb_edit_bankaccountId" id="bankAccount_bankaccountId">
				
				<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>账户类别： </label>
				<div class="col-sm-9">
					<input type="text" name="accounttype" id="edit_accounttype"  class="col-xs-10 col-sm-11 ztb_edit_accounttype  validate[required,maxSize[50]]" />
				</div>
			</div>
			
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>开户行： </label>
				<div class="col-sm-9">
					<input type="text" name="bankname" id="edit_bankname"  class="col-xs-10 col-sm-11 ztb_edit_bankname  validate[required,maxSize[50]]" />
				</div>
			</div>
	
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>账号： </label>
				<div class="col-sm-9">
					<input type="text" name="accountnumber" id="edit_accountnumber"  class="col-xs-10 col-sm-11 ztb_edit_accountnumber  validate[required,custom[number],maxSize[20]]" />
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>账户余额： </label>
				<div class="col-sm-9">
					<input type="text" name="accountsum" id="edit_accountsum"  class="col-xs-10 col-sm-9 ztb_edit_accountsum  validate[required,custom[number],maxSize[50]]" />
					<span class="midden col-sm-3 " style="line-height:28px;">万元</span>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 备注： </label>
				<div class="col-sm-9">
					<textarea name="remark" id="edit_remark"  class="col-xs-10 col-sm-11 ztb_edit_remark ztb_edit validate[maxSize[200]]"  style="height:94px;width:387px;"></textarea>
				</div>
				<div class="col-sm-11  no-padding-right">
					<span class="light-grey" style="float:right">限制200个字符</span>
				</div>
			</div>
				
				
			<!-- 	<div class="col-sm-8">
					<textarea class="col-xs-10 col-sm-8 ztb_add_clientSourceDesc ztb_add validate[maxSize[50]]"  name="clientSourceDesc" id="add_clientSourceDesc"  ></textarea>
				</div>
				 -->
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" id="saveEditCompanyBankAccount" class="btn btn-primary btn_submit"><i class='icon-ok bigger-110' ></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
				