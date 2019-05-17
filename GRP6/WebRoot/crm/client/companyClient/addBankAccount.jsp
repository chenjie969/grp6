<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="addCompanyBankAccountInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加开户信息</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="add_BankAccountInfo">
			<input type="hidden" name="client_ID" class="ztb_add_client_ID" id="bankAccount_client_ID">
			<input type="hidden" name="clientTypeID" class="ztb_add_clientTypeID" id="bankAccount_clientTypeID">
			
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>账户类别： </label>
				<div class="col-sm-9">
					<input type="text" name="accounttype" id="add_accounttype"  class="col-xs-10 col-sm-11 ztb_add_accounttype ztb_add validate[required,maxSize[50]]" />
				</div>
			</div>
			
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>开户行： </label>
				<div class="col-sm-9">
					<input type="text" name="bankname" id="add_bankname"  class="col-xs-10 col-sm-11 ztb_add_bankname ztb_add validate[required,maxSize[50]]" />
				</div>
			</div>
	
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>账号： </label>
				<div class="col-sm-9">
					<input type="text" name="accountnumber" id="add_accountnumber"  class="col-xs-10 col-sm-11 ztb_add_accountnumber ztb_add validate[required,custom[number],maxSize[20]]" />
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>账户余额： </label>
				<div class="col-sm-9">
					<input type="text" name="accountsum" id="add_accountsum"  class="col-xs-10 col-sm-9 ztb_add_accountsum ztb_add validate[required,custom[number],maxSize[50]]" />
					<span class="midden col-sm-3 " style="line-height:28px;">万元</span>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 备注： </label>
				<div class="col-sm-9">
					<textarea type="text" name="remark" id="add_remark"  class="col-xs-10 col-sm-11 ztb_add_remark ztb_add validate[maxSize[200]]" style="height:94px;width:387px;"></textarea>
				</div>
				<div class="col-sm-11  no-padding-right">
					<span class="light-grey" style="float:right">限制200个字符</span>
				</div>
			</div>
			
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" id="saveBankAccountInfo" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					