<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="editDownClient" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改下游销售客户</h4>
      </div>
      <div class="modal-body">
      	 <form class="form-horizontal row" role="form" id="edit_downClient_form">
      	 	<input type="hidden" name="upDownClient_ID" value="${downClient.upDownClient_ID }">
      	 	<input type="hidden" name="upDownFlag" value="${downClient.upDownFlag }">
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>合同期限： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" name="contractPeriod" class="col-sm-12 validate[required,maxSize[25]]" value="${downClient.contractPeriod }"/>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>客户名称： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" name="customerName" class="col-sm-12 validate[required,maxSize[25]]" value="${downClient.customerName }"/>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>产品： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<textarea class="col-xs-12 validate[maxSize[100]]"   name="productName" rows="5">${upClient.productName }</textarea>
							<div class="col-xs-12 no-padding-right">
								<span class="light-grey" style="float:right">限制100个字符</span>
							</div>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>金额： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<input type="text" name="currentSum" class="col-xs-8 validate[required,maxSize[18],custom[number]]" value="${downClient.currentSum }"/>
							<span class="col-xs-4" style="line-height:28px;">万元</span>
						</div>
			        </div>
				</div>
			</div>
			<div class="form-group col-xs-12">
				<label class="col-sm-3 col-xs-12 control-label no-padding-right" for="form-field-1">备注： </label>
				<div class="col-sm-9 col-xs-12">
					<div class="row">
					    <div class="col-xs-10">
							<textarea class="col-xs-12 validate[maxSize[100]]"   name="remark" rows="5">${downClient.remark }</textarea>
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
					