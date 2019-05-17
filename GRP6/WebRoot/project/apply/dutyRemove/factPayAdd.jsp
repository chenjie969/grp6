<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="addFactPay" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">部分还款</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="add_FactPay_form">
      	 	<input type="hidden" name=project_ID  value="${project_ID }"/>
      		 <input type="hidden" name=applyID  value="${apply_ID }"/>

					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1"><i class="icon-asterisk orange"></i>还款类型：</label>
						<div class="col-sm-8">
							<input type="hidden" id="freeTypeName" name="freeTypeName"
								class="freeTypeName"> <select
								class="col-xs-8 validate[required] freeTypeID" id="freeTypeID"
								name="freeTypeID">
								<c:forEach var="freeType" items="${freeTypeList}"
									varStatus="status">
									<option value="${freeType.dicTypeID}">${freeType.dicTypeName}</option>
								</c:forEach>
							</select>
						</div>
					</div>



					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>还款日期：
						</label>
						<div class="col-sm-8">
							<div class="input-group col-sm-8">
								<input class="form-control date-picker validate[required,custom[date]]"
									type="text" id="payDate" data-date-format="yyyy-mm-dd" name="payDate" /> 
								<span class="input-group-addon"> 
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1"><i class="icon-asterisk orange"></i>还款金额：
						</label>
						<div class="col-sm-8">

							<input type="text" id="paySum-add" name="paySum" class="col-sm-6 validate[required]">&nbsp;
							<span class="midden col-sm-4 " style="line-height:28px;">万元</span>

						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1">其中： </label>
					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1">还款本金：</label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-6 " id="payCapitalSum-add" name="payCapitalSum">
							<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1">还款利息：</label>
						<div class="col-sm-8">
							<input type="text" class="col-sm-6 " id="payInterestSum-add" name="payInterestSum">
							<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
						</div>
					</div>

					<!-- <div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1">其他还款：</label>
						<div class="col-sm-8">
							<input type="text" name="payOtherSum">&nbsp;<span>万元</span>
						</div>
					</div> -->

					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1">备注： </label>
						<div class="col-sm-8">
							<textarea class="col-xs-8 validate[maxSize[100]]" name="remark"
								rows="5"></textarea>
							<div class="col-xs-8 no-padding-right">
								<span class="light-grey" style="float: right">限制100个字符</span>
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
					

<script type="text/javascript">
	$('.date-picker').datepicker({autoclose: true}).next().on(ace.click_event, function () {
	    $(this).prev().focus();
	});
	
	$('.input-group-addon').click(function (){
		$('#payDate').focus();
	});
	
	$('.freeTypeName').attr("value",$('.freeTypeID option:selected').text());
	$(".freeTypeID").on("change", function () {
		$('.freeTypeName').attr("value",$('.freeTypeID option:selected').text());
    })
</script>					