<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="modal fade" id="announceAuditReturn" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">审核退回</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="audit_return_form">
      	 	<input type="hidden" name="messageId" id = "messageId"/>
			<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>退回原因：</label>
					
						<div class="col-sm-9">
							<textarea rows="6" name="returnDesc" class="col-sm-10 validate[maxSize[50]]"></textarea>
							<div class="col-sm-10 no-padding-right">
								<span class="light-grey pull-right">限制50个字符</span>
							</div>
						</div>
			 </div>			
			 <div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">审核人： </label>
				<label class="col-sm-9" for="form-input">${message.approvalUserName}</label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">审核日期： </label>
				<label class="col-sm-9" for="form-input"><fmt:formatDate value="${message.approvalDateTime}" pattern="yyyy-MM-dd"/> </label>
				
			</div>
		 </form>
      </div>
      <div class="modal-footer ">
      	<button type="button" class="btn btn-primary btn_submit" id="but_auditRetrun"> <i class='icon-ok bigger-110'></i>确认</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>


					
			
			
			
					