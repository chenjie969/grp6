<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<style>
	table{
	font-size:13px;
	text-align:center;
	}
	table tr th{
	border:1px solid #ddd;
	text-align: center;
	};
	table tr td{
	border:1px solid #ddd;
	text-align: center;
	};
</style>
<%@ include file="/common_timestamp.jsp" %>
<div class="page-content">
	<div class="page-header">
		<h4>收费登记</h4>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<input type="hidden" id="hidden_applyID" value="${urlParam.entityID}">
            <input type="hidden" id="openType" value="${urlParam.type}">
			<c:forEach items="${meetingDetailList}" var="meetingDetail">
				<div class="widget-box transparent">
					<div class="widget-header widget-header-flat">
						<h4 class="smaller lighter orange">${meetingDetail.busiTypeName} | <fmt:formatNumber value="${meetingDetail.agreeSum}" pattern="###,###.######"/>万元 | ${meetingDetail.periodMonth}个月${meetingDetail.periodMonth}天| ${meetingDetail.bankName}</h4>
						<div class="widget-toolbar" style="height:37px;">
							<a href="#" data-action="collapse" style="margin-top:10px;"><i class="icon-chevron-up"></i></a>
						</div>
					</div>
					<div class="widget-body">
						<div class="widget-body-inner" style="display: block;">
							<div class="widget-main no-padding">
								<h5 style="line-height: 26px;" class="col-sm-6 no-margin-top">业务品种：<span class="grey">${meetingDetail.busiTypeName}</span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6 no-margin-top">合作机构：<span class="grey">${meetingDetail.bankName}</span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6 no-margin-top">同意放款金额：<span class="grey"><fmt:formatNumber value="${meetingDetail.agreeSum}" pattern="###,###.######"/></span>万元</h5>
								<h5 style="line-height: 26px;" class="col-sm-6 no-margin-top">同意期限：<span class="grey">${meetingDetail.periodMonthDay}</span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6 no-margin-top">担保责任范围：<span class="grey">${meetingDetail.guarantyScope}</span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6 no-margin-top">责任金额：<span class="grey"><fmt:formatNumber value="${meetingDetail.guarantyDutySum}" pattern="###,###.######"/></span>万元</h5>
								<h5 style="line-height: 26px;" class="col-sm-6 no-margin-top">评审费率：<span class="grey"><fmt:formatNumber value="${meetingDetail.reviewRate}" pattern="###,###.######"/></span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6 no-margin-top">担保费率：<span class="grey"><fmt:formatNumber value="${meetingDetail.guarantyRate}" pattern="###,###.######"/></span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6 no-margin-top">保证金比例：<span class="grey"><fmt:formatNumber value="${meetingDetail.bzScale}" pattern="###,###.######"/></span></h5>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-12">
				<div class="widget-box transparent">
					<div class="widget-header widget-header-flat">
						<h4 class="smaller lighter orange">财务收费确认</h4>
						<div class="widget-toolbar" style="height:37px;">
							<a href="#" data-action="collapse" style="margin-top:10px;"><i class="icon-chevron-up"></i></a>
						</div>
						<%-- <a style="margin-right:10px;line-height:37px;display:block;text-decoration:none;" href="#" class="pull-right btn_addLoanPlan" data-meetingDetailID="${meetingDetail.meetingDetail_ID }">
							<i class="icon-edit bigger-110 orange" ></i>
							<span class="bigger-110 no-text-shadow orange">添加放款计划</span>
						</a> --%>
					</div>
					<div class="widget-body">
						<div class="widget-body-inner" style="display: block;">
							<div class="widget-main no-padding">
								<c:choose>
									<c:when test="${empty meetingDetail.loanPlanList}">
										<h5 style="line-height: 26px; text-align: center;" class="col-sm-12"><span class="grey">当前无记录</span></h5>
									</c:when>
									<c:otherwise>
										<c:forEach items="${meetingDetail.loanPlanList}" var="loanPlan" varStatus="loanPlanStatus">
											<div class="widget-box">
												<div class="widget-header">
													<h5>放款计划： 第${loanPlanStatus.index+1}笔</h5>
												</div>
												<div class="widget-body" style="border:1px solid #ccc;">
													<div class="widget-main">
														<div class="row">
															<h5 style="line-height: 26px;" class="col-sm-6">计划放款金额：<span class="grey"><fmt:formatNumber value="${loanPlan.loanSum}" pattern="###,###.######"/></span>万元</h5>
															<h5 style="line-height: 26px;" class="col-sm-6">期限：<span class="grey">${loanPlan.periodMonthDay}</span></h5>
															<h5 style="line-height: 26px;" class="col-sm-6">年利率：<span class="grey"><fmt:formatNumber value="${loanPlan.interestRate}" pattern="###,###.######"/></span>％</h5>
															<h5 style="line-height: 26px;" class="col-sm-6">计划放款日期：<span class="grey"><fmt:formatDate value="${loanPlan.loanDate}" pattern="yyyy-MM-dd" type="date"/></span></h5>
														</div>
													</div>
												</div>
												<div class="widget-header">
													<h5>还款计划： 第${loanPlanStatus.index+1}笔</h5>
												</div>
												<div class="widget-body" style="border:1px solid #ccc;">
													<div class="widget-main">
															<c:choose>
																<c:when test="${empty loanPlan.planPayList}">
																   <div class="row">
																	<h5 style="line-height: 26px;text-align: center;" class="col-sm-12"><span class="grey">当前无记录</span></h5>
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
																			<c:forEach items="${loanPlan.planPayList}" var="planPay" varStatus="status">
																				<tr>
																					<%-- <td><fmt:formatDate value="${planPay.planPayDate}" pattern="yyyy-MM-dd" type="date"/></td> --%>
																					<td>${planPay.planPayMonth }</td>
																					<td>
																					<fmt:formatNumber value="${planPay.planPaySum}" pattern="###,###.######"/>
																					</td>
																				</tr>
																			</c:forEach>
																		</tbody>
																	</table>
																</c:otherwise>
															</c:choose>
													</div>
												</div>
												<!-- 应收费用--start -->
												<div class="widget-header">
													<h5>应收费用： 第${loanPlanStatus.index+1}笔</h5>
												</div>
												<div class="widget-body" style="border:1px solid #ccc;">
													<div class="widget-main">
															<c:choose>
																<c:when test="${empty loanPlan.costMustList}">
																	<h5 style="line-height: 26px;text-align: center;" class="col-sm-12"><span class="grey">当前无记录</span></h5>
																</c:when>
																<c:otherwise>
																	<table class="table table-striped table-bordered table-hover" style="border:1px solid #ddd;">
																		<thead>
																			<tr>
																				<th>序号</th>
																				<th>费用类型</th>
																				<th>费率</th>
																				<th>应收金额（元）</th>
																				<th>状态</th>
																				 <c:if test="${urlParam.type eq 'edit'}" >
																				    <th>操作</th>
																				  </c:if>
																				
																				
																			</tr>
																		</thead>
																		<tbody>
																			<c:forEach items="${loanPlan.costMustList}" var="costMust" varStatus="costMustStatus">
																				<tr>
																					<td>${costMustStatus.index+1}</td>
																					<td>${costMust.costName}</td>
																					<td><fmt:formatNumber value="${costMust.costRate}" pattern="###,###.######"/>${costMust.costUnit}</td>
																					<td><fmt:formatNumber value="${costMust.mustCostSum}" pattern="###,###.##"/></td>
																					<td>${costMust.costMustState}</td>
																					
																					 <c:if test="${urlParam.type eq 'edit'}" >
																					      <td>
																						    <c:if test="${costMust.costMustState eq '未收到'}" >
																						         <a href="javascript:void(0)" id="${costMust.costMust_ID}" class="btn_costMustToPre">到账确认</a>
																						    </c:if>
																							<c:if test="${costMust.costMustState eq '已收到'}" >
																						         <span class="gery">到账确认</span>
																						    </c:if>
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
												<!-- 应收费用--end -->
												
												<!-- 预收费用--start -->
												<div class="widget-header">
													<h5>预收费用： 第${loanPlanStatus.index+1}笔</h5>
												</div>
												<div class="widget-body" style="border:1px solid #ccc;">
													<div class="widget-main">
															<c:choose>
																<c:when test="${empty loanPlan.costPreList}">
																 <div class="row">
																	<h5 style="line-height: 26px; text-align: center;" class="col-sm-12"><span class="grey">当前无记录</span></h5>
																</div>
																</c:when>
																<c:otherwise>
																	<table class="table table-striped table-bordered table-hover" style="border:1px solid #ddd;">
																		<thead>
																			<tr>
																				<th>序号</th>
																				<th>费用类型</th>
																				<th>费率</th>
																				<th>预收金额（元）</th>
																				<th>状态</th>
																				 <c:if test="${urlParam.type eq 'edit'}" >
																				    <th>操作</th>
																				 </c:if>
																				
																			</tr>
																		</thead>
																		<tbody>
																			<c:forEach items="${loanPlan.costPreList}" var="costPre" varStatus="costPreStatus">
																				<tr>
																					<td>${costPreStatus.index+1}</td>
																					<td>${costPre.costTypeName}</td>
																					<td><fmt:formatNumber value="${costPre.costRate}" pattern="###,###.######"/>${costPre.costUnit}</td>
																					<td><fmt:formatNumber value="${costPre.preCostSum}" pattern="###,###.##"/></td>
																					<td>${costPre.costPreState}</td>
																					
																					 <c:if test="${urlParam.type eq 'edit'}" >
																						     <td>
																							    <a href="javascript:void(0) " id="${costPre.costPre_ID}"  class="btn_costPreToCostMust">撤销</a>
																							    <c:if test="${costPre.costPreState eq '未确认到账'}" >
																							         <a href="javascript:void(0) " id="${costPre.costPre_ID}" class="btn_costPreToCostFact">到账确认</a>
																							    </c:if>
																								<c:if test="${costPre.costPreState eq '已确认到账'}" >
																							         <span class="gery">到账确认</span>
																							    </c:if>
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
												<!-- 预收费用--end -->
												<!-- 实收费用  --start -->
												<div class="widget-header">
													<h5>实收费用： 第${loanPlanStatus.index+1}笔</h5>
												</div>
												<div class="widget-body" style="border:1px solid #ccc;">
													<div class="widget-main">
															<c:choose>
																<c:when test="${empty loanPlan.costFactList}">
																 <div class="row">
																	<h5 style="line-height: 26px; text-align: center;" class="col-sm-12"><span class="grey">当前无记录</span></h5>
																</div>
																</c:when>
																<c:otherwise>
																	<table class="table table-striped table-bordered table-hover" style="border:1px solid #ddd;">
																		<thead>
																			<tr>
																				<th>序号</th>
																				<th>费用类型</th>
																				<th>费率</th>
																				<th>实收金额（元）</th>
																				<th>状态</th>
																				 <c:if test="${urlParam.type eq 'edit'}" >
																				    <th>操作</th>
																				 </c:if>
																			</tr>
																		</thead>
																		<tbody>
																			<c:forEach items="${loanPlan.costFactList}" var="costFact" varStatus="costFactStatus">
																				<tr>
																					<td>${costFactStatus.index+1}</td>
																					<td>${costFact.costTypeName}</td>
																					<td><fmt:formatNumber value="${costFact.costRate}" pattern="###,###.######"/>${costFact.costUnit}</td>
																					<td><fmt:formatNumber value="${costFact.factCostSum}" pattern="###,###.##"/></td>
																					<td>${costFact.costFactState}</td>
																					 <c:if test="${urlParam.type eq 'edit'}" >
																				      <td>
																					    <a href="javascript:void(0) " id="${costFact.costFact_ID}"  class="btn_costFactToCostPre">撤销</a>
																					   
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
												<!-- 实收费用  --end -->
												<!--退费费用  --start -->
												<div class="widget-header">
													<h5>退费费用 ： 第${loanPlanStatus.index+1}笔</h5>
												</div>
												<div class="widget-body" style="border:1px solid #ccc;">
													<div class="widget-main">
															<c:choose>
																<c:when test="${empty loanPlan.costReturnList}">
																 <div class="row">
																	<h5 style="line-height: 26px; text-align: center;" class="col-sm-12"><span class="grey">当前无记录</span></h5>
																</div>
																</c:when>
																<c:otherwise>
																	<table class="table table-striped table-bordered table-hover" style="border:1px solid #ddd;">
																		<thead>
																			<tr>
																				<th>序号</th>
																				<th>费用类型</th>
																				<th>原收费金额（元）</th>
																				<th>变更后金额（元）</th>
																				<th>退费金额（元）</th>
																				<th>退费类型</th>
																				<th>退费原因</th>
																				<th>退费确认日期</th>
																				<th>状态</th>
																				 <c:if test="${urlParam.type eq 'edit'}" >
																				    <th>操作</th>
																				 </c:if>
																			</tr>
																		</thead>
																		<tbody>
																		    <c:set var="returnCostSum_sum" value="0"></c:set>
																			<c:forEach items="${loanPlan.costReturnList}" var="costReturn" varStatus="costReturnStatus">
																				<tr>
																					<td>${costReturnStatus.index+1}</td>
																					<td>${costReturn.costTypeName}</td><!--费用类型  -->
																					<td><fmt:formatNumber value="${costReturn.oldCostSum}" pattern="###,###.##"/></td><!--原收费金额（元）  -->
																					<td><fmt:formatNumber value="${costReturn.newCostSum}" pattern="###,###.##"/></td><!--变更后金额（元）  -->
																					<td><fmt:formatNumber value="${costReturn.returnCostSum}" pattern="###,###.##"/></td><!--退费金额（元）  -->
																					<td>${costReturn.returnCostTypeName}</td><!--退费类型  -->
																					<td>${costReturn.returnDesc}</td><!--退费原因  -->
																					<td><fmt:formatDate value="${costReturn.returnCostDate}" pattern="yyyy-MM-dd" type="date"/></td><!--退费确认日期 -->
																					<td>${costReturn.costReturnState}</td><!--退费状态 -->
																					 <c:if test="${urlParam.type eq 'edit'}" >
																						   <td>
																							    <c:if test="${costReturn.costReturnState eq '未确认退费'}" >
																							         <a href="javascript:void(0) " id="${costReturn.costReturn_ID}" class="btn_costReturnToCostPre">退费确认</a>
																							    </c:if>
																								<c:if test="${costReturn.costReturnState eq '已确认'}" >
																							         <span class="gery">退费确认</span>
																							    </c:if>
																							</td>
																				     </c:if>
																					
																				</tr>
																				 <c:set var="returnCostSum_sum"  value="${returnCostSum_sum + costReturn.returnCostSum}"></c:set>
																			</c:forEach>
																			<tr>
																				<th>小计</th>
																				<th></th>
																				<th></th>
																				<th></th>
																				<th><fmt:formatNumber value="${returnCostSum_sum}" pattern="###,###.##"/>&nbsp;&nbsp;元</th>
																				<th></th>
																				<th></th>
																				<th></th>
																				<th></th>
																				<th></th>
																			</tr>
																			
																		</tbody>
																	</table>
																</c:otherwise>
															</c:choose>
													</div>
												</div>
												<!--退费费用  --end -->
												
												
												
												<!-- 收费小计 start-->
												  <div class="widget-header">
													<h5>收费小计： 第${loanPlanStatus.index+1}笔</h5>
												</div>
												<div class="widget-body" style="border:1px solid #ccc;">
													<div class="widget-main">
															<c:choose>
																<c:when test="${empty loanPlan.costPreSumMap}">
																 <div class="row">
																	<h5 style="line-height: 26px; text-align: center;" class="col-sm-12"><span class="grey">当前无记录</span></h5>
																</div>
																</c:when>
																<c:otherwise>
																	<table class="table table-striped table-bordered table-hover" style="border:1px solid #ddd;">
																		<thead>
																			<tr>
																				<th>序号</th>
																				<th>费用类型</th>
																				<!-- <th>费率</th> -->
																				<th>收费金额（元）</th>
																			</tr>
																		</thead>
																		<tbody>
																	    	<c:set var="costPreSumMap_sum" value="0"></c:set>
																			<c:forEach items="${loanPlan.costPreSumMap}" var="costPreSumMap" varStatus="costPreSumMapStatus">
																				<tr>
																					<td>${costPreSumMapStatus.index+1}</td>
																					<td>${costPreSumMap.key}</td>
																					<%-- <td><fmt:formatNumber value="${costFact.costRate}" pattern="###,###.######"/></td> --%>
																					<td><fmt:formatNumber value="${costPreSumMap.value}" pattern="###,###.##"/></td>
																				</tr>
																				<c:set var="costPreSumMap_sum" value="0"></c:set>
																				 <c:set var="costPreSumMap_sum"  value="${costPreSumMap_sum + costPreSumMap.value}"></c:set>
																			</c:forEach>
																			<tr>
																				<th>收费小计</th>
																				<th colspan="2" style="text-align: center;"><fmt:formatNumber value="${costPreSumMap_sum}" pattern="###,###.##"/>&nbsp;&nbsp;元</th>
																			</tr>
																			
																		</tbody>
																	</table>
																</c:otherwise>
															</c:choose>
													</div>
												</div>
												<!-- 收费小计 end-->
											</div>
										</c:forEach>
										
									</c:otherwise>
									
									
								</c:choose>
							</div>
						</div>
					</div>
				</div>
				<div class="space-16"></div>
			</c:forEach>
		</div>
	</div>
</div>
<div id="costRecordIndex_page"></div>
<div id="costPreToFact_page" ></div>
<%@ include file="/common_confirm.jsp" %>
 <script src="<%=path %>/project/cost/costRecordIndex.js?v=<%=vardate%>"></script>

							
									
									