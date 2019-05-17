<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	.table_jumpToConfirmPayment{
		font-size:13px;
		border:1px solid #ddd;
		table-layout:fixed
	}
	.table_jumpToConfirmPayment tr th,.table_jumpToConfirmPayment tr td{
		border:1px solid #ddd;
		text-align: center;
		vertical-align:middle
	};
</style>
<div class="modal fade" id="jumpToConfirmPayment" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">转收付确认</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal row" role="form" id="form_jumpToConfirmPayment">
					
					<div class="space-4"></div>
					<div class="form-group">
						<h5 class="col-sm-offset-1 col-sm-10 header lighter">
							收费信息
						</h5>
						<div class="col-sm-offset-1 col-sm-10">
							<table class="table table-hover table-striped table_jumpToConfirmPayment">
					 			<thead>
									<tr>
										<th>费用类别</th>
										<th>费率 （%）</th>
										<th>应收金额（元）</th>
										<th>实收金额（元）</th>
									</tr>
								</thead>
								<tbody></tbody>	
							</table>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-field-1">是否需要开具发票或收据： </label>
						<div class="col-sm-9">
							<div class="radio">
								<label>
									<input type="radio" name="isInvoice"  class="ace form-field-radio" value="1"/>
									<span class="lbl">是</span>
								</label>
								<label>
									<input  type="radio" name="isInvoice" checked="checked" class="ace form-field-radio"  value="0" />
									<span class="lbl">否</span>
								</label>
							</div>
						</div>
					</div>
					
					<div id="div_isInvoice" style="display:none">
						<div class="space-4"></div>
						<div class="form-group col-sm-6">
							<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>票据类型： </label>
							<div class="col-sm-8">
							    <div class="row">
								    <div class="col-sm-12">
										<select class="col-sm-10 validate[required]">
											<option value="">请选择</option>
											<c:forEach items="${billTypeList }" var="bill">
												<option value="${bill.dicTypeID }">${bill.dicTypeName }</option>
											</c:forEach>
										</select>
									</div>
						        </div>
						    </div>
						</div>
						<div class="form-group col-sm-6">
							<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>票据金额： </label>
							<div class="col-sm-8">
							    <div class="row">
								    <div class="col-sm-12">
										<input type="text" name="contact" class="col-sm-9  validate[required,custom[number],maxSize[18]]">
										<span class="midden col-sm-3" style="line-height:28px;">万元	</span>
									</div>
						        </div>
						    </div>
						</div>
						<div class="form-group col-sm-6">
							<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>发票抬头： </label>
							<div class="col-sm-8">
							    <div class="row">
								    <div class="col-sm-12">
										<input type="text" name="contact" class="col-sm-12  validate[required,maxSize[10]]">
									</div>
						        </div>
						    </div>
						</div>
						<div class="form-group col-sm-6">
							<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>纳税人识别号： </label>
							<div class="col-sm-8">
							    <div class="row">
								    <div class="col-sm-12">
										<input type="text" name="contact" class="col-sm-12  validate[required,maxSize[10]]">
									</div>
						        </div>
						    </div>
						</div>
						<div class="form-group col-sm-6">
							<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>开户行： </label>
							<div class="col-sm-8">
							    <div class="row">
								    <div class="col-sm-12">
										<input type="text" name="contact" class="col-sm-12  validate[required,maxSize[10]]">
									</div>
						        </div>
						    </div>
						</div>
						<div class="form-group col-sm-6">
							<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>账号： </label>
							<div class="col-sm-8">
							    <div class="row">
								    <div class="col-sm-12">
										<input type="text" name="contact" class="col-sm-12  validate[required,maxSize[10]]">
									</div>
						        </div>
						    </div>
						</div>
						<div class="form-group col-sm-6">
							<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>电话： </label>
							<div class="col-sm-8">
							    <div class="row">
								    <div class="col-sm-12">
										<input type="text" name="contact" class="col-sm-12  validate[required,maxSize[10]]">
									</div>
						        </div>
						    </div>
						</div>
						<div class="form-group col-sm-6">
							<label class="col-sm-4 control-label no-padding-right" for="form-field-1"><i class="icon-asterisk orange"></i>地址： </label>
							<div class="col-sm-8">
							    <div class="row">
								    <div class="col-sm-12">
										<input type="text" name="contact" class="col-sm-12  validate[required,maxSize[10]]">
									</div>
						        </div>
						    </div>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default btn-primary btn_submit"> <i class='icon-ok bigger-110'></i>确定</button>
				<button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>取消</button>
			</div>
		</div>
	</div>
</div>
<%@ include file="/common_timestamp.jsp" %>
<script src="<%=path %>/project/finance/projectCost/jumpToConfirmPayment.js?v=<%=vardate%>"></script>	
	