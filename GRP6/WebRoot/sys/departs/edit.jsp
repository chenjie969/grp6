<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" id="editDepartsModule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改部门</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="edit_departs_form">
			<input type="hidden" name="depart_uid" class="ztb_edit_depart_uid">
			<input type="hidden" name="unit_uid" class="ztb_edit_unit_uid">
			<input type="hidden" name="pdepart_id" class="ztb_edit_pdepart_id">
			<input type="hidden" name="url" class="ztb_edit_url">
			<input type="hidden" name="order_id" class="ztb_edit_order_id">
			<input type="hidden" name="leve1_user_id" class="ztb_edit_leve1_user_id">
			<input type="hidden" name="leve1_user_name" class="ztb_edit_leve1_user_name">
			<input type="hidden" name="leve2_user_id" class="ztb_edit_leve2_user_id">
			<input type="hidden" name="leve3_user_id" class="ztb_edit_leve3_user_id">
			<input type="hidden" name="createdatetime" class="ztb_edit_createdatetime">
			<input type="hidden" name="create_user" class="ztb_edit_create_user">
			<input type="hidden" name="depart_fullcode" class="ztb_edit_depart_fullcode">
			<input type="hidden" name="isRoot" class="ztb_edit_isRoot">
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>部门名称：</label>
				<div class="col-sm-9">
					<input type="text" name="depart_name" id="edit_depart_name"  class="col-xs-10 col-sm-8 ztb_edit_depart_name  validate[required,maxSize[25]]" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>类别：</label>
				<div class="col-sm-9">
					<select name="depart_type" id="edit_depart_type" class="col-xs-10 col-sm-8 ztb_edit_depart_type  validate[required,maxSize[25]]" >
						<option value="1" <c:if test="${(!empty depart_type) && depart_type ==1}"> selected ="selected "</c:if> > 子公司</option>
						<option value="2" <c:if test="${(!empty depart_type) && depart_type ==2}"> selected ="selected "</c:if> > 部&nbsp;门 </option>
					</select>
				</div>
			</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" id="edit_departs_btn"> <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					