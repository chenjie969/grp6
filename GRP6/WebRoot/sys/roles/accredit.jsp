<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="modal fade" id="editmodule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">授权角色（${roles.role_name}）</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" id="edit_form">
					<input type="hidden" name="role_uid" value="${roles.role_uid}" />
					<input type="hidden" name="mod_uids" value="${roles.mod_uids}" id="mod_uids"/>
					<input type="hidden" value="" id="mod_names"/>
					<input type="hidden" name="fun_ids" value="${roles.fun_ids}" id="fun_ids"/>
					<div class="row">
						<div class="col-sm-4">
							<div class="widget-box">
								<h4 class="row-fluid header smaller lighter " style="margin-bottom: 0px;">
									<i class="icon-th-list"></i> <span class="span7"> 菜单授权 </span>
									<!-- <span class="span5"> <label class="pull-right inline"> <input name="form-field-checkbox" class="ace ace-checkbox-2" type="checkbox" /> <span class="lbl control-label bolder blue"> 全选</span>
									</label>
									</span> -->
								</h4>
								<div class="widget-body">
									<div class="widget-main padding-8">
										<ul id="accreditSetTree" class="ztree"></ul>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm-8">
							<h4 class="row-fluid header smaller lighter purple">
								<i class="icon-signal purple"></i> <span class="span7"> 数据授权 </span>
								<!-- <span class="span5"> <label class="pull-right inline"> <input name="form-field-checkbox" class="ace ace-checkbox-2" type="checkbox" /> <span class="lbl control-label bolder blue"> 全选</span>
								</label>
								</span> -->
							</h4>
							<div class="widget-main">
								<div class="row">
									<div class="control-group col-sm-4">
										<label> <!-- <input name="form-field-checkbox" class="ace ace-checkbox-2" type="checkbox" /> --> <span class="lbl control-label bolder blue"> 客户数据授权</span>
										</label>
										<div class="checkbox">
											<label> <input name="clientDataType" class="ace orm-field-radio ztb_edit_isHighTechnology ztb_edit" type="radio" value="1"  id ="clientType1"<c:if test="${(!empty clientTypeData) && clientTypeData.accredit_type ==1}"> checked="checked"</c:if>/> <span class="lbl"> 本人创建</span>
											</label>
										</div>
										<div class="checkbox">
											<label> <input name="clientDataType" class="ace orm-field-radio ztb_edit_isHighTechnology ztb_edit" type="radio" value="2"	id ="clientType2" <c:if test="${(!empty clientTypeData) && clientTypeData.accredit_type ==2}">checked="checked"</c:if>/> <span class="lbl"> 本部门创建</span>
											</label>
										</div>
										<div class="checkbox">
											<label> <input name="clientDataType" class="ace orm-field-radio ztb_edit_isHighTechnology ztb_edit" type="radio" value="3" 	id ="clientType3" <c:if test="${(!empty clientTypeData) && clientTypeData.accredit_type ==3}">checked="checked"</c:if>/> <span class="lbl"> 全公司</span>
											</label>
										</div>
									</div>
									<div class="control-group col-sm-4">
										<label> <!-- <input name="form-field-checkbox" class="ace ace-checkbox-2" type="checkbox" /> --> <span class="lbl control-label bolder blue"> 项目数据授权</span>
										</label>
										<div class="checkbox">
											<label> <input name="proDataType" class="ace orm-field-radio ztb_edit_isHighTechnology ztb_edit" type="radio"  value="1" <c:if test="${(!empty proTypeData) && proTypeData.accredit_type ==1}">checked="checked"</c:if> /> <span class="lbl" > 本人创建</span>
											</label>
										</div>
										<div class="checkbox">
											<label> <input name="proDataType" class="ace orm-field-radio ztb_edit_isHighTechnology ztb_edit" type="radio"  value="2" <c:if test="${(!empty proTypeData) && proTypeData.accredit_type ==2}">checked="checked"</c:if> /> <span class="lbl" > 本部门创建</span>
											</label>
										</div>
										<div class="checkbox">
											<label> <input name="proDataType" class="ace orm-field-radio ztb_edit_isHighTechnology ztb_edit" type="radio"  value="3" <c:if test="${(!empty proTypeData) && proTypeData.accredit_type ==3}">checked="checked"</c:if> /> <span class="lbl"> 全公司</span>
											</label>
										</div>
									</div>

								</div>
							</div>
						</div>
						<%-- <div class="col-sm-8">
							<h4 class="row-fluid header smaller lighter green">
								<i class="icon-star green"></i> <span class="span7"> 功能授权 </span>
								<span class="span5"> <label class="pull-right inline"> <input name="fun_id" class="ace ace-checkbox-2" type="checkbox" /> <span class="lbl control-label bolder blue"> 全选</span>
								</label>
								</span>
							</h4>
							<div class="widget-main">
								<div class="row">
									<c:forEach items="${funTypeList}" var="funType" varStatus="status">
										<div class="control-group col-sm-4">
											<label> <span class="lbl control-label bolder blue"> ${funType.fun_type}</span></label>
											<c:forEach items="${functionsList}" var="functions" varStatus="status">
												<c:if test="${funType.fun_type == functions.fun_type }">
													<c:if test="${fn:contains(roles.fun_ids, functions.id)}">
														<div class="checkbox">
															<label> <input class="ace checkbox_functions" type="checkbox" value="${functions.id}" checked="checked"/> <span class="lbl"> ${functions.name}</span>
															</label>
														</div>
													</c:if>
													<c:if test="${!fn:contains(roles.fun_ids, functions.id)}">
														<div class="checkbox">
															<label> <input class="ace checkbox_functions" type="checkbox" value="${functions.id}" /> <span class="lbl"> ${functions.name}</span>
															</label>
														</div>
													</c:if>
												</c:if>
											</c:forEach>
										</div>
									</c:forEach>
								</div>
							</div>
						</div> --%>
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
<script type="text/javascript">
	// var clientDataTypeVal = undefined;
	$(".widget-main .checkbox .orm-field-radio").click(function(){
		// console.log(000)
		// if()		
		var clientDataTypeVal=$('input:radio[name="clientDataType"]:checked').val();
		var proDataTypeNum=$('input:radio[name="proDataType"]:checked').val();

		if(clientDataTypeVal ==1 || clientDataTypeVal ==2 || clientDataTypeVal ==3 ){
			$(this).parents(".control-group").find("input:checkbox[name='form-field-checkbox']").prop("checked",true)
		}
		
		if(proDataTypeNum ==1 || proDataTypeNum ==2 || proDataTypeNum ==3 ){
			$(this).parents(".control-group").find("input:checkbox[name='form-field-checkbox']").prop("checked",true)
		}
	})
	$(".widget-main .control-group input:checkbox[name='form-field-checkbox']").click(function(){
		// console.log($(this).val(),)
		if(!$(this).is(':checked')){
			$(this).prop("checked",false)
			// console.log("radio",$(this).parents(".control-group").find('input:radio[name="clientDataType"]'))
			$(this).parents(".control-group").find('input:radio[name="clientDataType"]').prop("checked",false)
			$(this).parents(".control-group").find('input:radio[name="proDataType"]').prop("checked",false)
		}
	})
</script>
