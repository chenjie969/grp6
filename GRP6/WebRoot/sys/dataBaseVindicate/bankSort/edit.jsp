<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="editBankSort" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改银行字典</h4>
      </div>
      <div class="modal-body">

			<form class="form-horizontal" role="form" id="edit_form">
				<input type="hidden" name="unitUid" class="ztb_edit_unitUid" >
				<input type="hidden" name="pbanksortid" class="ztb_edit_pbanksortid">
				<input type="hidden" name="banksortid" class="ztb_edit_banksortid">
				<input type="hidden" name="bankfullcode" class="ztb_edit_bankfullcode">
				<input type="hidden" name="url" class="ztb_edit_url">
				<input type="hidden" name="isedit" class="ztb_edit_isedit" >
				<input type="hidden" name="orderId" class="ztb_edit_orderId" >
				<input type="hidden" name="updateUser" class="ztb_edit_updateUser" >
				<input type="hidden" name="createUser" class="ztb_edit_createUser" >
				<input type="hidden" name="createdatetime" class="ztb_edit_createdatetime" >
				<input type="hidden" name="isDefault" class="ztb_edit_isDefault" >
				
				<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>银行字典名称： </label>
					<div class="col-sm-9">
						<input type="text" name="banksortname" id="edit_banksortname"  class="col-xs-10 col-sm-11 ztb_edit_banksortname validate[required,maxSize[50]]" />
					</div>
				</div>
				<div class="space-4"></div>
				<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1">对应监管机构银行编号： </label>
					<div class="col-sm-9" >
						<input type="text" name="unificationid" id="edit_unificationid"  class="col-xs-10 col-sm-11 ztb_edit_unificationid validate[maxSize[50]]" />
					</div>
				</div>
				
				<div class="space-4"></div>
				<div class="form-group" >
				   	<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>状态：  </label>
         			<div class="col-sm-9">
						<div class="radio">
							<label>
								<input type="radio" name="iseable" id="edit_iseable0" class="ace form-field-radio ztb_edit_iseable"  value="0"/>
								<span class="lbl">启用</span>
							</label>
							<label>
								<input  type="radio" name="iseable"	id="edit_iseable1" class="ace form-field-radio ztb_edit_iseable"  value="1" />
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
				