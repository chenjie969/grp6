<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/common_timestamp.jsp" %>
<style>
	table{
		font-size:13px;
		text-align: center;
	}
	table tr th,table tr td{
		border:1px solid #ddd;
		text-align: center;
	};
	
</style>
<div class="page-content">
	<div class="page-header">
		<h4>担保收费</h4>
	</div>
	<div class="row">
		<input type="hidden" id="hidden_applyID" value="${urlParam.entityID }">
		<input type="hidden" id="openType" value="${urlParam.type }">
		<c:forEach items="${meetingDetailList}" var="meetingDetail">
			<div class="col-xs-12">
				<div class="widget-box transparent">
					<div class="widget-header widget-header-flat">
						<h4 class="smaller lighter orange">${meetingDetail.busiTypeName} | <fmt:formatNumber value="${meetingDetail.agreeSum}" pattern="###,###.######"/>万元 | ${meetingDetail.periodMonthDay}| ${meetingDetail.bankName}</h4>
						<div class="widget-toolbar" style="height:37px;">
							<a href="javascript:void(0)"  data-action="collapse" style="margin-top:10px;"><i class="icon-chevron-up"></i></a>
						</div>
					</div>
					<div class="widget-body">
						<div class="widget-body-inner" style="display: block;">
							<div class="widget-main no-padding">
								<h5 style="line-height: 26px;" class="col-sm-6 no-margin-top">业务品种：<span class="grey">${meetingDetail.busiTypeName}</span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6 no-margin-top">合作机构：<span class="grey">${meetingDetail.bankName}</span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6 no-margin-top">同意放款金额：<span class="grey"><fmt:formatNumber value="${meetingDetail.agreeSum}" pattern="###,###.######"/>万元</span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6 no-margin-top">同意期限：<span class="grey">${meetingDetail.periodMonthDay}</span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6 no-margin-top">担保责任范围：<span class="grey">${meetingDetail.guarantyScope} ${meetingDetail.guarantyScale}%</span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6 no-margin-top">责任金额：<span class="grey">
									<c:choose>
										<c:when test="${empty meetingDetail.guarantyDutySum}">（空）</c:when>
										<c:otherwise><fmt:formatNumber value="${meetingDetail.guarantyDutySum}" pattern="###,###.######"/>万元</c:otherwise>
									</c:choose></span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6 no-margin-top">评审费率：<span class="grey">
									<c:choose>
										<c:when test="${empty meetingDetail.reviewRate}">（空）</c:when>
										<c:otherwise><fmt:formatNumber value="${meetingDetail.reviewRate}"  pattern="###,###.######"/>‰</c:otherwise>
									</c:choose></span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6 no-margin-top">担保费率：<span class="grey">
									<c:choose>
										<c:when test="${empty meetingDetail.guarantyRate}">（空）</c:when>
										<c:otherwise><fmt:formatNumber value="${meetingDetail.guarantyRate}"  pattern="###,###.######"/>%</c:otherwise>
									</c:choose></span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6 no-margin-top">保证金比例：<span class="grey">
									<c:choose>
										<c:when test="${empty meetingDetail.bzScale}">（空）</c:when>
										<c:otherwise><fmt:formatNumber value="${meetingDetail.bzScale}"  pattern="####,###.######"/>%</c:otherwise>
									</c:choose></span></h5>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-12">
				<div class="widget-box transparent">
					<div class="widget-header widget-header-flat">
						<h4 class="smaller lighter orange">担保收费</h4>
						<div class="widget-toolbar" style="height:37px;">
							<a href="javascript:void(0)"  data-action="collapse" style="margin-top:10px;"><i class="icon-chevron-up"></i></a>
						</div>
					</div>
					<div class="widget-body">
						<div class="widget-body-inner" style="display: block;">
							<div class="widget-main no-padding">
								<c:choose>
									<c:when test="${empty meetingDetail.loanPlanList }">
										<h5 style="line-height: 26px;" class="col-sm-12"><span class="grey">当前无记录</span></h5>
									</c:when>
									<c:otherwise>
										<c:forEach items="${meetingDetail.loanPlanList }" var="loanPlan" varStatus="status">
											<div class="widget-box">
												<div class="widget-header">
													<h5>放款计划： 第${status.index+1 }笔</h5>
												</div>
												<div class="widget-body" style="border:1px solid #ccc;">
													<div class="widget-main">
														<div class="row">
															<h5 style="line-height: 26px;" class="col-sm-6">计划放款金额：<span class="grey"><fmt:formatNumber value="${loanPlan.loanSum }" pattern="###,###.######"/></span>万元</h5>
															<h5 style="line-height: 26px;" class="col-sm-6">期限：<span class="grey">${loanPlan.periodMonthDay }</span></h5>
															<h5 style="line-height: 26px;" class="col-sm-6">年利率：<span class="grey">${loanPlan.interestRate }</span>％</h5>
															<h5 style="line-height: 26px;" class="col-sm-6">计划放款日期：<span class="grey"><fmt:formatDate value="${loanPlan.loanDate }" pattern="yyyy-MM-dd" type="date"/></span></h5>
														</div>
													</div>
												</div>
												<div class="widget-header">
													<h5>还款计划： 第${status.index+1 }笔</h5>
												</div>
												<div class="widget-body" style="border:1px solid #ccc;">
													<div class="widget-main">
														<c:choose>
															<c:when test="${empty loanPlan.planPayList }">
																<div class="row">
																	<h5 style="line-height: 26px;text-align:center;" class="col-sm-12"><span class="grey">当前无记录</span></h5>
																</div>
															</c:when>
															<c:otherwise>
																<table class="table table-striped table-bordered table-hover" style="border:1px solid #ddd;">
																	<thead>
																		<tr>
																			<!-- <th>计划还款日期</th> -->
																			<th>放款后第n个月</th>
																			<th>计划还款金额（万元）</th>
																		</tr>
																	</thead>
																	<tbody>
																		<c:set var="totalPlanPaySum" value="0"></c:set>
																		<c:forEach items="${loanPlan.planPayList }" var="planPay" varStatus="status">
																			<tr>
																				<td>${planPay.planPayMonth }</td>
																				<td><fmt:formatNumber value="${planPay.planPaySum }" pattern="###,###.######"/></td>
																			</tr>
																			<c:set var="totalPlanPaySum" value="${totalPlanPaySum + planPay.planPaySum}"></c:set>
																		</c:forEach>
																		<tr>
																			<th>计划还款小计：</th>
																			<th><fmt:formatNumber value="${totalPlanPaySum }" pattern="###,###.######"/></th>
																		</tr>
																	</tbody>
																</table>
															</c:otherwise>
														</c:choose>
													</div>
												</div>
												<div class="widget-header">
													<h5>应收费用： 第${status.index+1 }笔</h5>
													<c:if test="${urlParam.type == 'edit'}">
														<div class="widget-toolbar" style="height:37px;">
															<a href="javascript:void(0)" style="margin-right:10px;line-height:37px;display:block;text-decoration:none;"  class="pull-right btn_addCostMust" 
																data-loanPlanID="${loanPlan.loanPlan_ID }" data-meetingDetailID="${meetingDetail.meetingDetail_ID }">
																<i class="icon-edit bigger-110 orange" ></i>
																<span class="bigger-110 no-text-shadow orange">添加应收费用</span>
															</a>
														</div>	
													</c:if>
												</div>
												<div class="widget-body" style="border:1px solid #ccc;">
													<div class="widget-main">
														<c:choose>
															<c:when test="${empty loanPlan.costMustList }">
																<div class="row">
																	<h5 style="line-height: 26px;text-align:center;" class="col-sm-12"><span class="grey">当前无记录</span></h5>
																</div>
															</c:when>
															<c:otherwise>
																<table class="table table-striped table-bordered table-hover" style="border:1px solid #ddd;" id="table_planPay_${loanPlan.loanPlan_ID }">
																	<thead>
																		<tr>
																			<th>费用类型</th>
																			<th>费率</th>
																			<th>应收金额（元）</th>
																			<c:if test="${urlParam.type == 'edit'}">
																				<th>操作</th>
																			</c:if>
																		</tr>
																	</thead>
																	<tbody>
																		<c:forEach items="${loanPlan.costMustList }" var="costMust" varStatus="status">
																			<tr>
																				<td>${costMust.costName }</td>
																				<td>${costMust.costRate }${costMust.costUnit }</td>
																				<td><fmt:formatNumber value="${costMust.mustCostSum }" pattern="###,###.######"/></td>
																				<c:if test="${urlParam.type == 'edit'}">
																					<td>
																						<button class="btn btn-xs btn-info btn_editCostMust" href="javascript:void(0)" title="修改" data-costMustID="${costMust.costMust_ID }" data-meetingDetailID="${meetingDetail.meetingDetail_ID }"><i class="icon-pencil bigger-120"></i></button>
																						<button class="btn btn-xs btn-danger btn_delCostMust" href="javascript:void(0)" title="删除" data-costMustID="${costMust.costMust_ID }"><i class="icon-trash bigger-120"></i></button>
																					</td>
																				</c:if>
																			</tr>
																		</c:forEach>
																	</tbody>
																</table>
															</c:otherwise>
														</c:choose>
													</div>
												</div>
											</div>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</div>
				<div class="space-16"></div>
			</div>
		</c:forEach>
	</div>
</div>
<div id="page_costMust"></div>
<%@ include file="/common_del.jsp" %>

<script src="<%=path %>/project/costMust/costMust.js?v=<%=vardate%>"></script>

							
									
									