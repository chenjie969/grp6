<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp"%>
<%@ include file="/common_head.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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

<div class="page-header col-sm-12">
	<h4>确认收费情况</h4>
</div>
<div class="page-content">
	<div class="page-header">
		<input type="hidden" id="meetingDetail_ID" value="${meetingDetail_ID }">
		
		<button type="button" name="button" class="btn btn-sm btn-info" id="${meetingDetail_ID }" onclick="$.zjm_confirmFee.addCostMust(this.id)">添加应收</button>
		<button type="button" name="button" class="btn btn-sm btn-info" id="${meetingDetail_ID }" onclick="$.zjm_confirmFee.addCostPre(this.id)">添加预收</button>
		<button type="button" name="button" class="btn btn-sm btn-info" id="${meetingDetail_ID }" onclick="$.zjm_confirmFee.addCostReturn(this.id)">添加退费</button>
		<button type="button" name="button" class="btn btn-sm btn-info" id="${meetingDetail_ID }" onclick="$.zjm_confirmFee.addCostFact(this.id)">添加实收</button>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="row">

				<div class="col-sm-12">
					<div class="widget-box">
						<!-- <div class="widget-header">
							<a href="#" class="pull-right"  style="margin-right:10px;line-height:37px;display:block;text-decoration:none;cursor: default;">
								单位：元			
							</a>
						</div> -->
						<div class="widget-body" style="border: 1px solid #ccc;">
							<div class="widget-main">
								<div class="table-responsive">
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
												<th>操作</th>
											</tr>
										</thead>
										<tbody align="center">
											<c:forEach items="${costMustList }" var="costMust">
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
													<td>
														<c:if test="${costMust.costMustState eq '未收到' }">
															<button class="btn_modules_edit btn btn-xs btn-info" title="修改" id="${costMust.costMust_ID }" 
																onclick="$.zjm_confirmFee.updateCostMust(this.id)">
																<i class="icon-pencil bigger-120"></i>
															</button>
															<button class="btn_modules_del btn btn-xs btn-danger" title="删除" id="${costMust.costMust_ID }"
																onclick="$.zjm_confirmFee.delCostMust(this.id)">
																<i class="icon-trash bigger-120"></i>
															</button>
															<button class="btn_transact_change btn btn-xs btn-info" title="转预收" id="${costMust.costMust_ID }"
																onclick="$.zjm_confirmFee.mustTransPre(this.id)">
																<i class="icon-random bigger-120"></i>
															</button>
														</c:if>
													</td>
												</tr>
											</c:forEach>
											<c:forEach items="${costPreList }" var="costPre">
												<tr>
													<td><fmt:formatDate value="${costPre.preCostDate }" pattern="yyyy-MM-dd"/></td>
													<td>${costPre.costTypeName }</td>
													<td><fmt:formatNumber value="${costPre.costRate }" pattern="#0.00"/>${costPre.costUnit }</td>
													<td>${meetingDetail.busiTypeName } <fmt:formatNumber value="${meetingDetail.agreeSum }" />万元</td>
													<td>预收</td>
													<td><fmt:formatNumber value="${costPre.preCostSum }" /></td>
													<td>${costPre.costPreState }</td>
													<td>${costPre.remark }</td>
													<td>
														<c:if test="${costPre.costPreState eq '未确认到账' }">
															<button class="btn_modules_edit btn btn-xs btn-info" title="修改" id="${costPre.costPre_ID }" 
																onclick="$.zjm_confirmFee.updateCostPre(this.id)">
																<i class="icon-pencil bigger-120"></i>
															</button>
															<button class="btn_modules_del btn btn-xs btn-danger" title="删除" id="${costPre.costPre_ID }"
																onclick="$.zjm_confirmFee.delCostPre(this.id)">
																<i class="icon-trash bigger-120"></i>
															</button>
															<button class="btn_transact_change btn btn-xs btn-info" title="转实收" id="${costPre.costPre_ID}"
																onclick="$.zjm_confirmFee.preTransFact(this.id)">
																<i class="icon-random bigger-120"></i>
															</button>
														</c:if>
													</td>
												</tr>
											</c:forEach>
											<c:forEach items="${costReturnList }" var="costReturn">
												<tr>
													<td><fmt:formatDate value="${costReturn.returnCostDate }" pattern="yyyy-MM-dd"/></td>
													<td>${costReturn.costTypeName }</td>
													<td>（空）</td>
													<td>${meetingDetail.busiTypeName } <fmt:formatNumber value="${meetingDetail.agreeSum }" />万元</td>
													<td>退费</td>
													<td><fmt:formatNumber value="${costReturn.returnCostSum }" /></td>
													<td>${costReturn.costReturnState }</td>
													<td>${costReturn.remark }</td>
													<td>
														<button class="btn_modules_edit btn btn-xs btn-info" title="修改" id="${costReturn.costReturn_ID }" 
															onclick="$.zjm_confirmFee.updateCostReturn(this.id)">
															<i class="icon-pencil bigger-120"></i>
														</button>
														<button class="btn_modules_del btn btn-xs btn-danger" title="删除" id="${costReturn.costReturn_ID }"
															onclick="$.zjm_confirmFee.delCostReturn(this.id)">
															<i class="icon-trash bigger-120"></i>
														</button>
													</td>
												</tr>
											</c:forEach>
											<c:forEach items="${costFactList }" var="costFact">
												<tr>
													<td><fmt:formatDate value="${costFact.factCostDate }" pattern="yyyy-MM-dd"/></td>
													<td>${costFact.costTypeName }</td>
													<td><fmt:formatNumber value="${costFact.costRate }" pattern="#0.00"/>${costFact.costUnit }</td>
													<td>${meetingDetail.busiTypeName } <fmt:formatNumber value="${meetingDetail.agreeSum }" />万元</td>
													<td>实收</td>
													<td><fmt:formatNumber value="${costFact.factCostSum }" /></td>
													<td>${costFact.costFactState }</td>
													<td>${costFact.remark }</td>
													<td>
														<button class="btn_modules_edit btn btn-xs btn-info" title="修改" id="${costFact.costFact_ID}" 
															onclick="$.zjm_confirmFee.updateCostFact(this.id)">
															<i class="icon-pencil bigger-120"></i>
														</button>
														<button class="btn_modules_del btn btn-xs btn-danger" title="删除" id="${costFact.costFact_ID}"
															onclick="$.zjm_confirmFee.delCostFact(this.id)">
															<i class="icon-trash bigger-120"></i>
														</button>
													</td>
												</tr>
											</c:forEach>
											<c:if test="${empty costMustList && empty costFactList && empty costPreList && empty costReturnList }">
												<tr>
													<td colspan="9">暂无记录！</td>
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
</div>
<div id="confirmFee_page"></div>

<%@ include file="/common_foot.jsp"%>
<script src="<%=path%>/project/loan/singleLoanReview/confirmFee.js?v=<%=vardate%>"></script>
