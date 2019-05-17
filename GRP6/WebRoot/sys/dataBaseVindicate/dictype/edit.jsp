<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="editmodule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改字典</h4>
      </div>
      <div class="modal-body">
			<form class="form-horizontal" role="form" id="edit_form">
				<input type="hidden" name="unit_uid" class="ztb_edit_unit_uid">
				<input type="hidden" name="dicTypeID" class="ztb_edit_dicTypeID">
				<input type="hidden" name="dicTypePID" class="ztb_edit_dicTypePID">
				<input type="hidden" name="order_id" class="ztb_edit_order_id">
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>字典名称： </label>
					<div class="col-sm-9">
						<input type="text" name="dicTypeName" id="edit_dicTypeName"  class="col-xs-10 col-sm-8 ztb_edit_dicTypeName validate[required,maxSize[50]]" />
					</div>
				</div>
				<div class="space-4"></div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>是否可用： </label>
					<div class="col-sm-9">
						<div class="radio">
							<label>
								<input type="radio" name="isEable" class="ace form-field-radio" value="0"/>
								<span class="lbl">启用</span>
							</label>
							<label>
								<input  type="radio" name="isEable"	 class="ace form-field-radio"  value="1" />
								<span class="lbl">禁用</span>
							</label>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 备注： </label>
					<div class="col-sm-9">
						<textarea class="col-xs-10 col-sm-8 ztb_edit_remark ztb_edit validate[maxSize[200]]" rows="10" name="remark" ></textarea>
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
				