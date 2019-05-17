<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 
	<c:choose>
		<c:when test="${empty pageTable.rows}">
			<div class="center">
				没有找到匹配的记录
			</div>
		</c:when>
		<c:otherwise>
			<c:forEach items="${pageTable.rows}" var="mettingArrange">
				<div class="col-sm-4 pricing-box">
					<div class="widget-box">
						<div class="widget-header">
							<h5 class="bigger lighter">${mettingArrange.meetingCode}</h5>
							<div class="widget-toolbar" style="height:37px;">
								<c:choose>
									<c:when test="${mettingArrange.meetingStatus eq'01'}">
										<span class="badge badge-info" style="margin-top:10px;">未上会</span>
									</c:when>
									<c:when test="${mettingArrange.meetingStatus eq'02'}">
										<span class="badge" style="margin-top:10px;">已上会</span>
									</c:when>
								</c:choose>
							</div>
						</div>
						<div class="widget-body">
							<div class="widget-main">
								<ul class="list-unstyled spaced2" style="text-align:center;">
									<li class="bigger-120">上会时间：<fmt:formatDate value="${mettingArrange.meetingDateTime}" type="date" dateStyle="medium"/></li>
									<li class="bigger-120">会议室：${mettingArrange.meetingRoomName} </li>
								</ul>
								<hr>
								<div class="price blue">项目数量：<a href="javascript:void(0)" class="btn_view btn_vote" data-meetingID="${mettingArrange.meeting_ID}">${mettingArrange.applyNum}</a></div>
							</div>
							<div style="height:44px;">
								<c:choose>
									<c:when test="${isVote=='true'}">
										<button class="btn btn-warning width-100 pull-left btn_view" data-meetingID="${mettingArrange.meeting_ID}"><i class="icon-zoom-in bigger-120"></i>查看</button>
									</c:when>
									<c:when test="${isVote=='false'}">
										<%-- <button class="btn btn-warning width-50 pull-left btn_view" data-meetingID="${mettingArrange.meeting_ID}"><i class="icon-zoom-in bigger-120"></i>查看</button> --%>
										<button class="btn btn-info width-100 pull-left btn_vote" data-meetingID="${mettingArrange.meeting_ID}"><i class="icon-pencil bigger-120"></i>项目表决</button>
									</c:when>
								</c:choose>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
					
			<input type="hidden" id="total" value="${pageTable.total }">
			<div id="pageDiv" class="col-sm-12 center"></div>
	
			<!-- 页码 -->
			<%-- <div class="col-sm-12 center">
				<input type="hidden" id="pageTotal" value="${pageTable.total }">
				<c:set var="tmp" value="${pageTable.total/pageTable.pageSize }"></c:set>
				<c:set var="pageMax" value="${tmp+(1-(tmp%1))%1}"></c:set>	<!-- 向上取整 -->
				<ul class="pagination">	
				    <li id="btn_prevPage" title="上一页" <c:if test="${pageTable.pageNumber==0 }">class="disabled"</c:if>><a href="javascript:void(0)">&laquo;</a></li>
				    <c:forEach begin="1" end="${pageMax }" varStatus="pageIndex">
				    	  <li class="pageNumber <c:if test="${pageTable.pageNumber/pageTable.pageSize+1 == pageIndex.index }">active</c:if>"><a href="javascript:void(0)">${pageIndex.index }</a></li>
				    </c:forEach>
				    <li id="btn_nextPage" title="下一页" <c:if test="${pageTable.pageNumber+pageTable.pageSize>=pageTable.total }">class="disabled"</c:if>><a href="javascript:void(0)">&raquo;</a></li>
				</ul>
				<span class="col-sm-12">
					显示第 ${pageTable.pageNumber+1 }到第 ${pageTable.pageNumber+pageTable.pageSize>pageTable.total?pageTable.total:pageTable.pageNumber+pageTable.pageSize } 条记录，总共 ${pageTable.total } 条记录
				</span>
			</div> --%>
		</c:otherwise>
	</c:choose>
	
	
	<!--bootStrap分页插件 http://www.cnblogs.com/evilliu/articles/6393336.html -->
