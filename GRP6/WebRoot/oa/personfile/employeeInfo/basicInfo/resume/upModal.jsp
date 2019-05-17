<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="updateResumeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改工作简历</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="updateResume_Form"> 	
                  <input type="hidden" id="jobID" name="jobID" value="${hrstaffJob.jobID}"/>
            			<div class="form-group">					
						<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>起止年月： </label>
						
							<div class="col-sm-9">
							<div class="input-group col-sm-4" style="float: left;">
							
							
							<input class="form-control date-pickerMonth validate[required]" type="text" id="date-picker-1"  name="jobStartDate" 
										value="${hrstaffJob.jobStartDate}" data-date-format="yyyy-mm"/>
							
							
							 <span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>	
							</div>
							<p class="col-sm-1">-</p>
							<div class="input-group col-sm-4">
							<input class="form-control date-pickerMonth validate[required]" type="text" id="date-picker-1" name="jobEndDate" 
										value="${hrstaffJob.jobEndDate}" data-date-format="yyyy-mm"/>
							
							
							
							 <span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>	
							</div>
						</div>
					</div>
	         <div class="form-group ">
				   	<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>工作单位： </label>
			        <div class="col-sm-9">
						<input type="text" name="jobUnits" id="jobUnits"  class=" col-sm-10 ztb_add validate[required]" value="${hrstaffJob.jobUnits}" />	
					</div>
	         </div>	
	         <div class="form-group ">
				   	<label class="col-sm-3 control-label no-padding-right" for="form-input">地点： </label>
			        <div class="col-sm-9">
						<input type="text" name="jobAddress" id="jobAddress"  class=" col-sm-10 ztb_add" value="${hrstaffJob.jobAddress}" />	
						
					</div>
	         </div>	
	          	<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>职务： </label>
				<div class="col-sm-9">
					<input type="text" name="jobposts" id="jobposts"  value="${hrstaffJob.jobposts}" class=" col-sm-10 ztb_add validate[required]" />					
				</div>
			</div>  
			<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">备注：</label>
						<div class="col-sm-9">
							<textarea class="col-sm-10 limited  ztb_edit_busiScope validate[maxSize[50]]" rows="5" name="jobNotes" id="edit_jobNotes">${hrstaffJob.jobNotes}</textarea>
							<div class="col-sm-10 no-padding-right">
								<span class="light-grey pull-right">限制输入字数50个</span>
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
