<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp"%>

<div class="page-content">
	<div class="page-header">
		<button type="button" name="button" class="btn btn-sm btn-info" id="btn_add" >添加项目组</button>
		<button type="button" name="button" class="btn btn-sm btn-info" id="btn_sort" >顺序调整</button>
	</div>
	<div class="row">
		<table id="userGroup-table" style="font-size: 13px !important;">
		</table>
	</div>
</div>
<div id="userGroup_page"></div>

<%@ include file="/common_foot.jsp"%>
<script src="<%=path%>/sys/userGroup/index.js?v=<%=vardate%>"></script>
<%@ include file="/sys/sort/sort.jsp"%>