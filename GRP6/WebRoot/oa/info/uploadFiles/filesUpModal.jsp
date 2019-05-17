<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="uploadfiles" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" style="z-index:999999">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">附件上传</h4>
      </div>
      <div class="modal-body">
      		<form class="form-horizontal" role="form" id="add_form">
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 待上传文件列表 </label>
				<div class="col-sm-9" id="uploadFileList">您的浏览器未安装 Flash, Silverlight 或者支持 HTML5 .</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group" id="uploadConsoleListDiv">
				
			</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="pick"> <i class='icon-search bigger-110'></i>选择文件</button>
        <button type="button" class="btn btn-primary" id="upload"> <i class='icon-upload-alt bigger-110'></i>上传</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					