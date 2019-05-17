<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="addPersonClientModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增个人客户</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="add_personClientForm">
			<input type="hidden" name="clientTypeID" class="ztb_add_clientTypeID" value="02"><%--'01企业02个人经营类03个人消费类（不做字典，直接写在程序中）' --%>
			<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>申请人姓名： </label>
				<div class="col-sm-8">
					<input type="text" name="personName" id="add_personName"  class="col-sm-8 ztb_add_personName ztb_add validate[required,maxSize[50]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>身份证号码： </label>
				<div class="col-sm-8">
					<input type="hidden" name="age" id="add_age"  class="ztb_add_age ztb_add" />
					<input type="text" name="personNum" id="add_personNum"  class="col-sm-8 ztb_add_personNum ztb_add validate[required,minSize[18],maxSize[18]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>企业名称： </label>
				<div class="col-sm-8">
					<input type="text" name="clientName" id="add_clientName"  class="col-sm-8 ztb_add_clientName ztb_add validate[required,maxSize[50]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>创建日期： </label>
				<div class="col-sm-8">
						<div class="row">
							<div class="col-sm-8">
								<div class="input-group">
									<input  type="text" class="form-control date-picker ztb_add_createDateTime validate[required,custom[date]]" 
									name="createDateTime" id="id-date-picker-1"  data-date-format="yyyy-mm-dd" />
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
					</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>创建人： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-8">
							<div class="input-group creatUser_id">
								<input  type="text"  class="form-control validate[required] " autoField="createUserID"   id="creatUser_id"  value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="createUserName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
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
<script type="text/javascript">
$("#add_personNum").blur(function(){  // 失去焦点  
	var persoNum = $('#add_personNum').val();
	 if(persoNum=='' || persoNum.length != 18){
	 	return false;
	 }else{
		 var date = new Date();
		 var year = date.getFullYear(); 
		 var birthday_year = parseInt(persoNum.substr(6,4));
		 var userage= year - birthday_year;
		 $('#add_age').val(userage); 
		 return false;
	}
})
</script>

