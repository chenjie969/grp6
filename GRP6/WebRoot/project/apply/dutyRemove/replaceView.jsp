<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="modal fade" id="viewReplace" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
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
							<h5 class="col-sm-12" style="line-height:26px;">代偿日期：<span class="grey" >
								<c:choose>
				                	<c:when test="${empty replace.replaceDate }">（空）</c:when>
				                	<c:otherwise><fmt:formatDate pattern="yyyy-MM-dd" value="${replace.replaceDate }"/></c:otherwise>
				                </c:choose>
							</span></h5>
						</div>
					</div>
				</div>
				
				<div class="col-sm-offset-1 col-sm-10">
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">代偿金额：<span class="grey" >
							
							<c:choose>
			                	<c:when test="${empty replace.replaceSum }">（空）</c:when>
			                	<c:otherwise><fmt:formatNumber value="${replace.replaceSum }" pattern="###,###.######"/>万元</c:otherwise>
			                </c:choose>
							</span></h5>
						</div>
					</div>
				</div>
				
				<div class="col-sm-offset-1 col-sm-10">
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">代偿本金：<span class="grey" >
							
							<c:choose>
			                	<c:when test="${empty replace.replaceCapitalSum }">（空）</c:when>
			                	<c:otherwise><fmt:formatNumber value="${replace.replaceCapitalSum }" pattern="###,###.######"/>万元</c:otherwise>
			                </c:choose>
							</span></h5>
						</div>
					</div>
				</div>
				
				<div class="col-sm-offset-1 col-sm-10">
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">代偿利息：<span class="grey" >
							
							<c:choose>
			                	<c:when test="${empty replace.replaceInterestSum }">（空）</c:when>
			                	<c:otherwise><fmt:formatNumber value="${replace.replaceInterestSum }" pattern="###,###.######"/>万元</c:otherwise>
			                </c:choose>
							</span></h5>
						</div>
					</div>
				</div>
				
				<div class="col-sm-offset-1 col-sm-10">
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">代偿其它：<span class="grey" >
							
							<c:choose>
			                	<c:when test="${empty replace.replaceOtherSum }">（空）</c:when>
			                	<c:otherwise><fmt:formatNumber value="${replace.replaceOtherSum }" pattern="###,###.######"/>万元</c:otherwise>
			                </c:choose>
							</span></h5>
						</div>
					</div>
				</div>
				
				<div class="col-sm-offset-1 col-sm-10">
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">自有资金代偿：<span class="grey" >
							
							<c:choose>
			                	<c:when test="${empty replace.selfReplaceSum }">（空）</c:when>
			                	<c:otherwise><fmt:formatNumber value="${replace.selfReplaceSum }" pattern="###,###.######"/>万元</c:otherwise>
			                </c:choose>
							</span></h5>
						</div>
					</div>
				</div>
				<div class="col-sm-offset-1 col-sm-10">
					<div class="col-sm-12">
						<div class="row">
							<h5 class="col-sm-12" style="line-height:26px;">准备金冲抵：<span class="grey" >
							<c:choose>
			                	<c:when test="${empty replace.dangerReplaceSum }">（空）</c:when>
			                	<c:otherwise><fmt:formatNumber value="${replace.dangerReplaceSum }" pattern="###,###.######"/>万元</c:otherwise>
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
				                	<c:when test="${empty replace.remark }">（空）</c:when>
				                	<c:otherwise>${replace.remark }</c:otherwise>
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
					