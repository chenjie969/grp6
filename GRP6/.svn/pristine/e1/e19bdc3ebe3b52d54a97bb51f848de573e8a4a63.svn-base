<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="InventoryEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改存货</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="edit_inventoryFrom">
			<input type="hidden" name="client_ID" class="ztb_edit_client_ID client_ID" value="">
			<input type="hidden" name="inventory_ID" class="ztb_edit_inventory_ID" id="inventory_ID">
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>存货名称： </label>
				<div class="col-sm-9">
					<input type="text" name="inventoryName" id="edit_inventoryName" class="col-xs-10 col-sm-11 ztb_edit_inventoryName ztb_edit validate[required,maxSize[50]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>存货数量： </label>
				<div class="col-sm-9">
						<input type="text" name="inventoryCount" id="edit_inventoryCount" class="col-xs-10 col-sm-11 ztb_edit_inventoryCount ztb_edit validate[required,maxSize[18],custom[number]]" />
					</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>目前市场单价： </label>
				<div class="col-sm-9">
						<input type="text" name="inventoryPrice" id="edit_inventoryPrice"  class="col-xs-8 col-sm-9 ztb_edit_inventoryPrice ztb_edit validate[required,maxSize[18],custom[number]]" />
						<span class="midden  col-sm-3" style="line-height:28px;">万元</span>
					</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>存货金额： </label>
				<div class="col-sm-9">
					<input type="text" name="inventorySum" id="edit_inventorySum"  class="col-xs-8 col-sm-9 ztb_edit_inventorySum ztb_edit validate[required,maxSize[18],custom[number]]" />
					<span class="midden  col-sm-3" style="line-height:28px;">万元</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">备注： </label>
				<div class="col-sm-9">
					<textarea rows="5" class="col-xs-10 col-sm-11 ztb_edit_remark ztb_edit validate[maxSize[100]]" name="remark" id="edit_remark"></textarea>
					<span class="col-sm-5 light-grey col-sm-push-8">限制100个字符</span>
				</div>
			</div>
		</form>
			
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" id="saveInventoryEdit"><i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
				