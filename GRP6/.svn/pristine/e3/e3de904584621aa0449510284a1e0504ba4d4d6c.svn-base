<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="fundsApplyAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">用款申请</h4>
      </div>
      <div class="modal-body">
      	<input type="hidden" value='${strDetailList }' id="hidden_detailList">
      	<input type="hidden" id="hidden_isBusiLimit" value="${creditApply.isBusiLimit }">	<!-- 是否有业务品种限制 -->
		<input type="hidden" id="hidden_isBlend" value="${creditApply.isBlend }">			<!-- 是否额度混用 -->
		<input type="hidden" id="hidden_usableSum" value="${creditApply.agreeSum-creditApply.usedSum }">	<!-- 授信项总可用额度 -->
      	<form class="form-horizontal row" role="form" id="form_fundsApply">
      		<input type="hidden" id="hidden_applyID" value="${creditApply.apply_ID }" name="parentApply_ID">
      		<div class="space-4"></div>
			<div class="form-group">
			   	<label class="col-sm-3 control-label no-padding-right" for="form-field-1">授信项目名称： </label>
				<label class="col-sm-9">${creditApply.projectName }</label>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
			   	<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>业务性质： </label>
		        <div class="col-sm-9">
					<select class="col-sm-5  validate[required]" name="busiNatureID">
						<option value="">请选择</option>
						<c:forEach items="${busiNatureList }" var="busiNature">
							<option value="${busiNature.dicTypeID }">${busiNature.dicTypeName }</option>
						</c:forEach>
					</select>
					<input type="hidden" name="busiNatureName">
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
		   		<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>项目类型： </label>
				<div class="col-sm-9">
					<select class="col-sm-5 validate[required]" name="projectTypeID">
						<option value="">请选择</option>
						<c:forEach items="${projectTypeList }" var="projectType">
							<option value="${projectType.dicTypeID }">${projectType.dicTypeName }</option>
						</c:forEach>
					</select>
					<input type="hidden" name="projectTypeName">
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>客户名称： </label>
				<div class="col-sm-9">
					<select class="col-sm-5 validate[required]" name="client_ID">
						<option value="${creditApply.client_ID }">${creditApply.clientName }</option>
						<c:if test="${relationMain.cmlist != null }">
							<c:forEach items="${relationMain.cmlist }" var="relationCompany">
								<option value="${relationCompany.client_ID }">${relationCompany.clientName }</option>
							</c:forEach>
						</c:if>
					</select>
					<input type="hidden" name="clientName">
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>项目名称： </label>
				<div class="col-sm-9">
					<input type="text" id="input_projectName" class="col-sm-10 col-lg-6 validate[required,maxSize[100]]" name="projectName" value="${creditApply.clientName }"/>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
			   	<label class="col-sm-3 control-label no-padding-right" for="form-input">项目来源： </label>
		        <div class="col-sm-9">
					<select class="col-sm-5" name="projectSourceID">
						<option value="">请选择</option>
						<c:forEach items="${projectSourceList }" var="projectSource">
							<option value="${projectSource.dicTypeID }">${projectSource.dicTypeName }</option>
						</c:forEach>
					</select>
					<input type="hidden" name="projectSourceName">
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
	   	    	<label class="col-sm-3 control-label no-padding-right" for="form-input">来源说明： </label>
				<div class="col-sm-9">
				    <textarea class="col-sm-10 col-lg-10 limited validate[maxSize[250]]"  rows="5" name="sourceDesc"></textarea>
					<div class="col-sm-10 col-lg-10 no-padding-right">
					    <span class="light-grey" style="float:right;">限制250个字符</span>
					</div>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
			   	<label class="col-sm-3 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>业务品种： </label>
		        <div class="col-sm-9">
		        	<c:choose>  
						<c:when test="${empty creditApply.detailList }">  <!-- detailList为空，业务品种显示树 -->
							<div class="col-sm-5 input-group tree_busiType">
								<input  type="text"  class="form-control validate[required] " autoField="busiTypeID"  id="tree_busiType"  name="busiTypeName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</c:when>  
						<c:otherwise>	<!-- detailList不为空，业务品种要显示下拉框 -->
							<select class="col-sm-5 validate[required]" name="busiTypeID" id="select_busiType"></select>
							<input type="hidden" name="busiTypeName">
						</c:otherwise>  
					</c:choose>  
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
			   	<label class="col-sm-3 control-label no-padding-right" for="form-input">绿色通道： </label>
		        <div class="col-sm-9">
					<select class="col-sm-5" name="greenChannelID">
						<option value="">请选择</option>
						<c:forEach items="${greenChannelList }" var="greenChannel">
							<option value="${greenChannel.dicTypeID }">${greenChannel.dicTypeName }</option>
						</c:forEach>
					</select>
					<input type="hidden" name="greenChannelName">
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
			    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>申请金额： </label>
			    <div class="col-sm-9">
			        <input type="text" name="applySum" class="col-sm-3 validate[required,custom[number],maxSize[18],custom[lessThanUsableSum]]" name="applySum" id="input_applySum"/>
					<span class="midden col-sm-4 " style="line-height:28px;">万元	</span>
			    </div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
			    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>申请期限： </label>
			    <div class="col-sm-9">
			        <span class="col-sm-5 no-padding-left">
						<input type="text" class="validate[required,maxSize[5],custom[integer]]" name="periodMonth" style="width: 70px;"/>&nbsp;个月&nbsp;
						<input type="text" class="validate[required,maxSize[5],custom[integer]]" name="periodDay" value="0" style="width: 70px;"/>&nbsp;天
					</span>
			    </div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
		   		<label class="col-sm-3 control-label no-padding-right" for="form-input">合作机构： </label>
	        	<!-- 授信项没有业务品种限制，或有业务品种限制但该业务下没有合作机构限制时，此处是树 -->
	        	<div class="col-sm-9" id="div_bank_tree">
					<div class="col-sm-5 input-group tree_bank">
						<input  type="text"  class="form-control" autoField="bankID"   id="tree_bank"  name="bankName" readonly="readonly"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span>
					</div>
				</div>
				<!-- 授信项有业务品种限制，根据业务品种与合作机构的对应关系，生成此处下拉选择框 -->
				<div class="col-sm-9" id="div_bank_select" style="display:none">
					<select class="col-sm-5" name="select_bankID">
						<option value="">请选择</option>
					</select>
					<input type="hidden" name="select_bankName">
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
   	 		    <label class="col-sm-3 control-label no-padding-right" for="form-input">贷款(担保)用途： </label>
				<div class="col-sm-9">
				    <textarea class="col-sm-10 col-lg-10 limited" name="loadUsed" rows="5"></textarea>
				    <div class="col-sm-10 col-lg-10 no-padding-right">
					    <span class="light-grey" style="float:right;">限制2000个字符</span>
					</div>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-input">还款计划和来源： </label>
				<div class="col-sm-9">
				    <textarea class="col-sm-10 col-lg-10 limited" name="repaymentPlan" rows="5"></textarea>
				    <div class="col-sm-10 col-lg-10 no-padding-right">
					    <span class="light-grey" style="float:right;">限制2000个字符</span>
					</div>
				</div>
			</div>

			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-input">拟提供的保证措施： </label>
				<div class="col-sm-9">
				    <textarea class="col-sm-10 col-lg-10 limited" name="provideGuaranty" rows="5"></textarea>
				    <div class="col-sm-10 col-lg-10 no-padding-right">
					    <span class="light-grey" style="float:right;">限制2000个字符</span>
					</div>
				</div>
			</div>

			<div class="space-4"></div>
			<div class="form-group">
	   	    	<label class="col-sm-3 control-label no-padding-right" for="form-input">备注： </label>
				<div class="col-sm-9">
				    <textarea class="col-sm-10 col-lg-10 limited" name="otherDesc" rows="5"></textarea>
				    <div class="col-sm-10 col-lg-10 no-padding-right">
					    <span class="light-grey" style="float:right;">限制2000个字符</span>
					</div>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
		   		<label class="col-sm-3 control-label no-padding-right" for="form-input">经办部门： </label>
	      		<div class="col-sm-9 ">
					<div class="col-sm-5 input-group selectCreateDepart">
						<input  type="text"  class="form-control" autoField="departID"   id="selectCreateDepart"  
							value="${sessionUser.depart_name}" dataValue="${sessionUser.depart_uid}" name="departName" readonly="readonly"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span>
					</div>
				</div>
			</div>
	
			<div class="space-4"></div>
			<div class="form-group">
			   	<label class="col-sm-3 control-label no-padding-right" for="form-input">经办人： </label>
			   	<div class="col-sm-9 ">
			        <div class="col-sm-5 input-group selectCreateUser">
						<input  type="text"  class="form-control" autoField="createManID"   id="selectCreateUser"  
							value="${sessionUser.user_name}" dataValue="${sessionUser.user_uid}" name="createManName" readonly="readonly"/>
						<span class="input-group-addon ">
							<i class="icon-caret-down bigger-110"></i>
						</span>
					</div>
				</div>
	     				</div>
	
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-input">受理日期： </label>
	        	<div class="col-sm-9">
					<div class="input-group col-sm-5 ">
						<input class="form-control date-picker validate[custom[date]]" id="date-picker-1" type="text" data-date-format="yyyy-mm-dd" name="createDate"/>
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
			</div>
			
			<div class="form-group col-sm-12 col-xs-12" style="height:80px"></div>
     	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn-submit"> <i class='icon-ok bigger-110'></i>确定</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
