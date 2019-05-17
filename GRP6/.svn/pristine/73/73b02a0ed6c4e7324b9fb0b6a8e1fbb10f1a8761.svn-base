<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<style type="text/css">

#add_meeting {
	overflow-y: scroll;
}
</style>
<div class="modal fade" id="add_meetResolution" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">添加评审会决议</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" id="meetResolution_form">
							<input type="hidden" name="applyID" value="${applyID}">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="resolutionCode"><i class="icon-asterisk orange"></i>决议编号：
								</label>
								<div class="col-sm-9">
									<input id="resolutionCode" name="resolutionCode" placeholder="决议编号"
										class="col-sm-6 ">
								</div>
							</div>

							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="meetingID"><i class="icon-asterisk orange"></i>评审会编号：</label>
								<div class="col-sm-9">
									<select class="col-sm-6" id="meetingID" name="meetingID">
										<option value="">--请选择--</option>
										<c:forEach var="meeting" items="${meetingList}" varStatus="status">
											<option value="${meeting.meeting_ID}">${meeting.meetingCode}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="shouldJury">参会人数：
								</label>
								<div class="col-sm-9">
									<input id="shouldJury" name="shouldJury" placeholder="参会人数" class="col-sm-6">
								</div>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="senseJury">实到人数：
								</label>
								<div class="col-sm-9">
									<input id="senseJury" name="senseJury" placeholder="实到人数" class="col-sm-6">
								</div>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="passJury">通过人数：
								</label>
								<div class="col-sm-9">
									<input id="passJury" name="passJury" placeholder="通过人数" class="col-sm-6">
								</div>
							</div>

							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="signed">签批决议：</label>
								<div class="col-sm-9">
									<textarea id="signed" name="signed" 
									class="col-sm-10 autosize-transitionl" placeholder="签批决议"></textarea>
								</div>
							</div>
							
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="processControl">过程控制：</label>
								<div class="col-sm-9">
									<textarea id="processControl" name="processControl" 
									class="col-sm-10 autosize-transitionl" placeholder="过程控制"></textarea>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="loanConditions">放款条件：</label>
								<div class="col-sm-9">
									<textarea id="loanConditions" name="loanConditions" 
									class="col-sm-10 autosize-transitionl" placeholder="放款条件"></textarea>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="feeStandard">收费标准：</label>
								<div class="col-sm-9">
									<textarea id="feeStandard" name="feeStandard" 
									class="col-sm-10 autosize-transitionl" placeholder="收费标准"></textarea>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="otherMatters">其他事项：</label>
								<div class="col-sm-9">
									<textarea id="otherMatters" name="otherMatters" 
									class="col-sm-10 autosize-transitionl" placeholder="其他事项"></textarea>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="monitoredAsking">在保监控要求：</label>
								<div class="col-sm-9">
									<textarea id="monitoredAsking" name="monitoredAsking" 
									class="col-sm-10 autosize-transitionl" placeholder="在保监控要求"></textarea>
								</div>
							</div>

							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="resolutionType">决议类型：</label>
									<div class="col-sm-9">
									<select class="col-sm-6" id="resolutionType" name="resolutionType">
											<option>--请选择--</option>
											<option value="01">初次</option>
											<option value="02">样本</option>
											<option value="03">正本</option>
											<option value="04">核实</option>
									</select>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="controlType">保后监控：</label>
									<div class="col-sm-9">
										<select class="col-sm-6" id="controlType" name="controlType">
											<option>--请选择--</option>
											<option value="01">常规</option>
											<option value="02">按月</option>
											<option value="03">按季</option>
									</select>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="resolutionResult">决议结果：</label>
									<div class="col-sm-9">
										<select class="col-sm-6" id="resolutionResult" name="resolutionResult">
											<option>--请选择--</option>
											<option value="01">通过</option>
											<option value="02">复议</option>
											<option value="03">不通过</option>
									   </select>
								</div>
							</div> 
				</form>

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
</div>
<script src="/assets/js/chosen.jquery.min.js"></script>
<link rel="stylesheet" href="/assets/css/iconfont.css" />
<script src="/plugins/plupload/plupload.full.min.js"></script>
<script src="/plugins/plupload/i18n/zh_CN.js"></script>
<script src="/plugins/viewer/viewer.min.js"></script>

<script src="/assets/js/My97DatePicker/WdatePicker.js"></script>
