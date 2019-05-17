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
							<a data-toggle="tab" href="#computeMustCharge" id="computeMustChargeTab">
								应收计算
							</a>
						</li>
						<li>
							<a data-toggle="tab" href="#paymentNotice" id="paymentNoticeTab">
								缴费通知单
							</a>
						</li>
					</ul>
					<div class="tab-content">
						<div id="computeMustCharge" class="tab-pane in active">
							<%@ include file="/project/finance/projectCost/computeMustCharge.jsp"%>
						</div>
						<div id="paymentNotice" class="tab-pane">
							<%@ include file="/project/finance/projectCost/paymentNotice.jsp"%>
						</div>
					</div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->	
	</div><!-- /.page-content -->

<%@ include file="/common_message.jsp" %>	
<%@ include file="/common_foot.jsp" %>

<script src="<%=path %>/project/finance/projectCost/computeAndNotice.js?v=<%=vardate%>"></script>
