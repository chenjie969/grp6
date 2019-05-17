<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="planPayAutoAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" style="z-index:9999">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">自动生成还款计划</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="form_planPayAutoAdd">
			<input type="hidden" name="apply_ID" value="${planPay.apply_ID }"/>
			<input type="hidden" name="loanPlan_ID" value="${planPay.loanPlan_ID }"/>
 			
 			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>计划还款金额： </label>
				<div class="col-sm-8">
					<input type="text" name="planPaySum" class="col-sm-8 validate[required,custom[number],maxSize[18]]" id="autoAddPlanPaySum"/>
					<span class="midden col-sm-2" style="line-height:28px;">万元	</span>
				</div>
			</div>	
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>从第几个月开始还款： </label>
				<div class="col-sm-8">
					<input type="text" name="startMonth" class="col-sm-8 validate[required,custom[number],maxSize[5]]" id="startMonth"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>每隔几个月还款： </label>
				<div class="col-sm-8">
					<input type="text" name="monthNum" class="col-sm-8 validate[required,custom[number],maxSize[5]]" id="monthNum"/>
				</div>
			</div>
 			<!-- <div class="form-group">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>计划还款日期： </label>
		        <div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<div class="input-group">
								<input class="form-control date-picker validate[required,custom[date]]" type="text" data-date-format="yyyy-mm-dd" name="planPayDate"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
 			</div> -->
		</form>
      </div>
      
      <div class="modal-footer">
			<button type="button" class="btn btn-primary" id="btn_submit"><i class='icon-ok bigger-110'></i>保存</button>
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
				