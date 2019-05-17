<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="editSelfHouseModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改自有住房情况</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="edit_selfHouseForm">
			<input type="hidden" name="client_ID" class="client_ID" value="" />
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>坐落： </label>
				<div class="col-sm-8">
					<input type="text" name="address" id="edit_address"  class="col-xs-12 col-sm-12 ztb_edit_house_address ztb_edit_house validate[required,maxSize[25]]" />
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>建筑面积： </label>
				<div class="col-sm-8">
					<input type="text" name="area" id="edit_area"  class="col-xs-10 col-sm-10 ztb_edit_house_area ztb_edit_house validate[required,maxSize[10]]" />
					<span class="midden col-sm-2" style="line-height:28px;">㎡</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2">权属类型： </label>
				<div class="col-sm-8">
					<input type="hidden" name="ownership" id="ownership"  class="ztb_edit_house_ownership"/>
					<select class="col-sm-10 col-md-7  ztb_edit_house_ownership ztb_edit_house select_ownership  btn_ztb_select"  class_name="ztb_edit_house_ownership" id="select_ownership" readonly="readonly">
					</select>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2">第三人姓名： </label>
				<div class="col-sm-8">
					<input type="text" name="thirdName" id="edit_thirdName"  class="col-xs-12 col-sm-12 ztb_edit_house_thirdName ztb_edit_house validate[maxSize[10]]" />
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2">身份证号码： </label>
				<div class="col-sm-8">
					<input type="text" name="personNum" id="edit_personNum"  class="col-xs-12 col-sm-12 ztb_edit_house_personNum ztb_edit_house validate[minSize[18],maxSize[18]]" />
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2">与借款人关系： </label>
				<div class="col-sm-8">
					<input type="text" name="relation" id="edit_relation"  class="col-xs-12 col-sm-12 ztb_edit_house_relation ztb_edit_house validate[maxSize[25]]" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-2">备注： </label>
				<div class="col-sm-10">
					<textarea class="col-sm-11 limited ztb_edit_house ztb_edit_house_remark validate[maxSize[100]]"  name="remark"	 id="edit_remark"></textarea>
					<div class="col-sm-1 col-xs-1"></div><!-- 占位用 -->
					<div class="col-sm-11 col-xs-11 no-padding-right">
						<span class="light-grey" style="float:right">限制100个字符</span>
					</div>
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