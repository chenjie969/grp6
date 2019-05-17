<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<div class="page-content">
	<div class="row"> <!-- style="display: block" -->
		<div class="col-xs-12">
			<div class="tabbable">
				<ul class="nav nav-tabs" id="myTab">
					<li class="active"><a data-toggle="tab" href="#ok" id="projectList">项目列表</a></li>

					<li><a data-toggle="tab" href="#no" id="approvalRecord">审批记录</a></li>
				</ul>
				<div class="tab-content">
					<div id="ok" class="tab-pane in active">
						<%-- <c:if test="${urlParam.type eq 'edit' }"> --%>
							<div class="page-header">
								<button class="btn btn-sm btn-info" id="btn_addApproval">新增审批</button>
								<c:if test="${sessionUser.isAdmin==1}">
								<button class="btn btn-sm btn-info" id="btn_removeKeyProject">移出重点项目</button>
								</c:if>
								<button type="button" name="button" class="btn btn-sm btn-info" id="btn_hightSelect" >高级查询</button>
							</div>
						<%-- </c:if> --%>
						<div class="table-responsive" id="projectList">
							<table id="projectList_table" style="font-size: 13px !important;"></table>
						</div>
					</div>
					
					<div id="no" class="tab-pane">
					<!-- 在这里 在这里 在这里 在这里 在这里 在这里 在这里 在这里-->
							<div class="page-header">
								<button class="btn btn-sm btn-info" id="btn_startApproval">启动流程</button>
							</div>
						<div class="table-responsive" id="approvalRecord">
							<table id="approvalRecord_table" style="font-size: 13px !important;"></table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div><!-- /.row -->
</div><!-- /.page-content -->

<div id="keyProject_page"></div>
<div id="page_relationProject"></div>
<div id="approvalRecord_page"></div>
<div id="nodeTaskModal_page"></div>

<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_confirm.jsp" %>
<%@ include file="/common_message.jsp" %>
<%@ include file="/project/riskResponse/keyProject/selectProductModal.jsp" %><!-- 启动流程-选择流程页面 -->
<%@ include file="/project/riskResponse/keyProject/hightSelectkeyProject.jsp" %>	<!-- 高级查询 -->
<script src="<%=path%>/project/setNodeTask/nodeTaskModal.js?v=<%=vardate%>"></script>
<script src="<%=path%>/project/riskResponse/keyProject/keyProject.js?v=<%=vardate%>"></script>