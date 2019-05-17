<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" id="approvalPage" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">同意立项</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" id="form_approval">
					<input type="hidden" name="apply_ID" id="approvalPage_applyID">
					
					<div class="space-4"></div>
					<div class="form-group ">
						<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>项目名称： </label>
						<label class="col-sm-8"><span id="approvalPage_projectName" class="col-sm-12"></span></label>
					</div>
					
					<div class="space-4"></div>
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>指定项目经理A角： </label>
						<div class="col-sm-8">
							<div class="row">
								<div class=" col-sm-8 ">
									<div class="input-group approvalPage_Aman">
										<input  type="text"  class="form-control validate[required] " autoField="amanID"   id="approvalPage_Aman"  value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="amanName"  readonly="readonly"/>
										<span class="input-group-addon ">
											<i class="icon-caret-down bigger-110"></i>
										</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="space-4"></div>
					<div class="form-group ">
						<label class="col-sm-4 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>指定项目经理A角时间： </label>
						<div class="col-sm-8">
							<div class="row">
								<div class="col-sm-8">
									<div class="input-group">
										<input  type="text" class="form-control date-picker validate[required,custom[date]]" name="createDateTime"  id="approvalPage_AmanDate" data-date-format="yyyy-mm-dd" />
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
						<label class="col-sm-4 control-label no-padding-right" for="form-field-2">推荐意见： </label>
						<div class="col-sm-8">
							<textarea rows="5" class="col-xs-10 col-sm-8 ztb_add_clientSourceDesc ztb_add validate[maxSize[50]]"  name="clientSourceDesc" id="add_clientSourceDesc"  ></textarea>
						</div>
					</div>
					
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default btn-primary" data-dismiss="modal"> <i class='icon-ok bigger-110'></i>启动流程</button>
				<button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>取消</button>
			</div>
		</div>
	</div>
</div>
					