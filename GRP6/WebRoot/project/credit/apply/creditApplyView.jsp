<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>

	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<h4 class="col-sm-12 header smaller lighter blue">授信申请信息 </h4>
				<div class="col-sm-offset-1 col-sm-10">
					<h5 class="col-sm-6" style="line-height:26px;">授信客户类型：<span class="grey">${empty creditApply.relationID ? "企业客户":"集团/关联客户" }</span></h5>
					<h5 class="col-sm-6" style="line-height:26px;">授信编号：<span class="grey">${creditApply.busiCode}</span></h5>
					<h5 class="col-sm-6" style="line-height:26px;">授信客户名称：<span class="grey">${creditApply.clientName}</span></h5>
					<h5 class="col-sm-6" style="line-height:26px;">授信项目名称：<span class="grey">${creditApply.projectName }</span></h5>
					<h5 class="col-sm-6" style="line-height:26px;">授信项目类型：<span class="grey">${empty creditApply.creditTypeName ? "（空）":creditApply.creditTypeName}</span></h5>
					<h5 class="col-sm-6" style="line-height:26px;">授信总额度：<span class="grey"><fmt:formatNumber value="${creditApply.applySum }" pattern="###,###.######"/>万元</span></h5>
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
									<th>授信额度（万元）</th>
									<th>合作机构 </th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${creditApply.detailList }" var="applyDetail">
									<tr>
										<td>${applyDetail.busiTypeName }</td>
										<td><fmt:formatNumber value="${applyDetail.applySum }" pattern="###,###.######"/></td>
										<td>${applyDetail.bankName }</td>
									</tr>
								</c:forEach>
							</tbody>	
						</table>
					</c:if>
					<h5 class="col-sm-6" style="line-height:26px;">经办部门：<span class="grey">${creditApply.departName }</span></h5>
					<h5 class="col-sm-6" style="line-height:26px;">经办人：<span class="grey">${creditApply.createManName }</span></h5>
					<h5 class="col-sm-6" style="line-height:26px;">受理日期：<span class="grey"><fmt:formatDate value="${creditApply.createDate }" pattern="yyyy-MM-dd" type="date"/></span></h5>
				</div>
				
				<c:if test="${not empty creditProjectApply }">
					<h4 class="col-sm-12 header smaller lighter blue">授信项下项目申请信息</h4>
					<div class="col-sm-offset-1 col-sm-10">
						<h5 class="col-sm-6" style="line-height:26px;">业务性质：<span class="grey">${creditProjectApply.detailList[0].busiNatureName }</span></h5>
						<h5 class="col-sm-6" style="line-height:26px;">项目类型：<span class="grey">${creditProjectApply.detailList[0].projectTypeName }</span></h5>
						<h5 class="col-sm-6" style="line-height:26px;">客户名称：<span class="grey">${creditProjectApply.detailList[0].clientName }</span></h5>
						<h5 class="col-sm-6" style="line-height:26px;">项目名称：<span class="grey">${creditProjectApply.projectName }</span></h5>
						<h5 class="col-sm-6" style="line-height:26px;">项目编号：<span class="grey">${creditProjectApply.busiCode }</span></h5>
						<h5 class="col-sm-6" style="line-height:26px;">项目来源：<span class="grey">${empty creditProjectApply.detailList[0].projectSourceName ? "（空）":creditProjectApply.detailList[0].projectSourceName}</span></h5>
						<h5 class="col-sm-12" style="line-height:26px;">来源说明：<span class="grey">${empty creditProjectApply.detailList[0].sourceDesc ? "（空）":creditProjectApply.detailList[0].sourceDesc}</span></h5>
						<h5 class="col-sm-6" style="line-height:26px;">业务品种：<span class="grey">${creditProjectApply.detailList[0].busiTypeName }</span></h5>
						<h5 class="col-sm-6" style="line-height:26px;">绿色通道：<span class="grey">${empty creditProjectApply.detailList[0].greenChannelName ? "（空）":creditProjectApply.detailList[0].greenChannelName}</span></h5>
						<h5 class="col-sm-6" style="line-height:26px;">申请金额：<span class="grey"><fmt:formatNumber value="${creditProjectApply.detailList[0].applySum }" pattern="###,###.######"/>万元</span></h5>
						<h5 class="col-sm-6" style="line-height:26px;">申请期限：<span class="grey">${creditProjectApply.detailList[0].periodMonthDay }</span></h5>
					 	<h5 class="col-sm-6" style="line-height:26px;">合作机构：<span class="grey">${empty creditProjectApply.detailList[0].bankName ? "（空）":creditProjectApply.detailList[0].bankName}</span></h5>
						<h5 class="col-sm-12" style="line-height:26px;">贷款(担保)用途：<span class="grey">${empty creditProjectApply.detailList[0].loadUsed ? "（空）":creditProjectApply.detailList[0].loadUsed}</span></h5>
						<h5 class="col-sm-12" style="line-height:26px;">还款计划和来源：<span class="grey">${empty creditProjectApply.detailList[0].repaymentPlan ? "（空）":creditProjectApply.detailList[0].repaymentPlan}</span></h5>
						<h5 class="col-sm-12" style="line-height:26px;">拟提供的保证措施：<span class="grey">${empty creditProjectApply.detailList[0].provideGuaranty ? "（空）":creditProjectApply.detailList[0].provideGuaranty}</span></h5>
						<h5 class="col-sm-12" style="line-height:26px;">备注：<span class="grey">${empty creditProjectApply.detailList[0].otherDesc ? "（空）":creditProjectApply.detailList[0].otherDesc}</span></h5>
					</div>
				</c:if>
			</div><!-- /.col -->
		</div><!-- /.row -->	
	</div><!-- /.page-content -->
	
<%@ include file="/common_message.jsp" %>
<%@ include file="/project/credit/apply/clientList.jsp" %>
<%@ include file="/common_foot.jsp" %>
