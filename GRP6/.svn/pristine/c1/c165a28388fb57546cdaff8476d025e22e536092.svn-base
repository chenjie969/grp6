<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="modal fade" id="updateCostReturn" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改退费</h4>
      </div>
      <div class="modal-body">
      		<form class="form-horizontal row" role="form" id="updateCostReturn_form">
				<input type="hidden" name="costReturn_ID" value="${costReturn.costReturn_ID }">
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
								<option <c:if test="${costReturn.costTypeID eq costType.dicTypeID}">selected="selected"</c:if> value="${costType.dicTypeID}">${costType.dicTypeName}</option>
							</c:forEach>
						</select>
					</div> 
					
				</div>
				
				<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>退费金额： </label>
					<div class="col-sm-9">
						<input type="text" name="returnCostSum" id="returnCostSum"  value="${costReturn.returnCostSum }" class="col-sm-4 validate[required]" /> 
						<span class="col-sm-8" style="line-height:26px;">元</span>
					</div>
				</div>
				
				<div class="form-group">
			   	    <label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>退费日期： </label>
			        <div class="col-sm-9">
						<div class="input-group col-sm-8">
							<input value="<fmt:formatDate value="${costReturn.returnCostDate}" pattern="yyyy-MM-dd"/>" class="form-control date-picker returnCostDate validate[required,custom[date]]" type="text" data-date-format="yyyy-mm-dd" name="returnCostDate"/>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
	 			</div>
	 			
	 			<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1">退费原因： </label>
					<div class="col-sm-9">
						<textarea class="col-xs-10 col-sm-8 validate[maxSize[100]]" name="returnDesc"
								rows="5">${costReturn.returnDesc }</textarea>
						<div class="col-xs-10 col-sm-8 no-padding-right">
							<span class="light-grey" style="float: right">限制200个字符</span>
						</div>
					</div> 	
				</div>
				
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1">备注： </label>
					<div class="col-sm-9">
						<textarea class="col-xs-10 col-sm-8 validate[maxSize[100]]" name="remark"
								rows="5">${costReturn.remark }</textarea>
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
	$('.date-picker').datepicker({autoclose: true}).next().on(ace.click_event, function () {
	    $(this).prev().focus();
	});
	
	$('.input-group-addon').click(function (){
		$('.returnCostDate').focus();
	});
	$('.costTypeName').attr("value",$('.costTypeID option:selected').text());
	$(".costTypeID").on("change", function () {
		$('.costTypeName').attr("value",$('.costTypeID option:selected').text());
    })
</script>
