<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="editOtherAssetsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改其它家庭财产</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="edit_otherAssetsForm">
			<input type="hidden" name="client_ID" class="ztb_edit_client_ID ztb_edit" value="" />
			<div class="form-group ">
					<div class="col-sm-1 col-xs-1"></div><!-- 占位用 -->
					<textarea class="col-sm-10 limited ztb_edit ztb_edit_otherAssets validate[maxSize[2000]]" rows="7" cols="20" name="otherAssets"	 id="edit_otherAssets" ></textarea>
					<div class="col-sm-1 col-xs-1"></div><!-- 占位用 -->
					<div class="col-sm-11 col-xs-11 no-padding-right">
						<span class="light-grey" style="float:right">限制2000个字符</span>
					</div>
			</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>