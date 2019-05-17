<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="editUnitsModule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改机构</h4>
      </div>
      <div class="modal-body">

			<form class="form-horizontal" role="form" id="edit_form">
				<input type="hidden" name="unit_uid" class="ztb_edit_unit_uid">
				<input type="hidden" name="punit_uid" class="ztb_edit_punit_uid">
				<input type="hidden" name="unit_uidFullCode" class="ztb_edit_unit_uidFullCode">
				<input type="hidden" name="order_id" class="ztb_edit_order_id">
				<input type="hidden" name="isEable" class="ztb_edit_isEable">
				<input type="hidden" name="isDefault" class="ztb_edit_isDefault">
				<input type="hidden" name="unificationID" class="ztb_edit_unificationID">
				
				<div class="space-4"></div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1">上级机构名称：</label>
					<label id="ztb_edit_pUnitsName" class="col-sm-9 ztb_edit_pUnitsName"></label>
				</div>
				<div class="space-4"></div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>机构名称：</label>
					<div class="col-sm-9">
						<input type="text" name="unit_uidName" id="edit_unit_uidName"  class="col-xs-10 col-sm-8 ztb_edit_unit_uidName validate[required,maxSize[25]]" />
						<span class="help-inline col-xs-12 col-sm-4"></span>
					</div>
				</div>
				<!-- <div class="space-4"></div>
			<div class="form-group has-warning">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 机构编号全称： </label>
				<div class="col-sm-9">
					<input type="text" name="unit_uidFullCode" class="col-xs-10 col-sm-8 ztb_edit_unit_uidFullCode validate[required,maxSize[50]]" />
					<span class="help-inline col-xs-12 col-sm-4"><i class="icon-asterisk"></i><span class="midden">必填项</span></span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group has-warning">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 是否可禁用： </label>
				<div class="col-sm-9">
					<select name="isEable"   class="col-xs-10 col-sm-8 ztb_edit_isEable  validate[required,maxSize[1]]">
							<option value="1" selected>是</option>
							<option value="0" >否</option>
						</select>
					<span class="help-inline col-xs-12 col-sm-4"><i class="icon-asterisk"></i><span class="midden">必填项</span></span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group has-warning">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 系统自带还是用户自定义： </label>
				<div class="col-sm-9">
						<select name="contentType"   class="col-xs-10 col-sm-8 ztb_edit_contentType  validate[required,maxSize[1]]">
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
					<input type="text" name="unificationID" id="add_mod_name"  class="col-xs-10 col-sm-8 ztb_edit_unificationID validate[required,maxSize[50]]" />
					<span class="help-inline col-xs-12 col-sm-4"><i class="icon-asterisk"></i><span class="midden">必填项</span></span>
				</div>
			</div> -->
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
				