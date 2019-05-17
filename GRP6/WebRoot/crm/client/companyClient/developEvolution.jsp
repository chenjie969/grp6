<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/crm/client/companyClient/companyClientHead.jsp"%>

	<h4 class="header smaller lighter blue">
		企业发展沿革
		<button type="button" name="button" class="btn btn-minier btn-warning pull-right"  id="btn_developEvolutionEdit">
			<i class="icon-edit bigger-110"></i>
			<span class="bigger-110 no-text-shadow">修改</span>
		</button>
	</h4>
	<br>
	<div class="row" style="margin:0;">
		<pre id="developEvolution" class="col-xs-12" style="white-space: pre-wrap;"></pre>
	</div>

<%-- <%@ include file="/crm/client/companyClient/developEvolutionEdit.jsp"%> 
	如果在这里引入修改页面，弹出后会全部变成灰色并且不能编辑，需要在外层页面引入 --%> 

<script src="<%=path %>/crm/client/companyClient/developEvolution.js?v=<%=vardate%>"></script>
