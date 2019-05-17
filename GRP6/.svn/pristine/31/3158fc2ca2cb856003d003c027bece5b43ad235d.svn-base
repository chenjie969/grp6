<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade bs-example-modal-sm" id="arcMoveRecAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog " role="document">
    <div class="modal-content">
    <!-- 新增档案页面 -->
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增档案记录</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="arcMoveRecAdd_form" >
			    <input type="hidden" id="apply_ID" name="apply_ID" value="${pro_arcMoveRec.apply_ID}">
           	
           	<div class="form-group">
				<label class="col-md-4 control-label no-padding-right" for="form-field-1">移交人： </label>		
					<div class="col-md-8">
						<div class="col-md-6 col-sm-6 input-group txt_id">
							<input  type="text"  class="form-control " autoField="moveUserNameID"   id="txt_id"  value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="moveUserName"  readonly="readonly"/>
							<span class="input-group-addon ">
								<i class="icon-caret-down bigger-110"></i>
							</span>
						</div>
				</div>
		    </div>
           	<div class="form-group">
		   	    <label class="col-md-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>移交日期： </label>
	         	<div class="col-md-8">
					<div class="input-group col-sm-6 col-md-6">
						<input class="form-control date-picker validate[required,custom[date]]" id="moveDate" name="moveDate" type="text" data-date-format="yyyy-mm-dd" />
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
	        </div>
           	
	     
					
			<!-- <div class="form-group">
					<label class="col-sm-4 control-label no-padding-right" for="form-input"> 备注：</label>									   	    
		         	<div class="col-sm-8">
						<textarea class="col-sm-9 limited   validate[maxSize[2000]]" rows="5"  name="remark" id="remark" ></textarea>							
					    <span class="col-sm-5 light-grey col-sm-push-5">限制输入字数2000个</span>
					</div>
			</div> -->
			
				

		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary " id="btn_submit"> <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					