<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<%@ include file="/common_head.jsp"%>
<link href="<%=path%>/plugins/qtip/jquery.qtip.min.css?v=<%=vardate%>" rel="stylesheet" type="text/css" />
<%@ include file="/common_foot.jsp"%>
<div class="page-content">
	<!--begin页面内容  -->
	<!-- /.page-header end 页头部分-->
	<c:if test="${pendingWorkFlow.flowType!='04'}">
		<div class="col-sm-12 space-20"></div>
		<div class="col-sm-12">
			<c:forEach items="${componentList}" var="componentInfo" varStatus="status">
					<input type="hidden" class="btn_taskForm"
					href-data="${componentInfo.editAction}"
					projectID="${pendingWorkFlow.projectID}"
					businessId="${pendingWorkFlow.businessId}"
					businessType="${pendingWorkFlow.businessType}"
					flowType="${pendingWorkFlow.flowType}"
					stepName="${pendingWorkFlow.stepName}"
					stepID="${pendingWorkFlow.stepID}"
					type="edit"
					flowID="${pendingWorkFlow.flowID}"
					componentName="${componentInfo.componentName}"
					/>
			</c:forEach>
			<!-- PAGE CONTENT BEGINS -->
			<div id="loadFormInfoPage"></div>
			<!-- PAGE CONTENT ENDS -->
		</div>
	</c:if>
</div>
<!-- /.page-content -->
&nbsp;<br/>&nbsp;<br/>&nbsp;<br/>
&nbsp;<br/>&nbsp;<br/>&nbsp;<br/>
<div class="modal-footer" style="left: 0; position: fixed; bottom: 0; width: 100%; z-index: 100;">
	<div class="col-sm-4">
		<select class="col-xs-10 col-sm-11 " id="actionID">
			<option>-请选择流程走向-</option>
			<c:forEach items="${osactionList}" var="osaction" varStatus="status">
				<c:if test="${!fn:contains(osaction.view,'555')}"> 
					<option value="${osaction.actionID }">
						${osaction.actionName}
					</option>
				</c:if>
			</c:forEach>
		</select>
	</div>
	<div class="col-sm-8">
		<button class="btn btn-prev" style="float: right; margin-left: 5px;" id="btn_taskStop">
			<i class="icon-power-off"></i>提前终止
		</button>
		<!-- <button class="btn btn-prev" style="float: right;" id="btn_taskReturn">
			<i class="icon-arrow-left"></i>退回
		</button> -->
		<button class="btn btn-success" style="float: right;" id="btn_ostaskTransact">
			<i class="icon-arrow-right"></i>办结,提交下一步
		</button>
		<button class="btn btn-success" style="float: right;" id="btn_ostaskSugget">
			<i class="icon-arrow-right"></i>填写意见
		</button>
	</div>



</div>


<div id="transact_page"></div>
<script src="<%=path%>/plugins/qtip/jquery.qtip.pack.js?v=<%=vardate%>"></script>
<script src="<%=path%>/gworkFlow/transactIndex.js?v=<%=vardate%>"></script>
<%@ include file="/common_message.jsp"%>