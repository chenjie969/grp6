<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="paymentDetail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">收付确认</h4>
			</div>
			<div class="modal-body">
				<div class="table-responsive">
					<table id="table_confirmPayment" style="font-size:13px !important;"></table>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary btn-submit" data-dismiss="modal"> <i class='icon-ok bigger-110'></i>收付确认</button>
				<button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
			</div>
		</div>
	</div>
</div>
	