<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade bs-example-modal-sm" id="transferModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static"
	data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">查看岗位变动</h4>
			</div>
			<div class="modal-body">
      	<div class="row">
					<div class="col-sm-offset-1 col-sm-10">
						<div class="col-sm-12">
							<div class="row">				
							
								<h5 class="col-sm-12" style="line-height: 26px;">
									调动原因：<span class="grey">
									<c:choose><c:when test="${empty hrstaffPosts.postsReason}">（空）</c:when>
								<c:otherwise>${hrstaffPosts.postsReason}</c:otherwise>
							</c:choose>	
									
									</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									变动前部门：<span class="grey">
										<c:choose><c:when test="${empty hrstaffPosts.agoPostsDepNmae}">（空）</c:when>
								<c:otherwise>${hrstaffPosts.agoPostsDepNmae}</c:otherwise>
							</c:choose>	
									
							</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									变动后部门：<span class="grey">
									
												<c:choose><c:when test="${empty hrstaffPosts.nowPostsDepName}">（空）</c:when>
								<c:otherwise>${hrstaffPosts.nowPostsDepName}</c:otherwise>
							</c:choose>	
									</span>
								</h5>
							</div>
						</div>
										
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									变动前职位：<span class="grey">
													<c:choose><c:when test="${empty hrstaffPosts.agoPosts}">（空）</c:when>
								<c:otherwise>${hrstaffPosts.agoPosts}</c:otherwise>
							</c:choose>	
								</span>
								</h5>
							</div>
						</div>
						
						
								<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									变动后职位：<span class="grey">
													<c:choose><c:when test="${empty hrstaffPosts.nowPosts}">（空）</c:when>
								<c:otherwise>${hrstaffPosts.nowPosts}</c:otherwise>
							</c:choose>	
							</span>
								</h5>
							</div>
						</div>	
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									变动前薪金：<span class="grey">
													<c:choose><c:when test="${empty hrstaffPosts.agoSalary}">（空）</c:when>
								<c:otherwise>${hrstaffPosts.agoSalary}</c:otherwise>
							</c:choose>	
									元</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									变动后薪金：<span class="grey">
									
													<c:choose><c:when test="${empty hrstaffPosts.nowSalary}">（空）</c:when>
								<c:otherwise>${hrstaffPosts.nowSalary}</c:otherwise>
							</c:choose>	
									元</span>
								</h5>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<h5 class="col-sm-12" style="line-height: 26px;">
									变动日期：<span class="grey"><fmt:formatDate value="${hrstaffPosts.changePostsDate}" pattern="yyyy-MM-dd"/></span>
								</h5>
							</div>
						</div>
						
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
