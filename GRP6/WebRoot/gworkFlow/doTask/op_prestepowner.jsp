<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<div class="modal fade" id="ostaskTansact" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">选择下一步执行人</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" id="nextOsTask_form">
					<input type="hidden" name="flowID" class="os_flowID" value="${flowID}" /> 
					<input type="hidden" name="actionID" class="os_actionID" value="${actionID}" /> 
					<input type="hidden" name="projectID" class="os_projectID" value="${projectID}" /> 
					<input type="hidden" name="rolrUserUids" class="os_rolrUserUids" value="${autoUserID}" /> 
					<input type="hidden" name="roleNames" class="os_roleNames" value="${autoUserName}" />
					<h5 class="col-sm-4">下一步人员：<span class="grey">${autoUserName}</span></h5>
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
<script>     
 
	$(function() {
		$("#ostaskTansact").modal({
			keyboard : true
		});
		zjm.init();
		$(".btn_doTask_submit").click(function() {
			$.ajax({
				type : 'POST',
				url : '/gworkFlow/prestepownerDoAction',
				data : JSON.stringify({
					"flowID" : $(".os_flowID").val(),
					"actionID" : $(".os_actionID").val(),
					"projectID" : $(".os_projectID").val(),
					"rolrUserUids" : [$(".os_rolrUserUids").val()],
					"roleNames" : [$(".os_roleNames").val()]
				}),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					if (data.obj == 1) {
						$("#ostaskTansact").modal("hide");
						window.parent.closeMenu("osworkflow"+$(".os_projectID").val());
					} else {
						alert("任务提交失败！");
						tool.undisabled(".btn_submit");
					}
				}
			});
		});

	});
</script>