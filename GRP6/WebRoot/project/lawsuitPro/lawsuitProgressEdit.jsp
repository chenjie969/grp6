<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-lg" id="lawsuitProgressEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog  modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改案件诉讼情况</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="edit_lawsuitProgressForm">
			<div class="form-group ">
				<input type="hidden" name="applyID" id="applyID" value="${lawsuitProgress.applyID}">
				<input type="hidden" name="lawsuitProgress_ID" value="${lawsuitProgress.lawsuitProgress_ID}">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>日期： </label>
				<div class="col-sm-5">
						<div class="row">
							<div class="col-sm-9">
								<div class="input-group">
									<input  type="text" class="form-control date-picker validate[required,custom[date]]" 
									name="workDate" id="id-date-picker-1"  data-date-format="yyyy-mm-dd"  value = "<fmt:formatDate pattern="yyyy-MM-dd" value="${lawsuitProgress.workDate}" />" />
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
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>案件阶段： </label>
				<div class="col-sm-5">
					<input type="text" name="workStatus"  class="col-sm-9 validate[required,maxSize[50]]" value="${lawsuitProgress.workStatus}"/>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>经办人： </label>
				<div class="col-sm-9">
					<div class="row">
						<div class="col-sm-5">
							<div class="input-group creatUser_id">
								<input  type="text"  class="form-control validate[required] " autoField="operationManID"   id="creatUser_id"  value="${lawsuitProgress.operationManName}" dataValue="${lawsuitProgress.operationManID}" name="operationManName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-input">描述： </label>
				<div class="col-sm-9">
					<textarea class="col-sm-10 validate[maxSize[200]]" rows="5" cols="80" name="workDesc" >${lawsuitProgress.workDesc}</textarea>
					<div class="col-sm-10 no-padding-right" style="text-align:right;">
						<span class="light-grey">限制200个字符</span>
					</div>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-input">备注： </label>
				<div class="col-sm-9">
					<textarea class="col-sm-10 validate[maxSize[200]]" rows="5" cols="80" name="remark" >${lawsuitProgress.remark}</textarea>
					<div class="col-sm-10 no-padding-right" style="text-align:right;">
						<span class="light-grey">限制200个字符</span>
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

