<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="modal fade" id="viewFactPay" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看代偿信息</h4>
      </div>
      <div class="modal-body">
			<div class="row">
				<div class="col-sm-offset-1 col-sm-10">
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">还款类型：<span class="grey" >
								<c:choose>
				                	<c:when test="${empty factPay.freeTypeName }">（空）</c:when>
				                	<c:otherwise>${factPay.freeTypeName }</c:otherwise>
				                </c:choose>
							</span></h5>
						</div>
					</div>
				</div>
				
				<div class="col-sm-offset-1 col-sm-10">
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">还款日期：<span class="grey" >
								<c:choose>
				                	<c:when test="${empty factPay.payDate }">（空）</c:when>
				                	<c:otherwise><fmt:formatDate pattern="yyyy-MM-dd" value="${factPay.payDate }"/></c:otherwise>
				                </c:choose>
							</span></h5>
						</div>
					</div>
				</div>
				
				<div class="col-sm-offset-1 col-sm-10">
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">还款金额：<span class="grey" >
							
							<c:choose>
			                	<c:when test="${empty factPay.paySum }">（空）</c:when>
			                	<c:otherwise><fmt:formatNumber value="${factPay.paySum }" pattern="###,###.######"/>万元</c:otherwise>
			                </c:choose>
							</span></h5>
						</div>
					</div>
				</div>
				
				<div class="col-sm-offset-1 col-sm-10">
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">还款本金：<span class="grey" >
							
							<c:choose>
			                	<c:when test="${empty factPay.payCapitalSum }">（空）</c:when>
			                	<c:otherwise><fmt:formatNumber value="${factPay.payCapitalSum }" pattern="###,###.######"/>万元</c:otherwise>
			                </c:choose>
							</span></h5>
						</div>
					</div>
				</div>
				
				<div class="col-sm-offset-1 col-sm-10">
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">还款利息：<span class="grey" >
							
							<c:choose>
			                	<c:when test="${empty factPay.payInterestSum }">（空）</c:when>
			                	<c:otherwise><fmt:formatNumber value="${factPay.payInterestSum }" pattern="###,###.######"/>万元</c:otherwise>
			                </c:choose>
							</span></h5>
						</div>
					</div>
				</div>
				
				
				<div class="col-sm-offset-1 col-sm-10">
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">备注：<span class="grey" >
								<c:choose>
				                	<c:when test="${empty factPay.remark }">（空）</c:when>
				                	<c:otherwise>${factPay.remark }</c:otherwise>
				                </c:choose>
							</span></h5>
						</div>
					</div>
				</div>
				
			</div>
      </div>
      <div class="modal-footer ">
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
					