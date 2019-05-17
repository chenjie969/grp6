<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="addCheckRegi" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" data-backdrop="static"
	data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">添加日常检查计划</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal row" role="form" id="addCheckRegi_form">
					<input type="hidden" name="apply_ID" value="${apply_ID }" />
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>计划检查日期：
						</label>
						<div class="col-sm-8">
							<div class="input-group col-sm-8">
								<input class="form-control date-picker validate[required,custom[date]] col-sm-12"
									type="text" id="planCheckDate" data-date-format="yyyy-mm-dd"
									name="planCheckDate" /> <span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
<%-- 
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>检查人员：
						</label>
						<div class="col-sm-8">
							<div class="row">
								<div class="col-sm-8  validate[required]">
									<select id="operatorID" name="operatorID" class="col-sm-12 ">
										<option value="">&nbsp;请选择</option>
										<c:forEach items="${userList}" var="users">
											<option value="${users.id}">${users.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
					</div> --%>

				</form>
			</div>

			<div class="modal-footer ">
				<button type="button" class="btn btn-primary btn_submit">
					<i class='icon-ok bigger-110'></i>确认
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<i class='icon-remove bigger-110'></i>关闭
				</button>
			</div>

		</div>
	</div>
</div>


<script type="text/javascript">
	$('.date-picker').datepicker({
		autoclose : true
	}).next().on(ace.click_event, function() {
		$(this).prev().focus();
	});

	$('.input-group-addon').click(function() {
		$('#planCheckDate').focus();
	});
</script>
