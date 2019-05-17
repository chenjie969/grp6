<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<div class="modal fade" id="costMustEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" style="z-index:9999">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">修改应收费用</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="form_costMustEdit">
			<input type="hidden" name="apply_ID" value="${meetingDetail.apply_ID }">
			<input type="hidden" name="meetingDetail_ID" value="${meetingDetail.meetingDetail_ID }">
			<input type="hidden" name="loanPlan_ID" value="${loanPlan.loanPlan_ID }">
			<input type="hidden" name="costMust_ID" value="${costMust.costMust_ID }">
			
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right">放款金额： </label>
				<label class="col-sm-7"><fmt:formatNumber value="${loanPlan.loanSum }" pattern="###,###.######"/>万元</label>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right">年利率： </label>
				<label class="col-sm-7">
					<c:if test="${empty loanPlan.interestRate }">（空）</c:if>
					<c:if test="${not empty loanPlan.interestRate }">${loanPlan.interestRate }%</c:if>
				</label>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right">利息： </label>
				<div class="col-sm-7">
					<input type="text" name="interestSum" class="col-sm-6 validate[custom[number],maxSize[18]]" value="<fmt:formatNumber value="${costMust.interestSum }" pattern="###.######"/>"/>
					<span class="midden col-sm-3" style="line-height:28px;">元	</span>
				</div>
			</div>
 			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right">担保责任范围： </label>
				<label class="col-sm-4">${meetingDetail.guarantyScope==""?"(空)":meetingDetail.guarantyScope}&nbsp;&nbsp;<fmt:formatNumber value='${meetingDetail.guarantyScale}' pattern='###,###.######'/>%</label>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right"><i class="icon-asterisk orange"></i>费用类型： </label>
				<div class="col-sm-8">
					<select  name="costTypeID" class="col-sm-8 validate[required]" id="select_costTypeID">
						<option value="">请选择</option>
						<option value="${empty meetingDetail.reviewRate?0:meetingDetail.reviewRate }" 
							<c:if test="${costMust.costName=='评审费' }">selected="selected"</c:if> >评审费</option>
						<option value="${empty meetingDetail.guarantyRate?0:meetingDetail.guarantyRate }" 
							<c:if test="${costMust.costName=='担保费' }">selected="selected"</c:if> >担保费</option>
						<option value="${empty meetingDetail.bzScale?0:meetingDetail.bzScale }" 
							<c:if test="${costMust.costName=='保证金' }">selected="selected"</c:if> >保证金</option>
						<%-- <c:forEach items="${costTypeList }" var="costType">
							<option value="${costType.dicTypeID }" <c:if test="${costType.dicTypeID==costMust.costTypeID }">selected="selected"</c:if>>${costType.dicTypeName }</option>
						</c:forEach> --%>
					</select>
					<input type="hidden" name="costName" id="hidden_costName" value="${costMust.costName }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right"><i class="icon-asterisk orange"></i>费率： </label>
				<div class="col-sm-8">
					<input type="text" name="costRate" class="col-sm-5 validate[required]" value="${costMust.costRate }" id="input_costRate">
					<select name="costUnit" class="col-sm-3">
						<option value="%" id="costUnit_percent" <c:if test="${costMust.costUnit == '%' }">selected="selected"</c:if>>%</option>
						<option value="‰" id="costUnit_permillage" <c:if test="${costMust.costUnit == '‰' }">selected="selected"</c:if>>‰</option>
					</select>
				</div>
			</div>
			<%-- <div class="form-group">	
				<h5 class="col-sm-offset-1">本金应收费用：</h5>		
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right"><i class="icon-asterisk orange"></i>应收金额： </label>
				<div class="col-sm-7">
					<input type="text" name="capitalMustCostSum" class="col-sm-6 validate[required,custom[number],maxSize[18]] mustCostSum" 
						value="<fmt:formatNumber value="${costMust.capitalMustCostSum }" pattern="##.##"/>"/>
					<span class="midden col-sm-3" style="line-height:28px;">元	</span>
					<!-- <button type="button" class="btn btn-xs btn-info col-sm-3">计算</button> -->
				</div>
			</div>
			<div class="form-group">	
				<h5 class="col-sm-offset-1">利息应收费用：</h5>		
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right">应收金额： </label>
				<div class="col-sm-7">
					<input type="text" name="interestMustCostSum" class="col-sm-6 validate[custom[number],maxSize[18]] mustCostSum" 
						value="<fmt:formatNumber value="${costMust.interestMustCostSum }" pattern="##.##"/>"/>
					<span class="midden col-sm-3" style="line-height:28px;">元</span>
					<!-- <button type="button" class="btn btn-xs btn-info col-sm-3">计算</button> -->
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right">应收小计： </label>
				<label class="col-sm-4"><span id="span_mustCostSum"><fmt:formatNumber value="${costMust.mustCostSum }" pattern="###,###.######"/></span>元</label>
				<input type="hidden" name="mustCostSum" id="hidden_mustCostSum" value="${costMust.mustCostSum }">
			</div> --%>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right"><i class="icon-asterisk orange"></i>应收金额： </label>
				<div class="col-sm-7">
					<input type="text" name="mustCostSum" class="col-sm-6 validate[required,custom[number],maxSize[18]]" 
						value="<fmt:formatNumber value="${costMust.mustCostSum }" pattern="###.##"/>"/>
					<span class="midden col-sm-3" style="line-height:28px;">元</span>
				</div>
			</div>
		 </form>
      </div>
      <div class="modal-footer">
			<button type="button" class="btn btn-primary" id="btn_submit_costMustEditForm"><i class='icon-ok bigger-110'></i>保存</button>
			<button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
	
<script type="text/javascript">
	$("#select_costTypeID").change(function(){
		var $obj = $(this).children("option:selected");
		$("#hidden_costName").val($obj.text());
		if($obj.val()!=0){
			$("#input_costRate").val($obj.val());
		}
		if($obj.text()=="评审费"){
			$("#costUnit_permillage").attr("selected",true);
			$("#costUnit_percent").removeAttr("selected");
		}else{
			$("#costUnit_percent").attr("selected",true);
			$("#costUnit_permillage").removeAttr("selected");
		}
	});
	// 自动计算总应收费用
	$(".mustCostSum").blur(function(){
		var total = 0;
		$(".mustCostSum").each(function(){
			var temp = parseInt($(this).val());
			if(isNaN(temp)){
				temp = 0;
			}
			total += temp;
		});
		$("#hidden_mustCostSum").val(total);
		$("#span_mustCostSum").text(total);
	});
</script>