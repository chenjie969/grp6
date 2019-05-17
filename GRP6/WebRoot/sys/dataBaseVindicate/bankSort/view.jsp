<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade bs-example-modal-sm" id="viewBankSort" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看银行字典</h4>
      </div>
      <div class="modal-body">
		<div class="row">
		  <div class="col-sm-offset-1">
			<h5 class="col-sm-12">银行字典名称：<span class="grey ztb_view_banksortname"></span></h5>
			<h5 class="col-sm-12">对应监管机构银行字典编号：<span class="grey ztb_view_unificationid"></span></h5>
			<h5 class="col-sm-12">是否缺省：<span class="grey ztb_view_isDefault"></span></h5>
			<h5 class="col-sm-12">状态：<span class="grey ztb_view_iseable"></span></h5>
			</div>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
