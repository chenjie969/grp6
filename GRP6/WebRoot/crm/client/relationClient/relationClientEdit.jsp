<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="editRelationClientModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改关联企业</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="edit_relationClientForm">
			<input type="hidden" name="relation_id" class="relation_id" value="">
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>关联关系描述：  </label>
			</div>
			<div class="form-group ">
				<label class="col-sm-1 control-label no-padding-right" for="form-field-1">&nbsp; </label>
				<div class="col-sm-11">
					<textarea class="col-xs-10 col-sm-10 limited ztb_add ztb_edit_relationDesc validate[required,maxSize[50]]"  rows="7" cols="20" name="relationDesc" id="edit_relationDesc"></textarea>
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