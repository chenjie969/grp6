<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade bs-example-modal-sm" id="arcMoveAccept" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog " role="document">
    <div class="modal-content">
    <!-- 档案接收-->
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">档案接收</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="arcMoveAccept_form" >
			    <input type="hidden" id="arcMoveRec_ID" name="arcMoveRec_ID" value="${arcMove.arcMoveRec_ID}">
           	
           	<div class="form-group">
				<label class="col-md-4 control-label no-padding-right" for="form-field-1">接收人： </label>		
					<div class="col-md-8">
						<div class="col-md-6 col-sm-6 input-group acceptUserName">
							<input  type="text"  class="form-control " autoField="acceptUserNameID"   id="acceptUserName"  value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="acceptUserName"  readonly="readonly"/>
							<span class="input-group-addon ">
								<i class="icon-caret-down bigger-110"></i>
							</span>
						</div>
				</div>
		    </div>
           	<div class="form-group">
		   	    <label class="col-md-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>接收日期： </label>
	         	<div class="col-md-8">
					<div class="input-group col-sm-6 col-md-6">
						<input class="form-control date-picker validate[required,custom[date]]" id="acceptDate" name="acceptDate" type="text" data-date-format="yyyy-mm-dd" />
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
					