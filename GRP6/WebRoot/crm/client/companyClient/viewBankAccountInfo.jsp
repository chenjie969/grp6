<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="viewBankAccountClientInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看开户信息</h4>
      </div>
      <div class="modal-body">
			<div class="row">
				<div class="col-sm-offset-1">
				<h5 class="col-sm-12">账户类别：<span class="grey ztb_views_accounttype"></span></h5>
				<h5 class="col-sm-12">开户行：<span class="grey ztb_views_bankname"></span></h5>
				<h5 class="col-sm-12">账号：<span class="grey ztb_views_accountnumber"></span></h5>
				<h5 class="col-sm-12">账户余额：<span class="grey ztb_views_accountsum"></span>&nbsp;万元</h5>
				<h5 class="col-sm-12">备注： <span class="grey ztb_views_remark" style="white-space: pre-wrap;line-height:26px;"></span></h5>
			   </div>
			</div>		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
				