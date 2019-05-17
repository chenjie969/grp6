<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<div class="modal fade" id="taskTansact" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">选择下一步执行人</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" id="nextTask_form">
					<input type="hidden" name="flowID" value="${flowID}" /> 
					<input type="hidden" name="actionID" value="${actionID}" /> 
					<input type="hidden" name="projectID" value="${projectID}" />
					<ul class="invest-history-list clearfix b0">
						<li class="i-h-l-item line-2 b0"><span class="fl w40 tr cti">受理人员：</span> <span class="fl w30 tl cc">&nbsp;${autoUserName }</span></li>
					</ul>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary btn_doTask_submit">
					<i class='icon-ok bigger-110'></i>确认
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<i class='icon-remove bigger-110'></i>取消
				</button>
			</div>
		</div>
	</div>
</div>
