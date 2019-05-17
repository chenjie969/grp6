<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="modal fade" id="addCostFact" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加实收</h4>
      </div>
      <div class="modal-body">
      		<form class="form-horizontal row" role="form" id="addCostFact_form">
				<input type="hidden" name="meetingDetail_ID" value="${meetingDetail.meetingDetail_ID }">
				<input type="hidden" name="apply_ID" value="${meetingDetail.apply_ID }">
				<input type="hidden" name="applyDetail_ID" value="${meetingDetail.applyDetail_ID }">
				<input type="hidden" id="agreeSum" value="${meetingDetail.agreeSum }">
				<input type="hidden" id="periodMonth" value="${meetingDetail.periodMonth }">
				<input type="hidden" id="periodDay" value="${meetingDetail.periodDay }">
				
				<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>同意担保金额： </label>
					<div class="col-sm-9">
						<span style="line-height:28px;">
							<fmt:formatNumber value="${meetingDetail.agreeSum }" />万元
						</span>
					</div>
				</div>
				
				<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>同意期限： </label>
					<div class="col-sm-9">
						<span style="line-height:28px;">
							${meetingDetail.periodMonthDay }
						</span>
					</div>
				</div>
				
				<div class="form-group">
					 <label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>费用类型：</label>
					<div class="col-sm-9">
						<input type="hidden" id="costTypeName" name="costTypeName" class="costTypeName"> 
						<select class="col-sm-4 validate[required] costTypeID" id="costTypeID" name="costTypeID">
							<c:forEach var="costType" items="${costTypeList}" varStatus="status">
								<option value="${costType.dicTypeID}">${costType.dicTypeName}</option>
							</c:forEach>
						</select>
					</div> 
					
				</div>
				
				<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>费率： </label>
					<div class="col-sm-9">
						<input type="text" name="costRate" class="col-sm-4 validate[required] costRate" onkeyup="calculationFee(this.value);"/> 
					</div>
				</div>
				
				<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>费率单位： </label>
					<div class="col-sm-9">
						<select class="col-sm-4 validate[required] costUnit" id="costUnit" name="costUnit">
							<option value="%" selected="selected">%</option>
							<option value="‰">‰</option>
						</select>
						<span class="col-sm-8" style="line-height:26px;color:red;" id="costUnitspan"></span>
					</div>
				</div>
				
				<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>实收金额： </label>
					<div class="col-sm-9">
						<input type="text" name="factCostSum" id="factCostSum" class="col-sm-4 validate[required] getMoney" readonly="readonly"/> 
						<span class="col-sm-8" style="line-height:26px;">元</span>
					</div>
				</div>
				
	 			<div class="form-group">
			   	    <label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>实收日期： </label>
			        <div class="col-sm-9">
						<div class="input-group col-sm-8">
							<input class="form-control  date-picker factCostDate validate[required,custom[date]]" type="text" data-date-format="yyyy-mm-dd" name="factCostDate"/>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
	 			</div>
				
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1">备注： </label>
					<div class="col-sm-9">
						<textarea class="col-xs-10 col-sm-8 validate[maxSize[100]]" name="remark"
								rows="5"></textarea>
						<div class="col-xs-10 col-sm-8 no-padding-right">
							<span class="light-grey" style="float: right">限制50个字符</span>
						</div>
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

<script type="text/javascript">
	var agreeSum = parseFloat($("#agreeSum").val())*10000;//同意担保金额
	var periodMonth = $("#periodMonth").val();//期限月
	var periodDay = $("#periodDay").val();//期限天
	var period = periodMonth;
	if(parseFloat(periodDay) >= 15){
		period = parseFloat(periodMonth)+1;
	}else{
		if(parseFloat(periodDay) == 0){
			period = periodMonth; 
		}else{
			period = parseFloat(periodMonth)+0.5; 
		}
	}
	
	var costUnit = $("#costUnit").val();
	var  percent = 0.01;
	if(costUnit == '%'){
		$('#costUnitspan').html('（0.01）');
		percent = 0.01;
	}else{
		$('#costUnitspan').html('（0.001）');
		percent = 0.001;
	}
	$("#costUnit").on("change", function () {
		var costUnit = $("#costUnit").val();
		if(costUnit == '%'){
			$('#costUnitspan').html('（0.01）');
			percent = 0.01;
		}else{
			$('#costUnitspan').html('（0.001）');
			percent = 0.001;
		}
		var costRate1 = $(".costRate").val();
		calculationFee(costRate1);
	}); 
	
	 /* 输入费率，根据同意担保金额、费率单位算出费用；
	  如果是担保费和利息时还要根据同意期限来计算*/
	function calculationFee(costRate) {
		 var costTypeID = $(".costTypeID").val();
		 //f0bd2361808d4da9980f18629c236d5c 担保费  aaa82fbcc0ca446288d83e84a192def3 利息
		 
		 if(costTypeID =="f0bd2361808d4da9980f18629c236d5c" || costTypeID=="aaa82fbcc0ca446288d83e84a192def3"){
			var getMoney = (parseFloat(costRate)*parseFloat(agreeSum)*parseFloat(percent)*parseFloat(period))/12;
			if(getMoney==null || typeof(getMoney)=="undefined" || isNaN(getMoney)){
				getMoney=0;
			}
				//获取金额
			$(".getMoney").val(parseFloat(getMoney).toFixed(0)); 
		 }else{
			var getMoney = parseFloat(costRate)*parseFloat(agreeSum)*parseFloat(percent);
			if(getMoney==null || typeof(getMoney)=="undefined" || isNaN(getMoney)){
				getMoney=0;
			}
			//获取金额
			$(".getMoney").val(parseFloat(getMoney).toFixed(0));
		 }
	}
	
	
	$('.date-picker').datepicker({autoclose: true}).next().on(ace.click_event, function () {
	    $(this).prev().focus();
	});
	
	$('.input-group-addon').click(function (){
		$('.factCostDate').focus();
	});
	
	$('.costTypeName').attr("value",$('.costTypeID option:selected').text());
	$(".costTypeID").on("change", function () {
		$('.costTypeName').attr("value",$('.costTypeID option:selected').text());
		var costRate1 = $(".costRate").val();
		calculationFee(costRate1);
    })
</script>
