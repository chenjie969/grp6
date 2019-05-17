<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="modal fade" id="planLoanEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" style="z-index:9999">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">修改放款计划</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="form_planLoanEdit">
			<input type="hidden" name="applyDetailID" value="${loanPlan.applyDetailID }">
 			<input type="hidden" name="loanPlan_ID" value="${loanPlan.loanPlan_ID }">
 			<input type="hidden" name="accessType" value="update"/>
 			
 			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>放款机构： </label>
				<label class="col-sm-8" for="form-field-1">${loanPlan.bankName }</label>
			</div>
			
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>业务品种： </label>
				<label class="col-sm-8" for="form-field-1">${loanPlan.busiTypeName }</label>
			</div>
			
 			<div class="form-group">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>计划放款日期： </label>
		        <div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<div class="input-group">
								<input class="form-control date-picker validate[required,custom[date]]" type="text" data-date-format="yyyy-mm-dd" name="loanDate"
									value="<fmt:formatDate value='${loanPlan.loanDate }' pattern='yyyy-MM-dd' type='date'/>"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
 			</div>
 			
 			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>计划放款金额： </label>
				<div class="col-sm-8">
					<input type="text" name="loanSum" class="col-sm-8 validate[required,custom[number],maxSize[18]]" value="${loanPlan.loanSum }" id="updateLoanSum"/>
					<span class="midden col-sm-2" style="line-height:28px;">万元	</span>
				</div>
			</div>
 			
		</form>
      </div>
      <div class="modal-footer">
			<button type="button" class="btn btn-primary btn_submit"><i class='icon-ok bigger-110'></i>保存</button>
			<button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>取消</button>
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
				