<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>

	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
 				<div class="tabbable">
					<ul class="nav nav-tabs" id="clientDepotTab">
						<li class="active">
							<a data-toggle="tab" href="#noConfirmPayment" data-value="noConfirmPayment" class="confirmPaymentTab">
								待确认收付
							</a>
						</li>
						<li>
							<a data-toggle="tab" href="#confirmedPayment" data-value="confirmedPayment" class="confirmPaymentTab">
								已确认收付
							</a>
						</li>
					</ul>
					<div class="tab-content">
						<div id="noConfirmPayment" class="tab-pane in active">
							<div class="page-content">
				                <div class="row">
				                     <div class="col-sm-12">
										<div class="page-header">
											<!-- <button type="button" class="btn btn-sm btn-info" id="btn_confirmPayment">收付确认</button>&nbsp;
											<button type="button" class="btn btn-sm btn-info" id="btn_backToProjectCost">退回</button>&nbsp; -->
											<button type="button" class="btn btn-sm btn-info">高级查询</button>&nbsp;
										</div>
				                     </div>
				                     <div class="col-sm-12">
										<div class="table-responsive">
											<table id="table_noConfirmPayment" style="font-size:13px !important;"></table>  
				                        </div>
				                     </div>
								</div>
							</div><!-- /.page-content -->
						</div>
						<div id="confirmedPayment" class="tab-pane">
							<div class="page-content">
				                <div class="row">
				                     <div class="col-sm-12">
										<div class="page-header">
											<button type="button" class="btn btn-sm btn-info" id="btn_backToNoConfirmPayment">撤销收付确认</button>&nbsp;
											<button type="button" class="btn btn-sm btn-info" >高级查询</button>&nbsp;
										</div>
				                     </div>
				                     <div class="col-sm-12">
										<div class="table-responsive">
											<table id="table_confirmedPayment" style="font-size:13px !important;"></table>  
				                        </div>
				                     </div>
								</div>
							</div><!-- /.page-content -->
						</div>
					</div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->	
	</div><!-- /.page-content -->

<div id="confirmPayment_page"></div>

<%@ include file="/common_message.jsp" %>	
<%@ include file="/common_foot.jsp" %>

<script src="<%=path %>/project/finance/confirmPayment/confirmPayment.js?v=<%=vardate%>"></script>
