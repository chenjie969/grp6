<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp"%>

<div class="page-content">
	<div class="row">
		<table id="finishTask-table" style="font-size: 13px !important;">
		</table>
	</div>
</div>
<div id="finishTask_page"></div>
<%@ include file="/common_message.jsp" %>
<%@ include file="/common_foot.jsp"%>
<script src="<%=path%>/gbpm/product/finishTask/finishTask.js?v=<%=vardate%>"></script>