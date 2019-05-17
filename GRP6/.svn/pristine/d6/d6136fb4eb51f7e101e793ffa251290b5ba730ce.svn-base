<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="editmodule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改项目组</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="edit_form">
			<input type="hidden" name="userGroup_uuid" value="${usergroup.userGroup_uuid}"  />
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>项目组名称： </label>
				<div class="col-sm-9">
					<input type="text" name="userGroupName" id="userGroupName" value="${usergroup.userGroupName}"  class="col-xs-10 col-sm-11   validate[required,maxSize[50]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">项目组人员： </label>
				<div class="col-sm-9">
					<div class="row">
						<div class="col-xs-10 col-sm-11 ">
							<div class="input-group select_user_tree_userGroup">
								<input class="form-control" autoField="user_uids" name="user_names" id="select_user_tree_userGroup" type="text" value="${usergroup.user_names}" dataValue="${usergroup.user_uids}" />
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110  "></i>
								</span>
							</div>
						</div>
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
					