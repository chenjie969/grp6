<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/common_timestamp.jsp" %>
<script type="text/javascript">
/*注册日期控件点击事件*/
$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
	$(this).prev().focus();
}); 
/*设置日期初始值，默认为当天*/
$("#date-picker-1").attr("value",tool.parseDate(new Date().getTime()));
</script>
<div class="modal modal_wapper fade bs-example-modal-lg" id="addNewApproval" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h3 class="modal-title">新增审批</h3>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" id="addNewApproval_form">
				<input type="hidden" name="riskScheme_ID" id="riskScheme_ID" value="${riskScheme_ID}"/>
				<input type="hidden" name="relationMain_ID" id="relationMain_ID"/>
				<input type="hidden" name="relationMainName" id="relationMainName"/>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"
						for="form-input"><i class="icon-asterisk orange"></i>标题：</label>
					<div class="col-sm-6">
						<input type="text" name="title" class="col-sm-8 validate[required,maxSize[100]]" />
						<span class="midden col-sm-4 " style="line-height:28px;"></span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>审批类型： </label>
					<div class="col-sm-6">
						<select name="reviewType" class="col-xs-8 validate[required]" id="reviewType">
							<option value="方案">方案</option>
							<option value="工作进度">工作进度</option>
							<option value="打击逃废债工作进度">打击逃废债工作进度</option>
						</select>
					</div>
				</div>
				<div class="form-group" >
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1">方案：</label>
					<div class="col-sm-6"  >
		                <button class="btn btn-sm btn-info"  type="button" name="button" id="${riskScheme_ID.concat('_09')}" onclick="$.zjm_loanAttachment.filesUpdate(this.id)">
		                    	请选择</button>
		                 <div id="attachmentsDIV_09" class=""  style=" overflow-y:auto; overflow-x:auto; width:500px; height:90px;" ></div>
					</div>
				</div>
				<div class="form-group" >
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1">附件：</label>
					<div class="col-sm-6"  >
		                <button class="btn btn-sm btn-info"  type="button" name="button" id="${riskScheme_ID.concat('_08')}" onclick="$.zjm_loanAttachment.filesUpdate(this.id)">
		                    	请选择</button>
		                <div id="attachmentsDIV_08" class="" style=" overflow-y:auto; overflow-x:auto; width:500px; height:120px;" ></div>
					</div>
				</div>
				<div class="form-group" id="workProgress" style="display:none">                                                   
				   <label class="col-sm-3 control-label no-padding-right" for="form-field-1">工作进展： </label>
		           <div class="col-sm-8">
	               		<textarea class="col-sm-10 limited validate[maxSize[2000]]" rows="5"  name="workProgress" ></textarea>
		           		<div class="col-sm-10 no-padding-right">
		                 	<span class="light-grey" style="float:right;">最多允许输入字符2000个</span>
		           	 	</div>
		           	</div>
				</div> 
				<div class="form-group" id="needCoordination" style="display:none">
				   <label class="col-sm-3 control-label no-padding-right" for="form-field-1">需协调事项： </label>
		           <div class="col-sm-8">
	               		<textarea class="col-sm-10 limited validate[maxSize[2000]]" rows="5"  name="needCoordination" ></textarea>
		           		<div class="col-sm-10 no-padding-right">
		                 	<span class="light-grey" style="float:right;">最多允许输入字符2000个</span>
		           	 	</div>
		           	</div>
				</div> 
				<div class="form-group" id="nextPlan" style="display:none">
				   <label class="col-sm-3 control-label no-padding-right" for="form-field-1">下一步计划： </label>
		           <div class="col-sm-8">
	               		<textarea class="col-sm-10 limited validate[maxSize[2000]]" rows="5"  name="nextPlan" ></textarea>
		           		<div class="col-sm-10 no-padding-right">
		                 	<span class="light-grey" style="float:right;">最多允许输入字符2000个</span>
		           	 	</div>
		           	</div>
				</div> 
				<div class="form-group" id="lawsuitInfo" style="display:none">
				   <label class="col-sm-3 control-label no-padding-right" for="form-field-1">涉诉情况： </label>
		           <div class="col-sm-8">
	               		<textarea class="col-sm-10 limited validate[maxSize[2000]]" rows="5"  name="lawsuitInfo" ></textarea>
		           		<div class="col-sm-10 no-padding-right">
		                 	<span class="light-grey" style="float:right;">最多允许输入字符2000个</span>
		           	 	</div>
		           	</div>
				</div> 
				<div class="form-group" id="lawsuitProgress" style="display:none">
				   <label class="col-sm-3 control-label no-padding-right" for="form-field-1">涉案进展： </label>
		           <div class="col-sm-8">
	               		<textarea class="col-sm-10 limited validate[maxSize[2000]]" rows="5"  name="lawsuitProgress" ></textarea>
		           		<div class="col-sm-10 no-padding-right">
		                 	<span class="light-grey" style="float:right;">最多允许输入字符2000个</span>
		           	 	</div>
		           	</div>
				</div> 
				<div class="form-group ">
				   <label class="col-sm-3 control-label no-padding-right" for="form-field-1">备注： </label>
		           <div class="col-sm-8">
	               		<textarea class="col-sm-10 limited validate[maxSize[2000]]" rows="5"  name="remark" ></textarea>
		           		<div class="col-sm-10 no-padding-right">
		                 	<span class="light-grey" style="float:right;">最多允许输入字符2000个</span>
		           	 	</div>
		           	</div>
				</div> 
				
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>创建人： </label>
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
					
		        <div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>创建日期：
					</label>
					<div class="col-sm-6">
						<div class="input-group col-sm-6">
							<input class="form-control date-picker validate[required,custom[date]]"
								type="text" id="date-picker-1" data-date-format="yyyy-mm-dd" name="createDate" /> 
							<span class="input-group-addon input-group-addon1"> 
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
				</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary btn_submit">
					<i class='icon-ok bigger-110'></i>保存
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<i class='icon-remove bigger-110'></i>关闭
				</button>
			</div>
		</div>
	</div>
</div>
<script src="/plugins/plupload/plupload.full.min.js"></script>
<script src="/plugins/plupload/i18n/zh_CN.js"></script>
<script src="/project/riskResponse/keyProject/fileUp.js"></script>
<%@ include file="/project/riskResponse/keyProject/fileUp.jsp" %>