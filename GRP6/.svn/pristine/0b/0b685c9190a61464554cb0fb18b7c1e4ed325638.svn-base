<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
/*注册日期控件点击事件*/
$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
	$(this).prev().focus();
}); 
function sum(){
	var sum = 0;
	var socialInsurancePension = $("#socialInsurancePension").val();
	var socialInsuranceInjury = $("#socialInsuranceInjury").val();
	var socialInsuranceMedical = $("#socialInsuranceMedical").val();
	var socialInsuranceUnemploy = $("#socialInsuranceUnemploy").val();
	var socialInsuranceFertility = $("#socialInsuranceFertility").val();
	sum = Number(socialInsurancePension) + Number(socialInsuranceInjury)+Number(socialInsuranceMedical)+Number(socialInsuranceUnemploy)+Number(socialInsuranceFertility);
	
	$("#socialInsuranceCum").val(sum)
}

</script>
<div class="modal fade bs-example-modal-sm" id="socialInsuranceAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加社保缴纳</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="socialInsuranceAdd_Form">
		<input type="hidden" id="staffcaseId" name="staffcase_Id"/> 	
             
	 <div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>缴纳年月： </label>					
							<div class="col-sm-9">
							<div class="input-group col-sm-7" style="float: left;">
								<input type="text" name="socialInsuranceDate" id="id-date-picker-1" data-date-format="yyyy-mm-dd" class="form-control date-picker validate[required,custom[date]] "/> 
							 <span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
			</div>
			 		<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>养老:</label>
						<div class="col-sm-9">
							<input type="text" name="socialInsurancePension" id="socialInsurancePension" onchange="sum();" class="col-sm-4 validate[required,custom[number]]" /> 
							<span class="col-sm-8" style="line-height:34px;">元</span>
						</div>
					</div>
					
			 		<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>工伤:</label>
						<div class="col-sm-9">
							<input type="text" name="socialInsuranceInjury" id="socialInsuranceInjury"onchange="sum();" class="col-sm-4 validate[required,custom[number]]" /> 
							<span class="col-sm-8" style="line-height:34px;">元</span>
						</div>
					</div>
							
	<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>医疗:</label>
						<div class="col-sm-9">
							<input type="text" name="socialInsuranceMedical" id="socialInsuranceMedical"onchange="sum();" class="col-sm-4 validate[required,custom[number]]" /> 
							<span class="col-sm-8" style="line-height:34px;">元</span>
						</div>
					</div>  
							
			 		<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>生育:</label>
						<div class="col-sm-9">
							<input type="text" name="socialInsuranceFertility" id="socialInsuranceFertility"onchange="sum();" class="col-sm-4 validate[required],custom[number]" /> 
							<span class="col-sm-8" style="line-height:34px;">元</span>
						</div>
					</div>  
							
			 		<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>失业:</label>
						<div class="col-sm-9">
							<input type="text" name="socialInsuranceUnemploy" id="socialInsuranceUnemploy" onchange="sum();"class="col-sm-4 validate[required],custom[number]" /> 
							<span class="col-sm-8" style="line-height:34px;">元</span>
						</div>
					</div> 
							
			 		<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>小计:</label>
						<div class="col-sm-9">
							<input type="text" name="socialInsuranceCum" id="socialInsuranceCum" class="col-sm-4 validate[required],custom[number]" /> 
							<span class="col-sm-8" style="line-height:34px;">元</span>
						</div>
					</div>
                 <div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">备注：</label>
							<div class="col-sm-9">
							<textarea class="col-sm-10 limited  validate[maxSize[250]]" rows="5" name="socialInsuranceNotes" id="socialInsuranceNotes"></textarea>
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
