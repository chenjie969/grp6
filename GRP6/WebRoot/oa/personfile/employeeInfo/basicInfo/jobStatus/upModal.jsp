<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="jobUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改职务情况</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="jobUpdate_Form"> 	
                 		 <input type="hidden" id="dutyID" name="dutyID" value="${hrstaffDuty.dutyID}"/>
                 			
	          		
	          	<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>职务名称： </label>
				<div class="col-sm-9">
					<input type="text" name="dutyName" id="dutyName"  class=" col-sm-10 ztb_add validate[required,maxSize[10]]" value="${hrstaffDuty.dutyName}" />					
				</div>
			</div>
			
	          	
	         <div class="form-group ">
				   	<label class="col-sm-3 control-label no-padding-right" for="form-input">所属部门： </label>
			        <div class="col-sm-9">
								<div class="col-md-6 col-sm-6 input-group allDepartsTree3">
								<input type="text" class="form-control " autoField="dutyDepGID" id="allDepartsTree3" value="${hrstaffDuty.dutyDepGIDName}" name="departName3"
								dataValue="${hrstaffDuty.dutyDepGID}" 	readonly="readonly" /> <span class="input-group-addon "> <i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
					</div>
	         </div>	
			
	     	
	         <div class="form-group ">
				   	<label class="col-sm-3 control-label no-padding-right" for="form-input">直接上级： </label>
			        <div class="col-sm-9">
					
						<input type="text" name="dutySuperior" id="dutySuperior"  value="${hrstaffDuty.dutySuperior}" class=" col-sm-10 ztb_add validate[maxSize[10]]" />	
						
					</div>
	         </div>	
	        
             
	          	<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">职务等级： </label>
				<div class="col-sm-9">
					<input type="text" name="superiorLV" id="superiorLV"  value="${hrstaffDuty.superiorLV}" class=" col-sm-10 ztb_add validate[maxSize[5]]" />					
				</div>
			</div>       
   
	          	<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">晋升方向： </label>
				<div class="col-sm-9">
					<input type="text" name="dutyDirection" id="dutyDirection"  value="${hrstaffDuty.dutyDirection}" class=" col-sm-10 ztb_add" />					
				</div>
			</div>
            
	          	<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">薪资标准： </label>
				<div class="col-sm-9">
					<input type="text" name="dutySalary" id="dutySalary"  class=" col-sm-10 ztb_add validate[custom[number],maxSize[10]]"  value="${hrstaffDuty.dutySalary}"/>	元				
				</div>
			</div>
			 	<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">备注：</label>
								<div class="col-sm-9">
							<textarea class="col-sm-10 limited  ztb_edit_dutyNotes validate[maxSize[50]]" rows="5" name="dutyNotes" id="edit_dutyNotes">${hrstaffDuty.dutyNotes}</textarea>
							<div class="col-sm-10 no-padding-right">
								<span class="light-grey pull-right">限制输入字数50个</span>
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
