<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="modal fade bs-example-modal-sm" id="viewdynamicModal"
	tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
	data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">查看项目动态</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-sm-offset-1 col-sm-10">
						<div class="col-sm-12">
							<div class="row">

								<h5 class="col-sm-12" style="line-height: 26px;">
									发布人： <span class="grey"> <c:choose>
											<c:when test="${empty dynamic.createUserName}">（空）</c:when>
											<c:otherwise>${dynamic.createUserName}</c:otherwise>
										</c:choose>
									</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									项目动态：<span class="grey"> <c:choose>
											<c:when test="${empty dynamic.dynamicContent}">（空）</c:when>
											<c:otherwise>${dynamic.dynamicContent}</c:otherwise>
										</c:choose>
									</span>
								</h5>
							</div>
						</div>

						<h5 class="col-sm-12" style="line-height: 26px;">
							发布时间：<span class="grey"> <c:choose>
									<c:when test="${empty dynamic.createDateTime}">（空）</c:when>
									<c:otherwise>
										<fmt:formatDate value="${dynamic.createDateTime}"
											pattern="yyyy-MM-dd" />
									</c:otherwise>
								</c:choose>
							</span>
						</h5>

					</div>
				</div>

			</div>
			<div class="modal-footer">					
				<c:if	test="${ dynamic.createUserName == sessionUser.user_name &&   minutes lt 2}">
						<button type="button" class="btn btn-default btn-info btn_Dynamic_del" id="bid" data-dismiss="modal">			
						<i class='icon-mail-reply bigger-110'></i>撤回</button>					
				</c:if> 	
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<i class='icon-remove bigger-110'></i>关闭
				</button>
			</div>
		</div>
<div id="ViewdynamicInfo_page"></div>

	</div>
</div>

