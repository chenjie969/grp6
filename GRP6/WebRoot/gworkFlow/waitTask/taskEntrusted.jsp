<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="processDefinitionTaskEntrusted" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">委托他人办理</h4>
      </div>
      <div class="modal-body">
      <form class="form-horizontal" role="form" id="taskEntrusted_form">
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1">被委托人： </label>
				<div class="col-sm-9">
					<div class="row">
						<div class="col-xs-10 col-sm-11 ">
							<div class="input-group select_user_tree">
								<input class="form-control validate[required]" autoField="entrustedUserUid" name="entrustedUserName" id="select_user_tree" type="text" value="" dataValue="" />
								<span class="input-group-addon ">
									<i class="icon-caret-down bigger-110  "></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" ><i class='icon-ok bigger-110'></i>是</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>否</button>
      </div>
    </div>
  </div>
</div>
				