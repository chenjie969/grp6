<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="modal fade" id="confirmLoan" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" style="z-index:9999">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">融资担保业务放款确认</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="form_confirmLoan">
			<input type="hidden" name="loanPlan_ID" value="${loanPlan.loanPlan_ID }"/>
			<input type="hidden" name="apply_ID" value="${loanPlan.applyID }"/>
			<input type="hidden" name="applyDetail_ID" value="${loanPlan.applyDetailID }"/>
 			
 			<div class="form-group">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input">业务品种： </label>
		   	    <label class="col-sm-8">${loanPlan.busiTypeName } </label>
		   	    <input type="hidden" name="busiTypeID" value="${loanPlan.busiTypeID }">
		   	    <input type="hidden" name="busiTypeName" value="${loanPlan.busiTypeName }">
 			</div>
 			
			<div class="form-group">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input">放款机构： </label>
		   	    <c:if test="${not empty loanPlan.bankName }">
					 <label class="col-sm-8">${loanPlan.bankName } </label>
					 <input type="hidden" name="bankTypeID" value="${loanPlan.bankTypeID }">
			   	     <input type="hidden" name="bankTypeName" value="${loanPlan.bankTypeName }">
			   	     <input type="hidden" name="bankID" value="${loanPlan.bankID }">
			   	     <input type="hidden" name="bankName" value="${loanPlan.bankName }">
				</c:if>
				<c:if test="${empty loanPlan.bankName }">
					<div class=" col-sm-6">
						<div class="input-group selectBank">
							<input  type="text"  class="form-control col-sm-8" autoField="bankID"   id="selectBank"  name="bankName" readonly="readonly"/>
							<span class="input-group-addon ">
								<i class="icon-caret-down bigger-110"></i>
							</span>
						</div>
					</div>
				</c:if>
 			</div>
 			
 			<div class="form-group">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>放款子机构： </label>
		        <div class="col-sm-8">
					<input type="text" name="subBankName" class="col-sm-10 validate[required,maxSize[50]]" value="${loanPlan.subBankName }">
				</div>
 			</div>
 			
 			<div class="form-group">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input">计划放款金额： </label>
		   	    <label class="col-sm-8"><fmt:formatNumber value="${loanPlan.loanSum }" pattern="###,###.######"/> 万元</label>
		   	    <input type="hidden" name="loadSum" value="${loanPlan.loanSum }">
 			</div>
 			
 			<div class="form-group">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>担保起始日期： </label>
		        <div class="col-sm-8">
					<div class="row">
						<div class="col-sm-8">
							<div class="input-group">
								<input class="form-control date-picker validate[required,custom[date]]" type="text" data-date-format="yyyy-mm-dd" name="loadBeginDate"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
 			</div>
 			
 			<div class="form-group">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>担保到期日期： </label>
		        <div class="col-sm-8">
					<div class="row">
						<div class="col-sm-8">
							<div class="input-group">
								<input class="form-control date-picker validate[required,custom[date]]" type="text" data-date-format="yyyy-mm-dd" name="loadEndDate"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
 			</div>
 			
 			<div class="form-group">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>借据起始日期： </label>
		        <div class="col-sm-8">
					<div class="row">
						<div class="col-sm-8">
							<div class="input-group">
								<input class="form-control date-picker validate[required,custom[date]]" type="text" data-date-format="yyyy-mm-dd" name="billBeginDate"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
 			</div>
 			
 			<div class="form-group">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>借据到期日期： </label>
		        <div class="col-sm-8">
					<div class="row">
						<div class="col-sm-8">
							<div class="input-group">
								<input class="form-control date-picker validate[required,custom[date]]" type="text" data-date-format="yyyy-mm-dd" name="billEndDate"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
 			</div>
 			
 			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>是否涉及敏感债权人： </label>
				<div class="col-sm-8">
					<div class="radio">
						<label>
							<input type="radio" name="isCreditor" class="ace form-field-radio" value="1"/>
							<span class="lbl">是</span>
						</label>
						<label>
							<input type="radio" name="isCreditor" class="ace form-field-radio" value="0" checked="checked" />
							<span class="lbl">否</span>
						</label>
					</div>
				</div>
			</div>
			
			<div id="div_isCreditor" class="hide">
			<div class="form-group">
		   		<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>债权人种类： </label>
				<div class="col-sm-8">
					<select class="col-sm-6 validate[required]"  name="creditorTypeID">
						<option value="">请选择</option>
						<c:forEach items="${creditorTypeList }" var="creditorType">
							<option value="${creditorType.dicTypeID }">${creditorType.dicTypeName }</option>
						</c:forEach>
					</select>
					<input type="hidden" name="creditorTypeName">
				</div>
			</div>
			
			<div class="form-group">
		   		<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>债权人数量： </label>
				<div class="col-sm-8">
					<input type="text" name="creditorCount" class="col-sm-4 validate[required,maxSize[10],custom[number]]">
					<span class="col-sm-2" style="line-height:28px;">人</span>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">身份证编号： </label>
				<div class="col-sm-7">
				    <textarea class="col-sm-12  limited validate[maxSize[2000]]"  rows="5" name="idCard"></textarea>
				</div>
				<div class="col-sm-11 ">
				    <span class="light-grey" style="float:right;">限制2000个字符</span>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">债权方诉求： </label>
				<div class="col-sm-7">
				    <textarea class="col-sm-12  limited validate[maxSize[2000]]"  rows="5" name="creditorDistr"></textarea>
				</div>
				<div class="col-sm-11 ">
				    <span class="light-grey" style="float:right;">限制2000个字符</span>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">债权人备注： </label>
				<div class="col-sm-7">
				    <textarea class="col-sm-12  limited validate[maxSize[2000]]"  rows="5" name="creditorDesc"></textarea>
				</div>
				<div class="col-sm-11">
				    <span class="light-grey" style="float:right;">限制2000个字符</span>
				</div>
			</div>
 			</div>
 			
		</form>
      </div>
      
      <div class="modal-footer">
			<button type="button" class="btn btn-primary btn_submit"><i class='icon-ok bigger-110'></i>保存</button>
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
	/*监视下拉框选项变化*/
	$("select[name]").change(function(){
		var s1 = $(this).attr("name");
		var s2 = $(this).children("option:selected").text();
		var s3 = s1.replace(/ID/,"Name");
		$("input[name='"+s3+"']").val(s2);
	}); 
	/* 监视单选框变化 */
	$('input:radio[name="isCreditor"]').change(function(){
		var val=$('input:radio[name="isCreditor"]:checked').val();
		if(val==1){	//涉及敏感债权人
			$("#div_isCreditor").removeClass("hide");
		}else{	//不涉及敏感债权人
			$("#div_isCreditor").addClass("hide");
		}
	});
</script>
				