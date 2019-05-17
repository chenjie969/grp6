<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="OtherReceivableEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改其它应收账款</h4>
      </div>
      <div class="modal-body">
			<form class="form-horizontal" role="form" id="edit_otherReceivableFrom">
			<input type="hidden" name="client_ID" class="ztb_edit_client_ID client_ID" value="">
			<input type="hidden" name="otherReceivable_ID" class="ztb_edit_otherReceivable_ID" id="otherReceivable_ID">
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>应收客户名称： </label>
				<div class="col-sm-9">
					<input type="text" name="customerName" id="edit_customerName" class="col-xs-10 col-sm-11 ztb_edit_customerName ztb_edit validate[required,maxSize[50]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>发生时间： </label>
				<div class="col-sm-9">
						<div class="row">
							<div class="col-sm-8">
								<div class="input-group">
									<input  type="text" class="form-control date-picker ztb_edit_occurDate ztb_edit validate[required,custom[date]]" 
									name="occurDate" data-date-format="yyyy-mm-dd" />
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
					</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2">实际应还款时间： </label>
				<div class="col-sm-9">
						<div class="row">
							<div class="col-sm-8">
								<div class="input-group">
									<input  type="text" class="form-control date-picker ztb_edit_payDate ztb_edit validate[custom[date]]" 
									name="payDate"   data-date-format="yyyy-mm-dd" />
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
					</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>应收金额： </label>
				<div class="col-sm-9">
					<input type="text" name="taxSum" id="edit_taxSum"  class="col-xs-8 col-sm-9 ztb_edit_taxSum ztb_edit validate[required,custom[number],maxSize[18]]" />
					<span class="midden  col-sm-3" style="line-height:28px;">万元</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 备注： </label>
				<div class="col-sm-9">
					<textarea rows="5" class="col-xs-10 col-sm-11 ztb_edit_remark ztb_edit validate[maxSize[100]]" name="remark" id="edit_remark"></textarea>
					<span class="col-sm-5 light-grey col-sm-push-8">限制100个字符</span>
				</div>
			</div>
			
		</form>
			
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" id="saveOtherReceivableEdit"><i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
				