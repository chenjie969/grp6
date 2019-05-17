<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<style type="text/css">

#add_meeting {
	overflow-y: scroll;
}
</style>
<div class="modal fade" id="add_juryOnlineVote" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">添加评委在线表决</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" id="juryOnlineVote_form">
							<%-- <input type="hidden" name="applyID" value="${applyID}"> --%>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="resolutionCode">评审结论：
								</label>
								<div class="col-sm-9">
									<input type="radio" id="resolutionCode" checked="checked" name="resolutionCode">
									同意&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" id="resolutionCode" name="resolutionCode">
									反对&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" id="resolutionCode" name="resolutionCode">
									再议
								</div>
							</div>
							
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="shouldJury">同意担保金额：
								</label>
								<div class="col-sm-9">
									<input id="shouldJury" name="shouldJury" class="col-sm-6">&nbsp;
									<span class="light-grey" >万元</span>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="senseJury">同意担保期限：
								</label>
								<div class="col-sm-9">
									<input id="senseJury" name="senseJury" class="col-sm-6">&nbsp;
									<span class="light-grey" >个月</span>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="passJury">担保年利率：
								</label>
								<div class="col-sm-9">
									<input id="passJury" name="passJury" class="col-sm-6">
									&nbsp;<span class="light-grey" >%</span>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="passJury">履约保证金比例：
								</label>
								<div class="col-sm-9">
									<input id="passJury" name="passJury" class="col-sm-6">
									&nbsp;<span class="light-grey" >%</span>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="passJury">评审费费率：
								</label>
								<div class="col-sm-9">
									<input id="passJury" name="passJury" class="col-sm-6">
									&nbsp;<span class="light-grey" >‰</span>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="passJury">还款方式：
								</label>
								<div class="col-sm-9">
									<input id="passJury" name="passJury" class="col-sm-6">
								</div>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="passJury">用款方式：
								</label>
								<div class="col-sm-9">
									<input id="passJury" name="passJury" class="col-sm-6">
								</div>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="loanConditions">评审意见：</label>
								<div class="col-sm-9">
									<textarea id="loanConditions" name="loanConditions" 
									class="col-sm-10 autosize-transitionl"></textarea>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="loanConditions">需要满足的条件：</label>
								<div class="col-sm-9">
									<textarea id="loanConditions" name="loanConditions" 
									class="col-sm-10 autosize-transitionl"></textarea>
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
