<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="modal fade bs-example-modal-sm" id="viewCoopBZJManager" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看合作机构保证金</h4>
      </div>
      <div class="modal-body">
		<div class="row">
		   <div class="col-sm-offset-1">
				<h5 class="col-sm-12">合作机构：<span class="grey">${bankSort.banksortname}</span></h5>
				<h5 class="col-sm-12">授信额度：
					<span class="grey">
						<c:if test="${bankSort.creditSum eq null }">（空）</c:if>
						<c:if test="${bankSort.creditSum ne null }">
							<fmt:formatNumber value="${bankSort.creditSum}" pattern="###,###.######"/> 万元
						</c:if>
					</span>
				</h5>
				<h5 class="col-sm-12">保证金比例：
					<span class="grey">
						<c:if test="${bankSort.bzScale eq null }">（空）</c:if>
						<c:if test="${bankSort.bzScale ne null }">
							<fmt:formatNumber value="${bankSort.bzScale}"/> %
						</c:if>
					</span>
				</h5>
				<h5 class="col-sm-12">应缴存保证金：
					<span class="grey">
						<c:if test="${bankSort.mustBzSum eq null }">（空）</c:if>
						<c:if test="${bankSort.mustBzSum ne null }">
							<fmt:formatNumber value="${bankSort.mustBzSum}" pattern="###,###.######"/> 万元
						</c:if>
					</span>
				</h5>
				<h5 class="col-sm-12">存出保证金：
					<span class="grey">
						<c:if test="${bankSort.factBzSum eq null }">（空）</c:if>
						<c:if test="${bankSort.factBzSum ne null }">
							<fmt:formatNumber value="${bankSort.factBzSum}" pattern="###,###.######"/> 万元
						</c:if>
					</span>
				</h5>
				<h5 class="col-sm-12">备注：
					<span class="grey">
						<c:if test="${empty bankSort.remark}">（空）</c:if>
						<c:if test="${not empty bankSort.remark}">
							${bankSort.remark}
						</c:if>
					</span>
				</h5>
			</div>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal"> <i class='icon-remove bigger-110'></i>关闭</button>
      </div>
    </div>
  </div>
</div>
