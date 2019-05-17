<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%><div class="modal fade bs-example-modal-sm" id="sysparaEditModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改系统参数</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal row" role="form" id="edit_sysparaForm">
			<input type="hidden" name="syspara_ID" value="${para.syspara_ID}" />
			<input type="hidden" name="paraName" value="${para.paraName}" />
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-input">参数名称： </label>
				<label class="col-sm-8" >${para.paraName} </label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>参数值： </label>
				<div class="col-sm-8">
					<input type="text" name="paraValue" class="col-sm-10 validate[required,maxSize[50]]" value="${para.paraValue}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">备注 ：</label>
				<div class="col-sm-8">
					<textarea class="col-xs-10 col-sm-10 limited validate[maxSize[50]]"  rows="3" cols="20" name="remarks" >${para.remarks}</textarea>
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

 
<script type="text/javascript">
$("#edit_personNum").blur(function(){  // 失去焦点  
	var persoNum = $('#edit_personNum').val();
	 if(persoNum=='' || persoNum.length != 18){
	 	return false;
	 }else{
		 var date = new Date();
		 var year = date.getFullYear(); 
		 var birthday_year = parseInt(persoNum.substr(6,4));
		 var userage= year - birthday_year;
		 $('#edit_age').val(userage); 
		 return false;
	}
})
</script>
