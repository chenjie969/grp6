<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="addContractDoc" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增合同</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="addContractDoc_form">
      		 <input type="hidden" name="apply_ID"  value="${apply_ID }"/>
					
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>合同编号： </label>
				<div class="col-sm-8">
					<input type="text" class="col-sm-8 validate[required]" value="${contractCode }" name="contractCode" id="contractCode"/>
				</div>
			</div>	
			
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>合同名称： </label>
				<div class="col-sm-8">
						<input type="text" class="col-sm-8 validate[required]" name="contractName" id="contractName"/>
				</div>
			</div>
					
			<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1"><i class="icon-asterisk orange"></i>合同类型：</label>
						<div class="col-sm-8">
							<input type="hidden" id="contractTypeName" name="contractTypeName" class="contractTypeName"> 
							<select class="col-xs-8 validate[required] contractTypeID" id="contractTypeID" name="contractTypeID">
								<c:forEach var="dicType" items="${dicTypeList}"
									varStatus="status">
									<option value="${dicType.dicTypeID}">${dicType.dicTypeName}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>合同起始日期：
						</label>
						<div class="col-sm-8">
							<div class="input-group col-sm-8">
								<input class="form-control date-picker validate[required,custom[date]]"
									type="text" id="contractBeginDate" data-date-format="yyyy-mm-dd" name="contractBeginDate" /> 
								<span class="input-group-addon input-group-addon1"> 
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>合同到期日期：
						</label>
						<div class="col-sm-8">
							<div class="input-group col-sm-8">
								<input class="form-control date-picker validate[required,custom[date]]"
									type="text" id="contractEndDate" data-date-format="yyyy-mm-dd" name="contractEndDate" /> 
								<span class="input-group-addon input-group-addon2"> 
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1">备注： </label>
						<div class="col-sm-8">
							<textarea class="col-xs-8 validate[maxSize[100]]" name="remark"
								rows="5"></textarea>
							<div class="col-xs-8 no-padding-right">
								<span class="light-grey" style="float: right">限制200个字符</span>
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
	
	$('.input-group-addon1').click(function (){
		$('#contractBeginDate').focus();
	});
	$('.input-group-addon2').click(function (){
		$('#contractEndDate').focus();
	});
	
	$('.contractTypeName').attr("value",$('.contractTypeID option:selected').text());
	$(".contractTypeID").on("change", function () {
		$('.contractTypeName').attr("value",$('.contractTypeID option:selected').text());
    })
</script>					






