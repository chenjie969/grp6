<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="addmodule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加下级部门</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="add_departs_from">
			<input type="hidden" name="pdepart_id" class="ztb_add_pdepart_id">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 上级部门名称： </label>
				<label class="col-sm-9 ztb_add_up_depart_name"></label>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>部门名称：</label>
				<div class="col-sm-9">
					<input type="text" name="depart_name"  id="add_depart_name"  class="col-xs-10 col-sm-11 ztb_add_depart_name ztb_add validate[required,maxSize[25]]" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>类型：</label>
				<div class="col-sm-9">
					<!-- <input type="text" name="depart_name"  id="add_depart_name"  class="col-xs-10 col-sm-11 ztb_add_depart_name ztb_add validate[required,maxSize[25]]" /> -->
					<select name="depart_type" class="col-xs-10 col-sm-11 ztb_add_depart_type ztb_add validate[required,maxSize[25]]" >
						<option value="1"> 子公司</option>
						<option value="2"> 部&nbsp;门 </option>
					</select>
				</div>
			</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" id="add_departs"> <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					