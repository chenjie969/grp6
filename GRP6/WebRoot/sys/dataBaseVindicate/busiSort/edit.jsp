<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="editBusiSort" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改业务品种</h4>
      </div>
      <div class="modal-body">

			<form class="form-horizontal" role="form" id="edit_form">
				<input type="hidden" name="busisortid" class="ztb_edit_busisortid">
				<input type="hidden" name="unitUid" class="ztb_edit_unitUid">
				<input type="hidden" name="pbusisortid" class="ztb_edit_pbusisortid">
				<input type="hidden" name="busisortfullcode" class="ztb_edit_busisortfullcode">
				<input type="hidden" name="url" class="ztb_edit_url" >
				<input type="hidden" name="orderId" class="ztb_edit_orderId">
				<input type="hidden" name="createUser" class="ztb_edit_createUser" >
				<input type="hidden" name="updateUser" class="ztb_edit_updateUser">
				<input type="hidden" name="isedit" class="ztb_edit_isedit">
				<input type="hidden" name="isDefault" class="ztb_edit_isDefault">
			
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>业务品种名称： </label>
				<div class="col-sm-9">
					<input type="text" name="busisortname" id="edit_busisortname"  class="col-xs-10 col-sm-11 ztb_edit_busisortname ztb_edit validate[required,maxSize[50]]" />
				</div>
			</div>
	
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>所属业务大类： </label>
				<div class="col-sm-9">
					<select class="col-sm-6 btn_ztb_select ztb_edit_busiClass validate[required]" name="busiClass">
						<option value="01" id="busiClass01">担保</option>
						<option value="02" id="busiClass02">委贷</option>
					</select>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">对应监管机构业务品种编号： </label>
				<div class="col-sm-9">
					<input type="text" name="unificationid" id="edit_unificationid"  class="col-xs-10 col-sm-11 ztb_edit_unificationid ztb_edit validate[maxSize[50]]" />
				</div>
			</div>
			
			
			<div class="space-4"></div>
			<div class="form-group " >
				   	<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>状态：  </label>
         			<div class="col-sm-9">
						<div class="radio">
							<label>
								<input type="radio" name="iseable" id="edit_iseable0"  class="ace form-field-radio ztb_edit_iseable" value="0"/>
								<span class="lbl">启用</span>
							</label>
							<label>
								<input  type="radio" name="iseable"	 id="edit_iseable1" class="ace form-field-radio ztb_edit_iseable"  value="1" />
								<span class="lbl">禁用</span>
							</label>
						</div>
					</div>
	        </div>
				
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit"><i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
				