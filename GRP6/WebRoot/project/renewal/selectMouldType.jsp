<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="selectMouldType" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">选择模板</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="form_selectMouldType">
      	 	<input type="hidden" name="fileType" value="${fileType }">
      	 	<input type="hidden" name="entityID" value="${applyID }">
   			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>选择模板：</label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-10">
							<select class="col-sm-12 validate[required]"  name="mouldPath">
								<option value="">&nbsp;请选择</option>
								<c:forEach items="${mouldList }" var="mould">
									<option value="${mould.mouldPath }">${mould.oldMouldName }</option>
								</c:forEach>
							</select>
						</div>	
					</div>
				</div>
			</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="btn_submit"><i class='icon-ok bigger-110'></i>确定</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>取消</button>
      </div>
    </div>
  </div>
</div>
				