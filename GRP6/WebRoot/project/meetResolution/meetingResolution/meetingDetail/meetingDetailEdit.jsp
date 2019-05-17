<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function sum(){
	var sum = 0;
	var agreeSum = $("#agreeSum").val();
	var guarantyScale = $("#guarantyScale").val();
	sum = Number(agreeSum) * Number(guarantyScale)/100;
	$("#guarantyDutySum").val(sum)
}
</script>
<div class="modal fade" id="meetDetailEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" style="z-index:9999">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">修改批准担保情况</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="meetDetailEdit_form">
			<input type="hidden" name="meetingDetail_ID" value="${meetingDetail.meetingDetail_ID }">
			<input type="hidden" name="meetingResolution_ID" value="${meetingDetail.meetingResolution_ID }">
			<input type="hidden" name="apply_ID" value="${meetingDetail.apply_ID }">
			
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>业务品种：</label>
				<div class=" col-sm-5 ">
				<div class="input-group busiSortDicTree">
						<input  type="text"  class="form-control" autoField="busiTypeID" id="busiSortDicTree" name="busiTypeName" value="${meetingDetail.busiTypeName}" dataValue="${meetingDetail.busiTypeID}"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>担保金额： </label>
				<div class="col-sm-7">
					<input type="text" name="agreeSum" onchange="sum();" class="col-xs-10 col-sm-6 validate[required,custom[number],maxSize[18]]" id="agreeSum"
						value="<fmt:formatNumber value='${meetingDetail.agreeSum}' pattern='############'/>">
					<span class="midden col-sm-4 " style="line-height:28px;">万元	</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>担保期限：</label>
				<div class="col-sm-7">
					<span class="col-sm-10 no-padding-left">
						<input type="text" name="periodMonth" class="validate[required,maxSize[5],custom[integer]]" style="width: 70px;" value="${meetingDetail.periodMonth }"/>&nbsp;个月&nbsp;
						<input type="text" name="periodDay" class="validate[maxSize[5],custom[integer]]" style="width: 70px;" value="${meetingDetail.periodDay }"/>&nbsp;天&nbsp;
					</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>放款机构：</label>
				<div class=" col-sm-5 ">
					<div class="input-group selectBank">
						<input  type="text"  class="form-control" autoField="bankID" id="selectBank" name="bankName" value="${meetingDetail.bankName}" dataValue="${meetingDetail.bankID}"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>担保责任范围：</label>
				<div class="col-sm-9">
					<div class="row">
						<div class="col-sm-9">
							<select class="col-sm-6 btn_ztb_select"  name="guarantyScope">
								<option value="本金担保" <c:if test="${meetingDetail.guarantyScope=='本金担保' }">selected="selected"</c:if>>本金担保</option>
								<option value="本息担保" <c:if test="${meetingDetail.guarantyScope=='本息担保' }">selected="selected"</c:if>>本息担保</option>
							</select>
						<input type="text" name="guarantyScale" onchange="sum();"id="guarantyScale" class="col-xs-3 col-sm-3 validate[required,custom[number],maxSize[18]]" value="<fmt:formatNumber value='${meetingDetail.guarantyScale}' pattern='###,###.######'/>"/>
					     <span class="midden col-sm-3" style="line-height:28px;">%
						</div>	
					</div>
				</div>
			</div>
			 <div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">责任金额： </label>
				<div class="col-sm-7">
					<input type="text" name="guarantyDutySum" id="guarantyDutySum" class="col-sm-6 validate[custom[number],maxSize[18]]" 
						value="<fmt:formatNumber value='${meetingDetail.guarantyDutySum}' pattern='############'/>">
					<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
				</div>
			</div> 
			<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">评审费率：</label>
						<div class="col-sm-7">
							<input type="text" name="reviewRate" id="reviewRate"  class="col-sm-8 validate[custom[number],maxSize[10]]" value="<fmt:formatNumber value='${meetingDetail.reviewRate}' pattern='###,###.######'/>"/>
							<span class="midden col-sm-4 " style="line-height:28px;">‰</span>
						</div>
					</div> 
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">担保费率：</label>
						<div class="col-sm-7">
							<input type="text" name="guarantyRate" id="guarantyRate"  class="col-sm-8 validate[custom[number],maxSize[10]]" value="<fmt:formatNumber value='${meetingDetail.guarantyRate}' pattern='###,###.######'/>"/>
							<span class="midden col-sm-4 " style="line-height:28px;">%</span>
						</div>
					</div> 
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">保证金比例：</label>
						<div class="col-sm-7">
							<input type="text" name="bzScale" id="bzScale"  class="col-sm-8 validate[custom[number],maxSize[10]]" value="<fmt:formatNumber value='${meetingDetail.bzScale}' pattern='###,###.######'/>"/>
							<span class="midden col-sm-4 " style="line-height:28px;">%</span>
						</div>
					</div> 
		</form>
      </div>
      <div class="modal-footer">
			<button type="button" class="btn btn-primary btn_submit"><i class='icon-ok bigger-110'></i>确定</button>
			<button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
				