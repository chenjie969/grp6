<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="personOwnerAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增自然人信息</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="form_company">
			<input type="hidden" name="otherType" class="ztb_add_url" value="03">
			<input type="hidden" name="isOther" class="ztb_add_isedit" value="1">
			<input type="hidden" name="clientTypeID" class="ztb_add_isedit" value="03">
			<input type="hidden" name="isOptGaranty" class="isOptGaranty" value="1">
				
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>姓名： </label>
				<div class="col-sm-8">
					<input type="text" name="personName" id="personName"   class="col-xs-10 col-sm-11  validate[required,maxSize[50]]" />
				</div>
			</div>
	
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>身份证号： </label>
				<div class="col-sm-8">
					<input type="text" name="personNum"  class="col-xs-10 col-sm-11   validate[required,maxSize[18],minSize[18]]" />
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>手机号： </label>
				<div class="col-sm-8">
					<input type="text" name="phone"  class="col-xs-10 col-sm-11   validate[required,maxSize[50]]" />
				</div>
			</div>
	
			
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>现住地址： </label>
				<div class="col-sm-8">
					<input type="text" name="houseAddress"   class="col-xs-10 col-sm-11   validate[required,maxSize[50]]" />
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">邮编： </label>
				<div class="col-sm-8">
					<input type="text" name="zipCode"   class="col-xs-10 col-sm-11   validate[maxSize[6]]" />
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">传真： </label>
				<div class="col-sm-8">
					<input type="text" name="fax"  class="col-xs-10 col-sm-11   validate[maxSize[50]]" />
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
					