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
				<form class="form-horizontal" role="form" id="nextTask_form">
					<input type="hidden" name="flowID" class="os_flowID" value="${flowID}" /> 
					<input type="hidden" name="actionID" class="os_actionID" value="${actionID}" /> 
					<input type="hidden" name="projectID" class="os_projectID" value="${projectID}" />
					<ul class="invest-history-list clearfix b0">
						<c:forEach items="${osRoleMap}" var="osRole">
							<input type="hidden" name="roleName" class="os_roleNames" value="${osRole.key}" />
							<li class="i-h-l-item line-2 b0">
							<span class="fl w40 tr cti">${osRole.key}：</span> 
							<span class="fl w30 tl cc"> 
							<select class="select_text_style validate[required] os_rolrUserUids" name="rolrUserUid">
										<c:forEach items="${osRole.value}" var="flRolesUser">
											<option value="${flRolesUser.key}">${flRolesUser.value}</option>
										</c:forEach>
								</select>
							</span></li>
						</c:forEach>
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


<script>     
 
	$(function() {
		$("#ostaskTansact").modal({
			keyboard : true
		});
		zjm.init();
		$(".btn_doTask_submit").click(function() {
			$.ajax({
				type : 'POST',
				url : '/gworkFlow/nodynamicDoAction',
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
