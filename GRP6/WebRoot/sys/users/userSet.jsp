<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="editmodule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button id="editmodule_pageClose" type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">个人设置</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="edit_form">
			<input type="hidden" name="user_uid"  value="${user.user_uid}">
			<input type="hidden" id="userSetOldPassword"  value="${user.userpassword}">
			
			
			<%-- <div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">所属机构：</label>
				<textarea style="display: none;" name="unit_uidName">${user.unit_uidName}</textarea>
				<label class="col-sm-9 " for="form-field-1">${user.unit_uidName}</label>
			</div> --%>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">所属部门：</label>
				<textarea style="display: none;" name="depart_name">${user.depart_name}</textarea>
				<label  class="col-xs-10 col-sm-9  ">${user.depart_name}</label>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">用户姓名：</label>
				<label class="col-sm-9 " for="form-field-1">${user.user_name}</label>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">登录帐号：</label>
				<label class="col-sm-9 " for="form-field-1">${user.user_id}</label>
			</div>
			
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>原密码：</label>
				<div class="col-sm-9">
					<input type="password" class="col-xs-10 col-sm-8 validate[required,maxSize[50],funcCall[oldPasswordvalidate]]" value="" />
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>新密码：</label>
				<div class="col-sm-9">
					<input type="password" name="userpassword" id="userSetPassword"   class="col-xs-10 col-sm-8 validate[required,maxSize[50],funcCall[newPasswordvalidate]]" value="${user.userpassword}" />
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>确认新密码：</label>
				<div class="col-sm-9">
					<input type="password"  id="userSetPassword2"  class="col-xs-10 col-sm-8 validate[required,maxSize[50],equals[userSetPassword]]" value="${user.userpassword}"/>
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
		</form>
      </div>
      <div class="modal-footer ">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" id="btn_editmodule_pageClose" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					