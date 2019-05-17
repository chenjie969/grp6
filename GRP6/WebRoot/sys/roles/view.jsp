<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="viewmodule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看角色</h4>
      </div>
      <div class="modal-body">
      	<div class="row">
		   <div class="col-sm-offset-1">
			<h5 class="col-sm-12">角色名称：<span class="grey">${roles.role_name}</span></h5>
			<h5 class="col-sm-12">角色描述：<span class="grey">${roles.role_descr}</span></h5>
			<h5 class="col-sm-12">人员：<span class="grey">${roles.user_names}</span></h5>
			</div>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					