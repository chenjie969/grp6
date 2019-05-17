<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="approveGuaranteeEdti" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" style="z-index:9999">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">编辑批准担保情况</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="form_approveGuaranteeEdit">
			<input type="hidden" name="applyDetail_ID" value="${applyDetail.applyDetail_ID }">
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">业务品种：</label>
				<label class="col-sm-8">${applyDetail.busiTypeName }</label>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">放款机构：</label>
				<c:if test="${not empty applyDetail.bankName }">
					<label class="col-sm-8">${applyDetail.bankName }</label>
					<input type="hidden" name="bankName" value="${applyDetail.bankName }">
					<input type="hidden" name="bankID" value="${applyDetail.bankID }">
				</c:if>
				<c:if test="${empty applyDetail.bankName }">
					<div class=" col-sm-7 ">
						<div class="input-group selectBank">
							<input  type="text"  class="form-control" autoField="bankID"   id="selectBank"  name="bankName" readonly="readonly"/>
							<span class="input-group-addon ">
								<i class="icon-caret-down bigger-110"></i>
							</span>
						</div>
					</div>
				</c:if>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">放款子机构：</label>
				<div class="col-sm-8">
					<input type="text" name="subBankName" class="col-sm-10 validate[maxSize[50]]" value="${applyDetail.subBankName }">
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">申请金额：</label>
				<label class="col-sm-8">
					<fmt:formatNumber value="${applyDetail.applySum }" pattern="###,###.######"/> 万元
				</label>
				<input type="hidden" id="applySum" value="${applyDetail.applySum }">
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>同意金额： </label>
				<div class="col-sm-8">
					<input type="text" name="agreeSum" class="col-xs-10 col-sm-6 validate[required,custom[number],maxSize[18],custom[isMoreThan]]" id="agreeSum"
						value="<fmt:formatNumber value='${applyDetail.agreeSum}' pattern='###.######'/>">
					<span class="midden col-sm-4 " style="line-height:28px;">万元	</span>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>同意期限：</label>
				<div class="col-sm-8">
					<span class="col-sm-10 no-padding-left">
						<input type="text" name="agreeMonth" class="validate[required,maxSize[5],custom[integer]]" style="width: 70px;" value="${applyDetail.agreeMonth }"/>&nbsp;个月&nbsp;
						<input type="text" name="agreeDay"  class="validate[required,maxSize[5],custom[integer]]" style="width: 70px;" value="${applyDetail.agreeDay }"/>&nbsp;天
					</span>
				<!-- <span class="col-sm-10 no-padding-left grey">
						（注：同意期限为整月时，天数默认为0天）
					</span> -->
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>担保责任范围：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-5">
							<select class="col-sm-12 btn_ztb_select validate[required]"  name="guarantyScope">
								<option value="本金担保" <c:if test="${applyDetail.guarantyScope=='本金担保' }">selected="selected"</c:if>>本金担保</option>
								<option value="本息担保" <c:if test="${applyDetail.guarantyScope=='本息担保' }">selected="selected"</c:if>>本息担保</option>
							</select>
						</div>	
						<div class="col-sm-5 no-padding-left">
							<input type="text" name="guarantyScale" class="col-sm-8 validate[required,custom[number],maxSize[18]]" value="${applyDetail.guarantyScale }">&nbsp;&nbsp;％
						</div>
					</div>
				</div>
			</div>
			
			<%-- <div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>担保责任金额： </label>
				<div class="col-sm-8">
					<input type="text" name="guarantyDutySum" class="col-sm-6 validate[required,custom[number],maxSize[18]]" 
						value="<fmt:formatNumber value='${applyDetail.guarantyDutySum}' pattern='###.######'/>">
					<span class="midden col-sm-4 " style="line-height:28px;">万元	</span>
				</div>
			</div> --%>
		</form>
      </div>
      <div class="modal-footer">
			<button type="button" class="btn btn-primary btn_submit"><i class='icon-ok bigger-110'></i>确定</button>
			<button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
				