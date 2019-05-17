<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="addCompanyClient" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增企业</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="add_companyClientForm">
			<input type="hidden" name="clientTypeID" class="ztb_add_clientTypeID" value="01"><%--'01企业02个人经营类03个人消费类（不做字典，直接写在程序中）' --%>
			<!-- <input type="hidden" name="mod_uid" class="ztb_add_mod_uid"> -->
			<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>企业全称： </label>
				<div class="col-sm-8">
					<input type="text" name="clientName" id="add_clientName"  class="col-xs-10 col-sm-8 ztb_add_clientName ztb_add validate[required,maxSize[50]]" />
					
				</div>
			</div>
			
			<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>所属区域： </label>
		        <div class="col-sm-8">	
		        		<div class="row">
						<div class=" col-sm-6 ">
						<div class="input-group fullAreaCode">
						         <!-- <input type="hidden" class="ztb_add_fullAreaName ">
						         <input type="hidden" class="ztb_add_fullAreaCode "> -->
								 <input type="text"  class="form-control validate[required] " autoField="fullAreaCode" style="line-height:28px;" id="fullAreaCode"  value="" dataValue="" name="fullAreaName" readonly="readonly"/>							
								 <span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								 </span>
						</div>
						</div>
					</div>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>客户来源： </label>
				<div class="col-sm-8">
		        		<input type="hidden" id="clientSourceName" name="clientSourceName" class="col-sm-6 ztb_add_clientSourceName">
						<select class="col-sm-8  ztb_add_clientSourceID select_clientSource btn_ztb_select validate[required]"  name="clientSourceID" class_name="ztb_add_clientSourceName" id="select_clientSource">					
						</select>
				</div>	
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2">来源说明： </label>
				<div class="col-sm-8">
					<textarea class="col-sm-10 ztb_add_clientSourceDesc ztb_add validate[maxSize[50]]"  name="clientSourceDesc" id="add_clientSourceDesc"  rows="3"></textarea>
					<div class="col-sm-10 no-padding-right">
		                 <span class="light-grey" style="float:right;">限制250个字符</span>
		            </div>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-2"><i class="icon-asterisk orange"></i>创建日期： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-6">
							<div class="input-group">
								<input  type="text" class="form-control date-picker  ztb_add_createDateTime validate[required,custom[date]]" name="createDateTime"  id="id-date-picker-1" data-date-format="yyyy-mm-dd" />
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
						<div class=" col-sm-6">
							<div class="input-group txt_id">
								<input  type="text"  class="form-control validate[required] " autoField="createUserID"   id="txt_id"  value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="createUserName"  readonly="readonly"/>
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