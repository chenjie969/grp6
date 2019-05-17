<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="modal fade" id="addLoanConfirm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">已放款确认</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="addLoanConfirm_form">
      	 	<input type="hidden" id="loanPlan_ID" name="loanPlan_ID" value="${loanPlan.loanPlan_ID}">
      	 	<input type="hidden" id="applyID" name="applyID" value="${loanPlan.applyID}">
      	 	<input type="hidden" id="applyDetailID" name="applyDetailID" value="${loanPlan.applyDetailID}">
      	 	<input type="hidden" id="periodDay" name="periodDay" value="${loanPlan.periodDay}">
      	 	<input type="hidden" id="periodMonth" name="periodMonth" value="${loanPlan.periodMonth}">
      	 	<input type="hidden" id="interestRate" name="interestRate" value="${loanPlan.interestRate}">
      	 	<input type="hidden" id="loanSum" name="loanSum" value="${loanPlan.loanSum}">
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right" for="form-field-1">放款金额：</label>
						<div class="col-sm-8">
							<c:choose>
			                	<c:when test="${empty loanPlan.loanSum || loanPlan.loanSum eq 0}">
									<input type="text" value="（空）" 
										class="col-sm-12 " style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:when>
			                	<c:otherwise>
			                		<span><fmt:formatNumber value="${loanPlan.loanSum}" />万元</span>
									<%-- <input type="text" value="<fmt:formatNumber value="${loanPlan.loanSum}"/>" 
										 class="col-sm-8 " style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/> --%>
								</c:otherwise>
			                </c:choose>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right" for="form-field-1">期限：</label>
						<input type="hidden" value="${loanPlan.periodMonthDay}" name="periodMonthDay" />
						<div class="col-sm-8">
							<c:choose>
								<c:when test="${empty loanPlan.periodMonthDay || loanPlan.periodMonthDay eq ''}">（空）</c:when>
								<c:otherwise>
									<input type="text" value="${loanPlan.periodMonthDay}" class="col-sm-12 "
											style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right" for="form-field-1">年利率：</label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-10" value="<fmt:formatNumber value="${loanPlan.interestRate}" pattern="###.######％"/>" 
								style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>放款单编号：</label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-8 validate[required]"  name="loadCode"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>借据起始日期：
						</label>
						<div class="col-sm-8">
							<div class="input-group col-sm-8">
								<input class="form-control date-picker validate[required,custom[date]]"
									type="text" id="billBeginDate" data-date-format="yyyy-mm-dd" name="billBeginDate" /> 
								<span class="input-group-addon input-group-addon1"> 
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>借据到期日期：
						</label>
						<div class="col-sm-8">
							<div class="input-group col-sm-8">
								<input class="form-control date-picker validate[required,custom[date]]"
									type="text" id="billEndDate" data-date-format="yyyy-mm-dd" name="billEndDate" /> 
								<span class="input-group-addon input-group-addon2"> 
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right" for="form-field-1">借据附件：</label>
						<div class="col-sm-8">
	                        <button class="btn btn-sm btn-info" type="button" name="button" id="${loanPlan.loanPlan_ID}" onclick="$.zjm_loanAttachment.filesUpdate(this.id)">
	                           		上传</button>
	                        <div id="attachmentsDIV" class=""></div>
						</div>
					</div>
				</form>
      </div>
      
      <div class="modal-footer ">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>确认</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>

    </div>
  </div>
</div>
<script src="/plugins/plupload/plupload.full.min.js"></script>
<script src="/plugins/plupload/i18n/zh_CN.js"></script>
<script src="/project/loan/reviewLoan/loanAttachment.js"></script>
<%@ include file="/project/loan/reviewLoan/loanAttachment.jsp" %>  				
<script type="text/javascript">
	$('.date-picker').datepicker({autoclose: true}).next().on(ace.click_event, function () {
	    $(this).prev().focus();
	});
	
	$('.input-group-addon1').click(function (){
		$('#billBeginDate').focus();
	});
	
	$('.input-group-addon2').click(function (){
		$('#billEndDate').focus();
	});
	
</script>