<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade bs-example-modal-sm" id="disMissionModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static"
	data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">编辑离职原因</h4>
			</div>
			<div class="modal-body">				
				<form class="form-horizontal" role="form" id="disMission_Form">
				<input type="hidden" id="staffcase_Id" name="staffcase_Id" value="${hrstaffCase.staffcase_Id}"/>
				<input type="hidden" id="user_uid" name="user_uid" value="${hrstaffCase.user_uid}"/>
				<input type="hidden" id="user_name" name="user_name" value="${hrstaffCase.user_name}"/>
					<div class="form-group">					
						<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>离职日期： </label>
						<div class="col-sm-9">
							<div class="input-group col-sm-4" style="float: left;">
							<input type="text" class="form-control date-picker  ztb_add validate[custom[date]]" name="leavedate" id="id-date-picker-1"
									data-date-format="yyyy-mm-dd" value="${hrstaffCase.leavedate}" /> <span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>	
							</div>						
						</div>
					</div>	
						<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">离职原因：</label>
								<div class="col-sm-9">
							<textarea class="col-sm-10 limited  ztb_edit_dutyNotes validate[maxSize[50]]" rows="5" name="leavereason" id="edit_leavereason">${hrstaffCase.leavereason}</textarea>
							<div class="col-sm-10 no-padding-right">
								<span class="light-grey pull-right">限制250个字符</span>
							</div>
					</div>
					</div> 	
				
				
			</form>
			</div>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-primary btn_submit">
				<i class='icon-ok bigger-110'></i>保存
			</button>
			<button type="button" class="btn btn-default" data-dismiss="modal">
				<i class='icon-remove bigger-110'></i>关闭
			</button>
		</div>
	</div>
</div>

