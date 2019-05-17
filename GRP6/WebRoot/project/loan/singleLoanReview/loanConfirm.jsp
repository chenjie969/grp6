<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="modal fade" id="loanConfirm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">放款确认</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="loanConfirm_form">
				<input type="hidden" id="projectID" name="project_ID" value="${project_ID}">	
				<input type="hidden" name="meetingDetail_ID" value="${meetingDetail.meetingDetail_ID}"> 	
				
				<div class="form-group">
					 <label class="col-sm-3 control-label no-padding-right" for="form-field-1">业务品种：</label>
					<div class="col-sm-9">
						<c:choose>
			                <c:when test="${meetingDetail.busiTypeName || meetingDetail.busiTypeName eq ''}">
								<input type="text" value="（空）" 
										class="col-sm-12 " style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
							</c:when>
			                <c:otherwise>
			                	<input type="text" value="${meetingDetail.busiTypeName}" 
										class="col-sm-12 " style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
							</c:otherwise>
			            </c:choose>
					</div> 
					
				</div>
				
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1">放款机构：</label>
					<div class="col-sm-9">
						<c:choose>
			                <c:when test="${meetingDetail.bankName || meetingDetail.bankName eq ''}">
								<input type="text" value="（空）" 
										class="col-sm-12 " style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
							</c:when>
			                <c:otherwise>
			                	<input type="text" value="${meetingDetail.bankName}" 
										class="col-sm-12 " style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
			                		<%-- <span style="line-height:34px;">${meetingDetail.bankName}</span> --%>
							</c:otherwise>
			            </c:choose>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1">同意放款金额：</label>
					<div class="col-sm-9">
						<c:choose>
			                <c:when test="${empty meetingDetail.agreeSum || meetingDetail.agreeSum eq 0}">
									<input type="text" value="（空）" 
										class="col-sm-12 " style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
							</c:when>
			                <c:otherwise>
			                		<span style="line-height:28px;"><fmt:formatNumber value="${meetingDetail.agreeSum}" />万元</span>
							</c:otherwise>
			            </c:choose>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1">已放款金额：</label>
					<div class="col-sm-9">
						<c:choose>
			                <c:when test="${empty haveLoanSum || haveLoanSum eq 0}">
									<input type="text" value="（空）" 
										class="col-sm-12 " style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
							</c:when>
			                <c:otherwise>
			                		<span style="line-height:28px;"><fmt:formatNumber value="${haveLoanSum}" />万元</span>
							</c:otherwise>
			            </c:choose>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1">未放款金额：</label>
					<input type="hidden" id="notLoanSum" value="${notLoanSum}">
					<div class="col-sm-9">
						<c:choose>
			                <c:when test="${empty notLoanSum || notLoanSum eq 0}">
									<input type="text" value="（空）" 
										class="col-sm-12 " style="border-left:0px;border-top:0px;border-right:0px;border-bottom:0px"/>
							</c:when>
			                <c:otherwise>
			                		<span style="line-height:28px;"><fmt:formatNumber value="${notLoanSum}" />万元</span>
							</c:otherwise>
			            </c:choose>
					</div>
				</div>
				
				<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>放款单编号： </label>
					<div class="col-sm-9">
						<input type="text" name="loadCode" class="col-sm-4 validate[required]" /> 
					</div>
				</div>
				
				<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>本次放款金额： </label>
					<div class="col-sm-9">
						<input type="text" name="loadSum" id="loadSum_input" class="col-sm-4 validate[required]" /> 
						<span class="col-sm-8" style="line-height:34px;">万元</span>
						<div class="col-xs-10 col-sm-4 no-padding-right">
							<span class="light-red" id="loadSum_span" style="float: right"></span>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>担保起止日期： </label>
					<div class="col-sm-9">
						<div class="input-group col-sm-4" style="float: left;">
							<input class="form-control date-picker validate[required,custom[date]]" type="text" id="loadBeginDate" data-date-format="yyyy-mm-dd" name="loadBeginDate"/>
							<span class="input-group-addon input-group-addon1">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
						<p class="col-sm-1">至</p>
						<div class="input-group col-sm-4">
							<input class="form-control date-picker validate[required,custom[date]]" id="loadEndDate" name="loadEndDate" type="text"  data-date-format="yyyy-mm-dd" />
							<span class="input-group-addon input-group-addon2">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
				</div>
					
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>借据起止日期： </label>
					<div class="col-sm-9">
						<div class="input-group col-sm-4" style="float: left;">
							<input class="form-control date-picker validate[required,custom[date]]" id="billBeginDate" type="text" data-date-format="yyyy-mm-dd" name="billBeginDate"/>
							<span class="input-group-addon input-group-addon3">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
						<p class="col-sm-1">至</p>
						<div class="input-group col-sm-4">
							<input class="form-control date-picker validate[required,custom[date]]" id="billEndDate" name="billEndDate" type="text"  data-date-format="yyyy-mm-dd" />
							<span class="input-group-addon input-group-addon4">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
				</div>
					
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1">放款凭证：</label>
					<div class="col-sm-9">
		                <button class="btn btn-sm btn-info" type="button" name="button" id="${project_ID}" onclick="$.zjm_singleAttachment.filesUpdate(this.id)">
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
<script src="/project/loan/singleLoanReview/singleAttachment.js"></script>
<%@ include file="/project/loan/singleLoanReview/singleAttachment.jsp" %>  				
<script type="text/javascript">
	$('.date-picker').datepicker({autoclose: true}).next().on(ace.click_event, function () {
	    $(this).prev().focus();
	});
	
	$('.input-group-addon1').click(function (){
		$('#loadBeginDate').focus();
	});
	
	$('.input-group-addon2').click(function (){
		$('#loadEndDate').focus();
	});
	$('.input-group-addon3').click(function (){
		$('#billBeginDate').focus();
	});
	$('.input-group-addon4').click(function (){
		$('#billEndDate').focus();
	});
	
</script>