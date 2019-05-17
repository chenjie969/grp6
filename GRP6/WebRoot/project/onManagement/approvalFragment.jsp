<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<style>
	.subjectView:hover {text-decoration: none;}
	.subjectView1:hover {text-decoration: none;}
</style>
<c:if test="${approvalStatus eq '01'}">
    <div class="row">
        <c:forEach var="meeting" items="${meetings}" varStatus="status">
            <div class="col-xs-6 col-sm-4 pricing-box meeting" data-meeting-id="${meeting.meeting_ID}" 
            data-meeting-proName="${meeting.proNames}">
                <div class="widget-box">
                    <div class="widget-header">
                        <h5 class="bigger lighter">评审会20170001<%-- ${meeting.meetingCode} --%></h5>
                    </div>

                    <div class="widget-body">
                        <div class="widget-main">
                            <ul class="list-unstyled spaced2" style="text-align:center;">
                                <li class="bigger-120">
                                   	 <fmt:formatDate pattern="yyyy年MM月dd日 HH:mm:ss"
                                                    value="${meeting.meetingDateTime}"/>
                                </li>
                            </ul>
                            <hr/>
                            <div class="price blue">
                                  <h4 style="text-align:center;"><a href="#" class="subjectView"> ${meeting.meetingRoomName}</a></h4>
                            </div>
                        </div>

                        <div style="height:44px;">
                            <a href="#" class="btn btn-success  col-sm-4 approve">
                                <i class="icon-ok-sign bigger-110"></i>
                                <span>通过</span>
                            </a>
                            
                            <a href="#" class="btn btn-default  col-sm-4 reject">
                                <i class="icon-share-alt bigger-110"></i>
                                <span>拒绝</span>
                            </a>
                            <!-- <a href="#" class="btn btn-danger  col-sm-3 delete">
                                <i class="icon-remove bigger-110"></i>
                                <span>删除</span>
                            </a> -->
                            <a href="#" class="btn btn-warning  col-sm-4 view">
                                <i class="icon-zoom-in bigger-110"></i>
                                <span>查看</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>

        </c:forEach>
    </div>
</c:if>
<c:if test="${approvalStatus eq '02'}">
    <div class="row">
        <c:forEach var="meeting" items="${meetings}" varStatus="status">
            <div class="col-xs-6 col-sm-4 pricing-box meeting" data-meeting-id="${meeting.meeting_ID}" 
            data-meeting-proName="${meeting.proNames}">
                <div class="widget-box">
                    <div class="widget-header">
                        <h5 class="bigger lighter">评审会20170001<%-- ${meeting.meetingCode} --%></h5>
                    </div>

                    <div class="widget-body">
                        <div class="widget-main">
                            <ul class="list-unstyled spaced2" style="text-align:center;">
                                <li class="bigger-120">
                                    	<fmt:formatDate pattern="yyyy年MM月dd日 HH:mm:ss"
                                                    value="${meeting.meetingDateTime}"/>
                                </li>

                            </ul>
							 <hr/>
                            <div class="price blue">
                                   <h4 style="text-align:center;"><a href="#" class="subjectView"> 
                                    	${meeting.meetingRoomName}
                                   </a></h4>
                            </div>
                            
                        </div>

                        <div style="height:44px;">
                            
                            <a href="#" class="btn btn-default  col-sm-6 reject">
                                <i class="icon-share-alt bigger-110"></i>
                                <span>拒绝</span>
                            </a>
                            <!-- <a href="#" class="btn btn-danger  col-sm-4 delete">
                                <i class="icon-remove bigger-110"></i>
                                <span>删除</span>
                            </a> -->
                            <a href="#" class="btn btn-warning  col-sm-6 view">
                                <i class="icon-zoom-in bigger-110"></i>
                                <span>查看</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>

        </c:forEach>
    </div>
</c:if>
<c:if test="${approvalStatus eq '03'}">
    <div class="row">
        <c:forEach var="meeting" items="${meetings}" varStatus="status">
            <div class="col-xs-6 col-sm-4 pricing-box meeting" data-meeting-id="${meeting.meeting_ID}" 
            data-meeting-proName="${meeting.proNames}">
                <div class="widget-box">
                    <div class="widget-header">
                        <h5 class="bigger lighter">评审会20170001<%-- ：${meeting.meetingCode} --%></h5>
                    </div>

                    <div class="widget-body">
                        <div class="widget-main">
                            <ul class="list-unstyled spaced2" style="text-align:center;">
                                <li class="bigger-120">
                                    	<fmt:formatDate pattern="yyyy年MM月dd日 HH:mm:ss"
                                                    value="${meeting.meetingDateTime}"/>
                                </li>

                            </ul>
							<hr/>
                            <div class="price blue">
                                   <h4 style="text-align:center;"><a href="#" class="subjectView"> 
                                    	${meeting.meetingRoomName}
                                   </a></h4>
                            </div>
                            <%-- <hr/>
                            <div class="price blue">
                                 <h4 style="text-align:center;">
                                  	<a href="#" id="subjectView1" class="subjectView1"> 
	                                  <c:if test="${fn:length(meeting.proNames) gt 10}">${fn:substring(meeting.proNames, 0, 10)}......</c:if>
	                                  <c:if test="${fn:length(meeting.proNames) le 10}">${meeting.proNames}</c:if>
									</a>
								</h4>
                            </div> --%>
                        </div>

                        <div style="height:44px;">
                        	<!-- <a href="#" class="btn btn-danger  col-sm-6 delete">
                                <i class="icon-remove bigger-110"></i>
                                <span>删除</span>
                            </a> -->
                            <a href="#" class="btn btn-warning col-sm-12 view">
                                <i class="icon-zoom-in bigger-110"></i>
                                <span>查看</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>

        </c:forEach>
    </div>
</c:if>
<c:if test="${empty meetings}">
    <div class="row">
        <h5 class="text-center">没有符合条件的记录</h5>
    </div>
</c:if>

<script type="text/javascript">
</script>
