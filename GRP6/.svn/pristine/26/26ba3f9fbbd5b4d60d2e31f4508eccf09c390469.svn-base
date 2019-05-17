<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="modal fade bs-example-modal-sm" id="viewCooperation" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">查看合作机构</h4>
      </div>
      <div class="modal-body">
		<div class="row">
		   <div class="col-sm-offset-1">
				<h5 class="col-sm-12">合作机构：<span class="grey ztb_view_busisortname">${CooperationInfo.banksortname}</span></h5>
				<h5 class="col-sm-12">责任比例：
					<span class="grey ztb_view_busisortname">
						<c:if test="${CooperationInfo.zrScale eq null}">（空）</c:if>
						<c:if test="${CooperationInfo.zrScale ne null}">
							${CooperationInfo.zrScale}%
						</c:if>
					</span>
				</h5>
				<h5 class="col-sm-12">保证金比例：
					<span class="grey ztb_view_busisortname">
						<c:if test="${CooperationInfo.bzScale eq null}">（空）</c:if>
						<c:if test="${CooperationInfo.bzScale ne null}">
							${CooperationInfo.bzScale}%
						</c:if>
					</span>
				</h5>
				<h5 class="col-sm-12">缴存方式：
					<span class="grey ztb_view_busisortname">
						${CooperationInfo.depositMethodID == null ||CooperationInfo.depositMethodID =='' ?'（空）':CooperationInfo.depositMethodID}
					</span>
				</h5>
				<h5 class="col-sm-12">授信额度：
					<span class="grey ztb_view_unificationid">
						<c:if test="${CooperationInfo.creditSum eq null }">（空）</c:if>
						<c:if test="${CooperationInfo.creditSum ne null }">
							<fmt:formatNumber value="${CooperationInfo.creditSum}" pattern="###,###.######"/> 万元
						</c:if>
						
					</span>
				</h5>
				<h5 class="col-sm-12">授信起始日期：
					<span class="grey ztb_view_isDefault" id="isDefault">
						<c:if test="${CooperationInfo.creditBeginDate eq null }">（空）</c:if>
						<c:if test="${CooperationInfo.creditBeginDate ne null }">
							<fmt:formatDate value="${CooperationInfo.creditBeginDate}" />	
						</c:if>
					</span>
				</h5>
				<h5 class="col-sm-12">授信到期日期：
					<span class="grey ztb_view_iseable" id="iseable">
						<c:if test="${CooperationInfo.creditEndDate eq null }">（空）</c:if>
						<c:if test="${CooperationInfo.creditEndDate ne null }">
							<fmt:formatDate value="${CooperationInfo.creditEndDate}" pattern="yyyy-MM-dd"/> 
						</c:if>
					</span>
				</h5>
				<h5 class="col-sm-12">信贷偏好：
					<span class="grey ztb_view_iseable" id="iseable">
						${CooperationInfo.creditRemark == null || CooperationInfo.creditRemark == ''?'（空）':CooperationInfo.creditRemark}
					</span>
				</h5>
				<h5 class="col-sm-12">营业地址：
					<span class="grey ztb_view_iseable" id="iseable">
						${CooperationInfo.busiAddress == null || CooperationInfo.busiAddress ==''?'（空）':CooperationInfo.busiAddress}
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
