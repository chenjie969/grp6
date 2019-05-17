<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<div class="page-content">
	<div class="row"> <!-- style="display: block" -->
		<div class="col-xs-12">
					<!-- <div class="page-header">
								<button class="btn btn-sm btn-info" id="btn_startApproval">启动流程</button>
							</div> -->
						<div class="table-responsive" id="approvalRecord">
							<table id="approvalRecord_table" style="font-size: 13px !important;"></table>
						</div>
		</div>
	</div><!-- /.row -->
</div><!-- /.page-content -->

<div id="page_relationProject"></div>
<div id="approvalRecord_page"></div>
<div id="nodeTaskModal_page"></div>

<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_confirm.jsp" %>
<%@ include file="/common_message.jsp" %>
<%@ include file="/project/riskResponse/keyProject/selectProductModal.jsp" %><!-- 启动流程-选择流程页面 -->

<script src="<%=path%>/project/setNodeTask/nodeTaskModal.js?v=<%=vardate%>"></script>
<script src="<%=path%>/project/riskResponse/index/riskSchemeTable.js?v=<%=vardate%>"></script>