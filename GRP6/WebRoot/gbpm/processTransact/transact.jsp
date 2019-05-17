<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<div class="modal fade" id="taskTansact" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">任务办结</h4>
      </div>
      <div class="modal-body">
      <form class="form-horizontal"role="form"  id="nextTask_form">
      		<div class="table-responsive">
      		<table id="nodeTask_table" style="font-size:13px !important;"></table>
      		</div>
      		<%-- <c:forEach items="${nextTaskList}" var="nextTaskInfo" varStatus="status">
			<div class="space-4"></div>
			<div class="form-group">
				<!-- <label class="col-sm-3 control-label no-padding-right" for="form-field-1">办理人： </label> -->
				
				<div class="col-sm-1">
					<input data-index="0" name="btSelectItem" type="checkbox">
				</div>
				<label class="col-sm-6 control-label no-padding-right" for="form-field-1">${nextTaskInfo.nextTaskName} </label>
				<!-- <div class="col-sm-6">
					<div class="row">
						<select style="width: 200px; float: left;">
							<option value="">&nbsp;</option>
							<option value="AL">农业</option>
							<option value="AK">工业</option>
							<option value="AZ">信息业</option>

						</select>
					</div>
				</div> -->
				<div class="col-sm-5">
					<div class="row">
						<select style="width: 200px; float: left;">
							<option value="">&nbsp;</option>
							<option value="AL">农业</option>
							<option value="AK">工业</option>
							<option value="AZ">信息业</option>

						</select>
					</div>
				</div>
			</div>
			</c:forEach> --%>
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" ><i class='icon-ok bigger-110'></i>确认</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>取消</button>
      </div>
    </div>
  </div>
</div>
				