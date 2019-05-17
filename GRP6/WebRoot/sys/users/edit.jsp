<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="editUserModule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改用户</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="edit_form">
			<input type="hidden" name="user_uid" id="edit_user_uid" class="ztb_edit_user_uid">
			<input type="hidden" name="user_bh" id="edit_user_bh" class="ztb_edit_user_bh">
			<input type="hidden" id="departOldId" class="ztb_edit_depart_uid" name="departOldId" >
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">所属部门：</label>
				<label id="user_edit_depart_name" class="col-sm-9"></label>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				   	<label class="col-sm-3 control-label no-padding-right" for="form-input">新部门： </label>
			        <div class="col-sm-6">
						<div class="input-group departUid">
					         <!--  <input type="hidden"  class="ztb_edit_depart_name ">
					         <input type="hidden" class="ztb_edit_departUid "> -->
							 <input type="text"  class="form-control" autoField="departUid" style="line-height:28px;" id="departUid"  value="" dataValue="" name="depart_name" readonly="readonly"/>							
							 <span class="input-group-addon ">
								<i class="icon-caret-down bigger-110"></i>
							 </span>
						</div>
					</div>
             </div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>登录帐号：</label>
				<div class="col-sm-9">
					<input type="text" name="user_id" id="edit_user_id"  class="col-xs-10 col-sm-8 ztb_edit_user_id  validate[required,maxSize[50]]" />
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>登录密码：</label>
				<div class="col-sm-9">
					<input type="password" name="userpassword" id="edit_password"   class="col-xs-10 col-sm-8 ztb_edit_userpassword  validate[required,maxSize[50]]" />
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>确认密码：</label>
				<div class="col-sm-9">
					<input type="password"  id="edit_repeatpwd"  class="col-xs-10 col-sm-8 ztb_edit_userpassword  validate[required,equals[edit_password],maxSize[50]]" />
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>用户姓名：</label>
				<div class="col-sm-9">
					<input type="text" name="user_name"   class="col-xs-10 col-sm-8 ztb_edit_user_name  validate[required,maxSize[50]]" />
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2">员工类型：</label>
				<div class="col-sm-9">
					<select name="user_type" style="width: 100px;" class="col-xs-10 col-sm-8 ztb_edit_user_type  validate[required,maxSize[5]]">
							<option value="1" >在职</option>
							<option value="2" >离职</option>
							<option value="3" >外部</option>
						</select>
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			
			<!-- <div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2">分配岗位：</label>
				<div class="col-sm-9">
					<input type="hidden" name="postName" class="ztb_edit_postName  ztb_edit" id="defaultPostName">
					<select  name="post_ID"  class="col-xs-10 col-sm-6 ztb_edit_post_ID ztb_edit ">

					</select>
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div> -->
			
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2">是否允许登录：</label>
				<div class="col-sm-9">
					<select name="isactive" style="width: 100px;" class="col-xs-10 col-sm-8 ztb_edit_isactive">
						<option value="1">是</option>
						<option value="0">否</option>
					</select>
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2">是否禁用：</label>
				<div class="col-sm-9">
					<select name="isEable" style="width: 100px;" class="col-xs-10 col-sm-8 ztb_edit_isEable">
						<option value="1">是</option>
						<option value="0">否</option>
					</select>
					<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			<!-- <div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2">是否是管理员： </label>
				<div class="col-sm-9">
						<select name="isAdmin" class="col-xs-10 col-sm-8 ztb_edit_isAdmin  validate[required,maxSize[1]]">
							<option value="1" >是</option>
							<option value="0" >否</option>
						</select>
						<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2">是否是其他部门： </label>
				<div class="col-sm-9">col-xs-10 col-sm-8 ztb_edit_user_name  validate[required,maxSize[50]]
						<select name="is_otherdep" class="col-xs-10 col-sm-8 ztb_edit_is_otherdep  validate[required,maxSize[1]]">
							<option value="1" >是</option>
							<option value="0" >否</option>
						</select>
						<span class="help-inline col-xs-12 col-sm-4"></span>
				</div>
			</div> -->
		</form>
      </div>
      <div class="modal-footer ">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					