<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="editmodule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改角色</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="edit_form">
			<input type="hidden" name="role_uid" value="${roles.role_uid}"  />
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>角色名称： </label>
				<div class="col-sm-9">
					<input type="text" name="role_name" id="role_name" value="${roles.role_name}"  class="col-xs-10 col-sm-11   validate[required,maxSize[30]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">角色描述： </label>
				<div class="col-sm-9">
					<input type="text" name="role_descr" id="role_descr" value="${roles.role_descr}"  class="col-xs-10 col-sm-11   validate[maxSize[50]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">人员： </label>
				<div class="col-sm-9">
					<div class="row">
						<div class="col-xs-10 col-sm-11 ">
							<div class="input-group select_user_tree_roles">
								<input class="form-control" autoField="user_uids" name="user_names" id="select_user_tree_roles" type="text" value="${roles.user_names}" dataValue="${roles.user_uids}" />
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110  "></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">岗位： </label>
				<div class="col-sm-9">
					<div class="row">
						<div class="col-xs-10 col-sm-11 ">
							<div class="input-group select_user_tree_post">
								<input class="form-control" autoField="post_IDs" name="postNames" id="select_user_tree_post" type="text" value="${roles.postNames}" dataValue="${roles.post_IDs}" />
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110  "></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">项目组： </label>
				<div class="col-sm-9">
					<div class="row">
						<div class="col-xs-10 col-sm-11 ">
							<div class="input-group select_user_tree_roles-userGroup">
								<input class="form-control" autoField="userGroup_uuids" name="userGroupNames" id="select_user_tree_roles-userGroup" type="text" value="${roles.userGroupNames}" dataValue="${roles.userGroup_uuids}" maxlength="204800"/>
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
					