<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="modal fade bs-example-modal-sm" id="addDynamicModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
	data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">添加项目动态</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal row" role="form" id="addDynamic_Form">
				<input type="hidden" name="apply_ID" id="apply_ID" value="${prodynamic.apply_ID}"/>
					<div class="form-group col-sm-12">
						<label class="col-sm-2 control-label no-padding-right" for="form-input"><i class="icon-asterisk orange"></i>项目动态： </label>
						<div class="col-sm-10">
								<textarea class="col-sm-10 limited  ztb_edit_dynamicContent validate[required,maxSize[2000]]" rows="5" name="dynamicContent" id="dynamicContent" >${prodynamic.dynamicContent}</textarea>
							<div class="col-sm-10 no-padding-right">
								<span class="light-grey pull-right" >限制2000个字符</span>
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
