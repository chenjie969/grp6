<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="editmodule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改菜单</h4>
      </div>
      <div class="modal-body">

			<form class="form-horizontal" role="form" id="edit_form">
				<input type="hidden" name="mod_uid" class="ztb_edit_mod_uid" id="edit_mod_uid">
				<input type="hidden" name="pmod_id" class="ztb_edit_pmod_id">
				<input type="hidden" name="title" class="ztb_edit_title">
				<input type="hidden" name="iframe" class="ztb_edit_iframe">
				<input type="hidden" name="iconopen" class="ztb_edit_iconopen">
				<input type="hidden" name="isopen" class="ztb_edit_isopen">
				<input type="hidden" name="order_id" class="ztb_edit_order_id">
				<input type="hidden" name="update_user" class="ztb_edit_update_user">
				<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>菜单名称： </label>
					<div class="col-sm-9">
						<input type="text" name="mod_name" id="edit_mod_name"  class="col-xs-10 col-sm-11 ztb_edit_mod_name validate[required,maxSize[50]]" />
					</div>
				</div>
				<div class="space-4"></div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-select-1"> 菜单图标： </label>
					<div class="col-sm-9" >
						<div class="row">
							<div class="col-xs-10 col-sm-11" id="edit_wraper">
								<input type="text" name="icon" class="ztb_edit_icon icon-picker" />
							</div>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> <i class="icon-asterisk orange"></i>菜单URL： </label>
					<div class="col-sm-9">
						<textarea class="col-xs-10 col-sm-11 autosize-transition ztb_edit_url validate[required,maxSize[200]]"  name="url" ></textarea>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-select-1"> <i class="icon-asterisk orange"></i>是否自动刷新： </label>
					<div class="col-sm-9">
						<select class="col-xs-10 col-sm-11 ztb_edit_isReload"  name="isReload" id="form-field-select-1">
							<option value="0">否</option>
							<option value="1">是</option>
						</select>
					</div>
				</div>
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit"><i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default btn_reset"> <i class='icon-repeat bigger-110'></i>重置</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
				