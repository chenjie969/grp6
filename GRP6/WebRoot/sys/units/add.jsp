<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="addUnitsModule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加下级机构</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="add_form">
			<input type="hidden" name="punit_uid" class="ztb_add_punit_uid">
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 上级机构名称： </label>
				<label class="col-sm-9 ztb_add_up_unit_uidName"></label>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>机构名称：</label>
				<div class="col-sm-9">
					<input type="text" name="unit_uidName" id="add_unit_uidName"  class="col-xs-10 col-sm-8 ztb_add_unit_uidName ztb_add validate[required,maxSize[25]]" />
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>管理员账号：</label>
				<div class="col-sm-9">
					<input type="text" name="user_id" id="add_user_id"  class="col-xs-10 col-sm-8 ztb_add_user_id ztb_add validate[required,maxSize[25]]" />
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>登录密码：</label>
				<div class="col-sm-9">
					<input type="password" name="userpassword" id="add_password"  class="col-xs-10 col-sm-8 ztb_add_user_id ztb_add validate[required,maxSize[32]]" />
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>确认密码：</label>
				<div class="col-sm-9">
					<input type="password" id="repeatpwd"  class="col-xs-10 col-sm-8 ztb_add_user_id ztb_add validate[required,equals[add_password],maxSize[32]]" />
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			<!-- <div class="space-4"></div>
			<div class="form-group has-warning">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 机构编号全称： </label>
				<div class="col-sm-9">
					<input type="text" name="unit_uidFullCode" class="col-xs-10 col-sm-8 ztb_add_unit_uidFullCode ztb_add validate[required,maxSize[50]]" />
					<span class="help-inline col-xs-12 col-sm-4"><i class="icon-asterisk"></i><span class="midden">必填项</span></span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group has-warning">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">是否可禁用：</label>
				<div class="col-sm-9">
					<select name="isEable"   class="col-xs-10 col-sm-8 ztb_add_isEable ztb_add validate[required,maxSize[1]]">
							<option value="1" selected>是</option>
							<option value="0" >否</option>
						</select>
						
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group has-warning">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 系统自带还是用户自定义： </label>
				<div class="col-sm-9">
				<input type="text" name="contentType"   class="col-xs-10 col-sm-8 ztb_add_contentType ztb_add validate[required,maxSize[50]]" />
						<select name="contentType"   class="col-xs-10 col-sm-8 ztb_add_contentType ztb_add validate[required,maxSize[1]]">
							<option value="1" selected>系统自带</option>
							<option value="0" >用户自定义</option>
						</select>
					<span class="help-inline col-xs-12 col-sm-4"><i class="icon-asterisk"></i><span class="midden">必填项</span></span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group has-warning">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 统一编码： </label>
				<div class="col-sm-9">
					<input type="text" name="unificationID"   class="col-xs-10 col-sm-8 ztb_add_unificationID ztb_add validate[required,maxSize[50]]" />
					<span class="help-inline col-xs-12 col-sm-4"><i class="icon-asterisk"></i><span class="midden">必填项</span></span>
				</div>
			</div> -->
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					