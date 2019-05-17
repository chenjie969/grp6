<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%><div class="modal fade bs-example-modal-sm" id="sysparaViewModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改系统参数</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal row" role="form" id="edit_personClientForm">
			<input type="hidden" name="client_ID" class="ztb_edit_client_ID ztb_edit" value="" />
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-input">参数名称： </label>
				<label class="col-sm-8 ">${para.paraName} </label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-input">参数值： </label>
				<label class="col-sm-8 ">${para.paraValue} </label>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">备注 ：</label>
				<label class="col-sm-8 ">${para.remarks} </label>
			</div>
		</form>
      </div>
      <div class="modal-footer">
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
