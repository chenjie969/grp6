<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" id="viewEnterpriseDepot" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看企业储备库</h4>
      </div>
      <div class="modal-body">
      	<div class="row">
			<div class="col-sm-offset-1 col-sm-10">
				<!-- <div class="col-sm-6">
					<div class="row">
						<h5 class="col-sm-12">客户类型：<span class="grey">企业客户</span></h5>
					</div>
				</div> -->
				<div class="col-sm-6">
					<div class="row">
						<h5 class="col-sm-12">企业名称：<span class="grey" style="line-height:26px;">${apply.clientName }</span></h5>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="row">
						<h5 class="col-sm-12">申请编号：<span class="grey" style="line-height:26px;">${apply.applyNum }</span></h5>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="row">
						<h5 class="col-sm-12">联系人：<span class="grey" style="line-height:26px;">${apply.contact }</span></h5>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="row">
						<h5 class="col-sm-12">手机：<span class="grey" style="line-height:26px;">${apply.phone }</span></h5>
					</div>
				</div>
				<div class="col-sm-12 col-xs-12">
					<div class="row">
						<h5 class="col-sm-12"  style="line-height:26px;">固定电话：<span class="grey">
							<c:choose>
								<c:when test="${empty apply.telephone }">（空）</c:when>
								<c:otherwise>${apply.telephone }</c:otherwise>
							</c:choose>
						</span></h5>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="row">
						<h5 class="col-sm-12">业务品种：<span class="grey" style="line-height:26px;">${apply.busiTypeName }</span></h5>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="row">
						<h5 class="col-sm-12" style="line-height:26px;">合作机构：<span class="grey">
							<c:choose>
								<c:when test="${empty apply.cooperationName }">（空）</c:when>
								<c:otherwise>${apply.cooperationName }</c:otherwise>
							</c:choose>
						</span></h5>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="row">
						<h5 class="col-sm-12">申请金额：<span class="grey" style="line-height:26px;"><fmt:formatNumber value="${apply.applySum }" pattern="###,###.######"/>万元</span></h5>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="row">
						<h5 class="col-sm-12">申请期限：<span class="grey" style="line-height:26px;">
							<c:choose>
								<c:when test="${empty apply.periodMonthDay }">（空）</c:when>
								<c:otherwise>${apply.periodMonthDay }</c:otherwise>
							</c:choose>
						</span></h5>
					</div>
				</div>
				<div class="col-sm-12 col-xs-12">
					<div class="row">
						<h5 class="col-sm-12" style="line-height:26px;">客户来源：<span class="grey">${apply.clientSourceName }</span></h5>
					</div>
				</div>
				<div class="col-sm-12 col-xs-12">
					<div class="row">
						<h5 class="col-sm-12" style="line-height:26px;">来源说明：<span class="grey">
							<c:choose>
								<c:when test="${empty apply.clientSourceDesc }">（空）</c:when>
								<c:otherwise>${apply.clientSourceDesc }</c:otherwise>
							</c:choose>
						</span></h5>
					</div>
				</div>
				<div class="col-sm-12  col-xs-12">
					<div class="row">
						<h5 class="col-sm-12" style="line-height:26px;">贷款用途：<span class="grey">
							<c:choose>
								<c:when test="${empty apply.loadUsed }">（空）</c:when>
								<c:otherwise>${apply.loadUsed }</c:otherwise>
							</c:choose>
						</span></h5>
					</div>
				</div>
				<div class="col-sm-12  col-xs-12">
					<div class="row">
						<h5 class="col-sm-12" style="line-height:26px;">还款计划与来源：<span class="grey">
							<c:choose>
								<c:when test="${empty apply.repaymentPlan }">（空）</c:when>
								<c:otherwise>${apply.repaymentPlan }</c:otherwise>
							</c:choose>
						</span></h5>
					</div>
				</div>
				<div class="col-sm-12  col-xs-12">
					<div class="row">
						<h5 class="col-sm-12">拟提供的保证措施：<span class="grey" style="line-height:26px;">
							<c:choose>
								<c:when test="${empty apply.provideGuaranty }">（空）</c:when>
								<c:otherwise>${apply.provideGuaranty }</c:otherwise>
							</c:choose>
						</span></h5>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="row">
						<h5 class="col-sm-12">接待部门：<span class="grey" style="line-height:26px;">${apply.receiveDeapartName }</span></h5>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="row">
						<h5 class="col-sm-12">接待人：<span class="grey" style="line-height:26px;">${apply.receiveUserName }</span></h5>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="row">
						<h5 class="col-sm-12">接待日期：<span class="grey" style="line-height:26px;">
							<fmt:formatDate value="${apply.receiveDate }" pattern="yyyy-MM-dd" type="date"/>
						</span></h5>
					</div>
				</div>
				<div class="col-sm-12  col-xs-12">
					<div class="row">
						<h5 class="col-sm-12" style="line-height:26px;">不同意受理原因：<span class="grey">
							<c:choose>
								<c:when test="${empty apply.noAgreeDesc }">（空）</c:when>
								<c:otherwise>${apply.noAgreeDesc }</c:otherwise>
							</c:choose>
						</span></h5>
					</div>
				</div>
			</div>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					