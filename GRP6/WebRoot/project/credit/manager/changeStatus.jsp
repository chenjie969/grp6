<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" id="changeStatus" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" style="z-index:9999">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改授信项状态</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal row" role="form" id="form_changeStatus">
      		<input type="hidden" id="hidden_applyID" value="${creditApply.apply_ID }" name="apply_ID">
      		<div class="space-4"></div>
			<div class="form-group">
			   	<label class="col-sm-3 control-label no-padding-right" for="form-field-1">授信项目名称： </label>
				<label class="col-sm-9">${creditApply.projectName }</label>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
			   	<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>授信状态： </label>
				<div class="col-sm-9">
					<div class="radio">
						<label>
							<input type="radio" name="creditStatus" class="ace form-field-radio" value="01" <c:if test="${creditApply.creditStatus=='01' }">checked="checked"</c:if>/>
							<span class="lbl">已生效</span>
						</label>
						<label>
							<input type="radio" name="creditStatus" class="ace form-field-radio"  value="02" <c:if test="${creditApply.creditStatus=='02' }">checked="checked"</c:if>/>
							<span class="lbl">已失效</span>
						</label>
					</div>
				</div>
			</div>
		</form>
      </div>
      <div class="modal-footer">
         <button type="button" class="btn btn-primary btn_submit" >      <i class='icon-ok bigger-110'></i>确定</button>
         <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
				