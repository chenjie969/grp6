<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" id="setDepartsLeaderModule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">设置部门负责人</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="set_departs_leader_form">
			<input type="hidden" name="depart_uid" value="${departs.depart_uid }">
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">部门名称： </label>
				<label  class="col-sm-9 ">${departs.depart_name }</label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>部门负责人：</label>
				<div class="col-sm-9">
					<input id="leve1_user_name" type="hidden" name="leve1_user_name" value="${departs.leve1_user_name}">
					<select name="leve1_user_id" class="col-xs-10 validate[required]" id="usersList">
						<option value="">&nbsp;请选择</option>
						<c:forEach items="${usersList}" var="users">
							<option value="${users.user_uid}" <c:if test="${users.user_uid == departs.leve1_user_id}">selected="selected"</c:if>>${users.user_name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" id="edit_departs_btn"> <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					