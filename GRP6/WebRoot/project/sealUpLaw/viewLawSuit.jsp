<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="modal fade bs-example-modal-sm" id="viewLawSuitModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看项目诉讼</h4>
      </div>
      <div class="modal-body">
      	<div class="row">
					<div class="col-sm-offset-1 col-sm-10">
						<div class="col-sm-12">
							<div class="row">					
		
								<h5 class="col-sm-12" style="line-height: 26px;">	
								案号：
								<span class="grey">
										<c:choose><c:when test="${empty LawSuit.recordNum}">（空）</c:when>
								<c:otherwise>${LawSuit.recordNum}</c:otherwise>
							</c:choose>
									</span>
								</h5>
							</div>
						</div>
						
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
								原告：<span class="grey">
											<c:choose><c:when test="${empty LawSuit.plaintiff}">（空）</c:when>
								<c:otherwise>${LawSuit.plaintiff}</c:otherwise>
							</c:choose>
									</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									被告：<span class="grey">
											<c:choose><c:when test="${empty LawSuit.defendant}">（空）</c:when>
								<c:otherwise>${LawSuit.defendant}</c:otherwise>
							</c:choose>
									</span>
								</h5>
							</div>
						</div>
							<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									涉诉金额：<span class="grey">
											<c:choose><c:when test="${empty LawSuit.lawsuitSum}">（空）</c:when>
								<c:otherwise>${LawSuit.lawsuitSum}</c:otherwise>
							</c:choose>
									</span>元
								</h5>
							</div>
						</div>	
						
								<h5 class="col-sm-12" style="line-height: 26px;">
								起诉时间：<span class="grey">
											<c:choose><c:when test="${empty LawSuit.lawsuitDate}">（空）</c:when>
								<c:otherwise>	<fmt:formatDate value="${LawSuit.lawsuitDate}"
						pattern="yyyy-MM-dd" /></c:otherwise>
							</c:choose>
							</span>
								</h5>
						
						
						
								<h5 class="col-sm-12" style="line-height: 26px;">
								管辖法院：<span class="grey">
											<c:choose><c:when test="${empty LawSuit.lawCourt}">（空）</c:when>
								<c:otherwise>${LawSuit.lawCourt}</c:otherwise>
							</c:choose>
							</span>
								</h5>
						
					
						
								<h5 class="col-sm-12" style="line-height: 26px;">
									案件进展：<span class="grey">
											<c:choose><c:when test="${empty LawSuit.caseInfo}">（空）</c:when>
								<c:otherwise>${LawSuit.caseInfo}</c:otherwise>
							</c:choose>
							</span>
								</h5>
							
							
								<h5 class="col-sm-12" style="line-height: 26px;">
								财产保全情况：<span class="grey">
											<c:choose><c:when test="${empty LawSuit.propertyInfo}">（空）</c:when>
								<c:otherwise>${LawSuit.propertyInfo}</c:otherwise>
							</c:choose>
							</span>
								</h5>
					
							
							
					</div>
				</div>	

			</div>
			<div class="modal-footer">
			
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<i class='icon-remove bigger-110'></i>关闭
				</button>
			</div>
		</div>
	</div>
</div>
