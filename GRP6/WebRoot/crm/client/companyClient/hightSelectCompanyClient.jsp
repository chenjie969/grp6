<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="modal fade bs-example-modal-sm" id="hightSelectCompanyClient" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">高级查询</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="hightSelectCompanyClient_Form"> 	
           	<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">企业名称： </label>
				<div class="col-sm-8">
					<input type="text" name="clientName" id=""  class="col-xs-10 col-sm-9 ztb_add" />
					
				</div>
			</div>			
           	<div class="form-group" >
			   	<label class="col-sm-4 control-label no-padding-right" for="form-input">所属区域： </label>
				 <div class="col-sm-8">
						<div class="input-group  col-xs-10 col-sm-9 fullAreaCode">
						        <!-- <input type="hidden" class="ztb_edit_fullAreaName ">
						         <input type="hidden" class="ztb_edit_fullAreaCode "> -->
								 <input type="text"  class="form-control ztb_add" autoField="fullAreaCode" style="line-height:28px;" id="fullAreaCode"  value="" dataValue="" name="fullAreaName" />							
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
						</div>				
				</div>
            </div>           
           	<div class="form-group" >
			   	<label class="col-sm-4 control-label no-padding-right" for="form-input">所属行业： </label>		
				 <div class="col-sm-8">
						<div class="input-group fullTradeCode col-xs-10 col-sm-9">
						        <!--  <input type="hidden" class="ztb_edit_fullTradeName ">
						         <input type="hidden" class="ztb_edit_fullTradeCode "> -->
								 <input type="text"  class="form-control ztb_add" autoField="fullTradeCode" style="line-height:28px;" id="fullTradeCode"  value="" dataValue="" name="fullTradeName" />							
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
						</div>
					</div>				
            </div>           
			<div class="form-group">
				   	<label class="col-sm-4 control-label no-padding-right" for="form-input">企业性质： </label>
			        <div class="col-sm-8">
						<!-- <input type="hidden" id="natureName" name="natureName" class="ztb_edit_natureName"> -->
						<select class="col-xs-10 col-sm-9 ztb_add select_natureID btn_ztb_select"   name="natureID" class_name="ztb_edit_natureName" id="select_natureID">
						</select>
					</div>
             </div>
             
			<div class="form-group ">
				   	<label class="col-sm-4 control-label no-padding-right" for="form-input">币别： </label>
			        <div class="col-sm-8">
						<!-- <input type="hidden" id="currencyName" name="currencyName" class="ztb_edit_currencyName"> -->
						<select class="col-xs-10 col-sm-9  ztb_add select_currencyID btn_ztb_select"   name="currencyID" class_name="ztb_edit_currencyName" id="select_currencyID">
						</select>
					</div>
	         </div>
             <div class="form-group">
				   	<label class="col-sm-4 control-label no-padding-right" for="form-input">注册资金大小： </label>
			        <div class="col-sm-8">
						<input  type="text" class="col-sm-3 ztb_add" name="registerSumStart"  id="form-input-readonly"/>					
						<p class="col-sm-1">-</p> 
						<input  type="text" class="col-sm-3 ztb_add" name="registerSumEnd"  id="form-input-readonly"/>							
						<span style="line-height:28px;margin-left:1em;">
								万元
						</span>
					</div>
             </div>             
             <div class="form-group">
				   	<label class="col-sm-4 control-label no-padding-right" for="form-input">成立日期： </label>
			        <div class="col-sm-8">
					  <div class="input-group col-sm-4" style="float:left;">
						<input  type="text" class="form-control date-picker  ztb_add validate[custom[date]]" name="createDateStart"  id="id-date-picker-1" data-date-format="yyyy-mm-dd" />
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					   </div>
						
					   <p class="col-sm-1">-</p>
					   <div class="input-group col-sm-4">
						<input  type="text" class="form-control date-picker  ztb_add validate[custom[date]]" name="createDateEnd"  id="id-date-picker-2" data-date-format="yyyy-mm-dd" />
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
						</div>
					</div>
             </div>
             <div class="form-group">
				   	<label class="col-sm-4 control-label no-padding-right" for="form-input">客户来源： </label>
			        <div class="col-sm-8">
						<!-- <input type="hidden" id="clientSourceName" name="clientSourceName" class="ztb_add_clientSourceName"> -->
						<select class="col-xs-10 col-sm-9  ztb_add select_clientSource btn_ztb_select "  name="clientSourceID" class_name="ztb_add_clientSourceName" id="select_clientSource">					
						</select>
					</div>
             </div>            
            <div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">法定代表人： </label>
				<div class="col-sm-8">
					<input type="text" class=" col-xs-10 col-sm-9 ztb_add"  name="legalPerson" id="legalPerson"  />					
				</div>
			</div>
            <div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">实际控制人： </label>
				<div class="col-sm-8">
					<input type="text" class=" col-xs-10 col-sm-9 ztb_add" name="controlPerson" id="controlPerson"   />					
				</div>
			</div>
			 <div class="form-group">
				   	<label class="col-sm-4 control-label no-padding-right" for="form-input">创建日期： </label>
			        <div class="col-sm-8">
					  <div class="input-group col-sm-4" style="float:left;">
						<input  type="text" class="form-control date-picker ztb_add  validate[custom[date]]" name="createDateTimeStart"  id="id-date-picker-1" data-date-format="yyyy-mm-dd" />
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					   </div>
						
					   <p class="col-sm-1">-</p>
					   <div class="input-group col-sm-4">
						<input  type="text" class="form-control date-picker ztb_add  validate[custom[date]]" name="createDateTimeEnd"  id="id-date-picker-2" data-date-format="yyyy-mm-dd" />
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
						</div>
					</div>
             </div>
           <div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">机构名称： </label>
				<div class="col-sm-8">
					<input type="text" class=" col-xs-10 col-sm-9 ztb_add" name="unit_uidName" id="unit_uidName"   />					
				</div>
			</div>
             <div class="form-group">
				   	<label class="col-sm-4 control-label no-padding-right" for="form-input">创建部门： </label>
			        <div class="col-sm-8">
						<div class="input-group fullDepartCode col-xs-10 col-sm-9">
						         <!-- <input type="hidden"  class="ztb_edit_fullDepartName">
						         <input type="hidden" class="ztb_edit_fullDepartCode"> -->
								 <input type="text"  class="form-control ztb_add" autoField="fullDepartCode" style="line-height:28px;" id="fullDepartCode"  value="" dataValue="" name="fullDepartName" 
								 style="width:315px;"
								 />	
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
						</div>
					</div>
             </div>
             <div class="form-group">
				   	<label class="col-sm-4 control-label no-padding-right" for="form-input">创建人： </label>
			        <div class="col-sm-8">
						<input type="text"  class="col-xs-10 col-sm-9 ztb_add"  name="createUserName" id="createUserName" />
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
