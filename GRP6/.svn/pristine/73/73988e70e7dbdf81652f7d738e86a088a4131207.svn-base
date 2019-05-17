<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<div class="modal fade" id="addmodule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加流程分类</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="add_form">
		<input type="hidden" name="pactSortID" value="${actSort.pactSortID}"  />
		<input type="hidden" name="actSortFullCode" value="${actSort.actSortFullCode}"  />
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>流程分类名称： </label>
				<div class="col-sm-9">
					<input type="text" name="actSortName" id="actSortName" value="${actSort.actSortName}"  class="col-xs-10 col-sm-11   validate[required,maxSize[50]]" />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-select-1">是否展开节点： </label>
				<div class="col-sm-9">
					<select class="col-xs-10 col-sm-11" name="isOpen"  id="form-field-select-1">
						<option value="0" <c:if test="${actSort.isOpen==0}">selected</c:if>>否</option>
						<option value="1" <c:if test="${actSort.isOpen==1}">selected</c:if>>是</option>
					</select>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group ">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">备注： </label>
				<div class="col-sm-9">
					<textarea class="col-xs-10 col-sm-11 validate[maxSize[2000]]"  name="remark" >${actSort.remark}</textarea>
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
					