<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="addRelationClientModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加关联企业</h4>
      </div>
      <div class="modal-body">
			<form class="form-horizontal" role="form" id="add_relationClientForm">
				<input type="hidden" name="client_ID" class="client_ID"  value="">
				<input type="hidden" name="relationClientID" id="add_relation_clientID" value="">
				<div class="table-responsive"   id="loadinfo">
                     <table id="client-table" style="font-size:13px !important;"></table>  
                </div>
				<div class="space-4"></div>
           		<div class="form-group ">
                	<label class="col-sm-3 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>关联关系描述： </label>
					<div class="col-sm-9">	
						<textarea class="col-sm-10 limited ztb_add ztb_add_relationDesc validate[required]" name="relationDesc" id="select_relationDesc" maxlength="50"></textarea>
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
					