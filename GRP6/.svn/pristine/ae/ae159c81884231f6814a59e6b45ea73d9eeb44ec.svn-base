<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
/*注册日期控件点击事件*/
$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
	$(this).prev().focus();
}); 
</script>
<div class="modal fade bs-example-modal-sm" id="medicalAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加体检记录</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="medicalAdd_Form"> 
			<input type="hidden" id="staffcaseId" name="staffcase_Id"/>	
              
                 <div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>体检日期： </label>
						<div class="col-sm-9">
							<div class="input-group col-sm-7" style="float: left;">
								<input type="text" name="medicalDate" id="id-date-picker-1" data-date-format="yyyy-mm-dd" 
							class="form-control date-picker validate[required,custom[date]] " type="text"/>  <span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
			 	<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">体检费用：</label>
						<div class="col-sm-9">
							<input type="text" name="medicalFees" id="medicalFees"  class="col-sm-4 validate[custom[number],maxSize[10]]" />元
						</div>
					</div>  
				<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">体检情况：</label>
						<div class="col-sm-9">
							<textarea class="col-sm-10 limited   validate[maxSize[250]]" rows="5" name="medicalInfo" id="medicalInfo"></textarea>
							<div class="col-sm-10 no-padding-right">
								<span class="light-grey pull-right">最多允许输入字符250个</span>
							</div>
							</div>
					</div>	
			 	<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">体检医疗机构：</label>
						<div class="col-sm-9">
							<input type="text" name="medicalAgencies" id="medicalAgencies"  class="col-sm-10  validate[maxSize[50]]" />	
						</div>
					</div>  
				<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">备注：</label>
						<div class="col-sm-9">
							<textarea class="col-sm-10 limited  validate[maxSize[250]]" rows="5" name="medicalNotes" id="medicalNotes"></textarea>
							<div class="col-sm-10 no-padding-right">
								<span class="light-grey pull-right">最多允许输入字符250个</span>
							</div>
							</div>
					</div>	
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" ><i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
