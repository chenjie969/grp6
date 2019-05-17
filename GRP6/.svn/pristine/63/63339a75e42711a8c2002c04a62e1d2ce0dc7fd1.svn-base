<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="planLoanAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" style="z-index:9999">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">添加放款计划</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="form_planLoanAdd">
			<input type="hidden" name="meetingDetail_ID" value="${meetingDetail.meetingDetail_ID }"/>
			<input type="hidden" name="applyID" value="${meetingDetail.apply_ID }"/>
			<input type="hidden" name="applyDetailID" value="${meetingDetail.applyDetail_ID }"/>
			<input type="hidden" name="busiTypeID" value="${meetingDetail.busiTypeID }"/>
			<input type="hidden" name="busiTypeName" value="${meetingDetail.busiTypeName }"/>
			<input type="hidden" name="bankTypeID" value="${meetingDetail.bankTypeID }"/>
			<input type="hidden" name="bankTypeName" value="${meetingDetail.bantTypeName }"/>
			<input type="hidden" name="bankID" value="${meetingDetail.bankID }"/>
			<input type="hidden" name="bankName" value="${meetingDetail.bankName }"/>
			<input type="hidden" name="subBankName" value="${meetingDetail.subBankName }"/>
			<input type="hidden" name="accessType" value="insert"/>
 			
 			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>计划放款金额： </label>
				<div class="col-sm-8">
					<input type="text" name="loanSum" class="col-sm-8 validate[required,custom[number],maxSize[18]]" id="addLoanSum"/>
					<span class="midden col-sm-2" style="line-height:28px;">万元	</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>期限：</label>
				<div class="col-sm-8">
					<span class="col-sm-10 no-padding-left">
						<input type="text" name="periodMonth" class="validate[required,maxSize[5],custom[integer]]" style="width: 70px;"/>&nbsp;个月&nbsp;
						<input type="text" name="periodDay" value="0" class="validate[required,maxSize[5],custom[integer]]" style="width: 70px;"/>&nbsp;天
					</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">年利率： </label>
				<div class="col-sm-8">
				    <div class="row">
					    <div class="col-sm-10">
							<input type="text" name="interestRate" class="col-sm-10 validate[maxSize[10]]">
							<span style="line-height: 28px;" class="col-sm-2">%</span>
						</div>
			        </div>
			    </div>
		    </div>
 			<div class="form-group">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>计划放款日期： </label>
		        <div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<div class="input-group">
								<input class="form-control date-picker validate[required,custom[date]]" type="text" data-date-format="yyyy-mm-dd" name="loanDate"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
 			</div>
		</form>
      </div>
      
      <div class="modal-footer">
			<button type="button" class="btn btn-primary" id="btn_submit"><i class='icon-ok bigger-110'></i>保存</button>
			<button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
	/*注册日期控件点击事件*/
	$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
		$(this).prev().focus();
	});
</script>
				