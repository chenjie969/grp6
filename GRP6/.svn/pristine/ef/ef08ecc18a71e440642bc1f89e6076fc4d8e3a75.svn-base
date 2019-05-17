<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<script type="text/javascript">
/*注册日期控件点击事件*/
$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
	$(this).prev().focus();
}); 
</script>
<div class="modal fade bs-example-modal-sm" id="trainingUpdate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改培训记录</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="trainingUpdate_Form">
		<input type="hidden" name="trainingID" value="${training.trainingID}"/>
		<input type="hidden" name="staffcase_Id" value="${training.staffcase_Id}"/> 	
                 		<div class="form-group ">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>年度：
						</label>
							<div class="col-sm-9">
							<input type="text" name="trainingYear" id="trainingYear" class="col-sm-4 validate[required,maxSize[4]]" value="${training.trainingYear}"/> 
							<span class="col-sm-8" style="line-height:34px;">年</span>
						</div>
					</div>   	
			
			 	<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>培训名称：</label>
						<div class="col-sm-9">
							<input type="text" name="trainingName" id="trainingName"  class=" col-sm-10  validate[required,maxSize[20]]" value="${training.trainingName}" />	
						</div>
					</div>  
					
			 	<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">期间：</label>
						<div class="col-sm-9">
							<input type="text" name="trainingPeriod" id="trainingPeriod"  class=" col-sm-10 validate[maxSize[100]]"value="${training.trainingPeriod}" />	
						</div>
					</div>  
	          	
	        	<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">费用：</label>
						<div class="col-sm-9">
							<input type="text" name="trainingFees" id="trainingFees" class="col-sm-4 validate[custom[number],maxSize[10]]"value="${training.trainingFees}" /> 
							<span class="col-sm-8" style="line-height:34px;">元</span>
						</div>
					</div>  
             <div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">备注：</label>
							<div class="col-sm-9">
							<textarea class="col-sm-10 limited   validate[maxSize[250]]" rows="5" name="trainingNotes" id="edit_busiScope">${training.trainingNotes}</textarea>
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
