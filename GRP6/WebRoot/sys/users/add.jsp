<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="addUserModule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加用户</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="add_user_form">
			<input type="hidden" name="depart_uid" class="ztb_add_depart_uid">
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">所属部门：</label>
				<label class="col-sm-9 ztb_add_up_depart_name"></label>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>登录帐号：</label>
				<div class="col-sm-9">
					<input type="text" name="user_id" id="add_user_id"  class="col-xs-10 col-sm-8 ztb_add_user_id ztb_add validate[required,maxSize[15]]" />
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>登录密码：</label>
				<div class="col-sm-9">
					<input type="password" name="userpassword" id="add_password"  class="col-xs-10 col-sm-8 ztb_add_userpassword ztb_add validate[required,maxSize[32]]" />
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>确认密码：</label>
				<div class="col-sm-9">
					<input type="password" id="repeatpwd"  class="col-xs-10 col-sm-8 ztb_add_userpassword ztb_add validate[required,equals[add_password],maxSize[32]]" />
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>用户姓名：</label>
				<div class="col-sm-9">
					<input type="text" name="user_name"   class="col-xs-10 col-sm-8 ztb_add_user_name ztb_add validate[required,maxSize[10]]" />
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2">员工类型：</label>
				<div class="col-sm-9">
					<select name="user_type" style="width: 100px;" class="col-xs-10 col-sm-8 ztb_add_user_type ">
							<option value="1" selected="selected">在职</option>
							<option value="2" >离职</option>
							<option value="3" >外部</option>
						</select>
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			
			<!-- <div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2">分配岗位：</label>
				<div class="col-sm-9">
					<select name="post_ID"  class="col-xs-10 col-sm-6 ztb_add_post_ID ztb_add">
					
					<span class="help-inline col-xs-12 col-sm-4"></span>
					<span class="help-inline col-xs-12 col-sm-4"></span>
					</select>
				</div>
			</div> -->
			
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2">是否允许登录：</label>
				<div class="col-sm-9">
					<select name="isactive" style="width: 100px;" class="col-xs-10 col-sm-8 ztb_add_isactive ">
						<option value="1" selected="selected">是</option>
						<option value="0" >否</option>
					</select>
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2">是否禁用：</label>
				<div class="col-sm-9">
					<select name="isEable" style="width: 100px;" class="col-xs-10 col-sm-8 ztb_add_isEable ">
						<option value="0" selected="selected">否</option>
						<option value="1">是</option>
					</select>
				<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			<!-- <div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2">是否是管理员：</label>
				<div class="col-sm-9">
					<div class="radio">
						<label>
							<input   type="radio"  name="isAdmin"  id="isAdmin1" class="ace  form-field-radio ztb_add_isAdmin ztb_add" value="1" />
							<span class="lbl">是</span>
						</label>
						<label>
							<input   type="radio" name="isAdmin" checked="checked" id="isAdmin0" class="ace  form-field-radio ztb_add_isAdmin ztb_add" value="0" />
							<span class="lbl">否</span>
						</label>
					</div>
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div> -->
		</form>
      </div>
      <div class="modal-footer ">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					