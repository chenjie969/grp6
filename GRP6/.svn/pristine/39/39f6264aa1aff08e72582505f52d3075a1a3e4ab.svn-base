<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" id="fundsDetailView" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel">查看用款申请</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-sm-offset-1 col-sm-10">
						<div class="col-sm-6">
							<div class="row">
								<h5 class="col-sm-12" style="line-height:26px;">业务性质：<span class="grey" >${fundsApply.detailList[0].busiNatureName }</span></h5>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="row">
								<h5 class="col-sm-12" style="line-height:26px;">项目类型：<span class="grey" >${fundsApply.detailList[0].projectTypeName }</span></h5>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="row">
								<h5 class="col-sm-12" style="line-height:26px;">客户名称：<span class="grey">${fundsApply.detailList[0].clientName }</span></h5>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="row">
								<h5 class="col-sm-12" style="line-height:26px;">项目名称：<span class="grey">${fundsApply.projectName }</span></h5>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="row">
								<h5 class="col-sm-12" style="line-height:26px;">项目来源：<span class="grey">
									<c:choose>
										<c:when test="${empty fundsApply.detailList[0].projectSourceName }">（空）</c:when>
										<c:otherwise>${fundsApply.detailList[0].projectSourceName }</c:otherwise>
									</c:choose>
								</span></h5>
							</div>
						</div>
						<div class="col-sm-12 col-xs-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height:26px;">来源说明：<span class="grey">
									<c:choose>
										<c:when test="${empty fundsApply.detailList[0].sourceDesc }">（空）</c:when>
										<c:otherwise>${fundsApply.detailList[0].sourceDesc }</c:otherwise>
									</c:choose>
								</span></h5>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="row">
								<h5 class="col-sm-12" style="line-height:26px;">业务品种：<span class="grey" >${fundsApply.detailList[0].busiTypeName }</span></h5>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="row">
								<h5 class="col-sm-12" style="line-height:26px;">绿色通道：<span class="grey">
									<c:choose>
										<c:when test="${empty fundsApply.detailList[0].greenChannelName }">（空）</c:when>
										<c:otherwise>${fundsApply.detailList[0].greenChannelName }</c:otherwise>
									</c:choose>
								</span></h5>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="row">
								<h5 class="col-sm-12" style="line-height:26px;">申请金额：<span class="grey"><fmt:formatNumber value="${fundsApply.detailList[0].applySum}" pattern="###,###.######"> </fmt:formatNumber>
									  &nbsp;万元</span></h5>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="row">
								<h5 class="col-sm-12" style="line-height:26px;">申请期限：<span class="grey">
									<c:choose>
										<c:when test="${empty fundsApply.detailList[0].periodMonthDay }">（空）</c:when>
										<c:otherwise>${fundsApply.detailList[0].periodMonthDay }</c:otherwise>
									</c:choose>
								</span></h5>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="row">
								<h5 class="col-sm-12" style="line-height:26px;">合作机构：<span class="grey">
									<c:choose>
										<c:when test="${empty fundsApply.detailList[0].bankName }">（空）</c:when>
										<c:otherwise>${fundsApply.detailList[0].bankName }</c:otherwise>
									</c:choose>
								</span></h5>
							</div>
						</div>
						<div class="col-sm-12 col-xs-12">
							<div class="row">
								<h5 class="col-sm-12"  style="line-height:26px;">贷款(担保)用途：<span class="grey">
									<c:choose>
										<c:when test="${empty fundsApply.detailList[0].loadUsed }">（空）</c:when>
										<c:otherwise>${fundsApply.detailList[0].loadUsed }</c:otherwise>
									</c:choose>
								</span></h5>
							</div>
						</div>
						<div class="col-sm-12 col-xs-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height:26px;">还款计划与来源：<span class="grey">
									<c:choose>
										<c:when test="${empty fundsApply.detailList[0].repaymentPlan }">（空）</c:when>
										<c:otherwise>${fundsApply.detailList[0].repaymentPlan }</c:otherwise>
									</c:choose>
								</span></h5>
							</div>
						</div>
						<div class="col-sm-12 col-xs-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height:26px;">拟提供的保证措施：<span class="grey">
									<c:choose>
										<c:when test="${empty fundsApply.detailList[0].provideGuaranty }">（空）</c:when>
										<c:otherwise>${fundsApply.detailList[0].provideGuaranty }</c:otherwise>
									</c:choose>
								</span></h5>
							</div>
						</div>
						<div class="col-sm-12 col-xs-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height:26px;">备注：<span class="grey">
									<c:choose>
										<c:when test="${empty fundsApply.detailList[0].otherDesc }">（空）</c:when>
										<c:otherwise>${fundsApply.detailList[0].otherDesc }</c:otherwise>
									</c:choose>
								</span></h5>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="row">
								<h5 class="col-sm-12" style="line-height:26px;">经办部门：<span class="grey" >${fundsApply.departName }</span></h5>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="row">
								<h5 class="col-sm-12" style="line-height:26px;">经办人：<span class="grey">${fundsApply.createManName }</span></h5>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="row">
								<h5 class="col-sm-12" style="line-height:26px;">受理日期：<span class="grey">
									<fmt:formatDate value="${fundsApply.createDate }" pattern="yyyy-MM-dd" type="date"/>
								</span></h5>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
			      <button type="button" class="btn btn-default" data-dismiss="modal">
			           <i class="icon-remove bigger-110"></i>关闭
			      </button>
			</div>
		</div>
	</div>
</div> 
