<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="addSocialRelaViewModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加社会关系</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="addSocialRela_Form"> 	
                  <input type="hidden" id="staffcase_Id" name="staffcase_Id" value="${hrstaffRelation.staffcase_Id}"/>
            	         			<div class="form-group ">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>姓名：
						</label>
						<div class="col-sm-9">
							<input type="text" name="socialName" id="socialName"  class="col-sm-10 ztb_add validate[required,maxSize[10]]" value="${hrstaffRelation.socialName}"/>
						</div>
					</div>
	      <div class="form-group ">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">性别：
						</label>
						<div class="col-sm-9">
							<label class="radio-inline"> <input type="radio" value="男" name="socialSex" checked>男
							</label> <label class="radio-inline"> <input type="radio" value="女" name="socialSex">女
							</label>

						</div>
					</div>	

			 	 	<div class="form-group ">
						<label class="col-sm-3 control-label no-padding-right" for="form-input">年龄:</label>
						<div class="col-sm-9">
							<input type="text" name="socialAge" id="socialAge" class=" col-sm-4 ztb_add validate[custom[number],maxSize[6]]"  value="${hrstaffRelation.socialAge}"/> 
							<span class="col-sm-8" style="line-height:34px;">岁</span>
						</div>
					</div>
			 	<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input"><i class="icon-asterisk orange"></i>与之关系：</label>
						<div class="col-sm-9">
							<input type="text" name="socialType" id="socialType"  value="${hrstaffRelation.socialType}" class="col-sm-10 ztb_add validate[required,maxSize[20]]" />	
						</div>
					</div>  
	        	<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">所在城市：</label>
						<div class="col-sm-9">
							<input type="text" name="socialAddress" id="socialAddress" value="${hrstaffRelation.socialAddress}" class="col-sm-10 ztb_add" />	
						</div>
					</div> 	     	
			 	<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">工作单位：</label>
						<div class="col-sm-9">
							<input type="text" name="socialUnits" id="socialUnits" value="${hrstaffRelation.socialUnits}" class="col-sm-10 ztb_add" />	
						</div>
					</div>               
	           <div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">职务：</label>
						<div class="col-sm-9">
							<input type="text" name="socialDuty" id="socialDuty" value="${hrstaffRelation.socialDuty}"  class="col-sm-10 ztb_add" />	
						</div>
					</div>  
             <div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-input">备注：</label>
						<div class="col-sm-9">
							<textarea class="col-sm-10 limited  ztb_edit_busiScope validate[maxSize[2000]]" rows="5" name="socialNotes" id="edit_socialNotes">${hrstaffRelation.socialNotes}</textarea>
							<div class="col-sm-10 no-padding-right">
								<span class="light-grey pull-right">限制输入字数250个</span>
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
