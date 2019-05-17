<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="MachineEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改机器设备及车辆等</h4>
      </div>
      <div class="modal-body">
			<form class="form-horizontal" role="form" id="edit_machineFrom">
			<input type="hidden" name="client_ID" class="ztb_edit_client_ID client_ID" value="">
			<input type="hidden" name="machine_ID" class="ztb_edit_machine_ID" id="machine_ID">
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>财产名称： </label>
				<div class="col-sm-9">
					<input type="text" name="assetsName" id="edit_assetsName" class="col-xs-10 col-sm-11 ztb_edit_assetsName ztb_edit validate[required,maxSize[50]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>购入时间： </label>
				<div class="col-sm-9">
					<div class="row">
							<div class="col-sm-8">
								<div class="input-group">
									<input  type="text" class="form-control date-picker ztb_edit_buyDate ztb_edit validate[required,custom[date]]" 
									name="buyDate" data-date-format="yyyy-mm-dd" />
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
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>有无发票： </label>
				<div class="col-sm-9">
					<div class="radio ztb_edit_isBill ztb_edit" id="edit_isBill" >
						<label>
							<input  name="isBill"  type="radio" class="ace" value="1" checked/>
							<span class="lbl">有</span>
						</label>
					   <label>
							<input  name="isBill"  type="radio" class="ace" value="0"/>
							<span class="lbl">无</span>
						</label>                                    
					</div>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>原价： </label>
				<div class="col-sm-9">
						<input type="text" name="oldValue" id="edit_oldValue"  class="col-xs-8 col-sm-9 ztb_edit_oldValue ztb_edit validate[required,custom[number],maxSize[18]]" />
						<span class="midden  col-sm-3" style="line-height:28px;">万元</span>
					</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>余值： </label>
				<div class="col-sm-9">
					<input type="text" name="residualValue" id="edit_residualValue"  class="col-xs-8 col-sm-9 ztb_edit_residualValue ztb_edit validate[required,custom[number],maxSize[18]]" />
					<span class="midden  col-sm-3" style="line-height:28px;">万元</span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">状态： </label>
				<div class="col-sm-9">
					<input type="text" name="status" id="edit_status"  class="col-xs-10 col-sm-11 ztb_edit_status ztb_edit validate[maxSize[100]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">贷款行： </label>
				<div class="col-sm-9">
					<input type="text" name="loanBank" id="edit_loanBank"  class="col-xs-10 col-sm-11 ztb_edit_loanBank ztb_edit validate[maxSize[100]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 抵押金额： </label>
				<div class="col-sm-9">
					<input type="text" name="guarantySum" id="edit_guarantySum"  class="col-xs-8 col-sm-9 ztb_edit_guarantySum ztb_edit validate[maxSize[18]]" />
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
        <button type="button" class="btn btn-primary btn_submit" id="saveMachineEdit"><i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
				