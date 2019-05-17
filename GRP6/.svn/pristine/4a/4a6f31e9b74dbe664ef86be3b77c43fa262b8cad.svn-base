<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="editCompanyClientSource" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改客户来源</h4>
      </div>
      <div class="modal-body">

			<form class="form-horizontal" role="form" id="editClientSource_from">
				<input type="hidden" name="client_ID"    class="ztb_edit_client_ID">
				<input type="hidden" name="clientTypeID" class="ztb_edit_clientTypeID">
			<!-- 	<input type="hidden" name="banksortid" class="ztb_edit_banksortid"> -->
			
				<div class="space-4"></div>
				<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>客户来源： </label>
					<div class="col-sm-9">
			        		<input type="hidden" id="clientSourceName" name="clientSourceName" class="ztb_edit_clientSourceName">
							<select class="col-sm-9  ztb_edit_clientSourceID select_clientSource btn_ztb_select validate[required]"  name="clientSourceID" class_name="ztb_edit_clientSourceName" id="select_clientSource">					
							</select>
					
			        </div>	
				</div>
				
				<div class="space-4"></div>
				<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 来源说明： </label>
					<div class="col-sm-9" >
						<!-- <input type="text" name="clientSourceDesc" id="edit_clientSourceDesc"  
						class="col-xs-10 col-sm-11 ztb_edit_clientSourceDesc validate[required,maxSize[50]]" 
						style="width:315px"
						/> -->
						<textarea class="col-xs-10 col-sm-8 ztb_edit_clientSourceDesc ztb_add validate[maxSize[50]]"  name="clientSourceDesc" id="edit_clientSourceDesc"  
						style="width:315px;"
						></textarea>
					</div>
				</div>
				
				
				<div class="space-4"></div>
				<!-- <div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>创建部门： </label>
					<div class="col-sm-7">
						<input type="text" name="fullDepartName" id="edit_fullDepartName"  
						class="col-xs-10 col-sm-11 ztb_edit_fullDepartName validate[required,maxSize[50]]" 
						style="width:315px"
						/>
					</div>
				</div> -->
				
				<div class="form-group ">
				   	<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>创建部门： </label>
			        <div class="col-sm-7">
						<div class="input-group fullDepartCode">
						        <input type="hidden"  class="ztb_edit_fullDepartName">
						         <input type="hidden" class="ztb_edit_fullDepartCode">
								 <input type="text"  class="form-control validate[required] " autoField="fullDepartCode" style="line-height:28px;" id="fullDepartCode"  value="" dataValue="" name="fullDepartName" 
								 style="width:315px;" readonly="readonly"/>	
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
						</div>
					</div>
             </div>
				
				
				
				
				
				
				<div class="space-4"></div>
			<!-- 	<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>创建人： </label>
					<div class="col-sm-9">
						<input type="text" name="createUserName" id="edit_createUserName"  class="col-xs-10 col-sm-11 ztb_edit_createUserName validate[required,maxSize[50]]" />
					</div>
				</div> -->
				
				<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>创建人： </label>
				<div class="col-sm-9">
					<div class="row">
						<div class=" col-sm-9 ">
							  <div class="input-group createUserName">
								        <input type="hidden"  class="ztb_edit_createUserName">
								         <input type="hidden" class="ztb_edit_createUserID">
										 <input type="text"  class="form-control validate[required] " autoField="createUserID" style="line-height:28px;width:281px;" id="createUserName"  value="" dataValue="" name="createUserName" 
										 readonly="readonly" />	
										<span class="input-group-addon ">
											<i class="icon-caret-down bigger-110"></i>
										</span>
								</div>	
						</div>
					</div>
				</div>
			</div>
				
				
				
				
				<div class="space-4"></div>
			<!-- 	<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>创建时间： </label>
					<div class="col-sm-9">
						<input type="text" name="createDateTime" id="edit_createDateTime"  class="col-xs-10 col-sm-11 ztb_edit_createDateTime validate[required,maxSize[50]]" />
					</div>
				</div> -->
				
				<div class="form-group ">
			   	    <label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>创建时间： </label>
		         	<div class="col-sm-9">
						<div class="row">
							<div class="col-sm-9">
								<div class="input-group">
									<input  type="text" class="form-control date-picker  ztb_edit_createDateTime validate[required,custom[date]]" style="line-height:28px;width:275px;"  name="createDateTime"	id="id-date-picker-1" data-date-format="yyyy-mm-dd" />								
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
					</div>
	            </div>
				
				
				
				
				
				
				
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit"><i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
				