<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="editSpouseModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改配偶信息</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="edit_spouseForm">
			<input type="hidden" name="client_ID" class="client_ID" value="" />
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>姓名： </label>
				<div class="col-sm-8">
					<input type="text" name="spouseName" id="edit_spouseName"  class="col-xs-10 col-sm-12 ztb_edit_spouse_spouseName ztb_edit_spouse validate[required,maxSize[10]]" />
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2">身份证号码： </label>
				<div class="col-sm-8">
					<input type="text" name="personNum" id="edit_personNum"  class="col-xs-10 col-sm-12 ztb_edit_spouse_personNum ztb_edit_spouse validate[minSize[18],maxSize[18]]" />
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2">联系方式： </label>
				<div class="col-sm-8">
					<input type="text" name="contact" id="edit_contact"  class="col-xs-10 col-sm-12 ztb_edit_spouse_contact ztb_edit_spouse validate[maxSize[20]]" />
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2"></i>单位名称： </label>
				<div class="col-sm-8">
					<input type="text" name="unitName" id="edit_unitName"  class="col-xs-10 col-sm-12 ztb_edit_spouse_unitName ztb_edit_spouse validate[maxSize[25]]" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-2">单位地址： </label>
				<div class="col-sm-10">
					<textarea class="col-sm-9 limited ztb_edit_spouse ztb_edit_spouse_unitAddress validate[maxSize[25]]"  name="unitAddress"	 id="edit_unitAddress"></textarea>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2">单位邮编： </label>
				<div class="col-sm-8">
					<input type="text" name="unitPost" id="edit_unitPost"  class="col-xs-10 col-sm-12 ztb_edit_spouse_unitPost ztb_edit_spouse validate[maxSize[6]]" />
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2">单位电话： </label>
				<div class="col-sm-8">
					<input type="text" name="unitPhone" id="edit_unitPhone"  class="col-xs-10 col-sm-12 ztb_edit_spouse_unitPhone ztb_edit_spouse validate[maxSize[20]]" />
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2">&nbsp;</label>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2">税后收入： </label>
				<div class="col-sm-8">
					<input type="text" name="monthIncome"" id="edit_monthIncome""  class="col-xs-10 col-sm-8 ztb_edit_spouse_monthIncome ztb_edit_spouse validate[custom[number],maxSize[10]]" />
					<span class="midden col-sm-2" style="line-height:28px;">元</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-2">备注： </label>
				<div class="col-sm-10">
					<textarea class="col-sm-11 limited ztb_edit_spouse ztb_edit_spouse_remark validate[maxSize[100]]"  name="remark" id="edit_remark"></textarea>
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