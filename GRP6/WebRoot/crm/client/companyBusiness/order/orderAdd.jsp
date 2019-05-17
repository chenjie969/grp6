<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="addOrder" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增订单信息</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="add_order_form">
      	 	<input type="hidden" name="client_ID">
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>客户名称： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" name="customerName" class="col-sm-12 validate[required,maxSize[25]]"/>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>订单量： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" name="orderSum" class="col-sm-12 validate[required,maxSize[100]]"/>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>期限： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" name="period" class="col-sm-12 validate[required,maxSize[25]]"/>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1">其他： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<textarea class="col-xs-12 validate[maxSize[100]]"   name="otherDesc" rows="5"></textarea>
							<div class="col-xs-12 no-padding-right">
								<span class="light-grey" style="float:right">限制100个字符</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		 </form>
      </div>
      <div class="modal-footer ">
        <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					