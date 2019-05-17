<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<script type="text/javascript">
/*注册日期控件点击事件*/
$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
	$(this).prev().focus();
}); 
</script>
<div class="modal fade bs-example-modal-sm" id="laborContractUpdate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改劳动合同</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="laborContractUpdate_Form">
		<input type="hidden" name="laborContractID" value="${laborContract.laborContractID}"/>
		<input type="hidden" name="staffcase_Id" value="${laborContract.staffcase_Id}"/>
       <div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>签订起止日期： </label>
						<div class="col-sm-9">
							<div class="input-group col-sm-4" style="float: left;">
								<input type="text" value="<fmt:formatDate value='${laborContract.laborContractStartDate}' pattern='yyyy-MM-dd'/>"
									class="form-control date-picker validate[required,custom[date]]"
									name="laborContractStartDate" id="id-date-picker-1"
									data-date-format="yyyy-mm-dd" /> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<p class="col-sm-1">-</p>
							<div class="input-group col-sm-4">
								<input type="text" value="<fmt:formatDate value='${laborContract.laborContractEndDate}' pattern='yyyy-MM-dd'/>"
									class="form-control date-picker validate[required,custom[date]]"
									name="laborContractEndDate" id="id-date-picker-2"
									data-date-format="yyyy-mm-dd" /> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
					<div class="form-group ">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">签订期限： </label>
							<div class="col-sm-9">
							<input type="text" name="laborContractPeriod" class="col-sm-4" value="${laborContract.laborContractPeriod}"/> 
							<span class="col-sm-8" style="line-height:34px;">年</span>
						</div>
					</div>
					<div class="form-group ">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">劳动合同类型： </label>
						<div class="col-sm-9">
							<input type="text" name="laborContractType" value="${laborContract.laborContractType}"
								class="col-xs-10 col-sm-9" />
						</div>
					</div>
						<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-input">签订日期： </label>
						<div class="col-sm-9">
							<div class="input-group col-sm-4" style="float: left;">
								<input type="text" class="form-control date-picker  validate[custom[date]]" name="laborContractDate" id="id-date-picker-1"
									data-date-format="yyyy-mm-dd" readonly value="<fmt:formatDate value='${laborContract.laborContractDate}' pattern='yyyy-MM-dd'/>"/> <span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">备注：</label>
							<div class="col-sm-9">
							<textarea class="col-sm-10 limited  validate[maxSize[250]]" rows="5" name="laborContractNotes" 
								id="edit_busiScope">${laborContract.laborContractNotes}</textarea>
							<div class="col-sm-10 no-padding-right">
								<span class="light-grey pull-right">最多允许输入字符250个</span>
							</div>
							</div>
					</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
