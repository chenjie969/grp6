<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="viewmodule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看项目组</h4>
      </div>
      <div class="modal-body">
      	<div class="row">
		   <div class="col-sm-offset-1">
			<h5 class="col-sm-12">项目组名称：<span class="grey">${usergroup.userGroupName}</span></h5>
			<h5 class="col-sm-12">项目组人员：<span class="grey">${usergroup.user_names}</span></h5>
			</div>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					