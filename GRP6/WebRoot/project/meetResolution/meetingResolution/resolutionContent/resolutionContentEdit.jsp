<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <script type="text/javascript">
/**
 *获取下拉框值;
 */
<%--function getSelectText2 (v){
    var  selectID = v.id;
    var selectName = selectID.replace(/List/, "Name");
　    document.getElementById(selectName).value=v.options[v.options.selectedIndex].text;
};--%>

function setControlTypeName(){
	var type = document.getElementById('controlTypeList');     	
	 var pindex  = type.selectedIndex;
	 // 获取选中的下拉框的值(value)
　	 var pValue  =  type.options[pindex].value;　
　	 // 获取选中的下拉框的值(key)
　	 var pText = type.options[pindex].text;
　    document.getElementById('controlTypeName').value=pText;
}
function setResolutionResultName(){
	var type = document.getElementById('resolutionResultList');     	
	 var pindex  = type.selectedIndex;
	 // 获取选中的下拉框的值(value)
　	 var pValue  =  type.options[pindex].value;　
　	 // 获取选中的下拉框的值(key)
　	 var pText = type.options[pindex].text;
　    document.getElementById('resolutionResultName').value=pText;
}
</script>
<div class="modal modal_wapper fade bs-example-modal-lg" id="meetingResolutionEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg " role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改决议内容</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="updateMeetingResolution_form">
			 <input type="hidden" name="meetingResolution_ID" value="${meetingResolution.meetingResolution_ID}">
			<div class="form-group ">
			      <label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>评审决议： </label>
		           <div class="col-sm-9">
		               <textarea class="col-sm-10 limited validate[required,maxSize[2000]]" rows="5" id="signed"  name="signed" >${meetingResolution.signed}</textarea>
		           	<div class="col-sm-10 no-padding-right">
		                 <span class="light-grey" style="float:right;">最多允许输入字符2000个</span>
		            </div>
		           </div>
			</div>
			  <div class="form-group ">
			      <label class="col-sm-3 control-label no-padding-right" for="form-field-1">保证措施： </label>
		           <div class="col-sm-9">
		               <textarea class="col-sm-10 limited validate[maxSize[2000]]" rows="5" id="optDesc"  name="optDesc" >${meetingResolution.optDesc}</textarea>
		           	<div class="col-sm-10 no-padding-right">
		                 <span class="light-grey" style="float:right;">最多允许输入字符2000个</span>
		            </div>
		           </div>
			</div>
		
			
			<div class="form-group ">
          
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1">过程控制： </label>
		           <div class="col-sm-9">
		               <textarea class="col-sm-10 limited validate[maxSize[2000]]" rows="5" id="processControl"  name="processControl" >${meetingResolution.processControl}</textarea>
		           	<div class="col-sm-10 no-padding-right">
		                 <span class="light-grey" style="float:right;">最多允许输入字符2000个</span>
		            </div>
		           </div>
			</div>
			
	        <div class="form-group ">
				   <label class="col-sm-3 control-label no-padding-right" for="form-field-1">放款条件： </label>
		           <div class="col-sm-9">
		               <textarea class="col-sm-10 limited validate[maxSize[2000]]" rows="5" id="loanConditions"  name="loanConditions" >${meetingResolution.loanConditions}</textarea>
		           	<div class="col-sm-10 no-padding-right">
		                 <span class="light-grey" style="float:right;">最多允许输入字符2000个</span>
		            </div>
		           </div>
			</div>
			<div class="form-group ">
				   <label class="col-sm-3 control-label no-padding-right" for="form-field-1">其他事项： </label>
		           <div class="col-sm-9">
		               <textarea class="col-sm-10 limited validate[maxSize[2000]]" rows="5" id="otherMatters"  name="otherMatters" >${meetingResolution.otherMatters}</textarea>
		           	<div class="col-sm-10 no-padding-right">
		                 <span class="light-grey" style="float:right;">最多允许输入字符2000个</span>
		            </div>
		           </div>
			</div>
			<div class="form-group ">
				<label class="col-md-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>保后监管周期： </label>
		        <div class="col-md-9">
		        <input type="hidden" id="controlTypeName" class="controlTypeName" name="controlTypeName" value="${meetingResolution.controlTypeName}">
					  <select id="controlTypeList" class="col-sm-6 col-md-6 validate[required]" onchange='setControlTypeName()' name="controlTypeID"  >		
								<option value="">&nbsp;请选择</option>
								<c:forEach items="${controlTypeList}" var="controlType">
									<option value="${controlType.dicTypeID}" <c:if test="${controlType.dicTypeID eq meetingResolution.controlTypeID}">selected="selected"</c:if>>${controlType.dicTypeName}</option>
								</c:forEach>
					  </select>
				</div>
			</div>
			<div class="form-group ">
				   <label class="col-sm-3 control-label no-padding-right" for="form-field-1"></i>在保监管要求： </label>
		           <div class="col-sm-9">
		               <textarea class="col-sm-10 limited validate[maxSize[2000]]" rows="5" id="monitoredAsking"  name="monitoredAsking" >${meetingResolution.monitoredAsking}</textarea>
		           	<div class="col-sm-10 no-padding-right">
		                 <span class="light-grey" style="float:right;">最多允许输入字符2000个</span>
		            </div>
		           </div>
			</div>
			 <div class="form-group ">
				<label class="col-md-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>决议结果： </label>
		        <div class="col-md-9">
		        <input type="hidden" id="resolutionResultName" class="resolutionResultName" name="resolutionResultName" value="${meetingResolution.resolutionResultName}">
					  <select id="resolutionResultList" class="col-sm-6 col-md-6 validate[required]" onchange='setResolutionResultName()' name="resolutionResultID"  >		
								<option value="">&nbsp;请选择</option>
								<c:forEach items="${resolutionResultList}" var="resolutionResult">
									<option value="${resolutionResult.dicTypeID}" <c:if test="${resolutionResult.dicTypeID eq meetingResolution.resolutionResultID}">selected="selected"</c:if>>${resolutionResult.dicTypeName}</option>
								</c:forEach>
					  </select>
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
