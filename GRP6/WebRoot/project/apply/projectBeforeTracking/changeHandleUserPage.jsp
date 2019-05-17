<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade bs-example-modal-sm" id="changeHandleUser_page" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">重新指派</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="changeHandleUser_form">
			 <input type="hidden" name="runTask_ID" class="runTask_ID" value="${runTask.runTask_ID}">
			<%-- <div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right">项目名称： </label>
                <label class="col-sm-9 grey">
                   	  ${apply.projectName}
                </label>
			</div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right">项目编号：</label>
                <label class="col-sm-9 grey">
                   	  ${apply.busiCode}
                </label>
			</div> --%>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right">任务名称：</label>
                <label class="col-sm-9 grey">
                   	  ${runTask.taskName}
                </label>
			</div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 指派前： </label>
				<label class="col-sm-9 grey">
                   	  ${runTask.handleUserName}
                </label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>指派后： </label>
				<div class="col-sm-9">
					<div class="row">
						<div class="col-sm-8">
							<div class="input-group handleUserid">
								<input  type="text"  class="form-control validate[required] " autoField="handleUserID"   id="handleUserid"  value="${runTask.handleUserName}" dataValue="${runTask.handleUserID}" name="handleUserName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
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
