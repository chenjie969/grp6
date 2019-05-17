<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="processDefinitionConfig" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">配置</h4>
      </div>
      <div class="modal-body">
			<ul class="nav nav-tabs" id="myTab">
				<li class="active">
					<a data-toggle="tab" href="#processDefinitionInfo" >流程信息</a>
				</li>
				<li>
					<a data-toggle="tab" href="#processNodeInfo">节点设置</a>
				</li>
                   <li>
					<a data-toggle="tab" href="#processUserInfo">阶段操作者设置</a>
				</li>
                   <li>
					<a data-toggle="tab" href="#processVariateInfo">变量设置</a>
				</li>
                   <li>
					<a data-toggle="tab" href="#processFormInfo">表单设置</a>
				</li>
			</ul>
			<div id="processDefinitionInfo" class="tab-pane in active"><br/><br/><br/></div>
			<div id="processNodeInfo" class="tab-pane"><br/><br/><br/></div>
			<div id="processUserInfo" class="tab-pane"><br/><br/><br/></div>
			<div id="processVariateInfo" class="tab-pane"><br/><br/><br/></div>
			<div id="processFormInfo" class="tab-pane"><br/><br/><br/></div>
      </div>
      <div class="modal-footer">
        <!-- <button type="button" class="btn btn-primary btn_submit"><i class='icon-ok bigger-110'></i>保存</button> -->
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
				