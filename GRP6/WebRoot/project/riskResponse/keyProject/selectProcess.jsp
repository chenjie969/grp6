<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="modal modal_wapper fade bs-example-modal-lg" id="addProcess" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog " role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" id="processAdd_form">
		
				<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>请选择流程：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-8">
							<select class="col-sm-10"  name="guarantyScope">
								<option value="重点化解方案审批流程" <c:if test="">selected="selected"</c:if>>重点化解方案审批流程</option>
								<option value="重点化解工作进度审批流程" <c:if test="">selected="selected"</c:if>>重点化解工作进度审批流程</option>
								<option value="直管项目方案审批流程" <c:if test="">selected="selected"</c:if>>直管项目方案审批流程</option>
								<option value="打击逃废债方案审批流程" <c:if test="">selected="selected"</c:if>>打击逃废债方案审批流程</option>
								<option value="项目调度会审批流程" <c:if test="">selected="selected"</c:if>>项目调度会审批流程</option>
								<option value="项目专题会审批流程" <c:if test="">selected="selected"</c:if>>项目专题会审批流程</option>
							</select>
						</div>	
						
					</div>
				</div>
			</div>
			</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary btn_submitNext">
					<i class='icon-ok bigger-110'></i>下一步
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<i class='icon-remove bigger-110'></i>关闭
				</button>
			</div>
		</div>
	</div>
</div>