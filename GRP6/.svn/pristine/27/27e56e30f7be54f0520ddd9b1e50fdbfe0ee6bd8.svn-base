<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>

<div class="modal fade bs-example-modal-sm" id="costPreToFact" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
    <!-- 收入确认页面 -->
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">收入确认</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal " role="form" id="" >
		       
		       <input type="hidden" id="costPre_ID" value="${costPre.costPre_ID}">
		       
             <h4 class="header smaller lighter blue" style="text-align: right;">
				<button type="button" class="btn btn-sm btn-info" id="btn_changeCostPreToPlan" >调整收入计划</button> 
			</h4>  
			
			<table class="table table-striped table-bordered table-hover" style="border:1px solid #ddd;">
				<thead>
					<tr>
						<th>期次</th>
						<th>确认收入金额（元）</th>
						<th>计划收入日期</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
							<c:forEach items="${costFactList}" var="costFact" varStatus="costFactStatus">
							<tr>
								<td>
									  ${costFactStatus.index+1}
								</td>
								<td>
									<fmt:formatNumber value="${costFact.factCostSum}" pattern="###,###.##"/>
								</td>
								<td>
									<fmt:formatDate value="${costFact.planFactCostDate}" pattern="yyyy-MM-dd" type="date"/>
								</td>
								<td>
								   ${costFact.costFactState}
								</td>
								<td>
								   <a href="javascript:void(0)" id="${costFact.costFact_ID}"  class="btn_updateCostFact">修改</a>
								   <a href="javascript:void(0)" id="${costFact.costFact_ID}"  class="btn_deleteOneCostFact">删除</a>
								   <c:if test="${costFact.costFactState eq '未确认'}" >
							         <a href="javascript:void(0) " id="${costFact.costFact_ID}" class="btn_changeCostFact">到账确认</a>
							       </c:if>
								   <c:if test="${costFact.costFactState eq '已确认'}" >
							         <span>到账确认</span>
							       </c:if>
								  
								   
								   
								</td>
							</tr>
					 	</c:forEach>
					 		<tr>
								<td>
									  小计
								</td>
								<td colspan="4">
								    <fmt:formatNumber value="${costPre.preCostSum}" pattern="###,###.##"/>
								</td>
								
								
							</tr>
						
				</tbody>
			</table>          
           	
		</form>
      </div>
      <div class="modal-footer" align="center">
       <!--  <button type="button" class="btn btn-primary btn_submit" > <i class='icon-ok bigger-110'></i>保存</button> -->
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
<%@ include file="/common_del.jsp" %>
<script src="<%=path%>/project/cost/costPreToCostFact.js?v=<%=vardate%>"></script>
