<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="addmodule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加菜单</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="add_form">
			<input type="hidden" name="mod_type" class="ztb_add_mod_type">
			<input type="hidden" name="mod_uid" class="ztb_add_mod_uid">
			<input type="hidden" name="pmod_id" class="ztb_add_pmod_id">
			<input type="hidden" name="title" class="ztb_add_title">
			<input type="hidden" name="iframe" class="ztb_add_iframe">
			<input type="hidden" name="iconopen" class="ztb_add_iconopen">
			<input type="hidden" name="isopen" class="ztb_add_isopen">
			<input type="hidden" name="order_id" class="ztb_add_order_id" value="1">
			<input type="hidden" name="update_user" class="ztb_add_update_user" value="1">
			<input type="hidden" name="create_user" class="ztb_add_create_user" value="1">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">上级菜单名称： </label>
				<label class="col-sm-9 ztb_add_up_mod_name"></label>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>菜单名称： </label>
				<div class="col-sm-9">
					<input type="text" name="mod_name" id="add_mod_name"  class="col-xs-10 col-sm-11 ztb_add_mod_name ztb_add validate[required,maxSize[50]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-select-1"> 菜单图标： </label>
				<div class="col-sm-9" >
					<div class="row">
						<div class="col-xs-10 col-sm-11" id="add_wraper">
							<input type="text" name="icon" class="ztb_add_icon icon-picker" />
						</div>
					</div>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i> 菜单URL： </label>
				<div class="col-sm-9">
					<textarea class="col-xs-10 col-sm-11 ztb_add_url ztb_add validate[required,maxSize[200]]"  name="url" ></textarea>
				</div>
			</div>
			<div class="space-4"></div>
				<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-select-1"> <i class="icon-asterisk orange"></i>是否自动刷新： </label>
					<div class="col-sm-9">
						<select class="col-xs-10 col-sm-11 ztb_add_isReload" name="isReload"  id="form-field-select-1">
							<option value="0">否</option>
							<option value="1">是</option>
						</select>
					</div>
				</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					