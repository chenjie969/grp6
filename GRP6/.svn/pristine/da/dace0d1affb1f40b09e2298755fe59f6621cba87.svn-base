<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>

<div class="page-content">
	<div class="page-header">
		<h4>展期</h4>
	</div>
	<c:forEach items="${ meetingDetailList }" var="meetingDetail" varStatus="loanStatus">
		<div class="row">
			<div class="col-xs-12">
				<div class="widget-box transparent">
					<div class="widget-header widget-header-flat">
						<h4 class="smaller lighter orange">${loanStatus.index+1}、
							<c:choose>
								<c:when test="${empty meetingDetail.busiTypeName || meetingDetail.busiTypeName eq ''}"></c:when>
								<c:otherwise>${meetingDetail.busiTypeName} |</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${empty meetingDetail.agreeSum || meetingDetail.agreeSum eq 0}"></c:when>
								<c:otherwise><fmt:formatNumber value="${meetingDetail.agreeSum}"/>万元 |</c:otherwise>
							</c:choose>
							<%-- <c:choose>
					             <c:when test="${empty meetingDetail.periodMonth || meetingDetail.periodMonth eq 0}"></c:when>
					             <c:otherwise>${meetingDetail.periodMonth}个月|</c:otherwise>
					        </c:choose>
					        <c:choose>
					             <c:when test="${empty meetingDetail.periodDay || meetingDetail.periodDay eq 0}"></c:when>
					             <c:otherwise>${meetingDetail.periodDay}天|</c:otherwise>
					         </c:choose> --%>
					         <c:choose>
					             <c:when test="${empty meetingDetail.periodMonthDay || meetingDetail.periodMonthDay == '' }"></c:when>
					             <c:otherwise>${meetingDetail.periodMonthDay}|</c:otherwise>
					        </c:choose>
					         
							<c:choose>
								<c:when test="${empty meetingDetail.bankName || meetingDetail.bankName eq ''}"></c:when>
								<c:otherwise>${meetingDetail.bankName}</c:otherwise>
							</c:choose> 
						</h4> 
						<div class="widget-toolbar" style="height:37px">
							<a href="#" data-action="collapse" style="margin-top:11px;"><i class="icon-chevron-up"></i></a>
						</div>
					</div>
					<div class="widget-body">
						<div class="widget-body-inner" stryle="display: block;">
							<div class="widget-main no-padding">
								<h5 style="line-height: 26px;" class="col-sm-6">业务品种：<span class="grey">
									${empty meetingDetail.busiTypeName || meetingDetail.busiTypeName eq "" ?"(空)":meetingDetail.busiTypeName}
								</span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6">合作机构：<span class="grey">
									${empty meetingDetail.bankName || meetingDetail.bankName eq "" ?"(空)":meetingDetail.bankName}
								</span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6">担保金额：<span class="grey">
									<c:choose>
										<c:when test="${empty meetingDetail.agreeSum || meetingDetail.agreeSum eq 0}">（空）</c:when>
										<c:otherwise><fmt:formatNumber value="${meetingDetail.agreeSum}"/>万元</c:otherwise>
									</c:choose>
								</span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6">担保期限：<span class="grey">
									<%-- <c:choose>
										<c:when test="${empty meetingDetail.periodMonth || meetingDetail.periodMonth eq 0}">（空）</c:when>
										<c:otherwise>${meetingDetail.periodMonth}个月</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${empty meetingDetail.periodDay || meetingDetail.periodDay eq 0}">（空）</c:when>
										<c:otherwise>${meetingDetail.periodDay}天</c:otherwise>
									</c:choose> --%>
									${empty meetingDetail.periodMonthDay || meetingDetail.periodMonthDay eq "" ? "(空)":meetingDetail.periodMonthDay}
								</span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6">担保责任范围：<span class="grey">
									${empty meetingDetail.guarantyScope || meetingDetail.guarantyScope eq "" ?"(空)":meetingDetail.guarantyScope}
								</span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6">责任金额：<span class="grey">
									<c:choose>
										<c:when test="${empty meetingDetail.guarantyDutySum || meetingDetail.guarantyDutySum eq 0}">（空）</c:when>
										<c:otherwise><fmt:formatNumber value="${meetingDetail.guarantyDutySum}"/>万元</c:otherwise>
									</c:choose>
								</span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6">评审费率：<span class="grey">
									
									<c:choose>
										<c:when test="${empty meetingDetail.reviewRate || meetingDetail.reviewRate eq 0}">（空）</c:when>
										<c:otherwise><fmt:formatNumber value="${meetingDetail.reviewRate}"  pattern="#0.00"/>‰</c:otherwise>
									</c:choose>
								</span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6">担保费率：<span class="grey">
									<c:choose>
										<c:when test="${empty meetingDetail.guarantyRate || meetingDetail.guarantyRate eq 0}">（空）</c:when>
										<c:otherwise><fmt:formatNumber value="${meetingDetail.guarantyRate}" pattern="#0.00"/>%</c:otherwise>
									</c:choose>
								</span></h5>
								<h5 style="line-height: 26px;" class="col-sm-6">保证金比例：<span class="grey">
									<c:choose>
										<c:when test="${empty meetingDetail.bzScale || meetingDetail.bzScale eq 0}">（空）</c:when>
										<c:otherwise><fmt:formatNumber value="${meetingDetail.bzScale}"  pattern="#0.00"/>%</c:otherwise>
									</c:choose>
								</span></h5>
								
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="col-xs-12">
				<div class="widget-box transparent">
					<!-- <div class="widget-header widget-header-flat">
						<h4 class="smaller lighter orange">展期</h4>
						<div class="widget-toolbar" style="height:37px">
							<a href="#" data-action="collapse" style="margin-top:11px;"><i class="icon-chevron-up"></i></a>
						</div>
					</div> -->
					<div class="widget-body">
						<div class="widget-body-inner" stryle="display: block;">
						<c:forEach items="${ meetingDetail.loanPlanList }" var="loanPlan" varStatus="status">
							<input type="hidden" id="loanPlan_ID" name="loanPlan_ID" value="${loanPlan.loanPlan_ID}">
								<div class="widget-main no-padding">
									<div class="widget-box">
										<div class="widget-header">
											<h5>放款计划：第${status.index+1}笔 </h5>
										</div>
										<div class="widget-body" style="border:1px solid #ccc;">
											<div class="widget-main">
												<div class="row">
													<h5 style="line-height: 26px;" class="col-sm-6">计划放款金额：<span class="grey">
														<c:choose>
															<c:when test="${empty loanPlan.loanSum || loanPlan.loanSum eq 0}">（空）</c:when>
															<c:otherwise><fmt:formatNumber value="${loanPlan.loanSum}"/>万元</c:otherwise>
														</c:choose>
													</span></h5>
													<h5 style="line-height: 26px;" class="col-sm-6">期限：<span class="grey">
														${empty loanPlan.periodMonthDay || loanPlan.periodMonthDay eq "" ?"(空)":loanPlan.periodMonthDay}
													</span></h5>
													<h5 style="line-height: 26px;" class="col-sm-6">年利率：<span class="grey">
														<c:choose>
															<c:when test="${empty loanPlan.interestRate || loanPlan.interestRate eq 0}">（空）</c:when>
															<c:otherwise><fmt:formatNumber value="${loanPlan.interestRate}"  pattern="#0.00"/>％</c:otherwise>
														</c:choose>
													</span></h5>
													<h5 style="line-height: 26px;" class="col-sm-6">计划放款日期：<span class="grey">
														<c:choose>
															<c:when test="${empty loanPlan.loanDate}">（空）</c:when>
															<c:otherwise><fmt:formatDate value="${loanPlan.loanDate}" pattern="yyyy-MM-dd"/></c:otherwise>
														</c:choose>
													</span></h5>
												</div>
											</div>
										</div>
									</div>
									<div class="widget-box">
										<div class="widget-header">
											<h5>实际放款复核：第${status.index+1}笔<span style="color: red;">（在保中）</span></h5>
											<c:if test="${empty loanPlan.project.delay}">
												<div class="widget-toolbar action-buttons" style="height:37px;">
													<a href="#" style="margin-top:10px;" name="${loanPlan.project.loadSum}" id="${loanPlan.project.project_ID}" onclick="$.zjm_proDelay.proDelayAdd(this.id,this.name)">
														<i class="icon-edit orange">展期</i>
													</a>
												</div>
											</c:if>
										</div>
						
										<c:if test="${!empty loanPlan.project}">
										<div class="widget-body" style="border:1px solid #ccc;">
											<div class="widget-main">
												<div class="row">
														<h5 style="line-height: 26px;" class="col-sm-6">放款金额：<span class="grey">
															<c:choose>
																<c:when test="${empty loanPlan.project.loadSum || loanPlan.project.loadSum eq 0}">（空）</c:when>
																<c:otherwise><fmt:formatNumber value="${loanPlan.project.loadSum}"/>万元</c:otherwise>
															</c:choose>
														</span></h5>
														<h5 style="line-height: 26px;" class="col-sm-6">期限：<span class="grey">
															${empty loanPlan.project.periodMonthDay || loanPlan.project.periodMonthDay eq "" ?"(空)":loanPlan.project.periodMonthDay}
														</span></h5>
														<h5 style="line-height: 26px;" class="col-sm-6">年利率：<span class="grey"></span>
															<c:choose>
																<c:when test="${empty loanPlan.interestRate}">（空）</c:when>
																<c:otherwise><fmt:formatNumber value="${loanPlan.interestRate}"  pattern="#0.00"/>％</c:otherwise>
															</c:choose>
														</h5>
														<h5 style="line-height: 26px;" class="col-sm-6">借据起始日期：<span class="grey">
															<c:choose>
																<c:when test="${empty loanPlan.project.billBeginDate}">（空）</c:when>
																<c:otherwise><fmt:formatDate value="${loanPlan.project.billBeginDate}" pattern="yyyy-MM-dd"/></c:otherwise>
															</c:choose>
														</span></h5>
														<h5 style="line-height: 26px;" class="col-sm-6">借据到期日期：<span class="grey">
															<c:choose>
																<c:when test="${empty loanPlan.project.billEndDate}">（空）</c:when>
																<c:otherwise><fmt:formatDate value="${loanPlan.project.billEndDate}" pattern="yyyy-MM-dd"/></c:otherwise>
															</c:choose>
														</span></h5>
														<h5 style="line-height: 26px;" class="col-sm-6">借据附件：<span class="grey">
															<c:forEach items="${ loanPlan.projectfilesList }" var="projectfiles" varStatus="status11">
																<a href="${projectfiles.pathFile }">${projectfiles.sourceFileName }</a><br>
															</c:forEach>
														</span></h5>
												</div>
											</div>
										</div>
										</c:if>
										
										<c:if test="${empty loanPlan.project}">
										<div class="widget-body" style="border:1px solid #ccc;">
										<div class="widget-main">
										<div class="row">
											<h5 style="line-height: 26px; color: gray;text-align: center;" >
												暂无数据！
											</h5>
										</div>
										</div>
										</div>
										</c:if>
										
										<div class="widget-box">
										<div class="widget-header">
											<h5>展期：第${status.index+1}笔</h5>
											<c:if test="${!empty loanPlan.project.delay}">
												<div class="widget-toolbar action-buttons" style="height:37px;">
													<a href="#" style="margin-top:10px;" name="${loanPlan.project.loadSum}" id="${loanPlan.project.delay.delay_ID}" onclick="$.zjm_proDelay.proDelayEdit(this.id,this.name)">
														<i class="icon-edit orange">修改</i>
													</a>
													<a href="#" style="margin-top:10px;" id="${loanPlan.project.delay.delay_ID}" onclick="$.zjm_proDelay.proDelayDel(this.id)">
														<i class="icon-trash red">删除</i>
													</a>
												</div>
											</c:if>
										</div>
						
										<c:if test="${!empty loanPlan.project.delay}">
										<div class="widget-body" style="border:1px solid #ccc;">
											<div class="widget-main">
												<div class="row">
														<h5 style="line-height: 26px;" class="col-sm-6">展期金额：<span class="grey">
															<c:choose>
																<c:when test="${empty loanPlan.project.delay.delaySum || loanPlan.project.delay.delaySum eq 0}">（空）</c:when>
																<c:otherwise><fmt:formatNumber value="${loanPlan.project.delay.delaySum}"/>万元</c:otherwise>
															</c:choose>
														</span></h5>
														<h5 style="line-height: 26px;" class="col-sm-6">期限：<span class="grey">
															${empty loanPlan.project.delay.delayMonthDay || loanPlan.project.delay.delayMonthDay eq "" ?"(空)":loanPlan.project.delay.delayMonthDay}
														</span></h5>
														
														<h5 style="line-height: 26px;" class="col-sm-6">展期起始日期：<span class="grey">
															<c:choose>
																<c:when test="${empty loanPlan.project.delay.delayBeginDate}">（空）</c:when>
																<c:otherwise><fmt:formatDate value="${loanPlan.project.delay.delayBeginDate}" pattern="yyyy-MM-dd"/></c:otherwise>
															</c:choose>
														</span></h5>
														<h5 style="line-height: 26px;" class="col-sm-6">展期到期日期：<span class="grey">
															<c:choose>
																<c:when test="${empty loanPlan.project.delay.delayEndDate}">（空）</c:when>
																<c:otherwise><fmt:formatDate value="${loanPlan.project.delay.delayEndDate}" pattern="yyyy-MM-dd"/></c:otherwise>
															</c:choose>
														</span></h5>
														<h5 style="line-height: 26px;" class="col-sm-6">展期担保费率：<span class="grey"></span>
															<c:choose>
																<c:when test="${empty loanPlan.project.delay.delayRate || loanPlan.project.delay.delayRate eq 0}">（空）</c:when>
																<c:otherwise><fmt:formatNumber value="${loanPlan.project.delay.delayRate}"  pattern="#0.00"/>％</c:otherwise>
															</c:choose>
														</h5>
														<h5 style="line-height: 26px;" class="col-sm-6">借据附件：<span class="grey">
															<c:forEach items="${ loanPlan.project.projectfilesList }" var="projectfiless" varStatus="status12">
																<a href="${projectfiless.pathFile }">${projectfiless.sourceFileName }</a><br>
															</c:forEach>
														</span></h5>
												</div>
											</div>
										</div>
										</c:if>
										
										<c:if test="${empty loanPlan.project.delay}">
										<div class="widget-body" style="border:1px solid #ccc;">
										<div class="widget-main">
										<div class="row">
											<h5 style="line-height: 26px; color: gray;text-align: center;" >
												暂无数据！
											</h5>
										</div>
										</div>
										</div>
										</c:if>
										
										
									</div>
									
										
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
					
					<c:if test="${empty meetingDetail.loanPlanList }">
						<div class="widget-body">
							<div class="widget-body-inner" stryle="display: block;">
								<div class="widget-main no-padding">
								<div class="widget-box">
								<div class="widget-body" style="border:1px solid #ccc;"> 
								<div class="widget-main">
								<div class="row">
									<h5 style="line-height: 26px; color: red;text-align: center;" >
									该项目未做放款计划确认，无法进行项目展期！
									</h5>
								</div>
								 </div>
								</div>
								</div>
								</div>
							</div>
						</div> 
					</c:if>
					
				</div>
			</div>	
		</div>
		<div class="space-16"></div>
	</c:forEach>
</div>
<div id="proDelay_page"></div>
						
<script src="<%=path %>/project/loan/proDelay/proDelay.js?v=<%=vardate%>"></script>
