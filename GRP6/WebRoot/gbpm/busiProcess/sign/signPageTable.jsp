<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp"%>

<div class="page-content">
	<!-- <div class="page-header">
		<button type="button" name="button" class="btn btn-sm btn-info" id="btn_signed" >签收</button>
		<button type="button" name="button" class="btn btn-sm btn-info" id="btn_noSign" >拒收</button>
	</div> -->
	<div class="row">
		<table id="sign-table" style="font-size: 13px !important;">
		</table>
	</div>
</div>
<div id="sign_page"></div>
<%@ include file="../message.jsp" %>
<%@ include file="/common_foot.jsp"%>
<script src="<%=path%>/gbpm/busiProcess/sign/sign.js?v=<%=vardate%>"></script>