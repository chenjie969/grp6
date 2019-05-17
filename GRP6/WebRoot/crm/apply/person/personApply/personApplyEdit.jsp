<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" id="editPersonApply" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改个人咨询情况</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="edit_personApply_form">
      	 	<input type="hidden" name="apply_ID" value="${apply.apply_ID }">
      	 	<input type="hidden" name="clientType" value="${apply.clientType }">
      	 	<input type="hidden" name="approvalStatu" value="${apply.approvalStatu }">
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>申请人姓名： </label>
				<div class="col-sm-8">
					<div class="row">
					    <div class="col-sm-10">
							<input type="text" name="clientName" class="col-sm-12 validate[required,maxSize[50]]" value="${apply.clientName }" id="edit_clientName"/>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>身份证号码： </label>
				<div class="col-sm-8">
					<div class="row">
					    <div class="col-sm-10">
							<input type="text" name="certificateCode" class="col-sm-12 validate[required,maxSize[18],minSize[18]]" value="${apply.certificateCode }"/>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>手机： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<div class="input-group">
								<input class="form-control validate[required,maxSize[11],minSize[11]]" type="text" name="phone" value="${apply.phone }"/>
								<span class="input-group-addon">
									<i class="icon-phone bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-input">固定电话： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<div class="input-group">
								<input class="form-control validate[maxSize[50]]" type="text" name="telephone" value="${apply.telephone }"/>
								<span class="input-group-addon">
									<i class="icon-phone bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>业务品种：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class=" col-sm-10 ">
							<div class="input-group selectBusSort">
								<input  type="text"  class="form-control validate[required] " autoField="busiTypeID"  id="selectBusSort" 
									 name="busiTypeName" value="${apply.busiTypeName }" datavalue="${apply.busiTypeID }" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group  col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1">合作机构：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class=" col-sm-10 ">
							<div class="input-group selectBank">
								<input  type="text"  class="form-control" autoField="cooperationID"   id="selectBank"  
									name="cooperationName" value="${apply.cooperationName }" datavalue="${apply.cooperationID }" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group  col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>申请金额： </label>
				<div class="col-sm-8">
					<input type="text" name="applySum" class="col-xs-10 col-sm-6 validate[required,custom[number],maxSize[18]]" 
						value="<fmt:formatNumber value="${apply.applySum }" pattern="###.######"/>"/>
					<span class="midden col-sm-4 " style="line-height:28px;">万元	</span>
				</div>
			</div>
			<div class="form-group  col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>申请期限：</label>
				<div class="col-sm-8">
					<span class="col-sm-10 no-padding-left">
						<input type="text" name="periodMonth" class="validate[required,maxSize[5],custom[integer]]" style="width: 70px;" value="${apply.periodMonth }"/>&nbsp;个月&nbsp;
						<input type="text" name="periodDay"  class="validate[maxSize[5],custom[integer]]" style="width: 70px;" value="${apply.periodDay }"/>&nbsp;天
					</span>
				</div>
			</div>
			<div class="form-group  col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>客户来源：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
			        		<input type="hidden" id="clientSourceName" name="clientSourceName" class="ztb_add_clientSourceName" value="${apply.clientSourceName}">
							<select class="col-sm-12 select_clientSource  btn_ztb_select validate[required]"  name="clientSourceID" class_name="ztb_add_clientSourceName" id="select_clientSource">
								<option value="">&nbsp;请选择</option>
								<c:forEach items="${clientSourceList }" var="clientSource">
									<option value="${clientSource.dicTypeID }" <c:if test="${clientSource.dicTypeID == apply.clientSourceID}">selected</c:if>>${clientSource.dicTypeName }</option>
								</c:forEach>
							</select>
						</div>	
					</div>
				</div>
			</div>
			<!-- <div class="form-group  col-sm-6  hidden-xs" style="height:29px"></div> -->
			<div class="form-group  col-sm-6">
				<label class="col-sm-offset-2 col-sm-10 grey">（注：申请期限为整月时，天可以不填写）</label>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1">来源说明： </label>
				<div class="col-sm-10">
					<textarea rows="3" name="clientSourceDesc" class="col-sm-10 validate[maxSize[50]]">${apply.clientSourceDesc }</textarea>
					<div class="col-sm-10 no-padding-right">
						<span class="light-grey" style="float:right">限制50个字符</span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1">贷款用途： </label>
				<div class="col-sm-10">
					<textarea rows="5" name="loadUsed" class="col-sm-10 validate[maxSize[2000]]">${apply.loadUsed }</textarea>
					<div class="col-sm-10 no-padding-right">
						<span class="light-grey" style="float:right">限制2000个字符</span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1">还款计划与来源： </label>
				<div class="col-sm-10">
					<textarea rows="5" name="repaymentPlan" class="col-sm-10 validate[maxSize[2000]]">${apply.repaymentPlan }</textarea>
					<div class="col-sm-10 no-padding-right">
						<span class="light-grey" style="float:right">限制2000个字符</span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1">拟提供的&nbsp;&nbsp;&nbsp;&nbsp;<br/>保证措施： </label>
				<div class="col-sm-10">
					<textarea rows="5" name="provideGuaranty" class="col-sm-10 validate[maxSize[2000]]">${apply.provideGuaranty }</textarea>
					<div class="col-sm-10 no-padding-right">
						<span class="light-grey" style="float:right">限制2000个字符</span>
					</div>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>接待部门：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class=" col-sm-10 ">
							<div class="input-group selectReception">
								<input  type="text"  class="form-control validate[required] " autoField="receiveDeapartID"   id="selectReception"  
									value="${apply.receiveDeapartName}" datavalue="${apply.receiveDeapartID }" name="receiveDeapartName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>接待人：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class=" col-sm-10 ">
							<div class="input-group selectReceptionist">
								<input  type="text"  class="form-control validate[required] " autoField="receiveUserID"   id="selectReceptionist"  
									value="${apply.receiveUserName}" dataValue="${apply.receiveUserID}" name="receiveUserName" readonly="readonly"/>
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group col-sm-6">
		   	    <label class="col-sm-4 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>接待日期： </label>
		        <div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<div class="input-group">
								<input class="form-control date-picker validate[required,custom[date]]" type="text" id="date-picker-1" data-date-format="yyyy-mm-dd" name="receiveDate" 
									value="<fmt:formatDate value='${apply.receiveDate }' pattern='yyyy-MM-dd' type='date'/>"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
 			</div>
 			<div class="form-group col-sm-12 col-xs-12" style="height:80px"></div>
		 </form>
      </div>
      <div class="modal-footer ">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					