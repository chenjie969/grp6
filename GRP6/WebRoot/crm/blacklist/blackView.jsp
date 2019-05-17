<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="blackManView" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static"
	data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">请选择excel文件</h4>
			</div>
			<div class="modal-body">
			<form class="form-horizontal"  enctype="multipart/form-data" action="/uploadBadClientExcel"
					method="post"  id="batchAdd" name="batchAdd">
					<div class="form-group col-sm-offset-2">
						<input class="col-sm-offset-3" type="file" id="file1" name="excelFile" />
					</div>
					<div class="form-group"> 
						<label class="col-sm-4 control-label no-padding-right">说明：</label>
						<label class="col-sm-8"><a href="/addBadClientExcel">黑名单.xls(格式模板)</a></label>
					</div>
				</form> 		
			</div>
				<div class="modal-footer">
				<button type="button" class="btn btn-primary btn_submit" >
				<i class='icon-ok bigger-110'></i>确定导入
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<i class='icon-remove bigger-110'></i>关闭
				</button>
			</div>
		</div>
	</div>
</div>
