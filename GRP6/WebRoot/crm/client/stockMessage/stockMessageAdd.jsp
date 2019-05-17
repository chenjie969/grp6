<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="modal fade" id="stockMessageAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加股权信息</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="add_StockMessage">
			<input type="hidden" name="client_ID" class="ztb_add_client_ID client_ID" value="">
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>股东名称： </label>
				<div class="col-sm-9">
					<input type="text" name="stockname" id="add_stockname"  class="col-xs-10 col-sm-11 ztb_add_stockname ztb_add validate[required,maxSize[50]]" />
				</div>
			</div>
			
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>出资时间与方式： </label>
				<div class="col-sm-9">
				<!-- 	<input type="text" name="investtypetime" id="add_investtypetime"  class="col-xs-10 col-sm-11 ztb_add_investtypetime ztb_add validate[required,maxSize[50]]" /> -->
					<textarea type="text" name="investtypetime" id="add_investtypetime" rows="3" class="col-xs-10 col-sm-11 ztb_add_investtypetime ztb_add validate[required,maxSize[50]]" /></textarea
					<span class="col-sm-5 light-grey col-sm-push-8"></span>
				</div>
			</div>
	
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>出资金额： </label>
				<div class="col-sm-9">
					<input type="text" name="investsum" id="add_investsum"  class="col-xs-10 col-sm-9 ztb_add_investsum ztb_add validate[required,custom[number],maxSize[20]]" />
					<span class="midden col-sm-3 " style="line-height:28px;">万元</span>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>占比： </label>
				<div class="col-sm-9">
					<input type="text" name="investscale" id="add_investscale"  class="col-xs-10 col-sm-9 ztb_add_investscale ztb_add validate[required,custom[number],maxSize[50]]" />
					<span class="midden col-sm-3 " style="line-height:28px;">%</span>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 说明： </label>
				<div class="col-sm-9">
					<textarea rows="10" class="col-xs-10 col-sm-11 ztb_add_remark ztb_add validate[maxSize[2000]]" name="remark" id="add_remark"></textarea>
					<span class="col-sm-5 light-grey col-sm-push-8">限制2000个字符</span>
					<!-- <input type="text" name="remark" id="add_remark"  class="col-xs-10 col-sm-11 ztb_add_remark ztb_add" /> -->
				</div>
			</div>
			
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" id="saveStockMessageAdd" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					