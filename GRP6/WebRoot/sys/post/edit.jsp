<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="editPost" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改岗位</h4>
      </div>
      <div class="modal-body">
			<form class="form-horizontal" role="form" id="edit_post_form">
				<input type="hidden" name="post_ID" class="ztb_edit_post_ID" id="edit_post_ID">
				<input type="hidden" name="parentPostID" class="ztb_edit_parentPostID">
				<input type="hidden" name="unit_uid" class="ztb_edit_unit_uid">
				<input type="hidden" name="postFullCode" class="ztb_edit_postFullCode">
				<input type="hidden" name="postCode" class="ztb_edit_postCode">
				<input type="hidden" name="isDelete" class="ztb_edit_isDelete">
				<input type="hidden" name="order_id" class="ztb_edit_order_id">
				<div class="space-4"></div>
				<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1">上级岗位名称： </label>
					<label id="ztb_edit_parentPostName" class="col-sm-9 ztb_edit_parentPostName"></label>
				</div>
				<div class="space-4"></div>
				<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>岗位代码： </label>
					<div class="col-sm-9">
						<input type="text" name="postName" id="edit_postName"  class="col-xs-10 col-sm-9 ztb_edit_postName validate[required,maxSize[50]]" />
					</div>
				</div>
				<div class="space-4"></div>
				<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1">岗位描述： </label>
					<div class="col-sm-9">
						<textarea name="postDescription" id="edit_postDescription"  
						class="col-xs-10 col-sm-9 ztb_edit_postDescription validate[maxSize[50]]" 
						></textarea>
						<div class="col-sm-9 no-padding-right">
							<span class="light-grey" style="float:right">限制25个字符</span>
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
				