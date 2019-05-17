<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade bs-example-modal-sm" id="arcMoveDetailAdds" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog " role="document">
    <div class="modal-content">
    <!-- 新增档案页面 -->
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增档案</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="arcMoveDetailAdds_form" >
			    <input type="hidden" id="apply_ID" name="apply_ID" value="${pro_arcMove.apply_ID}">
			    <input type="hidden" id="arcMoveRec_ID" name="arcMoveRec_ID" value="${pro_arcMove.arcMoveRec_ID}">
         		<input type="hidden" name="arcMoveDetails" id="arcMoveDetailsTreeChecked" value="" />
           	<div class="">
					<div class="widget-body">
						<div class="widget-main padding-8">
							<ul id="arcMoveTree" class="ztree"></ul>
						</div>
					</div>
			</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary " id="btn_submit"> <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					