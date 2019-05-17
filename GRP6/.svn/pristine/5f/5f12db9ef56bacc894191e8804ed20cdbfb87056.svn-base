<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<style>
	.subjectView:hover {text-decoration: none;}
</style>
<c:if test="${approvalStatus eq 0}">
    <div class="row">
        <c:forEach var="meeting" items="${meetings}" varStatus="status">
            <div class="col-xs-6 col-sm-4 pricing-box meeting" data-meeting-id="${meeting.meeting_ID}">
                <div class="widget-box">
                    <div class="widget-header">
                        <h5 class="bigger lighter">${meeting.meetingRoomName}</h5>
                    </div>

                    <div class="widget-body">
                        <div class="widget-main">
                            <ul class="list-unstyled spaced2" style="text-align:center;">
                                <li class="bigger-120">
                                    <fmt:formatDate pattern="YYYY年MM月dd日"
                                                    value="${meeting.meetingBeginDateTime}"/>
                                </li>

                                <li>
                                <span class="bigger-150"> <fmt:formatDate pattern="HH:mm"
                                                                          value="${meeting.meetingBeginDateTime}"/></span>&nbsp;-&nbsp;<span
                                        class="bigger-150"><fmt:formatDate pattern="HH:mm"
                                                                           value="${meeting.meetingEndDateTime}"/></span>
                                </li>

                            </ul>

                            <hr/>
                            <h4 style="text-align:center;"><a href="#" class="subjectView"> ${meeting.meetingName}</a></h4>
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
<c:if test="${approvalStatus eq 1}">
    <div class="row">
        <c:forEach var="meeting" items="${meetings}" varStatus="status">
            <div class="col-xs-6 col-sm-4 pricing-box meeting" data-meeting-id="${meeting.meeting_ID}">
                <div class="widget-box">
                    <div class="widget-header">
                        <h5 class="bigger lighter">${meeting.meetingRoomName}</h5>
                        <div class="widget-toolbar">
                            <span class="badge  <c:if test="${meeting.currentStatus eq 'running'}">badge-danger</c:if> <c:if test="${meeting.currentStatus eq 'waiting'}">badge-info</c:if> <c:if test="${meeting.currentStatus eq 'over'}"></c:if>">
                            <c:if test="${meeting.currentStatus eq 'running'}">进行中</c:if> <c:if
                                    test="${meeting.currentStatus eq 'waiting'}">未开始</c:if> <c:if
                                    test="${meeting.currentStatus eq 'over'}">已结束</c:if>
                            </span>

                        </div>
                    </div>

                    <div class="widget-body">
                        <div class="widget-main">
                            <ul class="list-unstyled spaced2" style="text-align:center;">
                                <li class="bigger-120">
                                    <fmt:formatDate pattern="YYYY年MM月dd日"
                                                    value="${meeting.meetingBeginDateTime}"/>
                                </li>

                                <li>
                                <span class="bigger-150"> <fmt:formatDate pattern="HH:mm"
                                                                          value="${meeting.meetingBeginDateTime}"/></span>&nbsp;-&nbsp;<span
                                        class="bigger-150"><fmt:formatDate pattern="HH:mm"
                                                                           value="${meeting.meetingEndDateTime}"/></span>
                                </li>

                            </ul>

                            <hr/>
                            <div class="price blue">
                                    <h4 style="text-align:center;"><a href="#" class="subjectView"> ${meeting.meetingName}</a></h4>
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
<c:if test="${approvalStatus eq 3}">
    <div class="row">
        <c:forEach var="meeting" items="${meetings}" varStatus="status">
            <div class="col-xs-6 col-sm-4 pricing-box meeting" data-meeting-id="${meeting.meeting_ID}">
                <div class="widget-box">
                    <div class="widget-header">
                        <h5 class="bigger lighter">${meeting.meetingRoomName}</h5>
                    </div>

                    <div class="widget-body">
                        <div class="widget-main">
                            <ul class="list-unstyled spaced2" style="text-align:center;">
                                <li class="bigger-120">
                                    <fmt:formatDate pattern="YYYY年MM月dd日"
                                                    value="${meeting.meetingBeginDateTime}"/>
                                </li>

                                <li>
                                <span class="bigger-150"> <fmt:formatDate pattern="HH:mm"
                                                                          value="${meeting.meetingBeginDateTime}"/></span>&nbsp;-&nbsp;<span
                                        class="bigger-150"><fmt:formatDate pattern="HH:mm"
                                                                           value="${meeting.meetingEndDateTime}"/></span>
                                </li>

                            </ul>

                            <hr/>
                            <div class="price blue">
                                    <h4 style="text-align:center;"><a href="#" class="subjectView"> ${meeting.meetingName}</a></h4>
                            </div>
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