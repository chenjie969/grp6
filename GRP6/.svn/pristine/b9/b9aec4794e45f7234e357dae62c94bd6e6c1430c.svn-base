<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<style>
	table{
		font-size:13px !important;
		text-align: center;
		width: 80%;
	}
	table thead tr th{
		border:1px solid #ddd;
		text-align: center;
	};
	table tbody tr td{
		border:1px solid #ddd;
		text-align: center;
	};
	
</style>

<div class="page-content">
	<div class="page-header">
		<h4>收费登记</h4>
	</div>
	<c:if test="${empty meetingDetailList }">
		<div class="row">
			<div class="col-xs-12">
				暂无记录!
			</div>
		</div>
	</c:if>
	<c:forEach items="${meetingDetailList}" var="meetingDetail" varStatus="loanStatus">
		<div class="row">
			<!-- 决议同意担保情况  begin -->
			<div class="col-xs-12">
				<div class="widget-box transparent">
					<div class="widget-header widget-header-flat">
						<h4 class="smaller lighter orange">${loanStatus.index+1}、决议同意担保情况 </h4> 
						<div class="widget-toolbar action-buttons" style="height:37px;">
							<a href="#" data-action="collapse" style="margin-top:10px;">
								<i class="icon-chevron-up"></i>
							</a>
						</div>
					</div>
					<div class="widget-body">
						<div class="widget-body-inner" stryle="display: block;">
							<div class="widget-main no-padding">
								<h5 style="line-height: 26px;" class="col-sm-6">业务品种：<span class="grey">
										${empty meetingDetail.busiTypeName || meetingDetail.busiTypeName eq "" ?"(空)":meetingDetail.busiTypeName}
									</span></h5>
									<h5 style="line-height: 26px;" class="col-sm-6">放款机构：<span class="grey">
										${empty meetingDetail.bankName || meetingDetail.bankName eq "" ?"(空)":meetingDetail.bankName}
									</span></h5>
									<h5 style="line-height: 26px;" class="col-sm-6">同意担保金额：<span class="grey">
										<c:choose>
											<c:when test="${empty meetingDetail.agreeSum || meetingDetail.agreeSum eq 0}">（空）</c:when>
											<c:otherwise><fmt:formatNumber value="${meetingDetail.agreeSum}"/>万元</c:otherwise>
										</c:choose>
									</span></h5>
									<h5 style="line-height: 26px;" class="col-sm-6">同意期限：<span class="grey">
										${empty meetingDetail.periodMonthDay || meetingDetail.periodMonthDay eq "" ? "(空)":meetingDetail.periodMonthDay}
									</span></h5>
									<h5 style="line-height: 26px;" class="col-sm-6">同意评审费率：<span class="grey">
										
										<c:choose>
											<c:when test="${empty meetingDetail.reviewRate || meetingDetail.reviewRate eq 0}">（空）</c:when>
											<c:otherwise><fmt:formatNumber value="${meetingDetail.reviewRate}"  pattern="#0.00"/>‰</c:otherwise>
										</c:choose>
									</span></h5>
									<h5 style="line-height: 26px;" class="col-sm-6">同意担保费率：<span class="grey">
										<c:choose>
											<c:when test="${empty meetingDetail.guarantyRate || meetingDetail.guarantyRate eq 0}">（空）</c:when>
											<c:otherwise><fmt:formatNumber value="${meetingDetail.guarantyRate}" pattern="#0.00"/>%</c:otherwise>
										</c:choose>
									</span></h5>
									<h5 style="line-height: 26px;" class="col-sm-12">同意保证金比例：<span class="grey">
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
			<!-- 决议同意担保情况 end -->
			<!-- 实际收费情况  begin -->
			<div class="col-xs-12">
				<div class="widget-box transparent">
					<div class="widget-header widget-header-flat">
						<h4 class="smaller lighter orange">收费情况</h4>
						<div class="widget-toolbar" style="height:37px">
							<a href="#" data-action="collapse" style="margin-top:11px;"><i class="icon-chevron-up"></i></a>
						</div>
						<div class="widget-toolbar action-buttons" style="height:37px;">
						<c:if test="${urlParam.type eq 'edit' }">
							<a href="#" class="pull-right" style="margin-right:10px;line-height:37px;display:block;text-decoration:none;"
								id="${meetingDetail.meetingDetail_ID}" onclick="$.zjm_feeRegister.addCostFact(this.id)">
								<i class="icon-edit bigger-110 orange"></i>
								<span class="bigger-110 no-text-shadow orange">添加实收</span>
							</a>
							
							<a href="#" class="pull-right" style="margin-right:10px;line-height:37px;display:block;text-decoration:none;"
								id="${meetingDetail.meetingDetail_ID}" onclick="$.zjm_feeRegister.addCostReturn(this.id)">
								<i class="icon-edit bigger-110 orange"></i>
								<span class="bigger-110 no-text-shadow orange">添加退费</span>
							</a>
							
							<a href="#" class="pull-right" style="margin-right:10px;line-height:37px;display:block;text-decoration:none;"
								id="${meetingDetail.meetingDetail_ID}" onclick="$.zjm_feeRegister.addCostPre(this.id)">
								<i class="icon-edit bigger-110 orange"></i>
								<span class="bigger-110 no-text-shadow orange">添加预收</span>
							</a>
							
							<a href="#" class="pull-right"  style="margin-right:10px;line-height:37px;display:block;text-decoration:none;"
								id="${meetingDetail.meetingDetail_ID}" onclick="$.zjm_feeRegister.addCostMust(this.id)">
								<i class="icon-edit bigger-110 orange"></i>
								<span class="bigger-110 no-text-shadow orange">添加应收</span>
							</a>
						</c:if>
						</div>
					</div> 
					<div class="widget-body">
						<div class="widget-body-inner" stryle="display: block;">
							<div class="widget-main no-padding">
								<div class="widget-box">
									<div class="widget-header">
										<!-- <h5>第笔 </h5> -->
									</div>
									<div class="widget-body" style="border:1px solid #ccc;">
										<div class="widget-main">
												<table class="table table-striped table-bordered table-hover" style="border:1px solid #ddd;">
													<thead>
														<tr>
															<th>日期</th>
															<th>费用类型</th>
															<th>费率</th>
															<th>对应放款</th>
															<th>操作类型</th>
															<th>费用（元）</th>
															<th>状态</th>
															<th>备注</th>
															<c:if test="${urlParam.type eq 'edit' }">
																<th>操作</th>
															</c:if>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${meetingDetail.costMustList }" var="costMust">
															<tr>
																<td>
																	<c:choose>
																		<c:when test="${!empty costMust.mustCostDate }"><fmt:formatDate value="${costMust.mustCostDate }" pattern="yyyy-MM-dd"/></c:when>
																		<c:otherwise>（空）</c:otherwise>
																	</c:choose>
																</td>
																<td>${costMust.costName }</td>
																<td><fmt:formatNumber value="${costMust.costRate }" pattern="#0.00"/>${costMust.costUnit }</td>
																<td>${meetingDetail.busiTypeName } <fmt:formatNumber value="${meetingDetail.agreeSum }" />万元</td>
																<td>应收</td>
																<td><fmt:formatNumber value="${costMust.mustCostSum }" /></td>
																<td>${costMust.costMustState }</td>
																<td>${costMust.remark }</td>
																<c:if test="${urlParam.type eq 'edit' }">
																	<td>
																		<c:if test="${costMust.costMustState eq '未收到' }">
																			<button class="btn_modules_edit btn btn-xs btn-info" title="修改" id="${costMust.costMust_ID }" 
																				onclick="$.zjm_feeRegister.updateCostMust(this.id)">
																				<i class="icon-pencil bigger-120"></i>
																			</button>
																			<button class="btn_modules_del btn btn-xs btn-danger" title="删除" id="${costMust.costMust_ID }"
																				onclick="$.zjm_feeRegister.delCostMust(this.id)">
																				<i class="icon-trash bigger-120"></i>
																			</button>
																			<button class="btn_transact_change btn btn-xs btn-info" title="转预收" id="${costMust.costMust_ID }"
																				onclick="$.zjm_feeRegister.mustTransPre(this.id)">
																				<i class="icon-random bigger-120"></i>
																			</button>
																		</c:if>
																	</td>
																</c:if>
															</tr>
														</c:forEach>
														<c:forEach items="${meetingDetail.costPreList }" var="costPre">
															<tr>
																<td><fmt:formatDate value="${costPre.preCostDate }" pattern="yyyy-MM-dd"/></td>
																<td>${costPre.costTypeName }</td>
																<td><fmt:formatNumber value="${costPre.costRate }" pattern="#0.00"/>${costPre.costUnit }</td>
																<td>${meetingDetail.busiTypeName } <fmt:formatNumber value="${meetingDetail.agreeSum }" />万元</td>
																<td>预收</td>
																<td><fmt:formatNumber value="${costPre.preCostSum }" /></td>
																<td>${costPre.costPreState }</td>
																<td>${costPre.remark }</td>
																<c:if test="${urlParam.type eq 'edit' }">
																	<td>
																		<c:if test="${costPre.costPreState eq '未确认到账' }">
																			<button class="btn_modules_edit btn btn-xs btn-info" title="修改" id="${costPre.costPre_ID }" 
																				onclick="$.zjm_feeRegister.updateCostPre(this.id)">
																				<i class="icon-pencil bigger-120"></i>
																			</button>
																			<button class="btn_modules_del btn btn-xs btn-danger" title="删除" id="${costPre.costPre_ID }"
																				onclick="$.zjm_feeRegister.delCostPre(this.id)">
																				<i class="icon-trash bigger-120"></i>
																			</button>
																			<button class="btn_transact_change btn btn-xs btn-info" title="转实收" id="${costPre.costPre_ID}"
																				onclick="$.zjm_feeRegister.preTransFact(this.id)">
																				<i class="icon-random bigger-120"></i>
																			</button>
																		</c:if>
																	</td>
																</c:if>
															</tr>
														</c:forEach>
														<c:forEach items="${meetingDetail.costReturnList }" var="costReturn">
															<tr>
																<td><fmt:formatDate value="${costReturn.returnCostDate }" pattern="yyyy-MM-dd"/></td>
																<td>${costReturn.costTypeName }</td>
																<td>（空）</td>
																<td>${meetingDetail.busiTypeName } <fmt:formatNumber value="${meetingDetail.agreeSum }" />万元</td>
																<td>退费</td>
																<td><fmt:formatNumber value="${costReturn.returnCostSum }" /></td>
																<td>${costReturn.costReturnState }</td>
																<td>${costReturn.remark }</td>
																<c:if test="${urlParam.type eq 'edit' }">
																	<td>
																		<button class="btn_modules_edit btn btn-xs btn-info" title="修改" id="${costReturn.costReturn_ID }" 
																			onclick="$.zjm_feeRegister.updateCostReturn(this.id)">
																			<i class="icon-pencil bigger-120"></i>
																		</button>
																		<button class="btn_modules_del btn btn-xs btn-danger" title="删除" id="${costReturn.costReturn_ID }"
																			onclick="$.zjm_feeRegister.delCostReturn(this.id)">
																			<i class="icon-trash bigger-120"></i>
																		</button>
																	</td>
																</c:if>
															</tr>
														</c:forEach>
														<c:forEach items="${meetingDetail.costFactList }" var="costFact">
															<tr>
																<td><fmt:formatDate value="${costFact.factCostDate }" pattern="yyyy-MM-dd"/></td>
																<td>${costFact.costTypeName }</td>
																<td><fmt:formatNumber value="${costFact.costRate }" pattern="#0.00"/>${costFact.costUnit }</td>
																<td>${meetingDetail.busiTypeName } <fmt:formatNumber value="${meetingDetail.agreeSum }" />万元</td>
																<td>实收</td>
																<td><fmt:formatNumber value="${costFact.factCostSum }" /></td>
																<td>${costFact.costFactState }</td>
																<td>${costFact.remark }</td>
																<c:if test="${urlParam.type eq 'edit' }">
																	<td>
																		<button class="btn_modules_edit btn btn-xs btn-info" title="修改" id="${costFact.costFact_ID}" 
																			onclick="$.zjm_feeRegister.updateCostFact(this.id)">
																			<i class="icon-pencil bigger-120"></i>
																		</button>
																		<button class="btn_modules_del btn btn-xs btn-danger" title="删除" id="${costFact.costFact_ID}"
																			onclick="$.zjm_feeRegister.delCostFact(this.id)">
																			<i class="icon-trash bigger-120"></i>
																		</button>
																	</td>
																</c:if>
															</tr>
														</c:forEach>
														<c:if test="${empty meetingDetail.costMustList && empty meetingDetail.costFactList && empty meetingDetail.costPreList && empty meetingDetail.costReturnList }">
															<tr>
																<c:choose>
																	<c:when test="${urlParam.type eq 'edit' }"><td colspan="9">暂无记录！</td></c:when>
																	<c:otherwise><td colspan="8">暂无记录！</td></c:otherwise>
																</c:choose>
															</tr>
														</c:if>
													</tbody>
												</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					
				</div>
			</div>
			<!-- 实际收费情况  end -->
				
		</div>
		<div class="space-16"></div>
	</c:forEach>
</div>
<div id="feeRegister_page"></div>
<script src="<%=path %>/project/loan/feeRegister/feeRegister.js?v=<%=vardate%>"></script>

