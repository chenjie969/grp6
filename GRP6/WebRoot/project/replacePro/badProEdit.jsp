<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="badProEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">核销损失</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="badProEditForm">
			<input type="hidden" name="project_ID" id="project_ID" >
			<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>核销日期： </label>
				<div class="col-sm-8">
						<div class="row">
							<div class="col-sm-8">
								<div class="input-group">
									<input  type="text" class="form-control date-picker validate[required,custom[date]]" 
									name="badDate" id="id-date-picker-1"  data-date-format="yyyy-mm-dd" />
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
					</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>损失金额（万元）： </label>
				<div class="col-sm-8">
					<input type="text" name="badSum" class="col-sm-8 validate[required,custom[number],maxSize[50]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>经办人： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-8">
							<div class="input-group creatUser_id">
								<input  type="text"  class="form-control validate[required] " autoField="badUserID"   id="creatUser_id"  value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="badUserName" readonly="readonly"/>
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

