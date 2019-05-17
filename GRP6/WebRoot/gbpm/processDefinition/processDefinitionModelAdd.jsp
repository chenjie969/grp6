<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="processDefinitionModelAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新建流程模板</h4>
      </div>
      <div class="modal-body">
      		<form class="form-horizontal" role="form" id="add_model_form">
      			<input type="hidden" name="actSortID" value="${actSortID}"/>
				<div class="space-4"></div>
				<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> <i class="icon-asterisk orange"></i>流程模板名称： </label>
					<div class="col-sm-9">
						<input type="text" name="modelName" class="col-xs-10 col-sm-9 validate[required,maxSize[50]]" />
					</div>
				</div>
				<div class="space-4"></div>
				<div class="form-group ">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1">描述： </label>
					<div class="col-sm-9">
						<textarea name="description" class="col-xs-10 col-sm-9 validate[maxSize[500]]"></textarea>
						<div class="col-sm-9 no-padding-right">
							<span class="light-grey" style="float:right">限制500个字符</span>
						</div>
					</div>
				</div>				
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" ><i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>取消</button>
      </div>
    </div>
  </div>
</div>
				