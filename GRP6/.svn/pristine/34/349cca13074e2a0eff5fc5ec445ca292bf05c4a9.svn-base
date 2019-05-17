<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script>
</script>
<div class="modal fade bs-example-modal-sm" id="creditConditionsDetail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看额度使用情况</h4>
      </div>
      <div class="modal-body">
		<div class="row">
		   <div class="col-sm-offset-1">
				<h5 class="col-sm-12">合作机构：<span class="grey ztb_view_banksortname">${creditInfo.banksortname}</span></h5>
				<h5 class="col-sm-12">授信额度：
					<span class="grey ztb_view_unificationid">
						<c:if test="${creditInfo.creditSum eq null}">（空）</c:if>
						<c:if test="${creditInfo.creditSum ne null}">
							<fmt:formatNumber value="${creditInfo.creditSum}" pattern="###,###.######"/> 万元
						</c:if>
					</span>
				</h5>
				<h5 class="col-sm-12">已用额度：
					<span class="grey ztb_view_unificationid">
						<c:if test="${creditInfo.usedSum eq null}">（空）</c:if>
						<c:if test="${creditInfo.usedSum ne null}">
							<fmt:formatNumber value="${creditInfo.usedSum}" pattern="###,###.######"/> 万元
						</c:if>
					</span>
				</h5>
				<h5 class="col-sm-12">可用余额：
					<span class="grey ztb_view_unificationid">
						<fmt:formatNumber value="${creditInfo.creditSum- creditInfo.usedSum}" pattern="###,###.######"/> 万元
					</span>
				</h5>
				<h5 class="col-sm-12">授信起始日期：
					<span class="grey ztb_view_isDefault">
						<c:if test="${creditInfo.creditBeginDate eq null}">（空）</c:if>
						<c:if test="${creditInfo.creditBeginDate ne null}">
							<fmt:formatDate value="${creditInfo.creditBeginDate}" pattern="yyyy-MM-dd"/>
						</c:if>
					</span>
				</h5>
				<h5 class="col-sm-12">授信到期日期：
					<span class="grey ztb_view_iseable" id="iseable">
						<c:if test="${creditInfo.creditEndDate eq null}">（空）</c:if>
						<c:if test="${creditInfo.creditEndDate ne null}">
							<fmt:formatDate value="${creditInfo.creditEndDate}" pattern="yyyy-MM-dd"/>
						</c:if>
					</span>
				</h5>
				<h5 class="col-sm-12">责任比例：
					<span class="grey ztb_view_iseable" id="iseable">
						<c:if test="${creditInfo.zrScale eq null}">（空）</c:if>
						<c:if test="${creditInfo.zrScale ne null}">
							${creditInfo.zrScale}%
						</c:if>
					</span>
				</h5>
				<h5 class="col-sm-12">保证金比例：
					<span class="grey ztb_view_iseable">
						<c:if test="${creditInfo.bzScale eq null}">（空）</c:if>
						<c:if test="${creditInfo.bzScale ne null}">
							${creditInfo.bzScale}%
						</c:if>
					</span>
				</h5>
				<h5 class="col-sm-12">缴存方式：
					<span class="grey ztb_view_iseable">
						${creditInfo.depositMethodID == null || creditInfo.depositMethodID ==''?'（空）':creditInfo.depositMethodID}
					</span>
				</h5>
				<h5 class="col-sm-12">信贷偏好：
					<span class="grey ztb_view_iseable">
						${creditInfo.creditRemark == null || creditInfo.creditRemark ==''?'（空）':creditInfo.creditRemark}
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
