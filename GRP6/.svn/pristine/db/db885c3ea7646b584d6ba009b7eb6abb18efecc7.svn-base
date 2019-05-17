<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="modal fade" id="beforeEndAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" style="z-index:9999">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">提前到期确认</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="form_beforeEndAdd">
			<input type="hidden" name="loanPlan_ID" value="${project.project_ID }"/>

 			<div class="form-group">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input">业务品种： </label>
		   	    <label class="col-sm-8">${project.busiTypeName } </label>
 			</div>
 			
			<div class="form-group">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input">放款机构： </label>
				<label class="col-sm-8">${project.bankName } </label>
 			</div>
 			
 			<div class="form-group">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input">放款子机构： </label>
				<label class="col-sm-8">${project.subBankName } </label>
 			</div>
 			
 			<div class="form-group">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input">放款金额： </label>
				<label class="col-sm-8" id="loadSum">${project.loadSum } 万元</label>
 			</div>
 			
 			<div class="form-group">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input">提前到期金额： </label>
		   	    <div class="col-sm-8">
					<input type="text" name="beforeEndSum" class="col-sm-6 validate[required,custom[number],maxSize[18],custom[isLessThanLoanSum]]" id="beforeEndSum"/>
					<span class="midden col-sm-4 " style="line-height:28px;">万元	</span>
				</div>
 			</div>
 			
 			<div class="form-group">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>提前到期日期： </label>
		        <div class="col-sm-8">
					<div class="row">
						<div class="col-sm-8">
							<div class="input-group">
								<input class="form-control date-picker validate[required,custom[date]]" type="text" data-date-format="yyyy-mm-dd" name="beforeEndDate"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
 			</div>
 			
 			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">提前到期原因： </label>
				<div class="col-sm-8">
					<textarea rows="3" name="beforeEndDesc" class="col-sm-10 validate[maxSize[200]]"></textarea>
					<div class="col-sm-10 no-padding-right">
						<span class="light-grey" style="float:right">限制200个字符</span>
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
</script>
				