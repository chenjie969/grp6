<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="modal fade" id="editCooperation" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改合作机构</h4>
      </div>
      <div class="modal-body">

			<form class="form-horizontal" role="form" id="edit_form">
				<input type="hidden" name="banksortid" class="ztb_edit_busisortid" value="${CooperationInfo.banksortid}">
				<input type="hidden" name="unitUid" class="ztb_edit_unitUid" value="${CooperationInfo.unitUid}">
				<input type="hidden" name="pbanksortid" class="ztb_edit_pbanksortid" value="${CooperationInfo.pbanksortid}">
				<input type="hidden" name="bankfullcode" class="ztb_edit_bankfullcode" value="${CooperationInfo.bankfullcode}">
				<input type="hidden" name="url" class="ztb_edit_url" value="${CooperationInfo.url}">
				<input type="hidden" name="isedit" class="ztb_edit_isedit" value="${CooperationInfo.isedit}">
				<input type="hidden" name="orderId" class="ztb_edit_orderId" value="${CooperationInfo.orderId}">
				<input type="hidden" name="isDefault" class="ztb_edit_isDefault" value="${CooperationInfo.isDefault}">
				<input type="hidden" name="iseable" class="ztb_edit_iseable" value="${CooperationInfo.iseable}">
				<input type="hidden" name="createUser" class="ztb_edit_createUser" value="${CooperationInfo.createUser}">
			
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>合作机构名称： </label>
				<div class="col-sm-8">
					<input value="${CooperationInfo.banksortname}" name="banksortname" id="edit_banksortname"  class="col-xs-10 col-sm-11 ztb_edit validate[required,maxSize[50]]" />
				</div>
			</div>
	
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">责任比例： </label>
				<div class="col-sm-5">
					<input value="${CooperationInfo.zrScale}" name="zrScale" id="add_zrScale"  class="col-xs-10 col-sm-6  ztb_edit validate[custom[number],maxSize[18]]" />
					<span class="midden col-sm-4 " style="line-height:28px;">%</span>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">保证金比例： </label>
				<div class="col-sm-5">
					<input value="${CooperationInfo.bzScale}" name="bzScale" id="add_bzScale"  class="col-xs-10 col-sm-6  ztb_edit validate[custom[number],maxSize[18]]" />
					<span class="midden col-sm-4 " style="line-height:28px;">%</span>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">缴存方式： </label>
				<div class="col-sm-5">
					<select class="col-sm-11  ztb_edit  select_depositMethodID  btn_ztb_select" name="depositMethodID" onclick="clickSelect()" id="id_depositMethodID">
						<option value="${CooperationInfo.depositMethodID}">${CooperationInfo.depositMethodID}</option>
					</select>
					<input type="hidden" value="${CooperationInfo.depositMethodID}"  id="hidden_depositMethodID" />
				
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">授信额度： </label>
				<div class="col-sm-5">
					<input value="${CooperationInfo.creditSum}" name="creditSum" id="add_creditSum"  class="col-xs-10 col-sm-6  ztb_edit validate[custom[number],maxSize[18]]" />
					<span class="midden col-sm-4 " style="line-height:28px;">万元</span>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">授信起始日期： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-8">
							<div class="input-group">
								<input value="<fmt:formatDate value="${CooperationInfo.creditBeginDate}" pattern="yyyy-MM-dd"/>" name="creditBeginDate" id="add_creditBeginDate" data-date-format="yyyy-mm-dd"  class="date-picker form-control ztb_add validate[maxSize[50]]" />
								<span class="input-group-addon" >
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">授信到期日期： </label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-8">
							<div class="input-group">
								<input value="<fmt:formatDate value="${CooperationInfo.creditEndDate}" pattern="yyyy-MM-dd"/>" name="creditEndDate" id="add_creditEndDate" data-date-format="yyyy-mm-dd"   class="date-picker form-control ztb_add validate[maxSize[50]]" />
								<span class="input-group-addon" >
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">信贷偏好： </label>
				<div class="col-sm-8">
					<textarea rows="3" name="creditRemark" class="col-sm-11  ztb_add_creditRemark  ztb-add validate[maxSize[50]]">${CooperationInfo.creditRemark}</textarea>
					<span class="col-sm-6 light-grey col-sm-push-8">限制50个字符 </span>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">营业地址： </label>
				<div class="col-sm-8">
					<textarea rows="2" name="busiAddress" class="col-sm-11    ztb-add validate[maxSize[50]]">${CooperationInfo.busiAddress}</textarea>
					<span class="col-sm-6 light-grey col-sm-push-8">限制50个字符</span>
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
				