<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="modal fade" id="InventoryAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加存货</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="add_inventoryFrom">
			<input type="hidden" name="client_ID" class="ztb_add_client_ID client_ID" value="">
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>存货名称： </label>
				<div class="col-sm-9">
					<input type="text" name="inventoryName" id="add_inventoryName" class="col-xs-10 col-sm-11 ztb_add_inventoryName ztb_add validate[required,maxSize[50]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>存货数量： </label>
				<div class="col-sm-9">
						<input type="text" name="inventoryCount" id="add_inventoryCount" class="col-xs-10 col-sm-11 ztb_add_inventoryCount ztb_add validate[required,custom[number],maxSize[18]]" />
					</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>目前市场单价： </label>
				<div class="col-sm-9">
						<input type="text" name="inventoryPrice" id="add_inventoryPrice"  class="col-xs-8 col-sm-9 ztb_add_inventoryPrice ztb_add validate[required,custom[number],maxSize[18]]" />
						<span class="midden  col-sm-3" style="line-height:28px;">万元</span>
					</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>存货金额： </label>
				<div class="col-sm-9">
					<input type="text" name="inventorySum" id="add_inventorySum"  class="col-xs-8 col-sm-9 ztb_add_inventorySum ztb_add validate[required,custom[number],maxSize[18]]" />
					<span class="midden  col-sm-3" style="line-height:28px;">万元</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 备注： </label>
				<div class="col-sm-9">
					<textarea rows="5" class="col-xs-10 col-sm-11 ztb_add_remark ztb_add validate[maxSize[100]]" name="remark" id="add_remark"></textarea>
					<span class="col-sm-5 light-grey col-sm-push-8">限制100个字符</span>
				</div>
			</div>
			
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" id="saveInventoryAdd" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					