<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="hightSelectXPersonClient" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">高级查询</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal row" role="form" id="hightSelect_xPersonClientForm">
			<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">申请人姓名： </label>
				<div class="col-sm-8">
					<input type="text" name="personName" class="col-xs-10 col-sm-9  ztb_hightSelect validate[maxSize[50]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">身份证号码： </label>
				<div class="col-sm-8">
					<input type="text" name="personNum" class="col-xs-10 col-sm-9 ztb_hightSelect validate[maxSize[18]]"/>
				</div>
			</div>		
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">手机号： </label>
				<div class="col-sm-8">
					<input type="text" name="phone" class="col-xs-10 col-sm-9 ztb_hightSelect validate[custom[number],maxSize[20]]" />
				</div>
			</div>		
			<div class="space-4"></div>          
             <div class="form-group">
				   	<label class="col-sm-4 control-label no-padding-right" for="form-input">创建日期： </label>
			        <div class="col-sm-8">
					  <div class="input-group col-sm-4" style="float:left;">
						<input  type="text" class="form-control date-picker ztb_hightSelect  validate[custom[date]]" name="createDateTimeStart"  id="id-date-picker-1" data-date-format="yyyy-mm-dd" />
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					   </div>
						
					   <p class="col-sm-1">-</p>
					   <div class="input-group col-sm-4">
						<input  type="text" class="form-control date-picker ztb_hightSelect  validate[custom[date]]" name="createDateTimeEnd"  id="id-date-picker-2" data-date-format="yyyy-mm-dd" />
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
						</div>
					</div>
             </div>
			<div class="space-4"></div>	
           <div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">机构名称： </label>
				<div class="col-sm-8">
					<input type="text" class=" col-xs-10 col-sm-9 ztb_hightSelect" name="unit_uidName" id="unit_uidName"   />					
				</div>
			</div>
			<div class="space-4"></div>
             <div class="form-group">
				   	<label class="col-sm-4 control-label no-padding-right" for="form-input">创建部门： </label>
			        <div class="col-sm-8">
						<div class="input-group fullDepartCode col-xs-10 col-sm-9">
						         <!-- <input type="hidden"  class="ztb_edit_fullDepartName">
						         <input type="hidden" class="ztb_edit_fullDepartCode"> -->
								 <input type="text"  class="form-control ztb_hightSelect" autoField="fullDepartCode" style="line-height:28px;" id="fullDepartCode"  value="" dataValue="" name="fullDepartName" 
								 style="width:315px;"
								 />	
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
						</div>
					</div>
             </div>
             <div class="space-4"></div>
             <div class="form-group">
				   	<label class="col-sm-4 control-label no-padding-right" for="form-input">创建人： </label>
			        <div class="col-sm-8">
						<input type="text"  class="col-xs-10 col-sm-9 ztb_hightSelect"  name="createUserName" id="createUserName" />
					</div>
             </div>  
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-search bigger-110'></i>查询</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					