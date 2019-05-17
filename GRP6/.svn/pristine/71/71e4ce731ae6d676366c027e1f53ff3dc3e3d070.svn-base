<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
	<div class="col-xs-12">
		<div class="page-header">
			<h5 style="display: inline;">项目编号：<span class="grey">${apply.busiCode }</span></h5>
			<h5 style="display: inline;margin-left:2em;">项目名称：<span class="grey">${apply.projectName }</span></h5>
		</div>
	</div>
	<form class="form-horizontal row" role="form" id="projectAfter_form" >
		<input type="hidden" id="apply_ID" name="apply_ID" value="${apply.apply_ID }">
		<input type="hidden" id="project_ID" name="project_ID" value="${project.project_ID }">
		 <div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>项目金额： </label>
				<div class="col-sm-8">
					<input  type="text" class="col-sm-8  validate[required,maxSize[18]]"  name="loadSum" id="loadSum"  value="<fmt:formatNumber value="${project.loadSum}" pattern="###.######"/>"/>
				   <span class="midden col-sm-4 " style="line-height:28px;">万元</span>
				</div>
			</div>
             <div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>期限： </label>
				<div class="col-md-8 ">
	                  <input type="text" id="periodMonth" class="validate[required,maxSize[6],custom[integer]]" name="periodMonth" value="${project.periodMonth}" style="width:4em;" />
	                   &nbsp;个月&nbsp;
	                  <input type="text" id="periodDay" class="validate[required,maxSize[6],custom[integer]]" name="periodDay" value="${project.periodDay}" style="width:4em;" />
	                   &nbsp;天&nbsp;
	            </div>
			</div>
			 <div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>担保费率： </label>
				<div class="col-sm-8">
					<input  type="text" class="col-sm-8  validate[required,maxSize[6]]"  name="guarantyRate" id="guarantyRate"  value="<fmt:formatNumber value="${project.guarantyRate}" pattern="###.######"/>"/>
				   <span class="midden col-sm-4 " style="line-height:28px;">%</span>
				</div>
			</div>
			 <div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>贷款(委贷)利率： </label>
				<div class="col-sm-8">
					<input  type="text" class="col-sm-8  validate[required,maxSize[8]]"  name="bankRate" id="bankRate"  value="<fmt:formatNumber value="${project.bankRate}" pattern="###.######"/>"/>
				   <span class="midden col-sm-4 " style="line-height:28px;">%</span>
				</div>
			</div>
			
			 <div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>罚息利率： </label>
				<div class="col-sm-8">
					<input  type="text" class="col-sm-8  validate[required,maxSize[6]]"  name="punishRate" id="punishRate"  value="<fmt:formatNumber value="${project.punishRate}" pattern="###.######"/>"/>
				   <span class="midden col-sm-4 " style="line-height:28px;">%</span>
				</div>
			</div>
			
          
          <div class="form-group col-sm-6">
			   			<label class="col-sm-4 control-label no-padding-right" for="form-input" style="line-height:28px;">&nbsp;</label>
          </div>
          
          <div class="form-group ">
                 <label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>委托担保（委贷）合同号： </label>
                 <div class="col-sm-10">
						<textarea class="col-sm-10 limited   validate[required,maxSize[2000]]" rows="5"  name="dcontractCode" id="dcontractCode" >${apply.dContractCode}</textarea>							
					    <span class="col-sm-4 light-grey col-sm-push-8">限制输入字数2000个</span>
					</div>
			</div>
          <div class="form-group ">
                 <label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>借款合同号： </label>
                 <div class="col-sm-10">
						<textarea class="col-sm-10 limited   validate[maxSize[required,2000]]" rows="5"  name="jcontractCode" id="jcontractCode" >${apply.jContractCode}</textarea>							
					    <span class="col-sm-4 light-grey col-sm-push-8">限制输入字数2000个</span>
					</div>
			</div>
             
          <div class="form-group ">
                 <label class="col-md-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>保证合同号： </label>
                 <div class="col-sm-10">
						<textarea class="col-sm-10 limited   validate[maxSize[required,2000]]" rows="5"  name="bcontractCode" id="bcontractCode" >${apply.bContractCode}</textarea>							
					    <span class="col-sm-4 light-grey col-sm-push-8">限制输入字数2000个</span>
					</div>
			</div>
	</form>
	 <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
<%@ include file="/common_message.jsp" %>
<script src="<%=path %>/project/apply/projectInfToCheckAdd.js?v=<%=vardate%>"></script> 