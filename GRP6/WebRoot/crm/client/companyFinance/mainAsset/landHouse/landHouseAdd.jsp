<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="modal fade" id="LandHouseAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加土地、厂房、名下房产</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="add_landHouseFrom">
			<input type="hidden" name="client_ID" class="ztb_add_client_ID client_ID" value="">
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>名称： </label>
				<div class="col-sm-9">
					<input type="text" name="landHouseName" id="add_landHouseName" class="col-xs-10 col-sm-11 ztb_add_landHouseName ztb_add validate[required,maxSize[50]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>位置： </label>
				<div class="col-sm-9">
						<input type="text" name="landHousePosition" id="add_landHousePosition" class="col-xs-10 col-sm-11 ztb_add_landHousePosition ztb_add validate[required,maxSize[50]]" />
					</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>面积： </label>
				<div class="col-sm-9">
						<input type="text" name="landHouseArea" id="add_landHouseArea"  class="col-xs-8 col-sm-9 ztb_add_landHouseArea ztb_add validate[required,custom[number],maxSize[18]]" />
						<span class="midden  col-sm-3" style="line-height:28px;">㎡</span>
					</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>购买价： </label>
				<div class="col-sm-9">
					<input type="text" name="buyPrice" id="add_buyPrice"  class="col-xs-8 col-sm-9 ztb_add_buyPrice ztb_add validate[required,custom[number],maxSize[18]]" />
					<span class="midden  col-sm-3" style="line-height:28px;">万元</span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>是否有证： </label>
				<div class="col-sm-9">
					<div class="radio ztb_add_isCertificate ztb_add" id="add_isCertificate" >
						<label>
							<input  name="isCertificate"  type="radio" class="ace" value="1" checked/>
							<span class="lbl">是</span>
						</label>
					   <label>
							<input  name="isCertificate"  type="radio" class="ace" value="0"/>
							<span class="lbl">否</span>
						</label>                                    
					</div>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>状态： </label>
				<div class="col-sm-9">
					<input type="text" name="status" id="add_status"  class="col-xs-10 col-sm-11 ztb_add_status ztb_add validate[required,maxSize[100]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">贷款行： </label>
				<div class="col-sm-9">
					<input type="text" name="loanBank" id="add_loanBank"  class="col-xs-10 col-sm-11 ztb_add_loanBank ztb_add validate[maxSize[100]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">抵押金额： </label>
				<div class="col-sm-9">
					<input type="text" name="guarantySum" id="add_guarantySum"  class="col-xs-8 col-sm-9 ztb_add_guarantySum ztb_add validate[custom[number],maxSize[18]]" />
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
        <button type="button" id="saveLandHouseAdd" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					