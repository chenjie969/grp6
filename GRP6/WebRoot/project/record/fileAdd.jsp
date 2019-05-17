<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="fileAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false" style="z-index:9999">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">新增文档清单</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>类别： </label>
				<div class="col-sm-8">
					<input type="text" name="type" class="col-xs-10 col-sm-6 validate[required,maxSize[18]]" />
					<span class="midden col-sm-4 " style="line-height:28px;"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>文件名称： </label>
				<div class="col-sm-8">
					<input type="text" name="type" class="col-xs-10 col-sm-6 validate[required,maxSize[18]]" />
					<span class="midden col-sm-4 " style="line-height:28px;"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>份数： </label>
				<div class="col-sm-8">
					<input type="text" name="type" class="col-xs-10 col-sm-6 validate[required,custom[number],maxSize[18]]" />
					<span class="midden col-sm-4 " style="line-height:28px;">	</span>
				</div>
			</div>
		</form>
      </div>
      <div class="modal-footer">
			<button type="button" class="btn btn-primary btn_submit"  data-dismiss="modal"><i class='icon-ok bigger-110'></i>确定</button>
			<button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
