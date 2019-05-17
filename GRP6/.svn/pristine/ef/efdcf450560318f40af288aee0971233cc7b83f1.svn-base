<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<style>
	table.table_busiLimit{
		font-size:13px;
		border:1px solid #ddd;
		table-layout:fixed
	}
	table.table_busiLimit tr th,td{
		border:1px solid #ddd;
		text-align: center;
		vertical-align:middle
	};
</style>	
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
                <div class="row">
					<div class="col-sm-12">
						<h4 class="col-sm-12 header smaller lighter blue">授信项信息 </h4>
						<div class="col-sm-offset-1 col-sm-10">
							<h5 class="col-sm-6" style="line-height:26px;">授信客户类型：<span class="grey">${empty creditApply.relationID ? "企业客户":"集团/关联客户" }</span></h5>
							<h5 class="col-sm-6" style="line-height:26px;">授信编号：<span class="grey">201707050001</span></h5>
							<h5 class="col-sm-6" style="line-height:26px;">授信客户名称：<span class="grey">${creditApply.clientName}</span></h5>
							<h5 class="col-sm-6" style="line-height:26px;">授信项目名称：<span class="grey">${creditApply.projectName }</span></h5>
							<h5 class="col-sm-6" style="line-height:26px;">授信项目类型：<span class="grey">${empty creditApply.creditTypeName ? "（空）":creditApply.creditTypeName}</span></h5>
							<h5 class="col-sm-6" style="line-height:26px;">授信总额度：<span class="grey"><fmt:formatNumber value="${creditApply.agreeSum }" pattern="###,###.######"/>万元</span></h5>
							<h5 class="col-sm-6" style="line-height:26px;">已用额度：<span class="grey"><fmt:formatNumber value="${creditApply.usedSum }" pattern="###,###.######"/>万元</span></h5>
							<h5 class="col-sm-6" style="line-height:26px;">可用额度：<span class="grey"><fmt:formatNumber value="${creditApply.agreeSum-creditApply.usedSum }" pattern="###,###.######"/>万元</span></h5>
							<h5 class="col-sm-6" style="line-height:26px;">授信起始日期：<span class="grey">
								<c:choose>
									<c:when test="${empty creditApply.creditBeginDate }">（空）</c:when>
									<c:otherwise><fmt:formatDate value="${creditApply.creditBeginDate }" pattern="yyyy-MM-dd" type="date"/></c:otherwise>
								</c:choose>
							</span></h5>
							<h5 class="col-sm-6" style="line-height:26px;">授信结束日期：<span class="grey">
								<c:choose>
									<c:when test="${empty creditApply.creditEndDate }">（空）</c:when>
									<c:otherwise><fmt:formatDate value="${creditApply.creditEndDate }" pattern="yyyy-MM-dd" type="date"/></c:otherwise>
								</c:choose>
							</span></h5>	
							<h5 class="col-sm-6" style="line-height:26px;">循环使用授信额度：<span class="grey">${creditApply.isLoopCredit==1 ? "是":"否" }</span></h5>
							<h5 class="col-sm-6" style="line-height:26px;">限制品种与合作机构：<span class="grey">${creditApply.isBusiLimit==1 ? "是":"否" }</span></h5>
							<c:if test="${not empty creditApply.isBlend }">
								<h5 class="col-sm-6" style="line-height:26px;">是否额度混用：<span class="grey">${creditApply.isBlend==1 ? "是":"否" }</span></h5>
							</c:if>
							<c:if test="${not empty creditApply.detailList }">
								<h5 class="col-sm-12">业务品种与合作机构明细：</h5>
								<table class="table table-hover table-striped table_busiLimit">
						 			<thead>
										<tr>
											<th>业务品种</th>
											<th>合作机构 </th>
											<th>授信额度（万元）</th>
											<c:if test="${creditApply.isBlend==0 }">
												<th>已用额度（万元）</th>
												<th>可用额度（万元）</th>
											</c:if>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${creditApply.detailList }" var="applyDetail">
											<tr>
												<td>${applyDetail.busiTypeName }</td>
												<td>${applyDetail.bankName }</td>
												<td><fmt:formatNumber value="${applyDetail.agreeSum }" pattern="###,###.######"/></td>
												<c:if test="${creditApply.isBlend==0 }">
													<td><fmt:formatNumber value="${applyDetail.usedSum }" pattern="###,###.######"/></td>
													<td><fmt:formatNumber value="${applyDetail.agreeSum-applyDetail.usedSum }" pattern="###,###.######"/></td>
												</c:if>
											</tr>
										</c:forEach>
									</tbody>	
								</table>
							</c:if>
							<h5 class="col-sm-6" style="line-height:26px;">经办部门：<span class="grey">${creditApply.departName }</span></h5>
							<h5 class="col-sm-6" style="line-height:26px;">经办人：<span class="grey">${creditApply.createManName }</span></h5>
							<h5 class="col-sm-6" style="line-height:26px;">受理日期：<span class="grey"><fmt:formatDate value="${creditApply.createDate }" pattern="yyyy-MM-dd" type="date"/></span></h5>
						</div>
					</div>
					
					<div class="col-sm-12">
						<input type="hidden" value="${creditApply.apply_ID }" id="hidden_applyID">
						<h4 class="col-sm-12 header smaller lighter blue">用款明细</h4>
						<div class="table-responsive col-sm-12">
							<table id="table_fundsDetail" style="font-size:13px !important;"></table>  
				   		</div>
					</div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->

<div id="fundsDetail_page"></div>

<%@ include file="/common_message.jsp" %>
<%@ include file="/common_foot.jsp" %>

<script src="<%=path %>/project/credit/manager/fundsDetail.js?v=<%=vardate%>"></script>

	