<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="addCooperation" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加下级合作机构</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="add_form">
			<input type="hidden" name="pbanksortid" class="ztb_add_pbanksortid">
			<input type="hidden" name="url" class="ztb_add_url" value="#">
			<input type="hidden" name="isedit" class="ztb_add_isedit" value="1">
			<input type="hidden" name="orderId" class="ztb_add_orderId" value="1">
			<input type="hidden" name="isDefault" class="ztb_add_isDefault" value="0">
				<input type="hidden" name="iseable" class="ztb_add_iseable" value="0"><%--是否禁用,默认启用 --%>
				
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">上级机构： </label>
				<label class="col-sm-9 ztb_add_up_banksortname"></label>
			</div>
			
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>合作机构名称： </label>
				<div class="col-sm-8">
					<input type="text" name="banksortname" id="add_banksortname"  class="col-xs-10 col-sm-11 ztb_add_banksortname ztb_add validate[required,maxSize[50]]" />
				</div>
			</div>
	
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">责任比例： </label>
				<div class="col-sm-5">
					<input type="text" name="zrScale" id="add_zrScale"  class="col-xs-10 col-sm-6 ztb_add_zrScale ztb_add validate[custom[number],maxSize[18]]" />
					<span class="midden col-sm-4 " style="line-height:28px;">%</span>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">保证金比例： </label>
				<div class="col-sm-5">
					<input type="text" name="bzScale" id="add_bzScale"  class="col-xs-10 col-sm-6 ztb_add_bzScale ztb_add validate[custom[number],maxSize[18]]" />
					<span class="midden col-sm-4 " style="line-height:28px;">%</span>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">缴存方式： </label>
				<div class="col-sm-5">
					<select class="col-sm-11  ztb_add_depositMethodID  select_depositMethodID  btn_ztb_select" name="depositMethodID">
					</select>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">授信额度： </label>
				<div class="col-sm-5">
					<input type="text" name="creditSum" id="add_creditSum"  class="col-xs-10 col-sm-6 ztb_add_creditSum ztb_add validate[custom[number],maxSize[18]]" />
					<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">授信起始日期： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-8">
							<div class="input-group">
								<input type="text" name="creditBeginDate" id="add_creditBeginDate" data-date-format="yyyy-mm-dd"  class=" date-picker form-control  ztb_add_creditBeginDate ztb_add validate[maxSize[50]]" />
								<span class="input-group-addon" >
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>	
					</div>	
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">授信到期日期： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-8">
							<div class="input-group">
								<input  type="text" name="creditEndDate" id="add_creditEndDate" data-date-format="yyyy-mm-dd"   class="date-picker form-control  ztb_add_creditEndDate ztb_add validate[maxSize[50]]" />
								<span class="input-group-addon" >
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">信贷偏好： </label>
				<div class="col-sm-8">
					<textarea rows="3" name="creditRemark" class="col-sm-11  ztb_add_creditRemark  ztb_add validate[maxSize[50]]"></textarea>
					<span class="col-sm-6 light-grey col-sm-push-8">限制50个字符</span>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">营业地址： </label>
				<div class="col-sm-8">
					<textarea rows="2" name="busiAddress" class="col-sm-11  ztb_add_busiAddress  ztb_add validate[maxSize[50]]"></textarea>
					<span class="col-sm-6 light-grey col-sm-push-8">限制50个字符</span>
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
					