<%@ include file="/common_timestamp.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="returnDetailEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">追偿登记</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="edit_returnDetailForm">
			<input type="hidden" name="projectID" id="projectID" value="${returnDetail.projectID}">
			<input type="hidden" name="apply_ID" id="apply_ID" value="${returnDetail.apply_ID}">
			<input type="hidden" name="returnDetail_ID" id="returnDetail_ID" value="${returnDetail.returnDetail_ID}">
		
			<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>上报日期： </label>
				<div class="col-sm-8">
						<div class="row">
							<div class="col-sm-8">
								<div class="input-group">
									<input class="form-control date-picker   validate[required,custom[date]]" style="line-height:28px;" name="returnDate" id="id-date-picker-1" 
									type="text" data-date-format="yyyy-mm-dd"  value="<fmt:formatDate value="${returnDetail.returnDate}" type="time" timeStyle="full" pattern="yyyy-MM-dd"/>"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
					</div>
			</div>
			<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>追偿日期： </label>
				<div class="col-sm-8">
						<div class="row">
							<div class="col-sm-8">
								<div class="input-group">
									<input class="form-control date-picker   validate[required,custom[date]]" style="line-height:28px;" name="returnFactDate" id="id-date-picker-2" 
									type="text" data-date-format="yyyy-mm-dd"  value="<fmt:formatDate value="${returnDetail.returnFactDate}" type="time" timeStyle="full" pattern="yyyy-MM-dd"/>"/>
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
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>追偿金额 </label>
				<div class="col-sm-8">
					<input type="text" name="returnSum"  class="col-sm-6 validate[required,custom[number],maxSize[18]]" 
					value="<fmt:formatNumber value="${returnDetail.returnSum}" pattern="###.######"/>"/>
					<span class="midden col-sm-4" style="line-height:28px;">万</span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">其中： </label>
				<div class="col-sm-8">
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2">追偿本金： </label>
				<div class="col-sm-8">
					<input type="text" name="returnCapitalSum"   class="col-sm-6  validate[custom[number],maxSize[18]]" 
					value="<fmt:formatNumber value="${returnDetail.returnCapitalSum}" pattern="###.######"/>" />
					<span class="midden col-sm-4" style="line-height:28px;">万</span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2">追偿利息： </label>
				<div class="col-sm-8">
					<input type="text" name="returnInterestSum"  class="col-sm-6 validate[custom[number],maxSize[18]]" 
					value="<fmt:formatNumber value="${returnDetail.returnInterestSum}" pattern="###.######"/>" />
					<span class="midden col-sm-4" style="line-height:28px;">万</span>
				</div>
			</div>
			<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2">追偿其它： </label>
				<div class="col-sm-8">
					<input type="text" name="returnOtherSum"   class="col-sm-6 validate[custom[number],maxSize[18]]" 
					value="<fmt:formatNumber value="${returnDetail.returnOtherSum}" pattern="###.######"/>" />
					<span class="midden col-sm-4" style="line-height:28px;">万</span>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>经办人： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-8">
							<div class="input-group creatUser_id">
								<input  type="text"  class="form-control validate[required] " autoField="operationManID"   id="creatUser_id"  value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="operationManName" readonly="readonly"/>
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

