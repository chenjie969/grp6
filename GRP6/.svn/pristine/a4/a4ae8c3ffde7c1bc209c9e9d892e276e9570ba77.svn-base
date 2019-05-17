<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="stockMessageEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改股权信息</h4>
      </div>
      <div class="modal-body">

			<form class="form-horizontal" role="form" id="edit_StockMessage">
			<input type="hidden" name="client_ID" class="ztb_edit_client_ID client_ID">
			<input type="hidden" name="stockId" class="ztb_edit_stockId" id="stockId">
			
			
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>股东名称： </label>
				<div class="col-sm-9">
					<input type="text" name="stockname" id="edit_stockname"  class="col-xs-10 col-sm-11 ztb_edit_stockname ztb_edit validate[required,maxSize[50]]" />
				</div>
			</div>
			
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>出资时间与方式： </label>
				<div class="col-sm-9">
					<!-- <input type="text" name="investtypetime" id="edit_investtypetime"  class="col-xs-10 col-sm-11 ztb_edit_investtypetime ztb_edit validate[required,maxSize[50]]" /> -->
					<textarea type="text" name="investtypetime" id="edit_investtypetime" rows="3"  class="col-xs-10 col-sm-11 ztb_edit_investtypetime ztb_edit validate[required,maxSize[50]]" ></textarea>
					<span class="col-sm-5 light-grey col-sm-push-8"></span>
				</div>
			</div>
	
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>出资金额： </label>
				<div class="col-sm-9">
					<input type="text" name="investsum" id="edit_investsum"  class="col-xs-10 col-sm-9 ztb_edit_investsum ztb_edit validate[required,custom[number],maxSize[18]]" />
					<span class="midden col-sm-3 " style="line-height:28px;">万元</span>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>占比： </label>
				<div class="col-sm-9">
					<input type="text" name="investscale" id="edit_investscale"  class="col-xs-10 col-sm-9 ztb_edit_investscale ztb_edit validate[required,custom[number],maxSize[50]]" />
					<span class="midden col-sm-3 " style="line-height:28px;">%</span>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 说明： </label>
				<div class="col-sm-9">
					<textarea rows="10" class="col-xs-10 col-sm-11 ztb_edit_remark  ztb_edit validate[maxSize[2000]]" name="remark" id="edit_remark"></textarea>
					<span class="col-sm-5 light-grey col-sm-push-8">限制2000个字符</span>
					<!-- <input type="text" name="remark" id="edit_remark"  class="col-xs-10 col-sm-11 ztb_edit_remark  ztb_edit" /> -->
				</div>
			</div>
			
		</form>
			
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" id="saveStockMessageEdit"><i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
				