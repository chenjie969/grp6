<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="announceAddChildrenOrg" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加信息分类</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="add_form">
      	 	<input type="hidden" name="multilevelsortid" class="ztb_add_multilevelsortid">
			<input type="hidden" name="pmultilevelsortid" class="ztb_add_pmultilevelsortid">
			<input type="hidden" name="unitUid" class="ztb_add_unitUid" value="1">
			<input type="hidden" name="multilevelsortfullcode" class="ztb_add_multilevelsortfullcode">
			<input type="hidden" name="orderId" class="ztb_add_orderId" value="1">
			<input type="hidden" name="createUser" class="ztb_add_createUser" value="1">
			<input type="hidden" name="updateUser" class="ztb_add_updateUser" value="1">
			<input type="hidden" name="isedit" class="ztb_add_isedit" value="1">
			<input type="hidden" name="isDefault" class="ztb_add_isDefault" value="0">
		
			<div class="form-group">
			
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">上级分类名称： </label>
				<label class="col-sm-8 no-padding-right ztb_add_up_multilevelsortname" for="form-field-1"></label>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>下级分类名称： </label>
				<div class="col-sm-8">
					<input type="text" name="multilevelsortname" id="add_multilevelsortname" class="col-sm-8 ztb_add_multilevelsortname ztb_add validate[required,maxSize[50]]" />
				</div>
			</div>
		
			<!-- <div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">对应监管机构多级字典编号： </label>
				<div class="col-sm-8">
					<input type="text" name="unificationid" id="add_unificationid"  class="col-xs-10 col-sm-11 ztb_add_unificationid ztb_add  validate[maxSize[50]]" />
				</div>
			</div> -->
			
			<div class="space-4"></div>
			<div class="form-group" >
				   	<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>状态：  </label>
         			<div class="col-sm-8">
						<div class="radio">
							<label>
								<input type="radio" name="iseable" id="add_iseable"	  checked="checked" class="ace form-field-radio" value="0"/>
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
  
  	<div class="modal-footer ">
      	<button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
	</div>
</div>
					