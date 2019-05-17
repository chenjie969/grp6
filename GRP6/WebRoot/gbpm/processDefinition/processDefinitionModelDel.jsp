<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="processDefinitionModelDel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">流程模板删除</h4>
      </div>
      <div class="modal-body">
      		<div class="alert bigger-110">
      			<i class='icon-warning-sign red bigger-130'></i>
				是否删除流程模板？注意！此操作会删除所选流程模型下所有的部署流程及流程实例！
			</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" ><i class='icon-ok bigger-110'></i>是</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>否</button>
      </div>
    </div>
  </div>
</div>
				