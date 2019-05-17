<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="modal fade" id="editProDelay" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog  modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">展期</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="editProDelay_form">
				<input type="hidden" id="delay_ID" name="delay_ID" value="${delay.delay_ID }">	
				<input type="hidden" id="projectID" name="project_ID" value="${delay.project_ID }">	
				<input type="hidden" id="applyID" name="applyID" value="${delay.applyID }">	
				<div class="form-group col-sm-6">
					<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>展期金额： </label>
					<div class="col-sm-8">
					    <div class="row">
						    <div class="col-sm-10">
								<input type="text" id="delaySum_edit" name="delaySum" value="${delay.delaySum }" class="col-sm-6 validate[required]"/>
								<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
							</div>
			        	</div>
			    	</div>
				</div>
			
				<div class="form-group col-sm-6">
					<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>展期期限： </label>
					<div class="col-sm-8">
						<div class="row">
								<input type="number" name="delayMonth" value="${delay.delayMonth }" class="col-xs-3 col-sm-3 validate[required,custom[integer],maxSize[18]]" />
								<span class="midden col-sm-3 " style="line-height:28px;">个月</span>
								<input type="number" name="delayDay" value="${delay.delayDay }" class="col-xs-3 col-sm-3 validate[custom[integer],maxSize[30]]"/>
								<span class="midden col-sm-3 " style="line-height:28px;">天</span>
						</div>
					</div>
				</div>
					
				<div class="form-group col-sm-6">
			   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>展期起始日期： </label>
			        <div class="col-sm-8">
						<div class="row">
							<div class="col-sm-10">
								<div class="input-group">
									<input value="<fmt:formatDate value="${delay.delayBeginDate }" pattern="yyyy-MM-dd"/>" class="form-control date-picker validate[required,custom[date]]" type="text" id="delayBeginDate" data-date-format="yyyy-mm-dd" name="delayBeginDate"/>
									<span class="input-group-addon input-group-addon1">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
					</div>
	 			</div>	
				<div class="form-group col-sm-6">
			   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>展期到期日期： </label>
			        <div class="col-sm-8">
						<div class="row">
							<div class="col-sm-10">
								<div class="input-group">
									<input value="<fmt:formatDate value="${delay.delayEndDate }" pattern="yyyy-MM-dd"/>" class="form-control date-picker validate[required,custom[date]]" type="text" id="delayEndDate" data-date-format="yyyy-mm-dd" name="delayEndDate"/>
									<span class="input-group-addon input-group-addon2">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
					</div>
	 			</div>	
				
				<div class="form-group col-sm-6">
					<label class="col-sm-4 control-label no-padding-right" for="form-field-1">展期担保费率： </label>
					<div class="col-sm-8">
					    <div class="row">
						    <div class="col-sm-10">
								<input type="text" value="${delay.delayRate }" name="delayRate" class="col-sm-6"/>
								<span class="midden col-sm-4 " style="line-height:28px;">%</span>
							</div>
			        	</div>
			    	</div>
				</div>
				<div class="form-group  col-sm-6  hidden-xs" style="height:34px"></div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="form-field-1">展期原因： </label>
					<div class="col-sm-10">
						<textarea class="col-xs-10 validate[maxSize[100]]" name="delayReason" 
								 rows="5">${delay.delayReason }</textarea>
						<div class="col-xs-10 no-padding-right">
							<span class="light-grey" style="float: right">限制100个字符</span>
						</div>
					</div> 	
				</div>
					
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="form-field-1">附件：</label>
					<div class="col-sm-10">
		                <button class="btn btn-sm btn-info" type="button" name="button" id="${delay.project_ID }" onclick="$.zjm_loanAttachment.filesUpdate(this.id)">
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
<script src="/project/loan/proDelay/delayAttachment.js"></script>
<%@ include file="/project/loan/proDelay/delayAttachment.jsp" %>  				
<script type="text/javascript">
	$('.date-picker').datepicker({autoclose: true}).next().on(ace.click_event, function () {
	    $(this).prev().focus();
	});
	
	$('.input-group-addon1').click(function (){
		$('#delayBeginDate').focus();
	});
	
	$('.input-group-addon2').click(function (){
		$('#delayEndDate').focus();
	});
	
</script>