<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="addBusiSort" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加业务品种</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="add_form">
			<input type="hidden" name="busisortid" class="ztb_add_busisortid">
			<input type="hidden" name="unitUid" class="ztb_add_unitUid" value="1">
			<input type="hidden" name="pbusisortid" class="ztb_add_pbusisortid" id="add_pbusisortid">
			<input type="hidden" name="busisortfullcode" class="ztb_add_busisortfullcode" id="busisortfullcode">
			<input type="hidden" name="url" class="ztb_add_url" value="#">
			<input type="hidden" name="orderId" class="ztb_add_orderId" value="1">
			<input type="hidden" name="createUser" class="ztb_add_createUser" value="1">
			<input type="hidden" name="updateUser" class="ztb_add_updateUser" value="1">
			<input type="hidden" name="isedit" class="ztb_add_isedit" value="1">
			<input type="hidden" name="isDefault" class="ztb_add_isDefault" value="0"><%--初始化的数据为系统自带,否则为页面自定义的--%>
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 上级业务品种名称： </label>
				<label class="col-sm-9 ztb_add_up_busiSortName"></label>
			</div>
			
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>业务品种名称： </label>
				<div class="col-sm-9">
					<input type="text" name="busisortname" id="add_busisortname"  class="col-xs-10 col-sm-11 ztb_add_mod_name ztb_add validate[required,maxSize[50]]" />
				</div>
			</div>
	
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>所属业务大类： </label>
				<div class="col-sm-9">
					<select class="col-sm-6 btn_ztb_select validate[required]" name="busiClass">
						<option value="01">担保</option>
						<option value="02">委贷</option>
					</select>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">对应监管机构业务品种编号： </label>
				<div class="col-sm-9">
					<input type="text" name="unificationid" id="add_unificationid"  class="col-xs-10 col-sm-11 ztb_add_unificationid ztb_add  validate[maxSize[50]]" />
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group" >
				   	<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>状态：  </label>
         			<div class="col-sm-9">
						<div class="radio">
							<label>
								<input type="radio" name="iseable" id="add_iseable"	 checked="checked"  class="ace form-field-radio" value="0"/>
								<span class="lbl">启用</span>
							</label>
							<label>
								<input  type="radio" name="iseable"	 class="ace form-field-radio"  value="1" />
								<span class="lbl">禁用</span>
							</label>
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
					