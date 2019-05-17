<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="LandHouseEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改土地、厂房、名下房产</h4>
      </div>
      <div class="modal-body">
			<form class="form-horizontal" role="form" id="edit_landHouseFrom">
			<input type="hidden" name="client_ID" class="ztb_edit_client_ID client_ID" value="">
			<input type="hidden" name="landHouse_ID" class="ztb_edit_landHouse_ID" id="landHouse_ID">
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>名称： </label>
				<div class="col-sm-9">
					<input type="text" name="landHouseName" id="edit_landHouseName" class="col-xs-10 col-sm-11 ztb_edit_landHouseName ztb_edit validate[required,maxSize[50]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>位置： </label>
				<div class="col-sm-9">
					<textarea rows="3" class="col-xs-10 col-sm-11 ztb_edit_landHousePosition ztb_edit validate[required,maxSize[100]]" name="landHousePosition" id="edit_landHousePosition"></textarea>
					<span class="col-sm-5 light-grey col-sm-push-8">限制100个字符</span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>面积： </label>
				<div class="col-sm-9">
						<input type="text" name="landHouseArea" id="edit_landHouseArea"  class="col-xs-8 col-sm-9 ztb_edit_landHouseArea ztb_edit validate[required,custom[number],maxSize[18]]" />
						<span class="midden  col-sm-3" style="line-height:28px;">㎡</span>
					</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>购买价： </label>
				<div class="col-sm-9">
					<input type="text" name="buyPrice" id="edit_buyPrice"  class="col-xs-8 col-sm-9 ztb_edit_buyPrice ztb_edit validate[required,custom[number],maxSize[18]]" />
					<span class="midden  col-sm-3" style="line-height:28px;">万元</span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>是否有证： </label>
				<div class="col-sm-9">
					<div class="radio ztb_edit_isCertificate ztb_edit" id="edit_isCertificate" >
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
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">状态： </label>
				<div class="col-sm-9">
					<input type="text" name="status" id="edit_status"  class="col-xs-10 col-sm-11 ztb_edit_status ztb_edit validate[maxSize[100]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 贷款行： </label>
				<div class="col-sm-9">
					<input type="text" name="loanBank" id="edit_loanBank"  class="col-xs-10 col-sm-11 ztb_edit_loanBank ztb_edit validate[maxSize[100]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group"> 
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">抵押金额： </label>
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
        <button type="button" class="btn btn-primary btn_submit" id="saveLandHouseEdit"><i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
				