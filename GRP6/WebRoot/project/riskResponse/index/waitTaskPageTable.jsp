<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp"%>

<div class="page-content">
	<!-- <div class="page-header">
		<button type="button" name="button" class="btn btn-sm btn-info" id="btn_signed" >办理任务</button>
		<button type="button" name="button" class="btn btn-sm btn-info" id="btn_noSign" >拒收</button>
	</div> -->
	<div class="row">
		<table id="waitTask-table" style="font-size: 13px !important;">
		</table>
	</div>
</div>
<div id="waitTask_page"></div>
<%@ include file="/common_message.jsp" %>
<%@ include file="/common_foot.jsp"%>
<script src="<%=path%>/project/riskResponse/index/waitTask.js?v=<%=vardate%>"></script>