<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="addmodule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加字典</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="add_form">
			<input type="hidden" name="dicTypePID" class="ztb_add_dicTypePID" >
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 上级字典名称： </label>
				<label class="col-sm-9 ztb_add_up_dicTypeName"></label>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i> 字典名称： </label>
				<div class="col-sm-9">
					<input type="text" name="dicTypeName" id="add_dicTypeName"  class="col-xs-10 col-sm-8 ztb_add_dicTypeName ztb_add validate[required,maxSize[50]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>是否可用： </label>
				<div class="col-sm-9">
					<div class="radio">
						<label>
							<input type="radio" name="isEable" id="add_iseable"	  checked="checked" class="ace form-field-radio" value="0"/>
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
					<textarea class="col-xs-10 col-sm-8 ztb_add_url ztb_add validate[maxSize[200]]" rows="10" name="remark" ></textarea>
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
					